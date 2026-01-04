package p626ry;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

/* renamed from: ry.a */
/* loaded from: classes9.dex */
public class C12652a {

    /* renamed from: a */
    public static final a f58121a = new a();

    /* renamed from: ry.a$a */
    public static class a implements Serializable {
        private static final long serialVersionUID = 7092611880189329093L;

        private Object readResolve() {
            return C12652a.f58121a;
        }
    }

    /* renamed from: a */
    public static boolean m76179a(Object obj) {
        return obj != null && obj.getClass().isArray();
    }

    /* renamed from: b */
    public static boolean m76180b(Object obj) {
        if (obj == null) {
            return true;
        }
        if (obj instanceof CharSequence) {
            return ((CharSequence) obj).length() == 0;
        }
        if (m76179a(obj)) {
            return Array.getLength(obj) == 0;
        }
        if (obj instanceof Collection) {
            return ((Collection) obj).isEmpty();
        }
        if (obj instanceof Map) {
            return ((Map) obj).isEmpty();
        }
        if (obj instanceof Optional) {
            return !((Optional) obj).isPresent();
        }
        return false;
    }
}
