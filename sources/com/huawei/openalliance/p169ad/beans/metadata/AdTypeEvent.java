package com.huawei.openalliance.p169ad.beans.metadata;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import java.util.List;

@DataKeep
/* loaded from: classes8.dex */
public class AdTypeEvent {
    private int adType;
    private List<String> eventTypeList;

    /* renamed from: a */
    public int m39577a() {
        return this.adType;
    }

    /* renamed from: b */
    public List<String> m39580b() {
        return this.eventTypeList;
    }

    /* renamed from: a */
    public void m39578a(int i10) {
        this.adType = i10;
    }

    /* renamed from: a */
    public void m39579a(List<String> list) {
        this.eventTypeList = list;
    }
}
