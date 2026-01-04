package com.huawei.android.remotecontrol.offlinelocate.bean;

import com.huawei.android.remotecontrol.http.BaseResponse;

/* loaded from: classes4.dex */
public class OfflineLocateResponse extends BaseResponse {
    private String cmacKey;

    public OfflineLocateResponse(int i10, String str) {
        super(i10, str);
    }

    public String getCmacKey() {
        return this.cmacKey;
    }

    public void setCmacKey(String str) {
        this.cmacKey = str;
    }
}
