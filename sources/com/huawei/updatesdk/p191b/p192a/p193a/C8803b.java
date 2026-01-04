package com.huawei.updatesdk.p191b.p192a.p193a;

import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.huawei.updatesdk.p177a.p178a.p183d.AbstractC8782d;
import com.huawei.updatesdk.p191b.p195b.C8807a;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.huawei.updatesdk.b.a.a.b */
/* loaded from: classes9.dex */
public class C8803b {

    /* renamed from: a */
    private final Map<String, C8802a> f45125a;

    /* renamed from: com.huawei.updatesdk.b.a.a.b$b */
    public static class b {

        /* renamed from: a */
        private static final C8803b f45126a = new C8803b();
    }

    private C8803b() {
        this.f45125a = new HashMap();
    }

    /* renamed from: a */
    public static C8803b m56190a() {
        return b.f45126a;
    }

    /* renamed from: a */
    public String m56191a(PackageInfo packageInfo) throws Throwable {
        if (packageInfo == null || packageInfo.packageName == null || TextUtils.isEmpty(packageInfo.applicationInfo.sourceDir)) {
            return null;
        }
        C8802a c8802a = this.f45125a.get(packageInfo.packageName);
        if (c8802a != null && c8802a.m56188b() == packageInfo.lastUpdateTime && c8802a.m56189c() == packageInfo.versionCode) {
            return c8802a.m56184a();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(packageInfo.lastUpdateTime);
        sb2.append(packageInfo.versionCode);
        sb2.append(packageInfo.packageName);
        String str = "packagekey" + packageInfo.packageName;
        String str2 = "fileshakey" + packageInfo.packageName;
        boolean z10 = !TextUtils.equals(sb2.toString(), C8807a.m56209d().m56211a(str));
        if (z10) {
            C8807a.m56209d().m56213a(str, sb2.toString());
        }
        String strM56211a = C8807a.m56209d().m56211a(str2);
        if (TextUtils.isEmpty(strM56211a) || z10) {
            strM56211a = AbstractC8782d.m56038a(packageInfo.applicationInfo.sourceDir, "SHA-256");
            C8807a.m56209d().m56213a(str2, strM56211a);
        }
        C8802a c8802a2 = new C8802a();
        c8802a2.m56187a(strM56211a);
        c8802a2.m56186a(packageInfo.lastUpdateTime);
        c8802a2.m56185a(packageInfo.versionCode);
        this.f45125a.put(packageInfo.packageName, c8802a2);
        return strM56211a;
    }
}
