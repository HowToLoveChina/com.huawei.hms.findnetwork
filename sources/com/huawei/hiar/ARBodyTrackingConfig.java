package com.huawei.hiar;

import com.huawei.hiar.ARConfigBase;

/* loaded from: classes5.dex */
public class ARBodyTrackingConfig extends ARConfigBase {
    public ARBodyTrackingConfig() {
    }

    @Override // com.huawei.hiar.ARConfigBase
    public ARConfigBase.CameraLensFacing getCameraLensFacing() {
        return super.getCameraLensFacing();
    }

    @Override // com.huawei.hiar.ARConfigBase
    public void setCameraLensFacing(ARConfigBase.CameraLensFacing cameraLensFacing) {
        super.setCameraLensFacing(cameraLensFacing);
    }

    public ARBodyTrackingConfig(ARSession aRSession) {
        super(aRSession);
        setArType(2);
        super.setCameraLensFacing(ARConfigBase.CameraLensFacing.REAR);
        super.setFocusMode(ARConfigBase.FocusMode.AUTO_FOCUS);
    }
}
