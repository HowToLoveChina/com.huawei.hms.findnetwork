package com.huawei.openalliance.p169ad.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8127t;

/* renamed from: com.huawei.openalliance.ad.views.ai */
/* loaded from: classes2.dex */
public class C8074ai extends AutoScaleSizeRelativeLayout implements InterfaceC8127t {

    /* renamed from: a */
    private LinkedSurfaceView f37507a;

    /* renamed from: b */
    private PPSWLSView f37508b;

    /* renamed from: c */
    private PPSSplashAdSourceView f37509c;

    /* renamed from: d */
    private ViewStub f37510d;

    /* renamed from: e */
    private PPSSplashProView f37511e;

    /* renamed from: f */
    private PPSSplashSwipeView f37512f;

    /* renamed from: g */
    private PPSSplashTwistView f37513g;

    /* renamed from: h */
    private PPSSplashSwipeClickView f37514h;

    /* renamed from: i */
    private PPSSplashTwistClickView f37515i;

    public C8074ai(Context context) {
        super(context);
        m49997a(context);
    }

    /* renamed from: a */
    public void m49998a() {
        if (this.f37507a.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.f37507a.getParent()).removeView(this.f37507a);
        }
    }

    /* renamed from: b */
    public void m49999b() {
        removeAllViews();
        this.f37507a = null;
        this.f37508b = null;
        this.f37509c = null;
        this.f37510d = null;
        this.f37511e = null;
        this.f37512f = null;
        this.f37513g = null;
        this.f37514h = null;
        this.f37515i = null;
    }

    public LinkedSurfaceView getLinkedVideoView() {
        return this.f37507a;
    }

    public PPSSplashAdSourceView getPpsSplashAdSourceView() {
        return this.f37509c;
    }

    public PPSWLSView getPpswlsView() {
        return this.f37508b;
    }

    public PPSSplashProView getProView() {
        return this.f37511e;
    }

    public int getStatusBarHeight() {
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        return iArr[1];
    }

    public PPSSplashSwipeClickView getSwipeClickView() {
        return this.f37514h;
    }

    public PPSSplashSwipeView getSwipeView() {
        return this.f37512f;
    }

    public PPSSplashTwistClickView getTwistClickView() {
        return this.f37515i;
    }

    public PPSSplashTwistView getTwistView() {
        return this.f37513g;
    }

    public ViewStub getViewStub() {
        return this.f37510d;
    }

    /* renamed from: a */
    private void m49997a(Context context) {
        ((RelativeLayout) LayoutInflater.from(context).inflate(C6849R.layout.hiad_splash_linked_video_view, this)).setBackgroundColor(0);
        this.f37507a = (LinkedSurfaceView) findViewById(C6849R.id.hiad_linked_video_view);
        PPSWLSView pPSWLSView = (PPSWLSView) findViewById(C6849R.id.splash_wls_view);
        this.f37508b = pPSWLSView;
        pPSWLSView.setVisibility(8);
        PPSSplashAdSourceView pPSSplashAdSourceView = (PPSSplashAdSourceView) findViewById(C6849R.id.splash_ad_source_view);
        this.f37509c = pPSSplashAdSourceView;
        pPSSplashAdSourceView.setVisibility(8);
        this.f37510d = (ViewStub) findViewById(C6849R.id.hiad_logo_stub);
        this.f37511e = (PPSSplashProView) findViewById(C6849R.id.hiad_splash_pro_view);
        this.f37512f = (PPSSplashSwipeView) findViewById(C6849R.id.hiad_splash_swipe_view);
        this.f37513g = (PPSSplashTwistView) findViewById(C6849R.id.hiad_splash_twist_view);
        this.f37515i = (PPSSplashTwistClickView) findViewById(C6849R.id.hiad_splash_twist_click_view);
        this.f37514h = (PPSSplashSwipeClickView) findViewById(C6849R.id.hiad_splash_swipe_click_view);
        this.f37507a.setNeedPauseOnSurfaceDestory(false);
        this.f37507a.setScreenOnWhilePlaying(true);
        this.f37507a.setAutoScaleResizeLayoutOnVideoSizeChange(false);
        this.f37507a.setVideoScaleMode(2);
    }
}
