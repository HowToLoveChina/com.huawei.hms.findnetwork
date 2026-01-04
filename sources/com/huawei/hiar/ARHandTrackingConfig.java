package com.huawei.hiar;

import com.huawei.hiar.ARConfigBase;

/* loaded from: classes5.dex */
public class ARHandTrackingConfig extends ARConfigBase {
    public ARHandTrackingConfig() {
    }

    @Override // com.huawei.hiar.ARConfigBase
    public ARConfigBase.CameraLensFacing getCameraLensFacing() {
        return super.getCameraLensFacing();
    }

    @Override // com.huawei.hiar.ARConfigBase
    @Deprecated
    public ARConfigBase.HandFindingMode getHandFindingMode() {
        return super.getHandFindingMode();
    }

    @Override // com.huawei.hiar.ARConfigBase
    public void setCameraLensFacing(ARConfigBase.CameraLensFacing cameraLensFacing) {
        super.setCameraLensFacing(cameraLensFacing);
    }

    @Override // com.huawei.hiar.ARConfigBase
    @Deprecated
    public void setHandFindingMode(ARConfigBase.HandFindingMode handFindingMode) {
        super.setHandFindingMode(handFindingMode);
    }

    public ARHandTrackingConfig(ARSession aRSession) {
        super(aRSession);
        setArType(4);
        super.setCameraLensFacing(ARConfigBase.CameraLensFacing.REAR);
        super.setFocusMode(ARConfigBase.FocusMode.AUTO_FOCUS);
    }
}
