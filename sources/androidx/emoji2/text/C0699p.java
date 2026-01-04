package androidx.emoji2.text;

import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import java.util.stream.IntStream;
import p212d0.C8971c;

/* renamed from: androidx.emoji2.text.p */
/* loaded from: classes.dex */
public class C0699p implements Spannable {

    /* renamed from: a */
    public boolean f3677a = false;

    /* renamed from: b */
    public Spannable f3678b;

    /* renamed from: androidx.emoji2.text.p$a */
    public static class a {
        /* renamed from: a */
        public static IntStream m4323a(CharSequence charSequence) {
            return charSequence.chars();
        }

        /* renamed from: b */
        public static IntStream m4324b(CharSequence charSequence) {
            return charSequence.codePoints();
        }
    }

    /* renamed from: androidx.emoji2.text.p$b */
    public static class b {
        /* renamed from: a */
        public boolean mo4325a(CharSequence charSequence) {
            throw null;
        }
    }

    /* renamed from: androidx.emoji2.text.p$c */
    public static class c extends b {
        @Override // androidx.emoji2.text.C0699p.b
        /* renamed from: a */
        public boolean mo4325a(CharSequence charSequence) {
            return (charSequence instanceof PrecomputedText) || (charSequence instanceof C8971c);
        }
    }

    public C0699p(Spannable spannable) {
        this.f3678b = spannable;
    }

    /* renamed from: c */
    public static b m4320c() {
        return new c();
    }

    /* renamed from: a */
    public final void m4321a() {
        Spannable spannable = this.f3678b;
        if (!this.f3677a && m4320c().mo4325a(spannable)) {
            this.f3678b = new SpannableString(spannable);
        }
        this.f3677a = true;
    }

    /* renamed from: b */
    public Spannable m4322b() {
        return this.f3678b;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i10) {
        return this.f3678b.charAt(i10);
    }

    @Override // java.lang.CharSequence
    public IntStream chars() {
        return a.m4323a(this.f3678b);
    }

    @Override // java.lang.CharSequence
    public IntStream codePoints() {
        return a.m4324b(this.f3678b);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.f3678b.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.f3678b.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.f3678b.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public <T> T[] getSpans(int i10, int i11, Class<T> cls) {
        return (T[]) this.f3678b.getSpans(i10, i11, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f3678b.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i10, int i11, Class cls) {
        return this.f3678b.nextSpanTransition(i10, i11, cls);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object obj) {
        m4321a();
        this.f3678b.removeSpan(obj);
    }

    @Override // android.text.Spannable
    public void setSpan(Object obj, int i10, int i11, int i12) {
        m4321a();
        this.f3678b.setSpan(obj, i10, i11, i12);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i10, int i11) {
        return this.f3678b.subSequence(i10, i11);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.f3678b.toString();
    }

    public C0699p(CharSequence charSequence) {
        this.f3678b = new SpannableString(charSequence);
    }
}
