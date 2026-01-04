package com.huawei.location.nlp.network;

import android.location.Location;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import as.C1016d;
import com.huawei.hms.location.BuildConfig;
import com.huawei.hms.location.HwLocationResult;
import com.huawei.hwcloudjs.p164f.C6661f;
import com.huawei.location.lite.common.http.HttpClientEx;
import com.huawei.location.nlp.network.request.OnlineLocationRequest;
import com.huawei.location.nlp.network.response.OnlineLocationResponse;
import com.huawei.openalliance.p169ad.constant.IntentFailError;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import es.C9542g;
import java.util.HashMap;
import java.util.UUID;
import ls.C11340a;
import org.json.JSONException;
import org.json.JSONObject;
import p433ks.C11146a;
import p531or.C11991a;
import p688ur.C13244d;
import p688ur.C13245e;
import p785xr.C13851a;
import p785xr.C13852b;
import p785xr.C13853c;
import sr.C12847b;

/* loaded from: classes8.dex */
public class OnlineLocationService {
    private static final int FLAG_ACCURACY = 16;
    private static final int FLAG_BEARING = 8;
    private static final int FLAG_SPEED = 4;
    private static final String LOCATION_URL = "/networklocation/v1/onlineLocation";
    public static final String SRC_DEFAULT = "4";
    private static final String TAG = "OnlineLocationService";
    public static final String X_REQ_SRC = "X-Req-src";

    private boolean convertNativeLocation(Location location, OnlineLocationResponse onlineLocationResponse) {
        String str;
        com.huawei.location.nlp.network.response.Location position = onlineLocationResponse.getPosition();
        if (position == null) {
            str = "convertNativeLocation, responseLocation is null.";
        } else {
            short flags = position.getFlags();
            if (flags <= 0) {
                str = "convertNativeLocation, flag is invalid.";
            } else {
                if ((flags & 1) > 0) {
                    location.setLatitude(position.getLatitude());
                    location.setLongitude(position.getLongitude());
                    if ((flags & 4) != 0) {
                        location.setSpeed(position.getSpeed());
                    }
                    if ((flags & 8) != 0) {
                        location.setBearing(position.getBearing());
                    }
                    if ((flags & 16) != 0) {
                        location.setAccuracy(position.getAccuracy());
                    }
                    location.setElapsedRealtimeNanos(SystemClock.elapsedRealtimeNanos());
                    location.setTime(System.currentTimeMillis());
                    location.setProvider("network");
                    Bundle bundle = new Bundle();
                    if (!TextUtils.isEmpty(onlineLocationResponse.getSessionId())) {
                        bundle.putString("session_id", onlineLocationResponse.getSessionId());
                    }
                    bundle.putInt("vendorType", 1);
                    bundle.putString("locateType", onlineLocationResponse.getLocateType());
                    bundle.putString("buildingId", position.getBuildingId());
                    bundle.putInt("floor", position.getFloor());
                    bundle.putInt("floorAcc", position.getFloorAcc());
                    bundle.putLong("time", position.getTime());
                    bundle.putShort(ParamConstants.Param.FLAGS, position.getFlags());
                    location.setExtras(bundle);
                    return true;
                }
                str = "convertNativeLocation, lon&lat is invalid.";
            }
        }
        C1016d.m6183c(TAG, str);
        return false;
    }

