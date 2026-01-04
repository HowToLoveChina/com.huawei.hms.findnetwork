package com.huawei.riemann.gnsslocation.core.bean.eph;

/* loaded from: classes5.dex */
public class GlonassTim {
    public double mA0;
    public double mA1;
    public double mA2;
    public int mGnssToId;
    public int mWeekNumber;
    public int mWeekSecond;

    public static final class Builder {

        /* renamed from: a0 */
        public double f40492a0;

        /* renamed from: a1 */
        public double f40493a1;

        /* renamed from: a2 */
        public double f40494a2;
        public int gnssToId;
        public int weekNumber;
        public int weekSecond;

        public static Builder aGlonassTim() {
            return new Builder();
        }

        public GlonassTim build() {
            GlonassTim glonassTim = new GlonassTim();
            glonassTim.mWeekSecond = this.weekSecond;
            glonassTim.mWeekNumber = this.weekNumber;
            glonassTim.mGnssToId = this.gnssToId;
            glonassTim.mA1 = this.f40493a1;
            glonassTim.mA0 = this.f40492a0;
            glonassTim.mA2 = this.f40494a2;
            return glonassTim;
        }

        public Builder but() {
            return aGlonassTim().withWeekSecond(this.weekSecond).withWeekNumber(this.weekNumber).withA0(this.f40492a0).withA1(this.f40493a1).withA2(this.f40494a2).withGnssToId(this.gnssToId);
        }

        public Builder withA0(double d10) {
            this.f40492a0 = d10;
            return this;
        }

        public Builder withA1(double d10) {
            this.f40493a1 = d10;
            return this;
        }

        public Builder withA2(double d10) {
            this.f40494a2 = d10;
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
