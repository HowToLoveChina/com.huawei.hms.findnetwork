package okhttp3;

import java.util.ArrayList;
import java.util.List;
import okhttp3.internal.connection.C11935i;

/* renamed from: okhttp3.x */
/* loaded from: classes9.dex */
public final class C11957x {

    /* renamed from: a */
    public final C11911b f55664a;

    /* renamed from: b */
    public final List<C11935i> f55665b = new ArrayList();

    /* renamed from: c */
    public int f55666c = 0;

    public C11957x(C11911b c11911b) {
        this.f55664a = c11911b;
    }

    /* renamed from: a */
    public void m71877a(C11935i c11935i) {
        if (this.f55665b.contains(c11935i)) {
            return;
        }
        this.f55665b.add(c11935i);
    }

    /* renamed from: b */
    public C11911b m71878b() {
        return this.f55664a;
    }

    /* renamed from: c */
    public C11935i m71879c() {
        return m71880d();
    }

    /* renamed from: d */
    public final C11935i m71880d() {
        C11935i c11935i = null;
        int i10 = Integer.MAX_VALUE;
        for (C11935i c11935i2 : this.f55665b) {
            int size = c11935i2.f55422p.size();
            if (size < c11935i2.f55421o && !c11935i2.f55417k && size < i10) {
                c11935i = c11935i2;
                i10 = size;
            }
        }
        return c11935i;
    }

    /* renamed from: e */
    public boolean m71881e() {
        return this.f55665b.isEmpty();
    }

    /* renamed from: f */
    public void m71882f(C11935i c11935i) {
        this.f55665b.remove(c11935i);
    }
}
