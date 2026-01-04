package com.huawei.hicloud.notification.p106db.script;

/* loaded from: classes6.dex */
public class FreqControlTimeScript {
    public static final String DELETE_TABLE_FREQ_CONTROL_TIME = "delete from freq_control_time";
    public static final String QUERY_DAY_COUNT = "select distinct time from freq_control_time where time>=? and time<? and remind_method!='desk_popup';";
    public static final String QUERY_REMIND_METHOD_DAY_COUNT = "select distinct time from freq_control_time where time>=? and time<? and remind_method=?;";
    public static final String QUERY_REMIND_PURPOSE_DAY_COUNT = "select time from freq_control_time where time>=? and time<? and remind_purpose=?;";
    public static final String REPLACE_TIME = "replace into freq_control_time(time, remind_purpose, remind_method) VALUES(?, ?, ?);";
}
