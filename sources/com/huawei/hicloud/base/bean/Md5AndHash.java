package com.huawei.hicloud.base.bean;

import com.google.gson.Gson;

/* loaded from: classes6.dex */
public class Md5AndHash {
    private String hash;
    private String md5;

    public Md5AndHash(String str, String str2) {
        this.md5 = str;
        this.hash = str2;
    }

    public String getHash() {
        return this.hash;
    }

    public String getMD5() {
        return this.md5;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
