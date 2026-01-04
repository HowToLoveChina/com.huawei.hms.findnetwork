package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import java.lang.ref.WeakReference;
import p276f3.AbstractC9652f;
import p276f3.C9650d;

/* renamed from: com.google.android.material.internal.l */
/* loaded from: classes.dex */
public class C1781l {

    /* renamed from: c */
    public float f8397c;

    /* renamed from: f */
    public C9650d f8400f;

    /* renamed from: a */
    public final TextPaint f8395a = new TextPaint(1);

    /* renamed from: b */
    public final AbstractC9652f f8396b = new a();

    /* renamed from: d */
    public boolean f8398d = true;

    /* renamed from: e */
    public WeakReference<b> f8399e = new WeakReference<>(null);

    /* renamed from: com.google.android.material.internal.l$a */
    public class a extends AbstractC9652f {
        public a() {
        }

        @Override // p276f3.AbstractC9652f
        /* renamed from: a */
        public void mo10020a(int i10) {
            C1781l.this.f8398d = true;
            b bVar = (b) C1781l.this.f8399e.get();
            if (bVar != null) {
                bVar.mo9678a();
            }
        }

        @Override // p276f3.AbstractC9652f
        /* renamed from: b */
        public void mo10021b(Typeface typeface, boolean z10) {
            if (z10) {
                return;
            }
            C1781l.this.f8398d = true;
            b bVar = (b) C1781l.this.f8399e.get();
            if (bVar != null) {
                bVar.mo9678a();
            }
        }
    }

    /* renamed from: com.google.android.material.internal.l$b */
    public interface b {
        /* renamed from: a */
        void mo9678a();

        int[] getState();

        boolean onStateChange(int[] iArr);
    }

    public C1781l(b bVar) {
        m10758g(bVar);
    }

    /* renamed from: c */
    public final float m10754c(CharSequence charSequence) {
        if (charSequence == null) {
            return 0.0f;
        }
        return this.f8395a.measureText(charSequence, 0, charSequence.length());
    }

    /* renamed from: d */
    public C9650d m10755d() {
        return this.f8400f;
    }

    /* renamed from: e */
    public TextPaint m10756e() {
        return this.f8395a;
    }

    /* renamed from: f */
    public float m10757f(String str) {
        if (!this.f8398d) {
            return this.f8397c;
        }
        float fM10754c = m10754c(str);
        this.f8397c = fM10754c;
        this.f8398d = false;
        return fM10754c;
    }

    /* renamed from: g */
    public void m10758g(b bVar) {
        this.f8399e = new WeakReference<>(bVar);
    }

    /* renamed from: h */
    public void m10759h(C9650d c9650d, Context context) {
        if (this.f8400f != c9650d) {
            this.f8400f = c9650d;
            if (c9650d != null) {
                c9650d.m60289o(context, this.f8395a, this.f8396b);
                b bVar = this.f8399e.get();
                if (bVar != null) {
                    this.f8395a.drawableState = bVar.getState();
                }
                c9650d.m60288n(context, this.f8395a, this.f8396b);
                this.f8398d = true;
            }
            b bVar2 = this.f8399e.get();
            if (bVar2 != null) {
                bVar2.mo9678a();
                bVar2.onStateChange(bVar2.getState());
            }
        }
    }

    /* renamed from: i */
    public void m10760i(boolean z10) {
        this.f8398d = z10;
    }

    /* renamed from: j */
    public void m10761j(Context context) {
        this.f8400f.m60288n(context, this.f8395a, this.f8396b);
    }
}
