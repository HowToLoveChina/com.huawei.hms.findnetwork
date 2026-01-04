package p762x4;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.SparseArray;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.logic.BackupObject;
import com.huawei.android.backup.service.utils.BackupConstant;
import com.huawei.android.backup.service.utils.C2157a;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import p229di.C9139d;
import p668u4.C13122a;
import p699v4.C13334c;
import p699v4.C13345n;
import p699v4.C13349r;

/* renamed from: x4.a */
/* loaded from: classes.dex */
public final class C13694a {
    /* renamed from: a */
    public static long m82323a(Context context, String str) throws PackageManager.NameNotFoundException {
        long jM82327e;
        long jM79988u = 0;
        try {
        } catch (PackageManager.NameNotFoundException unused) {
            C2111d.m12648d("AppDataUtils", "calculateApkSize: NameNotFoundException.");
            jM82327e = 0;
        }
        if (context == null) {
            C2111d.m12653i("AppDataUtils", "calculateApkSize context is null");
            return 0L;
        }
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
        jM82327e = (BackupObject.isSupportBundleApp() && m82330h(context, str)) ? m82327e(context, packageInfo) : m82328f(packageInfo);
        List<String> listM79983p = C13334c.m79983p(C13345n.m80062a(context, str), str);
        if (listM79983p.size() <= 0) {
            return jM82327e;
        }
        Iterator<String> it = listM79983p.iterator();
        while (it.hasNext()) {
            jM79988u += C13334c.m79988u(new File(it.next()));
        }
        C2111d.m12654j("AppDataUtils", "obbDataSize ", Long.valueOf(jM79988u));
        return jM82327e + jM79988u;
    }

    @TargetApi(26)
    /* renamed from: b */
    public static String[] m82324b(PackageInfo packageInfo) {
        if (packageInfo == null) {
            C2111d.m12648d("AppDataUtils", "getAllSplitApksPath: packageInfo is null.");
            return null;
        }
        String[] strArr = packageInfo.applicationInfo.splitSourceDirs;
        if (strArr != null && strArr.length != 0) {
            return strArr;
        }
        C2111d.m12646b("AppDataUtils", "splitSourceDirs is empty.");
        return null;
    }

    /* renamed from: c */
    public static String m82325c(String str) {
        if (TextUtils.isEmpty(str) || !(str.endsWith(C13334c.m79984q()) || str.endsWith(".hap"))) {
            C2111d.m12648d("AppDataUtils", "This file isn't a apk or hap.");
            return null;
        }
        String str2 = File.separator;
        return str.contains(str2) ? str.substring(str.lastIndexOf(str2) + 1, str.length()) : str;
    }

    /* renamed from: d */
    public static String[] m82326d(Context context, PackageInfo packageInfo) {
        int i10;
        if (packageInfo == null) {
            C2111d.m12648d("AppDataUtils", "getSplitApksPath: packageInfo is null.");
            return null;
        }
        if (!C13349r.m80086b(context)) {
            C2111d.m12657m("AppDataUtils", "The EMUI version is brfore Q, can't get split apks path.");
            return null;
        }
        SparseArray<int[]> sparseArrayM57457a = C9139d.m57457a(packageInfo.applicationInfo);
        if (sparseArrayM57457a == null || sparseArrayM57457a.size() == 0) {
            C2111d.m12648d("AppDataUtils", "getBaseConfigApkPath: splitDependencies is empty.");
            return null;
        }
        int[] iArr = sparseArrayM57457a.get(0);
        if (iArr == null || iArr.length == 0) {
            C2111d.m12648d("AppDataUtils", "getBaseConfigApkPath: baseDependencies is empty.");
            return null;
        }
        String[] strArrM82324b = m82324b(packageInfo);
        if (C2157a.m13169D(strArrM82324b)) {
            C2111d.m12648d("AppDataUtils", "getBaseConfigApkPath: allSplitApkPath is empty.");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i11 : iArr) {
            if (i11 > 0 && i11 - 1 < strArrM82324b.length) {
                arrayList.add(strArrM82324b[i10]);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    /* renamed from: e */
    public static long m82327e(Context context, PackageInfo packageInfo) {
        if (packageInfo == null) {
            C2111d.m12648d("AppDataUtils", "getBundleAppApkSize: packageInfo is null.");
            return 0L;
        }
        File file = new File(packageInfo.applicationInfo.sourceDir);
        long length = file.exists() ? file.length() : 0L;
        String[] strArrM82326d = C13349r.m80086b(context) ? m82326d(context, packageInfo) : m82324b(packageInfo);
        if (strArrM82326d == null) {
            C2111d.m12657m("AppDataUtils", "getBundleAppApkSize: splitApksArr is null.");
            return length;
        }
        for (String str : strArrM82326d) {
            File file2 = new File(str);
            if (file2.exists()) {
                length += file2.length();
            }
        }
        return length;
    }

    /* renamed from: f */
    public static long m82328f(PackageInfo packageInfo) {
        if (packageInfo == null) {
            C2111d.m12648d("AppDataUtils", "getNormalAppApkSize: packageInfo is null.");
            return 0L;
        }
        File file = new File(packageInfo.applicationInfo.sourceDir);
        if (file.exists()) {
            return file.length();
        }
        return 0L;
    }

    /* renamed from: g */
    public static int m82329g(Context context, String str) throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo;
        if (context == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 64);
        } catch (PackageManager.NameNotFoundException unused) {
            C2111d.m12648d("AppDataUtils", "GET VERSIONCODE ERROR");
            packageInfo = null;
        }
        if (packageInfo != null) {
            return packageInfo.versionCode;
        }
        return -1;
    }

    /* renamed from: h */
    public static boolean m82330h(Context context, String str) {
        try {
            if (context == null) {
                C2111d.m12653i("AppDataUtils", "isBundleApp context is null");
                return false;
            }
            String[] strArrM82324b = m82324b(context.getPackageManager().getPackageInfo(str, 64));
            return strArrM82324b != null && strArrM82324b.length > 0;
        } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            C2111d.m12648d("AppDataUtils", "NameNotFoundException: get package path faild.");
            return false;
        } catch (IOException unused2) {
            C2111d.m12648d("AppDataUtils", "IOException: get package path faild.");
            return false;
        }
    }

