package com.huawei.hiar.common;

import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hms.support.api.entity.pay.PayStatusCodes;

/* loaded from: classes5.dex */
public enum CloudServiceState {
    UNKNOWN_STATE(-1),
    CLOUD_SERVICE_NORMAL(10000),
    CLOUD_SERVICE_ERROR_NETWORK_UNAVAILABLE(10001),
    CLOUD_SERVICE_ERROR_CLOUD_SERVICE_UNAVAILABLE(10002),
    CLOUD_SERVICE_ERROR_NOT_AUTHORIZED(10003),
    CLOUD_SERVICE_ERROR_SERVER_VERSION_TOO_OLD(10004),
    CLOUD_SERVICE_ERROR_TIME_EXHAUSTED(10005),
    CLOUD_SERVICE_ERROR_INTERNAL(NotifyConstants.CommonActionRequestCode.OPEN_DOUBLE_FRONT_APP_NOTICE),
    CLOUD_IMAGE_ERROR_IMAGE_GALLERY_INVALID(20001),
    CLOUD_IMAGE_ERROR_IMAGE_RECOGNIZE_FAILE(20002),
    CLOUD_OBJECT_ERROR_OBJECT_MODEL_INVALID(PayStatusCodes.PAY_STATE_PARAM_ERROR),
    CLOUD_OBJECT_ERROR_OBJECT_RECOGNIZE_FAILE(PayStatusCodes.PAY_STATE_TIME_OUT);

    private final int nativeCode;

    CloudServiceState(int i10) {
        this.nativeCode = i10;
    }

    public static CloudServiceState forNumber(int i10) {
        for (CloudServiceState cloudServiceState : values()) {
            if (cloudServiceState.nativeCode == i10) {
                return cloudServiceState;
            }
        }
        return UNKNOWN_STATE;
    }
}
