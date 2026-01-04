package com.huawei.openalliance.p169ad.inter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.huawei.hms.ads.VideoConfiguration;
import com.huawei.openalliance.p169ad.inter.listeners.IExSplashCallback;
import com.huawei.openalliance.p169ad.inter.listeners.LandingPageAction;
import com.huawei.openalliance.p169ad.inter.listeners.LinkedAdListener;
import com.huawei.openalliance.p169ad.media.IMultiMediaPlayingManager;

/* renamed from: com.huawei.openalliance.ad.inter.f */
/* loaded from: classes2.dex */
public interface InterfaceC7308f {
    /* renamed from: a */
    void mo44042a(BroadcastReceiver broadcastReceiver);

    /* renamed from: a */
    void mo44043a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter);

    /* renamed from: a */
    void mo44044a(VideoConfiguration videoConfiguration, boolean z10, boolean z11, int i10);

    /* renamed from: a */
    void mo44045a(String str);

    /* renamed from: a */
    void mo44046a(boolean z10);

    /* renamed from: b */
    LandingPageAction mo44047b();

    /* renamed from: b */
    void mo44048b(String str);

    /* renamed from: c */
    IMultiMediaPlayingManager mo44049c();

    /* renamed from: c */
    void mo44050c(String str);

    /* renamed from: d */
    Context mo44051d();

    /* renamed from: e */
    boolean mo44052e();

    /* renamed from: f */
    IExSplashCallback mo44053f();

    /* renamed from: g */
    LinkedAdListener mo44054g();

    /* renamed from: h */
    int mo44055h();

    /* renamed from: i */
    int mo44056i();

    /* renamed from: j */
    Integer mo44057j();

    /* renamed from: k */
    boolean mo44058k();

    /* renamed from: l */
    AppStatusQuery mo44059l();

    /* renamed from: m */
    boolean mo44060m();

    /* renamed from: n */
    boolean mo44061n();

    /* renamed from: o */
    Boolean mo44062o();
}
