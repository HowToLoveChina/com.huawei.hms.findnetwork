package p443l4;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import p417k4.InterfaceC10985d;
import p469m4.C11403d;

@Deprecated
/* renamed from: l4.a */
/* loaded from: classes.dex */
public abstract class AbstractC11229a implements InterfaceC10985d {

    /* renamed from: a */
    public static final Map<String, AbstractC11229a> f52739a = new HashMap();

    /* renamed from: b */
    public static final Object f52740b = new Object();

    /* renamed from: d */
    public static AbstractC11229a m67436d(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        return m67437e(context, context.getPackageName());
    }

    /* renamed from: e */
    public static AbstractC11229a m67437e(Context context, String str) {
        AbstractC11229a c11403d;
        synchronized (f52740b) {
            try {
                Map<String, AbstractC11229a> map = f52739a;
                c11403d = map.get(str);
                if (c11403d == null) {
                    c11403d = new C11403d(context, str);
                    map.put(str, c11403d);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c11403d;
    }
}
