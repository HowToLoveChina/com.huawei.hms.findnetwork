package com.huawei.hms.common;

/* loaded from: classes8.dex */
public enum HmsCheckedState {
    UNCHECKED(0),
    NOT_NEED_UPDATE(1),
    NEED_UPDATE(2);


    /* renamed from: a */
    private final int f23411a;

    HmsCheckedState(int i10) {
        this.f23411a = i10;
    }

    public int getState() {
        return this.f23411a;
    }
}
