package com.huawei.hicloud.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.findnetwork.comm.request.bean.DisconnectNotificationParams;
import com.huawei.phoneservice.feedbackcommon.utils.AsCache;

/* loaded from: classes6.dex */
public class DestopPopupPolicy {

    @SerializedName("requestCacheDuration")
    private int requestCacheDuration = DisconnectNotificationParams.DEFAULT_NORMAL_ADV_DURATION;

    @SerializedName("silentPeriodCheckRandomDuration ")
    private int silentPeriodCheckRandomDuration = AsCache.TIME_HOUR;

    @SerializedName("screenUnlockCheckInteval")
    private int screenUnlockCheckInteval = 3;

    @SerializedName("screenUnlockCheckTimes")
    private int screenUnlockCheckTimes = 5;

    public int getRequestCacheDuration() {
        return this.requestCacheDuration;
    }

    public int getScreenUnlockCheckInteval() {
        return this.screenUnlockCheckInteval;
    }

    public int getScreenUnlockCheckTimes() {
        return this.screenUnlockCheckTimes;
    }

    public int getSilentPeriodCheckRandomDuration() {
        return this.silentPeriodCheckRandomDuration;
    }

    public void setRequestCacheDuration(int i10) {
        this.requestCacheDuration = i10;
    }

    public void setScreenUnlockCheckInteval(int i10) {
        this.screenUnlockCheckInteval = i10;
    }

    public void setScreenUnlockCheckTimes(int i10) {
        this.screenUnlockCheckTimes = i10;
    }

    public void setSilentPeriodCheckRandomDuration(int i10) {
        this.silentPeriodCheckRandomDuration = i10;
    }
}
