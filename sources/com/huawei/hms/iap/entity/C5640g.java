package com.huawei.hms.iap.entity;

import android.app.PendingIntent;
import com.huawei.hms.core.aidl.AbstractMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* renamed from: com.huawei.hms.iap.entity.g */
/* loaded from: classes8.dex */
public class C5640g extends AbstractMessageEntity {

    @Packed
    private String errMsg;

    @Packed
    private String paymentData;

    @Packed
    private String paymentSignature;

    @Packed
    private PendingIntent pendingIntent;

    @Packed
    private int retCode;

    @Packed
    private String signatureAlgorithm;

    public String getErrMsg() {
        return this.errMsg;
    }

    public String getPaymentData() {
        return this.paymentData;
    }

    public String getPaymentSignature() {
        return this.paymentSignature;
    }

    public PendingIntent getPendingIntent() {
        return this.pendingIntent;
    }

    public int getReturnCode() {
        return this.retCode;
    }

    public String getSignatureAlgorithm() {
        return this.signatureAlgorithm;
    }
}
