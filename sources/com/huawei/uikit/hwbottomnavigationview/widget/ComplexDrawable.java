package com.huawei.uikit.hwbottomnavigationview.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.huawei.openalliance.p169ad.constant.OsType;
import com.huawei.uikit.hwbottomnavigationview.C8702R;
import com.huawei.uikit.hwcommon.anim.HwCubicBezierInterpolator;
import com.huawei.uikit.hwcommon.utils.HwReflectUtil;

/* loaded from: classes7.dex */
public class ComplexDrawable extends Drawable {
    protected static final float MAX_SCALE = 1.42f;

    /* renamed from: l */
    private static final String f41431l = "ComplexDrawable";

    /* renamed from: m */
    private static final float f41432m = 0.2f;

    /* renamed from: n */
    private static final float f41433n = 0.0f;

    /* renamed from: o */
    private static final float f41434o = 0.2f;

    /* renamed from: p */
    private static final float f41435p = 0.4f;

    /* renamed from: q */
    private static final float f41436q = 1.0f;

    /* renamed from: r */
    private static final int f41437r = -1;

    /* renamed from: s */
    private static final float f41438s = -1.0f;

    /* renamed from: t */
    private static final float f41439t = 1.0f;

    /* renamed from: a */
    private Drawable f41440a;

    /* renamed from: b */
    private Drawable f41441b;

    /* renamed from: c */
    private Context f41442c;

    /* renamed from: d */
    private int f41443d;

    /* renamed from: e */
    private ValueAnimator f41444e;

    /* renamed from: f */
    private ValueAnimator f41445f;

    /* renamed from: g */
    private int f41446g;

    /* renamed from: h */
    private int f41447h;

    /* renamed from: i */
    private int f41448i;

    /* renamed from: j */
    private ValueAnimator.AnimatorUpdateListener f41449j;

    /* renamed from: k */
    private Path f41450k;
    protected Rect mDrawableRect;
    protected int mIconBounds;

