package com.huawei.hicloud.bean;

/* loaded from: classes6.dex */
public class GetSingleLatestConfigReq extends GeneralConfigBaseReq {
    private Client client;
    private String etag;

    public Client getClient() {
        return this.client;
    }

    public String getEtag() {
        return this.etag;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setEtag(String str) {
        this.etag = str;
    }
}
