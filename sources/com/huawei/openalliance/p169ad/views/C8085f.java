package com.huawei.openalliance.p169ad.views;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;

/* renamed from: com.huawei.openalliance.ad.views.f */
/* loaded from: classes2.dex */
public class C8085f extends RelativeLayout {

    /* renamed from: a */
    private Animation f37613a;

    /* renamed from: b */
    private Animation f37614b;

    /* renamed from: c */
    private Animation f37615c;

    /* renamed from: d */
    private Animation f37616d;

    /* renamed from: e */
    private ImageView f37617e;

    /* renamed from: f */
    private ImageView f37618f;

    public C8085f(Context context) throws Resources.NotFoundException {
        super(context);
        m50114a(context);
    }

    /* renamed from: b */
    private void m50117b(Context context) throws Resources.NotFoundException {
        this.f37613a = AnimationUtils.loadAnimation(context, C6849R.anim.hiad_masking_hand_zoom_in);
        this.f37614b = AnimationUtils.loadAnimation(context, C6849R.anim.hiad_masking_hand_zoom_out);
        this.f37613a.setDuration(400L);
        this.f37614b.setDuration(400L);
        this.f37613a.setAnimationListener(new Animation.AnimationListener() { // from class: com.huawei.openalliance.ad.views.f.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (C8085f.this.f37617e != null) {
                    C8085f.this.f37617e.startAnimation(C8085f.this.f37614b);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        this.f37614b.setAnimationListener(new Animation.AnimationListener() { // from class: com.huawei.openalliance.ad.views.f.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (C8085f.this.f37618f != null) {
                    C8085f.this.f37618f.startAnimation(C8085f.this.f37615c);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        this.f37615c = AnimationUtils.loadAnimation(context, C6849R.anim.haid_masking_arc_zoom_in);
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(context, C6849R.anim.haid_masking_fade_out);
        this.f37616d = animationLoadAnimation;
        animationLoadAnimation.setDuration(400L);
        this.f37615c.setDuration(400L);
        this.f37615c.setAnimationListener(new Animation.AnimationListener() { // from class: com.huawei.openalliance.ad.views.f.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (C8085f.this.f37618f != null) {
                    C8085f.this.f37618f.startAnimation(C8085f.this.f37616d);
                }
                if (C8085f.this.f37617e != null) {
                    C8085f.this.f37617e.startAnimation(C8085f.this.f37613a);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (C8085f.this.f37618f != null) {
                    C8085f.this.f37618f.setVisibility(0);
                }
            }
        });
        this.f37616d.setAnimationListener(new Animation.AnimationListener() { // from class: com.huawei.openalliance.ad.views.f.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (C8085f.this.f37618f != null) {
                    C8085f.this.f37618f.setVisibility(4);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
    }

    /* renamed from: a */
    public void m50122a() {
        m50115a(this.f37614b);
        m50115a(this.f37613a);
        m50115a(this.f37616d);
        m50115a(this.f37615c);
        setVisibility(8);
    }

    /* renamed from: a */
    private void m50114a(Context context) throws Resources.NotFoundException {
        AbstractC7185ho.m43820b("MaskingView", "init");
        View.inflate(context, C6849R.layout.pps_masking_view, this);
        this.f37617e = (ImageView) findViewById(C6849R.id.hiad_click_hand);
        this.f37618f = (ImageView) findViewById(C6849R.id.hiad_click_arc);
        m50117b(context);
        this.f37617e.startAnimation(this.f37614b);
    }

    /* renamed from: a */
    private void m50115a(Animation animation) {
        if (animation != null) {
            animation.cancel();
        }
    }
}
