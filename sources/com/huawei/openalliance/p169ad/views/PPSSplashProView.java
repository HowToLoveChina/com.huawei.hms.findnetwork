package com.huawei.openalliance.p169ad.views;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.remotecontrol.p093ui.widget.TopAnimatorConfig;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.InterfaceC7146gc;
import com.huawei.openalliance.p169ad.InterpolatorC7160gq;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;

/* loaded from: classes2.dex */
public class PPSSplashProView extends RelativeLayout {

    /* renamed from: a */
    private View f37122a;

    /* renamed from: b */
    private ScanningRelativeLayout f37123b;

    /* renamed from: c */
    private int f37124c;

    /* renamed from: d */
    private TextView f37125d;

    /* renamed from: e */
    private ImageView f37126e;

    /* renamed from: f */
    private boolean f37127f;

    /* renamed from: g */
    private int f37128g;

    /* renamed from: h */
    private RoundLinearLayout f37129h;

    /* renamed from: i */
    private AnimatorSet f37130i;

    /* renamed from: j */
    private AnimatorSet f37131j;

    /* renamed from: k */
    private AnimatorSet f37132k;

    /* renamed from: l */
    private AnimatorSet f37133l;

    /* renamed from: m */
    private AnimatorSet f37134m;

    /* renamed from: n */
    private AnimatorSet f37135n;

    public PPSSplashProView(Context context) {
        super(context);
        this.f37124c = 2;
        this.f37128g = 1;
        m49650a(context);
    }

    /* renamed from: c */
    private void m49654c() {
        AbstractC7185ho.m43820b("PPSSplashProView", "showLogo:" + this.f37127f + ",orientation:" + this.f37128g);
        m49653b();
    }

