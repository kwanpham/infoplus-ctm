package com.infoplusvn.ctm.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class NotificationDto {
    private Integer id;

    private String notifyDay;

    private String notifyTime;

    private String notifyBy;

    private boolean isRepeated;

    private String sendTo;

    private Integer recordSts;

}
