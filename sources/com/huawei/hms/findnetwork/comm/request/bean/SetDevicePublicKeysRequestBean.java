package com.huawei.hms.findnetwork.comm.request.bean;

import com.huawei.hms.findnetwork.comm.request.option.OfflineBroadcastParam;
import java.util.List;
import java.util.Map;

/* loaded from: classes8.dex */
public class SetDevicePublicKeysRequestBean extends BaseRequestBean {
    private Map<String, List<OfflineBroadcastParam>> offlineKeysMap;

    public SetDevicePublicKeysRequestBean(Map<String, List<OfflineBroadcastParam>> map) {
        this.offlineKeysMap = map;
    }

    public Map<String, List<OfflineBroadcastParam>> getPublicKeysMap() {
        return this.offlineKeysMap;
    }

    public void setPublicKeysMap(Map<String, List<OfflineBroadcastParam>> map) {
        this.offlineKeysMap = map;
    }
}
