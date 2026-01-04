package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceArray;
import p790xw.C13885n;

/* renamed from: kotlinx.coroutines.internal.s */
/* loaded from: classes9.dex */
public final class C11102s<T> {
    private volatile AtomicReferenceArray<T> array;

    public C11102s(int i10) {
        this.array = new AtomicReferenceArray<>(i10);
    }

    /* renamed from: a */
    public final int m66800a() {
        return this.array.length();
    }

    /* renamed from: b */
    public final T m66801b(int i10) {
        AtomicReferenceArray<T> atomicReferenceArray = this.array;
        if (i10 < atomicReferenceArray.length()) {
            return atomicReferenceArray.get(i10);
        }
        return null;
    }

    /* renamed from: c */
    public final void m66802c(int i10, T t10) {
        AtomicReferenceArray<T> atomicReferenceArray = this.array;
        int length = atomicReferenceArray.length();
        if (i10 < length) {
            atomicReferenceArray.set(i10, t10);
            return;
        }
        AtomicReferenceArray<T> atomicReferenceArray2 = new AtomicReferenceArray<>(C13885n.m83236a(i10 + 1, length * 2));
        for (int i11 = 0; i11 < length; i11++) {
            atomicReferenceArray2.set(i11, atomicReferenceArray.get(i11));
        }
        atomicReferenceArray2.set(i10, t10);
        this.array = atomicReferenceArray2;
    }
}
