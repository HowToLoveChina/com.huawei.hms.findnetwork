package androidx.viewpager.widget;

import android.R;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.text.method.SingleLineTransformationMethod;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import java.lang.ref.WeakReference;
import java.util.Locale;

@ViewPager.InterfaceC0976e
/* loaded from: classes.dex */
public class PagerTitleStrip extends ViewGroup {

    /* renamed from: o */
    public static final int[] f4925o = {R.attr.textAppearance, R.attr.textSize, R.attr.textColor, R.attr.gravity};

    /* renamed from: p */
    public static final int[] f4926p = {R.attr.textAllCaps};

    /* renamed from: a */
    public ViewPager f4927a;

    /* renamed from: b */
    public TextView f4928b;

    /* renamed from: c */
    public TextView f4929c;

    /* renamed from: d */
    public TextView f4930d;

    /* renamed from: e */
    public int f4931e;

    /* renamed from: f */
    public float f4932f;

    /* renamed from: g */
    public int f4933g;

    /* renamed from: h */
    public int f4934h;

    /* renamed from: i */
    public boolean f4935i;

    /* renamed from: j */
    public boolean f4936j;

    /* renamed from: k */
    public final C0969a f4937k;

    /* renamed from: l */
    public WeakReference<AbstractC0984a> f4938l;

    /* renamed from: m */
    public int f4939m;

    /* renamed from: n */
    public int f4940n;

    /* renamed from: androidx.viewpager.widget.PagerTitleStrip$a */
    public class C0969a extends DataSetObserver implements ViewPager.InterfaceC0980i, ViewPager.InterfaceC0979h {

        /* renamed from: a */
        public int f4941a;

