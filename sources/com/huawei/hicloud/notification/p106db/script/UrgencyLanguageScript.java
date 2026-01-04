package com.huawei.hicloud.notification.p106db.script;

/* loaded from: classes6.dex */
public class UrgencyLanguageScript {
    public static final String CLEAR = "delete from urgency_language ";
    public static final String GET_COUNT = "select count(*) from urgency_language;";
    public static final String SQL_INSERT = "insert into urgency_language values(?, ?, ?, ?);";
    public static final String SQL_QUERY_STRING_VALUE = "select version,languageName,textName,textValue from urgency_language where (languageName=? or languageName like ? or languageName=?) and textName=?;";
}
