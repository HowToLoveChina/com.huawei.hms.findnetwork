package p209cs;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: cs.f */
/* loaded from: classes8.dex */
public @interface InterfaceC8950f {
    String[] paths() default {};
}
