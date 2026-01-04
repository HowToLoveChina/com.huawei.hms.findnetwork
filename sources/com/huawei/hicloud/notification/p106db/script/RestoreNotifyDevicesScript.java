package com.huawei.hicloud.notification.p106db.script;

/* loaded from: classes6.dex */
public class RestoreNotifyDevicesScript {
    public static final String CLEAR = "delete from restore_notify_devices";
    public static final String GET_COUNT = "select count(*) from restore_notify_devices;";
    public static final String SQL_GET_RELEASE_DEVICES = "select releasedevice from restore_notify_devices where loginstate =?;";
    public static final String SQL_RESTORE_NOTIFY_DEVICES_INSERT = "insert into restore_notify_devices values(?, ?, ?);";
}
