package com.huawei.hms.network.p129ai;

import com.huawei.hms.framework.common.Logger;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.network.ai.i0 */
/* loaded from: classes8.dex */
public class C5803i0 {

    /* renamed from: d */
    public static final String f25887d = "AIModelBasicDowloadInfoRequestBean";

    /* renamed from: a */
    public String f25888a;

    /* renamed from: b */
    public c f25889b = new c();

    /* renamed from: c */
    public a f25890c = new a();

    /* renamed from: com.huawei.hms.network.ai.i0$a */
    public class a {

        /* renamed from: a */
        public b f25891a;

        /* renamed from: b */
        public String f25892b;

        /* renamed from: c */
        public String f25893c;

        public a() {
            this.f25891a = C5803i0.this.new b();
        }

        /* renamed from: a */
        public String m33359a() {
            return this.f25892b;
        }

        /* renamed from: b */
        public String m33362b() {
            return this.f25893c;
        }

        /* renamed from: c */
        public b m33364c() {
            return this.f25891a;
        }

        /* renamed from: a */
        public void m33360a(b bVar) {
            this.f25891a = bVar;
        }

        /* renamed from: b */
        public void m33363b(String str) {
            this.f25893c = str;
        }

        /* renamed from: a */
        public void m33361a(String str) {
            this.f25892b = str;
        }
    }

    /* renamed from: com.huawei.hms.network.ai.i0$b */
    public class b {

        /* renamed from: a */
        public String f25895a;

        /* renamed from: b */
        public String f25896b;

        /* renamed from: c */
        public String f25897c;

        /* renamed from: d */
        public String f25898d;

        public b() {
        }

        /* renamed from: a */
        public String m33365a() {
            return this.f25895a;
        }

        /* renamed from: b */
        public String m33367b() {
            return this.f25898d;
        }

        /* renamed from: c */
        public String m33369c() {
            return this.f25896b;
        }

        /* renamed from: d */
        public String m33371d() {
            return this.f25897c;
        }

        /* renamed from: a */
        public void m33366a(String str) {
            this.f25895a = str;
        }

        /* renamed from: b */
        public void m33368b(String str) {
            this.f25898d = str;
        }

        /* renamed from: c */
        public void m33370c(String str) {
            this.f25896b = str;
        }

        /* renamed from: d */
        public void m33372d(String str) {
            this.f25897c = str;
        }
    }

    /* renamed from: com.huawei.hms.network.ai.i0$c */
    public class c {

        /* renamed from: a */
        public String f25900a;

        /* renamed from: b */
        public String f25901b;

        /* renamed from: c */
        public String f25902c;

        public c() {
        }

        /* renamed from: a */
        public String m33373a() {
            return this.f25901b;
        }

        /* renamed from: b */
        public String m33375b() {
            return this.f25902c;
        }

        /* renamed from: c */
        public String m33377c() {
            return this.f25900a;
        }

        /* renamed from: a */
        public void m33374a(String str) {
            this.f25901b = str;
        }

        /* renamed from: b */
        public void m33376b(String str) {
            this.f25902c = str;
        }

        /* renamed from: c */
        public void m33378c(String str) {
            this.f25900a = str;
        }
    }

    /* renamed from: a */
    public a m33352a() {
        return this.f25890c;
    }

    /* renamed from: b */
    public c m33356b() {
        return this.f25889b;
    }

    /* renamed from: c */
    public String m33357c() {
        return this.f25888a;
    }

    /* renamed from: d */
    public String m33358d() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject.put("version", m33357c());
            jSONObject2.put("uuid", m33356b().m33377c());
            jSONObject2.put("scene", m33356b().m33373a());
            jSONObject2.put("subScene", m33356b().m33375b());
            jSONObject.put("meta", jSONObject2);
            jSONObject4.put("emuiVer", m33352a().m33364c().m33369c());
            jSONObject4.put("romVer", m33352a().m33364c().m33371d());
            jSONObject4.put(JsbMapKeyNames.H5_DEVICE_TYPE, m33352a().m33364c().m33367b());
            jSONObject3.put("extData", jSONObject4);
            jSONObject3.put("currentModelName", m33352a().m33359a());
            jSONObject3.put("currentModelVersion", m33352a().m33362b());
            jSONObject.put("data", jSONObject3);
        } catch (JSONException unused) {
            Logger.m32138e(f25887d, "toJsonString meet error");
        }
        return jSONObject.toString();
    }

    /* renamed from: a */
    public void m33353a(a aVar) {
        this.f25890c = aVar;
    }

    /* renamed from: a */
    public void m33354a(c cVar) {
        this.f25889b = cVar;
    }

    /* renamed from: a */
    public void m33355a(String str) {
        this.f25888a = str;
    }
}
