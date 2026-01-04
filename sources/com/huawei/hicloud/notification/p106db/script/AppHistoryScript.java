package com.huawei.hicloud.notification.p106db.script;

/* loaded from: classes6.dex */
public class AppHistoryScript {
    public static final String CLEAR = "delete from history_application_distribute";
    public static final String SQL_DELETE = "delete from history_application_distribute where appId in";
    public static final String SQL_DELETE_OLDEST = "DELETE FROM history_application_distribute WHERE appId IN (SELECT appId FROM history_application_distribute ORDER BY time ASC";
    public static final String SQL_GET_HISTORY_BY_PAGE_PREFIX = "select appId,status,time from history_application_distribute order by time DESC";
    public static final String SQL_GET_HISTORY_COUNT = "select count(appId) from history_application_distribute";
    public static final String SQL_INSERT = "insert or replace into history_application_distribute values(?, ?, ?);";
}
