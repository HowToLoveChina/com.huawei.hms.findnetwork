package p786xs;

import java.util.ArrayList;

/* renamed from: xs.e */
/* loaded from: classes8.dex */
public final class C13858e {

    /* renamed from: a */
    public String f62142a = "XXX-XXX-XXX";

    /* renamed from: b */
    public ArrayList f62143b = new ArrayList();

    /* renamed from: a */
    public final boolean m83169a(double d10, double d11) {
        if (this.f62143b.size() < 3) {
            return false;
        }
        for (int i10 = 0; i10 < this.f62143b.size(); i10++) {
            if (i10 != this.f62143b.size() - 1) {
                double d12 = ((C13861h) this.f62143b.get(i10)).f62146b;
                double d13 = ((C13861h) this.f62143b.get(i10)).f62145a;
                int i11 = i10 + 1;
                if ((d13 - ((C13861h) this.f62143b.get(i11)).f62145a) * (d10 - d12) == (d11 - d13) * (d12 - ((C13861h) this.f62143b.get(i11)).f62146b)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: b */
    public final String m83170b() {
        return this.f62142a;
    }

    /* renamed from: c */
    public final void m83171c(String str) {
        this.f62142a = str;
    }

    /* renamed from: d */
    public final void m83172d(C13861h c13861h) {
        this.f62143b.add(c13861h);
    }

    /* renamed from: e */
    public final boolean m83173e(double d10, double d11) {
        double d12;
        double d13;
        double d14;
        double d15;
        if (this.f62143b.size() < 3) {
            return false;
        }
        int i10 = 0;
        for (int i11 = 0; i11 < this.f62143b.size(); i11++) {
            if (i11 != this.f62143b.size() - 1) {
                if (i11 == this.f62143b.size() - 2) {
                    d12 = ((C13861h) this.f62143b.get(i11)).f62146b;
                    d13 = ((C13861h) this.f62143b.get(i11)).f62145a;
                    d14 = ((C13861h) this.f62143b.get(0)).f62146b;
                    d15 = ((C13861h) this.f62143b.get(0)).f62145a;
                } else {
                    d12 = ((C13861h) this.f62143b.get(i11)).f62146b;
                    d13 = ((C13861h) this.f62143b.get(i11)).f62145a;
                    int i12 = i11 + 1;
                    d14 = ((C13861h) this.f62143b.get(i12)).f62146b;
                    d15 = ((C13861h) this.f62143b.get(i12)).f62145a;
                }
                if ((d11 >= d13 && d11 < d15) || (d11 >= d15 && d11 < d13)) {
                    double d16 = d13 - d15;
                    if (Math.abs(d16) > 0.0d) {
                        if (d12 - (((d13 - d11) * (d12 - d14)) / d16) < d10) {
                            i10++;
                        }
                    }
                }
            }
        }
        return i10 % 2 != 0;
    }
}
