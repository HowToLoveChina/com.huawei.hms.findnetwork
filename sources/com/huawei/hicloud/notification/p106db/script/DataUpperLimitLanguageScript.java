package com.huawei.hicloud.notification.p106db.script;

/* loaded from: classes6.dex */
public class DataUpperLimitLanguageScript {
    public static final String CLEAR = "delete from data_upper_limit_language;";
    public static final String GET_COUNT = "select count(*) from data_upper_limit_language;";
    public static final String INSERT_STRING = "insert into data_upper_limit_language values(?, ?, ?);";
    public static final String QUERY_VALUE = "select languageName, textName, textValue from data_upper_limit_language where languageName = ? and textName = ?;";
    public static final String SQL_QUERY_STRING_VALUE = "select languageName,textName,textValue from data_upper_limit_language where (languageName=? or languageName like ? or languageName=?) and textName=?;";
}
