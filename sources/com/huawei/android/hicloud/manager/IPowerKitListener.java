package com.huawei.android.hicloud.manager;

/* loaded from: classes3.dex */
public interface IPowerKitListener {
    /* renamed from: a */
    void mo16419a();

    /* renamed from: b */
    void mo16420b();

    void onPowerBaseLineUsing(String str, String str2, long j10, int i10, String str3);

    void onPowerOverUsing(String str, int i10, long j10, long j11, String str2);

    void onStateChanged(int i10, int i11, int i12, String str, int i13);
}
