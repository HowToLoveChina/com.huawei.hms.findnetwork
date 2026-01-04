package com.huawei.hms.support.api.location.common;

import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import as.C1016d;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.location.HWLocation;
import com.huawei.hms.location.LocationAvailability;
import com.huawei.hms.location.LocationResult;
import com.huawei.hms.network.p129ai.C5799g0;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class LocationJsonUtil {
    private static final String TAG = "LocationJsonUtil";

    public static Location convertLocation(HWLocation hWLocation) throws JSONException {
        if (hWLocation == null) {
            return null;
        }
        Location location = new Location(hWLocation.getProvider());
        location.setTime(hWLocation.getTime());
        location.setElapsedRealtimeNanos(hWLocation.getElapsedRealtimeNanos());
        location.setLatitude(hWLocation.getLatitude());
        location.setLongitude(hWLocation.getLongitude());
        location.setAltitude(hWLocation.getAltitude());
        location.setSpeed(hWLocation.getSpeed());
        location.setBearing(hWLocation.getBearing());
        location.setAccuracy(hWLocation.getAccuracy());
        location.setVerticalAccuracyMeters(hWLocation.getVerticalAccuracyMeters());
        location.setSpeedAccuracyMetersPerSecond(hWLocation.getSpeedAccuracyMetersPerSecond());
        location.setBearingAccuracyDegrees(hWLocation.getBearingAccuracyDegrees());
        if (hWLocation.getExtraInfo() != null) {
            Bundle bundle = new Bundle();
            JSONObject jSONObject = new JSONObject(hWLocation.getExtraInfo());
            for (Map.Entry<String, Object> entry : hWLocation.getExtraInfo().entrySet()) {
                try {
                    String key = entry.getKey();
                    if (!entry.getKey().startsWith("hw-address-")) {
                        Object obj = jSONObject.get(key);
                        if (obj instanceof Boolean) {
                            bundle.putBoolean(key, ((Boolean) obj).booleanValue());
                        } else if (obj instanceof Integer) {
                            bundle.putInt(key, ((Integer) obj).intValue());
                        } else if (obj instanceof Float) {
                            bundle.putFloat(key, ((Float) obj).floatValue());
                        } else if (obj instanceof Long) {
                            bundle.putLong(key, ((Long) obj).longValue());
                        } else if (obj instanceof Short) {
                            bundle.putShort(key, ((Short) obj).shortValue());
                        } else if (obj instanceof Double) {
                            bundle.putDouble(key, ((Double) obj).doubleValue());
                        } else {
                            bundle.putString(key, jSONObject.getString(key));
                        }
                    }
                } catch (JSONException unused) {
                    C1016d.m6183c(TAG, "convertLocation: JSONException");
                }
            }
            location.setExtras(bundle);
        }
        return location;
    }

    public static JSONObject createLocationJsonObject(Location location) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("mProvider", location.getProvider());
        jSONObject.put("mAltitude", location.getAltitude());
        jSONObject.put("mBearing", location.getBearing());
        jSONObject.put("mElapsedRealtimeNanos", location.getElapsedRealtimeNanos());
        jSONObject.put("mHorizontalAccuracyMeters", location.getAccuracy());
        jSONObject.put("mLatitude", location.getLatitude());
        jSONObject.put("mLongitude", location.getLongitude());
        jSONObject.put("mSpeed", location.getSpeed());
        jSONObject.put("mSpeedAccuracyMetersPerSecond", location.getSpeedAccuracyMetersPerSecond());
        jSONObject.put("mVerticalAccuracyMeters", location.getVerticalAccuracyMeters());
        jSONObject.put("mBearingAccuracyDegrees", location.getBearingAccuracyDegrees());
        jSONObject.put("mTime", location.getTime());
        return jSONObject;
    }

    private static void fillAddress(JSONObject jSONObject, HWLocation hWLocation) throws JSONException {
        JSONObject jSONObject2;
        if (!jSONObject.has(C5799g0.f25867g) || (jSONObject2 = jSONObject.getJSONObject(C5799g0.f25867g)) == null) {
            return;
        }
        hWLocation.setCountryCode(jSONObject2.optString("mCountryCode", ""));
        hWLocation.setCountryName(jSONObject2.optString("mCountryName", ""));
        hWLocation.setState(jSONObject2.optString("mState", ""));
        hWLocation.setCity(jSONObject2.optString("mCity", ""));
        hWLocation.setCounty(jSONObject2.optString("mCounty", ""));
        hWLocation.setStreet(jSONObject2.optString("mStreet", ""));
        hWLocation.setFeatureName(jSONObject2.optString("mFeatureName", ""));
        hWLocation.setPostalCode(jSONObject2.optString("mPostalCode", ""));
        hWLocation.setPhone(jSONObject2.optString("mPhone", ""));
        hWLocation.setUrl(jSONObject2.optString("mUrl", ""));
        if (jSONObject2.has("mExtraInfo")) {
            Object objOpt = jSONObject2.opt("mExtraInfo");
            JSONObject jSONObject3 = objOpt instanceof JSONObject ? (JSONObject) objOpt : null;
            if (jSONObject3 == null) {
                return;
            }
            Iterator<String> itKeys = jSONObject3.keys();
            HashMap map = new HashMap();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jSONObject3.get(next));
            }
            hWLocation.setExtraInfo(map);
        }
    }

    public static List<HWLocation> parseHwLocationsFromJsonObject(JSONObject jSONObject) throws ApiException, JSONException {
        JSONArray jSONArray = jSONObject.getJSONArray("geocoderResult");
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            HWLocation locationFromJsonObject = parseLocationFromJsonObject(jSONArray.getJSONObject(i10));
            if (locationFromJsonObject != null) {
                arrayList.add(locationFromJsonObject);
            }
        }
        return CollectionsUtil.isEmpty(arrayList) ? Collections.emptyList() : arrayList;
    }

    public static LocationAvailability parseLocationAvailabilityFromString(String str) throws JSONException {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject2 = new JSONObject(str);
        if (!jSONObject2.has("locationAvailability") || (jSONObject = jSONObject2.getJSONObject("locationAvailability")) == null) {
            return null;
        }
        LocationAvailability locationAvailability = new LocationAvailability();
        locationAvailability.setCellStatus(jSONObject.optInt("cellStatus"));
        locationAvailability.setWifiStatus(jSONObject.optInt("wifiStatus"));
        locationAvailability.setElapsedRealtimeNs(jSONObject.optLong("elapsedRealtimeNs"));
        locationAvailability.setLocationStatus(jSONObject.optInt("locationStatus"));
        return locationAvailability;
    }

    public static HWLocation parseLocationFromJsonObject(JSONObject jSONObject) throws ApiException, JSONException {
        JSONObject jSONObject2;
        if (jSONObject == null || !jSONObject.has(JsbMapKeyNames.H5_LOC) || (jSONObject2 = jSONObject.getJSONObject(JsbMapKeyNames.H5_LOC)) == null) {
            return null;
        }
        if (!jSONObject2.has("mProvider")) {
            throw new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
        }
        String string = jSONObject2.getString("mProvider");
        HWLocation hWLocation = new HWLocation();
        hWLocation.setProvider(string);
        hWLocation.setAltitude(jSONObject2.optDouble("mAltitude", 0.0d));
        hWLocation.setBearing((float) jSONObject2.optDouble("mBearing", 0.0d));
        hWLocation.setBearingAccuracyDegrees((float) jSONObject2.optDouble("mBearingAccuracyDegrees", 0.0d));
        hWLocation.setElapsedRealtimeNanos(jSONObject2.optLong("mElapsedRealtimeNanos", 0L));
        hWLocation.setAccuracy((float) jSONObject2.optDouble("mHorizontalAccuracyMeters", 0.0d));
        hWLocation.setLatitude(jSONObject2.optDouble("mLatitude", 0.0d));
        hWLocation.setLongitude(jSONObject2.optDouble("mLongitude", 0.0d));
        hWLocation.setSpeed((float) jSONObject2.optDouble("mSpeed", 0.0d));
        hWLocation.setSpeedAccuracyMetersPerSecond((float) jSONObject2.optDouble("mSpeedAccuracyMetersPerSecond", 0.0d));
        hWLocation.setTime(jSONObject2.optLong("mTime", 0L));
        hWLocation.setVerticalAccuracyMeters((float) jSONObject2.optDouble("mVerticalAccuracyMeters", 0.0d));
        fillAddress(jSONObject, hWLocation);
        return hWLocation;
    }

    public static LocationResult parseLocationResultFromJsonObject(JSONObject jSONObject) throws ApiException, JSONException {
        JSONObject jSONObject2;
        if (jSONObject == null || (jSONObject2 = jSONObject.getJSONObject("locationResult")) == null) {
            return null;
        }
        List<HWLocation> locationsFromJsonObject = parseLocationsFromJsonObject(jSONObject2);
        if (CollectionsUtil.isEmpty(locationsFromJsonObject)) {
            return null;
        }
        return LocationResult.create(locationsFromJsonObject);
    }

    public static List<HWLocation> parseLocationsFromJsonObject(JSONObject jSONObject) throws ApiException, JSONException {
        JSONArray jSONArray = jSONObject.getJSONArray("locations");
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            HWLocation locationFromJsonObject = parseLocationFromJsonObject(jSONArray.getJSONObject(i10));
            if (locationFromJsonObject != null) {
                arrayList.add(locationFromJsonObject);
            }
        }
        return CollectionsUtil.isEmpty(arrayList) ? Collections.emptyList() : arrayList;
    }
}
