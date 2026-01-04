package com.huawei.hianalytics;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huawei.hianalytics.core.common.EnvUtils;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.core.storage.CommonHeaderEx;
import com.huawei.hianalytics.core.storage.DaoManager;
import com.huawei.hianalytics.core.storage.Event;
import com.huawei.hianalytics.core.transport.Utils;
import com.huawei.hianalytics.framework.datahandler.ReportTask;
import com.huawei.hianalytics.framework.threadpool.TaskThread;
import com.huawei.secure.android.common.encrypt.aes.AesGcm;
import cu.C8952a;
import gu.C10048b;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hianalytics.f1 */
/* loaded from: classes5.dex */
public class RunnableC4753f1 implements Runnable {

    /* renamed from: a */
    public final Context f21738a;

    /* renamed from: a */
    public final String f21739a;

    /* renamed from: a */
    public final List<Event> f21740a = new ArrayList();

    /* renamed from: b */
    public final List<CommonHeaderEx> f21741b = new ArrayList();

    public RunnableC4753f1(Context context, String str) {
        this.f21738a = context;
        this.f21739a = str;
    }

    /* renamed from: a */
    public final void m28832a(String str, Object obj, String str2) throws JSONException, UnsupportedEncodingException {
        String str3;
        if (obj instanceof String) {
            JSONArray jSONArray = new JSONArray((String) obj);
            int length = jSONArray.length();
            if (length > 5000) {
                HiLog.m28812w("InitDataSupport", "array size is too long");
                return;
            }
            for (int i10 = 0; i10 < length; i10++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i10);
                if (System.currentTimeMillis() - Utils.parseStringToLong(jSONObject.getString(Event.EventConstants.RECORD_TIME)) <= 604800000) {
                    String strM56686h = C8952a.m56686h(jSONObject.optString("stat_v2_1".equals(str2) ? "content" : Event.EventConstants.PROPERTIES), C4799p0.m28983a().m28984a());
                    if (TextUtils.isEmpty(strM56686h)) {
                        HiLog.m28809i("InitDataSupport", "decryptCbc content is empty");
                        str3 = "";
                    } else {
                        String strM62473e = C10048b.m62473e(12);
                        str3 = strM62473e + AesGcm.encrypt(strM56686h, C4799p0.m28983a().m28984a(), strM62473e);
                    }
                    if (TextUtils.isEmpty(str3)) {
                        HiLog.m28809i("InitDataSupport", "content is empty");
                    } else {
                        Event event = new Event();
                        event.formJson(jSONObject);
                        event.setServicetag(str);
                        event.setContent(str3);
                        event.setProcessname(C4785j.m28944d());
                        this.f21740a.add(event);
                    }
                }
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() throws UnsupportedEncodingException {
        if (C4785j.m28927a("global_v2", "v2_1DataHandlerFlag", false)) {
            HiLog.m28809i("InitDataSupport", "cached data by HASDKV2 has already handled. tag: " + this.f21739a);
        } else {
            m28831a("stat_v2_1");
            m28831a("cached_v2_1");
            long jM28895a = C4785j.m28895a(this.f21738a, "common_nc");
            if (jM28895a != -1) {
                if (jM28895a > 5242880) {
                    HiLog.m28809i("InitDataSupport", "sp stat file length > 5M, begin delete it");
                    if (C4785j.m28937b(this.f21738a, "common_nc")) {
                        HiLog.m28809i("InitDataSupport", "sp stat file delete success");
                    }
                } else {
                    SharedPreferences sharedPreferencesM28898a = C4785j.m28898a("common_nc");
                    Map<String, ?> all = sharedPreferencesM28898a == null ? null : sharedPreferencesM28898a.getAll();
                    C4785j.m28937b(this.f21738a, "common_nc");
                    if (all != null && !all.isEmpty()) {
                        for (Map.Entry<String, ?> entry : all.entrySet()) {
                            String key = entry.getKey();
                            if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty((String) entry.getValue())) {
                                CommonHeaderEx commonHeaderEx = new CommonHeaderEx();
                                commonHeaderEx.setEvtExHashCode(key);
                                commonHeaderEx.setCommonHeaderEx((String) entry.getValue());
                                this.f21741b.add(commonHeaderEx);
                            }
                        }
                    }
                }
            }
            C4785j.m28937b(this.f21738a, "backup_event");
            if (!this.f21740a.isEmpty()) {
                C4792m c4792mM28963a = C4792m.m28963a(this.f21738a);
                List<Event> list = this.f21740a;
                c4792mM28963a.getClass();
                DaoManager.getInstance().insertEvents(list);
            }
            if (!this.f21741b.isEmpty()) {
                C4792m c4792mM28963a2 = C4792m.m28963a(this.f21738a);
                List<CommonHeaderEx> list2 = this.f21741b;
                c4792mM28963a2.getClass();
                DaoManager.getInstance().insertHeaders(list2);
            }
            if (TextUtils.isEmpty("v2_1DataHandlerFlag") || TextUtils.isEmpty("global_v2")) {
                HiLog.m28808e("SharedPreUtils", "spName or spKey is empty");
            } else {
                SharedPreferences sharedPreferencesM28898a2 = C4785j.m28898a("global_v2");
                if (sharedPreferencesM28898a2 != null) {
                    SharedPreferences.Editor editorEdit = sharedPreferencesM28898a2.edit();
                    editorEdit.putBoolean("v2_1DataHandlerFlag", true);
                    editorEdit.commit();
                }
            }
        }
        String str = C4782i.m28891a().m28893a().f21857i;
        String str2 = C4782i.m28891a().m28893a().f21856h;
        if (TextUtils.isEmpty(str)) {
            HiLog.m28809i("InitDataSupport", "app ver is first save. tag: " + this.f21739a);
            return;
        }
        if (str.equals(str2)) {
            return;
        }
        HiLog.m28809i("InitDataSupport", "the appVers are different. tag: " + this.f21739a);
        if (C4785j.m28936b(EnvUtils.getAppContext())) {
            TaskThread.getReportThread().addToQueue(new ReportTask("", "", str, 500, 0));
            return;
        }
        HiLog.m28811sw("InitDataSupport", "the network is unavailable. tag: " + this.f21739a);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0084 A[EXC_TOP_SPLITTER, PHI: r4
  0x0084: PHI (r4v1 java.lang.String) = (r4v0 java.lang.String), (r4v5 java.lang.String) binds: [B:24:0x0063, B:32:0x0081] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m28831a(java.lang.String r7) throws java.io.UnsupportedEncodingException {
        /*
            r6 = this;
            android.content.Context r0 = r6.f21738a
            long r0 = com.huawei.hianalytics.C4785j.m28895a(r0, r7)
            r2 = -1
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 != 0) goto Ld
            return
        Ld:
            r2 = 5242880(0x500000, double:2.590327E-317)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            java.lang.String r1 = "InitDataSupport"
            if (r0 <= 0) goto L29
            java.lang.String r0 = "sp stat file length > 5M, begin delete it"
            com.huawei.hianalytics.core.log.HiLog.m28809i(r1, r0)
            android.content.Context r6 = r6.f21738a
            boolean r6 = com.huawei.hianalytics.C4785j.m28937b(r6, r7)
            if (r6 == 0) goto L28
            java.lang.String r6 = "sp stat file delete success"
            com.huawei.hianalytics.core.log.HiLog.m28809i(r1, r6)
        L28:
            return
        L29:
            android.content.SharedPreferences r0 = com.huawei.hianalytics.C4785j.m28898a(r7)
            if (r0 != 0) goto L31
            r0 = 0
            goto L35
        L31:
            java.util.Map r0 = r0.getAll()
        L35:
            android.content.Context r2 = r6.f21738a
            com.huawei.hianalytics.C4785j.m28937b(r2, r7)
            if (r0 == 0) goto L92
            boolean r2 = r0.isEmpty()
            if (r2 == 0) goto L43
            goto L92
        L43:
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L4b:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L92
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r4 = "_default_config_tag"
            boolean r5 = r4.equals(r3)
            if (r5 == 0) goto L66
            goto L84
        L66:
            java.lang.String r4 = "-"
            java.lang.String[] r3 = r3.split(r4)
            int r4 = r3.length
            r5 = 2
            if (r4 == r5) goto L71
            goto L4b
        L71:
            r4 = 0
            r4 = r3[r4]
            r5 = 1
            r3 = r3[r5]
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 != 0) goto L4b
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L84
            goto L4b
        L84:
            java.lang.Object r2 = r2.getValue()     // Catch: org.json.JSONException -> L8c
            r6.m28832a(r4, r2, r7)     // Catch: org.json.JSONException -> L8c
            goto L4b
        L8c:
            java.lang.String r2 = "cache data is not json format"
            com.huawei.hianalytics.core.log.HiLog.m28808e(r1, r2)
            goto L4b
        L92:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hianalytics.RunnableC4753f1.m28831a(java.lang.String):void");
    }
}
