package com.huawei.hms.support.api.location.common;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import as.C1016d;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.location.LocationCallback;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.locationSdk.AbstractC5696b;
import com.huawei.hms.locationSdk.C5698b1;
import com.huawei.hms.locationSdk.C5733l1;
import com.huawei.hms.locationSdk.C5768x0;
import com.huawei.hms.locationSdk.C5773z;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.location.updates.RemoveLocationUpdatesRequest;
import com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.location.lite.common.report.C6791a;
import com.huawei.location.lite.common.report.ReportBuilder;
import es.C9536a;
import es.C9540e;
import es.C9545j;
import es.C9546k;
import es.C9551p;
import es.C9555t;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import p443l4.AbstractC11229a;
import p531or.C11991a;

/* loaded from: classes8.dex */
public class LocationRequestHelper {
    public static final String CP_TRANS_ID = "cpTransId";
    private static final String LOCATION_REQUEST_API_NAME = "Location_requestLocationUpdates_SDK";
    public static final String PETAL_MAPS_CAR_PACKAGE_NAME = "com.huawei.maps.car.app";
    public static final String PETAL_MAPS_PACKAGE_NAME = "com.huawei.maps.app";
    private static final String TAG = "LocationRequestHelper";
    private static final String VDR_ENABLE = "1";
    private static final String VDR_GNSS_OPTION = "vdrEnable";

    /* renamed from: com.huawei.hms.support.api.location.common.LocationRequestHelper$a */
    public class RunnableC6334a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f29812a;

        /* renamed from: b */
        final /* synthetic */ int f29813b;

        /* renamed from: c */
        final /* synthetic */ String f29814c;

        /* renamed from: d */
        final /* synthetic */ String f29815d;

        public RunnableC6334a(String str, int i10, String str2, String str3) {
            this.f29812a = str;
            this.f29813b = i10;
            this.f29814c = str2;
            this.f29815d = str3;
        }

