package p368ih;

import android.content.Context;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;

/* renamed from: ih.c */
/* loaded from: classes4.dex */
public class C10504c {

    /* renamed from: a */
    public static final Map<Integer, Class<? extends AbstractC10506e>> f50667a;

    /* renamed from: b */
    public static AbstractC10506e f50668b;

    static {
        HashMap map = new HashMap();
        f50667a = map;
        map.put(3, C10502a.class);
        map.put(1, C10508g.class);
        map.put(2, C10509h.class);
        map.put(0, C10507f.class);
        map.put(4, C10507f.class);
        map.put(7, C10503b.class);
    }

    /* renamed from: a */
    public static synchronized AbstractC10506e m64588a(Context context) {
        AbstractC10506e abstractC10506e = f50668b;
        if (abstractC10506e != null) {
            return abstractC10506e;
        }
        Log.i("DeviceImplFactory", "deviceType: " + C10505d.m64589a(context));
        Class<? extends AbstractC10506e> cls = f50667a.get(Integer.valueOf(C10505d.m64589a(context)));
        if (cls == null) {
            C10507f c10507f = new C10507f();
            f50668b = c10507f;
            return c10507f;
        }
        try {
            f50668b = cls.newInstance();
        } catch (Throwable unused) {
            f50668b = new C10507f();
            Log.e("DeviceImplFactory", "createDeviceInfo error and create default phone deviceinfo");
        }
        return f50668b;
    }
}
