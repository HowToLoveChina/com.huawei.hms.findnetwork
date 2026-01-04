package com.google.android.material.slider;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.SeekBar;
import com.google.android.material.R$attr;
import com.google.android.material.R$color;
import com.google.android.material.R$dimen;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.C1773d;
import com.google.android.material.internal.C1784o;
import com.google.android.material.internal.C1788s;
import com.google.android.material.internal.InterfaceC1787r;
import com.google.android.material.slider.BaseSlider;
import com.google.android.material.slider.InterfaceC1819a;
import com.google.android.material.slider.InterfaceC1820b;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import p211d.C8968a;
import p273f0.C9603h0;
import p276f3.C9649c;
import p304g0.C9832l;
import p356i3.C10427h;
import p356i3.C10432m;
import p413k0.AbstractC10968a;
import p416k3.C10981a;
import p442l3.C11228a;
import p666u2.C13110a;
import p757x.C13669a;
import p827z.C14059a;
import p830z2.C14088a;

/* loaded from: classes.dex */
abstract class BaseSlider<S extends BaseSlider<S, L, T>, L extends InterfaceC1819a<S>, T extends InterfaceC1820b<S>> extends View {

    /* renamed from: d0 */
    public static final String f8557d0 = "BaseSlider";

    /* renamed from: e0 */
    public static final int f8558e0 = R$style.Widget_MaterialComponents_Slider;

    /* renamed from: A */
    public int f8559A;

    /* renamed from: B */
    public float f8560B;

    /* renamed from: C */
    public MotionEvent f8561C;

    /* renamed from: D */
    public boolean f8562D;

    /* renamed from: E */
    public float f8563E;

    /* renamed from: F */
    public float f8564F;

    /* renamed from: G */
    public ArrayList<Float> f8565G;

    /* renamed from: H */
    public int f8566H;

    /* renamed from: I */
    public int f8567I;

    /* renamed from: J */
    public float f8568J;

    /* renamed from: K */
    public float[] f8569K;

    /* renamed from: L */
    public boolean f8570L;

    /* renamed from: M */
    public int f8571M;

    /* renamed from: N */
    public boolean f8572N;

    /* renamed from: O */
    public boolean f8573O;

    /* renamed from: P */
    public boolean f8574P;

    /* renamed from: Q */
    public ColorStateList f8575Q;

    /* renamed from: R */
    public ColorStateList f8576R;

    /* renamed from: S */
    public ColorStateList f8577S;

    /* renamed from: T */
    public ColorStateList f8578T;

    /* renamed from: U */
    public ColorStateList f8579U;

    /* renamed from: V */
    public final C10427h f8580V;

    /* renamed from: W */
    public Drawable f8581W;

    /* renamed from: a */
    public final Paint f8582a;

    /* renamed from: a0 */
    public List<Drawable> f8583a0;

    /* renamed from: b */
    public final Paint f8584b;

    /* renamed from: b0 */
    public float f8585b0;

    /* renamed from: c */
    public final Paint f8586c;

    /* renamed from: c0 */
    public int f8587c0;

    /* renamed from: d */
    public final Paint f8588d;

    /* renamed from: e */
    public final Paint f8589e;

    /* renamed from: f */
    public final Paint f8590f;

    /* renamed from: g */
    public final C1815e f8591g;

    /* renamed from: h */
    public final AccessibilityManager f8592h;

    /* renamed from: i */
    public BaseSlider<S, L, T>.RunnableC1814d f8593i;

    /* renamed from: j */
    public final InterfaceC1816f f8594j;

    /* renamed from: k */
    public final List<C11228a> f8595k;

    /* renamed from: l */
    public final List<L> f8596l;

    /* renamed from: m */
    public final List<T> f8597m;

    /* renamed from: n */
    public boolean f8598n;

    /* renamed from: o */
    public ValueAnimator f8599o;

    /* renamed from: p */
    public ValueAnimator f8600p;

    /* renamed from: q */
    public final int f8601q;

    /* renamed from: r */
    public int f8602r;

    /* renamed from: s */
    public int f8603s;

    /* renamed from: t */
    public int f8604t;

    /* renamed from: u */
    public int f8605u;

    /* renamed from: v */
    public int f8606v;

    /* renamed from: w */
    public int f8607w;

    /* renamed from: x */
    public int f8608x;

    /* renamed from: y */
    public int f8609y;

    /* renamed from: z */
    public int f8610z;

    public static class SliderState extends View.BaseSavedState {
        public static final Parcelable.Creator<SliderState> CREATOR = new C1810a();

        /* renamed from: a */
        public float f8611a;

        /* renamed from: b */
        public float f8612b;

        /* renamed from: c */
        public ArrayList<Float> f8613c;

        /* renamed from: d */
        public float f8614d;

        /* renamed from: e */
        public boolean f8615e;

        /* renamed from: com.google.android.material.slider.BaseSlider$SliderState$a */
        public class C1810a implements Parcelable.Creator<SliderState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SliderState createFromParcel(Parcel parcel) {
                return new SliderState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SliderState[] newArray(int i10) {
                return new SliderState[i10];
            }
        }

        public /* synthetic */ SliderState(Parcel parcel, C1811a c1811a) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeFloat(this.f8611a);
            parcel.writeFloat(this.f8612b);
            parcel.writeList(this.f8613c);
            parcel.writeFloat(this.f8614d);
            parcel.writeBooleanArray(new boolean[]{this.f8615e});
        }

        public SliderState(Parcelable parcelable) {
            super(parcelable);
        }

