package com.huawei.riemann.location.bean.obs;

/* loaded from: classes5.dex */
public class GnssRawObservation {
    public GnssClock mGnssClock;
    public SatelliteMeasurement mSatelliteMeasurement;

    public static final class Builder {
        public GnssClock mGnssClock;
        public SatelliteMeasurement mSatelliteMeasurement;

        public static Builder aGnssRawObservation() {
            return new Builder();
        }

        public GnssRawObservation build() {
            GnssRawObservation gnssRawObservation = new GnssRawObservation();
            gnssRawObservation.mSatelliteMeasurement = this.mSatelliteMeasurement;
            gnssRawObservation.mGnssClock = this.mGnssClock;
            return gnssRawObservation;
        }

        public Builder but() {
            return aGnssRawObservation().withGnssClock(this.mGnssClock).withSatelliteMeasurement(this.mSatelliteMeasurement);
        }

        public Builder withGnssClock(GnssClock gnssClock) {
            this.mGnssClock = gnssClock;
            return this;
        }

        public Builder withSatelliteMeasurement(SatelliteMeasurement satelliteMeasurement) {
            this.mSatelliteMeasurement = satelliteMeasurement;
            return this;
        }
    }

    public GnssClock getGnssClock() {
        return this.mGnssClock;
    }

    public SatelliteMeasurement getSatelliteMeasurement() {
        return this.mSatelliteMeasurement;
    }
}
