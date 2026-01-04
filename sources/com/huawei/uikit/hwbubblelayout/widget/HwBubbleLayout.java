package com.huawei.uikit.hwbubblelayout.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import com.huawei.uikit.hwbubblelayout.C8703R;
import com.huawei.uikit.hwcolumnsystem.widget.HwColumnSystem;
import com.huawei.uikit.hwgraphiceffect.widget.HwShadowEngine;
import com.huawei.uikit.hwresources.utils.HwWidgetCompat;
import com.huawei.uikit.hwresources.utils.HwWidgetInstantiator;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes7.dex */
public class HwBubbleLayout extends FrameLayout {
    public static final int ARROW_START_NEGATIVE = 2;
    public static final int ARROW_START_POSITIVE = 1;

    /* renamed from: b0 */
    private static final String f41554b0 = "HwBubbleLayout";

    /* renamed from: c0 */
    private static final int f41555c0 = 1;

    /* renamed from: d0 */
    private static final int f41556d0 = 2;

    /* renamed from: e0 */
    private static final int f41557e0 = 4;

    /* renamed from: f0 */
    private static final int f41558f0 = 2;

    /* renamed from: g0 */
    private static final int f41559g0 = 2;

    /* renamed from: h0 */
    private static final int f41560h0 = -1;

    /* renamed from: i0 */
    private static final float f41561i0 = 0.5f;

    /* renamed from: j0 */
    private static final String f41562j0 = "arrow_position";

    /* renamed from: k0 */
    private static final String f41563k0 = "instanceState";

    /* renamed from: l0 */
    private static final int f41564l0 = 2;

    /* renamed from: m0 */
    private static final int f41565m0 = 2;

    /* renamed from: A */
    private float f41566A;

    /* renamed from: B */
    private boolean f41567B;

    /* renamed from: C */
    private int f41568C;

    /* renamed from: D */
    private int f41569D;

    /* renamed from: E */
    private int f41570E;

    /* renamed from: F */
    private int f41571F;

    /* renamed from: G */
    private int f41572G;

    /* renamed from: H */
    private int f41573H;

    /* renamed from: I */
    private int f41574I;

    /* renamed from: J */
    private int f41575J;

    /* renamed from: K */
    private int f41576K;

    /* renamed from: L */
    private int f41577L;

    /* renamed from: M */
    private int f41578M;

    /* renamed from: N */
    private int f41579N;

    /* renamed from: O */
    private int f41580O;

    /* renamed from: P */
    private int f41581P;

    /* renamed from: Q */
    private int f41582Q;

    /* renamed from: R */
    private int f41583R;

    /* renamed from: S */
    private int f41584S;

    /* renamed from: T */
    private int f41585T;

    /* renamed from: U */
    private int f41586U;

    /* renamed from: V */
    private int f41587V;

    /* renamed from: W */
    private Context f41588W;

    /* renamed from: a */
    private Paint f41589a;

    /* renamed from: a0 */
    private HwShadowEngine f41590a0;

    /* renamed from: b */
    private Paint f41591b;

    /* renamed from: c */
    private Path f41592c;

    /* renamed from: d */
    private ArrowDirection f41593d;

    /* renamed from: e */
    private int f41594e;

    /* renamed from: f */
    private boolean f41595f;

    /* renamed from: g */
    private int f41596g;

    /* renamed from: h */
    private boolean f41597h;

    /* renamed from: i */
    private int f41598i;

    /* renamed from: j */
    private int f41599j;

    /* renamed from: k */
    private int f41600k;

    /* renamed from: l */
    private int f41601l;

    /* renamed from: m */
    private int f41602m;

    /* renamed from: n */
    private int f41603n;

    /* renamed from: o */
    private int f41604o;

    /* renamed from: p */
    private int f41605p;

    /* renamed from: q */
    private int f41606q;

    /* renamed from: r */
    private int f41607r;

    /* renamed from: s */
    private int f41608s;

    /* renamed from: t */
    private boolean f41609t;

    /* renamed from: u */
    private boolean f41610u;

    /* renamed from: v */
    private boolean f41611v;

    /* renamed from: w */
    private HwColumnSystem f41612w;

    /* renamed from: x */
    private boolean f41613x;

    /* renamed from: y */
    private int f41614y;

    /* renamed from: z */
    private int f41615z;

    public enum ArrowDirection {
        TOP(2),
        BOTTOM(4);


        /* renamed from: a */
        int f41617a;

