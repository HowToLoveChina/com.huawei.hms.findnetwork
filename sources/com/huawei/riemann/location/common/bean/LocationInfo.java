package com.huawei.riemann.location.common.bean;

import android.location.Location;
import as.C1016d;

/* loaded from: classes5.dex */
public class LocationInfo {
    private static final String TAG = "LocationInfo";
    private double accuracy;
    private double altitude;
    private double bearing;
    private double bootTime;
    private double latitude;
    private double longitude;
    private double speed;
    private double utcMs;

    public static final class Builder {
        private double accuracy;
        private double altitude;
        private double bearing;
        private double bootTime;
        private double latitude;
        private double longitude;
        private double speed;
        private double utcMs;

        private Builder() {
        }

        public LocationInfo build() {
            return new LocationInfo(this);
        }

        public Builder withAccuracy(double d10) {
            this.accuracy = d10;
            return this;
        }

        public Builder withAltitude(double d10) {
            this.altitude = d10;
            return this;
        }

        public Builder withBearing(double d10) {
            this.bearing = d10;
            return this;
        }

        public Builder withBootTime(double d10) {
            this.bootTime = d10;
            return this;
        }

        public Builder withLatitude(double d10) {
            this.latitude = d10;
            return this;
        }

        public Builder withLongitude(double d10) {
            this.longitude = d10;
            return this;
        }

        public Builder withSpeed(double d10) {
            this.speed = d10;
            return this;
        }

        public Builder withUtcMs(double d10) {
            this.utcMs = d10;
            return this;
        }
    }

    private LocationInfo(Builder builder) {
        this.bootTime = 0.0d;
        this.utcMs = 0.0d;
        this.longitude = 0.0d;
        this.latitude = 0.0d;
        this.bearing = 0.0d;
        this.speed = 0.0d;
        this.accuracy = 0.0d;
        this.altitude = 0.0d;
        this.bootTime = builder.bootTime;
        this.utcMs = builder.utcMs;
        this.longitude = builder.longitude;
        this.latitude = builder.latitude;
        this.bearing = builder.bearing;
        this.speed = builder.speed;
        this.accuracy = builder.accuracy;
        this.altitude = builder.altitude;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public double getAccuracy() {
        return this.accuracy;
    }

    public double getAltitude() {
        return this.altitude;
    }

    public double getBearing() {
        return this.bearing;
    }

    public double getBootTime() {
        return this.bootTime;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public double getSpeed() {
        return this.speed;
    }

    public double getUtcMs() {
        return this.utcMs;
    }

    public String toString() {
        return "LocationInfo{bootTime=" + this.bootTime + "utcMs=" + this.utcMs + ", bearing=" + this.bearing + ", speed=" + this.speed + ", accuracy=" + this.accuracy + '}';
    }

    public static Builder newBuilder(Location location) {
        if (location != null) {
            return new Builder().withLongitude(location.getLongitude()).withLatitude(location.getLatitude()).withAltitude(location.getAltitude()).withBearing(location.getBearing()).withSpeed(location.getSpeed()).withBootTime(location.getElapsedRealtimeNanos() * 1.0E-9d).withUtcMs(location.getTime()).withAccuracy(location.getAccuracy());
        }
        C1016d.m6183c(TAG, "null location, builder failed!");
        return new Builder();
    }
}
