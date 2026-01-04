package com.huawei.riemann.gnsslocation.core.bean.eph;

/* loaded from: classes5.dex */
public class BdsIon {
    public double mA0;
    public double mA1;
    public double mA2;
    public double mA3;
    public int mB0;
    public int mB1;
    public int mB2;
    public int mB3;
    public int mSvid;
    public int mToe;

    public static final class Builder {

        /* renamed from: a0 */
        public double f40463a0;

        /* renamed from: a1 */
        public double f40464a1;

        /* renamed from: a2 */
        public double f40465a2;

        /* renamed from: a3 */
        public double f40466a3;

        /* renamed from: b0 */
        public int f40467b0;

        /* renamed from: b1 */
        public int f40468b1;

        /* renamed from: b2 */
        public int f40469b2;

        /* renamed from: b3 */
        public int f40470b3;
        public int svid;
        public int toe;

        public static Builder aBdsIon() {
            return new Builder();
        }

        public BdsIon build() {
            BdsIon bdsIon = new BdsIon();
            bdsIon.mSvid = this.svid;
            bdsIon.mA2 = this.f40465a2;
            bdsIon.mB2 = this.f40469b2;
            bdsIon.mA0 = this.f40463a0;
            bdsIon.mA1 = this.f40464a1;
            bdsIon.mA3 = this.f40466a3;
            bdsIon.mB0 = this.f40467b0;
            bdsIon.mB1 = this.f40468b1;
            bdsIon.mB3 = this.f40470b3;
            bdsIon.mToe = this.toe;
            return bdsIon;
        }

        public Builder but() {
            return aBdsIon().withSvid(this.svid).withToe(this.toe).withA0(this.f40463a0).withA1(this.f40464a1).withA2(this.f40465a2).withA3(this.f40466a3).withB0(this.f40467b0).withB1(this.f40468b1).withB2(this.f40469b2).withB3(this.f40470b3);
        }

        public Builder withA0(double d10) {
            this.f40463a0 = d10;
            return this;
        }

        public Builder withA1(double d10) {
            this.f40464a1 = d10;
            return this;
        }

        public Builder withA2(double d10) {
            this.f40465a2 = d10;
            return this;
        }

        public Builder withA3(double d10) {
            this.f40466a3 = d10;
            return this;
        }

        public Builder withB0(int i10) {
            this.f40467b0 = i10;
            return this;
        }

        public Builder withB1(int i10) {
            this.f40468b1 = i10;
            return this;
        }

        public Builder withB2(int i10) {
            this.f40469b2 = i10;
            return this;
        }

        public Builder withB3(int i10) {
            this.f40470b3 = i10;
            return this;
        }

        public Builder withSvid(int i10) {
            this.svid = i10;
            return this;
        }

        public Builder withToe(int i10) {
            this.toe = i10;
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

    public int getSvid() {
        return this.mSvid;
    }

    public int getToe() {
        return this.mToe;
    }
}
