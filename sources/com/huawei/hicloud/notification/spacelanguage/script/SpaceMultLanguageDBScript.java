package com.huawei.hicloud.notification.spacelanguage.script;

/* loaded from: classes6.dex */
public class SpaceMultLanguageDBScript {
    public static final String CLEAR_INSERT_SPACE_MULT_LANGUAGE = "delete from space_mult_language";
    public static final String COUNT_OF_DATA = "select * from space_mult_language";
    public static final String GET_COUNT = "select count(*) from space_mult_language;";
    public static final String INSERT_SPACE_MULT_LANGUAGE = "insert into space_mult_language values(?, ?, ?)";
    public static final String QUERY_VALUE = "select value from space_mult_language where language=? and name=?";
    public static final String QUERY_VALUE_BY_LANGUAGE = "select value from space_mult_language where language like ? and name=?";
}
