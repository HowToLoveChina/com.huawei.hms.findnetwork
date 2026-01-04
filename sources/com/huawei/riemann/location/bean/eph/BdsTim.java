package com.huawei.riemann.location.bean.eph;

/* loaded from: classes5.dex */
public class BdsTim {
    public double mA0;
    public double mA1;
    public double mA2;
    public int mDeltaT;
    public int mGnssToId;
    public int mWeekNumber;
    public int mWeekSecond;

    public static final class Builder {

        /* renamed from: a0 */
        public double f40573a0;

        /* renamed from: a1 */
        public double f40574a1;

        /* renamed from: a2 */
        public double f40575a2;
        public int deltaT;
        public int gnssToId;
        public int weekNumber;
        public int weekSecond;

        public static Builder aBdsTim() {
            return new Builder();
        }

        public BdsTim build() {
            BdsTim bdsTim = new BdsTim();
            bdsTim.mA0 = this.f40573a0;
            bdsTim.mWeekSecond = this.weekSecond;
            bdsTim.mA2 = this.f40575a2;
            bdsTim.mGnssToId = this.gnssToId;
            bdsTim.mWeekNumber = this.weekNumber;
            bdsTim.mDeltaT = this.deltaT;
            bdsTim.mA1 = this.f40574a1;
            return bdsTim;
        }

        public Builder but() {
            return aBdsTim().withWeekSecond(this.weekSecond).withWeekNumber(this.weekNumber).withA0(this.f40573a0).withA1(this.f40574a1).withA2(this.f40575a2).withGnssToId(this.gnssToId).withDeltaT(this.deltaT);
        }

        public Builder withA0(double d10) {
            this.f40573a0 = d10;
            return this;
        }

        public Builder withA1(double d10) {
            this.f40574a1 = d10;
            return this;
        }

        public Builder withA2(double d10) {
            this.f40575a2 = d10;
            return this;
        }

        public Builder withDeltaT(int i10) {
            this.deltaT = i10;
            return this;
        }

        public Builder withGnssToId(int i10) {
            this.gnssToId = i10;
            return this;
        }

        public Builder withWeekNumber(int i10) {
            this.weekNumber = i10;
            return this;
        }

        public Builder withWeekSecond(int i10) {
            this.weekSecond = i10;
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

    public int getDeltaT() {
        return this.mDeltaT;
    }

    public int getGnssToId() {
        return this.mGnssToId;
    }

    public int getWeekNumber() {
        return this.mWeekNumber;
    }

    public int getWeekSecond() {
        return this.mWeekSecond;
    }
}
