package com.huawei.openalliance.p169ad.beans.metadata;

import com.huawei.openalliance.p169ad.annotations.DataKeep;

@DataKeep
/* loaded from: classes8.dex */
public class TouchPoint {
    private int rawX;
    private int rawY;
    private String taskId;

    public TouchPoint() {
    }

    public TouchPoint(int i10, int i11, String str) {
        this.rawX = i10;
        this.rawY = i11;
        this.taskId = str;
    }
}
