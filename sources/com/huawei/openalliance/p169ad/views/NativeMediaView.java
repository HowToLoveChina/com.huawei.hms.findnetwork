package com.huawei.openalliance.p169ad.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.huawei.openalliance.p169ad.AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.inter.data.C7302e;
import com.huawei.openalliance.p169ad.inter.data.INativeAd;
import com.huawei.openalliance.p169ad.monitor.listener.ViewShowAreaListener;

@OuterVisible
/* loaded from: classes2.dex */
public abstract class NativeMediaView extends AutoScaleSizeRelativeLayout {

    /* renamed from: a */
    boolean f36409a;

    /* renamed from: b */
    boolean f36410b;

    /* renamed from: c */
    protected C7302e f36411c;

    /* renamed from: d */
    protected int f36412d;

    /* renamed from: e */
    protected int f36413e;

    /* renamed from: f */
    protected AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh f36414f;

    /* renamed from: g */
    private ViewShowAreaListener f36415g;

    public NativeMediaView(Context context) {
        super(context);
        this.f36409a = false;
        this.f36410b = false;
        this.f36412d = -1;
        this.f36413e = 0;
        this.f36414f = new AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh(this) { // from class: com.huawei.openalliance.ad.views.NativeMediaView.1
            @Override // com.huawei.openalliance.p169ad.AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh
            /* renamed from: a */
            public void mo45252a() {
                NativeMediaView.this.mo48807b();
            }

            @Override // com.huawei.openalliance.p169ad.AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh
            /* renamed from: a */
            public void mo45253a(int i10) {
                NativeMediaView.this.m48806a(i10);
            }

            @Override // com.huawei.openalliance.p169ad.AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh
            /* renamed from: a */
            public void mo45254a(long j10, int i10) {
                NativeMediaView.this.m48806a(0);
                NativeMediaView.this.m48805a();
            }
        };
    }

    /* renamed from: a */
    public void m48805a() {
    }

    /* renamed from: b */
    public void mo48807b() {
    }

    /* renamed from: c */
    public void mo48808c() {
    }

    /* renamed from: d */
    public void mo48809d() {
    }

    /* renamed from: e */
    public void mo48810e() {
    }

    public int getAutoPlayAreaPercentageThresshold() {
        return 100;
    }

    public int getHiddenAreaPercentageThreshhold() {
        return 10;
    }

    public int getPlayedProgress() {
        return -1;
    }

    public int getPlayedTime() {
        return -1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh abstractViewTreeObserverOnGlobalLayoutListenerC7334jh = this.f36414f;
        if (abstractViewTreeObserverOnGlobalLayoutListenerC7334jh != null) {
            abstractViewTreeObserverOnGlobalLayoutListenerC7334jh.m45301h();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh abstractViewTreeObserverOnGlobalLayoutListenerC7334jh = this.f36414f;
        if (abstractViewTreeObserverOnGlobalLayoutListenerC7334jh != null) {
            abstractViewTreeObserverOnGlobalLayoutListenerC7334jh.m45302i();
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh abstractViewTreeObserverOnGlobalLayoutListenerC7334jh = this.f36414f;
        if (abstractViewTreeObserverOnGlobalLayoutListenerC7334jh != null) {
            abstractViewTreeObserverOnGlobalLayoutListenerC7334jh.m45303j();
        }
    }

    public void setNativeAd(INativeAd iNativeAd) {
        this.f36411c = iNativeAd instanceof C7302e ? (C7302e) iNativeAd : null;
    }

    @OuterVisible
    public void setViewShowAreaListener(ViewShowAreaListener viewShowAreaListener) {
        this.f36415g = viewShowAreaListener;
    }

    public NativeMediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f36409a = false;
        this.f36410b = false;
        this.f36412d = -1;
        this.f36413e = 0;
        this.f36414f = new AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh(this) { // from class: com.huawei.openalliance.ad.views.NativeMediaView.1
            @Override // com.huawei.openalliance.p169ad.AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh
            /* renamed from: a */
            public void mo45252a() {
                NativeMediaView.this.mo48807b();
            }

            @Override // com.huawei.openalliance.p169ad.AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh
            /* renamed from: a */
            public void mo45253a(int i10) {
                NativeMediaView.this.m48806a(i10);
            }

            @Override // com.huawei.openalliance.p169ad.AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh
            /* renamed from: a */
            public void mo45254a(long j10, int i10) {
                NativeMediaView.this.m48806a(0);
                NativeMediaView.this.m48805a();
            }
        };
    }

    /* renamed from: a */
    public void m48806a(int i10) {
        ViewShowAreaListener viewShowAreaListener = this.f36415g;
        if (viewShowAreaListener != null) {
            viewShowAreaListener.onUpdateShowArea(i10);
        }
        if (i10 >= getAutoPlayAreaPercentageThresshold()) {
            this.f36410b = false;
            if (this.f36409a) {
                return;
            }
            this.f36409a = true;
            mo48808c();
            return;
        }
        this.f36409a = false;
        if (i10 > 100 - getHiddenAreaPercentageThreshhold()) {
            if (this.f36410b) {
                mo48810e();
            }
            this.f36410b = false;
        } else {
            if (this.f36410b) {
                return;
            }
            this.f36410b = true;
            mo48809d();
        }
    }

    public NativeMediaView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f36409a = false;
        this.f36410b = false;
        this.f36412d = -1;
        this.f36413e = 0;
        this.f36414f = new AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh(this) { // from class: com.huawei.openalliance.ad.views.NativeMediaView.1
            @Override // com.huawei.openalliance.p169ad.AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh
            /* renamed from: a */
            public void mo45252a() {
                NativeMediaView.this.mo48807b();
            }

            @Override // com.huawei.openalliance.p169ad.AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh
            /* renamed from: a */
            public void mo45253a(int i102) {
                NativeMediaView.this.m48806a(i102);
            }

            @Override // com.huawei.openalliance.p169ad.AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh
            /* renamed from: a */
            public void mo45254a(long j10, int i102) {
                NativeMediaView.this.m48806a(0);
                NativeMediaView.this.m48805a();
            }
        };
    }

    @TargetApi(21)
    public NativeMediaView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f36409a = false;
        this.f36410b = false;
        this.f36412d = -1;
        this.f36413e = 0;
        this.f36414f = new AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh(this) { // from class: com.huawei.openalliance.ad.views.NativeMediaView.1
            @Override // com.huawei.openalliance.p169ad.AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh
            /* renamed from: a */
            public void mo45252a() {
                NativeMediaView.this.mo48807b();
            }

            @Override // com.huawei.openalliance.p169ad.AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh
            /* renamed from: a */
            public void mo45253a(int i102) {
                NativeMediaView.this.m48806a(i102);
            }

            @Override // com.huawei.openalliance.p169ad.AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh
            /* renamed from: a */
            public void mo45254a(long j10, int i102) {
                NativeMediaView.this.m48806a(0);
                NativeMediaView.this.m48805a();
            }
        };
    }
}
