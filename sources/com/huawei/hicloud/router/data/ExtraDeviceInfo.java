package com.huawei.hicloud.router.data;

/* loaded from: classes.dex */
public class ExtraDeviceInfo {
    private boolean canBeReserveForever;
    private int expiratoryInDays;

    /* renamed from: id */
    private String f22856id;
    private Integer occupySpaceType;

    public int getExpiratoryInDays() {
        return this.expiratoryInDays;
    }

    public String getId() {
        return this.f22856id;
    }

    public Integer getOccupySpaceType() {
        return this.occupySpaceType;
    }

    public boolean isCanBeReserveForever() {
        return this.canBeReserveForever;
    }

    public void setCanBeReserveForever(boolean z10) {
        this.canBeReserveForever = z10;
    }

    public void setExpiratoryInDays(int i10) {
        this.expiratoryInDays = i10;
    }

    public void setId(String str) {
        this.f22856id = str;
    }

    public void setOccupySpaceType(Integer num) {
        this.occupySpaceType = num;
    }
}
