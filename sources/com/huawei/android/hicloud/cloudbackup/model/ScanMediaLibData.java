package com.huawei.android.hicloud.cloudbackup.model;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class ScanMediaLibData {
    boolean isScanMedia;
    List<Integer> mimeTypes;

    public List<Integer> getMimeType() {
        List<Integer> list = this.mimeTypes;
        return list == null ? new ArrayList() : list;
    }

    public boolean isScanMedia() {
        return this.isScanMedia;
    }

    public void setMimeType(List<Integer> list) {
        this.mimeTypes = list;
    }

    public void setScanMedia(boolean z10) {
        this.isScanMedia = z10;
    }
}
