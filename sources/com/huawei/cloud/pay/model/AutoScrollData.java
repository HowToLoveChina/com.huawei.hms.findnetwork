package com.huawei.cloud.pay.model;

import android.graphics.Bitmap;

/* loaded from: classes5.dex */
public interface AutoScrollData<T> {
    String getBannerName(T t10);

    Bitmap getBannerPicture(T t10);

    String getBeginTime(T t10);

    String getEndTime(T t10);

    BannerLinkType getGotoType(T t10);

    String getPriority(T t10);
}
