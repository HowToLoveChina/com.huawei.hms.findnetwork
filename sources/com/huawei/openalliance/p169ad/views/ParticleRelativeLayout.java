package com.huawei.openalliance.p169ad.views;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.AbstractC7558os;
import com.huawei.openalliance.p169ad.C6849R;
import com.huawei.openalliance.p169ad.inter.data.AdLandingPageData;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8112e;
import com.huawei.uikit.hwrecyclerview.widget.HwItemTouchHelperEx;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class ParticleRelativeLayout extends AutoScaleSizeRelativeLayout implements InterfaceC8112e {

    /* renamed from: a */
    private static final int f37240a = C6849R.drawable.hiad_filled_circle;

    /* renamed from: b */
    private static final int f37241b = C6849R.drawable.hiad_hollow_circle;

    /* renamed from: c */
    private int f37242c;

    /* renamed from: d */
    private Bitmap f37243d;

    /* renamed from: e */
    private Paint f37244e;

    /* renamed from: f */
    private Paint f37245f;

    /* renamed from: g */
    private ValueAnimator f37246g;

    /* renamed from: h */
    private List<C8186y> f37247h;

    /* renamed from: i */
    private PorterDuffXfermode f37248i;

    /* renamed from: j */
    private View f37249j;

    /* renamed from: k */
    private AdLandingPageData f37250k;

    /* renamed from: l */
    private boolean f37251l;

    /* renamed from: m */
    private boolean f37252m;

    /* renamed from: n */
    private Handler f37253n;

    public ParticleRelativeLayout(Context context) {
        super(context);
        this.f37251l = false;
        this.f37252m = true;
        this.f37253n = new Handler(Looper.myLooper(), new Handler.Callback() { // from class: com.huawei.openalliance.ad.views.ParticleRelativeLayout.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (AbstractC7760bg.m47767a(ParticleRelativeLayout.this.f37247h)) {
                    return true;
                }
                for (C8186y c8186y : ParticleRelativeLayout.this.f37247h) {
                    if (c8186y.m50715a() != null) {
                        c8186y.m50715a().start();
                    }
                }
                return true;
            }
        });
        m49771c();
    }

    /* renamed from: a */
    private Bitmap m49766a(int i10) throws Resources.NotFoundException {
        Drawable drawable = getResources().getDrawable(i10);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    /* renamed from: c */
    private void m49771c() {
        AbstractC7185ho.m43820b("ParticleRelativeLayout", "init");
        try {
            this.f37247h = new ArrayList();
            Paint paint = new Paint(1);
            this.f37245f = paint;
            paint.setDither(true);
            this.f37245f.setFilterBitmap(true);
            Paint paint2 = new Paint(1);
            this.f37244e = paint2;
            paint2.setDither(true);
            this.f37244e.setStyle(Paint.Style.FILL);
            this.f37244e.setColor(-1);
            this.f37244e.setFilterBitmap(true);
            this.f37248i = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("ParticleRelativeLayout", "init exception: %s", th2.getClass().getSimpleName());
        }
    }

    /* renamed from: f */
    private void m49777f() {
        try {
            if (getHeight() == 0 || getWidth() == 0) {
                AbstractC7185ho.m43820b("ParticleRelativeLayout", "not support particle animator");
            } else if (m49779h()) {
                m49780i();
            } else {
                m49778g();
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("ParticleRelativeLayout", "initParticleAnimator error: %s", th2.getClass().getSimpleName());
        }
    }

    /* renamed from: g */
    private void m49778g() {
        int i10 = f37241b;
        m49769a(new int[]{0, 300}, new float[][]{new float[]{0.375f, 0.239f}, new float[]{0.75f, 1.119f}, new float[]{0.0f, 0.9f}}, i10);
        m49769a(new int[]{50, 300}, new float[][]{new float[]{0.314f, 0.083f}, new float[]{0.369f, -0.065f}, new float[]{0.0f, 0.5f}}, i10);
        int i11 = f37240a;
        m49769a(new int[]{0, 300}, new float[][]{new float[]{0.683f, 0.825f}, new float[]{0.315f, -0.155f}, new float[]{0.0f, 1.0f}}, i11);
        m49769a(new int[]{0, HwItemTouchHelperEx.Callback.DEFAULT_SWIPE_ANIMATION_DURATION}, new float[][]{new float[]{0.436f, 0.369f}, new float[]{0.298f, -0.107f}, new float[]{0.0f, 0.7f}}, i11);
        m49769a(new int[]{50, 300}, new float[][]{new float[]{0.244f, 0.05f}, new float[]{0.667f, 1.054f}, new float[]{0.0f, 0.4f}}, i11);
        m49769a(new int[]{0, 300}, new float[][]{new float[]{0.692f, 0.953f}, new float[]{0.708f, 1.089f}, new float[]{0.0f, 0.7f}}, i11);
    }

    /* renamed from: h */
    private boolean m49779h() {
        return AbstractC7558os.m46467f(this.f37250k.m44290f()) == 2 || AbstractC7741ao.m47592n(getContext());
    }

    /* renamed from: i */
    private void m49780i() {
        int i10 = f37240a;
        m49769a(new int[]{50, HwItemTouchHelperEx.Callback.DEFAULT_SWIPE_ANIMATION_DURATION}, new float[][]{new float[]{0.668f, 0.74f}, new float[]{0.363f, -0.131f}, new float[]{0.0f, 1.0f}}, i10);
        m49769a(new int[]{100, 300}, new float[][]{new float[]{0.535f, 0.582f}, new float[]{0.797f, 1.12f}, new float[]{0.0f, 1.0f}}, i10);
        m49769a(new int[]{0, HwItemTouchHelperEx.Callback.DEFAULT_SWIPE_ANIMATION_DURATION}, new float[][]{new float[]{0.488f, 0.465f}, new float[]{0.268f, -0.107f}, new float[]{0.0f, 0.9f}}, i10);
        m49769a(new int[]{50, HwItemTouchHelperEx.Callback.DEFAULT_SWIPE_ANIMATION_DURATION}, new float[][]{new float[]{0.171f, 0.073f}, new float[]{0.429f, -0.107f}, new float[]{0.0f, 0.6f}}, i10);
        m49769a(new int[]{150, 200}, new float[][]{new float[]{0.299f, 0.253f}, new float[]{0.268f, -0.071f}, new float[]{0.0f, 0.4f}}, i10);
        m49769a(new int[]{0, HwItemTouchHelperEx.Callback.DEFAULT_SWIPE_ANIMATION_DURATION}, new float[][]{new float[]{0.124f, 0.017f}, new float[]{0.369f, -0.155f}, new float[]{0.0f, 1.0f}}, i10);
        m49769a(new int[]{100, 200}, new float[][]{new float[]{0.204f, 0.168f}, new float[]{0.762f, 1.054f}, new float[]{0.0f, 0.4f}}, i10);
        m49769a(new int[]{0, HwItemTouchHelperEx.Callback.DEFAULT_SWIPE_ANIMATION_DURATION}, new float[][]{new float[]{0.15f, 0.11f}, new float[]{0.702f, 1.071f}, new float[]{0.0f, 0.5f}}, i10);
        m49769a(new int[]{50, 350}, new float[][]{new float[]{0.58f, 0.654f}, new float[]{0.446f, -0.065f}, new float[]{0.0f, 0.45f}}, i10);
        m49769a(new int[]{0, HwItemTouchHelperEx.Callback.DEFAULT_SWIPE_ANIMATION_DURATION}, new float[][]{new float[]{0.655f, 0.685f}, new float[]{0.774f, 1.065f}, new float[]{0.0f, 0.4f}}, i10);
        m49769a(new int[]{50, 200}, new float[][]{new float[]{0.884f, 1.01f}, new float[]{0.506f, -0.077f}, new float[]{0.0f, 0.8f}}, i10);
        int i11 = f37241b;
        m49769a(new int[]{0, HwItemTouchHelperEx.Callback.DEFAULT_SWIPE_ANIMATION_DURATION}, new float[][]{new float[]{0.465f, 0.431f}, new float[]{0.786f, 1.071f}, new float[]{0.0f, 0.5f}}, i11);
        m49769a(new int[]{50, HwItemTouchHelperEx.Callback.DEFAULT_SWIPE_ANIMATION_DURATION}, new float[][]{new float[]{0.261f, 0.203f}, new float[]{0.357f, -0.077f}, new float[]{0.0f, 0.6f}}, i11);
        m49769a(new int[]{0, HwItemTouchHelperEx.Callback.DEFAULT_SWIPE_ANIMATION_DURATION}, new float[][]{new float[]{0.778f, 0.854f}, new float[]{0.357f, -0.101f}, new float[]{0.0f, 0.8f}}, i11);
        m49769a(new int[]{50, HwItemTouchHelperEx.Callback.DEFAULT_SWIPE_ANIMATION_DURATION}, new float[][]{new float[]{0.711f, 0.794f}, new float[]{0.429f, -0.054f}, new float[]{0.0f, 0.4f}}, i11);
        m49769a(new int[]{100, 300}, new float[][]{new float[]{0.809f, 0.885f}, new float[]{0.72f, 1.125f}, new float[]{0.0f, 1.0f}}, i11);
    }

    /* renamed from: j */
    private void m49781j() {
        ValueAnimator valueAnimatorOfPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofKeyframe(View.SCALE_X, Keyframe.ofFloat(0.0f, 1.0f), Keyframe.ofFloat(0.2f, 0.95f), Keyframe.ofFloat(0.4f, 1.0f), Keyframe.ofFloat(1.0f, 1.0f)), PropertyValuesHolder.ofKeyframe(View.SCALE_Y, Keyframe.ofFloat(0.0f, 1.0f), Keyframe.ofFloat(0.2f, 0.95f), Keyframe.ofFloat(0.4f, 1.0f), Keyframe.ofFloat(1.0f, 1.0f)));
        this.f37246g = valueAnimatorOfPropertyValuesHolder;
        valueAnimatorOfPropertyValuesHolder.setDuration(1500L);
        this.f37246g.setTarget(this.f37249j);
        if (this.f37251l) {
            this.f37246g.setRepeatCount(-1);
        }
        this.f37246g.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.huawei.openalliance.ad.views.ParticleRelativeLayout.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ParticleRelativeLayout.this.f37249j == null || ParticleRelativeLayout.this.f37246g == null) {
                    return;
                }
                ParticleRelativeLayout.this.f37249j.setScaleY(((Float) ParticleRelativeLayout.this.f37246g.getAnimatedValue()).floatValue());
                ParticleRelativeLayout.this.f37249j.setScaleX(((Float) ParticleRelativeLayout.this.f37246g.getAnimatedValue()).floatValue());
            }
        });
        this.f37246g.addListener(new AnimatorListenerAdapter() { // from class: com.huawei.openalliance.ad.views.ParticleRelativeLayout.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                if (ParticleRelativeLayout.this.f37253n != null) {
                    ParticleRelativeLayout.this.f37253n.sendEmptyMessageDelayed(1002, 300L);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator, boolean z10) {
                if (ParticleRelativeLayout.this.f37253n != null) {
                    ParticleRelativeLayout.this.f37253n.sendEmptyMessageDelayed(1002, 300L);
                }
            }
        });
    }

    /* renamed from: k */
    private void m49782k() {
        if (AbstractC7760bg.m47767a(this.f37247h)) {
            return;
        }
        this.f37247h.clear();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f37243d == null) {
            return;
        }
        try {
            int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), this.f37245f, 31);
            m49768a(canvas);
            this.f37245f.setXfermode(this.f37248i);
            canvas.drawBitmap(this.f37243d, 0.0f, 0.0f, this.f37245f);
            this.f37245f.setXfermode(null);
            canvas.restoreToCount(iSaveLayer);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("ParticleRelativeLayout", "dispatchDraw exception: %s", th2.getClass().getSimpleName());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            ValueAnimator valueAnimator = this.f37246g;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f37246g.cancel();
            }
            this.f37250k = null;
            this.f37249j = null;
            m49782k();
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("ParticleRelativeLayout", "onDetachedFromWindow exception: %s", th2.getClass().getSimpleName());
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        AbstractC7185ho.m43820b("ParticleRelativeLayout", "onSizeChanged");
        m49774d();
        if (!this.f37252m && this.f37251l && this.f37250k != null) {
            m49782k();
            m49777f();
        }
        if (i10 == 0 || i11 == 0) {
            return;
        }
        this.f37252m = false;
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8112e
    public void setAutoRepeat(boolean z10) {
        this.f37251l = z10;
    }

    public void setRadius(int i10) {
        this.f37242c = i10;
        setRectCornerRadius(AbstractC7741ao.m47535a(getContext(), i10));
    }

    public ParticleRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* renamed from: d */
    private void m49774d() {
        if (getHeight() <= 0 || getWidth() <= 0) {
            return;
        }
        try {
            this.f37243d = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
            new Canvas(this.f37243d).drawRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), AbstractC7741ao.m47535a(getContext(), this.f37242c), AbstractC7741ao.m47535a(getContext(), this.f37242c), this.f37244e);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("ParticleRelativeLayout", "createBitMapException: %s", th2.getClass().getSimpleName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m49776e() {
        try {
            m49781j();
            m49777f();
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("ParticleRelativeLayout", "init animator exception: %s", th2.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8112e
    /* renamed from: b */
    public boolean mo49785b() {
        ValueAnimator valueAnimator = this.f37246g;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    public ParticleRelativeLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f37251l = false;
        this.f37252m = true;
        this.f37253n = new Handler(Looper.myLooper(), new Handler.Callback() { // from class: com.huawei.openalliance.ad.views.ParticleRelativeLayout.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (AbstractC7760bg.m47767a(ParticleRelativeLayout.this.f37247h)) {
                    return true;
                }
                for (C8186y c8186y : ParticleRelativeLayout.this.f37247h) {
                    if (c8186y.m50715a() != null) {
                        c8186y.m50715a().start();
                    }
                }
                return true;
            }
        });
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C6849R.styleable.ScanningRelativeLayout);
        this.f37242c = typedArrayObtainStyledAttributes.getDimensionPixelOffset(C6849R.styleable.ScanningRelativeLayout_layoutRadius, 36);
        typedArrayObtainStyledAttributes.recycle();
        m49771c();
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8112e
    /* renamed from: a */
    public void mo49783a() {
        AbstractC7185ho.m43820b("ParticleRelativeLayout", "stop");
        try {
            ValueAnimator valueAnimator = this.f37246g;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f37246g.cancel();
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("ParticleRelativeLayout", "cancel animator exception: %s", th2.getClass().getSimpleName());
        }
        postInvalidate();
    }

    /* renamed from: a */
    private void m49768a(Canvas canvas) {
        try {
            for (C8186y c8186y : this.f37247h) {
                canvas.drawBitmap(c8186y.m50720f(), (Rect) null, new RectF(c8186y.m50716b(), c8186y.m50717c(), c8186y.m50718d(), c8186y.m50719e()), this.f37245f);
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("ParticleRelativeLayout", "drawBitmaps: %s", th2.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8112e
    /* renamed from: a */
    public void mo49784a(View view, AdLandingPageData adLandingPageData) {
        if (view == null || adLandingPageData == null) {
            AbstractC7185ho.m43820b("ParticleRelativeLayout", "view or adLandingPageData is null");
            return;
        }
        AbstractC7185ho.m43820b("ParticleRelativeLayout", "start");
        this.f37249j = view;
        this.f37250k = adLandingPageData;
        post(new Runnable() { // from class: com.huawei.openalliance.ad.views.ParticleRelativeLayout.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (ParticleRelativeLayout.this.f37246g == null) {
                        ParticleRelativeLayout.this.m49776e();
                    } else if (ParticleRelativeLayout.this.f37246g.isRunning()) {
                        ParticleRelativeLayout.this.f37246g.cancel();
                    }
                    ParticleRelativeLayout.this.f37246g.start();
                } catch (Throwable th2) {
                    AbstractC7185ho.m43824c("ParticleRelativeLayout", "start animator exception: %s", th2.getClass().getSimpleName());
                }
            }
        });
    }

    /* renamed from: a */
    private void m49769a(int[] iArr, float[][] fArr, int i10) {
        if (this.f37247h != null) {
            this.f37247h.add(new C8186y(fArr, iArr, m49766a(i10), this));
        }
    }
}
