package com.huawei.android.hicloud.syncdrive.cloudsync.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import com.huawei.hicloud.base.drive.model.EndpointUrl;
import java.util.List;
import java.util.Map;
import ni.C11707b;

/* loaded from: classes3.dex */
public class Resource extends C11707b {

    @InterfaceC4648p
    private Map<String, Object> attributes;

    @InterfaceC4648p
    private String createdTime;

    @InterfaceC4648p
    private EndpointUrl downloadUrl;

    @InterfaceC4648p
    private String hash;

    /* renamed from: id */
    @InterfaceC4648p
    private String f13037id;

    @InterfaceC4648p
    private Long length;

    @InterfaceC4648p
    private String modifiedTime;

    @InterfaceC4648p
    private List<SliceObject> objects;

    @InterfaceC4648p
    private Map<String, String> properties;

    @InterfaceC4648p
    private String sha256;

    @InterfaceC4648p
    private Integer sliceSize;

    @InterfaceC4648p
    private Integer state;

    @InterfaceC4648p
    private Integer type;

    public Map<String, Object> getAttributes() {
        return this.attributes;
    }

    public String getCreatedTime() {
        return this.createdTime;
    }

    public EndpointUrl getDownloadUrl() {
        return this.downloadUrl;
    }

    public String getHash() {
        return this.hash;
    }

    public String getId() {
        return this.f13037id;
    }

    public Long getLength() {
        return this.length;
    }

    public String getModifiedTime() {
        return this.modifiedTime;
    }

    public List<SliceObject> getObjects() {
        return this.objects;
    }

    public Map<String, String> getProperties() {
        return this.properties;
    }

    public String getSha256() {
        return this.sha256;
    }

    public Integer getSliceSize() {
        return this.sliceSize;
    }

    public Integer getState() {
        return this.state;
    }

    public Integer getType() {
        return this.type;
    }

    public void setAttributes(Map<String, Object> map) {
        this.attributes = map;
    }

    public void setCreatedTime(String str) {
        this.createdTime = str;
    }

    public void setDownloadUrl(EndpointUrl endpointUrl) {
        this.downloadUrl = endpointUrl;
    }

    public void setHash(String str) {
        this.hash = str;
    }

    public void setId(String str) {
        this.f13037id = str;
    }

    public void setLength(Long l10) {
        this.length = l10;
    }

    public void setModifiedTime(String str) {
        this.modifiedTime = str;
    }

    public void setObjects(List<SliceObject> list) {
        this.objects = list;
    }

    public void setProperties(Map<String, String> map) {
        this.properties = map;
    }

    public void setSha256(String str) {
        this.sha256 = str;
    }

    public void setSliceSize(Integer num) {
        this.sliceSize = num;
    }

    public void setState(Integer num) {
        this.state = num;
    }

    public void setType(Integer num) {
        this.type = num;
    }

    @Override // ni.C11707b, java.util.AbstractMap
    public String toString() {
        return "Resource{createdTime='" + this.createdTime + "', hash='" + this.hash + "', id='" + this.f13037id + "', length=" + this.length + ", modifiedTime='" + this.modifiedTime + "', sha256='" + this.sha256 + "', state=" + this.state + '}';
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public Resource set(String str, Object obj) {
        return (Resource) super.set(str, obj);
    }
}
