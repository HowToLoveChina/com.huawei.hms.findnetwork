package p274f1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: f1.c */
/* loaded from: classes.dex */
public @interface InterfaceC9642c {
    String buildMethod() default "build";

    String withPrefix() default "with";
}
