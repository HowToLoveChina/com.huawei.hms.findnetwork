package com.huawei.hiar;

import com.huawei.hiar.ARConfigBase;

/* loaded from: classes5.dex */
public class ARWorldBodyTrackingConfig extends ARConfigBase {
    public ARWorldBodyTrackingConfig() {
    }

    @Override // com.huawei.hiar.ARConfigBase
    public ARAugmentedImageDatabase getAugmentedImageDatabase() {
        return super.getAugmentedImageDatabase();
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
    public void setPlaneFindingMode(ARConfigBase.PlaneFindingMode planeFindingMode) {
        super.setPlaneFindingMode(planeFindingMode);
    }

    public ARWorldBodyTrackingConfig(ARSession aRSession) {
        super(aRSession);
        setArType(3);
        super.setCameraLensFacing(ARConfigBase.CameraLensFacing.REAR);
        super.setFocusMode(ARConfigBase.FocusMode.FIXED_FOCUS);
    }
}
