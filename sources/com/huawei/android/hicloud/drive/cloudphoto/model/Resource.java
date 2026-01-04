package com.huawei.android.hicloud.drive.cloudphoto.model;

import com.huawei.cloud.base.util.C4644l;
import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.List;
import java.util.Map;
import ni.C11707b;

/* loaded from: classes3.dex */
public class Resource extends C11707b {

    @InterfaceC4648p
    private MediaAssetAttribute attributes;

    @InterfaceC4648p
    private Long compressedSize;

    @InterfaceC4648p
    private C4644l createdTime;

    @InterfaceC4648p
    private EndpointUrl downloadUrl;

    @InterfaceC4648p
    private String encoding;

    @InterfaceC4648p
    private String hash;

    /* renamed from: id */
    @InterfaceC4648p
    private String f12223id;

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

    public MediaAssetAttribute getAttributes() {
        return this.attributes;
    }

    public Long getCompressedSize() {
        return this.compressedSize;
    }

    public C4644l getCreatedTime() {
        return this.createdTime;
    }

    public EndpointUrl getDownloadUrl() {
        return this.downloadUrl;
    }

    public String getEncoding() {
        return this.encoding;
    }

    public String getHash() {
        return this.hash;
    }

    public String getId() {
        return this.f12223id;
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

    public void setAttributes(MediaAssetAttribute mediaAssetAttribute) {
        this.attributes = mediaAssetAttribute;
    }

    public void setCompressedSize(Long l10) {
        this.compressedSize = l10;
    }

    public void setCreatedTime(C4644l c4644l) {
        this.createdTime = c4644l;
    }

    public void setDownloadUrl(EndpointUrl endpointUrl) {
        this.downloadUrl = endpointUrl;
    }

    public void setEncoding(String str) {
        this.encoding = str;
    }

    public void setHash(String str) {
        this.hash = str;
    }

    public void setId(String str) {
        this.f12223id = str;
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
