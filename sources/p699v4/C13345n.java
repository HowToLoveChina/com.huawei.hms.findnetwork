package p699v4;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.text.TextUtils;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupRestoreConstans;
import java.io.File;
import p728w4.C13527a;
import p728w4.C13528b;
import p728w4.C13529c;

/* renamed from: v4.n */
/* loaded from: classes.dex */
public final class C13345n {

    /* renamed from: a */
    public static final int f60172a = C13342k.m80055d(C13529c.m81423a("ro.build.version.sdk"));

    /* renamed from: a */
    public static String m80062a(Context context, String str) {
        String strM80072k = m80072k(context, 2);
        if (TextUtils.isEmpty(strM80072k)) {
            C2111d.m12648d("StorageVolumeUtil", "obbData rootPath is null.");
            return "";
        }
        String str2 = strM80072k + "/Android/obb/" + str;
        C2111d.m12646b("StorageVolumeUtil", "obbData path is " + str2);
        return str2;
    }

    /* renamed from: b */
    public static String m80063b(Context context) {
        if (context == null) {
            return null;
        }
        return m80072k(context, 2) + "/Huawei/CloudClone/temp";
    }

    /* renamed from: c */
    public static long m80064c(String str) {
        StatFs statFs = new StatFs(str);
        return statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong();
    }

    /* renamed from: d */
    public static String m80065d(Context context) {
        if (context == null) {
            C2111d.m12648d("StorageVolumeUtil", "PMSbackupRestoreUtil context is null");
            return null;
        }
        return context.getFilesDir() + File.separator + "tarappcache";
    }

