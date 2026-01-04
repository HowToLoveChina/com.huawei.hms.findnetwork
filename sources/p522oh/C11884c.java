package p522oh;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mh.C11471d;
import mh.InterfaceC11470c;
import th.C13012a;

/* renamed from: oh.c */
/* loaded from: classes4.dex */
public class C11884c {

    /* renamed from: a */
    public static Map<Class, Object> f54939a;

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        f54939a = concurrentHashMap;
        if (concurrentHashMap.size() <= 0) {
            m71379b(InterfaceC11470c.class, new C11471d());
        }
    }

    /* renamed from: a */
    public static Object m71378a(Class cls) {
        if (cls == null) {
            C13012a.m78317c("MarketInstallApiRegiste", "apiClass can not be null");
            return null;
        }
        Object obj = f54939a.get(cls);
        if (obj == null || !cls.isAssignableFrom(obj.getClass())) {
            return null;
        }
        return obj;
    }

    /* renamed from: b */
    public static boolean m71379b(Class cls, InterfaceC11882a interfaceC11882a) {
        String str;
        if (cls == null) {
            str = "class is null.";
        } else if (interfaceC11882a == null) {
            str = "Impl is null.";
        } else {
            if (cls.isAssignableFrom(interfaceC11882a.getClass())) {
                f54939a.put(cls, interfaceC11882a);
                return true;
            }
            str = "Impl is not extends right class:" + cls + "-" + interfaceC11882a.getClass();
        }
        C13012a.m78317c("MarketInstallApiRegiste", str);
        return false;
    }
}
