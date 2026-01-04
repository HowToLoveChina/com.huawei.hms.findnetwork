package com.huawei.hms.network.embedded;

import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.network.embedded.C6055q0;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;

/* renamed from: com.huawei.hms.network.embedded.n0 */
/* loaded from: classes8.dex */
public class C6016n0 {

    /* renamed from: c */
    public static final String f27534c = "HttpDnsClient";

    /* renamed from: d */
    public static final String f27535d = "?type=ALL&domains=";

    /* renamed from: e */
    public static final String f27536e = "/v1/";

    /* renamed from: f */
    public static final String f27537f = "/batch-resolve";

    /* renamed from: a */
    public String f27538a;

    /* renamed from: b */
    public final C6055q0 f27539b = new C6055q0(m34876a());

    /* renamed from: b */
    private C6003m0 m34874b(String str) {
        C6003m0 c6003m0M33733a = C5843a0.m33733a(str);
        return C6158y.m35829b(c6003m0M33733a) ? InterfaceC5938h0.f26897b.lookup(str) : c6003m0M33733a;
    }

    /* renamed from: a */
    public C6003m0 m34875a(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return new C6003m0();
        }
        C6055q0.a aVarM35049a = this.f27539b.m35049a();
        if (aVarM35049a != null && aVarM35049a.m35052a()) {
            Logger.m32145w("HttpDnsClient", "HttpDns server is retry-after");
            return new C6003m0();
        }
        if (str.equals(C6029o0.m34910e().m34912b())) {
            return m34874b(str);
        }
        C6003m0 c6003m0M35048a = this.f27539b.m35048a(str);
        c6003m0M35048a.m34743b(3);
        c6003m0M35048a.m34737a(0);
        return c6003m0M35048a;
    }

    /* renamed from: a */
    public final String m34876a() throws PackageManager.NameNotFoundException {
        String str;
        if (!TextUtils.isEmpty(this.f27538a)) {
            return this.f27538a;
        }
        String strM34913c = C6029o0.m34910e().m34913c();
        String strM34914d = C6029o0.m34910e().m34914d();
        if (TextUtils.isEmpty(strM34913c) || TextUtils.isEmpty(strM34914d)) {
            str = "";
        } else {
            str = strM34913c + f27536e + strM34914d + f27537f + f27535d;
        }
        this.f27538a = str;
        return this.f27538a;
    }

    /* renamed from: b */
    public C6029o0 m34878b() {
        return C6029o0.m34910e();
    }

    /* renamed from: a */
    public ArrayList<C6003m0> m34877a(List<String> list) {
        if (list == null || list.isEmpty()) {
            return new ArrayList<>();
        }
        list.remove(C6029o0.m34910e().m34912b());
        if (list.isEmpty()) {
            return new ArrayList<>();
        }
        C6055q0.a aVarM35049a = this.f27539b.m35049a();
        return (aVarM35049a == null || !aVarM35049a.m35052a()) ? this.f27539b.m35050a(list) : new ArrayList<>();
    }
}
