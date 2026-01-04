package com.huawei.hms.location;

import android.content.Intent;
import android.location.Location;
import com.huawei.secure.android.common.intent.SafeIntent;
import hu.C10343b;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class GeofenceData {
    public static final String KEY_ERROR_CODE = "hms_error_code";
    private static final String KEY_GEOFENCE_BUNDLE = "com.huawei.hms.location.geofence.geofence_list_bundle";
    public static final String KEY_GEOFENCE_LIST = "com.huawei.hms.location.geofence.geofence_list";
    public static final String KEY_LOCATION = "com.huawei.hms.location.geofence.location";
    public static final String KEY_TRANSITION = "com.huawei.hms.location.geofence.conversion";
    private final int conversion;
    private final List<Geofence> convertingGeofenceList;
    private final Location convertingLocation;
    private final int errorCode;

    private GeofenceData(int i10, int i11, List<Geofence> list, Location location) {
        this.errorCode = i10;
        this.conversion = i11;
        this.convertingGeofenceList = list;
        this.convertingLocation = location;
    }

    public static GeofenceData getDataFromIntent(Intent intent) {
        if (intent == null) {
            return null;
        }
        SafeIntent safeIntent = new SafeIntent(intent);
        int intExtra = safeIntent.getIntExtra(KEY_ERROR_CODE, -1);
        int intExtra2 = safeIntent.getIntExtra(KEY_TRANSITION, -1);
        int i10 = (intExtra2 == 1 || intExtra2 == 2 || intExtra2 == 4) ? intExtra2 : -1;
        Location location = (Location) safeIntent.getParcelableExtra(KEY_LOCATION);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayListM63692n = new C10343b(safeIntent.getBundleExtra(KEY_GEOFENCE_BUNDLE)).m63692n(KEY_GEOFENCE_LIST);
        if (arrayListM63692n == null) {
            arrayListM63692n = safeIntent.getParcelableArrayListExtra(KEY_GEOFENCE_LIST);
        }
        if (arrayListM63692n != null && arrayListM63692n.size() > 0) {
            arrayList.addAll(arrayListM63692n);
        }
        return new GeofenceData(intExtra, i10, arrayList, location);
    }

    public int getConversion() {
        return this.conversion;
    }

    public List<Geofence> getConvertingGeofenceList() {
        return this.convertingGeofenceList;
    }

    public Location getConvertingLocation() {
        return this.convertingLocation;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public boolean isFailure() {
        return this.errorCode != -1;
    }

    public boolean isSuccess() {
        return this.errorCode == -1;
    }
}
