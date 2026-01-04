package com.huawei.riemann.location.bean.eph;

/* loaded from: classes5.dex */
public class Ephemeris {
    public BdsEphemeris mBdsEphemeris;
    public GalileoEphemeris mGalileoEphemeris;
    public GlonassEphemeris mGlonassEphemeris;
    public GpsEphemeris mGpsEphemeris;
    public IrnssEphemeris mIrnssEphemeris;
    public QzssEphemeris mQzssEphemeris;
    public SbasEphemeris mSbasEphemeris;

    public static final class Builder {
        public BdsEphemeris mBdsEphemeris;
        public GalileoEphemeris mGalileoEphemeris;
        public GlonassEphemeris mGlonassEphemeris;
        public GpsEphemeris mGpsEphemeris;
        public IrnssEphemeris mIrnssEphemeris;
        public QzssEphemeris mQzssEphemeris;
        public SbasEphemeris mSbasEphemeris;

        public static Builder anEphemeris() {
            return new Builder();
        }

        private Builder withIrnssEphemeris(IrnssEphemeris irnssEphemeris) {
            this.mIrnssEphemeris = irnssEphemeris;
            return this;
        }

        private Builder withQzssEphemeris(QzssEphemeris qzssEphemeris) {
            this.mQzssEphemeris = qzssEphemeris;
            return this;
        }

        private Builder withSbasEphemeris(SbasEphemeris sbasEphemeris) {
            this.mSbasEphemeris = sbasEphemeris;
            return this;
        }

        public Ephemeris build() {
            Ephemeris ephemeris = new Ephemeris();
            ephemeris.mGpsEphemeris = this.mGpsEphemeris;
            ephemeris.mSbasEphemeris = this.mSbasEphemeris;
            ephemeris.mGlonassEphemeris = this.mGlonassEphemeris;
            ephemeris.mQzssEphemeris = this.mQzssEphemeris;
            ephemeris.mBdsEphemeris = this.mBdsEphemeris;
            ephemeris.mGalileoEphemeris = this.mGalileoEphemeris;
            ephemeris.mIrnssEphemeris = this.mIrnssEphemeris;
            return ephemeris;
        }

        public Builder but() {
            return anEphemeris().withGpsEphemeris(this.mGpsEphemeris).withSbasEphemeris(this.mSbasEphemeris).withGlonassEphemeris(this.mGlonassEphemeris).withQzssEphemeris(this.mQzssEphemeris).withBdsEphemeris(this.mBdsEphemeris).withGalileoEphemeris(this.mGalileoEphemeris).withIrnssEphemeris(this.mIrnssEphemeris);
        }

        public Builder withBdsEphemeris(BdsEphemeris bdsEphemeris) {
            this.mBdsEphemeris = bdsEphemeris;
            return this;
        }

        public Builder withGalileoEphemeris(GalileoEphemeris galileoEphemeris) {
            this.mGalileoEphemeris = galileoEphemeris;
            return this;
        }

        public Builder withGlonassEphemeris(GlonassEphemeris glonassEphemeris) {
            this.mGlonassEphemeris = glonassEphemeris;
            return this;
        }

        public Builder withGpsEphemeris(GpsEphemeris gpsEphemeris) {
            this.mGpsEphemeris = gpsEphemeris;
            return this;
        }
    }

    public BdsEphemeris getBdsEphemeris() {
        return this.mBdsEphemeris;
    }

    public GalileoEphemeris getGalileoEphemeris() {
        return this.mGalileoEphemeris;
    }

    public GlonassEphemeris getGlonassEphemeris() {
        return this.mGlonassEphemeris;
    }

    public GpsEphemeris getGpsEphemeris() {
        return this.mGpsEphemeris;
    }

    public IrnssEphemeris getIrnssEphemeris() {
        return this.mIrnssEphemeris;
    }

    public QzssEphemeris getQzssEphemeris() {
        return this.mQzssEphemeris;
    }

    public SbasEphemeris getSbasEphemeris() {
        return this.mSbasEphemeris;
    }
}
