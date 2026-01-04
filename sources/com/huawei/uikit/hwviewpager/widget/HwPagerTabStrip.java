package com.huawei.uikit.hwviewpager.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.content.ContextCompat;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes9.dex */
public class HwPagerTabStrip extends HwPagerTitleStrip {

    /* renamed from: M */
    private static final String f44608M = "HwPagerTabStrip";

    /* renamed from: N */
    private static final int f44609N = 24;

    /* renamed from: O */
    private static final int f44610O = 16;

    /* renamed from: P */
    private static final int f44611P = 32;

    /* renamed from: Q */
    private static final int f44612Q = 3;

    /* renamed from: R */
    private static final int f44613R = 6;

    /* renamed from: S */
    private static final int f44614S = 64;

    /* renamed from: T */
    private static final int f44615T = 32;

    /* renamed from: U */
    private static final int f44616U = 1;

    /* renamed from: A */
    private int f44617A;

    /* renamed from: B */
    private int f44618B;

    /* renamed from: C */
    private int f44619C;

    /* renamed from: D */
    private int f44620D;

    /* renamed from: E */
    private int f44621E;

    /* renamed from: F */
    private int f44622F;

    /* renamed from: G */
    private int f44623G;

    /* renamed from: H */
    private float f44624H;

    /* renamed from: I */
    private float f44625I;

    /* renamed from: J */
    private boolean f44626J;

    /* renamed from: K */
    private boolean f44627K;

    /* renamed from: L */
    private boolean f44628L;

    /* renamed from: w */
    private final Paint f44629w;

    /* renamed from: x */
    private final Rect f44630x;

    /* renamed from: y */
    private int f44631y;

    /* renamed from: z */
    private int f44632z;

