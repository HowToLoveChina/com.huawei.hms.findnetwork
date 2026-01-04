package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.inter.data.VideoInfo;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.C7775bv;
import com.huawei.openalliance.p169ad.views.VideoView;

/* renamed from: com.huawei.openalliance.ad.gx */
/* loaded from: classes8.dex */
public class C7167gx implements InterfaceC7168gy {

    /* renamed from: a */
    private int f32988a;

    /* renamed from: b */
    private int f32989b;

    /* renamed from: c */
    private int f32990c;

    /* renamed from: d */
    private boolean f32991d;

    /* renamed from: e */
    private VideoView f32992e;

    /* renamed from: f */
    private VideoInfo f32993f;

    /* renamed from: g */
    private InterfaceC7163gt f32994g;

    /* renamed from: h */
    private int f32995h = 0;

    /* renamed from: i */
    private Context f32996i;

    /* renamed from: j */
    private String f32997j;

    public C7167gx(Context context, VideoView videoView, VideoInfo videoInfo, InterfaceC7163gt interfaceC7163gt) {
        this.f32996i = context;
        this.f32992e = videoView;
        this.f32993f = videoInfo;
        this.f32990c = m43643a(interfaceC7163gt, videoInfo);
        this.f32988a = this.f32993f.getDownloadNetwork();
        this.f32989b = this.f32993f.getVideoPlayMode();
        this.f32991d = this.f32993f.m44585f();
        this.f32994g = interfaceC7163gt;
        String strM47540a = AbstractC7741ao.m47540a(this.f32996i, videoInfo);
        this.f32997j = strM47540a;
        AbstractC7185ho.m43821b("LinkedAlertAndPlayStrategy", "mediaPath %s", AbstractC7806cz.m48174f(strM47540a));
        AbstractC7185ho.m43818a("LinkedAlertAndPlayStrategy", "isDirectReturn %s", Boolean.valueOf(this.f32991d));
    }

    /* renamed from: c */
    private boolean m43645c() {
        InterfaceC7163gt interfaceC7163gt = this.f32994g;
        return (interfaceC7163gt == null || interfaceC7163gt.mo43631m() == null) ? false : true;
    }

    /* renamed from: d */
    private int m43646d() {
        AbstractC7185ho.m43818a("LinkedAlertAndPlayStrategy", "switchWifi, mManualOrAuto is %d", Integer.valueOf(this.f32995h));
        if (this.f32995h == 0) {
            this.f32995h = 2;
        }
        return this.f32995h + 100;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7168gy
    /* renamed from: a */
    public int mo43647a() {
        AbstractC7185ho.m43817a("LinkedAlertAndPlayStrategy", "switchToNoNetwork");
        if (this.f32992e == null) {
            return -1;
        }
        if (TextUtils.isEmpty(this.f32997j) || AbstractC7806cz.m48181j(this.f32997j)) {
            return 1;
        }
        return this.f32995h == 0 ? 102 : 0;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7168gy
    /* renamed from: b */
    public void mo43650b() {
        this.f32995h = 0;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7168gy
    /* renamed from: a */
    public int mo43648a(int i10, boolean z10) {
        this.f32995h = i10;
        AbstractC7185ho.m43818a("LinkedAlertAndPlayStrategy", "startPlayVideo， mManualOrAuto %d", Integer.valueOf(i10));
        if (!TextUtils.isEmpty(this.f32997j) && !AbstractC7806cz.m48181j(this.f32997j)) {
            return i10 + 100;
        }
        if (!C7775bv.m47831e(this.f32996i)) {
            return 1;
        }
        if (m43645c() && !AbstractC7558os.m46459G(this.f32994g.mo43625g())) {
            int autoPlayNetwork = this.f32994g.mo43631m().getAutoPlayNetwork();
            AbstractC7185ho.m43821b("LinkedAlertAndPlayStrategy", "use videoConfig, autoPlay netWork is : %s, needDataAlert: %s", Integer.valueOf(autoPlayNetwork), Boolean.valueOf(z10));
            if ((autoPlayNetwork == 2 || autoPlayNetwork == 0) && !C7775bv.m47829c(this.f32996i) && z10) {
                return i10 + 200;
            }
            if (autoPlayNetwork == 2) {
                return i10 + 100;
            }
            if (autoPlayNetwork == 1 || autoPlayNetwork == 0) {
                return i10 + 100;
            }
        }
        return (C7775bv.m47829c(this.f32996i) || this.f32990c == 1) ? i10 + 100 : !z10 ? i10 + 100 : this.f32995h + 200;
    }

    /* renamed from: a */
    private int m43643a(InterfaceC7163gt interfaceC7163gt, VideoInfo videoInfo) {
        if (interfaceC7163gt == null) {
            return 0;
        }
        return (interfaceC7163gt.mo43631m() == null || (AbstractC7558os.m46459G(interfaceC7163gt.mo43625g()) && videoInfo != null)) ? videoInfo.getAutoPlayNetwork() : interfaceC7163gt.mo43631m().getAutoPlayNetwork();
    }

    /* renamed from: a */
    private int m43644a(boolean z10) {
        AbstractC7185ho.m43821b("LinkedAlertAndPlayStrategy", "switchData, needDataAlert is %s， autoPlayNet is %s", Boolean.valueOf(z10), Integer.valueOf(this.f32990c));
        if (!z10 || this.f32990c == 1) {
            return this.f32995h + 100;
        }
        if (!TextUtils.isEmpty(this.f32997j) && !AbstractC7806cz.m48181j(this.f32997j)) {
            return this.f32995h + 100;
        }
        if (this.f32995h == 0) {
            this.f32995h = 1;
        }
        return this.f32995h + 200;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7168gy
    /* renamed from: a */
    public int mo43649a(boolean z10, boolean z11) {
        AbstractC7185ho.m43821b("LinkedAlertAndPlayStrategy", "switchToNetworkConnected, isWifi: %s, needDataAlert: %s", Boolean.valueOf(z10), Boolean.valueOf(z11));
        if (this.f32992e == null) {
            return -1;
        }
        return z10 ? m43646d() : m43644a(z11);
    }
}
