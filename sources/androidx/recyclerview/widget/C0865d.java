package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* renamed from: androidx.recyclerview.widget.d */
/* loaded from: classes.dex */
public class C0865d {

    /* renamed from: a */
    public final b f4481a;

    /* renamed from: b */
    public final a f4482b = new a();

    /* renamed from: c */
    public final List<View> f4483c = new ArrayList();

    /* renamed from: androidx.recyclerview.widget.d$a */
    public static class a {

        /* renamed from: a */
        public long f4484a = 0;

        /* renamed from: b */
        public a f4485b;

        /* renamed from: a */
        public void m5459a(int i10) {
            if (i10 < 64) {
                this.f4484a &= ~(1 << i10);
                return;
            }
            a aVar = this.f4485b;
            if (aVar != null) {
                aVar.m5459a(i10 - 64);
            }
        }

        /* renamed from: b */
        public int m5460b(int i10) {
            a aVar = this.f4485b;
            if (aVar == null) {
                if (i10 >= 64) {
                    return Long.bitCount(this.f4484a);
                }
                return Long.bitCount(((1 << i10) - 1) & this.f4484a);
            }
            if (i10 >= 64) {
                return aVar.m5460b(i10 - 64) + Long.bitCount(this.f4484a);
            }
            return Long.bitCount(((1 << i10) - 1) & this.f4484a);
        }

        /* renamed from: c */
        public final void m5461c() {
            if (this.f4485b == null) {
                this.f4485b = new a();
            }
        }

        /* renamed from: d */
        public boolean m5462d(int i10) {
            if (i10 < 64) {
                return ((1 << i10) & this.f4484a) != 0;
            }
            m5461c();
            return this.f4485b.m5462d(i10 - 64);
        }

        /* renamed from: e */
        public void m5463e(int i10, boolean z10) {
            if (i10 >= 64) {
                m5461c();
                this.f4485b.m5463e(i10 - 64, z10);
                return;
            }
            long j10 = this.f4484a;
            boolean z11 = (Long.MIN_VALUE & j10) != 0;
            long j11 = (1 << i10) - 1;
            this.f4484a = ((j10 & (~j11)) << 1) | (j10 & j11);
            if (z10) {
                m5466h(i10);
            } else {
                m5459a(i10);
            }
            if (z11 || this.f4485b != null) {
                m5461c();
                this.f4485b.m5463e(0, z11);
            }
        }

        /* renamed from: f */
        public boolean m5464f(int i10) {
            if (i10 >= 64) {
                m5461c();
                return this.f4485b.m5464f(i10 - 64);
            }
            long j10 = 1 << i10;
            long j11 = this.f4484a;
            boolean z10 = (j11 & j10) != 0;
            long j12 = j11 & (~j10);
            this.f4484a = j12;
            long j13 = j10 - 1;
            this.f4484a = (j12 & j13) | Long.rotateRight((~j13) & j12, 1);
            a aVar = this.f4485b;
            if (aVar != null) {
                if (aVar.m5462d(0)) {
                    m5466h(63);
                }
                this.f4485b.m5464f(0);
            }
            return z10;
        }

        /* renamed from: g */
        public void m5465g() {
            this.f4484a = 0L;
            a aVar = this.f4485b;
            if (aVar != null) {
                aVar.m5465g();
            }
        }

        /* renamed from: h */
        public void m5466h(int i10) {
            if (i10 < 64) {
                this.f4484a |= 1 << i10;
            } else {
                m5461c();
                this.f4485b.m5466h(i10 - 64);
            }
        }

        public String toString() {
            if (this.f4485b == null) {
                return Long.toBinaryString(this.f4484a);
            }
            return this.f4485b.toString() + "xx" + Long.toBinaryString(this.f4484a);
        }
    }

    /* renamed from: androidx.recyclerview.widget.d$b */
    public interface b {
        /* renamed from: a */
        View mo5184a(int i10);

        /* renamed from: b */
        void mo5185b(View view);

        /* renamed from: c */
        int mo5186c();

        /* renamed from: d */
        void mo5187d();

        /* renamed from: e */
        int mo5188e(View view);

        /* renamed from: f */
        RecyclerView.AbstractC0833c0 mo5189f(View view);

        /* renamed from: g */
        void mo5190g(int i10);

        /* renamed from: h */
        void mo5191h(View view);

        /* renamed from: i */
        void mo5192i(View view, int i10);

        /* renamed from: j */
        void mo5193j(int i10);

        /* renamed from: k */
        void mo5194k(View view, int i10, ViewGroup.LayoutParams layoutParams);
    }

    public C0865d(b bVar) {
        this.f4481a = bVar;
    }

    /* renamed from: a */
    public void m5439a(View view, int i10, boolean z10) {
        int iMo5186c = i10 < 0 ? this.f4481a.mo5186c() : m5446h(i10);
        this.f4482b.m5463e(iMo5186c, z10);
        if (z10) {
            m5450l(view);
        }
        this.f4481a.mo5192i(view, iMo5186c);
    }

    /* renamed from: b */
    public void m5440b(View view, boolean z10) {
        m5439a(view, -1, z10);
    }

