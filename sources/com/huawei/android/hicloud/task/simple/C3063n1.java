package com.huawei.android.hicloud.task.simple;

import com.huawei.hicloud.report.uba.UBAAnalyze;
import fk.C9721b;
import java.util.LinkedHashMap;
import java.util.Map;
import p015ak.C0229n;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p684un.C13225d;

/* renamed from: com.huawei.android.hicloud.task.simple.n1 */
/* loaded from: classes3.dex */
public class C3063n1 extends AbstractC12367d {
    /* renamed from: c */
    public void m18365c(Map<String, String> map) {
        long jM1607f = C0229n.m1607f(C0229n.m1606e());
        long jM1605d = C0229n.m1605d("/storage/emulated/0");
        map.put("totalStorage", String.valueOf(jM1607f));
        map.put("availableSpace", String.valueOf(jM1605d));
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        C11839m.m70688i("LocalStorageInfoReportTask", "LocalStorageInfoReportTask start");
        m18366d();
    }

    /* renamed from: d */
    public void m18366d() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        m18365c(linkedHashMap);
        C13225d.m79490f1().m79591l0("cloudbackup_local_info", linkedHashMap);
        UBAAnalyze.m29958S("PVC", "cloudbackup_local_info", "4", "100", linkedHashMap);
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public boolean syncLock() {
        return false;
    }
}
