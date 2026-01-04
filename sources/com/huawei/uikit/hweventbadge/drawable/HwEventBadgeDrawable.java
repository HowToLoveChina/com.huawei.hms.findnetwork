package com.huawei.uikit.hweventbadge.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.huawei.uikit.hweventbadge.C8714R;
import com.huawei.uikit.hwresources.utils.AuxiliaryHelper;
import java.util.Locale;

/* loaded from: classes7.dex */
public class HwEventBadgeDrawable extends Drawable {
    public static final int BADGE_MODE_DOT = 1;
    public static final int BADGE_MODE_TEXT = 2;

    /* renamed from: q */
    private static final String f42815q = "HwEventBadgeDrawable";

    /* renamed from: r */
    private static final int f42816r = 99;

    /* renamed from: s */
    private static final int f42817s = 10;

    /* renamed from: t */
    private static final int f42818t = 2;

    /* renamed from: u */
    private static final float f42819u = 2.0f;

    /* renamed from: v */
    private static final float f42820v = 1.75f;

    /* renamed from: a */
    private TextPaint f42821a;

    /* renamed from: b */
    private Paint f42822b;

    /* renamed from: f */
    private float f42826f;

    /* renamed from: g */
    private float f42827g;

    /* renamed from: h */
    private float f42828h;

    /* renamed from: i */
    private int f42829i;

    /* renamed from: j */
    private float f42830j;

    /* renamed from: k */
    private int f42831k;

    /* renamed from: l */
    private int f42832l;

    /* renamed from: n */
    private int f42834n;

    /* renamed from: o */
    private int f42835o;

    /* renamed from: p */
    private Context f42836p;

    /* renamed from: c */
    private int f42823c = 0;

    /* renamed from: d */
    private int f42824d = 99;

    /* renamed from: e */
    private String f42825e = "";

    /* renamed from: m */
    private int f42833m = 2;

    public HwEventBadgeDrawable() {
        m54673a();
    }

    /* renamed from: a */
    private void m54674a(Context context) {
        float f10 = context.getResources().getConfiguration().fontScale;
        this.f42828h = f10;
        if (Float.compare(f10, 1.75f) < 0 || !AuxiliaryHelper.isAuxiliaryDevice(this.f42836p)) {
            return;
        }
        Resources resources = context.getResources();
        int i10 = C8714R.dimen.hweventbadge_height_large_model;
        this.f42829i = resources.getDimensionPixelSize(i10);
        this.f42821a.setTextSize(context.getResources().getDimensionPixelSize(C8714R.dimen.emui_text_size_caption_large_model));
        this.f42831k = context.getResources().getDimensionPixelSize(i10);
    }

