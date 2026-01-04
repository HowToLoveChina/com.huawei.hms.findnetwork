package com.huawei.cloud.base.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: com.huawei.cloud.base.util.p */
/* loaded from: classes.dex */
public @interface InterfaceC4648p {
    String value() default "##default";
}
