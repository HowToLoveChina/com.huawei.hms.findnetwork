package com.huawei.hicloud.notification.p106db.script;

/* loaded from: classes6.dex */
public class H5ConfigScript {
    public static final String CLEAR_H5_CONFIG_CONTENT = "delete from h5_config";
    public static final String INSETT_H5_CONFIG_CONTENT = "insert into h5_config values(?, ?, ?)";
    public static final String QUERY_H5_CONFIG_CONTENT = "select resourceId, key, value from h5_config where resourceId=? and key=? ";
}
