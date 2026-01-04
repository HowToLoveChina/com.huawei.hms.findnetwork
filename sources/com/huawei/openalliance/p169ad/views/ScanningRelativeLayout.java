package com.huawei.openalliance.p169ad.views;

import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.InterpolatorC7160gq;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import com.huawei.openalliance.p169ad.inter.data.AdLandingPageData;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8112e;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public class ScanningRelativeLayout extends AutoScaleSizeRelativeLayout implements InterfaceC8112e {

    /* renamed from: a */
    private int f37361a;

    /* renamed from: b */
    private int f37362b;

    /* renamed from: c */
    private Bitmap f37363c;

    /* renamed from: d */
    private Bitmap f37364d;

    /* renamed from: e */
    private Paint f37365e;

    /* renamed from: f */
    private Paint f37366f;

    /* renamed from: g */
    private float f37367g;

    /* renamed from: h */
    private float f37368h;

    /* renamed from: i */
    private float f37369i;

    /* renamed from: j */
    private ValueAnimator f37370j;

    /* renamed from: k */
    private PorterDuffXfermode f37371k;

    /* renamed from: l */
    private boolean f37372l;

    /* renamed from: m */
    private boolean f37373m;

    /* renamed from: com.huawei.openalliance.ad.views.ScanningRelativeLayout$1 */
    public class RunnableC80531 implements Runnable {
        public RunnableC80531() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (ScanningRelativeLayout.this.f37370j == null) {
                    ScanningRelativeLayout.this.m49913g();
                } else if (ScanningRelativeLayout.this.f37370j.isRunning()) {
                    ScanningRelativeLayout.this.f37370j.cancel();
                }
                ScanningRelativeLayout.this.f37370j.start();
            } catch (Throwable th2) {
                AbstractC7185ho.m43824c("ScanningRelativeLayout", "start scan exception: %s", th2.getClass().getSimpleName());
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.views.ScanningRelativeLayout$a */
    public static class C8054a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        private WeakReference<ScanningRelativeLayout> f37375a;

        public C8054a(ScanningRelativeLayout scanningRelativeLayout) {
            this.f37375a = new WeakReference<>(scanningRelativeLayout);
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ScanningRelativeLayout scanningRelativeLayout = this.f37375a.get();
            if (scanningRelativeLayout == null || valueAnimator == null) {
                return;
            }
            scanningRelativeLayout.setLeft(((Float) valueAnimator.getAnimatedValue()).floatValue());
            scanningRelativeLayout.postInvalidate();
        }
    }

    public ScanningRelativeLayout(Context context) {
        super(context);
        this.f37372l = false;
        this.f37373m = true;
        m49911e();
    }

    /* renamed from: e */
    private void m49911e() {
        AbstractC7185ho.m43820b("ScanningRelativeLayout", "init");
        try {
            Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(getResources(), this.f37361a);
            this.f37364d = bitmapDecodeResource;
            if (bitmapDecodeResource != null && AbstractC7811dd.m48315c()) {
                Matrix matrix = new Matrix();
                matrix.postScale(-1.0f, 1.0f);
                Bitmap bitmap = this.f37364d;
                this.f37364d = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), this.f37364d.getHeight(), matrix, false);
            }
            float f10 = -this.f37364d.getWidth();
            this.f37368h = f10;
            this.f37367g = f10;
            Paint paint = new Paint(1);
            this.f37366f = paint;
            paint.setDither(true);
            this.f37366f.setFilterBitmap(true);
            Paint paint2 = new Paint(1);
            this.f37365e = paint2;
            paint2.setDither(true);
            this.f37365e.setStyle(Paint.Style.FILL);
            this.f37365e.setColor(-1);
            this.f37365e.setFilterBitmap(true);
            this.f37371k = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("ScanningRelativeLayout", "init exception: %s", th2.getClass().getSimpleName());
        }
    }

    /* renamed from: f */
    private void m49912f() {
        if (getHeight() <= 0 || getWidth() <= 0) {
            return;
        }
        try {
            this.f37363c = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
            new Canvas(this.f37363c).drawRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), AbstractC7741ao.m47535a(getContext(), this.f37362b), AbstractC7741ao.m47535a(getContext(), this.f37362b), this.f37365e);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("ScanningRelativeLayout", "createBitMapException: %s", th2.getClass().getSimpleName());
        }
    }

    /* renamed from: g */
    public void m49913g() {
        try {
            ValueAnimator valueAnimatorOfPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(AbstractC7811dd.m48315c() ? PropertyValuesHolder.ofKeyframe(View.TRANSLATION_X, Keyframe.ofFloat(0.0f, this.f37369i), Keyframe.ofFloat(1.0f, this.f37368h)) : PropertyValuesHolder.ofKeyframe(View.TRANSLATION_X, Keyframe.ofFloat(0.0f, this.f37368h), Keyframe.ofFloat(1.0f, this.f37369i)));
            this.f37370j = valueAnimatorOfPropertyValuesHolder;
            valueAnimatorOfPropertyValuesHolder.setInterpolator(new InterpolatorC7160gq(0.2f, 0.0f, 0.2f, 1.0f));
            this.f37370j.setDuration(1500L);
            if (this.f37372l) {
                this.f37370j.setRepeatCount(-1);
            }
            this.f37370j.addUpdateListener(new C8054a(this));
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("ScanningRelativeLayout", "init animator exception: %s", th2.getClass().getSimpleName());
        }
    }

    /* renamed from: c */
    public void m49914c() {
        AbstractC7185ho.m43820b("ScanningRelativeLayout", ParamConstants.CallbackMethod.ON_PREPARE);
        try {
            ValueAnimator valueAnimator = this.f37370j;
            if (valueAnimator == null) {
                m49913g();
            } else if (valueAnimator.isRunning()) {
                this.f37370j.cancel();
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("ScanningRelativeLayout", "prepare scan exception: %s", th2.getClass().getSimpleName());
        }
    }

    /* renamed from: d */
    public void m49915d() {
        AbstractC7185ho.m43820b("ScanningRelativeLayout", "start");
        post(new Runnable() { // from class: com.huawei.openalliance.ad.views.ScanningRelativeLayout.1
            public RunnableC80531() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (ScanningRelativeLayout.this.f37370j == null) {
                        ScanningRelativeLayout.this.m49913g();
                    } else if (ScanningRelativeLayout.this.f37370j.isRunning()) {
                        ScanningRelativeLayout.this.f37370j.cancel();
                    }
                    ScanningRelativeLayout.this.f37370j.start();
                } catch (Throwable th2) {
                    AbstractC7185ho.m43824c("ScanningRelativeLayout", "start scan exception: %s", th2.getClass().getSimpleName());
                }
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f37363c == null) {
            return;
        }
        try {
            canvas.drawBitmap(this.f37364d, this.f37367g, 0.0f, this.f37366f);
            int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), this.f37366f, 31);
            this.f37366f.setXfermode(this.f37371k);
            canvas.drawBitmap(this.f37363c, 0.0f, 0.0f, this.f37366f);
            this.f37366f.setXfermode(null);
            canvas.restoreToCount(iSaveLayer);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("ScanningRelativeLayout", "dispatchDraw exception: %s", th2.getClass().getSimpleName());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            ValueAnimator valueAnimator = this.f37370j;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                return;
            }
            this.f37370j.cancel();
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("ScanningRelativeLayout", "animator cancel exception: %s", th2.getClass().getSimpleName());
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        ValueAnimator valueAnimator;
        super.onSizeChanged(i10, i11, i12, i13);
        AbstractC7185ho.m43820b("ScanningRelativeLayout", "onSizeChanged");
        m49912f();
        this.f37369i = i10;
        if (!this.f37373m && this.f37372l && (valueAnimator = this.f37370j) != null) {
            boolean zIsRunning = valueAnimator.isRunning();
            if (zIsRunning) {
                this.f37370j.cancel();
            }
            this.f37370j = null;
            m49913g();
            ValueAnimator valueAnimator2 = this.f37370j;
            if (valueAnimator2 != null && zIsRunning) {
                valueAnimator2.start();
            }
        }
        if (i10 == 0 || i11 == 0) {
            return;
        }
        this.f37373m = false;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8112e
    public void setAutoRepeat(boolean z10) {
        this.f37372l = z10;
    }

    public void setLeft(float f10) {
        this.f37367g = f10;
    }

    public void setRadius(int i10) {
        this.f37362b = i10;
        setRectCornerRadius(AbstractC7741ao.m47535a(getContext(), i10));
    }

    public ScanningRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8112e
    /* renamed from: a */
    public void mo49783a() {
        AbstractC7185ho.m43820b("ScanningRelativeLayout", "stop");
        try {
            ValueAnimator valueAnimator = this.f37370j;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f37370j.cancel();
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("ScanningRelativeLayout", "cancel animation exception: %s", th2.getClass().getSimpleName());
        }
        this.f37367g = this.f37368h;
        postInvalidate();
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8112e
    /* renamed from: b */
    public boolean mo49785b() {
        ValueAnimator valueAnimator = this.f37370j;
        if (valueAnimator == null) {
            return false;
        }
        return valueAnimator.isRunning();
    }

    public ScanningRelativeLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f37372l = false;
        this.f37373m = true;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C6849R.styleable.ScanningRelativeLayout);
        this.f37361a = typedArrayObtainStyledAttributes.getResourceId(C6849R.styleable.ScanningRelativeLayout_layoutScanImage, C6849R.drawable.hiad_scan);
        this.f37362b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(C6849R.styleable.ScanningRelativeLayout_layoutRadius, 36);
        typedArrayObtainStyledAttributes.recycle();
        m49911e();
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8112e
    /* renamed from: a */
    public void mo49784a(View view, AdLandingPageData adLandingPageData) {
        m49915d();
    }
}
