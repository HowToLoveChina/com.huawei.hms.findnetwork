package com.huawei.hicloud.bean;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class HonorVersionInfo {

    @SerializedName("info")
    private Info info;

    @SerializedName("romVersRegex")
    private String romVersRegex;

    @SerializedName("sha256")
    private String sha256;

    @SerializedName("url")
    private String url;

    @SerializedName("versionCode")
    private String versionCode;

    public static class Info {

        @SerializedName("detail")
        private String detail;

        @SerializedName("name")
        private String name;

        @SerializedName("size")
        private String size;

        @SerializedName("title")
        private String title;

        @SerializedName("ver")
        private String ver;

        public String getDetail() {
            return this.detail;
        }

        public String getName() {
            return this.name;
        }

        public String getSize() {
            return this.size;
        }

        public String getTitle() {
            return this.title;
        }

        public String getVer() {
            return this.ver;
        }

        public void setDetail(String str) {
            this.detail = str;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setSize(String str) {
            this.size = str;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public void setVer(String str) {
            this.ver = str;
        }
    }

    public Info getInfo() {
        return this.info;
    }

    public String getRomVersRegex() {
        return this.romVersRegex;
    }

    public String getSha256() {
        return this.sha256;
    }

    public String getUrl() {
        return this.url;
    }

    public String getVersionCode() {
        return this.versionCode;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public void setRomVersRegex(String str) {
        this.romVersRegex = str;
    }

    public void setSha256(String str) {
        this.sha256 = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setVersionCode(String str) {
        this.versionCode = str;
    }
}
