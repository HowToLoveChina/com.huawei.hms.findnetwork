package p015ak;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.StatFs;
import android.os.storage.StorageManager;
import android.text.TextUtils;
import com.hihonor.android.util.SystemInfo;
import com.huawei.android.os.BuildEx;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;
import p399jk.AbstractC10896a;

/* renamed from: ak.n */
/* loaded from: classes6.dex */
public class C0229n {

    /* renamed from: a */
    public static final boolean f850a;

    /* renamed from: b */
    public static final boolean f851b;

    /* renamed from: c */
    public static final long f852c;

    /* renamed from: d */
    public static final String[] f853d;

    static {
        f850a = C0209d.m1277l1() || BuildEx.VERSION.EMUI_SDK_INT >= 17;
        boolean z10 = C0209d.m1277l1() || BuildEx.VERSION.EMUI_SDK_INT >= 14;
        f851b = z10;
        f852c = z10 ? 4000000000L : 4294967296L;
        f853d = new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"};
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m1602a(android.view.View r5, android.content.Context r6, int r7, int r8, int r9) throws android.content.res.Resources.NotFoundException {
        /*
            java.lang.String r0 = "HiDiskCommonUtil"
            if (r6 != 0) goto La
            java.lang.String r5 = "agingCheckBoxConfig context is null"
            p399jk.AbstractC10896a.m65887i(r0, r5)
            return
        La:
            android.content.res.Resources r1 = r6.getResources()
            if (r1 != 0) goto L16
            java.lang.String r5 = "agingCheckBoxConfig res is null"
            p399jk.AbstractC10896a.m65887i(r0, r5)
            return
        L16:
            boolean r0 = r5 instanceof android.widget.TextView
            r2 = 0
            if (r0 == 0) goto L1f
            r0 = r5
            android.widget.TextView r0 = (android.widget.TextView) r0
            goto L20
        L1f:
            r0 = r2
        L20:
            boolean r3 = r5 instanceof android.widget.Button
            if (r3 == 0) goto L27
            r2 = r5
            android.widget.Button r2 = (android.widget.Button) r2
        L27:
            float r5 = p015ak.C0209d.m1195O(r6)
            r3 = 1071644672(0x3fe00000, float:1.75)
            int r3 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            r4 = 1073741824(0x40000000, float:2.0)
            if (r3 < 0) goto L3d
            int r3 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r3 >= 0) goto L3d
            float r5 = r1.getDimension(r7)
        L3b:
            int r5 = (int) r5
            goto L4e
        L3d:
            int r5 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r5 != 0) goto L46
            float r5 = r1.getDimension(r8)
            goto L3b
        L46:
            if (r5 <= 0) goto L4d
            float r5 = r1.getDimension(r9)
            goto L3b
        L4d:
            r5 = 0
        L4e:
            float r7 = (float) r5
            int r6 = m1609h(r6, r7)
            if (r5 <= 0) goto L62
            r5 = 1
            if (r0 == 0) goto L5c
            float r7 = (float) r6
            r0.setTextSize(r5, r7)
        L5c:
            if (r2 == 0) goto L62
            float r6 = (float) r6
            r2.setTextSize(r5, r6)
        L62:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p015ak.C0229n.m1602a(android.view.View, android.content.Context, int, int, int):void");
    }

    /* renamed from: b */
    public static long m1603b(long j10) {
        long j11 = f852c;
        while (j10 > (3 * j11) / 2) {
            j11 *= 2;
        }
        return j11;
    }

    /* renamed from: c */
    public static String m1604c(String str, String str2, String str3) {
        if (!TextUtils.equals(Locale.getDefault().getLanguage(), str3) || str == null || !str.contains(str2)) {
            return str;
        }
        return str.replace(str2, "\u202a" + str2 + "\u202c");
    }

    /* renamed from: d */
    public static long m1605d(String str) {
        long blockSizeLong = 0;
        if (!m1608g(f853d)) {
            AbstractC10896a.m65888w("HiDiskCommonUtil", "has no storage permission");
            return 0L;
        }
        if (str == null || str.startsWith("/ui_smb_root")) {
            return 0L;
        }
        try {
            StatFs statFs = new StatFs(str);
            blockSizeLong = statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong();
            AbstractC10896a.m65888w("HiDiskCommonUtil", "getAvailableStorageSpace" + blockSizeLong);
            return blockSizeLong;
        } catch (IllegalArgumentException e10) {
            AbstractC10896a.m65886e("HiDiskCommonUtil", "getAvailableStorageSpace: " + e10.toString());
            return blockSizeLong;
        }
    }

    /* renamed from: e */
    public static String m1606e() {
        long jLongValue;
        String strValueOf;
        AbstractC10896a.m65887i("HiDiskCommonUtil", "IS_MORE_P_VERSION int = " + Build.VERSION.SDK_INT);
        if (f850a) {
            try {
                StorageManager storageManager = (StorageManager) C0213f.m1377a().getSystemService("storage");
                jLongValue = ((Long) storageManager.getClass().getDeclaredMethod("getPrimaryStorageSize", new Class[0]).invoke(storageManager, new Object[0])).longValue();
            } catch (IllegalAccessException e10) {
                AbstractC10896a.m65886e("HiDiskCommonUtil", "getTotalStorage  IllegalAccessException  " + e10.toString());
                jLongValue = 0;
                AbstractC10896a.m65887i("HiDiskCommonUtil", "size --> " + jLongValue);
                strValueOf = String.valueOf(jLongValue);
                AbstractC10896a.m65887i("HiDiskCommonUtil", "totalStorageString  = " + strValueOf);
                return strValueOf;
            } catch (NoSuchMethodException e11) {
                AbstractC10896a.m65886e("HiDiskCommonUtil", "getTotalStorage  NoSuchMethodException  " + e11.toString());
                jLongValue = 0;
                AbstractC10896a.m65887i("HiDiskCommonUtil", "size --> " + jLongValue);
                strValueOf = String.valueOf(jLongValue);
                AbstractC10896a.m65887i("HiDiskCommonUtil", "totalStorageString  = " + strValueOf);
                return strValueOf;
            } catch (InvocationTargetException e12) {
                AbstractC10896a.m65886e("HiDiskCommonUtil", "getTotalStorage  InvocationTargetException  " + e12.toString());
                jLongValue = 0;
                AbstractC10896a.m65887i("HiDiskCommonUtil", "size --> " + jLongValue);
                strValueOf = String.valueOf(jLongValue);
                AbstractC10896a.m65887i("HiDiskCommonUtil", "totalStorageString  = " + strValueOf);
                return strValueOf;
            }
            AbstractC10896a.m65887i("HiDiskCommonUtil", "size --> " + jLongValue);
            strValueOf = String.valueOf(jLongValue);
        } else {
            strValueOf = C0209d.m1277l1() ? SystemInfo.getDeviceEmmc() : com.huawei.android.util.SystemInfo.getDeviceEmmc();
        }
        AbstractC10896a.m65887i("HiDiskCommonUtil", "totalStorageString  = " + strValueOf);
        return strValueOf;
    }

    /* renamed from: f */
    public static long m1607f(String str) {
        int i10 = f851b ? 1000 : 1024;
        if (str == null) {
            return 0L;
        }
        try {
            if (str.isEmpty()) {
                return 0L;
            }
            long jM1688f = C0241z.m1688f(str);
            if (!f850a) {
                jM1688f *= i10;
            }
            return m1603b(jM1688f);
        } catch (NumberFormatException e10) {
            AbstractC10896a.m65885d("getTotalStorageSummary", e10.toString());
            return 0L;
        }
    }

    /* renamed from: g */
    public static boolean m1608g(String... strArr) {
        for (String str : strArr) {
            if (C0213f.m1377a().checkSelfPermission(str) != 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: h */
    public static int m1609h(Context context, float f10) {
        Resources resources;
        if (context == null || (resources = context.getResources()) == null) {
            return 0;
        }
        return (int) Math.ceil(f10 / resources.getDisplayMetrics().density);
    }
}
