package p276f3;

import android.graphics.Typeface;

/* renamed from: f3.a */
/* loaded from: classes.dex */
public final class C9647a extends AbstractC9652f {

    /* renamed from: a */
    public final Typeface f47780a;

    /* renamed from: b */
    public final a f47781b;

    /* renamed from: c */
    public boolean f47782c;

    /* renamed from: f3.a$a */
    public interface a {
        /* renamed from: a */
        void mo10675a(Typeface typeface);
    }

    public C9647a(a aVar, Typeface typeface) {
        this.f47780a = typeface;
        this.f47781b = aVar;
    }

    @Override // p276f3.AbstractC9652f
    /* renamed from: a */
    public void mo10020a(int i10) {
        m60259d(this.f47780a);
    }

    @Override // p276f3.AbstractC9652f
    /* renamed from: b */
    public void mo10021b(Typeface typeface, boolean z10) {
        m60259d(typeface);
    }

    /* renamed from: c */
    public void m60258c() {
        this.f47782c = true;
    }

    /* renamed from: d */
    public final void m60259d(Typeface typeface) {
        if (this.f47782c) {
            return;
        }
        this.f47781b.mo10675a(typeface);
    }
}
