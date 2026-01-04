package com.huawei.cloud.pay.model;

import com.huawei.android.hicloud.agd.ads.AdParametersExt;
import java.io.Serializable;

/* loaded from: classes5.dex */
public class DlAppCampInfo implements Serializable {
    private static final long serialVersionUID = -3336207801828149069L;
    private AdParametersExt adParametersExt;
    private int launchNo;
    private int minLimit;

    public AdParametersExt getAdParametersExt() {
        return this.adParametersExt;
    }

    public int getLaunchNo() {
        return this.launchNo;
    }

    public int getMinLimit() {
        return this.minLimit;
    }

    public void setAdParametersExt(AdParametersExt adParametersExt) {
        this.adParametersExt = adParametersExt;
    }

    public void setLaunchNo(int i10) {
        this.launchNo = i10;
    }

    public void setMinLimit(int i10) {
        this.minLimit = i10;
    }
}
