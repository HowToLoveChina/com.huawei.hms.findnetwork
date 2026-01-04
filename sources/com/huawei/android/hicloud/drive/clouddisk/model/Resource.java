package com.huawei.android.hicloud.drive.clouddisk.model;

import com.huawei.cloud.base.util.C4644l;
import com.huawei.cloud.base.util.InterfaceC4648p;
import com.huawei.hicloud.base.drive.model.EndpointUrl;
import com.huawei.secure.android.common.util.SafeBase64;
import java.util.List;
import java.util.Map;
import ni.C11707b;

/* loaded from: classes3.dex */
public class Resource extends C11707b {

    @InterfaceC4648p
    private Map<String, Object> attributes;

    @InterfaceC4648p
    private C4644l createdTime;

    @InterfaceC4648p
    private String digest;

    @InterfaceC4648p
    private EndpointUrl downloadUrl;

    @InterfaceC4648p
    private String hash;

    /* renamed from: id */
    @InterfaceC4648p
    private String f12212id;

    @InterfaceC4648p
    private List<Layer> layers;

    @InterfaceC4648p
    private Long length;

    @InterfaceC4648p
    private C4644l modifiedTime;

    @InterfaceC4648p
    private List<SliceObject> objects;

    @InterfaceC4648p
    private Map<String, String> properties;

    @InterfaceC4648p
    private String sha256;

    @InterfaceC4648p
    private Long sliceSize;

    @InterfaceC4648p
    private Integer state;

    @InterfaceC4648p
    private Integer type;

    public Map<String, Object> getAttributes() {
        return this.attributes;
    }

    public C4644l getCreatedTime() {
        return this.createdTime;
    }

    public byte[] getDigest() {
        return SafeBase64.decode(this.digest, 2);
    }

    public String getDigestStr() {
        return this.digest;
    }

    public EndpointUrl getDownloadUrl() {
        return this.downloadUrl;
    }

    public String getHash() {
        return this.hash;
    }

    public String getId() {
        return this.f12212id;
    }

    public List<Layer> getLayers() {
        return this.layers;
    }

    public Long getLength() {
        return this.length;
    }

    public C4644l getModifiedTime() {
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

    public Long getSliceSize() {
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

    public void setCreatedTime(C4644l c4644l) {
        this.createdTime = c4644l;
    }

    public void setDigest(byte[] bArr) {
        this.digest = SafeBase64.encodeToString(bArr, 2);
    }

    public void setDownloadUrl(EndpointUrl endpointUrl) {
        this.downloadUrl = endpointUrl;
    }

    public void setHash(String str) {
        this.hash = str;
    }

    public void setId(String str) {
        this.f12212id = str;
    }

    public void setLayers(List<Layer> list) {
        this.layers = list;
    }

    public void setLength(Long l10) {
        this.length = l10;
    }

    public void setModifiedTime(C4644l c4644l) {
        this.modifiedTime = c4644l;
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

    public void setSliceSize(Long l10) {
        this.sliceSize = l10;
    }

    public void setState(Integer num) {
        this.state = num;
    }

    public void setType(Integer num) {
        this.type = num;
    }
}
