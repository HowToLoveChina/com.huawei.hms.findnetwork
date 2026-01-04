package com.huawei.hianalytics;

import android.text.TextUtils;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.core.transport.Utils;
import com.huawei.hianalytics.framework.listener.IHAEventListener;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.hianalytics.process.HiAnalyticsManager;
import java.util.LinkedHashMap;

/* renamed from: com.huawei.hianalytics.c1 */
/* loaded from: classes5.dex */
public class C4734c1 implements IHAEventListener {
    /* renamed from: a */
    public static String m28780a(String str, String str2) {
        return str + "_" + str2;
    }

    @Override // com.huawei.hianalytics.framework.listener.IHAEventListener
    public void metricReport(String str) {
        HandlerC4807u handlerC4807u;
        if (C4811w.m29047a().f21966c.contains(str) && (handlerC4807u = C4805t.f21934b) != null && C4805t.m29031b() && !C4785j.m28950g()) {
            handlerC4807u.removeMessages(5);
            handlerC4807u.sendEmptyMessage(5);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0034  */
    @Override // com.huawei.hianalytics.framework.listener.IHAEventListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onEvent(java.lang.String r5, java.lang.String r6, java.lang.String r7) {
        /*
            r4 = this;
            java.lang.String r0 = "ha_default_collection"
            boolean r1 = r0.equals(r5)
            if (r1 == 0) goto L9
            return
        L9:
            com.huawei.hianalytics.process.HiAnalyticsInstance r0 = com.huawei.hianalytics.process.HiAnalyticsManager.getInstanceByTag(r0)
            if (r0 != 0) goto L10
            return
        L10:
            int r1 = r6.hashCode()     // Catch: java.lang.Exception -> L51
            r2 = -1403792647(0xffffffffac53d2f9, float:-3.0102017E-12)
            r3 = 1
            if (r1 == r2) goto L2a
            r2 = 1274936771(0x4bfdfdc3, float:3.3291142E7)
            if (r1 == r2) goto L20
            goto L34
        L20:
            java.lang.String r1 = "$discard_list"
            boolean r1 = r6.equals(r1)     // Catch: java.lang.Exception -> L51
            if (r1 == 0) goto L34
            r1 = 0
            goto L35
        L2a:
            java.lang.String r1 = "$retry_list"
            boolean r1 = r6.equals(r1)     // Catch: java.lang.Exception -> L51
            if (r1 == 0) goto L34
            r1 = r3
            goto L35
        L34:
            r1 = -1
        L35:
            if (r1 == 0) goto L3e
            if (r1 == r3) goto L3a
            goto L58
        L3a:
            r4.m28781a(r0, r5, r6)     // Catch: java.lang.Exception -> L51
            goto L58
        L3e:
            java.util.LinkedHashMap r4 = new java.util.LinkedHashMap     // Catch: java.lang.Exception -> L51
            r4.<init>()     // Catch: java.lang.Exception -> L51
            java.lang.String r1 = "$content"
            r4.put(r1, r7)     // Catch: java.lang.Exception -> L51
            java.lang.String r7 = "$tag"
            r4.put(r7, r5)     // Catch: java.lang.Exception -> L51
            r0.onEvent(r3, r6, r4)     // Catch: java.lang.Exception -> L51
            goto L58
        L51:
            java.lang.String r4 = "HAEL"
            java.lang.String r5 = "fail to on ha event"
            com.huawei.hianalytics.core.log.HiLog.m28812w(r4, r5)
        L58:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hianalytics.C4734c1.onEvent(java.lang.String, java.lang.String, java.lang.String):void");
    }

    @Override // com.huawei.hianalytics.framework.listener.IHAEventListener
    public void onReport(String str) {
        if ("ha_default_collection".equals(str)) {
            return;
        }
        try {
            if (System.currentTimeMillis() - C4785j.m28896a("global_v2", m28780a(str, "report_ha_event_time"), 0L) < 43200000) {
                HiLog.m28807d("HAEL", "report ha event interval is greater than 12 hours. tag:" + str);
                return;
            }
            HiAnalyticsInstance instanceByTag = HiAnalyticsManager.getInstanceByTag("ha_default_collection");
            if (instanceByTag == null) {
                return;
            }
            instanceByTag.onReport(1);
            C4785j.m28917a("global_v2", m28780a(str, "report_ha_event_time"), System.currentTimeMillis());
        } catch (Exception unused) {
            HiLog.m28812w("HAEL", "fail to report ha event");
        }
    }

    @Override // com.huawei.hianalytics.framework.listener.IHAEventListener
    public void reportAppEvent() {
        HandlerC4807u handlerC4807u = C4805t.f21932a;
        if (handlerC4807u == null) {
            return;
        }
        if (System.currentTimeMillis() - C4785j.m28896a("global_v2", "lastReportTime", 0L) < C4803s.m29018a().f21924c) {
            return;
        }
        handlerC4807u.removeMessages(4);
        handlerC4807u.sendEmptyMessage(4);
    }

    /* renamed from: a */
    public final void m28781a(HiAnalyticsInstance hiAnalyticsInstance, String str, String str2) {
        String strM28780a;
        StringBuilder sb2;
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strM28908a = C4785j.m28908a("global_v2", m28780a(str, "send_retry_info"), "");
        if (TextUtils.isEmpty(strM28908a)) {
            C4785j.m28918a("global_v2", m28780a(str, "send_retry_info"), jCurrentTimeMillis + ",1");
            return;
        }
        String[] strArrSplit = strM28908a.split(",");
        long stringToLong = Utils.parseStringToLong(strArrSplit[0]);
        String str3 = strArrSplit[1];
        if (jCurrentTimeMillis - stringToLong > 43200000) {
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.put("$content", str3);
            linkedHashMap.put("$tag", str);
            hiAnalyticsInstance.onEvent(1, str2, linkedHashMap);
            strM28780a = m28780a(str, "send_retry_info");
            sb2 = new StringBuilder();
            sb2.append(jCurrentTimeMillis);
            sb2.append(",0");
        } else {
            long stringToLong2 = Utils.parseStringToLong(str3) + 1;
            strM28780a = m28780a(str, "send_retry_info");
            sb2 = new StringBuilder();
            sb2.append(stringToLong);
            sb2.append(",");
            sb2.append(stringToLong2);
        }
        C4785j.m28918a("global_v2", strM28780a, sb2.toString());
    }
}
