package p823yv;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p374iv.C10626e;
import p535ov.InterfaceC12034a;
import p535ov.InterfaceC12047n;

/* renamed from: yv.c */
/* loaded from: classes9.dex */
public class C14048c {

    /* renamed from: a */
    public final String f62839a;

    /* renamed from: b */
    public final Field f62840b;

    /* renamed from: c */
    public final List<C14047b> f62841c = new ArrayList();

    /* renamed from: d */
    public C14046a f62842d;

    public C14048c(String str, Field field) throws C10626e, SecurityException {
        this.f62839a = str;
        this.f62840b = field;
        field.setAccessible(true);
        for (Annotation annotation : field.getDeclaredAnnotations()) {
            if (((InterfaceC12034a) annotation.annotationType().getAnnotation(InterfaceC12034a.class)) != null) {
                if (annotation.annotationType() != InterfaceC12047n.class) {
                    this.f62841c.add(new C14047b(m84256a(), annotation, field.getType()));
                } else {
                    this.f62842d = new C14046a(str, field.getType());
                }
            }
        }
    }

    /* renamed from: a */
    public final String m84256a() {
        return this.f62839a + "." + this.f62840b.getName();
    }

    /* renamed from: b */
    public boolean m84257b() {
        return this.f62841c.size() > 0 || this.f62842d != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: c */
    public <T> void m84258c(T t10) throws IllegalAccessException, C10626e, IllegalArgumentException {
        try {
            Object obj = this.f62840b.get(t10);
            Iterator<C14047b> it = this.f62841c.iterator();
            while (it.hasNext()) {
                it.next().m84255a(obj);
            }
            C14046a c14046a = this.f62842d;
            if (c14046a != 0) {
                c14046a.m84254c(obj);
            }
        } catch (IllegalAccessException e10) {
            throw new C10626e("field validate failed:" + e10.getMessage());
        }
    }
}
