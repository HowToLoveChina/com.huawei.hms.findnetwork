package com.huawei.hwcloudjs.service.jsapi.network;

import com.huawei.hwcloudjs.annotation.JSField;
import com.huawei.hwcloudjs.annotation.JSNativeMsg;
import com.huawei.hwcloudjs.service.jsmsg.NativeMsg;
import com.huawei.hwcloudjs.support.enables.NoProguard;

@JSNativeMsg(isOpen = true, type = "onNetworkStatusChange")
@NoProguard
/* loaded from: classes8.dex */
public class NetworkChangeMsg extends NativeMsg {

    @JSField("networkType")
    private String networkType;

    public String getNetworkType() {
        return this.networkType;
    }

    public void setNetworkType(String str) {
        this.networkType = str;
    }
}
