package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import p465m0.C11386a;

/* renamed from: androidx.emoji2.text.g */
/* loaded from: classes.dex */
public class C0690g {

    /* renamed from: d */
    public static final ThreadLocal<C11386a> f3629d = new ThreadLocal<>();

    /* renamed from: a */
    public final int f3630a;

    /* renamed from: b */
    public final C0696m f3631b;

    /* renamed from: c */
    public volatile int f3632c = 0;

    public C0690g(C0696m c0696m, int i10) {
        this.f3631b = c0696m;
        this.f3630a = i10;
    }

    /* renamed from: a */
    public void m4248a(Canvas canvas, float f10, float f11, Paint paint) {
        Typeface typefaceM4302g = this.f3631b.m4302g();
        Typeface typeface = paint.getTypeface();
        paint.setTypeface(typefaceM4302g);
        canvas.drawText(this.f3631b.m4298c(), this.f3630a * 2, 2, f10, f11, paint);
        paint.setTypeface(typeface);
    }

    /* renamed from: b */
    public int m4249b(int i10) {
        return m4254g().m68277h(i10);
    }

    /* renamed from: c */
    public int m4250c() {
        return m4254g().m68278i();
    }

    @SuppressLint({"KotlinPropertyAccess"})
    /* renamed from: d */
    public int m4251d() {
        return this.f3632c;
    }

    /* renamed from: e */
    public short m4252e() {
        return m4254g().m68280k();
    }

    /* renamed from: f */
    public int m4253f() {
        return m4254g().m68281l();
    }

    /* renamed from: g */
    public final C11386a m4254g() {
        ThreadLocal<C11386a> threadLocal = f3629d;
        C11386a c11386a = threadLocal.get();
        if (c11386a == null) {
            c11386a = new C11386a();
            threadLocal.set(c11386a);
        }
        this.f3631b.m4299d().m68288j(c11386a, this.f3630a);
        return c11386a;
    }

    /* renamed from: h */
    public short m4255h() {
        return m4254g().m68282m();
    }

    /* renamed from: i */
    public short m4256i() {
        return m4254g().m68283n();
    }

    /* renamed from: j */
    public boolean m4257j() {
        return m4254g().m68279j();
    }

    @SuppressLint({"KotlinPropertyAccess"})
    /* renamed from: k */
    public void m4258k(boolean z10) {
        this.f3632c = z10 ? 2 : 1;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append(", id:");
        sb2.append(Integer.toHexString(m4253f()));
        sb2.append(", codepoints:");
        int iM4250c = m4250c();
        for (int i10 = 0; i10 < iM4250c; i10++) {
            sb2.append(Integer.toHexString(m4249b(i10)));
            sb2.append(" ");
        }
        return sb2.toString();
    }
}
