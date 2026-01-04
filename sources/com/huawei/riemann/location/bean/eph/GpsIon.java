package com.huawei.riemann.location.bean.eph;

/* loaded from: classes5.dex */
public class GpsIon {
    public double mA0;
    public double mA1;
    public double mA2;
    public double mA3;
    public int mB0;
    public int mB1;
    public int mB2;
    public int mB3;
    public boolean mValid;

    public static final class Builder {

        /* renamed from: a0 */
        public double f40595a0;

        /* renamed from: a1 */
        public double f40596a1;

        /* renamed from: a2 */
        public double f40597a2;

        /* renamed from: a3 */
        public double f40598a3;

        /* renamed from: b0 */
        public int f40599b0;

        /* renamed from: b1 */
        public int f40600b1;

        /* renamed from: b2 */
        public int f40601b2;

        /* renamed from: b3 */
        public int f40602b3;
        public boolean valid;

        public static Builder aGpsIon() {
            return new Builder();
        }

        public GpsIon build() {
            GpsIon gpsIon = new GpsIon();
            gpsIon.mB3 = this.f40602b3;
            gpsIon.mA2 = this.f40597a2;
            gpsIon.mA3 = this.f40598a3;
            gpsIon.mA1 = this.f40596a1;
            gpsIon.mA0 = this.f40595a0;
            gpsIon.mB1 = this.f40600b1;
            gpsIon.mB2 = this.f40601b2;
            gpsIon.mB0 = this.f40599b0;
            gpsIon.mValid = this.valid;
            return gpsIon;
        }

        public Builder but() {
            return aGpsIon().withA0(this.f40595a0).withA1(this.f40596a1).withA2(this.f40597a2).withA3(this.f40598a3).withB0(this.f40599b0).withB1(this.f40600b1).withB2(this.f40601b2).withB3(this.f40602b3).withValid(this.valid);
        }

        public Builder withA0(double d10) {
            this.f40595a0 = d10;
            return this;
        }

        public Builder withA1(double d10) {
            this.f40596a1 = d10;
            return this;
        }

        public Builder withA2(double d10) {
            this.f40597a2 = d10;
            return this;
        }

        public Builder withA3(double d10) {
            this.f40598a3 = d10;
            return this;
        }

        public Builder withB0(int i10) {
            this.f40599b0 = i10;
            return this;
        }

        public Builder withB1(int i10) {
            this.f40600b1 = i10;
            return this;
        }

        public Builder withB2(int i10) {
            this.f40601b2 = i10;
            return this;
        }

        public Builder withB3(int i10) {
            this.f40602b3 = i10;
            return this;
        }

        public Builder withValid(boolean z10) {
            this.valid = z10;
            return this;
        }
    }

    public double getA0() {
        return this.mA0;
    }

    public double getA1() {
        return this.mA1;
    }

    public double getA2() {
        return this.mA2;
    }

    public double getA3() {
        return this.mA3;
    }

    public int getB0() {
        return this.mB0;
    }

    public int getB1() {
        return this.mB1;
    }

    public int getB2() {
        return this.mB2;
    }

    public int getB3() {
        return this.mB3;
    }

    public boolean getValid() {
        return this.mValid;
    }
}
