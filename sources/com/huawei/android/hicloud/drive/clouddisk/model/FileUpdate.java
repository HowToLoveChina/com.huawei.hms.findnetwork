package com.huawei.android.hicloud.drive.clouddisk.model;

import com.google.gson.Gson;
import com.huawei.cloud.base.util.C4644l;
import com.huawei.cloud.base.util.InterfaceC4648p;
import ni.C11707b;

/* loaded from: classes3.dex */
public class FileUpdate extends C11707b {

    @InterfaceC4648p
    private Long baseVersion;

    @InterfaceC4648p
    private String description;

    @InterfaceC4648p
    private C4644l editTime;

    /* renamed from: id */
    @InterfaceC4648p
    private String f12209id;

    @InterfaceC4648p
    private String parentFolder;

    @InterfaceC4648p
    private boolean recycled;

    @InterfaceC4648p
    private C4644l recycledTime;

    public Long getBaseVersion() {
        return this.baseVersion;
    }

    public String getDescription() {
        return this.description;
    }

    public C4644l getEditTime() {
        return this.editTime;
    }

    public String getId() {
        return this.f12209id;
    }

    public String getParentFolder() {
        return this.parentFolder;
    }

    public C4644l getRecycledTime() {
        return this.recycledTime;
    }

    public boolean isRecycled() {
        return this.recycled;
    }

    public void setBaseVersion(Long l10) {
        this.baseVersion = l10;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setEditTime(C4644l c4644l) {
        this.editTime = c4644l;
    }

    public void setId(String str) {
        this.f12209id = str;
    }

    public void setParentFolder(String str) {
        this.parentFolder = str;
    }

    public void setRecycled(boolean z10) {
        this.recycled = z10;
    }

    public void setRecycledTime(C4644l c4644l) {
        this.recycledTime = c4644l;
    }

    @Override // ni.C11707b, java.util.AbstractMap
    public String toString() {
        return new Gson().toJson(this);
    }
}
