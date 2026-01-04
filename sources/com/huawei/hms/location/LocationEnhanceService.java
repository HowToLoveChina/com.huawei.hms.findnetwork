package com.huawei.hms.location;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.locationSdk.C5758u;
import com.huawei.hms.locationSdk.C5765w0;
import com.huawei.hms.locationSdk.InterfaceC5720h0;
import com.huawei.hms.support.api.entity.location.stationrecognition.CityStationLineResponse;
import com.huawei.hms.support.api.entity.location.stationrecognition.HistoryStationInfoResponse;

/* loaded from: classes8.dex */
public class LocationEnhanceService {
    private static final String TAG = "LocationEnhanceService";
    private InterfaceC5720h0 locationEnhanceClient;

    public LocationEnhanceService(Activity activity) {
        this.locationEnhanceClient = C5758u.m33174c(activity, (C5765w0) null);
    }

    private Task<Void> reportLocation(Location location, String str) {
        return this.locationEnhanceClient.mo33087a(location, str);
    }

    public Task<HistoryStationInfoResponse> getHistoryStationInfo(String str) {
        return this.locationEnhanceClient.mo33094b(str);
    }

    public Task<LocationSceneResponse> getLocationSceneResponse(LocationSceneRequest locationSceneRequest) {
        return this.locationEnhanceClient.mo33088a(locationSceneRequest);
    }

    public Task<NavigationResult> getNavigationState(NavigationRequest navigationRequest) {
        return this.locationEnhanceClient.mo33089a(navigationRequest);
    }

    public Task<CityStationLineResponse> getStationLines(String str, String str2) {
        return this.locationEnhanceClient.mo33092a(str, str2);
    }

    public Task<Void> requestStationRecognition(String str) {
        return this.locationEnhanceClient.mo33091a(str);
    }

    public Task<LocationSceneResponse> setLocationSceneMode(LocationSceneRequest locationSceneRequest) {
        return this.locationEnhanceClient.mo33093b(locationSceneRequest);
    }

    public Task<RoadDataResult> setRoadData(RoadData roadData) {
        return this.locationEnhanceClient.mo33090a(roadData);
    }

    public LocationEnhanceService(Context context) {
        this.locationEnhanceClient = C5758u.m33175c(context, (C5765w0) null);
    }
}
