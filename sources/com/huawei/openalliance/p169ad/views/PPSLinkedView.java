package com.huawei.openalliance.p169ad.views;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.DisplayCutout;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.openalliance.p169ad.AbstractC7014dc;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.AbstractC7558os;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C6982bz;
import com.huawei.openalliance.p169ad.C6985cb;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.C7327ja;
import com.huawei.openalliance.p169ad.C7330jd;
import com.huawei.openalliance.p169ad.C7484ms;
import com.huawei.openalliance.p169ad.C7565oz;
import com.huawei.openalliance.p169ad.C7639ro;
import com.huawei.openalliance.p169ad.C7640rp;
import com.huawei.openalliance.p169ad.C7694tp;
import com.huawei.openalliance.p169ad.C7695tq;
import com.huawei.openalliance.p169ad.C7716uk;
import com.huawei.openalliance.p169ad.InterfaceC7328jb;
import com.huawei.openalliance.p169ad.InterfaceC7337jk;
import com.huawei.openalliance.p169ad.InterfaceC7531nz;
import com.huawei.openalliance.p169ad.InterpolatorC7160gq;
import com.huawei.openalliance.p169ad.analysis.C6920a;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.beans.metadata.InteractCfg;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.RTCMethods;
import com.huawei.openalliance.p169ad.download.app.AppStatus;
import com.huawei.openalliance.p169ad.inter.C7288c;
import com.huawei.openalliance.p169ad.inter.HiAd;
import com.huawei.openalliance.p169ad.inter.data.IAd;
import com.huawei.openalliance.p169ad.inter.data.ILinkedSplashAd;
import com.huawei.openalliance.p169ad.inter.data.LinkedSplashAd;
import com.huawei.openalliance.p169ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.p169ad.inter.data.VideoInfo;
import com.huawei.openalliance.p169ad.inter.listeners.AdActionListener;
import com.huawei.openalliance.p169ad.inter.listeners.AdShowListener;
import com.huawei.openalliance.p169ad.inter.listeners.LinkedAdListener;
import com.huawei.openalliance.p169ad.media.MediaPlayerAgent;
import com.huawei.openalliance.p169ad.media.listener.ILinkedMediaStateListener;
import com.huawei.openalliance.p169ad.media.listener.MuteListener;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.C7780c;
import com.huawei.openalliance.p169ad.utils.C7845x;
import com.huawei.openalliance.p169ad.views.AbstractC8105i;
import com.huawei.openalliance.p169ad.views.interfaces.IAppDownloadButton;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@OuterVisible
/* loaded from: classes2.dex */
public class PPSLinkedView extends AbstractC8105i {

    /* renamed from: com.huawei.openalliance.ad.views.PPSLinkedView$1 */
    public class RunnableC79601 implements Runnable {
        public RunnableC79601() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Long lValueOf;
            Integer numValueOf;
            int i10;
            PPSLinkedView pPSLinkedView = PPSLinkedView.this;
            LinkedSplashAd linkedSplashAd = pPSLinkedView.f37879l;
            if (linkedSplashAd == null) {
                return;
            }
            if (pPSLinkedView.f37820ad == 2) {
                lValueOf = Long.valueOf(linkedSplashAd.getMinEffectiveShowTime());
                numValueOf = Integer.valueOf(PPSLinkedView.this.f37878k.m45261d());
                i10 = 9;
            } else {
                lValueOf = Long.valueOf(linkedSplashAd.getMinEffectiveShowTime());
                numValueOf = Integer.valueOf(PPSLinkedView.this.f37878k.m45261d());
                i10 = 8;
            }
            pPSLinkedView.m49257a(lValueOf, numValueOf, Integer.valueOf(i10), false);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.PPSLinkedView$2 */
    public class RunnableC79612 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ PPSDestView f36799a;

        public RunnableC79612(PPSDestView pPSDestView) {
            pPSDestView = pPSDestView;
        }

