package com.huawei.hms.location;

import android.app.Activity;
import android.content.Context;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.locationSdk.C5758u;
import com.huawei.hms.locationSdk.C5765w0;
import com.huawei.hms.locationSdk.InterfaceC5709e0;

/* loaded from: classes8.dex */
public class SettingsClient {
    private InterfaceC5709e0 locationClient;
    private Activity mActivity;
    private Context mContext;

    public SettingsClient(Activity activity) {
        this.mActivity = activity;
        this.locationClient = C5758u.m33172b(activity, (C5765w0) null);
    }

    public Task<LocationSettingsResponse> checkLocationSettings(LocationSettingsRequest locationSettingsRequest) {
        return this.locationClient.mo33072a(locationSettingsRequest);
    }

    public Task<Void> setLogConfig(LogConfig logConfig) {
        return this.locationClient.mo33073a(logConfig);
    }

    public SettingsClient(Context context) {
        this.mContext = context;
        this.locationClient = C5758u.m33173b(context, (C5765w0) null);
    }
}