        @Override // java.lang.Runnable
        public void run() throws JSONException {
            ReportBuilder reportBuilder = new ReportBuilder();
            reportBuilder.setApiName(LocationRequestHelper.LOCATION_REQUEST_API_NAME);
            reportBuilder.setWLANScan();
            reportBuilder.setLocationEnable(C9545j.m59603d(C11991a.m72145a()));
            reportBuilder.setTransactionID(this.f29812a);
            reportBuilder.setPackage(C11991a.m72145a().getPackageName());
            reportBuilder.setCpAppVersion(C9536a.m59546f(C11991a.m72145a().getPackageName()));
            reportBuilder.setErrorCode(this.f29813b + "");
            reportBuilder.setErrorMessage(this.f29814c);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(LocationRequestHelper.CP_TRANS_ID, this.f29815d);
                reportBuilder.setExt(jSONObject.toString());
            } catch (JSONException unused) {
                HMSLocationLog.m36662i(LocationRequestHelper.TAG, this.f29812a, "reportRequest put ext failed");
            }
            C6791a.m38458h().m38467l(reportBuilder);
            C6791a.m38458h().m38469n();
        }
    }

    public static void assertNoNull(Object obj) throws ApiException {
        if (obj == null) {
            throw new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
        }
    }

    private static void buildRequestEntity(String str, LocationRequest locationRequest, LocationCallback locationCallback, RequestLocationUpdatesRequest requestLocationUpdatesRequest) {
        requestLocationUpdatesRequest.setLocationRequest(locationRequest);
        if (!TextUtils.equals(str, "Intent")) {
            requestLocationUpdatesRequest.setUuid(locationCallback.getUuid());
        }
        if (TextUtils.equals(str, "ExCallback")) {
            locationRequest.putExtras("productId", getProductId());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.huawei.hms.locationSdk.AbstractC5696b buildTaskApiCall(java.lang.String r15, com.huawei.hms.location.LocationCallback r16, android.os.Looper r17, android.app.PendingIntent r18, com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest r19, com.huawei.hms.locationSdk.C5733l1 r20, java.lang.String r21) throws com.huawei.hms.common.ApiException {
        /*
            Method dump skipped, instructions count: 279
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.support.api.location.common.LocationRequestHelper.buildTaskApiCall(java.lang.String, com.huawei.hms.location.LocationCallback, android.os.Looper, android.app.PendingIntent, com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest, com.huawei.hms.locationSdk.l1, java.lang.String):com.huawei.hms.locationSdk.b");
    }

    private static void checkLocationPermission() throws ApiException {
        if (!PermissionUtil.isLocationPermissionAvailable(C11991a.m72145a())) {
            throw new ApiException(new Status(10803, LocationStatusCode.getStatusCodeString(10803)));
        }
    }

    private static void checkMethodSupport(String str) throws ApiException {
        if (TextUtils.equals(str, "Intent") && !C5773z.m33216a(C11991a.m72145a())) {
            throw new ApiException(new Status(LocationStatusCode.NOT_YET_SUPPORTED, LocationStatusCode.getStatusCodeString(LocationStatusCode.NOT_YET_SUPPORTED)));
        }
    }

    private static void checkPriority(String str, LocationRequest locationRequest) throws ApiException {
        str.hashCode();
        switch (str) {
            case "Intent":
            case "NORMAL Callback":
                if (locationRequest.getPriority() == 200 || locationRequest.getPriority() == 300 || locationRequest.getPriority() == 400) {
                    throw new ApiException(new Status(LocationStatusCode.METHOD_INVOKE_ERROR, LocationStatusCode.getStatusCodeString(LocationStatusCode.METHOD_INVOKE_ERROR)));
                }
                return;
            case "ExCallback":
                if (locationRequest.getPriority() == 200) {
                    locationRequest.setNeedAddress(false);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private static void checkRemoveRequestParam(LocationCallback locationCallback, PendingIntent pendingIntent, String str) throws ApiException {
        int iHashCode = str.hashCode();
        if (iHashCode != -2099895620) {
            if (iHashCode == -1598699650) {
                str.equals("NORMAL Callback");
            }
        } else if (str.equals("Intent")) {
            assertNoNull(pendingIntent);
            return;
        }
        assertNoNull(locationCallback);
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void checkRequestParam(java.lang.String r2, com.huawei.hms.location.LocationRequest r3, com.huawei.hms.location.LocationCallback r4, android.os.Looper r5, android.app.PendingIntent r6) throws com.huawei.hms.common.ApiException {
        /*
            assertNoNull(r3)
            int r0 = r2.hashCode()
            r1 = -2099895620(0xffffffff82d622bc, float:-3.146441E-37)
            if (r0 == r1) goto L20
            r6 = -1598699650(0xffffffffa0b5c77e, float:-3.0794606E-19)
            if (r0 == r6) goto L1d
            r6 = 1366690360(0x51760a38, float:6.6045837E10)
            if (r0 == r6) goto L17
            goto L2c
        L17:
            java.lang.String r6 = "ExCallback"
        L19:
            r2.equals(r6)
            goto L2c
        L1d:
            java.lang.String r6 = "NORMAL Callback"
            goto L19
        L20:
            java.lang.String r0 = "Intent"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L2c
            assertNoNull(r6)
            goto L32
        L2c:
            assertNoNull(r4)
            assertNoNull(r5)
        L32:
            int r2 = r3.getNumUpdates()
            r4 = 10802(0x2a32, float:1.5137E-41)
            if (r2 <= 0) goto L58
            int r2 = r3.getCoordinateType()
            if (r2 == 0) goto L57
            int r2 = r3.getCoordinateType()
            r3 = 1
            if (r2 != r3) goto L48
            goto L57
        L48:
            com.huawei.hms.common.ApiException r2 = new com.huawei.hms.common.ApiException
            com.huawei.hms.support.api.client.Status r3 = new com.huawei.hms.support.api.client.Status
            java.lang.String r5 = com.huawei.hms.support.api.location.common.exception.LocationStatusCode.getStatusCodeString(r4)
            r3.<init>(r4, r5)
            r2.<init>(r3)
            throw r2
        L57:
            return
        L58:
            com.huawei.hms.common.ApiException r2 = new com.huawei.hms.common.ApiException
            com.huawei.hms.support.api.client.Status r3 = new com.huawei.hms.support.api.client.Status
            java.lang.String r5 = com.huawei.hms.support.api.location.common.exception.LocationStatusCode.getStatusCodeString(r4)
            r3.<init>(r4, r5)
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.support.api.location.common.LocationRequestHelper.checkRequestParam(java.lang.String, com.huawei.hms.location.LocationRequest, com.huawei.hms.location.LocationCallback, android.os.Looper, android.app.PendingIntent):void");
    }

    private static C5733l1 createRemoveLocationUpdatesCache(LocationCallback locationCallback, PendingIntent pendingIntent, String str, String str2) throws ApiException {
        checkRemoveRequestParam(locationCallback, pendingIntent, str);
        C5733l1 c5733l1 = (C5733l1) C5768x0.m33197b().m33193b(new C5733l1(null, pendingIntent, locationCallback, null, str2, str));
        if (c5733l1 != null) {
            return c5733l1;
        }
        int iHashCode = str.hashCode();
        if (iHashCode != -2099895620) {
            if (iHashCode == -1598699650) {
                str.equals("NORMAL Callback");
            }
        } else if (str.equals("Intent")) {
            HMSLocationLog.m36660e(TAG, str2, "remove location updates with intent cannot find intent");
            throw new ApiException(new Status(LocationStatusCode.NO_MATCHED_INTENT, LocationStatusCode.getStatusCodeString(LocationStatusCode.NO_MATCHED_INTENT)));
        }
        HMSLocationLog.m36660e(TAG, str2, "remove location updates with callback cannot find callback");
        throw new ApiException(new Status(LocationStatusCode.NO_MATCHED_CALLBACK, LocationStatusCode.getStatusCodeString(LocationStatusCode.NO_MATCHED_CALLBACK)));
    }

    public static AbstractC5696b createRemoveTaskApiCall(LocationCallback locationCallback, PendingIntent pendingIntent, String str, String str2, RemoveLocationUpdatesRequest removeLocationUpdatesRequest) throws ApiException {
        C5733l1 c5733l1CreateRemoveLocationUpdatesCache = createRemoveLocationUpdatesCache(locationCallback, pendingIntent, str, str2);
        String strM33186a = c5733l1CreateRemoveLocationUpdatesCache.m33186a();
        removeLocationUpdatesRequest.setTid(strM33186a);
        if (TextUtils.equals(str, "NORMAL Callback")) {
            removeLocationUpdatesRequest.setUuid(locationCallback.getUuid());
        }
        C5698b1 c5698b1 = new C5698b1("location.removeLocationUpdates", JsonUtil.createJsonString(removeLocationUpdatesRequest), strM33186a, c5733l1CreateRemoveLocationUpdatesCache, "");
        if (TextUtils.equals(str, "Intent")) {
            c5698b1.setParcelable(pendingIntent);
        }
        HMSLocationLog.m36662i(TAG, strM33186a, str + " removeLocationUpdates tid =" + strM33186a + ",uuid = " + removeLocationUpdatesRequest.getUuid() + " Version Code = 61403300");
        return c5698b1;
    }

    public static AbstractC5696b createRequestApiCall(String str, LocationRequest locationRequest, LocationCallback locationCallback, Looper looper, PendingIntent pendingIntent, RequestLocationUpdatesRequest requestLocationUpdatesRequest) throws ApiException {
        checkMethodSupport(str);
        checkRequestParam(str, locationRequest, locationCallback, looper, pendingIntent);
        checkLocationPermission();
        checkPriority(str, locationRequest);
        buildRequestEntity(str, locationRequest, locationCallback, requestLocationUpdatesRequest);
        return buildTaskApiCall(str, locationCallback, looper, pendingIntent, requestLocationUpdatesRequest, new C5733l1(locationRequest, pendingIntent, locationCallback, looper, requestLocationUpdatesRequest.getTid(), str), JsonUtil.createJsonString(requestLocationUpdatesRequest));
    }

    public static String getCpTid(LocationRequest locationRequest) {
        Map<String, String> extras;
        return (locationRequest == null || (extras = locationRequest.getExtras()) == null || extras.isEmpty()) ? "" : extras.get(CP_TRANS_ID);
    }

    private static String getOption(RequestLocationUpdatesRequest requestLocationUpdatesRequest) {
        Map<String, String> extras = requestLocationUpdatesRequest.getLocationRequest().getExtras();
        String str = extras != null ? extras.get("vdrEnable") : "";
        C1016d.m6186f(TAG, "vdrEnable is: " + str);
        return str;
    }

    private static String getProductId() {
        try {
            return AbstractC11229a.m67436d(C11991a.m72145a()).mo66356b("client/product_id");
        } catch (Exception unused) {
            HMSLog.m36986e(TAG, "get agc productId by exception");
            return "";
        }
    }

    private static boolean isCodeAllowReport(int i10) {
        return i10 == 10811;
    }

    public static boolean isNeedMdcLocation() {
        if (PETAL_MAPS_CAR_PACKAGE_NAME.equals(C11991a.m72145a().getPackageName())) {
            return true;
        }
        HMSLocationLog.m36662i(TAG, "", "do not need mdc location, not target package");
        return false;
    }

    private static boolean isVdrEnable(RequestLocationUpdatesRequest requestLocationUpdatesRequest) {
        String str;
        if (requestLocationUpdatesRequest.getLocationRequest().getPriority() != 200) {
            str = "do not support vdr, priority is: " + requestLocationUpdatesRequest.getLocationRequest().getPriority();
        } else {
            if (C9551p.m59641e("com.huawei.location.vdr.VdrManager")) {
                return TextUtils.equals(getOption(requestLocationUpdatesRequest), "1");
            }
            str = "no vdr module, do not support vdr";
        }
        C1016d.m6186f(TAG, str);
        return false;
    }

    private static void logCurrentStatus(LocationRequest locationRequest, String str, Context context) {
        if (context == null || locationRequest == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(context == null ? "context is null, " : "context is not null, ");
            sb2.append(locationRequest == null ? "request is null, " : "request is not null, ");
            HMSLocationLog.m36660e(TAG, str, sb2.toString());
            return;
        }
        HMSLocationLog.m36662i(TAG, str, "priority: " + locationRequest.getPriority() + ", locationMode: " + C9545j.m59603d(context) + ", netWork available: " + C9546k.m59614h(context) + ", model is: " + Build.MODEL + ",WLANScan:" + C9555t.m59656a(C11991a.m72145a()));
    }

    public static void reportRequest(String str, int i10, String str2, String str3) {
        if (PETAL_MAPS_CAR_PACKAGE_NAME.equals(C11991a.m72145a().getPackageName()) || PETAL_MAPS_PACKAGE_NAME.equals(C11991a.m72145a().getPackageName()) || isCodeAllowReport(i10)) {
            C9540e.m59581d().m59582a(new RunnableC6334a(str, i10, str2, str3));
        }
    }
}
