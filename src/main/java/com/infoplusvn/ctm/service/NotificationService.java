package com.infoplusvn.ctm.service;

import com.infoplusvn.ctm.dto.NotificationDto;
import com.infoplusvn.ctm.entity.Notification;

public interface NotificationService {
    String createNew(NotificationDto notificationDto);

    Notification selectCurrentNotification();

    String resetNotification();
}
