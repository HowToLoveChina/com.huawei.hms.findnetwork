package com.huawei.hms.network.embedded;

import android.net.NetworkInfo;

/* renamed from: com.huawei.hms.network.embedded.b5 */
/* loaded from: classes8.dex */
public class C5862b5 implements InterfaceC5876c5 {

    /* renamed from: a */
    public int f26408a;

    /* renamed from: b */
    public NetworkInfo.DetailedState f26409b;

    /* renamed from: c */
    public long f26410c;

    @Override // com.huawei.hms.network.embedded.InterfaceC5876c5
    /* renamed from: a */
    public NetworkInfo.DetailedState mo33855a() {
        return this.f26409b;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5876c5
    /* renamed from: b */
    public long mo33859b() {
        return this.f26410c;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5876c5
    /* renamed from: c */
    public int mo33860c() {
        return this.f26408a;
    }

    public String toString() {
        return "NetworkInfoImpl{networkType=" + this.f26408a + ", networkDetailState=" + this.f26409b + ", networkTimeStamp=" + this.f26410c + '}';
    }

    /* renamed from: a */
    public void m33856a(int i10) {
        this.f26408a = i10;
    }

    /* renamed from: a */
    public void m33857a(long j10) {
        this.f26410c = j10;
    }

    /* renamed from: a */
    public void m33858a(NetworkInfo.DetailedState detailedState) {
        this.f26409b = detailedState;
    }
}
