package p779xl;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import pm.C12197x;
import pm.InterfaceC12198y;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: xl.a */
/* loaded from: classes6.dex */
public @interface InterfaceC13828a {
    Class<? extends InterfaceC12198y> controller() default C12197x.class;
}
