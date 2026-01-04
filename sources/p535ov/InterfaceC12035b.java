package p535ov;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@InterfaceC12034a
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: ov.b */
/* loaded from: classes9.dex */
public @interface InterfaceC12035b {
    int[] intArr() default {};

    String message() default "";

    String[] strArr() default {};
}
