package com.huawei.hicloud.notification.p106db.script;

/* loaded from: classes6.dex */
public class HiCloudTextLinkLanguageScript {
    public static final String CLEAR = "delete from text_link_language;";
    public static final String DROP_TABLE_TEXT_LINK_CONFIG_LANGUAGE = "DROP TABLE if exists text_link_language";
    public static final String GET_COUNT = "select count(*) from text_link_language;";
    public static final String INSERT_STRING = "insert into text_link_language values(?, ?, ?);";
    public static final String QUERY_VALUE = "select languageName, textName, textValue from text_link_language where languageName = ? and textName = ?;";
    public static final String SQL_QUERY_ALL_STRING_VALUE = "select languageName,textName,textValue from text_link_language where (languageName=? or languageName like ? or languageName=?);";
    public static final String SQL_QUERY_STRING_VALUE = "select languageName,textName,textValue from text_link_language where (languageName=? or languageName like ? or languageName=?) and textName=?;";
}
