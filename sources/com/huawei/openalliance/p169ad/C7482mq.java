package com.huawei.openalliance.p169ad;

import com.iab.omid.library.huawei.adsession.media.Position;
import com.iab.omid.library.huawei.adsession.media.VastProperties;

/* renamed from: com.huawei.openalliance.ad.mq */
/* loaded from: classes8.dex */
public class C7482mq {

    /* renamed from: a */
    private static boolean f34685a = C7418ma.m45655a("com.iab.omid.library.huawei.adsession.media.VastProperties");

    /* renamed from: b */
    private final boolean f34686b = false;

    /* renamed from: c */
    private final boolean f34687c;

    /* renamed from: d */
    private final VastProperties f34688d;

    /* renamed from: e */
    private final EnumC7481mp f34689e;

    /* renamed from: f */
    private Float f34690f;

    private C7482mq(float f10, boolean z10, EnumC7481mp enumC7481mp, VastProperties vastProperties) {
        this.f34690f = Float.valueOf(0.0f);
        this.f34690f = Float.valueOf(f10);
        this.f34687c = z10;
        this.f34689e = enumC7481mp;
        this.f34688d = vastProperties;
    }

    /* renamed from: a */
    public static C7482mq m45849a(float f10, boolean z10, EnumC7481mp enumC7481mp) {
        Position positionM45848a;
        return new C7482mq(f10, z10, enumC7481mp, (enumC7481mp == null || !m45850a() || (positionM45848a = EnumC7481mp.m45848a(enumC7481mp)) == null) ? null : VastProperties.createVastPropertiesForSkippableMedia(f10, z10, positionM45848a));
    }

    /* renamed from: b */
    public VastProperties m45851b() {
        return this.f34688d;
    }

    /* renamed from: a */
    public static boolean m45850a() {
        return f34685a;
    }
}
