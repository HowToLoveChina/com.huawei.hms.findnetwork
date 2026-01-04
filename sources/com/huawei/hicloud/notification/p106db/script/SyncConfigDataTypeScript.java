package com.huawei.hicloud.notification.p106db.script;

/* loaded from: classes6.dex */
public class SyncConfigDataTypeScript {
    public static final String CLEAR = "DELETE FROM sync_config_data_type ";
    public static final String SQL_GET_DATA_TYPE_BY_SERVICE_ID = "select serviceId,typeId,typeName,showNum,rcycSync from sync_config_data_type where serviceId=?;";
    public static final String SQL_INSERT = "insert into sync_config_data_type values(?, ?, ?, ?, ?);";
}
