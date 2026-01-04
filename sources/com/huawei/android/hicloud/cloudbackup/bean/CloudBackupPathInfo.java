package com.huawei.android.hicloud.cloudbackup.bean;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class CloudBackupPathInfo {
    private List<String> fileSuffix;
    private List<Integer> mimeTypes;
    private List<String> paths;

    public List<String> getFileSuffix() {
        List<String> list = this.fileSuffix;
        return list == null ? new ArrayList() : list;
    }

    public List<Integer> getMimeTypes() {
        List<Integer> list = this.mimeTypes;
        return list == null ? new ArrayList() : list;
    }

    public List<String> getPaths() {
        List<String> list = this.paths;
        return list == null ? new ArrayList() : list;
    }

    public void setFileSuffix(List<String> list) {
        this.fileSuffix = list;
    }

    public void setMimeTypes(List<Integer> list) {
        this.mimeTypes = list;
    }

    public void setPaths(List<String> list) {
        this.paths = list;
    }
}
