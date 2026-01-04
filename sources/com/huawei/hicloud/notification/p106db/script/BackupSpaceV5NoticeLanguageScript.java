package com.huawei.hicloud.notification.p106db.script;

/* loaded from: classes6.dex */
public class BackupSpaceV5NoticeLanguageScript {
    public static final String CLEAR = "delete from space_notify_v5_language;";
    public static final String CLEAR_BY_INSTANCE_ID = "delete from space_notify_v5_language where textName like ?;";
    public static final String GET_COUNT = "select count(*) from space_notify_v5_language;";
    public static final String INSERT_STRING = "insert into space_notify_v5_language values(?, ?, ?);";
    public static final String QUERY_VALUE = "select languageName, textName, textValue from space_notify_v5_language where languageName = ? and textName = ?;";
    public static final String SQL_QUERY_ALL_STRING_VALUE = "select languageName,textName,textValue from space_notify_v5_language where (languageName=? or languageName like ? or languageName=?);";
    public static final String SQL_QUERY_STRING_VALUE = "select languageName,textName,textValue from space_notify_v5_language where (languageName=? or languageName like ? or languageName=?) and textName=?;";
}
