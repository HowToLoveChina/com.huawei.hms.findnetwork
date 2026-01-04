package com.huawei.hicloud.request.basic.bean;

/* loaded from: classes6.dex */
public class VisionDeviceReq extends BasicBaseReq {
    private int clientType;
    private int deviceStatus;
    private String frameworkType;
    private int prodType;

    public VisionDeviceReq(int i10, int i11) {
        super("getUserVisionDeviceInfoReq");
        this.clientType = i10;
        this.prodType = i11;
    }

    public int getClientType() {
        return this.clientType;
    }

    public int getDeviceStatus() {
        return this.deviceStatus;
    }

    public String getFrameworkType() {
        return this.frameworkType;
    }

    public int getProdType() {
        return this.prodType;
    }

    public void setClientType(int i10) {
        this.clientType = i10;
    }

    public void setDeviceStatus(int i10) {
        this.deviceStatus = i10;
    }

    public void setFrameworkType(String str) {
        this.frameworkType = str;
    }

    public void setProdType(int i10) {
        this.prodType = i10;
    }

    public VisionDeviceReq(int i10, String str, int i11) {
        super("getUserVisionDeviceInfoReq");
        this.clientType = i10;
        this.frameworkType = str;
        this.deviceStatus = i11;
    }
}
