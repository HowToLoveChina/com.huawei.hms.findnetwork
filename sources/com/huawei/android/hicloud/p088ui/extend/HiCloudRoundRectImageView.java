package com.huawei.android.hicloud.p088ui.extend;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.huawei.hicloud.sync.R$styleable;
import java.util.Arrays;
import p514o9.C11839m;
import p514o9.C11842p;

/* loaded from: classes3.dex */
public class HiCloudRoundRectImageView extends ImageView {
    public static final int ALL_CORNERS = 0;
    private static final int DEFAULT_CORNER_RADIUS = 16;
    private static final int DEFAULT_GIF_CORNER_RADIUS = 32;
    private static final String TAG = "HiCloudRoundRectImageView";
    public static final int TOP_TWO_CORNERS = 1;
    private int cornerRadius;
    private Path mMaskPath;
    private int mMode;
    protected Paint roundPaint;

    public HiCloudRoundRectImageView(Context context) {
        this(context, null);
    }

    private Bitmap convertForegroundToBitmap(Drawable drawable, Drawable drawable2) {
        if (drawable == null || drawable2 == null) {
            return null;
        }
        if (drawable2 instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable2).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable2.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable2.draw(canvas);
        return bitmapCreateBitmap;
    }

    private void drawBitMap(Canvas canvas, Bitmap bitmap) {
        if (bitmap != null) {
            Bitmap roundBitmap = getRoundBitmap(bitmap, this.cornerRadius);
            Rect rect = new Rect(0, 0, roundBitmap.getWidth(), roundBitmap.getHeight());
            Rect rect2 = new Rect(0, 0, getWidth(), getHeight());
            this.roundPaint.reset();
            canvas.drawBitmap(roundBitmap, rect, rect2, this.roundPaint);
        }
    }

    public Bitmap getRoundBitmap(Bitmap bitmap, int i10) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        this.roundPaint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        this.roundPaint.setColor(-12434878);
        float f10 = i10;
        canvas.drawRoundRect(rectF, f10, f10, this.roundPaint);
        this.roundPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, this.roundPaint);
        return bitmapCreateBitmap;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        try {
            Drawable drawable = getDrawable();
            if (drawable instanceof BitmapDrawable) {
                drawBitMap(canvas, ((BitmapDrawable) drawable).getBitmap());
            } else {
                canvas.clipPath(this.mMaskPath);
                super.onDraw(canvas);
            }
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "onDraw exception:" + e10.getMessage());
            super.onDraw(canvas);
        }
    }

    @Override // android.view.View
    public void onDrawForeground(Canvas canvas) {
        if (getForeground() == null) {
            return;
        }
        try {
            Drawable drawable = getDrawable();
            if (drawable instanceof BitmapDrawable) {
                drawBitMap(canvas, convertForegroundToBitmap(drawable, getForeground()));
            } else {
                canvas.clipPath(this.mMaskPath);
                super.onDrawForeground(canvas);
            }
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "onDrawForeground exception:" + e10.getMessage());
            super.onDrawForeground(canvas);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (z10) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            if (this.cornerRadius != 0) {
                float[] fArr = new float[8];
                if (this.mMode == 1) {
                    Arrays.fill(fArr, 0, 4, 32.0f);
                } else {
                    Arrays.fill(fArr, 32.0f);
                }
                this.mMaskPath.reset();
                this.mMaskPath.addRoundRect(new RectF(0.0f, 0.0f, measuredWidth, measuredHeight), fArr, Path.Direction.CW);
            }
        }
    }

    public void setCornerRadius(int i10) {
        this.cornerRadius = i10;
    }

    public void setMode(int i10) {
        this.mMode = i10;
    }

    public HiCloudRoundRectImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HiCloudRoundRectImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mMaskPath = new Path();
        this.roundPaint = new Paint();
        this.cornerRadius = context.obtainStyledAttributes(attributeSet, R$styleable.round_corner_image_attr).getDimensionPixelSize(C11842p.m70840n(context, R$styleable.round_corner_image_attr_cornerRadius), C11842p.m70840n(context, 16));
    }
}
