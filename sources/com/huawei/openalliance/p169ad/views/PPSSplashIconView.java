package com.huawei.openalliance.p169ad.views;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.huawei.android.remotecontrol.p093ui.widget.TopAnimatorConfig;
import com.huawei.openalliance.p169ad.AbstractC7014dc;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6982bz;
import com.huawei.openalliance.p169ad.C7019dh;
import com.huawei.openalliance.p169ad.C7022dk;
import com.huawei.openalliance.p169ad.C7525nt;
import com.huawei.openalliance.p169ad.C7653sb;
import com.huawei.openalliance.p169ad.C7694tp;
import com.huawei.openalliance.p169ad.InterpolatorC7160gq;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.beans.metadata.MetaData;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.p169ad.inter.listeners.SplashIconListener;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.C7752az;

@OuterVisible
/* loaded from: classes2.dex */
public class PPSSplashIconView {

    /* renamed from: a */
    private ContentRecord f37083a;

    /* renamed from: b */
    private C8073ah f37084b;

    /* renamed from: c */
    private C8071af f37085c;

    /* renamed from: d */
    private C8072ag f37086d;

    /* renamed from: e */
    private CornerImageView f37087e;

    /* renamed from: f */
    private CornerImageView f37088f;

    /* renamed from: g */
    private CornerImageView f37089g;

    /* renamed from: h */
    private AutoScaleSizeRelativeLayout f37090h;

    /* renamed from: i */
    private WindowManager f37091i;

    /* renamed from: j */
    private SplashIconListener f37092j;

    /* renamed from: k */
    private C7525nt f37093k;

    /* renamed from: l */
    private CountDownTimer f37094l;

    /* renamed from: m */
    private Context f37095m;

    /* renamed from: n */
    private int f37096n;

    /* renamed from: o */
    private int f37097o;

    /* renamed from: p */
    private int f37098p;

    /* renamed from: q */
    private String f37099q;

    /* renamed from: r */
    private String f37100r;

    /* renamed from: s */
    private boolean f37101s;

    /* renamed from: u */
    private int f37103u;

    /* renamed from: v */
    private int f37104v;

    /* renamed from: w */
    private AnimatorSet f37105w;

    /* renamed from: x */
    private AnimatorSet f37106x;

    /* renamed from: z */
    private MaterialClickInfo f37108z;

    /* renamed from: t */
    private boolean f37102t = false;

    /* renamed from: y */
    private boolean f37107y = false;

    @OuterVisible
    public PPSSplashIconView(Activity activity, int i10, int i11) {
        this.f37101s = false;
        AbstractC7185ho.m43820b("PPSSplashIconView", "init");
        if (this.f37101s) {
            AbstractC7185ho.m43823c("PPSSplashIconView", "already init");
            return;
        }
        this.f37101s = true;
        if (AbstractC7014dc.m41888k() == null || AbstractC7014dc.m41888k().m41568i() == null) {
            AbstractC7185ho.m43823c("PPSSplashIconView", "ad is null");
            return;
        }
        ContentRecord contentRecordM41888k = AbstractC7014dc.m41888k();
        this.f37083a = contentRecordM41888k;
        MetaData metaDataM41568i = contentRecordM41888k.m41568i();
        if (metaDataM41568i == null || AbstractC7760bg.m47767a(metaDataM41568i.m40315g()) || metaDataM41568i.m40315g().get(0) == null) {
            AbstractC7185ho.m43823c("PPSSplashIconView", "Icon info is null");
            return;
        }
        Context applicationContext = activity.getApplicationContext();
        this.f37095m = applicationContext;
        this.f37093k = new C7525nt(applicationContext, this.f37083a, activity.getLocalClassName());
        String strM40180c = metaDataM41568i.m40315g().get(0).m40180c();
        this.f37100r = strM40180c;
        if (!TextUtils.isEmpty(strM40180c)) {
            m49622a(activity, i10, i11, metaDataM41568i);
        } else {
            AbstractC7185ho.m43823c("PPSSplashIconView", "Icon url is null");
            this.f37093k.m46209a(1);
        }
    }

