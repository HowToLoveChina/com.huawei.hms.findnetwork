package com.huawei.hms.support.api.entity.location.offlinelocation;

import java.util.List;
import java.util.Map;

/* loaded from: classes8.dex */
public class OfflineLocationRequestData {
    private Map<String, Object> extras;
    private List<HwCellInfo> hwCellInfoList;
    private List<HwWifiInfo> hwWifiInfoList;
    private long locationTime;

    public Map<String, Object> getExtras() {
        return this.extras;
    }

    public List<HwCellInfo> getHwCellInfoList() {
        return this.hwCellInfoList;
    }

    public List<HwWifiInfo> getHwWifiInfoList() {
        return this.hwWifiInfoList;
    }

    public long getLocationTime() {
        return this.locationTime;
    }

    public void setExtras(Map<String, Object> map) {
        this.extras = map;
    }

    public void setHwCellInfoList(List<HwCellInfo> list) {
        this.hwCellInfoList = list;
    }

    public void setHwWifiInfoList(List<HwWifiInfo> list) {
        this.hwWifiInfoList = list;
    }

    public void setLocationTime(long j10) {
        this.locationTime = j10;
    }
}
