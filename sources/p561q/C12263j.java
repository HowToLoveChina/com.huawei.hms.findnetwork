package p561q;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import p596r.C12442i;
import p596r.C12448o;

/* renamed from: q.j */
/* loaded from: classes.dex */
public class C12263j extends C12258e implements InterfaceC12262i {

    /* renamed from: V0 */
    public C12258e[] f56888V0 = new C12258e[4];

    /* renamed from: W0 */
    public int f56889W0 = 0;

    @Override // p561q.InterfaceC12262i
    /* renamed from: a */
    public void mo73766a(C12258e c12258e) {
        if (c12258e == this || c12258e == null) {
            return;
        }
        int i10 = this.f56889W0 + 1;
        C12258e[] c12258eArr = this.f56888V0;
        if (i10 > c12258eArr.length) {
            this.f56888V0 = (C12258e[]) Arrays.copyOf(c12258eArr, c12258eArr.length * 2);
        }
        C12258e[] c12258eArr2 = this.f56888V0;
        int i11 = this.f56889W0;
        c12258eArr2[i11] = c12258e;
        this.f56889W0 = i11 + 1;
    }

    @Override // p561q.InterfaceC12262i
    /* renamed from: b */
    public void mo73767b() {
        this.f56889W0 = 0;
        Arrays.fill(this.f56888V0, (Object) null);
    }

    @Override // p561q.InterfaceC12262i
    /* renamed from: c */
    public void mo73768c(C12259f c12259f) {
    }

    @Override // p561q.C12258e
    /* renamed from: n */
    public void mo73514n(C12258e c12258e, HashMap<C12258e, C12258e> map) {
        super.mo73514n(c12258e, map);
        C12263j c12263j = (C12263j) c12258e;
        this.f56889W0 = 0;
        int i10 = c12263j.f56889W0;
        for (int i11 = 0; i11 < i10; i11++) {
            mo73766a(map.get(c12263j.f56888V0[i11]));
        }
    }

    /* renamed from: w1 */
    public void m73769w1(ArrayList<C12448o> arrayList, int i10, C12448o c12448o) {
        for (int i11 = 0; i11 < this.f56889W0; i11++) {
            c12448o.m74683a(this.f56888V0[i11]);
        }
        for (int i12 = 0; i12 < this.f56889W0; i12++) {
            C12442i.m74670a(this.f56888V0[i12], i10, arrayList, c12448o);
        }
    }

    /* renamed from: x1 */
    public int m73770x1(int i10) {
        int i11;
        int i12;
        for (int i13 = 0; i13 < this.f56889W0; i13++) {
            C12258e c12258e = this.f56888V0[i13];
            if (i10 == 0 && (i12 = c12258e.f56739S0) != -1) {
                return i12;
            }
            if (i10 == 1 && (i11 = c12258e.f56741T0) != -1) {
                return i11;
            }
        }
        return -1;
    }
}
