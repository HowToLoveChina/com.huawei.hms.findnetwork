package p618rm;

import android.os.Message;
import com.huawei.android.hicloud.cloudbackup.callable.CBCallBack;
import com.huawei.cloud.base.util.C4633d0;
import hk.C10278a;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import p015ak.C0221j;
import p514o9.C11839m;

/* renamed from: rm.m */
/* loaded from: classes6.dex */
public class C12571m {

    /* renamed from: a */
    public static final Object f57919a = new Object();

    /* renamed from: b */
    public static final Object f57920b = new Object();

    /* renamed from: c */
    public static volatile Map<String, a> f57921c = new HashMap();

    /* renamed from: d */
    public static ExecutorService f57922d = Executors.newFixedThreadPool(1);

    /* renamed from: rm.m$a */
    public static class a implements Runnable {

        /* renamed from: a */
        public String f57923a;

        public a(String str) {
            this.f57923a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                C11839m.m70686d("CloudBackupFileDelete", "file delete start, path = " + this.f57923a);
                boolean zM1499i = C0221j.m1499i(this.f57923a);
                C11839m.m70686d("CloudBackupFileDelete", "file delete end, path = " + this.f57923a + ", result = " + zM1499i);
                if (!zM1499i) {
                    C11839m.m70686d("CloudBackupFileDelete", "file delete retry start, path = " + this.f57923a);
                    boolean zM1499i2 = C0221j.m1499i(this.f57923a);
                    C11839m.m70686d("CloudBackupFileDelete", "file delete retry end, path = " + this.f57923a + ", result = " + zM1499i2);
                    if (!zM1499i2) {
                        Message messageObtain = Message.obtain();
                        messageObtain.what = 9009;
                        messageObtain.obj = this.f57923a;
                        CBCallBack.getInstance().sendMessage(messageObtain);
                    }
                }
                synchronized (C12571m.f57920b) {
                    C12571m.m75546h(this.f57923a);
                    C12571m.f57920b.notifyAll();
                }
            } catch (Throwable th2) {
                synchronized (C12571m.f57920b) {
                    C12571m.m75546h(this.f57923a);
                    C12571m.f57920b.notifyAll();
                    throw th2;
                }
            }
        }
    }

    /* renamed from: c */
    public static void m75541c(String str) {
        synchronized (f57919a) {
            try {
                if (f57921c.containsKey(str)) {
                    C11839m.m70686d("CloudBackupFileDelete", "delete task already exist, path = " + str);
                } else {
                    a aVar = new a(str);
                    f57921c.put(str, aVar);
                    f57922d.execute(aVar);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: d */
    public static void m75542d(String str) {
        if (!C4633d0.m28404a(str) && C10278a.m63442h(str).exists()) {
            m75545g();
            m75541c(str);
        }
    }

    /* renamed from: e */
    public static void m75543e(String str) {
        C11839m.m70686d("CloudBackupFileDelete", "file delete sync await start, path = " + str);
        synchronized (f57920b) {
            while (m75544f()) {
                try {
                    f57920b.wait(400L);
                } catch (InterruptedException e10) {
                    C11839m.m70686d("CloudBackupFileDelete", "file delete sync await error, " + e10.toString());
                }
            }
        }
        C11839m.m70686d("CloudBackupFileDelete", "file delete sync await end, path = " + str);
    }

    /* renamed from: f */
    public static boolean m75544f() {
        boolean z10;
        synchronized (f57919a) {
            z10 = !f57921c.isEmpty();
        }
        return z10;
    }

    /* renamed from: g */
    public static synchronized void m75545g() {
        try {
            if (f57922d.isShutdown() || f57922d.isTerminated()) {
                f57922d = Executors.newFixedThreadPool(1);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: h */
    public static void m75546h(String str) {
        synchronized (f57919a) {
            f57921c.remove(str);
        }
    }

    /* renamed from: i */
    public static void m75547i(String str) {
        m75542d(str);
        m75543e(str);
    }
}
