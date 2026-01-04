package com.huawei.hianalytics;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.framework.threadpool.TaskThread;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.hianalytics.process.HiAnalyticsManager;
import com.huawei.hms.feature.dynamic.InterfaceC5323b;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.huawei.hianalytics.p */
/* loaded from: classes5.dex */
public class C4798p extends AbstractC4786j0 {

    /* renamed from: a */
    public static long f21886a;

    /* renamed from: a */
    public final List<a> f21887a;

    /* renamed from: com.huawei.hianalytics.p$a */
    public static class a {

        /* renamed from: a */
        public final long f21888a;

        /* renamed from: a */
        public final String f21889a;

        /* renamed from: b */
        public final String f21890b;

        public a(String str, String str2, long j10) {
            this.f21889a = str;
            this.f21890b = str2;
            this.f21888a = j10;
        }
    }

    public C4798p(Handler handler, String str) {
        super(handler, str);
        this.f21887a = new ArrayList();
    }

    @Override // com.huawei.hianalytics.AbstractC4786j0
    /* renamed from: a */
    public void mo28775a() {
    }

    /* renamed from: b */
    public /* synthetic */ void m28979b(Bundle bundle) {
        try {
            String string = bundle.getString("toPackage");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            m28981a(bundle.getString("fromPackage"), string);
        } catch (Throwable th2) {
            HiLog.m28809i("CC1", "cache " + th2.getMessage());
        }
    }

    /* renamed from: a */
    public final synchronized void m28981a(String str, String str2) {
        try {
            ((AbstractC4786j0) this).f21834a.removeMessages(3);
            this.f21887a.add(new a(str, str2, System.currentTimeMillis()));
            if (this.f21887a.size() >= C4803s.m29018a().f21914a) {
                m28982b();
            } else {
                ((AbstractC4786j0) this).f21834a.sendEmptyMessageDelayed(3, C4803s.m29018a().f21927d);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: b */
    public synchronized void m28982b() {
        HiAnalyticsInstance instanceByTag;
        if (this.f21887a.isEmpty()) {
            return;
        }
        try {
            instanceByTag = HiAnalyticsManager.getInstanceByTag("ha_default_collection");
        } catch (Throwable th2) {
            HiLog.m28809i("CC1", "flush fail: " + th2.getMessage());
        }
        if (instanceByTag == null) {
            this.f21887a.clear();
            return;
        }
        JSONArray jSONArray = new JSONArray();
        for (a aVar : this.f21887a) {
            aVar.getClass();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(RemoteMessageConst.FROM, aVar.f21889a);
            jSONObject.put(RemoteMessageConst.f29664TO, aVar.f21890b);
            jSONObject.put("time", aVar.f21888a);
            jSONArray.put(jSONObject);
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("apps", jSONArray);
        jSONObject2.put("version", InterfaceC5323b.f24693t);
        instanceByTag.onEventSync(0, "100", jSONObject2);
        this.f21887a.clear();
        return;
    }

    @Override // com.huawei.hianalytics.AbstractC4786j0
    /* renamed from: a */
    public void mo28776a(final Bundle bundle) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - f21886a > 5000) {
            f21886a = jCurrentTimeMillis;
            if (!C4785j.m28950g()) {
                ((AbstractC4786j0) this).f21834a.removeMessages(5);
                ((AbstractC4786j0) this).f21834a.sendEmptyMessage(5);
            }
        }
        if (System.currentTimeMillis() - C4785j.m28896a("global_v2", "lastReportTime", 0L) >= C4803s.m29018a().f21915a) {
            ((AbstractC4786j0) this).f21834a.removeMessages(4);
            ((AbstractC4786j0) this).f21834a.sendEmptyMessageDelayed(4, new Random().nextInt(30) * 1000);
        }
        if (InterfaceC4776g.f21821a[0].equals(((AbstractC4786j0) this).f21835a) && C4803s.m29018a().f21922b) {
            TaskThread.getRecordThread().addToQueue(new Runnable() { // from class: pj.d
                @Override // java.lang.Runnable
                public final void run() {
                    this.f56356a.m28979b(bundle);
                }
            });
        }
    }
}
