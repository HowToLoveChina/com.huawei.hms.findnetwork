package bt;

import com.huawei.hms.network.embedded.C5976k;
import java.util.Locale;

/* renamed from: bt.a */
/* loaded from: classes8.dex */
public final class C1284a {

    /* renamed from: a */
    public int f5750a;

    /* renamed from: b */
    public int f5751b;

    /* renamed from: c */
    public int f5752c;

    /* renamed from: d */
    public long f5753d;

    public C1284a(long j10) {
        m7622f(j10);
    }

    /* renamed from: a */
    public final int m7617a() {
        return this.f5751b;
    }

    /* renamed from: b */
    public final int m7618b() {
        return this.f5750a;
    }

    /* renamed from: c */
    public final long m7619c() {
        return this.f5753d;
    }

    /* renamed from: d */
    public final int m7620d() {
        return this.f5752c;
    }

    /* renamed from: e */
    public final int m7621e() {
        return (this.f5752c / 86400) * 86400;
    }

    /* renamed from: f */
    public final void m7622f(long j10) {
        long j11 = ((j10 / 1000) - 315964800) + 18;
        this.f5753d = j11;
        this.f5752c = (int) (j11 % C5976k.b.f27174l);
        int i10 = (int) (j11 / C5976k.b.f27174l);
        this.f5750a = i10 / 1024;
        this.f5751b = i10 % 1024;
    }

    public final String toString() {
        Locale locale = Locale.ENGLISH;
        return "weekRound: " + this.f5750a + " weekNumber = " + this.f5751b + " weekSecond: " + this.f5752c;
    }
}
