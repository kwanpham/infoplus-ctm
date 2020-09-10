package com.infoplusvn.ctm.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.Temporal;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "ip_contract_detail")
@EntityListeners(AuditingEntityListener.class)
public class ContractDetail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="root_id")
    private ContractDetail rootContractDetail;

    @OneToMany(mappedBy="rootContractDetail" , fetch = FetchType.LAZY)
    private Set<ContractDetail> subContractDetailList = new HashSet<>();

    @Column(name = "version" , nullable = false)
    private int version;

    @Column(name = "record_sts" , nullable = false)
    private int recordSts;

    @ManyToOne
    @JoinColumn(name = "contract_id" , nullable = false)
    private Contract contract;

//    @OneToOne
//    @JoinColumn(name = "previous_id")
//    private ContractDetail previousContractDetail;

    @Column(name = "type")
    private String type;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "contract_dt")
    private Timestamp contractDt;

    @Column(name = "contract_amount")
    private String contractAmount;

    @Column(name = "contract_term")
    private String contractTerm;

    @Column(name = "payment_ratio")
    private String paymentRatio;

    @Column(name = "payment_dt")
    private Timestamp paymentDt;

    @Column(name = "payment_value")
    private String paymentValue;

    @Column(name = "payment_remain")
    private String paymentRemain;

    @Column(name = "payment_invoice_dt")
    private Timestamp paymentInvoiceDt;

    @Column(name = "changed_content")
    private String changedContent;

    @CreatedBy
    @Column(name = "created_by" , updatable = false)
    private String createdBy;

    @CreatedDate
    @Column(name = "created_dt" , updatable = false)
    private Timestamp createdDt;

    @LastModifiedBy
    @Column(name = "modified_by")
    private String modifiedBy;

    @LastModifiedDate
    @Column(name = "modified_dt")
    private Timestamp modifiedDt;



}
