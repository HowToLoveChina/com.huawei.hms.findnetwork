package com.huawei.hms.framework.network.grs.p122g;

import android.content.Context;
import com.huawei.hms.framework.common.ExceptionCode;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.common.hianalytics.HianalyticsHelper;
import com.huawei.hms.framework.common.hianalytics.LinkedHashMapPack;
import com.huawei.hms.framework.network.grs.p122g.p124j.C5451a;
import com.huawei.hms.network.embedded.C6148x2;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.framework.network.grs.g.e */
/* loaded from: classes8.dex */
public class C5446e {

    /* renamed from: com.huawei.hms.framework.network.grs.g.e$a */
    public class a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ long f24972a;

        /* renamed from: b */
        final /* synthetic */ ArrayList f24973b;

        /* renamed from: c */
        final /* synthetic */ JSONArray f24974c;

        public a(long j10, ArrayList arrayList, JSONArray jSONArray) {
            this.f24972a = j10;
            this.f24973b = arrayList;
            this.f24974c = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            C5451a c5451a = new C5451a();
            c5451a.put("total_time", this.f24972a);
            Iterator it = this.f24973b.iterator();
            while (it.hasNext()) {
                C5445d c5445d = (C5445d) it.next();
                if (c5445d.m32289o() || c5445d.m32287m()) {
                    c5451a.put(C5446e.m32292b(c5445d));
                    it.remove();
                    break;
                }
            }
            if (this.f24973b.size() > 0) {
                C5445d c5445d2 = (C5445d) this.f24973b.get(r1.size() - 1);
                c5451a.put(C5446e.m32292b(c5445d2));
                this.f24973b.remove(c5445d2);
            }
            if (this.f24973b.size() > 0) {
                Iterator it2 = this.f24973b.iterator();
                while (it2.hasNext()) {
                    this.f24974c.put(new JSONObject(C5446e.m32292b((C5445d) it2.next())));
                }
            }
            if (this.f24974c.length() > 0) {
                c5451a.put(C6148x2.FAILED_INFO, this.f24974c.toString());
            }
            Logger.m32137d("HaReportHelper", "grssdk report data to aiops is: %s", new JSONObject(c5451a.get()));
            HianalyticsHelper.getInstance().onEvent(c5451a.get(), "grs_request");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static LinkedHashMap<String, String> m32292b(C5445d c5445d) {
        LinkedHashMapPack linkedHashMapPack = new LinkedHashMapPack();
        Exception excM32278d = c5445d.m32278d();
        if (excM32278d != null) {
            linkedHashMapPack.put("error_code", ExceptionCode.getErrorCodeFromException(excM32278d));
            linkedHashMapPack.put("exception_name", excM32278d.getClass().getSimpleName());
            linkedHashMapPack.put("message", StringUtils.anonymizeMessage(excM32278d.getMessage()));
        } else {
            linkedHashMapPack.put("error_code", c5445d.m32274b());
            linkedHashMapPack.put("exception_name", c5445d.m32277c());
        }
        try {
            linkedHashMapPack.put("domain", new URL(c5445d.m32286l()).getHost());
        } catch (MalformedURLException e10) {
            Logger.m32146w("HaReportHelper", "report host MalformedURLException", e10);
        }
        linkedHashMapPack.put("req_start_time", c5445d.m32282h());
        linkedHashMapPack.put("req_end_time", c5445d.m32281g());
        linkedHashMapPack.put("req_total_time", c5445d.m32283i());
        return linkedHashMapPack.getAll();
    }

    /* renamed from: a */
    public static void m32291a(ArrayList<C5445d> arrayList, long j10, JSONArray jSONArray, Context context) {
        if (context == null || arrayList == null || arrayList.size() <= 0 || !HianalyticsHelper.getInstance().isEnableReport(context)) {
            return;
        }
        HianalyticsHelper.getInstance().getReportExecutor().submit(new a(j10, arrayList, jSONArray));
    }
}
