package com.huawei.hms.network.embedded;

import com.huawei.hms.framework.common.LimitQueue;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.ReflectionUtils;
import com.huawei.hms.network.httpclient.Interceptor;
import com.huawei.hms.network.httpclient.RequestFinishedInfo;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.network.embedded.o5 */
/* loaded from: classes8.dex */
public class C6034o5 {

    /* renamed from: b */
    public static final String f27608b = "RequestMetricsCache";

    /* renamed from: c */
    public static C6034o5 f27609c = new C6034o5();

    /* renamed from: d */
    public static volatile boolean f27610d = false;

    /* renamed from: e */
    public static volatile boolean f27611e = false;

    /* renamed from: f */
    public static String f27612f = "com.huawei.hms.network.httpclient.Interceptor$Chain";

    /* renamed from: a */
    public LimitQueue<C6021n5> f27613a = new LimitQueue<>(10, false);

    /* renamed from: com.huawei.hms.network.embedded.o5$a */
    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Interceptor.Chain f27614a;

        public a(Interceptor.Chain chain) {
            this.f27614a = chain;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptor.Chain chain;
            if (!C6034o5.this.m34918b() || (chain = this.f27614a) == null || chain.requestFinishedInfo() == null) {
                return;
            }
            RequestFinishedInfo.MetricsTime metricsTime = this.f27614a.requestFinishedInfo().getMetricsTime();
            if (metricsTime.getConnectEndTime() - metricsTime.getConnectStartTime() == 0) {
                return;
            }
            C6034o5.this.m34915a(new C6021n5(this.f27614a));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public boolean m34918b() {
        if (f27611e) {
            return f27610d;
        }
        f27610d = ReflectionUtils.checkCompatible(f27612f, C6047p5.f27701b, new Class[0]);
        f27611e = true;
        return f27610d;
    }

    /* renamed from: c */
    public static C6034o5 m34919c() {
        return f27609c;
    }

    /* renamed from: a */
    public String m34920a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version", "8.0.1.309");
            JSONArray jSONArray = new JSONArray();
            Iterator<C6021n5> it = this.f27613a.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().m34896i());
            }
            jSONObject.put(C6047p5.f27701b, jSONArray);
        } catch (JSONException unused) {
            Logger.m32145w(f27608b, "Get RequestMetricsCache Error");
        }
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m34915a(C6021n5 c6021n5) {
        this.f27613a.add(c6021n5);
    }

    /* renamed from: a */
    public void m34921a(Interceptor.Chain chain) {
        C6060q5.m35062a().m35063a(new a(chain));
    }
}
