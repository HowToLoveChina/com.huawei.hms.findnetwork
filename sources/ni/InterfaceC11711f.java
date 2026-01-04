package ni;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: ni.f */
/* loaded from: classes.dex */
public @interface InterfaceC11711f {

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    /* renamed from: ni.f$a */
    public @interface a {
        String key();

        Class<?> ref();
    }

    a[] typeDefinitions();
}
