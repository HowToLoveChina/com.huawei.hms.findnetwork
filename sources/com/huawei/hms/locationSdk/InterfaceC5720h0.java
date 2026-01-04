package com.huawei.hms.locationSdk;

import android.location.Location;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.location.LocationSceneRequest;
import com.huawei.hms.location.LocationSceneResponse;
import com.huawei.hms.location.NavigationRequest;
import com.huawei.hms.location.NavigationResult;
import com.huawei.hms.location.RoadData;
import com.huawei.hms.location.RoadDataResult;
import com.huawei.hms.support.api.entity.location.stationrecognition.CityStationLineResponse;
import com.huawei.hms.support.api.entity.location.stationrecognition.HistoryStationInfoResponse;

/* renamed from: com.huawei.hms.locationSdk.h0 */
/* loaded from: classes8.dex */
public interface InterfaceC5720h0 {
    /* renamed from: a */
    Task<Void> mo33087a(Location location, String str);

    /* renamed from: a */
    Task<LocationSceneResponse> mo33088a(LocationSceneRequest locationSceneRequest);

    /* renamed from: a */
    Task<NavigationResult> mo33089a(NavigationRequest navigationRequest);

    /* renamed from: a */
    Task<RoadDataResult> mo33090a(RoadData roadData);

    /* renamed from: a */
    Task<Void> mo33091a(String str);

    /* renamed from: a */
    Task<CityStationLineResponse> mo33092a(String str, String str2);

    /* renamed from: b */
    Task<LocationSceneResponse> mo33093b(LocationSceneRequest locationSceneRequest);

    /* renamed from: b */
    Task<HistoryStationInfoResponse> mo33094b(String str);
}
