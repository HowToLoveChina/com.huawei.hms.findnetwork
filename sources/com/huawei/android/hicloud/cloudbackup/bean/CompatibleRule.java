package com.huawei.android.hicloud.cloudbackup.bean;

import java.util.List;

/* loaded from: classes2.dex */
public class CompatibleRule {
    String clientVer = "";
    List<String> compatibleVers;

    public String getClientVer() {
        return this.clientVer;
    }

    public List<String> getCompatibleVers() {
        return this.compatibleVers;
    }

    public void setClientVer(String str) {
        this.clientVer = str;
    }

    public void setCompatibleVers(List<String> list) {
        this.compatibleVers = list;
    }

    public String toString() {
        return "CompatibleRule{clientVer='" + this.clientVer + "', compatibleVers=" + this.compatibleVers + '}';
    }
}