        @Override // java.lang.Runnable
        public void run() {
            PPSDestView pPSDestView;
            AbstractC7185ho.m43817a("PPSLinkedView", "destView post");
            if (!AbstractC7811dd.m48315c() || (pPSDestView = pPSDestView) == null || pPSDestView.getX() >= 0.0f) {
                return;
            }
            PPSLinkedView.this.m49225A();
            PPSDestView pPSDestView2 = pPSDestView;
            pPSDestView2.setX((PPSLinkedView.this.f37817aa - Math.abs(pPSDestView2.getX())) - pPSDestView.getWidth());
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.PPSLinkedView$3 */
    public class ViewOnTouchListenerC79623 implements View.OnTouchListener {
        public ViewOnTouchListenerC79623() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                AbstractC7185ho.m43820b("PPSLinkedView", "onTouch: begin to scale");
                PPSLinkedView.this.f37771D.setVisibility(4);
                PPSLinkedView.this.m49302o();
                PPSLinkedView pPSLinkedView = PPSLinkedView.this;
                pPSLinkedView.f37840ax = 1;
                pPSLinkedView.mo49299j();
            }
            return true;
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.PPSLinkedView$4 */
    public class RunnableC79634 implements Runnable {
        public RunnableC79634() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C8074ai c8074ai = PPSLinkedView.this.f37889v;
            if (c8074ai != null) {
                if (c8074ai.isAttachedToWindow()) {
                    PPSLinkedView pPSLinkedView = PPSLinkedView.this;
                    pPSLinkedView.f37770C.removeView(pPSLinkedView.f37889v);
                }
                PPSLinkedView.this.f37889v.m49999b();
                PPSLinkedView.this.f37889v = null;
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.PPSLinkedView$5 */
    public class C79645 implements ValueAnimator.AnimatorUpdateListener {
        public C79645() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            try {
                float animatedFraction = (valueAnimator.getAnimatedFraction() * (PPSLinkedView.this.f37822af - 1.0f)) + 1.0f;
                float animatedFraction2 = valueAnimator.getAnimatedFraction();
                PPSLinkedView pPSLinkedView = PPSLinkedView.this;
                float f10 = (animatedFraction2 * (pPSLinkedView.f37824ah - 1.0f)) + 1.0f;
                LinkedSurfaceView linkedSurfaceView = pPSLinkedView.f37892y;
                float animatedFraction3 = valueAnimator.getAnimatedFraction();
                PPSLinkedView pPSLinkedView2 = PPSLinkedView.this;
                linkedSurfaceView.m48800a(animatedFraction, animatedFraction3 * pPSLinkedView2.f37823ag, f10, (int) (pPSLinkedView2.f37817aa * f10), (int) (pPSLinkedView2.f37790W * animatedFraction));
            } catch (Throwable th2) {
                AbstractC7185ho.m43821b("PPSLinkedView", "scaleAndTransAnimation err: %s", th2.getClass().getSimpleName());
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.PPSLinkedView$6 */
    public class C79656 implements Animator.AnimatorListener {
        public C79656() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            VideoInfo videoInfo;
            AbstractC7185ho.m43820b("PPSLinkedView", "onAnimationEnd");
            try {
                PPSLinkedView pPSLinkedView = PPSLinkedView.this;
                if (pPSLinkedView.f37818ab > 0 && (videoInfo = pPSLinkedView.f37882o) != null) {
                    AbstractC7185ho.m43821b("PPSLinkedView", "onAnimationEnd, VideoRatio = %s", videoInfo.getVideoRatio());
                    if (PPSLinkedView.this.f37882o.getVideoRatio().floatValue() < 1.0f) {
                        PPSLinkedView pPSLinkedView2 = PPSLinkedView.this;
                        LinkedSurfaceView linkedSurfaceView = pPSLinkedView2.f37892y;
                        int i10 = pPSLinkedView2.f37819ac;
                        int i11 = pPSLinkedView2.f37818ab;
                        linkedSurfaceView.m48801a((i10 * 1.0f) / (i11 * 1.0f), (i10 * 1.0f) / (i11 * 1.0f), i10, i11);
                    } else {
                        PPSLinkedView pPSLinkedView3 = PPSLinkedView.this;
                        LinkedSurfaceView linkedSurfaceView2 = pPSLinkedView3.f37892y;
                        float fFloatValue = pPSLinkedView3.f37882o.getVideoRatio().floatValue();
                        PPSLinkedView pPSLinkedView4 = PPSLinkedView.this;
                        int i12 = pPSLinkedView4.f37819ac;
                        int i13 = pPSLinkedView4.f37818ab;
                        linkedSurfaceView2.m48801a(fFloatValue, (i12 * 1.0f) / (i13 * 1.0f), i12, i13);
                    }
                }
                PPSLinkedView.this.m49226B();
                PPSLinkedView.this.f37820ad = 2;
            } catch (Throwable th2) {
                AbstractC7185ho.m43821b("PPSLinkedView", "onAnimationEnd err: %s", th2.getClass().getSimpleName());
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            AbstractC7185ho.m43820b("PPSLinkedView", "onAnimationStart");
            C7695tq c7695tq = PPSLinkedView.this.f37814aX;
            if (c7695tq != null) {
                c7695tq.setVisibility(8);
            }
            ImageView imageView = PPSLinkedView.this.f37772E;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            C8152v c8152v = PPSLinkedView.this.f37771D;
            if (c8152v != null) {
                c8152v.setVisibility(8);
            }
            PPSSplashAdSourceView pPSSplashAdSourceView = PPSLinkedView.this.f37877j;
            if (pPSSplashAdSourceView != null) {
                pPSSplashAdSourceView.m49616a();
                PPSLinkedView.this.f37877j.setVisibility(8);
            }
            PPSWLSView pPSWLSView = PPSLinkedView.this.f37876i;
            if (pPSWLSView != null) {
                pPSWLSView.setVisibility(8);
            }
            View view = PPSLinkedView.this.f37778K;
            if (view != null) {
                view.setVisibility(8);
            }
            PPSSplashProView pPSSplashProView = PPSLinkedView.this.f37799aI;
            if (pPSSplashProView != null) {
                pPSSplashProView.setVisibility(8);
                PPSLinkedView.this.f37799aI.m49665a();
            }
            PPSSplashSwipeView pPSSplashSwipeView = PPSLinkedView.this.f37800aJ;
            if (pPSSplashSwipeView != null) {
                pPSSplashSwipeView.setVisibility(8);
                PPSLinkedView.this.f37800aJ.m50329b();
            }
            PPSSplashTwistView pPSSplashTwistView = PPSLinkedView.this.f37801aK;
            if (pPSSplashTwistView != null) {
                pPSSplashTwistView.setVisibility(8);
            }
            PPSSplashTwistClickView pPSSplashTwistClickView = PPSLinkedView.this.f37812aV;
            if (pPSSplashTwistClickView != null) {
                pPSSplashTwistClickView.setVisibility(8);
            }
            PPSSplashSwipeClickView pPSSplashSwipeClickView = PPSLinkedView.this.f37811aU;
            if (pPSSplashSwipeClickView != null) {
                pPSSplashSwipeClickView.setVisibility(8);
            }
            C8074ai c8074ai = PPSLinkedView.this.f37889v;
            if (c8074ai != null) {
                c8074ai.setOnTouchListener(null);
            }
            C7640rp c7640rp = PPSLinkedView.this.f37802aL;
            if (c7640rp != null) {
                c7640rp.m47109b();
            }
            C7639ro c7639ro = PPSLinkedView.this.f37803aM;
            if (c7639ro != null) {
                c7639ro.m47105b();
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.PPSLinkedView$7 */
    public class RunnableC79667 implements Runnable {
        public RunnableC79667() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PPSLinkedView.this.f37890w.cancel();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.PPSLinkedView$8 */
    public class RunnableC79678 implements Runnable {
        public RunnableC79678() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PPSLinkedView.this.m49272c(false);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.PPSLinkedView$9 */
    public class RunnableC79689 implements Runnable {
        public RunnableC79689() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (PPSLinkedView.this.f37771D != null) {
                AbstractC7185ho.m43817a("PPSLinkedView", "skip btn show");
                PPSLinkedView.this.f37771D.setVisibility(0);
            }
        }
    }

    @OuterVisible
    public interface OnLinkedAdClickListener {
        void onClick(int i10);
    }

    @OuterVisible
    public interface OnLinkedAdPreparedListener {
        void onPrepared();
    }

    @OuterVisible
    public interface OnLinkedAdSwitchListener {
        void onSwitch(int i10);
    }

    @OuterVisible
    public PPSLinkedView(Context context) {
        super(context);
    }

    /* renamed from: A */
    public void m49225A() {
        DisplayMetrics displayMetrics = this.f37874g.getResources().getDisplayMetrics();
        this.f37790W = displayMetrics.heightPixels;
        this.f37817aa = displayMetrics.widthPixels;
    }

    /* renamed from: B */
    public void m49226B() {
        AbstractC7185ho.m43820b("PPSLinkedView", "switchViewOnAnimationEnd. ");
        m49272c(this.f37791aA);
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("PPSLinkedView", "isMoved: %s, linkedAdListener on switch: %s ", Boolean.valueOf(this.f37826aj), this.f37828al);
        }
        if (this.f37828al == null) {
            AbstractC7185ho.m43823c("PPSLinkedView", "linkedAdListener is null. ");
        } else {
            AbstractC7185ho.m43817a("PPSLinkedView", "splash show end. ");
            this.f37828al.onAdDismissed();
        }
    }

    /* renamed from: C */
    private boolean m49227C() {
        boolean zM49228D = m49228D();
        boolean zM49229E = m49229E();
        if (!zM49228D && !zM49229E) {
            return true;
        }
        AbstractC7185ho.m43824c("PPSLinkedView", "checkDestView, destView change null, linkedAdListener: %s, isMoved:%s. ", AbstractC7806cz.m48162b(this.f37828al), Boolean.valueOf(this.f37826aj));
        AbstractC7185ho.m43821b("PPSLinkedView", "isDestViewNull:%s, isDestViewNotAvalible:%s", Boolean.valueOf(zM49228D), Boolean.valueOf(zM49229E));
        if (!this.f37797aG) {
            this.f37797aG = true;
            m49271c(-5);
            LinkedAdListener linkedAdListener = this.f37828al;
            if (linkedAdListener != null) {
                linkedAdListener.onAdDismissed();
            }
        }
        if (!this.f37826aj) {
            this.f37826aj = true;
            this.f37820ad = 0;
            this.f37872e.m47408i();
            m49230F();
            m49243S();
            OnLinkedAdSwitchListener onLinkedAdSwitchListener = this.f37884q;
            if (onLinkedAdSwitchListener != null) {
                onLinkedAdSwitchListener.onSwitch(this.f37840ax);
            }
        }
        return false;
    }

    /* renamed from: D */
    private boolean m49228D() {
        PPSDestView pPSDestView = this.f37893z;
        return pPSDestView == null || pPSDestView.getHeight() == 0 || this.f37893z.getWidth() == 0;
    }

    /* renamed from: E */
    private boolean m49229E() {
        C8076ak c8076akM47405f = this.f37872e.m47405f();
        return c8076akM47405f == null || !c8076akM47405f.m50002j();
    }

    /* renamed from: F */
    private void m49230F() {
        AbstractC7185ho.m43820b("PPSLinkedView", "removeSplashView");
        C8074ai c8074ai = this.f37889v;
        if (c8074ai != null) {
            c8074ai.setVisibility(8);
            this.f37889v.m49998a();
        }
        LinkedSurfaceView linkedSurfaceView = this.f37892y;
        if (linkedSurfaceView != null) {
            linkedSurfaceView.m48799a();
            C8099g c8099g = this.f37891x;
            if (c8099g != null) {
                c8099g.m50171b(this.f37892y);
            }
            this.f37892y = null;
        }
        AbstractC7817dj.m48364a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.4
            public RunnableC79634() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C8074ai c8074ai2 = PPSLinkedView.this.f37889v;
                if (c8074ai2 != null) {
                    if (c8074ai2.isAttachedToWindow()) {
                        PPSLinkedView pPSLinkedView = PPSLinkedView.this;
                        pPSLinkedView.f37770C.removeView(pPSLinkedView.f37889v);
                    }
                    PPSLinkedView.this.f37889v.m49999b();
                    PPSLinkedView.this.f37889v = null;
                }
            }
        }, 20L);
        PPSSplashProView pPSSplashProView = this.f37799aI;
        if (pPSSplashProView != null) {
            pPSSplashProView.m49665a();
        }
        PPSSplashSwipeView pPSSplashSwipeView = this.f37800aJ;
        if (pPSSplashSwipeView != null) {
            pPSSplashSwipeView.m50329b();
        }
        C7640rp c7640rp = this.f37802aL;
        if (c7640rp != null) {
            c7640rp.m47109b();
        }
        C7639ro c7639ro = this.f37803aM;
        if (c7639ro != null) {
            c7639ro.m47105b();
        }
    }

    /* renamed from: G */
    private void m49231G() {
        AbstractC7185ho.m43820b("PPSLinkedView", "addMonitor");
        C7330jd c7330jd = new C7330jd(this, this);
        this.f37878k = c7330jd;
        c7330jd.m45301h();
        LinkedSplashAd linkedSplashAd = this.f37879l;
        if (linkedSplashAd != null) {
            this.f37878k.m45259b(linkedSplashAd.getMinEffectiveShowTime(), this.f37879l.getMinEffectiveShowRatio());
        }
        this.f37878k.m45255a(this.f37879l);
    }

    /* renamed from: H */
    private void m49232H() {
        this.f37838av.addListener(new Animator.AnimatorListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.6
            public C79656() {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoInfo videoInfo;
                AbstractC7185ho.m43820b("PPSLinkedView", "onAnimationEnd");
                try {
                    PPSLinkedView pPSLinkedView = PPSLinkedView.this;
                    if (pPSLinkedView.f37818ab > 0 && (videoInfo = pPSLinkedView.f37882o) != null) {
                        AbstractC7185ho.m43821b("PPSLinkedView", "onAnimationEnd, VideoRatio = %s", videoInfo.getVideoRatio());
                        if (PPSLinkedView.this.f37882o.getVideoRatio().floatValue() < 1.0f) {
                            PPSLinkedView pPSLinkedView2 = PPSLinkedView.this;
                            LinkedSurfaceView linkedSurfaceView = pPSLinkedView2.f37892y;
                            int i10 = pPSLinkedView2.f37819ac;
                            int i11 = pPSLinkedView2.f37818ab;
                            linkedSurfaceView.m48801a((i10 * 1.0f) / (i11 * 1.0f), (i10 * 1.0f) / (i11 * 1.0f), i10, i11);
                        } else {
                            PPSLinkedView pPSLinkedView3 = PPSLinkedView.this;
                            LinkedSurfaceView linkedSurfaceView2 = pPSLinkedView3.f37892y;
                            float fFloatValue = pPSLinkedView3.f37882o.getVideoRatio().floatValue();
                            PPSLinkedView pPSLinkedView4 = PPSLinkedView.this;
                            int i12 = pPSLinkedView4.f37819ac;
                            int i13 = pPSLinkedView4.f37818ab;
                            linkedSurfaceView2.m48801a(fFloatValue, (i12 * 1.0f) / (i13 * 1.0f), i12, i13);
                        }
                    }
                    PPSLinkedView.this.m49226B();
                    PPSLinkedView.this.f37820ad = 2;
                } catch (Throwable th2) {
                    AbstractC7185ho.m43821b("PPSLinkedView", "onAnimationEnd err: %s", th2.getClass().getSimpleName());
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                AbstractC7185ho.m43820b("PPSLinkedView", "onAnimationStart");
                C7695tq c7695tq = PPSLinkedView.this.f37814aX;
                if (c7695tq != null) {
                    c7695tq.setVisibility(8);
                }
                ImageView imageView = PPSLinkedView.this.f37772E;
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
                C8152v c8152v = PPSLinkedView.this.f37771D;
                if (c8152v != null) {
                    c8152v.setVisibility(8);
                }
                PPSSplashAdSourceView pPSSplashAdSourceView = PPSLinkedView.this.f37877j;
                if (pPSSplashAdSourceView != null) {
                    pPSSplashAdSourceView.m49616a();
                    PPSLinkedView.this.f37877j.setVisibility(8);
                }
                PPSWLSView pPSWLSView = PPSLinkedView.this.f37876i;
                if (pPSWLSView != null) {
                    pPSWLSView.setVisibility(8);
                }
                View view = PPSLinkedView.this.f37778K;
                if (view != null) {
                    view.setVisibility(8);
                }
                PPSSplashProView pPSSplashProView = PPSLinkedView.this.f37799aI;
                if (pPSSplashProView != null) {
                    pPSSplashProView.setVisibility(8);
                    PPSLinkedView.this.f37799aI.m49665a();
                }
                PPSSplashSwipeView pPSSplashSwipeView = PPSLinkedView.this.f37800aJ;
                if (pPSSplashSwipeView != null) {
                    pPSSplashSwipeView.setVisibility(8);
                    PPSLinkedView.this.f37800aJ.m50329b();
                }
                PPSSplashTwistView pPSSplashTwistView = PPSLinkedView.this.f37801aK;
                if (pPSSplashTwistView != null) {
                    pPSSplashTwistView.setVisibility(8);
                }
                PPSSplashTwistClickView pPSSplashTwistClickView = PPSLinkedView.this.f37812aV;
                if (pPSSplashTwistClickView != null) {
                    pPSSplashTwistClickView.setVisibility(8);
                }
                PPSSplashSwipeClickView pPSSplashSwipeClickView = PPSLinkedView.this.f37811aU;
                if (pPSSplashSwipeClickView != null) {
                    pPSSplashSwipeClickView.setVisibility(8);
                }
                C8074ai c8074ai = PPSLinkedView.this.f37889v;
                if (c8074ai != null) {
                    c8074ai.setOnTouchListener(null);
                }
                C7640rp c7640rp = PPSLinkedView.this.f37802aL;
                if (c7640rp != null) {
                    c7640rp.m47109b();
                }
                C7639ro c7639ro = PPSLinkedView.this.f37803aM;
                if (c7639ro != null) {
                    c7639ro.m47105b();
                }
            }
        });
    }

    /* renamed from: I */
    private void m49233I() {
        AbstractC8105i.d dVar = this.f37774G;
        if (dVar != null) {
            dVar.cancel();
            this.f37774G = null;
        }
    }

    /* renamed from: J */
    private void m49234J() throws Resources.NotFoundException {
        m49245U();
        m49244T();
        m49266b(this.f37879l);
        m49238N();
        m49252a(this.f37879l);
    }

    /* renamed from: K */
    private void m49235K() {
        int iMo43030H = this.f37875h.mo43030H();
        if (iMo43030H > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f37799aI.getLayoutParams();
            int iM47535a = AbstractC7741ao.m47535a(this.f37874g, iMo43030H);
            this.f37799aI.setPadding(iM47535a, iM47535a, iM47535a, iM47535a);
            if (layoutParams.isMarginRelative()) {
                layoutParams.setMarginStart(layoutParams.leftMargin - iM47535a);
                layoutParams.setMarginEnd(layoutParams.rightMargin - iM47535a);
            } else {
                layoutParams.setMargins(layoutParams.leftMargin - iM47535a, layoutParams.topMargin, layoutParams.rightMargin - iM47535a, layoutParams.bottomMargin);
            }
            this.f37799aI.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: L */
    private void m49236L() {
        AbstractC7185ho.m43820b("PPSLinkedView", "setAccListener");
        if (this.f37803aM == null) {
            AbstractC7185ho.m43820b("PPSLinkedView", "new setAccListener");
            C7639ro c7639ro = new C7639ro(getContext());
            this.f37803aM = c7639ro;
            c7639ro.m47104a(new AbstractC8105i.b());
            this.f37803aM.m47103a();
        }
    }

    /* renamed from: M */
    private void m49237M() {
        AbstractC7185ho.m43820b("PPSLinkedView", "setRotationListener");
        if (this.f37802aL == null) {
            AbstractC7185ho.m43820b("PPSLinkedView", " new setRotationListener");
            C7640rp c7640rp = new C7640rp(getContext());
            this.f37802aL = c7640rp;
            c7640rp.m47108a(new AbstractC8105i.c());
            this.f37802aL.m47107a();
        }
    }

    /* renamed from: N */
    private void m49238N() {
        String str;
        try {
            if (this.f37778K == null) {
                View viewInflate = this.f37777J.inflate();
                this.f37778K = viewInflate;
                viewInflate.setId(C6849R.id.hiad_full_logo_region);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f37778K.getLayoutParams();
            if (this.f37788U > 0) {
                AbstractC7185ho.m43818a("PPSLinkedView", "left:%d, top:%d, right:%d", Integer.valueOf(layoutParams.leftMargin), Integer.valueOf(layoutParams.topMargin), Integer.valueOf(layoutParams.rightMargin));
                layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin + this.f37788U, layoutParams.rightMargin, layoutParams.bottomMargin);
                this.f37778K.setLayoutParams(layoutParams);
            }
            ImageView imageView = (ImageView) this.f37778K.findViewById(C6849R.id.hiad_full_mode_logo);
            int i10 = this.f37776I;
            if (i10 > 0) {
                imageView.setImageResource(i10);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            TextView textView = (TextView) this.f37778K.findViewById(C6849R.id.hiad_media_name);
            int i11 = this.f37780M;
            if (i11 <= 0) {
                textView.setVisibility(8);
            } else {
                textView.setText(i11);
                textView.setVisibility(0);
            }
        } catch (Resources.NotFoundException unused) {
            str = "showFullModeLogo res not found";
            AbstractC7185ho.m43823c("PPSLinkedView", str);
        } catch (Exception e10) {
            str = "showFullModeLogo " + e10.getClass().getSimpleName();
            AbstractC7185ho.m43823c("PPSLinkedView", str);
        }
    }

    /* renamed from: O */
    private void m49239O() {
        if (this.f37890w != null) {
            AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.7
                public RunnableC79667() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    PPSLinkedView.this.f37890w.cancel();
                }
            });
        }
    }

    /* renamed from: P */
    private void m49240P() {
        LinkedSplashAd linkedSplashAd = this.f37879l;
        if (linkedSplashAd != null) {
            linkedSplashAd.m44847j(false);
        }
        this.f37879l = null;
        this.f37769B = null;
        this.f37775H = null;
        this.f37779L = null;
        WeakReference<Context> weakReference = this.f37809aS;
        if (weakReference != null) {
            weakReference.clear();
        }
        LinkedSurfaceView linkedSurfaceView = this.f37892y;
        if (linkedSurfaceView != null) {
            linkedSurfaceView.m48799a();
        }
        C8076ak c8076akM47405f = this.f37872e.m47405f();
        if (c8076akM47405f != null) {
            c8076akM47405f.destroyView();
        }
        C8099g c8099g = this.f37891x;
        if (c8099g != null) {
            c8099g.m50178i();
        }
        this.f37872e.m47398b(false);
        m49243S();
        AbstractC7014dc.m41869a((IAd) null);
        AbstractC7817dj.m48366a(this.f37870c);
        this.f37871d.m47379b();
        C7288c.m44224a(this.f37874g).m44229a(false);
    }

    /* renamed from: Q */
    private void m49241Q() {
        LinkedSplashAd linkedSplashAd;
        if (!m49303p() || (linkedSplashAd = this.f37879l) == null || linkedSplashAd.m44814aj()) {
            return;
        }
        AbstractC7185ho.m43820b("PPSLinkedView", " maybe report show start.");
        mo45267b();
    }

    /* renamed from: R */
    private void m49242R() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        this.f37768A = arrayList;
        m49258a(arrayList);
    }

    /* renamed from: S */
    private void m49243S() {
        List<View> list = this.f37768A;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (View view : this.f37768A) {
            if (view != null) {
                view.setOnClickListener(null);
            }
        }
        setOnClickListener(null);
    }

    /* renamed from: T */
    private void m49244T() throws Resources.NotFoundException {
        if (this.f37773F && this.f37772E == null) {
            ImageView imageView = new ImageView(getContext());
            this.f37772E = imageView;
            imageView.setImageResource(C6849R.drawable.hiad_selector_ic_sound_check);
            AbstractC7811dd.m48296a(this.f37772E);
            Resources resources = this.f37874g.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(C6849R.dimen.hiad_8_dp);
            this.f37772E.setPadding(0, dimensionPixelSize, resources.getDimensionPixelSize(C6849R.dimen.hiad_page_margin_side), dimensionPixelSize);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.addRule(21);
            int i10 = C6849R.dimen.haid_splash_sound_margin_right;
            layoutParams.rightMargin = resources.getDimensionPixelSize(i10);
            int dimensionPixelOffset = resources.getDimensionPixelOffset(C6849R.dimen.haid_splash_sound_margin_bottom);
            layoutParams.bottomMargin = dimensionPixelOffset;
            layoutParams.bottomMargin = dimensionPixelOffset + AbstractC7811dd.m48326f(this.f37874g);
            layoutParams.setMarginEnd(resources.getDimensionPixelSize(i10));
            this.f37889v.addView(this.f37772E, layoutParams);
            this.f37772E.bringToFront();
            this.f37772E.setSelected(false);
            this.f37772E.setOnClickListener(this.f37853bj);
        }
    }

    /* renamed from: U */
    private void m49245U() {
        if (this.f37771D != null) {
            AbstractC7185ho.m43818a("PPSLinkedView", "%d delay, skip btn show", Integer.valueOf(this.f37798aH));
            if (this.f37798aH > 0) {
                AbstractC7817dj.m48365a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.9
                    public RunnableC79689() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (PPSLinkedView.this.f37771D != null) {
                            AbstractC7185ho.m43817a("PPSLinkedView", "skip btn show");
                            PPSLinkedView.this.f37771D.setVisibility(0);
                        }
                    }
                }, this.f37870c, this.f37798aH);
            } else {
                AbstractC7185ho.m43817a("PPSLinkedView", "skip btn show");
                this.f37771D.setVisibility(0);
            }
        }
    }

    /* renamed from: a */
    private C8152v m49246a(String str, int i10, String str2, boolean z10, float f10, int i11) {
        return new C8152v(getContext(), str, 1, 4, i10, str2, z10, this.f37788U, f10, i11, false);
    }

    /* renamed from: b */
    private WindowManager.LayoutParams m49261b(Context context) {
        String str;
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.flags = 134218760;
        layoutParams.format = 1;
        try {
            if (AbstractC7811dd.m48333i(context)) {
                AbstractC7185ho.m43817a("PPSLinkedView", " isNotchEnable");
                layoutParams.layoutInDisplayCutoutMode = 1;
            }
            C6985cb.m41166a(this.f37874g).mo41203a(layoutParams);
        } catch (NoSuchMethodError unused) {
            str = "initOnApplyWindowInsets NoSuchMethodError setDisplaySideMode";
            AbstractC7185ho.m43823c("PPSLinkedView", str);
            return layoutParams;
        } catch (Throwable th2) {
            str = "initOnApplyWindowInsets error:" + th2.getClass().getSimpleName();
            AbstractC7185ho.m43823c("PPSLinkedView", str);
            return layoutParams;
        }
        return layoutParams;
    }

    /* renamed from: c */
    private int m49269c(ContentRecord contentRecord) {
        return (contentRecord.m41459aK() == null || contentRecord.m41459aK().m40198a() == null) ? this.f37875h.mo43028F() : contentRecord.m41459aK().m40198a().intValue();
    }

    /* renamed from: d */
    private Integer m49273d(ContentRecord contentRecord) {
        int iM46475n = AbstractC7558os.m46475n(contentRecord.m41427W());
        if (iM46475n == 0) {
            return null;
        }
        int iM49269c = m49269c(contentRecord);
        AbstractC7185ho.m43821b("PPSLinkedView", "initial mode: %s", Integer.valueOf(iM49269c));
        if (iM49269c == 0) {
            return Integer.valueOf(iM49269c);
        }
        Map<String, String> mapM47729a = AbstractC7758be.m47729a(this.f37875h.mo43430ca());
        if (mapM47729a != null) {
            if ((2 == iM49269c || 3 == iM49269c) && m49260a(AbstractC7806cz.m48180i(mapM47729a.get(Constants.TWIST_TYPE)))) {
                iM49269c = 4;
            }
            if ((1 == iM49269c || 4 == iM49269c) && m49260a(AbstractC7806cz.m48180i(mapM47729a.get(Constants.SWIPE_TYPE)))) {
                return 0;
            }
        }
        if (1 != getResources().getConfiguration().orientation || 2 != iM46475n) {
            return 0;
        }
        if (!m49277e(iM49269c)) {
            return Integer.valueOf(iM49269c);
        }
        AbstractC7185ho.m43821b("PPSLinkedView", "can't use twist, enable : %s", Boolean.valueOf(this.f37875h.mo43345aL()));
        return 0;
    }

    private RelativeLayout.LayoutParams getDestViewParam() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        return layoutParams;
    }

