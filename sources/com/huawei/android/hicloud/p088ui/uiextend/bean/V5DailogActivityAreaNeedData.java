package com.huawei.android.hicloud.p088ui.uiextend.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.cloud.pay.model.ActivityEntry;
import com.huawei.cloud.pay.model.GetClientUIConfigResp;
import com.huawei.cloud.pay.model.GetPackagesBySpaceRuleResp;
import com.huawei.hicloud.notification.p106db.bean.RecommendNeedData;
import com.huawei.hicloud.notification.p106db.bean.backupspaceinsufficientconfig.FrontAppText;
import com.huawei.hicloud.notification.p106db.bean.backupspaceinsufficientconfig.V5DetailPageText;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class V5DailogActivityAreaNeedData implements Serializable {
    private static final long serialVersionUID = 6924660407753435855L;
    private ActivityEntry activityEntry;
    private GetClientUIConfigResp clientUIConfigResp;
    private V5DetailPageText detailPage;

    @SerializedName("enableFrontApp")
    private int enableFrontApp;

    @SerializedName("enableRecomPackages")
    private int enableRecomPackages;

    @SerializedName("frontAppStyle")
    private String frontAppStyle;

    @SerializedName("frontAppText")
    private FrontAppText frontAppText;
    private boolean isAutoPay;
    private RecommendNeedData recommendNeedData;
    private GetPackagesBySpaceRuleResp recommendPackageInfo;

    public ActivityEntry getActivityEntry() {
        return this.activityEntry;
    }

    public GetClientUIConfigResp getClientUIConfigResp() {
        return this.clientUIConfigResp;
    }

    public V5DetailPageText getDetailPage() {
        return this.detailPage;
    }

    public int getEnableFrontApp() {
        return this.enableFrontApp;
    }

    public int getEnableRecomPackages() {
        return this.enableRecomPackages;
    }

    public String getFrontAppStyle() {
        return this.frontAppStyle;
    }

    public FrontAppText getFrontAppText() {
        return this.frontAppText;
    }

    public RecommendNeedData getRecommendNeedData() {
        return this.recommendNeedData;
    }

    public GetPackagesBySpaceRuleResp getRecommendPackageInfo() {
        return this.recommendPackageInfo;
    }

    public boolean isAutoPay() {
        return this.isAutoPay;
    }

    public void setActivityEntry(ActivityEntry activityEntry) {
        this.activityEntry = activityEntry;
    }

    public void setAutoPay(boolean z10) {
        this.isAutoPay = z10;
    }

    public void setClientUIConfigResp(GetClientUIConfigResp getClientUIConfigResp) {
        this.clientUIConfigResp = getClientUIConfigResp;
    }

    public void setDetailPage(V5DetailPageText v5DetailPageText) {
        this.detailPage = v5DetailPageText;
    }

    public void setEnableFrontApp(int i10) {
        this.enableFrontApp = i10;
    }

    public void setEnableRecomPackages(int i10) {
        this.enableRecomPackages = i10;
    }

    public void setFrontAppStyle(String str) {
        this.frontAppStyle = str;
    }

    public void setFrontAppText(FrontAppText frontAppText) {
        this.frontAppText = frontAppText;
    }

    public void setRecommendNeedData(RecommendNeedData recommendNeedData) {
        this.recommendNeedData = recommendNeedData;
    }

    public void setRecommendPackageInfo(GetPackagesBySpaceRuleResp getPackagesBySpaceRuleResp) {
        this.recommendPackageInfo = getPackagesBySpaceRuleResp;
    }
}
