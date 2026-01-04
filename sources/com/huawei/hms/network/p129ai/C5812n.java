package com.huawei.hms.network.p129ai;

import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.network.httpclient.util.PreConnectManager;
import com.huawei.hms.network.inner.api.RequestContext;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;

/* renamed from: com.huawei.hms.network.ai.n */
/* loaded from: classes8.dex */
public class C5812n implements InterfaceC5802i {

    /* renamed from: t */
    public static final String f25968t = "DomainRelationModel";

    /* renamed from: a */
    public long f25969a;

    /* renamed from: b */
    public int f25970b;

    /* renamed from: c */
    public long f25971c;

    /* renamed from: j */
    public long f25978j;

    /* renamed from: l */
    public Map<String, List<Map.Entry<String, Integer>>> f25980l;

    /* renamed from: m */
    public Map<String, Map<String, Integer>> f25981m;

    /* renamed from: r */
    public Timer f25986r;

    /* renamed from: d */
    public int f25972d = 50;

    /* renamed from: e */
    public float f25973e = 0.75f;

    /* renamed from: f */
    public float f25974f = 0.8f;

    /* renamed from: g */
    public float f25975g = 0.2f;

    /* renamed from: h */
    public int f25976h = 10;

    /* renamed from: i */
    public int f25977i = 50;

    /* renamed from: k */
    public int f25979k = 600000;

    /* renamed from: n */
    public List<C5817q> f25982n = new ArrayList();

    /* renamed from: o */
    public List<C5816p> f25983o = new ArrayList();

    /* renamed from: p */
    public int f25984p = 0;

    /* renamed from: q */
    public int f25985q = 0;

    /* renamed from: s */
    public Map<String, C5810m> f25987s = new ConcurrentHashMap();

