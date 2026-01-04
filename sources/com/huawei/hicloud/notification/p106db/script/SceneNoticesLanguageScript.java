package com.huawei.hicloud.notification.p106db.script;

/* loaded from: classes6.dex */
public class SceneNoticesLanguageScript {
    public static final String CLEAR = "delete from scene_notices_language";
    public static final String INSERT_STRING = "insert into scene_notices_language values(?, ?, ?)";
    public static final String QUERY_COUNT = "select count(*) from scene_notices_language;";
    public static final String QUERY_VALUE = "select languageName, textName, textValue from scene_notices_language where languageName = ? and textName = ?";
    public static final String SQL_QUERY_STRING_VALUE = "select languageName,textName,textValue from scene_notices_language where (languageName=? or languageName like ? or languageName=?) and textName=?;";
}
