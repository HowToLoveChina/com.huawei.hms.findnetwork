package com.huawei.android.hicloud.sync.syncutil;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import com.huawei.android.hicloud.sync.bean.ReportDataTypeDetail;
import com.huawei.android.hicloud.sync.bean.ReportSyncEndInfo;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import je.C10812z;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0213f;
import p514o9.C11839m;
import tc.C13007b;

/* renamed from: com.huawei.android.hicloud.sync.syncutil.i */
/* loaded from: classes3.dex */
public class C2980i {
    /* renamed from: b */
    public static void m17867b(String str) {
        C13007b.m78205Y(C0213f.m1377a()).m78274n(str);
        C13007b.m78205Y(C0213f.m1377a()).m78276o(str);
        C13007b.m78205Y(C0213f.m1377a()).m78254d(str);
        C13007b.m78205Y(C0213f.m1377a()).m78278p(str);
    }

    /* renamed from: c */
    public static void m17868c(Context context, String str, ReportSyncEndInfo reportSyncEndInfo, String str2) {
        if (reportSyncEndInfo == null) {
            return;
        }
        boolean zM1333z1 = C0209d.m1333z1(context);
        boolean zM15941B = CloudSyncUtil.m15941B(context);
        reportSyncEndInfo.setEndNetworkType(zM1333z1 ? 1 : 0);
        reportSyncEndInfo.setEndPlugged(zM15941B ? 1 : 0);
        reportSyncEndInfo.setEndTime(System.currentTimeMillis());
        m17878m(context, str, reportSyncEndInfo, str2);
        C11839m.m70686d("ReportEndUtil", "finalReportEndInfo: " + reportSyncEndInfo.toString());
        try {
            UBAAnalyze.m29952M("CKC", "cloudsync_sync_end", new JSONObject(reportSyncEndInfo.toString()));
        } catch (Exception e10) {
            C11839m.m70687e("ReportEndUtil", "finalReportEndInfo err " + e10.getMessage());
        }
    }

