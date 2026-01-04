package com.huawei.hicloud.request.agreement.request;

import java.util.ArrayList;

/* loaded from: classes6.dex */
public class QueryProtocolOpenRegionsRsp extends BaseRsp {
    private long cacheSeconds;
    private ArrayList<String> regions;

    public long getCacheSeconds() {
        return this.cacheSeconds;
    }

    public ArrayList<String> getCountryList() {
        return this.regions;
    }

    public void setCacheSeconds(long j10) {
        this.cacheSeconds = j10;
    }

    public void setCountryList(ArrayList<String> arrayList) {
        this.regions = arrayList;
    }
}
