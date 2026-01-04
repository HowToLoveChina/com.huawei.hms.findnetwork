package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.beans.inner.CountryCodeBean;

/* renamed from: com.huawei.openalliance.ad.cf */
/* loaded from: classes8.dex */
public class C6989cf extends C6986cc {

    /* renamed from: c */
    private static InterfaceC6998co f32116c;

    /* renamed from: d */
    private static final byte[] f32117d = new byte[0];

    /* renamed from: e */
    private CountryCodeBean f32118e;

    public C6989cf(Context context) {
        super(context);
        this.f32118e = new CountryCodeBean(context);
    }

    /* renamed from: b */
    public static InterfaceC6998co m41211b(Context context) {
        return m41212c(context);
    }

    /* renamed from: c */
    private static InterfaceC6998co m41212c(Context context) {
        InterfaceC6998co interfaceC6998co;
        synchronized (f32117d) {
            try {
                if (f32116c == null) {
                    f32116c = new C6989cf(context);
                }
                interfaceC6998co = f32116c;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return interfaceC6998co;
    }

    @Override // com.huawei.openalliance.p169ad.C6986cc, com.huawei.openalliance.p169ad.InterfaceC6998co
    /* renamed from: a */
    public boolean mo41170a() {
        return "CN".equalsIgnoreCase(this.f32118e.m39390a());
    }

    @Override // com.huawei.openalliance.p169ad.C6986cc, com.huawei.openalliance.p169ad.InterfaceC6998co
    /* renamed from: d */
    public boolean mo41175d() {
        return mo41170a();
    }

    @Override // com.huawei.openalliance.p169ad.C6986cc, com.huawei.openalliance.p169ad.InterfaceC6998co
    /* renamed from: l */
    public boolean mo41183l() {
        return false;
    }
}