    /* renamed from: e */
    public static String m80066e() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            return Environment.getExternalStorageDirectory().getPath();
        }
        return null;
    }

    @TargetApi(24)
    /* renamed from: f */
    public static String[] m80067f(Context context) {
        if (context == null) {
            return new String[0];
        }
        StorageManager storageManager = (StorageManager) context.getSystemService("storage");
        if (storageManager == null) {
            return new String[0];
        }
        StorageVolume[] storageVolumeArrM81419d = C13528b.m81419d(storageManager);
        if (storageVolumeArrM81419d == null) {
            return new String[0];
        }
        String[] strArr = new String[3];
        for (StorageVolume storageVolume : storageVolumeArrM81419d) {
            if (storageVolume != null && "mounted".equals(C13528b.m81420e(storageManager, C13528b.m81418c(storageVolume)))) {
                if (storageVolume.isRemovable()) {
                    String strM81418c = C13528b.m81418c(storageVolume);
                    if (!TextUtils.isEmpty(strM81418c)) {
                        if (strM81418c.contains("usb")) {
                            strArr[2] = C13528b.m81418c(storageVolume);
                        } else {
                            strArr[1] = C13528b.m81418c(storageVolume);
                        }
                    }
                } else {
                    strArr[0] = C13528b.m81418c(storageVolume);
                }
            }
        }
        return strArr;
    }

    /* renamed from: g */
    public static String[] m80068g(Context context) {
        if (context == null) {
            return new String[0];
        }
        StorageManager storageManager = (StorageManager) context.getSystemService("storage");
        if (storageManager == null) {
            return new String[0];
        }
        StorageVolume[] storageVolumeArrM81419d = C13528b.m81419d(storageManager);
        return storageVolumeArrM81419d == null ? new String[0] : m80069h(storageManager, storageVolumeArrM81419d);
    }

    @TargetApi(24)
    /* renamed from: h */
    public static String[] m80069h(StorageManager storageManager, StorageVolume[] storageVolumeArr) {
        String[] strArr = new String[3];
        for (StorageVolume storageVolume : storageVolumeArr) {
            if (storageVolume != null) {
                boolean zIsPrimary = storageVolume.isPrimary();
                boolean zIsRemovable = storageVolume.isRemovable();
                if (zIsPrimary) {
                    String str = strArr[0];
                    if (str == null || str.isEmpty()) {
                        strArr[0] = C13528b.m81418c(storageVolume);
                    }
                } else {
                    m80073l(storageManager, zIsRemovable, strArr, storageVolume);
                }
            }
        }
        return strArr;
    }

    /* renamed from: i */
    public static String m80070i(Context context) {
        if (context == null) {
            C2111d.m12648d("StorageVolumeUtil", "PMSbackupRestoreUtil context is null");
            return null;
        }
        return BackupRestoreConstans.DATA_PATH + context.getPackageName() + "/files/clone/";
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0010 A[PHI: r1
  0x0010: PHI (r1v4 java.lang.String[]) = (r1v2 java.lang.String[]), (r1v5 java.lang.String[]) binds: [B:10:0x001b, B:5:0x000e] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String[] m80071j(android.content.Context r3) {
        /*
            r0 = 3
            java.lang.String[] r0 = new java.lang.String[r0]
            int r1 = p699v4.C13345n.f60172a
            r2 = 23
            if (r1 < r2) goto L12
            java.lang.String[] r1 = m80068g(r3)
            int r2 = r1.length
            if (r2 <= 0) goto L25
        L10:
            r0 = r1
            goto L25
        L12:
            r2 = 14
            if (r1 < r2) goto L1e
            java.lang.String[] r1 = m80067f(r3)
            int r2 = r1.length
            if (r2 <= 0) goto L25
            goto L10
        L1e:
            r1 = 0
            java.lang.String r2 = m80066e()
            r0[r1] = r2
        L25:
            boolean r3 = com.huawei.android.backup.filelogic.utils.C2108a.m12622h(r3)
            if (r3 == 0) goto L32
            r3 = 1
            r1 = 0
            r0[r3] = r1
            r3 = 2
            r0[r3] = r1
        L32:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p699v4.C13345n.m80071j(android.content.Context):java.lang.String[]");
    }

    /* renamed from: k */
    public static String m80072k(Context context, int i10) {
        String[] strArrM80071j = m80071j(context);
        if (i10 == 2) {
            return strArrM80071j[0];
        }
        if (i10 == 3) {
            return strArrM80071j[1];
        }
        if (i10 != 4) {
            return null;
        }
        return strArrM80071j[2];
    }

    /* renamed from: l */
    public static void m80073l(StorageManager storageManager, boolean z10, String[] strArr, StorageVolume storageVolume) {
        String uuid;
        C13527a c13527aM81416a;
        C13527a c13527aM81417b;
        if (!z10 || (uuid = storageVolume.getUuid()) == null || (c13527aM81416a = C13528b.m81416a(storageManager, uuid)) == null || c13527aM81416a.m81413g() == null || (c13527aM81417b = C13528b.m81417b(c13527aM81416a)) == null || c13527aM81417b.m81413g() == null) {
            return;
        }
        if (C13528b.m81421f(c13527aM81417b)) {
            String str = strArr[1];
            if (str == null || str.isEmpty()) {
                strArr[1] = C13528b.m81418c(storageVolume);
                return;
            }
            return;
        }
        if (!C13528b.m81422g(c13527aM81417b)) {
            C2111d.m12657m("StorageVolumeUtil", "unknown type disk");
            return;
        }
        String str2 = strArr[2];
        if (str2 == null || str2.isEmpty()) {
            strArr[2] = C13528b.m81418c(storageVolume);
        }
    }

    /* renamed from: m */
    public static boolean m80074m(Context context, int i10) {
        boolean zIsEmpty;
        String[] strArrM80071j = m80071j(context);
        if (i10 != 2) {
            if (i10 != 3) {
                if (i10 != 4 || strArrM80071j.length <= 2) {
                    return false;
                }
                zIsEmpty = TextUtils.isEmpty(strArrM80071j[2]);
            } else {
                if (strArrM80071j.length <= 1) {
                    return false;
                }
                zIsEmpty = TextUtils.isEmpty(strArrM80071j[1]);
            }
        } else {
            if (strArrM80071j.length <= 0) {
                return false;
            }
            zIsEmpty = TextUtils.isEmpty(strArrM80071j[0]);
        }
        return !zIsEmpty;
    }
}
