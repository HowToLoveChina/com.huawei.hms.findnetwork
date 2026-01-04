package com.huawei.location.router;

import android.content.Context;
import com.huawei.location.router.dispatch.DispatchTaskManager;
import com.huawei.location.router.entity.IRouterResponse;
import com.huawei.location.router.entity.RouterRequest;
import java.util.HashMap;
import p531or.C11991a;

/* loaded from: classes8.dex */
public class RouterTaskHandler {
    private HashMap<String, String> apiRequestMap;

    /* renamed from: com.huawei.location.router.RouterTaskHandler$a */
    public static class C6806a {

        /* renamed from: a */
        public static final RouterTaskHandler f31397a = new RouterTaskHandler();
    }

    private RouterTaskHandler() {
    }

    public static RouterTaskHandler getInstance() {
        return C6806a.f31397a;
    }

    private void initTaskCall() {
        if (this.apiRequestMap == null) {
            this.apiRequestMap = new HashMap<>();
        }
        this.apiRequestMap.put("location.requestLocationUpdates", "com.huawei.location.RequestLocationUpdatesTaskCall");
        this.apiRequestMap.put("location.removeLocationUpdates", "com.huawei.location.RemoveUpdateTaskCall");
        this.apiRequestMap.put("location.requestLocationUpdatesEx", "com.huawei.location.RequestUpdatesExTaskCall");
        this.apiRequestMap.put("location.getLastLocation", "com.huawei.location.GetLastLocationTaskCall");
        this.apiRequestMap.put("location.getLocationAvailability", "com.huawei.location.GetAvailabilityTaskCall");
        this.apiRequestMap.put("location.checkLocationSettings", "com.huawei.location.CheckSettingsTaskCall");
        this.apiRequestMap.put("location.enableBackgroundLocation", "com.huawei.location.EnableGroundTaskCall");
        this.apiRequestMap.put("location.disableBackgroundLocation", "com.huawei.location.DisableGroundTaskCall");
        this.apiRequestMap.put("location.requestActivityIdentificationUpdates", "com.huawei.location.activity.RequestActivityIdentificationUpdatesTaskCall");
        this.apiRequestMap.put("location.removeActivityIdentificationUpdates", "com.huawei.location.activity.RemoveActivityIdentificationUpdatesTaskCall");
        this.apiRequestMap.put("location.requestActivityConversionUpdates", "com.huawei.location.activity.RequestActivityConversionUpdatesTaskCall");
        this.apiRequestMap.put("location.removeActivityConversionUpdates", "com.huawei.location.activity.RemoveActivityConversionUpdatesTaskCall");
        this.apiRequestMap.put(LocationNaming.REQUEST_ADAPTER_SDM, "com.huawei.location.activity.RequestAdapterSDMTaskCall");
    }

    public <T extends RouterRequest> void enqueue(T t10) {
        if (t10 == null) {
            return;
        }
        DispatchTaskManager.getInstance().dispatchTask(t10);
    }

    public <T extends RouterRequest> IRouterResponse execute(T t10) {
        if (t10 == null) {
            return null;
        }
        return DispatchTaskManager.getInstance().executeTask(t10);
    }

    public HashMap<String, String> getApiRequestMap() {
        return this.apiRequestMap;
    }

    public void initTaskCall(Context context) {
        C11991a.m72147c(context);
        initTaskCall();
    }
}
