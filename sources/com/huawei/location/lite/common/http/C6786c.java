package com.huawei.location.lite.common.http;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.ArrayMap;
import as.C1016d;
import com.huawei.location.lite.common.report.C6791a;
import com.huawei.location.lite.common.report.ReportBuilder;
import es.C9542g;
import es.C9552q;
import es.C9553r;
import p209cs.C8947c;
import p209cs.C8948d;
import p785xr.C13851a;

/* renamed from: com.huawei.location.lite.common.http.c */
/* loaded from: classes8.dex */
public class C6786c {

    /* renamed from: a */
    public ReportBuilder f31376a;

    public C6786c(ReportBuilder reportBuilder) {
        this.f31376a = reportBuilder;
        m38449b();
    }

    /* renamed from: a */
    public final void m38448a(C13851a c13851a, String str) {
        if (!TextUtils.equals(c13851a.m83127g(), "/networklocation/v1/onlineLocation") || TextUtils.equals(str, String.valueOf(200))) {
            return;
        }
        String strM83150c = c13851a.m83125e().m83150c("X-CP-Info");
        if (TextUtils.isEmpty(strM83150c)) {
            return;
        }
        this.f31376a.setExtParam("X-CP-Info", strM83150c);
    }

    /* renamed from: b */
    public final void m38449b() {
        if (this.f31376a == null) {
            this.f31376a = new ReportBuilder();
        }
        this.f31376a.setCallTime();
    }

    /* renamed from: c */
    public void m38450c(C13851a c13851a, String str, String str2) {
        ReportBuilder reportBuilder;
        if (c13851a == null) {
            C1016d.m6183c("HttpReportHelper", "request param exception");
            return;
        }
        if (TextUtils.equals("0", c13851a.m83125e().m83150c("NeedReport"))) {
            C1016d.m6190j("HttpReportHelper", "this request not need report");
            return;
        }
        if (this.f31376a == null) {
            this.f31376a = new ReportBuilder();
        }
        this.f31376a.setApiName("Location_serverApi");
        this.f31376a.setTransactionID(c13851a.m83125e().m83150c("X-Request-ID"));
        String strM83127g = c13851a.m83127g();
        if (strM83127g.length() > 60) {
            reportBuilder = this.f31376a;
            strM83127g = strM83127g.substring(0, 60);
        } else {
            reportBuilder = this.f31376a;
        }
        reportBuilder.setRequestUrl(strM83127g);
        if (!C9553r.m59645b(str)) {
            this.f31376a.setErrorCode(str);
        }
        if (!C9553r.m59645b(str2)) {
            this.f31376a.setErrorMessage(str2);
        }
        if (!TextUtils.equals(str, String.valueOf(200)) && TextUtils.isEmpty(this.f31376a.getMcc())) {
            this.f31376a.setMCC(m38452e(c13851a.m83121a()));
        }
        m38448a(c13851a, str);
        this.f31376a.setCostTime();
        try {
            if (C9552q.m59643a() == 100) {
                C6791a.m38458h().m38467l(this.f31376a);
                C6791a.m38458h().m38468m(this.f31376a);
            } else {
                C8948d c8948d = new C8948d();
                c8948d.m56671a(C9542g.m59588a().toJson(this.f31376a));
                Bundle bundle = new Bundle();
                bundle.putString("report_type", "server_report");
                c8948d.m56672b(bundle);
                C8947c.m56668a().m56669b(102, "report", c8948d, null);
            }
        } catch (Exception unused) {
            C1016d.m6183c("HttpReportHelper", "reportHttpResult exception");
        }
    }

    /* renamed from: d */
    public void m38451d(long j10) {
        this.f31376a.setExtParam("httpSdkCostTime", j10 + "");
    }

    /* renamed from: e */
    public final String m38452e(String str) {
        if (TextUtils.isEmpty(str)) {
            return "UNKNOWN";
        }
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("-drcn", "DR1");
        arrayMap.put("locationtest.", "DR1");
        arrayMap.put("-dra", "DR2");
        arrayMap.put("locationtestSingapore.", "DR2");
        arrayMap.put("-dre", "DR3");
        arrayMap.put("locationtestEurope.", "DR3");
        arrayMap.put("-drru", "DR4");
        arrayMap.put("locationtestRussia.", "DR4");
        for (String str2 : arrayMap.keySet()) {
            if (str.contains(str2)) {
                return (String) arrayMap.get(str2);
            }
        }
        return "UNKNOWN";
    }
}
