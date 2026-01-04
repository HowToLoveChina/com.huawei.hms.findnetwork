package com.huawei.android.hicloud.drive.cloudphoto.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.Map;
import ni.C11707b;

/* loaded from: classes3.dex */
public class TasksCreateRequest extends C11707b {

    @InterfaceC4648p
    private Map<String, String> properties;

    @InterfaceC4648p
    private String type;

    public Map<String, String> getProperties() {
        return this.properties;
    }

    public String getType() {
        return this.type;
    }

    public void setProperties(Map<String, String> map) {
        this.properties = map;
    }

    public void setType(String str) {
        this.type = str;
    }
}
