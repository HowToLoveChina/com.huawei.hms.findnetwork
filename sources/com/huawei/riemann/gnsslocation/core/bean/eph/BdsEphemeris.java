package com.huawei.riemann.gnsslocation.core.bean.eph;

import java.util.Arrays;

/* loaded from: classes5.dex */
public class BdsEphemeris {
    public BdsIon[] mBdsIons;
    public BdsNav[] mBdsNavs;
    public BdsTim[] mBdsTims;
    public int mNonBroadcastInd;
    public int mSatNumber;

    public static final class Builder {
        public BdsIon[] mBdsIons;
        public BdsNav[] mBdsNavs;
        public BdsTim[] mBdsTims;
        public int mNonBroadcastInd;
        public int mSatNumber;

        public static Builder aBdsEphemeris() {
            return new Builder();
        }

        public BdsEphemeris build() {
            BdsEphemeris bdsEphemeris = new BdsEphemeris();
            bdsEphemeris.mBdsIons = this.mBdsIons;
            bdsEphemeris.mNonBroadcastInd = this.mNonBroadcastInd;
            bdsEphemeris.mSatNumber = this.mSatNumber;
            bdsEphemeris.mBdsNavs = this.mBdsNavs;
            bdsEphemeris.mBdsTims = this.mBdsTims;
            return bdsEphemeris;
        }

        public Builder but() {
            return aBdsEphemeris().withSatNumber(this.mSatNumber).withNonBroadcastInd(this.mNonBroadcastInd).withBdsNavs(this.mBdsNavs).withBdsIons(this.mBdsIons).withBdsTims(this.mBdsTims);
        }

        public Builder withBdsIons(BdsIon[] bdsIonArr) {
            this.mBdsIons = (BdsIon[]) Arrays.copyOf(bdsIonArr, bdsIonArr.length);
            return this;
        }

        public Builder withBdsNavs(BdsNav[] bdsNavArr) {
            this.mBdsNavs = (BdsNav[]) Arrays.copyOf(bdsNavArr, bdsNavArr.length);
            return this;
        }

        public Builder withBdsTims(BdsTim[] bdsTimArr) {
            this.mBdsTims = (BdsTim[]) Arrays.copyOf(bdsTimArr, bdsTimArr.length);
            return this;
        }

        public Builder withNonBroadcastInd(int i10) {
            this.mNonBroadcastInd = i10;
            return this;
        }

        public Builder withSatNumber(int i10) {
            this.mSatNumber = i10;
            return this;
        }
    }

    public BdsIon[] getBdsIons() {
        BdsIon[] bdsIonArr = this.mBdsIons;
        return (BdsIon[]) Arrays.copyOf(bdsIonArr, bdsIonArr.length);
    }

    public BdsNav[] getBdsNavs() {
        BdsNav[] bdsNavArr = this.mBdsNavs;
        return (BdsNav[]) Arrays.copyOf(bdsNavArr, bdsNavArr.length);
    }

    public BdsTim[] getBdsTims() {
        BdsTim[] bdsTimArr = this.mBdsTims;
        return (BdsTim[]) Arrays.copyOf(bdsTimArr, bdsTimArr.length);
    }

    public int getNonBroadcastInd() {
        return this.mNonBroadcastInd;
    }

    public int getSatNumber() {
        return this.mSatNumber;
    }
}
