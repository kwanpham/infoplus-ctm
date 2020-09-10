package com.infoplusvn.ctm.controller.v1.api.request;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class NotificationRequest {

    private String notifyDay;

    private String notifyBy;

    private String notifyTime;

    private String sendTo;

    private Boolean isRepeat;
}
