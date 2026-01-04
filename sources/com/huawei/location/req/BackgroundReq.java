package com.huawei.location.req;

import android.content.Context;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.entity.location.common.LocationBaseRequest;

/* loaded from: classes8.dex */
public class BackgroundReq extends LocationBaseRequest {

    @Packed
    private int notificationId;

    @Packed
    private String uuid;

    public BackgroundReq() {
    }

    public int getNotificationId() {
        return this.notificationId;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setNotificationId(int i10) {
        this.notificationId = i10;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }

    public BackgroundReq(Context context) {
        super(context);
    }
}
