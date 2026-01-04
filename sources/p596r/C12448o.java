package p596r;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import p479n.C11574d;
import p561q.C12255b;
import p561q.C12258e;
import p561q.C12259f;

/* renamed from: r.o */
/* loaded from: classes.dex */
public class C12448o {

    /* renamed from: g */
    public static int f57343g;

    /* renamed from: b */
    public int f57345b;

    /* renamed from: d */
    public int f57347d;

    /* renamed from: a */
    public ArrayList<C12258e> f57344a = new ArrayList<>();

    /* renamed from: c */
    public boolean f57346c = false;

    /* renamed from: e */
    public ArrayList<a> f57348e = null;

    /* renamed from: f */
    public int f57349f = -1;

    /* renamed from: r.o$a */
    public static class a {

        /* renamed from: a */
        public WeakReference<C12258e> f57350a;

        /* renamed from: b */
        public int f57351b;

        /* renamed from: c */
        public int f57352c;

        /* renamed from: d */
        public int f57353d;

        /* renamed from: e */
        public int f57354e;

        /* renamed from: f */
        public int f57355f;

        /* renamed from: g */
        public int f57356g;

        public a(C12258e c12258e, C11574d c11574d, int i10) {
            this.f57350a = new WeakReference<>(c12258e);
            this.f57351b = c11574d.m69114y(c12258e.f56734Q);
            this.f57352c = c11574d.m69114y(c12258e.f56736R);
            this.f57353d = c11574d.m69114y(c12258e.f56738S);
            this.f57354e = c11574d.m69114y(c12258e.f56740T);
            this.f57355f = c11574d.m69114y(c12258e.f56742U);
            this.f57356g = i10;
        }
    }

    public C12448o(int i10) {
        int i11 = f57343g;
        f57343g = i11 + 1;
        this.f57345b = i11;
        this.f57347d = i10;
    }

    /* renamed from: a */
    public boolean m74683a(C12258e c12258e) {
        if (this.f57344a.contains(c12258e)) {
            return false;
        }
        this.f57344a.add(c12258e);
        return true;
    }

    /* renamed from: b */
    public void m74684b(ArrayList<C12448o> arrayList) {
        int size = this.f57344a.size();
        if (this.f57349f != -1 && size > 0) {
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                C12448o c12448o = arrayList.get(i10);
                if (this.f57349f == c12448o.f57345b) {
                    m74689g(this.f57347d, c12448o);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    /* renamed from: c */
    public int m74685c() {
        return this.f57345b;
    }

    /* renamed from: d */
    public int m74686d() {
        return this.f57347d;
    }

    /* renamed from: e */
    public final String m74687e() {
        int i10 = this.f57347d;
        return i10 == 0 ? "Horizontal" : i10 == 1 ? "Vertical" : i10 == 2 ? "Both" : "Unknown";
    }

    /* renamed from: f */
    public int m74688f(C11574d c11574d, int i10) {
        if (this.f57344a.size() == 0) {
            return 0;
        }
        return m74692j(c11574d, this.f57344a, i10);
    }

    /* renamed from: g */
    public void m74689g(int i10, C12448o c12448o) {
        Iterator<C12258e> it = this.f57344a.iterator();
        while (it.hasNext()) {
            C12258e next = it.next();
            c12448o.m74683a(next);
            if (i10 == 0) {
                next.f56739S0 = c12448o.m74685c();
            } else {
                next.f56741T0 = c12448o.m74685c();
            }
        }
        this.f57349f = c12448o.f57345b;
    }

    /* renamed from: h */
    public void m74690h(boolean z10) {
        this.f57346c = z10;
    }

    /* renamed from: i */
    public void m74691i(int i10) {
        this.f57347d = i10;
    }

    /* renamed from: j */
    public final int m74692j(C11574d c11574d, ArrayList<C12258e> arrayList, int i10) {
        int iM69114y;
        int iM69114y2;
        C12259f c12259f = (C12259f) arrayList.get(0).m73570M();
        c11574d.m69091E();
        c12259f.mo73512g(c11574d, false);
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            arrayList.get(i11).mo73512g(c11574d, false);
        }
        if (i10 == 0 && c12259f.f56816g1 > 0) {
            C12255b.m73520b(c12259f, c11574d, arrayList, 0);
        }
        if (i10 == 1 && c12259f.f56817h1 > 0) {
            C12255b.m73520b(c12259f, c11574d, arrayList, 1);
        }
        try {
            c11574d.m69087A();
        } catch (Exception e10) {
            System.err.println(e10.toString() + "\n" + Arrays.toString(e10.getStackTrace()).replace("[", "   at ").replace(",", "\n   at").replace("]", ""));
        }
        this.f57348e = new ArrayList<>();
        for (int i12 = 0; i12 < arrayList.size(); i12++) {
            this.f57348e.add(new a(arrayList.get(i12), c11574d, i10));
        }
        if (i10 == 0) {
            iM69114y = c11574d.m69114y(c12259f.f56734Q);
            iM69114y2 = c11574d.m69114y(c12259f.f56738S);
            c11574d.m69091E();
        } else {
            iM69114y = c11574d.m69114y(c12259f.f56736R);
            iM69114y2 = c11574d.m69114y(c12259f.f56740T);
            c11574d.m69091E();
        }
        return iM69114y2 - iM69114y;
    }

    public String toString() {
        String str = m74687e() + " [" + this.f57345b + "] <";
        Iterator<C12258e> it = this.f57344a.iterator();
        while (it.hasNext()) {
            str = str + " " + it.next().m73653v();
        }
        return str + " >";
    }
}
