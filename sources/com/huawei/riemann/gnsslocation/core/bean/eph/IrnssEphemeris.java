package com.huawei.riemann.gnsslocation.core.bean.eph;

/* loaded from: classes5.dex */
public class IrnssEphemeris {
    public int mSatNumber;

    public static final class Builder {
        public int mSatNumber;

        public static Builder aIrnssEphemeris() {
            return new Builder();
        }

        public IrnssEphemeris build() {
            IrnssEphemeris irnssEphemeris = new IrnssEphemeris();
            irnssEphemeris.mSatNumber = this.mSatNumber;
            return irnssEphemeris;
        }

        public Builder but() {
            return aIrnssEphemeris().withSatNumber(this.mSatNumber);
        }

        public Builder withSatNumber(int i10) {
            this.mSatNumber = i10;
            return this;
        }
    }
}
