package com.huawei.hiar;

import java.util.Collection;

/* loaded from: classes5.dex */
public interface ARTrackable {

    public enum TrackingState {
        UNKNOWN_STATE(-1),
        TRACKING(0),
        PAUSED(1),
        STOPPED(2);

        final int mStateCode;

        TrackingState(int i10) {
            this.mStateCode = i10;
        }

        public static TrackingState forNumber(int i10) {
            for (TrackingState trackingState : values()) {
                if (trackingState.mStateCode == i10) {
                    return trackingState;
                }
            }
            return UNKNOWN_STATE;
        }
    }

    ARAnchor createAnchor(ARPose aRPose);

    Collection<ARAnchor> getAnchors();

    TrackingState getTrackingState();
}
