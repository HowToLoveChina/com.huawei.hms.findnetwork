package es;

import android.content.Context;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import as.C1016d;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import p531or.C11991a;

/* renamed from: es.c */
/* loaded from: classes8.dex */
public class C9538c {

    /* renamed from: c */
    public static final b[] f47433c;

    /* renamed from: a */
    public static final String[] f47431a = {"android.hardware.type.", "android.software."};

    /* renamed from: b */
    public static final List<String> f47432b = Arrays.asList("kidpad", "kidwatch");

    /* renamed from: d */
    public static volatile int f47434d = -1;

    /* renamed from: e */
    public static volatile String f47435e = "";

    /* renamed from: f */
    public static volatile String f47436f = "";

    /* renamed from: g */
    public static volatile String f47437g = "";

    /* renamed from: h */
    public static volatile String f47438h = "";

    /* renamed from: es.c$b */
    public static final class b {

        /* renamed from: a */
        public final int f47439a;

        /* renamed from: b */
        public final String f47440b;

        /* renamed from: c */
        public final boolean f47441c;

        /* renamed from: d */
        public final String f47442d;

        /* renamed from: e */
        public final String f47443e;

        public b(int i10, String str, boolean z10, String str2, String str3) {
            this.f47439a = i10;
            this.f47440b = str;
            this.f47441c = z10;
            this.f47442d = str2;
            this.f47443e = str3;
        }
    }

    static {
        String str = null;
        boolean z10 = false;
        boolean z11 = false;
        f47433c = new b[]{new b(0, "handset", false, "default", null), new b(1, "pad", false, "tablet", null), new b(2, "watch", true, "watch", "watch"), new b(3, "kidwatch", false, "kidwatch", null), new b(4, "tv", true, "tv", "television"), new b(4, "tv", true, "tv", "leanback"), new b(5, "mobiletv", z10, "mobiletv", str), new b(6, "glass", z11, null, null), new b(7, "earphone", z10, null, str), new b(8, "car", z11, "car", "automotive")};
    }

    /* renamed from: a */
    public static int m59562a(FeatureInfo[] featureInfoArr) {
        C1016d.m6181a("DeviceInfoUtil", "Checking Android Features...");
        HashSet hashSet = new HashSet();
        for (FeatureInfo featureInfo : featureInfoArr) {
            if (featureInfo != null) {
                String strM59574m = m59574m(featureInfo.name);
                if (!TextUtils.isEmpty(strM59574m)) {
                    hashSet.add(strM59574m);
                }
            }
        }
        return m59570i(hashSet);
    }

