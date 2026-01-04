package com.huawei.hms.locationSdk;

import android.os.Parcelable;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.location.router.entity.StatusInfo;

/* renamed from: com.huawei.hms.locationSdk.q1 */
/* loaded from: classes8.dex */
class C5748q1 implements ResponseErrorCode {

    /* renamed from: a */
    private final int f25563a;

    /* renamed from: b */
    private final int f25564b;

    /* renamed from: c */
    private final String f25565c;

    /* renamed from: d */
    private final String f25566d;

    public C5748q1(StatusInfo statusInfo, String str) {
        this.f25563a = statusInfo.getStatusCode();
        this.f25564b = statusInfo.getErrorCode();
        this.f25565c = statusInfo.getErrorMessage();
        this.f25566d = str;
    }

    @Override // com.huawei.hms.common.internal.ResponseErrorCode
    public int getErrorCode() {
        return this.f25564b;
    }

    @Override // com.huawei.hms.common.internal.ResponseErrorCode
    public String getErrorReason() {
        return this.f25565c;
    }

    @Override // com.huawei.hms.common.internal.ResponseErrorCode
    public Parcelable getParcelable() {
        return null;
    }

    @Override // com.huawei.hms.common.internal.ResponseErrorCode
    public String getResolution() {
        return null;
    }

    @Override // com.huawei.hms.common.internal.ResponseErrorCode
    public int getStatusCode() {
        return this.f25563a;
    }

    @Override // com.huawei.hms.common.internal.ResponseErrorCode
    public String getTransactionId() {
        return this.f25566d;
    }

    @Override // com.huawei.hms.common.internal.ResponseErrorCode
    public boolean hasResolution() {
        return false;
    }
}
