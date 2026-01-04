package p009a8;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.hicloud.album.service.report.CommonOpsReport;
import com.huawei.android.hicloud.drive.cloudphoto.model.Asset;
import com.huawei.android.hicloud.drive.cloudphoto.model.TasksCreateRequest;
import com.huawei.android.hicloud.drive.cloudphoto.request.Assets;
import com.huawei.cloud.base.http.C4616s;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import java.io.IOException;
import java.util.HashMap;
import p015ak.C0213f;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1136q;
import p283fa.C9678a;
import p292fn.C9733f;
import p546p6.C12106s;
import p546p6.EnumC12107t;
import p804ya.C13924a;

/* renamed from: a8.c */
/* loaded from: classes2.dex */
public class C0065c {

    /* renamed from: a8.c$a */
    public static class a {

        /* renamed from: a */
        public static C0065c f214a = new C0065c();
    }

    /* renamed from: a */
    public static C0065c m432a() {
        return a.f214a;
    }

    /* renamed from: b */
    public final long m433b() {
        int resourceScanTaskCreateInterval;
        HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
        if (hiCloudSysParamMapM60757p != null) {
            resourceScanTaskCreateInterval = hiCloudSysParamMapM60757p.getResourceScanTaskCreateInterval();
            C1120a.m6677i("DownloadErrorManager", "hiCloudSysParamMap get day is " + resourceScanTaskCreateInterval);
        } else {
            resourceScanTaskCreateInterval = 30;
        }
        return resourceScanTaskCreateInterval * 86400000;
    }

    /* renamed from: c */
    public synchronized void m434c(String str, String str2, long j10) {
        Context contextM1377a;
        long jCurrentTimeMillis;
        TasksCreateRequest tasksCreateRequest;
        C1120a.m6678w("DownloadErrorManager", "reportCheck errorCode:" + str);
        if (TextUtils.isEmpty(str)) {
            C1120a.m6678w("DownloadErrorManager", "reportCheck errorCode is null");
            return;
        }
        long jM7013M = C1136q.b.m7013M(C0213f.m1377a());
        long jM433b = m433b();
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jM7013M;
        if (!str.contains("404") || jCurrentTimeMillis2 <= jM433b) {
            C1120a.m6677i("DownloadErrorManager", "interval: " + jM433b + " reportInterval:" + jCurrentTimeMillis2);
        } else {
            C1120a.m6678w("DownloadErrorManager", "reportCheck request");
            C13924a c13924aM60445d = C9678a.m60442e().m60445d();
            try {
                try {
                    tasksCreateRequest = new TasksCreateRequest();
                    tasksCreateRequest.setType("resourceScan");
                    HashMap map = new HashMap();
                    if (TextUtils.isEmpty(str2) || j10 == 0) {
                        C1120a.m6678w("DownloadErrorManager", "fileId is null or size equal 0");
                    } else {
                        map.put("mediaId", str2);
                        map.put("size", Long.toString(j10));
                    }
                    tasksCreateRequest.setProperties(map);
                } catch (IOException e10) {
                    C1120a.m6676e("DownloadErrorManager", "ReportResourceScan runTask IOException: " + e10.toString());
                    if ((!(e10 instanceof C4616s) ? C1122c.m6845x0(e10) : C1122c.m6802l0((C4616s) e10)) == 0) {
                        contextM1377a = C0213f.m1377a();
                        jCurrentTimeMillis = System.currentTimeMillis();
                    }
                } catch (Exception e11) {
                    C1120a.m6676e("DownloadErrorManager", "ReportResourceScan runTask Exception: " + e11.toString());
                }
                if (c13924aM60445d == null) {
                    C1120a.m6678w("DownloadErrorManager", "cloudPhoto is null return");
                    C1136q.b.m7038Y0(C0213f.m1377a(), System.currentTimeMillis());
                } else {
                    c13924aM60445d.m83561r().create(tasksCreateRequest).execute();
                    contextM1377a = C0213f.m1377a();
                    jCurrentTimeMillis = System.currentTimeMillis();
                    C1136q.b.m7038Y0(contextM1377a, jCurrentTimeMillis);
                }
            } catch (Throwable th2) {
                C1136q.b.m7038Y0(C0213f.m1377a(), System.currentTimeMillis());
                throw th2;
            }
        }
    }

