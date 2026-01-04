package com.huawei.hicloud.notification.spacelanguage.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;

/* loaded from: classes6.dex */
public class Configurations {

    /* renamed from: id */
    @SerializedName("id")
    private String f22679id;

    @SerializedName(FaqConstants.FAQ_EMUI_LANGUAGE)
    private SpaceMultLanguage language;

    public String getId() {
        return this.f22679id;
    }

    public SpaceMultLanguage getLanguage() {
        return this.language;
    }

    public void setId(String str) {
        this.f22679id = str;
    }

    public void setLanguage(SpaceMultLanguage spaceMultLanguage) {
        this.language = spaceMultLanguage;
    }
}