    /* renamed from: e */
    private float m49631e() {
        float fM48326f;
        float fMo41169a = C6982bz.m41148a(this.f37095m).mo41169a(this.f37084b);
        int i10 = this.f37095m.getResources().getDisplayMetrics().heightPixels;
        Point point = new Point();
        this.f37091i.getDefaultDisplay().getRealSize(point);
        float fM48329g = (((float) point.y) - fMo41169a) - ((float) i10) > ((float) AbstractC7811dd.m48334j(this.f37095m)) ? AbstractC7811dd.m48329g(this.f37095m) : 0.0f;
        if (!C6982bz.m41148a(this.f37095m).mo41171a(this.f37095m) || C6982bz.m41148a(this.f37095m).mo41169a(this.f37084b) <= 0) {
            fM48326f = AbstractC7811dd.m48326f(this.f37095m) - AbstractC7741ao.m47583h(this.f37095m);
        } else {
            if (fM48329g == 0.0f) {
                return 0.0f;
            }
            fM48326f = C6982bz.m41148a(this.f37095m).mo41169a(this.f37084b);
        }
        return (fM48326f * 1.0f) / 2.0f;
    }

    /* renamed from: g */
    private void m49635g() {
        AbstractC7185ho.m43820b("PPSSplashIconView", "cancelDisplayCountTask");
        CountDownTimer countDownTimer = this.f37094l;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f37094l = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m49637h() {
        SplashIconListener splashIconListener = this.f37092j;
        if (splashIconListener != null) {
            splashIconListener.onIconDismiss(0);
        }
    }

    @OuterVisible
    public void destroy() {
        SplashIconListener splashIconListener;
        m49640i();
        if (this.f37085c == null || (splashIconListener = this.f37092j) == null || !this.f37107y) {
            return;
        }
        splashIconListener.onIconDismiss(3);
    }

    @OuterVisible
    public void setAdIconListener(SplashIconListener splashIconListener) {
        this.f37092j = splashIconListener;
    }

    @OuterVisible
    public void start() {
        boolean z10 = this.f37102t;
        if (z10 || !this.f37101s) {
            AbstractC7185ho.m43824c("PPSSplashIconView", "already start or not init, hasStart= %s", Boolean.valueOf(z10));
            m49637h();
            return;
        }
        this.f37102t = true;
        if (AbstractC7014dc.m41888k() == null || (AbstractC7014dc.m41886i() == null && AbstractC7014dc.m41887j() == null)) {
            AbstractC7185ho.m43823c("PPSSplashIconView", "not show icon");
            AbstractC7014dc.m41866a((Bitmap) null);
            AbstractC7014dc.m41867a((Drawable) null);
            m49637h();
            return;
        }
        AbstractC7014dc.m41880c(null);
        if (this.f37084b == null || this.f37087e == null) {
            AbstractC7185ho.m43823c("PPSSplashIconView", "not real init");
            m49637h();
            return;
        }
        if (AbstractC7014dc.m41886i() != null) {
            this.f37087e.setImageDrawable(AbstractC7014dc.m41886i());
            AbstractC7014dc.m41867a((Drawable) null);
        } else {
            this.f37087e.setImageBitmap(AbstractC7014dc.m41887j());
            AbstractC7014dc.m41866a((Bitmap) null);
        }
        if (this.f37099q == null && !TextUtils.isEmpty(this.f37100r)) {
            m49624a(this.f37100r);
            if (this.f37099q == null) {
                AbstractC7185ho.m43823c("PPSSplashIconView", "cachedPath is null");
                C7525nt c7525nt = this.f37093k;
                if (c7525nt != null) {
                    c7525nt.m46209a(2);
                }
                m49637h();
                return;
            }
        }
        AbstractC7185ho.m43820b("PPSSplashIconView", "start");
        C7752az.m47691a(this.f37095m, this.f37099q, new C7752az.a() { // from class: com.huawei.openalliance.ad.views.PPSSplashIconView.2
            @Override // com.huawei.openalliance.p169ad.utils.C7752az.a
            /* renamed from: a */
            public void mo30231a() {
                AbstractC7185ho.m43820b("PPSSplashIconView", "start - image load failed");
                AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSSplashIconView.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (PPSSplashIconView.this.f37093k != null) {
                            PPSSplashIconView.this.f37093k.m46209a(3);
                        }
                        PPSSplashIconView.this.m49640i();
                        PPSSplashIconView.this.m49637h();
                    }
                });
            }

            @Override // com.huawei.openalliance.p169ad.utils.C7752az.a
            /* renamed from: a */
            public void mo30232a(final Drawable drawable) {
                AbstractC7185ho.m43820b("PPSSplashIconView", "start - image load success");
                AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSSplashIconView.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (PPSSplashIconView.this.f37088f != null) {
                            PPSSplashIconView.this.f37088f.setImageDrawable(drawable);
                        }
                        if (PPSSplashIconView.this.f37089g != null) {
                            PPSSplashIconView.this.f37089g.setImageDrawable(drawable);
                        }
                        PPSSplashIconView.this.m49626b();
                        if (PPSSplashIconView.this.f37093k != null) {
                            PPSSplashIconView.this.f37093k.m46208a();
                        }
                    }
                });
            }
        }, null);
    }

    @OuterVisible
    public void updatePos(int i10, int i11) {
        if (!this.f37102t) {
            AbstractC7185ho.m43823c("PPSSplashIconView", "updatePos, not start");
            return;
        }
        C8071af c8071af = this.f37085c;
        if (c8071af == null || !c8071af.isAttachedToWindow()) {
            AbstractC7185ho.m43823c("PPSSplashIconView", "updatePos, not attach");
            return;
        }
        if (i11 <= 0 || i11 > this.f37103u) {
            i11 = this.f37104v;
        }
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.flags = 40;
        layoutParams.format = 1;
        layoutParams.gravity = i10 == 1 ? 8388659 : 8388661;
        layoutParams.x = AbstractC7741ao.m47535a(this.f37095m, 4.0f);
        layoutParams.y = AbstractC7741ao.m47535a(this.f37095m, i11 + 28);
        this.f37091i.updateViewLayout(this.f37085c, layoutParams);
        layoutParams.x = i10 == 1 ? AbstractC7741ao.m47535a(this.f37095m, 44.0f) : 0;
        layoutParams.y = AbstractC7741ao.m47535a(this.f37095m, i11);
        this.f37091i.updateViewLayout(this.f37086d, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m49626b() {
        C8071af c8071af;
        if (this.f37084b == null || (c8071af = this.f37085c) == null) {
            AbstractC7185ho.m43823c("PPSSplashIconView", "onIconLoaded, not init");
            return;
        }
        ViewTreeObserver viewTreeObserver = c8071af.getViewTreeObserver();
        if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
            C7525nt c7525nt = this.f37093k;
            if (c7525nt != null) {
                c7525nt.m46209a(4);
            }
            m49640i();
            m49637h();
            return;
        }
        viewTreeObserver.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.huawei.openalliance.ad.views.PPSSplashIconView.3
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (PPSSplashIconView.this.f37085c == null || PPSSplashIconView.this.f37084b == null) {
                    AbstractC7185ho.m43823c("PPSSplashIconView", "onPreDraw, View is null");
                    return true;
                }
                PPSSplashIconView.this.f37085c.getViewTreeObserver().removeOnPreDrawListener(this);
                AbstractC7185ho.m43820b("PPSSplashIconView", "onPreDraw: start anim");
                PPSSplashIconView.this.m49630d();
                return true;
            }
        });
        this.f37085c.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSSplashIconView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PPSSplashIconView.this.f37093k.m46212a(PPSSplashIconView.this.f37083a.m41460aL() != 0 ? Long.valueOf(System.currentTimeMillis() - PPSSplashIconView.this.f37083a.m41460aL()) : null, 100, 1);
                boolean zM46211a = PPSSplashIconView.this.f37093k.m46211a(PPSSplashIconView.this.f37085c.getContext(), PPSSplashIconView.this.f37108z);
                PPSSplashIconView.this.f37108z = null;
                AbstractC7185ho.m43821b("PPSSplashIconView", "onclick, result= %s", Boolean.valueOf(zM46211a));
                if (PPSSplashIconView.this.f37092j != null) {
                    PPSSplashIconView.this.f37092j.onIconClick();
                }
                if (zM46211a) {
                    AbstractC7817dj.m48364a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSSplashIconView.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PPSSplashIconView.this.m49640i();
                            if (PPSSplashIconView.this.f37092j != null) {
                                PPSSplashIconView.this.f37092j.onIconDismiss(4);
                            }
                        }
                    }, 200L);
                }
            }
        });
        this.f37085c.setOnTouchListener(new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSSplashIconView.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    PPSSplashIconView.this.f37108z = C7694tp.m47283a(view, motionEvent);
                }
                if (1 != motionEvent.getAction()) {
                    return false;
                }
                C7694tp.m47284a(view, motionEvent, null, PPSSplashIconView.this.f37108z);
                return false;
            }
        });
        this.f37086d.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSSplashIconView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AbstractC7185ho.m43820b("PPSSplashIconView", "click close");
                PPSSplashIconView.this.m49640i();
                if (PPSSplashIconView.this.f37092j != null) {
                    PPSSplashIconView.this.f37092j.onIconDismiss(1);
                }
            }
        });
        m49628c();
    }

    /* renamed from: c */
    private void m49628c() {
        try {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.width = -2;
            layoutParams.height = -2;
            layoutParams.flags = 134218760;
            layoutParams.format = 1;
            layoutParams.gravity = 8388615;
            this.f37091i.addView(this.f37084b, layoutParams);
            layoutParams.flags = 40;
            if (this.f37096n == 1) {
                layoutParams.gravity = 8388659;
            } else {
                layoutParams.gravity = 8388661;
            }
            layoutParams.x = AbstractC7741ao.m47535a(this.f37095m, 4.0f);
            layoutParams.y = AbstractC7741ao.m47535a(this.f37095m, this.f37097o + 28);
            this.f37091i.addView(this.f37085c, layoutParams);
            if (this.f37096n == 1) {
                layoutParams.x = AbstractC7741ao.m47535a(this.f37095m, 44.0f);
            } else {
                layoutParams.x = 0;
            }
            layoutParams.y = AbstractC7741ao.m47535a(this.f37095m, this.f37097o);
            this.f37091i.addView(this.f37086d, layoutParams);
            this.f37090h.setAlpha(0.0f);
            this.f37089g.setAlpha(0.0f);
            this.f37088f.setAlpha(0.0f);
            this.f37086d.setAlpha(0.0f);
            this.f37107y = true;
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("PPSSplashIconView", "add icon error: %s", th2.getClass().getSimpleName());
            this.f37093k.m46209a(5);
            m49640i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m49630d() {
        if (this.f37084b == null || this.f37085c == null || this.f37087e == null) {
            AbstractC7185ho.m43823c("PPSSplashIconView", "initAndStartAnimation, not init");
            return;
        }
        int width = this.f37089g.getWidth();
        int height = this.f37089g.getHeight();
        float pivotX = this.f37089g.getPivotX();
        float pivotY = this.f37089g.getPivotY();
        int[] iArr = new int[2];
        this.f37089g.getLocationOnScreen(iArr);
        float fM49631e = m49631e();
        AbstractC7185ho.m43821b("PPSSplashIconView", "destWidth=%s destHeight=%s destX=%s  destY=%s locationD= %s %s systemDiff = %s", Integer.valueOf(width), Integer.valueOf(height), Float.valueOf(pivotX), Float.valueOf(pivotY), Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]), Float.valueOf(fM49631e));
        AbstractC7185ho.m43821b("PPSSplashIconView", "S= %s %s, I=%s %s ", Float.valueOf(this.f37087e.getPivotX()), Float.valueOf(this.f37087e.getPivotY()), Float.valueOf(this.f37088f.getPivotX()), Float.valueOf(this.f37088f.getPivotY()));
        AbstractC7185ho.m43821b("PPSSplashIconView", "splash Width= %s Height=%s, splashIcon Width=%s Height=%s", Integer.valueOf(this.f37087e.getWidth()), Integer.valueOf(this.f37087e.getHeight()), Integer.valueOf(this.f37088f.getWidth()), Integer.valueOf(this.f37088f.getHeight()));
        if (this.f37087e.getHeight() == 0 || this.f37087e.getWidth() == 0 || this.f37088f.getWidth() == 0 || this.f37088f.getHeight() == 0) {
            m49640i();
            m49637h();
            return;
        }
        CornerImageView cornerImageView = this.f37087e;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(cornerImageView, "translationX", 0.0f, (iArr[0] + pivotX) - cornerImageView.getPivotX());
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f37087e, "translationY", 0.0f, ((AbstractC7741ao.m47535a(this.f37095m, this.f37097o + 32) + pivotY) - this.f37087e.getPivotY()) - fM49631e);
        float f10 = width * 1.0f;
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.f37087e, TopAnimatorConfig.AnimatorType.SCALE_X, 1.0f, f10 / (r15.getWidth() * 1.0f));
        float f11 = height * 1.0f;
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.f37087e, TopAnimatorConfig.AnimatorType.SCALE_Y, 1.0f, f11 / (r15.getHeight() * 1.0f));
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.f37087e, TopAnimatorConfig.AnimatorType.ALPHA, 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this.f37088f, "translationX", 0.0f, (iArr[0] + pivotX) - this.f37087e.getPivotX());
        ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(this.f37088f, "translationY", 0.0f, ((AbstractC7741ao.m47535a(this.f37095m, this.f37097o + 32) + pivotY) - this.f37087e.getPivotY()) - fM49631e);
        float width2 = f10 / (this.f37088f.getWidth() * 1.0f);
        float height2 = f11 / (this.f37088f.getHeight() * 1.0f);
        AbstractC7185ho.m43821b("PPSSplashIconView", "destScaleX= %s  destScaleY = %s", Float.valueOf(width2), Float.valueOf(height2));
        ObjectAnimator objectAnimatorOfFloat8 = ObjectAnimator.ofFloat(this.f37088f, TopAnimatorConfig.AnimatorType.SCALE_X, 1.0f, width2);
        ObjectAnimator objectAnimatorOfFloat9 = ObjectAnimator.ofFloat(this.f37088f, TopAnimatorConfig.AnimatorType.SCALE_Y, 1.0f, height2);
        ObjectAnimator objectAnimatorOfFloat10 = ObjectAnimator.ofFloat(this.f37088f, TopAnimatorConfig.AnimatorType.ALPHA, 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat11 = ObjectAnimator.ofFloat(this.f37090h, TopAnimatorConfig.AnimatorType.ALPHA, 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat12 = ObjectAnimator.ofFloat(this.f37086d, TopAnimatorConfig.AnimatorType.ALPHA, 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f37106x = animatorSet;
        animatorSet.setDuration(300L);
        this.f37106x.setInterpolator(new InterpolatorC7160gq(0.2f, 0.0f, 0.2f, 1.0f));
        this.f37106x.playTogether(objectAnimatorOfFloat11, objectAnimatorOfFloat12);
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.f37105w = animatorSet2;
        animatorSet2.setDuration(500L);
        this.f37105w.setInterpolator(new InterpolatorC7160gq(0.2f, 0.0f, 0.2f, 1.0f));
        this.f37105w.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3, objectAnimatorOfFloat4, objectAnimatorOfFloat6, objectAnimatorOfFloat7, objectAnimatorOfFloat8, objectAnimatorOfFloat9, objectAnimatorOfFloat5, objectAnimatorOfFloat10);
        this.f37105w.addListener(new Animator.AnimatorListener() { // from class: com.huawei.openalliance.ad.views.PPSSplashIconView.7
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AbstractC7185ho.m43820b("PPSSplashIconView", "onAnimationEnd");
                try {
                    PPSSplashIconView.this.f37089g.setAlpha(1.0f);
                    AbstractC7817dj.m48364a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSSplashIconView.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PPSSplashIconView.this.f37084b != null) {
                                if (PPSSplashIconView.this.f37084b.isAttachedToWindow()) {
                                    PPSSplashIconView.this.f37091i.removeViewImmediate(PPSSplashIconView.this.f37084b);
                                }
                                if (PPSSplashIconView.this.f37106x != null) {
                                    PPSSplashIconView.this.f37106x.start();
                                }
                            }
                        }
                    }, 20L);
                    PPSSplashIconView.this.m49634f();
                } catch (Throwable th2) {
                    AbstractC7185ho.m43821b("PPSSplashIconView", "onAnimationEnd err: %s", th2.getClass().getSimpleName());
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        this.f37105w.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m49634f() {
        AbstractC7185ho.m43821b("PPSSplashIconView", "startDisplayCountTask, duration: %s", Integer.valueOf(this.f37098p));
        CountDownTimer countDownTimer = this.f37094l;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        CountDownTimer countDownTimer2 = new CountDownTimer(this.f37098p, 1000L) { // from class: com.huawei.openalliance.ad.views.PPSSplashIconView.8
            @Override // android.os.CountDownTimer
            public void onFinish() {
                AbstractC7185ho.m43820b("PPSSplashIconView", "onFinish");
                PPSSplashIconView.this.m49640i();
                if (PPSSplashIconView.this.f37092j != null) {
                    PPSSplashIconView.this.f37092j.onIconDismiss(2);
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j10) {
            }
        };
        this.f37094l = countDownTimer2;
        countDownTimer2.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m49640i() {
        m49635g();
        this.f37087e = null;
        m49623a(this.f37084b);
        m49623a(this.f37085c);
        m49623a(this.f37086d);
        AnimatorSet animatorSet = this.f37106x;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.f37106x.cancel();
        }
        AnimatorSet animatorSet2 = this.f37105w;
        if (animatorSet2 == null || !animatorSet2.isRunning()) {
            return;
        }
        this.f37105w.cancel();
    }

    /* renamed from: a */
    private void m49621a() {
        if (this.f37099q != null) {
            AbstractC7834m.m48484d(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSSplashIconView.1
                @Override // java.lang.Runnable
                public void run() {
                    C7653sb c7653sb = new C7653sb();
                    c7653sb.m47187d(PPSSplashIconView.this.f37099q);
                    C7752az.m47689a(PPSSplashIconView.this.f37095m, c7653sb, (C7752az.a) null);
                }
            });
        }
    }

    /* renamed from: a */
    private void m49622a(Activity activity, int i10, int i11, MetaData metaData) {
        C7525nt c7525nt;
        m49624a(this.f37100r);
        this.f37098p = (metaData.m40270G() == null || metaData.m40270G().intValue() <= 0) ? 10000 : metaData.m40270G().intValue() * 1000;
        this.f37096n = i10;
        activity.getWindowManager().getDefaultDisplay().getRealMetrics(new DisplayMetrics());
        this.f37103u = AbstractC7741ao.m47557b(this.f37095m, r3.heightPixels) - 92;
        int iM47557b = (int) ((AbstractC7741ao.m47557b(this.f37095m, r3.heightPixels) * 0.85f) - 92.0f);
        this.f37104v = iM47557b;
        if (i11 <= 0 || i11 > this.f37103u) {
            i11 = iM47557b;
        }
        this.f37097o = i11;
        m49621a();
        this.f37084b = new C8073ah(activity);
        C8071af c8071af = new C8071af(activity);
        this.f37085c = c8071af;
        this.f37089g = c8071af.getIcon();
        this.f37090h = this.f37085c.getRoundLayout();
        this.f37087e = this.f37084b.getSplash();
        this.f37086d = new C8072ag(activity);
        this.f37088f = this.f37084b.getIcon();
        this.f37091i = (WindowManager) activity.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR);
        C8071af c8071af2 = this.f37085c;
        if (c8071af2 == null || (c7525nt = this.f37093k) == null) {
            return;
        }
        c7525nt.m46210a(c8071af2);
    }

    /* renamed from: a */
    private void m49623a(View view) {
        if (view == null || !view.isAttachedToWindow()) {
            return;
        }
        this.f37091i.removeViewImmediate(view);
    }

    /* renamed from: a */
    private void m49624a(String str) {
        if (str.startsWith("http")) {
            C7022dk c7022dkM41937a = C7019dh.m41937a(this.f37095m, Constants.NORMAL_CACHE);
            this.f37099q = c7022dkM41937a.m41968c(c7022dkM41937a.m41970e(str));
        }
    }
}
