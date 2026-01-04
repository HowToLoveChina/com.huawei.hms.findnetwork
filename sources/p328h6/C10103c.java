package p328h6;

import android.content.Context;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.tarhelp.TarFilesThread;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import p359i6.C10447c;
import p359i6.InterfaceC10445a;
import p699v4.C13345n;

/* renamed from: h6.c */
/* loaded from: classes.dex */
public class C10103c implements InterfaceC10445a {

    /* renamed from: c */
    public static String f49298c;

    /* renamed from: d */
    public static String[] f49299d;

    /* renamed from: j */
    public static volatile C10103c f49305j;

    /* renamed from: a */
    public int f49307a = -1;

    /* renamed from: b */
    public Set<String> f49308b = new HashSet();

    /* renamed from: e */
    public static TarFilesThread[] f49300e = new TarFilesThread[1];

    /* renamed from: f */
    public static Map<String, ConcurrentLinkedQueue<C10107g>> f49301f = new HashMap();

    /* renamed from: g */
    public static final Map<String, Integer> f49302g = new HashMap();

    /* renamed from: h */
    public static Map<String, Integer> f49303h = new HashMap(9);

    /* renamed from: i */
    public static Map<String, Integer> f49304i = new HashMap(9);

    /* renamed from: k */
    public static boolean f49306k = false;

    public C10103c(Context context) {
        if (context == null) {
            C2111d.m12648d("ProcessTarManager", "context is null");
            return;
        }
        m62922i(context.getApplicationContext().getFilesDir() + "/FtpTemp" + File.separator + "tarmediacache");
        m62921h(context);
        m62926j(context);
        C10447c.m64245a().m64247c(this);
    }

    /* renamed from: c */
    public static String[] m62918c() {
        return (String[]) f49299d.clone();
    }

    /* renamed from: e */
    public static String m62919e() {
        return f49298c;
    }

    /* renamed from: g */
    public static C10103c m62920g(Context context) {
        if (f49305j == null) {
            synchronized (C10103c.class) {
                try {
                    if (f49305j == null) {
                        f49305j = new C10103c(context);
                    }
                } finally {
                }
            }
        }
        return f49305j;
    }

    /* renamed from: h */
    public static void m62921h(Context context) {
        f49299d = C13345n.m80071j(context.getApplicationContext());
    }

    /* renamed from: i */
    public static void m62922i(String str) {
        f49298c = str;
    }

    @Override // p359i6.InterfaceC10445a
    /* renamed from: a */
    public boolean mo12820a(int i10) throws SecurityException, IllegalArgumentException {
        C2111d.m12646b("ProcessTarManager", "setWeight:AdjustThreadPriority weight is " + i10);
        boolean z10 = false;
        for (TarFilesThread tarFilesThread : f49300e) {
            if (tarFilesThread != null && tarFilesThread.isAlive()) {
                C10101a.m62912b().m62914c(tarFilesThread.m13112f(), i10);
                z10 = true;
            }
        }
        return z10;
    }

    /* renamed from: b */
    public boolean m62923b(String str, C10107g c10107g) {
        if (c10107g == null) {
            return false;
        }
        f49301f.get(str).offer(c10107g);
        m62927k(str);
        return true;
    }

    /* renamed from: d */
    public int m62924d(String str) {
        int iIntValue;
        synchronized (f49303h) {
            iIntValue = f49303h.get(str).intValue();
        }
        return iIntValue;
    }

    /* renamed from: f */
    public boolean m62925f(String str) {
        return this.f49308b.contains(str);
    }

    /* renamed from: j */
    public final void m62926j(Context context) {
        if (f49306k) {
            C2111d.m12653i("ProcessTarManager", "[dftpTar] use dftp tar, don't use local tar");
            return;
        }
        C2111d.m12646b("ProcessTarManager", "start TarThread");
        try {
            TarFilesThread tarFilesThread = f49300e[0];
            if (tarFilesThread == null || !tarFilesThread.m13113g()) {
                f49300e[0] = new TarFilesThread(context);
                f49300e[0].start();
            }
        } catch (IllegalThreadStateException unused) {
            C2111d.m12648d("ProcessTarManager", "startTarThread IllegalThreadStateException");
        }
    }

    /* renamed from: k */
    public final void m62927k(String str) {
        Map<String, Integer> map = f49302g;
        if (map != null) {
            synchronized (map) {
                try {
                    if (map.get(str) != null) {
                        map.put(str, Integer.valueOf(r0.intValue() - 1));
                    }
                } finally {
                }
            }
        }
    }
}
