package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import kw.C11177h;
import kw.C11185l;
import kw.C11186m;
import p692uw.C13267j;

/* renamed from: androidx.lifecycle.a0 */
/* loaded from: classes.dex */
public final class C0778a0 {

    /* renamed from: a */
    public static final List<Class<?>> f4138a = C11186m.m67177g(Application.class, C0806v.class);

    /* renamed from: b */
    public static final List<Class<?>> f4139b = C11185l.m67172b(C0806v.class);

    /* renamed from: c */
    public static final <T> Constructor<T> m4913c(Class<T> cls, List<? extends Class<?>> list) throws SecurityException {
        C13267j.m79677e(cls, "modelClass");
        C13267j.m79677e(list, "signature");
        Object[] constructors = cls.getConstructors();
        C13267j.m79676d(constructors, "modelClass.constructors");
        for (Object obj : constructors) {
            Constructor<T> constructor = (Constructor<T>) obj;
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            C13267j.m79676d(parameterTypes, "constructor.parameterTypes");
            List listM67154n = C11177h.m67154n(parameterTypes);
            if (C13267j.m79673a(list, listM67154n)) {
                return constructor;
            }
            if (list.size() == listM67154n.size() && listM67154n.containsAll(list)) {
                throw new UnsupportedOperationException("Class " + cls.getSimpleName() + " must have parameters in the proper order: " + list);
            }
        }
        return null;
    }

    /* renamed from: d */
    public static final <T extends AbstractC0780b0> T m4914d(Class<T> cls, Constructor<T> constructor, Object... objArr) {
        C13267j.m79677e(cls, "modelClass");
        C13267j.m79677e(constructor, "constructor");
        C13267j.m79677e(objArr, "params");
        try {
            return constructor.newInstance(Arrays.copyOf(objArr, objArr.length));
        } catch (IllegalAccessException e10) {
            throw new RuntimeException("Failed to access " + cls, e10);
        } catch (InstantiationException e11) {
            throw new RuntimeException("A " + cls + " cannot be instantiated.", e11);
        } catch (InvocationTargetException e12) {
            throw new RuntimeException("An exception happened in constructor of " + cls, e12.getCause());
        }
    }
}
