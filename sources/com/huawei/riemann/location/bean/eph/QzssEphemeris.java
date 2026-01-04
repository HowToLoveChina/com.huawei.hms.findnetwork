package com.huawei.riemann.location.bean.eph;

/* loaded from: classes5.dex */
public class QzssEphemeris {
    public int mSatNumber;

    public static final class Builder {
        public int mSatNumber;

        public static Builder aQzssEphemeris() {
            return new Builder();
        }

        public QzssEphemeris build() {
            QzssEphemeris qzssEphemeris = new QzssEphemeris();
            qzssEphemeris.mSatNumber = this.mSatNumber;
            return qzssEphemeris;
        }

        public Builder but() {
            return aQzssEphemeris().withSatNumber(this.mSatNumber);
        }

        public Builder withSatNumber(int i10) {
            this.mSatNumber = i10;
            return this;
        }
    }
}
