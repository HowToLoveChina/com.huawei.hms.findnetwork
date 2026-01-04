package com.huawei.hicloud.cloudbackup.p104v3.server.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import java.util.List;
import ni.C11707b;

/* loaded from: classes6.dex */
public class FileList extends C11707b {

    @InterfaceC4648p
    private List<File> files;

    @InterfaceC4648p
    private String nextCursor;

    public List<File> getFiles() {
        return this.files;
    }

    public String getNextCursor() {
        return this.nextCursor;
    }

    public FileList setFiles(List<File> list) {
        this.files = list;
        return this;
    }

    public FileList setNextCursor(String str) {
        this.nextCursor = str;
        return this;
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public FileList set(String str, Object obj) {
        return (FileList) super.set(str, obj);
    }
}
