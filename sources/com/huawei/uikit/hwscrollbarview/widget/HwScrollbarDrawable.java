package com.huawei.uikit.hwscrollbarview.widget;

import android.R;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.annotation.Keep;
import com.huawei.uikit.hwscrollbarview.C8733R;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public class HwScrollbarDrawable extends Drawable {

    /* renamed from: r */
    private static final String f44008r = "ScrollbarDrawable";

    /* renamed from: s */
    private static final int f44009s = 150;

    /* renamed from: t */
    private static final int f44010t = 255;

    /* renamed from: u */
    private static final float f44011u = 0.5f;

    /* renamed from: v */
    private static final int f44012v = 8;

    /* renamed from: w */
    private static final int f44013w = 8;

    /* renamed from: x */
    private static final int f44014x = 24;

    /* renamed from: f */
    private int f44020f;

    /* renamed from: g */
    private int f44021g;

    /* renamed from: n */
    private Animator f44028n;

    /* renamed from: o */
    private Interpolator f44029o;

    /* renamed from: a */
    private int f44015a = 0;

    /* renamed from: b */
    private Paint f44016b = new Paint(1);

    /* renamed from: c */
    private RectF f44017c = new RectF();

    /* renamed from: d */
    private int f44018d = 8;

    /* renamed from: e */
    private int f44019e = 8;

    /* renamed from: h */
    private boolean f44022h = false;

    /* renamed from: i */
    private int f44023i = 0;

    /* renamed from: j */
    private int f44024j = 0;

    /* renamed from: k */
    private int f44025k = 255;

    /* renamed from: l */
    private float f44026l = 0.0f;

    /* renamed from: m */
    private boolean f44027m = false;

    /* renamed from: p */
    private long f44030p = 150;

    /* renamed from: q */
    private long f44031q = 150;

    public HwScrollbarDrawable() {
        this.f44016b.setStyle(Paint.Style.FILL);
    }

    /* renamed from: a */
    private int m55422a(int i10, int i11) {
        return ((((i11 >>> 24) * (i10 + (i10 >> 7))) >> 8) << 24) | ((i11 << 8) >>> 8);
    }

    /* renamed from: b */
    private boolean m55429b(boolean z10) {
        if (this.f44027m == z10) {
            return false;
        }
        this.f44027m = z10;
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int i10 = this.f44024j;
        int i11 = this.f44023i;
        if (i11 != 0) {
            i10 = i11;
        }
        this.f44016b.setColor(m55422a(this.f44025k, i10));
        RectF rectF = this.f44017c;
        Rect bounds = getBounds();
        if (m55426a()) {
            float f10 = bounds.left + this.f44015a;
            rectF.left = f10;
            rectF.right = f10 + this.f44020f;
        } else {
            float f11 = bounds.right - this.f44015a;
            rectF.right = f11;
            rectF.left = f11 - this.f44020f;
        }
        rectF.top = bounds.top;
        rectF.bottom = bounds.bottom;
        float fWidth = this.f44026l;
        if (Float.compare(fWidth, 0.0f) <= 0) {
            fWidth = rectF.width() * f44011u;
        }
        canvas.drawRoundRect(rectF, fWidth, fWidth, this.f44016b);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return (this.f44023i >>> 24) == 255 ? -1 : -3;
    }

    public int getScrollbarNormalWidth() {
        return this.f44018d;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        super.inflate(resources, xmlPullParser, attributeSet, theme);
        TypedArray typedArrayM55424a = m55424a(resources, theme, attributeSet, C8733R.styleable.HwScrollbarDrawable);
        m55425a((Context) null, typedArrayM55424a);
        typedArrayM55424a.recycle();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.f44022h;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean z10;
        if (m55430b(iArr)) {
            this.f44021g = this.f44019e;
            z10 = true;
        } else {
            this.f44021g = this.f44018d;
            z10 = false;
        }
        if (!m55429b(z10)) {
            return false;
        }
        Animator animator = this.f44028n;
        if (animator != null && animator.isRunning()) {
            this.f44028n.cancel();
        }
        Animator animatorM55423a = m55423a(z10);
        this.f44028n = animatorM55423a;
        animatorM55423a.start();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        if (this.f44025k != i10) {
            this.f44025k = i10;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z10) {
        this.f44022h = z10;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f44016b.setColorFilter(colorFilter);
    }

    public void setInterpolator(Interpolator interpolator) {
        this.f44029o = interpolator;
    }

    public void setScrollbarActivatedWidth(int i10) {
        this.f44019e = i10;
    }

    public void setScrollbarColor(int i10) {
        this.f44024j = i10;
    }

    public void setScrollbarEndMargin(int i10) {
        this.f44015a = i10;
    }

    public void setScrollbarNormalWidth(int i10) {
        this.f44018d = i10;
    }

    public void setScrollbarToActivatedDuration(long j10) {
        this.f44030p = j10;
    }

    public void setScrollbarToUnactivatedDuration(long j10) {
        this.f44031q = j10;
    }

    @Keep
    public void setScrollbarWidth(int i10) {
        if (this.f44020f != i10) {
            this.f44020f = i10;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i10) {
        this.f44023i = i10;
        invalidateSelf();
    }

    /* renamed from: a */
    private boolean m55426a() {
        return isAutoMirrored() && getLayoutDirection() == 1;
    }

    /* renamed from: a */
    private Animator m55423a(boolean z10) {
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this, "scrollbarWidth", this.f44020f, this.f44021g);
        Interpolator interpolator = this.f44029o;
        if (interpolator != null) {
            objectAnimatorOfInt.setInterpolator(interpolator);
        }
        if (z10) {
            objectAnimatorOfInt.setDuration(this.f44030p);
        } else {
            objectAnimatorOfInt.setDuration(this.f44031q);
        }
        return objectAnimatorOfInt;
    }

    /* renamed from: b */
    private boolean m55430b(int[] iArr) {
        return m55428a(iArr, R.attr.state_pressed);
    }

    public void inflate(Context context, AttributeSet attributeSet, int i10) {
        if (context == null) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C8733R.styleable.HwScrollbarDrawable, i10, C8733R.style.Widget_Emui_HwScrollbarDrawable);
        m55425a(context, typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    private boolean m55427a(int[] iArr) {
        return m55428a(iArr, R.attr.state_hovered);
    }

    /* renamed from: a */
    private boolean m55428a(int[] iArr, int i10) {
        if (iArr == null) {
            return false;
        }
        for (int i11 : iArr) {
            if (i11 == i10) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private void m55425a(Context context, TypedArray typedArray) {
        int dimensionPixelSize = typedArray.getDimensionPixelSize(C8733R.styleable.HwScrollbarDrawable_hwScrollbarNormalWidth, 8);
        setScrollbarNormalWidth(dimensionPixelSize);
        setScrollbarWidth(dimensionPixelSize);
        setScrollbarActivatedWidth(typedArray.getDimensionPixelSize(C8733R.styleable.HwScrollbarDrawable_hwScrollbarActivatedWidth, 8));
        setScrollbarEndMargin(typedArray.getDimensionPixelSize(C8733R.styleable.HwScrollbarDrawable_hwScrollbarEndMargin, 8));
        setScrollbarColor(typedArray.getColor(C8733R.styleable.HwScrollbarDrawable_hwScrollbarColor, 0));
        int resourceId = typedArray.getResourceId(C8733R.styleable.HwScrollbarDrawable_hwScrollbarInterpolator, R.anim.linear_interpolator);
        if (resourceId > 0 && context != null) {
            setInterpolator(AnimationUtils.loadInterpolator(context, resourceId));
        }
        setScrollbarToActivatedDuration(typedArray.getInt(C8733R.styleable.HwScrollbarDrawable_hwScrollbarToActivatedDuration, 150));
        setScrollbarToUnactivatedDuration(typedArray.getInt(C8733R.styleable.HwScrollbarDrawable_hwScrollbarToUnactivatedDuration, 150));
    }

    /* renamed from: a */
    private TypedArray m55424a(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }
}
