package com.huawei.hicloud.request.basic.bean;

import java.util.Map;

/* loaded from: classes6.dex */
public class PostUserPropertiesReq extends BasicBaseReq {
    public static final int IS_APPEND = 1;
    public static final int IS_OVERWRITE = 2;
    private Map<String, String> properties;
    private int updateType;

    public PostUserPropertiesReq(Map<String, String> map) {
        super("postUserProperties");
        this.properties = map;
        this.updateType = 1;
    }

    public Map<String, String> getProperties() {
        return this.properties;
    }

    public int getUpdateType() {
        return this.updateType;
    }

    public void setProperties(Map<String, String> map) {
        this.properties = map;
    }

    public void setUpdateType(int i10) {
        this.updateType = i10;
    }

    public PostUserPropertiesReq() {
        super("postUserProperties");
    }
}
