package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.inter.data.VideoInfo;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.views.C8074ai;
import com.huawei.openalliance.p169ad.views.PPSDestView;
import com.huawei.openalliance.p169ad.views.PPSLinkedView;

/* renamed from: com.huawei.openalliance.ad.uj */
/* loaded from: classes8.dex */
public class C7715uj {

    /* renamed from: a */
    protected InterfaceC7416lz f35774a = new C7405lo();

    /* renamed from: a */
    public void m47375a() {
        this.f35774a.mo45610a(EnumC7480mo.CLICK);
    }

    /* renamed from: b */
    public void m47379b() {
        this.f35774a.mo45613b();
    }

    /* renamed from: c */
    public void m47381c() {
        this.f35774a.mo45623j();
    }

    /* renamed from: d */
    public void m47382d() {
        this.f35774a.mo45618e();
    }

    /* renamed from: e */
    public void m47383e() {
        this.f35774a.mo45625l();
    }

    /* renamed from: f */
    public void m47384f() {
        this.f35774a.mo45622i();
    }

    /* renamed from: g */
    public void m47385g() {
        this.f35774a.mo45621h();
    }

    /* renamed from: h */
    public void m47386h() {
        this.f35774a.mo45620g();
    }

    /* renamed from: i */
    public void m47387i() {
        this.f35774a.mo45624k();
    }

    /* renamed from: a */
    public void m47376a(int i10) {
        this.f35774a.mo45605a(i10);
    }

    /* renamed from: b */
    public void m47380b(int i10) {
        this.f35774a.mo45614b(i10);
    }

    /* renamed from: a */
    public void m47377a(VideoInfo videoInfo) {
        if (this.f35774a == null || videoInfo == null) {
            return;
        }
        AbstractC7185ho.m43820b("LinkedSplashOmProxy", "om start");
        this.f35774a.mo45606a(videoInfo.getVideoDuration(), !"y".equals(videoInfo.getSoundSwitch()));
    }

    /* renamed from: a */
    public void m47378a(PPSLinkedView pPSLinkedView, ContentRecord contentRecord, PPSDestView pPSDestView, Context context, C8074ai c8074ai) {
        this.f35774a.mo45613b();
        C7405lo c7405lo = new C7405lo();
        this.f35774a = c7405lo;
        c7405lo.mo45607a(context, contentRecord, pPSDestView, true);
        InterfaceC7474mi interfaceC7474miMo45604a = this.f35774a.mo45604a();
        if (interfaceC7474miMo45604a != null) {
            interfaceC7474miMo45604a.mo45609a(c8074ai, EnumC7473mh.VIDEO_CONTROLS, null);
            interfaceC7474miMo45604a.mo45609a(pPSLinkedView, EnumC7473mh.OTHER, null);
            this.f35774a.mo45612a(false);
            this.f35774a.mo45615b(true);
            this.f35774a.mo45616c();
            this.f35774a.mo45611a(C7482mq.m45849a(0.0f, true, EnumC7481mp.STANDALONE));
        }
    }
}
