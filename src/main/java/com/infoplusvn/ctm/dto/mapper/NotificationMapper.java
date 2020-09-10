package com.infoplusvn.ctm.dto.mapper;

import com.infoplusvn.ctm.dto.NotificationDto;
import com.infoplusvn.ctm.entity.Notification;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface NotificationMapper {
    NotificationMapper NOTIFICATION_MAPPER = Mappers.getMapper(NotificationMapper.class);

    Notification dtoToEntity(NotificationDto notificationDto);
}
