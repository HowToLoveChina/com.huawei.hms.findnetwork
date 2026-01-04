package com.huawei.hicloud.cloudbackup.p104v3.server.model;

import com.huawei.cloud.base.util.InterfaceC4648p;
import ni.C11707b;

/* loaded from: classes6.dex */
public class FileDelete extends C11707b {

    @InterfaceC4648p
    private String cloudPath;

    /* renamed from: id */
    @InterfaceC4648p
    private String f22594id;

    @InterfaceC4648p
    private String logs;

    public String getCloudPath() {
        return this.cloudPath;
    }

    public String getId() {
        return this.f22594id;
    }

    public String getLogs() {
        return this.logs;
    }

    public FileDelete setCloudPath(String str) {
        this.cloudPath = str;
        return this;
    }

    public FileDelete setId(String str) {
        this.f22594id = str;
        return this;
    }

    public void setLogs(String str) {
        this.logs = str;
    }

    @Override // ni.C11707b, com.huawei.cloud.base.util.C4646n
    public FileDelete set(String str, Object obj) {
        return (FileDelete) super.set(str, obj);
    }
}
