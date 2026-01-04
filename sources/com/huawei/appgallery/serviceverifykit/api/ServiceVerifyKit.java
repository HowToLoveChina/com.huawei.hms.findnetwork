package com.huawei.appgallery.serviceverifykit.api;

import ai.C0201a;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import ci.C1441b;
import com.huawei.appgallery.serviceverifykit.p097c.C4583a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p844zh.C14301a;

/* loaded from: classes4.dex */
public class ServiceVerifyKit {

    public static final class PkgVerifyBuilder {

        /* renamed from: a */
        public Context f21045a;

        /* renamed from: b */
        public String f21046b = "AppGallery Verification";

        /* renamed from: c */
        public String f21047c = "Huawei CBG Cloud Security Signer";

        /* renamed from: d */
        public String f21048d = "com.huawei.appgallery.fingerprint_signature";

        /* renamed from: e */
        public String f21049e = "com.huawei.appgallery.sign_certchain";

        /* renamed from: f */
        public final Map<String, String[]> f21050f = new HashMap();

        public PkgVerifyBuilder(Context context) {
            this.f21045a = context;
        }
    }

    /* renamed from: com.huawei.appgallery.serviceverifykit.api.ServiceVerifyKit$a */
    public static class C4580a {

        /* renamed from: a */
        public String f21051a;

        /* renamed from: k */
        public Context f21061k;

        /* renamed from: l */
        public int f21062l;

        /* renamed from: o */
        public Intent f21065o;

        /* renamed from: p */
        public a f21066p;

        /* renamed from: r */
        public String f21068r;

        /* renamed from: s */
        public String f21069s;

        /* renamed from: b */
        public String f21052b = "AppGallery Verification";

        /* renamed from: c */
        public String f21053c = "Huawei CBG Cloud Security Signer";

        /* renamed from: d */
        public String f21054d = "com.huawei.appgallery.fingerprint_signature";

        /* renamed from: e */
        public String f21055e = "com.huawei.appgallery.sign_certchain";

        /* renamed from: f */
        public Map<String, String[]> f21056f = new HashMap();

        /* renamed from: g */
        public Map<String, String> f21057g = new HashMap();

        /* renamed from: h */
        public Map<String, Integer> f21058h = new HashMap();

        /* renamed from: i */
        public List<String> f21059i = new ArrayList();

        /* renamed from: j */
        public List<C4582c> f21060j = new ArrayList();

        /* renamed from: m */
        public int f21063m = 0;

        /* renamed from: n */
        public int f21064n = 0;

        /* renamed from: q */
        public String f21067q = "verify_match_property";

        /* renamed from: com.huawei.appgallery.serviceverifykit.api.ServiceVerifyKit$a$a */
        public enum a {
            ACTIVITY,
            SERVICE,
            BROADCAST
        }

        /* renamed from: a */
        public C4580a m28092a(String str, String str2) {
            this.f21056f.put(str, ServiceVerifyKit.m28090d(this.f21056f.get(str), str2));
            this.f21058h.put(str, Integer.valueOf(this.f21063m));
            return this;
        }

        /* renamed from: b */
        public String m28093b() {
            ServiceVerifyKit serviceVerifyKit = new ServiceVerifyKit();
            C4583a c4583a = new C4583a(this.f21061k);
            this.f21057g.put(this.f21054d, this.f21055e);
            c4583a.m28111k(this.f21051a, this.f21052b, this.f21053c, this.f21056f, this.f21058h, this.f21062l, this.f21059i, this.f21060j, this.f21064n, this.f21067q, this.f21068r, this.f21065o, this.f21066p, this.f21057g, this.f21069s);
            return serviceVerifyKit.m28091b(c4583a);
        }

        /* renamed from: c */
        public C4580a m28094c(String str) {
            if (TextUtils.isEmpty(str)) {
                C1441b.f6211b.m8284a("ServiceVerifyKit", "error input chain key");
            } else {
                this.f21055e = str;
            }
            return this;
        }

        /* renamed from: d */
        public C4580a m28095d(String str) {
            if (TextUtils.isEmpty(str)) {
                C1441b.f6211b.m8284a("ServiceVerifyKit", "error input signer key");
            } else {
                this.f21054d = str;
            }
            return this;
        }

        /* renamed from: e */
        public C4580a m28096e(Context context) {
            this.f21061k = context.getApplicationContext();
            return this;
        }

        /* renamed from: f */
        public C4580a m28097f(List<String> list) {
            if (list.isEmpty()) {
                C1441b.f6211b.m8284a("ServiceVerifyKit", "error input preferred package name");
            } else {
                this.f21059i = list;
            }
            return this;
        }

        /* renamed from: g */
        public C4580a m28098g(Intent intent, a aVar) {
            if (intent == null) {
                C1441b.f6211b.m8284a("ServiceVerifyKit", "error input intent");
            } else {
                this.f21065o = intent;
            }
            if (aVar == null) {
                C1441b.f6211b.m8284a("ServiceVerifyKit", "error input type");
            } else {
                this.f21066p = aVar;
            }
            return this;
        }
    }

    /* renamed from: com.huawei.appgallery.serviceverifykit.api.ServiceVerifyKit$c */
    public static class C4582c {

        /* renamed from: a */
        public String f21074a;

        /* renamed from: b */
        public String f21075b;

        /* renamed from: a */
        public String m28099a() {
            return this.f21074a;
        }

        /* renamed from: b */
        public String m28100b() {
            return this.f21075b;
        }
    }

    public ServiceVerifyKit() {
    }

    public /* synthetic */ ServiceVerifyKit(C4581b c4581b) {
        this();
    }

    /* renamed from: d */
    public static String[] m28090d(String[] strArr, String str) {
        if (strArr == null) {
            return new String[]{str};
        }
        int length = strArr.length;
        for (String str2 : strArr) {
            if (TextUtils.equals(str2, str)) {
                return strArr;
            }
        }
        String[] strArr2 = new String[length + 1];
        System.arraycopy(strArr, 0, strArr2, 0, length);
        strArr2[length] = str;
        return strArr2;
    }

    /* renamed from: b */
    public final String m28091b(C4583a c4583a) {
        List<C14301a> listM28107g = c4583a.m28107g();
        if (listM28107g == null || listM28107g.isEmpty()) {
            return null;
        }
        return new C0201a().m1114a(listM28107g);
    }
}
