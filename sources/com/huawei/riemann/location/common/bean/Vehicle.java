package com.huawei.riemann.location.common.bean;

import com.huawei.location.C6769i;

/* loaded from: classes5.dex */
public class Vehicle {
    private double bootTime;
    private int gear;
    private double speed;

    public static final class Builder {
        private double bootTime;
        private int gear;
        private double speed;

        private Builder() {
        }

        public Vehicle build() {
            return new Vehicle(this);
        }

        public Builder withGear(int i10) {
            this.gear = i10;
            return this;
        }

        public Builder withSpeed(double d10) {
            this.speed = d10;
            return this;
        }

        public Builder withTimestamp(double d10) {
            this.bootTime = d10;
            return this;
        }
    }

    private Vehicle(Builder builder) {
        this.bootTime = 0.0d;
        this.speed = 0.0d;
        this.gear = 1;
        this.bootTime = builder.bootTime;
        this.speed = builder.speed;
        this.gear = builder.gear;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public double getBootTime() {
        return this.bootTime;
    }

    public int getGear() {
        return this.gear;
    }

    public double getSpeed() {
        return this.speed;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("Vehicle {bootTime=");
        sb2.append(this.bootTime);
        sb2.append(", speed=");
        sb2.append(this.speed);
        sb2.append(", gear=");
        return C6769i.m38373a(sb2, this.gear, '}');
    }
}
