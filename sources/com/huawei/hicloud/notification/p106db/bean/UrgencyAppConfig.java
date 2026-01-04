package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.util.List;

/* loaded from: classes6.dex */
public class UrgencyAppConfig {
    private static final String TAG = "UrgencyAppConfig";

    @SerializedName(FaqConstants.FAQ_EMUI_LANGUAGE)
    private UrgencyLanguage language;

    @SerializedName("policies")
    private List<UrgencyPolicy> policyList;

    public UrgencyLanguage getLanguage() {
        return this.language;
    }

    public String getLanguageJsonStr() {
        try {
            return this.language != null ? new Gson().toJson(this.language) : "";
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "getLanguageJsonStr exception:" + e10.toString());
            return "";
        }
    }

    public List<UrgencyPolicy> getPolicyList() {
        return this.policyList;
    }

    public void setLanguage(UrgencyLanguage urgencyLanguage) {
        this.language = urgencyLanguage;
    }

    public void setPolicyList(List<UrgencyPolicy> list) {
        this.policyList = list;
    }
}
