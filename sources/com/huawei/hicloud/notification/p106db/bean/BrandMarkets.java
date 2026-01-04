package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;

/* loaded from: classes6.dex */
public class BrandMarkets {

    @SerializedName("brandMarkets")
    private BrandMarket[] brandMarkets;

    @SerializedName(FaqConstants.FAQ_EMUI_LANGUAGE)
    private CommonLanguage language;

    public BrandMarket[] getBrandMarkets() {
        return this.brandMarkets;
    }

    public CommonLanguage getLanguage() {
        return this.language;
    }

    public void setBrandMarkets(BrandMarket[] brandMarketArr) {
        this.brandMarkets = brandMarketArr;
    }

    public void setLanguage(CommonLanguage commonLanguage) {
        this.language = commonLanguage;
    }
}
