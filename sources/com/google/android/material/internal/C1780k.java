package com.google.android.material.internal;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;

/* renamed from: com.google.android.material.internal.k */
/* loaded from: classes.dex */
public final class C1780k {

    /* renamed from: n */
    public static final int f8381n = 1;

    /* renamed from: a */
    public CharSequence f8382a;

    /* renamed from: b */
    public final TextPaint f8383b;

    /* renamed from: c */
    public final int f8384c;

    /* renamed from: e */
    public int f8386e;

    /* renamed from: l */
    public boolean f8393l;

    /* renamed from: d */
    public int f8385d = 0;

    /* renamed from: f */
    public Layout.Alignment f8387f = Layout.Alignment.ALIGN_NORMAL;

    /* renamed from: g */
    public int f8388g = Integer.MAX_VALUE;

    /* renamed from: h */
    public float f8389h = 0.0f;

    /* renamed from: i */
    public float f8390i = 1.0f;

    /* renamed from: j */
    public int f8391j = f8381n;

    /* renamed from: k */
    public boolean f8392k = true;

    /* renamed from: m */
    public TextUtils.TruncateAt f8394m = null;

    /* renamed from: com.google.android.material.internal.k$a */
    public static class a extends Exception {
    }

    public C1780k(CharSequence charSequence, TextPaint textPaint, int i10) {
        this.f8382a = charSequence;
        this.f8383b = textPaint;
        this.f8384c = i10;
        this.f8386e = charSequence.length();
    }

    /* renamed from: b */
    public static C1780k m10743b(CharSequence charSequence, TextPaint textPaint, int i10) {
        return new C1780k(charSequence, textPaint, i10);
    }

    /* renamed from: a */
    public StaticLayout m10744a() throws a {
        if (this.f8382a == null) {
            this.f8382a = "";
        }
        int iMax = Math.max(0, this.f8384c);
        CharSequence charSequenceEllipsize = this.f8382a;
        if (this.f8388g == 1) {
            charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, this.f8383b, iMax, this.f8394m);
        }
        int iMin = Math.min(charSequenceEllipsize.length(), this.f8386e);
        this.f8386e = iMin;
        if (this.f8393l && this.f8388g == 1) {
            this.f8387f = Layout.Alignment.ALIGN_OPPOSITE;
        }
        StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequenceEllipsize, this.f8385d, iMin, this.f8383b, iMax);
        builderObtain.setAlignment(this.f8387f);
        builderObtain.setIncludePad(this.f8392k);
        builderObtain.setTextDirection(this.f8393l ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
        TextUtils.TruncateAt truncateAt = this.f8394m;
        if (truncateAt != null) {
            builderObtain.setEllipsize(truncateAt);
        }
        builderObtain.setMaxLines(this.f8388g);
        float f10 = this.f8389h;
        if (f10 != 0.0f || this.f8390i != 1.0f) {
            builderObtain.setLineSpacing(f10, this.f8390i);
        }
        if (this.f8388g > 1) {
            builderObtain.setHyphenationFrequency(this.f8391j);
        }
        return builderObtain.build();
    }

    /* renamed from: c */
    public C1780k m10745c(Layout.Alignment alignment) {
        this.f8387f = alignment;
        return this;
    }

    /* renamed from: d */
    public C1780k m10746d(TextUtils.TruncateAt truncateAt) {
        this.f8394m = truncateAt;
        return this;
    }

    /* renamed from: e */
    public C1780k m10747e(int i10) {
        this.f8391j = i10;
        return this;
    }

    /* renamed from: f */
    public C1780k m10748f(boolean z10) {
        this.f8392k = z10;
        return this;
    }

    /* renamed from: g */
    public C1780k m10749g(boolean z10) {
        this.f8393l = z10;
        return this;
    }

    /* renamed from: h */
    public C1780k m10750h(float f10, float f11) {
        this.f8389h = f10;
        this.f8390i = f11;
        return this;
    }

    /* renamed from: i */
    public C1780k m10751i(int i10) {
        this.f8388g = i10;
        return this;
    }
}
