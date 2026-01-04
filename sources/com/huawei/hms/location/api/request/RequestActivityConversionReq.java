package com.huawei.hms.location.api.request;

import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.location.ActivityConversionInfo;
import java.util.List;

/* loaded from: classes8.dex */
public class RequestActivityConversionReq extends BaseLocationReq {

    @Packed
    private List<ActivityConversionInfo> activityConversions;

    @Packed
    private String moduleName;

    public List<ActivityConversionInfo> getActivityConversions() {
        return this.activityConversions;
    }

    public String getModuleName() {
        return this.moduleName;
    }

    public void setActivityConversions(List<ActivityConversionInfo> list) {
        this.activityConversions = list;
    }

    public void setModuleName(String str) {
        this.moduleName = str;
    }
}
