package com.huawei.openalliance.p169ad;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.TYPE, ElementType.METHOD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: com.huawei.openalliance.ad.kl */
/* loaded from: classes8.dex */
public @interface InterfaceC7365kl {
    /* renamed from: a */
    String m45451a() default "";

    /* renamed from: b */
    boolean m45452b() default false;
}