    public void calcBadgeLocation() {
        int i10 = this.f42831k;
        this.f42834n = i10;
        this.f42835o = i10;
        int i11 = this.f42833m;
        if (i11 == 1) {
            int i12 = this.f42829i;
            this.f42834n = i12;
            this.f42835o = i12;
        } else if (i11 == 2) {
            float fMeasureText = this.f42821a.measureText(this.f42825e);
            float fDescent = this.f42821a.descent() - this.f42821a.ascent();
            int i13 = this.f42823c;
            if (i13 > 0 && i13 < 10) {
                int i14 = this.f42831k;
                this.f42834n = i14;
                this.f42835o = i14;
            } else if (i13 >= 10) {
                this.f42834n = Math.round((this.f42832l * 2.0f) + fMeasureText);
                this.f42835o = this.f42831k;
            } else {
                Log.e(f42815q, "invalid badge count");
            }
            this.f42826f = (this.f42834n - fMeasureText) / 2.0f;
            this.f42827g = ((this.f42835o - fDescent) / 2.0f) - this.f42821a.ascent();
        } else {
            Log.e(f42815q, "invalid badge mode");
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds;
        if (canvas != null && (bounds = getBounds()) != null && bounds.right > bounds.left && bounds.bottom > bounds.top && this.f42823c > 0) {
            canvas.save();
            int i10 = this.f42833m;
            if (i10 == 1) {
                canvas.drawCircle(bounds.left + (bounds.width() / 2.0f), bounds.top + (bounds.height() / 2.0f), this.f42835o / 2.0f, this.f42822b);
            } else if (i10 == 2) {
                canvas.translate((bounds.width() - this.f42834n) / 2.0f, (bounds.height() - this.f42835o) / 2.0f);
                RectF rectF = new RectF(bounds.left, bounds.top, r2 + this.f42834n, r4 + this.f42835o);
                float f10 = this.f42830j;
                canvas.drawRoundRect(rectF, f10, f10, this.f42822b);
                canvas.drawText(this.f42825e, bounds.left + this.f42826f, bounds.top + this.f42827g, this.f42821a);
            } else {
                Log.e(f42815q, "invalid badge mode");
            }
            canvas.restore();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f42822b.getAlpha();
    }

    public int getBadgeCount() {
        return this.f42823c;
    }

    public int getBadgeMaxNumber() {
        return this.f42824d;
    }

    public int getBadgeMode() {
        return this.f42833m;
    }

    public int getBadgeTextMargin() {
        return this.f42832l;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f42835o;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f42834n;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return getAlpha() == 0 ? -2 : -3;
    }

    public TextPaint getTextPaint() {
        return this.f42821a;
    }

    public float getTextStartX() {
        return this.f42826f;
    }

    public void parseAttrsAndInit(Context context, AttributeSet attributeSet, int i10) throws Resources.NotFoundException {
        parseAttrsAndInit(context, attributeSet, i10, C8714R.style.Widget_Emui_HwEventBadge);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f42822b.setAlpha(i10);
        this.f42821a.setAlpha(i10);
    }

    public void setBackgroundColor(int i10) {
        this.f42822b.setColor(i10);
        invalidateSelf();
    }

    public void setBackgroundHeight(int i10) {
        this.f42835o = i10;
    }

    public void setBackgroundWidth(int i10) {
        this.f42834n = i10;
    }

    public void setBadgeCount(int i10) {
        setBadgeCount(i10, this.f42824d);
    }

    public void setBadgeMode(int i10) {
        if (this.f42833m != i10) {
            this.f42833m = i10;
            if (Float.compare(this.f42828h, 1.75f) >= 0 && this.f42833m == 2 && AuxiliaryHelper.isAuxiliaryDevice(this.f42836p)) {
                Resources resources = this.f42836p.getResources();
                int i11 = C8714R.dimen.hweventbadge_height_large_model;
                this.f42829i = resources.getDimensionPixelSize(i11);
                this.f42821a.setTextSize(this.f42836p.getResources().getDimensionPixelSize(C8714R.dimen.emui_text_size_caption_large_model));
                this.f42831k = this.f42836p.getResources().getDimensionPixelSize(i11);
            } else {
                this.f42829i = this.f42836p.getResources().getDimensionPixelSize(C8714R.dimen.hweventbadge_dot_size);
                this.f42821a.setTextSize(this.f42836p.getResources().getDimensionPixelSize(C8714R.dimen.emui_text_size_caption));
                this.f42831k = this.f42836p.getResources().getDimensionPixelSize(C8714R.dimen.hweventbadge_height);
            }
            calcBadgeLocation();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        super.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f42822b.setColorFilter(colorFilter);
        this.f42821a.setColorFilter(colorFilter);
    }

    public void setTextColor(int i10) {
        if (this.f42821a.getColor() != i10) {
            this.f42821a.setColor(i10);
            invalidateSelf();
        }
    }

    public void setTextStartX(float f10) {
        this.f42826f = f10;
    }

    public void parseAttrsAndInit(Context context, AttributeSet attributeSet, int i10, int i11) throws Resources.NotFoundException {
        if (context == null) {
            return;
        }
        this.f42836p = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C8714R.styleable.HwEventBadge, i10, i11);
        this.f42829i = typedArrayObtainStyledAttributes.getDimensionPixelSize(C8714R.styleable.HwEventBadge_hwEventBadgeDotSize, context.getResources().getDimensionPixelSize(C8714R.dimen.hweventbadge_dot_size));
        this.f42833m = typedArrayObtainStyledAttributes.getInt(C8714R.styleable.HwEventBadge_hwEventBadgeMode, 2);
        this.f42831k = typedArrayObtainStyledAttributes.getDimensionPixelSize(C8714R.styleable.HwEventBadge_hwEventBadgeHeight, context.getResources().getDimensionPixelSize(C8714R.dimen.hweventbadge_height));
        this.f42832l = typedArrayObtainStyledAttributes.getDimensionPixelSize(C8714R.styleable.HwEventBadge_hwEventBadgeTextMargin, context.getResources().getDimensionPixelSize(C8714R.dimen.hweventbadge_text_margin));
        this.f42821a.setColor(typedArrayObtainStyledAttributes.getColor(C8714R.styleable.HwEventBadge_hwEventBadgeTextColor, ContextCompat.getColor(context, C8714R.color.emui_text_primary_inverse)));
        this.f42821a.setTextSize(typedArrayObtainStyledAttributes.getDimensionPixelSize(C8714R.styleable.HwEventBadge_hwEventBadgeTextSize, context.getResources().getDimensionPixelSize(C8714R.dimen.emui_text_size_caption)));
        this.f42822b.setColor(typedArrayObtainStyledAttributes.getColor(C8714R.styleable.HwEventBadge_hwEventBadgeBackgroundColor, ContextCompat.getColor(context, C8714R.color.emui_functional_red)));
        calcBadgeLocation();
        this.f42830j = typedArrayObtainStyledAttributes.getDimension(C8714R.styleable.HwEventBadge_hwEventBadgeTextRadius, this.f42835o / 2.0f);
        m54674a(context);
        typedArrayObtainStyledAttributes.recycle();
    }

    public void setBadgeCount(int i10, int i11) {
        if (i10 < 0) {
            Log.w(f42815q, "setBadgeCount method: param count must be equals or bigger than zero");
            return;
        }
        if (this.f42823c != i10) {
            this.f42823c = i10;
        }
        if (this.f42824d != i11) {
            this.f42824d = i11;
        }
        if (this.f42823c <= i11) {
            this.f42825e = String.format(Locale.getDefault(), "%d", Integer.valueOf(this.f42823c));
        } else {
            this.f42825e = String.format(Locale.getDefault(), "%d+", Integer.valueOf(i11));
        }
        calcBadgeLocation();
    }

    /* renamed from: a */
    private void m54673a() {
        TextPaint textPaint = new TextPaint();
        this.f42821a = textPaint;
        textPaint.setAntiAlias(true);
        this.f42821a.setFilterBitmap(true);
        Paint paint = new Paint();
        this.f42822b = paint;
        paint.setAntiAlias(true);
    }
}
