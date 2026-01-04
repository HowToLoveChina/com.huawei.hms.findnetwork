package com.huawei.hicloud.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.io.Serializable;

/* loaded from: classes6.dex */
public class SyncConfig implements Serializable {
    private static final long serialVersionUID = -92298829911339125L;

    @SerializedName(FaqConstants.FAQ_EMUI_LANGUAGE)
    private SyncConfigLanguage syncConfigLanguage;

    @SerializedName("service")
    private SyncConfigService[] syncConfigService;

    public SyncConfigLanguage getSyncConfigLanguage() {
        return this.syncConfigLanguage;
    }

    public SyncConfigService[] getSyncConfigService() {
        SyncConfigService[] syncConfigServiceArr = this.syncConfigService;
        return syncConfigServiceArr != null ? (SyncConfigService[]) syncConfigServiceArr.clone() : new SyncConfigService[0];
    }

    public void setSyncConfigLanguage(SyncConfigLanguage syncConfigLanguage) {
        this.syncConfigLanguage = syncConfigLanguage;
    }

    public void setSyncConfigService(SyncConfigService[] syncConfigServiceArr) {
        if (syncConfigServiceArr != null) {
            this.syncConfigService = (SyncConfigService[]) syncConfigServiceArr.clone();
        } else {
            this.syncConfigService = null;
        }
    }
}
