package com.huawei.openalliance.p169ad.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8128u;

/* loaded from: classes2.dex */
public class LinkedSurfaceView extends RelativeLayout implements InterfaceC8128u {

    /* renamed from: a */
    private AbstractC8078b f36406a;

    /* renamed from: b */
    private int f36407b;

    /* renamed from: c */
    private int f36408c;

    public LinkedSurfaceView(Context context) {
        super(context);
        m48798a(context);
    }

    /* renamed from: a */
    public void m48799a() {
        this.f36406a.destroyView();
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8128u
    /* renamed from: b */
    public void mo48803b() {
        this.f36406a.mo48803b();
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8128u
    /* renamed from: c */
    public void mo48804c() {
        this.f36406a.mo48804c();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        AbstractC7185ho.m43820b("LinkedSurfaceView", "onAttachedToWindow");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AbstractC7185ho.m43820b("LinkedSurfaceView", "onDetachedFromWindow");
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int i14;
        super.onLayout(z10, i10, i11, i12, i13);
        if (this.f36408c == 0 && this.f36407b == 0) {
            this.f36407b = i12 - i10;
            this.f36408c = i13 - i11;
        }
        if (this.f36406a.getVideoHeight() == 0 || (i14 = this.f36408c) == 0) {
            return;
        }
        this.f36406a.m50080a(this.f36407b, i14);
        AbstractC8078b abstractC8078b = this.f36406a;
        float videoWidth = (abstractC8078b.getVideoWidth() * 1.0f) / this.f36406a.getVideoHeight();
        int i15 = this.f36407b;
        int i16 = this.f36408c;
        abstractC8078b.mo48785a(videoWidth, (i15 * 1.0f) / i16, i15, i16);
    }

    public void setAutoScaleResizeLayoutOnVideoSizeChange(boolean z10) {
        this.f36406a.setAutoScaleResizeLayoutOnVideoSizeChange(z10);
    }

    public void setNeedPauseOnSurfaceDestory(boolean z10) {
        this.f36406a.setNeedPauseOnSurfaceDestory(z10);
    }

    public void setScreenOnWhilePlaying(boolean z10) {
        this.f36406a.setScreenOnWhilePlaying(z10);
    }

    public void setVideoRatio(Float f10) {
        this.f36406a.setVideoRatio(f10);
    }

    public void setVideoScaleMode(int i10) {
        this.f36406a.setVideoScaleMode(i10);
    }

    public LinkedSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m48798a(context);
    }

    /* renamed from: a */
    public void m48800a(float f10, float f11, float f12, int i10, int i11) {
        super.setScaleY(f10);
        super.setTranslationY(f11);
        super.setScaleX(f12);
        this.f36408c = i11;
        this.f36407b = i10;
        if (this.f36406a.getVideoHeight() == 0 || i11 == 0) {
            return;
        }
        this.f36406a.m50080a(i10, i11);
        this.f36406a.mo48785a((r1.getVideoWidth() * 1.0f) / this.f36406a.getVideoHeight(), (i10 * 1.0f) / i11, i10, i11);
    }

    public LinkedSurfaceView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        m48798a(context);
    }

    /* renamed from: a */
    public void m48801a(float f10, float f11, int i10, int i11) {
        this.f36406a.mo48785a(f10, f11, i10, i11);
    }

    /* renamed from: a */
    private void m48798a(Context context) {
        this.f36406a = new C8075aj(context);
        addView(this.f36406a, new RelativeLayout.LayoutParams(-1, -1));
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8128u
    /* renamed from: a */
    public void mo48802a(C8099g c8099g) {
        this.f36406a.mo48802a(c8099g);
    }
}
