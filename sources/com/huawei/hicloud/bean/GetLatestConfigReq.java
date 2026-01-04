package com.huawei.hicloud.bean;

/* loaded from: classes6.dex */
public class GetLatestConfigReq extends GeneralConfigBaseReq {
    private Client client;
    private Keys[] keys;

    public Client getClient() {
        return this.client;
    }

    public Keys[] getKeys() {
        return this.keys;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setKeys(Keys[] keysArr) {
        this.keys = keysArr;
    }
}
