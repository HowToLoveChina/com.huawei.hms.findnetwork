package com.huawei.hicloud.notification.p106db.script;

/* loaded from: classes6.dex */
public class HiCloudActivesLanguageDBScript {
    public static final String CLEAR = "delete from hicloud_actives_language ";
    public static final String GET_COUNT = "select count(*) from hicloud_actives_language;";
    public static final String INSERT_HICLOUD_ACTIVES_LANGUAGE = "insert into hicloud_actives_language values(?, ?, ?)";
    public static final String SQL_QUERY_STRING_VALUE = "select languageName,textName,textValue from hicloud_actives_language where (languageName=? or languageName like ? or languageName=?) and textName=?;";
}
