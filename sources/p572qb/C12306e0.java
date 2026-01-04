package p572qb;

import android.content.Context;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import fk.C9721b;
import gp.C10028c;
import java.util.LinkedHashMap;
import p015ak.C0212e0;
import p015ak.C0213f;
import p020ap.C1006a;
import p020ap.C1010e;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p709vj.C13452e;

/* renamed from: qb.e0 */
/* loaded from: classes3.dex */
public class C12306e0 {

    /* renamed from: qb.e0$b */
    public static class b {

        /* renamed from: a */
        public static final C12306e0 f57010a = new C12306e0();
    }

    /* renamed from: qb.e0$c */
    public static class c extends AbstractC12367d {
        public c() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            C12306e0.m73994c().m73997e();
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.COLLECT_DEVICE_INFO;
        }
    }

    /* renamed from: c */
    public static C12306e0 m73994c() {
        return b.f57010a;
    }

    /* renamed from: b */
    public void m73995b() {
        C12515a.m75110o().m75175e(new c(), true);
    }

    /* renamed from: d */
    public final boolean m73996d() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("ReportDeviceInfoManager", "isSatisfyReportLogic context null");
            return false;
        }
        boolean zM62221H1 = C10028c.m62182c0().m62221H1();
        boolean zM80842P0 = C13452e.m80781L().m80842P0();
        C11839m.m70686d("ReportDeviceInfoManager", "isSatisfyCollectLogic isHiCloudLogin " + zM80842P0 + " isAgreedHiCloudTerms " + zM62221H1);
        if (!zM80842P0) {
            C11839m.m70687e("ReportDeviceInfoManager", "isSatisfyCollectLogic not login hw account");
            return false;
        }
        if (!zM62221H1) {
            C11839m.m70687e("ReportDeviceInfoManager", "isSatisfyCollectLogic not agree hicloud terms");
            return false;
        }
        long jM1359i = C0212e0.m1359i(contextM1377a, "sp_device_use_info", "key_report_time_mills", 0L);
        C11839m.m70686d("ReportDeviceInfoManager", "isSatisfyReportLogic lastReportTimeMills " + jM1359i);
        if (jM1359i == 0) {
            C11839m.m70687e("ReportDeviceInfoManager", "isSatisfyReportLogic  first time 7 days later report");
            C0212e0.m1370t(contextM1377a, "sp_device_use_info", "key_report_time_mills", System.currentTimeMillis());
            return false;
        }
        boolean z10 = System.currentTimeMillis() - jM1359i > 604800000;
        C11839m.m70686d("ReportDeviceInfoManager", "isSatisfyReportLogic isOverSevenDays " + z10);
        if (!z10) {
            C11839m.m70687e("ReportDeviceInfoManager", "isSatisfyReportLogic not satisfy over 7 days logic");
            return false;
        }
        boolean zM1354d = C0212e0.m1354d(contextM1377a, "sp_device_use_info", "key_has_data_change", false);
        C11839m.m70686d("ReportDeviceInfoManager", "isSatisfyReportLogic hasDataChange " + zM1354d);
        if (zM1354d) {
            return true;
        }
        C11839m.m70687e("ReportDeviceInfoManager", "isSatisfyReportLogic not satisfy data change logic");
        return false;
    }

    /* renamed from: e */
    public final void m73997e() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("ReportDeviceInfoManager", "reportDeviceInfo context null");
            return;
        }
        if (m73996d()) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            m73998f(contextM1377a, linkedHashMap);
            linkedHashMap.put("key_report_backup_app_flag", String.valueOf(jCurrentTimeMillis));
            UBAAnalyze.m29948I("CKC", "device_use_info_report", linkedHashMap);
            int iM1357g = C0212e0.m1357g(contextM1377a, "sp_device_use_info", "key_backup_item_length", 0);
            C11839m.m70686d("ReportDeviceInfoManager", "reportDeviceInfo backupAppSize " + iM1357g);
            if (iM1357g > 0) {
                for (int i10 = 0; i10 < iM1357g; i10++) {
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                    String strM1363m = C0212e0.m1363m(contextM1377a, "sp_device_use_info", "key_backup_app_item_info" + i10, "");
                    C11839m.m70686d("ReportDeviceInfoManager", "itemData " + i10 + strM1363m);
                    linkedHashMap2.put("key_report_backup_app_flag", String.valueOf(jCurrentTimeMillis));
                    linkedHashMap2.put("key_backup_app_item_info" + i10, strM1363m);
                    UBAAnalyze.m29948I("CKC", "device_use_info_report", linkedHashMap2);
                }
            }
            C0212e0.m1370t(contextM1377a, "sp_device_use_info", "key_report_time_mills", System.currentTimeMillis());
            C0212e0.m1365o(contextM1377a, "sp_device_use_info", "key_has_data_change", false);
        }
    }

    /* renamed from: f */
    public final void m73998f(Context context, LinkedHashMap<String, String> linkedHashMap) {
        boolean zM6139e;
        String strM1363m = C0212e0.m1363m(context, "sp_device_use_info", "key_total_size", "");
        C11839m.m70686d("ReportDeviceInfoManager", "totalSize " + strM1363m);
        linkedHashMap.put("key_total_size", strM1363m);
        String strM1363m2 = C0212e0.m1363m(context, "sp_device_use_info", "key_used_size", "");
        C11839m.m70686d("ReportDeviceInfoManager", "usedSize " + strM1363m2);
        linkedHashMap.put("key_used_size", strM1363m2);
        String strM1363m3 = C0212e0.m1363m(context, "sp_device_use_info", "key_image_size", "");
        C11839m.m70686d("ReportDeviceInfoManager", "imageSize " + strM1363m3);
        linkedHashMap.put("key_image_size", strM1363m3);
        String strM1363m4 = C0212e0.m1363m(context, "sp_device_use_info", "key_video_size", "");
        C11839m.m70686d("ReportDeviceInfoManager", "videoSize " + strM1363m4);
        linkedHashMap.put("key_video_size", strM1363m4);
        String strM1363m5 = C0212e0.m1363m(context, "sp_device_use_info", "key_audio_size", "");
        C11839m.m70686d("ReportDeviceInfoManager", "audioSize " + strM1363m5);
        linkedHashMap.put("key_audio_size", strM1363m5);
        String strM1363m6 = C0212e0.m1363m(context, "sp_device_use_info", "key_document_size", "");
        C11839m.m70686d("ReportDeviceInfoManager", "documentSize " + strM1363m6);
        linkedHashMap.put("key_document_size", strM1363m6);
        try {
            zM6139e = C1010e.m6125b().m6139e(context);
        } catch (Exception e10) {
            C11839m.m70687e("ReportDeviceInfoManager", "phoneFinderStatus " + e10.getMessage());
            zM6139e = false;
        }
        C11839m.m70686d("ReportDeviceInfoManager", "phoneFinderStatus " + zM6139e);
        linkedHashMap.put("key_phone_finder_status", String.valueOf(zM6139e));
        boolean zM5975v = C1006a.m5936k().m5975v(context);
        C11839m.m70686d("ReportDeviceInfoManager", "gallerySwitchStatus " + zM5975v);
        linkedHashMap.put("key_gallery_swtich_status", String.valueOf(zM5975v));
        boolean zM62388s = C10028c.m62182c0().m62388s("backup_key");
        C11839m.m70686d("ReportDeviceInfoManager", "cloudBackupStatus " + zM62388s);
        linkedHashMap.put("key_cloud_backup_status", String.valueOf(zM62388s));
    }

    public C12306e0() {
    }
}
