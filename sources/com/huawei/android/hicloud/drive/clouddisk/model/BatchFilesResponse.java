package com.huawei.android.hicloud.drive.clouddisk.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import com.huawei.cloud.services.drive.model.File;
import java.util.List;
import ni.C11707b;

/* loaded from: classes3.dex */
public class BatchFilesResponse extends C11707b {

    @InterfaceC4648p
    private List<FailFile> failedFiles;

    @InterfaceC4648p
    private List<File> files;

    public List<FailFile> getFailedFiles() {
        return this.failedFiles;
    }

    public List<File> getFiles() {
        return this.files;
    }

    public void setFailedFiles(List<FailFile> list) {
        this.failedFiles = list;
    }

    public void setFiles(List<File> list) {
        this.files = list;
    }
}
