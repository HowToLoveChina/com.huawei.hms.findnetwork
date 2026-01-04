package com.google.android.material.timepicker;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import com.google.android.material.R$attr;
import com.google.android.material.R$color;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.timepicker.ClockHandView;
import java.util.Arrays;
import p211d.C8968a;
import p273f0.C9582a;
import p273f0.C9603h0;
import p276f3.C9649c;
import p304g0.C9832l;

/* loaded from: classes.dex */
class ClockFaceView extends RadialViewGroup implements ClockHandView.InterfaceC1877c {

    /* renamed from: d */
    public final ClockHandView f8992d;

    /* renamed from: e */
    public final Rect f8993e;

    /* renamed from: f */
    public final RectF f8994f;

    /* renamed from: g */
    public final SparseArray<TextView> f8995g;

    /* renamed from: h */
    public final C9582a f8996h;

    /* renamed from: i */
    public final int[] f8997i;

    /* renamed from: j */
    public final float[] f8998j;

    /* renamed from: k */
    public final int f8999k;

    /* renamed from: l */
    public final int f9000l;

    /* renamed from: m */
    public final int f9001m;

    /* renamed from: n */
    public final int f9002n;

    /* renamed from: o */
    public String[] f9003o;

    /* renamed from: p */
    public float f9004p;

    /* renamed from: q */
    public final ColorStateList f9005q;

