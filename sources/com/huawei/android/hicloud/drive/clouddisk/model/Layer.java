package com.huawei.android.hicloud.drive.clouddisk.model;

import com.huawei.cloud.base.util.C4644l;
import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.List;
import java.util.Map;
import ni.C11707b;

/* loaded from: classes3.dex */
public class Layer extends C11707b {

    @InterfaceC4648p
    private C4644l createdTime;

    /* renamed from: id */
    @InterfaceC4648p
    private String f12210id;

    /* renamed from: iv */
    @InterfaceC4648p
    private String f12211iv;

    @InterfaceC4648p
    private Long length;

    @InterfaceC4648p
    private C4644l modifiedTime;

    @InterfaceC4648p
    private List<SliceObject> objects;

    @InterfaceC4648p
    private Map<String, String> properties;

    @InterfaceC4648p
    private Integer seq;

    @InterfaceC4648p
    private String sha256;

    @InterfaceC4648p
    private Long sliceSize;

    @InterfaceC4648p
    private Integer state;

    @InterfaceC4648p
    private Integer type;

    public C4644l getCreatedTime() {
        return this.createdTime;
    }

    public String getId() {
        return this.f12210id;
    }

    public String getIv() {
        return this.f12211iv;
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

    public Integer getSeq() {
        return this.seq;
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

    public void setCreatedTime(C4644l c4644l) {
        this.createdTime = c4644l;
    }

    public void setId(String str) {
        this.f12210id = str;
    }

    public void setIv(String str) {
        this.f12211iv = str;
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

    public void setSeq(Integer num) {
        this.seq = num;
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
