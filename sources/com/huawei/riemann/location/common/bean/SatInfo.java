package com.huawei.riemann.location.common.bean;

/* loaded from: classes5.dex */
public class SatInfo {
    public static final int CONSTELLATION_TYPE_BD = 4;
    public static final int CONSTELLATION_TYPE_GAL = 3;
    public static final int CONSTELLATION_TYPE_GLO = 2;
    public static final int CONSTELLATION_TYPE_GPS = 1;
    private double azimuth;
    private double bootTime;
    private int constellationType;
    private double elevation;
    private int satNum;
    private double snr;
    private boolean usedInFix;

    public static final class Builder {
        private double azimuth;
        private double bootTime;
        private int constellationType;
        private double elevation;
        private int satNum;
        private double snr;
        private boolean usedInFix;

        private Builder() {
            this.bootTime = 0.0d;
            this.constellationType = 0;
            this.satNum = 0;
            this.elevation = 0.0d;
            this.azimuth = 0.0d;
            this.snr = 0.0d;
            this.usedInFix = false;
        }

        public SatInfo build() {
            return new SatInfo(this);
        }

        public Builder withAzimuth(double d10) {
            this.azimuth = d10;
            return this;
        }

        public Builder withBootTime(double d10) {
            this.bootTime = d10;
            return this;
        }

        public Builder withConstellationType(int i10) {
            this.constellationType = i10;
            return this;
        }

        public Builder withElevation(double d10) {
            this.elevation = d10;
            return this;
        }

        public Builder withSatNum(int i10) {
            this.satNum = i10;
            return this;
        }

        public Builder withSnr(double d10) {
            this.snr = d10;
            return this;
        }

        public Builder withUsedInFix(boolean z10) {
            this.usedInFix = z10;
            return this;
        }
    }

    private SatInfo(Builder builder) {
        this.bootTime = 0.0d;
        this.constellationType = 0;
        this.satNum = 0;
        this.elevation = 0.0d;
        this.azimuth = 0.0d;
        this.snr = 0.0d;
        this.usedInFix = false;
        this.bootTime = builder.bootTime;
        this.constellationType = builder.constellationType;
        this.satNum = builder.satNum;
        this.elevation = builder.elevation;
        this.azimuth = builder.azimuth;
        this.snr = builder.snr;
        this.usedInFix = builder.usedInFix;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public double getAzimuth() {
        return this.azimuth;
    }

    public double getBootTime() {
        return this.bootTime;
    }

    public int getConstellationType() {
        return this.constellationType;
    }

    public double getElevation() {
        return this.elevation;
    }

    public int getSatNum() {
        return this.satNum;
    }

    public double getSnr() {
        return this.snr;
    }

    public boolean isUsedInFix() {
        return this.usedInFix;
    }

    public String toString() {
        return this.bootTime + ", " + this.constellationType + ", " + this.satNum + ", " + this.elevation + ", " + this.azimuth + ", " + this.snr + ", " + this.usedInFix;
    }
}
