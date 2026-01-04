package p250e7;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import java.util.Iterator;

/* renamed from: e7.b */
/* loaded from: classes2.dex */
public class C9420b {

    /* renamed from: a */
    public static final String f47084a = "b";

    /* renamed from: e7.b$a */
    public static class a {

        /* renamed from: a */
        public String[] f47085a;
    }

    /* renamed from: a */
    public static PackageInfo m59087a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e10) {
            C9419a.m59082h(f47084a, "get package info failed.", e10);
            return null;
        }
    }

    @TargetApi(21)
    /* renamed from: b */
    public static a m59088b(Context context) {
        a aVar = new a();
        PackageInfo packageInfoM59087a = m59087a(context);
        if (packageInfoM59087a != null && packageInfoM59087a.applicationInfo != null) {
            aVar.f47085a = packageInfoM59087a.splitNames;
        }
        return aVar;
    }

    /* renamed from: c */
    public static Bundle m59089c(Context context) {
        ApplicationInfo applicationInfo;
        PackageInfo packageInfoM59087a = m59087a(context);
        if (packageInfoM59087a == null || (applicationInfo = packageInfoM59087a.applicationInfo) == null) {
            return null;
        }
        return applicationInfo.metaData;
    }

    /* renamed from: d */
    public static boolean m59090d(Context context) {
        ApplicationInfo applicationInfo;
        if (context == null) {
            return false;
        }
        PackageInfo packageInfoM59087a = m59087a(context);
        if (packageInfoM59087a == null || (applicationInfo = packageInfoM59087a.applicationInfo) == null) {
            C9419a.m59080f(f47084a, context.getPackageName() + " is application");
            return false;
        }
        Bundle bundle = applicationInfo.metaData;
        if (bundle == null) {
            C9419a.m59080f(f47084a, context.getPackageName() + " meta-data is null");
            return false;
        }
        Iterator<String> it = bundle.keySet().iterator();
        while (it.hasNext()) {
            if (it.next().startsWith("com.huawei.hms.kit.type")) {
                C9419a.m59080f(f47084a, context.getPackageName() + " is kit");
                return true;
            }
        }
        C9419a.m59080f(f47084a, context.getPackageName() + " is application");
        return false;
    }
}
