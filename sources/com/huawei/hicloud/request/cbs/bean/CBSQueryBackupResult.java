package com.huawei.hicloud.request.cbs.bean;

/* loaded from: classes6.dex */
public class CBSQueryBackupResult extends CBSBaseResp {
    private int count;
    private int failType;
    private int submitNum;

    public int getCount() {
        return this.count;
    }

    public int getFailType() {
        return this.failType;
    }

    @Override // com.huawei.hicloud.request.cbs.bean.CBSBaseResp
    public String getInfo() {
        return this.info;
    }

    @Override // com.huawei.hicloud.request.cbs.bean.CBSBaseResp
    public int getResult() {
        return this.result;
    }

    public int getSubmitNum() {
        return this.submitNum;
    }

    public void setCount(int i10) {
        this.count = i10;
    }

    public void setFailType(int i10) {
        this.failType = i10;
    }

    @Override // com.huawei.hicloud.request.cbs.bean.CBSBaseResp
    public void setInfo(String str) {
        this.info = str;
    }

    @Override // com.huawei.hicloud.request.cbs.bean.CBSBaseResp
    public void setResult(int i10) {
        this.result = i10;
    }

    public void setSubmitNum(int i10) {
        this.submitNum = i10;
    }
}
