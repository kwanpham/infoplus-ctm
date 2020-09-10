package com.infoplusvn.ctm.repo;

import com.infoplusvn.ctm.entity.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface ContractDetailRepo extends JpaRepository<ContractDetail, Long> {

    Page<ContractDetail> findAll(Pageable pageable);

    List<ContractDetail> findAll();

    Optional<ContractDetail> findById(Long id);

    Optional<ContractDetail> findByRootContractDetailAndRecordSts(ContractDetail rootContractDetail , int recordSts);

    Optional<ContractDetail> findByRootContractDetailAndVersion(ContractDetail rootContractDetail , int version);

    @Query("select c from ContractDetail c where c.recordSts = '1' order by c.paymentDt asc ")
    List<ContractDetail> findUpcommingSale(Pageable pageable);


    @Query("select c from ContractDetail c where c.recordSts = '1' order by c.paymentInvoiceDt asc ")
    List<ContractDetail> findUpcommingPurchase(Pageable pageable);

    @Query("select c from ContractDetail c where c.paymentDt between ?1 and ?2 and c.type = ?3 and c.recordSts = ?4")
    List<ContractDetail> findUpcommingContractDetail(Timestamp date1 , Timestamp date2 , String type ,int recordSts , Pageable pageable);


}
