package com.huawei.riemann.gnsslocation.core.bean.eph;

/* loaded from: classes5.dex */
public class SbasEphemeris {
    public int mSatNumber;

    public static final class Builder {
        public int mSatNumber;

        public static Builder aSbasEphemeris() {
            return new Builder();
        }

        public SbasEphemeris build() {
            SbasEphemeris sbasEphemeris = new SbasEphemeris();
            sbasEphemeris.mSatNumber = this.mSatNumber;
            return sbasEphemeris;
        }

        public Builder but() {
            return aSbasEphemeris().withSatNumber(this.mSatNumber);
        }

        public Builder withSatNumber(int i10) {
            this.mSatNumber = i10;
            return this;
        }
    }
}
