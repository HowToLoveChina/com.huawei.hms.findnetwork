package com.huawei.hicloud.notification.p106db.script;

/* loaded from: classes6.dex */
public class DriveConfigLanguageScript {
    public static final String CLEAR = "delete from drive_config_language ";
    public static final String GET_COUNT = "select count(*) from drive_config_language;";
    public static final String SQL_INSERT = "insert into drive_config_language values(?, ?, ?);";
    public static final String SQL_QUERY_STRING_VALUE = "select languageName,textName,textValue from drive_config_language where (languageName=? or languageName like ? or languageName=?) and textName=?;";
}
