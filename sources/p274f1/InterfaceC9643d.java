package p274f1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import p244e1.EnumC9389m;
import p323h1.C10085i;
import p323h1.EnumC10078b;
import p381j1.EnumC10653e1;
import p381j1.InterfaceC10644b1;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: f1.d */
/* loaded from: classes.dex */
public @interface InterfaceC9643d {
    boolean alphabetic() default true;

    boolean asm() default true;

    Class<? extends C10085i.c> autoTypeCheckHandler() default C10085i.c.class;

    Class<?> builder() default Void.class;

    Class<?> deserializer() default Void.class;

    String[] ignores() default {};

    String[] includes() default {};

    Class<?> mappingTo() default Void.class;

    EnumC9389m naming() default EnumC9389m.NeverUseThisValueExceptDefaultValue;

    String[] orders() default {};

    EnumC10078b[] parseFeatures() default {};

    Class<?>[] seeAlso() default {};

    boolean serializeEnumAsJavaBean() default false;

    Class<?> serializer() default Void.class;

    EnumC10653e1[] serialzeFeatures() default {};

    Class<? extends InterfaceC10644b1>[] serialzeFilters() default {};

    String typeKey() default "";

    String typeName() default "";
}
