package com.huawei.cloud.services.drive.model;

import com.huawei.cloud.base.util.C4644l;
import com.huawei.cloud.base.util.InterfaceC4648p;
import ni.C11707b;

/* loaded from: classes5.dex */
public final class HistoryVersion extends C11707b {

    @InterfaceC4648p
    private String category;

    @InterfaceC4648p
    public C4644l editedTime;

    /* renamed from: id */
    @InterfaceC4648p
    private String f21491id;

    @InterfaceC4648p
    private Boolean keepPermanent;

    @InterfaceC4648p
    public User lastEditor;

    @InterfaceC4648p
    public String mimeType;

    @InterfaceC4648p
    public String originalFilename;

    @InterfaceC4648p
    public String sha256;

    @InterfaceC4648p
    public Long size;

    public String getCategory() {
        return this.category;
    }

    public C4644l getEditedTime() {
        return this.editedTime;
    }

    public String getId() {
        return this.f21491id;
    }

    public Boolean getKeepPermanent() {
        return this.keepPermanent;
    }

    public User getLastEditor() {
        return this.lastEditor;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public String getOriginalFilename() {
        return this.originalFilename;
    }

    public String getSha256() {
        return this.sha256;
    }

    public Long getSize() {
        return this.size;
    }

    public HistoryVersion setCategory(String str) {
        this.category = str;
        return this;
    }

    public HistoryVersion setEditedTime(C4644l c4644l) {
        this.editedTime = c4644l;
        return this;
    }

    public HistoryVersion setId(String str) {
        this.f21491id = str;
        return this;
    }

    public HistoryVersion setKeepPermanent(Boolean bool) {
        this.keepPermanent = bool;
        return this;
    }

    public HistoryVersion setLastEditor(User user) {
        this.lastEditor = user;
        return this;
    }

    public HistoryVersion setMimeType(String str) {
        this.mimeType = str;
        return this;
    }

    public HistoryVersion setOriginalFilename(String str) {
        this.originalFilename = str;
        return this;
    }

    public HistoryVersion setSha256(String str) {
        this.sha256 = str;
        return this;
    }

    public HistoryVersion setSize(Long l10) {
        this.size = l10;
        return this;
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public HistoryVersion set(String str, Object obj) {
        return (HistoryVersion) super.set(str, obj);
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n, java.util.AbstractMap
    public HistoryVersion clone() {
        return (HistoryVersion) super.clone();
    }
}
