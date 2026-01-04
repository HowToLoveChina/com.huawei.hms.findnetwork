package com.huawei.hicloud.notification.p106db.script;

/* loaded from: classes6.dex */
public class NoticeContentLanguageScript {
    public static final String CLEAR = "delete from notice_content_language;";
    public static final String GET_COUNT = "select count(*) from notice_content_language;";
    public static final String INSERT_STRING = "insert into notice_content_language values(?, ?, ?);";
    public static final String QUERY_VALUE = "select languageName, textName, textValue from notice_content_language where languageName = ? and textName = ?;";
    public static final String SQL_QUERY_ALL_STRING_VALUE = "select languageName,textName,textValue from notice_content_language where (languageName=? or languageName like ? or languageName=?);";
    public static final String SQL_QUERY_STRING_VALUE = "select languageName,textName,textValue from notice_content_language where (languageName=? or languageName like ? or languageName=?) and textName=?;";
}
