package com.huawei.hms.findnetwork.comm.request.bean;

/* loaded from: classes8.dex */
public class SendHeartBeatRequestBean extends BaseRequestBean {
    private int businessId;
    private int[] businessIds;
    private String connectTagSn;
    private String extData;
    private boolean isStop;
    private String srcTranId;

    public SendHeartBeatRequestBean() {
    }

    public int getBusinessId() {
        return this.businessId;
    }

    public int[] getBusinessIds() {
        int[] iArr = this.businessIds;
        if (iArr == null) {
            return null;
        }
        return (int[]) iArr.clone();
    }

    public String getConnectTagSn() {
        return this.connectTagSn;
    }

    public String getExtData() {
        return this.extData;
    }

    @Override // com.huawei.hms.findnetwork.comm.request.bean.BaseRequestBean
    public String getSrcTranId() {
        return this.srcTranId;
    }

    public boolean isStop() {
        return this.isStop;
    }

    public void setBusinessId(int i10) {
        this.businessId = i10;
    }

    public void setBusinessIds(int[] iArr) {
        this.businessIds = iArr == null ? null : (int[]) iArr.clone();
    }

    public void setConnectTagSn(String str) {
        this.connectTagSn = str;
    }

    public void setExtData(String str) {
        this.extData = str;
    }

    @Override // com.huawei.hms.findnetwork.comm.request.bean.BaseRequestBean
    public void setSrcTranId(String str) {
        this.srcTranId = str;
    }

    public void setStop(boolean z10) {
        this.isStop = z10;
    }

    public SendHeartBeatRequestBean(String str, int i10) {
        this.connectTagSn = str;
        this.businessId = i10;
    }
}
