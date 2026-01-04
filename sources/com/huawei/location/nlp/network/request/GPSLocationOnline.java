package com.huawei.location.nlp.network.request;

import com.huawei.location.C6769i;
import com.huawei.location.nlp.network.response.Location;

/* loaded from: classes8.dex */
public class GPSLocationOnline extends Location {
    private int sourceType;

    public int getSourceType() {
        return this.sourceType;
    }

    public void setSourceType(int i10) {
        this.sourceType = i10;
    }

    @Override // com.huawei.location.nlp.network.response.Location
    public String toString() {
        StringBuilder sb2 = new StringBuilder("GPSLocationOnline{");
        sb2.append(super.toString());
        sb2.append("sourceType=");
        return C6769i.m38373a(sb2, this.sourceType, '}');
    }
}
