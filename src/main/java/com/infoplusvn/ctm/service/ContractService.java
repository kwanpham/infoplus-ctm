package com.infoplusvn.ctm.service;

import com.infoplusvn.ctm.dto.ContractDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContractService {

    void createNewContract(ContractDto contractDto);

    void updateContract(ContractDto contractDto);

    List<ContractDto> getAllContract();

    Page<ContractDto> findByPageable(Pageable pageable);

}
