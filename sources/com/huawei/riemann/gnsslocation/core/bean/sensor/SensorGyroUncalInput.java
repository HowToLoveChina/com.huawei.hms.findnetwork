package com.huawei.riemann.gnsslocation.core.bean.sensor;

/* loaded from: classes5.dex */
public class SensorGyroUncalInput {
    public double mBiasx;
    public double mBiasy;
    public double mBiasz;
    public long mBootTime;
    public double mUgx;
    public double mUgy;
    public double mUgz;

    public static final class Builder {
        public double biasx;
        public double biasy;
        public double biasz;
        public long bootTime;
        public double ugx;
        public double ugy;
        public double ugz;

        public static Builder aSensorGyroUncalInput() {
            return new Builder();
        }

        public SensorGyroUncalInput build() {
            SensorGyroUncalInput sensorGyroUncalInput = new SensorGyroUncalInput();
            sensorGyroUncalInput.mBootTime = this.bootTime;
            sensorGyroUncalInput.mUgx = this.ugx;
            sensorGyroUncalInput.mUgy = this.ugy;
            sensorGyroUncalInput.mUgz = this.ugz;
            sensorGyroUncalInput.mBiasx = this.biasx;
            sensorGyroUncalInput.mBiasy = this.biasy;
            sensorGyroUncalInput.mBiasz = this.biasz;
            return sensorGyroUncalInput;
        }

        public Builder but() {
            return aSensorGyroUncalInput().withBt(this.bootTime).withUgx(this.ugx).withUgy(this.ugy).withUgz(this.ugz).withBiasx(this.biasx).withBiasy(this.biasy).withBiasz(this.biasz);
        }

        public Builder withBiasx(double d10) {
            this.biasx = d10;
            return this;
        }

        public Builder withBiasy(double d10) {
            this.biasy = d10;
            return this;
        }

        public Builder withBiasz(double d10) {
            this.biasz = d10;
            return this;
        }

        public Builder withBt(long j10) {
            this.bootTime = j10;
            return this;
        }

        public Builder withUgx(double d10) {
            this.ugx = d10;
            return this;
        }

        public Builder withUgy(double d10) {
            this.ugy = d10;
            return this;
        }

        public Builder withUgz(double d10) {
            this.ugz = d10;
            return this;
        }
    }

    public double getBiasx() {
        return this.mBiasx;
    }

    public double getBiasy() {
        return this.mBiasy;
    }

    public double getBiasz() {
        return this.mBiasz;
    }

    public long getBootTime() {
        return this.mBootTime;
    }

    public double getUgx() {
        return this.mUgx;
    }

    public double getUgy() {
        return this.mUgy;
    }

    public double getUgz() {
        return this.mUgz;
    }
}
