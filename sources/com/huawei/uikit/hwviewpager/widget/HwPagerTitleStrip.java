package com.huawei.uikit.hwviewpager.widget;

import android.R;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.text.method.SingleLineTransformationMethod;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import com.huawei.uikit.hwviewpager.widget.HwViewPager;
import java.lang.ref.WeakReference;
import java.util.Locale;

@HwViewPager.DecorView
/* loaded from: classes9.dex */
public class HwPagerTitleStrip extends ViewGroup {

    /* renamed from: o */
    private static final String f44635o = "HwPagerTitleStrip";

    /* renamed from: p */
    private static final int[] f44636p = {R.attr.textAllCaps};

    /* renamed from: q */
    private static final int[] f44637q = {R.attr.textAppearance, R.attr.textSize, R.attr.textColor, R.attr.gravity};

    /* renamed from: r */
    private static final int f44638r = 2;

    /* renamed from: s */
    private static final float f44639s = 0.5f;

    /* renamed from: t */
    private static final float f44640t = 0.8f;

    /* renamed from: u */
    private static final float f44641u = 0.6f;

    /* renamed from: v */
    private static final int f44642v = 16;

    /* renamed from: a */
    HwViewPager f44643a;

    /* renamed from: b */
    TextView f44644b;

    /* renamed from: c */
    TextView f44645c;

    /* renamed from: d */
    TextView f44646d;

    /* renamed from: e */
    int f44647e;

    /* renamed from: f */
    private int f44648f;

    /* renamed from: g */
    float f44649g;

    /* renamed from: h */
    private int f44650h;

    /* renamed from: i */
    private int f44651i;

    /* renamed from: j */
    private boolean f44652j;

    /* renamed from: k */
    private boolean f44653k;

    /* renamed from: l */
    private final bzrwd f44654l;

    /* renamed from: m */
    private WeakReference<HwPagerAdapter> f44655m;

    /* renamed from: n */
    private int f44656n;

    public static class aauaf extends SingleLineTransformationMethod {

        /* renamed from: a */
        private Locale f44657a;

        public aauaf(Context context) {
            this.f44657a = context.getResources().getConfiguration().locale;
        }

        @Override // android.text.method.ReplacementTransformationMethod, android.text.method.TransformationMethod
        public CharSequence getTransformation(CharSequence charSequence, View view) {
            CharSequence transformation = super.getTransformation(charSequence, view);
            if (transformation != null) {
                return transformation.toString().toUpperCase(this.f44657a);
            }
            return null;
        }
    }

    public class bzrwd extends DataSetObserver implements HwViewPager.OnPageChangeListener, HwViewPager.OnAdapterChangeListener {

        /* renamed from: a */
        private int f44658a;

        public bzrwd() {
        }

        @Override // com.huawei.uikit.hwviewpager.widget.HwViewPager.OnAdapterChangeListener
        public void onAdapterChanged(HwViewPager hwViewPager, HwPagerAdapter hwPagerAdapter, HwPagerAdapter hwPagerAdapter2) {
            HwPagerTitleStrip.this.m55796a(hwPagerAdapter, hwPagerAdapter2);
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            HwPagerTitleStrip hwPagerTitleStrip = HwPagerTitleStrip.this;
            hwPagerTitleStrip.m55795a(hwPagerTitleStrip.f44643a.getCurrentItem(), HwPagerTitleStrip.this.f44643a.getAdapter());
            float f10 = Float.compare(HwPagerTitleStrip.this.f44649g, 0.0f) >= 0 ? HwPagerTitleStrip.this.f44649g : 0.0f;
            HwPagerTitleStrip hwPagerTitleStrip2 = HwPagerTitleStrip.this;
            hwPagerTitleStrip2.mo55784a(hwPagerTitleStrip2.f44643a.getCurrentItem(), f10, true);
        }

        @Override // com.huawei.uikit.hwviewpager.widget.HwViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i10) {
            this.f44658a = i10;
        }

        @Override // com.huawei.uikit.hwviewpager.widget.HwViewPager.OnPageChangeListener
        public void onPageScrolled(int i10, float f10, int i11) {
            if (f10 > HwPagerTitleStrip.f44639s) {
                i10++;
            }
            HwPagerTitleStrip.this.mo55784a(i10, f10, false);
        }

