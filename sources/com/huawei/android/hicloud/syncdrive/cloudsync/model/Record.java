package com.huawei.android.hicloud.syncdrive.cloudsync.model;

import com.huawei.cloud.base.util.C4644l;
import com.huawei.cloud.base.util.InterfaceC4648p;
import com.huawei.hicloud.base.drive.model.Cipher;
import java.util.List;
import java.util.Map;
import ni.C11707b;

/* loaded from: classes3.dex */
public class Record extends C11707b {

    @InterfaceC4648p
    private Map<String, Object> appProperties;

    @InterfaceC4648p
    private List<Attachment> attachments;

    @InterfaceC4648p
    private Integer attachmentsAddCount;

    @InterfaceC4648p
    private Integer attachmentsDeleteCount;

    @InterfaceC4648p
    private Integer attachmentsUpdateCount;

    @InterfaceC4648p
    private Map<String, Object> attributes;

    @InterfaceC4648p
    private Cipher cipher;

    @InterfaceC4648p
    private C4644l createdTime;

    @InterfaceC4648p
    private C4644l editedTime;

    /* renamed from: id */
    @InterfaceC4648p
    private String f13035id;

    @InterfaceC4648p
    private String kind;

    @InterfaceC4648p
    private String mode;

    @InterfaceC4648p
    private Boolean recycled;

    @InterfaceC4648p
    private C4644l recycledTime;

    @InterfaceC4648p
    private Integer status;

    @InterfaceC4648p
    private Long version;

    public Map<String, Object> getAppProperties() {
        return this.appProperties;
    }

    public List<Attachment> getAttachments() {
        return this.attachments;
    }

    public Integer getAttachmentsAddCount() {
        return this.attachmentsAddCount;
    }

    public Integer getAttachmentsDeleteCount() {
        return this.attachmentsDeleteCount;
    }

    public Integer getAttachmentsUpdateCount() {
        return this.attachmentsUpdateCount;
    }

    public Map<String, Object> getAttributes() {
        return this.attributes;
    }

    public Cipher getCipher() {
        return this.cipher;
    }

    public C4644l getCreatedTime() {
        return this.createdTime;
    }

    public C4644l getEditedTime() {
        return this.editedTime;
    }

    public String getId() {
        return this.f13035id;
    }

    public String getKind() {
        return this.kind;
    }

    public String getMode() {
        return this.mode;
    }

    public Boolean getRecycled() {
        return this.recycled;
    }

    public C4644l getRecycledTime() {
        return this.recycledTime;
    }

    public Integer getStatus() {
        return this.status;
    }

    public Long getVersion() {
        return this.version;
    }

    public void setAppProperties(Map<String, Object> map) {
        this.appProperties = map;
    }

    public void setAttachments(List<Attachment> list) {
        this.attachments = list;
    }

    public void setAttachmentsAddCount(Integer num) {
        this.attachmentsAddCount = num;
    }

    public void setAttachmentsDeleteCount(Integer num) {
        this.attachmentsDeleteCount = num;
    }

    public void setAttachmentsUpdateCount(Integer num) {
        this.attachmentsUpdateCount = num;
    }

    public void setAttributes(Map<String, Object> map) {
        this.attributes = map;
    }

    public void setCipher(Cipher cipher) {
        this.cipher = cipher;
    }

    public void setCreatedTime(C4644l c4644l) {
        this.createdTime = c4644l;
    }

    public void setEditedTime(C4644l c4644l) {
        this.editedTime = c4644l;
    }

    public void setId(String str) {
        this.f13035id = str;
    }

    public void setKind(String str) {
        this.kind = str;
    }

    public void setMode(String str) {
        this.mode = str;
    }

    public void setRecycled(Boolean bool) {
        this.recycled = bool;
    }

    public void setRecycledTime(C4644l c4644l) {
        this.recycledTime = c4644l;
    }

    public void setStatus(Integer num) {
        this.status = num;
    }

    public void setVersion(Long l10) {
        this.version = l10;
    }

    @Override // ni.C11707b, java.util.AbstractMap
    public String toString() {
        return "Record{kind='" + this.kind + "', id='" + this.f13035id + "', version=" + this.version + ", recycled=" + this.recycled + ", status=" + this.status + ", attributes=" + this.attributes + ", attachments=" + this.attachments + '}';
    }
}
