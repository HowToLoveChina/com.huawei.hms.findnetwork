package com.huawei.android.hicloud.p081cs.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.request.opengw.bean.Objects;

/* loaded from: classes3.dex */
public class Properties {

    @SerializedName("dbank_s3_file")
    private Objects dbankS3File;

    @SerializedName("e_fek")
    private String eFek;

    @SerializedName("e_iv")
    private String eIv;

    @SerializedName("e_type")
    private int eType;
    private String name;

    public String getEFekFromProperties() {
        return this.eFek;
    }

    public String getEIv() {
        return this.eIv;
    }

    public int getEType() {
        return this.eType;
    }

    public String getName() {
        return this.name;
    }

    public Objects getObjects() {
        return this.dbankS3File;
    }

    public void setEFekFromProperties(String str) {
        this.eFek = str;
    }

    public void setEIv(String str) {
        this.eIv = str;
    }

    public void setEType(int i10) {
        this.eType = i10;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setObjects(Objects objects) {
        this.dbankS3File = objects;
    }
}
