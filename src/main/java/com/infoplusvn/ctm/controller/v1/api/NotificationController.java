package com.infoplusvn.ctm.controller.v1.api;

import com.infoplusvn.ctm.controller.v1.api.request.NotificationRequest;
import com.infoplusvn.ctm.dto.NotificationDto;
import com.infoplusvn.ctm.service.NotificationService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ctm")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @ApiOperation(value = "Add new notification setting" ,  authorizations = {@Authorization(value = "apiKey")})
    @PostMapping("/v1.0.0/add_notification_setting")
    public ResponseEntity addNotification(@RequestBody NotificationRequest notificationRequest) {
        return  ResponseEntity.ok(createNotificationSetting(notificationRequest));
    }

    private String createNotificationSetting(NotificationRequest notificationRequest) {
        NotificationDto notificationDto = new NotificationDto()
                .setNotifyDay(notificationRequest.getNotifyDay())
                .setNotifyBy(notificationRequest.getNotifyBy())
                .setNotifyTime(notificationRequest.getNotifyTime())
                .setSendTo(notificationRequest.getSendTo())
                .setRepeated(notificationRequest.getIsRepeat())
                .setRecordSts(1);

        return notificationService.createNew(notificationDto);
    }

    @ApiOperation(value = "Get notification setting" ,  authorizations = {@Authorization(value = "apiKey")})
    @GetMapping("/v1.0.0/get_notification_setting")
    public ResponseEntity selectCurrentNotification() {
        return  ResponseEntity.ok(notificationService.selectCurrentNotification());
    }

    @ApiOperation(value = "Reset notification setting" ,  authorizations = {@Authorization(value = "apiKey")})
    @PostMapping("/v1.0.0/reset_notification_setting")
    public ResponseEntity resetNotification() {
        return  ResponseEntity.ok(notificationService.resetNotification());
    }

}
