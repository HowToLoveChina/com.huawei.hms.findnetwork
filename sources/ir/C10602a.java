package ir;

import com.huawei.hms.network.embedded.C5976k;
import java.util.Locale;

/* renamed from: ir.a */
/* loaded from: classes8.dex */
public final class C10602a {

    /* renamed from: a */
    public int f50976a;

    /* renamed from: b */
    public int f50977b;

    /* renamed from: c */
    public int f50978c;

    /* renamed from: d */
    public long f50979d;

    public C10602a(long j10) {
        m65005f(j10);
    }

    /* renamed from: a */
    public final int m65000a() {
        return this.f50977b;
    }

    /* renamed from: b */
    public final int m65001b() {
        return this.f50976a;
    }

    /* renamed from: c */
    public final long m65002c() {
        return this.f50979d;
    }

    /* renamed from: d */
    public final int m65003d() {
        return this.f50978c;
    }

    /* renamed from: e */
    public final int m65004e() {
        return (this.f50978c / 86400) * 86400;
    }

    /* renamed from: f */
    public final void m65005f(long j10) {
        long j11 = ((j10 / 1000) - 315964800) + 18;
        this.f50979d = j11;
        this.f50978c = (int) (j11 % C5976k.b.f27174l);
        int i10 = (int) (j11 / C5976k.b.f27174l);
        this.f50976a = i10 / 1024;
        this.f50977b = i10 % 1024;
    }

    public final String toString() {
        Locale locale = Locale.ENGLISH;
        return "weekRound: " + this.f50976a + " weekNumber = " + this.f50977b + " weekSecond: " + this.f50978c;
    }
}
