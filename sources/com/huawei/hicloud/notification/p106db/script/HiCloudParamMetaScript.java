package com.huawei.hicloud.notification.p106db.script;

/* loaded from: classes6.dex */
public class HiCloudParamMetaScript {
    public static final String CLEAR = "delete from params_meta";
    public static final String INSERT_STRING = "insert into params_meta values(?, ?, ?, ?, ?)";
    public static final String QUERY_FULL_DATA_VALUE = "select name, type, provider, endpoint ,authType from params_meta";
    public static final String QUERY_FULL_DATA_VALUE_BY_KEY = "select name, type, provider, endpoint, authType from params_meta where name = ?";
}
