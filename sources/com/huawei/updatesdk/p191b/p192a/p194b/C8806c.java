package com.huawei.updatesdk.p191b.p192a.p194b;

import android.util.ArrayMap;
import android.util.ArraySet;
import com.huawei.updatesdk.p177a.p178a.p180c.p181a.p182a.C8777a;
import java.io.File;
import java.security.PublicKey;

/* renamed from: com.huawei.updatesdk.b.a.b.c */
/* loaded from: classes9.dex */
class C8806c {

    /* renamed from: com.huawei.updatesdk.b.a.b.c$a */
    public static class a {

        /* renamed from: a */
        ArrayMap<String, ArraySet<PublicKey>> f45133a = null;

        /* renamed from: b */
        ArraySet<String> f45134b = null;
    }

    /* renamed from: a */
    public static a m56206a(File file) {
        a aVar = new a();
        Object objM56208b = m56208b(file);
        if (objM56208b != null) {
            Object objM56207a = m56207a(objM56208b, "mKeySetMapping");
            if (objM56207a instanceof ArrayMap) {
                aVar.f45133a = (ArrayMap) objM56207a;
            }
            Object objM56207a2 = m56207a(objM56208b, "mUpgradeKeySets");
            if (objM56207a2 instanceof ArraySet) {
                aVar.f45134b = (ArraySet) objM56207a2;
            }
        }
        return aVar;
    }

    /* renamed from: b */
    private static Object m56208b(File file) {
        try {
            Class<?> cls = Class.forName("android.content.pm.PackageParser");
            return cls.getDeclaredMethod("parsePackage", File.class, Integer.TYPE).invoke(cls.newInstance(), file, 0);
        } catch (Throwable th2) {
            C8777a.m56029c("KeySetsUtils", "can not get PackageParser: " + th2.getMessage());
            return null;
        }
    }

    /* renamed from: a */
    private static Object m56207a(Object obj, String str) {
        try {
            return Class.forName("android.content.pm.PackageParser$Package").getDeclaredField(str).get(obj);
        } catch (Throwable th2) {
            C8777a.m56029c("KeySetsUtils", "can not find class: " + th2.getMessage());
            return null;
        }
    }
}
