package com.huawei.android.hicloud.hwidrecommend.bean;

import java.util.List;

/* loaded from: classes3.dex */
public class RecommendResult {
    private int recommendSize;
    private List<RecommendItem> recommends;

    public int getRecommendSize() {
        return this.recommendSize;
    }

    public List<RecommendItem> getRecommends() {
        return this.recommends;
    }

    public void setRecommendSize(int i10) {
        this.recommendSize = i10;
    }

    public void setRecommends(List<RecommendItem> list) {
        this.recommends = list;
    }
}