    /* renamed from: a */
    public void m49665a() {
        ScanningRelativeLayout scanningRelativeLayout = this.f37123b;
        if (scanningRelativeLayout != null) {
            scanningRelativeLayout.mo49783a();
        }
        AnimatorSet animatorSet = this.f37131j;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.f37131j = null;
        }
        AnimatorSet animatorSet2 = this.f37130i;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
            this.f37130i = null;
        }
        AnimatorSet animatorSet3 = this.f37132k;
        if (animatorSet3 != null) {
            animatorSet3.cancel();
            this.f37132k = null;
        }
        AnimatorSet animatorSet4 = this.f37133l;
        if (animatorSet4 != null) {
            animatorSet4.cancel();
            this.f37133l = null;
        }
        AnimatorSet animatorSet5 = this.f37134m;
        if (animatorSet5 != null) {
            animatorSet5.cancel();
            this.f37134m = null;
        }
        AnimatorSet animatorSet6 = this.f37135n;
        if (animatorSet6 != null) {
            animatorSet6.cancel();
            this.f37135n = null;
        }
    }

    public int getMode() {
        return this.f37124c;
    }

    public void setDesc(String str) {
        if (this.f37125d != null) {
            boolean zIsEmpty = TextUtils.isEmpty(str);
            TextView textView = this.f37125d;
            if (zIsEmpty) {
                textView.setText(C6849R.string.hiad_splash_pro_desc);
            } else {
                textView.setText(str);
            }
        }
    }

    public void setMode(int i10) {
        this.f37124c = i10;
    }

    public void setOrientation(int i10) {
        this.f37128g = i10;
    }

    public PPSSplashProView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f37124c = 2;
        this.f37128g = 1;
        m49650a(context);
    }

    /* renamed from: a */
    private void m49650a(Context context) {
        String str;
        AbstractC7185ho.m43820b("PPSSplashProView", "init");
        try {
            View viewInflate = View.inflate(context, C6849R.layout.hiad_layout_splash_pro, this);
            this.f37122a = viewInflate;
            this.f37123b = (ScanningRelativeLayout) viewInflate.findViewById(C6849R.id.hiad_pro_layout);
            this.f37129h = (RoundLinearLayout) this.f37122a.findViewById(C6849R.id.hiad_pro_desc_layout);
            this.f37123b.setBackground(getResources().getDrawable(C6849R.drawable.hiad_splash_pro_bg));
            this.f37125d = (TextView) this.f37122a.findViewById(C6849R.id.hiad_pro_desc);
            this.f37126e = (ImageView) this.f37122a.findViewById(C6849R.id.hiad_pro_arrow);
        } catch (RuntimeException unused) {
            str = "init RuntimeException";
            AbstractC7185ho.m43823c("PPSSplashProView", str);
        } catch (Exception unused2) {
            str = "init error";
            AbstractC7185ho.m43823c("PPSSplashProView", str);
        }
    }

    /* renamed from: b */
    private void m49653b() {
        TextView textView;
        float fMo43037O;
        Context applicationContext = getContext().getApplicationContext();
        InterfaceC7146gc interfaceC7146gcM43316b = C7124fh.m43316b(applicationContext);
        int iM47535a = AbstractC7741ao.m47535a(applicationContext, interfaceC7146gcM43316b.mo43036N());
        int iMo43038P = interfaceC7146gcM43316b.mo43038P();
        int iM47535a2 = AbstractC7741ao.m47535a(applicationContext, interfaceC7146gcM43316b.mo43037O());
        final int iM47535a3 = AbstractC7741ao.m47535a(applicationContext, interfaceC7146gcM43316b.mo43049a(applicationContext));
        this.f37123b.setRadius(iMo43038P);
        this.f37129h.setRectCornerRadius(AbstractC7741ao.m47535a(applicationContext, iMo43038P));
        this.f37123b.setMinimumHeight(iM47535a);
        int i10 = 2;
        if (AbstractC7741ao.m47592n(getContext())) {
            textView = this.f37125d;
            fMo43037O = interfaceC7146gcM43316b.mo43037O() * 2;
            i10 = 1;
        } else {
            textView = this.f37125d;
            fMo43037O = interfaceC7146gcM43316b.mo43037O();
        }
        textView.setTextSize(i10, fMo43037O);
        this.f37125d.setMinimumHeight(iM47535a);
        ViewGroup.LayoutParams layoutParams = this.f37126e.getLayoutParams();
        layoutParams.height = iM47535a2;
        layoutParams.width = iM47535a2;
        this.f37126e.setLayoutParams(layoutParams);
        this.f37122a.post(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSSplashProView.1
            @Override // java.lang.Runnable
            public void run() {
                ViewGroup.LayoutParams layoutParams2 = PPSSplashProView.this.getLayoutParams();
                if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) layoutParams2;
                    layoutParams3.bottomMargin = (PPSSplashProView.this.f37127f || PPSSplashProView.this.f37128g != 1) ? iM47535a3 : iM47535a3 + AbstractC7811dd.m48326f(PPSSplashProView.this.getContext());
                    PPSSplashProView.this.setLayoutParams(layoutParams3);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m49657d() {
        AbstractC7185ho.m43820b("PPSSplashProView", "startAnimators");
        try {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f37129h, TopAnimatorConfig.AnimatorType.ALPHA, 0.0f, 1.0f);
            objectAnimatorOfFloat.setDuration(300L);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f37123b, TopAnimatorConfig.AnimatorType.SCALE_X, 0.85f, 1.0f);
            ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.f37123b, TopAnimatorConfig.AnimatorType.SCALE_Y, 0.85f, 1.0f);
            objectAnimatorOfFloat2.setDuration(300L);
            objectAnimatorOfFloat3.setDuration(300L);
            AnimatorSet animatorSet = new AnimatorSet();
            this.f37130i = animatorSet;
            animatorSet.playTogether(objectAnimatorOfFloat2, objectAnimatorOfFloat3, objectAnimatorOfFloat);
            this.f37130i.setInterpolator(new InterpolatorC7160gq(0.2f, 0.0f, 0.2f, 1.0f));
            this.f37130i.addListener(new Animator.AnimatorListener() { // from class: com.huawei.openalliance.ad.views.PPSSplashProView.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    AbstractC7185ho.m43820b("PPSSplashProView", "upAndAlphaSet onAnimationEnd");
                    try {
                        PPSSplashProView.this.f37123b.m49915d();
                        if (PPSSplashProView.this.f37132k == null || PPSSplashProView.this.f37133l == null) {
                            return;
                        }
                        PPSSplashProView.this.f37132k.start();
                        PPSSplashProView.this.f37133l.start();
                    } catch (Throwable th2) {
                        AbstractC7185ho.m43824c("PPSSplashProView", "scale err: %s", th2.getClass().getSimpleName());
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    try {
                        PPSSplashProView.this.f37123b.m49914c();
                    } catch (Throwable th2) {
                        AbstractC7185ho.m43824c("PPSSplashProView", "prepare err: %s", th2.getClass().getSimpleName());
                    }
                }
            });
            ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.f37123b, TopAnimatorConfig.AnimatorType.SCALE_X, 1.0f, 0.85f);
            ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.f37123b, TopAnimatorConfig.AnimatorType.SCALE_Y, 1.0f, 0.85f);
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.f37131j = animatorSet2;
            animatorSet2.setDuration(0L);
            this.f37131j.setInterpolator(new InterpolatorC7160gq(0.2f, 0.0f, 0.2f, 1.0f));
            this.f37131j.playTogether(objectAnimatorOfFloat4, objectAnimatorOfFloat5);
            this.f37131j.addListener(new Animator.AnimatorListener() { // from class: com.huawei.openalliance.ad.views.PPSSplashProView.4
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    AbstractC7185ho.m43820b("PPSSplashProView", "scaleAnimationDown onAnimationEnd");
                    try {
                        PPSSplashProView.this.setVisibility(0);
                        if (PPSSplashProView.this.f37130i != null) {
                            PPSSplashProView.this.f37130i.start();
                        }
                    } catch (Throwable th2) {
                        AbstractC7185ho.m43824c("PPSSplashProView", "up and alpha err: %s", th2.getClass().getSimpleName());
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }
            });
            this.f37126e.setVisibility(4);
            m49659e();
            this.f37131j.start();
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("PPSSplashProView", "anim error: %s", th2.getClass().getSimpleName());
            RoundLinearLayout roundLinearLayout = this.f37129h;
            if (roundLinearLayout != null) {
                roundLinearLayout.setBackground(getResources().getDrawable(C6849R.drawable.hiad_splash_pro_bg_scan));
            }
            setVisibility(0);
        }
    }

    /* renamed from: e */
    private void m49659e() {
        this.f37132k = new AnimatorSet();
        this.f37133l = new AnimatorSet();
        this.f37134m = new AnimatorSet();
        this.f37135n = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f37126e, TopAnimatorConfig.AnimatorType.SCALE_X, 1.0f, 1.225f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f37126e, TopAnimatorConfig.AnimatorType.SCALE_Y, 1.0f, 1.225f);
        objectAnimatorOfFloat.setDuration(350L);
        objectAnimatorOfFloat2.setDuration(350L);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.f37126e, TopAnimatorConfig.AnimatorType.SCALE_X, 1.225f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.f37126e, TopAnimatorConfig.AnimatorType.SCALE_Y, 1.225f, 1.0f);
        objectAnimatorOfFloat3.setDuration(500L);
        objectAnimatorOfFloat4.setDuration(500L);
        this.f37134m.playSequentially(objectAnimatorOfFloat, objectAnimatorOfFloat3);
        this.f37135n.playSequentially(objectAnimatorOfFloat2, objectAnimatorOfFloat4);
        this.f37134m.setInterpolator(new InterpolatorC7160gq(0.2f, 0.0f, 0.2f, 1.0f));
        this.f37135n.setInterpolator(new InterpolatorC7160gq(0.2f, 0.0f, 0.2f, 1.0f));
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.f37126e, TopAnimatorConfig.AnimatorType.SCALE_X, 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this.f37126e, TopAnimatorConfig.AnimatorType.SCALE_Y, 1.0f, 0.0f);
        objectAnimatorOfFloat5.setDuration(0L);
        objectAnimatorOfFloat6.setDuration(0L);
        objectAnimatorOfFloat5.addListener(new Animator.AnimatorListener() { // from class: com.huawei.openalliance.ad.views.PPSSplashProView.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                try {
                    PPSSplashProView.this.f37126e.setVisibility(0);
                } catch (Throwable th2) {
                    AbstractC7185ho.m43824c("PPSSplashProView", "arrowImage set visible err: %s", th2.getClass().getSimpleName());
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(this.f37126e, TopAnimatorConfig.AnimatorType.SCALE_X, 0.0f, 1.225f);
        ObjectAnimator objectAnimatorOfFloat8 = ObjectAnimator.ofFloat(this.f37126e, TopAnimatorConfig.AnimatorType.SCALE_Y, 0.0f, 1.225f);
        objectAnimatorOfFloat7.setDuration(400L);
        objectAnimatorOfFloat8.setDuration(400L);
        ObjectAnimator objectAnimatorOfFloat9 = ObjectAnimator.ofFloat(this.f37126e, TopAnimatorConfig.AnimatorType.SCALE_X, 1.225f, 0.989f);
        ObjectAnimator objectAnimatorOfFloat10 = ObjectAnimator.ofFloat(this.f37126e, TopAnimatorConfig.AnimatorType.SCALE_Y, 1.225f, 0.989f);
        objectAnimatorOfFloat9.setDuration(500L);
        objectAnimatorOfFloat10.setDuration(500L);
        ObjectAnimator objectAnimatorOfFloat11 = ObjectAnimator.ofFloat(this.f37126e, TopAnimatorConfig.AnimatorType.SCALE_X, 0.989f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat12 = ObjectAnimator.ofFloat(this.f37126e, TopAnimatorConfig.AnimatorType.SCALE_Y, 0.989f, 1.0f);
        objectAnimatorOfFloat11.setDuration(350L);
        objectAnimatorOfFloat12.setDuration(350L);
        this.f37132k.playSequentially(objectAnimatorOfFloat5, objectAnimatorOfFloat7, objectAnimatorOfFloat9, objectAnimatorOfFloat11);
        this.f37133l.playSequentially(objectAnimatorOfFloat6, objectAnimatorOfFloat8, objectAnimatorOfFloat10, objectAnimatorOfFloat12);
        this.f37132k.setInterpolator(new InterpolatorC7160gq(0.2f, 0.0f, 0.2f, 1.0f));
        this.f37133l.setInterpolator(new InterpolatorC7160gq(0.2f, 0.0f, 0.2f, 1.0f));
        this.f37132k.addListener(new Animator.AnimatorListener() { // from class: com.huawei.openalliance.ad.views.PPSSplashProView.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AbstractC7817dj.m48364a(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSSplashProView.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (PPSSplashProView.this.f37134m == null || PPSSplashProView.this.f37135n == null) {
                            return;
                        }
                        PPSSplashProView.this.f37134m.start();
                        PPSSplashProView.this.f37135n.start();
                    }
                }, 450L);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
    }

    public PPSSplashProView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f37124c = 2;
        this.f37128g = 1;
        m49650a(context);
    }

    /* renamed from: a */
    public void m49666a(boolean z10, int i10) {
        this.f37127f = z10;
        if (this.f37123b != null && i10 == 0) {
            RoundLinearLayout roundLinearLayout = this.f37129h;
            if (roundLinearLayout != null) {
                roundLinearLayout.setBackground(getResources().getDrawable(C6849R.drawable.hiad_splash_pro_bg_scan));
                this.f37129h.setAlpha(0.0f);
            }
            this.f37123b.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.huawei.openalliance.ad.views.PPSSplashProView.2
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
                    if (i13 - i11 <= 0 || i14 - i12 <= 0 || i15 != 0 || i17 != 0) {
                        return;
                    }
                    PPSSplashProView.this.m49657d();
                }
            });
        }
        m49654c();
    }
}
