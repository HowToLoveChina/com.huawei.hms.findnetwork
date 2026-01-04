package com.huawei.android.hicloud.syncdrive.cloudsync.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.List;
import java.util.Map;
import ni.C11707b;

/* loaded from: classes3.dex */
public class ResourceUpdateReq extends C11707b {

    @InterfaceC4648p
    private Map<String, Object> attributes;

    @InterfaceC4648p
    private String hash;

    @InterfaceC4648p
    private List<ObjectUpdateReq> objects;

    @InterfaceC4648p
    private Map<String, Object> properties;

    @InterfaceC4648p
    private String sha256;

    public Map<String, Object> getAttributes() {
        return this.attributes;
    }

    public String getHash() {
        return this.hash;
    }

    public List<ObjectUpdateReq> getObjects() {
        return this.objects;
    }

    public Map<String, Object> getProperties() {
        return this.properties;
    }

    public String getSha256() {
        return this.sha256;
    }

    public void setAttributes(Map<String, Object> map) {
        this.attributes = map;
    }

    public ResourceUpdateReq setHash(String str) {
        this.hash = str;
        return this;
    }

    public ResourceUpdateReq setObjects(List<ObjectUpdateReq> list) {
        this.objects = list;
        return this;
    }

    public ResourceUpdateReq setProperties(Map<String, Object> map) {
        this.properties = map;
        return this;
    }

    public ResourceUpdateReq setSha256(String str) {
        this.sha256 = str;
        return this;
    }
}
