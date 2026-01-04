package com.huawei.openalliance.p169ad;

import com.iab.omid.library.huawei.adsession.AdSessionConfiguration;

/* renamed from: com.huawei.openalliance.ad.me */
/* loaded from: classes8.dex */
public class C7423me {

    /* renamed from: a */
    private static boolean f34488a = C7418ma.m45655a("com.iab.omid.library.huawei.adsession.AdSessionConfiguration");

    /* renamed from: b */
    private AdSessionConfiguration f34489b;

    private C7423me(EnumC7472mg enumC7472mg, EnumC7475mj enumC7475mj, EnumC7476mk enumC7476mk, EnumC7476mk enumC7476mk2, boolean z10) {
        this.f34489b = null;
        if (EnumC7472mg.m45835a() && EnumC7475mj.m45839a() && EnumC7476mk.m45841a()) {
            this.f34489b = AdSessionConfiguration.createAdSessionConfiguration(EnumC7472mg.m45834a(enumC7472mg), EnumC7475mj.m45838a(enumC7475mj), EnumC7476mk.m45840a(enumC7476mk), EnumC7476mk.m45840a(enumC7476mk2), z10);
        }
    }

    /* renamed from: a */
    public static C7423me m45679a(EnumC7472mg enumC7472mg, EnumC7475mj enumC7475mj, EnumC7476mk enumC7476mk, EnumC7476mk enumC7476mk2, boolean z10) {
        if (f34488a) {
            return new C7423me(enumC7472mg, enumC7475mj, enumC7476mk, enumC7476mk2, z10);
        }
        return null;
    }

    /* renamed from: b */
    public AdSessionConfiguration m45681b() {
        return this.f34489b;
    }

    /* renamed from: a */
    public static boolean m45680a() {
        return f34488a;
    }
}
