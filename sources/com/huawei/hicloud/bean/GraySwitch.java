package com.huawei.hicloud.bean;

/* loaded from: classes6.dex */
public class GraySwitch {
    String functionId;
    String parameters;
    int status;

    public GraySwitch() {
        this.parameters = "";
    }

    public String getFunctionId() {
        return this.functionId;
    }

    public String getParameters() {
        return this.parameters;
    }

    public int getStatus() {
        return this.status;
    }

    public void setFunctionId(String str) {
        this.functionId = str;
    }

    public void setParameters(String str) {
        this.parameters = str;
    }

    public void setStatus(int i10) {
        this.status = i10;
    }

    public GraySwitch(String str, String str2, int i10) {
        this.functionId = str;
        this.parameters = str2;
        this.status = i10;
    }
}
