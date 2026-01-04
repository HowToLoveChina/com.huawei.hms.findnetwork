package com.huawei.riemann.location.common.bean;

import java.util.ArrayList;

/* loaded from: classes5.dex */
public class GnssInfo {
    ArrayList<SatInfo> satInfoList = new ArrayList<>();

    public ArrayList<SatInfo> getSatInfoList() {
        return this.satInfoList;
    }

    public void setSatInfoList(ArrayList<SatInfo> arrayList) {
        this.satInfoList = arrayList;
    }
}
