package com.huawei.hicloud.notification.p106db.bean;

import java.util.List;

/* loaded from: classes6.dex */
public class IncentiveActivity {
    private long clientVersion;
    private List<String> entrance;
    private CommonLanguage language;
    private List<H5Resource> resorces;

    public long getClientVersion() {
        return this.clientVersion;
    }

    public List<String> getEntrance() {
        return this.entrance;
    }

    public CommonLanguage getLanguage() {
        return this.language;
    }

    public List<H5Resource> getResources() {
        return this.resorces;
    }

    public void setClientVersion(long j10) {
        this.clientVersion = j10;
    }

    public void setEntrance(List<String> list) {
        this.entrance = list;
    }

    public void setLanguage(CommonLanguage commonLanguage) {
        this.language = commonLanguage;
    }

    public void setResources(List<H5Resource> list) {
        this.resorces = list;
    }
}
