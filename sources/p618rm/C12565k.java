package p618rm;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupRestoreUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.ProgressCallback;
import com.huawei.ark.app.PackageMode;
import com.huawei.ark.os.ArkPlatform;
import com.huawei.ark.os.ArkRuntimeStatus;
import com.huawei.cloud.base.util.C4633d0;
import hk.C10278a;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import p015ak.C0213f;
import p514o9.C11839m;
import p780xm.C13834f;

/* renamed from: rm.k */
/* loaded from: classes6.dex */
public class C12565k {

    /* renamed from: a */
    public static boolean f57906a = false;

    /* renamed from: b */
    public static boolean f57907b = false;

    /* renamed from: c */
    public static volatile boolean f57908c = false;

    /* renamed from: d */
    public static final Object f57909d = new Object();

    /* renamed from: e */
    public static final AtomicBoolean f57910e = new AtomicBoolean(false);

    /* renamed from: f */
    public static long f57911f = -1;

    /* renamed from: g */
    public static long f57912g = -1;

    /* renamed from: b */
    public static String m75516b(String str, boolean z10) throws PackageManager.NameNotFoundException {
        if (!f57907b || !z10) {
            return "";
        }
        try {
            ApplicationInfo applicationInfo = C0213f.m1377a().getPackageManager().getApplicationInfo(str, 128);
            return "ark".equals(applicationInfo.metaData.getString("ohos.ark.flag")) ? applicationInfo.metaData.getString("ohos.ark.bc.version") : "";
        } catch (Exception unused) {
            C11839m.m70689w("CloudBackupArkUtil", "getArkVersion not ark system, appId = " + str);
            return "";
        }
    }

    /* renamed from: c */
    public static PackageMode m75517c(Context context, String str) {
        try {
            return (PackageMode) Class.forName("com.huawei.ark.app.ArkApplicationInfo").getDeclaredMethod("getPackageMode", Context.class, String.class).invoke(null, context, str);
        } catch (Exception unused) {
            C11839m.m70689w("CloudBackupArkUtil", "getPackageMode not ark system, appId = " + str);
            return PackageMode.ANDROID;
        }
    }

    /* renamed from: d */
    public static int m75518d(String str) {
        if (!f57906a && !f57907b) {
            return 0;
        }
        try {
            PackageMode packageModeM75517c = m75517c(C0213f.m1377a(), str);
            if (packageModeM75517c == PackageMode.ARK) {
                return 3;
            }
            if (packageModeM75517c == PackageMode.MIX) {
                return 1;
            }
            return packageModeM75517c == PackageMode.BOTH ? 2 : 0;
        } catch (NoClassDefFoundError unused) {
            C11839m.m70689w("CloudBackupArkUtil", "getRuntimeType not ark system, appId = " + str);
            return 0;
        }
    }

    /* renamed from: e */
    public static void m75519e() {
        if (f57907b) {
            try {
                f57912g = m75531q((String) Class.forName("com.huawei.ark.os.ArkPlatformVersion").getDeclaredMethod("getArkBCMinVersion", new Class[0]).invoke(null, new Object[0]));
            } catch (Exception unused) {
                C11839m.m70689w("CloudBackupArkUtil", "getArkBCMinVersion not ark system");
            }
        }
    }

    /* renamed from: f */
    public static void m75520f() {
        if (f57907b) {
            try {
                f57911f = m75531q((String) Class.forName("com.huawei.ark.os.ArkPlatformVersion").getDeclaredMethod("getArkBCVersion", new Class[0]).invoke(null, new Object[0]));
            } catch (Exception unused) {
                C11839m.m70689w("CloudBackupArkUtil", "getArkBCVersion not ark system");
            }
        }
    }

    /* renamed from: g */
    public static void m75521g() {
        try {
            ArkRuntimeStatus arkRuntimeStatus = ArkPlatform.getArkRuntimeStatus();
            f57906a = arkRuntimeStatus == ArkRuntimeStatus.ABNORMAL || arkRuntimeStatus == ArkRuntimeStatus.NORMAL;
            C11839m.m70688i("CloudBackupArkUtil", "initArkRuntimeSupportedMaple: " + f57906a);
        } catch (NoClassDefFoundError unused) {
            C11839m.m70688i("CloudBackupArkUtil", "getArkRuntimeStatus not ark system.");
        }
    }

    /* renamed from: h */
    public static void m75522h() {
        try {
            f57907b = ((Boolean) Class.forName("com.huawei.ark.os.ArkPlatform").getDeclaredMethod("isArkRuntimeSupported", new Class[0]).invoke(null, new Object[0])).booleanValue();
            C11839m.m70688i("CloudBackupArkUtil", "isArkRuntimeSupportedOHOS: " + f57907b);
        } catch (Exception unused) {
            C11839m.m70688i("CloudBackupArkUtil", "isArkRuntimeSupported not ark system.");
        }
    }

