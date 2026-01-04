package com.huawei.android.hicloud.p088ui.views;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.views.CircleProgressView;
import com.huawei.android.p073ds.R$dimen;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import sk.C12809f;

/* loaded from: classes3.dex */
public class BackUpAnimatorView extends LinearLayout {

    /* renamed from: a */
    public CircleProgressView f19305a;

    /* renamed from: b */
    public TextView f19306b;

    /* renamed from: c */
    public View f19307c;

    /* renamed from: d */
    public LinearLayout f19308d;

    /* renamed from: e */
    public CheckMarkView f19309e;

    /* renamed from: f */
    public int f19310f;

    /* renamed from: g */
    public boolean f19311g;

    /* renamed from: com.huawei.android.hicloud.ui.views.BackUpAnimatorView$a */
    public class C4281a implements CircleProgressView.CircleProgressListener {
        public C4281a() {
        }

        @Override // com.huawei.android.hicloud.ui.views.CircleProgressView.CircleProgressListener
        public void onSuccess() {
            BackUpAnimatorView.this.m25643g();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.views.BackUpAnimatorView$b */
    public class AnimationAnimationListenerC4282b implements Animation.AnimationListener {
        public AnimationAnimationListenerC4282b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            BackUpAnimatorView.this.m25644h();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.views.BackUpAnimatorView$c */
    public class AnimationAnimationListenerC4283c implements Animation.AnimationListener {
        public AnimationAnimationListenerC4283c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) throws Resources.NotFoundException {
            if (BackUpAnimatorView.this.f19311g) {
                BackUpAnimatorView.this.m25642f();
                BackUpAnimatorView.this.setProgress(0);
            } else {
                BackUpAnimatorView.this.f19309e.setVisibility(0);
                BackUpAnimatorView.this.f19309e.m25693h();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public BackUpAnimatorView(Context context) {
        this(context, null);
    }

    /* renamed from: e */
    public final void m25641e() {
        View viewInflate = View.inflate(getContext(), R$layout.back_up_animator_layout, this);
        this.f19305a = (CircleProgressView) C12809f.m76831d(viewInflate, R$id.bc_circle_progress_view);
        this.f19306b = (TextView) C12809f.m76831d(viewInflate, R$id.bc_text_progress);
        this.f19307c = C12809f.m76831d(viewInflate, R$id.bc_progress_success_bg);
        this.f19308d = (LinearLayout) C12809f.m76831d(viewInflate, R$id.bc_progress_content);
        this.f19309e = (CheckMarkView) C12809f.m76831d(viewInflate, R$id.bc_check_mark_view);
        this.f19305a.setProgressListener(new C4281a());
    }

    /* renamed from: f */
    public void m25642f() {
        Log.i("TopAnimatorView", "resetView: ");
        try {
            this.f19311g = true;
            this.f19310f = 0;
            this.f19306b.setText("");
            this.f19308d.setVisibility(0);
            this.f19307c.setVisibility(8);
            this.f19307c.clearAnimation();
            this.f19308d.clearAnimation();
            this.f19309e.setVisibility(8);
            this.f19309e.m25689d();
            this.f19305a.m25695b();
        } catch (Exception e10) {
            Log.e("TopAnimatorView", "resetView exception: " + e10.toString());
        }
    }

    /* renamed from: g */
    public final void m25643g() {
        this.f19307c.setVisibility(0);
        this.f19308d.setVisibility(8);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(400L);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setAnimationListener(new AnimationAnimationListenerC4282b());
        this.f19307c.startAnimation(scaleAnimation);
    }

    public int getProcess() {
        return this.f19310f;
    }

    /* renamed from: h */
    public final void m25644h() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(400L);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setAnimationListener(new AnimationAnimationListenerC4283c());
        this.f19308d.startAnimation(scaleAnimation);
    }

    public void setProgress(int i10) throws Resources.NotFoundException {
        if (i10 > 0 && this.f19311g) {
            this.f19311g = false;
        }
        if (i10 < this.f19310f) {
            return;
        }
        this.f19310f = i10;
        this.f19305a.setProgress(i10);
        String strM16144h = C2783d.m16144h(i10);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.backup_percent_12);
        SpannableString spannableString = new SpannableString(strM16144h);
        spannableString.setSpan(new AbsoluteSizeSpan(dimensionPixelSize, false), spannableString.length() - 1, spannableString.length(), 33);
        this.f19306b.setText(spannableString);
    }

    public BackUpAnimatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BackUpAnimatorView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f19311g = false;
        m25641e();
    }
}