        @Override // com.huawei.uikit.hwviewpager.widget.HwViewPager.OnPageChangeListener
        public void onPageSelected(int i10) {
            if (this.f44658a == 0) {
                HwPagerTitleStrip hwPagerTitleStrip = HwPagerTitleStrip.this;
                hwPagerTitleStrip.m55795a(hwPagerTitleStrip.f44643a.getCurrentItem(), HwPagerTitleStrip.this.f44643a.getAdapter());
                float f10 = Float.compare(HwPagerTitleStrip.this.f44649g, 0.0f) >= 0 ? HwPagerTitleStrip.this.f44649g : 0.0f;
                HwPagerTitleStrip hwPagerTitleStrip2 = HwPagerTitleStrip.this;
                hwPagerTitleStrip2.mo55784a(hwPagerTitleStrip2.f44643a.getCurrentItem(), f10, true);
            }
        }
    }

    public HwPagerTitleStrip(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    private float m55785a(float f10) {
        float f11 = f10 + f44639s;
        return f11 > 1.0f ? f11 - 1.0f : f11;
    }

    /* renamed from: b */
    private void m55793b(float f10, int i10, int i11) {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int measuredHeight = this.f44645c.getMeasuredHeight();
        int i12 = measuredHeight / 2;
        float fM55785a = m55785a(f10);
        boolean zIsRtlLayout = this.f44643a.isRtlLayout();
        int i13 = ((i11 - (paddingBottom + i12)) - ((int) (((i11 - (paddingTop + i12)) - r7) * fM55785a))) - i12;
        int i14 = measuredHeight + i13;
        int iMax = Math.max(Math.max(this.f44644b.getMeasuredWidth(), this.f44645c.getMeasuredWidth()), this.f44646d.getMeasuredWidth());
        int i15 = this.f44651i & 7;
        if (i15 == 1) {
            paddingLeft = (((i10 - paddingLeft) - paddingRight) - iMax) / 2;
        } else if (i15 == 5) {
            paddingLeft = zIsRtlLayout ? paddingRight : (i10 - paddingRight) - iMax;
        } else if (zIsRtlLayout) {
            paddingLeft = (i10 - iMax) - paddingLeft;
        }
        TextView textView = this.f44645c;
        textView.layout(paddingLeft, i13, textView.getMeasuredWidth() + paddingLeft, i14);
        int measuredHeight2 = this.f44644b.getMeasuredHeight();
        int iMin = Math.min(paddingTop, (i13 - this.f44650h) - measuredHeight2);
        TextView textView2 = this.f44644b;
        textView2.layout(paddingLeft, iMin, textView2.getMeasuredWidth() + paddingLeft, measuredHeight2 + iMin);
        int measuredHeight3 = this.f44646d.getMeasuredHeight();
        int iMax2 = Math.max((i11 - paddingBottom) - measuredHeight3, i14 + this.f44650h);
        TextView textView3 = this.f44646d;
        textView3.layout(paddingLeft, iMax2, textView3.getMeasuredWidth() + paddingLeft, measuredHeight3 + iMax2);
    }

    private static void setSingleLineAllCaps(TextView textView) {
        textView.setTransformationMethod(new aauaf(textView.getContext()));
    }

    public int getMinHeight() {
        Drawable background = getBackground();
        if (background != null) {
            return background.getIntrinsicHeight();
        }
        return 0;
    }

    public int getMinWidth() {
        Drawable background = getBackground();
        if (background != null) {
            return background.getIntrinsicWidth();
        }
        return 0;
    }

    public int getTextSpacing() {
        return this.f44650h;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (!(parent instanceof HwViewPager)) {
            throw new IllegalStateException("HwPagerTitleStrip must be a direct child of a ViewPager.");
        }
        HwViewPager hwViewPager = (HwViewPager) parent;
        HwPagerAdapter adapter = hwViewPager.getAdapter();
        hwViewPager.m55915a(this.f44654l);
        hwViewPager.addOnAdapterChangeListener(this.f44654l);
        this.f44643a = hwViewPager;
        if (hwViewPager.getPageScrollDirection() == 0) {
            setGravity(80);
        } else {
            setGravity(1);
        }
        WeakReference<HwPagerAdapter> weakReference = this.f44655m;
        m55796a(weakReference != null ? weakReference.get() : null, adapter);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        HwViewPager hwViewPager = this.f44643a;
        if (hwViewPager != null) {
            m55796a(hwViewPager.getAdapter(), (HwPagerAdapter) null);
            this.f44643a.m55915a((HwViewPager.OnPageChangeListener) null);
            this.f44643a.removeOnAdapterChangeListener(this.f44654l);
            this.f44643a = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        if (this.f44643a != null) {
            mo55784a(this.f44648f, Float.compare(this.f44649g, 0.0f) >= 0 ? this.f44649g : 0.0f, true);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        HwViewPager hwViewPager = this.f44643a;
        if (hwViewPager == null || hwViewPager.getPageScrollDirection() == 0) {
            m55791a(i10, i11);
        } else {
            m55794b(i10, i11);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.f44652j) {
            return;
        }
        super.requestLayout();
    }

    public void setGravity(int i10) {
        this.f44651i = i10;
        requestLayout();
    }

    public void setNonPrimaryAlpha(float f10) {
        int i10 = ((int) (f10 * 255.0f)) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA;
        this.f44656n = i10;
        int i11 = (i10 << 24) | (this.f44647e & 16777215);
        this.f44644b.setTextColor(i11);
        this.f44646d.setTextColor(i11);
    }

    public void setTextColor(int i10) {
        this.f44647e = i10;
        this.f44645c.setTextColor(i10);
        int i11 = (this.f44656n << 24) | (this.f44647e & 16777215);
        this.f44644b.setTextColor(i11);
        this.f44646d.setTextColor(i11);
    }

    public void setTextSize(int i10, float f10) {
        this.f44644b.setTextSize(i10, f10);
        this.f44645c.setTextSize(i10, f10);
        this.f44646d.setTextSize(i10, f10);
    }

    public void setTextSpacing(int i10) {
        this.f44650h = i10;
        requestLayout();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public HwPagerTitleStrip(android.content.Context r5, android.util.AttributeSet r6) throws android.content.res.Resources.NotFoundException {
        /*
            r4 = this;
            r4.<init>(r5, r6)
            r0 = -1
            r4.f44648f = r0
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            r4.f44649g = r0
            com.huawei.uikit.hwviewpager.widget.HwPagerTitleStrip$bzrwd r0 = new com.huawei.uikit.hwviewpager.widget.HwPagerTitleStrip$bzrwd
            r0.<init>()
            r4.f44654l = r0
            android.widget.TextView r0 = new android.widget.TextView
            r0.<init>(r5)
            r4.f44644b = r0
            r4.addView(r0)
            android.widget.TextView r0 = new android.widget.TextView
            r0.<init>(r5)
            r4.f44645c = r0
            r4.addView(r0)
            android.widget.TextView r0 = new android.widget.TextView
            r0.<init>(r5)
            r4.f44646d = r0
            r4.addView(r0)
            int[] r0 = com.huawei.uikit.hwviewpager.widget.HwPagerTitleStrip.f44637q
            android.content.res.TypedArray r6 = r5.obtainStyledAttributes(r6, r0)
            r0 = 0
            int r1 = r6.getResourceId(r0, r0)
            if (r1 == 0) goto L4b
            android.widget.TextView r2 = r4.f44644b
            androidx.core.widget.C0669j.m4080n(r2, r1)
            android.widget.TextView r2 = r4.f44645c
            androidx.core.widget.C0669j.m4080n(r2, r1)
            android.widget.TextView r2 = r4.f44646d
            androidx.core.widget.C0669j.m4080n(r2, r1)
        L4b:
            r2 = 1
            int r2 = r6.getDimensionPixelSize(r2, r0)
            if (r2 == 0) goto L55
            r4.m55790a(r2)
        L55:
            r2 = 2
            boolean r3 = r6.hasValue(r2)
            if (r3 == 0) goto L6f
            int r2 = r6.getColor(r2, r0)
            android.widget.TextView r3 = r4.f44644b
            r3.setTextColor(r2)
            android.widget.TextView r3 = r4.f44645c
            r3.setTextColor(r2)
            android.widget.TextView r3 = r4.f44646d
            r3.setTextColor(r2)
        L6f:
            r2 = 3
            r3 = 80
            int r2 = r6.getInteger(r2, r3)
            r4.f44651i = r2
            r6.recycle()
            android.widget.TextView r6 = r4.f44645c
            android.content.res.ColorStateList r6 = r6.getTextColors()
            int r6 = r6.getDefaultColor()
            r4.f44647e = r6
            r4.m55788a()
            android.widget.TextView r6 = r4.f44644b
            android.text.TextUtils$TruncateAt r2 = android.text.TextUtils.TruncateAt.END
            r6.setEllipsize(r2)
            android.widget.TextView r6 = r4.f44645c
            r6.setEllipsize(r2)
            android.widget.TextView r6 = r4.f44646d
            r6.setEllipsize(r2)
            if (r1 == 0) goto Lbc
            int[] r6 = com.huawei.uikit.hwviewpager.widget.HwPagerTitleStrip.f44636p
            android.content.res.TypedArray r6 = r5.obtainStyledAttributes(r1, r6)
            boolean r0 = r6.getBoolean(r0, r0)
            r6.recycle()
            if (r0 == 0) goto Lbc
            android.widget.TextView r6 = r4.f44644b
            setSingleLineAllCaps(r6)
            android.widget.TextView r6 = r4.f44645c
            setSingleLineAllCaps(r6)
            android.widget.TextView r6 = r4.f44646d
            setSingleLineAllCaps(r6)
            goto Lcb
        Lbc:
            android.widget.TextView r6 = r4.f44644b
            r6.setSingleLine()
            android.widget.TextView r6 = r4.f44645c
            r6.setSingleLine()
            android.widget.TextView r6 = r4.f44646d
            r6.setSingleLine()
        Lcb:
            android.content.res.Resources r5 = r5.getResources()
            android.util.DisplayMetrics r5 = r5.getDisplayMetrics()
            float r5 = r5.density
            r6 = 1098907648(0x41800000, float:16.0)
            float r5 = r5 * r6
            int r5 = (int) r5
            r4.f44650h = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.uikit.hwviewpager.widget.HwPagerTitleStrip.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    /* renamed from: a */
    private float m55786a(float f10, boolean z10) {
        if (z10) {
            f10 = -f10;
        }
        float f11 = f10 + f44639s;
        return z10 ? f11 < 0.0f ? f11 + 1.0f : f11 : f11 > 1.0f ? f11 - 1.0f : f11;
    }

    /* renamed from: a */
    private void m55790a(int i10) {
        setTextSize(0, i10);
    }

    /* renamed from: a */
    private void m55788a() {
        setNonPrimaryAlpha(0.6f);
    }

    /* renamed from: a */
    public void m55795a(int i10, HwPagerAdapter hwPagerAdapter) {
        int count = hwPagerAdapter != null ? hwPagerAdapter.getCount() : 0;
        boolean z10 = true;
        this.f44652j = true;
        CharSequence pageTitle = null;
        this.f44644b.setText((i10 < 1 || hwPagerAdapter == null) ? null : hwPagerAdapter.getPageTitle(i10 - 1));
        this.f44645c.setText((hwPagerAdapter == null || i10 >= count) ? null : hwPagerAdapter.getPageTitle(i10));
        int i11 = i10 + 1;
        if (i11 < count && hwPagerAdapter != null) {
            pageTitle = hwPagerAdapter.getPageTitle(i11);
        }
        this.f44646d.setText(pageTitle);
        HwViewPager hwViewPager = this.f44643a;
        if (hwViewPager != null && hwViewPager.getPageScrollDirection() != 0) {
            z10 = false;
        }
        m55792a(z10);
        this.f44648f = i10;
        if (!this.f44653k) {
            mo55784a(i10, this.f44649g, false);
        }
        this.f44652j = false;
    }

    /* renamed from: a */
    private void m55792a(boolean z10) {
        float f10 = z10 ? 0.8f : 1.0f;
        float f11 = z10 ? 1.0f : 0.8f;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((getWidth() - getPaddingLeft()) - getPaddingRight()) * f10)), Integer.MIN_VALUE);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((getHeight() - getPaddingTop()) - getPaddingBottom()) * f11)), Integer.MIN_VALUE);
        this.f44644b.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        this.f44645c.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        this.f44646d.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
    }

    /* renamed from: b */
    private void m55794b(int i10, int i11) {
        int iMax;
        if (View.MeasureSpec.getMode(i11) != 1073741824) {
            Log.w(f44635o, "onMeasureVertical: Must measure with an exact height");
            return;
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i10, paddingLeft, -2);
        int size = View.MeasureSpec.getSize(i11);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i11, (int) (size * 0.19999999f), -2);
        this.f44644b.measure(childMeasureSpec, childMeasureSpec2);
        this.f44645c.measure(childMeasureSpec, childMeasureSpec2);
        this.f44646d.measure(childMeasureSpec, childMeasureSpec2);
        if (View.MeasureSpec.getMode(i10) == 1073741824) {
            iMax = View.MeasureSpec.getSize(i10);
        } else {
            iMax = Math.max(getMinWidth(), this.f44645c.getMeasuredWidth() + paddingLeft);
        }
        this.f44645c.getMeasuredState();
        setMeasuredDimension(View.resolveSize(iMax, i10), size);
    }

    /* renamed from: a */
    public void m55796a(HwPagerAdapter hwPagerAdapter, HwPagerAdapter hwPagerAdapter2) {
        if (hwPagerAdapter != null) {
            hwPagerAdapter.unregisterDataSetObserver(this.f44654l);
            this.f44655m = null;
        }
        if (hwPagerAdapter2 != null) {
            hwPagerAdapter2.registerDataSetObserver(this.f44654l);
            this.f44655m = new WeakReference<>(hwPagerAdapter2);
        }
        HwViewPager hwViewPager = this.f44643a;
        if (hwViewPager != null) {
            this.f44648f = -1;
            this.f44649g = -1.0f;
            m55795a(hwViewPager.getCurrentItem(), hwPagerAdapter2);
            requestLayout();
        }
    }

    /* renamed from: a */
    public void mo55784a(int i10, float f10, boolean z10) {
        if (i10 != this.f44648f) {
            m55795a(i10, this.f44643a.getAdapter());
        } else if (!z10 && f10 == this.f44649g) {
            return;
        }
        this.f44653k = true;
        int width = getWidth();
        int height = getHeight();
        if (this.f44643a.getPageScrollDirection() == 0) {
            m55789a(f10, width, height);
        } else {
            m55793b(f10, width, height);
        }
        this.f44649g = f10;
        this.f44653k = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00b3  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m55789a(float r13, int r14, int r15) {
        /*
            r12 = this;
            int r0 = r12.getPaddingLeft()
            int r1 = r12.getPaddingRight()
            int r2 = r12.getPaddingTop()
            int r3 = r12.getPaddingBottom()
            android.widget.TextView r4 = r12.f44645c
            int r4 = r4.getMeasuredWidth()
            int r5 = r4 / 2
            int r6 = r0 + r5
            int r7 = r1 + r5
            int r6 = r14 - r6
            int r6 = r6 - r7
            com.huawei.uikit.hwviewpager.widget.HwViewPager r8 = r12.f44643a
            boolean r8 = r8.isRtlLayout()
            float r13 = r12.m55786a(r13, r8)
            int r7 = r14 - r7
            float r6 = (float) r6
            float r6 = r6 * r13
            int r13 = (int) r6
            int r7 = r7 - r13
            int r7 = r7 - r5
            int r4 = r4 + r7
            android.widget.TextView r13 = r12.f44644b
            int r13 = r13.getBaseline()
            android.widget.TextView r5 = r12.f44645c
            int r5 = r5.getBaseline()
            android.widget.TextView r6 = r12.f44646d
            int r6 = r6.getBaseline()
            int r9 = java.lang.Math.max(r13, r5)
            int r9 = java.lang.Math.max(r9, r6)
            int r13 = r9 - r13
            int r5 = r9 - r5
            int r9 = r9 - r6
            int r6 = r12.m55787a(r13, r5, r9)
            int r10 = r12.f44651i
            r10 = r10 & 112(0x70, float:1.57E-43)
            r11 = 16
            if (r10 == r11) goto L6b
            r11 = 80
            if (r10 == r11) goto L64
            int r13 = r13 + r2
            int r5 = r5 + r2
            int r2 = r2 + r9
            goto L71
        L64:
            int r15 = r15 - r3
            int r15 = r15 - r6
        L66:
            int r13 = r13 + r15
            int r5 = r5 + r15
            int r2 = r15 + r9
            goto L71
        L6b:
            int r15 = r15 - r2
            int r15 = r15 - r3
            int r15 = r15 - r6
            int r15 = r15 / 2
            goto L66
        L71:
            android.widget.TextView r15 = r12.f44645c
            int r3 = r15.getMeasuredHeight()
            int r3 = r3 + r5
            r15.layout(r7, r5, r4, r3)
            android.widget.TextView r15 = r12.f44644b
            int r15 = r15.getMeasuredWidth()
            if (r8 == 0) goto L8e
            int r3 = r14 - r1
            int r3 = r3 - r15
            int r5 = r12.f44650h
            int r5 = r5 + r4
            int r3 = java.lang.Math.max(r3, r5)
            goto L97
        L8e:
            int r3 = r12.f44650h
            int r3 = r7 - r3
            int r3 = r3 - r15
            int r3 = java.lang.Math.min(r0, r3)
        L97:
            android.widget.TextView r5 = r12.f44644b
            int r15 = r15 + r3
            int r6 = r5.getMeasuredHeight()
            int r6 = r6 + r13
            r5.layout(r3, r13, r15, r6)
            android.widget.TextView r13 = r12.f44646d
            int r13 = r13.getMeasuredWidth()
            if (r8 == 0) goto Lb3
            int r14 = r12.f44650h
            int r7 = r7 - r14
            int r7 = r7 - r13
            int r14 = java.lang.Math.min(r0, r7)
            goto Lbc
        Lb3:
            int r14 = r14 - r1
            int r14 = r14 - r13
            int r15 = r12.f44650h
            int r4 = r4 + r15
            int r14 = java.lang.Math.max(r14, r4)
        Lbc:
            android.widget.TextView r12 = r12.f44646d
            int r13 = r13 + r14
            int r15 = r12.getMeasuredHeight()
            int r15 = r15 + r2
            r12.layout(r14, r2, r13, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.uikit.hwviewpager.widget.HwPagerTitleStrip.m55789a(float, int, int):void");
    }

    /* renamed from: a */
    private int m55787a(int i10, int i11, int i12) {
        int measuredHeight = i10 + this.f44644b.getMeasuredHeight();
        int measuredHeight2 = i11 + this.f44645c.getMeasuredHeight();
        return Math.max(Math.max(measuredHeight, measuredHeight2), i12 + this.f44646d.getMeasuredHeight());
    }

    /* renamed from: a */
    private void m55791a(int i10, int i11) {
        int iMax;
        if (View.MeasureSpec.getMode(i10) != 1073741824) {
            Log.w(f44635o, "onMeasureVertical: Must measure with an exact width");
            return;
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i11, paddingTop, -2);
        int size = View.MeasureSpec.getSize(i10);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i10, (int) (size * 0.19999999f), -2);
        this.f44644b.measure(childMeasureSpec2, childMeasureSpec);
        this.f44645c.measure(childMeasureSpec2, childMeasureSpec);
        this.f44646d.measure(childMeasureSpec2, childMeasureSpec);
        if (View.MeasureSpec.getMode(i11) == 1073741824) {
            iMax = View.MeasureSpec.getSize(i11);
        } else {
            iMax = Math.max(getMinHeight(), this.f44645c.getMeasuredHeight() + paddingTop);
        }
        setMeasuredDimension(size, View.resolveSizeAndState(iMax, i11, this.f44645c.getMeasuredState() << 16));
    }
}