        public C0969a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0979h
        /* renamed from: a */
        public void mo5853a(ViewPager viewPager, AbstractC0984a abstractC0984a, AbstractC0984a abstractC0984a2) {
            PagerTitleStrip.this.m5851b(abstractC0984a, abstractC0984a2);
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
            pagerTitleStrip.m5852c(pagerTitleStrip.f4927a.getCurrentItem(), PagerTitleStrip.this.f4927a.getAdapter());
            PagerTitleStrip pagerTitleStrip2 = PagerTitleStrip.this;
            float f10 = pagerTitleStrip2.f4932f;
            if (f10 < 0.0f) {
                f10 = 0.0f;
            }
            pagerTitleStrip2.mo5849d(pagerTitleStrip2.f4927a.getCurrentItem(), f10, true);
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0980i
        public void onPageScrollStateChanged(int i10) {
            this.f4941a = i10;
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0980i
        public void onPageScrolled(int i10, float f10, int i11) {
            if (f10 > 0.5f) {
                i10++;
            }
            PagerTitleStrip.this.mo5849d(i10, f10, false);
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0980i
        public void onPageSelected(int i10) {
            if (this.f4941a == 0) {
                PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
                pagerTitleStrip.m5852c(pagerTitleStrip.f4927a.getCurrentItem(), PagerTitleStrip.this.f4927a.getAdapter());
                PagerTitleStrip pagerTitleStrip2 = PagerTitleStrip.this;
                float f10 = pagerTitleStrip2.f4932f;
                if (f10 < 0.0f) {
                    f10 = 0.0f;
                }
                pagerTitleStrip2.mo5849d(pagerTitleStrip2.f4927a.getCurrentItem(), f10, true);
            }
        }
    }

    /* renamed from: androidx.viewpager.widget.PagerTitleStrip$b */
    public static class C0970b extends SingleLineTransformationMethod {

        /* renamed from: a */
        public Locale f4943a;

        public C0970b(Context context) {
            this.f4943a = context.getResources().getConfiguration().locale;
        }

        @Override // android.text.method.ReplacementTransformationMethod, android.text.method.TransformationMethod
        public CharSequence getTransformation(CharSequence charSequence, View view) {
            CharSequence transformation = super.getTransformation(charSequence, view);
            if (transformation != null) {
                return transformation.toString().toUpperCase(this.f4943a);
            }
            return null;
        }
    }

    public PagerTitleStrip(Context context) {
        this(context, null);
    }

    private static void setSingleLineAllCaps(TextView textView) {
        textView.setTransformationMethod(new C0970b(textView.getContext()));
    }

    /* renamed from: a */
    public void m5850a(int i10, float f10) {
        this.f4928b.setTextSize(i10, f10);
        this.f4929c.setTextSize(i10, f10);
        this.f4930d.setTextSize(i10, f10);
    }

    /* renamed from: b */
    public void m5851b(AbstractC0984a abstractC0984a, AbstractC0984a abstractC0984a2) {
        if (abstractC0984a != null) {
            abstractC0984a.unregisterDataSetObserver(this.f4937k);
            this.f4938l = null;
        }
        if (abstractC0984a2 != null) {
            abstractC0984a2.registerDataSetObserver(this.f4937k);
            this.f4938l = new WeakReference<>(abstractC0984a2);
        }
        ViewPager viewPager = this.f4927a;
        if (viewPager != null) {
            this.f4931e = -1;
            this.f4932f = -1.0f;
            m5852c(viewPager.getCurrentItem(), abstractC0984a2);
            requestLayout();
        }
    }

    /* renamed from: c */
    public void m5852c(int i10, AbstractC0984a abstractC0984a) {
        int count = abstractC0984a != null ? abstractC0984a.getCount() : 0;
        this.f4935i = true;
        CharSequence pageTitle = null;
        this.f4928b.setText((i10 < 1 || abstractC0984a == null) ? null : abstractC0984a.getPageTitle(i10 - 1));
        this.f4929c.setText((abstractC0984a == null || i10 >= count) ? null : abstractC0984a.getPageTitle(i10));
        int i11 = i10 + 1;
        if (i11 < count && abstractC0984a != null) {
            pageTitle = abstractC0984a.getPageTitle(i11);
        }
        this.f4930d.setText(pageTitle);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.8f)), Integer.MIN_VALUE);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), Integer.MIN_VALUE);
        this.f4928b.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        this.f4929c.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        this.f4930d.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        this.f4931e = i10;
        if (!this.f4936j) {
            mo5849d(i10, this.f4932f, false);
        }
        this.f4935i = false;
    }

    /* renamed from: d */
    public void mo5849d(int i10, float f10, boolean z10) {
        int i11;
        int i12;
        int i13;
        int i14;
        if (i10 != this.f4931e) {
            m5852c(i10, this.f4927a.getAdapter());
        } else if (!z10 && f10 == this.f4932f) {
            return;
        }
        this.f4936j = true;
        int measuredWidth = this.f4928b.getMeasuredWidth();
        int measuredWidth2 = this.f4929c.getMeasuredWidth();
        int measuredWidth3 = this.f4930d.getMeasuredWidth();
        int i15 = measuredWidth2 / 2;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i16 = paddingRight + i15;
        int i17 = (width - (paddingLeft + i15)) - i16;
        float f11 = 0.5f + f10;
        if (f11 > 1.0f) {
            f11 -= 1.0f;
        }
        int i18 = ((width - i16) - ((int) (i17 * f11))) - i15;
        int i19 = measuredWidth2 + i18;
        int baseline = this.f4928b.getBaseline();
        int baseline2 = this.f4929c.getBaseline();
        int baseline3 = this.f4930d.getBaseline();
        int iMax = Math.max(Math.max(baseline, baseline2), baseline3);
        int i20 = iMax - baseline;
        int i21 = iMax - baseline2;
        int i22 = iMax - baseline3;
        int iMax2 = Math.max(Math.max(this.f4928b.getMeasuredHeight() + i20, this.f4929c.getMeasuredHeight() + i21), this.f4930d.getMeasuredHeight() + i22);
        int i23 = this.f4934h & 112;
        if (i23 == 16) {
            i11 = (((height - paddingTop) - paddingBottom) - iMax2) / 2;
        } else {
            if (i23 != 80) {
                i12 = i20 + paddingTop;
                i13 = i21 + paddingTop;
                i14 = paddingTop + i22;
                TextView textView = this.f4929c;
                textView.layout(i18, i13, i19, textView.getMeasuredHeight() + i13);
                int iMin = Math.min(paddingLeft, (i18 - this.f4933g) - measuredWidth);
                TextView textView2 = this.f4928b;
                textView2.layout(iMin, i12, measuredWidth + iMin, textView2.getMeasuredHeight() + i12);
                int iMax3 = Math.max((width - paddingRight) - measuredWidth3, i19 + this.f4933g);
                TextView textView3 = this.f4930d;
                textView3.layout(iMax3, i14, iMax3 + measuredWidth3, textView3.getMeasuredHeight() + i14);
                this.f4932f = f10;
                this.f4936j = false;
            }
            i11 = (height - paddingBottom) - iMax2;
        }
        i12 = i20 + i11;
        i13 = i21 + i11;
        i14 = i11 + i22;
        TextView textView4 = this.f4929c;
        textView4.layout(i18, i13, i19, textView4.getMeasuredHeight() + i13);
        int iMin2 = Math.min(paddingLeft, (i18 - this.f4933g) - measuredWidth);
        TextView textView22 = this.f4928b;
        textView22.layout(iMin2, i12, measuredWidth + iMin2, textView22.getMeasuredHeight() + i12);
        int iMax32 = Math.max((width - paddingRight) - measuredWidth3, i19 + this.f4933g);
        TextView textView32 = this.f4930d;
        textView32.layout(iMax32, i14, iMax32 + measuredWidth3, textView32.getMeasuredHeight() + i14);
        this.f4932f = f10;
        this.f4936j = false;
    }

    public int getMinHeight() {
        Drawable background = getBackground();
        if (background != null) {
            return background.getIntrinsicHeight();
        }
        return 0;
    }

    public int getTextSpacing() {
        return this.f4933g;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (!(parent instanceof ViewPager)) {
            throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
        }
        ViewPager viewPager = (ViewPager) parent;
        AbstractC0984a adapter = viewPager.getAdapter();
        viewPager.setInternalPageChangeListener(this.f4937k);
        viewPager.addOnAdapterChangeListener(this.f4937k);
        this.f4927a = viewPager;
        WeakReference<AbstractC0984a> weakReference = this.f4938l;
        m5851b(weakReference != null ? weakReference.get() : null, adapter);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewPager viewPager = this.f4927a;
        if (viewPager != null) {
            m5851b(viewPager.getAdapter(), null);
            this.f4927a.setInternalPageChangeListener(null);
            this.f4927a.removeOnAdapterChangeListener(this.f4937k);
            this.f4927a = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        if (this.f4927a != null) {
            float f10 = this.f4932f;
            if (f10 < 0.0f) {
                f10 = 0.0f;
            }
            mo5849d(this.f4931e, f10, true);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int iMax;
        if (View.MeasureSpec.getMode(i10) != 1073741824) {
            throw new IllegalStateException("Must measure with an exact width");
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i11, paddingTop, -2);
        int size = View.MeasureSpec.getSize(i10);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i10, (int) (size * 0.2f), -2);
        this.f4928b.measure(childMeasureSpec2, childMeasureSpec);
        this.f4929c.measure(childMeasureSpec2, childMeasureSpec);
        this.f4930d.measure(childMeasureSpec2, childMeasureSpec);
        if (View.MeasureSpec.getMode(i11) == 1073741824) {
            iMax = View.MeasureSpec.getSize(i11);
        } else {
            iMax = Math.max(getMinHeight(), this.f4929c.getMeasuredHeight() + paddingTop);
        }
        setMeasuredDimension(size, View.resolveSizeAndState(iMax, i11, this.f4929c.getMeasuredState() << 16));
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.f4935i) {
            return;
        }
        super.requestLayout();
    }

    public void setGravity(int i10) {
        this.f4934h = i10;
        requestLayout();
    }

    public void setNonPrimaryAlpha(float f10) {
        int i10 = ((int) (f10 * 255.0f)) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA;
        this.f4939m = i10;
        int i11 = (i10 << 24) | (this.f4940n & 16777215);
        this.f4928b.setTextColor(i11);
        this.f4930d.setTextColor(i11);
    }

    public void setTextColor(int i10) {
        this.f4940n = i10;
        this.f4929c.setTextColor(i10);
        int i11 = (this.f4939m << 24) | (this.f4940n & 16777215);
        this.f4928b.setTextColor(i11);
        this.f4930d.setTextColor(i11);
    }

    public void setTextSpacing(int i10) {
        this.f4933g = i10;
        requestLayout();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00c0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public PagerTitleStrip(android.content.Context r5, android.util.AttributeSet r6) throws android.content.res.Resources.NotFoundException {
        /*
            r4 = this;
            r4.<init>(r5, r6)
            r0 = -1
            r4.f4931e = r0
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            r4.f4932f = r0
            androidx.viewpager.widget.PagerTitleStrip$a r0 = new androidx.viewpager.widget.PagerTitleStrip$a
            r0.<init>()
            r4.f4937k = r0
            android.widget.TextView r0 = new android.widget.TextView
            r0.<init>(r5)
            r4.f4928b = r0
            r4.addView(r0)
            android.widget.TextView r0 = new android.widget.TextView
            r0.<init>(r5)
            r4.f4929c = r0
            r4.addView(r0)
            android.widget.TextView r0 = new android.widget.TextView
            r0.<init>(r5)
            r4.f4930d = r0
            r4.addView(r0)
            int[] r0 = androidx.viewpager.widget.PagerTitleStrip.f4925o
            android.content.res.TypedArray r6 = r5.obtainStyledAttributes(r6, r0)
            r0 = 0
            int r1 = r6.getResourceId(r0, r0)
            if (r1 == 0) goto L4b
            android.widget.TextView r2 = r4.f4928b
            androidx.core.widget.C0669j.m4080n(r2, r1)
            android.widget.TextView r2 = r4.f4929c
            androidx.core.widget.C0669j.m4080n(r2, r1)
            android.widget.TextView r2 = r4.f4930d
            androidx.core.widget.C0669j.m4080n(r2, r1)
        L4b:
            r2 = 1
            int r2 = r6.getDimensionPixelSize(r2, r0)
            if (r2 == 0) goto L56
            float r2 = (float) r2
            r4.m5850a(r0, r2)
        L56:
            r2 = 2
            boolean r3 = r6.hasValue(r2)
            if (r3 == 0) goto L70
            int r2 = r6.getColor(r2, r0)
            android.widget.TextView r3 = r4.f4928b
            r3.setTextColor(r2)
            android.widget.TextView r3 = r4.f4929c
            r3.setTextColor(r2)
            android.widget.TextView r3 = r4.f4930d
            r3.setTextColor(r2)
        L70:
            r2 = 3
            r3 = 80
            int r2 = r6.getInteger(r2, r3)
            r4.f4934h = r2
            r6.recycle()
            android.widget.TextView r6 = r4.f4929c
            android.content.res.ColorStateList r6 = r6.getTextColors()
            int r6 = r6.getDefaultColor()
            r4.f4940n = r6
            r6 = 1058642330(0x3f19999a, float:0.6)
            r4.setNonPrimaryAlpha(r6)
            android.widget.TextView r6 = r4.f4928b
            android.text.TextUtils$TruncateAt r2 = android.text.TextUtils.TruncateAt.END
            r6.setEllipsize(r2)
            android.widget.TextView r6 = r4.f4929c
            r6.setEllipsize(r2)
            android.widget.TextView r6 = r4.f4930d
            r6.setEllipsize(r2)
            if (r1 == 0) goto Lc0
            int[] r6 = androidx.viewpager.widget.PagerTitleStrip.f4926p
            android.content.res.TypedArray r6 = r5.obtainStyledAttributes(r1, r6)
            boolean r0 = r6.getBoolean(r0, r0)
            r6.recycle()
            if (r0 == 0) goto Lc0
            android.widget.TextView r6 = r4.f4928b
            setSingleLineAllCaps(r6)
            android.widget.TextView r6 = r4.f4929c
            setSingleLineAllCaps(r6)
            android.widget.TextView r6 = r4.f4930d
            setSingleLineAllCaps(r6)
            goto Lcf
        Lc0:
            android.widget.TextView r6 = r4.f4928b
            r6.setSingleLine()
            android.widget.TextView r6 = r4.f4929c
            r6.setSingleLine()
            android.widget.TextView r6 = r4.f4930d
            r6.setSingleLine()
        Lcf:
            android.content.res.Resources r5 = r5.getResources()
            android.util.DisplayMetrics r5 = r5.getDisplayMetrics()
            float r5 = r5.density
            r6 = 1098907648(0x41800000, float:16.0)
            float r5 = r5 * r6
            int r5 = (int) r5
            r4.f4933g = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.PagerTitleStrip.<init>(android.content.Context, android.util.AttributeSet):void");
    }
}
