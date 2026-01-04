package com.huawei.hicloud.request.opengw.bean;

/* loaded from: classes6.dex */
public class UploadCer {
    private String nsp_host;
    private String nsp_tapp;
    private int nsp_tstr;
    private String nsp_tver;
    private String secret;

    public UploadCer copy() {
        UploadCer uploadCer = new UploadCer();
        uploadCer.nsp_host = this.nsp_host;
        uploadCer.nsp_tapp = this.nsp_tapp;
        uploadCer.nsp_tstr = this.nsp_tstr;
        uploadCer.nsp_tver = this.nsp_tver;
        uploadCer.secret = this.secret;
        return uploadCer;
    }

    public String getNspHost() {
        return this.nsp_host;
    }

    public String getNspTapp() {
        return this.nsp_tapp;
    }

    public int getNspTstr() {
        return this.nsp_tstr;
    }

    public String getNspTver() {
        return this.nsp_tver;
    }

    public String getSecret() {
        return this.secret;
    }

    public void setNspHost(String str) {
        this.nsp_host = str;
    }

    public void setNspTapp(String str) {
        this.nsp_tapp = str;
    }

    public void setNspTstr(int i10) {
        this.nsp_tstr = i10;
    }

    public void setNspTver(String str) {
        this.nsp_tver = str;
    }

    public void setSecret(String str) {
        this.secret = str;
    }
}
