package com.huawei.android.backup.service.logic;

import com.huawei.android.backup.filelogic.utils.C2110c;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.filelogic.utils.PmsCheckUtil;
import java.io.IOException;

/* renamed from: com.huawei.android.backup.service.logic.a */
/* loaded from: classes.dex */
public abstract class AbstractC2124a extends BackupObject {

    /* renamed from: a */
    public static C2110c f9587a = null;

    /* renamed from: b */
    public static int f9588b = 4;

    /* renamed from: a */
    public static void m12749a() throws IOException {
        C2110c c2110c = f9587a;
        if (c2110c == null) {
            f9588b = 4;
        } else if (!c2110c.m12632c()) {
            f9588b = 4;
        } else {
            f9587a.m12633d();
            f9588b = 1;
        }
    }

    /* renamed from: b */
    public static int m12750b() throws InterruptedException {
        m12754f();
        C2111d.m12654j("BackupObjectFileBackup", "wait for install finished: ", Integer.valueOf(f9588b));
        return f9588b;
    }

    /* renamed from: c */
    public static int m12751c() throws InterruptedException {
        if (PmsCheckUtil.m12611e()) {
            C2111d.m12653i("BackupObjectFileBackup", "This is support PMS");
            return 1;
        }
        m12754f();
        int i10 = f9588b;
        if (i10 == 1) {
            C2111d.m12654j("BackupObjectFileBackup", "support, flag: ", Integer.valueOf(i10));
            return 1;
        }
        C2111d.m12654j("BackupObjectFileBackup", "unsupport, flag: ", Integer.valueOf(i10));
        return -1;
    }

    /* renamed from: d */
    public static void m12752d() throws IOException {
        C2111d.m12653i("BackupObjectFileBackup", "initSocketSupport start");
        if (f9588b == 4) {
            f9587a = new C2110c();
        }
        m12749a();
        f9587a = null;
        if (f9588b == 1) {
            C2111d.m12653i("BackupObjectFileBackup", "LOCAL_SOCKET_SUPPORT is true");
        } else {
            f9588b = 3;
        }
    }

    /* renamed from: e */
    public static boolean m12753e() {
        return f9588b != 4;
    }

    /* renamed from: f */
    public static void m12754f() throws InterruptedException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        while (!m12753e() && System.currentTimeMillis() - jCurrentTimeMillis <= 10000) {
            try {
                Thread.sleep(5L);
            } catch (InterruptedException e10) {
                C2111d.m12649e("BackupObjectFileBackup", "Sleep Failed at:", e10.getMessage());
                return;
            }
        }
    }
}
