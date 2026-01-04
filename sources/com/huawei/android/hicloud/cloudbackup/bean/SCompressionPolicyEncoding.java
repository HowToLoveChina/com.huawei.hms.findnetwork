package com.huawei.android.hicloud.cloudbackup.bean;

import java.util.List;

/* loaded from: classes2.dex */
public class SCompressionPolicyEncoding {
    private int compressionRate;
    private String encoding;
    private List<String> fileExtension;
    private int maxSize = 2048;
    private int minSize = 100;
    private int priority = 0;

    public int getCompressionRate() {
        return this.compressionRate;
    }

    public String getEncoding() {
        return this.encoding;
    }

    public List<String> getFileExtension() {
        return this.fileExtension;
    }

    public int getMaxSize() {
        return this.maxSize;
    }

    public int getMinSize() {
        return this.minSize;
    }

    public int getPriority() {
        return this.priority;
    }
}
