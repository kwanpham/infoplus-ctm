package com.infoplusvn.ctm.service.impl;

import com.infoplusvn.ctm.constant.SystemConstant;
import com.infoplusvn.ctm.dto.ContractDetailDto;
import com.infoplusvn.ctm.dto.mapper.ContractDetailMapper;
import com.infoplusvn.ctm.entity.Contract;
import com.infoplusvn.ctm.entity.ContractDetail;
import com.infoplusvn.ctm.exception.LogicException;
import com.infoplusvn.ctm.exception.ResourceNotFoundException;
import com.infoplusvn.ctm.repo.ContractDetailRepo;
import com.infoplusvn.ctm.repo.ContractRepo;
import com.infoplusvn.ctm.service.ContractDetailService;
import com.infoplusvn.ctm.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class ContractDetailServiceImpl implements ContractDetailService {

    @Autowired
    private ContractDetailRepo cdr;

    @Autowired
    private ContractDetailMapper cdm;

    @Autowired
    private ContractRepo contractRepo;


    @Deprecated
    @Override
    public List<ContractDetailDto> getAllUpcomingPurchase(Pageable pageable) {
        return cdr.findUpcommingPurchase(pageable)
                .stream()
                .map(contractDetail -> cdm.entityToDto(contractDetail))
                .collect(Collectors.toList());
    }

    @Deprecated
    @Override
    public List<ContractDetailDto> getAllUpcomingSale(Pageable pageable) {
        return cdr.findUpcommingSale(pageable)
                .stream()
                .map(contractDetail -> cdm.entityToDto(contractDetail))
                .collect(Collectors.toList());
    }

    @Override
    public Set<ContractDetailDto> getAllVersion(Long id) throws ResourceNotFoundException {
        Optional<ContractDetail> contractDetail = cdr.findById(id);
        if (contractDetail.isPresent()) {

            return contractDetail.get()
                    .getRootContractDetail()
                    .getSubContractDetailList()
                    .stream()
                    .map(contractDetail1 -> cdm.entityToDto(contractDetail1))
                    .collect(Collectors.toSet());
        }
        throw new ResourceNotFoundException("Cant not find contract detail with id = " + id);
    }

    @Transactional
    @Override
    public void createNewContractDetail(ContractDetailDto cdd) throws ResourceNotFoundException {
        Optional<Contract> contractOptional = contractRepo.findById(cdd.getContractId());
        if (contractOptional.isPresent()) {
            ContractDetail contractDetail = cdm.dtoToEntity(cdd);
            contractDetail.setContract(contractOptional.get());
            contractDetail.setVersion(1);
            contractDetail.setChangedContent("");
            contractDetail.setRecordSts(1);
            contractDetail.setRootContractDetail(null);
            cdr.save(contractDetail);
        } else {
            throw new ResourceNotFoundException("Cant not find Contract with id = " + cdd.getContractId());
        }
    }


    @Transactional
    @Override
    public void createNewContractDetailVersion(ContractDetailDto cdd) throws ResourceNotFoundException, LogicException {

        //check logic pre contract detail , if user type a contract detail preversion , it will thorw logic exception

        Optional<ContractDetail> preVersionOptional1 = cdr.findById(cdd.getId());

        if (!preVersionOptional1.isPresent()) {
            throw new ResourceNotFoundException("Can't find ContractDetail with  id = " + cdd.getId());
        }

        ContractDetail preVersion1 = preVersionOptional1.get();

        if (preVersion1.getVersion() == 1 && preVersion1.getSubContractDetailList().size() == 0) {
            preVersion1.setRecordSts(0);
            preVersion1 = cdr.saveAndFlush(preVersion1);

            ContractDetail newVersion = cdm.dtoToEntity(cdd);

            Contract contract = new Contract();
            contract.setId(cdd.getContractId());

            newVersion.setContract(contract);

            newVersion.setRootContractDetail(preVersion1);

            newVersion.setId(null);
            newVersion.setRecordSts(1);
            newVersion.setVersion(preVersion1.getVersion() + 1);
            cdr.saveAndFlush(newVersion);
            return;

        }

        if (preVersion1.getVersion() == 1 && preVersion1.getSubContractDetailList().size() > 0) {
            throw new LogicException("Contract Detail id have problem");
        }

        Optional<ContractDetail> preVersionOptional2 = cdr.findByRootContractDetailAndRecordSts(preVersion1.getRootContractDetail(), 1);

        if (!preVersionOptional2.isPresent()) {
            throw new ResourceNotFoundException("Can't find ContractDetail with root id = " + preVersion1.getRootContractDetail().getId());
        }


        ContractDetail preVersion2 = preVersionOptional2.get();


        if (preVersion1.equals(preVersion2)) {

            preVersion1.setRecordSts(0);
            preVersion1 = cdr.saveAndFlush(preVersion1);

            ContractDetail newVersion = cdm.dtoToEntity(cdd);

            Contract contract = new Contract();
            contract.setId(cdd.getContractId());

            newVersion.setContract(contract);

            newVersion.setRootContractDetail(preVersion1.getRootContractDetail());

            newVersion.setId(null);
            newVersion.setRecordSts(1);
            newVersion.setVersion(preVersion1.getVersion() + 1);
            cdr.saveAndFlush(newVersion);

        } else {

            throw new LogicException("Contract Detail id have problem");

        }
    }

    @Override
    public List<ContractDetailDto> getUpCommingContract(String type) {
        Date dt = new Date();

        Timestamp t1 = new Timestamp(dt.getTime());

        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, 3);
        dt = c.getTime();

        Timestamp t2 = new Timestamp(dt.getTime());

        List<ContractDetail> result = cdr.findUpcommingContractDetail(t1, t2, type, 1, null);

        return cdm.entitiesToDtos(result);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void removeContractDetail(Long id) throws ResourceNotFoundException, LogicException {
        Optional<ContractDetail> contractDetailOptional = cdr.findById(id);

        if (!contractDetailOptional.isPresent())
            throw new ResourceNotFoundException("Could not find contract detail id = " + id);

        ContractDetail currentContractDetail = contractDetailOptional.get();

        if (currentContractDetail.getVersion() == 1) {
            cdr.delete(currentContractDetail);
            return;

        }

        Optional<ContractDetail> contractDetailOptiona1 = cdr.findByRootContractDetailAndRecordSts(currentContractDetail.getRootContractDetail(), 1);

        if (!contractDetailOptiona1.isPresent()) {
            throw new ResourceNotFoundException("Can't find ContractDetail with root id = " + currentContractDetail.getRootContractDetail().getId());
        }

        ContractDetail currentContractDetail2 = contractDetailOptiona1.get();

        if (!currentContractDetail.equals(currentContractDetail2)) {
            throw new LogicException("Contract Detail id have problem");
        }

        cdr.delete(currentContractDetail);


        Optional<ContractDetail> contractDetailOptiona2;
        if (currentContractDetail.getVersion() == 2) {
            contractDetailOptiona2 = cdr
                    .findById(currentContractDetail.getRootContractDetail().getId());
        } else {
            contractDetailOptiona2 = cdr
                    .findByRootContractDetailAndVersion(currentContractDetail.getRootContractDetail(), currentContractDetail.getVersion() - 1);
        }


        if (!contractDetailOptiona2.isPresent())
            throw new ResourceNotFoundException("Could not find contract detail root id = "
                    + currentContractDetail.getRootContractDetail().getId() +
                    " and version = " + (currentContractDetail.getVersion() - 1));

        ContractDetail preContractDetail = contractDetailOptiona2.get();

        preContractDetail.setRecordSts(1);
        cdr.save(preContractDetail);
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public void revertContractDetail(long currentId, long revertId) throws LogicException, ResourceNotFoundException {
        if (currentId == revertId)
            throw new LogicException("currentId and revertId can not be same ");

        Optional<ContractDetail> currentContractDetailOptional = cdr.findById(currentId);

        if (!currentContractDetailOptional.isPresent())
            throw new ResourceNotFoundException("Could not find contract id = " + currentId);

        Optional<ContractDetail> revertContractDetailOptional = cdr.findById(revertId);

        if (!revertContractDetailOptional.isPresent())
            throw new ResourceNotFoundException("Could not find contract id = " + revertId);

        ContractDetail currentContractDetail = currentContractDetailOptional.get();
        ContractDetail revertContractDetail = revertContractDetailOptional.get();

        if (currentContractDetail.getRootContractDetail().getId() != revertContractDetail.getRootContractDetail().getId()) {
            throw new LogicException("Root id is diffrent");
        }

        currentContractDetail.setRecordSts(0);
        revertContractDetail.setRecordSts(1);

        cdr.save(currentContractDetail);
        cdr.save(revertContractDetail);


    }


}

