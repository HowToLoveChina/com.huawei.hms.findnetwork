package com.huawei.hiar.common;

/* loaded from: classes5.dex */
public enum CloudAnchorState {
    STATE_NONE(0),
    STATE_TASK_IN_PROGRESS(1),
    STATE_SUCCESS(2),
    STATE_ERROR_INTERNAL(-1),
    STATE_ERROR_NOT_AUTHORIZED(-2),
    STATE_ERROR_SERVICE_UNAVAILABLE(-3),
    STATE_ERROR_RESOURCE_EXHAUSTED(-4),
    STATE_ERROR_HOSTING_DATASET_PROCESSING_FAILED(-5),
    STATE_ERROR_CLOUD_ID_NOT_FOUND(-6),
    STATE_ERROR_RESOLVING_LOCALIZATION_NO_MATCH(-7),
    STATE_ERROR_RESOLVING_SDK_VERSION_TOO_OLD(-8),
    STATE_ERROR_RESOLVING_SDK_VERSION_TOO_NEW(-9);

    private final int nativeCode;

    CloudAnchorState(int i10) {
        this.nativeCode = i10;
    }

    public static CloudAnchorState forNumber(int i10) {
        for (CloudAnchorState cloudAnchorState : values()) {
            if (cloudAnchorState.nativeCode == i10) {
                return cloudAnchorState;
            }
        }
        return STATE_NONE;
    }
}