    /* renamed from: com.huawei.hms.network.ai.n$a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C5812n.this.m33457g();
            C5812n.this.m33456f();
            C5812n.this.m33453e();
            C5812n.this.m33461i();
        }
    }

    /* renamed from: com.huawei.hms.network.ai.n$b */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C5812n.this.m33450d();
        }
    }

    /* renamed from: com.huawei.hms.network.ai.n$c */
    public class c implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ RequestContext f25990a;

        public c(RequestContext requestContext) {
            this.f25990a = requestContext;
        }

        @Override // java.lang.Runnable
        public void run() {
            C5812n.this.m33445b(this.f25990a);
        }
    }

    /* renamed from: com.huawei.hms.network.ai.n$d */
    public class d implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ C5808l f25992a;

        public d(C5808l c5808l) {
            this.f25992a = c5808l;
        }

        @Override // java.lang.Runnable
        public void run() throws JSONException {
            C5812n.this.m33451d(this.f25992a);
        }
    }

    /* renamed from: com.huawei.hms.network.ai.n$e */
    public class e implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ C5808l f25994a;

        public e(C5808l c5808l) {
            this.f25994a = c5808l;
        }

        @Override // java.lang.Runnable
        public void run() {
            C5812n.this.m33454e(this.f25994a);
            C5812n.this.m33447c(this.f25994a);
            C5812n.m33464k(C5812n.this);
        }
    }

    /* renamed from: com.huawei.hms.network.ai.n$f */
    public class f implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Map.Entry f25996a;

        public f(Map.Entry entry) {
            this.f25996a = entry;
        }

        @Override // java.lang.Runnable
        public void run() {
            C5812n.this.f25983o.add(new C5816p((String) this.f25996a.getKey(), System.currentTimeMillis(), false));
        }
    }

    /* renamed from: com.huawei.hms.network.ai.n$g */
    public class g extends TimerTask {

        /* renamed from: com.huawei.hms.network.ai.n$g$a */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                InterfaceC5798g interfaceC5798gM33293b = C5792d.m33287c().m33293b(C5788b.f25732b);
                long jCurrentTimeMillis = System.currentTimeMillis();
                for (int size = C5812n.this.f25982n.size() - 1; size >= 0; size--) {
                    if (jCurrentTimeMillis - ((C5817q) C5812n.this.f25982n.get(size)).m33490b() > C5812n.this.f25969a) {
                        C5812n c5812n = C5812n.this;
                        c5812n.m33440a((C5817q) c5812n.f25982n.get(size));
                        C5812n.this.f25982n.remove(size);
                    }
                }
                interfaceC5798gM33293b.mo33242a(C5812n.this.f25987s);
                C5812n.this.f25987s.clear();
                C5812n.this.m33459h();
            }
        }

        public g() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            C5794e.m33310a().m33311a(new a());
        }
    }

    /* renamed from: a */
    private float m33435a(C5817q c5817q, String str) {
        float f10 = this.f25972d;
        long jLongValue = c5817q.f26029a.get(str).getKey().longValue() - c5817q.m33490b();
        float f11 = 100 - this.f25972d;
        return f10 + (this.f25974f * f11 * ((r5 - jLongValue) / this.f25969a)) + (((f11 * this.f25975g) * Math.min(c5817q.f26029a.get(str).getValue().intValue(), this.f25976h)) / this.f25976h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m33457g() {
        this.f25969a = 60000L;
        this.f25970b = 1;
        this.f25971c = 30000L;
        this.f25972d = 50;
        this.f25976h = 10;
        this.f25974f = 0.8f;
        this.f25975g = 0.2f;
        this.f25979k = 600000;
        this.f25977i = 50;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m33459h() {
        if (this.f25983o.isEmpty()) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        int i10 = 0;
        int i11 = 0;
        for (C5816p c5816p : this.f25983o) {
            if (jCurrentTimeMillis - c5816p.m33488c() > this.f25969a) {
                i10++;
                if (c5816p.m33487b()) {
                    i11++;
                }
            }
        }
        List<C5816p> list = this.f25983o;
        this.f25983o = list.subList(i10, list.size());
        HashMap map = new HashMap();
        map.put(C5804j.f25911h, C5788b.f25732b);
        float f10 = (i11 / i10) * 100.0f;
        map.put(C5804j.f25907d, String.valueOf(Math.round(f10) / 100.0f));
        map.put(C5804j.f25909f, String.valueOf(i10));
        map.put(C5804j.f25908e, String.valueOf(Math.round(f10) / 100.0f));
        map.put(C5804j.f25910g, String.valueOf(i10));
        map.put(C5804j.f25914k, this.f25984p == 0 ? "0" : String.valueOf(Math.round((this.f25985q / r1) * 100.0f) / 100.0f));
        C5804j.m33379a(map);
        this.f25985q = 0;
        this.f25984p = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m33461i() {
        this.f25986r = new Timer("NetworkKit_AIModel_DomainRelationModel_Timer");
        g gVar = new g();
        Timer timer = this.f25986r;
        long j10 = this.f25979k;
        timer.schedule(gVar, j10, j10);
    }

    /* renamed from: k */
    public static /* synthetic */ int m33464k(C5812n c5812n) {
        int i10 = c5812n.f25984p;
        c5812n.f25984p = i10 + 1;
        return i10;
    }

    @Override // com.huawei.hms.network.p129ai.InterfaceC5802i
    /* renamed from: b */
    public void mo33283b() {
        C5794e.m33310a().m33311a(new b());
    }

    /* renamed from: b */
    private void m33442b(C5808l c5808l) {
        this.f25982n.add(0, new C5817q(c5808l.m33420a(), c5808l.m33421b()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m33450d() {
        Timer timer = this.f25986r;
        if (timer != null) {
            timer.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m33453e() {
        InterfaceC5798g interfaceC5798gM33293b = C5792d.m33287c().m33293b(C5788b.f25732b);
        if (interfaceC5798gM33293b != null && (interfaceC5798gM33293b.mo33237a() instanceof Map)) {
            this.f25980l = (Map) interfaceC5798gM33293b.mo33237a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m33456f() {
        InterfaceC5798g interfaceC5798gM33293b = C5792d.m33287c().m33293b(C5788b.f25732b);
        if (interfaceC5798gM33293b != null && (interfaceC5798gM33293b.mo33245b() instanceof Map)) {
            this.f25981m = (Map) interfaceC5798gM33293b.mo33245b();
        }
    }

    @Override // com.huawei.hms.network.p129ai.InterfaceC5802i
    /* renamed from: a */
    public void mo33279a() {
        C5794e.m33310a().m33311a(new a());
    }

    @Override // com.huawei.hms.network.p129ai.InterfaceC5802i
    /* renamed from: c */
    public void mo33284c() {
        this.f25980l = new HashMap();
        this.f25981m = new HashMap();
        this.f25982n.clear();
        this.f25983o.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m33447c(C5808l c5808l) {
        if (this.f25983o.isEmpty()) {
            return;
        }
        for (int size = this.f25983o.size() - 1; size >= 0; size--) {
            C5816p c5816p = this.f25983o.get(size);
            if (c5808l.m33421b() - c5816p.m33488c() >= this.f25969a) {
                return;
            }
            if (c5816p.m33485a().equals(c5808l.m33420a())) {
                c5816p.m33486a(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m33451d(C5808l c5808l) throws JSONException {
        if (System.currentTimeMillis() - this.f25978j < this.f25971c) {
            return;
        }
        if (this.f25980l == null) {
            m33453e();
            if (this.f25980l == null) {
                return;
            }
        }
        if (c5808l != null && this.f25980l.containsKey(c5808l.m33420a())) {
            int iMin = Math.min(this.f25980l.get(c5808l.m33420a()).size(), this.f25970b);
            Logger.m32141i(f25968t, "prefetch size:" + this.f25980l.get(c5808l.m33420a()).subList(0, iMin).size());
            for (Map.Entry<String, Integer> entry : this.f25980l.get(c5808l.m33420a()).subList(0, iMin)) {
                if (!TextUtils.isEmpty(entry.getKey()) && entry.getValue().intValue() >= this.f25977i) {
                    Logger.m32136d(f25968t, "prefetch domain : " + entry.getKey());
                    PreConnectManager.getInstance().connect(entry.getKey(), new PreConnectManager.ConnectCallBack());
                    C5794e.m33310a().m33311a(new f(entry));
                }
            }
        }
        this.f25978j = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m33454e(C5808l c5808l) {
        int size = this.f25982n.size();
        if (this.f25982n.size() <= 0 || !this.f25982n.get(0).m33489a().equals(c5808l.m33420a()) || m33441a(c5808l.m33421b(), this.f25982n.get(0).m33490b())) {
            int i10 = -1;
            int i11 = 0;
            while (true) {
                if (i11 >= this.f25982n.size()) {
                    break;
                }
                C5817q c5817q = this.f25982n.get(i11);
                if (m33441a(c5808l.m33421b(), c5817q.m33490b())) {
                    size = i11;
                    break;
                }
                if (c5808l.m33420a().equals(c5817q.m33489a())) {
                    i10 = i11;
                } else {
                    if (!c5817q.f26029a.containsKey(c5808l.m33420a())) {
                        c5817q.f26029a.put(c5808l.m33420a(), new AbstractMap.SimpleEntry(Long.valueOf(c5808l.m33421b()), 0));
                    }
                    c5817q.f26029a.get(c5808l.m33420a()).setValue(Integer.valueOf(c5817q.f26029a.get(c5808l.m33420a()).getValue().intValue() + 1));
                }
                i11++;
            }
            for (int i12 = size; i12 < this.f25982n.size(); i12++) {
                m33440a(this.f25982n.get(i12));
            }
            if (size < this.f25982n.size()) {
                this.f25982n = this.f25982n.subList(0, size);
            }
            if (i10 > 0) {
                m33440a(this.f25982n.get(i10));
                this.f25982n.remove(i10);
            }
            m33442b(c5808l);
        }
    }

    @Override // com.huawei.hms.network.p129ai.InterfaceC5802i
    /* renamed from: a */
    public void mo33281a(C5808l c5808l) {
        C5794e.m33310a().m33312b(new d(c5808l));
        C5794e.m33310a().m33311a(new e(c5808l));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m33445b(RequestContext requestContext) {
        if (requestContext.requestFinishedInfo().getMetricsRealTime().getConnectEndTime() - requestContext.requestFinishedInfo().getMetricsRealTime().getConnectStartTime() == 0) {
            this.f25985q++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00ea  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m33440a(com.huawei.hms.network.p129ai.C5817q r11) {
        /*
            Method dump skipped, instructions count: 518
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.network.p129ai.C5812n.m33440a(com.huawei.hms.network.ai.q):void");
    }

    @Override // com.huawei.hms.network.p129ai.InterfaceC5802i
    /* renamed from: a */
    public void mo33282a(RequestContext requestContext) {
        if (requestContext.throwable() != null) {
            return;
        }
        C5794e.m33310a().m33311a(new c(requestContext));
    }

    /* renamed from: a */
    private boolean m33441a(long j10, long j11) {
        return j10 - j11 > this.f25969a;
    }
}
