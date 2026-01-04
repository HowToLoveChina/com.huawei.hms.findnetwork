package com.huawei.phoneservice.faq.base.widget;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import androidx.annotation.Keep;
import androidx.appcompat.widget.AppCompatImageView;
import com.huawei.phoneservice.faq.base.R$color;
import com.huawei.phoneservice.faq.base.R$styleable;
import com.huawei.phoneservice.faq.base.util.FaqCommonUtils;
import com.huawei.phoneservice.faq.base.util.FaqLogger;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Keep
/* loaded from: classes4.dex */
public class ThemeImageView extends AppCompatImageView {
    private static final Set<Integer> BLACK_SET = new HashSet();
    static final String TAG = "ThemeImageView";
    private int anInt;
    private Bitmap bitmap;
    private Integer integer;
    private Paint mClearPaint;
    private Bitmap normalBitmap;
    private Integer pressFilterColor;
    private int pressFilterColorId;
    private Bitmap pressedBitmap;

    public ThemeImageView(Context context) {
        super(context);
        this.integer = null;
        this.pressFilterColor = null;
    }

    public static Bitmap drawableToBitmap(Drawable drawable) throws Throwable {
        Bitmap bitmapCreateBitmap = null;
        if (drawable == null) {
            return null;
        }
        try {
            bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            drawable.draw(canvas);
            return bitmapCreateBitmap;
        } catch (IllegalArgumentException unused) {
            FaqLogger.m51852w(TAG, "drawableToBitmap IllegalArgumentException");
            return bitmapCreateBitmap;
        }
    }

    private boolean filter(Drawable drawable) {
        Set<Integer> set = BLACK_SET;
        synchronized (set) {
            try {
                if (!FaqCommonUtils.isEmpty(set) && drawable != null && drawable.getConstantState() != null) {
                    Iterator<Integer> it = set.iterator();
                    while (it.hasNext()) {
                        Drawable drawable2 = getResources().getDrawable(it.next().intValue());
                        if (drawable2 != null && drawable.getConstantState().equals(drawable2.getConstantState())) {
                            return false;
                        }
                    }
                    return true;
                }
                return true;
            } finally {
            }
        }
    }

    private Drawable getImageDrawable() throws IllegalArgumentException {
        Paint paint = new Paint(1);
        if (this.normalBitmap == null) {
            this.normalBitmap = Bitmap.createBitmap(this.bitmap.getWidth(), this.bitmap.getHeight(), this.bitmap.getConfig());
        }
        if (this.pressedBitmap == null) {
            this.pressedBitmap = Bitmap.createBitmap(this.bitmap.getWidth(), this.bitmap.getHeight(), this.bitmap.getConfig());
        }
        Canvas canvas = new Canvas(this.normalBitmap);
        paint.setColorFilter(getNormalFilter());
        canvas.drawPaint(this.mClearPaint);
        canvas.drawBitmap(this.bitmap, new Matrix(), paint);
        canvas.setBitmap(this.pressedBitmap);
        paint.setColorFilter(getPressedFilter());
        canvas.drawPaint(this.mClearPaint);
        canvas.drawBitmap(this.bitmap, new Matrix(), paint);
        if (isInEditMode()) {
            return setSelector(new BitmapDrawable((Resources) null, this.normalBitmap), new BitmapDrawable((Resources) null, this.pressedBitmap));
        }
        Resources resources = getResources();
        return setSelector(new BitmapDrawable(resources, this.normalBitmap), new BitmapDrawable(resources, this.pressedBitmap));
    }

    private void init(Context context, AttributeSet attributeSet) throws Throwable {
        int iIntValue;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ThemeImageView);
            this.anInt = typedArrayObtainStyledAttributes.getResourceId(R$styleable.ThemeImageView_normal_color, R$color.faq_base_sdk_themeImageView_normal);
            this.pressFilterColorId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.ThemeImageView_pressed_color, 0);
            typedArrayObtainStyledAttributes.recycle();
        }
        if (this.anInt != 0) {
            setInteger(getResources().getColor(this.anInt));
        }
        if (this.pressFilterColorId == 0) {
            if (this.integer != null) {
                iIntValue = (int) (r3.intValue() * 0.8d);
            }
            Paint paint = new Paint();
            this.mClearPaint = paint;
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            updateDrawable();
        }
        iIntValue = getResources().getColor(this.pressFilterColorId);
        setPressFilterColor(iIntValue);
        Paint paint2 = new Paint();
        this.mClearPaint = paint2;
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        updateDrawable();
    }

    public static StateListDrawable setSelector(Drawable drawable, Drawable drawable2) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_enabled, R.attr.state_pressed}, drawable2);
        stateListDrawable.addState(new int[0], drawable);
        return stateListDrawable;
    }

    public ColorFilter getNormalFilter() {
        Integer num = this.integer;
        return new PorterDuffColorFilter(num == null ? getResources().getColor(this.anInt) : num.intValue(), PorterDuff.Mode.SRC_IN);
    }

    public ColorFilter getPressedFilter() {
        Integer num = this.pressFilterColor;
        return new PorterDuffColorFilter(num == null ? getResources().getColor(this.pressFilterColorId) : num.intValue(), PorterDuff.Mode.SRC_IN);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) throws Throwable {
        if (this.pressFilterColorId != 0 && drawable != null && drawable.getConstantState() != null && filter(drawable) && !(drawable instanceof StateListDrawable)) {
            try {
                Bitmap bitmapDrawableToBitmap = drawableToBitmap(drawable);
                this.bitmap = bitmapDrawableToBitmap;
                if (bitmapDrawableToBitmap != null) {
                    drawable = getImageDrawable();
                }
            } catch (IllegalArgumentException e10) {
                FaqLogger.m51840e(TAG, e10 + "setImageDrawable error");
            }
        }
        super.setImageDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i10) throws Throwable {
        setImageDrawable(getResources().getDrawable(i10));
    }

    public ThemeImageView setInteger(int i10) {
        this.integer = Integer.valueOf(i10);
        return this;
    }

    public ThemeImageView setPressFilterColor(int i10) {
        this.pressFilterColor = Integer.valueOf(i10);
        return this;
    }

    public void updateDrawable() throws Throwable {
        if (this.bitmap == null && getDrawable() != null) {
            this.bitmap = drawableToBitmap(getDrawable());
        }
        Bitmap bitmap = this.bitmap;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        try {
            super.setImageDrawable(getImageDrawable());
        } catch (IllegalArgumentException e10) {
            FaqLogger.m51840e(TAG, e10 + "setImageDrawable error");
        }
    }

    public ThemeImageView(Context context, AttributeSet attributeSet) throws Throwable {
        super(context, attributeSet);
        this.integer = null;
        this.pressFilterColor = null;
        init(context, attributeSet);
    }

    public ThemeImageView(Context context, AttributeSet attributeSet, int i10) throws Throwable {
        super(context, attributeSet, i10);
        this.integer = null;
        this.pressFilterColor = null;
        init(context, attributeSet);
    }
}