    /* renamed from: q */
    private void m49278q() {
        this.f37876i = this.f37889v.getPpswlsView();
        this.f37877j = this.f37889v.getPpsSplashAdSourceView();
    }

    /* renamed from: r */
    private void m49279r() {
        C8099g c8099g = new C8099g(this.f37874g);
        this.f37891x = c8099g;
        c8099g.m50168a(this.f37892y);
        this.f37891x.m50168a(this.f37872e.m47405f());
    }

    /* renamed from: s */
    private void m49280s() {
        this.f37799aI = this.f37889v.getProView();
        this.f37800aJ = this.f37889v.getSwipeView();
        this.f37801aK = this.f37889v.getTwistView();
        this.f37811aU = this.f37889v.getSwipeClickView();
        this.f37812aV = this.f37889v.getTwistClickView();
    }

    private void setDestViewClickable(PPSDestView pPSDestView) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(pPSDestView);
        m49258a(arrayList);
    }

    private void setSkipBtnDelayTime(ContentRecord contentRecord) {
        if (contentRecord == null || contentRecord.m41499au() <= 0) {
            return;
        }
        this.f37798aH = contentRecord.m41499au();
    }

    private void setSplashViewClickable(C8074ai c8074ai) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(c8074ai);
        m49258a(arrayList);
    }

    /* renamed from: t */
    private void m49281t() {
        C8099g c8099g = this.f37891x;
        if (c8099g == null) {
            return;
        }
        this.f37872e.m47392a(c8099g.m50177h());
        MediaPlayerAgent mediaPlayerAgentM47410k = this.f37872e.m47410k();
        if (mediaPlayerAgentM47410k == null) {
            return;
        }
        mediaPlayerAgentM47410k.m45799a(this.f37815aY);
        mediaPlayerAgentM47410k.addMediaStateListener(this.f37844ba);
        mediaPlayerAgentM47410k.addMediaErrorListener(this.f37850bg);
        mediaPlayerAgentM47410k.addMediaInfoListener(this.f37845bb);
        mediaPlayerAgentM47410k.addMuteListener(this.f37851bh);
        mediaPlayerAgentM47410k.addMediaBufferListener(this.f37852bi);
        mediaPlayerAgentM47410k.addReportVideoTimeListenersSet(this.f37816aZ);
    }

    /* renamed from: u */
    private boolean m49282u() {
        String str;
        if (getResources().getConfiguration().orientation != 1) {
            str = "orientation not portrait. ";
        } else if (!this.f37829am) {
            str = "not register linkedSplashAd and destview. ";
        } else if (this.f37879l == null || this.f37882o == null) {
            str = "videoInfo is null. ";
        } else {
            if (this.f37770C != null && this.f37889v != null && this.f37892y != null) {
                return false;
            }
            str = "splash view not ready. ";
        }
        AbstractC7185ho.m43823c("PPSLinkedView", str);
        m49285x();
        mo49298i();
        unregister();
        return true;
    }

    /* renamed from: v */
    private void m49283v() {
        C8152v c8152v = this.f37771D;
        if (c8152v != null) {
            c8152v.setLinkedOnTouchListener(new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.3
                public ViewOnTouchListenerC79623() {
                }

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 1) {
                        AbstractC7185ho.m43820b("PPSLinkedView", "onTouch: begin to scale");
                        PPSLinkedView.this.f37771D.setVisibility(4);
                        PPSLinkedView.this.m49302o();
                        PPSLinkedView pPSLinkedView = PPSLinkedView.this;
                        pPSLinkedView.f37840ax = 1;
                        pPSLinkedView.mo49299j();
                    }
                    return true;
                }
            });
        }
    }

    /* renamed from: w */
    private boolean m49284w() {
        LinkedSplashAd linkedSplashAd = this.f37879l;
        if (linkedSplashAd == null || !linkedSplashAd.isFromExsplash() || this.f37875h == null) {
            return true;
        }
        if (this.f37828al == null) {
            LinkedAdListener linkedAdListenerMo44054g = HiAd.m44014a(this.f37874g).mo44054g();
            this.f37828al = linkedAdListenerMo44054g;
            this.f37879l.setListener(linkedAdListenerMo44054g);
        }
        Long lMo43375bB = this.f37875h.mo43375bB();
        long jLongValue = lMo43375bB.longValue();
        int iMo43376bC = this.f37875h.mo43376bC();
        long jMo43377bD = this.f37875h.mo43377bD();
        long j10 = iMo43376bC;
        long j11 = jLongValue + j10;
        long jCurrentTimeMillis = System.currentTimeMillis();
        String contentId = this.f37879l.getContentId();
        String slotId = this.f37879l.getSlotId();
        long j12 = (jCurrentTimeMillis - jLongValue) - j10;
        AbstractC7185ho.m43818a("PPSLinkedView", "ExSplashPreCheck, sloganStartTime:%s, sloganShowTime:%s, redundancyTime:%s", lMo43375bB, Integer.valueOf(iMo43376bC), Long.valueOf(jMo43377bD));
        AbstractC7185ho.m43818a("PPSLinkedView", "ExSplashPreCheck, thresholdTime:%s, currentTime: %s", Long.valueOf(j11), Long.valueOf(System.currentTimeMillis()));
        if (HiAd.getInstance(this.f37874g).isEnableUserInfo() && jCurrentTimeMillis <= j11) {
            return true;
        }
        AbstractC7185ho.m43823c("PPSLinkedView", "ExSplashPreCheck, unable user info or over time");
        C7484ms.m45854a(this.f37874g).m45855a(RTCMethods.SHOW_SPLASH, null, null, null);
        this.f37794aD.m39093a(this.f37793aC, 1, slotId, contentId, j12);
        mo49298i();
        m49230F();
        unregister();
        return false;
    }

    /* renamed from: x */
    private void m49285x() {
        LinkedSplashAd linkedSplashAd = this.f37879l;
        if (linkedSplashAd == null || !linkedSplashAd.isFromExsplash()) {
            return;
        }
        C7484ms.m45854a(this.f37874g).m45855a(RTCMethods.SHOW_SPLASH, null, null, null);
        this.f37794aD.m39092a(this.f37793aC, 1, this.f37879l.getSlotId(), this.f37879l.getContentId());
    }

    /* renamed from: y */
    private boolean m49286y() {
        String str;
        PPSSplashView pPSSplashView;
        if (this.f37880m == null && (pPSSplashView = this.f37769B) != null && pPSSplashView.getAdMediator() != null) {
            AbstractC7185ho.m43820b("PPSLinkedView", "set adMediator. ");
            this.f37880m = this.f37769B.getAdMediator();
        }
        if (getResources().getConfiguration().orientation != 1) {
            str = "orientation not portrait. ";
        } else if (this.f37829am) {
            VideoInfo videoInfo = this.f37882o;
            if (videoInfo == null) {
                str = "videoInfo is null. ";
            } else {
                if (this.f37889v != null && this.f37892y != null) {
                    this.f37820ad = 1;
                    this.f37821ae = (((double) videoInfo.m44575d()) < -1.0E-7d || ((double) this.f37882o.m44575d()) > 1.0E-7d) ? (int) (this.f37882o.m44575d() * 1000.0f) : 3500;
                    this.f37774G = new AbstractC8105i.d(this.f37821ae, 1000L);
                    return true;
                }
                str = "splash view not ready. ";
            }
        } else {
            str = "not register linkedSplashAd and destview. ";
        }
        AbstractC7185ho.m43823c("PPSLinkedView", str);
        m49285x();
        mo49298i();
        unregister();
        return false;
    }

    /* renamed from: z */
    private void m49287z() {
        this.f37872e.m47394a(this.f37879l.mo44485F(), this.f37882o, this.f37881n);
        this.f37892y.setClickable(false);
    }

    @OuterVisible
    public void addLinkedMediaStateListener(ILinkedMediaStateListener iLinkedMediaStateListener) {
        if (iLinkedMediaStateListener == null) {
            return;
        }
        this.f37887t = iLinkedMediaStateListener;
    }

    @OuterVisible
    public void addMuteListener(MuteListener muteListener) {
        this.f37888u = muteListener;
    }

    @OuterVisible
    public void destroyView() {
        AbstractC7185ho.m43820b("PPSLinkedView", "destroyView. ");
        unregister();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            int iM47282a = C7694tp.m47282a(motionEvent);
            if (iM47282a == 0) {
                this.f37873f = C7694tp.m47283a(this, motionEvent);
            }
            if (1 == iM47282a) {
                C7694tp.m47284a(this, motionEvent, null, this.f37873f);
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("PPSLinkedView", "dispatchTouchEvent exception : %s", th2.getClass().getSimpleName());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.huawei.openalliance.p169ad.C7330jd.a
    /* renamed from: e */
    public void mo45271e() {
        AbstractC7185ho.m43820b("PPSLinkedView", "onViewShownBetweenFullAndPartial: ");
        this.f37872e.m47402d(this.f37882o);
    }

    @Override // com.huawei.openalliance.p169ad.views.AbstractC8105i
    /* renamed from: f */
    public void mo49295f() throws Resources.NotFoundException {
        if (!this.f37786S) {
            this.f37786S = true;
            LinkedSplashAd linkedSplashAd = this.f37879l;
            if (linkedSplashAd != null && linkedSplashAd.isFromExsplash()) {
                C7484ms.m45854a(this.f37874g).m45855a(RTCMethods.DISMISS_SLOGAN, null, null, null);
            }
            this.f37784Q = System.currentTimeMillis();
            if (!this.f37875h.mo43401bb()) {
                m49257a((Long) null, (Integer) null, (Integer) 8, false);
                this.f37827ak = true;
            }
            if (!this.f37813aW && this.f37820ad == 1) {
                m49234J();
            }
        }
        View view = this.f37775H;
        if (view != null) {
            view.setVisibility(8);
            this.f37775H = null;
        }
        if (this.f37769B != null) {
            AbstractC7185ho.m43817a("PPSLinkedView", "PPSSplashView is not null. ");
            this.f37769B.setVisibility(8);
            this.f37769B = null;
        }
        View view2 = this.f37779L;
        if (view2 != null) {
            view2.setVisibility(8);
            this.f37779L = null;
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.AbstractC8105i
    /* renamed from: g */
    public void mo49296g() {
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        AbstractC7185ho.m43820b("PPSLinkedView", "calculateScaleAndTrans");
        m49225A();
        if (this.f37790W <= 0.0f || this.f37817aa <= 0.0f) {
            AbstractC7185ho.m43823c("PPSLinkedView", "calculateScaleAndTrans, get screen size failed. ");
            mo49298i();
            unregister();
            return;
        }
        boolean zM48337m = AbstractC7811dd.m48337m(this.f37874g);
        AbstractC7185ho.m43821b("PPSLinkedView", "calculateScaleAndTrans, MultiWindow:%s, screenHeight:%s,  screenWidth:%s", Boolean.valueOf(zM48337m), Float.valueOf(this.f37790W), Float.valueOf(this.f37817aa));
        this.f37893z.getLocationOnScreen(this.f37825ai);
        this.f37818ab = this.f37893z.getHeight();
        this.f37819ac = this.f37893z.getWidth();
        AbstractC7185ho.m43821b("PPSLinkedView", "calculateScaleAndTrans, destViewHeight:%s, destViewWidth:%s, locationX:%s, locationY:%s", Integer.valueOf(this.f37818ab), Integer.valueOf(this.f37819ac), Integer.valueOf(this.f37825ai[0]), Integer.valueOf(this.f37825ai[1]));
        Point point = new Point();
        this.f37770C.getDefaultDisplay().getRealSize(point);
        AbstractC7185ho.m43818a("PPSLinkedView", "calculateScaleAndTrans, screenHeight:%s, point.y:%s", Float.valueOf(this.f37790W), Integer.valueOf(point.y));
        if (this.f37788U <= 0 && C6982bz.m41148a(this.f37874g).mo41171a(this.f37874g)) {
            this.f37788U = Math.max(this.f37788U, C6982bz.m41148a(this.f37874g).mo41169a(this));
        }
        if ((point.y - this.f37788U) - this.f37790W > AbstractC7811dd.m48334j(this.f37874g)) {
            this.f37789V = AbstractC7811dd.m48329g(this.f37874g);
        } else {
            this.f37789V = 0;
        }
        AbstractC7185ho.m43821b("PPSLinkedView", "calculateScaleAndTrans, NotchEnable: %s, scrennHeight:%s, screenWidth:%s, navigationBarHeight:%s, notchHeight:%s", Boolean.valueOf(C6982bz.m41148a(this.f37874g).mo41171a(this.f37874g)), Float.valueOf(this.f37790W), Float.valueOf(this.f37817aa), Integer.valueOf(this.f37789V), Integer.valueOf(this.f37788U));
        if (C6982bz.m41148a(this.f37874g).mo41171a(this.f37874g)) {
            if (zM48337m) {
                int i10 = this.f37818ab;
                f13 = this.f37790W;
                int i11 = this.f37788U;
                this.f37822af = (i10 * 1.0f) / (i11 + f13);
                f12 = this.f37825ai[1] + ((i10 * 1.0f) / 2.0f);
                f14 = i11;
            } else {
                int i12 = this.f37818ab;
                float f15 = this.f37790W;
                int i13 = this.f37788U;
                int i14 = this.f37789V;
                this.f37822af = (i12 * 1.0f) / ((i13 + f15) + i14);
                f12 = this.f37825ai[1] + ((i12 * 1.0f) / 2.0f);
                f13 = f15 + i13;
                f14 = i14;
            }
            f11 = f12 - (((f13 + f14) * 1.0f) / 2.0f);
        } else {
            if (zM48337m) {
                int i15 = this.f37818ab;
                float f16 = this.f37790W;
                this.f37822af = (i15 * 1.0f) / f16;
                f10 = (this.f37825ai[1] + ((i15 * 1.0f) / 2.0f)) - ((f16 * 1.0f) / 2.0f);
            } else {
                int i16 = this.f37818ab;
                int i17 = this.f37789V;
                float f17 = this.f37790W;
                this.f37822af = (i16 * 1.0f) / (i17 + f17);
                f10 = (this.f37825ai[1] + ((i16 * 1.0f) / 2.0f)) - (((f17 + i17) * 1.0f) / 2.0f);
            }
            f11 = f10 - this.f37788U;
        }
        this.f37823ag = f11;
        this.f37824ah = ((this.f37819ac * 1.0f) / this.f37817aa) * 1.0f;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.IPPSLinkedView
    public String getSplashViewSlotPosition() {
        return AbstractC7811dd.m48288a((InterfaceC7337jk) this.f37769B);
    }

    @Override // com.huawei.openalliance.p169ad.views.AbstractC8105i
    /* renamed from: h */
    public void mo49297h() {
        if (this.f37820ad != 1 || this.f37826aj) {
            return;
        }
        this.f37826aj = true;
        m49233I();
        this.f37820ad = 0;
        this.f37872e.m47408i();
        m49230F();
        C8099g c8099g = this.f37891x;
        if (c8099g != null) {
            c8099g.m50178i();
        }
        this.f37769B = null;
        this.f37775H = null;
        this.f37779L = null;
        m49243S();
        PPSSplashProView pPSSplashProView = this.f37799aI;
        if (pPSSplashProView != null) {
            pPSSplashProView.m49665a();
        }
        if (this.f37827ak || !this.f37781N) {
            return;
        }
        AbstractC7185ho.m43817a("PPSLinkedView", "report imp and phyImp on splash. ");
        this.f37883p.mo46128a(System.currentTimeMillis() - this.f37783P, 100);
        mo49292a((Integer) 8, false);
    }

    @Override // com.huawei.openalliance.p169ad.views.AbstractC8105i
    /* renamed from: i */
    public void mo49298i() {
        AbstractC7185ho.m43821b("PPSLinkedView", "reportDisplayError, adMediator: %s, linkedAdListener: %s", AbstractC7806cz.m48162b(this.f37880m), AbstractC7806cz.m48162b(this.f37828al));
        boolean z10 = this.f37797aG;
        if (!z10 && this.f37880m != null) {
            AbstractC7185ho.m43820b("PPSLinkedView", "report display error. ");
            this.f37797aG = true;
            this.f37880m.mo45168c(-3);
            this.f37880m.mo45209B();
            return;
        }
        if (z10) {
            return;
        }
        AbstractC7185ho.m43820b("PPSLinkedView", "report fail to display. ");
        this.f37797aG = true;
        m49271c(-3);
    }

    @Override // com.huawei.openalliance.p169ad.views.AbstractC8105i
    /* renamed from: j */
    public void mo49299j() {
        AbstractC7185ho.m43820b("PPSLinkedView", "startScaleDown. ");
        m49233I();
        if (!m49227C()) {
            if (this.f37827ak || this.f37784Q == -1) {
                return;
            }
            this.f37883p.mo46128a(System.currentTimeMillis() - this.f37784Q, 100);
            this.f37784Q = -1L;
            return;
        }
        this.f37837au = true;
        mo49296g();
        this.f37889v.setClickable(false);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f37838av = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(new InterpolatorC7160gq(0.4f, 0.0f, 0.2f, 1.0f));
        this.f37838av.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.5
            public C79645() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                try {
                    float animatedFraction = (valueAnimator.getAnimatedFraction() * (PPSLinkedView.this.f37822af - 1.0f)) + 1.0f;
                    float animatedFraction2 = valueAnimator.getAnimatedFraction();
                    PPSLinkedView pPSLinkedView = PPSLinkedView.this;
                    float f10 = (animatedFraction2 * (pPSLinkedView.f37824ah - 1.0f)) + 1.0f;
                    LinkedSurfaceView linkedSurfaceView = pPSLinkedView.f37892y;
                    float animatedFraction3 = valueAnimator.getAnimatedFraction();
                    PPSLinkedView pPSLinkedView2 = PPSLinkedView.this;
                    linkedSurfaceView.m48800a(animatedFraction, animatedFraction3 * pPSLinkedView2.f37823ag, f10, (int) (pPSLinkedView2.f37817aa * f10), (int) (pPSLinkedView2.f37790W * animatedFraction));
                } catch (Throwable th2) {
                    AbstractC7185ho.m43821b("PPSLinkedView", "scaleAndTransAnimation err: %s", th2.getClass().getSimpleName());
                }
            }
        });
        m49232H();
        this.f37838av.setDuration(1000L).start();
    }

    @Override // com.huawei.openalliance.p169ad.views.AbstractC8105i
    /* renamed from: m */
    public /* bridge */ /* synthetic */ InterfaceC7328jb mo49300m() {
        return super.mo49300m();
    }

    @OuterVisible
    public void mute() {
        AbstractC7185ho.m43820b("PPSLinkedView", "call mute. ");
        this.f37872e.m47397b(this.f37882o);
    }

    @Override // com.huawei.openalliance.p169ad.views.AbstractC8105i
    /* renamed from: n */
    public /* bridge */ /* synthetic */ C8074ai mo49301n() {
        return super.mo49301n();
    }

    /* renamed from: o */
    public void m49302o() {
        AbstractC7185ho.m43820b("PPSLinkedView", "onClose");
        m49239O();
        this.f37883p.mo46139c();
        mo49292a((Integer) 3, true);
        this.f37871d.m47381c();
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        AbstractC7185ho.m43821b("PPSLinkedView", "onApplyWindowInsets, sdk: %s", Integer.valueOf(Build.VERSION.SDK_INT));
        if (AbstractC7811dd.m48308b() && windowInsets != null) {
            DisplayCutout displayCutout = windowInsets.getDisplayCutout();
            if (displayCutout != null) {
                List<Rect> boundingRects = displayCutout.getBoundingRects();
                if (!AbstractC7760bg.m47767a(boundingRects)) {
                    this.f37788U = boundingRects.get(0).height();
                }
            } else {
                AbstractC7185ho.m43820b("PPSLinkedView", "DisplayCutout is null");
            }
        }
        if (this.f37788U <= 0 && C6982bz.m41148a(this.f37874g).mo41171a(this.f37874g)) {
            this.f37788U = Math.max(this.f37788U, C6982bz.m41148a(this.f37874g).mo41169a(this));
        }
        AbstractC7185ho.m43820b("PPSLinkedView", "notchHeight:" + this.f37788U);
        return super.onApplyWindowInsets(windowInsets);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        AbstractC7185ho.m43817a("PPSLinkedView", "onAttachedToWindow");
        C7330jd c7330jd = this.f37878k;
        if (c7330jd != null) {
            c7330jd.m45301h();
        }
        AbstractC7817dj.m48366a(this.f37870c);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AbstractC7185ho.m43817a("PPSLinkedView", "onDetechedFromWindow");
        C7330jd c7330jd = this.f37878k;
        if (c7330jd != null) {
            c7330jd.m45302i();
        }
        AbstractC7817dj.m48366a(this.f37870c);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        AbstractC7185ho.m43817a("PPSLinkedView", "onVisibilityChanged:");
        C7330jd c7330jd = this.f37878k;
        if (c7330jd != null) {
            c7330jd.m45303j();
        }
    }

    /* renamed from: p */
    public boolean m49303p() {
        C7330jd c7330jd = this.f37878k;
        if (c7330jd != null) {
            return c7330jd.m45307n();
        }
        return false;
    }

    @OuterVisible
    public void pause() {
        AbstractC7185ho.m43820b("PPSLinkedView", "call pause. ");
        this.f37872e.m47406g();
    }

    @OuterVisible
    public void play() {
        AbstractC7185ho.m43820b("PPSLinkedView", "call play. ");
        this.f37872e.m47407h();
    }

    @OuterVisible
    public void prepare() {
        if (this.f37830an) {
            AbstractC7185ho.m43823c("PPSLinkedView", "register failed, can't prepare now");
            return;
        }
        if (this.f37839aw) {
            AbstractC7185ho.m43823c("PPSLinkedView", "already prepared");
            return;
        }
        LinkedSplashAd linkedSplashAd = this.f37879l;
        if (linkedSplashAd != null && linkedSplashAd.isFromExsplash()) {
            LinkedAdListener linkedAdListenerMo44054g = HiAd.m44014a(this.f37874g).mo44054g();
            this.f37828al = linkedAdListenerMo44054g;
            this.f37879l.setListener(linkedAdListenerMo44054g);
        }
        if (!m49286y()) {
            AbstractC7185ho.m43823c("PPSLinkedView", "prepare check failed");
            return;
        }
        LinkedSplashAd linkedSplashAd2 = this.f37879l;
        if (linkedSplashAd2 == null || this.f37882o == null) {
            AbstractC7185ho.m43823c("PPSLinkedView", "prepare, linkedSplashAd is null");
            return;
        }
        m49276e(linkedSplashAd2.m44490K());
        AbstractC7185ho.m43820b("PPSLinkedView", "start prepare");
        m49287z();
        this.f37872e.m47396b();
    }

    @OuterVisible
    public void register(ILinkedSplashAd iLinkedSplashAd) {
        AbstractC7185ho.m43821b("PPSLinkedView", "register, linkedSplashAd: %s. ", iLinkedSplashAd);
        if (this.f37834ar) {
            AbstractC7185ho.m43823c("PPSLinkedView", "Already registered ad, can't register now");
            return;
        }
        this.f37834ar = true;
        if (iLinkedSplashAd instanceof LinkedSplashAd) {
            LinkedSplashAd linkedSplashAd = (LinkedSplashAd) iLinkedSplashAd;
            this.f37879l = linkedSplashAd;
            linkedSplashAd.setListener(this.f37828al);
            VideoInfo videoInfo = this.f37879l.getVideoInfo();
            this.f37882o = videoInfo;
            if (videoInfo != null && !videoInfo.m44582e()) {
                this.f37773F = false;
            }
            this.f37883p.mo46130a(this.f37879l);
            m49241Q();
            this.f37883p.mo46140h();
        }
        m49242R();
    }

    @OuterVisible
    public void registerSplashView(PPSSplashView pPSSplashView) {
        AbstractC7185ho.m43820b("PPSLinkedView", "begin register splashView");
        if (this.f37833aq) {
            AbstractC7185ho.m43823c("PPSLinkedView", "Already registered splashView, can't register now");
            return;
        }
        this.f37833aq = true;
        this.f37769B = pPSSplashView;
        if (pPSSplashView != null) {
            if (pPSSplashView.getAdListener() instanceof LinkedAdListener) {
                this.f37828al = (LinkedAdListener) pPSSplashView.getAdListener();
            }
            this.f37776I = pPSSplashView.getLogoResId();
            this.f37780M = pPSSplashView.getMediaNameResId();
            this.f37779L = pPSSplashView.getLogo();
            this.f37775H = pPSSplashView.getSloganView();
            this.f37880m = pPSSplashView.getAdMediator();
            this.f37881n = pPSSplashView.getAudioFocusType();
        }
        AbstractC7185ho.m43821b("PPSLinkedView", "register PPSSplashView, linkedAdListener: %s. ", AbstractC7806cz.m48162b(this.f37828al));
    }

    @OuterVisible
    public void resumeView() {
        ValueAnimator valueAnimator;
        AbstractC7185ho.m43821b("PPSLinkedView", "resumeView, LinkedState: %s", Integer.valueOf(this.f37820ad));
        if (this.f37835as) {
            this.f37820ad = 2;
        }
        int i10 = this.f37820ad;
        if (i10 == 2) {
            this.f37872e.m47390a(this.f37882o);
            if (this.f37878k == null) {
                m49231G();
            }
            C7330jd c7330jd = this.f37878k;
            if (c7330jd != null) {
                c7330jd.m45263f();
            }
        } else if (i10 == 1 && this.f37786S) {
            m49233I();
            if (this.f37837au && (valueAnimator = this.f37838av) != null) {
                valueAnimator.end();
            }
            m49272c(true);
            LinkedAdListener linkedAdListener = this.f37828al;
            if (linkedAdListener != null) {
                linkedAdListener.onAdDismissed();
            }
            this.f37820ad = 2;
        }
        if (this.f37769B != null) {
            this.f37769B = null;
        }
        if (this.f37775H != null) {
            this.f37775H = null;
        }
        if (this.f37779L != null) {
            this.f37779L = null;
        }
    }

    @OuterVisible
    public void setAdShowListener(AdShowListener adShowListener) {
        AbstractC7185ho.m43820b("PPSLinkedView", "setAdShowListener. ");
        InterfaceC7531nz interfaceC7531nz = this.f37883p;
        if (interfaceC7531nz != null) {
            interfaceC7531nz.mo46132a(adShowListener);
        }
    }

    @OuterVisible
    public void setLinkedAdActionListener(AdActionListener adActionListener) {
        AbstractC7185ho.m43820b("PPSLinkedView", "setLinkedAdActionListener. ");
        InterfaceC7531nz interfaceC7531nz = this.f37883p;
        if (interfaceC7531nz != null) {
            interfaceC7531nz.mo46131a(adActionListener);
        }
    }

    @OuterVisible
    public void setMuteOnlyOnLostAudioFocus(boolean z10) {
        this.f37841ay = z10;
    }

    @OuterVisible
    public void setOnLinkedAdClickListener(OnLinkedAdClickListener onLinkedAdClickListener) {
        this.f37885r = onLinkedAdClickListener;
    }

    @OuterVisible
    public void setOnLinkedAdPreparedListener(OnLinkedAdPreparedListener onLinkedAdPreparedListener) {
        this.f37886s = onLinkedAdPreparedListener;
    }

    @OuterVisible
    public void setOnLinkedAdSwitchListener(OnLinkedAdSwitchListener onLinkedAdSwitchListener) {
        this.f37884q = onLinkedAdSwitchListener;
    }

    @OuterVisible
    public void start() throws Resources.NotFoundException {
        PPSSplashView pPSSplashView;
        AbstractC7185ho.m43820b("PPSLinkedView", "start. ");
        boolean z10 = this.f37830an;
        if (z10 || this.f37831ao) {
            AbstractC7185ho.m43824c("PPSLinkedView", "can't start now, reg fail: %s, already start: %s", Boolean.valueOf(z10), Boolean.valueOf(this.f37831ao));
            return;
        }
        this.f37831ao = true;
        if (this.f37880m == null && (pPSSplashView = this.f37769B) != null && pPSSplashView.getAdMediator() != null) {
            AbstractC7185ho.m43820b("PPSLinkedView", "set mediator.");
            this.f37880m = this.f37769B.getAdMediator();
        }
        LinkedSplashAd linkedSplashAd = this.f37879l;
        if (linkedSplashAd != null && linkedSplashAd.isFromExsplash()) {
            this.f37776I = HiAd.m44014a(this.f37874g).mo44055h();
            this.f37780M = HiAd.m44014a(this.f37874g).mo44056i();
            LinkedAdListener linkedAdListenerMo44054g = HiAd.m44014a(this.f37874g).mo44054g();
            this.f37828al = linkedAdListenerMo44054g;
            this.f37879l.setListener(linkedAdListenerMo44054g);
        }
        InterfaceC7328jb interfaceC7328jb = this.f37880m;
        if (interfaceC7328jb != null && interfaceC7328jb.mo45193t()) {
            AbstractC7185ho.m43823c("PPSLinkedView", "already started play normal ad. ");
            m49285x();
            mo49298i();
            unregister();
            return;
        }
        AbstractC7185ho.m43821b("PPSLinkedView", "start, adMediator:%s, splashView:%s", this.f37880m, this.f37769B);
        PPSSplashView pPSSplashView2 = this.f37769B;
        if (pPSSplashView2 != null) {
            AbstractC7185ho.m43821b("PPSLinkedView", "start, splashView.getAdMediator():%s", pPSSplashView2.getAdMediator());
        }
        if (this.f37880m instanceof C7327ja) {
            AbstractC7185ho.m43820b("PPSLinkedView", "start, set shown");
            ((C7327ja) this.f37880m).m45246b(true);
        }
        if (m49282u()) {
            return;
        }
        m49276e(this.f37879l.m44490K());
        this.f37813aW = false;
        this.f37820ad = 1;
        this.f37821ae = (((double) this.f37882o.m44575d()) < -1.0E-7d || ((double) this.f37882o.m44575d()) > 1.0E-7d) ? (int) (this.f37882o.m44575d() * 1000.0f) : 3500;
        this.f37774G = new AbstractC8105i.d(this.f37821ae, 1000L);
        m49287z();
        if (!m49284w()) {
            AbstractC7185ho.m43823c("PPSLinkedView", "exsplash unable user info or over time, can't start now");
            return;
        }
        this.f37770C.addView(this.f37889v, m49261b(this.f37874g));
        this.f37809aS = new WeakReference<>(getContext());
        m50297a(this.f37874g);
        m49253a(this.f37879l, this.f37875h.mo43368az());
        m49283v();
        m49268b(false);
    }

    @OuterVisible
    public void stopView() {
        ValueAnimator valueAnimator;
        AbstractC7185ho.m43821b("PPSLinkedView", "stopView, LinkedState: %s, isStartScale: %s", Integer.valueOf(this.f37820ad), Boolean.valueOf(this.f37837au));
        if (this.f37820ad == 1) {
            if (!this.f37827ak && this.f37781N && !this.f37837au) {
                AbstractC7185ho.m43817a("PPSLinkedView", "report imp on splash. ");
                mo49292a((Integer) 8, false);
                this.f37883p.mo46128a(System.currentTimeMillis() - this.f37784Q, 100);
                this.f37784Q = -1L;
            }
            m49233I();
            if (this.f37837au && (valueAnimator = this.f37838av) != null) {
                this.f37791aA = false;
                valueAnimator.end();
            }
            AbstractC7817dj.m48364a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.8
                public RunnableC79678() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    PPSLinkedView.this.m49272c(false);
                }
            }, 200L);
            this.f37835as = true;
            this.f37820ad = 2;
        }
        PPSSplashView pPSSplashView = this.f37769B;
        if (pPSSplashView != null) {
            pPSSplashView.setVisibility(8);
            this.f37769B = null;
        }
        if (this.f37775H != null) {
            this.f37775H = null;
        }
        if (this.f37779L != null) {
            this.f37779L = null;
        }
        this.f37872e.m47406g();
        LinkedSplashAd linkedSplashAd = this.f37879l;
        if (linkedSplashAd != null) {
            linkedSplashAd.m44847j(false);
        }
    }

    @OuterVisible
    public void unmute() {
        AbstractC7185ho.m43820b("PPSLinkedView", "call unmute. ");
        this.f37872e.m47400c(this.f37882o);
    }

    @OuterVisible
    public void unregister() {
        AbstractC7185ho.m43820b("PPSLinkedView", "unregister. ");
        m49240P();
    }

    @OuterVisible
    public PPSLinkedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* renamed from: a */
    private String m49247a(InteractCfg interactCfg) {
        if (interactCfg != null) {
            return interactCfg.m40217h();
        }
        return null;
    }

    /* renamed from: b */
    private String m49262b(InteractCfg interactCfg) {
        if (interactCfg != null) {
            return interactCfg.m40218i();
        }
        return null;
    }

    /* renamed from: c */
    private String m49270c(InteractCfg interactCfg) {
        if (interactCfg != null) {
            return interactCfg.m40219j();
        }
        return null;
    }

    /* renamed from: d */
    private String m49274d(InteractCfg interactCfg) {
        if (interactCfg != null) {
            return interactCfg.m40220k();
        }
        return null;
    }

    /* renamed from: e */
    private void m49276e(ContentRecord contentRecord) {
        if (contentRecord == null || this.f37872e.m47405f() == null) {
            return;
        }
        AbstractC7185ho.m43820b("PPSLinkedView", "initOmsdkResource");
        this.f37871d.m47378a(this, contentRecord, this.f37893z, this.f37874g, this.f37889v);
    }

    @OuterVisible
    public void register(ILinkedSplashAd iLinkedSplashAd, List<View> list, PPSDestView pPSDestView) {
        AbstractC7185ho.m43821b("PPSLinkedView", "register, linkedSplashAd: %s, clickableViews: %s, destView: %s. ", iLinkedSplashAd, list, pPSDestView);
        if (this.f37829am) {
            AbstractC7185ho.m43823c("PPSLinkedView", "Already registered, can't register now");
            return;
        }
        if (iLinkedSplashAd == null || iLinkedSplashAd.getVideoInfo() == null) {
            AbstractC7185ho.m43823c("PPSLinkedView", "register failed, ad is null");
            return;
        }
        this.f37829am = true;
        if (this.f37879l == null) {
            register(iLinkedSplashAd);
        }
        if (pPSDestView == null) {
            AbstractC7185ho.m43823c("PPSLinkedView", "register failed, destView is null");
            this.f37830an = true;
            return;
        }
        this.f37893z = pPSDestView;
        setDestViewClickable(pPSDestView);
        this.f37872e.m47389a(this.f37874g, iLinkedSplashAd);
        if (list != null) {
            this.f37768A = list;
            m49258a(list);
        }
        this.f37889v = new C8074ai(this.f37874g);
        m49251a(iLinkedSplashAd);
        m49279r();
        m49281t();
        m49278q();
        this.f37777J = this.f37889v.getViewStub();
        m49280s();
        setSplashViewClickable(this.f37889v);
        AbstractC7185ho.m43820b("PPSLinkedView", "add view");
        pPSDestView.post(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.2

            /* renamed from: a */
            final /* synthetic */ PPSDestView f36799a;

            public RunnableC79612(PPSDestView pPSDestView2) {
                pPSDestView = pPSDestView2;
            }

            @Override // java.lang.Runnable
            public void run() {
                PPSDestView pPSDestView2;
                AbstractC7185ho.m43817a("PPSLinkedView", "destView post");
                if (!AbstractC7811dd.m48315c() || (pPSDestView2 = pPSDestView) == null || pPSDestView2.getX() >= 0.0f) {
                    return;
                }
                PPSLinkedView.this.m49225A();
                PPSDestView pPSDestView22 = pPSDestView;
                pPSDestView22.setX((PPSLinkedView.this.f37817aa - Math.abs(pPSDestView22.getX())) - pPSDestView.getWidth());
            }
        });
        pPSDestView2.addView(this.f37872e.m47405f(), getDestViewParam());
    }

    @OuterVisible
    public void start(Context context) throws Resources.NotFoundException {
        if (this.f37830an) {
            AbstractC7185ho.m43823c("PPSLinkedView", "register failed, can't start now");
            return;
        }
        boolean z10 = this.f37831ao;
        if (z10 || !this.f37839aw) {
            AbstractC7185ho.m43824c("PPSLinkedView", "Already started:%s, isPrepared:%s, can't start now", Boolean.valueOf(z10), Boolean.valueOf(this.f37839aw));
            return;
        }
        if (!(context instanceof Activity)) {
            AbstractC7185ho.m43823c("PPSLinkedView", "context not activity");
            m49285x();
            mo49298i();
            unregister();
            return;
        }
        this.f37809aS = new WeakReference<>(context);
        this.f37831ao = true;
        InterfaceC7328jb interfaceC7328jb = this.f37880m;
        if (interfaceC7328jb != null && interfaceC7328jb.mo45193t()) {
            AbstractC7185ho.m43823c("PPSLinkedView", "already started play normal ad. ");
            m49285x();
            mo49298i();
            unregister();
            return;
        }
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.f37880m == null);
        AbstractC7185ho.m43821b("PPSLinkedView", "start after prepare, mediator: %S", objArr);
        PPSSplashView pPSSplashView = this.f37769B;
        if (pPSSplashView != null) {
            AbstractC7185ho.m43821b("PPSLinkedView", "test, mediator: %S", pPSSplashView.getAdMediator());
        }
        if (this.f37880m instanceof C7327ja) {
            AbstractC7185ho.m43820b("PPSLinkedView", "start, set shown");
            ((C7327ja) this.f37880m).m45246b(true);
        }
        if (!m49284w()) {
            AbstractC7185ho.m43823c("PPSLinkedView", "exsplash unable user info or over time, can't start now");
            return;
        }
        this.f37813aW = false;
        this.f37874g = context.getApplicationContext();
        this.f37770C = (WindowManager) context.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR);
        this.f37770C.addView(this.f37889v, m49261b(context));
        m50297a(context);
        m49253a(this.f37879l, this.f37875h.mo43368az());
        m49283v();
        m49268b(true);
    }

    @OuterVisible
    public void unregister(IAppDownloadButton iAppDownloadButton) {
        IAppDownloadButton iAppDownloadButton2;
        AbstractC7185ho.m43820b("PPSLinkedView", "begin unregister appDownloadButton");
        if (iAppDownloadButton == null || iAppDownloadButton != (iAppDownloadButton2 = this.f37890w)) {
            return;
        }
        iAppDownloadButton2.setPpsLinkedView(null);
        this.f37890w.setNativeAd(null);
        this.f37890w = null;
        this.f37832ap = false;
    }

    @OuterVisible
    public PPSLinkedView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }

    /* renamed from: a */
    private String m49248a(InteractCfg interactCfg, String str) {
        return !TextUtils.isEmpty(str) ? str : (interactCfg == null || interactCfg.m40221l() == null) ? this.f37875h.mo43031I() : interactCfg.m40221l();
    }

    /* renamed from: b */
    private String m49263b(InteractCfg interactCfg, String str) {
        return !TextUtils.isEmpty(str) ? str : (interactCfg == null || interactCfg.m40221l() == null) ? this.f37875h.mo43033K() : interactCfg.m40221l();
    }

    /* renamed from: e */
    private boolean m49277e(int i10) {
        if (2 != i10 && 3 != i10) {
            return false;
        }
        if (this.f37875h.mo43345aL()) {
            return !C7845x.m48582l(getContext().getApplicationContext());
        }
        return true;
    }

    @Override // com.huawei.openalliance.p169ad.C7330jd.a
    /* renamed from: c */
    public void mo45269c() {
        AbstractC7185ho.m43820b("PPSLinkedView", "onViewFullShown: ");
        this.f37872e.m47391a(this.f37882o, this.f37842az);
    }

    @Override // com.huawei.openalliance.p169ad.C7330jd.a
    /* renamed from: d */
    public void mo45270d() {
        AbstractC7185ho.m43820b("PPSLinkedView", "onViewPartialHidden: ");
        this.f37872e.m47404e(this.f37882o);
    }

    @OuterVisible
    public boolean register(IAppDownloadButton iAppDownloadButton) {
        AbstractC7185ho.m43820b("PPSLinkedView", "begin register appDownloadButton");
        boolean nativeAd = false;
        if (this.f37832ap) {
            AbstractC7185ho.m43823c("PPSLinkedView", "Already registered appDownloadButton, can't register now");
            return false;
        }
        this.f37832ap = true;
        if (this.f37879l == null) {
            throw new IllegalStateException("Register INativeAd first");
        }
        this.f37890w = iAppDownloadButton;
        if (iAppDownloadButton != null) {
            iAppDownloadButton.setPpsLinkedView(this);
            nativeAd = iAppDownloadButton.setNativeAd(this.f37879l);
        }
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43818a("PPSLinkedView", "register downloadbutton, succ:%s", Boolean.valueOf(nativeAd));
        }
        return nativeAd;
    }

    @OuterVisible
    public PPSLinkedView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
    }

    /* renamed from: b */
    private String m49264b(ContentRecord contentRecord) throws Resources.NotFoundException {
        String strM47856a = C7780c.m47856a(getContext(), contentRecord, 0);
        return !TextUtils.isEmpty(strM47856a) ? strM47856a : !TextUtils.isEmpty(this.f37875h.mo43029G()) ? this.f37875h.mo43029G() : contentRecord.m41503ay();
    }

    /* renamed from: c */
    private void m49271c(int i10) {
        LinkedAdListener linkedAdListener = this.f37828al;
        if (linkedAdListener != null) {
            linkedAdListener.onAdFailedToLoad(i10);
        }
        m49275d(i10);
    }

    /* renamed from: d */
    private void m49275d(int i10) {
        String strM41486ah;
        String strM41585m;
        if (this.f37795aE != null) {
            ContentRecord contentRecordM46667a = C7565oz.m46667a(this.f37879l);
            if (contentRecordM46667a != null) {
                strM41486ah = contentRecordM46667a.m41486ah();
                strM41585m = contentRecordM46667a.m41585m();
            } else {
                strM41486ah = null;
                strM41585m = null;
            }
            this.f37795aE.m39177a(i10, new C6920a(strM41486ah, strM41585m, 1), (String) null, contentRecordM46667a);
        }
    }

    @Override // com.huawei.openalliance.p169ad.C7330jd.a
    /* renamed from: a */
    public void mo45265a() {
        AbstractC7185ho.m43820b("PPSLinkedView", "onViewShowStartRecord");
        LinkedSplashAd linkedSplashAd = this.f37879l;
        if (linkedSplashAd == null || !this.f37826aj) {
            return;
        }
        AbstractC7185ho.m43818a("PPSLinkedView", "ad.getMinEffectiveShowTime: %s. ", Long.valueOf(linkedSplashAd.getMinEffectiveShowTime()));
        AbstractC7817dj.m48365a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSLinkedView.1
            public RunnableC79601() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Long lValueOf;
                Integer numValueOf;
                int i10;
                PPSLinkedView pPSLinkedView = PPSLinkedView.this;
                LinkedSplashAd linkedSplashAd2 = pPSLinkedView.f37879l;
                if (linkedSplashAd2 == null) {
                    return;
                }
                if (pPSLinkedView.f37820ad == 2) {
                    lValueOf = Long.valueOf(linkedSplashAd2.getMinEffectiveShowTime());
                    numValueOf = Integer.valueOf(PPSLinkedView.this.f37878k.m45261d());
                    i10 = 9;
                } else {
                    lValueOf = Long.valueOf(linkedSplashAd2.getMinEffectiveShowTime());
                    numValueOf = Integer.valueOf(PPSLinkedView.this.f37878k.m45261d());
                    i10 = 8;
                }
                pPSLinkedView.m49257a(lValueOf, numValueOf, Integer.valueOf(i10), false);
            }
        }, this.f37843b, linkedSplashAd.getMinEffectiveShowTime());
    }

    /* renamed from: c */
    public void m49272c(boolean z10) {
        AbstractC7185ho.m43820b("PPSLinkedView", "moveLinkedView");
        if (m49227C() && !this.f37826aj) {
            m49230F();
            OnLinkedAdSwitchListener onLinkedAdSwitchListener = this.f37884q;
            if (onLinkedAdSwitchListener != null) {
                onLinkedAdSwitchListener.onSwitch(this.f37840ax);
            }
            if (z10) {
                m49231G();
            }
            this.f37826aj = true;
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.AbstractC8105i
    /* renamed from: a */
    public void mo49288a(int i10) {
        OnLinkedAdClickListener onLinkedAdClickListener;
        LinkedSplashAd linkedSplashAd;
        m49265b(this.f37820ad);
        InterfaceC7531nz interfaceC7531nz = this.f37883p;
        if (interfaceC7531nz == null || interfaceC7531nz.mo46135a(i10, this.f37873f)) {
            m49233I();
            if (18 == i10) {
                Context context = this.f37809aS.get();
                if (context instanceof Activity) {
                    ((Activity) context).overridePendingTransition(C6849R.anim.hiad_open, C6849R.anim.hiad_close);
                }
            }
        } else {
            IAppDownloadButton iAppDownloadButton = this.f37890w;
            if (iAppDownloadButton != null && (iAppDownloadButton instanceof AppDownloadButton)) {
                if (AppStatus.DOWNLOAD == ((AppDownloadButton) iAppDownloadButton).getStatus() && (linkedSplashAd = this.f37879l) != null && linkedSplashAd.isAutoDownloadApp() && AbstractC7558os.m46469h(this.f37879l.getCtrlSwitchs())) {
                    AbstractC7185ho.m43820b("PPSLinkedView", "download app directly");
                    ((AppDownloadButton) this.f37890w).performClick();
                }
            }
        }
        this.f37873f = null;
        this.f37871d.m47375a();
        int i11 = this.f37820ad;
        int i12 = 1;
        if (i11 == 1) {
            this.f37840ax = 3;
            onLinkedAdClickListener = this.f37885r;
            if (onLinkedAdClickListener == null) {
                return;
            }
        } else {
            i12 = 2;
            if (i11 != 2) {
                return;
            }
            this.f37840ax = 4;
            onLinkedAdClickListener = this.f37885r;
            if (onLinkedAdClickListener == null) {
                return;
            }
        }
        onLinkedAdClickListener.onClick(i12);
    }

    @Override // com.huawei.openalliance.p169ad.C7330jd.a
    /* renamed from: b */
    public void mo45267b() {
        LinkedSplashAd linkedSplashAd;
        AbstractC7185ho.m43820b("PPSLinkedView", "onViewPhysicalShowStart");
        if (!this.f37826aj || (linkedSplashAd = this.f37879l) == null || linkedSplashAd.m44814aj()) {
            return;
        }
        m50299l();
        m50298k();
    }

    /* renamed from: b */
    private void m49265b(int i10) {
        int i11;
        if (i10 == 1) {
            i11 = 12;
        } else if (i10 != 2) {
            return;
        } else {
            i11 = 13;
        }
        mo49292a(Integer.valueOf(i11), true);
    }

    @Override // com.huawei.openalliance.p169ad.views.AbstractC8105i
    /* renamed from: a */
    public void mo49289a(int i10, boolean z10) {
        VideoInfo videoInfo = this.f37882o;
        if (videoInfo != null) {
            videoInfo.m44579e(z10 ? 0 : i10);
        }
        if (this.f37781N) {
            this.f37781N = false;
            InterfaceC7531nz interfaceC7531nz = this.f37883p;
            long j10 = this.f37783P;
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j11 = this.f37785R;
            long j12 = i10;
            if (z10) {
                interfaceC7531nz.mo46129a(j10, jCurrentTimeMillis, j11, j12);
                this.f37871d.m47386h();
            } else {
                interfaceC7531nz.mo46137b(j10, jCurrentTimeMillis, j11, j12);
                this.f37871d.m47387i();
            }
        }
        this.f37872e.m47398b(false);
    }

    @Override // com.huawei.openalliance.p169ad.C7330jd.a
    /* renamed from: a */
    public void mo45266a(long j10, int i10) {
        AbstractC7185ho.m43820b("PPSLinkedView", "onViewShowEndRecord");
        AbstractC7817dj.m48366a(this.f37843b);
        if (!this.f37878k.m45256a(j10) || this.f37787T) {
            return;
        }
        this.f37787T = true;
        m49257a(Long.valueOf(j10), Integer.valueOf(i10), Integer.valueOf(this.f37820ad == 2 ? 9 : 8), false);
    }

    @Override // com.huawei.openalliance.p169ad.C7330jd.a
    /* renamed from: b */
    public void mo45268b(long j10, int i10) {
        AbstractC7185ho.m43820b("PPSLinkedView", "onViewPhysicalShowEnd: ");
        AbstractC7817dj.m48366a(this.f37843b);
        LinkedSplashAd linkedSplashAd = this.f37879l;
        if (linkedSplashAd != null) {
            linkedSplashAd.m44847j(false);
        }
        this.f37872e.m47403e();
        AbstractC7185ho.m43818a("PPSLinkedView", "onViewPhysicalShowEnd, noPhyImp: %s. ", Boolean.valueOf(this.f37827ak));
        if (this.f37827ak || i10 <= 0) {
            return;
        }
        AbstractC7185ho.m43817a("PPSLinkedView", "report phyImp. ");
        if (this.f37784Q == -1) {
            this.f37883p.mo46128a(j10, i10);
        } else {
            this.f37883p.mo46128a(System.currentTimeMillis() - this.f37784Q, i10);
            this.f37784Q = -1L;
        }
    }

    /* renamed from: a */
    private void m49249a(ContentRecord contentRecord) {
        int iIntValue;
        if (contentRecord.m41459aK() != null) {
            InteractCfg interactCfgM41459aK = contentRecord.m41459aK();
            this.f37806aP = (interactCfgM41459aK.m40201b() == null || interactCfgM41459aK.m40201b().intValue() <= 0) ? C7124fh.m43316b(getContext()).mo43032J() : interactCfgM41459aK.m40201b().intValue();
            this.f37808aR = interactCfgM41459aK.m40204c() != null ? interactCfgM41459aK.m40204c().intValue() : C7124fh.m43316b(getContext()).mo43035M();
            this.f37807aQ = interactCfgM41459aK.m40207d() != null ? interactCfgM41459aK.m40207d().intValue() : C7124fh.m43316b(getContext()).mo43034L();
            this.f37810aT = interactCfgM41459aK.m40215g().intValue();
            iIntValue = interactCfgM41459aK.m40210e().intValue();
        } else {
            this.f37806aP = C7124fh.m43316b(getContext()).mo43032J();
            this.f37808aR = C7124fh.m43316b(getContext()).mo43035M();
            this.f37807aQ = C7124fh.m43316b(getContext()).mo43034L();
            iIntValue = 0;
        }
        this.f37805aO = iIntValue;
        this.f37804aN = this.f37807aQ * 2;
    }

    /* renamed from: b */
    private void m49266b(LinkedSplashAd linkedSplashAd) {
        AbstractC7185ho.m43821b("PPSLinkedView", "LinkedSplashAd:%s, isChinaRom:%s", linkedSplashAd, Boolean.valueOf(this.f37792aB));
        if (linkedSplashAd != null) {
            Integer numM49273d = m49273d(linkedSplashAd.m44490K());
            InteractCfg interactCfgM41459aK = linkedSplashAd.m44490K().m41459aK();
            Integer numM40213f = interactCfgM41459aK == null ? null : interactCfgM41459aK.m40213f();
            if (this.f37792aB) {
                this.f37877j.m49618a(this, numM49273d, numM40213f, AbstractC7741ao.m47555a(true, linkedSplashAd.isTransparencyOpen(), linkedSplashAd.getTransparencyTplUrl()));
                this.f37877j.setVisibility(0);
                this.f37877j.m49617a(linkedSplashAd.m44490K(), false, this.f37788U, 1, false);
                return;
            }
            this.f37876i.setPpsLinkedView(this);
            this.f37876i.m49732a(numM49273d, numM40213f);
            this.f37876i.setVisibility(0);
            this.f37876i.m49731a(linkedSplashAd.m44490K(), false, this.f37788U, 1, false);
            if (AbstractC7760bg.m47767a(linkedSplashAd.m44491L())) {
                return;
            }
            this.f37876i.setChoiceViewOnClickListener(new AbstractC8105i.a(this, linkedSplashAd.m44490K()));
        }
    }

    /* renamed from: a */
    private void m49250a(ContentRecord contentRecord, int i10) {
        m49235K();
        this.f37799aI.setVisibility(4);
        this.f37799aI.setDesc(m49264b(contentRecord));
        this.f37799aI.m49666a(false, i10);
        if (i10 != 0) {
            this.f37799aI.setVisibility(0);
        }
        this.f37889v.setOnTouchListener(this.f37849bf);
    }

    /* renamed from: b */
    private void m49268b(boolean z10) throws Resources.NotFoundException {
        AbstractC7185ho.m43820b("PPSLinkedView", "start play. ");
        this.f37872e.m47395a(this.f37841ay);
        if (z10) {
            this.f37813aW = true;
            m49234J();
        }
        if (this.f37774G != null) {
            AbstractC7185ho.m43820b("PPSLinkedView", "start count down. ");
            this.f37774G.start();
        }
    }

    /* renamed from: a */
    public void m49290a(ContentRecord contentRecord, int[] iArr, int[] iArr2) {
        if (AbstractC7741ao.m47556a(iArr, 2) && AbstractC7741ao.m47556a(iArr2, 2) && contentRecord != null) {
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("PPSLinkedView", "addComplianceDialog, loc: %s, %s", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
                AbstractC7185ho.m43818a("PPSLinkedView", "addComplianceDialog, size: %s, %s", Integer.valueOf(iArr2[0]), Integer.valueOf(iArr2[1]));
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            C7695tq c7695tq = new C7695tq(getContext(), iArr, iArr2);
            this.f37814aX = c7695tq;
            this.f37889v.addView(c7695tq, layoutParams);
            contentRecord.m41610u(AbstractC7806cz.m48168c(contentRecord.m41476aa()));
            this.f37814aX.setScreenWidth(this.f37889v.getMeasuredWidth());
            this.f37814aX.setScreenHeight(this.f37889v.getMeasuredHeight());
            this.f37814aX.setAdContent(contentRecord);
        }
    }

    /* renamed from: a */
    private void m49251a(ILinkedSplashAd iLinkedSplashAd) {
        this.f37892y = this.f37889v.getLinkedVideoView();
        if (iLinkedSplashAd.getVideoInfo() != null) {
            this.f37892y.setVideoRatio(iLinkedSplashAd.getVideoInfo().getVideoRatio());
        }
    }

    /* renamed from: a */
    private void m49252a(LinkedSplashAd linkedSplashAd) throws Resources.NotFoundException {
        ContentRecord contentRecordM44490K;
        Integer numM49273d;
        if (this.f37799aI == null || linkedSplashAd == null || (contentRecordM44490K = linkedSplashAd.m44490K()) == null) {
            return;
        }
        int iM46475n = AbstractC7558os.m46475n(contentRecordM44490K.m41427W());
        int iM46481t = AbstractC7558os.m46481t(contentRecordM44490K.m41427W());
        AbstractC7185ho.m43820b("PPSLinkedView", "set splashpro mode:" + iM46475n);
        if (iM46475n == 0 || (numM49273d = m49273d(contentRecordM44490K)) == null) {
            this.f37799aI.setVisibility(8);
        } else if (numM49273d.intValue() == 0) {
            m49250a(contentRecordM44490K, iM46481t);
        } else {
            m49249a(contentRecordM44490K);
            m49259a(false, numM49273d.intValue(), contentRecordM44490K);
        }
        this.f37799aI.setMode(iM46475n);
    }

    /* renamed from: a */
    private void m49253a(LinkedSplashAd linkedSplashAd, int i10) {
        float fM44488I;
        int iM44489J;
        String str;
        String str2;
        if (linkedSplashAd != null) {
            String strM44486G = linkedSplashAd.m44486G();
            String strM44487H = linkedSplashAd.m44487H();
            fM44488I = linkedSplashAd.m44488I();
            iM44489J = linkedSplashAd.m44489J();
            setSkipBtnDelayTime(linkedSplashAd.m44490K());
            str = strM44486G;
            str2 = strM44487H;
        } else {
            fM44488I = 0.0f;
            iM44489J = 0;
            str = null;
            str2 = null;
        }
        C8152v c8152vM49246a = m49246a(str, i10, str2, false, fM44488I, iM44489J);
        this.f37771D = c8152vM49246a;
        c8152vM49246a.setId(C6849R.id.hiad_btn_skip);
        this.f37889v.addView(this.f37771D);
        this.f37771D.bringToFront();
        this.f37771D.setVisibility(4);
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.IPPSLinkedView
    /* renamed from: a */
    public void mo49291a(Integer num) {
        m49257a(Long.valueOf(System.currentTimeMillis() - this.f37878k.m45262e()), Integer.valueOf(this.f37878k.m45261d()), num, false);
    }

    @Override // com.huawei.openalliance.p169ad.views.AbstractC8105i
    /* renamed from: a */
    public void mo49292a(Integer num, boolean z10) {
        AbstractC7185ho.m43817a("PPSLinkedView", "reportSplashAdShowEvent. ");
        m49257a(Long.valueOf(System.currentTimeMillis() - this.f37783P), (Integer) 100, num, z10);
    }

    /* renamed from: a */
    public void m49257a(Long l10, Integer num, Integer num2, boolean z10) {
        AbstractC7185ho.m43817a("PPSLinkedView", "reportAdShowEvent. ");
        LinkedSplashAd linkedSplashAd = this.f37879l;
        if (linkedSplashAd == null) {
            return;
        }
        boolean zM47867a = C7780c.m47867a(linkedSplashAd.m44627d(), num2);
        if (!this.f37879l.m44790Y() || (zM47867a && !this.f37879l.m44619b())) {
            if (!this.f37875h.mo43401bb()) {
                this.f37879l.m44842h(true);
                this.f37883p.mo46133a(null, null, num2);
            } else if (z10 || l10.longValue() >= this.f37879l.getMinEffectiveShowTime()) {
                this.f37879l.m44842h(true);
                AbstractC7185ho.m43817a("PPSLinkedView", "report imp. ");
                this.f37883p.mo46133a(l10, num, num2);
            }
            if (zM47867a) {
                this.f37879l.m44612a(true);
            }
            this.f37871d.m47382d();
        }
    }

    /* renamed from: a */
    private void m49258a(List<View> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (View view : list) {
            if (view instanceof NativeVideoView) {
                ((NativeVideoView) view).setCoverClickListener(this.f37846bc);
            } else if (view != null) {
                view.setOnClickListener(this.f37846bc);
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.AbstractC8105i
    /* renamed from: a */
    public void mo49293a(boolean z10) {
        VideoInfo videoInfo;
        String str;
        AbstractC7185ho.m43820b("PPSLinkedView", "switchSound enableSound: " + z10);
        if (this.f37892y == null || this.f37872e.m47410k() == null) {
            return;
        }
        C7716uk c7716uk = this.f37872e;
        if (z10) {
            c7716uk.m47401d();
            this.f37772E.setSelected(true);
            videoInfo = this.f37882o;
            if (videoInfo != null) {
                str = "y";
                videoInfo.m44580e(str);
            }
        } else {
            c7716uk.m47399c();
            this.f37772E.setSelected(false);
            videoInfo = this.f37882o;
            if (videoInfo != null) {
                str = "n";
                videoInfo.m44580e(str);
            }
        }
        this.f37883p.mo46134a(!z10);
    }

    /* renamed from: a */
    private void m49259a(boolean z10, int i10, ContentRecord contentRecord) throws Resources.NotFoundException {
        PPSSplashSwipeClickView pPSSplashSwipeClickView;
        this.f37889v.setOnClickListener(null);
        InteractCfg interactCfgM41459aK = contentRecord.m41459aK();
        String strM47856a = C7780c.m47856a(getContext(), contentRecord, i10);
        if (1 == i10) {
            PPSSplashSwipeView pPSSplashSwipeView = this.f37800aJ;
            if (pPSSplashSwipeView == null) {
                return;
            }
            pPSSplashSwipeView.setVisibility(4);
            this.f37800aJ.m50326a(m49247a(interactCfgM41459aK), m49248a(interactCfgM41459aK, strM47856a));
            this.f37800aJ.setShowLogo(z10);
            this.f37800aJ.setVisibility(0);
            this.f37889v.setOnTouchListener(this.f37847bd);
            return;
        }
        if (2 == i10) {
            PPSSplashTwistView pPSSplashTwistView = this.f37801aK;
            if (pPSSplashTwistView == null) {
                return;
            }
            pPSSplashTwistView.setVisibility(4);
            this.f37801aK.m50326a(m49262b(interactCfgM41459aK), m49263b(interactCfgM41459aK, strM47856a));
            this.f37801aK.setShowLogo(z10);
            this.f37801aK.setVisibility(0);
            this.f37889v.setOnTouchListener(AbstractC8105i.f37767a);
            m49236L();
            m49237M();
            return;
        }
        if (3 != i10) {
            if (4 != i10 || (pPSSplashSwipeClickView = this.f37811aU) == null) {
                return;
            }
            pPSSplashSwipeClickView.setVisibility(4);
            this.f37811aU.m50326a(m49270c(interactCfgM41459aK), m49248a(interactCfgM41459aK, strM47856a));
            this.f37811aU.setShowLogo(z10);
            this.f37811aU.setVisibility(0);
            this.f37889v.setOnTouchListener(this.f37847bd);
            this.f37811aU.getClickAreaView().setOnTouchListener(this.f37848be);
            return;
        }
        PPSSplashTwistClickView pPSSplashTwistClickView = this.f37812aV;
        if (pPSSplashTwistClickView == null) {
            return;
        }
        pPSSplashTwistClickView.setVisibility(4);
        this.f37812aV.m50326a(m49274d(interactCfgM41459aK), m49263b(interactCfgM41459aK, strM47856a));
        this.f37812aV.setShowLogo(z10);
        this.f37812aV.setVisibility(0);
        this.f37889v.setOnTouchListener(AbstractC8105i.f37767a);
        this.f37812aV.getClickAreaView().setOnTouchListener(this.f37848be);
        m49236L();
        m49237M();
    }

    @Override // com.huawei.openalliance.p169ad.views.AbstractC8105i
    /* renamed from: a */
    public boolean mo49294a(MaterialClickInfo materialClickInfo) {
        PPSSplashProView pPSSplashProView = this.f37799aI;
        if (pPSSplashProView != null && materialClickInfo != null) {
            int mode = pPSSplashProView.getMode();
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43818a("PPSLinkedView", "splashpro mode:%d", Integer.valueOf(mode));
            }
            if (1 != mode && mode != 0) {
                Rect rect = new Rect();
                this.f37799aI.getHitRect(rect);
                boolean zContains = rect.contains(materialClickInfo.m44501a().intValue(), materialClickInfo.m44506b().intValue());
                AbstractC7185ho.m43820b("PPSLinkedView", "check result:" + zContains);
                return zContains;
            }
        }
        return true;
    }

    /* renamed from: a */
    private boolean m49260a(Long l10) {
        return C7124fh.m43316b(getContext()).mo43333a(l10);
    }
}
