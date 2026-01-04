package com.huawei.hicloud.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.io.Serializable;

/* loaded from: classes6.dex */
public class DriveConfig implements Serializable {
    private static final long serialVersionUID = -2650143845672864093L;

    @SerializedName(FaqConstants.FAQ_EMUI_LANGUAGE)
    private DriveConfigLanguage driveConfigLanguage;

    @SerializedName("service")
    private DriveConfigService[] driveConfigService;

    public DriveConfigLanguage getDriveConfigLanguage() {
        return this.driveConfigLanguage;
    }

    public DriveConfigService[] getDriveConfigService() {
        DriveConfigService[] driveConfigServiceArr = this.driveConfigService;
        return driveConfigServiceArr != null ? (DriveConfigService[]) driveConfigServiceArr.clone() : new DriveConfigService[0];
    }

    public void setDriveConfigLanguage(DriveConfigLanguage driveConfigLanguage) {
        this.driveConfigLanguage = driveConfigLanguage;
    }

    public void setDriveConfigService(DriveConfigService[] driveConfigServiceArr) {
        if (driveConfigServiceArr != null) {
            this.driveConfigService = (DriveConfigService[]) driveConfigServiceArr.clone();
        } else {
            this.driveConfigService = null;
        }
    }
}
