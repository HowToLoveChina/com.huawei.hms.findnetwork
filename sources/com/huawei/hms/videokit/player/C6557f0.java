package com.huawei.hms.videokit.player;

import android.content.Context;

/* renamed from: com.huawei.hms.videokit.player.f0 */
/* loaded from: classes8.dex */
public final class C6557f0 extends C6544b0 {

    /* renamed from: b */
    private C6609y f30458b;

    public C6557f0(Context context) {
        super(context);
        this.f30458b = C6609y.m37724b();
    }

    /* renamed from: a */
    public void m37365a(int i10) {
        if (!C6609y.m37724b().m37727c()) {
            C6550c1.m37256a("KitUpgradeDataReporter", "VideoPlayer reporting channel is off ");
            return;
        }
        if (this.f30458b == null) {
            this.f30458b = C6609y.m37724b();
        }
        C6592p c6592p = new C6592p();
        m37218a(c6592p);
        c6592p.m37590a("UpgradeCode", i10);
        this.f30458b.m37725a(1, "VideoKitOM101", c6592p);
    }
}