        public SliderState(Parcel parcel) {
            super(parcel);
            this.f8611a = parcel.readFloat();
            this.f8612b = parcel.readFloat();
            ArrayList<Float> arrayList = new ArrayList<>();
            this.f8613c = arrayList;
            parcel.readList(arrayList, Float.class.getClassLoader());
            this.f8614d = parcel.readFloat();
            this.f8615e = parcel.createBooleanArray()[0];
        }
    }

    /* renamed from: com.google.android.material.slider.BaseSlider$a */
    public class C1811a implements InterfaceC1816f {

        /* renamed from: a */
        public final /* synthetic */ AttributeSet f8616a;

        /* renamed from: b */
        public final /* synthetic */ int f8617b;

        public C1811a(AttributeSet attributeSet, int i10) {
            this.f8616a = attributeSet;
            this.f8617b = i10;
        }

        @Override // com.google.android.material.slider.BaseSlider.InterfaceC1816f
        /* renamed from: a */
        public C11228a mo10969a() {
            TypedArray typedArrayM10770h = C1784o.m10770h(BaseSlider.this.getContext(), this.f8616a, R$styleable.Slider, this.f8617b, BaseSlider.f8558e0, new int[0]);
            C11228a c11228aM10897V = BaseSlider.m10897V(BaseSlider.this.getContext(), typedArrayM10770h);
            typedArrayM10770h.recycle();
            return c11228aM10897V;
        }
    }

    /* renamed from: com.google.android.material.slider.BaseSlider$b */
    public class C1812b implements ValueAnimator.AnimatorUpdateListener {
        public C1812b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            Iterator it = BaseSlider.this.f8595k.iterator();
            while (it.hasNext()) {
                ((C11228a) it.next()).m67426B0(fFloatValue);
            }
            C9603h0.m59884g0(BaseSlider.this);
        }
    }

    /* renamed from: com.google.android.material.slider.BaseSlider$c */
    public class C1813c extends AnimatorListenerAdapter {
        public C1813c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            Iterator it = BaseSlider.this.f8595k.iterator();
            while (it.hasNext()) {
                C1788s.m10785f(BaseSlider.this).mo10779b((C11228a) it.next());
            }
        }
    }

    /* renamed from: com.google.android.material.slider.BaseSlider$e */
    public static class C1815e extends AbstractC10968a {

        /* renamed from: o */
        public final BaseSlider<?, ?, ?> f8623o;

        /* renamed from: p */
        public final Rect f8624p;

        public C1815e(BaseSlider<?, ?, ?> baseSlider) {
            super(baseSlider);
            this.f8624p = new Rect();
            this.f8623o = baseSlider;
        }

        @Override // p413k0.AbstractC10968a
        /* renamed from: C */
        public void mo10023C(int i10, C9832l c9832l) {
            c9832l.m61073b(C9832l.a.f48285L);
            List<Float> values = this.f8623o.getValues();
            float fFloatValue = values.get(i10).floatValue();
            float valueFrom = this.f8623o.getValueFrom();
            float valueTo = this.f8623o.getValueTo();
            if (this.f8623o.isEnabled()) {
                if (fFloatValue > valueFrom) {
                    c9832l.m61071a(8192);
                }
                if (fFloatValue < valueTo) {
                    c9832l.m61071a(4096);
                }
            }
            c9832l.m61096n0(C9832l.d.m61128a(1, valueFrom, valueTo, fFloatValue));
            c9832l.m61065U(SeekBar.class.getName());
            StringBuilder sb2 = new StringBuilder();
            if (this.f8623o.getContentDescription() != null) {
                sb2.append(this.f8623o.getContentDescription());
                sb2.append(",");
            }
            if (values.size() > 1) {
                sb2.append(m10971L(i10));
                sb2.append(this.f8623o.m10906A(fFloatValue));
            }
            c9832l.m61069Y(sb2.toString());
            this.f8623o.m10937h0(i10, this.f8624p);
            c9832l.m61060P(this.f8624p);
        }

        /* renamed from: L */
        public final String m10971L(int i10) {
            return i10 == this.f8623o.getValues().size() + (-1) ? this.f8623o.getContext().getString(R$string.material_slider_range_end) : i10 == 0 ? this.f8623o.getContext().getString(R$string.material_slider_range_start) : "";
        }

        @Override // p413k0.AbstractC10968a
        /* renamed from: o */
        public int mo10025o(float f10, float f11) {
            for (int i10 = 0; i10 < this.f8623o.getValues().size(); i10++) {
                this.f8623o.m10937h0(i10, this.f8624p);
                if (this.f8624p.contains((int) f10, (int) f11)) {
                    return i10;
                }
            }
            return -1;
        }

        @Override // p413k0.AbstractC10968a
        /* renamed from: p */
        public void mo10026p(List<Integer> list) {
            for (int i10 = 0; i10 < this.f8623o.getValues().size(); i10++) {
                list.add(Integer.valueOf(i10));
            }
        }

        @Override // p413k0.AbstractC10968a
        /* renamed from: y */
        public boolean mo10027y(int i10, int i11, Bundle bundle) {
            if (!this.f8623o.isEnabled()) {
                return false;
            }
            if (i11 != 4096 && i11 != 8192) {
                if (i11 == 16908349 && bundle != null && bundle.containsKey("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE")) {
                    if (this.f8623o.m10934f0(i10, bundle.getFloat("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE"))) {
                        this.f8623o.m10939i0();
                        this.f8623o.postInvalidate();
                        m66222r(i10);
                        return true;
                    }
                }
                return false;
            }
            float fM10944l = this.f8623o.m10944l(20);
            if (i11 == 8192) {
                fM10944l = -fM10944l;
            }
            if (this.f8623o.m10914J()) {
                fM10944l = -fM10944l;
            }
            if (!this.f8623o.m10934f0(i10, C14059a.m84262a(this.f8623o.getValues().get(i10).floatValue() + fM10944l, this.f8623o.getValueFrom(), this.f8623o.getValueTo()))) {
                return false;
            }
            this.f8623o.m10939i0();
            this.f8623o.postInvalidate();
            m66222r(i10);
            return true;
        }
    }

    /* renamed from: com.google.android.material.slider.BaseSlider$f */
    public interface InterfaceC1816f {
        /* renamed from: a */
        C11228a mo10969a();
    }

    public BaseSlider(Context context) {
        this(context, null);
    }

    /* renamed from: B */
    public static float m10896B(ValueAnimator valueAnimator, float f10) {
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return f10;
        }
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        valueAnimator.cancel();
        return fFloatValue;
    }

    /* renamed from: V */
    public static C11228a m10897V(Context context, TypedArray typedArray) {
        return C11228a.m67423u0(context, null, 0, typedArray.getResourceId(R$styleable.Slider_labelStyle, R$style.Widget_MaterialComponents_Tooltip));
    }

    /* renamed from: X */
    public static int m10898X(float[] fArr, float f10) {
        return Math.round(f10 * ((fArr.length / 2) - 1));
    }

    private float[] getActiveRange() {
        float fFloatValue = ((Float) Collections.max(getValues())).floatValue();
        float fFloatValue2 = ((Float) Collections.min(getValues())).floatValue();
        if (this.f8565G.size() == 1) {
            fFloatValue2 = this.f8563E;
        }
        float fM10922R = m10922R(fFloatValue2);
        float fM10922R2 = m10922R(fFloatValue);
        return m10914J() ? new float[]{fM10922R2, fM10922R} : new float[]{fM10922R, fM10922R2};
    }

    private float getValueOfTouchPosition() {
        double dM10933e0 = m10933e0(this.f8585b0);
        if (m10914J()) {
            dM10933e0 = 1.0d - dM10933e0;
        }
        float f10 = this.f8564F;
        return (float) ((dM10933e0 * (f10 - r4)) + this.f8563E);
    }

    private float getValueOfTouchPositionAbsolute() {
        float f10 = this.f8585b0;
        if (m10914J()) {
            f10 = 1.0f - f10;
        }
        float f11 = this.f8564F;
        float f12 = this.f8563E;
        return (f10 * (f11 - f12)) + f12;
    }

    private void setValuesInternal(ArrayList<Float> arrayList) {
        if (arrayList.isEmpty()) {
            throw new IllegalArgumentException("At least one value must be set");
        }
        Collections.sort(arrayList);
        if (this.f8565G.size() == arrayList.size() && this.f8565G.equals(arrayList)) {
            return;
        }
        this.f8565G = arrayList;
        this.f8574P = true;
        this.f8567I = 0;
        m10939i0();
        m10950o();
        m10958s();
        postInvalidate();
    }

    /* renamed from: A */
    public final String m10906A(float f10) {
        if (mo10909E()) {
            throw null;
        }
        return String.format(((float) ((int) f10)) == f10 ? "%.0f" : "%.2f", Float.valueOf(f10));
    }

    /* renamed from: C */
    public final float m10907C(int i10, float f10) {
        float minSeparation = getMinSeparation();
        if (this.f8587c0 == 0) {
            minSeparation = m10954q(minSeparation);
        }
        if (m10914J()) {
            minSeparation = -minSeparation;
        }
        int i11 = i10 + 1;
        int i12 = i10 - 1;
        return C14059a.m84262a(f10, i12 < 0 ? this.f8563E : this.f8565G.get(i12).floatValue() + minSeparation, i11 >= this.f8565G.size() ? this.f8564F : this.f8565G.get(i11).floatValue() - minSeparation);
    }

    /* renamed from: D */
    public final int m10908D(ColorStateList colorStateList) {
        return colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor());
    }

    /* renamed from: E */
    public boolean mo10909E() {
        return false;
    }

    /* renamed from: F */
    public final Drawable m10910F(Drawable drawable) {
        Drawable drawableNewDrawable = drawable.mutate().getConstantState().newDrawable();
        m10936h(drawableNewDrawable);
        return drawableNewDrawable;
    }

    /* renamed from: G */
    public final void m10911G() {
        this.f8582a.setStrokeWidth(this.f8606v);
        this.f8584b.setStrokeWidth(this.f8606v);
        this.f8589e.setStrokeWidth(this.f8606v / 2.0f);
        this.f8590f.setStrokeWidth(this.f8606v / 2.0f);
    }

    /* renamed from: H */
    public final boolean m10912H() {
        for (ViewParent parent = getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
            ViewGroup viewGroup = (ViewGroup) parent;
            if ((viewGroup.canScrollVertically(1) || viewGroup.canScrollVertically(-1)) && viewGroup.shouldDelayChildPressedState()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: I */
    public final boolean m10913I(float f10) {
        double dDoubleValue = new BigDecimal(Float.toString(f10)).divide(new BigDecimal(Float.toString(this.f8568J)), MathContext.DECIMAL64).doubleValue();
        return Math.abs(((double) Math.round(dDoubleValue)) - dDoubleValue) < 1.0E-4d;
    }

    /* renamed from: J */
    public final boolean m10914J() {
        return C9603h0.m59832A(this) == 1;
    }

    /* renamed from: K */
    public final void m10915K(Resources resources) throws Resources.NotFoundException {
        this.f8604t = resources.getDimensionPixelSize(R$dimen.mtrl_slider_widget_height);
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R$dimen.mtrl_slider_track_side_padding);
        this.f8602r = dimensionPixelOffset;
        this.f8607w = dimensionPixelOffset;
        this.f8603s = resources.getDimensionPixelSize(R$dimen.mtrl_slider_thumb_radius);
        this.f8608x = resources.getDimensionPixelOffset(R$dimen.mtrl_slider_track_top);
        this.f8559A = resources.getDimensionPixelSize(R$dimen.mtrl_slider_label_padding);
    }

    /* renamed from: L */
    public final void m10916L() {
        if (this.f8568J <= 0.0f) {
            return;
        }
        m10943k0();
        int iMin = Math.min((int) (((this.f8564F - this.f8563E) / this.f8568J) + 1.0f), (this.f8571M / (this.f8606v * 2)) + 1);
        float[] fArr = this.f8569K;
        if (fArr == null || fArr.length != iMin * 2) {
            this.f8569K = new float[iMin * 2];
        }
        float f10 = this.f8571M / (iMin - 1);
        for (int i10 = 0; i10 < iMin * 2; i10 += 2) {
            float[] fArr2 = this.f8569K;
            fArr2[i10] = this.f8607w + ((i10 / 2) * f10);
            fArr2[i10 + 1] = m10946m();
        }
    }

    /* renamed from: M */
    public final void m10917M(Canvas canvas, int i10, int i11) {
        if (m10931c0()) {
            canvas.drawCircle((int) (this.f8607w + (m10922R(this.f8565G.get(this.f8567I).floatValue()) * i10)), i11, this.f8610z, this.f8588d);
        }
    }

    /* renamed from: N */
    public final void m10918N(Canvas canvas) {
        if (!this.f8570L || this.f8568J <= 0.0f) {
            return;
        }
        float[] activeRange = getActiveRange();
        int iM10898X = m10898X(this.f8569K, activeRange[0]);
        int iM10898X2 = m10898X(this.f8569K, activeRange[1]);
        int i10 = iM10898X * 2;
        canvas.drawPoints(this.f8569K, 0, i10, this.f8589e);
        int i11 = iM10898X2 * 2;
        canvas.drawPoints(this.f8569K, i10, i11 - i10, this.f8590f);
        float[] fArr = this.f8569K;
        canvas.drawPoints(fArr, i11, fArr.length - i11, this.f8589e);
    }

    /* renamed from: O */
    public final void m10919O() {
        this.f8607w = this.f8602r + Math.max(this.f8609y - this.f8603s, 0);
        if (C9603h0.m59864T(this)) {
            m10941j0(getWidth());
        }
    }

    /* renamed from: P */
    public final boolean m10920P(int i10) {
        int i11 = this.f8567I;
        int iM84264c = (int) C14059a.m84264c(i11 + i10, 0L, this.f8565G.size() - 1);
        this.f8567I = iM84264c;
        if (iM84264c == i11) {
            return false;
        }
        if (this.f8566H != -1) {
            this.f8566H = iM84264c;
        }
        m10939i0();
        postInvalidate();
        return true;
    }

    /* renamed from: Q */
    public final boolean m10921Q(int i10) {
        if (m10914J()) {
            i10 = i10 == Integer.MIN_VALUE ? Integer.MAX_VALUE : -i10;
        }
        return m10920P(i10);
    }

    /* renamed from: R */
    public final float m10922R(float f10) {
        float f11 = this.f8563E;
        float f12 = (f10 - f11) / (this.f8564F - f11);
        return m10914J() ? 1.0f - f12 : f12;
    }

    /* renamed from: S */
    public final Boolean m10923S(int i10, KeyEvent keyEvent) {
        if (i10 == 61) {
            return keyEvent.hasNoModifiers() ? Boolean.valueOf(m10920P(1)) : keyEvent.isShiftPressed() ? Boolean.valueOf(m10920P(-1)) : Boolean.FALSE;
        }
        if (i10 != 66) {
            if (i10 != 81) {
                if (i10 == 69) {
                    m10920P(-1);
                    return Boolean.TRUE;
                }
                if (i10 != 70) {
                    switch (i10) {
                        case 21:
                            m10921Q(-1);
                            break;
                        case 22:
                            m10921Q(1);
                            break;
                    }
                    return Boolean.TRUE;
                }
            }
            m10920P(1);
            return Boolean.TRUE;
        }
        this.f8566H = this.f8567I;
        postInvalidate();
        return Boolean.TRUE;
    }

    /* renamed from: T */
    public final void m10924T() {
        Iterator<T> it = this.f8597m.iterator();
        while (it.hasNext()) {
            it.next().m10980a(this);
        }
    }

    /* renamed from: U */
    public final void m10925U() {
        Iterator<T> it = this.f8597m.iterator();
        while (it.hasNext()) {
            it.next().m10981b(this);
        }
    }

    /* renamed from: W */
    public boolean mo10926W() {
        if (this.f8566H != -1) {
            return true;
        }
        float valueOfTouchPositionAbsolute = getValueOfTouchPositionAbsolute();
        float fM10957r0 = m10957r0(valueOfTouchPositionAbsolute);
        this.f8566H = 0;
        float fAbs = Math.abs(this.f8565G.get(0).floatValue() - valueOfTouchPositionAbsolute);
        for (int i10 = 1; i10 < this.f8565G.size(); i10++) {
            float fAbs2 = Math.abs(this.f8565G.get(i10).floatValue() - valueOfTouchPositionAbsolute);
            float fM10957r02 = m10957r0(this.f8565G.get(i10).floatValue());
            if (Float.compare(fAbs2, fAbs) > 1) {
                break;
            }
            boolean z10 = !m10914J() ? fM10957r02 - fM10957r0 >= 0.0f : fM10957r02 - fM10957r0 <= 0.0f;
            if (Float.compare(fAbs2, fAbs) < 0) {
                this.f8566H = i10;
            } else {
                if (Float.compare(fAbs2, fAbs) != 0) {
                    continue;
                } else {
                    if (Math.abs(fM10957r02 - fM10957r0) < this.f8601q) {
                        this.f8566H = -1;
                        return false;
                    }
                    if (z10) {
                        this.f8566H = i10;
                    }
                }
            }
            fAbs = fAbs2;
        }
        return this.f8566H != -1;
    }

    /* renamed from: Y */
    public final void m10927Y(Context context, AttributeSet attributeSet, int i10) {
        TypedArray typedArrayM10770h = C1784o.m10770h(context, attributeSet, R$styleable.Slider, i10, f8558e0, new int[0]);
        this.f8563E = typedArrayM10770h.getFloat(R$styleable.Slider_android_valueFrom, 0.0f);
        this.f8564F = typedArrayM10770h.getFloat(R$styleable.Slider_android_valueTo, 1.0f);
        setValues(Float.valueOf(this.f8563E));
        this.f8568J = typedArrayM10770h.getFloat(R$styleable.Slider_android_stepSize, 0.0f);
        int i11 = R$styleable.Slider_trackColor;
        boolean zHasValue = typedArrayM10770h.hasValue(i11);
        int i12 = zHasValue ? i11 : R$styleable.Slider_trackColorInactive;
        if (!zHasValue) {
            i11 = R$styleable.Slider_trackColorActive;
        }
        ColorStateList colorStateListM60265a = C9649c.m60265a(context, typedArrayM10770h, i12);
        if (colorStateListM60265a == null) {
            colorStateListM60265a = C8968a.m56742a(context, R$color.material_slider_inactive_track_color);
        }
        setTrackInactiveTintList(colorStateListM60265a);
        ColorStateList colorStateListM60265a2 = C9649c.m60265a(context, typedArrayM10770h, i11);
        if (colorStateListM60265a2 == null) {
            colorStateListM60265a2 = C8968a.m56742a(context, R$color.material_slider_active_track_color);
        }
        setTrackActiveTintList(colorStateListM60265a2);
        this.f8580V.m64002b0(C9649c.m60265a(context, typedArrayM10770h, R$styleable.Slider_thumbColor));
        int i13 = R$styleable.Slider_thumbStrokeColor;
        if (typedArrayM10770h.hasValue(i13)) {
            setThumbStrokeColor(C9649c.m60265a(context, typedArrayM10770h, i13));
        }
        setThumbStrokeWidth(typedArrayM10770h.getDimension(R$styleable.Slider_thumbStrokeWidth, 0.0f));
        ColorStateList colorStateListM60265a3 = C9649c.m60265a(context, typedArrayM10770h, R$styleable.Slider_haloColor);
        if (colorStateListM60265a3 == null) {
            colorStateListM60265a3 = C8968a.m56742a(context, R$color.material_slider_halo_color);
        }
        setHaloTintList(colorStateListM60265a3);
        this.f8570L = typedArrayM10770h.getBoolean(R$styleable.Slider_tickVisible, true);
        int i14 = R$styleable.Slider_tickColor;
        boolean zHasValue2 = typedArrayM10770h.hasValue(i14);
        int i15 = zHasValue2 ? i14 : R$styleable.Slider_tickColorInactive;
        if (!zHasValue2) {
            i14 = R$styleable.Slider_tickColorActive;
        }
        ColorStateList colorStateListM60265a4 = C9649c.m60265a(context, typedArrayM10770h, i15);
        if (colorStateListM60265a4 == null) {
            colorStateListM60265a4 = C8968a.m56742a(context, R$color.material_slider_inactive_tick_marks_color);
        }
        setTickInactiveTintList(colorStateListM60265a4);
        ColorStateList colorStateListM60265a5 = C9649c.m60265a(context, typedArrayM10770h, i14);
        if (colorStateListM60265a5 == null) {
            colorStateListM60265a5 = C8968a.m56742a(context, R$color.material_slider_active_tick_marks_color);
        }
        setTickActiveTintList(colorStateListM60265a5);
        setThumbRadius(typedArrayM10770h.getDimensionPixelSize(R$styleable.Slider_thumbRadius, 0));
        setHaloRadius(typedArrayM10770h.getDimensionPixelSize(R$styleable.Slider_haloRadius, 0));
        setThumbElevation(typedArrayM10770h.getDimension(R$styleable.Slider_thumbElevation, 0.0f));
        setTrackHeight(typedArrayM10770h.getDimensionPixelSize(R$styleable.Slider_trackHeight, 0));
        setLabelBehavior(typedArrayM10770h.getInt(R$styleable.Slider_labelBehavior, 0));
        if (!typedArrayM10770h.getBoolean(R$styleable.Slider_android_enabled, true)) {
            setEnabled(false);
        }
        typedArrayM10770h.recycle();
    }

    /* renamed from: Z */
    public final void m10928Z(int i10) {
        BaseSlider<S, L, T>.RunnableC1814d runnableC1814d = this.f8593i;
        if (runnableC1814d == null) {
            this.f8593i = new RunnableC1814d(this, null);
        } else {
            removeCallbacks(runnableC1814d);
        }
        this.f8593i.m10970a(i10);
        postDelayed(this.f8593i, 200L);
    }

    /* renamed from: a0 */
    public final void m10929a0(C11228a c11228a, float f10) {
        c11228a.m67427C0(m10906A(f10));
        int iM10922R = (this.f8607w + ((int) (m10922R(f10) * this.f8571M))) - (c11228a.getIntrinsicWidth() / 2);
        int iM10946m = m10946m() - (this.f8559A + this.f8609y);
        c11228a.setBounds(iM10922R, iM10946m - c11228a.getIntrinsicHeight(), c11228a.getIntrinsicWidth() + iM10922R, iM10946m);
        Rect rect = new Rect(c11228a.getBounds());
        C1773d.m10679c(C1788s.m10784e(this), this, rect);
        c11228a.setBounds(rect);
        C1788s.m10785f(this).mo10778a(c11228a);
    }

    /* renamed from: b0 */
    public final boolean m10930b0() {
        return this.f8605u == 3;
    }

    /* renamed from: c0 */
    public final boolean m10931c0() {
        return this.f8572N || !(getBackground() instanceof RippleDrawable);
    }

    /* renamed from: d0 */
    public final boolean m10932d0(float f10) {
        return m10934f0(this.f8566H, f10);
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return this.f8591g.m66216i(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.f8582a.setColor(m10908D(this.f8579U));
        this.f8584b.setColor(m10908D(this.f8578T));
        this.f8589e.setColor(m10908D(this.f8577S));
        this.f8590f.setColor(m10908D(this.f8576R));
        for (C11228a c11228a : this.f8595k) {
            if (c11228a.isStateful()) {
                c11228a.setState(getDrawableState());
            }
        }
        if (this.f8580V.isStateful()) {
            this.f8580V.setState(getDrawableState());
        }
        this.f8588d.setColor(m10908D(this.f8575Q));
        this.f8588d.setAlpha(63);
    }

    /* renamed from: e0 */
    public final double m10933e0(float f10) {
        float f11 = this.f8568J;
        if (f11 <= 0.0f) {
            return f10;
        }
        return Math.round(f10 * r2) / ((int) ((this.f8564F - this.f8563E) / f11));
    }

    /* renamed from: f0 */
    public final boolean m10934f0(int i10, float f10) {
        this.f8567I = i10;
        if (Math.abs(f10 - this.f8565G.get(i10).floatValue()) < 1.0E-4d) {
            return false;
        }
        this.f8565G.set(i10, Float.valueOf(m10907C(i10, f10)));
        m10956r(i10);
        return true;
    }

    /* renamed from: g0 */
    public final boolean m10935g0() {
        return m10932d0(getValueOfTouchPosition());
    }

    @Override // android.view.View
    public CharSequence getAccessibilityClassName() {
        return SeekBar.class.getName();
    }

    public final int getAccessibilityFocusedVirtualViewId() {
        return this.f8591g.m66218k();
    }

    public int getActiveThumbIndex() {
        return this.f8566H;
    }

    public int getFocusedThumbIndex() {
        return this.f8567I;
    }

    public int getHaloRadius() {
        return this.f8610z;
    }

    public ColorStateList getHaloTintList() {
        return this.f8575Q;
    }

    public int getLabelBehavior() {
        return this.f8605u;
    }

    public float getMinSeparation() {
        return 0.0f;
    }

    public float getStepSize() {
        return this.f8568J;
    }

    public float getThumbElevation() {
        return this.f8580V.m64032w();
    }

    public int getThumbRadius() {
        return this.f8609y;
    }

    public ColorStateList getThumbStrokeColor() {
        return this.f8580V.m63981F();
    }

    public float getThumbStrokeWidth() {
        return this.f8580V.m63983H();
    }

    public ColorStateList getThumbTintList() {
        return this.f8580V.m64033x();
    }

    public ColorStateList getTickActiveTintList() {
        return this.f8576R;
    }

    public ColorStateList getTickInactiveTintList() {
        return this.f8577S;
    }

    public ColorStateList getTickTintList() {
        if (this.f8577S.equals(this.f8576R)) {
            return this.f8576R;
        }
        throw new IllegalStateException("The inactive and active ticks are different colors. Use the getTickColorInactive() and getTickColorActive() methods instead.");
    }

    public ColorStateList getTrackActiveTintList() {
        return this.f8578T;
    }

    public int getTrackHeight() {
        return this.f8606v;
    }

    public ColorStateList getTrackInactiveTintList() {
        return this.f8579U;
    }

    public int getTrackSidePadding() {
        return this.f8607w;
    }

    public ColorStateList getTrackTintList() {
        if (this.f8579U.equals(this.f8578T)) {
            return this.f8578T;
        }
        throw new IllegalStateException("The inactive and active parts of the track are different colors. Use the getInactiveTrackColor() and getActiveTrackColor() methods instead.");
    }

    public int getTrackWidth() {
        return this.f8571M;
    }

    public float getValueFrom() {
        return this.f8563E;
    }

    public float getValueTo() {
        return this.f8564F;
    }

    public List<Float> getValues() {
        return new ArrayList(this.f8565G);
    }

    /* renamed from: h */
    public final void m10936h(Drawable drawable) {
        int i10 = this.f8609y * 2;
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth == -1 && intrinsicHeight == -1) {
            drawable.setBounds(0, 0, i10, i10);
        } else {
            float fMax = i10 / Math.max(intrinsicWidth, intrinsicHeight);
            drawable.setBounds(0, 0, (int) (intrinsicWidth * fMax), (int) (intrinsicHeight * fMax));
        }
    }

    /* renamed from: h0 */
    public void m10937h0(int i10, Rect rect) {
        int iM10922R = this.f8607w + ((int) (m10922R(getValues().get(i10).floatValue()) * this.f8571M));
        int iM10946m = m10946m();
        int i11 = this.f8609y;
        rect.set(iM10922R - i11, iM10946m - i11, iM10922R + i11, iM10946m + i11);
    }

    /* renamed from: i */
    public final void m10938i(C11228a c11228a) {
        c11228a.m67425A0(C1788s.m10784e(this));
    }

    /* renamed from: i0 */
    public final void m10939i0() {
        if (m10931c0() || getMeasuredWidth() <= 0) {
            return;
        }
        Drawable background = getBackground();
        if (background instanceof RippleDrawable) {
            int iM10922R = (int) ((m10922R(this.f8565G.get(this.f8567I).floatValue()) * this.f8571M) + this.f8607w);
            int iM10946m = m10946m();
            int i10 = this.f8610z;
            C13669a.m82225f(background, iM10922R - i10, iM10946m - i10, iM10922R + i10, iM10946m + i10);
        }
    }

    /* renamed from: j */
    public final Float m10940j(int i10) {
        float fM10944l = this.f8573O ? m10944l(20) : m10942k();
        if (i10 == 21) {
            if (!m10914J()) {
                fM10944l = -fM10944l;
            }
            return Float.valueOf(fM10944l);
        }
        if (i10 == 22) {
            if (m10914J()) {
                fM10944l = -fM10944l;
            }
            return Float.valueOf(fM10944l);
        }
        if (i10 == 69) {
            return Float.valueOf(-fM10944l);
        }
        if (i10 == 70 || i10 == 81) {
            return Float.valueOf(fM10944l);
        }
        return null;
    }

    /* renamed from: j0 */
    public final void m10941j0(int i10) {
        this.f8571M = Math.max(i10 - (this.f8607w * 2), 0);
        m10916L();
    }

    /* renamed from: k */
    public final float m10942k() {
        float f10 = this.f8568J;
        if (f10 == 0.0f) {
            return 1.0f;
        }
        return f10;
    }

    /* renamed from: k0 */
    public final void m10943k0() {
        if (this.f8574P) {
            m10949n0();
            m10951o0();
            m10947m0();
            m10953p0();
            m10945l0();
            m10959s0();
            this.f8574P = false;
        }
    }

    /* renamed from: l */
    public final float m10944l(int i10) {
        float fM10942k = m10942k();
        return (this.f8564F - this.f8563E) / fM10942k <= i10 ? fM10942k : Math.round(r1 / r2) * fM10942k;
    }

    /* renamed from: l0 */
    public final void m10945l0() {
        float minSeparation = getMinSeparation();
        if (minSeparation < 0.0f) {
            throw new IllegalStateException(String.format("minSeparation(%s) must be greater or equal to 0", Float.valueOf(minSeparation)));
        }
        float f10 = this.f8568J;
        if (f10 <= 0.0f || minSeparation <= 0.0f) {
            return;
        }
        if (this.f8587c0 != 1) {
            throw new IllegalStateException(String.format("minSeparation(%s) cannot be set as a dimension when using stepSize(%s)", Float.valueOf(minSeparation), Float.valueOf(this.f8568J)));
        }
        if (minSeparation < f10 || !m10913I(minSeparation)) {
            throw new IllegalStateException(String.format("minSeparation(%s) must be greater or equal and a multiple of stepSize(%s) when using stepSize(%s)", Float.valueOf(minSeparation), Float.valueOf(this.f8568J), Float.valueOf(this.f8568J)));
        }
    }

    /* renamed from: m */
    public final int m10946m() {
        return this.f8608x + ((this.f8605u == 1 || m10930b0()) ? this.f8595k.get(0).getIntrinsicHeight() : 0);
    }

    /* renamed from: m0 */
    public final void m10947m0() {
        if (this.f8568J > 0.0f && !m10955q0(this.f8564F)) {
            throw new IllegalStateException(String.format("The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range", Float.valueOf(this.f8568J), Float.valueOf(this.f8563E), Float.valueOf(this.f8564F)));
        }
    }

    /* renamed from: n */
    public final ValueAnimator m10948n(boolean z10) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(m10896B(z10 ? this.f8600p : this.f8599o, z10 ? 0.0f : 1.0f), z10 ? 1.0f : 0.0f);
        valueAnimatorOfFloat.setDuration(z10 ? 83L : 117L);
        valueAnimatorOfFloat.setInterpolator(z10 ? C13110a.f59601e : C13110a.f59599c);
        valueAnimatorOfFloat.addUpdateListener(new C1812b());
        return valueAnimatorOfFloat;
    }

    /* renamed from: n0 */
    public final void m10949n0() {
        if (this.f8563E >= this.f8564F) {
            throw new IllegalStateException(String.format("valueFrom(%s) must be smaller than valueTo(%s)", Float.valueOf(this.f8563E), Float.valueOf(this.f8564F)));
        }
    }

    /* renamed from: o */
    public final void m10950o() {
        if (this.f8595k.size() > this.f8565G.size()) {
            List<C11228a> listSubList = this.f8595k.subList(this.f8565G.size(), this.f8595k.size());
            for (C11228a c11228a : listSubList) {
                if (C9603h0.m59863S(this)) {
                    m10952p(c11228a);
                }
            }
            listSubList.clear();
        }
        while (this.f8595k.size() < this.f8565G.size()) {
            C11228a c11228aMo10969a = this.f8594j.mo10969a();
            this.f8595k.add(c11228aMo10969a);
            if (C9603h0.m59863S(this)) {
                m10938i(c11228aMo10969a);
            }
        }
        int i10 = this.f8595k.size() == 1 ? 0 : 1;
        Iterator<C11228a> it = this.f8595k.iterator();
        while (it.hasNext()) {
            it.next().m64020m0(i10);
        }
    }

    /* renamed from: o0 */
    public final void m10951o0() {
        if (this.f8564F <= this.f8563E) {
            throw new IllegalStateException(String.format("valueTo(%s) must be greater than valueFrom(%s)", Float.valueOf(this.f8564F), Float.valueOf(this.f8563E)));
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Iterator<C11228a> it = this.f8595k.iterator();
        while (it.hasNext()) {
            m10938i(it.next());
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        BaseSlider<S, L, T>.RunnableC1814d runnableC1814d = this.f8593i;
        if (runnableC1814d != null) {
            removeCallbacks(runnableC1814d);
        }
        this.f8598n = false;
        Iterator<C11228a> it = this.f8595k.iterator();
        while (it.hasNext()) {
            m10952p(it.next());
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f8574P) {
            m10943k0();
            m10916L();
        }
        super.onDraw(canvas);
        int iM10946m = m10946m();
        m10961u(canvas, this.f8571M, iM10946m);
        if (((Float) Collections.max(getValues())).floatValue() > this.f8563E) {
            m10960t(canvas, this.f8571M, iM10946m);
        }
        m10918N(canvas);
        if ((this.f8562D || isFocused() || m10930b0()) && isEnabled()) {
            m10917M(canvas, this.f8571M, iM10946m);
            if (this.f8566H != -1 || m10930b0()) {
                m10964x();
            } else {
                m10965y();
            }
        } else {
            m10965y();
        }
        m10963w(canvas, this.f8571M, iM10946m);
    }

    @Override // android.view.View
    public void onFocusChanged(boolean z10, int i10, Rect rect) {
        super.onFocusChanged(z10, i10, rect);
        if (z10) {
            m10966z(i10);
            this.f8591g.m66205I(this.f8567I);
        } else {
            this.f8566H = -1;
            this.f8591g.m66209b(this.f8567I);
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (!isEnabled()) {
            return super.onKeyDown(i10, keyEvent);
        }
        if (this.f8565G.size() == 1) {
            this.f8566H = 0;
        }
        if (this.f8566H == -1) {
            Boolean boolM10923S = m10923S(i10, keyEvent);
            return boolM10923S != null ? boolM10923S.booleanValue() : super.onKeyDown(i10, keyEvent);
        }
        this.f8573O |= keyEvent.isLongPress();
        Float fM10940j = m10940j(i10);
        if (fM10940j != null) {
            if (m10932d0(this.f8565G.get(this.f8566H).floatValue() + fM10940j.floatValue())) {
                m10939i0();
                postInvalidate();
            }
            return true;
        }
        if (i10 != 23) {
            if (i10 == 61) {
                if (keyEvent.hasNoModifiers()) {
                    return m10920P(1);
                }
                if (keyEvent.isShiftPressed()) {
                    return m10920P(-1);
                }
                return false;
            }
            if (i10 != 66) {
                return super.onKeyDown(i10, keyEvent);
            }
        }
        this.f8566H = -1;
        postInvalidate();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i10, KeyEvent keyEvent) {
        this.f8573O = false;
        return super.onKeyUp(i10, keyEvent);
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec(this.f8604t + ((this.f8605u == 1 || m10930b0()) ? this.f8595k.get(0).getIntrinsicHeight() : 0), 1073741824));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SliderState sliderState = (SliderState) parcelable;
        super.onRestoreInstanceState(sliderState.getSuperState());
        this.f8563E = sliderState.f8611a;
        this.f8564F = sliderState.f8612b;
        setValuesInternal(sliderState.f8613c);
        this.f8568J = sliderState.f8614d;
        if (sliderState.f8615e) {
            requestFocus();
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SliderState sliderState = new SliderState(super.onSaveInstanceState());
        sliderState.f8611a = this.f8563E;
        sliderState.f8612b = this.f8564F;
        sliderState.f8613c = new ArrayList<>(this.f8565G);
        sliderState.f8614d = this.f8568J;
        sliderState.f8615e = hasFocus();
        return sliderState;
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        m10941j0(i10);
        m10939i0();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        float x10 = motionEvent.getX();
        float f10 = (x10 - this.f8607w) / this.f8571M;
        this.f8585b0 = f10;
        float fMax = Math.max(0.0f, f10);
        this.f8585b0 = fMax;
        this.f8585b0 = Math.min(1.0f, fMax);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f8560B = x10;
            if (!m10912H()) {
                getParent().requestDisallowInterceptTouchEvent(true);
                if (mo10926W()) {
                    requestFocus();
                    this.f8562D = true;
                    m10935g0();
                    m10939i0();
                    invalidate();
                    m10924T();
                }
            }
        } else if (actionMasked == 1) {
            this.f8562D = false;
            MotionEvent motionEvent2 = this.f8561C;
            if (motionEvent2 != null && motionEvent2.getActionMasked() == 0 && Math.abs(this.f8561C.getX() - motionEvent.getX()) <= this.f8601q && Math.abs(this.f8561C.getY() - motionEvent.getY()) <= this.f8601q && mo10926W()) {
                m10924T();
            }
            if (this.f8566H != -1) {
                m10935g0();
                this.f8566H = -1;
                m10925U();
            }
            invalidate();
        } else if (actionMasked == 2) {
            if (!this.f8562D) {
                if (m10912H() && Math.abs(x10 - this.f8560B) < this.f8601q) {
                    return false;
                }
                getParent().requestDisallowInterceptTouchEvent(true);
                m10924T();
            }
            if (mo10926W()) {
                this.f8562D = true;
                m10935g0();
                m10939i0();
                invalidate();
            }
        }
        setPressed(this.f8562D);
        this.f8561C = MotionEvent.obtain(motionEvent);
        return true;
    }

    /* renamed from: p */
    public final void m10952p(C11228a c11228a) {
        InterfaceC1787r interfaceC1787rM10785f = C1788s.m10785f(this);
        if (interfaceC1787rM10785f != null) {
            interfaceC1787rM10785f.mo10779b(c11228a);
            c11228a.m67433w0(C1788s.m10784e(this));
        }
    }

    /* renamed from: p0 */
    public final void m10953p0() {
        Iterator<Float> it = this.f8565G.iterator();
        while (it.hasNext()) {
            Float next = it.next();
            if (next.floatValue() < this.f8563E || next.floatValue() > this.f8564F) {
                throw new IllegalStateException(String.format("Slider value(%s) must be greater or equal to valueFrom(%s), and lower or equal to valueTo(%s)", next, Float.valueOf(this.f8563E), Float.valueOf(this.f8564F)));
            }
            if (this.f8568J > 0.0f && !m10955q0(next.floatValue())) {
                throw new IllegalStateException(String.format("Value(%s) must be equal to valueFrom(%s) plus a multiple of stepSize(%s) when using stepSize(%s)", next, Float.valueOf(this.f8563E), Float.valueOf(this.f8568J), Float.valueOf(this.f8568J)));
            }
        }
    }

    /* renamed from: q */
    public final float m10954q(float f10) {
        if (f10 == 0.0f) {
            return 0.0f;
        }
        float f11 = (f10 - this.f8607w) / this.f8571M;
        float f12 = this.f8563E;
        return (f11 * (f12 - this.f8564F)) + f12;
    }

    /* renamed from: q0 */
    public final boolean m10955q0(float f10) {
        return m10913I(f10 - this.f8563E);
    }

    /* renamed from: r */
    public final void m10956r(int i10) {
        Iterator<L> it = this.f8596l.iterator();
        while (it.hasNext()) {
            it.next().m10979a(this, this.f8565G.get(i10).floatValue(), true);
        }
        AccessibilityManager accessibilityManager = this.f8592h;
        if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
            return;
        }
        m10928Z(i10);
    }

    /* renamed from: r0 */
    public final float m10957r0(float f10) {
        return (m10922R(f10) * this.f8571M) + this.f8607w;
    }

    /* renamed from: s */
    public final void m10958s() {
        for (L l10 : this.f8596l) {
            Iterator<Float> it = this.f8565G.iterator();
            while (it.hasNext()) {
                l10.m10979a(this, it.next().floatValue(), false);
            }
        }
    }

    /* renamed from: s0 */
    public final void m10959s0() {
        float f10 = this.f8568J;
        if (f10 == 0.0f) {
            return;
        }
        if (((int) f10) != f10) {
            Log.w(f8557d0, String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.", "stepSize", Float.valueOf(f10)));
        }
        float f11 = this.f8563E;
        if (((int) f11) != f11) {
            Log.w(f8557d0, String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.", "valueFrom", Float.valueOf(f11)));
        }
        float f12 = this.f8564F;
        if (((int) f12) != f12) {
            Log.w(f8557d0, String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.", "valueTo", Float.valueOf(f12)));
        }
    }

    public void setActiveThumbIndex(int i10) {
        this.f8566H = i10;
    }

    public void setCustomThumbDrawable(int i10) {
        setCustomThumbDrawable(getResources().getDrawable(i10));
    }

    public void setCustomThumbDrawablesForValues(int... iArr) {
        Drawable[] drawableArr = new Drawable[iArr.length];
        for (int i10 = 0; i10 < iArr.length; i10++) {
            drawableArr[i10] = getResources().getDrawable(iArr[i10]);
        }
        setCustomThumbDrawablesForValues(drawableArr);
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        setLayerType(z10 ? 0 : 2, null);
    }

    public void setFocusedThumbIndex(int i10) {
        if (i10 < 0 || i10 >= this.f8565G.size()) {
            throw new IllegalArgumentException("index out of range");
        }
        this.f8567I = i10;
        this.f8591g.m66205I(i10);
        postInvalidate();
    }

    public void setHaloRadius(int i10) {
        if (i10 == this.f8610z) {
            return;
        }
        this.f8610z = i10;
        Drawable background = getBackground();
        if (m10931c0() || !(background instanceof RippleDrawable)) {
            postInvalidate();
        } else {
            C14088a.m84431b((RippleDrawable) background, this.f8610z);
        }
    }

    public void setHaloRadiusResource(int i10) {
        setHaloRadius(getResources().getDimensionPixelSize(i10));
    }

    public void setHaloTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.f8575Q)) {
            return;
        }
        this.f8575Q = colorStateList;
        Drawable background = getBackground();
        if (!m10931c0() && (background instanceof RippleDrawable)) {
            ((RippleDrawable) background).setColor(colorStateList);
            return;
        }
        this.f8588d.setColor(m10908D(colorStateList));
        this.f8588d.setAlpha(63);
        invalidate();
    }

    public void setLabelBehavior(int i10) {
        if (this.f8605u != i10) {
            this.f8605u = i10;
            requestLayout();
        }
    }

    public void setLabelFormatter(InterfaceC1821c interfaceC1821c) {
    }

    public void setSeparationUnit(int i10) {
        this.f8587c0 = i10;
        this.f8574P = true;
        postInvalidate();
    }

    public void setStepSize(float f10) {
        if (f10 < 0.0f) {
            throw new IllegalArgumentException(String.format("The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range", Float.valueOf(f10), Float.valueOf(this.f8563E), Float.valueOf(this.f8564F)));
        }
        if (this.f8568J != f10) {
            this.f8568J = f10;
            this.f8574P = true;
            postInvalidate();
        }
    }

    public void setThumbElevation(float f10) {
        this.f8580V.m64001a0(f10);
    }

    public void setThumbElevationResource(int i10) {
        setThumbElevation(getResources().getDimension(i10));
    }

    public void setThumbRadius(int i10) {
        if (i10 == this.f8609y) {
            return;
        }
        this.f8609y = i10;
        m10919O();
        this.f8580V.setShapeAppearanceModel(C10432m.m64045a().m64096q(0, this.f8609y).m64093m());
        C10427h c10427h = this.f8580V;
        int i11 = this.f8609y;
        c10427h.setBounds(0, 0, i11 * 2, i11 * 2);
        Drawable drawable = this.f8581W;
        if (drawable != null) {
            m10936h(drawable);
        }
        Iterator<Drawable> it = this.f8583a0.iterator();
        while (it.hasNext()) {
            m10936h(it.next());
        }
        postInvalidate();
    }

    public void setThumbRadiusResource(int i10) {
        setThumbRadius(getResources().getDimensionPixelSize(i10));
    }

    public void setThumbStrokeColor(ColorStateList colorStateList) {
        this.f8580V.m64019l0(colorStateList);
        postInvalidate();
    }

    public void setThumbStrokeColorResource(int i10) {
        if (i10 != 0) {
            setThumbStrokeColor(C8968a.m56742a(getContext(), i10));
        }
    }

    public void setThumbStrokeWidth(float f10) {
        this.f8580V.m64020m0(f10);
        postInvalidate();
    }

    public void setThumbStrokeWidthResource(int i10) {
        if (i10 != 0) {
            setThumbStrokeWidth(getResources().getDimension(i10));
        }
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.f8580V.m64033x())) {
            return;
        }
        this.f8580V.m64002b0(colorStateList);
        invalidate();
    }

    public void setTickActiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.f8576R)) {
            return;
        }
        this.f8576R = colorStateList;
        this.f8590f.setColor(m10908D(colorStateList));
        invalidate();
    }

    public void setTickInactiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.f8577S)) {
            return;
        }
        this.f8577S = colorStateList;
        this.f8589e.setColor(m10908D(colorStateList));
        invalidate();
    }

    public void setTickTintList(ColorStateList colorStateList) {
        setTickInactiveTintList(colorStateList);
        setTickActiveTintList(colorStateList);
    }

    public void setTickVisible(boolean z10) {
        if (this.f8570L != z10) {
            this.f8570L = z10;
            postInvalidate();
        }
    }

    public void setTrackActiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.f8578T)) {
            return;
        }
        this.f8578T = colorStateList;
        this.f8584b.setColor(m10908D(colorStateList));
        invalidate();
    }

    public void setTrackHeight(int i10) {
        if (this.f8606v != i10) {
            this.f8606v = i10;
            m10911G();
            postInvalidate();
        }
    }

    public void setTrackInactiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.f8579U)) {
            return;
        }
        this.f8579U = colorStateList;
        this.f8582a.setColor(m10908D(colorStateList));
        invalidate();
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        setTrackInactiveTintList(colorStateList);
        setTrackActiveTintList(colorStateList);
    }

    public void setValueFrom(float f10) {
        this.f8563E = f10;
        this.f8574P = true;
        postInvalidate();
    }

    public void setValueTo(float f10) {
        this.f8564F = f10;
        this.f8574P = true;
        postInvalidate();
    }

    public void setValues(Float... fArr) {
        ArrayList<Float> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, fArr);
        setValuesInternal(arrayList);
    }

    /* renamed from: t */
    public final void m10960t(Canvas canvas, int i10, int i11) {
        float[] activeRange = getActiveRange();
        int i12 = this.f8607w;
        float f10 = i10;
        float f11 = i11;
        canvas.drawLine(i12 + (activeRange[0] * f10), f11, i12 + (activeRange[1] * f10), f11, this.f8584b);
    }

    /* renamed from: u */
    public final void m10961u(Canvas canvas, int i10, int i11) {
        float[] activeRange = getActiveRange();
        float f10 = i10;
        float f11 = this.f8607w + (activeRange[1] * f10);
        if (f11 < r1 + i10) {
            float f12 = i11;
            canvas.drawLine(f11, f12, r1 + i10, f12, this.f8582a);
        }
        int i12 = this.f8607w;
        float f13 = i12 + (activeRange[0] * f10);
        if (f13 > i12) {
            float f14 = i11;
            canvas.drawLine(i12, f14, f13, f14, this.f8582a);
        }
    }

    /* renamed from: v */
    public final void m10962v(Canvas canvas, int i10, int i11, float f10, Drawable drawable) {
        canvas.save();
        canvas.translate((this.f8607w + ((int) (m10922R(f10) * i10))) - (drawable.getBounds().width() / 2.0f), i11 - (drawable.getBounds().height() / 2.0f));
        drawable.draw(canvas);
        canvas.restore();
    }

    /* renamed from: w */
    public final void m10963w(Canvas canvas, int i10, int i11) {
        for (int i12 = 0; i12 < this.f8565G.size(); i12++) {
            float fFloatValue = this.f8565G.get(i12).floatValue();
            Drawable drawable = this.f8581W;
            if (drawable != null) {
                m10962v(canvas, i10, i11, fFloatValue, drawable);
            } else if (i12 < this.f8583a0.size()) {
                m10962v(canvas, i10, i11, fFloatValue, this.f8583a0.get(i12));
            } else {
                if (!isEnabled()) {
                    canvas.drawCircle(this.f8607w + (m10922R(fFloatValue) * i10), i11, this.f8609y, this.f8586c);
                }
                m10962v(canvas, i10, i11, fFloatValue, this.f8580V);
            }
        }
    }

    /* renamed from: x */
    public final void m10964x() {
        if (this.f8605u == 2) {
            return;
        }
        if (!this.f8598n) {
            this.f8598n = true;
            ValueAnimator valueAnimatorM10948n = m10948n(true);
            this.f8599o = valueAnimatorM10948n;
            this.f8600p = null;
            valueAnimatorM10948n.start();
        }
        Iterator<C11228a> it = this.f8595k.iterator();
        for (int i10 = 0; i10 < this.f8565G.size() && it.hasNext(); i10++) {
            if (i10 != this.f8567I) {
                m10929a0(it.next(), this.f8565G.get(i10).floatValue());
            }
        }
        if (!it.hasNext()) {
            throw new IllegalStateException(String.format("Not enough labels(%d) to display all the values(%d)", Integer.valueOf(this.f8595k.size()), Integer.valueOf(this.f8565G.size())));
        }
        m10929a0(it.next(), this.f8565G.get(this.f8567I).floatValue());
    }

    /* renamed from: y */
    public final void m10965y() {
        if (this.f8598n) {
            this.f8598n = false;
            ValueAnimator valueAnimatorM10948n = m10948n(false);
            this.f8600p = valueAnimatorM10948n;
            this.f8599o = null;
            valueAnimatorM10948n.addListener(new C1813c());
            this.f8600p.start();
        }
    }

    /* renamed from: z */
    public final void m10966z(int i10) {
        if (i10 == 1) {
            m10920P(Integer.MAX_VALUE);
            return;
        }
        if (i10 == 2) {
            m10920P(Integer.MIN_VALUE);
        } else if (i10 == 17) {
            m10921Q(Integer.MAX_VALUE);
        } else {
            if (i10 != 66) {
                return;
            }
            m10921Q(Integer.MIN_VALUE);
        }
    }

    /* renamed from: com.google.android.material.slider.BaseSlider$d */
    public class RunnableC1814d implements Runnable {

        /* renamed from: a */
        public int f8621a;

        public RunnableC1814d() {
            this.f8621a = -1;
        }

        /* renamed from: a */
        public void m10970a(int i10) {
            this.f8621a = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseSlider.this.f8591g.m66206J(this.f8621a, 4);
        }

        public /* synthetic */ RunnableC1814d(BaseSlider baseSlider, C1811a c1811a) {
            this();
        }
    }

    public BaseSlider(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.sliderStyle);
    }

    public void setCustomThumbDrawable(Drawable drawable) {
        this.f8581W = m10910F(drawable);
        this.f8583a0.clear();
        postInvalidate();
    }

    public BaseSlider(Context context, AttributeSet attributeSet, int i10) throws Resources.NotFoundException {
        super(C10981a.m66348c(context, attributeSet, i10, f8558e0), attributeSet, i10);
        this.f8595k = new ArrayList();
        this.f8596l = new ArrayList();
        this.f8597m = new ArrayList();
        this.f8598n = false;
        this.f8562D = false;
        this.f8565G = new ArrayList<>();
        this.f8566H = -1;
        this.f8567I = -1;
        this.f8568J = 0.0f;
        this.f8570L = true;
        this.f8573O = false;
        C10427h c10427h = new C10427h();
        this.f8580V = c10427h;
        this.f8583a0 = Collections.emptyList();
        this.f8587c0 = 0;
        Context context2 = getContext();
        Paint paint = new Paint();
        this.f8582a = paint;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        Paint.Cap cap = Paint.Cap.ROUND;
        paint.setStrokeCap(cap);
        Paint paint2 = new Paint();
        this.f8584b = paint2;
        paint2.setStyle(style);
        paint2.setStrokeCap(cap);
        Paint paint3 = new Paint(1);
        this.f8586c = paint3;
        Paint.Style style2 = Paint.Style.FILL;
        paint3.setStyle(style2);
        paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Paint paint4 = new Paint(1);
        this.f8588d = paint4;
        paint4.setStyle(style2);
        Paint paint5 = new Paint();
        this.f8589e = paint5;
        paint5.setStyle(style);
        paint5.setStrokeCap(cap);
        Paint paint6 = new Paint();
        this.f8590f = paint6;
        paint6.setStyle(style);
        paint6.setStrokeCap(cap);
        m10915K(context2.getResources());
        this.f8594j = new C1811a(attributeSet, i10);
        m10927Y(context2, attributeSet, i10);
        setFocusable(true);
        setClickable(true);
        c10427h.m64013i0(2);
        this.f8601q = ViewConfiguration.get(context2).getScaledTouchSlop();
        C1815e c1815e = new C1815e(this);
        this.f8591g = c1815e;
        C9603h0.m59902p0(this, c1815e);
        this.f8592h = (AccessibilityManager) getContext().getSystemService("accessibility");
    }

    public void setValues(List<Float> list) {
        setValuesInternal(new ArrayList<>(list));
    }

    public void setCustomThumbDrawablesForValues(Drawable... drawableArr) {
        this.f8581W = null;
        this.f8583a0 = new ArrayList();
        for (Drawable drawable : drawableArr) {
            this.f8583a0.add(m10910F(drawable));
        }
        postInvalidate();
    }
}
