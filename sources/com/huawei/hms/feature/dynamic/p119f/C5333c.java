package com.huawei.hms.feature.dynamic.p119f;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupRestoreConstans;
import com.huawei.hms.common.util.Logger;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.huawei.hms.feature.dynamic.f.c */
/* loaded from: classes8.dex */
public class C5333c {

    /* renamed from: a */
    public static final String f24716a = "HMSPkgManager";

    /* renamed from: b */
    public static final List<String> f24717b = new a();

    /* renamed from: c */
    public static final int f24718c = 8;

    /* renamed from: d */
    public static final int f24719d = 4;

    /* renamed from: e */
    public static final int f24720e = 5;

    /* renamed from: com.huawei.hms.feature.dynamic.f.c$a */
    public static class a extends ArrayList<String> {
        public a() {
            add("com.huawei.hwid");
            add("com.huawei.hwid.tv");
        }
    }

    /* renamed from: com.huawei.hms.feature.dynamic.f.c$b */
    public static class b implements PrivilegedAction {

        /* renamed from: a */
        public final /* synthetic */ Field f24721a;

        public b(Field field) {
            this.f24721a = field;
        }

        @Override // java.security.PrivilegedAction
        public Object run() throws SecurityException {
            this.f24721a.setAccessible(true);
            return null;
        }
    }

    /* renamed from: a */
    public static boolean m31892a(Context context) {
        if (context == null) {
            Logger.m30737e(f24716a, "The given context is null.");
            return false;
        }
        for (String str : f24717b) {
            try {
            } catch (PackageManager.NameNotFoundException unused) {
                Logger.m30744w(f24716a, "Query for HMS Core package name:" + str + " failed.");
            }
            if (context.getPackageManager().getPackageInfo(str, 0) != null) {
                Logger.m30740i(f24716a, "The HMS Core is installed, pkgName:" + str);
                return true;
            }
            continue;
        }
        return false;
    }

    /* renamed from: b */
    public static boolean m31894b(Context context, String str) throws IllegalAccessException, NoSuchFieldException, PackageManager.NameNotFoundException, IllegalArgumentException {
        PackageInfo packageInfo;
        ApplicationInfo applicationInfo;
        if (context == null || TextUtils.isEmpty(str)) {
            Logger.m30737e(f24716a, "context is null or pkgName is null.");
            return false;
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (PackageManager.NameNotFoundException e10) {
            Logger.m30737e(f24716a, "get PrivAppFlag err for " + str + ":" + e10.getMessage());
            packageInfo = null;
        }
        if (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null) {
            Logger.m30740i(f24716a, "Get pkg application null:" + str);
            return false;
        }
        try {
            Field field = applicationInfo.getClass().getField("privateFlags");
            AccessController.doPrivileged(new b(field));
            Object obj = field.get(applicationInfo);
            if (!(obj instanceof Integer)) {
                Logger.m30740i(f24716a, "Get privFlag instance error.");
                return false;
            }
            int iIntValue = ((Integer) obj).intValue();
            Logger.m30735d(f24716a, "privFlag of " + str + " is:" + iIntValue);
            boolean z10 = (iIntValue & 8) != 0;
            Logger.m30740i(f24716a, "pkgName:" + str + ", isPrivApp:" + z10);
            return z10;
        } catch (IllegalAccessException | NoSuchFieldException e11) {
            Logger.m30737e(f24716a, "get Priv App Flag err for " + str + ":" + e11.getMessage());
            return false;
        }
    }

    /* renamed from: c */
    public static boolean m31895c(Context context, String str) throws PackageManager.NameNotFoundException {
        if (context == null || TextUtils.isEmpty(str)) {
            Logger.m30744w(f24716a, "context is null or pkgName is null.");
            return false;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
            boolean z10 = (packageInfo == null || (packageInfo.applicationInfo.flags & 1) == 0) ? false : true;
            Logger.m30740i(f24716a, "isHMSSystemApp:" + z10);
            if (z10) {
                Logger.m30740i(f24716a, "The HMS package:" + str + " is SystemApp");
                return true;
            }
        } catch (PackageManager.NameNotFoundException e10) {
            Logger.m30737e(f24716a, "getSystemApp flag error for " + str + ":" + e10.getMessage());
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m31893a(Context context, String str) throws IOException {
        if (context == null || TextUtils.isEmpty(str)) {
            Logger.m30737e(f24716a, "context is null or filePath is null.");
            return false;
        }
        try {
        } catch (IOException unused) {
            Logger.m30737e(f24716a, "checkPathValidity IOException");
        }
        if (!new File(str).exists()) {
            Logger.m30744w(f24716a, "the file does not exist.");
            return false;
        }
        String canonicalPath = new File(str).getCanonicalPath();
        if (canonicalPath.startsWith("/system/app/HFF")) {
            Logger.m30740i(f24716a, "HFF file path, need not to verify.");
            return true;
        }
        if (canonicalPath.startsWith(BackupRestoreConstans.DATA_PATH)) {
            String[] strArrSplit = canonicalPath.split("/");
            if (strArrSplit.length >= 4) {
                return m31894b(context, strArrSplit[3]);
            }
        } else if (canonicalPath.startsWith("/data/user_de/") || canonicalPath.startsWith(BackupRestoreConstans.DATA_USER_PATH)) {
            String[] strArrSplit2 = canonicalPath.split("/");
            if (strArrSplit2.length >= 5) {
                return m31894b(context, strArrSplit2[4]);
            }
        } else {
            Logger.m30744w(f24716a, "illegal path.");
        }
        return false;
    }
}
