package com.huawei.openalliance.p169ad.inter.data;

import com.huawei.openalliance.p169ad.annotations.OuterVisible;

@OuterVisible
/* loaded from: classes2.dex */
public enum PlacementEvent {
    VIP("clickvip"),
    CLOSE("userclose");

    private final String event;

    PlacementEvent(String str) {
        this.event = str;
    }

    /* renamed from: a */
    public String m44544a() {
        return this.event;
    }
}
