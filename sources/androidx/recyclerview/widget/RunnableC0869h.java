package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;
import p024b0.C1094j;

/* renamed from: androidx.recyclerview.widget.h */
/* loaded from: classes.dex */
public final class RunnableC0869h implements Runnable {

    /* renamed from: e */
    public static final ThreadLocal<RunnableC0869h> f4598e = new ThreadLocal<>();

    /* renamed from: f */
    public static Comparator<c> f4599f = new a();

    /* renamed from: b */
    public long f4601b;

    /* renamed from: c */
    public long f4602c;

    /* renamed from: a */
    public ArrayList<RecyclerView> f4600a = new ArrayList<>();

    /* renamed from: d */
    public ArrayList<c> f4603d = new ArrayList<>();

    /* renamed from: androidx.recyclerview.widget.h$a */
    public class a implements Comparator<c> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(c cVar, c cVar2) {
            RecyclerView recyclerView = cVar.f4611d;
            if ((recyclerView == null) != (cVar2.f4611d == null)) {
                return recyclerView == null ? 1 : -1;
            }
            boolean z10 = cVar.f4608a;
            if (z10 != cVar2.f4608a) {
                return z10 ? -1 : 1;
            }
            int i10 = cVar2.f4609b - cVar.f4609b;
            if (i10 != 0) {
                return i10;
            }
            int i11 = cVar.f4610c - cVar2.f4610c;
            if (i11 != 0) {
                return i11;
            }
            return 0;
        }
    }

    @SuppressLint({"VisibleForTests"})
    /* renamed from: androidx.recyclerview.widget.h$b */
    public static class b implements RecyclerView.AbstractC0846p.c {

        /* renamed from: a */
        public int f4604a;

        /* renamed from: b */
        public int f4605b;

        /* renamed from: c */
        public int[] f4606c;

        /* renamed from: d */
        public int f4607d;

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0846p.c
        /* renamed from: a */
        public void mo5245a(int i10, int i11) {
            if (i10 < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i11 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            int i12 = this.f4607d;
            int i13 = i12 * 2;
            int[] iArr = this.f4606c;
            if (iArr == null) {
                int[] iArr2 = new int[4];
                this.f4606c = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i13 >= iArr.length) {
                int[] iArr3 = new int[i12 * 4];
                this.f4606c = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            }
            int[] iArr4 = this.f4606c;
            iArr4[i13] = i10;
            iArr4[i13 + 1] = i11;
            this.f4607d++;
        }

        /* renamed from: b */
        public void m5535b() {
            int[] iArr = this.f4606c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f4607d = 0;
        }

        /* renamed from: c */
        public void m5536c(RecyclerView recyclerView, boolean z10) {
            this.f4607d = 0;
            int[] iArr = this.f4606c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.AbstractC0846p abstractC0846p = recyclerView.mLayout;
            if (recyclerView.mAdapter == null || abstractC0846p == null || !abstractC0846p.isItemPrefetchEnabled()) {
                return;
            }
            if (z10) {
                if (!recyclerView.mAdapterHelper.m5422p()) {
                    abstractC0846p.collectInitialPrefetchPositions(recyclerView.mAdapter.mo721e(), this);
                }
            } else if (!recyclerView.hasPendingAdapterUpdates()) {
                abstractC0846p.collectAdjacentPrefetchPositions(this.f4604a, this.f4605b, recyclerView.mState, this);
            }
            int i10 = this.f4607d;
            if (i10 > abstractC0846p.mPrefetchMaxCountObserved) {
                abstractC0846p.mPrefetchMaxCountObserved = i10;
                abstractC0846p.mPrefetchMaxObservedInInitialPrefetch = z10;
                recyclerView.mRecycler.m5268K();
            }
        }

        /* renamed from: d */
        public boolean m5537d(int i10) {
            if (this.f4606c != null) {
                int i11 = this.f4607d * 2;
                for (int i12 = 0; i12 < i11; i12 += 2) {
                    if (this.f4606c[i12] == i10) {
                        return true;
                    }
                }
            }
            return false;
        }

        /* renamed from: e */
        public void m5538e(int i10, int i11) {
            this.f4604a = i10;
            this.f4605b = i11;
        }
    }

    /* renamed from: androidx.recyclerview.widget.h$c */
    public static class c {

        /* renamed from: a */
        public boolean f4608a;

        /* renamed from: b */
        public int f4609b;

        /* renamed from: c */
        public int f4610c;

        /* renamed from: d */
        public RecyclerView f4611d;

        /* renamed from: e */
        public int f4612e;

        /* renamed from: a */
        public void m5539a() {
            this.f4608a = false;
            this.f4609b = 0;
            this.f4610c = 0;
            this.f4611d = null;
            this.f4612e = 0;
        }
    }

    /* renamed from: f */
    public static boolean m5524f(RecyclerView recyclerView, int i10) {
        int iM5448j = recyclerView.mChildHelper.m5448j();
        for (int i11 = 0; i11 < iM5448j; i11++) {
            RecyclerView.AbstractC0833c0 childViewHolderInt = RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.m5447i(i11));
            if (childViewHolderInt.f4329c == i10 && !childViewHolderInt.m5175v()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public void m5525a(RecyclerView recyclerView) {
        this.f4600a.add(recyclerView);
    }

    /* renamed from: c */
    public final void m5526c() {
        c cVar;
        int size = this.f4600a.size();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            RecyclerView recyclerView = this.f4600a.get(i11);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.mPrefetchRegistry.m5536c(recyclerView, false);
                i10 += recyclerView.mPrefetchRegistry.f4607d;
            }
        }
        this.f4603d.ensureCapacity(i10);
        int i12 = 0;
        for (int i13 = 0; i13 < size; i13++) {
            RecyclerView recyclerView2 = this.f4600a.get(i13);
            if (recyclerView2.getWindowVisibility() == 0) {
                b bVar = recyclerView2.mPrefetchRegistry;
                int iAbs = Math.abs(bVar.f4604a) + Math.abs(bVar.f4605b);
                for (int i14 = 0; i14 < bVar.f4607d * 2; i14 += 2) {
                    if (i12 >= this.f4603d.size()) {
                        cVar = new c();
                        this.f4603d.add(cVar);
                    } else {
                        cVar = this.f4603d.get(i12);
                    }
                    int[] iArr = bVar.f4606c;
                    int i15 = iArr[i14 + 1];
                    cVar.f4608a = i15 <= iAbs;
                    cVar.f4609b = iAbs;
                    cVar.f4610c = i15;
                    cVar.f4611d = recyclerView2;
                    cVar.f4612e = iArr[i14];
                    i12++;
                }
            }
        }
        Collections.sort(this.f4603d, f4599f);
    }

    /* renamed from: d */
    public final void m5527d(c cVar, long j10) {
        RecyclerView.AbstractC0833c0 abstractC0833c0M5532j = m5532j(cVar.f4611d, cVar.f4612e, cVar.f4608a ? Long.MAX_VALUE : j10);
        if (abstractC0833c0M5532j == null || abstractC0833c0M5532j.f4328b == null || !abstractC0833c0M5532j.m5174u() || abstractC0833c0M5532j.m5175v()) {
            return;
        }
        m5531i(abstractC0833c0M5532j.f4328b.get(), j10);
    }

    /* renamed from: e */
    public final void m5528e(long j10) {
        for (int i10 = 0; i10 < this.f4603d.size(); i10++) {
            c cVar = this.f4603d.get(i10);
            if (cVar.f4611d == null) {
                return;
            }
            m5527d(cVar, j10);
            cVar.m5539a();
        }
    }

    /* renamed from: g */
    public void m5529g(RecyclerView recyclerView, int i10, int i11) {
        if (recyclerView.isAttachedToWindow() && this.f4601b == 0) {
            this.f4601b = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.mPrefetchRegistry.m5538e(i10, i11);
    }

    /* renamed from: h */
    public void m5530h(long j10) {
        m5526c();
        m5528e(j10);
    }

    /* renamed from: i */
    public final void m5531i(RecyclerView recyclerView, long j10) {
        if (recyclerView == null) {
            return;
        }
        if (recyclerView.mDataSetHasChangedAfterLayout && recyclerView.mChildHelper.m5448j() != 0) {
            recyclerView.removeAndRecycleViews();
        }
        b bVar = recyclerView.mPrefetchRegistry;
        bVar.m5536c(recyclerView, true);
        if (bVar.f4607d != 0) {
            try {
                C1094j.m6490a("RV Nested Prefetch");
                recyclerView.mState.m5309f(recyclerView.mAdapter);
                for (int i10 = 0; i10 < bVar.f4607d * 2; i10 += 2) {
                    m5532j(recyclerView, bVar.f4606c[i10], j10);
                }
            } finally {
                C1094j.m6491b();
            }
        }
    }

    /* renamed from: j */
    public final RecyclerView.AbstractC0833c0 m5532j(RecyclerView recyclerView, int i10, long j10) {
        if (m5524f(recyclerView, i10)) {
            return null;
        }
        RecyclerView.C0852v c0852v = recyclerView.mRecycler;
        try {
            recyclerView.onEnterLayoutOrScroll();
            RecyclerView.AbstractC0833c0 abstractC0833c0M5266I = c0852v.m5266I(i10, false, j10);
            if (abstractC0833c0M5266I != null) {
                if (!abstractC0833c0M5266I.m5174u() || abstractC0833c0M5266I.m5175v()) {
                    c0852v.m5271a(abstractC0833c0M5266I, false);
                } else {
                    c0852v.m5259B(abstractC0833c0M5266I.f4327a);
                }
            }
            recyclerView.onExitLayoutOrScroll(false);
            return abstractC0833c0M5266I;
        } catch (Throwable th2) {
            recyclerView.onExitLayoutOrScroll(false);
            throw th2;
        }
    }

    /* renamed from: k */
    public void m5533k(RecyclerView recyclerView) {
        this.f4600a.remove(recyclerView);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            C1094j.m6490a("RV Prefetch");
            if (!this.f4600a.isEmpty()) {
                int size = this.f4600a.size();
                long jMax = 0;
                for (int i10 = 0; i10 < size; i10++) {
                    RecyclerView recyclerView = this.f4600a.get(i10);
                    if (recyclerView.getWindowVisibility() == 0) {
                        jMax = Math.max(recyclerView.getDrawingTime(), jMax);
                    }
                }
                if (jMax != 0) {
                    m5530h(TimeUnit.MILLISECONDS.toNanos(jMax) + this.f4602c);
                    this.f4601b = 0L;
                    C1094j.m6491b();
                }
            }
        } finally {
            this.f4601b = 0L;
            C1094j.m6491b();
        }
    }
}
