package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.android.hicloud.clouddisk.logic.calllogs.CallLogCons;
import com.huawei.hms.network.inner.api.NetworkService;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.util.List;

/* loaded from: classes6.dex */
public class BackupBeforeNoticeConfig {

    @SerializedName(FaqConstants.FAQ_EMUI_LANGUAGE)
    private CommonLanguage commonLanguage;

    @SerializedName(NetworkService.Constants.CONFIG_SERVICE)
    private List<BackupBeforeNotice> configuration;

    @SerializedName(CallLogCons.DATE)
    private String date;

    @SerializedName("version")
    private String version;

    public CommonLanguage getCommonLanguage() {
        return this.commonLanguage;
    }

    public List<BackupBeforeNotice> getConfiguration() {
        return this.configuration;
    }

    public String getDate() {
        return this.date;
    }

    public String getVersion() {
        return this.version;
    }

    public void setCommonLanguage(CommonLanguage commonLanguage) {
        this.commonLanguage = commonLanguage;
    }

    public void setConfiguration(List<BackupBeforeNotice> list) {
        this.configuration = list;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
