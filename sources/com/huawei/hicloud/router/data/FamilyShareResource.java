package com.huawei.hicloud.router.data;

import com.google.gson.annotations.SerializedName;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;

/* loaded from: classes.dex */
public class FamilyShareResource {

    @SerializedName(FaqConstants.FAQ_EMUI_LANGUAGE)
    private FamilyShareLanguage familyShareLanguage;

    @SerializedName("page_parmas")
    private FamilySharePageParams familySharePageParams;

    @SerializedName("static_pages")
    private FamilyShareStaticPages familyShareStaticPages;

    public FamilyShareLanguage getFamilyShareLanguage() {
        return this.familyShareLanguage;
    }

    public FamilySharePageParams getFamilySharePageParams() {
        return this.familySharePageParams;
    }

    public FamilyShareStaticPages getFamilyShareStaticPages() {
        return this.familyShareStaticPages;
    }

    public void setFamilyShareLanguage(FamilyShareLanguage familyShareLanguage) {
        this.familyShareLanguage = familyShareLanguage;
    }

    public void setFamilySharePageParams(FamilySharePageParams familySharePageParams) {
        this.familySharePageParams = familySharePageParams;
    }

    public void setFamilyShareStaticPages(FamilyShareStaticPages familyShareStaticPages) {
        this.familyShareStaticPages = familyShareStaticPages;
    }
}
