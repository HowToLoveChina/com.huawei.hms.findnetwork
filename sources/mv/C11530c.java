package mv;

import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import p374iv.C10624c;

/* renamed from: mv.c */
/* loaded from: classes9.dex */
public class C11530c {

    /* renamed from: a */
    public static volatile C11530c f53483a;

    public C11530c() throws IllegalAccessException, C10624c, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        m68819b();
    }

    /* renamed from: a */
    public static C11530c m68818a() throws C10624c {
        if (f53483a == null) {
            synchronized (C11530c.class) {
                try {
                    if (f53483a == null) {
                        f53483a = new C11530c();
                    }
                } finally {
                }
            }
        }
        return f53483a;
    }

    /* renamed from: b */
    public final void m68819b() throws IllegalAccessException, C10624c, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            Method method = Class.forName("com.huawei.security.keystore.HwUniversalKeyStoreProvider").getMethod(JsbMapKeyNames.H5_TEXT_DOWNLOAD_INSTALL, new Class[0]);
            method.setAccessible(true);
            method.invoke(null, new Object[0]);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e10) {
            throw new C10624c("install HwKeyStore fail:" + e10.getMessage());
        }
    }
}
