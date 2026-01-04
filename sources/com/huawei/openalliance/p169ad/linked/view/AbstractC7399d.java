package com.huawei.openalliance.p169ad.linked.view;

import android.content.Context;
import android.view.View;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh;
import com.huawei.openalliance.p169ad.C7162gs;
import com.huawei.openalliance.p169ad.views.AutoScaleSizeRelativeLayout;

/* renamed from: com.huawei.openalliance.ad.linked.view.d */
/* loaded from: classes2.dex */
public abstract class AbstractC7399d extends AutoScaleSizeRelativeLayout {

    /* renamed from: b */
    protected C7162gs f34411b;

    /* renamed from: c */
    boolean f34412c;

    /* renamed from: d */
    boolean f34413d;

    /* renamed from: e */
    protected AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh f34414e;

    public AbstractC7399d(Context context) {
        super(context);
        this.f34412c = false;
        this.f34413d = false;
        this.f34414e = new AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh(this) { // from class: com.huawei.openalliance.ad.linked.view.d.1
            @Override // com.huawei.openalliance.p169ad.AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh
            /* renamed from: a */
            public void mo45252a() {
                AbstractC7399d.this.mo45563d();
            }

            @Override // com.huawei.openalliance.p169ad.AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh
            /* renamed from: a */
            public void mo45253a(int i10) {
                AbstractC7399d.this.m45594b(i10);
            }

            @Override // com.huawei.openalliance.p169ad.AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh
            /* renamed from: a */
            public void mo45254a(long j10, int i10) {
                AbstractC7399d.this.m45594b(0);
            }
        };
    }

    /* renamed from: a */
    public void mo45558a() {
    }

    /* renamed from: b */
    public void mo45561b() {
    }

    /* renamed from: c */
    public void mo45562c() {
    }

    /* renamed from: d */
    public void mo45563d() {
    }

    public int getAutoPlayAreaPercentageThresshold() {
        return 100;
    }

    public int getHiddenAreaPercentageThreshhold() {
        return 10;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh abstractViewTreeObserverOnGlobalLayoutListenerC7334jh = this.f34414e;
        if (abstractViewTreeObserverOnGlobalLayoutListenerC7334jh != null) {
            abstractViewTreeObserverOnGlobalLayoutListenerC7334jh.m45301h();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh abstractViewTreeObserverOnGlobalLayoutListenerC7334jh = this.f34414e;
        if (abstractViewTreeObserverOnGlobalLayoutListenerC7334jh != null) {
            abstractViewTreeObserverOnGlobalLayoutListenerC7334jh.m45302i();
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        AbstractViewTreeObserverOnGlobalLayoutListenerC7334jh abstractViewTreeObserverOnGlobalLayoutListenerC7334jh = this.f34414e;
        if (abstractViewTreeObserverOnGlobalLayoutListenerC7334jh != null) {
            abstractViewTreeObserverOnGlobalLayoutListenerC7334jh.m45303j();
        }
    }

    public void setLinkedNativeAd(C7162gs c7162gs) {
        if (!(c7162gs instanceof C7162gs)) {
            c7162gs = null;
        }
        this.f34411b = c7162gs;
    }

    /* renamed from: b */
    public void m45594b(int i10) {
        AbstractC7185ho.m43820b("LinkedMediaView", "visiblePercentage is " + i10);
        if (i10 >= getAutoPlayAreaPercentageThresshold()) {
            this.f34413d = false;
            if (this.f34412c) {
                return;
            }
            this.f34412c = true;
            mo45558a();
            return;
        }
        this.f34412c = false;
        int hiddenAreaPercentageThreshhold = getHiddenAreaPercentageThreshhold();
        AbstractC7185ho.m43820b("LinkedMediaView", "HiddenAreaPercentageThreshhold is " + hiddenAreaPercentageThreshhold);
        if (i10 > 100 - hiddenAreaPercentageThreshhold) {
            if (this.f34413d) {
                mo45562c();
            }
            this.f34413d = false;
        } else {
            if (this.f34413d) {
                return;
            }
            this.f34413d = true;
            mo45561b();
        }
    }
}
