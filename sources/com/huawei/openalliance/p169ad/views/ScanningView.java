package com.huawei.openalliance.p169ad.views;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.InterpolatorC7160gq;

/* loaded from: classes2.dex */
public class ScanningView extends View {

    /* renamed from: a */
    private int f37376a;

    /* renamed from: b */
    private Bitmap f37377b;

    /* renamed from: c */
    private Bitmap f37378c;

    /* renamed from: d */
    private Paint f37379d;

    /* renamed from: e */
    private Paint f37380e;

    /* renamed from: f */
    private PorterDuffXfermode f37381f;

    /* renamed from: g */
    private float f37382g;

    /* renamed from: h */
    private float f37383h;

    /* renamed from: i */
    private float f37384i;

    /* renamed from: j */
    private ValueAnimator f37385j;

    /* renamed from: k */
    private Animator.AnimatorListener f37386k;

    public ScanningView(Context context) {
        super(context);
        m49921d();
    }

    /* renamed from: c */
    private void m49919c() {
        this.f37378c = BitmapFactory.decodeResource(getResources(), this.f37376a);
    }

    /* renamed from: d */
    private void m49921d() {
        Paint paint = new Paint(1);
        this.f37379d = paint;
        paint.setDither(true);
        this.f37379d.setFilterBitmap(true);
        Paint paint2 = new Paint(1);
        this.f37380e = paint2;
        paint2.setDither(true);
        this.f37380e.setStyle(Paint.Style.FILL);
        this.f37380e.setColor(-1);
        this.f37380e.setFilterBitmap(true);
        this.f37381f = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m49922e() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.f37383h, this.f37384i);
        this.f37385j = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(new InterpolatorC7160gq(0.33f, 0.0f, 0.67f, 1.0f));
        this.f37385j.setDuration(2500L);
        this.f37385j.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.huawei.openalliance.ad.views.ScanningView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ScanningView.this.f37382g = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ScanningView.this.postInvalidate();
            }
        });
        this.f37385j.addListener(new AnimatorListenerAdapter() { // from class: com.huawei.openalliance.ad.views.ScanningView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                ScanningView.this.setVisibility(8);
                if (ScanningView.this.f37386k != null) {
                    ScanningView.this.f37386k.onAnimationCancel(animator);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ScanningView.this.setVisibility(8);
                if (ScanningView.this.f37386k != null) {
                    ScanningView.this.f37386k.onAnimationEnd(animator);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ScanningView.this.setVisibility(0);
                if (ScanningView.this.f37386k != null) {
                    ScanningView.this.f37386k.onAnimationStart(animator);
                }
            }
        });
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.f37377b == null) {
            return;
        }
        try {
            int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), this.f37379d, 31);
            canvas.drawBitmap(this.f37378c, 0.0f, this.f37382g, this.f37379d);
            this.f37379d.setXfermode(this.f37381f);
            canvas.drawBitmap(this.f37377b, 0.0f, 0.0f, this.f37379d);
            this.f37379d.setXfermode(null);
            canvas.restoreToCount(iSaveLayer);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("ScanningView", "draw exception: %s", th2.getClass().getSimpleName());
        }
        super.draw(canvas);
    }

    public Bitmap getSrcBitmap() {
        return this.f37377b;
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        m49919c();
        float f10 = i11;
        this.f37383h = f10;
        this.f37382g = f10;
        this.f37384i = -i11;
    }

    public void setAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.f37386k = animatorListener;
    }

    public void setSrcBitmap(Bitmap bitmap) {
        this.f37377b = bitmap;
    }

    public ScanningView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* renamed from: b */
    public void m49924b() {
        ValueAnimator valueAnimator = this.f37385j;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f37385j.cancel();
        }
        this.f37382g = this.f37383h;
        postInvalidate();
    }

    public ScanningView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        m49921d();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C6849R.styleable.ScanningView);
        this.f37376a = typedArrayObtainStyledAttributes.getResourceId(C6849R.styleable.ScanningView_lightImage, C6849R.drawable.hiad_arrow_scan);
        typedArrayObtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    public void m49923a() {
        if (this.f37377b == null) {
            AbstractC7185ho.m43820b("ScanningView", "start, mSrcBitmap is null");
        } else {
            post(new Runnable() { // from class: com.huawei.openalliance.ad.views.ScanningView.3
                @Override // java.lang.Runnable
                public void run() {
                    if (ScanningView.this.f37385j == null) {
                        ScanningView.this.m49922e();
                    } else if (ScanningView.this.f37385j.isRunning()) {
                        ScanningView.this.f37385j.cancel();
                    }
                    ScanningView.this.f37385j.start();
                }
            });
        }
    }
}
