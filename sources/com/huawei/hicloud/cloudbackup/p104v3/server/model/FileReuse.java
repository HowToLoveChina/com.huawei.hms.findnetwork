package com.huawei.hicloud.cloudbackup.p104v3.server.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import ni.C11707b;

/* loaded from: classes6.dex */
public class FileReuse extends C11707b {

    @InterfaceC4648p
    private Long fileIdCreateTime;

    @InterfaceC4648p
    private Long fileIdTotalCount;

    @InterfaceC4648p
    private String fileIds;

    public Long getFileIdCreateTime() {
        return this.fileIdCreateTime;
    }

    public Long getFileIdTotalCount() {
        return this.fileIdTotalCount;
    }

    public String getFileIds() {
        return this.fileIds;
    }

    public FileReuse setFileIdCreateTime(Long l10) {
        this.fileIdCreateTime = l10;
        return this;
    }

    public FileReuse setFileIdTotalCount(Long l10) {
        this.fileIdTotalCount = l10;
        return this;
    }

    public FileReuse setFileIds(String str) {
        this.fileIds = str;
        return this;
    }
}
