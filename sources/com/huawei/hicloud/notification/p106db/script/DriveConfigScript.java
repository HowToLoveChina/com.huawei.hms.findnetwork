package com.huawei.hicloud.notification.p106db.script;

/* loaded from: classes6.dex */
public class DriveConfigScript {
    public static final String CLEAR = "delete from drive_config";
    public static final String GET_COUNT = "select count(*) from drive_config;";
    public static final String SQL_GET_ALL_SERVICE = "select id,appId,pkgNames,signHash,icon,style,name,subPageIcon,subDesc,subSwitchDesc,minSyncVersion,record,recordIndex,version,iconPath,subPageIconPath,subUser from drive_config;";
    public static final String SQL_GET_SERVICE_BY_ID = "select id,appId,pkgNames,signHash,icon,style,name,subPageIcon,subDesc,subSwitchDesc,minSyncVersion,record,recordIndex,version,iconPath,subPageIconPath,subUser from drive_config where id=?;";
    public static final String SQL_INSERT = "insert into drive_config values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    public static final String SQL_UPDATE_ICON_PATH = "update drive_config set iconPath=? where id=?;";
}
