package com.huawei.hms.locationSdk;

import android.app.Notification;
import android.app.PendingIntent;
import android.location.Location;
import android.os.Looper;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.location.HWLocation;
import com.huawei.hms.location.LocationAvailability;
import com.huawei.hms.location.LocationCallback;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.location.LocationSettingsRequest;
import com.huawei.hms.location.LocationSettingsResponse;
import com.huawei.hms.location.LogConfig;
import com.huawei.hms.support.api.entity.location.offlinelocation.OfflineLocationRequest;
import com.huawei.hms.support.api.entity.location.offlinelocation.OfflineLocationResponse;

/* renamed from: com.huawei.hms.locationSdk.e0 */
/* loaded from: classes8.dex */
public interface InterfaceC5709e0 {
    /* renamed from: a */
    Task<LocationAvailability> mo33064a();

    /* renamed from: a */
    Task<Void> mo33065a(int i10, Notification notification);

    /* renamed from: a */
    Task<Void> mo33066a(PendingIntent pendingIntent);

    /* renamed from: a */
    Task<Void> mo33067a(Location location);

    /* renamed from: a */
    Task<Void> mo33068a(LocationCallback locationCallback);

    /* renamed from: a */
    Task<HWLocation> mo33069a(LocationRequest locationRequest);

    /* renamed from: a */
    Task<Void> mo33070a(LocationRequest locationRequest, PendingIntent pendingIntent);

    /* renamed from: a */
    Task<Void> mo33071a(LocationRequest locationRequest, LocationCallback locationCallback, Looper looper);

    /* renamed from: a */
    Task<LocationSettingsResponse> mo33072a(LocationSettingsRequest locationSettingsRequest);

    /* renamed from: a */
    Task<Void> mo33073a(LogConfig logConfig);

    /* renamed from: a */
    Task<OfflineLocationResponse> mo33074a(OfflineLocationRequest offlineLocationRequest);

    /* renamed from: a */
    Task<Void> mo33075a(boolean z10);

    /* renamed from: b */
    Task<Location> mo33076b();

    /* renamed from: b */
    Task<Void> mo33077b(LocationRequest locationRequest, LocationCallback locationCallback, Looper looper);

    /* renamed from: c */
    Task<Void> mo33078c();

    /* renamed from: d */
    Task<Void> mo33079d();
}
