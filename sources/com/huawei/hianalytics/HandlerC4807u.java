package com.huawei.hianalytics;

import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.location.p065a.C1529a;
import com.huawei.hianalytics.core.common.EnvUtils;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.framework.threadpool.TaskThread;
import com.huawei.hianalytics.p100dc.StateKeeper;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.hianalytics.process.HiAnalyticsManager;
import com.huawei.hms.feature.dynamic.InterfaceC5323b;
import com.huawei.hms.network.file.core.util.Utils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.huawei.hianalytics.u */
/* loaded from: classes5.dex */
public class HandlerC4807u extends Handler {

    /* renamed from: a */
    public String f21935a;

    /* renamed from: a */
    public WeakReference<C4809v> f21936a;

    /* renamed from: a */
    public final boolean f21937a;

    /* renamed from: b */
    public WeakReference<C4798p> f21938b;

    /* renamed from: c */
    public WeakReference<C4730b0> f21939c;

    /* renamed from: d */
    public WeakReference<C4727a0> f21940d;

    public HandlerC4807u(Looper looper, int i10, String str) {
        long jM29024b;
        int i11;
        super(looper);
        this.f21937a = Looper.myLooper() == Looper.getMainLooper();
        if (i10 != 1) {
            if (i10 == 2) {
                jM29024b = C4811w.m29047a().m29053b() + C4811w.m29047a().m29048a();
                i11 = 5;
            }
            this.f21935a = str;
        }
        jM29024b = C4803s.m29018a().m29024b() + C4803s.m29018a().m29020a();
        i11 = 4;
        sendEmptyMessageDelayed(i11, jM29024b);
        this.f21935a = str;
    }

    @Override // android.os.Handler
    public void handleMessage(final Message message) {
        if (this.f21937a) {
            TaskThread.getRecordThread().addToQueue(new Runnable() { // from class: pj.j
                @Override // java.lang.Runnable
                public final void run() {
                    this.f56362a.m29037b(message);
                }
            });
            return;
        }
        try {
            m29037b(message);
        } catch (Throwable th2) {
            HiLog.m28812w("handler", "handleMessage error:" + th2.getMessage());
        }
    }

    /* renamed from: a */
    public final void m29038a() {
        C4730b0 c4730b0;
        WeakReference<C4730b0> weakReference = this.f21939c;
        if (weakReference == null || (c4730b0 = weakReference.get()) == null) {
            return;
        }
        synchronized (c4730b0) {
            c4730b0.f21649e = C4785j.m28929b();
        }
    }

