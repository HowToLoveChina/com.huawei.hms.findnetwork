package okhttp3;

import java.util.concurrent.TimeUnit;
import okhttp3.internal.connection.C11937k;

/* renamed from: okhttp3.l */
/* loaded from: classes9.dex */
public final class C11945l {
    final C11937k delegate;

    /* renamed from: okhttp3.l$a */
    public interface a {
        /* renamed from: a */
        void mo71523a(String str, int i10, String str2);
    }

    public C11945l() {
        this(5, 5L, TimeUnit.MINUTES);
    }

    /* renamed from: a */
    public void m71795a(a aVar) {
        this.delegate.m71737c(aVar);
    }

    /* renamed from: b */
    public int m71796b(String str, int i10, String str2) {
        return this.delegate.m71743i(str, i10, str2);
    }

    /* renamed from: c */
    public boolean m71797c(String str, int i10, String str2) {
        return this.delegate.m71745k(str, i10, str2);
    }

    public C11945l(int i10, long j10, TimeUnit timeUnit) {
        this.delegate = new C11937k(i10, j10, timeUnit);
    }
}
