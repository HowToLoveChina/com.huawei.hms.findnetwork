package com.huawei.hms.findnetwork.comm.request.bean;

import com.huawei.hms.findnetwork.comm.request.option.OfflineBroadcastParam;
import java.util.List;

/* loaded from: classes8.dex */
public class SetPublicKeysRequestBean extends BaseRequestBean {
    private String countryCode;
    private List<OfflineBroadcastParam> publicKeys;

    public SetPublicKeysRequestBean(List<OfflineBroadcastParam> list) {
        this.publicKeys = list;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public List<OfflineBroadcastParam> getPublicKeys() {
        return this.publicKeys;
    }

    public void setCountryCode(String str) {
        this.countryCode = str;
    }

    public void setPublicKeys(List<OfflineBroadcastParam> list) {
        this.publicKeys = list;
    }
}
