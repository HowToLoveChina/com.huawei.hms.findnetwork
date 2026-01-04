package p015ak;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.StatFs;
import android.os.UserManager;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import hk.C10278a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import p035bk.C1249b;
import p229di.C9141f;
import p229di.C9154s;
import p229di.C9155t;
import p229di.C9156u;
import p399jk.AbstractC10896a;
import p815ym.AbstractC14026a;

/* renamed from: ak.j */
/* loaded from: classes6.dex */
public class C0221j {

    /* renamed from: a */
    public static String f821a = null;

    /* renamed from: b */
    public static String f822b = null;

    /* renamed from: c */
    public static String f823c = null;

    /* renamed from: d */
    public static String f824d = null;

    /* renamed from: e */
    public static String f825e = null;

    /* renamed from: f */
    public static String f826f = null;

    /* renamed from: g */
    public static String f827g = null;

    /* renamed from: h */
    public static String f828h = null;

    /* renamed from: i */
    public static boolean f829i = true;

    /* renamed from: j */
    public static boolean f830j = true;

    /* renamed from: k */
    public static final HashMap<String, String> f831k;

    static {
        HashMap<String, String> map = new HashMap<>();
        f831k = map;
        map.put("storHandlerForData", C0220i0.class.getName());
    }

    /* renamed from: A */
    public static String m1473A() {
        return f827g;
    }

    /* renamed from: B */
    public static String m1474B() {
        if (f830j) {
            return (String) m1495e(f827g);
        }
        return null;
    }

    /* renamed from: C */
    public static boolean m1475C(Context context, Handler.Callback callback) {
        m1509s(context);
        return m1496f(callback);
    }

    /* renamed from: D */
    public static void m1476D(Context context) {
        String strM1504n;
        UserManager userManager = (UserManager) context.getSystemService("user");
        List<Object> listM57499d = C9155t.m57499d(userManager);
        if (listM57499d != null) {
            Iterator<Object> it = listM57499d.iterator();
            while (it.hasNext()) {
                int iM57495a = C9154s.m57495a(it.next());
                if (C9141f.m57460a(C9156u.m57500a(userManager, iM57495a))) {
                    AbstractC10896a.m65887i("FileHelper", "clone user id: " + iM57495a);
                    strM1504n = m1504n(iM57495a);
                    AbstractC10896a.m65887i("FileHelper", "appClonePath: " + strM1504n);
                    break;
                }
            }
            strM1504n = null;
        } else {
            strM1504n = null;
        }
        f828h = strM1504n;
    }

    /* renamed from: E */
    public static void m1477E(StorageVolume[] storageVolumeArr) {
        f826f = m1510t(storageVolumeArr);
    }

    /* renamed from: F */
    public static void m1478F(Context context) {
        f830j = true;
        f829i = true;
        m1509s(context);
    }

