package com.huawei.uikit.animations.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.util.Log;

/* loaded from: classes6.dex */
public class HwLowFrameLoadingDrawable extends BitmapDrawable {

    /* renamed from: A */
    private static final float f40935A = 0.125f;
    public static final int DEFAULT_DRAWABLE_BITMAP_SIZE = 50;
    public static final int DEFAULT_LOADING_DURATION = 600;

    /* renamed from: l */
    private static final String f40936l = "HwLowFrameLoadingDrawable";

    /* renamed from: m */
    private static final int f40937m = 250;

    /* renamed from: n */
    private static final int f40938n = -7697782;

    /* renamed from: o */
    private static final int f40939o = -13421773;

    /* renamed from: p */
    private static final float f40940p = 0.0f;

    /* renamed from: q */
    private static final float f40941q = 0.0f;

    /* renamed from: r */
    private static final float f40942r = 0.5f;

    /* renamed from: s */
    private static final float f40943s = 0.125f;

    /* renamed from: t */
    private static final float f40944t = 0.85f;

    /* renamed from: u */
    private static final int f40945u = 45;

    /* renamed from: v */
    private static final int f40946v = 360;

    /* renamed from: w */
    private static final int f40947w = 8;

    /* renamed from: x */
    private static final int f40948x = 3;

    /* renamed from: y */
    private static final float f40949y = 0.0f;

    /* renamed from: z */
    private static final float f40950z = 1.0f;

    /* renamed from: a */
    private int f40951a;

    /* renamed from: b */
    private float f40952b;

    /* renamed from: c */
    private int f40953c;

    /* renamed from: d */
    private float f40954d;

    /* renamed from: e */
    private float f40955e;

    /* renamed from: f */
    private float f40956f;

    /* renamed from: g */
    private float f40957g;

    /* renamed from: h */
    private float f40958h;

    /* renamed from: i */
    private Paint f40959i;

    /* renamed from: j */
    private Handler f40960j;

    /* renamed from: k */
    private Runnable f40961k;

    public class bzrwd implements Runnable {

        /* renamed from: a */
        float f40962a = 0.0f;

        public bzrwd() {
        }

        @Override // java.lang.Runnable
        public void run() {
            float f10 = this.f40962a + 0.125f;
            this.f40962a = f10;
            if (f10 > 1.0f) {
                this.f40962a = f10 - 1.0f;
            }
            HwLowFrameLoadingDrawable.this.m53757a(this.f40962a);
            HwLowFrameLoadingDrawable.this.f40960j.postDelayed(this, HwLowFrameLoadingDrawable.this.f40953c);
        }
    }

    public HwLowFrameLoadingDrawable(Resources resources, int i10) {
        this(resources, i10, 600);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (canvas == null) {
            Log.e(f40936l, "draw error: canvas is null.");
            return;
        }
        this.f40959i.setColor(this.f40951a);
        m53760b(canvas);
        if (this.f40952b > 1.0f) {
            this.f40952b = 0.0f;
        }
        canvas.save();
        for (int i10 = 0; i10 < 8; i10++) {
            int i11 = (int) (this.f40952b / 0.125f);
            int i12 = i11 + 3;
            if (i12 > 8) {
                int i13 = i11 - 5;
                if (i10 >= i11 || i10 < i13) {
                    this.f40959i.setColor(f40939o);
                } else {
                    this.f40959i.setColor(f40938n);
                }
            } else if (i10 < i11 || i10 >= i12) {
                this.f40959i.setColor(f40938n);
            } else {
                this.f40959i.setColor(f40939o);
            }
            canvas.drawCircle(this.f40957g, this.f40958h, this.f40954d, this.f40959i);
            canvas.rotate(45.0f, this.f40955e, this.f40956f);
        }
        canvas.restore();
    }

    public HwLowFrameLoadingDrawable(Resources resources, int i10, int i11) {
        super(resources, Bitmap.createBitmap(Math.min(i10, 250), Math.min(i10, 250), Bitmap.Config.ARGB_8888));
        this.f40952b = 0.0f;
        this.f40960j = new Handler();
        this.f40961k = new bzrwd();
        this.f40953c = i11;
        m53756a();
    }

    /* renamed from: b */
    private void m53760b(Canvas canvas) {
        float fM53754a = m53754a(canvas);
        float f10 = f40944t * fM53754a;
        this.f40954d = fM53754a * 0.125f;
        this.f40957g = this.f40955e;
        this.f40958h = this.f40956f - f10;
    }

    /* renamed from: a */
    private void m53756a() {
        Paint paint = new Paint();
        this.f40959i = paint;
        this.f40955e = 0.0f;
        this.f40956f = 0.0f;
        this.f40951a = f40938n;
        paint.setColor(f40938n);
        this.f40959i.setAntiAlias(true);
        m53757a(0.0f);
        this.f40960j.postDelayed(this.f40961k, this.f40953c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m53757a(float f10) {
        this.f40952b = f10;
        invalidateSelf();
    }

    /* renamed from: a */
    private float m53754a(Canvas canvas) {
        this.f40955e = canvas.getWidth() * f40942r;
        float height = canvas.getHeight() * f40942r;
        this.f40956f = height;
        return Math.min(this.f40955e, height);
    }
}
