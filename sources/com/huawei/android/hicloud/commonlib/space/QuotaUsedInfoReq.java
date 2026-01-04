package com.huawei.android.hicloud.commonlib.space;

import com.google.gson.Gson;

/* loaded from: classes3.dex */
public class QuotaUsedInfoReq {
    private String key;

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
