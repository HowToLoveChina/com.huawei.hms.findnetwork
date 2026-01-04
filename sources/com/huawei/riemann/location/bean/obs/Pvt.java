package com.huawei.riemann.location.bean.obs;

/* loaded from: classes5.dex */
public class Pvt {
    public int mErrCode = 0;
    public double mLatitude = 0.0d;
    public double mLongitude = 0.0d;
    public double mAltitude = 0.0d;
    public float mSpeed = 0.0f;
    public float mAccuracy = 0.0f;
    public float mBearing = 0.0f;
    public long mTime = 0;

    public static final class Builder {
        public int mErrCode = 0;
        public double mLatitude = 0.0d;
        public double mLongitude = 0.0d;
        public double mAltitude = 0.0d;
        public float mSpeed = 0.0f;
        public float mAccuracy = 0.0f;
        public float mBearing = 0.0f;
        public long mTime = 0;

        public static Builder aPvt() {
            return new Builder();
        }

        public Pvt build() {
            Pvt pvt = new Pvt();
            pvt.mErrCode = this.mErrCode;
            pvt.mLatitude = this.mLatitude;
            pvt.mLongitude = this.mLongitude;
            pvt.mBearing = this.mBearing;
            pvt.mTime = this.mTime;
            pvt.mAltitude = this.mAltitude;
            pvt.mSpeed = this.mSpeed;
            pvt.mAccuracy = this.mAccuracy;
            return pvt;
        }

        public Builder but() {
            return aPvt().withErrCode(this.mErrCode).withLatitude(this.mLatitude).withLongitude(this.mLongitude).withAltitude(this.mAltitude).withSpeed(this.mSpeed).withAccuracy(this.mAccuracy).withBearing(this.mBearing).withTime(this.mTime);
        }

        public Builder withAccuracy(float f10) {
            this.mAccuracy = f10;
            return this;
        }

        public Builder withAltitude(double d10) {
            this.mAltitude = d10;
            return this;
        }

        public Builder withBearing(float f10) {
            this.mBearing = f10;
            return this;
        }

        public Builder withErrCode(int i10) {
            this.mErrCode = i10;
            return this;
        }

        public Builder withLatitude(double d10) {
            this.mLatitude = d10;
            return this;
        }

        public Builder withLongitude(double d10) {
            this.mLongitude = d10;
            return this;
        }

        public Builder withSpeed(float f10) {
            this.mSpeed = f10;
            return this;
        }

        public Builder withTime(long j10) {
            this.mTime = j10;
            return this;
        }
    }

    public float getAccuracy() {
        return this.mAccuracy;
    }

    public double getAltitude() {
        return this.mAltitude;
    }

    public float getBearing() {
        return this.mBearing;
    }

    public int getErrCode() {
        return this.mErrCode;
    }

    public double getLatitude() {
        return this.mLatitude;
    }

    public double getLongitude() {
        return this.mLongitude;
    }

    public float getSpeed() {
        return this.mSpeed;
    }

    public long getTime() {
        return this.mTime;
    }
}
