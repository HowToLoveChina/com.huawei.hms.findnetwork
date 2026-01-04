package com.huawei.hicloud.bean;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class BackupCheckQuicKit {
    private static final int CHECK_DEFAULT = 0;
    private static final int CHECK_HITS = 1;

    @SerializedName("InnerApp")
    private int innerApp = 1;

    public boolean isInnerAppHit() {
        return this.innerApp == 1;
    }

    public String toString() {
        return "BackupCheckQuicKit{innerApp=" + this.innerApp + '}';
    }
}
