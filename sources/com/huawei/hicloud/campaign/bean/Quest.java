package com.huawei.hicloud.campaign.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import java.util.List;

/* loaded from: classes6.dex */
public class Quest {
    private int defaultValue;

    /* renamed from: id */
    @SerializedName("id")
    private String f22240id;

    @SerializedName(NotifyConstants.NotificationReport.KEY_ORDER)
    private String order;
    private List<RankingValues> rankingValues;

    public int getDefaultValue() {
        return this.defaultValue;
    }

    public String getId() {
        return this.f22240id;
    }

    public String getOrder() {
        return this.order;
    }

    public List<RankingValues> getRankingValues() {
        return this.rankingValues;
    }

    public void setDefaultValue(int i10) {
        this.defaultValue = i10;
    }

    public void setId(String str) {
        this.f22240id = str;
    }

    public void setOrder(String str) {
        this.order = str;
    }

    public void setRankingValues(List<RankingValues> list) {
        this.rankingValues = list;
    }
}
