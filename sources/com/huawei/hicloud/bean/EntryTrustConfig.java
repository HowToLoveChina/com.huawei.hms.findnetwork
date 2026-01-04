package com.huawei.hicloud.bean;

import java.util.List;

/* loaded from: classes6.dex */
public class EntryTrustConfig {
    private List<EntryPackageInfo> entryTrusts;
    private String version;

    public List<EntryPackageInfo> getEntryTrusts() {
        return this.entryTrusts;
    }

    public String getVersion() {
        return this.version;
    }

    public void setEntryTrusts(List<EntryPackageInfo> list) {
        this.entryTrusts = list;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
