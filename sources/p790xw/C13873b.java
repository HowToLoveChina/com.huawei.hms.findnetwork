package p790xw;

import java.util.NoSuchElementException;
import kw.AbstractC11181j;
import p692uw.C13267j;

/* renamed from: xw.b */
/* loaded from: classes9.dex */
public final class C13873b extends AbstractC11181j {

    /* renamed from: a */
    public final int f62160a;

    /* renamed from: b */
    public final int f62161b;

    /* renamed from: c */
    public boolean f62162c;

    /* renamed from: d */
    public int f62163d;

    public C13873b(char c10, char c11, int i10) {
        this.f62160a = i10;
        this.f62161b = c11;
        boolean z10 = true;
        if (i10 <= 0 ? C13267j.m79678f(c10, c11) < 0 : C13267j.m79678f(c10, c11) > 0) {
            z10 = false;
        }
        this.f62162c = z10;
        this.f62163d = z10 ? c10 : c11;
    }

    @Override // kw.AbstractC11181j
    /* renamed from: b */
    public char mo67158b() {
        int i10 = this.f62163d;
        if (i10 != this.f62161b) {
            this.f62163d = this.f62160a + i10;
        } else {
            if (!this.f62162c) {
                throw new NoSuchElementException();
            }
            this.f62162c = false;
        }
        return (char) i10;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f62162c;
    }
}
