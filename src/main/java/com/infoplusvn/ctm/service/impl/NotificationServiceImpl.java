package com.infoplusvn.ctm.service.impl;

import com.infoplusvn.ctm.constant.SystemConstant;
import com.infoplusvn.ctm.dto.NotificationDto;
import com.infoplusvn.ctm.dto.mapper.NotificationMapper;
import com.infoplusvn.ctm.entity.Notification;
import com.infoplusvn.ctm.repo.NotificationRepo;
import com.infoplusvn.ctm.service.NotificationService;
import com.infoplusvn.ctm.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationMapper notificationMapper;
    @Autowired
    private NotificationRepo notificationRepo;

    @Override
    public String createNew(NotificationDto notificationDto) {
        try {
            Notification notification = notificationMapper.dtoToEntity(notificationDto);
            notificationRepo.closeAll("admin", new Timestamp(new Date().getTime()));
            notificationRepo.save(notification);
            return SystemConstant.SUCCESS_CODE;
        } catch (Exception ex) {
            System.out.println("Error: " + ex.toString());
            return SystemConstant.SQL_ERROR_CODE;
        }
    }

    @Override
    public Notification selectCurrentNotification() {
        return notificationRepo.getNotifySettings();
    }

    @Override
    public String resetNotification() {
        try {
            notificationRepo.closeAll("thai2123123", new Timestamp(new Date().getTime()));
            notificationRepo.resetSettingToDefault();
            return SystemConstant.SUCCESS_CODE;
        }
        catch (Exception ex) {
            System.out.println("Error: " + ex.toString());
            return SystemConstant.SQL_ERROR_CODE;
        }
    }
}
