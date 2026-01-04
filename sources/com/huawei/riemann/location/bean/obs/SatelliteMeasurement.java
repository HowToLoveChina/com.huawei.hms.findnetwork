package com.huawei.riemann.location.bean.obs;

/* loaded from: classes5.dex */
public class SatelliteMeasurement {
    public double mAccumulatedDeltaRangeMeters;
    public int mAccumulatedDeltaRangeState;
    public double mAccumulatedDeltaRangeUncertaintyMeters;
    public double mAutomaticGainControlLevelInDb;
    public long mCarrierCycles;
    public float mCarrierFrequencyHz;
    public double mCarrierPhase;
    public double mCarrierPhaseUncertainty;
    public double mCn0DbHz;
    public int mConstellationType;
    public double mFullInterSignalBiasNanos;
    public double mFullInterSignalBiasUncertaintyNanos;
    public int mMultipathIndicator;
    public double mPseudorangeRateMetersPerSecond;
    public double mPseudorangeRateUncertaintyMetersPerSecond;
    public long mReceivedSvTimeNanos;
    public long mReceivedSvTimeUncertaintyNanos;
    public double mSatelliteInterSignalBiasNanos;
    public double mSatelliteInterSignalBiasUncertaintyNanos;
    public double mSnrInDb;
    public int mState;
    public int mSvid;
    public double mTimeOffsetNanos;

    public static final class Builder {
        public double mAccumulatedDeltaRangeMeters;
        public int mAccumulatedDeltaRangeState;
        public double mAccumulatedDeltaRangeUncertaintyMeters;
        public double mAutomaticGainControlLevelInDb;
        public long mCarrierCycles;
        public float mCarrierFrequencyHz;
        public double mCarrierPhase;
        public double mCarrierPhaseUncertainty;
        public double mCn0DbHz;
        public int mConstellationType;
        public double mFullInterSignalBiasNanos;
        public double mFullInterSignalBiasUncertaintyNanos;
        public int mMultipathIndicator;
        public double mPseudorangeRateMetersPerSecond;
        public double mPseudorangeRateUncertaintyMetersPerSecond;
        public long mReceivedSvTimeNanos;
        public long mReceivedSvTimeUncertaintyNanos;
        public double mSatelliteInterSignalBiasNanos;
        public double mSatelliteInterSignalBiasUncertaintyNanos;
        public double mSnrInDb;
        public int mState;
        public int mSvid;
        public double mTimeOffsetNanos;

        public static Builder aSatelliteMeasurement() {
            return new Builder();
        }

        public SatelliteMeasurement build() {
            SatelliteMeasurement satelliteMeasurement = new SatelliteMeasurement();
            satelliteMeasurement.mSatelliteInterSignalBiasUncertaintyNanos = this.mSatelliteInterSignalBiasUncertaintyNanos;
            satelliteMeasurement.mCn0DbHz = this.mCn0DbHz;
            satelliteMeasurement.mAccumulatedDeltaRangeUncertaintyMeters = this.mAccumulatedDeltaRangeUncertaintyMeters;
            satelliteMeasurement.mCarrierPhaseUncertainty = this.mCarrierPhaseUncertainty;
            satelliteMeasurement.mMultipathIndicator = this.mMultipathIndicator;
            satelliteMeasurement.mPseudorangeRateUncertaintyMetersPerSecond = this.mPseudorangeRateUncertaintyMetersPerSecond;
            satelliteMeasurement.mCarrierFrequencyHz = this.mCarrierFrequencyHz;
            satelliteMeasurement.mSatelliteInterSignalBiasNanos = this.mSatelliteInterSignalBiasNanos;
            satelliteMeasurement.mSvid = this.mSvid;
            satelliteMeasurement.mReceivedSvTimeUncertaintyNanos = this.mReceivedSvTimeUncertaintyNanos;
            satelliteMeasurement.mState = this.mState;
            satelliteMeasurement.mConstellationType = this.mConstellationType;
            satelliteMeasurement.mFullInterSignalBiasNanos = this.mFullInterSignalBiasNanos;
            satelliteMeasurement.mTimeOffsetNanos = this.mTimeOffsetNanos;
            satelliteMeasurement.mCarrierCycles = this.mCarrierCycles;
            satelliteMeasurement.mCarrierPhase = this.mCarrierPhase;
            satelliteMeasurement.mReceivedSvTimeNanos = this.mReceivedSvTimeNanos;
            satelliteMeasurement.mFullInterSignalBiasUncertaintyNanos = this.mFullInterSignalBiasUncertaintyNanos;
            satelliteMeasurement.mAutomaticGainControlLevelInDb = this.mAutomaticGainControlLevelInDb;
            satelliteMeasurement.mAccumulatedDeltaRangeMeters = this.mAccumulatedDeltaRangeMeters;
            satelliteMeasurement.mPseudorangeRateMetersPerSecond = this.mPseudorangeRateMetersPerSecond;
            satelliteMeasurement.mAccumulatedDeltaRangeState = this.mAccumulatedDeltaRangeState;
            satelliteMeasurement.mSnrInDb = this.mSnrInDb;
            return satelliteMeasurement;
        }

