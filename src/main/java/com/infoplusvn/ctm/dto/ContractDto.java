package com.infoplusvn.ctm.dto;

import com.infoplusvn.ctm.entity.ContractDetail;
import com.infoplusvn.ctm.entity.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
public class ContractDto {

    private Long id;

    private String name;

    private String createdBy;

    private String createdDt;

   // private List<ContractDetail> contractDetailList = new ArrayList<>();

}
