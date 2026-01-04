package com.huawei.hicloud.bean;

import androidx.annotation.Keep;

@Keep
/* loaded from: classes6.dex */
public class FeatureGray {
    String functionId;
    String parameters;
    int status;

    public FeatureGray(String str, int i10) {
        this.functionId = str;
        this.parameters = "";
        this.status = i10;
    }

    public String getFunctionId() {
        return this.functionId;
    }

    public int getStatus() {
        return this.status;
    }

    public void setFunctionId(String str) {
        this.functionId = str;
    }

    public void setStatus(int i10) {
        this.status = i10;
    }

    public FeatureGray(String str, String str2, int i10) {
        this.functionId = str;
        this.parameters = str2;
        this.status = i10;
    }
}
