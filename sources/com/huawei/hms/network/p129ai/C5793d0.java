package com.huawei.hms.network.p129ai;

import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.network.httpclient.util.PreConnectManager;
import com.huawei.hms.network.inner.api.DnsNetworkService;
import com.huawei.hms.network.inner.api.NetworkKitInnerImpl;
import com.huawei.hms.network.inner.api.RequestContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;

/* renamed from: com.huawei.hms.network.ai.d0 */
/* loaded from: classes8.dex */
public class C5793d0 implements InterfaceC5802i {

    /* renamed from: x */
    public static final String f25785x = "InitModel";

    /* renamed from: b */
    public long f25787b;

    /* renamed from: c */
    public long f25788c;

    /* renamed from: j */
    public float f25795j;

    /* renamed from: k */
    public float f25796k;

    /* renamed from: l */
    public float f25797l;

    /* renamed from: m */
    public float f25798m;

    /* renamed from: n */
    public float f25799n;

    /* renamed from: o */
    public float f25800o;

    /* renamed from: p */
    public float f25801p;

    /* renamed from: q */
    public int f25802q;

    /* renamed from: r */
    public int f25803r;

    /* renamed from: a */
    public boolean f25786a = false;

    /* renamed from: d */
    public int f25789d = 50;

    /* renamed from: e */
    public float f25790e = 0.75f;

    /* renamed from: f */
    public int f25791f = 0;

    /* renamed from: g */
    public int f25792g = 1;

    /* renamed from: h */
    public int f25793h = 0;

    /* renamed from: i */
    public int f25794i = 1;

    /* renamed from: s */
    public int f25804s = 0;

    /* renamed from: t */
    public int f25805t = 0;

    /* renamed from: u */
    public HashMap<String, long[]> f25806u = new HashMap<>();

    /* renamed from: v */
    public Map<String, Boolean> f25807v = new LinkedHashMap();

    /* renamed from: w */
    public Map<String, Boolean> f25808w = new HashMap();

    /* renamed from: com.huawei.hms.network.ai.d0$a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() throws JSONException {
            C5793d0.this.m33307e();
        }
    }

    /* renamed from: com.huawei.hms.network.ai.d0$b */
    public class b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ RequestContext f25810a;

        public b(RequestContext requestContext) {
            this.f25810a = requestContext;
        }

