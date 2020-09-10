package com.infoplusvn.ctm.dto;

import com.infoplusvn.ctm.entity.Contract;
import com.infoplusvn.ctm.entity.ContractDetail;
import lombok.Data;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Data
public class ContractDetailDto {


    private Long id;

    private int version;

    private Long previousId;

    private Long rootId;

    private Integer recordSts;

    private String type;

    private String companyName;


    private Long contractId;


    private String contractDt;


    private String contractAmount;


    private String contractTerm;


    private String paymentRatio;


    private String paymentDt;


    private String paymentValue;


    private String paymentRemain;


    private String paymentInvoiceDt;


    private String changedContent;

    private String createdDt;

    private String modifiedDt;


}
