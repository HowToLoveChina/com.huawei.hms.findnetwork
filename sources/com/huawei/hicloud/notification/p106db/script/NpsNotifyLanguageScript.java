package com.huawei.hicloud.notification.p106db.script;

/* loaded from: classes6.dex */
public class NpsNotifyLanguageScript {
    public static final String CLEAR = "delete from hicloud_nps_notify_language;";
    public static final String GET_COUNT = "select count(*) from hicloud_nps_notify_language;";
    public static final String INSERT_STRING = "insert into hicloud_nps_notify_language values(?, ?, ?);";
    public static final String SQL_QUERY_ALL_STRING_VALUE = "select languageName,textName,textValue from hicloud_nps_notify_language where (languageName=? or languageName like ? or languageName=?);";
    public static final String SQL_QUERY_STRING_VALUE = "select languageName,textName,textValue from hicloud_nps_notify_language where (languageName=? or languageName like ? or languageName=?) and textName=?;";
}
