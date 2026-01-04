package com.huawei.riemann.location.common.bean;

/* loaded from: classes5.dex */
public class Gyroscope {
    private double bootTime;
    private double gyroX;
    private double gyroY;
    private double gyroZ;

    public static final class Builder {
        private double bootTime;
        private double gyroX;
        private double gyroY;
        private double gyroZ;

        public Gyroscope build() {
            return new Gyroscope(this);
        }

        public Builder withBootTime(double d10) {
            this.bootTime = d10;
            return this;
        }

        public Builder withGyroX(double d10) {
            this.gyroX = d10;
            return this;
        }

        public Builder withGyroY(double d10) {
            this.gyroY = d10;
            return this;
        }

        public Builder withGyroZ(double d10) {
            this.gyroZ = d10;
            return this;
        }
    }

    private Gyroscope(Builder builder) {
        this.bootTime = 0.0d;
        this.gyroX = 0.0d;
        this.gyroY = 0.0d;
        this.gyroZ = 0.0d;
        this.bootTime = builder.bootTime;
        this.gyroX = builder.gyroX;
        this.gyroY = builder.gyroY;
        this.gyroZ = builder.gyroZ;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public double getBootTime() {
        return this.bootTime;
    }

    public double getGyroX() {
        return this.gyroX;
    }

    public double getGyroY() {
        return this.gyroY;
    }

    public double getGyroZ() {
        return this.gyroZ;
    }

    public String toString() {
        return "Gyroscope {bootTime=" + this.bootTime + ", gyroX=" + this.gyroX + ", gyroY=" + this.gyroY + ", gyroZ=" + this.gyroZ + '}';
    }
}
