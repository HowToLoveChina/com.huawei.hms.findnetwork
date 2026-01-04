package com.huawei.hicloud.notification.p106db.script;

/* loaded from: classes6.dex */
public class SpaceNotifyScript {
    public static final String DELETE_TABLE_SPACE_NOTIFY = "delete from space_notify";
    public static final String QUERY_BY_DAY = "select time, day, month, year, week from space_notify where day = ? and month = ? and year = ?;";
    public static final String QUERY_BY_MONTH = "select time, day, month, year, week from space_notify where month = ? and year = ?;";
    public static final String QUERY_BY_WEEK = "select time, day, month, year, week from space_notify where week = ? and year = ?;";
    public static final String REPLACE_TIME = "replace into space_notify(time,day,month,year,week) VALUES(?,?,?,?,?);";
}
