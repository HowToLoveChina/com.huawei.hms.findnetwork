package androidx.viewpager.widget;

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

/* loaded from: classes.dex */
public class PagerTabStrip extends PagerTitleStrip {

    /* renamed from: A */
    public boolean f4907A;

    /* renamed from: B */
    public int f4908B;

    /* renamed from: C */
    public boolean f4909C;

    /* renamed from: D */
    public float f4910D;

    /* renamed from: E */
    public float f4911E;

    /* renamed from: F */
    public int f4912F;

    /* renamed from: q */
    public int f4913q;

    /* renamed from: r */
    public int f4914r;

    /* renamed from: s */
    public int f4915s;

    /* renamed from: t */
    public int f4916t;

    /* renamed from: u */
    public int f4917u;

    /* renamed from: v */
    public int f4918v;

    /* renamed from: w */
    public final Paint f4919w;

    /* renamed from: x */
    public final Rect f4920x;

    /* renamed from: y */
    public int f4921y;

    /* renamed from: z */
    public boolean f4922z;

    /* renamed from: androidx.viewpager.widget.PagerTabStrip$a */
    public class ViewOnClickListenerC0967a implements View.OnClickListener {
        public ViewOnClickListenerC0967a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws Resources.NotFoundException {
            PagerTabStrip.this.f4927a.setCurrentItem(r0.getCurrentItem() - 1);
        }
    }

    /* renamed from: androidx.viewpager.widget.PagerTabStrip$b */
    public class ViewOnClickListenerC0968b implements View.OnClickListener {
        public ViewOnClickListenerC0968b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws Resources.NotFoundException {
            ViewPager viewPager = PagerTabStrip.this.f4927a;
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
        }
    }

    public PagerTabStrip(Context context) {
        this(context, null);
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    /* renamed from: d */
    public void mo5849d(int i10, float f10, boolean z10) {
        Rect rect = this.f4920x;
        int height = getHeight();
        int left = this.f4929c.getLeft() - this.f4918v;
        int right = this.f4929c.getRight() + this.f4918v;
        int i11 = height - this.f4914r;
        rect.set(left, i11, right, height);
        super.mo5849d(i10, f10, z10);
        this.f4921y = (int) (Math.abs(f10 - 0.5f) * 2.0f * 255.0f);
        rect.union(this.f4929c.getLeft() - this.f4918v, i11, this.f4929c.getRight() + this.f4918v, height);
        invalidate(rect);
    }

    public boolean getDrawFullUnderline() {
        return this.f4922z;
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    public int getMinHeight() {
        return Math.max(super.getMinHeight(), this.f4917u);
    }

    public int getTabIndicatorColor() {
        return this.f4913q;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int left = this.f4929c.getLeft() - this.f4918v;
        int right = this.f4929c.getRight() + this.f4918v;
        int i10 = height - this.f4914r;
        this.f4919w.setColor((this.f4921y << 24) | (this.f4913q & 16777215));
        float f10 = height;
        canvas.drawRect(left, i10, right, f10, this.f4919w);
        if (this.f4922z) {
            this.f4919w.setColor((this.f4913q & 16777215) | (-16777216));
            canvas.drawRect(getPaddingLeft(), height - this.f4908B, getWidth() - getPaddingRight(), f10, this.f4919w);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) throws Resources.NotFoundException {
        int action = motionEvent.getAction();
        if (action != 0 && this.f4909C) {
            return false;
        }
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        if (action == 0) {
            this.f4910D = x10;
            this.f4911E = y10;
            this.f4909C = false;
        } else if (action != 1) {
            if (action == 2 && (Math.abs(x10 - this.f4910D) > this.f4912F || Math.abs(y10 - this.f4911E) > this.f4912F)) {
                this.f4909C = true;
            }
        } else if (x10 < this.f4929c.getLeft() - this.f4918v) {
            ViewPager viewPager = this.f4927a;
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        } else if (x10 > this.f4929c.getRight() + this.f4918v) {
            ViewPager viewPager2 = this.f4927a;
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
        }
        return true;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
        super.setBackgroundColor(i10);
        if (this.f4907A) {
            return;
        }
        this.f4922z = (i10 & (-16777216)) == 0;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f4907A) {
            return;
        }
        this.f4922z = drawable == null;
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        if (this.f4907A) {
            return;
        }
        this.f4922z = i10 == 0;
    }

    public void setDrawFullUnderline(boolean z10) {
        this.f4922z = z10;
        this.f4907A = true;
        invalidate();
    }

    @Override // android.view.View
    public void setPadding(int i10, int i11, int i12, int i13) {
        int i14 = this.f4915s;
        if (i13 < i14) {
            i13 = i14;
        }
        super.setPadding(i10, i11, i12, i13);
    }

    public void setTabIndicatorColor(int i10) {
        this.f4913q = i10;
        this.f4919w.setColor(i10);
        invalidate();
    }

    public void setTabIndicatorColorResource(int i10) {
        setTabIndicatorColor(ContextCompat.getColor(getContext(), i10));
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    public void setTextSpacing(int i10) {
        int i11 = this.f4916t;
        if (i10 < i11) {
            i10 = i11;
        }
        super.setTextSpacing(i10);
    }

    public PagerTabStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        this.f4919w = paint;
        this.f4920x = new Rect();
        this.f4921y = HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA;
        this.f4922z = false;
        this.f4907A = false;
        int i10 = this.f4940n;
        this.f4913q = i10;
        paint.setColor(i10);
        float f10 = context.getResources().getDisplayMetrics().density;
        this.f4914r = (int) ((3.0f * f10) + 0.5f);
        this.f4915s = (int) ((6.0f * f10) + 0.5f);
        this.f4916t = (int) (64.0f * f10);
        this.f4918v = (int) ((16.0f * f10) + 0.5f);
        this.f4908B = (int) ((1.0f * f10) + 0.5f);
        this.f4917u = (int) ((f10 * 32.0f) + 0.5f);
        this.f4912F = ViewConfiguration.get(context).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(getTextSpacing());
        setWillNotDraw(false);
        this.f4928b.setFocusable(true);
        this.f4928b.setOnClickListener(new ViewOnClickListenerC0967a());
        this.f4930d.setFocusable(true);
        this.f4930d.setOnClickListener(new ViewOnClickListenerC0968b());
        if (getBackground() == null) {
            this.f4922z = true;
        }
    }
}
