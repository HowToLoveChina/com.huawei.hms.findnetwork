package com.huawei.openalliance.p169ad.beans.vast;

import com.huawei.openalliance.p169ad.annotations.InterfaceC6929a;
import java.util.List;
import java.util.Map;

/* loaded from: classes8.dex */
public class NonLinearAds {

    @InterfaceC6929a
    private String nonLinearClickThrough;
    private List<NonLinear> nonLinears;
    private Map<String, List<Tracking>> trackingEvents;

    /* renamed from: a */
    public Map<String, List<Tracking>> m40998a() {
        return this.trackingEvents;
    }

    /* renamed from: b */
    public List<NonLinear> m41001b() {
        return this.nonLinears;
    }

    /* renamed from: a */
    public void m40999a(List<NonLinear> list) {
        this.nonLinears = list;
    }

    /* renamed from: a */
    public void m41000a(Map<String, List<Tracking>> map) {
        this.trackingEvents = map;
    }
}
