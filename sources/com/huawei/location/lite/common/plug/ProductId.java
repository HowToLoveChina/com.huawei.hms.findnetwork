package com.huawei.location.lite.common.plug;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import p209cs.InterfaceC8950f;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes8.dex */
public @interface ProductId {

    @InterfaceC8950f(paths = {"com.huawei.location.common.LocationCommonPluginImpl"})
    public static final int HMS_COMMON = 102;
}
