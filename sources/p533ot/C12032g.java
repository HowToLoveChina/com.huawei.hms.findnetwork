package p533ot;

import java.util.Locale;
import p590qt.C12410r;

/* renamed from: ot.g */
/* loaded from: classes5.dex */
public class C12032g implements InterfaceC12031f {

    /* renamed from: a */
    public final double f55799a;

    /* renamed from: b */
    public final double f55800b;

    public C12032g() {
        this(2.65d, 72.5d);
    }

    @Override // p533ot.InterfaceC12031f
    /* renamed from: a */
    public double mo72176a(double d10) {
        if (d10 >= -128.0d && d10 <= 0.0d) {
            return Math.pow(10.0d, ((-this.f55800b) - d10) / (this.f55799a * 10.0d));
        }
        C12410r.m74523d().mo57439a("ALG-PolarisTagPosition", String.format(Locale.ENGLISH, "rssi %f out of range! Must be -128 <= rssi < 0 !", Double.valueOf(d10)));
        return 0.0d;
    }

    public C12032g(double d10, double d11) {
        if (d10 < 0.1d || d10 > 1000.0d) {
            C12410r.m74523d().mo57439a("ALG-PolarisTagPosition", String.format(Locale.ENGLISH, "multiplier %f out of range! Must be 0.1 <= multiplier <= 1000 !", Double.valueOf(d10)));
            this.f55799a = 2.65d;
            this.f55800b = d11;
        } else if (d11 >= -128.0d && d11 <= 127.0d) {
            this.f55799a = d10;
            this.f55800b = d11;
        } else {
            C12410r.m74523d().mo57439a("ALG-PolarisTagPosition", String.format(Locale.ENGLISH, "offset %f out of range! Must be -128 <= offset <= 127 !", Double.valueOf(d11)));
            this.f55799a = d10;
            this.f55800b = 72.5d;
        }
    }
}
