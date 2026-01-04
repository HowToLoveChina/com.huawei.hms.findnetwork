package p640sq;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: sq.a */
/* loaded from: classes8.dex */
public final class C12822a {

    /* renamed from: a */
    public static final String f58536a = "a";

    /* renamed from: c */
    public static Context f58538c;

    /* renamed from: b */
    public static ConcurrentHashMap<String, String> f58537b = new ConcurrentHashMap<>();

    /* renamed from: d */
    public static Handler f58539d = new a(Looper.myLooper());

    /* renamed from: sq.a$a */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1001) {
                return;
            }
            C12836o.m77097b(C12822a.f58536a, "download succ,begining copy", true);
            C12822a.m76975g(C12822a.m76972d(), C12822a.m76973e(), (String) message.obj);
        }
    }

    /* renamed from: d */
    public static String m76972d() {
        try {
            return f58538c.getDir("hwId", 0).getCanonicalPath() + "/";
        } catch (IOException e10) {
            C12836o.m77099d(f58536a, "IOException:" + e10.getClass().getSimpleName(), true);
            return "";
        }
    }

    /* renamed from: e */
    public static String m76973e() {
        try {
            return f58538c.getDir("hw", 0).getCanonicalPath() + "/";
        } catch (IOException e10) {
            C12836o.m77099d(f58536a, "IOException:" + e10.getClass().getSimpleName(), true);
            return "";
        }
    }

    /* renamed from: f */
    public static ConcurrentHashMap<String, String> m76974f() {
        return f58537b;
    }

    /* renamed from: g */
    public static void m76975g(String str, String str2, String str3) {
        C12836o.m77097b(f58536a, "handlerRequestCopyData", true);
        throw null;
    }
}
