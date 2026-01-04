package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.C0585c;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$styleable;
import p273f0.C9603h0;
import p356i3.C10427h;
import p356i3.C10430k;

/* loaded from: classes.dex */
class RadialViewGroup extends ConstraintLayout {

    /* renamed from: a */
    public final Runnable f9026a;

    /* renamed from: b */
    public int f9027b;

    /* renamed from: c */
    public C10427h f9028c;

    /* renamed from: com.google.android.material.timepicker.RadialViewGroup$a */
    public class RunnableC1878a implements Runnable {
        public RunnableC1878a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RadialViewGroup.this.m11413f();
        }
    }

    public RadialViewGroup(Context context) {
        this(context, null);
    }

    /* renamed from: e */
    public static boolean m11410e(View view) {
        return "skip".equals(view.getTag());
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i10, layoutParams);
        if (view.getId() == -1) {
            view.setId(C9603h0.m59891k());
        }
        m11414g();
    }

    /* renamed from: b */
    public final Drawable m11411b() {
        C10427h c10427h = new C10427h();
        this.f9028c = c10427h;
        c10427h.m64000Z(new C10430k(0.5f));
        this.f9028c.m64002b0(ColorStateList.valueOf(-1));
        return this.f9028c;
    }

    /* renamed from: c */
    public int m11412c() {
        return this.f9027b;
    }

    /* renamed from: d */
    public void mo11392d(int i10) {
        this.f9027b = i10;
        m11413f();
    }

    /* renamed from: f */
    public void m11413f() {
        int childCount = getChildCount();
        int i10 = 1;
        for (int i11 = 0; i11 < childCount; i11++) {
            if (m11410e(getChildAt(i11))) {
                i10++;
            }
        }
        C0585c c0585c = new C0585c();
        c0585c.m3637p(this);
        float f10 = 0.0f;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            int id2 = childAt.getId();
            int i13 = R$id.circle_center;
            if (id2 != i13 && !m11410e(childAt)) {
                c0585c.m3640s(childAt.getId(), i13, this.f9027b, f10);
                f10 += 360.0f / (childCount - i10);
            }
        }
        c0585c.m3631i(this);
    }

    /* renamed from: g */
    public final void m11414g() {
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.f9026a);
            handler.post(this.f9026a);
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        m11413f();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        m11414g();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
        this.f9028c.m64002b0(ColorStateList.valueOf(i10));
    }

    public RadialViewGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RadialViewGroup(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        LayoutInflater.from(context).inflate(R$layout.material_radial_view_group, this);
        C9603h0.m59910t0(this, m11411b());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RadialViewGroup, i10, 0);
        this.f9027b = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.RadialViewGroup_materialCircleRadius, 0);
        this.f9026a = new RunnableC1878a();
        typedArrayObtainStyledAttributes.recycle();
    }
}