        public Builder but() {
            return aSatelliteMeasurement().withSvid(this.mSvid).withConstellationType(this.mConstellationType).withTimeOffsetNanos(this.mTimeOffsetNanos).withState(this.mState).withReceivedSvTimeNanos(this.mReceivedSvTimeNanos).withReceivedSvTimeUncertaintyNanos(this.mReceivedSvTimeUncertaintyNanos).withCn0DbHz(this.mCn0DbHz).withPseudorangeRateMetersPerSecond(this.mPseudorangeRateMetersPerSecond).withPseudorangeRateUncertaintyMetersPerSecond(this.mPseudorangeRateUncertaintyMetersPerSecond).withAccumulatedDeltaRangeState(this.mAccumulatedDeltaRangeState).withAccumulatedDeltaRangeMeters(this.mAccumulatedDeltaRangeMeters).withAccumulatedDeltaRangeUncertaintyMeters(this.mAccumulatedDeltaRangeUncertaintyMeters).withCarrierFrequencyHz(this.mCarrierFrequencyHz).withCarrierCycles(this.mCarrierCycles).withCarrierPhase(this.mCarrierPhase).withCarrierPhaseUncertainty(this.mCarrierPhaseUncertainty).withMultipathIndicator(this.mMultipathIndicator).withSnrInDb(this.mSnrInDb).withAutomaticGainControlLevelInDb(this.mAutomaticGainControlLevelInDb).withFullInterSignalBiasNanos(this.mFullInterSignalBiasNanos).withFullInterSignalBiasUncertaintyNanos(this.mFullInterSignalBiasUncertaintyNanos).withSatelliteInterSignalBiasNanos(this.mSatelliteInterSignalBiasNanos).withSatelliteInterSignalBiasUncertaintyNanos(this.mSatelliteInterSignalBiasUncertaintyNanos);
        }

        public Builder withAccumulatedDeltaRangeMeters(double d10) {
            this.mAccumulatedDeltaRangeMeters = d10;
            return this;
        }

        public Builder withAccumulatedDeltaRangeState(int i10) {
            this.mAccumulatedDeltaRangeState = i10;
            return this;
        }

        public Builder withAccumulatedDeltaRangeUncertaintyMeters(double d10) {
            this.mAccumulatedDeltaRangeUncertaintyMeters = d10;
            return this;
        }

        public Builder withAutomaticGainControlLevelInDb(double d10) {
            this.mAutomaticGainControlLevelInDb = d10;
            return this;
        }

        public Builder withCarrierCycles(long j10) {
            this.mCarrierCycles = j10;
            return this;
        }

        public Builder withCarrierFrequencyHz(float f10) {
            this.mCarrierFrequencyHz = f10;
            return this;
        }

        public Builder withCarrierPhase(double d10) {
            this.mCarrierPhase = d10;
            return this;
        }

        public Builder withCarrierPhaseUncertainty(double d10) {
            this.mCarrierPhaseUncertainty = d10;
            return this;
        }

        public Builder withCn0DbHz(double d10) {
            this.mCn0DbHz = d10;
            return this;
        }

        public Builder withConstellationType(int i10) {
            this.mConstellationType = i10;
            return this;
        }

