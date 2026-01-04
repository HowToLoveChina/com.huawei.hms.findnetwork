package com.huawei.location.nlp.network.request.wifi;

import com.huawei.location.nlp.network.request.BaseExtraInfo;
import java.util.List;

/* loaded from: classes8.dex */
public class WifiExtraInfo extends BaseExtraInfo {
    private List<Integer> macDetails;

    public List<Integer> getMacDetails() {
        return this.macDetails;
    }

    public void setMacDetails(List<Integer> list) {
        this.macDetails = list;
    }
}
