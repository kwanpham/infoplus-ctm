package com.infoplusvn.ctm.repo;

import com.infoplusvn.ctm.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

@Transactional
public interface NotificationRepo extends JpaRepository<Notification, Long> {
    @Modifying
    @Query("update Notification n set n.recordSts = 0, n.modifyBy = ?1, n.modifyDt = ?2 where n.recordSts = 1")
    void closeAll(String modifyBy, Timestamp modifyDate);

    @Query("select n from Notification n where n.recordSts = 1")
    Notification getNotifySettings();

    @Modifying
    @Query("update Notification n set n.recordSts = 1 where n.isDefault = 1")
    void resetSettingToDefault();
}
