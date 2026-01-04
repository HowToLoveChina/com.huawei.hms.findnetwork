package com.huawei.uikit.hwprogressbar.graphics.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/* loaded from: classes2.dex */
public class HwFlickerDrawable extends Drawable {

    /* renamed from: n */
    private static final String f43036n = "HwFlickerDrawable";

    /* renamed from: o */
    private static final float f43037o = 0.3f;

    /* renamed from: p */
    private static final int f43038p = 2000;

    /* renamed from: q */
    private static final int f43039q = 10000;

    /* renamed from: r */
    private static final int f43040r = 1728053247;

    /* renamed from: s */
    private static final float f43041s = 0.93f;

    /* renamed from: t */
    private static final int f43042t = 16777215;

    /* renamed from: u */
    private static final int f43043u = 0;

    /* renamed from: v */
    private static final int f43044v = 1;

    /* renamed from: w */
    private static final int f43045w = 2;

    /* renamed from: a */
    private Paint f43046a;

    /* renamed from: b */
    private float f43047b;

    /* renamed from: c */
    private float f43048c;

    /* renamed from: d */
    private float f43049d;

    /* renamed from: e */
    private float f43050e;

    /* renamed from: i */
    private int f43054i;

    /* renamed from: k */
    private long f43056k;

    /* renamed from: l */
    private LinearGradient f43057l;

    /* renamed from: f */
    private int f43051f = f43040r;

    /* renamed from: g */
    private boolean f43052g = true;

    /* renamed from: h */
    private float f43053h = 0.0f;

    /* renamed from: j */
    private boolean f43055j = false;

    /* renamed from: m */
    private Runnable f43058m = new bzrwd();

    public class bzrwd implements Runnable {
        public bzrwd() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HwFlickerDrawable.this.invalidateSelf();
        }
    }

    public HwFlickerDrawable() {
        Paint paint = new Paint();
        this.f43046a = paint;
        paint.setAntiAlias(true);
        this.f43046a.setStyle(Paint.Style.FILL);
        this.f43047b = 0.0f;
        this.f43049d = 0.0f;
        m54737a(2);
    }

    /* renamed from: a */
    private void m54738a(long j10) {
        this.f43056k = j10;
    }

    /* renamed from: b */
    private void m54739b() {
        int i10 = this.f43051f;
        int i11 = f43042t & i10;
        float[] fArr = {0.0f, f43041s, 1.0f};
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, this.f43049d, 0.0f, new int[]{i11, i10, i11}, fArr, Shader.TileMode.CLAMP);
        this.f43057l = linearGradient;
        this.f43046a.setShader(linearGradient);
    }

    /* renamed from: c */
    private boolean m54740c() {
        return this.f43054i == 2;
    }

    /* renamed from: d */
    private boolean m54741d() {
        return this.f43055j && this.f43052g;
    }

    /* renamed from: e */
    private void m54742e() {
        this.f43050e = -this.f43049d;
    }

    /* renamed from: f */
    private void m54743f() {
        this.f43053h = (this.f43049d + this.f43048c) / 2000.0f;
        if (this.f43052g) {
            this.f43052g = false;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (m54740c()) {
            this.f43055j = false;
            return;
        }
        m54743f();
        float fM54735a = this.f43050e + (this.f43053h * m54735a());
        if (Float.compare(fM54735a, this.f43048c) > 0) {
            int i10 = (int) this.f43048c;
            if (i10 != 0) {
                fM54735a = (fM54735a % i10) - this.f43049d;
            }
            this.f43052g = true;
        }
        this.f43050e = fM54735a;
        canvas.save();
        canvas.translate(fM54735a, 0.0f);
        Rect bounds = getBounds();
        float f10 = Float.compare(this.f43049d + fM54735a, this.f43048c) > 0 ? this.f43048c - fM54735a : this.f43049d;
        if (Float.compare(fM54735a, 0.0f) < 0) {
            float f11 = bounds.left - fM54735a;
            canvas.clipRect(f11, bounds.top, f11 + f10, bounds.bottom);
        }
        float f12 = bounds.left;
        canvas.drawRect(f12, bounds.top, f12 + f10, bounds.bottom, this.f43046a);
        canvas.restore();
        scheduleSelf(this.f43058m, 0L);
        if (m54741d()) {
            this.f43055j = false;
            stop();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public boolean isRunning() {
        return this.f43054i != 2;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i10) {
        this.f43048c = (this.f43047b * i10) / 10000.0f;
        return false;
    }

    public void pause() {
        if (this.f43054i == 1) {
            return;
        }
        this.f43055j = true;
        m54737a(1);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        super.setBounds(rect);
        m54736a(rect.left, rect.right);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public void setFlickerColor(int i10) {
        if (this.f43051f != i10) {
            this.f43051f = i10;
            m54739b();
        }
    }

    public void start() {
        if (this.f43054i == 0) {
            return;
        }
        this.f43055j = false;
        m54738a(System.currentTimeMillis());
        scheduleSelf(this.f43058m, 0L);
        m54737a(0);
    }

    public void stop() {
        m54742e();
        m54737a(2);
    }

    /* renamed from: a */
    private long m54735a() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j10 = jCurrentTimeMillis - this.f43056k;
        m54738a(jCurrentTimeMillis);
        if (j10 < 0) {
            return 0L;
        }
        return j10;
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i10, int i11, int i12, int i13) {
        super.setBounds(i10, i11, i12, i13);
        m54736a(i10, i12);
    }

    /* renamed from: a */
    private void m54737a(int i10) {
        this.f43054i = i10;
    }

    /* renamed from: a */
    private void m54736a(float f10, float f11) {
        float f12 = f11 - f10;
        this.f43047b = f12;
        float level = (f12 * getLevel()) / 10000.0f;
        this.f43048c = level;
        float f13 = this.f43047b * 0.3f;
        this.f43049d = f13;
        this.f43053h = (f13 + level) / 2000.0f;
        m54742e();
        m54739b();
    }
}
