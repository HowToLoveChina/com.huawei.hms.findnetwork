package com.huawei.cloud.pay.model;

/* loaded from: classes5.dex */
public class GetPortraitReq extends Request {
    private String cursor;
    private boolean isOnlyPortrait;
    private Integer pageSize;

    public GetPortraitReq(String str, boolean z10, Integer num, String str2) {
        super(str);
        this.isOnlyPortrait = z10;
        this.pageSize = num;
        this.cursor = str2;
    }

    public String getCursor() {
        return this.cursor;
    }

    public boolean getIsOnlyPortrait() {
        return this.isOnlyPortrait;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public void setCursor(String str) {
        this.cursor = str;
    }

    public void setIsOnlyPortrait(boolean z10) {
        this.isOnlyPortrait = z10;
    }

    public void setPageSize(Integer num) {
        this.pageSize = num;
    }

    @Override // com.huawei.cloud.pay.model.Request
    public String toString() {
        return "isOnlyPortrait=" + this.isOnlyPortrait + "&pageSize=" + this.pageSize + "&cursor=" + this.cursor;
    }
}
