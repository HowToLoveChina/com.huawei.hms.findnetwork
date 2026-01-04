package com.huawei.hms.location;

import android.text.TextUtils;
import com.huawei.hms.support.api.entity.location.fence.GeofenceEntity;

/* loaded from: classes8.dex */
public interface Geofence {
    public static final int CONVERSIONS_MAX = 7;
    public static final int CONVERSIONS_MIN = 0;
    public static final long DEFAULT_DURATION = -2;
    public static final int DEFAULT_INTERVAL = 0;
    public static final int DWELL_GEOFENCE_CONVERSION = 4;
    public static final int ENTER_GEOFENCE_CONVERSION = 1;
    public static final int EXIT_GEOFENCE_CONVERSION = 2;
    public static final long GEOFENCE_NEVER_EXPIRE = -1;

    public static final class Builder {
        private double latitude;
        private double longitude;
        private float radius;
        private String uniqueId = null;
        private int conversions = 0;
        private long validDuration = -2;
        private int notificationInterval = 0;
        private int dwellDelayTime = -1;

        public Geofence build() {
            if (TextUtils.isEmpty(this.uniqueId)) {
                throw new IllegalArgumentException("uniqueId not set.");
            }
            int i10 = this.conversions;
            if (i10 <= 0 || i10 > 7) {
                throw new IllegalArgumentException("invalid conversions.");
            }
            if ((i10 & 4) != 0 && this.dwellDelayTime < 0) {
                throw new IllegalArgumentException("Non-negative dwellDelayTime needs to be set when conversions include DWELL_GEOFENCE_CONVERSION.");
            }
            long j10 = this.validDuration;
            if (j10 == -2) {
                throw new IllegalArgumentException("validDuration not set.");
            }
            int i11 = this.notificationInterval;
            if (i11 >= 0) {
                return new GeofenceEntity(this.uniqueId, i10, this.latitude, this.longitude, this.radius, j10, i11, this.dwellDelayTime);
            }
            throw new IllegalArgumentException("notificationInterval should be nonnegative.");
        }

        public Builder setConversions(int i10) {
            this.conversions = i10;
            return this;
        }

        public Builder setDwellDelayTime(int i10) {
            this.dwellDelayTime = i10;
            return this;
        }

        public Builder setNotificationInterval(int i10) {
            this.notificationInterval = i10;
            return this;
        }

        public Builder setRoundArea(double d10, double d11, float f10) {
            this.latitude = d10;
            this.longitude = d11;
            this.radius = f10;
            return this;
        }

        public Builder setUniqueId(String str) {
            this.uniqueId = str;
            return this;
        }

        public Builder setValidContinueTime(long j10) {
            if (j10 < 0) {
                j10 = -1;
            }
            this.validDuration = j10;
            return this;
        }
    }

    String getUniqueId();
}
