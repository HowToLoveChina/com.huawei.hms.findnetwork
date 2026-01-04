package androidx.fragment.app;

import androidx.fragment.app.Fragment;
import p438l.C11213g;

/* renamed from: androidx.fragment.app.k */
/* loaded from: classes.dex */
public class C0753k {

    /* renamed from: a */
    public static final C11213g<ClassLoader, C11213g<String, Class<?>>> f4058a = new C11213g<>();

    /* renamed from: b */
    public static boolean m4794b(ClassLoader classLoader, String str) {
        try {
            return Fragment.class.isAssignableFrom(m4795c(classLoader, str));
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* renamed from: c */
    public static Class<?> m4795c(ClassLoader classLoader, String str) throws ClassNotFoundException {
        C11213g<ClassLoader, C11213g<String, Class<?>>> c11213g = f4058a;
        C11213g<String, Class<?>> c11213g2 = c11213g.get(classLoader);
        if (c11213g2 == null) {
            c11213g2 = new C11213g<>();
            c11213g.put(classLoader, c11213g2);
        }
        Class<?> cls = c11213g2.get(str);
        if (cls != null) {
            return cls;
        }
        Class<?> cls2 = Class.forName(str, false, classLoader);
        c11213g2.put(str, cls2);
        return cls2;
    }

    /* renamed from: d */
    public static Class<? extends Fragment> m4796d(ClassLoader classLoader, String str) {
        try {
            return m4795c(classLoader, str);
        } catch (ClassCastException e10) {
            throw new Fragment.C0711h("Unable to instantiate fragment " + str + ": make sure class is a valid subclass of Fragment", e10);
        } catch (ClassNotFoundException e11) {
            throw new Fragment.C0711h("Unable to instantiate fragment " + str + ": make sure class name exists", e11);
        }
    }

    /* renamed from: a */
    public Fragment mo4623a(ClassLoader classLoader, String str) {
        throw null;
    }
}
