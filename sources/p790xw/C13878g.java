package p790xw;

import java.util.NoSuchElementException;
import kw.AbstractC11199z;

/* renamed from: xw.g */
/* loaded from: classes9.dex */
public final class C13878g extends AbstractC11199z {

    /* renamed from: a */
    public final int f62174a;

    /* renamed from: b */
    public final int f62175b;

    /* renamed from: c */
    public boolean f62176c;

    /* renamed from: d */
    public int f62177d;

    public C13878g(int i10, int i11, int i12) {
        this.f62174a = i12;
        this.f62175b = i11;
        boolean z10 = true;
        if (i12 <= 0 ? i10 < i11 : i10 > i11) {
            z10 = false;
        }
        this.f62176c = z10;
        this.f62177d = z10 ? i10 : i11;
    }

    @Override // kw.AbstractC11199z
    /* renamed from: b */
    public int mo67208b() {
        int i10 = this.f62177d;
        if (i10 != this.f62175b) {
            this.f62177d = this.f62174a + i10;
        } else {
            if (!this.f62176c) {
                throw new NoSuchElementException();
            }
            this.f62176c = false;
        }
        return i10;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f62176c;
    }
}
