package com.infoplusvn.ctm.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by https://github.com/kwanpham
 */

@Data
@Entity
@Table(name = "ip_notification")
public class Notification extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "notify_day")
    private String notifyDay;

    @Column(name = "is_repeated")
    private boolean isRepeated;

    @Column(name = "notify_time")
    private String notifyTime;

    @Column(name = "notify_by")
    private String notifyBy;

    @Column(name = "send_to")
    private String sendTo;

    @Column(name = "is_default")
    private boolean isDefault;

    @Column(name = "record_sts")
    private Integer recordSts;

    @CreatedBy
    @Column(name = "created_by")
    private String createdBy;

    @CreatedDate
    @Column(name = "created_dt")
    private Timestamp createdDt;

    @LastModifiedBy
    @Column(name = "modify_by")
    private String modifyBy;

    @LastModifiedDate
    @Column(name = "modify_dt")
    private Timestamp modifyDt;


}
