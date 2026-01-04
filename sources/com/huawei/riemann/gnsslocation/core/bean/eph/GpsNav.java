package com.huawei.riemann.gnsslocation.core.bean.eph;

/* loaded from: classes5.dex */
public class GpsNav {
    public int mAcc;
    public double mAf0;
    public double mAf1;
    public double mAf2;
    public int mAodo;
    public double mCic;
    public double mCis;
    public double mCrc;
    public double mCrs;
    public double mCuc;
    public double mCus;
    public double mDeltaN;
    public double mEcc;
    public double mGpsTow23b;
    public double mGroupDelay;
    public int mHealth;
    public double mI0;
    public double mIDot;
    public int mIodc;
    public int mIode;
    public double mM0;
    public double mOmega;
    public double mOmega0;
    public double mOmegaDot;
    public double mSqrtA;
    public int mSvid;
    public int mToc;
    public int mToe;
    public int mWeekNumber;

    public static final class Builder {
        public int acc;
        public double af0;
        public double af1;
        public double af2;
        public int aodo;
        public double cic;
        public double cis;
        public double crc;
        public double crs;
        public double cuc;
        public double cus;
        public double deltaN;
        public double ecc;
        public double gpsTow23b;
        public double groupDelay;
        public int health;

        /* renamed from: i0 */
        public double f40503i0;
        public double idot;
        public int iodc;
        public int iode;

        /* renamed from: m0 */
        public double f40504m0;
        public double omega;
        public double omega0;
        public double omegaDot;
        public double sqrtA;
        public int svid;
        public int toc;
        public int toe;
        public int weekNumber;

        public static Builder aGpsNav() {
            return new Builder();
        }

        public GpsNav build() {
            GpsNav gpsNav = new GpsNav();
            gpsNav.mGroupDelay = this.groupDelay;
            gpsNav.mAf0 = this.af0;
            gpsNav.mAcc = this.acc;
            gpsNav.mIode = this.iode;
            gpsNav.mCrs = this.crs;
            gpsNav.mCis = this.cis;
            gpsNav.mEcc = this.ecc;
            gpsNav.mOmega = this.omega;
            gpsNav.mCus = this.cus;
            gpsNav.mGpsTow23b = this.gpsTow23b;
            gpsNav.mAf2 = this.af2;
            gpsNav.mWeekNumber = this.weekNumber;
            gpsNav.mIDot = this.idot;
            gpsNav.mHealth = this.health;
            gpsNav.mToe = this.toe;
            gpsNav.mSqrtA = this.sqrtA;
            gpsNav.mM0 = this.f40504m0;
            gpsNav.mCuc = this.cuc;
            gpsNav.mI0 = this.f40503i0;
            gpsNav.mOmegaDot = this.omegaDot;
            gpsNav.mAodo = this.aodo;
            gpsNav.mAf1 = this.af1;
            gpsNav.mIodc = this.iodc;
            gpsNav.mToc = this.toc;
            gpsNav.mSvid = this.svid;
            gpsNav.mDeltaN = this.deltaN;
            gpsNav.mOmega0 = this.omega0;
            gpsNav.mCic = this.cic;
            gpsNav.mCrc = this.crc;
            return gpsNav;
        }

        public Builder but() {
            return aGpsNav().withSvid(this.svid).withAcc(this.acc).withIodc(this.iodc).withIode(this.iode).withAodo(this.aodo).withM0(this.f40504m0).withDeltaN(this.deltaN).withEcc(this.ecc).withSqrtA(this.sqrtA).withOmega0(this.omega0).withI0(this.f40503i0).withOmega(this.omega).withOmegaDot(this.omegaDot).withIdot(this.idot).withCuc(this.cuc).withCus(this.cus).withCrc(this.crc).withCrs(this.crs).withCic(this.cic).withCis(this.cis).withGroupDelay(this.groupDelay).withAf0(this.af0).withAf1(this.af1).withAf2(this.af2).withHealth(this.health).withToc(this.toc).withToe(this.toe).withGpsTow23b(this.gpsTow23b).withWeekNumber(this.weekNumber);
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

        public Builder withAodo(int i10) {
            this.aodo = i10;
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

        public Builder withGpsTow23b(double d10) {
            this.gpsTow23b = d10;
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
            this.f40503i0 = d10;
            return this;
        }

        public Builder withIdot(double d10) {
            this.idot = d10;
            return this;
        }

        public Builder withIodc(int i10) {
            this.iodc = i10;
            return this;
        }

        public Builder withIode(int i10) {
            this.iode = i10;
            return this;
        }

        public Builder withM0(double d10) {
            this.f40504m0 = d10;
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

        public Builder withWeekNumber(int i10) {
            this.weekNumber = i10;
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

    public int getAodo() {
        return this.mAodo;
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

    public double getGpsTow23b() {
        return this.mGpsTow23b;
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

    public int getIodc() {
        return this.mIodc;
    }

    public int getIode() {
        return this.mIode;
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

    public int getWeekNumber() {
        return this.mWeekNumber;
    }
}
