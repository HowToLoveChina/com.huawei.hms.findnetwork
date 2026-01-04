package com.huawei.openalliance.p169ad.inter.data;

import com.huawei.openalliance.p169ad.annotations.OuterVisible;

@OuterVisible
/* loaded from: classes2.dex */
public enum RewardEvent {
    CLOSE("userclose"),
    BACKPRESSED("backpressed");

    private final String event;

    RewardEvent(String str) {
        this.event = str;
    }

    /* renamed from: a */
    public String m44553a() {
        return this.event;
    }
}
