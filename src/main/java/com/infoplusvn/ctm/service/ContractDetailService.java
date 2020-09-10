package com.infoplusvn.ctm.service;

import com.infoplusvn.ctm.dto.ContractDetailDto;
import com.infoplusvn.ctm.exception.LogicException;
import com.infoplusvn.ctm.exception.ResourceNotFoundException;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;

public interface ContractDetailService {


    List<ContractDetailDto> getAllUpcomingPurchase(Pageable pageable);

    List<ContractDetailDto> getAllUpcomingSale(Pageable pageable);

    Set<ContractDetailDto> getAllVersion(Long rootId) throws ResourceNotFoundException;

    void createNewContractDetail(ContractDetailDto cdd) throws ResourceNotFoundException;

    void createNewContractDetailVersion(ContractDetailDto cdd) throws ResourceNotFoundException, LogicException;

    List<ContractDetailDto> getUpCommingContract(String type);

    void removeContractDetail(Long id) throws ResourceNotFoundException, LogicException;

    void revertContractDetail(long currentId , long revertId) throws LogicException, ResourceNotFoundException;






}
