package p572qb;

import android.content.Context;
import bd.C1164a;
import com.huawei.android.hicloud.syncdrive.cloudsync.request.TasksCreateRequest;
import com.huawei.android.hicloud.syncdrive.util.DriveSyncUtil;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import p255ed.C9453i;
import p292fn.C9733f;
import p514o9.C11839m;
import tc.C13007b;

/* renamed from: qb.i */
/* loaded from: classes3.dex */
public class C12313i {

    /* renamed from: qb.i$a */
    public static class a {

        /* renamed from: a */
        public static C12313i f57023a = new C12313i();
    }

    /* renamed from: a */
    public static C12313i m74031a() {
        return a.f57023a;
    }

    /* renamed from: b */
    public final void m74032b(C13007b c13007b, String str, String str2) {
        try {
            try {
                C9453i c9453iM7268d = C1164a.m7265f().m7268d(str2);
                TasksCreateRequest tasksCreateRequest = new TasksCreateRequest();
                tasksCreateRequest.setType("resourceScan");
                DriveSyncUtil.m18002l(str2, "local_download_struct");
                c9453iM7268d.m59244c().create(str, tasksCreateRequest).execute();
            } catch (Exception e10) {
                C11839m.m70687e("DownloadErrorReportManager", "ReportResourceScan runTask Exception: " + e10.toString());
            }
        } finally {
            C11839m.m70688i("DownloadErrorReportManager", "reportCheck Success");
            c13007b.m78225J0(System.currentTimeMillis());
        }
    }

    /* renamed from: c */
    public void m74033c(Context context, String str, String str2) {
        HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
        int resourceScanTaskCreateInterval = hiCloudSysParamMapM60757p != null ? hiCloudSysParamMapM60757p.getResourceScanTaskCreateInterval() : 0;
        if (resourceScanTaskCreateInterval <= 0) {
            resourceScanTaskCreateInterval = 30;
        }
        C11839m.m70688i("DownloadErrorReportManager", "resourceScanTaskCreateInterval day is " + resourceScanTaskCreateInterval);
        long jCurrentTimeMillis = System.currentTimeMillis();
        C13007b c13007bM78205Y = C13007b.m78205Y(context);
        long jM78240R = c13007bM78205Y.m78240R();
        Long lValueOf = Long.valueOf(jM78240R);
        long j10 = jCurrentTimeMillis - jM78240R;
        C11839m.m70688i("DownloadErrorReportManager", "duration: " + Long.valueOf(j10) + ",lastScanTaskTime:" + lValueOf);
        if (j10 > resourceScanTaskCreateInterval * 86400000) {
            C11839m.m70688i("DownloadErrorReportManager", "reportCheck");
            m74032b(c13007bM78205Y, str, str2);
            return;
        }
        C11839m.m70689w("DownloadErrorReportManager", "duration < " + resourceScanTaskCreateInterval + " day do not Scan Task");
    }
}