    private OnlineLocationResponse doHttp(OnlineLocationRequest onlineLocationRequest) {
        StringBuilder sb2;
        String message;
        String string;
        C1016d.m6186f(TAG, "doHttp, request is " + onlineLocationRequest.toString());
        OnlineLocationResponse onlineLocationResponse = new OnlineLocationResponse();
        try {
            try {
                C13853c c13853cM83161f = new C13853c.a().m83161f(new JSONObject(C9542g.m59588a().toJson(onlineLocationRequest)));
                String strM77149d = C12847b.m77149d(BuildConfig.LIBRARY_PACKAGE_NAME);
                if (TextUtils.isEmpty(strM77149d)) {
                    C1016d.m6183c(TAG, "grsHostAddress is null");
                    return onlineLocationResponse;
                }
                String packageName = C11991a.m72145a().getPackageName();
                HashMap<String, String> map = new HashMap<>();
                map.put(X_REQ_SRC, "4");
                String string2 = UUID.randomUUID().toString();
                OnlineLocationResponse onlineLocationResponse2 = (OnlineLocationResponse) new HttpClientEx().m38437a(new C13851a.a(LOCATION_URL).m83143m(strM77149d).m83146p(new C13852b(string2).m83153f(packageName).m83149b(map)).m83144n(c13853cM83161f).m83141k()).mo38439b(OnlineLocationResponse.class);
                try {
                    onlineLocationResponse2.setSessionId(string2);
                    C1016d.m6186f(TAG, "doHttp, response code is " + onlineLocationResponse2.getApiCode());
                    return onlineLocationResponse2;
                } catch (Exception unused) {
                    onlineLocationResponse = onlineLocationResponse2;
                    string = IntentFailError.UNKNOWN_EXCEPTION;
                    C1016d.m6183c(TAG, string);
                    return onlineLocationResponse;
                } catch (C13244d e10) {
                    onlineLocationResponse = onlineLocationResponse2;
                    e = e10;
                    sb2 = new StringBuilder("doHttp, OnErrorException: code is ");
                    sb2.append(e.m79631c());
                    sb2.append(", msg is ");
                    message = e.m79632d();
                    sb2.append(message);
                    string = sb2.toString();
                    C1016d.m6183c(TAG, string);
                    return onlineLocationResponse;
                } catch (C13245e e11) {
                    onlineLocationResponse = onlineLocationResponse2;
                    e = e11;
                    sb2 = new StringBuilder("doHttp, OnFailureException: code is ");
                    sb2.append(e.m79628b());
                    sb2.append(", msg is ");
                    message = e.getMessage();
                    sb2.append(message);
                    string = sb2.toString();
                    C1016d.m6183c(TAG, string);
                    return onlineLocationResponse;
                }
            } catch (Exception unused2) {
            } catch (C13244d e12) {
                e = e12;
            } catch (C13245e e13) {
                e = e13;
            }
        } catch (JSONException unused3) {
            C1016d.m6183c(TAG, "doHttp, transfer to JSONException failed");
            return onlineLocationResponse;
        }
    }

    public HwLocationResult getLocationFromCloud(OnlineLocationRequest onlineLocationRequest) {
        onlineLocationRequest.setBoottime(SystemClock.elapsedRealtimeNanos() / 1000);
        OnlineLocationResponse onlineLocationResponseDoHttp = doHttp(onlineLocationRequest);
        HwLocationResult hwLocationResult = new HwLocationResult();
        Location location = new Location("network");
        if (!onlineLocationResponseDoHttp.isSuccess()) {
            C1016d.m6183c(TAG, "getLocationFromCloud, response is failed");
            hwLocationResult.setCode(11000);
            hwLocationResult.setMessage(C11146a.m67058a(11000));
            return hwLocationResult;
        }
        if (!convertNativeLocation(location, onlineLocationResponseDoHttp)) {
            hwLocationResult.setCode(11000);
            hwLocationResult.setMessage(C11146a.m67058a(11000));
            return hwLocationResult;
        }
        if (onlineLocationResponseDoHttp.getIndoor() == 0) {
            String locateType = onlineLocationResponseDoHttp.getLocateType();
            if (C6661f.f30885g.equalsIgnoreCase(locateType)) {
                location.setElapsedRealtimeNanos(C11340a.m68129g().m68135f());
            }
            if ("cell".equalsIgnoreCase(locateType)) {
                location.setElapsedRealtimeNanos(C11340a.m68129g().m68132c());
            }
        }
        hwLocationResult.setCode(0);
        hwLocationResult.setMessage(C11146a.m67058a(0));
        hwLocationResult.setLocation(location);
        return hwLocationResult;
    }
}
