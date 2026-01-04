package com.huawei.hiar;

import com.huawei.hiar.ARConfigBase;

/* loaded from: classes5.dex */
public class ARImageTrackingConfig extends ARConfigBase {
    public ARImageTrackingConfig() {
    }

    @Override // com.huawei.hiar.ARConfigBase
    public ARAugmentedImageDatabase getAugmentedImageDatabase() {
        return super.getAugmentedImageDatabase();
    }

    @Override // com.huawei.hiar.ARConfigBase
    public void setAugmentedImageDatabase(ARAugmentedImageDatabase aRAugmentedImageDatabase) {
        super.setAugmentedImageDatabase(aRAugmentedImageDatabase);
    }

    public ARImageTrackingConfig(ARSession aRSession) {
        super(aRSession);
        super.setArType(128);
        super.setFocusMode(ARConfigBase.FocusMode.AUTO_FOCUS);
        super.setCameraLensFacing(ARConfigBase.CameraLensFacing.REAR);
    }
}
