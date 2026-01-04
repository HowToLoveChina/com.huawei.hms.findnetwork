package com.huawei.android.hicloud.syncdrive.cloudsync.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.Map;
import ni.C11707b;

/* loaded from: classes3.dex */
public class AssetCreateRequest extends C11707b {

    @InterfaceC4648p
    private Map<String, Object> attributes;

    @InterfaceC4648p
    private String mimeType;

    @InterfaceC4648p
    private Map<String, String> properties;

    @InterfaceC4648p
    private ResourceCreateReq resource;

    @InterfaceC4648p
    private Map<String, Object> scaAttributes;

    public Map<String, Object> getAttributes() {
        return this.attributes;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public Map<String, String> getProperties() {
        return this.properties;
    }

    public ResourceCreateReq getResource() {
        return this.resource;
    }

    public Map<String, Object> getScaAttributes() {
        return this.scaAttributes;
    }

    public void setAttributes(Map<String, Object> map) {
        this.attributes = map;
    }

    public void setMimeType(String str) {
        this.mimeType = str;
    }

    public void setProperties(Map<String, String> map) {
        this.properties = map;
    }

    public void setResource(ResourceCreateReq resourceCreateReq) {
        this.resource = resourceCreateReq;
    }

    public void setScaAttributes(Map<String, Object> map) {
        this.scaAttributes = map;
    }
}
