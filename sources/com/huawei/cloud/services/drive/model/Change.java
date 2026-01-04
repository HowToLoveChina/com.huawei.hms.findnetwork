package com.huawei.cloud.services.drive.model;

import com.huawei.cloud.base.util.C4644l;
import com.huawei.cloud.base.util.InterfaceC4648p;
import ni.C11707b;

/* loaded from: classes5.dex */
public final class Change extends C11707b {

    @InterfaceC4648p
    private String category;

    @InterfaceC4648p
    private String changeType;

    @InterfaceC4648p
    private Boolean deleted;

    @InterfaceC4648p
    private File file;

    @InterfaceC4648p
    private String fileId;

    @InterfaceC4648p
    private C4644l time;

    public String getCategory() {
        return this.category;
    }

    public String getChangeType() {
        return this.changeType;
    }

    public Boolean getDeleted() {
        return this.deleted;
    }

    public File getFile() {
        return this.file;
    }

    public String getFileId() {
        return this.fileId;
    }

    public C4644l getTime() {
        return this.time;
    }

    public Change setCategory(String str) {
        this.category = str;
        return this;
    }

    public Change setChangeType(String str) {
        this.changeType = str;
        return this;
    }

    public Change setDeleted(Boolean bool) {
        this.deleted = bool;
        return this;
    }

    public Change setFile(File file) {
        this.file = file;
        return this;
    }

    public Change setFileId(String str) {
        this.fileId = str;
        return this;
    }

    public Change setTime(C4644l c4644l) {
        this.time = c4644l;
        return this;
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public Change set(String str, Object obj) {
        return (Change) super.set(str, obj);
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n, java.util.AbstractMap
    public Change clone() {
        return (Change) super.clone();
    }
}