    /* renamed from: d */
    public synchronized void m435d(String str, String str2, Asset asset) {
        String string;
        CommonOpsReport commonOpsReport;
        String str3;
        C1120a.m6677i("DownloadErrorManager", "updateStatus");
        if (!TextUtils.isEmpty(str2) && asset != null) {
            if (asset.getStatus().intValue() == 2) {
                C1120a.m6677i("DownloadErrorManager", "status is 2 return fileId:" + str2);
                return;
            }
            if (TextUtils.isEmpty(str)) {
                str = C1122c.m6755Z0("04001");
            }
            C13924a c13924aM60445d = C9678a.m60442e().m60445d();
            int iM28322f = 4312;
            try {
            } catch (Throwable th2) {
                th = th2;
                iM28322f = 0;
            }
            try {
                try {
                    try {
                        Asset asset2 = new Asset();
                        asset2.setStatus(2);
                        Assets.Revisions.Update update = c13924aM60445d.m83549f().revisions().update(str2, asset.getId(), asset.getVersionId(), "id", asset2);
                        C12106s c12106sM72509c = C12106s.m72509c();
                        EnumC12107t enumC12107t = EnumC12107t.DOWNLOAD_UPDATE_ASSET;
                        update.addHeader("x-hw-lock", (Object) c12106sM72509c.m72513e(enumC12107t, false).getSessionId()).addHeader("x-hw-trace-id", (Object) str).execute();
                        C12106s.m72509c().m72520l(enumC12107t);
                        new CommonOpsReport(C0213f.m1377a()).m15209C(str, "Assets.revisions.update", 0, "ok");
                    } catch (C4616s e10) {
                        iM28322f = e10.m28322f();
                        string = e10.m28319c();
                        C1120a.m6676e("DownloadErrorManager", "httpResponseException result" + e10.toString());
                        C12106s.m72509c().m72520l(EnumC12107t.DOWNLOAD_UPDATE_ASSET);
                        commonOpsReport = new CommonOpsReport(C0213f.m1377a());
                        str3 = "Assets.revisions.update";
                        commonOpsReport.m15209C(str, str3, iM28322f, string);
                        return;
                    } catch (Exception e11) {
                        string = e11.toString();
                        C1120a.m6676e("DownloadErrorManager", "updateStatus  Exception: " + e11.toString());
                        C12106s.m72509c().m72520l(EnumC12107t.DOWNLOAD_UPDATE_ASSET);
                        commonOpsReport = new CommonOpsReport(C0213f.m1377a());
                        str3 = "Assets.revisions.update";
                        commonOpsReport.m15209C(str, str3, iM28322f, string);
                        return;
                    }
                } catch (IOException e12) {
                    C1120a.m6676e("DownloadErrorManager", "updateStatus IOException result" + e12.toString());
                    String string2 = e12.toString();
                    C12106s.m72509c().m72520l(EnumC12107t.DOWNLOAD_UPDATE_ASSET);
                    new CommonOpsReport(C0213f.m1377a()).m15209C(str, "Assets.revisions.update", 4312, string2);
                }
                return;
            } catch (Throwable th3) {
                th = th3;
                C12106s.m72509c().m72520l(EnumC12107t.DOWNLOAD_UPDATE_ASSET);
                new CommonOpsReport(C0213f.m1377a()).m15209C(str, "Assets.revisions.update", iM28322f, "ok");
                throw th;
            }
        }
        C1120a.m6677i("DownloadErrorManager", "fileId or asset  is null " + str2);
    }
}
