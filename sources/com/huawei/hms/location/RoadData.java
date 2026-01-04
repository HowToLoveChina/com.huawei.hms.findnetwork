package com.huawei.hms.location;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import java.util.Map;

/* loaded from: classes8.dex */
public class RoadData implements IMessageEntity {
    public static final int SERVICE_TYPE_RTK_LANE = 1;
    public static final int SERVICE_TYPE_VDR = 2;

    @Packed
    private String data;

    @Packed
    private Map<String, String> extras;

    @Packed
    private int serviceType;

    @Packed
    private String sourceType;

    public String getData() {
        return this.data;
    }

    public Map<String, String> getExtras() {
        return this.extras;
    }

    public int getServiceType() {
        return this.serviceType;
    }

    public String getSourceType() {
        return this.sourceType;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setExtras(Map<String, String> map) {
        this.extras = map;
    }

    public void setServiceType(int i10) {
        this.serviceType = i10;
    }

    public void setSourceType(String str) {
        this.sourceType = str;
    }
}
