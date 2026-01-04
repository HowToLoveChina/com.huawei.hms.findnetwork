package com.huawei.openalliance.p169ad;

import android.app.Activity;
import android.view.View;
import com.huawei.openalliance.p169ad.activity.PPSActivity;
import com.huawei.openalliance.p169ad.linked.view.C7398c;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.views.PPSWebView;

/* renamed from: com.huawei.openalliance.ad.gr */
/* loaded from: classes8.dex */
public class C7161gr {

    /* renamed from: a */
    private PPSActivity.InterfaceC6882b f32959a;

    /* renamed from: b */
    private InterfaceC7163gt f32960b;

    /* renamed from: c */
    private PPSWebView f32961c;

    /* renamed from: d */
    private InterfaceC7337jk f32962d;

    public C7161gr(InterfaceC7163gt interfaceC7163gt, InterfaceC7337jk interfaceC7337jk, PPSWebView pPSWebView) {
        this.f32960b = interfaceC7163gt;
        this.f32962d = interfaceC7337jk;
        this.f32961c = pPSWebView;
    }

    /* renamed from: e */
    private void m43610e() {
        InterfaceC7337jk interfaceC7337jk = this.f32962d;
        if (interfaceC7337jk instanceof C7398c) {
            ((C7398c) interfaceC7337jk).setPlayModeChangeListener(this.f32959a);
        }
    }

    /* renamed from: a */
    public View m43611a(Activity activity) {
        InterfaceC7163gt interfaceC7163gt = this.f32960b;
        if (interfaceC7163gt == null) {
            return this.f32961c;
        }
        if (!interfaceC7163gt.mo43629k() || !this.f32960b.mo43630l() || AbstractC7811dd.m48300a(activity)) {
            return this.f32961c;
        }
        InterfaceC7163gt interfaceC7163gt2 = this.f32960b;
        if (interfaceC7163gt2 instanceof C7162gs) {
            InterfaceC7337jk interfaceC7337jk = this.f32962d;
            if ((interfaceC7337jk instanceof C7398c) && this.f32961c != null) {
                C7398c c7398c = (C7398c) interfaceC7337jk;
                c7398c.m45587a(interfaceC7163gt2);
                c7398c.m45588a(this.f32961c);
                m43610e();
                return c7398c;
            }
        }
        return this.f32961c;
    }

    /* renamed from: b */
    public void m43615b() {
        InterfaceC7337jk interfaceC7337jk = this.f32962d;
        if (interfaceC7337jk instanceof C7398c) {
            ((C7398c) interfaceC7337jk).m45589b();
        }
    }

    /* renamed from: c */
    public void m43616c() {
        InterfaceC7337jk interfaceC7337jk = this.f32962d;
        if (interfaceC7337jk instanceof C7398c) {
            ((C7398c) interfaceC7337jk).m45590c();
        }
    }

    /* renamed from: d */
    public InterfaceC7337jk m43617d() {
        return this.f32962d;
    }

    /* renamed from: a */
    public void m43612a() {
        AbstractC7185ho.m43817a("LinkedLandVideoViewAdapter", "destroy adapter");
        InterfaceC7337jk interfaceC7337jk = this.f32962d;
        if (interfaceC7337jk instanceof C7398c) {
            ((C7398c) interfaceC7337jk).m45585a();
        }
    }

    /* renamed from: a */
    public void m43613a(PPSActivity.InterfaceC6882b interfaceC6882b) {
        this.f32959a = interfaceC6882b;
    }

    /* renamed from: a */
    public void m43614a(InterfaceC7337jk interfaceC7337jk) {
        this.f32962d = interfaceC7337jk;
    }
}