    /* renamed from: com.google.android.material.timepicker.ClockFaceView$a */
    public class ViewTreeObserverOnPreDrawListenerC1873a implements ViewTreeObserver.OnPreDrawListener {
        public ViewTreeObserverOnPreDrawListenerC1873a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (!ClockFaceView.this.isShown()) {
                return true;
            }
            ClockFaceView.this.getViewTreeObserver().removeOnPreDrawListener(this);
            ClockFaceView.this.mo11392d(((ClockFaceView.this.getHeight() / 2) - ClockFaceView.this.f8992d.m11403g()) - ClockFaceView.this.f8999k);
            return true;
        }
    }

    /* renamed from: com.google.android.material.timepicker.ClockFaceView$b */
    public class C1874b extends C9582a {
        public C1874b() {
        }

        @Override // p273f0.C9582a
        public void onInitializeAccessibilityNodeInfo(View view, C9832l c9832l) {
            super.onInitializeAccessibilityNodeInfo(view, c9832l);
            int iIntValue = ((Integer) view.getTag(R$id.material_value_index)).intValue();
            if (iIntValue > 0) {
                c9832l.m61116x0((View) ClockFaceView.this.f8995g.get(iIntValue - 1));
            }
            c9832l.m61068X(C9832l.c.m61127a(0, 1, iIntValue, 1, false, view.isSelected()));
            c9832l.m61066V(true);
            c9832l.m61073b(C9832l.a.f48299i);
        }

        @Override // p273f0.C9582a
        public boolean performAccessibilityAction(View view, int i10, Bundle bundle) {
            if (i10 != 16) {
                return super.performAccessibilityAction(view, i10, bundle);
            }
            long jUptimeMillis = SystemClock.uptimeMillis();
            float x10 = view.getX() + (view.getWidth() / 2.0f);
            float height = (view.getHeight() / 2.0f) + view.getY();
            ClockFaceView.this.f8992d.onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 0, x10, height, 0));
            ClockFaceView.this.f8992d.onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 1, x10, height, 0));
            return true;
        }
    }

    public ClockFaceView(Context context) {
        this(context, null);
    }

    /* renamed from: s */
    public static float m11390s(float f10, float f11, float f12) {
        return Math.max(Math.max(f10, f11), f12);
    }

    @Override // com.google.android.material.timepicker.ClockHandView.InterfaceC1877c
    /* renamed from: a */
    public void mo11391a(float f10, boolean z10) {
        if (Math.abs(this.f9004p - f10) > 0.001f) {
            this.f9004p = f10;
            m11393q();
        }
    }

    @Override // com.google.android.material.timepicker.RadialViewGroup
    /* renamed from: d */
    public void mo11392d(int i10) {
        if (i10 != m11412c()) {
            super.mo11392d(i10);
            this.f8992d.m11406j(m11412c());
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        C9832l.m61042A0(accessibilityNodeInfo).m61067W(C9832l.b.m61126b(1, this.f9003o.length, false, 1));
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        m11393q();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int iM11390s = (int) (this.f9002n / m11390s(this.f9000l / displayMetrics.heightPixels, this.f9001m / displayMetrics.widthPixels, 1.0f));
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iM11390s, 1073741824);
        setMeasuredDimension(iM11390s, iM11390s);
        super.onMeasure(iMakeMeasureSpec, iMakeMeasureSpec);
    }

    /* renamed from: q */
    public final void m11393q() {
        RectF rectFM11400d = this.f8992d.m11400d();
        for (int i10 = 0; i10 < this.f8995g.size(); i10++) {
            TextView textView = this.f8995g.get(i10);
            if (textView != null) {
                textView.getDrawingRect(this.f8993e);
                offsetDescendantRectToMyCoords(textView, this.f8993e);
                textView.setSelected(rectFM11400d.contains(this.f8993e.centerX(), this.f8993e.centerY()));
                textView.getPaint().setShader(m11394r(rectFM11400d, this.f8993e, textView));
                textView.invalidate();
            }
        }
    }

    /* renamed from: r */
    public final RadialGradient m11394r(RectF rectF, Rect rect, TextView textView) {
        this.f8994f.set(rect);
        this.f8994f.offset(textView.getPaddingLeft(), textView.getPaddingTop());
        if (RectF.intersects(rectF, this.f8994f)) {
            return new RadialGradient(rectF.centerX() - this.f8994f.left, rectF.centerY() - this.f8994f.top, rectF.width() * 0.5f, this.f8997i, this.f8998j, Shader.TileMode.CLAMP);
        }
        return null;
    }

    /* renamed from: t */
    public void m11395t(String[] strArr, int i10) {
        this.f9003o = strArr;
        m11396u(i10);
    }

    /* renamed from: u */
    public final void m11396u(int i10) {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        int size = this.f8995g.size();
        for (int i11 = 0; i11 < Math.max(this.f9003o.length, size); i11++) {
            TextView textView = this.f8995g.get(i11);
            if (i11 >= this.f9003o.length) {
                removeView(textView);
                this.f8995g.remove(i11);
            } else {
                if (textView == null) {
                    textView = (TextView) layoutInflaterFrom.inflate(R$layout.material_clockface_textview, (ViewGroup) this, false);
                    this.f8995g.put(i11, textView);
                    addView(textView);
                }
                textView.setVisibility(0);
                textView.setText(this.f9003o[i11]);
                textView.setTag(R$id.material_value_index, Integer.valueOf(i11));
                C9603h0.m59902p0(textView, this.f8996h);
                textView.setTextColor(this.f9005q);
                if (i10 != 0) {
                    textView.setContentDescription(getResources().getString(i10, this.f9003o[i11]));
                }
            }
        }
    }

    public ClockFaceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialClockStyle);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public ClockFaceView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f8993e = new Rect();
        this.f8994f = new RectF();
        this.f8995g = new SparseArray<>();
        this.f8998j = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ClockFaceView, i10, R$style.Widget_MaterialComponents_TimePicker_Clock);
        Resources resources = getResources();
        ColorStateList colorStateListM60265a = C9649c.m60265a(context, typedArrayObtainStyledAttributes, R$styleable.ClockFaceView_clockNumberTextColor);
        this.f9005q = colorStateListM60265a;
        LayoutInflater.from(context).inflate(R$layout.material_clockface_view, (ViewGroup) this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(R$id.material_clock_hand);
        this.f8992d = clockHandView;
        this.f8999k = resources.getDimensionPixelSize(R$dimen.material_clock_hand_padding);
        int colorForState = colorStateListM60265a.getColorForState(new int[]{R.attr.state_selected}, colorStateListM60265a.getDefaultColor());
        this.f8997i = new int[]{colorForState, colorForState, colorStateListM60265a.getDefaultColor()};
        clockHandView.m11398b(this);
        int defaultColor = C8968a.m56742a(context, R$color.material_timepicker_clockface).getDefaultColor();
        ColorStateList colorStateListM60265a2 = C9649c.m60265a(context, typedArrayObtainStyledAttributes, R$styleable.ClockFaceView_clockFaceBackgroundColor);
        setBackgroundColor(colorStateListM60265a2 != null ? colorStateListM60265a2.getDefaultColor() : defaultColor);
        getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserverOnPreDrawListenerC1873a());
        setFocusable(true);
        typedArrayObtainStyledAttributes.recycle();
        this.f8996h = new C1874b();
        String[] strArr = new String[12];
        Arrays.fill(strArr, "");
        m11395t(strArr, 0);
        this.f9000l = resources.getDimensionPixelSize(R$dimen.material_time_picker_minimum_screen_height);
        this.f9001m = resources.getDimensionPixelSize(R$dimen.material_time_picker_minimum_screen_width);
        this.f9002n = resources.getDimensionPixelSize(R$dimen.material_clock_size);
    }
}
