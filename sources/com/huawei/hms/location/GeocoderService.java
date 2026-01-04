package com.huawei.hms.location;

import android.app.Activity;
import android.content.Context;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.locationSdk.C5758u;
import com.huawei.hms.locationSdk.C5765w0;
import com.huawei.hms.locationSdk.InterfaceC5729k0;
import java.util.List;
import java.util.Locale;

/* loaded from: classes8.dex */
public class GeocoderService {
    private InterfaceC5729k0 locationClient;

    public GeocoderService(Activity activity, Locale locale) {
        this.locationClient = C5758u.m33170a(activity, locale, (C5765w0) null);
    }

    public Task<List<HWLocation>> getFromLocation(GetFromLocationRequest getFromLocationRequest) {
        return this.locationClient.mo33110a(getFromLocationRequest);
    }

    public Task<List<HWLocation>> getFromLocationName(GetFromLocationNameRequest getFromLocationNameRequest) {
        return this.locationClient.mo33109a(getFromLocationNameRequest);
    }

    public GeocoderService(Context context, Locale locale) {
        this.locationClient = C5758u.m33171a(context, locale, (C5765w0) null);
    }
}
