package com.huawei.hicloud.notification.p106db.script;

/* loaded from: classes6.dex */
public class H5LanguageConfigScript {
    public static final String CLEAR_H5_LANGUAGE_CONFIG_CONTENT = "delete from h5_language_config";
    public static final String GET_COUNT = "select count(*) from h5_language_config;";
    public static final String INSETT_H5_LANGUAGE_CONFIG_CONTENT = "insert into h5_language_config values(?, ?, ?)";
    public static final String QUERY_H5_LANGUAGE_CONFIG_CONTENT = "select language, name, value from h5_language_config where language=? and name=?";
    public static final String SQL_QUERY_STRING_VALUE = "select language,name,value from h5_language_config where (language=? or language like ? or language=?) and name=?;";
}
