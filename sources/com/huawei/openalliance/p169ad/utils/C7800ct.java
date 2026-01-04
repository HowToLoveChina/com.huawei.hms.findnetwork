package com.huawei.openalliance.p169ad.utils;

import android.content.Context;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6982bz;
import com.huawei.openalliance.p169ad.C6984ca;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.InterfaceC6999cp;
import com.huawei.openalliance.p169ad.constant.FlavorConstants;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.utils.ct */
/* loaded from: classes2.dex */
public class C7800ct {

    /* renamed from: a */
    private static final byte[] f36039a = new byte[0];

    /* renamed from: b */
    private static C7800ct f36040b;

    /* renamed from: c */
    private String f36041c;

    /* renamed from: d */
    private String f36042d;

    /* renamed from: e */
    private String f36043e;

    /* renamed from: com.huawei.openalliance.ad.utils.ct$a */
    public static class a implements Runnable {

        /* renamed from: a */
        private final Context f36044a;

        /* renamed from: b */
        private final String f36045b;

        public a(Context context, String str) {
            this.f36044a = context;
            this.f36045b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f36045b == null) {
                AbstractC7185ho.m43826d("ServerConfig", "Must set application name for GRS: HiAd.setApplicationName");
                return;
            }
            String strMo41186o = C6982bz.m41148a(this.f36044a).mo41186o();
            InterfaceC6999cp interfaceC6999cpM41165a = C6984ca.m41165a(this.f36044a);
            interfaceC6999cpM41165a.mo41218a(this.f36045b);
            interfaceC6999cpM41165a.mo41220b(strMo41186o);
            AbstractC7185ho.m43820b("ServerConfig", "country:" + strMo41186o);
            Map<String, String> mapMo41221c = interfaceC6999cpM41165a.mo41221c(FlavorConstants.HIAD_GRS_SERVICE_NAME);
            HashMap map = new HashMap();
            if (mapMo41221c != null && !mapMo41221c.isEmpty()) {
                for (Map.Entry<String, String> entry : mapMo41221c.entrySet()) {
                    String strM47567c = AbstractC7741ao.m47567c(entry.getValue());
                    map.put(entry.getKey() + strMo41186o, strM47567c);
                    AbstractC7185ho.m43820b("ServerConfig", "url:" + AbstractC7819dl.m48375a(strM47567c));
                }
                C7124fh.m43316b(this.f36044a).mo43330a(map);
            }
            if (C7843v.m48511a()) {
                C7843v.m48509a(this.f36044a);
            }
        }
    }

    private C7800ct() {
    }

    /* renamed from: a */
    public static C7800ct m48114a() {
        C7800ct c7800ct;
        synchronized (f36039a) {
            try {
                if (f36040b == null) {
                    f36040b = new C7800ct();
                }
                c7800ct = f36040b;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c7800ct;
    }

    /* renamed from: b */
    public String m48118b() {
        return this.f36042d;
    }

    /* renamed from: c */
    public String m48121c() {
        return this.f36043e;
    }

    /* renamed from: d */
    public void m48123d(String str) {
        if (C7843v.m48511a()) {
            C7843v.m48510a(str);
        }
    }

    /* renamed from: a */
    public void m48115a(Context context) {
        AbstractC7185ho.m43820b("ServerConfig", "init");
        AbstractC7834m.m48481b(new a(context, this.f36041c));
    }

    /* renamed from: b */
    public void m48119b(Context context) {
        if (AbstractC7806cz.m48165b(this.f36041c)) {
            AbstractC7185ho.m43823c("ServerConfig", "asyncGetUrl, appNameBlank");
        } else {
            AbstractC7185ho.m43820b("ServerConfig", "asyncGetUrl");
            AbstractC7834m.m48481b(new a(context, this.f36041c));
        }
    }

    /* renamed from: c */
    public void m48122c(String str) {
        this.f36041c = str;
    }

    /* renamed from: a */
    public void m48116a(Context context, boolean z10) {
    }

    /* renamed from: b */
    public void m48120b(String str) {
        this.f36043e = str;
    }

    /* renamed from: a */
    public void m48117a(String str) {
        this.f36042d = str;
    }
}
