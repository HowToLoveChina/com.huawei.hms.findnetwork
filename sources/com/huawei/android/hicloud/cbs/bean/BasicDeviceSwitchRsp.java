package com.huawei.android.hicloud.cbs.bean;

import com.huawei.hicloud.request.cbs.bean.CBSBaseResp;
import java.util.List;

/* loaded from: classes2.dex */
public class BasicDeviceSwitchRsp extends CBSBaseResp {
    private List<BasicDeviceSwitchInfo> swStatusList;

    public List<BasicDeviceSwitchInfo> getSwStatusList() {
        return this.swStatusList;
    }

    public BasicDeviceSwitchInfo getSwitchInfo(String str) {
        String swName;
        for (BasicDeviceSwitchInfo basicDeviceSwitchInfo : this.swStatusList) {
            if (basicDeviceSwitchInfo != null && (swName = basicDeviceSwitchInfo.getSwName()) != null && swName.equals(str)) {
                return basicDeviceSwitchInfo;
            }
        }
        return null;
    }

    public void setSwStatusList(List<BasicDeviceSwitchInfo> list) {
        this.swStatusList = list;
    }
}
