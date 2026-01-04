package com.huawei.hms.iap.entity;

import android.app.PendingIntent;
import com.huawei.hms.core.aidl.AbstractMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* renamed from: com.huawei.hms.iap.entity.b */
/* loaded from: classes8.dex */
public class C5635b extends AbstractMessageEntity {

    @Packed
    private int accountFlag;

    @Packed
    private String carrierId;

    @Packed
    private String country;

    @Packed
    private PendingIntent pendingIntent;

    @Packed
    private int returnCode;

    @Packed
    private String returnDesc;

    public int getAccountFlag() {
        return this.accountFlag;
    }

    public String getCarrierId() {
        return this.carrierId;
    }

    public String getCountry() {
        return this.country;
    }

    public PendingIntent getPendingIntent() {
        return this.pendingIntent;
    }

    public int getReturnCode() {
        return this.returnCode;
    }

    public String getReturnDesc() {
        return this.returnDesc;
    }

    public void setReturnCode(int i10) {
        this.returnCode = i10;
    }

    public void setReturnDesc(String str) {
        this.returnDesc = str;
    }
}
