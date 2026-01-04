package androidx.emoji2.text;

import android.text.TextPaint;
import androidx.emoji2.text.C0688e;
import p723w.C13505d;

/* renamed from: androidx.emoji2.text.d */
/* loaded from: classes.dex */
public class C0687d implements C0688e.d {

    /* renamed from: b */
    public static final ThreadLocal<StringBuilder> f3592b = new ThreadLocal<>();

    /* renamed from: a */
    public final TextPaint f3593a;

    public C0687d() {
        TextPaint textPaint = new TextPaint();
        this.f3593a = textPaint;
        textPaint.setTextSize(10.0f);
    }

    /* renamed from: b */
    public static StringBuilder m4218b() {
        ThreadLocal<StringBuilder> threadLocal = f3592b;
        if (threadLocal.get() == null) {
            threadLocal.set(new StringBuilder());
        }
        return threadLocal.get();
    }

    @Override // androidx.emoji2.text.C0688e.d
    /* renamed from: a */
    public boolean mo4219a(CharSequence charSequence, int i10, int i11, int i12) {
        StringBuilder sbM4218b = m4218b();
        sbM4218b.setLength(0);
        while (i10 < i11) {
            sbM4218b.append(charSequence.charAt(i10));
            i10++;
        }
        return C13505d.m81233a(this.f3593a, sbM4218b.toString());
    }
}
