package com.huawei.hicloud.cloudbackup.p104v3.server.model;

import com.huawei.cloud.base.util.C4644l;
import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.Map;
import ni.C11707b;

/* loaded from: classes6.dex */
public class Asset extends C11707b {

    @InterfaceC4648p
    private C11707b attributes;

    @InterfaceC4648p
    private Cipher cipher;

    @InterfaceC4648p
    private String divideCheckUrl;

    /* renamed from: id */
    @InterfaceC4648p
    private String f22584id;

    @InterfaceC4648p
    private Integer keepPolicy;

    @InterfaceC4648p
    private String lastModifyingUser;

    @InterfaceC4648p
    private String mimeType;

    @InterfaceC4648p
    private C4644l modifiedTime;

    @InterfaceC4648p
    private Map<String, String> properties;
    private String quicSwitch;

    @InterfaceC4648p
    private Integer quotaType;

    @InterfaceC4648p
    private Resource resource;

    @InterfaceC4648p
    private C11707b scaAttributes;

    @InterfaceC4648p
    private Integer scaRank;

    @InterfaceC4648p
    private Integer scaState;

    @InterfaceC4648p
    private Integer state;

    @InterfaceC4648p
    private Integer version;

    @InterfaceC4648p
    private String versionId;

    public C11707b getAttributes() {
        return this.attributes;
    }

    public Cipher getCipher() {
        return this.cipher;
    }

    public String getDivideCheckUrl() {
        return this.divideCheckUrl;
    }

    public String getId() {
        return this.f22584id;
    }

    public Integer getKeepPolicy() {
        return this.keepPolicy;
    }

    public String getLastModifyingUser() {
        return this.lastModifyingUser;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public C4644l getModifiedTime() {
        return this.modifiedTime;
    }

    public Map<String, String> getProperties() {
        return this.properties;
    }

    public String getQuicSwitch() {
        return this.quicSwitch;
    }

    public Integer getQuotaType() {
        return this.quotaType;
    }

    public Resource getResource() {
        return this.resource;
    }

    public C11707b getScaAttributes() {
        return this.scaAttributes;
    }

    public Integer getScaRank() {
        return this.scaRank;
    }

    public Integer getScaState() {
        return this.scaState;
    }

    public Integer getState() {
        return this.state;
    }

    public Integer getVersion() {
        return this.version;
    }

    public String getVersionId() {
        return this.versionId;
    }

    public Asset setAttributes(C11707b c11707b) {
        this.attributes = c11707b;
        return this;
    }

    public Asset setCipher(Cipher cipher) {
        this.cipher = cipher;
        return this;
    }

    public void setDivideCheckUrl(String str) {
        this.divideCheckUrl = str;
    }

    public Asset setId(String str) {
        this.f22584id = str;
        return this;
    }

    public Asset setKeepPolicy(Integer num) {
        this.keepPolicy = num;
        return this;
    }

    public Asset setLastModifyingUser(String str) {
        this.lastModifyingUser = str;
        return this;
    }

    public Asset setMimeType(String str) {
        this.mimeType = str;
        return this;
    }

    public Asset setModifiedTime(C4644l c4644l) {
        this.modifiedTime = c4644l;
        return this;
    }

    public Asset setProperties(Map<String, String> map) {
        this.properties = map;
        return this;
    }

    public void setQuicSwitch(String str) {
        this.quicSwitch = str;
    }

    public Asset setQuotaType(Integer num) {
        this.quotaType = num;
        return this;
    }

    public Asset setResource(Resource resource) {
        this.resource = resource;
        return this;
    }

    public Asset setScaAttributes(C11707b c11707b) {
        this.scaAttributes = c11707b;
        return this;
    }

    public Asset setScaRank(Integer num) {
        this.scaRank = num;
        return this;
    }

    public Asset setScaState(Integer num) {
        this.scaState = num;
        return this;
    }

    public Asset setState(Integer num) {
        this.state = num;
        return this;
    }

    public Asset setVersion(Integer num) {
        this.version = num;
        return this;
    }

    public Asset setVersionId(String str) {
        this.versionId = str;
        return this;
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public Asset set(String str, Object obj) {
        return (Asset) super.set(str, obj);
    }
}
