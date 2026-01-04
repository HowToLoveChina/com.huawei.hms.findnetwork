package com.huawei.android.hicloud.cbs.bean;

import com.huawei.hicloud.request.cbs.bean.CBSBaseResp;
import java.util.Map;

/* loaded from: classes2.dex */
public class PersonalizedMarketingSwitchRsp extends CBSBaseResp {
    private Map<String, String> properties;

    public Map<String, String> getProperties() {
        return this.properties;
    }

    public String getSwitchInfo(String str) {
        return this.properties.get(str);
    }

    public void setProperties(Map<String, String> map) {
        this.properties = map;
    }
}
