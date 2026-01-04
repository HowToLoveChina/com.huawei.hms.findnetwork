package p509o4;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p484n4.C11632a;

/* renamed from: o4.d */
/* loaded from: classes.dex */
public final class C11817d {

    /* renamed from: c */
    public static Map<Class<?>, C11632a> f54716c = new HashMap();

    /* renamed from: d */
    public static Map<Class<?>, Object> f54717d = new HashMap();

    /* renamed from: a */
    public Map<Class<?>, C11632a> f54718a = new HashMap();

    /* renamed from: b */
    public Map<Class<?>, Object> f54719b = new HashMap();

    public C11817d(List<C11632a> list, Context context) throws SecurityException {
        m70389c(list, context);
    }

    /* renamed from: a */
    public static Constructor m70387a(Class cls, Class... clsArr) throws SecurityException {
        boolean z10 = false;
        for (Constructor<?> constructor : cls.getDeclaredConstructors()) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes.length == clsArr.length) {
                for (int i10 = 0; i10 < clsArr.length; i10++) {
                    z10 = parameterTypes[i10] == clsArr[i10];
                }
                if (z10) {
                    return constructor;
                }
            }
        }
        return null;
    }

    /* renamed from: b */
    public final void m70388b(String str, Exception exc) {
        Log.e("AGC_ServiceRepository", "Instantiate shared service " + str + exc.getLocalizedMessage());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("cause message:");
        sb2.append(exc.getCause() != null ? exc.getCause().getMessage() : "");
        Log.e("AGC_ServiceRepository", sb2.toString());
    }

    /* renamed from: c */
    public void m70389c(List<C11632a> list, Context context) throws SecurityException {
        Map<Class<?>, C11632a> map;
        String str;
        Log.d("AGC_ServiceRepository", "addService start");
        if (list == null) {
            return;
        }
        for (C11632a c11632a : list) {
            if (c11632a.m69499d()) {
                if (!f54716c.containsKey(c11632a.m69496a())) {
                    map = f54716c;
                }
                if (!c11632a.m69498c() && c11632a.m69497b() != null && !f54717d.containsKey(c11632a.m69496a())) {
                    try {
                        Constructor constructorM70387a = m70387a(c11632a.m69497b(), Context.class);
                        f54717d.put(c11632a.m69496a(), constructorM70387a != null ? constructorM70387a.newInstance(context) : c11632a.m69497b().newInstance());
                    } catch (IllegalAccessException e10) {
                        e = e10;
                        str = "AccessException";
                        m70388b(str, e);
                    } catch (InstantiationException e11) {
                        e = e11;
                        str = "InstantiationException";
                        m70388b(str, e);
                    } catch (InvocationTargetException e12) {
                        e = e12;
                        str = "TargetException";
                        m70388b(str, e);
                    }
                }
            } else {
                map = this.f54718a;
            }
            map.put(c11632a.m69496a(), c11632a);
            if (!c11632a.m69498c()) {
            }
        }
        Log.d("AGC_ServiceRepository", "addService end");
    }
}
