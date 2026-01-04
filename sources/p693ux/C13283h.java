package p693ux;

import okhttp3.AbstractC11924h0;
import okhttp3.C11910a0;
import p022ay.InterfaceC1056f;

/* renamed from: ux.h */
/* loaded from: classes9.dex */
public final class C13283h extends AbstractC11924h0 {

    /* renamed from: a */
    public final String f59998a;

    /* renamed from: b */
    public final long f59999b;

    /* renamed from: c */
    public final InterfaceC1056f f60000c;

    public C13283h(String str, long j10, InterfaceC1056f interfaceC1056f) {
        this.f59998a = str;
        this.f59999b = j10;
        this.f60000c = interfaceC1056f;
    }

    @Override // okhttp3.AbstractC11924h0
    /* renamed from: u */
    public long mo71634u() {
        return this.f59999b;
    }

    @Override // okhttp3.AbstractC11924h0
    /* renamed from: v */
    public C11910a0 mo71635v() {
        String str = this.f59998a;
        if (str != null) {
            return C11910a0.m71445d(str);
        }
        return null;
    }

    @Override // okhttp3.AbstractC11924h0
    /* renamed from: y */
    public InterfaceC1056f mo71636y() {
        return this.f60000c;
    }
}
