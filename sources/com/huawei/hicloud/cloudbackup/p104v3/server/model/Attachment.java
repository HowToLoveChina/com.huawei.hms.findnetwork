package com.huawei.hicloud.cloudbackup.p104v3.server.model;

import com.huawei.cloud.base.util.C4644l;
import com.huawei.cloud.base.util.InterfaceC4648p;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ni.C11707b;

/* loaded from: classes6.dex */
public class Attachment extends C11707b {

    @InterfaceC4648p
    private String assetId;

    @InterfaceC4648p
    private Cipher cipher;

    @InterfaceC4648p
    private C4644l createdTime;
    private Resource.EndpointURL downloadUrl;

    @InterfaceC4648p
    private String hash;

    @InterfaceC4648p
    private Long length;

    @InterfaceC4648p
    private String mimeType;

    @InterfaceC4648p
    private C4644l modifiedTime;

    @InterfaceC4648p
    private List<Resource.SliceObject> objects;

    @InterfaceC4648p
    private Map<String, String> properties;

    @InterfaceC4648p
    private Integer quotaType;

    @InterfaceC4648p
    private String sha256;

    @InterfaceC4648p
    private Long sliceSize;

    @InterfaceC4648p
    private Integer state;

    @InterfaceC4648p
    private Integer type;

    @InterfaceC4648p
    private String usage;

    @InterfaceC4648p
    private Integer version;

    @InterfaceC4648p
    private String versionId;

    public String getAssetId() {
        return this.assetId;
    }

    public Cipher getCipher() {
        return this.cipher;
    }

    public C4644l getCreatedTime() {
        return this.createdTime;
    }

    public Resource.EndpointURL getDownloadUrl() {
        return this.downloadUrl;
    }

    public String getHash() {
        return this.hash;
    }

    public Long getLength() {
        return this.length;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public C4644l getModifiedTime() {
        return this.modifiedTime;
    }

    public List<Resource.SliceObject> getObjects() {
        return this.objects;
    }

    public Map<String, String> getProperties() {
        Map<String, String> map = this.properties;
        return map == null ? new HashMap() : map;
    }

    public Integer getQuotaType() {
        return this.quotaType;
    }

    public String getSha256() {
        return this.sha256;
    }

    public Long getSliceSize() {
        return this.sliceSize;
    }

    public Integer getState() {
        return this.state;
    }

    public Integer getType() {
        return this.type;
    }

    public String getUsage() {
        return this.usage;
    }

    public Integer getVersion() {
        return this.version;
    }

    public String getVersionId() {
        return this.versionId;
    }

    public Attachment setAssetId(String str) {
        this.assetId = str;
        return this;
    }

    public Attachment setCipher(Cipher cipher) {
        this.cipher = cipher;
        return this;
    }

    public Attachment setCreatedTime(C4644l c4644l) {
        this.createdTime = c4644l;
        return this;
    }

    public Attachment setDownloadUrl(Resource.EndpointURL endpointURL) {
        this.downloadUrl = endpointURL;
        return this;
    }

    public Attachment setHash(String str) {
        this.hash = str;
        return this;
    }

    public Attachment setLength(Long l10) {
        this.length = l10;
        return this;
    }

    public Attachment setMimeType(String str) {
        this.mimeType = str;
        return this;
    }

    public Attachment setModifiedTime(C4644l c4644l) {
        this.modifiedTime = c4644l;
        return this;
    }

    public Attachment setObjects(List<Resource.SliceObject> list) {
        this.objects = list;
        return this;
    }

    public Attachment setProperties(Map<String, String> map) {
        this.properties = map;
        return this;
    }

    public Attachment setQuotaType(Integer num) {
        this.quotaType = num;
        return this;
    }

    public Attachment setSha256(String str) {
        this.sha256 = str;
        return this;
    }

    public Attachment setSliceSize(Long l10) {
        this.sliceSize = l10;
        return this;
    }

    public Attachment setState(Integer num) {
        this.state = num;
        return this;
    }

    public Attachment setType(Integer num) {
        this.type = num;
        return this;
    }

    public Attachment setUsage(String str) {
        this.usage = str;
        return this;
    }

    public Attachment setVersion(Integer num) {
        this.version = num;
        return this;
    }

    public Attachment setVersionId(String str) {
        this.versionId = str;
        return this;
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public Attachment set(String str, Object obj) {
        return (Attachment) super.set(str, obj);
    }
}
