package com.huawei.hicloud.notification.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.notification.p106db.bean.CommonLanguage;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;

/* loaded from: classes6.dex */
public class FrequencyControl {

    @SerializedName("frequencyControls")
    private FreqControlBean[] frequencyControlBeans;

    @SerializedName(FaqConstants.FAQ_EMUI_LANGUAGE)
    private CommonLanguage language;

    public FreqControlBean[] getFrequencyControlBeans() {
        return this.frequencyControlBeans;
    }

    public CommonLanguage getLanguage() {
        return this.language;
    }

    public void setFrequencyControlBeans(FreqControlBean[] freqControlBeanArr) {
        this.frequencyControlBeans = freqControlBeanArr;
    }

    public void setLanguage(CommonLanguage commonLanguage) {
        this.language = commonLanguage;
    }
}
