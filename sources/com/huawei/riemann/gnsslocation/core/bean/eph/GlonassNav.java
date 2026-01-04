package com.huawei.riemann.gnsslocation.core.bean.eph;

/* loaded from: classes5.dex */
public class GlonassNav {
    public double mDeltaTau;
    public int mEn;
    public double mGamma;
    public int mHealth;
    public int mIod;

    /* renamed from: mM */
    public int f40481mM;
    public int mP1;
    public int mP2;
    public int mSvid;
    public double mTaun;

    /* renamed from: mX */
    public double f40482mX;
    public double mXDot;
    public double mXDotDot;

    /* renamed from: mY */
    public double f40483mY;
    public double mYDot;
    public double mYDotDot;

    /* renamed from: mZ */
    public double f40484mZ;
    public double mZDot;
    public double mZDotDot;

    public static final class Builder {
        public double deltaTau;

        /* renamed from: en */
        public int f40485en;
        public double gamma;
        public int health;
        public int iod;

        /* renamed from: m */
        public int f40486m;

        /* renamed from: p1 */
        public int f40487p1;

        /* renamed from: p2 */
        public int f40488p2;
        public int svid;
        public double taun;

        /* renamed from: x */
        public double f40489x;
        public double xDot;
        public double xDotDot;

        /* renamed from: y */
        public double f40490y;
        public double yDot;
        public double yDotDot;

        /* renamed from: z */
        public double f40491z;
        public double zDot;
        public double zDotDot;

        public static Builder aGlonassNav() {
            return new Builder();
        }

        public GlonassNav build() {
            GlonassNav glonassNav = new GlonassNav();
            glonassNav.mTaun = this.taun;
            glonassNav.mZDotDot = this.zDotDot;
            glonassNav.mSvid = this.svid;
            glonassNav.f40481mM = this.f40486m;
            glonassNav.mYDot = this.yDot;
            glonassNav.mP1 = this.f40487p1;
            glonassNav.mXDot = this.xDot;
            glonassNav.mXDotDot = this.xDotDot;
            glonassNav.mYDotDot = this.yDotDot;
            glonassNav.f40484mZ = this.f40491z;
            glonassNav.mIod = this.iod;
            glonassNav.mGamma = this.gamma;
            glonassNav.mDeltaTau = this.deltaTau;
            glonassNav.f40482mX = this.f40489x;
            glonassNav.mP2 = this.f40488p2;
            glonassNav.mEn = this.f40485en;
            glonassNav.mZDot = this.zDot;
            glonassNav.f40483mY = this.f40490y;
            glonassNav.mHealth = this.health;
            return glonassNav;
        }

        public Builder but() {
            return aGlonassNav().withSvid(this.svid).withHealth(this.health).withIod(this.iod).withTaun(this.taun).withGamma(this.gamma).withDeltaTau(this.deltaTau).withEn(this.f40485en).withP1(this.f40487p1).withP2(this.f40488p2).withM(this.f40486m).withX(this.f40489x).withY(this.f40490y).withZ(this.f40491z).withXDot(this.xDot).withYDot(this.yDot).withZDot(this.zDot).withXDotDot(this.xDotDot).withYDotDot(this.yDotDot).withZDotDot(this.zDotDot);
        }

        public Builder withDeltaTau(double d10) {
            this.deltaTau = d10;
            return this;
        }

        public Builder withEn(int i10) {
            this.f40485en = i10;
            return this;
        }

        public Builder withGamma(double d10) {
            this.gamma = d10;
            return this;
        }

        public Builder withHealth(int i10) {
            this.health = i10;
            return this;
        }

        public Builder withIod(int i10) {
            this.iod = i10;
            return this;
        }

        public Builder withM(int i10) {
            this.f40486m = i10;
            return this;
        }

        public Builder withP1(int i10) {
            this.f40487p1 = i10;
            return this;
        }

        public Builder withP2(int i10) {
            this.f40488p2 = i10;
            return this;
        }

        public Builder withSvid(int i10) {
            this.svid = i10;
            return this;
        }

        public Builder withTaun(double d10) {
            this.taun = d10;
            return this;
        }

        public Builder withX(double d10) {
            this.f40489x = d10;
            return this;
        }

        public Builder withXDot(double d10) {
            this.xDot = d10;
            return this;
        }

        public Builder withXDotDot(double d10) {
            this.xDotDot = d10;
            return this;
        }

        public Builder withY(double d10) {
            this.f40490y = d10;
            return this;
        }

        public Builder withYDot(double d10) {
            this.yDot = d10;
            return this;
        }

        public Builder withYDotDot(double d10) {
            this.yDotDot = d10;
            return this;
        }

        public Builder withZ(double d10) {
            this.f40491z = d10;
            return this;
        }

        public Builder withZDot(double d10) {
            this.zDot = d10;
            return this;
        }

        public Builder withZDotDot(double d10) {
            this.zDotDot = d10;
            return this;
        }
    }

    public double getDeltaTau() {
        return this.mDeltaTau;
    }

    public int getEn() {
        return this.mEn;
    }

    public double getGamma() {
        return this.mGamma;
    }

    public int getHealth() {
        return this.mHealth;
    }

    public int getIod() {
        return this.mIod;
    }

    public int getM() {
        return this.f40481mM;
    }

    public int getP1() {
        return this.mP1;
    }

    public int getP2() {
        return this.mP2;
    }

    public int getSvid() {
        return this.mSvid;
    }

    public double getTaun() {
        return this.mTaun;
    }

    public double getX() {
        return this.f40482mX;
    }

    public double getY() {
        return this.f40483mY;
    }

    public double getZ() {
        return this.f40484mZ;
    }

    public double getxDot() {
        return this.mXDot;
    }

    public double getxDotDot() {
        return this.mXDotDot;
    }

    public double getyDot() {
        return this.mYDot;
    }

    public double getyDotDot() {
        return this.mYDotDot;
    }

    public double getzDot() {
        return this.mZDot;
    }

    public double getzDotDot() {
        return this.mZDotDot;
    }
}
