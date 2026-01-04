package com.huawei.hicloud.request.basic.bean;

import java.util.List;

/* loaded from: classes6.dex */
public class BasicDevConfInitReq extends BasicBaseReq {
    private List<AgrInfo> agrInfo;
    private String clientCap;
    private String newUser;
    private boolean termIsAgreed;

    public BasicDevConfInitReq(String str) {
        super(str);
        this.newUser = "1";
    }

    public List<AgrInfo> getAgrInfo() {
        return this.agrInfo;
    }

    public String getClientCap() {
        return this.clientCap;
    }

    public boolean isTermIsAgreed() {
        return this.termIsAgreed;
    }

    public void setAgrInfo(List<AgrInfo> list) {
        this.agrInfo = list;
    }

    public void setClientCap(String str) {
        this.clientCap = str;
    }

    public void setTermIsAgreed(boolean z10) {
        this.termIsAgreed = z10;
    }
}
