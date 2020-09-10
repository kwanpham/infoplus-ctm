package com.infoplusvn.ctm;

import com.infoplusvn.ctm.controller.v1.api.request.ContractDetailRequest;
import com.infoplusvn.ctm.dto.ContractDetailDto;
import com.infoplusvn.ctm.entity.Contract;
import com.infoplusvn.ctm.entity.ContractDetail;
import com.infoplusvn.ctm.exception.LogicException;
import com.infoplusvn.ctm.exception.ResourceNotFoundException;
import com.infoplusvn.ctm.repo.ContractDetailRepo;
import com.infoplusvn.ctm.service.ContractDetailService;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;

/**
 * Created by https://github.com/kwanpham
 */

@SpringBootTest
public class TestService {

    @Autowired
    ContractDetailRepo contractDetailService;

    @Autowired
    ContractDetailService contractDetailService1;

    @Test
    public void testAddNewContract() {
        ContractDetail cd = new ContractDetail();
        cd.setCompanyName("NH BANK");
        cd.setRecordSts(1);
        cd.setVersion(1);
        cd.setContractDt(new Timestamp(System.currentTimeMillis()));
        cd.setContractAmount("5000000");
        cd.setContractTerm("term");
        cd.setPaymentDt(new Timestamp(System.currentTimeMillis()));
        cd.setPaymentInvoiceDt(new Timestamp(System.currentTimeMillis()));
        cd.setPaymentRatio("50%");
        cd.setPaymentRemain("500000");
        cd.setPaymentValue("600000");

        Contract contract = new Contract();
        contract.setId(1L);
        cd.setContract(contract);


        //cd.setRootContractDetail(cd);

        cd = contractDetailService.save(cd);


    }

    @Test
    public void testAddNewContractVersion() throws ResourceNotFoundException, LogicException {
        ContractDetailDto cd = new ContractDetailDto();
        cd.setCompanyName("NH BANK");
        cd.setContractAmount("5000000");
        cd.setContractTerm("term");
        cd.setPaymentRatio("50%");
        cd.setPaymentRemain("500000");
        cd.setPaymentValue("600000");
        cd.setPaymentDt(new Timestamp(System.currentTimeMillis()).toString());
        cd.setPaymentInvoiceDt(new Timestamp(System.currentTimeMillis()).toString());
        cd.setContractDt(new Timestamp(System.currentTimeMillis()).toString());
        cd.setContractId(1L);
        cd.setRootId(4L);
        cd.setPreviousId(4L);
        cd.setType("1");
        cd.setChangedContent("Change field ?");


        contractDetailService1.createNewContractDetailVersion(cd);

    }



}
