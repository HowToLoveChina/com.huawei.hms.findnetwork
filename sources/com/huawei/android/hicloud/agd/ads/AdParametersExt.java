package com.huawei.android.hicloud.agd.ads;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes2.dex */
public class AdParametersExt implements Serializable {
    private static final long serialVersionUID = 4164617120333037484L;
    private List<AdParam> adParamList;
    private Integer enabled = 0;
    private Integer threshold = 0;

    private String getAdid(int i10) {
        List<AdParam> list = this.adParamList;
        if (list != null && list.size() != 0) {
            for (AdParam adParam : this.adParamList) {
                if (adParam.getAdType() == i10) {
                    return adParam.getAdId();
                }
            }
        }
        return "";
    }

    public String getAgdAdid() {
        return getAdid(1);
    }

    public String getAggAdid() {
        return getAdid(2);
    }

    public Integer getEnabled() {
        return this.enabled;
    }

    public String getPpsAdid() {
        return getAdid(0);
    }

    public String getPreAppAdid() {
        return getAdid(3);
    }

    public Integer getThreshold() {
        return this.threshold;
    }

    public boolean isRequestAgdResource(int i10, String str) {
        return this.enabled.intValue() != 0 && this.threshold.intValue() >= i10;
    }

    public void setEnabled(Integer num) {
        this.enabled = num;
    }

    public void setThreshold(Integer num) {
        this.threshold = num;
    }

    public String toString() {
        return "AdParameters{enabled=" + this.enabled + ", PpsAdid='" + getPpsAdid() + "', AgdAdid='" + getAgdAdid() + "', AggAdid='" + getAggAdid() + "', PreAppAdid='" + getPreAppAdid() + "', threshold=" + this.threshold + '}';
    }
}
