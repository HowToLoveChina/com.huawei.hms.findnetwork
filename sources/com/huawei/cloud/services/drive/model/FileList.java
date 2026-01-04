package com.huawei.cloud.services.drive.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.List;
import ni.C11707b;

/* loaded from: classes5.dex */
public final class FileList extends C11707b {

    @InterfaceC4648p
    private String category;

    @InterfaceC4648p
    private List<File> files;

    @InterfaceC4648p
    private String nextCursor;

    @InterfaceC4648p
    private Boolean searchCompleted;

    public String getCategory() {
        return this.category;
    }

    public List<File> getFiles() {
        return this.files;
    }

    public String getNextCursor() {
        return this.nextCursor;
    }

    public Boolean getSearchCompleted() {
        return this.searchCompleted;
    }

    public FileList setCategory(String str) {
        this.category = str;
        return this;
    }

    public FileList setFiles(List<File> list) {
        this.files = list;
        return this;
    }

    public FileList setNextCursor(String str) {
        this.nextCursor = str;
        return this;
    }

    public FileList setSearchCompleted(Boolean bool) {
        this.searchCompleted = bool;
        return this;
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public FileList set(String str, Object obj) {
        return (FileList) super.set(str, obj);
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n, java.util.AbstractMap
    public FileList clone() {
        return (FileList) super.clone();
    }
}
