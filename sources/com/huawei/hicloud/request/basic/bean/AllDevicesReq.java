package com.huawei.hicloud.request.basic.bean;

/* loaded from: classes6.dex */
public class AllDevicesReq extends BasicBaseReq {
    private int clientType;
    private int dataType;

    public AllDevicesReq(int i10) {
        super("GetUserDeviceInfoReq");
        this.dataType = i10;
    }

    public int getClientType() {
        return this.clientType;
    }

    public int getDataType() {
        return this.dataType;
    }

    public void setClientType(int i10) {
        this.clientType = i10;
    }

    public void setDataType(int i10) {
        this.dataType = i10;
    }
}
