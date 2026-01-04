package com.huawei.riemann.gnsslocation.core.bean.sensor;

/* loaded from: classes5.dex */
public class SensorAccInput {
    public double mAx;
    public double mAy;
    public double mAz;
    public long mBootTime;

    public static final class Builder {

        /* renamed from: ax */
        public double f40554ax;

        /* renamed from: ay */
        public double f40555ay;

        /* renamed from: az */
        public double f40556az;
        public long bootTime;

        public static Builder aSensorAccInput() {
            return new Builder();
        }

        public SensorAccInput build() {
            SensorAccInput sensorAccInput = new SensorAccInput();
            sensorAccInput.mBootTime = this.bootTime;
            sensorAccInput.mAx = this.f40554ax;
            sensorAccInput.mAy = this.f40555ay;
            sensorAccInput.mAz = this.f40556az;
            return sensorAccInput;
        }

        public Builder but() {
            return aSensorAccInput().withBootTime(this.bootTime).withAx(this.f40554ax).withAy(this.f40555ay).withAz(this.f40556az);
        }

        public Builder withAx(double d10) {
            this.f40554ax = d10;
            return this;
        }

        public Builder withAy(double d10) {
            this.f40555ay = d10;
            return this;
        }

        public Builder withAz(double d10) {
            this.f40556az = d10;
            return this;
        }

        public Builder withBootTime(long j10) {
            this.bootTime = j10;
            return this;
        }
    }

    public double getAx() {
        return this.mAx;
    }

    public double getAy() {
        return this.mAy;
    }

    public double getAz() {
        return this.mAz;
    }

    public long getBootTime() {
        return this.mBootTime;
    }
}
