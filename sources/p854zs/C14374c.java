package p854zs;

import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.SystemClock;
import as.C1016d;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.network.p129ai.C5799g0;
import com.huawei.hms.support.api.entity.location.lastlocation.GetLastLocationResponse;
import com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.riemann.location.common.utils.Constant;
import es.C9548m;
import es.C9550o;
import org.json.JSONException;
import org.json.JSONObject;
import p531or.C11991a;

/* renamed from: zs.c */
/* loaded from: classes8.dex */
public final class C14374c {
    /* renamed from: a */
    public static String m85583a(GetLastLocationResponse getLastLocationResponse) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject = m85584b(getLastLocationResponse.getLocation());
        } catch (JSONException unused) {
            C1016d.m6183c("LocationInnerUtil", "buildEntityFromResponse get jsonException .");
        }
        return jSONObject.toString();
    }

    /* renamed from: b */
    public static JSONObject m85584b(Location location) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (location == null) {
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("mProvider", location.getProvider());
        jSONObject2.put("mAltitude", location.getAltitude());
        jSONObject2.put("mBearing", location.getBearing());
        jSONObject2.put("mHorizontalAccuracyMeters", location.getAccuracy());
        jSONObject2.put("mLatitude", location.getLatitude());
        jSONObject2.put("mLongitude", location.getLongitude());
        jSONObject2.put("mSpeed", location.getSpeed());
        jSONObject2.put("mTime", location.getTime());
        jSONObject2.put("mElapsedRealtimeNanos", location.getElapsedRealtimeNanos());
        jSONObject2.put("mBearingAccuracyDegrees", location.getBearingAccuracyDegrees());
        jSONObject2.put("mSpeedAccuracyMetersPerSecond", location.getSpeedAccuracyMetersPerSecond());
        jSONObject2.put("mVerticalAccuracyMeters", location.getVerticalAccuracyMeters());
        if (location.getExtras() != null) {
            JSONObject jSONObject3 = new JSONObject();
            if (location.getExtras().containsKey(Constant.LOCATION_SOURCE_TYPE)) {
                jSONObject3.put(Constant.LOCATION_SOURCE_TYPE, location.getExtras().getInt(Constant.LOCATION_SOURCE_TYPE, -1));
            }
            if (location.getExtras().containsKey("LocationSource")) {
                jSONObject3.put("LocationSource", location.getExtras().getInt("LocationSource", 0));
            }
            if (location.getExtras().containsKey("session_id")) {
                jSONObject3.put("session_id", location.getExtras().getString("session_id"));
            }
            if (location.getExtras().containsKey("vendorType")) {
                jSONObject3.put("vendorType", location.getExtras().getInt("vendorType"));
            }
            if (location.getExtras().containsKey("locateType")) {
                jSONObject3.put("locateType", location.getExtras().getString("locateType"));
            }
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("mExtraInfo", jSONObject3);
            jSONObject.put(C5799g0.f25867g, jSONObject4);
        }
        jSONObject.put(JsbMapKeyNames.H5_LOC, jSONObject2);
        return jSONObject;
    }

    /* renamed from: c */
    public static boolean m85585c() {
        try {
            if (Build.VERSION.SDK_INT > 30 && !C9550o.m59633f()) {
                return true ^ C9548m.m59619b(C11991a.m72145a(), "android.permission.ACCESS_FINE_LOCATION");
            }
            return false;
        } catch (Exception unused) {
            C1016d.m6183c("LocationInnerUtil", "checkApproximatelyPermission exception");
            return true;
        }
    }

    /* renamed from: d */
    public static boolean m85586d(RequestLocationUpdatesRequest requestLocationUpdatesRequest) {
        String str;
        if (requestLocationUpdatesRequest == null) {
            return false;
        }
        LocationRequest locationRequest = requestLocationUpdatesRequest.getLocationRequest();
        if (locationRequest == null) {
            str = "checkRequestInvalid false, locationRequest is invalid";
        } else {
            if (locationRequest.getExpirationTime() >= SystemClock.elapsedRealtime()) {
                return locationRequest.getNumUpdates() >= 1;
            }
            str = "checkRequestInvalid false, expirationTime is invalid";
        }
        C1016d.m6186f("LocationInnerUtil", str);
        return false;
    }

    /* renamed from: e */
    public static boolean m85587e(String str) {
        String str2;
        try {
            Object systemService = C11991a.m72145a().getSystemService(JsbMapKeyNames.H5_LOC);
            if (systemService instanceof LocationManager) {
                return ((LocationManager) systemService).isProviderEnabled(str);
            }
            return false;
        } catch (IllegalArgumentException unused) {
            str2 = "isProviderEnabled IllegalArgumentException";
            C1016d.m6183c("LocationInnerUtil", str2);
            return false;
        } catch (SecurityException unused2) {
            str2 = "isProviderEnabled SecurityException";
            C1016d.m6183c("LocationInnerUtil", str2);
            return false;
        } catch (Exception unused3) {
            str2 = "isProviderEnabled exception";
            C1016d.m6183c("LocationInnerUtil", str2);
            return false;
        }
    }
}