    /* renamed from: i */
    public static boolean m82331i(String str, String str2, ArrayList<String> arrayList, String str3) {
        if (arrayList == null) {
            return true;
        }
        StringBuilder sb2 = new StringBuilder(str);
        String str4 = File.separator;
        sb2.append(str4);
        sb2.append(str2);
        String string = sb2.toString();
        int iIndexOf = string.indexOf(str3);
        if (!TextUtils.isEmpty(str) && str.contains("/data/user/0")) {
            if (iIndexOf != -1) {
                string = "/data/data" + str4 + string.substring(iIndexOf);
            } else {
                string = "/data/data" + str4 + string;
            }
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            if (string.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: j */
    public static boolean m82332j(String str) {
        return m82333k(str) || "lib".equals(str);
    }

    /* renamed from: k */
    public static boolean m82333k(String str) {
        if (TextUtils.isEmpty(str)) {
            C2111d.m12653i("AppDataUtils", "isPipeOrDexFile filePath is null");
            return false;
        }
        if (!str.endsWith(".000000") && !str.endsWith(".dex")) {
            return false;
        }
        C2111d.m12657m("AppDataUtils", "this file may be pipe or dex file");
        return true;
    }

    /* renamed from: l */
    public static boolean m82334l(String str, String str2, int i10, String str3) {
        if (TextUtils.isEmpty(str)) {
            C2111d.m12653i("AppDataUtils", "isRealFile dirPath is null");
            return false;
        }
        if ((i10 != 4 && i10 != 8) || m82333k(str2) || ".".equals(str2) || "..".equals(str2)) {
            return false;
        }
        return ("lib".equals(str2) && str.equals(str3)) ? false : true;
    }

    /* renamed from: m */
    public static boolean m82335m(Context context, String str) {
        if (TextUtils.isEmpty(str) || C2157a.m13174I(str) || context == null) {
            return false;
        }
        if (BackupConstant.m13130d().containsKey(str)) {
            return C2157a.m13172G(context);
        }
        return true;
    }

    /* renamed from: n */
    public static boolean m82336n(Context context, int i10, String str) {
        return (context == null || TextUtils.isEmpty(str) || m82329g(context, str) < i10) ? false : true;
    }

    /* renamed from: o */
    public static HashMap<String, Long> m82337o(Context context, List<String> list) {
        C2111d.m12653i("AppDataUtils", "queryAllAppDataSize start...");
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (list == null) {
            return new HashMap<>();
        }
        int size = list.size();
        HashMap<String, Long> map = new HashMap<>(size);
        int i10 = (size / 15) + 1;
        ArrayList<FutureTask> arrayList = new ArrayList(i10);
        int i11 = 0;
        while (i11 < i10) {
            try {
                int i12 = i11 * 15;
                i11++;
                int i13 = i11 * 15;
                C2111d.m12654j("AppDataUtils", "start a query app data size thread [", Integer.valueOf(i12), "-", Integer.valueOf(i13), "]");
                if (size <= i13) {
                    i13 = size;
                }
                FutureTask futureTask = new FutureTask(new CallableC13701h(context, list.subList(i12, i13)));
                C13122a.m78920d().m80077c(futureTask);
                arrayList.add(futureTask);
            } finally {
                C13122a.m78921e();
            }
        }
        try {
            for (FutureTask futureTask2 : arrayList) {
                if (futureTask2 != null) {
                    map.putAll((Map) futureTask2.get());
                    C2111d.m12653i("AppDataUtils", "do a GetInfoFromApkTask.get(), adding to retList.");
                }
            }
        } catch (InterruptedException unused) {
            C2111d.m12648d("AppDataUtils", "InterruptedException");
        } catch (ExecutionException unused2) {
            C2111d.m12648d("AppDataUtils", "ExecutionException");
        }
        C2111d.m12654j("AppDataUtils", "queryAllAppDataSize end, cost total time [", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis), "]");
        return map;
    }
}