        @Override // java.lang.Runnable
        public void run() {
            C5793d0.this.m33302b(this.f25810a);
        }
    }

    /* renamed from: com.huawei.hms.network.ai.d0$c */
    public class c implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ C5808l f25812a;

        public c(C5808l c5808l) {
            this.f25812a = c5808l;
        }

        @Override // java.lang.Runnable
        public void run() {
            C5793d0.this.m33303c(this.f25812a);
        }
    }

    /* renamed from: a */
    private float m33295a(String str) {
        return (Math.min(this.f25800o, this.f25806u.get(str)[this.f25793h]) / this.f25800o) * this.f25799n * this.f25795j;
    }

    /* renamed from: b */
    private float m33299b(String str) {
        return (1.0f - ((this.f25806u.get(str)[this.f25794i] / 1000) / (this.f25788c / 1000))) * this.f25799n * this.f25796k;
    }

    /* renamed from: h */
    private float[] m33304h() {
        int iMin = Math.min(this.f25807v.size(), this.f25803r);
        Iterator<Map.Entry<String, Boolean>> it = this.f25807v.entrySet().iterator();
        float f10 = 0.0f;
        float f11 = 0.0f;
        int i10 = 0;
        while (it.hasNext()) {
            if (it.next().getValue().booleanValue()) {
                f10 += 1.0f;
                if (i10 < iMin) {
                    f11 += 1.0f;
                }
            }
            i10++;
        }
        Iterator<Map.Entry<String, Boolean>> it2 = this.f25808w.entrySet().iterator();
        float f12 = 0.0f;
        while (it2.hasNext()) {
            if (it2.next().getValue().booleanValue()) {
                f12 += 1.0f;
            }
        }
        float[] fArr = new float[3];
        fArr[0] = iMin > 0 ? Math.round((f11 / iMin) * 100.0f) / 100.0f : 0.0f;
        fArr[1] = this.f25807v.size() > 0 ? Math.round((f10 / this.f25807v.size()) * 100.0f) / 100.0f : 0.0f;
        fArr[2] = this.f25808w.size() > 0 ? Math.round((f12 / this.f25808w.size()) * 100.0f) / 100.0f : 0.0f;
        return fArr;
    }

    /* renamed from: i */
    private void m33305i() {
        if (this.f25807v.size() != 0) {
            float[] fArrM33304h = m33304h();
            HashMap map = new HashMap();
            map.put(C5804j.f25911h, C5788b.f25731a);
            map.put(C5804j.f25907d, String.valueOf(fArrM33304h[0]));
            map.put(C5804j.f25908e, String.valueOf(fArrM33304h[1]));
            map.put(C5804j.f25915l, String.valueOf(fArrM33304h[2]));
            map.put(C5804j.f25909f, String.valueOf(Math.min(this.f25807v.size(), this.f25803r)));
            map.put(C5804j.f25910g, String.valueOf(this.f25807v.size()));
            map.put(C5804j.f25914k, this.f25804s == 0 ? "0" : String.valueOf(Math.round((this.f25805t / r0) * 100.0f) / 100.0f));
            C5804j.m33379a(map);
        }
    }

    @Override // com.huawei.hms.network.p129ai.InterfaceC5802i
    /* renamed from: c */
    public void mo33284c() {
        this.f25806u.clear();
        this.f25807v.clear();
        this.f25808w.clear();
    }

    /* renamed from: d */
    public boolean m33306d() {
        return this.f25786a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: e */
    public void m33307e() throws JSONException {
        Logger.m32141i(f25785x, "InitModule start execute");
        ArrayList arrayList = (ArrayList) C5792d.m33287c().m33293b(C5788b.f25731a).mo33237a();
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        Logger.m32141i(f25785x, "preFetchList size: " + arrayList.size());
        DnsNetworkService dnsNetworkService = (DnsNetworkService) NetworkKitInnerImpl.getInstance().getService("dns");
        for (int i10 = 0; i10 < Math.min(arrayList.size(), this.f25802q); i10++) {
            if (!TextUtils.isEmpty((CharSequence) arrayList.get(i10))) {
                if (i10 < Math.min(arrayList.size(), this.f25803r)) {
                    Logger.m32143v(f25785x, "Pre Connect : https://" + ((String) arrayList.get(i10)));
                    PreConnectManager.getInstance().connect((String) arrayList.get(i10), new PreConnectManager.ConnectCallBack());
                } else {
                    Logger.m32143v(f25785x, "Pre DNS : https://" + ((String) arrayList.get(i10)));
                    if (dnsNetworkService != null) {
                        dnsNetworkService.dnsPrefetch((String) arrayList.get(i10));
                    }
                }
                this.f25807v.put(arrayList.get(i10), Boolean.FALSE);
            }
        }
    }

    /* renamed from: f */
    public void m33308f() {
        this.f25787b = System.currentTimeMillis();
        this.f25788c = 300000L;
        this.f25789d = 50;
        this.f25790e = 0.7f;
        this.f25795j = 0.4f;
        this.f25796k = 0.2f;
        this.f25797l = 0.4f;
        this.f25798m = 50.0f;
        this.f25800o = 30.0f;
        this.f25801p = 10.0f;
        this.f25799n = 50.0f;
        this.f25802q = 10;
        this.f25803r = 5;
    }

    /* renamed from: g */
    public void m33309g() {
        InterfaceC5798g interfaceC5798gM33293b = C5792d.m33287c().m33293b(C5788b.f25731a);
        Map<String, int[]> map = (Map) interfaceC5798gM33293b.mo33245b();
        for (Map.Entry<String, int[]> entry : map.entrySet()) {
            String key = entry.getKey();
            boolean zContainsKey = this.f25806u.containsKey(key);
            int[] value = entry.getValue();
            if (zContainsKey) {
                int i10 = this.f25792g;
                value[i10] = value[i10] + 1;
            } else {
                value[this.f25792g] = 0;
            }
            float fM33300b = this.f25806u.containsKey(key) ? m33300b(map, key) : 0.0f;
            int i11 = map.get(key)[this.f25791f];
            int[] iArr = map.get(key);
            int i12 = this.f25791f;
            float f10 = this.f25790e;
            iArr[i12] = (int) ((fM33300b * (1.0f - f10)) + (f10 * i11));
        }
        for (String str : this.f25806u.keySet()) {
            if (!map.containsKey(str)) {
                float fM33300b2 = m33300b(map, str);
                float f11 = this.f25790e;
                map.put(str, new int[]{(int) ((fM33300b2 * (1.0f - f11)) + (f11 * this.f25789d)), 1});
            }
        }
        interfaceC5798gM33293b.mo33242a(map);
    }

    /* renamed from: a */
    private float m33296a(Map<String, int[]> map, String str) {
        if (map.get(str) != null) {
            return (Math.min(this.f25801p, map.get(str)[this.f25792g]) / this.f25801p) * this.f25799n * this.f25797l;
        }
        return 0.0f;
    }

    /* renamed from: b */
    private float m33300b(Map<String, int[]> map, String str) {
        return m33295a(str) + m33299b(str) + m33296a(map, str) + this.f25798m;
    }

    /* renamed from: c */
    public void m33303c(C5808l c5808l) {
        if (m33306d()) {
            Logger.m32136d(f25785x, "Initmodel train finished");
            return;
        }
        if (c5808l.m33421b() - this.f25787b >= this.f25788c) {
            Logger.m32136d(f25785x, "update train data");
            this.f25786a = true;
            m33305i();
            m33309g();
            return;
        }
        this.f25804s++;
        m33301b(c5808l);
        Logger.m32136d(f25785x, "add a train url " + c5808l.m33420a());
        long j10 = this.f25806u.containsKey(c5808l.m33420a()) ? 1 + this.f25806u.get(c5808l.m33420a())[this.f25793h] : 1L;
        if (this.f25806u.containsKey(c5808l.m33420a())) {
            this.f25806u.put(c5808l.m33420a(), new long[]{j10, this.f25806u.get(c5808l.m33420a())[this.f25794i]});
        } else {
            this.f25806u.put(c5808l.m33420a(), new long[]{j10, c5808l.m33421b() - this.f25787b});
        }
    }

    @Override // com.huawei.hms.network.p129ai.InterfaceC5802i
    /* renamed from: a */
    public void mo33279a() {
        m33308f();
        C5794e.m33310a().m33312b(new a());
    }

    @Override // com.huawei.hms.network.p129ai.InterfaceC5802i
    /* renamed from: b */
    public void mo33283b() {
    }

    /* renamed from: b */
    private void m33301b(C5808l c5808l) {
        if (this.f25807v.containsKey(c5808l.m33420a())) {
            this.f25807v.put(c5808l.m33420a(), Boolean.TRUE);
        }
    }

    /* renamed from: b */
    public void m33302b(RequestContext requestContext) {
        Map<String, Boolean> map;
        String url;
        Boolean bool;
        if (m33306d()) {
            Logger.m32136d(f25785x, "Initmodel train finished");
            return;
        }
        if (requestContext.requestFinishedInfo().getMetricsRealTime().getConnectEndTime() - requestContext.requestFinishedInfo().getMetricsRealTime().getConnectStartTime() == 0) {
            this.f25805t++;
            if (this.f25808w.containsKey(requestContext.request().getUrl())) {
                return;
            }
            map = this.f25808w;
            url = requestContext.request().getUrl();
            bool = Boolean.TRUE;
        } else {
            if (this.f25808w.containsKey(requestContext.request().getUrl())) {
                return;
            }
            map = this.f25808w;
            url = requestContext.request().getUrl();
            bool = Boolean.FALSE;
        }
        map.put(url, bool);
    }

    @Override // com.huawei.hms.network.p129ai.InterfaceC5802i
    /* renamed from: a */
    public void mo33281a(C5808l c5808l) {
        C5794e.m33310a().m33311a(new c(c5808l));
    }

    @Override // com.huawei.hms.network.p129ai.InterfaceC5802i
    /* renamed from: a */
    public void mo33282a(RequestContext requestContext) {
        if (requestContext.throwable() != null) {
            return;
        }
        C5794e.m33310a().m33311a(new b(requestContext));
    }
}
