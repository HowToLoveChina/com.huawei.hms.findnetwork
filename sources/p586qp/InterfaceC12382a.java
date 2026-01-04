package p586qp;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: qp.a */
/* loaded from: classes8.dex */
public @interface InterfaceC12382a {
    boolean memoryCache() default false;

    String name() default "";
}
