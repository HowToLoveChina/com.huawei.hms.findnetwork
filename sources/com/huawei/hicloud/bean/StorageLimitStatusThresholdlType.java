package com.huawei.hicloud.bean;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes6.dex */
public @interface StorageLimitStatusThresholdlType {
    public static final int ADEQUATE = 2;
    public static final int IS_FULL = 0;
    public static final int WILL_BE_FULL = 1;
}
