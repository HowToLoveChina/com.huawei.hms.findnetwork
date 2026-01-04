package com.huawei.hicloud.notification.p106db.bean;

import java.util.List;

/* loaded from: classes6.dex */
public class HiCloudParamMetaBean {
    private String date;

    /* renamed from: id */
    private String f22648id;
    private List<MetaListBean> metalist;
    private List<ProvidersBean> providers;
    private long version;

    public String getDate() {
        return this.date;
    }

    public String getId() {
        return this.f22648id;
    }

    public List<MetaListBean> getMetalist() {
        return this.metalist;
    }

    public List<ProvidersBean> getProviders() {
        return this.providers;
    }

    public long getVersion() {
        return this.version;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setId(String str) {
        this.f22648id = str;
    }

    public void setMetalist(List<MetaListBean> list) {
        this.metalist = list;
    }

    public void setProviders(List<ProvidersBean> list) {
        this.providers = list;
    }

    public void setVersion(long j10) {
        this.version = j10;
    }
}
