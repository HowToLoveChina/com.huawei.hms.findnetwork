package com.huawei.hms.support.api.entity.safetydetect;

import com.huawei.hms.support.api.entity.safetydetect.base.BaseResp;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class WifiDetectResponse extends BaseResp {
    private int wifiDetectStatus;

    public WifiDetectResponse(String str) {
        this.wifiDetectStatus = new JSONObject(str).optInt("wifiDetectStatus");
    }

    public int getWifiDetectStatus() {
        return this.wifiDetectStatus;
    }

    public void setWifiDetectStatus(int i10) {
        this.wifiDetectStatus = i10;
    }
}
