package com.infoplusvn.ctm.repo;

import com.infoplusvn.ctm.entity.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepo extends JpaRepository<Contract, Long> {

    Page<Contract> findAll(Pageable pageable);


}
