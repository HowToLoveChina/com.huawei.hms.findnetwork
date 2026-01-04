package p561q;

import p479n.C11574d;
import p561q.C12258e;

/* renamed from: q.k */
/* loaded from: classes.dex */
public class C12264k {

    /* renamed from: a */
    public static boolean[] f56890a = new boolean[3];

    /* renamed from: a */
    public static void m73771a(C12259f c12259f, C11574d c11574d, C12258e c12258e) {
        c12258e.f56786t = -1;
        c12258e.f56788u = -1;
        C12258e.b bVar = c12259f.f56751b0[0];
        C12258e.b bVar2 = C12258e.b.WRAP_CONTENT;
        if (bVar != bVar2 && c12258e.f56751b0[0] == C12258e.b.MATCH_PARENT) {
            int i10 = c12258e.f56734Q.f56688g;
            int iM73594Y = c12259f.m73594Y() - c12258e.f56738S.f56688g;
            C12257d c12257d = c12258e.f56734Q;
            c12257d.f56690i = c11574d.m69108q(c12257d);
            C12257d c12257d2 = c12258e.f56738S;
            c12257d2.f56690i = c11574d.m69108q(c12257d2);
            c11574d.m69097f(c12258e.f56734Q.f56690i, i10);
            c11574d.m69097f(c12258e.f56738S.f56690i, iM73594Y);
            c12258e.f56786t = 2;
            c12258e.m73585T0(i10, iM73594Y);
        }
        if (c12259f.f56751b0[1] == bVar2 || c12258e.f56751b0[1] != C12258e.b.MATCH_PARENT) {
            return;
        }
        int i11 = c12258e.f56736R.f56688g;
        int iM73662z = c12259f.m73662z() - c12258e.f56740T.f56688g;
        C12257d c12257d3 = c12258e.f56736R;
        c12257d3.f56690i = c11574d.m69108q(c12257d3);
        C12257d c12257d4 = c12258e.f56740T;
        c12257d4.f56690i = c11574d.m69108q(c12257d4);
        c11574d.m69097f(c12258e.f56736R.f56690i, i11);
        c11574d.m69097f(c12258e.f56740T.f56690i, iM73662z);
        if (c12258e.f56775n0 > 0 || c12258e.m73592X() == 8) {
            C12257d c12257d5 = c12258e.f56742U;
            c12257d5.f56690i = c11574d.m69108q(c12257d5);
            c11574d.m69097f(c12258e.f56742U.f56690i, c12258e.f56775n0 + i11);
        }
        c12258e.f56788u = 2;
        c12258e.m73625k1(i11, iM73662z);
    }

    /* renamed from: b */
    public static final boolean m73772b(int i10, int i11) {
        return (i10 & i11) == i11;
    }
}
