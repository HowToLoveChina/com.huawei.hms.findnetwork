package okhttp3.internal.connection;

import android.os.Build;
import java.net.InetSocketAddress;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: okhttp3.internal.connection.b */
/* loaded from: classes9.dex */
public class C11928b {
    /* renamed from: a */
    public static C11929c m71663a(CopyOnWriteArrayList<InetSocketAddress> copyOnWriteArrayList, int i10, int i11) {
        int iM71664b = m71664b();
        String property = System.getProperty("openConcurrent");
        boolean z10 = property == null || !property.trim().equalsIgnoreCase("false");
        if ((iM71664b < 29 || !z10) && iM71664b < 30) {
            return new C11929c(copyOnWriteArrayList, i10, i11);
        }
        return new C11927a(copyOnWriteArrayList, i10, i11);
    }

    /* renamed from: b */
    public static int m71664b() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (NoClassDefFoundError unused) {
            return 0;
        }
    }
}