    public class bzrwd implements ValueAnimator.AnimatorUpdateListener {
        public bzrwd() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator == null) {
                Log.w(ComplexDrawable.f41431l, "onAnimationUpdate: Param valueAnimator is null");
                return;
            }
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null || !(animatedValue instanceof Integer)) {
                return;
            }
            ComplexDrawable.this.setRadius(((Integer) animatedValue).intValue());
        }
    }

    public ComplexDrawable(Context context, Drawable drawable) {
        this(context, drawable, 0);
    }

    /* renamed from: a */
    private void m53988a(Drawable drawable, int i10) throws NoSuchMethodException, SecurityException {
        this.f41446g = this.f41442c.getResources().getInteger(C8702R.integer.hwbottomnavigationview_icon_anim_duration);
        if (i10 == 0) {
            this.mIconBounds = this.f41442c.getResources().getDimensionPixelSize(C8702R.dimen.hwbottomnavigationview_item_icon_size);
        } else {
            this.mIconBounds = i10;
        }
        initDrawableRect();
        m53987a(drawable);
        this.f41449j = new bzrwd();
        this.f41450k = new Path();
        m53986a();
    }

    /* renamed from: b */
    public void m53993b(int i10) throws NoSuchMethodException, SecurityException {
        m53987a(ContextCompat.getDrawable(this.f41442c, i10));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (canvas == null) {
            Log.w(f41431l, "draw: Param canvas is null");
            return;
        }
        this.f41450k.reset();
        this.f41450k.addCircle(m53991b() ? this.mDrawableRect.right : this.mDrawableRect.left, this.mDrawableRect.bottom, this.f41443d, Path.Direction.CCW);
        canvas.save();
        canvas.clipPath(this.f41450k, Region.Op.DIFFERENCE);
        if (this.f41440a.isAutoMirrored() && m53991b()) {
            Rect rect = this.mDrawableRect;
            canvas.translate(rect.right + rect.left, 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        this.f41440a.draw(canvas);
        canvas.restore();
        canvas.save();
        canvas.clipPath(this.f41450k);
        if (this.f41440a.isAutoMirrored() && m53991b()) {
            Rect rect2 = this.mDrawableRect;
            canvas.translate(rect2.right + rect2.left, 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        this.f41441b.draw(canvas);
        canvas.restore();
    }

    public Drawable getDefaultDrawable() {
        return this.f41440a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f41440a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    public void initDrawableRect() {
        int i10 = this.mIconBounds;
        this.mDrawableRect = new Rect(0, 0, i10, i10);
    }

    public void setActiveColor(int i10) {
        Drawable drawable = this.f41441b;
        if (drawable == null) {
            return;
        }
        this.f41447h = i10;
        drawable.setTint(i10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        Drawable drawable = this.f41440a;
        if (drawable != null) {
            drawable.setAlpha(i10);
        }
        Drawable drawable2 = this.f41441b;
        if (drawable2 != null) {
            drawable2.setAlpha(i10);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f41440a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
        Drawable drawable2 = this.f41441b;
        if (drawable2 != null) {
            drawable2.setColorFilter(colorFilter);
        }
    }

    public void setDefaultColor(int i10) {
        Drawable drawable = this.f41440a;
        if (drawable == null) {
            return;
        }
        this.f41448i = i10;
        drawable.setTint(i10);
        invalidateSelf();
    }

    public void setRadius(int i10) {
        this.f41443d = i10;
        invalidateSelf();
    }

    public void setSrcDrawable(Drawable drawable) throws NoSuchMethodException, SecurityException {
        m53987a(drawable);
    }

    public void setState(boolean z10, boolean z11) {
        if (z11) {
            m53990a(z10);
        } else {
            setRadius(z10 ? (int) (this.mIconBounds * MAX_SCALE) : 0);
        }
    }

    public ComplexDrawable(Context context, Drawable drawable, int i10) throws NoSuchMethodException, SecurityException {
        this.f41443d = 0;
        this.f41442c = context;
        m53988a(drawable, i10);
    }

    /* renamed from: b */
    private boolean m53991b() {
        return getLayoutDirection() == 1;
    }

    /* renamed from: a */
    private void m53986a() {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, (int) (this.mIconBounds * MAX_SCALE));
        this.f41444e = valueAnimatorOfInt;
        valueAnimatorOfInt.setDuration(this.f41446g);
        this.f41444e.addUpdateListener(this.f41449j);
        this.f41444e.setInterpolator(new HwCubicBezierInterpolator(0.2f, 0.0f, 0.2f, 1.0f));
        ValueAnimator valueAnimatorOfInt2 = ValueAnimator.ofInt((int) (this.mIconBounds * MAX_SCALE), 0);
        this.f41445f = valueAnimatorOfInt2;
        valueAnimatorOfInt2.setDuration(this.f41446g);
        this.f41445f.addUpdateListener(this.f41449j);
        this.f41445f.setInterpolator(new HwCubicBezierInterpolator(0.4f, 0.0f, 0.2f, 1.0f));
    }

    /* renamed from: a */
    public void m53992a(int i10) {
        this.mIconBounds = i10;
        this.mDrawableRect.set(0, 0, i10, i10);
        this.f41444e.setIntValues(0, (int) (this.mIconBounds * MAX_SCALE));
        this.f41445f.setIntValues((int) (this.mIconBounds * MAX_SCALE), 0);
        Drawable drawable = this.f41440a;
        if (drawable != null) {
            drawable.setBounds(this.mDrawableRect);
        }
        Drawable drawable2 = this.f41441b;
        if (drawable2 != null) {
            drawable2.setBounds(this.mDrawableRect);
        }
        invalidateSelf();
    }

    /* renamed from: a */
    private void m53987a(Drawable drawable) throws NoSuchMethodException, SecurityException {
        if (!(drawable instanceof StateListDrawable)) {
            if (drawable != null) {
                m53989a(drawable, drawable.getConstantState().newDrawable().mutate());
                return;
            }
            return;
        }
        StateListDrawable stateListDrawable = (StateListDrawable) drawable;
        int identifier = this.f41442c.getResources().getIdentifier("state_selected", "attr", OsType.ANDROID);
        int[] iArr = new int[0];
        int[] iArr2 = {identifier};
        int iFindStateDrawableIndex = stateListDrawable.findStateDrawableIndex(new int[]{~identifier});
        Drawable stateDrawable = iFindStateDrawableIndex != -1 ? stateListDrawable.getStateDrawable(iFindStateDrawableIndex) : null;
        int iFindStateDrawableIndex2 = stateListDrawable.findStateDrawableIndex(iArr2);
        Drawable stateDrawable2 = iFindStateDrawableIndex2 != -1 ? stateListDrawable.getStateDrawable(iFindStateDrawableIndex2) : null;
        if (stateDrawable == null && stateDrawable2 == null) {
            m53989a(drawable, drawable.getConstantState().newDrawable().mutate());
            return;
        }
        if (stateDrawable != null && stateDrawable2 != null) {
            m53989a(stateDrawable, stateDrawable2);
            return;
        }
        if (m53984a(stateListDrawable, iArr) != -1) {
            int iM53984a = m53984a(stateListDrawable, iArr);
            if (stateDrawable == null) {
                stateDrawable = m53985a(stateListDrawable, iM53984a);
            }
            if (stateDrawable2 == null) {
                stateDrawable2 = m53985a(stateListDrawable, iM53984a);
            }
            m53989a(stateDrawable, stateDrawable2);
            return;
        }
        throw new IllegalArgumentException("no resource available to provide");
    }

    /* renamed from: a */
    private Drawable m53985a(StateListDrawable stateListDrawable, int i10) throws NoSuchMethodException, SecurityException {
        Object objCallMethod = HwReflectUtil.callMethod(stateListDrawable, "getStateDrawable", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(i10)}, StateListDrawable.class);
        if (objCallMethod != null) {
            return (Drawable) objCallMethod;
        }
        return null;
    }

    /* renamed from: a */
    private int m53984a(StateListDrawable stateListDrawable, int[] iArr) throws NoSuchMethodException, SecurityException {
        Object objCallMethod = HwReflectUtil.callMethod(stateListDrawable, "getStateDrawableIndex", new Class[]{iArr.getClass()}, new Object[]{iArr}, StateListDrawable.class);
        if (objCallMethod != null) {
            return ((Integer) objCallMethod).intValue();
        }
        return -1;
    }

    /* renamed from: a */
    private void m53989a(Drawable drawable, Drawable drawable2) {
        if (drawable == null || drawable2 == null) {
            return;
        }
        this.f41440a = drawable;
        drawable.setBounds(this.mDrawableRect);
        this.f41441b = drawable2;
        drawable2.setBounds(this.mDrawableRect);
        invalidateSelf();
    }

    /* renamed from: a */
    private void m53990a(boolean z10) {
        ValueAnimator valueAnimator = z10 ? this.f41445f : this.f41444e;
        ValueAnimator valueAnimator2 = z10 ? this.f41444e : this.f41445f;
        if (valueAnimator.isRunning()) {
            valueAnimator.reverse();
        } else {
            valueAnimator2.start();
        }
    }
}
