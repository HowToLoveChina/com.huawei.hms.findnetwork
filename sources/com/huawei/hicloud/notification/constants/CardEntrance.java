package com.huawei.hicloud.notification.constants;

import com.huawei.hicloud.notification.constants.RecommendCardConstants;

/* loaded from: classes6.dex */
public enum CardEntrance {
    BUY(RecommendCardConstants.Entrance.BUY),
    HOMEPAGE(RecommendCardConstants.Entrance.HOMEPAGE),
    MANAGE("manage");

    private String entrance;

    CardEntrance(String str) {
        this.entrance = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.entrance;
    }
}
