package com.huawei.hicloud.notification.constants;

import com.huawei.hicloud.notification.constants.RecommendCardConstants;

/* loaded from: classes6.dex */
public enum BannerPictureType {
    PHONE_LANDSCAPE(RecommendCardConstants.Resolution.PHONE_LANDSCAPE),
    PHONE_PORTRAIT(RecommendCardConstants.Resolution.PHONE_PORTRAIT),
    PICTURE_SECOND("PICTURE_SECOND");

    private String pictureType;

    BannerPictureType(String str) {
        this.pictureType = str;
    }

    public String getVal() {
        return this.pictureType;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.pictureType;
    }
}
