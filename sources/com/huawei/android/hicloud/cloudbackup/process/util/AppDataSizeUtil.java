package com.huawei.android.hicloud.cloudbackup.process.util;

import android.annotation.TargetApi;
import android.app.usage.StorageStats;
import android.app.usage.StorageStatsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.UserHandle;
import android.text.TextUtils;
import com.huawei.hicloud.notification.data.AppDataCollector;
import gt.C10046b;
import hk.C10278a;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;
import java.util.function.ToLongFunction;
import p015ak.C0209d;
import p514o9.C11839m;
import p762x4.C13694a;

/* loaded from: classes2.dex */
public class AppDataSizeUtil {
    private static final String TAG = "AppDataSizeUtil";

    public static class HapFileNameFilter implements FilenameFilter {
        private HapFileNameFilter() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.endsWith(".hap");
        }
    }

    public static class MyPrivilegedAction implements PrivilegedAction {
        private Method method;

        @Override // java.security.PrivilegedAction
        public Object run() throws SecurityException {
            this.method.setAccessible(true);
            return null;
        }

        private MyPrivilegedAction(Method method) {
            this.method = method;
        }
    }

    public static long calculateApkSize(Context context, String str) throws PackageManager.NameNotFoundException {
        if (context == null) {
            C11839m.m70688i(TAG, "calculateApkSize context is null");
            return 0L;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            return C10046b.m62458f(packageInfo.packageName) ? getHarmonyAppSize(packageInfo) : C13694a.m82330h(context, str) ? C13694a.m82327e(context, packageInfo) : C13694a.m82328f(packageInfo);
        } catch (PackageManager.NameNotFoundException unused) {
            C11839m.m70687e(TAG, "calculateApkSize: NameNotFoundException.");
            return 0L;
        }
    }

    @TargetApi(26)
    public static long getAppDataSize(String str, int i10, Context context) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        StorageStatsManager storageStatsManager = (StorageStatsManager) context.getSystemService("storagestats");
        PackageManager packageManager = context.getPackageManager();
        long packageVolmueInfo = 0;
        if (packageManager == null || storageStatsManager == null) {
            C11839m.m70689w(TAG, "mPackageManager or storageStatsManager is null");
            return 0L;
        }
        try {
            Class<?> cls = Class.forName(packageManager.getClass().getName());
            Class<?> cls2 = Integer.TYPE;
            Method method = cls.getMethod("getApplicationInfoAsUser", String.class, cls2, cls2);
            AccessController.doPrivileged(new MyPrivilegedAction(method));
            UUID uuid = ((ApplicationInfo) method.invoke(packageManager, str, 0, Integer.valueOf(i10))).storageUuid;
            UserHandle userHandle = getUserHandle(i10);
            if (userHandle != null) {
                return storageStatsManager.queryStatsForPackage(uuid, str, userHandle).getDataBytes();
            }
            C11839m.m70687e(TAG, "getAppDataSize userHandle is null");
            return 0L;
        } catch (Exception e10) {
            if (i10 == 0) {
                AppDataCollector appDataCollector = new AppDataCollector();
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                packageVolmueInfo = appDataCollector.getPackageVolmueInfo(context, arrayList);
            }
            C11839m.m70687e(TAG, "InvocationTargetException appId " + str + ",: " + e10.getMessage() + " retry result: " + packageVolmueInfo);
            return packageVolmueInfo;
        }
    }

    public static long getAppTotalSize(Context context, String str) throws NoSuchMethodException, PackageManager.NameNotFoundException, ClassNotFoundException, SecurityException, IOException {
        if (context == null) {
            C11839m.m70688i(TAG, "getAppTotalSize context is null");
            return 0L;
        }
        int i10 = Build.VERSION.SDK_INT;
        long appTotalSize = getAppTotalSize(str, C0209d.m1222X(), context);
        C11839m.m70686d(TAG, "getAppTotalSize appId = " + str + ", dataSize = " + appTotalSize + ", sdkInt = " + i10);
        return appTotalSize;
    }

    public static long getHarmonyAppSize(PackageInfo packageInfo) {
        if (packageInfo == null) {
            C11839m.m70687e(TAG, "getNormalAppApkSize: packageInfo is null.");
            return 0L;
        }
        String str = packageInfo.applicationInfo.sourceDir;
        int iLastIndexOf = str.lastIndexOf(File.separator);
        if (iLastIndexOf == -1) {
            return 0L;
        }
        File[] fileArrListFiles = C10278a.m63442h(str.substring(0, iLastIndexOf)).listFiles(new HapFileNameFilter());
        if (fileArrListFiles != null && fileArrListFiles.length != 0) {
            return Arrays.stream(fileArrListFiles).mapToLong(new ToLongFunction() { // from class: com.huawei.android.hicloud.cloudbackup.process.util.a
                @Override // java.util.function.ToLongFunction
                public final long applyAsLong(Object obj) {
                    return ((File) obj).length();
                }
            }).sum();
        }
        C11839m.m70687e(TAG, "There is no .hap files.");
        return 0L;
    }

    public static long getPackageSize(Context context, String str, int i10) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        if (context == null) {
            C11839m.m70688i(TAG, "getPackageSize context is null");
            return 0L;
        }
        int i11 = Build.VERSION.SDK_INT;
        long appDataSize = getAppDataSize(str, i10, context);
        C11839m.m70686d(TAG, "getPackageSize appId = " + str + ",dataSize = " + appDataSize + " ,sdkInt = " + i11);
        return appDataSize;
    }

    public static UserHandle getUserHandle(int i10) {
        try {
            return (UserHandle) UserHandle.class.getConstructor(Integer.TYPE).newInstance(Integer.valueOf(i10));
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "getUserHandle error: " + e10.getMessage());
            return null;
        }
    }

    @TargetApi(26)
    private static long getAppTotalSize(String str, int i10, Context context) throws NoSuchMethodException, PackageManager.NameNotFoundException, ClassNotFoundException, SecurityException, IOException {
        StorageStatsManager storageStatsManager = (StorageStatsManager) context.getSystemService("storagestats");
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null || storageStatsManager == null) {
            C11839m.m70689w(TAG, "packageManager or storageStatsManager is null");
            return 0L;
        }
        try {
            Class<?> cls = Class.forName(packageManager.getClass().getName());
            Class<?> cls2 = Integer.TYPE;
            Method method = cls.getMethod("getApplicationInfoAsUser", String.class, cls2, cls2);
            AccessController.doPrivileged(new MyPrivilegedAction(method));
            UUID uuid = ((ApplicationInfo) method.invoke(packageManager, str, 0, Integer.valueOf(i10))).storageUuid;
            UserHandle userHandle = getUserHandle(i10);
            if (userHandle == null) {
                C11839m.m70687e(TAG, "getAppTotalSize userHandle is null");
                return 0L;
            }
            StorageStats storageStatsQueryStatsForPackage = storageStatsManager.queryStatsForPackage(uuid, str, userHandle);
            return storageStatsQueryStatsForPackage.getAppBytes() + storageStatsQueryStatsForPackage.getDataBytes();
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "InvocationTargetException appId " + str + ",: " + e10.getMessage());
            return 0L;
        }
    }
}