        public Builder withFullInterSignalBiasNanos(double d10) {
            this.mFullInterSignalBiasNanos = d10;
            return this;
        }

        public Builder withFullInterSignalBiasUncertaintyNanos(double d10) {
            this.mFullInterSignalBiasUncertaintyNanos = d10;
            return this;
        }

        public Builder withMultipathIndicator(int i10) {
            this.mMultipathIndicator = i10;
            return this;
        }

        public Builder withPseudorangeRateMetersPerSecond(double d10) {
            this.mPseudorangeRateMetersPerSecond = d10;
            return this;
        }

        public Builder withPseudorangeRateUncertaintyMetersPerSecond(double d10) {
            this.mPseudorangeRateUncertaintyMetersPerSecond = d10;
            return this;
        }

        public Builder withReceivedSvTimeNanos(long j10) {
            this.mReceivedSvTimeNanos = j10;
            return this;
        }

        public Builder withReceivedSvTimeUncertaintyNanos(long j10) {
            this.mReceivedSvTimeUncertaintyNanos = j10;
            return this;
        }

        public Builder withSatelliteInterSignalBiasNanos(double d10) {
            this.mSatelliteInterSignalBiasNanos = d10;
            return this;
        }

        public Builder withSatelliteInterSignalBiasUncertaintyNanos(double d10) {
            this.mSatelliteInterSignalBiasUncertaintyNanos = d10;
            return this;
        }

        public Builder withSnrInDb(double d10) {
            this.mSnrInDb = d10;
            return this;
        }

        public Builder withState(int i10) {
            this.mState = i10;
            return this;
        }

        public Builder withSvid(int i10) {
            this.mSvid = i10;
            return this;
        }

        public Builder withTimeOffsetNanos(double d10) {
            this.mTimeOffsetNanos = d10;
            return this;
        }
    }

    public double getAccumulatedDeltaRangeMeters() {
        return this.mAccumulatedDeltaRangeMeters;
    }

    public int getAccumulatedDeltaRangeState() {
        return this.mAccumulatedDeltaRangeState;
    }

    public double getAccumulatedDeltaRangeUncertaintyMeters() {
        return this.mAccumulatedDeltaRangeUncertaintyMeters;
    }

    public double getAutomaticGainControlLevelInDb() {
        return this.mAutomaticGainControlLevelInDb;
    }

    public long getCarrierCycles() {
        return this.mCarrierCycles;
    }

    public float getCarrierFrequencyHz() {
        return this.mCarrierFrequencyHz;
    }

    public double getCarrierPhase() {
        return this.mCarrierPhase;
    }

    public double getCarrierPhaseUncertainty() {
        return this.mCarrierPhaseUncertainty;
    }

    public double getCn0DbHz() {
        return this.mCn0DbHz;
    }

    public int getConstellationType() {
        return this.mConstellationType;
    }

    public double getFullInterSignalBiasNanos() {
        return this.mFullInterSignalBiasNanos;
    }

    public double getFullInterSignalBiasUncertaintyNanos() {
        return this.mFullInterSignalBiasUncertaintyNanos;
    }

    public int getMultipathIndicator() {
        return this.mMultipathIndicator;
    }

    public double getPseudorangeRateMetersPerSecond() {
        return this.mPseudorangeRateMetersPerSecond;
    }

    public double getPseudorangeRateUncertaintyMetersPerSecond() {
        return this.mPseudorangeRateUncertaintyMetersPerSecond;
    }

    public long getReceivedSvTimeNanos() {
        return this.mReceivedSvTimeNanos;
    }

    public long getReceivedSvTimeUncertaintyNanos() {
        return this.mReceivedSvTimeUncertaintyNanos;
    }

    public double getSatelliteInterSignalBiasNanos() {
        return this.mSatelliteInterSignalBiasNanos;
    }

    public double getSatelliteInterSignalBiasUncertaintyNanos() {
        return this.mSatelliteInterSignalBiasUncertaintyNanos;
    }

    public double getSnrInDb() {
        return this.mSnrInDb;
    }

    public int getState() {
        return this.mState;
    }

    public int getSvid() {
        return this.mSvid;
    }

    public double getTimeOffsetNanos() {
        return this.mTimeOffsetNanos;
    }
}
