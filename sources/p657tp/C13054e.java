package p657tp;

import com.google.gson.JsonSyntaxException;
import java.util.Locale;
import p371ik.C10527a;
import p639sp.C12820a;
import p639sp.C12821b;
import p686up.InterfaceC13233a;

/* renamed from: tp.e */
/* loaded from: classes8.dex */
public class C13054e {
    /* renamed from: a */
    public static void m78775a() {
        try {
            C13053d.m78770i().m78762a();
        } catch (C12820a e10) {
            throw new C12821b(e10.getMessage());
        }
    }

    /* renamed from: b */
    public static void m78776b(Class cls) throws C12821b {
        if (!InterfaceC13233a.class.isAssignableFrom(cls)) {
            throw new C12821b(String.format(Locale.ENGLISH, "Input className:%s is not configurable!", cls.getSimpleName()));
        }
        try {
            C13053d.m78770i().m78763b(cls);
        } catch (C12820a e10) {
            throw new C12821b(e10.getMessage());
        }
    }

    /* renamed from: c */
    public static String m78777c(Class cls) throws C12821b {
        if (!InterfaceC13233a.class.isAssignableFrom(cls)) {
            throw new C12821b(String.format(Locale.ENGLISH, "Input className:%s is not configurable!", cls.getSimpleName()));
        }
        try {
            return C10527a.m64633k(C13053d.m78770i().m78764c(cls));
        } catch (C12820a e10) {
            throw new C12821b(e10.getMessage());
        }
    }

    /* renamed from: d */
    public static void m78778d(Class cls, String str) throws C12821b {
        if (!InterfaceC13233a.class.isAssignableFrom(cls)) {
            throw new C12821b(String.format(Locale.ENGLISH, "Input className:%s is not configurable!", cls.getSimpleName()));
        }
        try {
            C13053d.m78770i().m78766e(cls, str);
        } catch (JsonSyntaxException | C12820a e10) {
            throw new C12821b(e10.getMessage());
        }
    }
}
