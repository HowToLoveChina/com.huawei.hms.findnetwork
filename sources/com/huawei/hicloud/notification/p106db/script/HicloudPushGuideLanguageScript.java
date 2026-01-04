package com.huawei.hicloud.notification.p106db.script;

/* loaded from: classes6.dex */
public class HicloudPushGuideLanguageScript {
    public static final String CLEAR = "delete from hicloud_push_guide_language";
    public static final String INSERT_STRING = "insert into hicloud_push_guide_language values(?, ?, ?)";
    public static final String QUERY_COUNT = "select count(*) from hicloud_push_guide_language;";
    public static final String QUERY_VALUE = "select languageName, textName, textValue from hicloud_push_guide_language where languageName = ? and textName = ?";
    public static final String SQL_QUERY_STRING_VALUE = "select languageName,textName,textValue from hicloud_push_guide_language where (languageName=? or languageName like ? or languageName=?) and textName=?;";
}
