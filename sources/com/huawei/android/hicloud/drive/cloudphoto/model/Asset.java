package com.huawei.android.hicloud.drive.cloudphoto.model;

import com.huawei.cloud.base.util.C4644l;
import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.Map;
import ni.C11707b;

/* loaded from: classes3.dex */
public class Asset extends C11707b {

    @InterfaceC4648p
    private MediaAssetAttribute attributes;

    @InterfaceC4648p
    private Cipher cipher;

    @InterfaceC4648p
    private C4644l createdTime;

    /* renamed from: id */
    @InterfaceC4648p
    private String f12218id;

    @InterfaceC4648p
    private Integer keepPolicy;

    @InterfaceC4648p
    private String mimeType;

    @InterfaceC4648p
    private C4644l modifiedTime;
    private String name;

    @InterfaceC4648p
    private Map<String, String> properties;

    @InterfaceC4648p
    private Resource resource;

    @InterfaceC4648p
    private Map<String, Object> scaAttributes;

    @InterfaceC4648p
    private Integer state;

    @InterfaceC4648p
    private Integer status;

    @InterfaceC4648p
    private Long version;

    @InterfaceC4648p
    private String versionId;
    public static final Integer NORMAL = 0;
    public static final Integer FIX = 1;

    public MediaAssetAttribute getAttributes() {
        return this.attributes;
    }

    public Cipher getCipher() {
        return this.cipher;
    }

    public C4644l getCreatedTime() {
        return this.createdTime;
    }

    public String getId() {
        return this.f12218id;
    }

    public Integer getKeepPolicy() {
        return this.keepPolicy;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public C4644l getModifiedTime() {
        return this.modifiedTime;
    }

    public String getName() {
        return this.name;
    }

    public Map<String, String> getProperties() {
        return this.properties;
    }

    public Resource getResource() {
        return this.resource;
    }

    public Map<String, Object> getScaAttributes() {
        return this.scaAttributes;
    }

    public Integer getState() {
        return this.state;
    }

    public Integer getStatus() {
        Integer num = this.status;
        if (num == null) {
            return 0;
        }
        return num;
    }

    public Long getVersion() {
        return this.version;
    }

    public String getVersionId() {
        return this.versionId;
    }

    public void setAttributes(MediaAssetAttribute mediaAssetAttribute) {
        this.attributes = mediaAssetAttribute;
    }

    public void setCipher(Cipher cipher) {
        this.cipher = cipher;
    }

    public void setCreatedTime(C4644l c4644l) {
        this.createdTime = c4644l;
    }

    public void setId(String str) {
        this.f12218id = str;
    }

    public void setKeepPolicy(Integer num) {
        this.keepPolicy = num;
    }

    public void setMimeType(String str) {
        this.mimeType = str;
    }

    public void setModifiedTime(C4644l c4644l) {
        this.modifiedTime = c4644l;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setProperties(Map<String, String> map) {
        this.properties = map;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public void setScaAttributes(Map<String, Object> map) {
        this.scaAttributes = map;
    }

    public Asset setState(Integer num) {
        this.state = num;
        return this;
    }

    public void setStatus(Integer num) {
        this.status = num;
    }

    public void setVersion(Long l10) {
        this.version = l10;
    }

    public void setVersionId(String str) {
        this.versionId = str;
    }
}
