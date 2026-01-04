package p561q;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import p479n.C11573c;
import p479n.C11579i;
import p596r.C12442i;
import p596r.C12448o;

/* renamed from: q.d */
/* loaded from: classes.dex */
public class C12257d {

    /* renamed from: b */
    public int f56683b;

    /* renamed from: c */
    public boolean f56684c;

    /* renamed from: d */
    public final C12258e f56685d;

    /* renamed from: e */
    public final a f56686e;

    /* renamed from: f */
    public C12257d f56687f;

    /* renamed from: i */
    public C11579i f56690i;

    /* renamed from: a */
    public HashSet<C12257d> f56682a = null;

    /* renamed from: g */
    public int f56688g = 0;

    /* renamed from: h */
    public int f56689h = Integer.MIN_VALUE;

    /* renamed from: q.d$a */
    public enum a {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public C12257d(C12258e c12258e, a aVar) {
        this.f56685d = c12258e;
        this.f56686e = aVar;
    }

    /* renamed from: a */
    public boolean m73524a(C12257d c12257d, int i10) {
        return m73525b(c12257d, i10, Integer.MIN_VALUE, false);
    }

    /* renamed from: b */
    public boolean m73525b(C12257d c12257d, int i10, int i11, boolean z10) {
        if (c12257d == null) {
            m73540q();
            return true;
        }
        if (!z10 && !m73539p(c12257d)) {
            return false;
        }
        this.f56687f = c12257d;
        if (c12257d.f56682a == null) {
            c12257d.f56682a = new HashSet<>();
        }
        HashSet<C12257d> hashSet = this.f56687f.f56682a;
        if (hashSet != null) {
            hashSet.add(this);
        }
        this.f56688g = i10;
        this.f56689h = i11;
        return true;
    }

    /* renamed from: c */
    public void m73526c(int i10, ArrayList<C12448o> arrayList, C12448o c12448o) {
        HashSet<C12257d> hashSet = this.f56682a;
        if (hashSet != null) {
            Iterator<C12257d> it = hashSet.iterator();
            while (it.hasNext()) {
                C12442i.m74670a(it.next().f56685d, i10, arrayList, c12448o);
            }
        }
    }

    /* renamed from: d */
    public HashSet<C12257d> m73527d() {
        return this.f56682a;
    }

    /* renamed from: e */
    public int m73528e() {
        if (this.f56684c) {
            return this.f56683b;
        }
        return 0;
    }

    /* renamed from: f */
    public int m73529f() {
        C12257d c12257d;
        if (this.f56685d.m73592X() == 8) {
            return 0;
        }
        return (this.f56689h == Integer.MIN_VALUE || (c12257d = this.f56687f) == null || c12257d.f56685d.m73592X() != 8) ? this.f56688g : this.f56689h;
    }

    /* renamed from: g */
    public final C12257d m73530g() {
        switch (this.f56686e) {
            case NONE:
            case BASELINE:
            case CENTER:
            case CENTER_X:
            case CENTER_Y:
                return null;
            case LEFT:
                return this.f56685d.f56738S;
            case TOP:
                return this.f56685d.f56740T;
            case RIGHT:
                return this.f56685d.f56734Q;
            case BOTTOM:
                return this.f56685d.f56736R;
            default:
                throw new AssertionError(this.f56686e.name());
        }
    }

    /* renamed from: h */
    public C12258e m73531h() {
        return this.f56685d;
    }

    /* renamed from: i */
    public C11579i m73532i() {
        return this.f56690i;
    }

    /* renamed from: j */
    public C12257d m73533j() {
        return this.f56687f;
    }

    /* renamed from: k */
    public a m73534k() {
        return this.f56686e;
    }

    /* renamed from: l */
    public boolean m73535l() {
        HashSet<C12257d> hashSet = this.f56682a;
        if (hashSet == null) {
            return false;
        }
        Iterator<C12257d> it = hashSet.iterator();
        while (it.hasNext()) {
            if (it.next().m73530g().m73538o()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: m */
    public boolean m73536m() {
        HashSet<C12257d> hashSet = this.f56682a;
        return hashSet != null && hashSet.size() > 0;
    }

    /* renamed from: n */
    public boolean m73537n() {
        return this.f56684c;
    }

    /* renamed from: o */
    public boolean m73538o() {
        return this.f56687f != null;
    }

    /* renamed from: p */
    public boolean m73539p(C12257d c12257d) {
        if (c12257d == null) {
            return false;
        }
        a aVarM73534k = c12257d.m73534k();
        a aVar = this.f56686e;
        if (aVarM73534k == aVar) {
            return aVar != a.BASELINE || (c12257d.m73531h().m73600b0() && m73531h().m73600b0());
        }
        switch (aVar) {
            case NONE:
            case CENTER_X:
            case CENTER_Y:
                return false;
            case LEFT:
            case RIGHT:
                boolean z10 = aVarM73534k == a.LEFT || aVarM73534k == a.RIGHT;
                if (c12257d.m73531h() instanceof C12261h) {
                    return z10 || aVarM73534k == a.CENTER_X;
                }
                return z10;
            case TOP:
            case BOTTOM:
                boolean z11 = aVarM73534k == a.TOP || aVarM73534k == a.BOTTOM;
                if (c12257d.m73531h() instanceof C12261h) {
                    return z11 || aVarM73534k == a.CENTER_Y;
                }
                return z11;
            case BASELINE:
                return (aVarM73534k == a.LEFT || aVarM73534k == a.RIGHT) ? false : true;
            case CENTER:
                return (aVarM73534k == a.BASELINE || aVarM73534k == a.CENTER_X || aVarM73534k == a.CENTER_Y) ? false : true;
            default:
                throw new AssertionError(this.f56686e.name());
        }
    }

    /* renamed from: q */
    public void m73540q() {
        HashSet<C12257d> hashSet;
        C12257d c12257d = this.f56687f;
        if (c12257d != null && (hashSet = c12257d.f56682a) != null) {
            hashSet.remove(this);
            if (this.f56687f.f56682a.size() == 0) {
                this.f56687f.f56682a = null;
            }
        }
        this.f56682a = null;
        this.f56687f = null;
        this.f56688g = 0;
        this.f56689h = Integer.MIN_VALUE;
        this.f56684c = false;
        this.f56683b = 0;
    }

    /* renamed from: r */
    public void m73541r() {
        this.f56684c = false;
        this.f56683b = 0;
    }

    /* renamed from: s */
    public void m73542s(C11573c c11573c) {
        C11579i c11579i = this.f56690i;
        if (c11579i == null) {
            this.f56690i = new C11579i(C11579i.a.UNRESTRICTED, null);
        } else {
            c11579i.m69132h();
        }
    }

    /* renamed from: t */
    public void m73543t(int i10) {
        this.f56683b = i10;
        this.f56684c = true;
    }

    public String toString() {
        return this.f56685d.m73653v() + ":" + this.f56686e.toString();
    }

    /* renamed from: u */
    public void m73544u(int i10) {
        if (m73538o()) {
            this.f56689h = i10;
        }
    }
}
