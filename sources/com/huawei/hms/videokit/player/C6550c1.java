package com.huawei.hms.videokit.player;

import android.content.Context;
import android.database.SQLException;
import android.text.TextUtils;
import com.huawei.hiar.ARImageMetadata;
import com.huawei.hms.network.embedded.C5929g4;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.BindException;
import java.net.SocketTimeoutException;
import java.security.acl.NotOwnerException;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Vector;
import java.util.jar.JarException;

/* renamed from: com.huawei.hms.videokit.player.c1 */
/* loaded from: classes8.dex */
public final class C6550c1 {

    /* renamed from: c */
    private static Context f30348c;

    /* renamed from: e */
    private static String f30350e;

    /* renamed from: h */
    static final Map<Class<?>, String> f30353h;

    /* renamed from: a */
    private static InterfaceC6612z0 f30346a = C6553d1.m37331a();

    /* renamed from: b */
    private static Vector<C6545b1> f30347b = new Vector<>();

    /* renamed from: d */
    private static String f30349d = "";

    /* renamed from: f */
    private static int f30351f = 1;

    /* renamed from: g */
    private static boolean f30352g = false;

    /* renamed from: com.huawei.hms.videokit.player.c1$a */
    public enum a {
        DEBUG(0),
        INFO(1),
        WARN(2),
        ERROR(3),
        CLOSE(10);


        /* renamed from: a */
        private int f30360a;

        a(int i10) {
            this.f30360a = i10;
        }

        /* renamed from: a */
        public int m37267a() {
            return this.f30360a;
        }

        /* renamed from: a */
        public static a m37266a(int i10) {
            for (a aVar : values()) {
                if (aVar.m37267a() == i10) {
                    return aVar;
                }
            }
            return null;
        }
    }

    static {
        HashMap map = new HashMap();
        f30353h = map;
        map.put(FileNotFoundException.class, "file is illegal");
        map.put(JarException.class, "jar exception");
        map.put(MissingResourceException.class, "missing resource");
        map.put(NotOwnerException.class, "not owner exception");
        map.put(ConcurrentModificationException.class, "modification exception");
        map.put(BindException.class, "bind exception");
        map.put(OutOfMemoryError.class, "out of memory");
        map.put(StackOverflowError.class, "stack overflow");
        map.put(SQLException.class, "sql exception");
        map.put(SocketTimeoutException.class, "socket timeout");
    }

    /* renamed from: a */
    public static int m37250a(int i10) {
        if (i10 >= 10 && i10 <= 100) {
            return i10;
        }
        m37256a(f30349d, "Log file number out of range, and value is " + i10);
        return 20;
    }

    /* renamed from: b */
    public static int m37261b(int i10) {
        if (i10 >= 500 && i10 <= 10000) {
            return i10 * 1024;
        }
        m37256a(f30349d, "Log file size out of range, and value is " + i10);
        return ARImageMetadata.SHADING_MODE;
    }

    /* renamed from: c */
    public static int m37263c(int i10) {
        if ((i10 < 0 || i10 > 3) && i10 != 10) {
            return 1;
        }
        return i10;
    }

    /* renamed from: d */
    public static void m37265d(String str, Object obj) {
        InterfaceC6612z0 interfaceC6612z0;
        if (!f30352g) {
            m37257a(str, obj, 2);
        }
        if (f30351f > 2 || (interfaceC6612z0 = f30346a) == null) {
            return;
        }
        interfaceC6612z0.mo37205d(f30349d + str, obj);
    }

    /* renamed from: a */
    public static String m37251a(Context context) throws IOException {
        try {
            String canonicalPath = context.getApplicationContext().getFilesDir().getCanonicalPath();
            String str = canonicalPath + "/videoplayerkit";
            File file = new File(str);
            if (!file.exists()) {
                if (!file.createNewFile()) {
                    return canonicalPath;
                }
            }
            return str;
        } catch (RuntimeException unused) {
            String path = context.getApplicationContext().getFilesDir().getPath();
            return TextUtils.isEmpty(path) ? "" : path;
        } catch (Exception unused2) {
            return "";
        }
    }

    /* renamed from: b */
    public static void m37262b(String str, Object obj) {
        if (f30351f > 3) {
            return;
        }
        Object objM37253a = m37253a(obj);
        if (objM37253a == null) {
            objM37253a = obj;
        }
        if (!f30352g) {
            m37257a(str, obj, 3);
        }
        InterfaceC6612z0 interfaceC6612z0 = f30346a;
        if (interfaceC6612z0 != null) {
            interfaceC6612z0.mo37201a(f30349d + str, objM37253a);
        }
    }

    /* renamed from: c */
    public static void m37264c(String str, Object obj) {
        InterfaceC6612z0 interfaceC6612z0;
        if (!f30352g) {
            m37257a(str, obj, 1);
        }
        if (f30351f > 1 || (interfaceC6612z0 = f30346a) == null) {
            return;
        }
        interfaceC6612z0.mo37203b(f30349d + str, obj);
    }

