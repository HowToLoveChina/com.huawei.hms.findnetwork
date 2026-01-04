package com.huawei.openalliance.p169ad.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: com.huawei.openalliance.ad.annotations.h */
/* loaded from: classes8.dex */
public @interface InterfaceC6936h {
    /* renamed from: a */
    boolean m39226a() default true;

    /* renamed from: b */
    Class m39227b() default Void.class;

    /* renamed from: c */
    int m39228c() default 0;

    /* renamed from: d */
    String m39229d() default "";

    /* renamed from: e */
    int[] m39230e() default {0, 100};

    /* renamed from: f */
    int m39231f() default 0;
}
