package com.huawei.location.base.activity;

import android.os.SystemClock;
import as.C1016d;
import com.huawei.hms.location.entity.activity.ActivityRecognitionResult;
import com.huawei.hms.location.entity.activity.DetectedActivity;
import com.huawei.location.base.activity.callback.ARCallback;
import com.huawei.location.base.activity.entity.ClientInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes8.dex */
public class ActivityRecognitionMappingManager {
    private static final String TAG = "ActivityRecognitionMappingManager";
    private List<ActivityRecognitionMappingInfo> activityRecognitionMappingInfoList = new CopyOnWriteArrayList();

    private void callBackWithReport(ActivityRecognitionMappingInfo activityRecognitionMappingInfo, ActivityRecognitionResult activityRecognitionResult) {
        try {
            activityRecognitionMappingInfo.getCallback().onActivityRecognition(activityRecognitionResult);
        } catch (Exception unused) {
            C1016d.m6185e(TAG, "Failed to get activity recognition callback", true);
        }
    }

    private boolean isUpdate(ActivityRecognitionMappingInfo activityRecognitionMappingInfo) {
        for (int i10 = 0; i10 < this.activityRecognitionMappingInfoList.size(); i10++) {
            if (this.activityRecognitionMappingInfoList.get(i10).equals(activityRecognitionMappingInfo)) {
                ActivityRecognitionMappingInfo activityRecognitionMappingInfo2 = this.activityRecognitionMappingInfoList.get(i10);
                C1016d.m6186f(TAG, "need update arMappingInfo:time:" + activityRecognitionMappingInfo2.getDetectionIntervalMillis() + "->" + activityRecognitionMappingInfo.getDetectionIntervalMillis());
                activityRecognitionMappingInfo2.setDetectionIntervalMillis(activityRecognitionMappingInfo.getDetectionIntervalMillis());
                activityRecognitionMappingInfo2.setClientInfo(activityRecognitionMappingInfo.getClientInfo());
                return true;
            }
        }
        return false;
    }

    public void addActivityUpdatesMappingInfo(long j10, ARCallback aRCallback, ClientInfo clientInfo) {
        C1016d.m6186f(TAG, "addActivityUpdatesMappingInfo enter, detectionIntervalMillis:" + j10 + ", callback:" + aRCallback);
        ActivityRecognitionMappingInfo activityRecognitionMappingInfo = new ActivityRecognitionMappingInfo();
        activityRecognitionMappingInfo.setCallback(aRCallback);
        activityRecognitionMappingInfo.setClientInfo(clientInfo);
        activityRecognitionMappingInfo.setDetectionIntervalMillis(j10);
        if (this.activityRecognitionMappingInfoList.isEmpty() || !isUpdate(activityRecognitionMappingInfo)) {
            this.activityRecognitionMappingInfoList.add(activityRecognitionMappingInfo);
        }
        C1016d.m6186f(TAG, "addActivityUpdatesMappingInfo success, infos size:" + this.activityRecognitionMappingInfoList.size());
    }

    public List<ActivityRecognitionMappingInfo> getInfos() {
        return this.activityRecognitionMappingInfoList;
    }

    public long getMinTime() {
        Iterator<ActivityRecognitionMappingInfo> it = this.activityRecognitionMappingInfoList.iterator();
        long j10 = -1;
        while (it.hasNext()) {
            long detectionIntervalMillis = it.next().getDetectionIntervalMillis();
            if (j10 == -1 || detectionIntervalMillis < j10) {
                j10 = detectionIntervalMillis;
            }
        }
        C1016d.m6186f(TAG, "getMinTime ,minTime is " + j10);
        return j10;
    }

    public boolean isEmptyRequest() {
        List<ActivityRecognitionMappingInfo> list = this.activityRecognitionMappingInfoList;
        return list == null || list.isEmpty();
    }

    public void removeActivityUpdatesMappingInfo(ARCallback aRCallback) {
        C1016d.m6187g(TAG, "removeActivityUpdatesMappingInfo enter, callback:" + aRCallback, true);
        if (aRCallback == null) {
            C1016d.m6183c(TAG, "callback is null");
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (ActivityRecognitionMappingInfo activityRecognitionMappingInfo : this.activityRecognitionMappingInfoList) {
            if (activityRecognitionMappingInfo.getCallback().equals(aRCallback)) {
                arrayList.add(activityRecognitionMappingInfo);
            }
        }
        this.activityRecognitionMappingInfoList.removeAll(arrayList);
        C1016d.m6187g(TAG, "removeActivityUpdatesMappingInfo success,  infos size:" + this.activityRecognitionMappingInfoList.size(), true);
    }

    public List<ActivityRecognitionMappingInfo> removeActivityUpdatesMappingInfoByPackageName(String str) {
        C1016d.m6186f(TAG, "removeActivityUpdatesMappingInfoByPackageName:enter:" + str);
        ArrayList arrayList = new ArrayList();
        for (ActivityRecognitionMappingInfo activityRecognitionMappingInfo : this.activityRecognitionMappingInfoList) {
            if (activityRecognitionMappingInfo.getClientInfo().getPackageName().equals(str)) {
                arrayList.add(activityRecognitionMappingInfo);
            }
        }
        this.activityRecognitionMappingInfoList.removeAll(arrayList);
        C1016d.m6186f(TAG, "removeActivityUpdatesMappingInfoByPackageName:exit:" + str);
        return arrayList;
    }

    public void send(List<DetectedActivity> list) {
        C1016d.m6186f(TAG, "send begin");
        if (list.size() > 0) {
            ActivityRecognitionResult activityRecognitionResult = new ActivityRecognitionResult(list, System.currentTimeMillis(), SystemClock.elapsedRealtime());
            for (ActivityRecognitionMappingInfo activityRecognitionMappingInfo : this.activityRecognitionMappingInfoList) {
                C1016d.m6186f(TAG, "sending");
                callBackWithReport(activityRecognitionMappingInfo, activityRecognitionResult);
            }
        }
    }
}
