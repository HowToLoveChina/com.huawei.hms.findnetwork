package com.huawei.hicloud.campaign.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.android.hicloud.clouddisk.logic.calllogs.CallLogCons;
import com.huawei.hicloud.notification.p106db.bean.CommonLanguage;
import com.huawei.hms.network.inner.api.NetworkService;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;

/* loaded from: classes6.dex */
public class CampaignActivityRoot {

    @SerializedName(FaqConstants.FAQ_EMUI_LANGUAGE)
    private CommonLanguage commonLanguage;

    @SerializedName(NetworkService.Constants.CONFIG_SERVICE)
    private CampaignActivityConfig[] config;

    @SerializedName(CallLogCons.DATE)
    private String date;

    /* renamed from: id */
    @SerializedName("id")
    private String f22238id;

    @SerializedName("version")
    private String version;

    public CommonLanguage getCommonLanguage() {
        return this.commonLanguage;
    }

    public CampaignActivityConfig[] getConfig() {
        return this.config;
    }

    public String getDate() {
        return this.date;
    }

    public String getId() {
        return this.f22238id;
    }

    public String getVersion() {
        return this.version;
    }

    public void setCommonLanguage(CommonLanguage commonLanguage) {
        this.commonLanguage = commonLanguage;
    }

    public void setConfig(CampaignActivityConfig[] campaignActivityConfigArr) {
        this.config = campaignActivityConfigArr;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setId(String str) {
        this.f22238id = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
