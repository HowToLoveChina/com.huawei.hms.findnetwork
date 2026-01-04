package p668u4;

import com.huawei.android.backup.filelogic.utils.C2111d;
import p699v4.C13346o;

/* renamed from: u4.a */
/* loaded from: classes.dex */
public class C13122a extends C13346o {

    /* renamed from: b */
    public static C13122a f59622b;

    public C13122a() {
        super(5, 8, 100);
    }

    /* renamed from: d */
    public static synchronized C13122a m78920d() {
        try {
            if (f59622b == null) {
                C2111d.m12653i("AppLoadThreadExecutor", "new Instance");
                f59622b = new C13122a();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f59622b;
    }

    /* renamed from: e */
    public static synchronized void m78921e() {
        if (f59622b != null) {
            C2111d.m12653i("AppLoadThreadExecutor", "release instance");
            f59622b.m80076b();
            f59622b = null;
        }
    }
}
