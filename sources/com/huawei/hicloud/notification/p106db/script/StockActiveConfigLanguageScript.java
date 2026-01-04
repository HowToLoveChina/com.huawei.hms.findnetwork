package com.huawei.hicloud.notification.p106db.script;

/* loaded from: classes6.dex */
public class StockActiveConfigLanguageScript {
    public static final String CLEAR = "delete from stock_active_config_language";
    public static final String INSERT_STRING = "insert into stock_active_config_language values(?, ?, ?)";
    public static final String QUERY_COUNT = "select count(*) from stock_active_config_language;";
    public static final String QUERY_VALUE = "select languageName, textName, textValue from stock_active_config_language where languageName = ? and textName = ?";
    public static final String SQL_QUERY_STRING_VALUE = "select languageName,textName,textValue from stock_active_config_language where (languageName=? or languageName like ? or languageName=?) and textName=?;";
}