    /* renamed from: G */
    public static void m1479G(StorageManager storageManager, StorageVolume[] storageVolumeArr) {
        String strM7481d;
        Object objM7479b;
        int length = storageVolumeArr.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                strM7481d = null;
                break;
            }
            StorageVolume storageVolume = storageVolumeArr[i10];
            if (storageVolume.getUuid() != null) {
                File fileM7482e = C1249b.m7482e(storageVolume);
                Object objM7478a = C1249b.m7478a(storageManager, storageVolume.getUuid());
                if (objM7478a != null && (objM7479b = C1249b.m7479b(objM7478a)) != null && !storageVolume.isPrimary() && C1249b.m7485h(objM7479b) && "mounted".equals(Environment.getExternalStorageState(fileM7482e))) {
                    strM7481d = C1249b.m7481d(storageVolume);
                    break;
                }
            }
            i10++;
        }
        f825e = strM7481d;
    }

    /* renamed from: H */
    public static void m1480H(StorageManager storageManager, StorageVolume[] storageVolumeArr) {
        String uuid;
        Object objM7479b;
        String strM7481d = null;
        for (StorageVolume storageVolume : storageVolumeArr) {
            if (("mounted".equals(storageVolume.getState()) || "mounted_ro".equals(storageVolume.getState())) && (uuid = storageVolume.getUuid()) != null && (objM7479b = C1249b.m7479b(C1249b.m7478a(storageManager, uuid))) != null && !C1249b.m7485h(objM7479b) && C1249b.m7486i(objM7479b)) {
                strM7481d = C1249b.m7481d(storageVolume);
            }
        }
        f827g = strM7481d;
    }

    /* renamed from: I */
    public static boolean m1481I(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            AbstractC10896a.m65886e("FileHelper", "isStorageMounted2 mountPath is empty");
            return false;
        }
        if (context == null) {
            AbstractC10896a.m65886e("FileHelper", "isStorageMounted2 context is null");
            return false;
        }
        StorageManager storageManager = (StorageManager) context.getSystemService("storage");
        if (storageManager != null) {
            return "mounted".equals(C1249b.m7484g(storageManager, str));
        }
        AbstractC10896a.m65886e("FileHelper", "isStorageMounted2 storageManager is null");
        return false;
    }

    /* renamed from: J */
    public static String m1482J(String str) {
        return ("A" + str).trim().substring(1);
    }

    /* renamed from: K */
    public static AbstractC0218h0 m1483K(String str) {
        try {
            try {
                return (AbstractC0218h0) Class.forName(f831k.get(str)).newInstance();
            } catch (IllegalAccessException e10) {
                AbstractC10896a.m65886e("FileHelper", "IllegalAccessException occour" + e10.toString());
                return null;
            } catch (InstantiationException e11) {
                AbstractC10896a.m65886e("FileHelper", "InstantiationException occour" + e11.toString());
                return null;
            }
        } catch (ClassNotFoundException e12) {
            AbstractC10896a.m65886e("FileHelper", "Exception occour" + e12.toString());
            return null;
        }
    }

    /* renamed from: L */
    public static AbstractC0218h0 m1484L(String str, String str2, String str3) {
        String str4 = str + File.separator + str2;
        AbstractC0218h0 abstractC0218h0M1483K = m1483K(str3);
        if (abstractC0218h0M1483K == null || abstractC0218h0M1483K.mo1457f(str4)) {
            return abstractC0218h0M1483K;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0035  */
    /* renamed from: M */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static p015ak.AbstractC0218h0 m1485M(java.lang.String r1, java.lang.String r2, java.lang.String r3, java.lang.String r4, java.lang.String r5, android.os.Handler.Callback r6) {
        /*
            ak.h0 r5 = m1483K(r5)
            if (r5 == 0) goto L36
            r0 = 0
            java.lang.String r1 = m1508r(r1, r2, r3, r4)     // Catch: java.lang.Exception -> L1a
            if (r1 == 0) goto L35
            boolean r3 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Exception -> L1a
            if (r3 != 0) goto L35
            boolean r1 = r5.mo1457f(r1)     // Catch: java.lang.Exception -> L1a
            if (r1 != 0) goto L36
            goto L35
        L1a:
            r1 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Exception occour"
            r3.append(r4)
            java.lang.String r1 = r1.toString()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            java.lang.String r3 = "FileHelper"
            p399jk.AbstractC10896a.m65886e(r3, r1)
        L35:
            r5 = r0
        L36:
            if (r5 != 0) goto L3e
            r1 = 11
            r3 = 0
            m1491a(r6, r1, r3, r3, r2)
        L3e:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p015ak.C0221j.m1485M(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, android.os.Handler$Callback):ak.h0");
    }

    /* renamed from: N */
    public static boolean m1486N(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return m1481I(str, context);
    }

    /* renamed from: O */
    public static void m1487O(List<Integer> list) {
        if (AbstractC14026a.m84159a(list)) {
            AbstractC10896a.m65888w("FileHelper", "refreshAppClonePath, but cloneUserIds is empty.");
            return;
        }
        if (list.get(0) == null) {
            AbstractC10896a.m65888w("FileHelper", "refreshAppClonePath, but clonedUserId is null.");
            return;
        }
        int iIntValue = list.get(0).intValue();
        AbstractC10896a.m65887i("FileHelper", "refreshAppClonePath, current user is: " + iIntValue);
        f828h = m1504n(iIntValue);
    }

    /* renamed from: P */
    public static String m1488P(String str, String str2) {
        return (!TextUtils.isEmpty(str) && C0209d.m1179I1() && str.startsWith(m1512v())) ? str.replaceAll("[\\\\:*?<>\"|]", str2) : str;
    }

    /* renamed from: Q */
    public static String m1489Q(String[] strArr) throws IOException {
        return m1490R(strArr, null);
    }

    /* renamed from: R */
    public static String m1490R(String[] strArr, String str) throws IOException {
        StringBuilder sb2 = new StringBuilder();
        boolean z10 = false;
        for (String str2 : strArr) {
            if (str2 != null) {
                if (z10) {
                    sb2.append(File.separator);
                }
                sb2.append(m1482J(str2));
                File fileM63442h = C10278a.m63442h(sb2.toString());
                if (!fileM63442h.exists() && !fileM63442h.mkdirs()) {
                    throw new IOException("create fileDir: " + fileM63442h.getPath() + " failed");
                }
                z10 = true;
            }
        }
        if (str != null) {
            sb2.append(File.separator + str);
        }
        if (sb2.length() < 1) {
            return null;
        }
        return sb2.toString();
    }

    /* renamed from: a */
    public static boolean m1491a(Handler.Callback callback, int i10, int i11, int i12, Object obj) {
        if (callback == null) {
            return false;
        }
        return callback.handleMessage(Message.obtain(null, i10, i11, i12, obj));
    }

    /* renamed from: b */
    public static boolean m1492b(String str, Handler.Callback callback) {
        try {
            String strM1489Q = m1489Q(new String[]{str});
            try {
                long jM1502l = m1502l(strM1489Q);
                if (jM1502l >= 10485760) {
                    return true;
                }
                long jM1516z = m1516z(strM1489Q);
                AbstractC10896a.m65886e("FileHelper", "SDcard available size is not enough = " + String.valueOf(jM1502l >> 20) + "M");
                m1491a(callback, 15, (int) (jM1502l / 1048576), (int) (jM1516z / 1048576), strM1489Q);
                return false;
            } catch (Exception e10) {
                AbstractC10896a.m65886e("FileHelper", "checkAvailableSize error: " + e10.toString());
                m1491a(callback, 67, 0, 0, null);
                return false;
            }
        } catch (IOException e11) {
            AbstractC10896a.m65886e("FileHelper", "checkAvailableSize: " + e11.toString());
            m1491a(callback, 11, 0, 0, str);
            return false;
        }
    }

    /* renamed from: c */
    public static void m1493c(long j10, long j11, Context context) {
        f829i = true;
        f830j = true;
        if (m1486N(f825e, context)) {
            try {
                long jM1502l = m1502l(f825e);
                if (j10 > jM1502l) {
                    f829i = false;
                }
                AbstractC10896a.m65887i("FileHelper", "checkAvailableSizeForRestore sdCardNeedSize = " + j10 + " ,availableSize = " + jM1502l);
            } catch (Exception e10) {
                AbstractC10896a.m65886e("FileHelper", "checkAvailableSizeForRestore sd error e = " + e10.toString());
            }
        } else {
            f829i = false;
        }
        if (m1486N(f827g, context)) {
            try {
                long jM1502l2 = m1502l(f827g);
                if (j11 > jM1502l2) {
                    f830j = false;
                }
                AbstractC10896a.m65887i("FileHelper", "checkAvailableSizeForRestore uDiskNeedSize = " + j11 + " ,availableSize = " + jM1502l2);
            } catch (Exception e11) {
                AbstractC10896a.m65886e("FileHelper", "checkAvailableSizeForRestore uDisk error e = " + e11.toString());
            }
        } else {
            f830j = false;
        }
        AbstractC10896a.m65887i("FileHelper", "checkAvailableSizeForRestore uDiskAvailable = " + f830j + " ,sdCardAvailable = " + f829i);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0089  */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m1494d(java.lang.String r4, java.lang.String r5) {
        /*
            java.io.File r4 = hk.C10278a.m63442h(r4)
            boolean r0 = r4.exists()
            if (r0 != 0) goto Lb
            return
        Lb:
            java.io.File[] r4 = r4.listFiles()
            r0 = 0
        L10:
            if (r4 == 0) goto L92
            int r1 = r4.length
            if (r0 >= r1) goto L92
            r1 = r4[r0]
            java.lang.String r1 = r1.getName()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r5)
            java.lang.String r3 = ".db"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L89
            r1 = r4[r0]
            java.lang.String r1 = r1.getName()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r5)
            java.lang.String r3 = ".db-shm"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L89
            r1 = r4[r0]
            java.lang.String r1 = r1.getName()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r5)
            java.lang.String r3 = ".db-wal"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L89
            r1 = r4[r0]
            java.lang.String r1 = r1.getName()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r5)
            java.lang.String r3 = "Res.zip"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L8e
        L89:
            r1 = r4[r0]
            m1498h(r1)
        L8e:
            int r0 = r0 + 1
            goto L10
        L92:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p015ak.C0221j.m1494d(java.lang.String, java.lang.String):void");
    }

    /* renamed from: e */
    public static <T> T m1495e(T t10) {
        return t10;
    }

    /* renamed from: f */
    public static boolean m1496f(Handler.Callback callback) {
        boolean zM1497g;
        String str;
        String str2;
        boolean z10;
        String str3 = f826f;
        if (str3 == null || !m1492b(str3, null)) {
            String str4 = f825e;
            if (str4 == null || !m1492b(str4, null)) {
                f824d = null;
                f825e = null;
                f826f = null;
                f821a = null;
                f822b = null;
                f823c = null;
            } else {
                f824d = f825e;
            }
        } else {
            f824d = f826f;
        }
        String strM1192N = C0209d.m1192N();
        String lowerCase = C0209d.m1269j1() ? TextUtils.isEmpty(strM1192N) ? "honor" : strM1192N.toLowerCase(Locale.ENGLISH) : "huawei";
        String str5 = f824d;
        if (str5 != null) {
            zM1497g = m1497g(str5, lowerCase);
            f821a = f824d + File.separator + lowerCase + "/HwCloud/sysdata";
        } else {
            zM1497g = false;
        }
        if (f825e == null) {
            str = null;
        } else {
            str = f825e + File.separator + lowerCase + "/HwCloud/media";
        }
        f822b = str;
        if (f826f == null) {
            str2 = null;
        } else {
            str2 = f826f + File.separator + lowerCase + "/HwCloud/media";
        }
        f823c = str2;
        if (f824d == null) {
            m1491a(callback, 15, 0, 0, null);
            z10 = false;
        } else {
            z10 = true;
        }
        if (zM1497g) {
            return z10;
        }
        m1491a(callback, 1202, 0, 0, null);
        return false;
    }

    /* renamed from: g */
    public static boolean m1497g(String str, String str2) {
        try {
            StringBuilder sb2 = new StringBuilder();
            String str3 = File.separator;
            sb2.append(str3);
            sb2.append(str2);
            sb2.append("/HwCloud");
            m1489Q(new String[]{str, sb2.toString()});
            m1489Q(new String[]{str + str3 + str2 + "/HwCloud", "/sysdata"});
            m1489Q(new String[]{str + str3 + str2 + "/HwCloud", "/media"});
            m1489Q(new String[]{str + str3 + str2 + "/HwCloud", "/app"});
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    /* renamed from: h */
    public static boolean m1498h(File file) {
        File[] fileArrM63440f;
        if (file == null || !file.exists()) {
            return true;
        }
        if (file.isDirectory() && (fileArrM63440f = C10278a.m63440f(file)) != null) {
            for (File file2 : fileArrM63440f) {
                m1498h(file2);
            }
        }
        return file.delete();
    }

    /* renamed from: i */
    public static boolean m1499i(String str) {
        if (str == null) {
            return false;
        }
        return m1498h(C10278a.m63442h(str));
    }

    /* renamed from: j */
    public static String m1500j(int i10) {
        if (i10 > 100 || i10 < 0) {
            i10 = 0;
        }
        return NumberFormat.getPercentInstance().format(new BigDecimal(i10).divide(new BigDecimal(100.0d)));
    }

    /* renamed from: k */
    public static String m1501k() {
        return (String) m1495e(f828h);
    }

    /* renamed from: l */
    public static long m1502l(String str) throws Exception {
        StatFs statFs = new StatFs(str);
        return statFs.getAvailableBlocks() * statFs.getBlockSize();
    }

    /* renamed from: m */
    public static long m1503m(String str) {
        long availableBlocks = 0;
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        try {
            StatFs statFs = new StatFs(str);
            availableBlocks = statFs.getAvailableBlocks() * statFs.getBlockSize();
            AbstractC10896a.m65888w("FileHelper", "getAvailableStorageSpace" + availableBlocks);
            return availableBlocks;
        } catch (IllegalArgumentException e10) {
            AbstractC10896a.m65886e("FileHelper", "getAvailableStorageSpace: " + e10.toString());
            return availableBlocks;
        }
    }

    /* renamed from: n */
    public static String m1504n(int i10) {
        return SplitAppUtil.STORAGE_EMULATED + i10;
    }

    /* renamed from: o */
    public static String m1505o() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            return Environment.getExternalStorageDirectory().getPath();
        }
        return null;
    }

    /* renamed from: p */
    public static long m1506p(File file) {
        if (file == null) {
            return 0L;
        }
        if (file.isFile()) {
            return m1507q(file);
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return 0L;
        }
        int iM1507q = 0;
        for (File file2 : fileArrListFiles) {
            iM1507q = (int) (iM1507q + m1507q(file2));
        }
        return iM1507q;
    }

    /* renamed from: q */
    public static long m1507q(File file) throws IOException {
        if (file == null) {
            AbstractC10896a.m65887i("FileHelper", "getFileSize file is null");
            return 0L;
        }
        FileInputStream fileInputStreamM63444j = null;
        try {
            try {
                try {
                    fileInputStreamM63444j = C10278a.m63444j(file);
                    int iAvailable = fileInputStreamM63444j.available();
                    try {
                        fileInputStreamM63444j.close();
                    } catch (IOException e10) {
                        AbstractC10896a.m65886e("FileHelper", "getFileSize Exception = " + e10.toString());
                    }
                    return iAvailable;
                } catch (FileNotFoundException unused) {
                    AbstractC10896a.m65886e("FileHelper", "getFileSize FileNotFoundException");
                    if (fileInputStreamM63444j != null) {
                        try {
                            fileInputStreamM63444j.close();
                        } catch (IOException e11) {
                            AbstractC10896a.m65886e("FileHelper", "getFileSize Exception = " + e11.toString());
                        }
                    }
                    return 0L;
                }
            } catch (IOException e12) {
                AbstractC10896a.m65886e("FileHelper", "getFileSize Exception = " + e12.toString());
                if (fileInputStreamM63444j != null) {
                    try {
                        fileInputStreamM63444j.close();
                    } catch (IOException e13) {
                        AbstractC10896a.m65886e("FileHelper", "getFileSize Exception = " + e13.toString());
                    }
                }
                return 0L;
            }
        } catch (Throwable th2) {
            if (fileInputStreamM63444j != null) {
                try {
                    fileInputStreamM63444j.close();
                } catch (IOException e14) {
                    AbstractC10896a.m65886e("FileHelper", "getFileSize Exception = " + e14.toString());
                }
            }
            throw th2;
        }
    }

    /* renamed from: r */
    public static String m1508r(String str, String str2, String str3, String str4) throws IOException {
        return m1490R(new String[]{str, str3, str2}, str4);
    }

    /* renamed from: s */
    public static void m1509s(Context context) {
        StorageManager storageManager = context != null ? (StorageManager) context.getSystemService("storage") : null;
        if (storageManager == null) {
            AbstractC10896a.m65886e("FileHelper", "storageManager is null");
            return;
        }
        StorageVolume[] storageVolumeArrM7483f = C1249b.m7483f(storageManager);
        m1479G(storageManager, storageVolumeArrM7483f);
        m1477E(storageVolumeArrM7483f);
        m1480H(storageManager, storageVolumeArrM7483f);
        m1476D(context);
        AbstractC10896a.m65887i("FileHelper", "getICSStoragePath locationSdcard = " + f825e + " ,locationPcard = " + f826f + " ,uDiskStoragePath = " + f827g + ", appClonePath = " + f828h);
    }

    /* renamed from: t */
    public static String m1510t(StorageVolume[] storageVolumeArr) {
        for (StorageVolume storageVolume : storageVolumeArr) {
            if (storageVolume.isPrimary() && storageVolume.isEmulated()) {
                return C1249b.m7481d(storageVolume);
            }
        }
        return "";
    }

    /* renamed from: u */
    public static String m1511u(Context context) {
        StorageVolume[] storageVolumeArrM7483f;
        if (context == null) {
            context = C0213f.m1377a();
        }
        StorageManager storageManager = context != null ? (StorageManager) context.getSystemService("storage") : null;
        if (storageManager == null || (storageVolumeArrM7483f = C1249b.m7483f(storageManager)) == null || storageVolumeArrM7483f.length == 0) {
            return "/storage/emulated/0";
        }
        String strM1510t = m1510t(storageVolumeArrM7483f);
        return TextUtils.isEmpty(strM1510t) ? "/storage/emulated/0" : strM1510t;
    }

    /* renamed from: v */
    public static String m1512v() {
        return (String) m1495e(f826f);
    }

    /* renamed from: w */
    public static String m1513w() {
        return (String) m1495e(f825e);
    }

    /* renamed from: x */
    public static String m1514x() {
        if (f829i) {
            return (String) m1495e(f825e);
        }
        return null;
    }

    /* renamed from: y */
    public static String m1515y() {
        return (String) m1495e(f821a);
    }

    /* renamed from: z */
    public static long m1516z(String str) {
        StatFs statFs = new StatFs(str);
        return statFs.getBlockCount() * statFs.getBlockSize();
    }
}
