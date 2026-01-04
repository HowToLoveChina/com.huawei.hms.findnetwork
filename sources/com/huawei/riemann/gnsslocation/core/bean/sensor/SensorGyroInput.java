package com.huawei.riemann.gnsslocation.core.bean.sensor;

/* loaded from: classes5.dex */
public class SensorGyroInput {
    public long mBootTime;
    public double mGx;
    public double mGy;
    public double mGz;

    public static final class Builder {
        public long bootTime;

        /* renamed from: gx */
        public double f40557gx;

        /* renamed from: gy */
        public double f40558gy;

        /* renamed from: gz */
        public double f40559gz;

        public static Builder aSensorGyroInput() {
            return new Builder();
        }

        public SensorGyroInput build() {
            SensorGyroInput sensorGyroInput = new SensorGyroInput();
            sensorGyroInput.mBootTime = this.bootTime;
            sensorGyroInput.mGx = this.f40557gx;
            sensorGyroInput.mGy = this.f40558gy;
            sensorGyroInput.mGz = this.f40559gz;
            return sensorGyroInput;
        }

        public Builder but() {
            return aSensorGyroInput().withBootTime(this.bootTime).withGx(this.f40557gx).withGy(this.f40558gy).withGz(this.f40559gz);
        }

        public Builder withBootTime(long j10) {
            this.bootTime = j10;
            return this;
        }

        public Builder withGx(double d10) {
            this.f40557gx = d10;
            return this;
        }

        public Builder withGy(double d10) {
            this.f40558gy = d10;
            return this;
        }

        public Builder withGz(double d10) {
            this.f40559gz = d10;
            return this;
        }
    }

    public long getBootTime() {
        return this.mBootTime;
    }

    public double getGx() {
        return this.mGx;
    }

    public double getGy() {
        return this.mGy;
    }

    public double getGz() {
        return this.mGz;
    }
}
