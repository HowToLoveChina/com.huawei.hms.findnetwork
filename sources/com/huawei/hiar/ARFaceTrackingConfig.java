package com.huawei.hiar;

import com.huawei.hiar.ARConfigBase;

/* loaded from: classes5.dex */
public class ARFaceTrackingConfig extends ARConfigBase {
    public ARFaceTrackingConfig() {
    }

    @Override // com.huawei.hiar.ARConfigBase
    public long getFaceDetectMode() {
        return super.getFaceDetectMode();
    }

    @Override // com.huawei.hiar.ARConfigBase
    public void setCameraLensFacing(ARConfigBase.CameraLensFacing cameraLensFacing) {
        super.setCameraLensFacing(cameraLensFacing);
    }

    @Override // com.huawei.hiar.ARConfigBase
    public void setFaceDetectMode(long j10) {
        super.setFaceDetectMode(j10);
    }

    public ARFaceTrackingConfig(ARSession aRSession) {
        super(aRSession);
        super.setArType(16);
        super.setCameraLensFacing(ARConfigBase.CameraLensFacing.FRONT);
        super.setFocusMode(ARConfigBase.FocusMode.AUTO_FOCUS);
    }
}
