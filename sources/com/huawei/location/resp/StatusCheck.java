package com.huawei.location.resp;

import android.app.PendingIntent;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* loaded from: classes8.dex */
public class StatusCheck implements IMessageEntity {

    @Packed
    private PendingIntent resolution;

    @Packed
    private int statusCode;

    @Packed
    private String statusMessage;

    public PendingIntent getResolution() {
        return this.resolution;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public void setResolution(PendingIntent pendingIntent) {
        this.resolution = pendingIntent;
    }

    public void setStatusCode(int i10) {
        this.statusCode = i10;
    }

    public void setStatusMessage(String str) {
        this.statusMessage = str;
    }
}
