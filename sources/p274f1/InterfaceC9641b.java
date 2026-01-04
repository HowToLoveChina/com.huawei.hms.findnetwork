package p274f1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import p323h1.EnumC10078b;
import p381j1.EnumC10653e1;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: f1.b */
/* loaded from: classes.dex */
public @interface InterfaceC9641b {
    String[] alternateNames() default {};

    String defaultValue() default "";

    boolean deserialize() default true;

    Class<?> deserializeUsing() default Void.class;

    String format() default "";

    boolean jsonDirect() default false;

    String label() default "";

    String name() default "";

    int ordinal() default 0;

    EnumC10078b[] parseFeatures() default {};

    boolean serialize() default true;

    Class<?> serializeUsing() default Void.class;

    EnumC10653e1[] serialzeFeatures() default {};

    boolean unwrapped() default false;
}
