package p022ay;

import java.util.concurrent.atomic.AtomicReference;
import p692uw.C13267j;

/* renamed from: ay.v */
/* loaded from: classes9.dex */
public final class C1072v {

    /* renamed from: a */
    public static final C1072v f5174a = new C1072v();

    /* renamed from: b */
    public static final int f5175b = 65536;

    /* renamed from: c */
    public static final C1071u f5176c = new C1071u(new byte[0], 0, 0, false, false);

    /* renamed from: d */
    public static final int f5177d;

    /* renamed from: e */
    public static final AtomicReference<C1071u>[] f5178e;

    static {
        int iHighestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        f5177d = iHighestOneBit;
        AtomicReference<C1071u>[] atomicReferenceArr = new AtomicReference[iHighestOneBit];
        for (int i10 = 0; i10 < iHighestOneBit; i10++) {
            atomicReferenceArr[i10] = new AtomicReference<>();
        }
        f5178e = atomicReferenceArr;
    }

    /* renamed from: b */
    public static final void m6440b(C1071u c1071u) {
        AtomicReference<C1071u> atomicReferenceM6442a;
        C1071u c1071u2;
        C1071u andSet;
        C13267j.m79677e(c1071u, "segment");
        if (c1071u.f5172f != null || c1071u.f5173g != null) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (c1071u.f5170d || (andSet = (atomicReferenceM6442a = f5174a.m6442a()).getAndSet((c1071u2 = f5176c))) == c1071u2) {
            return;
        }
        int i10 = andSet != null ? andSet.f5169c : 0;
        if (i10 >= f5175b) {
            atomicReferenceM6442a.set(andSet);
            return;
        }
        c1071u.f5172f = andSet;
        c1071u.f5168b = 0;
        c1071u.f5169c = i10 + 8192;
        atomicReferenceM6442a.set(c1071u);
    }

    /* renamed from: c */
    public static final C1071u m6441c() {
        AtomicReference<C1071u> atomicReferenceM6442a = f5174a.m6442a();
        C1071u c1071u = f5176c;
        C1071u andSet = atomicReferenceM6442a.getAndSet(c1071u);
        if (andSet == c1071u) {
            return new C1071u();
        }
        if (andSet == null) {
            atomicReferenceM6442a.set(null);
            return new C1071u();
        }
        atomicReferenceM6442a.set(andSet.f5172f);
        andSet.f5172f = null;
        andSet.f5169c = 0;
        return andSet;
    }

    /* renamed from: a */
    public final AtomicReference<C1071u> m6442a() {
        return f5178e[(int) (Thread.currentThread().getId() & (f5177d - 1))];
    }
}
