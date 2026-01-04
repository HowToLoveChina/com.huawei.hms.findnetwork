package com.huawei.hicloud.bean;

import com.google.gson.Gson;

/* loaded from: classes6.dex */
public class FileInfo {
    private String hash;
    private String url;

    public String getHash() {
        return this.hash;
    }

    public String getUrl() {
        return this.url;
    }

    public void setHash(String str) {
        this.hash = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
