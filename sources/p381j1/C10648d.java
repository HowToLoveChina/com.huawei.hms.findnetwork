package p381j1;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Map;
import p244e1.AbstractC9377a;
import p244e1.C9380d;
import p244e1.C9381e;

/* renamed from: j1.d */
/* loaded from: classes.dex */
public class C10648d implements InterfaceC10686t0 {

    /* renamed from: a */
    public static volatile Class f51183a = null;

    /* renamed from: b */
    public static volatile boolean f51184b = false;

    /* renamed from: c */
    public static volatile Method f51185c;

    /* renamed from: d */
    public static volatile Method f51186d;

    /* renamed from: e */
    public static C10648d f51187e = new C10648d();

    @Override // p381j1.InterfaceC10686t0
    /* renamed from: e */
    public void mo63933e(C10664i0 c10664i0, Object obj, Object obj2, Type type, int i10) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        C9380d c9380d;
        Class<?>[] interfaces = obj.getClass().getInterfaces();
        if (interfaces.length == 1 && interfaces[0].isAnnotation()) {
            Class<?> cls = interfaces[0];
            if (f51183a == null && !f51184b) {
                try {
                    f51183a = Class.forName("sun.reflect.annotation.AnnotationType");
                } finally {
                }
            }
            if (f51183a == null) {
                throw new C9380d("not support Type Annotation.");
            }
            if (f51185c == null && !f51184b) {
                try {
                    f51185c = f51183a.getMethod("getInstance", Class.class);
                } finally {
                }
            }
            if (f51186d == null && !f51184b) {
                try {
                    f51186d = f51183a.getMethod("members", new Class[0]);
                } finally {
                }
            }
            if (f51185c == null || f51184b) {
                throw new C9380d("not support Type Annotation.");
            }
            try {
                Object objInvoke = null;
                try {
                    Map map = (Map) f51186d.invoke(f51185c.invoke(null, cls), new Object[0]);
                    C9381e c9381e = new C9381e(map.size());
                    for (Map.Entry entry : map.entrySet()) {
                        try {
                            objInvoke = ((Method) entry.getValue()).invoke(obj, new Object[0]);
                        } catch (IllegalAccessException | InvocationTargetException unused) {
                        }
                        c9381e.put((String) entry.getKey(), AbstractC9377a.m58772u(objInvoke));
                    }
                    c10664i0.m65262G(c9381e);
                } finally {
                }
            } finally {
            }
        }
    }
}
