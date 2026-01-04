package com.huawei.android.hicloud.p088ui.extend;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.huawei.hicloud.sync.R$styleable;
import p514o9.C11842p;

/* loaded from: classes3.dex */
public class ScaleRoundRectImageView extends AppCompatImageView {

    /* renamed from: a */
    public int f17951a;

    /* renamed from: b */
    public float f17952b;

    /* renamed from: c */
    public float f17953c;

    /* renamed from: d */
    public Path f17954d;

    public ScaleRoundRectImageView(Context context) {
        this(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes;
        if (attributeSet != null && (typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ScaleRoundRectImageView)) != null) {
            try {
                this.f17951a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.ScaleRoundRectImageView_sriRadius, C11842p.m70840n(context, 16));
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        }
        this.f17954d = new Path();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int i10 = this.f17951a;
        int i11 = i10 * 2;
        int i12 = i10 * 2;
        if (this.f17952b >= i11 && this.f17953c > i12) {
            this.f17954d.reset();
            this.f17954d.moveTo(this.f17951a, 0.0f);
            this.f17954d.lineTo(this.f17952b - this.f17951a, 0.0f);
            Path path = this.f17954d;
            float f10 = this.f17952b;
            path.quadTo(f10, 0.0f, f10, this.f17951a);
            this.f17954d.lineTo(this.f17952b, this.f17953c - this.f17951a);
            Path path2 = this.f17954d;
            float f11 = this.f17952b;
            float f12 = this.f17953c;
            path2.quadTo(f11, f12, f11 - this.f17951a, f12);
            this.f17954d.lineTo(this.f17951a, this.f17953c);
            Path path3 = this.f17954d;
            float f13 = this.f17953c;
            path3.quadTo(0.0f, f13, 0.0f, f13 - this.f17951a);
            this.f17954d.lineTo(0.0f, this.f17951a);
            this.f17954d.quadTo(0.0f, 0.0f, this.f17951a, 0.0f);
            canvas.clipPath(this.f17954d);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        this.f17952b = getWidth();
        this.f17953c = getHeight();
    }

    public void setCornerRadius(int i10) {
        this.f17951a = i10;
    }

    public ScaleRoundRectImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScaleRoundRectImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        init(context, attributeSet);
    }
}
