package com.huawei.android.hicloud.p088ui.uiextend;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$styleable;
import java.util.Arrays;
import p015ak.C0209d;
import p514o9.C11839m;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes3.dex */
public class RoundRectImageView extends ImageView {
    private static final int ALL_NONE = 4;
    public static final int TABLET_DEFAULT_BORDER_WIDTH = 2;
    private static final int TOP_TWO_CORNERS = 3;
    private static final int TWO_CORNERS = 2;
    private ImageView favourIcon;
    private boolean isNeedRound;
    private boolean isShowBorder;
    private int mBorderColor;
    private boolean mBorderEnable;
    private Paint mBorderPaint;
    private float mBorderWidth;
    private Path mMaskPath;
    private int mMode;
    private float mRadius;
    private ScaleExType mScaleExType;
    protected int mViewHeight;
    protected int mViewWidth;

    public enum ScaleExType {
        DEFAULT(0),
        BOTTOM_CENTER(1),
        EXT_BOTTOM_CENTER(2);

        final int nativeInt;

        ScaleExType(int i10) {
            this.nativeInt = i10;
        }
    }

    public RoundRectImageView(Context context) {
        super(context);
        this.mMaskPath = new Path();
        this.mScaleExType = ScaleExType.DEFAULT;
        this.mBorderPaint = new Paint();
        this.mBorderWidth = 1.0f;
        this.isShowBorder = true;
        this.mBorderEnable = false;
        this.isNeedRound = true;
        init(null);
    }

    private void drawBorder(Canvas canvas) {
        if (this.mBorderEnable && this.mBorderWidth > 0.0f && this.isShowBorder) {
            int width = getWidth();
            int height = getHeight();
            this.mBorderPaint.setColor(this.mBorderColor);
            this.mBorderPaint.setStyle(Paint.Style.STROKE);
            this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
            this.mBorderPaint.setAntiAlias(true);
            float f10 = this.mBorderWidth / 2.0f;
            if (this.mMode == 4) {
                canvas.drawRoundRect(f10, f10, width - f10, height - f10, 0.0f, 0.0f, this.mBorderPaint);
            } else {
                float f11 = this.mRadius;
                canvas.drawRoundRect(f10, f10, width - f10, height - f10, f11, f11, this.mBorderPaint);
            }
        }
    }

    private void init(AttributeSet attributeSet) {
        setLayerType(2, null);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.RoundRectImageView);
            this.mRadius = typedArrayObtainStyledAttributes.getDimension(R$styleable.RoundRectImageView_round_radius, 0.0f);
            this.mMode = typedArrayObtainStyledAttributes.getInt(R$styleable.RoundRectImageView_hidisk_shape_mode, 1);
            this.mBorderEnable = typedArrayObtainStyledAttributes.getBoolean(R$styleable.RoundRectImageView_border_enable, false);
            this.mBorderWidth = typedArrayObtainStyledAttributes.getFloat(R$styleable.RoundRectImageView_border_width, 1.0f);
            if (C0209d.m1170F1()) {
                this.mBorderWidth = 2.0f;
            }
            this.mBorderColor = typedArrayObtainStyledAttributes.getColor(R$styleable.RoundRectImageView_border_color, getContext().getColor(R$color.hidisk_image_corner_color));
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static void setBorderImageViewByBitmap(ImageView imageView, Bitmap bitmap) {
        setImageViewByBitmap(imageView, bitmap, true, ScaleExType.DEFAULT, true);
    }

    public static void setBorderScaleDefault(ImageView imageView, Drawable drawable) {
        setImageViewByDrawable(imageView, drawable, true, ScaleExType.DEFAULT, true);
    }

    public static void setImageViewByBitmap(ImageView imageView, Bitmap bitmap, boolean z10, ScaleExType scaleExType, boolean z11) {
        if (imageView instanceof RoundRectImageView) {
            ((RoundRectImageView) imageView).setImageBitmap(bitmap, z10, scaleExType, z11);
        } else if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
    }