    /* renamed from: i */
    public static void m75523i() {
        C11839m.m70688i("CloudBackupArkUtil", "get pms move dir result start.");
        String str = C0213f.m1377a().getFilesDir() + "";
        BackupRestoreUtil backupRestoreUtil = new BackupRestoreUtil(C0213f.m1377a(), new ProgressCallback(), str);
        String strCheckLocation = backupRestoreUtil.checkLocation(str);
        String str2 = strCheckLocation + "/pmsmove/";
        File fileM63442h = C10278a.m63442h(str2);
        if (!fileM63442h.exists() && !fileM63442h.mkdirs()) {
            C11839m.m70687e("CloudBackupArkUtil", "create des dir error.");
            return;
        }
        try {
            String str3 = strCheckLocation + "/testDir";
            File fileM63442h2 = C10278a.m63442h(str3);
            if (!fileM63442h2.exists() && !fileM63442h2.mkdirs()) {
                C11839m.m70687e("CloudBackupArkUtil", "create res dir error.");
                return;
            }
            File fileM63441g = C10278a.m63441g(fileM63442h2, "file.txt");
            if (!fileM63441g.exists() && !fileM63441g.createNewFile()) {
                C11839m.m70687e("CloudBackupArkUtil", "create res sub file fail.");
                return;
            }
            int iMove = backupRestoreUtil.move(CloudBackupConstant.Command.PMS_OPTION_DIR, str3, str2);
            C11839m.m70688i("CloudBackupArkUtil", "move test dir result: " + iMove);
            if (iMove == 0) {
                f57908c = true;
            }
        } catch (IOException e10) {
            C11839m.m70687e("CloudBackupArkUtil", "create file error: " + e10.toString());
        }
    }

    /* renamed from: j */
    public static void m75524j() {
        C11839m.m70688i("CloudBackupArkUtil", "v3 task start initPmsMoveOrderSupportedAsync.");
        C13834f.m82974k(new Callable() { // from class: rm.j
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return C12565k.m75530p();
            }
        }, null);
    }

    /* renamed from: k */
    public static boolean m75525k() {
        return f57906a;
    }

    /* renamed from: l */
    public static boolean m75526l() {
        return f57907b;
    }

    /* renamed from: m */
    public static boolean m75527m(String str) throws NumberFormatException {
        if (!f57907b || C4633d0.m28404a(str) || f57912g == -1 || f57911f == -1) {
            return false;
        }
        long jM75531q = m75531q(str);
        return jM75531q >= f57912g && jM75531q <= f57911f;
    }

    /* renamed from: n */
    public static boolean m75528n(String str) {
        if (!f57907b) {
            return false;
        }
        try {
            String strName = m75517c(C0213f.m1377a(), str).name();
            if (C4633d0.m28404a(strName)) {
                return false;
            }
            return strName.equals(Class.forName("com.huawei.ark.app.PackageMode").getDeclaredField("OHOS_ARK").getName());
        } catch (Exception | NoClassDefFoundError unused) {
            C11839m.m70689w("CloudBackupArkUtil", "isOHOSArk not ark system, appId = " + str);
            return false;
        }
    }

    /* renamed from: o */
    public static boolean m75529o() {
        boolean z10;
        if (f57908c) {
            return f57908c;
        }
        synchronized (f57909d) {
            try {
                AtomicBoolean atomicBoolean = f57910e;
                if (!atomicBoolean.get()) {
                    m75523i();
                    atomicBoolean.set(true);
                }
                z10 = f57908c;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return z10;
    }

    /* renamed from: p */
    public static /* synthetic */ Void m75530p() throws Exception {
        C11839m.m70688i("CloudBackupArkUtil", "isSupportedMove:" + m75529o());
        return null;
    }

    /* renamed from: q */
    public static long m75531q(String str) throws NumberFormatException {
        if (str == null || str.isEmpty()) {
            return -1L;
        }
        String[] strArrSplit = str.split("\\.");
        if (strArrSplit.length != 4) {
            return -1L;
        }
        long j10 = Long.parseLong(strArrSplit[0]);
        long j11 = Long.parseLong(strArrSplit[1]);
        long j12 = Long.parseLong(strArrSplit[2]);
        long j13 = Long.parseLong(strArrSplit[3]);
        if (j10 >= 512 || j11 >= 512 || j12 >= 512 || j13 >= 512) {
            return -1L;
        }
        return (j10 << 24) + (j11 << 16) + (j12 << 8) + j13;
    }
}