    /* renamed from: c */
    public void m5441c(View view, int i10, ViewGroup.LayoutParams layoutParams, boolean z10) {
        int iMo5186c = i10 < 0 ? this.f4481a.mo5186c() : m5446h(i10);
        this.f4482b.m5463e(iMo5186c, z10);
        if (z10) {
            m5450l(view);
        }
        this.f4481a.mo5194k(view, iMo5186c, layoutParams);
    }

    /* renamed from: d */
    public void m5442d(int i10) {
        int iM5446h = m5446h(i10);
        this.f4482b.m5464f(iM5446h);
        this.f4481a.mo5190g(iM5446h);
    }

    /* renamed from: e */
    public View m5443e(int i10) {
        int size = this.f4483c.size();
        for (int i11 = 0; i11 < size; i11++) {
            View view = this.f4483c.get(i11);
            RecyclerView.AbstractC0833c0 abstractC0833c0Mo5189f = this.f4481a.mo5189f(view);
            if (abstractC0833c0Mo5189f.m5168o() == i10 && !abstractC0833c0Mo5189f.m5175v() && !abstractC0833c0Mo5189f.m5177x()) {
                return view;
            }
        }
        return null;
    }

    /* renamed from: f */
    public View m5444f(int i10) {
        return this.f4481a.mo5184a(m5446h(i10));
    }

    /* renamed from: g */
    public int m5445g() {
        return this.f4481a.mo5186c() - this.f4483c.size();
    }

    /* renamed from: h */
    public final int m5446h(int i10) {
        if (i10 < 0) {
            return -1;
        }
        int iMo5186c = this.f4481a.mo5186c();
        int i11 = i10;
        while (i11 < iMo5186c) {
            int iM5460b = i10 - (i11 - this.f4482b.m5460b(i11));
            if (iM5460b == 0) {
                while (this.f4482b.m5462d(i11)) {
                    i11++;
                }
                return i11;
            }
            i11 += iM5460b;
        }
        return -1;
    }

    /* renamed from: i */
    public View m5447i(int i10) {
        return this.f4481a.mo5184a(i10);
    }

    /* renamed from: j */
    public int m5448j() {
        return this.f4481a.mo5186c();
    }

    /* renamed from: k */
    public void m5449k(View view) {
        int iMo5188e = this.f4481a.mo5188e(view);
        if (iMo5188e >= 0) {
            this.f4482b.m5466h(iMo5188e);
            m5450l(view);
        } else {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    /* renamed from: l */
    public final void m5450l(View view) {
        this.f4483c.add(view);
        this.f4481a.mo5185b(view);
    }

    /* renamed from: m */
    public int m5451m(View view) {
        int iMo5188e = this.f4481a.mo5188e(view);
        if (iMo5188e == -1 || this.f4482b.m5462d(iMo5188e)) {
            return -1;
        }
        return iMo5188e - this.f4482b.m5460b(iMo5188e);
    }

    /* renamed from: n */
    public boolean m5452n(View view) {
        return this.f4483c.contains(view);
    }

    /* renamed from: o */
    public void m5453o() {
        this.f4482b.m5465g();
        for (int size = this.f4483c.size() - 1; size >= 0; size--) {
            this.f4481a.mo5191h(this.f4483c.get(size));
            this.f4483c.remove(size);
        }
        this.f4481a.mo5187d();
    }

    /* renamed from: p */
    public void m5454p(View view) {
        int iMo5188e = this.f4481a.mo5188e(view);
        if (iMo5188e < 0) {
            return;
        }
        if (this.f4482b.m5464f(iMo5188e)) {
            m5458t(view);
        }
        this.f4481a.mo5193j(iMo5188e);
    }

    /* renamed from: q */
    public void m5455q(int i10) {
        int iM5446h = m5446h(i10);
        View viewMo5184a = this.f4481a.mo5184a(iM5446h);
        if (viewMo5184a == null) {
            return;
        }
        if (this.f4482b.m5464f(iM5446h)) {
            m5458t(viewMo5184a);
        }
        this.f4481a.mo5193j(iM5446h);
    }

    /* renamed from: r */
    public boolean m5456r(View view) {
        int iMo5188e = this.f4481a.mo5188e(view);
        if (iMo5188e == -1) {
            m5458t(view);
            return true;
        }
        if (!this.f4482b.m5462d(iMo5188e)) {
            return false;
        }
        this.f4482b.m5464f(iMo5188e);
        m5458t(view);
        this.f4481a.mo5193j(iMo5188e);
        return true;
    }

    /* renamed from: s */
    public void m5457s(View view) {
        int iMo5188e = this.f4481a.mo5188e(view);
        if (iMo5188e < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        if (this.f4482b.m5462d(iMo5188e)) {
            this.f4482b.m5459a(iMo5188e);
            m5458t(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    /* renamed from: t */
    public final boolean m5458t(View view) {
        if (!this.f4483c.remove(view)) {
            return false;
        }
        this.f4481a.mo5191h(view);
        return true;
    }

    public String toString() {
        return this.f4482b.toString() + ", hidden list:" + this.f4483c.size();
    }
}
