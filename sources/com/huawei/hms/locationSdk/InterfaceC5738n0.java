package com.huawei.hms.locationSdk;

import android.app.PendingIntent;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.location.GeofenceRequest;
import java.util.List;

/* renamed from: com.huawei.hms.locationSdk.n0 */
/* loaded from: classes8.dex */
public interface InterfaceC5738n0 {
    /* renamed from: a */
    Task<Void> mo33140a(PendingIntent pendingIntent);

    /* renamed from: a */
    Task<Void> mo33141a(GeofenceRequest geofenceRequest, PendingIntent pendingIntent);

    /* renamed from: a */
    Task<Void> mo33142a(List<String> list);
}
