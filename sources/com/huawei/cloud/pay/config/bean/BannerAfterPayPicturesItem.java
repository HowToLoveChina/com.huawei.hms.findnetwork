package com.huawei.cloud.pay.config.bean;

import p015ak.C0241z;

/* loaded from: classes5.dex */
public class BannerAfterPayPicturesItem {
    private String hash;
    private String resolution;
    private String url;

    public String getHash() {
        return this.hash;
    }

    public float getPicturePropertion() {
        int iM1685c;
        String str = this.resolution;
        if (str != null && !str.equals("")) {
            String[] strArrSplit = this.resolution.split("\\*");
            if (strArrSplit.length != 2 || (iM1685c = C0241z.m1685c(strArrSplit[0])) == 0) {
                return -1.0f;
            }
            return C0241z.m1685c(strArrSplit[1]) / iM1685c;
        }
        return -1.0f;
    }

    public String getResolution() {
        return this.resolution;
    }

    public String getUrl() {
        return this.url;
    }

    public void setHash(String str) {
        this.hash = str;
    }

    public void setResolution(String str) {
        this.resolution = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