    /* renamed from: a */
    public final void m29037b(Message message) {
        C4809v c4809v;
        C4809v c4809v2;
        C4798p c4798p;
        String strM28908a;
        C4781h1 c4781h1;
        String string;
        C4730b0 c4730b0;
        C4809v c4809v3;
        C4798p c4798p2;
        WeakReference<C4727a0> weakReference;
        C4727a0 c4727a0;
        C4730b0 c4730b02;
        switch (message.what) {
            case 1:
                String str = (String) message.obj;
                WeakReference<C4809v> weakReference2 = this.f21936a;
                if (weakReference2 == null || (c4809v = weakReference2.get()) == null) {
                    return;
                }
                String strM28929b = C4785j.m28929b();
                if (TextUtils.isEmpty(strM28929b)) {
                    c4809v.f21947b = "";
                    c4809v.f21945a = 0L;
                    str = "";
                } else {
                    if (!TextUtils.isEmpty(c4809v.f21947b) && !TextUtils.equals(c4809v.f21947b, strM28929b)) {
                        c4809v.m29044b();
                    }
                    if (TextUtils.equals(c4809v.f21947b, strM28929b)) {
                        return;
                    }
                    c4809v.f21947b = strM28929b;
                    c4809v.f21945a = System.currentTimeMillis();
                }
                c4809v.f21948c = str;
                return;
            case 2:
                WeakReference<C4809v> weakReference3 = this.f21936a;
                if (weakReference3 == null || (c4809v2 = weakReference3.get()) == null) {
                    return;
                }
                c4809v2.m29045c();
                return;
            case 3:
                WeakReference<C4798p> weakReference4 = this.f21938b;
                if (weakReference4 == null || (c4798p = weakReference4.get()) == null) {
                    return;
                }
                c4798p.m28982b();
                return;
            case 4:
                HiLog.m28807d("handler", "handleMessage report");
                if (System.currentTimeMillis() - C4785j.m28896a("global_v2", "lastReportTime", 0L) < C4803s.m29018a().f21915a) {
                    return;
                }
                if (C4803s.m29018a().f21918a) {
                    if (InterfaceC4776g.f21821a[0].equals(this.f21935a)) {
                        WeakReference<C4798p> weakReference5 = this.f21938b;
                        if (weakReference5 != null && (c4798p2 = weakReference5.get()) != null) {
                            c4798p2.m28982b();
                        }
                        WeakReference<C4809v> weakReference6 = this.f21936a;
                        if (weakReference6 != null && (c4809v3 = weakReference6.get()) != null) {
                            c4809v3.m29045c();
                        }
                        if (C4803s.m29018a().f21928d) {
                            try {
                                Context appContext = EnvUtils.getAppContext();
                                Pair<Long, Long> pairM29021a = C4803s.m29018a().m29021a();
                                Map<String, C4800q> mapM28779a = new C4733c0().m28779a(((UsageStatsManager) appContext.getSystemService("usagestats")).queryEvents(((Long) pairM29021a.first).longValue(), ((Long) pairM29021a.second).longValue()));
                                JSONArray jSONArray = new JSONArray();
                                for (C4800q c4800q : ((HashMap) mapM28779a).values()) {
                                    if (c4800q.f21901a != 0 && c4800q.f21905c != 0) {
                                        JSONObject jSONObject = new JSONObject();
                                        jSONObject.put("start", pairM29021a.first);
                                        jSONObject.put("end", pairM29021a.second);
                                        jSONObject.put("packageName", c4800q.f21903a);
                                        jSONObject.put("firstTimeStamp", c4800q.f21902a);
                                        jSONObject.put("lastTimeStamp", c4800q.f21904b);
                                        jSONObject.put("launchCount", c4800q.f21901a);
                                        jSONObject.put(Utils.TOTAL_TIME, c4800q.f21905c);
                                        jSONArray.put(jSONObject);
                                    }
                                }
                                HiLog.m28807d("UC", "collect range " + pairM29021a + ", size " + jSONArray.length());
                                if (jSONArray.length() != 0) {
                                    HiAnalyticsInstance instanceByTag = HiAnalyticsManager.getInstanceByTag("ha_default_collection");
                                    if (instanceByTag != null) {
                                        JSONObject jSONObject2 = new JSONObject();
                                        jSONObject2.put("usages", jSONArray);
                                        jSONObject2.put("version", InterfaceC5323b.f24693t);
                                        instanceByTag.onEventSync(0, "102", jSONObject2);
                                    }
                                    C4803s.m29018a().getClass();
                                    C4785j.m28917a("global_v2", "lastCollectTime", System.currentTimeMillis());
                                }
                            } catch (Throwable th2) {
                                HiLog.m28811sw("UC", "collect " + th2.getMessage());
                            }
                        } else {
                            HiLog.m28809i("UC", "app usage is disable");
                        }
                    }
                    WeakReference<C4730b0> weakReference7 = this.f21939c;
                    if (weakReference7 != null && (c4730b0 = weakReference7.get()) != null) {
                        c4730b0.m28777b();
                    }
                    HiAnalyticsInstance instanceByTag2 = HiAnalyticsManager.getInstanceByTag("ha_default_collection");
                    if (instanceByTag2 != null) {
                        String strM28908a2 = C4785j.m28908a("global_v2", "sdkReportUrl", "");
                        if (!TextUtils.isEmpty(strM28908a2)) {
                            C4782i.m28891a().m28892a("ha_default_collection").f21711b.f21631c = strM28908a2;
                        }
                        if (TextUtils.isEmpty(C4785j.m28948f())) {
                            Pair<String, Boolean> pairM28899a = C4785j.m28899a(EnvUtils.getAppContext());
                            instanceByTag2.setOAID(0, (String) pairM28899a.first);
                            instanceByTag2.setOAIDTrackingFlag(0, ((Boolean) pairM28899a.second).booleanValue());
                        }
                        instanceByTag2.onReport(0);
                        C4785j.m28917a("global_v2", "lastReportTime", System.currentTimeMillis());
                    }
                }
                C4803s c4803sM29018a = C4803s.m29018a();
                c4803sM29018a.getClass();
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - C4785j.m28896a("global_v2", "lastReloadTime", 0L) > c4803sM29018a.f21920b) {
                    boolean z10 = c4803sM29018a.f21918a;
                    String[] strArr = InterfaceC4776g.f21821a;
                    int length = strArr.length;
                    int i10 = 0;
                    while (true) {
                        if (i10 < length) {
                            HiAnalyticsInstance instanceByTag3 = HiAnalyticsManager.getInstanceByTag(strArr[i10]);
                            if (instanceByTag3 == null) {
                                i10++;
                            } else {
                                String collectUrl = instanceByTag3.getCollectUrl();
                                if (!TextUtils.isEmpty(collectUrl) && (collectUrl.contains("metrics1-drcn") || collectUrl.contains("metrics-drcn") || collectUrl.contains("metrics1.data"))) {
                                    strM28908a = C4785j.m28908a("global_v2", "sdkConfigUrl", "");
                                    if (TextUtils.isEmpty(strM28908a)) {
                                        synchronized (C4781h1.f21826b) {
                                            try {
                                                if (C4781h1.f21825a == null) {
                                                    C4781h1.f21825a = new C4781h1(EnvUtils.getAppContext());
                                                }
                                                c4781h1 = C4781h1.f21825a;
                                            } finally {
                                            }
                                        }
                                        synchronized (c4781h1.f21828a) {
                                            string = c4781h1.f21827a.getSharedPreferences("qoes_remote_config", 0).getString("ab_base_url", "");
                                        }
                                        if (!TextUtils.isEmpty(string)) {
                                            strM28908a = string + "/abtest/1.0/com.huawei.hianalytics/AB/config";
                                        }
                                    }
                                }
                            }
                        }
                    }
                    strM28908a = "";
                    if (C4785j.m28938b("DcCfg", "common_cfg", strM28908a)) {
                        HiLog.m28807d(C1529a.f6575a, "reloadConfig success");
                        c4803sM29018a.m29022a();
                        C4785j.m28917a("global_v2", "lastReloadTime", jCurrentTimeMillis);
                        boolean z11 = c4803sM29018a.f21918a;
                        if (z11 != z10) {
                            if (z11) {
                                for (String str2 : InterfaceC4776g.f21821a) {
                                    if (HiAnalyticsManager.getInstanceByTag(str2) != null) {
                                        C4805t.m29033d(str2);
                                    }
                                }
                            } else {
                                synchronized (StateKeeper.class) {
                                    C4805t.m29026a();
                                }
                            }
                        }
                    } else {
                        HiLog.m28812w(C1529a.f6575a, "reloadConfig failed");
                    }
                }
                removeMessages(4);
                long j10 = C4803s.m29018a().f21915a;
                C4803s.m29018a().getClass();
                sendEmptyMessageDelayed(4, j10 + (new Random().nextInt(r2.f21919b) * 60000));
                return;
            case 5:
                if (!C4785j.m28950g() && C4811w.m29047a().f21961a && (weakReference = this.f21940d) != null && (c4727a0 = weakReference.get()) != null) {
                    synchronized (c4727a0) {
                        try {
                            HiLog.m28807d("MPL", "flush");
                            if (!C4794n.m28969a(EnvUtils.getAppContext()).checkAndClearTable()) {
                                ArrayList arrayList = new ArrayList();
                                ArrayList arrayList2 = new ArrayList();
                                try {
                                    List<C4813x> listM28739a = c4727a0.m28739a((List<String>) arrayList2);
                                    if (listM28739a.isEmpty()) {
                                        HiLog.m28807d("MPL", "no metric data");
                                    } else {
                                        Map<String, C4815y> mapM28740a = c4727a0.m28740a((List<String>) arrayList);
                                        ArrayList arrayList3 = new ArrayList();
                                        c4727a0.m28741a(listM28739a, arrayList2, arrayList3, mapM28740a);
                                        if (arrayList3.isEmpty()) {
                                            HiLog.m28807d("MPL", "no new metric data");
                                        } else if (c4727a0.m28742a(arrayList3, mapM28740a)) {
                                            c4727a0.m28741a(arrayList3, null, null, mapM28740a);
                                        }
                                        C4785j.m28934b();
                                    }
                                    C4785j.m28919a(arrayList2, arrayList);
                                } catch (Throwable unused) {
                                    HiLog.m28807d("MPL", "handle info failed");
                                }
                            }
                            c4727a0.f21617a.removeMessages(5);
                            c4727a0.f21617a.sendEmptyMessageDelayed(5, C4811w.m29047a().f21958a + C4811w.m29047a().m29048a());
                        } catch (Throwable th3) {
                            throw th3;
                        }
                    }
                }
                removeMessages(5);
                sendEmptyMessageDelayed(5, C4811w.m29047a().f21958a + C4811w.m29047a().m29048a());
                return;
            case 6:
                WeakReference<C4730b0> weakReference8 = this.f21939c;
                if (weakReference8 == null || (c4730b02 = weakReference8.get()) == null) {
                    return;
                }
                c4730b02.m28777b();
                return;
            case 7:
                m29038a();
                return;
            default:
                return;
        }
    }
}
