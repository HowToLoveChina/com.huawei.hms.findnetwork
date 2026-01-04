package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import p243e0.C9373h;

/* renamed from: androidx.emoji2.text.i */
/* loaded from: classes.dex */
public abstract class AbstractC0692i extends ReplacementSpan {

    /* renamed from: b */
    public final C0690g f3647b;

    /* renamed from: a */
    public final Paint.FontMetricsInt f3646a = new Paint.FontMetricsInt();

    /* renamed from: c */
    public short f3648c = -1;

    /* renamed from: d */
    public short f3649d = -1;

    /* renamed from: e */
    public float f3650e = 1.0f;

    public AbstractC0692i(C0690g c0690g) {
        C9373h.m58746g(c0690g, "metadata cannot be null");
        this.f3647b = c0690g;
    }

    /* renamed from: a */
    public final C0690g m4277a() {
        return this.f3647b;
    }

    /* renamed from: b */
    public final int m4278b() {
        return this.f3648c;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, @SuppressLint({"UnknownNullness"}) CharSequence charSequence, int i10, int i11, Paint.FontMetricsInt fontMetricsInt) {
        paint.getFontMetricsInt(this.f3646a);
        Paint.FontMetricsInt fontMetricsInt2 = this.f3646a;
        this.f3650e = (Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent) * 1.0f) / this.f3647b.m4252e();
        this.f3649d = (short) (this.f3647b.m4252e() * this.f3650e);
        short sM4256i = (short) (this.f3647b.m4256i() * this.f3650e);
        this.f3648c = sM4256i;
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt3 = this.f3646a;
            fontMetricsInt.ascent = fontMetricsInt3.ascent;
            fontMetricsInt.descent = fontMetricsInt3.descent;
            fontMetricsInt.top = fontMetricsInt3.top;
            fontMetricsInt.bottom = fontMetricsInt3.bottom;
        }
        return sM4256i;
    }
}