        ArrowDirection(int i10) {
            this.f41617a = i10;
        }

        public static ArrowDirection getDirection(int i10) {
            return i10 != 2 ? BOTTOM : TOP;
        }
    }

    public static /* synthetic */ class aauaf {

        /* renamed from: a */
        static final /* synthetic */ int[] f41618a;

        static {
            int[] iArr = new int[ArrowDirection.values().length];
            f41618a = iArr;
            try {
                iArr[ArrowDirection.BOTTOM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f41618a[ArrowDirection.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public class bzrwd extends ViewOutlineProvider {
        public bzrwd() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            if (outline != null) {
                outline.setRoundRect(HwBubbleLayout.this.f41602m, HwBubbleLayout.this.f41603n, HwBubbleLayout.this.f41604o, HwBubbleLayout.this.f41605p, HwBubbleLayout.this.f41606q);
            }
        }
    }

    public HwBubbleLayout(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    private boolean m54066a(int i10, int i11, float f10) {
        return i10 > 0 && i11 > 0 && f10 > 0.0f;
    }

    private void getAxisOffset() {
        this.f41570E = getResources().getDimensionPixelSize(C8703R.dimen.hwbubblelayout_bezier_offset_x2);
        this.f41571F = getResources().getDimensionPixelSize(C8703R.dimen.hwbubblelayout_bezier_offset_y2);
        this.f41572G = getResources().getDimensionPixelSize(C8703R.dimen.hwbubblelayout_bezier_offset_x3);
        this.f41573H = getResources().getDimensionPixelSize(C8703R.dimen.hwbubblelayout_bezier_offset_y3);
        this.f41574I = getResources().getDimensionPixelSize(C8703R.dimen.hwbubblelayout_bezier_offset_x4);
        this.f41575J = getResources().getDimensionPixelSize(C8703R.dimen.hwbubblelayout_bezier_offset_y4);
        this.f41576K = getResources().getDimensionPixelSize(C8703R.dimen.hwbubblelayout_bezier_offset_x5);
        this.f41577L = getResources().getDimensionPixelSize(C8703R.dimen.hwbubblelayout_bezier_offset_y5);
        this.f41578M = getResources().getDimensionPixelSize(C8703R.dimen.hwbubblelayout_bezier_offset_x6);
        this.f41579N = getResources().getDimensionPixelSize(C8703R.dimen.hwbubblelayout_bezier_offset_y6);
        this.f41580O = getResources().getDimensionPixelSize(C8703R.dimen.hwbubblelayout_bezier_offset_x7);
        this.f41581P = getResources().getDimensionPixelSize(C8703R.dimen.hwbubblelayout_bezier_offset_y7);
        this.f41582Q = getResources().getDimensionPixelSize(C8703R.dimen.hwbubblelayout_bezier_offset_x8);
        this.f41583R = getResources().getDimensionPixelSize(C8703R.dimen.hwbubblelayout_bezier_offset_y8);
        this.f41584S = getResources().getDimensionPixelSize(C8703R.dimen.hwbubblelayout_bezier_offset_x9);
        this.f41585T = getResources().getDimensionPixelSize(C8703R.dimen.hwbubblelayout_bezier_offset_y9);
    }

    public static HwBubbleLayout instantiate(Context context) throws ClassNotFoundException {
        Object objInstantiate = HwWidgetInstantiator.instantiate(context, HwWidgetInstantiator.getDeviceClassName(context, HwBubbleLayout.class, HwWidgetInstantiator.getCurrentType(context, 1, 1)), HwBubbleLayout.class);
        if (objInstantiate instanceof HwBubbleLayout) {
            return (HwBubbleLayout) objInstantiate;
        }
        return null;
    }

    public void configureColumn(int i10, int i11, float f10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (!m54066a(i10, i11, f10)) {
            if (this.f41613x) {
                this.f41613x = false;
                m54070b(getContext());
                m54065a((ViewGroup) this);
                return;
            }
            return;
        }
        this.f41613x = true;
        this.f41614y = i10;
        this.f41615z = i11;
        this.f41566A = f10;
        m54070b(getContext());
        m54065a((ViewGroup) this);
    }

    public ArrowDirection getArrowDirection() {
        return this.f41593d;
    }

    public int getArrowPosition() {
        return this.f41594e;
    }

    public int getBubbleColor() {
        return this.f41608s;
    }

    public int getBubbleRadius() {
        return this.f41606q;
    }

    public int getBubbleWidth() {
        return ((this.f41600k - this.f41598i) - (this.f41606q * 2)) + (this.f41586U * 2);
    }

    public int getShadowSize() {
        if (this.f41590a0 == null) {
            return -1;
        }
        return this.f41569D;
    }

    public int getShadowStyle() {
        if (this.f41590a0 == null) {
            return -1;
        }
        return this.f41568C;
    }

    public int isArrowDrawPositive() {
        return this.f41596g;
    }

    public boolean isArrowPositionCenter() {
        return this.f41595f;
    }

    public boolean isShadowEnabled() {
        return this.f41567B;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onConfigurationChanged(configuration);
        if (this.f41613x) {
            this.f41612w.setColumnType(4);
            this.f41612w.updateConfigation(this.f41588W, this.f41614y, this.f41615z, this.f41566A);
        } else {
            this.f41612w.setColumnType(4);
            this.f41612w.updateConfigation(this.f41588W);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (canvas == null) {
            return;
        }
        super.onDraw(canvas);
        canvas.drawPath(this.f41592c, this.f41589a);
        if (this.f41609t) {
            canvas.drawPath(this.f41592c, this.f41591b);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (this.f41610u) {
            m54070b(getContext());
            int size = View.MeasureSpec.getSize(i10);
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(m54071c(size), View.MeasureSpec.getMode(i10)), i11);
        } else {
            super.onMeasure(i10, i11);
        }
        int measuredHeight = getMeasuredHeight();
        int measuredWidth = getMeasuredWidth();
        int iM54059a = m54059a(this.f41588W);
        if (iM54059a > measuredWidth) {
            setMeasuredDimension(iM54059a, measuredHeight);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        try {
            if (bundle.containsKey(f41562j0)) {
                this.f41594e = bundle.getInt(f41562j0, 0);
            }
            Parcelable parcelable2 = bundle.getParcelable(f41563k0);
            if (parcelable2 != null) {
                super.onRestoreInstanceState(parcelable2);
            }
        } catch (BadParcelableException unused) {
            Log.e(f41554b0, "Parcelable, onRestoreInstanceState error.");
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        try {
            bundle.putParcelable(f41563k0, super.onSaveInstanceState());
            bundle.putInt(f41562j0, this.f41594e);
        } catch (BadParcelableException unused) {
            Log.e(f41554b0, "Parcelable, HwBubbleLayout onSaveInstanceState error");
        }
        return bundle;
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.f41600k = i10;
        this.f41601l = i11;
        m54069b();
    }

    public void setArrowDirection(ArrowDirection arrowDirection) {
        this.f41593d = arrowDirection;
        m54073c();
        m54069b();
    }

    public void setArrowPosition(int i10) {
        this.f41594e = i10;
        m54069b();
        invalidate();
    }

    public void setArrowPositionCenter(boolean z10) {
        this.f41595f = z10;
        m54069b();
    }

    public void setArrowStartLocation(int i10) {
        if (this.f41596g == i10) {
            return;
        }
        this.f41596g = i10;
        m54069b();
        invalidate();
    }

    public void setBubbleColor(int i10) {
        this.f41608s = i10;
        m54069b();
    }

    public void setInsideShadowClip(boolean z10) {
        HwShadowEngine hwShadowEngine = this.f41590a0;
        if (hwShadowEngine != null) {
            hwShadowEngine.setInsideShadowClip(z10);
        }
    }

    public void setShadowEnabled(boolean z10) {
        this.f41567B = z10;
        if (this.f41590a0 == null) {
            this.f41590a0 = new HwShadowEngine(this.f41588W, this, this.f41569D, this.f41568C);
        }
        this.f41590a0.setShadowEnabled(this.f41567B);
    }

    public void setShadowSize(int i10) {
        if (this.f41569D == i10) {
            return;
        }
        this.f41569D = i10;
        HwShadowEngine hwShadowEngine = this.f41590a0;
        if (hwShadowEngine != null) {
            hwShadowEngine.setShadowSize(i10);
            if (this.f41567B) {
                this.f41590a0.refreshShadowEffects();
            }
        }
    }

    public void setShadowStyle(int i10) {
        if (this.f41568C == i10) {
            return;
        }
        this.f41568C = i10;
        HwShadowEngine hwShadowEngine = this.f41590a0;
        if (hwShadowEngine != null) {
            hwShadowEngine.setShadowStyle(i10);
            if (this.f41567B) {
                this.f41590a0.refreshShadowEffects();
            }
        }
    }

    public HwBubbleLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C8703R.attr.hwBubbleLayoutStyle);
    }

    /* renamed from: b */
    private void m54070b(Context context) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (this.f41613x) {
            m54074c(context);
        } else {
            m54076d(context);
        }
    }

    /* renamed from: c */
    private void m54073c() {
        if (aauaf.f41618a[this.f41593d.ordinal()] != 1) {
            setPadding(0, this.f41599j, 0, 0);
        } else {
            setPadding(0, 0, 0, this.f41599j);
        }
    }

    /* renamed from: d */
    private void m54076d(Context context) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.f41612w.setColumnType(4);
        this.f41612w.updateConfigation(context);
    }

    public HwBubbleLayout(Context context, AttributeSet attributeSet, int i10) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException, InvocationTargetException {
        super(m54062a(context, i10), attributeSet, i10);
        this.f41596g = 1;
        this.f41597h = false;
        this.f41609t = false;
        this.f41610u = false;
        this.f41613x = false;
        this.f41588W = getContext();
        HwColumnSystem hwColumnSystem = new HwColumnSystem(this.f41588W);
        this.f41612w = hwColumnSystem;
        hwColumnSystem.setColumnType(4);
        this.f41613x = false;
        this.f41612w.updateConfigation(this.f41588W);
        setWillNotDraw(false);
        m54064a(this.f41588W.obtainStyledAttributes(attributeSet, C8703R.styleable.HwBubbleLayout, i10, C8703R.style.Widget_Emui_HwBubbleLayout));
        Paint paint = new Paint(5);
        this.f41589a = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f41592c = new Path();
        m54073c();
        if (this.f41611v) {
            setMinimumWidth(this.f41612w.getMinColumnWidth());
        }
    }

    /* renamed from: a */
    private static Context m54062a(Context context, int i10) {
        return HwWidgetCompat.wrapContext(context, i10, C8703R.style.Theme_Emui_HwBubbleLayout);
    }

    /* renamed from: a */
    private void m54064a(TypedArray typedArray) throws Resources.NotFoundException {
        this.f41593d = ArrowDirection.getDirection(typedArray.getInt(C8703R.styleable.HwBubbleLayout_hwArrowDirection, ArrowDirection.BOTTOM.f41617a));
        this.f41594e = typedArray.getDimensionPixelSize(C8703R.styleable.HwBubbleLayout_hwArrowPosition, -1);
        this.f41595f = typedArray.getBoolean(C8703R.styleable.HwBubbleLayout_hwArrowPositionCenter, false);
        if (this.f41594e < 0) {
            this.f41595f = true;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(C8703R.dimen.emui_corner_radius_large);
        this.f41607r = dimensionPixelSize;
        this.f41606q = typedArray.getDimensionPixelSize(C8703R.styleable.HwBubbleLayout_hwBubbleRadius, dimensionPixelSize);
        this.f41596g = typedArray.getInt(C8703R.styleable.HwBubbleLayout_hwArrowStartLocation, 1);
        this.f41608s = typedArray.getColor(C8703R.styleable.HwBubbleLayout_hwBubbleColor, getResources().getColor(C8703R.color.emui_color_tooltips_bg));
        this.f41610u = typedArray.getBoolean(C8703R.styleable.HwBubbleLayout_hwColumnEnabled, false);
        this.f41567B = typedArray.getBoolean(C8703R.styleable.HwBubbleLayout_hwShadowEnabled, false);
        this.f41611v = typedArray.getBoolean(C8703R.styleable.HwBubbleLayout_hwBubbleIsSpaciousStyle, false);
        this.f41568C = typedArray.getInt(C8703R.styleable.HwBubbleLayout_hwWidgetStyle, 0);
        this.f41569D = typedArray.getInt(C8703R.styleable.HwBubbleLayout_hwShadowSize, 2);
        typedArray.recycle();
        HwShadowEngine hwShadowEngine = new HwShadowEngine(this.f41588W, this, this.f41569D, this.f41568C);
        this.f41590a0 = hwShadowEngine;
        hwShadowEngine.setShadowEnabled(this.f41567B);
        double dSqrt = (2.0d - Math.sqrt(2.0d)) * 2.0d;
        int i10 = this.f41606q;
        int i11 = (int) (dSqrt * i10);
        this.f41587V = i11;
        this.f41586U -= i11 - i10;
        this.f41598i = getResources().getDimensionPixelSize(C8703R.dimen.hwbubblelayout_default_arrow_width);
        this.f41599j = getResources().getDimensionPixelSize(C8703R.dimen.hwbubblelayout_default_arrow_height);
        getAxisOffset();
        boolean z10 = this.f41588W.getResources().getBoolean(C8703R.bool.emui_stroke_enable);
        this.f41609t = z10;
        if (z10) {
            int dimensionPixelSize2 = this.f41588W.getResources().getDimensionPixelSize(C8703R.dimen.emui_popup_type_stroke_width);
            if (dimensionPixelSize2 > 0) {
                Paint paint = new Paint(5);
                this.f41591b = paint;
                paint.setStyle(Paint.Style.STROKE);
                this.f41591b.setColor(getContext().getResources().getColor(C8703R.color.emui_stroke_color));
                this.f41591b.setStrokeWidth(dimensionPixelSize2);
                return;
            }
            this.f41609t = false;
        }
    }

    /* renamed from: d */
    private boolean m54077d() {
        return getLayoutDirection() == 1;
    }

    /* renamed from: b */
    private void m54069b() {
        Path pathM54063a;
        if (this.f41590a0 == null) {
            HwShadowEngine hwShadowEngine = new HwShadowEngine(this.f41588W, this, this.f41569D, this.f41568C);
            this.f41590a0 = hwShadowEngine;
            hwShadowEngine.setShadowEnabled(this.f41567B);
        }
        this.f41602m = 0;
        ArrowDirection arrowDirection = this.f41593d;
        this.f41603n = arrowDirection == ArrowDirection.TOP ? this.f41599j : 0;
        this.f41604o = this.f41600k;
        this.f41605p = this.f41601l - (arrowDirection == ArrowDirection.BOTTOM ? this.f41599j : 0);
        this.f41589a.setColor(this.f41608s);
        this.f41592c.reset();
        if (this.f41597h) {
            int i10 = this.f41604o - this.f41602m;
            int i11 = this.f41606q;
            int i12 = (i10 - i11) - i11;
            if (this.f41598i > i12) {
                this.f41598i = i12;
                this.f41595f = true;
            }
        }
        int i13 = aauaf.f41618a[this.f41593d.ordinal()];
        if (i13 == 1) {
            pathM54063a = m54063a(m54058a());
        } else if (i13 != 2) {
            pathM54063a = new Path();
        } else {
            pathM54063a = m54068b(m54058a());
        }
        RectF rectF = new RectF(this.f41602m, this.f41603n, this.f41604o, this.f41605p);
        Path path = this.f41592c;
        float f10 = this.f41606q;
        path.addRoundRect(rectF, f10, f10, Path.Direction.CW);
        this.f41592c.op(pathM54063a, Path.Op.UNION);
        this.f41592c.close();
        pathM54063a.close();
        setOutlineProvider(new bzrwd());
        setClipToOutline(false);
    }

    /* renamed from: c */
    private void m54074c(Context context) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.f41612w.setColumnType(4);
        this.f41612w.updateConfigation(context, this.f41614y, this.f41615z, this.f41566A);
    }

    /* renamed from: c */
    private int m54071c(int i10) {
        if (this.f41611v) {
            return Math.min(this.f41612w.getMaxColumnWidth(), i10);
        }
        return Math.min(this.f41612w.getSuggestWidth(), i10);
    }

    /* renamed from: b */
    private Path m54068b(int i10) {
        Path path = new Path();
        if (m54077d()) {
            int i11 = (this.f41604o - i10) + this.f41602m;
            path.moveTo(i11, this.f41603n);
            path.quadTo(i11 - this.f41578M, this.f41603n, i11 - this.f41570E, r2 - this.f41571F);
            float f10 = i11 - this.f41580O;
            int i12 = this.f41603n;
            path.quadTo(f10, i12 - this.f41581P, i11 - this.f41572G, i12 - this.f41573H);
            float f11 = i11 - this.f41582Q;
            int i13 = this.f41603n;
            path.quadTo(f11, i13 - this.f41583R, i11 - this.f41574I, i13 - this.f41575J);
            float f12 = i11 - this.f41584S;
            float f13 = this.f41603n;
            path.quadTo(f12, f13, i11 - this.f41576K, f13);
        } else {
            path.moveTo(i10, this.f41603n);
            path.quadTo(this.f41578M + i10, this.f41603n, this.f41570E + i10, r2 - this.f41571F);
            float f14 = this.f41580O + i10;
            int i14 = this.f41603n;
            path.quadTo(f14, i14 - this.f41581P, this.f41572G + i10, i14 - this.f41573H);
            float f15 = this.f41582Q + i10;
            int i15 = this.f41603n;
            path.quadTo(f15, i15 - this.f41583R, this.f41574I + i10, i15 - this.f41575J);
            float f16 = this.f41584S + i10;
            float f17 = this.f41603n;
            path.quadTo(f16, f17, i10 + this.f41576K, f17);
        }
        return path;
    }

    /* renamed from: a */
    private void m54065a(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        if (childCount == 0) {
            viewGroup.requestLayout();
            viewGroup.invalidate();
            return;
        }
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if (childAt instanceof ViewGroup) {
                m54065a((ViewGroup) childAt);
            } else if (childAt != null) {
                childAt.requestLayout();
                childAt.invalidate();
            }
        }
    }

    /* renamed from: a */
    private int m54058a() {
        int i10 = this.f41594e;
        int i11 = this.f41602m;
        int i12 = this.f41606q;
        int i13 = this.f41586U;
        int i14 = ((i10 + i11) + i12) - i13;
        if (this.f41595f) {
            return (((this.f41604o - i11) / 2) - (this.f41598i / 2)) + i11;
        }
        if (this.f41596g == 1) {
            int i15 = this.f41598i;
            int i16 = i14 + i15;
            int i17 = this.f41604o;
            return i16 > (i17 - i12) + i13 ? ((i17 - i15) - i12) + i13 : i14;
        }
        int i18 = (((this.f41604o - i12) - this.f41598i) - i10) + i13;
        int i19 = (i11 + i12) - i13;
        return i18 < i19 ? i19 : i18;
    }

    /* renamed from: a */
    private Path m54063a(int i10) {
        Path path = new Path();
        if (m54077d()) {
            int i11 = (this.f41604o - i10) + this.f41602m;
            path.moveTo(i11, this.f41605p);
            path.quadTo(i11 - this.f41578M, this.f41605p, i11 - this.f41570E, r2 + this.f41571F);
            float f10 = i11 - this.f41580O;
            int i12 = this.f41605p;
            path.quadTo(f10, this.f41581P + i12, i11 - this.f41572G, i12 + this.f41573H);
            float f11 = i11 - this.f41582Q;
            int i13 = this.f41605p;
            path.quadTo(f11, this.f41583R + i13, i11 - this.f41574I, i13 + this.f41575J);
            float f12 = i11 - this.f41584S;
            float f13 = this.f41605p;
            path.quadTo(f12, f13, i11 - this.f41576K, f13);
        } else {
            path.moveTo(i10, this.f41605p);
            path.quadTo(this.f41578M + i10, this.f41605p, this.f41570E + i10, r2 + this.f41571F);
            float f14 = this.f41580O + i10;
            int i14 = this.f41605p;
            path.quadTo(f14, this.f41581P + i14, this.f41572G + i10, i14 + this.f41573H);
            float f15 = this.f41582Q + i10;
            int i15 = this.f41605p;
            path.quadTo(f15, this.f41583R + i15, this.f41574I + i10, i15 + this.f41575J);
            float f16 = this.f41584S + i10;
            float f17 = this.f41605p;
            path.quadTo(f16, f17, i10 + this.f41576K, f17);
        }
        return path;
    }

    /* renamed from: a */
    private int m54059a(Context context) {
        if (context == null) {
            return 0;
        }
        int suggestWidth = ((this.f41612w.getSuggestWidth() - (this.f41606q * 2)) - this.f41598i) + (this.f41586U * 2);
        if (!this.f41610u || suggestWidth < 0) {
            suggestWidth = (this.f41586U * 2) + ((context.getResources().getDisplayMetrics().widthPixels - (this.f41606q * 2)) - this.f41598i);
        }
        if (this.f41594e > suggestWidth) {
            this.f41594e = suggestWidth;
        }
        return (((this.f41606q * 2) + this.f41598i) + this.f41594e) - (this.f41586U * 2);
    }

    /* renamed from: a */
    private int m54060a(Context context, float f10) {
        if (context == null) {
            return 0;
        }
        return (int) ((f10 * context.getResources().getDisplayMetrics().density) + f41561i0);
    }
}
