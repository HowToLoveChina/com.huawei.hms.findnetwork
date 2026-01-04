package com.huawei.android.hicloud.p088ui.uiextend.cloudpay;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.huawei.cloud.pay.model.BannerLinkType;
import com.huawei.cloud.pay.model.BannerParams;
import p035bk.C1248a;

/* loaded from: classes3.dex */
public class BannerScrollUpView extends ScrollUpView<BannerParams> {
    public static final int MAX_HEIGHT = 40;
    public static final int REQ_HEIGHT = 96;
    public static final int REQ_WIDTH = 96;

    public BannerScrollUpView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }

    private int calculateInSampleSize(BitmapFactory.Options options, int i10, int i11) {
        int i12 = options.outHeight;
        int i13 = options.outWidth;
        if (i12 <= i11 && i13 <= i10) {
            return 1;
        }
        int iRound = Math.round(i12 / i11);
        int iRound2 = Math.round(i13 / i10);
        return iRound < iRound2 ? iRound : iRound2;
    }

    private Bitmap getSmallBitmap(String str) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            C1248a.m7473d(str, options);
            options.inSampleSize = calculateInSampleSize(options, 96, 96);
            options.inJustDecodeBounds = false;
            return C1248a.m7473d(str, options);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.uiextend.cloudpay.ScrollUpView
    public int getBannerViewHeight() {
        return 40;
    }

    public BannerScrollUpView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.huawei.cloud.pay.model.AutoScrollData
    public String getBannerName(BannerParams bannerParams) {
        if (bannerParams != null) {
            return bannerParams.getBannerName();
        }
        return null;
    }

    @Override // com.huawei.cloud.pay.model.AutoScrollData
    public Bitmap getBannerPicture(BannerParams bannerParams) {
        if (bannerParams == null || TextUtils.isEmpty(bannerParams.getBannerPicture())) {
            return null;
        }
        return getSmallBitmap(bannerParams.getBannerPicture());
    }

    @Override // com.huawei.cloud.pay.model.AutoScrollData
    public String getBeginTime(BannerParams bannerParams) {
        if (bannerParams != null) {
            return bannerParams.getBeginTime();
        }
        return null;
    }

    @Override // com.huawei.cloud.pay.model.AutoScrollData
    public String getEndTime(BannerParams bannerParams) {
        if (bannerParams != null) {
            return bannerParams.getEndTime();
        }
        return null;
    }

    @Override // com.huawei.cloud.pay.model.AutoScrollData
    public BannerLinkType getGotoType(BannerParams bannerParams) {
        if (bannerParams != null) {
            return bannerParams.getLink();
        }
        return null;
    }

    @Override // com.huawei.cloud.pay.model.AutoScrollData
    public String getPriority(BannerParams bannerParams) {
        if (bannerParams != null) {
            return bannerParams.getPriority();
        }
        return null;
    }

    public BannerScrollUpView(Context context) {
        super(context);
    }
}
