package com.huawei.android.hicloud.p088ui.views;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.AnimatedImageDrawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.util.Iterator;
import p514o9.C11839m;
import p514o9.C11842p;
import sk.C12809f;

/* loaded from: classes3.dex */
public class CampaignEntryFloatView extends FrameLayout {

    /* renamed from: a */
    public boolean f19360a;

    /* renamed from: b */
    public float f19361b;

    /* renamed from: c */
    public float f19362c;

    /* renamed from: d */
    public int f19363d;

    /* renamed from: e */
    public int f19364e;

    /* renamed from: f */
    public int f19365f;

    /* renamed from: g */
    public int f19366g;

    /* renamed from: h */
    public float f19367h;

    /* renamed from: i */
    public float f19368i;

    /* renamed from: j */
    public WindowManager f19369j;

    /* renamed from: k */
    public WindowManager.LayoutParams f19370k;

    /* renamed from: l */
    public ImageView f19371l;

    /* renamed from: m */
    public ImageView f19372m;

    /* renamed from: n */
    public int f19373n;

    public CampaignEntryFloatView(Context context) {
        super(context);
        mo25681h(context);
    }

    /* renamed from: c */
    private void m25675c(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (this.f19369j == null) {
            this.f19369j = (WindowManager) context.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR);
        }
        this.f19369j.getDefaultDisplay().getMetrics(displayMetrics);
        this.f19367h = displayMetrics.widthPixels;
        this.f19368i = displayMetrics.heightPixels;
        this.f19365f = (int) C11842p.m70844o(context, 74);
        this.f19366g = (int) C11842p.m70844o(context, 79);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f19370k = layoutParams;
        layoutParams.gravity = 8388659;
        layoutParams.flags = 8;
        layoutParams.type = 2;
        layoutParams.format = 1;
        int i10 = this.f19365f;
        layoutParams.width = i10;
        int i11 = this.f19366g;
        layoutParams.height = i11;
        layoutParams.x = (int) (this.f19367h - i10);
        layoutParams.y = ((int) (this.f19368i - i11)) / 2;
    }

    /* renamed from: b */
    public final void m25676b(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (this.f19369j == null) {
            this.f19369j = (WindowManager) context.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR);
        }
        this.f19369j.getDefaultDisplay().getMetrics(displayMetrics);
        int i10 = displayMetrics.widthPixels;
        int i11 = displayMetrics.heightPixels;
        WindowManager.LayoutParams layoutParams = this.f19370k;
        layoutParams.x = layoutParams.x == 0 ? 0 : i10 - layoutParams.width;
        layoutParams.y = (int) (((layoutParams.y * 1.0d) / this.f19368i) * i11);
        this.f19368i = i11;
        this.f19367h = i10;
    }

    /* renamed from: d */
    public void m25677d() {
        try {
            this.f19369j.removeViewImmediate(this);
        } catch (Exception e10) {
            C11839m.m70686d("CampaignEntryFloatView", "destroy Exception: " + e10.getMessage());
        }
    }

    /* renamed from: e */
    public final void m25678e() {
        ImageView imageView = this.f19372m;
        if (imageView == null || !(imageView.getDrawable() instanceof AnimatedImageDrawable)) {
            return;
        }
        ((AnimatedImageDrawable) this.f19372m.getDrawable()).stop();
    }

    /* renamed from: f */
    public void m25679f() {
        ImageView imageView = this.f19372m;
        if (imageView == null || !(imageView.getDrawable() instanceof AnimatedImageDrawable)) {
            return;
        }
        ((AnimatedImageDrawable) this.f19372m.getDrawable()).start();
    }

    /* renamed from: g */
    public final View m25680g(View view, int i10, int i11) {
        Iterator<View> it = view.getTouchables().iterator();
        View viewM25680g = null;
        while (it.hasNext()) {
            View next = it.next();
            if (next instanceof ViewGroup) {
                viewM25680g = m25680g(next, i10, i11);
            } else if (m25682i(next, i10, i11)) {
                return next;
            }
        }
        return viewM25680g;
    }

    public ImageView getCampaignClose() {
        return this.f19371l;
    }

    public ImageView getCampaignImg() {
        return this.f19372m;
    }

    /* renamed from: h */
    public void mo25681h(Context context) {
        setVisibility(8);
        LayoutInflater.from(context).inflate(R$layout.campaign_float_layout, this);
        this.f19371l = (ImageView) C12809f.m76831d(this, R$id.campaign_entry_close);
        this.f19372m = (ImageView) C12809f.m76831d(this, R$id.campaign_entry_img);
        try {
            m25675c(context);
            this.f19369j.addView(this, this.f19370k);
        } catch (Exception e10) {
            C11839m.m70687e("CampaignEntryFloatView", "init Exception: " + e10.getMessage());
        }
    }

    /* renamed from: i */
    public final boolean m25682i(View view, int i10, int i11) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i12 = iArr[0];
        int i13 = iArr[1];
        return view.isClickable() && i11 >= i13 && i11 <= view.getMeasuredHeight() + i13 && i10 >= i12 && i10 <= view.getMeasuredWidth() + i12;
    }

    /* renamed from: j */
    public final /* synthetic */ void m25683j() {
        try {
            m25676b(getContext());
            this.f19369j.updateViewLayout(this, this.f19370k);
            m25679f();
            if (this.f19373n == 0) {
                setVisibility(0);
            } else {
                setVisibility(8);
            }
        } catch (Exception e10) {
            C11839m.m70687e("CampaignEntryFloatView", "onConfigurationChanged Exception: " + e10.getMessage());
        }
    }

    /* renamed from: k */
    public final void m25684k() {
        try {
            this.f19369j.updateViewLayout(this, this.f19370k);
        } catch (Exception e10) {
            C11839m.m70687e("CampaignEntryFloatView", "updateViewLayout Exception: " + e10.getMessage());
        }
    }

    /* renamed from: l */
    public void m25685l() {
        try {
            this.f19369j.addView(this, this.f19370k);
        } catch (Exception e10) {
            C11839m.m70686d("CampaignEntryFloatView", "addView Exception: " + e10.getMessage());
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f19373n == 0) {
            super.setVisibility(8);
        }
        postDelayed(new Runnable() { // from class: de.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f45837a.m25683j();
            }
        }, 200L);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        C11839m.m70686d("CampaignEntryFloatView", "onTouchEvent X: " + rawX + ", Y: " + rawY);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f19361b = rawX;
            this.f19362c = rawY;
            WindowManager.LayoutParams layoutParams = this.f19370k;
            this.f19363d = layoutParams.x;
            this.f19364e = layoutParams.y;
        } else if (action != 1) {
            if (action == 2) {
                int i10 = (int) (rawX - this.f19361b);
                int i11 = (int) (rawY - this.f19362c);
                if (this.f19360a || Math.abs(i10) > this.f19365f / 3 || Math.abs(i11) > this.f19366g / 3) {
                    if (!this.f19360a) {
                        m25678e();
                    }
                    WindowManager.LayoutParams layoutParams2 = this.f19370k;
                    layoutParams2.x = this.f19363d + i10;
                    layoutParams2.y = this.f19364e + i11;
                    m25684k();
                    this.f19360a = true;
                }
            }
        } else if (this.f19360a) {
            setViewSide(rawX);
            m25684k();
            m25679f();
            this.f19360a = false;
            this.f19361b = 0.0f;
            this.f19362c = 0.0f;
            this.f19363d = 0;
            this.f19364e = 0;
        } else {
            View viewM25680g = m25680g(this, (int) this.f19361b, (int) this.f19362c);
            if (viewM25680g != null) {
                viewM25680g.performClick();
            }
        }
        return true;
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        if (i10 == 0) {
            try {
                m25676b(getContext());
                this.f19369j.updateViewLayout(this, this.f19370k);
                m25679f();
            } catch (Exception e10) {
                C11839m.m70687e("CampaignEntryFloatView", "onWindowVisibilityChanged Exception: " + e10.getMessage());
            }
        }
    }

    public void setViewSide(float f10) {
        float f11 = this.f19367h;
        if (f10 < f11 / 2.0f) {
            this.f19370k.x = 0;
        } else {
            this.f19370k.x = (int) (f11 - r2.width);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        this.f19373n = i10;
    }

    public CampaignEntryFloatView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        mo25681h(context);
    }

    public CampaignEntryFloatView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        mo25681h(context);
    }
}
