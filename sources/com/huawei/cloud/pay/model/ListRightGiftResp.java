package com.huawei.cloud.pay.model;

import java.util.List;

/* loaded from: classes5.dex */
public class ListRightGiftResp extends Response {
    private String cursor;
    private List<Gift> giftList;
    private int pageSize;

    public String getCursor() {
        return this.cursor;
    }

    public List<Gift> getGiftList() {
        return this.giftList;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setCursor(String str) {
        this.cursor = str;
    }

    public void setGiftList(List<Gift> list) {
        this.giftList = list;
    }

    public void setPageSize(int i10) {
        this.pageSize = i10;
    }
}
