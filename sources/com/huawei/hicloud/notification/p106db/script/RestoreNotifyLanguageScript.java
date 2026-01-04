package com.huawei.hicloud.notification.p106db.script;

/* loaded from: classes6.dex */
public class RestoreNotifyLanguageScript {
    public static final String CLEAR = "delete from restore_notify_language";
    public static final String GET_COUNT = "select count(*) from restore_notify_language";
    public static final String SQL_GET_RESTORE_CONTENT = "select id,loginstate,language,title,sub_title from restore_notify_language where loginstate = ? and language = ?;";
    public static final String SQL_GET_RESTORE_CONTENT_BY_LANGUAGE = "select id,loginstate,language,title,sub_title from restore_notify_language where loginstate = ? and language like ?;";
    public static final String SQL_RESTORE_LANGUAGE_INSERT = "insert into restore_notify_language values(?, ?, ?, ?, ?);";
}
