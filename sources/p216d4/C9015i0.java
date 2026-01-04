package p216d4;

import android.content.Context;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: d4.i0 */
/* loaded from: classes.dex */
public class C9015i0 {

    /* renamed from: b */
    public static final Object f45649b = new Object();

    /* renamed from: c */
    public static volatile C9015i0 f45650c;

    /* renamed from: a */
    public Map<String, C9013h0> f45651a = new ConcurrentHashMap();

    /* renamed from: d */
    public static C9015i0 m56922d() {
        if (f45650c == null) {
            synchronized (f45649b) {
                try {
                    if (f45650c == null) {
                        f45650c = new C9015i0();
                    }
                } finally {
                }
            }
        }
        return f45650c;
    }

    /* renamed from: a */
    public C9013h0 m56923a(Context context, String str) {
        C9013h0 c9013h0 = this.f45651a.get(str);
        if (c9013h0 == null) {
            synchronized (f45649b) {
                try {
                    c9013h0 = this.f45651a.get(str);
                    if (c9013h0 == null) {
                        c9013h0 = new C9013h0(context, str, 60000L);
                        this.f45651a.put(str, c9013h0);
                    }
                } finally {
                }
            }
        }
        c9013h0.m56904w();
        return c9013h0;
    }

    /* renamed from: b */
    public void m56924b() {
        for (Map.Entry<String, C9013h0> entry : this.f45651a.entrySet()) {
            String key = entry.getKey();
            if (entry.getValue().m56905x()) {
                this.f45651a.remove(key);
            }
        }
    }

    /* renamed from: c */
    public void m56925c(C9013h0 c9013h0) {
        if (c9013h0 == null) {
            return;
        }
        c9013h0.m56903v();
    }
}
