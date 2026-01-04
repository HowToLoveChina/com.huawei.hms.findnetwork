package com.huawei.android.hicloud.syncdrive.cloudsync.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import com.huawei.hicloud.base.drive.model.Cipher;
import java.util.Map;
import ni.C11707b;

/* loaded from: classes3.dex */
public class Asset extends C11707b {

    @InterfaceC4648p
    private String appVer;

    @InterfaceC4648p
    private Map<String, Object> attributes;

    @InterfaceC4648p
    private Cipher cipher;

    @InterfaceC4648p
    private String createdTime;

    /* renamed from: id */
    @InterfaceC4648p
    private String f13032id;

    @InterfaceC4648p
    private Integer keepPolicy;

    @InterfaceC4648p
    private String mimeType;

    @InterfaceC4648p
    private String modifiedTime;

    @InterfaceC4648p
    private Map<String, String> properties;

    @InterfaceC4648p
    private Resource resource;

    @InterfaceC4648p
    private Integer state;

    @InterfaceC4648p
    private Integer status;

    @InterfaceC4648p
    private Long version;

    @InterfaceC4648p
    private String versionId;

    public String getAppVer() {
        return this.appVer;
    }

    public Map<String, Object> getAttributes() {
        return this.attributes;
    }

    public Cipher getCipher() {
        return this.cipher;
    }

    public String getCreatedTime() {
        return this.createdTime;
    }

    public String getId() {
        return this.f13032id;
    }

    public Integer getKeepPolicy() {
        return this.keepPolicy;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public String getModifiedTime() {
        return this.modifiedTime;
    }

    public Map<String, String> getProperties() {
        return this.properties;
    }

    public Resource getResource() {
        return this.resource;
    }

    public Integer getState() {
        return this.state;
    }

    public Integer getStatus() {
        return this.status;
    }

    public Long getVersion() {
        return this.version;
    }

    public String getVersionId() {
        return this.versionId;
    }

    public void setAppVer(String str) {
        this.appVer = str;
    }

    public Asset setAttributes(Map<String, Object> map) {
        this.attributes = map;
        return this;
    }

    public Asset setCipher(Cipher cipher) {
        this.cipher = cipher;
        return this;
    }

    public Asset setCreatedTime(String str) {
        this.createdTime = str;
        return this;
    }

    public Asset setId(String str) {
        this.f13032id = str;
        return this;
    }

    public Asset setKeepPolicy(Integer num) {
        this.keepPolicy = num;
        return this;
    }

    public Asset setMimeType(String str) {
        this.mimeType = str;
        return this;
    }

    public Asset setModifiedTime(String str) {
        this.modifiedTime = str;
        return this;
    }

    public Asset setProperties(Map<String, String> map) {
        this.properties = map;
        return this;
    }

    public Asset setResource(Resource resource) {
        this.resource = resource;
        return this;
    }

    public Asset setState(Integer num) {
        this.state = num;
        return this;
    }

    public void setStatus(Integer num) {
        this.status = num;
    }

    public Asset setVersion(Long l10) {
        this.version = l10;
        return this;
    }

    public Asset setVersionId(String str) {
        this.versionId = str;
        return this;
    }
}
