package com.huawei.riemann.gnsslocation.core.bean.eph;

/* loaded from: classes5.dex */
public class BdsNav {
    public int mAcc;
    public double mAf0;
    public double mAf1;
    public double mAf2;
    public int mAodc;
    public int mAode;
    public double mCic;
    public double mCis;
    public double mCrc;
    public double mCrs;
    public double mCuc;
    public double mCus;
    public double mDeltaN;
    public double mEcc;
    public double mGroupDelay;
    public int mHealth;
    public double mI0;
    public double mIDot;
    public double mM0;
    public double mOmega;
    public double mOmega0;
    public double mOmegaDot;
    public double mSqrtA;
    public int mSvid;
    public int mToc;
    public int mToe;

    public static final class Builder {
        public int acc;
        public double af0;
        public double af1;
        public double af2;
        public int aodc;
        public int aode;
        public double cic;
        public double cis;
        public double crc;
        public double crs;
        public double cuc;
        public double cus;
        public double deltaN;
        public double ecc;
        public double groupDelay;
        public int health;

        /* renamed from: i0 */
        public double f40471i0;
        public double iDot;

        /* renamed from: m0 */
        public double f40472m0;
        public double omega;
        public double omega0;
        public double omegaDot;
        public double sqrtA;
        public int svid;
        public int toc;
        public int toe;

        public static Builder aBdsNav() {
            return new Builder();
        }

        public BdsNav build() {
            BdsNav bdsNav = new BdsNav();
            bdsNav.mAf0 = this.af0;
            bdsNav.mOmega = this.omega;
            bdsNav.mCrc = this.crc;
            bdsNav.mAcc = this.acc;
            bdsNav.mHealth = this.health;
            bdsNav.mAodc = this.aodc;
            bdsNav.mToe = this.toe;
            bdsNav.mAf1 = this.af1;
            bdsNav.mCic = this.cic;
            bdsNav.mI0 = this.f40471i0;
            bdsNav.mOmegaDot = this.omegaDot;
            bdsNav.mCus = this.cus;
            bdsNav.mToc = this.toc;
            bdsNav.mIDot = this.iDot;
            bdsNav.mGroupDelay = this.groupDelay;
            bdsNav.mCuc = this.cuc;
            bdsNav.mEcc = this.ecc;
            bdsNav.mOmega0 = this.omega0;
            bdsNav.mAf2 = this.af2;
            bdsNav.mDeltaN = this.deltaN;
            bdsNav.mSvid = this.svid;
            bdsNav.mAode = this.aode;
            bdsNav.mCis = this.cis;
            bdsNav.mCrs = this.crs;
            bdsNav.mM0 = this.f40472m0;
            bdsNav.mSqrtA = this.sqrtA;
            return bdsNav;
        }

        public Builder but() {
            return aBdsNav().withSvid(this.svid).withAcc(this.acc).withAodc(this.aodc).withAode(this.aode).withM0(this.f40472m0).withDeltaN(this.deltaN).withEcc(this.ecc).withSqrtA(this.sqrtA).withOmega0(this.omega0).withI0(this.f40471i0).withOmega(this.omega).withOmegaDot(this.omegaDot).withIDot(this.iDot).withCuc(this.cuc).withCus(this.cus).withCrc(this.crc).withCrs(this.crs).withCic(this.cic).withCis(this.cis).withGroupDelay(this.groupDelay).withAf0(this.af0).withAf1(this.af1).withAf2(this.af2).withHealth(this.health).withToc(this.toc).withToe(this.toe);
        }

        public Builder withAcc(int i10) {
            this.acc = i10;
            return this;
        }

        public Builder withAf0(double d10) {
            this.af0 = d10;
            return this;
        }

        public Builder withAf1(double d10) {
            this.af1 = d10;
            return this;
        }

        public Builder withAf2(double d10) {
            this.af2 = d10;
            return this;
        }

        public Builder withAodc(int i10) {
            this.aodc = i10;
            return this;
        }

        public Builder withAode(int i10) {
            this.aode = i10;
            return this;
        }

        public Builder withCic(double d10) {
            this.cic = d10;
            return this;
        }

        public Builder withCis(double d10) {
            this.cis = d10;
            return this;
        }

        public Builder withCrc(double d10) {
            this.crc = d10;
            return this;
        }

        public Builder withCrs(double d10) {
            this.crs = d10;
            return this;
        }

        public Builder withCuc(double d10) {
            this.cuc = d10;
            return this;
        }

        public Builder withCus(double d10) {
            this.cus = d10;
            return this;
        }

        public Builder withDeltaN(double d10) {
            this.deltaN = d10;
            return this;
        }

        public Builder withEcc(double d10) {
            this.ecc = d10;
            return this;
        }

        public Builder withGroupDelay(double d10) {
            this.groupDelay = d10;
            return this;
        }

        public Builder withHealth(int i10) {
            this.health = i10;
            return this;
        }

        public Builder withI0(double d10) {
            this.f40471i0 = d10;
            return this;
        }

        public Builder withIDot(double d10) {
            this.iDot = d10;
            return this;
        }

        public Builder withM0(double d10) {
            this.f40472m0 = d10;
            return this;
        }

        public Builder withOmega(double d10) {
            this.omega = d10;
            return this;
        }

        public Builder withOmega0(double d10) {
            this.omega0 = d10;
            return this;
        }

        public Builder withOmegaDot(double d10) {
            this.omegaDot = d10;
            return this;
        }

        public Builder withSqrtA(double d10) {
            this.sqrtA = d10;
            return this;
        }

        public Builder withSvid(int i10) {
            this.svid = i10;
            return this;
        }

        public Builder withToc(int i10) {
            this.toc = i10;
            return this;
        }

        public Builder withToe(int i10) {
            this.toe = i10;
            return this;
        }
    }

    public int getAcc() {
        return this.mAcc;
    }

    public double getAf0() {
        return this.mAf0;
    }

    public double getAf1() {
        return this.mAf1;
    }

    public double getAf2() {
        return this.mAf2;
    }

    public int getAodc() {
        return this.mAodc;
    }

    public int getAode() {
        return this.mAode;
    }

    public double getCic() {
        return this.mCic;
    }

    public double getCis() {
        return this.mCis;
    }

    public double getCrc() {
        return this.mCrc;
    }

    public double getCrs() {
        return this.mCrs;
    }

    public double getCuc() {
        return this.mCuc;
    }

    public double getCus() {
        return this.mCus;
    }

    public double getDeltaN() {
        return this.mDeltaN;
    }

    public double getEcc() {
        return this.mEcc;
    }

    public double getGroupDelay() {
        return this.mGroupDelay;
    }

    public int getHealth() {
        return this.mHealth;
    }

    public double getI0() {
        return this.mI0;
    }

    public double getIDot() {
        return this.mIDot;
    }

    public double getM0() {
        return this.mM0;
    }

    public double getOmega() {
        return this.mOmega;
    }

    public double getOmega0() {
        return this.mOmega0;
    }

    public double getOmegaDot() {
        return this.mOmegaDot;
    }

    public double getSqrtA() {
        return this.mSqrtA;
    }

    public int getSvid() {
        return this.mSvid;
    }

    public int getToc() {
        return this.mToc;
    }

    public int getToe() {
        return this.mToe;
    }
}
