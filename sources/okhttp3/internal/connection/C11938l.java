package okhttp3.internal.connection;

import java.util.LinkedHashSet;
import java.util.Set;
import okhttp3.C11926i0;

/* renamed from: okhttp3.internal.connection.l */
/* loaded from: classes9.dex */
public final class C11938l {

    /* renamed from: a */
    public final Set<C11926i0> f55432a = new LinkedHashSet();

    /* renamed from: a */
    public synchronized void m71752a(C11926i0 c11926i0) {
        this.f55432a.remove(c11926i0);
    }

    /* renamed from: b */
    public synchronized void m71753b(C11926i0 c11926i0) {
        this.f55432a.add(c11926i0);
    }

    /* renamed from: c */
    public synchronized boolean m71754c(C11926i0 c11926i0) {
        return this.f55432a.contains(c11926i0);
    }
}
