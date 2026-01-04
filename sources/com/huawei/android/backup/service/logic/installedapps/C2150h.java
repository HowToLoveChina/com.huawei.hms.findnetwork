package com.huawei.android.backup.service.logic.installedapps;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.hianalytics.core.transport.Utils;
import java.util.Set;
import p699v4.C13334c;

/* renamed from: com.huawei.android.backup.service.logic.installedapps.h */
/* loaded from: classes.dex */
public class C2150h {
    /* renamed from: a */
    public static Bundle m12967a(long j10, long j11) {
        Bundle bundle = new Bundle();
        bundle.putLong("current", j10);
        bundle.putLong("totalsize", j11);
        return bundle;
    }

    /* renamed from: b */
    public static boolean m12968b(PackageInfo packageInfo, Set<String> set, Set<String> set2, int i10, boolean z10) {
        String str = packageInfo.applicationInfo.sourceDir;
        if (!C13334c.m79959C(str)) {
            C2111d.m12648d(Utils.TAG, "Application package [" + str + "] isn't exist.");
            return false;
        }
        if (set != null && set.contains(packageInfo.packageName)) {
            return false;
        }
        if ("com.huawei.meetime".equals(packageInfo.packageName)) {
            C2111d.m12653i(Utils.TAG, "support com.huawei.meetime");
            return true;
        }
        if (!m12971e(packageInfo, z10)) {
            return i10 == 0 || set2 == null || !set2.contains(packageInfo.packageName);
        }
        C2111d.m12646b(Utils.TAG, "isPresetOrSystemApp:" + packageInfo.packageName);
        return false;
    }

    /* renamed from: c */
    public static boolean m12969c(ApplicationInfo applicationInfo) {
        return m12973g(applicationInfo) && !m12974h(applicationInfo);
    }

    /* renamed from: d */
    public static boolean m12970d(String str) {
        return str.contains("/data/cust/") || str.contains("/data/dataapp/") || str.contains("/system/") || str.contains("/flex/") || str.contains("/preload/");
    }

    /* renamed from: e */
    public static boolean m12971e(PackageInfo packageInfo, boolean z10) {
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        return (z10 ? m12969c(applicationInfo) : m12972f(applicationInfo)) || m12970d(applicationInfo.sourceDir);
    }

    /* renamed from: f */
    public static boolean m12972f(ApplicationInfo applicationInfo) {
        return m12973g(applicationInfo) || m12974h(applicationInfo);
    }

    /* renamed from: g */
    public static boolean m12973g(ApplicationInfo applicationInfo) {
        return (applicationInfo.flags & 1) != 0;
    }

    /* renamed from: h */
    public static boolean m12974h(ApplicationInfo applicationInfo) {
        return (applicationInfo.flags & 128) != 0;
    }
}
