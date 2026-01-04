package com.huawei.ads.adsrec;

import android.content.Context;
import com.huawei.ads.adsrec.p066db.table.AdTraceRecord;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.json.JSONObject;
import p216d4.AbstractC9003c0;
import p216d4.AbstractC9019k0;
import p216d4.AbstractC9038y;
import p216d4.C9008f;
import p216d4.C9020l;
import p216d4.C9022m;
import p216d4.InterfaceC9028p;
import p247e4.C9405a;
import p277f4.C9655a;
import p277f4.InterfaceC9656b;
import p357i4.C10438c;
import p384j4.AbstractC10702a;
import p384j4.AbstractC10706e;
import p384j4.AbstractC10707f;
import p405jt.AbstractC10915a;

/* loaded from: classes.dex */
public class AdRecommendEngine {

    /* renamed from: a */
    public final C2093e f9473a;

    /* renamed from: b */
    public C9008f f9474b;

    /* renamed from: c */
    public C2096q0 f9475c;

    /* renamed from: d */
    public InterfaceC9028p f9476d;

    /* renamed from: e */
    public Context f9477e;

    /* renamed from: com.huawei.ads.adsrec.AdRecommendEngine$a */
    public class RunnableC2089a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Set f9478a;

        /* renamed from: b */
        public final /* synthetic */ String f9479b;

        public RunnableC2089a(Set set, String str) {
            this.f9478a = set;
            this.f9479b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AbstractC10706e.m65374a(this.f9478a)) {
                return;
            }
            String strM56932a = AbstractC9019k0.m56932a(this.f9479b);
            if (AbstractC10707f.m65379d(strM56932a)) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (AdTraceRecord adTraceRecord : AdRecommendEngine.this.f9473a.m12569o(AdTraceRecord.class, null, null, null, null, null)) {
                if (Objects.equals(strM56932a, adTraceRecord.m12501D()) && this.f9478a.contains(adTraceRecord.m12508y())) {
                    adTraceRecord.m12505v(false);
                    arrayList.add(new C10438c(AdTraceRecord.class.getSimpleName(), null, null, "uniqueId=? and contentId=?", new String[]{strM56932a, adTraceRecord.m12508y()}, adTraceRecord.m64216r()));
                }
            }
            AdRecommendEngine.this.f9473a.m12568n(arrayList);
        }
    }

    /* renamed from: com.huawei.ads.adsrec.AdRecommendEngine$b */
    public class RunnableC2090b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ C9020l f9481a;

        /* renamed from: b */
        public final /* synthetic */ C9655a f9482b;

        /* renamed from: c */
        public final /* synthetic */ Map f9483c;

        public RunnableC2090b(C9020l c9020l, C9655a c9655a, Map map) {
            this.f9481a = c9020l;
            this.f9482b = c9655a;
            this.f9483c = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC9038y.m57000g(AdRecommendEngine.this.f9477e, this.f9481a, this.f9482b, this.f9483c);
            AbstractC9038y.m56999f(AdRecommendEngine.this.f9477e, this.f9481a, this.f9482b);
        }
    }

    /* renamed from: com.huawei.ads.adsrec.AdRecommendEngine$c */
    public class RunnableC2091c implements Runnable {
        public RunnableC2091c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AdRecommendEngine.this.f9476d.mo12558a();
            AdRecommendEngine.this.f9473a.m12562h();
        }
    }

    /* renamed from: com.huawei.ads.adsrec.AdRecommendEngine$d */
    public class RunnableC2092d implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ C9405a f9486a;

        public RunnableC2092d(C9405a c9405a) {
            this.f9486a = c9405a;
        }

        @Override // java.lang.Runnable
        public void run() {
            AdRecommendEngine.this.f9473a.m12548z(this.f9486a);
            AdRecommendEngine.this.f9473a.m12562h();
            new C2095n(AdRecommendEngine.this.f9477e).m12551a(false);
        }
    }

    public AdRecommendEngine(Context context) {
        this.f9477e = context.getApplicationContext();
        C2099v c2099v = new C2099v(context);
        this.f9476d = c2099v;
        this.f9474b = new C9008f(context, c2099v);
        this.f9475c = new C2096q0(context);
        this.f9473a = new C2093e(this.f9477e);
    }

    /* renamed from: b */
    public final Set<String> m12446b(C9655a c9655a, C9020l c9020l) {
        if (c9020l == null) {
            return null;
        }
        return c9020l.m56936d(c9655a.m60309o(), c9655a.m60308n(), c9655a);
    }

    /* renamed from: c */
    public final void m12447c() {
        AbstractC10702a.m65329h(new RunnableC2091c());
    }

    /* renamed from: d */
    public final void m12448d(C9020l c9020l, C9655a c9655a, Map<String, List<String>> map) {
        if (AbstractC10706e.m65374a(c9655a.m60296b())) {
            return;
        }
        AbstractC10702a.m65329h(new RunnableC2090b(c9020l, c9655a, map));
    }

    /* renamed from: e */
    public final void m12449e(String str, Set<String> set) {
        AbstractC10702a.m65329h(new RunnableC2089a(set, str));
    }

    /* renamed from: g */
    public final JSONObject m12450g(C9655a c9655a, C9020l c9020l) {
        Map<String, List<String>> mapM56870a = null;
        if (c9020l == null) {
            m12447c();
            return null;
        }
        try {
            if (!c9020l.m56947r()) {
                C9022m.m56949a(c9655a.m60307m()).mo56926a(this.f9477e, c9655a, c9020l);
                mapM56870a = AbstractC9003c0.m56870a(c9020l);
                c9020l = this.f9475c.m12552a(c9020l, c9655a);
                Set<String> setM12446b = m12446b(c9655a, c9020l);
                this.f9476d.mo12560b(c9020l.m56945p(), setM12446b);
                m12449e(c9655a.m60305k(), setM12446b);
            }
            m12448d(c9020l, c9655a, mapM56870a);
            JSONObject jSONObjectM56943n = c9020l.m56943n();
            m12447c();
            return jSONObjectM56943n;
        } catch (Throwable th2) {
            m12447c();
            throw th2;
        }
    }

    /* renamed from: i */
    public void m12451i(C9405a c9405a) {
        AbstractC10702a.m65329h(new RunnableC2092d(c9405a));
    }

    /* renamed from: j */
    public JSONObject m12452j(C9655a c9655a, InterfaceC9656b interfaceC9656b) {
        AbstractC10915a.m65973e("AdRecEngine", "recallAds %s", c9655a);
        if (c9655a == null) {
            return null;
        }
        c9655a.m60297c(0);
        return m12450g(c9655a, this.f9474b.mo12550b(c9655a, interfaceC9656b));
    }

    /* renamed from: k */
    public JSONObject m12453k(C9655a c9655a, String str) {
        try {
            AbstractC10915a.m65973e("AdRecEngine", "recallAds via api %s", c9655a);
            if (c9655a != null && str != null) {
                c9655a.m60297c(1);
                return m12450g(c9655a, this.f9474b.mo12549a(c9655a, new C9020l(c9655a.m60304j(), new JSONObject(str))));
            }
            return null;
        } catch (Throwable th2) {
            AbstractC10915a.m65979k("AdRecEngine", "recall via api error: %s", th2.getClass().getSimpleName());
            return null;
        }
    }
}
