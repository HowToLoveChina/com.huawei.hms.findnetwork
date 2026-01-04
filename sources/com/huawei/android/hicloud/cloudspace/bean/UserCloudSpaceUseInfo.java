package com.huawei.android.hicloud.cloudspace.bean;

import android.content.Context;
import android.content.res.Resources;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.util.Locale;
import p015ak.C0213f;
import p015ak.C0223k;
import p015ak.C0241z;
import p514o9.C11839m;

/* loaded from: classes2.dex */
public class UserCloudSpaceUseInfo {
    private static final String EMPTY = "";
    private static final String TAG = "UserCloudSpaceUseInfo";
    private long cloudUsage;
    private int imageCount;
    private int videoCount;

    public long getCloudUsage() {
        return this.cloudUsage;
    }

    public String getCloudUsageWithUnit() {
        String language = Locale.getDefault().getLanguage();
        String strM1524g = C0223k.m1524g(C0213f.m1377a(), this.cloudUsage);
        if (!language.equalsIgnoreCase(Constants.URDU_LANG)) {
            return strM1524g;
        }
        return "\u200f\u200e" + strM1524g;
    }

    public int getImageCount() {
        return this.imageCount;
    }

    public String getImageCountWithUnit(Context context, int i10) {
        if (context == null) {
            C11839m.m70689w(TAG, "getImageCountWithUnit: context is null");
            return "";
        }
        try {
            Resources resources = context.getResources();
            if (resources != null) {
                int i11 = this.imageCount;
                return resources.getQuantityString(i10, i11, Integer.valueOf(i11));
            }
        } catch (Exception e10) {
            C11839m.m70687e(TAG, e10.toString());
        }
        return "";
    }

    public int getVideoCount() {
        return this.videoCount;
    }

    public String getVideoCountWithUnit(Context context, int i10) {
        if (context == null) {
            C11839m.m70689w(TAG, "getVideoCountWithUnit: context is null");
            return "";
        }
        try {
            Resources resources = context.getResources();
            if (resources != null) {
                int i11 = this.videoCount;
                return resources.getQuantityString(i10, i11, Integer.valueOf(i11));
            }
        } catch (Exception e10) {
            C11839m.m70687e(TAG, e10.toString());
        }
        return "";
    }

    public void setCloudUsage(String str) {
        this.cloudUsage = C0241z.m1688f(str);
    }

    public void setImageCount(String str) {
        this.imageCount = C0241z.m1685c(str);
    }

    public void setVideoCount(String str) {
        this.videoCount = C0241z.m1685c(str);
    }

    public String toString() {
        return "UserCloudSpaceUseInfo{cloudUsage=" + this.cloudUsage + ", imageCount=" + this.imageCount + ", videoCount=" + this.videoCount + '}';
    }
}
