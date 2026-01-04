package com.huawei.hiar;

import com.huawei.hiar.ARConfigBase;

/* loaded from: classes5.dex */
public class ARWorldTrackingConfig extends ARConfigBase {
    public ARWorldTrackingConfig() {
    }

    @Override // com.huawei.hiar.ARConfigBase
    public ARAugmentedImageDatabase getAugmentedImageDatabase() {
        return super.getAugmentedImageDatabase();
    }

    @Override // com.huawei.hiar.ARConfigBase
    public long getFaceDetectMode() {
        return super.getFaceDetectMode();
    }

    @Override // com.huawei.hiar.ARConfigBase
    public ARConfigBase.PlaneFindingMode getPlaneFindingMode() {
        return super.getPlaneFindingMode();
    }

    @Override // com.huawei.hiar.ARConfigBase
    public void setAugmentedImageDatabase(ARAugmentedImageDatabase aRAugmentedImageDatabase) {
        super.setAugmentedImageDatabase(aRAugmentedImageDatabase);
    }

    @Override // com.huawei.hiar.ARConfigBase
    public void setFaceDetectMode(long j10) {
        super.setFaceDetectMode(j10);
    }

    @Override // com.huawei.hiar.ARConfigBase
    public void setPlaneFindingMode(ARConfigBase.PlaneFindingMode planeFindingMode) {
        super.setPlaneFindingMode(planeFindingMode);
    }

    public ARWorldTrackingConfig(ARSession aRSession) {
        super(aRSession);
        super.setArType(1);
        super.setCameraLensFacing(ARConfigBase.CameraLensFacing.REAR);
        super.setFocusMode(ARConfigBase.FocusMode.FIXED_FOCUS);
    }
}
