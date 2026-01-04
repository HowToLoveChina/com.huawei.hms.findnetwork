package com.huawei.hms.videokit.player;

import android.content.Context;
import com.huawei.secure.android.common.util.SafeString;
import java.util.UUID;

/* renamed from: com.huawei.hms.videokit.player.k */
/* loaded from: classes8.dex */
class C6582k extends WisePlayerFactory {

    /* renamed from: p */
    private Context f30544p;

    public C6582k(Context context) {
        this.f30544p = context;
    }

    @Override // com.huawei.hms.videokit.player.WisePlayerFactory
    public Preloader createPreloader() throws CreateComponentException {
        String str;
        int i10;
        long jM37688f = C6600t0.m37688f();
        if (WisePlayerFactory.f30260d && WisePlayerFactory.m37119g() != null) {
            C6562i c6562iM37394a = C6562i.m37394a(this.f30544p);
            C6556f.m37359a().m37364a("createPreloader", jM37688f, 0, null);
            return c6562iM37394a;
        }
        C6550c1.m37265d("WisePlayerFactoryImp", "create Preloader fail");
        C6556f.m37359a().m37364a("createPreloader", jM37688f, 1, null);
        if (WisePlayerFactory.m37119g() == null) {
            str = "The WisePlayerFactory is not initialized";
            i10 = 1;
        } else {
            str = "Failed to load player plugin";
            i10 = 0;
        }
        C6550c1.m37265d("WisePlayerFactoryImp", str + ", exception code is " + i10);
        throw new CreateComponentException(i10, str);
    }

    @Override // com.huawei.hms.videokit.player.WisePlayerFactory
    public WisePlayer createWisePlayer() throws CreateComponentException {
        long jM37688f = C6600t0.m37688f();
        String strReplace = SafeString.replace(UUID.randomUUID().toString(), "-", "");
        if (WisePlayerFactory.m37119g() != null) {
            C6584l c6584lM37485a = C6584l.m37485a(this.f30544p, strReplace);
            C6556f.m37359a().m37364a("createWisePlayer", jM37688f, 0, strReplace);
            return c6584lM37485a;
        }
        C6556f.m37359a().m37364a("createWisePlayer", jM37688f, 1, strReplace);
        C6550c1.m37265d("WisePlayerFactoryImp", "The WisePlayerFactory is not initialized");
        throw new CreateComponentException(1, "The WisePlayerFactory is not initialized");
    }
}
