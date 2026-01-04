package com.huawei.hms.network.embedded;

/* renamed from: com.huawei.hms.network.embedded.l9 */
/* loaded from: classes8.dex */
public final class C5999l9 extends AbstractC6140w7 {

    /* renamed from: b */
    public final String f27445b;

    /* renamed from: c */
    public final long f27446c;

    /* renamed from: d */
    public final InterfaceC5896db f27447d;

    public C5999l9(String str, long j10, InterfaceC5896db interfaceC5896db) {
        this.f27445b = str;
        this.f27446c = j10;
        this.f27447d = interfaceC5896db;
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6140w7
    /* renamed from: v */
    public long mo34710v() {
        return this.f27446c;
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6140w7
    /* renamed from: w */
    public C6036o7 mo34711w() {
        String str = this.f27445b;
        if (str != null) {
            return C6036o7.m34923b(str);
        }
        return null;
    }

    @Override // com.huawei.hms.network.embedded.AbstractC6140w7
    /* renamed from: x */
    public InterfaceC5896db mo34712x() {
        return this.f27447d;
    }
}
