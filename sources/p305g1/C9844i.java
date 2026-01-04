package p305g1;

import com.huawei.android.hicloud.sync.service.aidl.SyncType;

/* renamed from: g1.i */
/* loaded from: classes.dex */
public class C9844i implements InterfaceC9843h {

    /* renamed from: a */
    public C9844i f48375a;

    /* renamed from: b */
    public final C9838c f48376b;

    /* renamed from: c */
    public int f48377c;

    /* renamed from: d */
    public final int f48378d;

    /* renamed from: e */
    public final int f48379e;

    /* renamed from: f */
    public int f48380f;

    /* renamed from: g */
    public int[] f48381g;

    /* renamed from: h */
    public C9836a f48382h = new C9836a();

    /* renamed from: i */
    public int f48383i;

    /* renamed from: j */
    public int f48384j;

    public C9844i(C9838c c9838c, int i10, String str, String str2, String str3, String[] strArr) {
        if (c9838c.f48351q == null) {
            c9838c.f48351q = this;
        } else {
            c9838c.f48352r.f48375a = this;
        }
        c9838c.f48352r = this;
        this.f48376b = c9838c;
        this.f48377c = i10;
        this.f48378d = c9838c.m61166h(str);
        this.f48379e = c9838c.m61166h(str2);
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        int length = strArr.length;
        this.f48380f = length;
        this.f48381g = new int[length];
        for (int i11 = 0; i11 < this.f48380f; i11++) {
            this.f48381g[i11] = c9838c.m61160b(strArr[i11]).f48357a;
        }
    }

    @Override // p305g1.InterfaceC9843h
    /* renamed from: a */
    public void mo61181a(int i10, int i11) {
        this.f48382h.m61147d(SyncType.AUTO_SYNC_RECORD).m61145b(i10, i11);
    }

    @Override // p305g1.InterfaceC9843h
    /* renamed from: b */
    public void mo61182b(int i10, String str) {
        this.f48382h.m61146c(i10, this.f48376b.m61160b(str).f48357a);
    }

    @Override // p305g1.InterfaceC9843h
    /* renamed from: c */
    public void mo61183c(int i10, String str, String str2, String str3) {
        this.f48382h.m61146c(i10, this.f48376b.m61162d(str, str2, str3).f48357a);
    }

    @Override // p305g1.InterfaceC9843h
    /* renamed from: d */
    public void mo61184d(int i10, int i11) {
        this.f48382h.m61145b(i10, i11);
    }

    @Override // p305g1.InterfaceC9843h
    /* renamed from: e */
    public void mo61185e(int i10) {
        this.f48382h.m61147d(i10);
    }

    @Override // p305g1.InterfaceC9843h
    /* renamed from: f */
    public void mo61186f(int i10, int i11) {
        this.f48383i = i10;
        this.f48384j = i11;
    }

    @Override // p305g1.InterfaceC9843h
    /* renamed from: g */
    public void mo61187g(int i10, int i11) {
        if (i11 < 4 && i10 != 169) {
            this.f48382h.m61147d((i10 < 54 ? ((i10 - 21) << 2) + 26 : ((i10 - 54) << 2) + 59) + i11);
        } else if (i11 >= 256) {
            this.f48382h.m61147d(196).m61146c(i10, i11);
        } else {
            this.f48382h.m61145b(i10, i11);
        }
    }

    @Override // p305g1.InterfaceC9843h
    /* renamed from: h */
    public void mo61188h(int i10, C9841f c9841f) {
        if ((c9841f.f48366a & 2) != 0 && c9841f.f48367b - this.f48382h.f48328b < -32768) {
            throw new UnsupportedOperationException();
        }
        this.f48382h.m61147d(i10);
        C9836a c9836a = this.f48382h;
        c9841f.m61177b(this, c9836a, c9836a.f48328b - 1, i10 == 200);
    }

    @Override // p305g1.InterfaceC9843h
    /* renamed from: i */
    public void mo61189i(int i10, String str, String str2, String str3) {
        boolean z10 = i10 == 185;
        C9840e c9840eM61163e = this.f48376b.m61163e(str, str2, str3, z10);
        int iM61196b = c9840eM61163e.f48359c;
        if (!z10) {
            this.f48382h.m61146c(i10, c9840eM61163e.f48357a);
            return;
        }
        if (iM61196b == 0) {
            iM61196b = C9845j.m61196b(str3);
            c9840eM61163e.f48359c = iM61196b;
        }
        this.f48382h.m61146c(185, c9840eM61163e.f48357a).m61145b(iM61196b >> 2, 0);
    }

    @Override // p305g1.InterfaceC9843h
    /* renamed from: j */
    public void mo61190j() {
    }

    @Override // p305g1.InterfaceC9843h
    /* renamed from: k */
    public void mo61191k(Object obj) {
        C9840e c9840eM61161c = this.f48376b.m61161c(obj);
        int i10 = c9840eM61161c.f48357a;
        int i11 = c9840eM61161c.f48358b;
        if (i11 == 5 || i11 == 6) {
            this.f48382h.m61146c(20, i10);
        } else if (i10 >= 256) {
            this.f48382h.m61146c(19, i10);
        } else {
            this.f48382h.m61145b(18, i10);
        }
    }

    @Override // p305g1.InterfaceC9843h
    /* renamed from: l */
    public void mo61192l(C9841f c9841f) {
        C9836a c9836a = this.f48382h;
        c9841f.m61178c(this, c9836a.f48328b, c9836a.f48327a);
    }

    /* renamed from: m */
    public final int m61193m() {
        int i10;
        if (this.f48382h.f48328b > 0) {
            this.f48376b.m61166h("Code");
            i10 = this.f48382h.f48328b + 26;
        } else {
            i10 = 8;
        }
        if (this.f48380f <= 0) {
            return i10;
        }
        this.f48376b.m61166h("Exceptions");
        return i10 + (this.f48380f * 2) + 8;
    }

    /* renamed from: n */
    public final void m61194n(C9836a c9836a) {
        c9836a.m61150g(this.f48377c & (-393217)).m61150g(this.f48378d).m61150g(this.f48379e);
        int i10 = this.f48382h.f48328b > 0 ? 1 : 0;
        if (this.f48380f > 0) {
            i10++;
        }
        c9836a.m61150g(i10);
        int i11 = this.f48382h.f48328b;
        if (i11 > 0) {
            c9836a.m61150g(this.f48376b.m61166h("Code")).m61149f(i11 + 12);
            c9836a.m61150g(this.f48383i).m61150g(this.f48384j);
            C9836a c9836aM61149f = c9836a.m61149f(this.f48382h.f48328b);
            C9836a c9836a2 = this.f48382h;
            c9836aM61149f.m61148e(c9836a2.f48327a, 0, c9836a2.f48328b);
            c9836a.m61150g(0);
            c9836a.m61150g(0);
        }
        if (this.f48380f > 0) {
            c9836a.m61150g(this.f48376b.m61166h("Exceptions")).m61149f((this.f48380f * 2) + 2);
            c9836a.m61150g(this.f48380f);
            for (int i12 = 0; i12 < this.f48380f; i12++) {
                c9836a.m61150g(this.f48381g[i12]);
            }
        }
    }
}
