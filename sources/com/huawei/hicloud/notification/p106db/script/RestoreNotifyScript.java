package com.huawei.hicloud.notification.p106db.script;

/* loaded from: classes6.dex */
public class RestoreNotifyScript {
    public static final String CLEAR = "delete from restore_notify";
    public static final String GET_COUNT = "select count(*) from restore_notify;";
    public static final String SQL_GET_RESTORE_NOTIFY_CONFIG = "select id,hoursafteroobe,timesinhours,firsttrigafter,starttime,endTime,loginstate,noticetype,priority from restore_notify where loginstate = ?;";
    public static final String SQL_RESTORE_NOTIFY_INSERT = "insert into restore_notify values(?, ?, ?, ?, ?, ?, ?, ?, ?);";
}