    public static void setImageViewByDrawable(ImageView imageView, Drawable drawable, boolean z10, ScaleExType scaleExType, boolean z11) {
        if (imageView instanceof RoundRectImageView) {
            ((RoundRectImageView) imageView).setImageDrawable(drawable, z10, scaleExType, z11);
        } else if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    public static void setNoBorderBottomCenter(ImageView imageView, Drawable drawable) {
        setImageViewByDrawable(imageView, drawable, false, ScaleExType.BOTTOM_CENTER, false);
    }

    public static void setNoBorderImageViewByBitmap(ImageView imageView, Bitmap bitmap) {
        setImageViewByBitmap(imageView, bitmap, false, ScaleExType.DEFAULT, true);
    }

    public static void setNoBorderScaleDefault(ImageView imageView, Drawable drawable) {
        setImageViewByDrawable(imageView, drawable, false, ScaleExType.DEFAULT, true);
    }

    public boolean drawNonDefaultCanvas(int i10, int i11, Canvas canvas, Drawable drawable) {
        if (i10 > this.mViewWidth || i11 > this.mViewHeight) {
            return false;
        }
        canvas.save();
        canvas.translate((this.mViewWidth - i10) / 2.0f, this.mViewHeight - i11);
        drawable.draw(canvas);
        canvas.restore();
        return true;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Drawable drawable;
        if (this.isNeedRound && this.mRadius > 0.0f) {
            canvas.clipPath(this.mMaskPath);
        }
        try {
            drawable = getDrawable();
        } catch (Exception unused) {
            C11839m.m70688i("RoundRectImageView", "Slide too fast, Bitmap recycling is not timely!");
        }
        if (drawable == null) {
            return;
        }
        int iWidth = drawable.getBounds().width();
        int iHeight = drawable.getBounds().height();
        if (!this.mBorderEnable || this.mScaleExType == ScaleExType.DEFAULT || !drawNonDefaultCanvas(iWidth, iHeight, canvas, drawable)) {
            super.onDraw(canvas);
        }
        drawBorder(canvas);
    }

    @Override // android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (z10) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            float f10 = this.mRadius;
            if (f10 != 0.0f) {
                float[] fArr = new float[8];
                int i14 = this.mMode;
                if (i14 == 2) {
                    Arrays.fill(fArr, 4, 8, f10);
                } else if (i14 == 3) {
                    Arrays.fill(fArr, 0, 4, f10);
                } else if (i14 == 4) {
                    Arrays.fill(fArr, 0.0f);
                } else {
                    Arrays.fill(fArr, f10);
                }
                this.mMaskPath.reset();
                this.mMaskPath.addRoundRect(new RectF(0.0f, 0.0f, measuredWidth, measuredHeight), fArr, Path.Direction.CW);
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        this.mViewWidth = getMeasuredWidth();
        this.mViewHeight = getMeasuredHeight();
    }

    public void setBorderColor(int i10) {
        this.mBorderColor = i10;
    }

    public void setBorderEnable(boolean z10) {
        this.mBorderEnable = z10;
    }

    public void setBorderWidth(float f10) {
        this.mBorderWidth = f10;
        if (C0209d.m1170F1()) {
            this.mBorderWidth = 2.0f;
        }
    }

    public void setFavourIcon(ImageView imageView) {
        this.favourIcon = imageView;
    }

    public void setImageBitmap(Bitmap bitmap, boolean z10, ScaleExType scaleExType, boolean z11) {
        this.isShowBorder = z10;
        this.mScaleExType = scaleExType;
        this.isNeedRound = z11;
        super.setImageBitmap(bitmap);
    }

    public void setImageDrawable(Drawable drawable, boolean z10, ScaleExType scaleExType, boolean z11) {
        this.isShowBorder = z10;
        this.mScaleExType = scaleExType;
        this.isNeedRound = z11;
        setImageDrawable(drawable);
        setFavourIcon(drawable);
    }

    public void setImageResId(int i10, boolean z10, ScaleExType scaleExType, boolean z11) {
        this.isShowBorder = z10;
        this.mScaleExType = scaleExType;
        this.isNeedRound = z11;
        Drawable drawable = getContext().getDrawable(i10);
        super.setImageDrawable(drawable);
        setFavourIcon(drawable);
    }

    public void setScaleExType(ScaleExType scaleExType) {
        this.mScaleExType = scaleExType;
    }

    private void setFavourIcon(Drawable drawable) {
        int i10;
        int i11;
        int iWidth = drawable.getBounds().width();
        int iHeight = drawable.getBounds().height();
        if (this.favourIcon != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.favourIcon.getLayoutParams());
            if (this.mScaleExType != ScaleExType.EXT_BOTTOM_CENTER || iWidth > (i10 = this.mViewWidth) || iHeight > (i11 = this.mViewHeight)) {
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
            } else {
                layoutParams.leftMargin = (i10 - iWidth) / 2;
                layoutParams.topMargin = i11 - iHeight;
            }
            this.favourIcon.setLayoutParams(layoutParams);
        }
    }

    public void setImageBitmap(Bitmap bitmap, boolean z10) {
        setImageBitmap(bitmap, z10, ScaleExType.DEFAULT, true);
    }

    public void setImageDrawable(Drawable drawable, boolean z10) {
        setImageDrawable(drawable, z10, ScaleExType.DEFAULT, true);
    }

    public RoundRectImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMaskPath = new Path();
        this.mScaleExType = ScaleExType.DEFAULT;
        this.mBorderPaint = new Paint();
        this.mBorderWidth = 1.0f;
        this.isShowBorder = true;
        this.mBorderEnable = false;
        this.isNeedRound = true;
        init(attributeSet);
    }

    public RoundRectImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mMaskPath = new Path();
        this.mScaleExType = ScaleExType.DEFAULT;
        this.mBorderPaint = new Paint();
        this.mBorderWidth = 1.0f;
        this.isShowBorder = true;
        this.mBorderEnable = false;
        this.isNeedRound = true;
        init(attributeSet);
    }
}
