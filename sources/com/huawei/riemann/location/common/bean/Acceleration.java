package com.huawei.riemann.location.common.bean;

/* loaded from: classes5.dex */
public class Acceleration {
    private double accX;
    private double accY;
    private double accZ;
    private double bootTime;

    public static final class Builder {
        private double accX;
        private double accY;
        private double accZ;
        private double bootTime;

        private Builder() {
            this.bootTime = 0.0d;
            this.accX = 0.0d;
            this.accY = 0.0d;
            this.accZ = 9.8d;
        }

        public Acceleration build() {
            return new Acceleration(this);
        }

        public Builder withAccX(double d10) {
            this.accX = d10;
            return this;
        }

        public Builder withAccY(double d10) {
            this.accY = d10;
            return this;
        }

        public Builder withAccZ(double d10) {
            this.accZ = d10;
            return this;
        }

        public Builder withBootTime(double d10) {
            this.bootTime = d10;
            return this;
        }
    }

    private Acceleration(Builder builder) {
        this.bootTime = 0.0d;
        this.accX = 0.0d;
        this.accY = 0.0d;
        this.accZ = 9.8d;
        this.bootTime = builder.bootTime;
        this.accX = builder.accX;
        this.accY = builder.accY;
        this.accZ = builder.accZ;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public double getAccX() {
        return this.accX;
    }

    public double getAccY() {
        return this.accY;
    }

    public double getAccZ() {
        return this.accZ;
    }

    public double getBootTime() {
        return this.bootTime;
    }

    public String toString() {
        return "Acceleration {bootTime=" + this.bootTime + ", accX=" + this.accX + ", accY=" + this.accY + ", accZ=" + this.accZ + '}';
    }
}