    public class aauaf implements View.OnClickListener {
        public aauaf() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
            HwViewPager hwViewPager = HwPagerTabStrip.this.f44643a;
            hwViewPager.setCurrentItem(hwViewPager.getCurrentItem() + 1);
        }
    }

    public class bzrwd implements View.OnClickListener {
        public bzrwd() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
            HwPagerTabStrip.this.f44643a.setCurrentItem(r0.getCurrentItem() - 1);
        }
    }

    public HwPagerTabStrip(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    private void m55781a(float f10, float f11) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (this.f44643a.getPageScrollDirection() != 0) {
            if (f11 < this.f44645c.getTop() - this.f44617A) {
                this.f44643a.setCurrentItem(r2.getCurrentItem() - 1);
                return;
            } else {
                if (f11 > this.f44645c.getBottom() + this.f44617A) {
                    HwViewPager hwViewPager = this.f44643a;
                    hwViewPager.setCurrentItem(hwViewPager.getCurrentItem() + 1);
                    return;
                }
                return;
            }
        }
        boolean zIsRtlLayout = this.f44643a.isRtlLayout();
        if (f10 < this.f44645c.getLeft() - this.f44617A) {
            HwViewPager hwViewPager2 = this.f44643a;
            hwViewPager2.setCurrentItem(zIsRtlLayout ? hwViewPager2.getCurrentItem() + 1 : hwViewPager2.getCurrentItem() - 1);
        } else if (f10 > this.f44645c.getRight() + this.f44617A) {
            HwViewPager hwViewPager3 = this.f44643a;
            hwViewPager3.setCurrentItem(zIsRtlLayout ? hwViewPager3.getCurrentItem() - 1 : hwViewPager3.getCurrentItem() + 1);
        }
    }

    /* renamed from: b */
    private void m55783b() {
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(getTextSpacing());
    }

    public boolean getDrawFullUnderline() {
        return this.f44626J;
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerTitleStrip
    public int getMinHeight() {
        return Math.max(super.getMinHeight(), this.f44623G);
    }

    public int getTabIndicatorColor() {
        return this.f44631y;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        boolean zIsRtlLayout;
        boolean z10;
        if (canvas == null) {
            return;
        }
        super.onDraw(canvas);
        HwViewPager hwViewPager = this.f44643a;
        if (hwViewPager != null) {
            boolean z11 = hwViewPager.getPageScrollDirection() == 0;
            zIsRtlLayout = this.f44643a.isRtlLayout();
            z10 = z11;
        } else {
            zIsRtlLayout = false;
            z10 = true;
        }
        int height = getHeight();
        int bottom = z10 ? height : this.f44645c.getBottom() + this.f44632z;
        int left = this.f44645c.getLeft() - this.f44617A;
        int right = this.f44645c.getRight() + this.f44617A;
        int i10 = bottom - this.f44632z;
        this.f44629w.setColor((this.f44618B << 24) | (this.f44631y & 16777215));
        canvas.drawRect(left, i10, right, bottom, this.f44629w);
        if (this.f44626J) {
            this.f44629w.setColor((this.f44631y & 16777215) | (-16777216));
            m55782a(canvas, z10, zIsRtlLayout, height);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (motionEvent == null) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 0 && this.f44628L) {
            return false;
        }
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        if (action == 0) {
            this.f44624H = x10;
            this.f44625I = y10;
            this.f44628L = false;
        } else if (action != 1) {
            if (action == 2 && (Math.abs(x10 - this.f44624H) > this.f44620D || Math.abs(y10 - this.f44625I) > this.f44620D)) {
                this.f44628L = true;
            }
        } else if (this.f44643a != null) {
            m55781a(x10, y10);
        }
        return true;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
        super.setBackgroundColor(i10);
        if (this.f44627K) {
            return;
        }
        this.f44626J = (i10 & (-16777216)) == 0;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f44627K) {
            return;
        }
        this.f44626J = drawable == null;
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        if (this.f44627K) {
            return;
        }
        this.f44626J = i10 == 0;
    }

    public void setDrawFullUnderline(boolean z10) {
        this.f44626J = z10;
        this.f44627K = true;
        invalidate();
    }

    @Override // android.view.View
    public void setPadding(int i10, int i11, int i12, int i13) {
        int i14 = this.f44621E;
        if (i13 < i14) {
            i13 = i14;
        }
        super.setPadding(i10, i11, i12, i13);
    }

    public void setTabIndicatorColor(int i10) {
        this.f44631y = i10;
        this.f44629w.setColor(i10);
        invalidate();
    }

    public void setTabIndicatorColorResource(int i10) {
        setTabIndicatorColor(ContextCompat.getColor(getContext(), i10));
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerTitleStrip
    public void setTextSpacing(int i10) {
        int i11 = this.f44622F;
        if (i10 < i11) {
            i10 = i11;
        }
        super.setTextSpacing(i10);
    }

    public HwPagerTabStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        this.f44629w = paint;
        this.f44630x = new Rect();
        this.f44618B = HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA;
        this.f44626J = false;
        this.f44627K = false;
        int i10 = this.f44647e;
        this.f44631y = i10;
        paint.setColor(i10);
        float f10 = context.getResources().getDisplayMetrics().density;
        this.f44632z = (int) ((3.0f * f10) + 0.5f);
        this.f44617A = (int) ((16.0f * f10) + 0.5f);
        this.f44619C = (int) ((1.0f * f10) + 0.5f);
        this.f44623G = (int) ((32.0f * f10) + 0.5f);
        this.f44621E = (int) ((6.0f * f10) + 0.5f);
        this.f44622F = (int) (f10 * 64.0f);
        this.f44620D = ViewConfiguration.get(context).getScaledTouchSlop();
        m55783b();
        setWillNotDraw(false);
        this.f44644b.setFocusable(true);
        this.f44644b.setOnClickListener(new bzrwd());
        this.f44646d.setFocusable(true);
        this.f44646d.setOnClickListener(new aauaf());
        if (getBackground() == null) {
            this.f44626J = true;
        }
    }

    /* renamed from: a */
    private void m55782a(Canvas canvas, boolean z10, boolean z11, int i10) {
        if (z10) {
            canvas.drawRect(getPaddingLeft(), i10 - this.f44619C, getWidth() - getPaddingRight(), i10, this.f44629w);
        } else if (z11) {
            canvas.drawRect(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + this.f44619C, i10, this.f44629w);
        } else {
            canvas.drawRect((getWidth() - getPaddingRight()) - this.f44619C, getPaddingTop(), getWidth() - getPaddingRight(), i10, this.f44629w);
        }
    }

    @Override // com.huawei.uikit.hwviewpager.widget.HwPagerTitleStrip
    /* renamed from: a */
    public void mo55784a(int i10, float f10, boolean z10) {
        Rect rect = this.f44630x;
        int height = getHeight();
        int left = this.f44645c.getLeft() - this.f44617A;
        int right = this.f44645c.getRight() + this.f44617A;
        int i11 = height - this.f44632z;
        rect.set(left, i11, right, height);
        super.mo55784a(i10, f10, z10);
        this.f44618B = (int) (Math.abs(f10 - 0.5f) * 2.0f * 255.0f);
        rect.union(this.f44645c.getLeft() - this.f44617A, i11, this.f44645c.getRight() + this.f44617A, height);
        invalidate(rect);
    }
}
