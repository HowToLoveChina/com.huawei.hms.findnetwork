package com.huawei.hicloud.request.cbs.bean;

import gp.C10028c;

/* loaded from: classes6.dex */
public class CBSQueryAllDevicesBackupRecordReq extends CBSBaseReq {
    private boolean isContainInterim;
    private int isContainOH;
    private boolean isContainRefurbishment;
    private String version;

    public CBSQueryAllDevicesBackupRecordReq(int i10, String str, boolean z10, int i11) {
        super(i10, str);
        this.version = "V2";
        if (C10028c.m62182c0().m62335h1()) {
            this.version = CBSBaseReq.CURRENT_API_VERSION;
        }
        this.isContainRefurbishment = true;
        this.isContainInterim = z10;
        this.isContainOH = i11;
    }

    public String getVersion() {
        return this.version;
    }

    public int isContainOH() {
        return this.isContainOH;
    }

    public boolean isContainRefurbishment() {
        return this.isContainRefurbishment;
    }

    public void setContainOH(int i10) {
        this.isContainOH = i10;
    }

    public void setContainRefurbishment(boolean z10) {
        this.isContainRefurbishment = z10;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
