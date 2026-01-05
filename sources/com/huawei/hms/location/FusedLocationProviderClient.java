package com.huawei.hms.location;

import android.app.Activity;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.locationSdk.C5758u;
import com.huawei.hms.locationSdk.C5765w0;
import com.huawei.hms.locationSdk.InterfaceC5709e0;
import com.huawei.hms.support.api.entity.location.offlinelocation.OfflineLocationRequest;
import com.huawei.hms.support.api.entity.location.offlinelocation.OfflineLocationResponse;
import com.huawei.hms.support.api.location.common.LocationClientStateManager;

/* loaded from: classes8.dex */
public class FusedLocationProviderClient {
    public static final String KEY_MOCK_LOCATION = "mockLocation";
    public static final String KEY_VERTICAL_ACCURACY = "verticalAccuracy";
    private static final String TAG = "FusedLocationProviderClient";
    private InterfaceC5709e0 locationClient;
    private final Context mContext;

    public FusedLocationProviderClient(Activity activity) {
        this.mContext = activity.getApplicationContext();
        this.locationClient = C5758u.m33172b(activity, (C5765w0) null);
    }

    public Task<Void> disableBackgroundLocation() {
        return this.locationClient.mo33079d();
    }

    public Task<Void> enableBackgroundLocation(int i10, Notification notification) {
        return this.locationClient.enableBackgroundLocation(i10, notification);
    }

    public Task<Void> flushLocations() {
        LocationClientStateManager.getInstance().resetCache();
        return this.locationClient.mo33078c();
    }

    public Task<Location> getLastLocation() {
        LocationClientStateManager.getInstance().resetCache();
        return this.locationClient.mo33076b();
    }

    public Task<HWLocation> getLastLocationWithAddress(LocationRequest locationRequest) {
        LocationClientStateManager.getInstance().resetCache();
        return this.locationClient.mo33069a(locationRequest);
    }

    public Task<LocationAvailability> getLocationAvailability() {
        LocationClientStateManager.getInstance().resetCache();
        return this.locationClient.mo33064a();
    }

    public Task<OfflineLocationResponse> getOfflineLocation(OfflineLocationRequest offlineLocationRequest) {
        LocationClientStateManager.getInstance().resetCache();
        return this.locationClient.mo33074a(offlineLocationRequest);
    }

    public Task<Void> removeLocationUpdates(PendingIntent pendingIntent) {
        LocationClientStateManager.getInstance().resetCache();
        return this.locationClient.mo33066a(pendingIntent);
    }

    public Task<Void> requestLocationUpdates(LocationRequest locationRequest, PendingIntent pendingIntent) {
        LocationClientStateManager.getInstance().resetCache();
        return this.locationClient.mo33070a(locationRequest, pendingIntent);
    }

    public Task<Void> requestLocationUpdatesEx(LocationRequest locationRequest, LocationCallback locationCallback, Looper looper) {
        LocationClientStateManager.getInstance().resetCache();
        return this.locationClient.mo33077b(locationRequest, locationCallback, looper);
    }

    public Task<Void> setMockLocation(Location location) {
        LocationClientStateManager.getInstance().resetCache();
        return this.locationClient.mo33067a(location);
    }

    public Task<Void> setMockMode(boolean z10) {
        LocationClientStateManager.getInstance().resetCache();
        return this.locationClient.mo33075a(z10);
    }

    public FusedLocationProviderClient(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        this.locationClient = C5758u.m33173b(applicationContext, (C5765w0) null);
    }

    public Task<Void> removeLocationUpdates(LocationCallback locationCallback) {
        LocationClientStateManager.getInstance().resetCache();
        return this.locationClient.mo33068a(locationCallback);
    }

    public Task<Void> requestLocationUpdates(LocationRequest locationRequest, LocationCallback locationCallback, Looper looper) {
        LocationClientStateManager.getInstance().resetCache();
        return this.locationClient.mo33071a(locationRequest, locationCallback, looper);
    }
}
