package com.huawei.android.hicloud.syncdrive.cloudsync.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.Map;
import ni.C11707b;

/* loaded from: classes3.dex */
public class Relation extends C11707b {

    @InterfaceC4648p
    private Map<String, String> attributes;

    /* renamed from: id */
    @InterfaceC4648p
    private String f13036id;

    @InterfaceC4648p
    private String kind;

    @InterfaceC4648p
    private Map<String, String> properties;

    @InterfaceC4648p
    private String type;

    public Map<String, String> getAttributes() {
        return this.attributes;
    }

    public String getId() {
        return this.f13036id;
    }

    public String getKind() {
        return this.kind;
    }

    public Map<String, String> getProperties() {
        return this.properties;
    }

    public String getType() {
        return this.type;
    }

    public void setAttributes(Map<String, String> map) {
        this.attributes = map;
    }

    public void setId(String str) {
        this.f13036id = str;
    }

    public void setKind(String str) {
        this.kind = str;
    }

    public void setProperties(Map<String, String> map) {
        this.properties = map;
    }

    public void setType(String str) {
        this.type = str;
    }
}
