package pw;

import p593qw.C12421a;
import p692uw.C13267j;
import rw.C12633a;

/* renamed from: pw.b */
/* loaded from: classes9.dex */
public final class C12240b {

    /* renamed from: a */
    public static final C12239a f56629a;

    static {
        C12239a c12239a;
        Object objNewInstance;
        try {
            objNewInstance = C12633a.class.newInstance();
            C13267j.m79676d(objNewInstance, "forName(\"kotlin.internal…entations\").newInstance()");
            try {
                try {
                } catch (ClassCastException e10) {
                    ClassLoader classLoader = objNewInstance.getClass().getClassLoader();
                    ClassLoader classLoader2 = C12239a.class.getClassLoader();
                    if (C13267j.m79673a(classLoader, classLoader2)) {
                        throw e10;
                    }
                    throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader + ", base type classloader: " + classLoader2, e10);
                }
            } catch (ClassNotFoundException unused) {
                Object objNewInstance2 = C12421a.class.newInstance();
                C13267j.m79676d(objNewInstance2, "forName(\"kotlin.internal…entations\").newInstance()");
                try {
                    try {
                        if (objNewInstance2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                        }
                        c12239a = (C12239a) objNewInstance2;
                    } catch (ClassNotFoundException unused2) {
                        c12239a = new C12239a();
                    }
                } catch (ClassCastException e11) {
                    ClassLoader classLoader3 = objNewInstance2.getClass().getClassLoader();
                    ClassLoader classLoader4 = C12239a.class.getClassLoader();
                    if (C13267j.m79673a(classLoader3, classLoader4)) {
                        throw e11;
                    }
                    throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader3 + ", base type classloader: " + classLoader4, e11);
                }
            }
        } catch (ClassNotFoundException unused3) {
            Object objNewInstance3 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
            C13267j.m79676d(objNewInstance3, "forName(\"kotlin.internal…entations\").newInstance()");
            try {
                try {
                    if (objNewInstance3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                    c12239a = (C12239a) objNewInstance3;
                } catch (ClassNotFoundException unused4) {
                    Object objNewInstance4 = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
                    C13267j.m79676d(objNewInstance4, "forName(\"kotlin.internal…entations\").newInstance()");
                    try {
                        if (objNewInstance4 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                        }
                        c12239a = (C12239a) objNewInstance4;
                    } catch (ClassCastException e12) {
                        ClassLoader classLoader5 = objNewInstance4.getClass().getClassLoader();
                        ClassLoader classLoader6 = C12239a.class.getClassLoader();
                        if (C13267j.m79673a(classLoader5, classLoader6)) {
                            throw e12;
                        }
                        throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader5 + ", base type classloader: " + classLoader6, e12);
                    }
                }
            } catch (ClassCastException e13) {
                ClassLoader classLoader7 = objNewInstance3.getClass().getClassLoader();
                ClassLoader classLoader8 = C12239a.class.getClassLoader();
                if (C13267j.m79673a(classLoader7, classLoader8)) {
                    throw e13;
                }
                throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader7 + ", base type classloader: " + classLoader8, e13);
            }
        }
        if (objNewInstance == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
        }
        c12239a = (C12239a) objNewInstance;
        f56629a = c12239a;
    }
}
