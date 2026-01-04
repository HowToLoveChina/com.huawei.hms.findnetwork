package com.huawei.openalliance.p169ad.views;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;

@OuterVisible
/* loaded from: classes2.dex */
public class PPSFlickerDrawable extends Drawable {

    /* renamed from: a */
    private Paint f36642a;

    /* renamed from: b */
    private float f36643b;

    /* renamed from: c */
    private float f36644c;

    /* renamed from: d */
    private float f36645d;

    /* renamed from: e */
    private float f36646e;

    /* renamed from: i */
    private int f36650i;

    /* renamed from: k */
    private long f36652k;

    /* renamed from: l */
    private LinearGradient f36653l;

    /* renamed from: m */
    private float f36654m;

    /* renamed from: n */
    private boolean f36655n;

    /* renamed from: f */
    private int f36647f = 1728053247;

    /* renamed from: g */
    private boolean f36648g = true;

    /* renamed from: h */
    private float f36649h = 0.0f;

    /* renamed from: j */
    private boolean f36651j = false;

    @OuterVisible
    public PPSFlickerDrawable() {
        m49044c();
    }

    /* renamed from: c */
    private void m49044c() {
        Paint paint = new Paint();
        this.f36642a = paint;
        paint.setAntiAlias(true);
        this.f36642a.setStyle(Paint.Style.FILL);
        this.f36643b = 0.0f;
        this.f36645d = 0.0f;
        m49042a(2);
        this.f36655n = AbstractC7811dd.m48332h();
    }

    /* renamed from: d */
    private boolean m49045d() {
        return this.f36650i == 2;
    }

    /* renamed from: e */
    private boolean m49046e() {
        return this.f36651j && this.f36648g;
    }

    /* renamed from: f */
    private void m49047f() {
        this.f36649h = (this.f36645d + this.f36644c) / 2000.0f;
        if (this.f36648g) {
            this.f36648g = false;
        }
    }

    /* renamed from: g */
    private long m49048g() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j10 = jCurrentTimeMillis - this.f36652k;
        m49043a(jCurrentTimeMillis);
        if (j10 < 0) {
            return 0L;
        }
        return j10;
    }

    /* renamed from: h */
    private void m49049h() {
        int i10 = this.f36647f;
        int i11 = 16777215 & i10;
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, this.f36645d, 0.0f, new int[]{i11, i10, i11}, new float[]{0.0f, 0.93f, 1.0f}, Shader.TileMode.CLAMP);
        this.f36653l = linearGradient;
        this.f36642a.setShader(linearGradient);
    }

    /* renamed from: i */
    private void m49050i() {
        this.f36646e = -this.f36645d;
    }

    /* renamed from: a */
    public void m49051a() {
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43817a("HwFlickerDrawable", "start()");
        }
        if (this.f36650i == 0) {
            return;
        }
        this.f36651j = false;
        m49043a(System.currentTimeMillis());
        invalidateSelf();
        m49042a(0);
    }

    /* renamed from: b */
    public void m49052b() {
        if (AbstractC7185ho.m43819a()) {
            AbstractC7185ho.m43817a("HwFlickerDrawable", "stop()");
        }
        m49050i();
        m49042a(2);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (m49045d()) {
            this.f36651j = false;
            return;
        }
        m49047f();
        float fM49048g = this.f36646e + (this.f36649h * m49048g());
        if (Float.compare(fM49048g, this.f36644c) > 0) {
            if (((int) this.f36644c) != 0) {
                fM49048g = (fM49048g % ((int) r0)) - this.f36645d;
            }
            this.f36648g = true;
        }
        this.f36646e = fM49048g;
        Rect bounds = getBounds();
        if (Float.compare(this.f36654m, 0.0f) > 0) {
            RectF rectF = new RectF();
            rectF.set(bounds);
            Path path = new Path();
            float f10 = this.f36654m;
            path.addRoundRect(rectF, f10, f10, Path.Direction.CW);
            canvas.clipPath(path);
        }
        if (this.f36655n) {
            canvas.scale(-1.0f, 1.0f, bounds.width() / 2.0f, bounds.height() / 2.0f);
        }
        canvas.save();
        canvas.translate(fM49048g, 0.0f);
        float f11 = Float.compare(this.f36645d + fM49048g, this.f36644c) > 0 ? this.f36644c - fM49048g : this.f36645d;
        if (Float.compare(fM49048g, 0.0f) < 0) {
            int i10 = bounds.left;
            canvas.clipRect(i10 - fM49048g, bounds.top, (i10 - fM49048g) + f11, bounds.bottom);
        }
        int i11 = bounds.left;
        canvas.drawRect(i11, bounds.top, i11 + f11, bounds.bottom, this.f36642a);
        canvas.restore();
        invalidateSelf();
        if (m49046e()) {
            this.f36651j = false;
            m49052b();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i10) {
        this.f36644c = (this.f36643b * i10) / 10000.0f;
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i10, int i11, int i12, int i13) {
        super.setBounds(i10, i11, i12, i13);
        m49041a(i10, i12);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    @OuterVisible
    public PPSFlickerDrawable(float f10) {
        this.f36654m = f10;
        m49044c();
    }

    /* renamed from: a */
    private void m49041a(float f10, float f11) {
        float f12 = f11 - f10;
        this.f36643b = f12;
        float level = (f12 * getLevel()) / 10000.0f;
        this.f36644c = level;
        float f13 = this.f36643b * 0.3f;
        this.f36645d = f13;
        this.f36649h = (f13 + level) / 2000.0f;
        m49050i();
        m49049h();
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        super.setBounds(rect);
        m49041a(rect.left, rect.right);
    }

    /* renamed from: a */
    private void m49042a(int i10) {
        this.f36650i = i10;
    }

    /* renamed from: a */
    private void m49043a(long j10) {
        this.f36652k = j10;
    }
}
