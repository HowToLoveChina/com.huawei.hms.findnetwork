package com.huawei.location.nlp.network.request;

import com.huawei.location.C6769i;
import com.huawei.location.nlp.network.response.Location;

/* loaded from: classes8.dex */
public class NLPLocationOnLine extends Location {
    private int source;
    private int technology;

    public int getSource() {
        return this.source;
    }

    public int getTechnology() {
        return this.technology;
    }

    public void setSource(int i10) {
        this.source = i10;
    }

    public void setTechnology(int i10) {
        this.technology = i10;
    }

    @Override // com.huawei.location.nlp.network.response.Location
    public String toString() {
        StringBuilder sb2 = new StringBuilder("NLPLocationOnLine{");
        sb2.append(super.toString());
        sb2.append("source=");
        sb2.append(this.source);
        sb2.append(", technology=");
        return C6769i.m38373a(sb2, this.technology, '}');
    }
}
