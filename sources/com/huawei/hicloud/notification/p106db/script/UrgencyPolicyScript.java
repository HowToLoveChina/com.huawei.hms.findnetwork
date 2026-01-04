package com.huawei.hicloud.notification.p106db.script;

/* loaded from: classes6.dex */
public class UrgencyPolicyScript {
    public static final String CLEAR = "delete from urgency_policy";
    public static final String GET_COUNT = "select count(*) from urgency_policy;";
    public static final String SQL_GET_ALL_POLICY = "select id,scenario,action,notice_type,notice,ontop,detail from urgency_policy;";
    public static final String SQL_POLICY_INSERT = "insert into urgency_policy values(?, ?, ?, ?, ?, ?, ?);";
}