    /* renamed from: a */
    public static String m37252a(Context context, String str) throws IOException {
        if (context == null) {
            return str;
        }
        String strM37251a = m37251a(context);
        if (TextUtils.isEmpty(str)) {
            return strM37251a;
        }
        try {
            File file = new File(str);
            if (file.exists()) {
                if (file.canWrite()) {
                    return str;
                }
            }
            return strM37251a;
        } catch (Exception e10) {
            m37258a(f30349d, "Check log file path error ", e10);
            return strM37251a;
        }
    }

    /* renamed from: a */
    public static String m37253a(Object obj) {
        if (obj == null) {
            return null;
        }
        for (Map.Entry<Class<?>, String> entry : f30353h.entrySet()) {
            if (entry.getKey().isAssignableFrom(obj.getClass())) {
                return entry.getValue();
            }
        }
        return null;
    }

    /* renamed from: a */
    private static String m37254a(String... strArr) {
        if (strArr == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        for (String str : strArr) {
            if (!C6600t0.m37683c(str)) {
                if (!str.startsWith("/")) {
                    sb2.append(C5929g4.f26852n);
                }
                sb2.append(str);
            }
        }
        return sb2.toString();
    }

    /* renamed from: a */
    private static void m37255a() {
        if (f30347b.size() > 0) {
            Iterator<C6545b1> it = f30347b.iterator();
            while (it.hasNext()) {
                C6545b1 next = it.next();
                int iIntValue = next.m37220a().intValue();
                if (iIntValue == 0) {
                    m37256a(next.m37225c(), next.m37224b());
                } else if (iIntValue == 1) {
                    m37264c(next.m37225c(), next.m37224b());
                } else if (iIntValue == 2) {
                    m37265d(next.m37225c(), next.m37224b());
                } else if (iIntValue == 3) {
                    m37262b(next.m37225c(), next.m37224b());
                }
            }
            f30347b.clear();
        }
    }

    /* renamed from: a */
    public static void m37256a(String str, Object obj) {
        InterfaceC6612z0 interfaceC6612z0;
        if (!f30352g) {
            m37257a(str, obj, 0);
        }
        if (f30351f > 0 || (interfaceC6612z0 = f30346a) == null) {
            return;
        }
        interfaceC6612z0.mo37204c(f30349d + str, obj);
    }

    /* renamed from: a */
    private static void m37257a(String str, Object obj, int i10) {
        if (f30347b.size() >= 200) {
            f30347b.remove(0);
        }
        C6545b1 c6545b1 = new C6545b1();
        c6545b1.m37221a(Integer.valueOf(i10));
        c6545b1.m37223a(str);
        c6545b1.m37222a(obj);
        f30347b.add(c6545b1);
    }

    /* renamed from: a */
    public static void m37258a(String str, Object obj, Throwable th2) {
        if (f30351f > 3) {
            return;
        }
        String strM37253a = m37253a(th2);
        InterfaceC6612z0 interfaceC6612z0 = f30346a;
        if (interfaceC6612z0 != null) {
            if (strM37253a == null) {
                interfaceC6612z0.mo37202a(f30349d + str, obj, th2);
                return;
            }
            interfaceC6612z0.mo37201a(f30349d + str, strM37253a);
        }
    }

    /* renamed from: a */
    public static synchronized boolean m37259a(Context context, String str, String str2, a aVar) {
        return m37260a(context, str, str2, aVar, 5, ARImageMetadata.SHADING_MODE);
    }

    /* renamed from: a */
    public static synchronized boolean m37260a(Context context, String str, String str2, a aVar, int i10, int i11) {
        if (f30352g) {
            m37256a(f30349d, " already init");
            return f30352g;
        }
        f30348c = context;
        if (C6600t0.m37683c(f30349d)) {
            f30349d = str;
        }
        f30350e = str2;
        if (aVar != null) {
            f30351f = aVar.m37267a();
        }
        if (f30351f >= 10) {
            InterfaceC6612z0 interfaceC6612z0 = f30346a;
            if (interfaceC6612z0 != null) {
                interfaceC6612z0.mo37200a();
            }
            f30352g = false;
            return false;
        }
        Context context2 = f30348c;
        String strM37254a = context2 != null ? C6600t0.m37685d(context2).endsWith(":player") ? m37254a(f30350e, "wiseplayer_player_%g.log") : m37254a(f30350e, "wiseplayer_app_%g.log") : null;
        if (C6600t0.m37683c(strM37254a)) {
            f30346a = C6553d1.m37331a();
            f30352g = false;
            return false;
        }
        f30346a = C6553d1.m37332a(strM37254a, i10, i11);
        if (!C6542a1.f30302a) {
            f30352g = false;
            return false;
        }
        f30352g = true;
        m37255a();
        return f30352g;
    }
}
