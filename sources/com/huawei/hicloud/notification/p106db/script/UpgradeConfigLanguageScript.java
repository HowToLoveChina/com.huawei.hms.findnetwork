package com.huawei.hicloud.notification.p106db.script;

/* loaded from: classes6.dex */
public class UpgradeConfigLanguageScript {
    public static final String CLEAR = "delete from upgrade_config_language";
    public static final String INSERT_STRING = "insert into upgrade_config_language values(?, ?, ?)";
    public static final String QUERY_COUNT = "select count(*) from upgrade_config_language;";
    public static final String QUERY_VALUE = "select languageName, textName, textValue from upgrade_config_language where languageName = ? and textName = ?";
    public static final String SQL_QUERY_STRING_VALUE = "select languageName,textName,textValue from upgrade_config_language where (languageName=? or languageName like ? or languageName=?) and textName=?;";
}
