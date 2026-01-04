package androidx.recyclerview.widget;

import android.view.View;

/* renamed from: androidx.recyclerview.widget.t */
/* loaded from: classes.dex */
public class C0881t {

    /* renamed from: a */
    public final b f4636a;

    /* renamed from: b */
    public a f4637b = new a();

    /* renamed from: androidx.recyclerview.widget.t$a */
    public static class a {

        /* renamed from: a */
        public int f4638a = 0;

        /* renamed from: b */
        public int f4639b;

        /* renamed from: c */
        public int f4640c;

        /* renamed from: d */
        public int f4641d;

        /* renamed from: e */
        public int f4642e;

        /* renamed from: a */
        public void m5584a(int i10) {
            this.f4638a = i10 | this.f4638a;
        }

        /* renamed from: b */
        public boolean m5585b() {
            int i10 = this.f4638a;
            if ((i10 & 7) != 0 && (i10 & m5586c(this.f4641d, this.f4639b)) == 0) {
                return false;
            }
            int i11 = this.f4638a;
            if ((i11 & 112) != 0 && (i11 & (m5586c(this.f4641d, this.f4640c) << 4)) == 0) {
                return false;
            }
            int i12 = this.f4638a;
            if ((i12 & 1792) != 0 && (i12 & (m5586c(this.f4642e, this.f4639b) << 8)) == 0) {
                return false;
            }
            int i13 = this.f4638a;
            return (i13 & 28672) == 0 || ((m5586c(this.f4642e, this.f4640c) << 12) & i13) != 0;
        }

        /* renamed from: c */
        public int m5586c(int i10, int i11) {
            if (i10 > i11) {
                return 1;
            }
            return i10 == i11 ? 2 : 4;
        }

        /* renamed from: d */
        public void m5587d() {
            this.f4638a = 0;
        }

        /* renamed from: e */
        public void m5588e(int i10, int i11, int i12, int i13) {
            this.f4639b = i10;
            this.f4640c = i11;
            this.f4641d = i12;
            this.f4642e = i13;
        }
    }

    /* renamed from: androidx.recyclerview.widget.t$b */
    public interface b {
        /* renamed from: a */
        View mo5240a(int i10);

        /* renamed from: b */
        int mo5241b(View view);

        /* renamed from: c */
        int mo5242c();

        /* renamed from: d */
        int mo5243d();

        /* renamed from: e */
        int mo5244e(View view);
    }

    public C0881t(b bVar) {
        this.f4636a = bVar;
    }

    /* renamed from: a */
    public View m5582a(int i10, int i11, int i12, int i13) {
        int iMo5242c = this.f4636a.mo5242c();
        int iMo5243d = this.f4636a.mo5243d();
        int i14 = i11 > i10 ? 1 : -1;
        View view = null;
        while (i10 != i11) {
            View viewMo5240a = this.f4636a.mo5240a(i10);
            this.f4637b.m5588e(iMo5242c, iMo5243d, this.f4636a.mo5241b(viewMo5240a), this.f4636a.mo5244e(viewMo5240a));
            if (i12 != 0) {
                this.f4637b.m5587d();
                this.f4637b.m5584a(i12);
                if (this.f4637b.m5585b()) {
                    return viewMo5240a;
                }
            }
            if (i13 != 0) {
                this.f4637b.m5587d();
                this.f4637b.m5584a(i13);
                if (this.f4637b.m5585b()) {
                    view = viewMo5240a;
                }
            }
            i10 += i14;
        }
        return view;
    }

    /* renamed from: b */
    public boolean m5583b(View view, int i10) {
        this.f4637b.m5588e(this.f4636a.mo5242c(), this.f4636a.mo5243d(), this.f4636a.mo5241b(view), this.f4636a.mo5244e(view));
        if (i10 == 0) {
            return false;
        }
        this.f4637b.m5587d();
        this.f4637b.m5584a(i10);
        return this.f4637b.m5585b();
    }
}
