package com.huawei.hicloud.notification.p106db.script;

/* loaded from: classes6.dex */
public class SyncConfigScript {
    public static final String CLEAR = "delete from sync_config ";
    public static final String GET_COUNT = "select count(*) from sync_config;";
    public static final String SQL_GET_ALL_SERVICE = "select id,name,icon,iconPath,record,recordIndex,supportServer,unstructedPath,unstructedPathObs,minSyncVersion,minSyncVersionObs,subUser,applications,notifyType, forceDelete,databaseId,keyType,fingerPrints,iconHash from sync_config;";
    public static final String SQL_GET_SERVICE_BY_APPLICATION = "select id,name,icon,iconPath,record,recordIndex,supportServer,unstructedPath,unstructedPathObs,minSyncVersion,minSyncVersionObs,subUser,applications,notifyType, forceDelete,databaseId,keyType,fingerPrints,iconHash from sync_config where applications like ?;";
    public static final String SQL_GET_SERVICE_BY_DATABASE_ID = "select id,name,icon,iconPath,record,recordIndex,supportServer,unstructedPath,unstructedPathObs,minSyncVersion,minSyncVersionObs,subUser,applications,notifyType, forceDelete,databaseId,keyType,fingerPrints,iconHash from sync_config where databaseId=?;";
    public static final String SQL_GET_SERVICE_BY_ID = "select id,name,icon,iconPath,record,recordIndex,supportServer,unstructedPath,unstructedPathObs,minSyncVersion,minSyncVersionObs,subUser,applications,notifyType, forceDelete,databaseId,keyType,fingerPrints,iconHash from sync_config where id=?;";
    public static final String SQL_GET_SERVICE_BY_UNSTRUCTUREOBS_PATH = "select id,name,icon,iconPath,record,recordIndex,supportServer,unstructedPath,unstructedPathObs,minSyncVersion,minSyncVersionObs,subUser,applications,notifyType, forceDelete,databaseId,keyType,fingerPrints,iconHash from sync_config where unstructedPathObs=?;";
    public static final String SQL_GET_SERVICE_BY_UNSTRUCTURE_PATH = "select id,name,icon,iconPath,record,recordIndex,supportServer,unstructedPath,unstructedPathObs,minSyncVersion,minSyncVersionObs,subUser,applications,notifyType, forceDelete,databaseId,keyType,fingerPrints,iconHash from sync_config where unstructedPath=?;";
    public static final String SQL_INSERT = "insert into sync_config values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    public static final String SQL_UPDATE_ICON_PATH = "update sync_config set iconPath=? where id=?;";
}
