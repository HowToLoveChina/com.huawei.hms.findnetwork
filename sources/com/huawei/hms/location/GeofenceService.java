package com.huawei.hms.location;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.locationSdk.C5758u;
import com.huawei.hms.locationSdk.C5765w0;
import com.huawei.hms.locationSdk.InterfaceC5738n0;
import java.util.List;

/* loaded from: classes8.dex */
public class GeofenceService {
    private InterfaceC5738n0 locationClient;

    public GeofenceService(Activity activity) {
        this.locationClient = C5758u.m33176d(activity, (C5765w0) null);
    }

    public Task<Void> createGeofenceList(GeofenceRequest geofenceRequest, PendingIntent pendingIntent) {
        return this.locationClient.mo33141a(geofenceRequest, pendingIntent);
    }

    public Task<Void> deleteGeofenceList(PendingIntent pendingIntent) {
        return this.locationClient.mo33140a(pendingIntent);
    }

    public GeofenceService(Context context) {
        this.locationClient = C5758u.m33177d(context, (C5765w0) null);
    }

    public Task<Void> deleteGeofenceList(List<String> list) {
        return this.locationClient.mo33142a(list);
    }
}
