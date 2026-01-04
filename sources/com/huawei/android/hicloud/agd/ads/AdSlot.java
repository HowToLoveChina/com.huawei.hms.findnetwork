package com.huawei.android.hicloud.agd.ads;

/* loaded from: classes2.dex */
public class AdSlot {
    private static final int DOWNLOAD_TYPE_AGD_SDK = 1;
    private Integer adCount;
    private Integer downloadType = 1;
    private Integer pageNumber;
    private Integer personalize;
    private String slotId;

    public AdSlot(Integer num, Integer num2, String str) {
        this.adCount = num;
        this.pageNumber = num2;
        this.slotId = str;
    }

    public Integer getAdCount() {
        return this.adCount;
    }

    public Integer getDownloadType() {
        return this.downloadType;
    }

    public Integer getPageNumber() {
        return this.pageNumber;
    }

    public Integer getPersonalize() {
        return this.personalize;
    }

    public String getSlotId() {
        return this.slotId;
    }

    public void setAdCount(Integer num) {
        this.adCount = num;
    }

    public void setDownloadType(Integer num) {
        this.downloadType = num;
    }

    public void setPageNumber(Integer num) {
        this.pageNumber = num;
    }

    public void setPersonalize(Integer num) {
        this.personalize = num;
    }

    public void setSlotId(String str) {
        this.slotId = str;
    }
}
