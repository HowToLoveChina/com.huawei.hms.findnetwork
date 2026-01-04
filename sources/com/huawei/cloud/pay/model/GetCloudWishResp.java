package com.huawei.cloud.pay.model;

import java.util.List;

/* loaded from: classes5.dex */
public class GetCloudWishResp {
    private CloudWishError error;
    private String nextCursor;
    private List<CloudWish> wishes;

    public CloudWishError getError() {
        return this.error;
    }

    public String getNextCursor() {
        return this.nextCursor;
    }

    public List<CloudWish> getWishes() {
        return this.wishes;
    }

    public void setError(CloudWishError cloudWishError) {
        this.error = cloudWishError;
    }

    public void setNextCursor(String str) {
        this.nextCursor = str;
    }

    public void setWishes(List<CloudWish> list) {
        this.wishes = list;
    }
}
