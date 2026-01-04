package com.huawei.riemann.gnsslocation.core.bean.eph;

/* loaded from: classes5.dex */
public class GalileoTim {
    public double mA0;
    public double mA1;
    public long mT0;

    public static final class Builder {

        /* renamed from: a0 */
        public double f40478a0;

        /* renamed from: a1 */
        public double f40479a1;

        /* renamed from: t0 */
        public long f40480t0;

        public static Builder aGalileoTim() {
            return new Builder();
        }

        public GalileoTim build() {
            GalileoTim galileoTim = new GalileoTim();
            galileoTim.mA0 = this.f40478a0;
            galileoTim.mA1 = this.f40479a1;
            galileoTim.mT0 = this.f40480t0;
            return galileoTim;
        }

        public Builder but() {
            return aGalileoTim().withA0(this.f40478a0).withA1(this.f40479a1).withT0(this.f40480t0);
        }

        public Builder withA0(double d10) {
            this.f40478a0 = d10;
            return this;
        }

        public Builder withA1(double d10) {
            this.f40479a1 = d10;
            return this;
        }

        public Builder withT0(long j10) {
            this.f40480t0 = j10;
            return this;
        }
    }

    public double getA0() {
        return this.mA0;
    }

    public double getA1() {
        return this.mA1;
    }

    public long getT0() {
        return this.mT0;
    }
}
