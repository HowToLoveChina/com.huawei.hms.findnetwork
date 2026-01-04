package com.huawei.updatesdk.p191b.p192a.p194b;

import android.content.pm.PackageInfo;
import android.util.ArrayMap;
import android.util.ArraySet;
import com.huawei.updatesdk.p177a.p178a.p183d.AbstractC8786h;
import com.huawei.updatesdk.p191b.p192a.p194b.C8804a;
import com.huawei.updatesdk.p191b.p192a.p194b.C8806c;
import java.io.File;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.updatesdk.b.a.b.b */
/* loaded from: classes9.dex */
public class C8805b {

    /* renamed from: a */
    private final Map<String, C8804a> f45131a;

    /* renamed from: com.huawei.updatesdk.b.a.b.b$b */
    public static class b {

        /* renamed from: a */
        private static final C8805b f45132a = new C8805b();
    }

    private C8805b() {
        this.f45131a = new HashMap();
    }

    /* renamed from: a */
    public static C8805b m56201a() {
        return b.f45132a;
    }

    /* renamed from: b */
    private static ArrayList<String> m56203b(PackageInfo packageInfo) {
        ArraySet<String> arraySet;
        C8804a c8804a = new C8804a();
        c8804a.m56196a(packageInfo.packageName);
        File file = new File(packageInfo.applicationInfo.sourceDir);
        if (!file.exists()) {
            return null;
        }
        c8804a.m56194a(file.lastModified());
        C8806c.a aVarM56206a = C8806c.m56206a(file);
        ArrayMap<String, ArraySet<PublicKey>> arrayMap = aVarM56206a.f45133a;
        if (arrayMap == null || arrayMap.isEmpty() || (arraySet = aVarM56206a.f45134b) == null || arraySet.isEmpty()) {
            m56202a(c8804a);
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (Map.Entry<String, ArraySet<PublicKey>> entry : aVarM56206a.f45133a.entrySet()) {
            if (aVarM56206a.f45134b.contains(entry.getKey())) {
                Iterator<PublicKey> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    arrayList.add(AbstractC8786h.m56065a(it.next().getEncoded()));
                }
            }
        }
        C8804a.a aVar = new C8804a.a();
        aVar.m56200a(arrayList);
        c8804a.m56195a(aVar);
        m56202a(c8804a);
        return arrayList;
    }

    /* renamed from: a */
    public List<String> m56204a(PackageInfo packageInfo) {
        String str;
        if (packageInfo == null || (str = packageInfo.applicationInfo.sourceDir) == null) {
            return null;
        }
        long jLastModified = new File(str).lastModified();
        C8804a c8804a = m56201a().f45131a.get(packageInfo.packageName);
        if (c8804a == null || c8804a.m56197b() != jLastModified) {
            return m56203b(packageInfo);
        }
        if (c8804a.m56193a() == null) {
            return null;
        }
        return c8804a.m56193a().m56199a();
    }

    /* renamed from: a */
    private static void m56202a(C8804a c8804a) {
        m56201a().f45131a.put(c8804a.m56198c(), c8804a);
    }
}
