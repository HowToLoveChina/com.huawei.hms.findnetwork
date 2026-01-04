package com.huawei.android.hicloud.p088ui.uiextend;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.huawei.hicloud.sync.R$styleable;

/* loaded from: classes3.dex */
public class CustomRoundImageView extends AppCompatImageView {
    private int cornerBottomLeftRadius;
    private int cornerBottomRightRadius;
    private int cornerRadius;
    private int cornerTopLeftRadius;
    private int cornerTopRightRadius;
    private Path mPath;

    public CustomRoundImageView(Context context) {
        super(context);
        this.mPath = new Path();
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        setLayerType(2, null);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CustomRoundImageView, 0, 0);
        for (int i10 = 0; i10 < typedArrayObtainStyledAttributes.getIndexCount(); i10++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i10);
            if (index == R$styleable.CustomRoundImageView_corner_radius) {
                this.cornerRadius = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.cornerRadius);
            } else if (index == R$styleable.CustomRoundImageView_corner_top_left_radius) {
                this.cornerTopLeftRadius = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.cornerTopLeftRadius);
            } else if (index == R$styleable.CustomRoundImageView_corner_top_right_radius) {
                this.cornerTopRightRadius = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.cornerTopRightRadius);
            } else if (index == R$styleable.CustomRoundImageView_corner_bottom_left_radius) {
                this.cornerBottomLeftRadius = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.cornerBottomLeftRadius);
            } else if (index == R$styleable.CustomRoundImageView_corner_bottom_right_radius) {
                this.cornerBottomRightRadius = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.cornerBottomRightRadius);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        canvas.clipPath(this.mPath);
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (z10) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            float[] fArr = new float[8];
            if (this.cornerRadius > 0) {
                for (int i14 = 0; i14 < 8; i14++) {
                    fArr[i14] = this.cornerRadius;
                }
            } else if (getLayoutDirection() == 0) {
                float f10 = this.cornerTopLeftRadius;
                fArr[1] = f10;
                fArr[0] = f10;
                float f11 = this.cornerTopRightRadius;
                fArr[3] = f11;
                fArr[2] = f11;
                float f12 = this.cornerBottomRightRadius;
                fArr[5] = f12;
                fArr[4] = f12;
                float f13 = this.cornerBottomLeftRadius;
                fArr[7] = f13;
                fArr[6] = f13;
            } else {
                float f14 = this.cornerTopRightRadius;
                fArr[1] = f14;
                fArr[0] = f14;
                float f15 = this.cornerTopLeftRadius;
                fArr[3] = f15;
                fArr[2] = f15;
                float f16 = this.cornerBottomLeftRadius;
                fArr[5] = f16;
                fArr[4] = f16;
                float f17 = this.cornerBottomRightRadius;
                fArr[7] = f17;
                fArr[6] = f17;
            }
            this.mPath.reset();
            this.mPath.addRoundRect(new RectF(0.0f, 0.0f, measuredWidth, measuredHeight), fArr, Path.Direction.CW);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
    }

    public void setCornerRadius(int i10) {
        this.cornerRadius = i10;
    }

    public CustomRoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPath = new Path();
        init(context, attributeSet);
    }

    public CustomRoundImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mPath = new Path();
        init(context, attributeSet);
    }
}