    /* renamed from: b */
    public static int m59563b(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            C1016d.m6181a("DeviceInfoUtil", "packageManager is null.");
            return -1;
        }
        FeatureInfo[] systemAvailableFeatures = new FeatureInfo[0];
        try {
            systemAvailableFeatures = packageManager.getSystemAvailableFeatures();
        } catch (RuntimeException unused) {
            C1016d.m6181a("DeviceInfoUtil", "Package  manager  has  died Exception");
        }
        int iM59564c = m59564c(systemAvailableFeatures);
        C1016d.m6181a("DeviceInfoUtil", "1. detectHuaweiFeature: " + iM59564c);
        if (iM59564c == -1) {
            iM59564c = -1;
        } else if (iM59564c != 0) {
            return iM59564c;
        }
        int iM59562a = m59562a(systemAvailableFeatures);
        C1016d.m6181a("DeviceInfoUtil", "2. detectAndroidFeature: " + iM59562a);
        if (iM59562a != -1) {
            return iM59562a;
        }
        int iM59565d = m59565d();
        C1016d.m6181a("DeviceInfoUtil", "3. detectSystemProperty: " + iM59565d);
        return iM59565d == -1 ? iM59564c : iM59565d;
    }

    /* renamed from: c */
    public static int m59564c(FeatureInfo[] featureInfoArr) {
        int i10;
        C1016d.m6181a("DeviceInfoUtil", "Checking Huawei Features...");
        int length = featureInfoArr.length;
        int i11 = -1;
        int i12 = 0;
        while (true) {
            if (i12 >= length) {
                break;
            }
            FeatureInfo featureInfo = featureInfoArr[i12];
            if (featureInfo != null) {
                String str = featureInfo.name;
                if (!TextUtils.isEmpty(str)) {
                    if (str.startsWith("com.huawei.software.features.")) {
                        i10 = 29;
                    } else if (str.startsWith("com.hihonor.software.features.")) {
                        i10 = 30;
                    } else {
                        continue;
                    }
                    String strSubstring = str.substring(i10);
                    for (b bVar : f47433c) {
                        if (strSubstring.equals(bVar.f47440b)) {
                            i11 = bVar.f47439a;
                            if (!bVar.f47441c) {
                                break;
                            }
                        }
                    }
                    if (i11 != -1) {
                        C1016d.m6181a("DeviceInfoUtil", "Huawei Feature is found: " + featureInfo.name);
                        break;
                    }
                } else {
                    continue;
                }
            }
            i12++;
        }
        return i11;
    }

    /* renamed from: d */
    public static int m59565d() {
        C1016d.m6181a("DeviceInfoUtil", "Checking system properties...");
        String strM59648c = C9554s.m59648c();
        if (TextUtils.isEmpty(strM59648c)) {
            return -1;
        }
        List listAsList = Arrays.asList(strM59648c.split(",", 10));
        int i10 = -1;
        for (b bVar : f47433c) {
            if (listAsList.contains(bVar.f47442d)) {
                i10 = bVar.f47439a;
                if (!bVar.f47441c) {
                    break;
                }
            }
        }
        if (i10 == -1) {
            C1016d.m6181a("DeviceInfoUtil", "System property not found.");
        }
        return i10;
    }

    /* renamed from: e */
    public static synchronized String m59566e() {
        if (!TextUtils.isEmpty(f47437g)) {
            return f47437g;
        }
        f47437g = Build.BRAND;
        return f47437g;
    }

    /* renamed from: f */
    public static int m59567f(Context context) {
        if (f47434d != -1) {
            C1016d.m6181a("DeviceInfoUtil", "get deviceType from cache: " + f47434d);
            return f47434d;
        }
        if (context == null) {
            C1016d.m6181a("DeviceInfoUtil", "context is null.");
            return f47434d;
        }
        int iM59563b = m59563b(context);
        if (iM59563b != -1) {
            f47434d = iM59563b;
        }
        C1016d.m6181a("DeviceInfoUtil", "Final DeviceType: " + f47434d);
        return iM59563b;
    }

    /* renamed from: g */
    public static synchronized String m59568g() {
        if (!TextUtils.isEmpty(f47438h)) {
            return f47438h;
        }
        f47438h = Build.MODEL;
        return f47438h;
    }

    /* renamed from: h */
    public static synchronized String m59569h() {
        if (!TextUtils.isEmpty(f47436f)) {
            return f47436f;
        }
        f47436f = Build.MANUFACTURER;
        return f47436f;
    }

    /* renamed from: i */
    public static int m59570i(Set<String> set) {
        C1016d.m6181a("DeviceInfoUtil", "androidFeaturesNickNames :" + set);
        int i10 = -1;
        for (String str : set) {
            for (b bVar : f47433c) {
                if (str.equals(bVar.f47443e)) {
                    i10 = bVar.f47439a;
                    if (!bVar.f47441c) {
                        break;
                    }
                }
            }
            if (i10 != -1) {
                break;
            }
        }
        return i10;
    }

    /* renamed from: j */
    public static boolean m59571j() {
        return m59573l() && C9550o.m59635h();
    }

    /* renamed from: k */
    public static boolean m59572k() {
        return TextUtils.equals(C9554s.m59646a("ro.vendor.market.type", ""), "KidWatch");
    }

    /* renamed from: l */
    public static boolean m59573l() {
        return m59567f(C11991a.m72145a()) == 2;
    }

    /* renamed from: m */
    public static String m59574m(String str) {
        String strSubstring = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] strArr = f47431a;
        int length = strArr.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                break;
            }
            String str2 = strArr[i10];
            if (str.startsWith(str2)) {
                strSubstring = str.substring(str2.length());
                break;
            }
            i10++;
        }
        C1016d.m6181a("DeviceInfoUtil", "featureInfoName relative nick name :" + strSubstring);
        return strSubstring;
    }
}
