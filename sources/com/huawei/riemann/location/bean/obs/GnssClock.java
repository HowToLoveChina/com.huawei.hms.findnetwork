package com.huawei.riemann.location.bean.obs;

/* loaded from: classes5.dex */
public class GnssClock {
    public double mBiasNanos;
    public double mBiasUncertaintyNanos;
    public double mDriftNanosPerSecond;
    public double mDriftUncertaintyNanosPerSecond;
    public long mElapsedRealtimeMillis;
    public long mFullBiasNanos;
    public int mHardwareClockDiscontinuityCount;
    public int mLeapSecond;
    public long mTimeNanos;
    public double mTimeUncertaintyNanos;

    public static final class Builder {
        public double mBiasNanos;
        public double mBiasUncertaintyNanos;
        public double mDriftNanosPerSecond;
        public double mDriftUncertaintyNanosPerSecond;
        public long mElapsedRealtimeMillis;
        public long mFullBiasNanos;
        public int mHardwareClockDiscontinuityCount;
        public int mLeapSecond;
        public long mTimeNanos;
        public double mTimeUncertaintyNanos;

        public static Builder aGnssClock() {
            return new Builder();
        }

        public GnssClock build() {
            GnssClock gnssClock = new GnssClock();
            gnssClock.mTimeNanos = this.mTimeNanos;
            gnssClock.mFullBiasNanos = this.mFullBiasNanos;
            gnssClock.mTimeUncertaintyNanos = this.mTimeUncertaintyNanos;
            gnssClock.mDriftNanosPerSecond = this.mDriftNanosPerSecond;
            gnssClock.mDriftUncertaintyNanosPerSecond = this.mDriftUncertaintyNanosPerSecond;
            gnssClock.mElapsedRealtimeMillis = this.mElapsedRealtimeMillis;
            gnssClock.mBiasUncertaintyNanos = this.mBiasUncertaintyNanos;
            gnssClock.mBiasNanos = this.mBiasNanos;
            gnssClock.mHardwareClockDiscontinuityCount = this.mHardwareClockDiscontinuityCount;
            gnssClock.mLeapSecond = this.mLeapSecond;
            return gnssClock;
        }

        public Builder but() {
            return aGnssClock().withElapsedRealtimeMillis(this.mElapsedRealtimeMillis).withTimeNanos(this.mTimeNanos).withLeapSecond(this.mLeapSecond).withTimeUncertaintyNanos(this.mTimeUncertaintyNanos).withFullBiasNanos(this.mFullBiasNanos).withBiasNanos(this.mBiasNanos).withBiasUncertaintyNanos(this.mBiasUncertaintyNanos).withDriftNanosPerSecond(this.mDriftNanosPerSecond).withDriftUncertaintyNanosPerSecond(this.mDriftUncertaintyNanosPerSecond).withHardwareClockDiscontinuityCount(this.mHardwareClockDiscontinuityCount);
        }

        public Builder withBiasNanos(double d10) {
            this.mBiasNanos = d10;
            return this;
        }

        public Builder withBiasUncertaintyNanos(double d10) {
            this.mBiasUncertaintyNanos = d10;
            return this;
        }

        public Builder withDriftNanosPerSecond(double d10) {
            this.mDriftNanosPerSecond = d10;
            return this;
        }

        public Builder withDriftUncertaintyNanosPerSecond(double d10) {
            this.mDriftUncertaintyNanosPerSecond = d10;
            return this;
        }

        public Builder withElapsedRealtimeMillis(long j10) {
            this.mElapsedRealtimeMillis = j10;
            return this;
        }

        public Builder withFullBiasNanos(long j10) {
            this.mFullBiasNanos = j10;
            return this;
        }

        public Builder withHardwareClockDiscontinuityCount(int i10) {
            this.mHardwareClockDiscontinuityCount = i10;
            return this;
        }

        public Builder withLeapSecond(int i10) {
            this.mLeapSecond = i10;
            return this;
        }

        public Builder withTimeNanos(long j10) {
            this.mTimeNanos = j10;
            return this;
        }

        public Builder withTimeUncertaintyNanos(double d10) {
            this.mTimeUncertaintyNanos = d10;
            return this;
        }
    }

    public double getBiasNanos() {
        return this.mBiasNanos;
    }

    public double getBiasUncertaintyNanos() {
        return this.mBiasUncertaintyNanos;
    }

    public double getDriftNanosPerSecond() {
        return this.mDriftNanosPerSecond;
    }

    public double getDriftUncertaintyNanosPerSecond() {
        return this.mDriftUncertaintyNanosPerSecond;
    }

    public long getElapsedRealtimeMillis() {
        return this.mElapsedRealtimeMillis;
    }

    public long getFullBiasNanos() {
        return this.mFullBiasNanos;
    }

    public int getHardwareClockDiscontinuityCount() {
        return this.mHardwareClockDiscontinuityCount;
    }

    public int getLeapSecond() {
        return this.mLeapSecond;
    }

    public long getTimeNanos() {
        return this.mTimeNanos;
    }

    public double getTimeUncertaintyNanos() {
        return this.mTimeUncertaintyNanos;
    }
}
