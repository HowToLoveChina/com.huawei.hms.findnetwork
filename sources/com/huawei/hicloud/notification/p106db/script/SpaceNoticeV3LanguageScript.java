package com.huawei.hicloud.notification.p106db.script;

/* loaded from: classes6.dex */
public class SpaceNoticeV3LanguageScript {
    public static final String CLEAR = "delete from space_notify_v3_language;";
    public static final String CLEAR_LOCAL = "delete from space_notify_v3_language_local;";
    public static final String GET_COUNT = "select count(*) from space_notify_v3_language;";
    public static final String GET_COUNT_LOCAL = "select count(*) from space_notify_v3_language_local;";
    public static final String INSERT_STRING = "insert into space_notify_v3_language values(?, ?, ?);";
    public static final String INSERT_STRING_LOCAL = "insert into space_notify_v3_language_local values(?, ?, ?);";
    public static final String QUERY_VALUE = "select languageName, textName, textValue from space_notify_v3_language where languageName = ? and textName = ?;";
    public static final String QUERY_VALUE_LOCAL = "select languageName, textName, textValue from space_notify_v3_language_local where languageName = ? and textName = ?;";
    public static final String SQL_QUERY_ALL_STRING_VALUE = "select languageName,textName,textValue from space_notify_v3_language where (languageName=? or languageName like ? or languageName=?);";
    public static final String SQL_QUERY_ALL_STRING_VALUE_LOCAL = "select languageName,textName,textValue from space_notify_v3_language_local where (languageName=? or languageName like ? or languageName=?);";
    public static final String SQL_QUERY_STRING_VALUE = "select languageName,textName,textValue from space_notify_v3_language where (languageName=? or languageName like ? or languageName=?) and textName=?;";
    public static final String SQL_QUERY_STRING_VALUE_LOCAL = "select languageName,textName,textValue from space_notify_v3_language_local where (languageName=? or languageName like ? or languageName=?) and textName=?;";
}
