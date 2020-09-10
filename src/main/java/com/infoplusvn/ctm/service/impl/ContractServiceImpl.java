package com.infoplusvn.ctm.service.impl;

import com.infoplusvn.ctm.dto.ContractDto;
import com.infoplusvn.ctm.dto.mapper.ContractMapper;
import com.infoplusvn.ctm.repo.ContractRepo;
import com.infoplusvn.ctm.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractRepo contractRepo;

    @Autowired
    private ContractMapper contractMapper;

    @Override
    public void createNewContract(ContractDto contractDto) {
        contractRepo.saveAndFlush(contractMapper.dtoToEntity(contractDto));
    }

    @Override
    public void updateContract(ContractDto contractDto) {
        contractRepo.saveAndFlush(contractMapper.dtoToEntity(contractDto));
    }

    @Override
    public List<ContractDto> getAllContract() {
        return contractMapper.entitiesToDtos(contractRepo.findAll());
    }

    @Override
    public Page<ContractDto> findByPageable(Pageable pageable) {
        return contractRepo.findAll(pageable)
                .map(contract -> contractMapper.entityToDto(contract));

    }
}
