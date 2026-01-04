package com.huawei.location.mdc;

import com.google.gson.annotations.SerializedName;
import com.huawei.location.lite.common.config.ConfigBaseResponse;

/* loaded from: classes8.dex */
public class AdsLocationConfig extends ConfigBaseResponse {

    @SerializedName("MdcEnable")
    private boolean mdcEnable = true;

    public boolean isMdcEnable() {
        return this.mdcEnable;
    }

    public void setMdcEnable(boolean z10) {
        this.mdcEnable = z10;
    }
}