    /* renamed from: d */
    public static ReportDataTypeDetail m17869d(ReportSyncEndInfo reportSyncEndInfo, String str) {
        if (reportSyncEndInfo == null || TextUtils.isEmpty(str)) {
            return null;
        }
        List<ReportDataTypeDetail> dataTypeDetail = reportSyncEndInfo.getDataTypeDetail();
        if (dataTypeDetail == null) {
            dataTypeDetail = new ArrayList<>();
        }
        if (dataTypeDetail.isEmpty()) {
            ReportDataTypeDetail reportDataTypeDetail = new ReportDataTypeDetail();
            reportDataTypeDetail.setdType(str);
            dataTypeDetail.add(reportDataTypeDetail);
            reportSyncEndInfo.setDataTypeDetail(dataTypeDetail);
            return reportDataTypeDetail;
        }
        Map map = (Map) dataTypeDetail.stream().collect(Collectors.toMap(new Function() { // from class: com.huawei.android.hicloud.sync.syncutil.g
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ReportDataTypeDetail) obj).getdType();
            }
        }, new Function() { // from class: com.huawei.android.hicloud.sync.syncutil.h
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return C2980i.m17871f((ReportDataTypeDetail) obj);
            }
        }));
        if (map.containsKey(str) && map.get(str) != null) {
            return (ReportDataTypeDetail) map.get(str);
        }
        ReportDataTypeDetail reportDataTypeDetail2 = new ReportDataTypeDetail();
        reportDataTypeDetail2.setdType(str);
        dataTypeDetail.add(reportDataTypeDetail2);
        reportSyncEndInfo.setDataTypeDetail(dataTypeDetail);
        return reportDataTypeDetail2;
    }

    /* renamed from: e */
    public static void m17870e(Context context, String str, ReportSyncEndInfo reportSyncEndInfo) {
        if (reportSyncEndInfo == null) {
            return;
        }
        boolean zM1333z1 = C0209d.m1333z1(context);
        boolean zM15941B = CloudSyncUtil.m15941B(context);
        reportSyncEndInfo.setSyncType(str);
        reportSyncEndInfo.setStartNetworkType(zM1333z1 ? 1 : 0);
        reportSyncEndInfo.setStartPlugged(zM15941B ? 1 : 0);
        reportSyncEndInfo.setStartTime(System.currentTimeMillis());
        reportSyncEndInfo.setPrepareTraceId(C13007b.m78205Y(context).m78230M(str));
        reportSyncEndInfo.setPrepareTimes(C13007b.m78205Y(context).m78228L(str));
        reportSyncEndInfo.setFirstStartTime(C13007b.m78205Y(context).m78208B(str));
        reportSyncEndInfo.setSource(C13007b.m78205Y(context).m78243U(str));
    }

    /* renamed from: f */
    public static /* synthetic */ ReportDataTypeDetail m17871f(ReportDataTypeDetail reportDataTypeDetail) {
        return reportDataTypeDetail;
    }

    /* renamed from: g */
    public static void m17872g(ReportSyncEndInfo reportSyncEndInfo, String str, int i10) {
        ReportDataTypeDetail reportDataTypeDetailM17869d;
        if (reportSyncEndInfo == null || (reportDataTypeDetailM17869d = m17869d(reportSyncEndInfo, str)) == null) {
            return;
        }
        reportDataTypeDetailM17869d.setDc(reportDataTypeDetailM17869d.getDc() + i10);
    }

    /* renamed from: h */
    public static void m17873h(ReportSyncEndInfo reportSyncEndInfo, String str, long j10) {
        ReportDataTypeDetail reportDataTypeDetailM17869d;
        if (reportSyncEndInfo == null || (reportDataTypeDetailM17869d = m17869d(reportSyncEndInfo, str)) == null) {
            return;
        }
        reportDataTypeDetailM17869d.setDs(reportDataTypeDetailM17869d.getDs() + j10);
    }

    /* renamed from: i */
    public static void m17874i(ReportSyncEndInfo reportSyncEndInfo, String str, long j10) {
        ReportDataTypeDetail reportDataTypeDetailM17869d;
        if (reportSyncEndInfo == null || (reportDataTypeDetailM17869d = m17869d(reportSyncEndInfo, str)) == null) {
            return;
        }
        reportDataTypeDetailM17869d.setDt(reportDataTypeDetailM17869d.getDt() + j10);
    }

    /* renamed from: j */
    public static void m17875j(ReportSyncEndInfo reportSyncEndInfo, String str, int i10) {
        ReportDataTypeDetail reportDataTypeDetailM17869d;
        if (reportSyncEndInfo == null || (reportDataTypeDetailM17869d = m17869d(reportSyncEndInfo, str)) == null) {
            return;
        }
        reportDataTypeDetailM17869d.setUc(reportDataTypeDetailM17869d.getUc() + i10);
    }

    /* renamed from: k */
    public static void m17876k(ReportSyncEndInfo reportSyncEndInfo, String str, long j10) {
        ReportDataTypeDetail reportDataTypeDetailM17869d;
        if (reportSyncEndInfo == null || (reportDataTypeDetailM17869d = m17869d(reportSyncEndInfo, str)) == null) {
            return;
        }
        reportDataTypeDetailM17869d.setUs(reportDataTypeDetailM17869d.getUs() + j10);
    }

    /* renamed from: l */
    public static void m17877l(ReportSyncEndInfo reportSyncEndInfo, String str, long j10) {
        ReportDataTypeDetail reportDataTypeDetailM17869d;
        if (reportSyncEndInfo == null || (reportDataTypeDetailM17869d = m17869d(reportSyncEndInfo, str)) == null) {
            return;
        }
        reportDataTypeDetailM17869d.setUt(reportDataTypeDetailM17869d.getUt() + j10);
    }

    /* renamed from: m */
    public static void m17878m(Context context, String str, ReportSyncEndInfo reportSyncEndInfo, String str2) {
        if (reportSyncEndInfo == null) {
            return;
        }
        reportSyncEndInfo.setEndForground(!C0209d.m1234a2(context, C10812z.m65834c(context, str, str2)) ? 1 : 0);
    }

    /* renamed from: n */
    public static void m17879n(ReportSyncEndInfo reportSyncEndInfo, int i10, String str) {
        if (reportSyncEndInfo == null || i10 == 0) {
            return;
        }
        reportSyncEndInfo.setErrorCode(String.valueOf(i10));
        reportSyncEndInfo.setErrorReason(str);
    }

    /* renamed from: o */
    public static void m17880o(ReportSyncEndInfo reportSyncEndInfo, String str, String str2) {
        if (reportSyncEndInfo == null || TextUtils.isEmpty(str) || str2 == null) {
            return;
        }
        try {
            if (str2.isEmpty()) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str2);
            if (jSONObject.has("prepareTraceId")) {
                String strOptString = jSONObject.optString("prepareTraceId");
                if (!TextUtils.isEmpty(strOptString)) {
                    C13007b.m78205Y(C0213f.m1377a()).m78215E0(str, strOptString);
                    reportSyncEndInfo.setPrepareTraceId(strOptString);
                    C11839m.m70688i("ReportEndUtil", "local prepareTraceId = " + strOptString + ", syncType = " + str);
                }
            }
            if (jSONObject.has("prepareTimes")) {
                int iOptInt = jSONObject.optInt("prepareTimes");
                C13007b.m78205Y(C0213f.m1377a()).m78213D0(str, iOptInt);
                reportSyncEndInfo.setPrepareTimes(iOptInt);
                C11839m.m70688i("ReportEndUtil", "local prepareTimes = " + iOptInt + ", syncType = " + str);
            }
            if (jSONObject.has("firstStartTime")) {
                long jOptLong = jSONObject.optLong("firstStartTime");
                C13007b.m78205Y(C0213f.m1377a()).m78283r0(str, jOptLong);
                reportSyncEndInfo.setFirstStartTime(jOptLong);
                C11839m.m70688i("ReportEndUtil", "local firstPrepareTime = " + jOptLong + ", syncType = " + str);
            }
            if (jSONObject.has("thirdAppSyncScene")) {
                int iOptInt2 = jSONObject.optInt("thirdAppSyncScene");
                C13007b.m78205Y(C0213f.m1377a()).m78231M0(str, iOptInt2);
                reportSyncEndInfo.setSource(iOptInt2);
                C11839m.m70688i("ReportEndUtil", "third sync scene = " + iOptInt2 + ", syncType = " + str);
            }
        } catch (Exception e10) {
            C11839m.m70687e("ReportEndUtil", "setExtraInfo error " + e10.getMessage());
        }
    }

    /* renamed from: p */
    public static void m17881p(ReportSyncEndInfo reportSyncEndInfo, long j10) {
        if (reportSyncEndInfo == null) {
            return;
        }
        reportSyncEndInfo.setFirstStartTime(j10);
    }

    /* renamed from: q */
    public static void m17882q(ReportSyncEndInfo reportSyncEndInfo, boolean z10) {
        if (reportSyncEndInfo == null) {
            return;
        }
        reportSyncEndInfo.setHasAssets(z10 ? 1 : 0);
    }

    /* renamed from: r */
    public static void m17883r(ReportSyncEndInfo reportSyncEndInfo, boolean z10) {
        if (reportSyncEndInfo == null) {
            return;
        }
        reportSyncEndInfo.setIncFlag(!z10 ? 1 : 0);
    }

    /* renamed from: s */
    public static void m17884s(ReportSyncEndInfo reportSyncEndInfo, String str) {
        if (reportSyncEndInfo == null) {
            return;
        }
        reportSyncEndInfo.setTraceId(str);
    }

    /* renamed from: t */
    public static void m17885t(Context context, String str, ReportSyncEndInfo reportSyncEndInfo, String str2) {
        if (reportSyncEndInfo == null) {
            return;
        }
        reportSyncEndInfo.setStartForground(!C0209d.m1234a2(context, C10812z.m65834c(context, str, str2)) ? 1 : 0);
    }

    /* renamed from: u */
    public static void m17886u(ReportSyncEndInfo reportSyncEndInfo, String str) {
        if (reportSyncEndInfo == null) {
            return;
        }
        LinkedHashMap<String, String> linkedHashMapM65833b = C10812z.m65833b(str);
        reportSyncEndInfo.setThirdAppId(linkedHashMapM65833b.get("appId"));
        reportSyncEndInfo.setThirdAppPkgName(linkedHashMapM65833b.get("packageName"));
        reportSyncEndInfo.setThirdAppVersion(linkedHashMapM65833b.get("versionName"));
    }
}
