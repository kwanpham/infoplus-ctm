package com.infoplusvn.ctm.controller.v1.api.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by https://github.com/kwanpham
 */
@Data
public class ContractDetailRequest {

    private Long id;


    @ApiModelProperty(example = "S" ,  name = "Type" , required = true)
    private String type;


    @ApiModelProperty(example = "NH BANK" ,  name = "companyName" )
    private String companyName;

    @ApiModelProperty(example = "1" ,  name = "contractId" )
    private Long contractId;


    @ApiModelProperty(example = "2019-11-18 10:47:55" ,  name = "contractId" )
    private String contractDt;


    @ApiModelProperty(example = "50000" ,  name = "contractId" )
    private String contractAmount;

    @ApiModelProperty(example = "Term" ,  name = "contractId" )
    private String contractTerm;

    @ApiModelProperty(example = "600000" ,  name = "paymentRatio" )
    private String paymentRatio;


    @ApiModelProperty(example = "2019-11-18 10:47:55" ,  name = "paymentDt" )
    private String paymentDt;

    @ApiModelProperty(example = "700000" ,  name = "paymentValue" )
    private String paymentValue;

    @ApiModelProperty(example = "300000" ,  name = "paymentRemain" )
    private String paymentRemain;


    @ApiModelProperty(example = "2019-11-18 10:47:55" ,  name = "paymentInvoiceDt" )
    private String paymentInvoiceDt;

    @ApiModelProperty(example = "changed hello" ,  name = "changedContent" )
    private String changedContent;



}
