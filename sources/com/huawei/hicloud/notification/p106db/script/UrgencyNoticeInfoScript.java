package com.huawei.hicloud.notification.p106db.script;

/* loaded from: classes6.dex */
public class UrgencyNoticeInfoScript {
    public static final String CLEAR = "delete from urgency_notice_info";
    public static final String GET_COUNT = "select count(*) from urgency_notice_info;";
    public static final String SQL_INSERT = "insert into urgency_notice_info values(?, ?);";
    public static final String SQL_QUERY_VALUE = "select key,value from urgency_notice_info where key=?;";
}
