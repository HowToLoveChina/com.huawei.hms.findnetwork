package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import p243e0.C9373h;

/* renamed from: androidx.emoji2.text.n */
/* loaded from: classes.dex */
public final class C0697n extends SpannableStringBuilder {

    /* renamed from: a */
    public final Class<?> f3672a;

    /* renamed from: b */
    public final List<a> f3673b;

    /* renamed from: androidx.emoji2.text.n$a */
    public static class a implements TextWatcher, SpanWatcher {

        /* renamed from: a */
        public final Object f3674a;

        /* renamed from: b */
        public final AtomicInteger f3675b = new AtomicInteger(0);

        public a(Object obj) {
            this.f3674a = obj;
        }

        /* renamed from: a */
        public final void m4316a() {
            this.f3675b.incrementAndGet();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            ((TextWatcher) this.f3674a).afterTextChanged(editable);
        }

        /* renamed from: b */
        public final boolean m4317b(Object obj) {
            return obj instanceof AbstractC0692i;
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            ((TextWatcher) this.f3674a).beforeTextChanged(charSequence, i10, i11, i12);
        }

        /* renamed from: c */
        public final void m4318c() {
            this.f3675b.decrementAndGet();
        }

        @Override // android.text.SpanWatcher
        public void onSpanAdded(Spannable spannable, Object obj, int i10, int i11) {
            if (this.f3675b.get() <= 0 || !m4317b(obj)) {
                ((SpanWatcher) this.f3674a).onSpanAdded(spannable, obj, i10, i11);
            }
        }

        @Override // android.text.SpanWatcher
        public void onSpanChanged(Spannable spannable, Object obj, int i10, int i11, int i12, int i13) {
            if (this.f3675b.get() <= 0 || !m4317b(obj)) {
                ((SpanWatcher) this.f3674a).onSpanChanged(spannable, obj, i10, i11, i12, i13);
            }
        }

        @Override // android.text.SpanWatcher
        public void onSpanRemoved(Spannable spannable, Object obj, int i10, int i11) {
            if (this.f3675b.get() <= 0 || !m4317b(obj)) {
                ((SpanWatcher) this.f3674a).onSpanRemoved(spannable, obj, i10, i11);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            ((TextWatcher) this.f3674a).onTextChanged(charSequence, i10, i11, i12);
        }
    }

    public C0697n(Class<?> cls, CharSequence charSequence) {
        super(charSequence);
        this.f3673b = new ArrayList();
        C9373h.m58746g(cls, "watcherClass cannot be null");
        this.f3672a = cls;
    }

    /* renamed from: c */
    public static C0697n m4307c(Class<?> cls, CharSequence charSequence) {
        return new C0697n(cls, charSequence);
    }

    /* renamed from: a */
    public void m4308a() {
        m4309b();
    }

    /* renamed from: b */
    public final void m4309b() {
        for (int i10 = 0; i10 < this.f3673b.size(); i10++) {
            this.f3673b.get(i10).m4316a();
        }
    }

    /* renamed from: d */
    public void m4310d() {
        m4315i();
        m4311e();
    }

    /* renamed from: e */
    public final void m4311e() {
        for (int i10 = 0; i10 < this.f3673b.size(); i10++) {
            this.f3673b.get(i10).onTextChanged(this, 0, length(), length());
        }
    }

    /* renamed from: f */
    public final a m4312f(Object obj) {
        for (int i10 = 0; i10 < this.f3673b.size(); i10++) {
            a aVar = this.f3673b.get(i10);
            if (aVar.f3674a == obj) {
                return aVar;
            }
        }
        return null;
    }

    /* renamed from: g */
    public final boolean m4313g(Class<?> cls) {
        return this.f3672a == cls;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanEnd(Object obj) {
        a aVarM4312f;
        if (m4314h(obj) && (aVarM4312f = m4312f(obj)) != null) {
            obj = aVarM4312f;
        }
        return super.getSpanEnd(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanFlags(Object obj) {
        a aVarM4312f;
        if (m4314h(obj) && (aVarM4312f = m4312f(obj)) != null) {
            obj = aVarM4312f;
        }
        return super.getSpanFlags(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanStart(Object obj) {
        a aVarM4312f;
        if (m4314h(obj) && (aVarM4312f = m4312f(obj)) != null) {
            obj = aVarM4312f;
        }
        return super.getSpanStart(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    @SuppressLint({"UnknownNullness"})
    public <T> T[] getSpans(int i10, int i11, Class<T> cls) {
        if (!m4313g(cls)) {
            return (T[]) super.getSpans(i10, i11, cls);
        }
        a[] aVarArr = (a[]) super.getSpans(i10, i11, a.class);
        T[] tArr = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, aVarArr.length));
        for (int i12 = 0; i12 < aVarArr.length; i12++) {
            tArr[i12] = aVarArr[i12].f3674a;
        }
        return tArr;
    }

    /* renamed from: h */
    public final boolean m4314h(Object obj) {
        return obj != null && m4313g(obj.getClass());
    }

    /* renamed from: i */
    public final void m4315i() {
        for (int i10 = 0; i10 < this.f3673b.size(); i10++) {
            this.f3673b.get(i10).m4318c();
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int nextSpanTransition(int i10, int i11, Class cls) {
        if (cls == null || m4313g(cls)) {
            cls = a.class;
        }
        return super.nextSpanTransition(i10, i11, cls);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public void removeSpan(Object obj) {
        a aVarM4312f;
        if (m4314h(obj)) {
            aVarM4312f = m4312f(obj);
            if (aVarM4312f != null) {
                obj = aVarM4312f;
            }
        } else {
            aVarM4312f = null;
        }
        super.removeSpan(obj);
        if (aVarM4312f != null) {
            this.f3673b.remove(aVarM4312f);
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public void setSpan(Object obj, int i10, int i11, int i12) {
        if (m4314h(obj)) {
            a aVar = new a(obj);
            this.f3673b.add(aVar);
            obj = aVar;
        }
        super.setSpan(obj, i10, i11, i12);
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    @SuppressLint({"UnknownNullness"})
    public CharSequence subSequence(int i10, int i11) {
        return new C0697n(this.f3672a, this, i10, i11);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder delete(int i10, int i11) {
        super.delete(i10, i11);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder insert(int i10, CharSequence charSequence) {
        super.insert(i10, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder replace(int i10, int i11, CharSequence charSequence) {
        m4309b();
        super.replace(i10, i11, charSequence);
        m4315i();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder insert(int i10, CharSequence charSequence, int i11, int i12) {
        super.insert(i10, charSequence, i11, i12);
        return this;
    }

    public C0697n(Class<?> cls, CharSequence charSequence, int i10, int i11) {
        super(charSequence, i10, i11);
        this.f3673b = new ArrayList();
        C9373h.m58746g(cls, "watcherClass cannot be null");
        this.f3672a = cls;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder replace(int i10, int i11, CharSequence charSequence, int i12, int i13) {
        m4309b();
        super.replace(i10, i11, charSequence, i12, i13);
        m4315i();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public SpannableStringBuilder append(@SuppressLint({"UnknownNullness"}) CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public SpannableStringBuilder append(char c10) {
        super.append(c10);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public SpannableStringBuilder append(@SuppressLint({"UnknownNullness"}) CharSequence charSequence, int i10, int i11) {
        super.append(charSequence, i10, i11);
        return this;
    }

    @Override // android.text.SpannableStringBuilder
    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder append(CharSequence charSequence, Object obj, int i10) {
        super.append(charSequence, obj, i10);
        return this;
    }
}
