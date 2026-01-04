package com.huawei.android.hicloud.cloudbackup.bean;

/* loaded from: classes2.dex */
public class Language {
    private String hash;
    private String url;
    private long version;

    public String getHash() {
        String str = this.hash;
        return str == null ? "" : str;
    }

    public String getUrl() {
        String str = this.url;
        return str == null ? "" : str;
    }

    public long getVersion() {
        return this.version;
    }

    public void setHash(String str) {
        this.hash = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setVersion(long j10) {
        this.version = j10;
    }
}
