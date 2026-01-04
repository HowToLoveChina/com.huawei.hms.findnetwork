package com.huawei.android.remotecontrol.tag.bean;

import com.huawei.android.remotecontrol.http.BaseResponse;

/* loaded from: classes4.dex */
public class TagBindResponse extends BaseResponse {
    private int bindStatus;

    public TagBindResponse(int i10, String str) {
        super(i10, str);
        this.bindStatus = -1;
    }

    public int getBindStatus() {
        return this.bindStatus;
    }

    public void setBindStatus(int i10) {
        this.bindStatus = i10;
    }
}
