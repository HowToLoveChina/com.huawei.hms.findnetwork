package com.huawei.android.backup.service.logic;

import android.os.Bundle;
import com.android.packageinstaller.aidl.AppInfo;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.logic.C2153l;
import com.huawei.android.backup.service.logic.apprisk.AppsRisk;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p386j6.C10713c;

/* renamed from: com.huawei.android.backup.service.logic.j */
/* loaded from: classes.dex */
public class C2151j {
    /* renamed from: a */
    public static List<AppInfo> m12975a(Bundle bundle) {
        ArrayList arrayList = new ArrayList();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                arrayList.add(new AppInfo(str, C10713c.m65394d(bundle, str)));
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public static Bundle m12976b(C2153l.b bVar) {
        Bundle bundle;
        if (bVar == null || (bundle = bVar.f9690f) == null) {
            C2111d.m12648d("ControlBranchUtil", "getAPPRiskInfoRaw : cmd or executeParameter is null");
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        AppsRisk appsRisk = new AppsRisk(bVar.f9685a);
        Bundle bundleM65393c = C10713c.m65393c(bundle, "AppPackageList");
        if (bundleM65393c == null || C10713c.m65399i(bundleM65393c) <= 0 || !appsRisk.m12760f()) {
            bundle.putStringArrayList("RiskAppPackageNameList", arrayList);
            return bundle;
        }
        Map<String, Integer> mapM12759e = appsRisk.m12759e(m12975a(bundleM65393c));
        appsRisk.m12758d();
        if (mapM12759e != null) {
            for (Map.Entry<String, Integer> entry : mapM12759e.entrySet()) {
                Integer value = entry.getValue();
                if (value != null && value.intValue() == 1) {
                    arrayList.add(entry.getKey());
                }
            }
        }
        bundle.putStringArrayList("RiskAppPackageNameList", arrayList);
        return bundle;
    }
}
