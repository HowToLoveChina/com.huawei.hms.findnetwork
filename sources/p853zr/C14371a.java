package p853zr;

import android.content.Context;
import android.text.TextUtils;
import as.C1016d;
import aw.InterfaceC1028a;
import com.huawei.hms.location.BuildConfig;
import com.huawei.hms.network.embedded.C5863b6;
import com.huawei.location.lite.common.report.C6791a;
import com.huawei.wisesecurity.ucs.credential.Credential;
import com.huawei.wisesecurity.ucs.credential.CredentialClient;
import com.huawei.wisesecurity.ucs.credential.crypto.signer.CredentialSignAlg;
import com.huawei.wisesecurity.ucs.credential.crypto.signer.CredentialSigner;
import com.huawei.wisesecurity.ucs.credential.outer.GrsCapability;
import com.huawei.wisesecurity.ucs.credential.outer.HACapability;
import com.huawei.wisesecurity.ucs.credential.outer.NetworkCapability;
import com.huawei.wisesecurity.ucs.credential.outer.NetworkRequest;
import com.huawei.wisesecurity.ucs.credential.outer.NetworkResponse;
import es.C9549n;
import gs.C10043a;
import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import mr.C11506a;
import okhttp3.AbstractC11920f0;
import okhttp3.C11910a0;
import okhttp3.C11912b0;
import okhttp3.C11918e0;
import okhttp3.C11922g0;
import okhttp3.C11955v;
import p436kv.InterfaceC11162b;
import p531or.C11991a;
import p688ur.C13241a;
import p688ur.C13243c;
import p820yr.C14038b;
import p857zv.C14387a;
import p857zv.C14389c;
import sr.C12847b;

/* renamed from: zr.a */
/* loaded from: classes8.dex */
public class C14371a {

    /* renamed from: a */
    public Credential f63734a;

    /* renamed from: b */
    public CredentialClient f63735b;

    /* renamed from: zr.a$b */
    public static class b implements GrsCapability {
        public b() {
        }

        @Override // com.huawei.wisesecurity.ucs.credential.outer.GrsCapability
        public String synGetGrsUrl(String str, String str2) {
            C1016d.m6181a("UCSSignHelper", "GrsCapabilityImpl synGetGrsUrl" + str);
            return C12847b.m77151f(C10043a.m62448a(), str, str2);
        }
    }

    /* renamed from: zr.a$c */
    public static class c implements HACapability {
        public c() {
        }

        @Override // com.huawei.wisesecurity.ucs.credential.outer.HACapability
        public void onEvent(Context context, String str, InterfaceC11162b interfaceC11162b) {
            C6791a.m38458h().m38466k(1, str, interfaceC11162b.build());
        }
    }

    /* renamed from: zr.a$d */
    public static class d implements InterfaceC1028a {
        public d() {
        }

        @Override // aw.InterfaceC1028a
        /* renamed from: d */
        public void mo6226d(String str, String str2) {
            C1016d.m6181a(str, str2);
        }

        @Override // aw.InterfaceC1028a
        /* renamed from: e */
        public void mo6227e(String str, String str2) {
            C1016d.m6183c(str, str2);
        }

        @Override // aw.InterfaceC1028a
        /* renamed from: i */
        public void mo6228i(String str, String str2) {
            C1016d.m6186f(str, str2);
        }

        @Override // aw.InterfaceC1028a
        /* renamed from: w */
        public void mo6229w(String str, String str2) {
            C1016d.m6190j(str, str2);
        }
    }

    /* renamed from: zr.a$e */
    public static class e implements NetworkCapability {
        public e() {
        }

        /* renamed from: a */
        public final NetworkResponse m85567a(C11918e0 c11918e0) throws IOException {
            C11912b0.c cVar = new C11912b0.c();
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            try {
                C11922g0 c11922g0Execute = cVar.m71506c(10000L, timeUnit).m71507d(10000L, timeUnit).m71520q(false).m71505b().m71495z(c11918e0).execute();
                NetworkResponse networkResponse = new NetworkResponse();
                networkResponse.setCode(c11922g0Execute.m71597u());
                networkResponse.setHeaders(c11922g0Execute.m71601y().m71858k());
                if (c11922g0Execute.m71595s() != null) {
                    networkResponse.setBody(c11922g0Execute.m71595s().m71637z());
                }
                return networkResponse;
            } catch (IOException e10) {
                C1016d.m6183c("UCSSignHelper", "UCS http failed by exception");
                throw e10;
            }
        }

        @Override // com.huawei.wisesecurity.ucs.credential.outer.NetworkCapability
        public NetworkResponse get(NetworkRequest networkRequest) throws IOException {
            C1016d.m6181a("UCSSignHelper", "NetworkCapabilityImpl ucs http getUrl：" + networkRequest.getUrl());
            return m85567a(new C11918e0.a().m71586m(networkRequest.getUrl()).m71579f(C11955v.m71851h(networkRequest.getHeaders())).m71575b());
        }

        @Override // com.huawei.wisesecurity.ucs.credential.outer.NetworkCapability
        public void initConfig(int i10, int i11) {
        }

        @Override // com.huawei.wisesecurity.ucs.credential.outer.NetworkCapability
        public NetworkResponse post(NetworkRequest networkRequest) throws IOException {
            C1016d.m6181a("UCSSignHelper", "NetworkCapabilityImpl ucs http postUrl：" + networkRequest.getUrl());
            return m85567a(new C11918e0.a().m71586m(networkRequest.getUrl()).m71579f(C11955v.m71851h(networkRequest.getHeaders())).m71581h(AbstractC11920f0.create(C11910a0.m71445d("application/json; charset=utf-8"), networkRequest.getBody())).m71575b());
        }
    }

    /* renamed from: zr.a$f */
    public static class f {

        /* renamed from: a */
        public static final C14371a f63736a = new C14371a();
    }

    public C14371a() {
    }

    /* renamed from: b */
    public static C14371a m85559b() {
        return f.f63736a;
    }

    /* renamed from: a */
    public final boolean m85560a(Context context) {
        Credential credential = this.f63734a;
        if (credential != null && !m85563e(Long.valueOf(credential.getExpireTime()))) {
            return true;
        }
        C1016d.m6186f("UCSSignHelper", "init credential from sp");
        C9549n c9549n = new C9549n("location_credential");
        Credential credentialM85562d = m85562d(context, c9549n);
        this.f63734a = credentialM85562d;
        if (credentialM85562d != null) {
            return true;
        }
        C1016d.m6186f("UCSSignHelper", "init credential from network");
        Credential credentialM85561c = m85561c(context);
        this.f63734a = credentialM85561c;
        if (credentialM85561c == null) {
            return false;
        }
        C11506a.m68682e().m68687f();
        c9549n.m59626d("credentialExpiredTime", this.f63734a.getExpireTime());
        c9549n.m59627e("credentialCache", this.f63734a.toString());
        C1016d.m6186f("UCSSignHelper", "Credential init success, expire time is :" + this.f63734a.getExpireTime());
        return true;
    }

    /* renamed from: c */
    public final synchronized Credential m85561c(Context context) {
        CredentialClient credentialClientBuild;
        try {
            credentialClientBuild = new CredentialClient.Builder().context(context).serCountry(C10043a.m62448a()).networkRetryTime(1).networkTimeOut(10000).appId(C11506a.m68682e().m68686d()).grsCapability(new b()).haCapability(new c()).networkCapability(new e()).logInstance(new d()).build();
            this.f63735b = credentialClientBuild;
        } catch (C14389c e10) {
            C1016d.m6183c("UCSSignHelper", "init credential form network failed :" + e10.m85620b());
            return null;
        }
        return credentialClientBuild.applyCredential(BuildConfig.LIBRARY_PACKAGE_NAME);
    }

    /* renamed from: d */
    public final Credential m85562d(Context context, C9549n c9549n) {
        String str;
        long jM59623a = c9549n.m59623a("credentialExpiredTime");
        if (jM59623a <= 0 || m85563e(Long.valueOf(jM59623a))) {
            str = "sp credential is expired,credentialExpiredTime:" + jM59623a;
        } else {
            String strM59624b = c9549n.m59624b("credentialCache");
            if (TextUtils.isEmpty(strM59624b)) {
                str = "sp credential is null";
            } else {
                try {
                    CredentialClient credentialClientBuild = new CredentialClient.Builder().context(context).build();
                    this.f63735b = credentialClientBuild;
                    return credentialClientBuild.genCredentialFromString(strM59624b);
                } catch (C14389c e10) {
                    str = "init credential form sp failed :" + e10.m85620b();
                }
            }
        }
        C1016d.m6183c("UCSSignHelper", str);
        return null;
    }

    /* renamed from: e */
    public final boolean m85563e(Long l10) {
        return System.currentTimeMillis() > l10.longValue() || l10.longValue() - System.currentTimeMillis() < C5863b6.g.f26453g;
    }

    /* renamed from: f */
    public void m85564f() {
        C1016d.m6186f("UCSSignHelper", "reApplyCredential");
        this.f63734a = null;
        C9549n c9549n = new C9549n("location_credential");
        c9549n.m59625c("credentialExpiredTime");
        c9549n.m59625c("credentialCache");
        m85560a(C11991a.m72145a());
    }

    /* renamed from: g */
    public final String m85565g(C14038b c14038b) throws C14387a, C14389c {
        Credential credential = this.f63734a;
        if (credential == null || m85563e(Long.valueOf(credential.getExpireTime()))) {
            C1016d.m6183c("UCSSignHelper", "credential is not ready");
            return "";
        }
        CredentialSigner credentialSignerBuild = new CredentialSigner.Builder().withCredential(this.f63734a).withAlg(CredentialSignAlg.HMAC_SHA256).withCredentialClient(this.f63735b).build();
        String string = Long.toString(System.currentTimeMillis());
        Locale locale = Locale.ENGLISH;
        String str = c14038b.m84206g() + "&" + c14038b.m84207h() + "&" + c14038b.m84209j() + "&" + c14038b.m84208i() + "&ak=" + this.f63734a.getAccessKey() + "&timestamp=" + string;
        if (!TextUtils.isEmpty(c14038b.m84205f()[0])) {
            str = str + "&" + c14038b.m84205f()[0];
        }
        C1016d.m6181a("UCSSignHelper", "newStringToSign:".concat(str));
        String strSignBase64 = credentialSignerBuild.getSignHandler().from(str).signBase64();
        C1016d.m6186f("UCSSignHelper", "sign successful");
        String str2 = "EXT-AUTH-CLOUDSOA-HMAC-SHA256 appid=hmslocation,timestamp=" + string + ",signature=" + strSignBase64 + ",ak=" + this.f63734a.getAccessKey();
        if (TextUtils.isEmpty(c14038b.m84205f()[1])) {
            return str2;
        }
        return str2 + ",signedHeaders=" + c14038b.m84205f()[1];
    }

    /* renamed from: h */
    public String m85566h(Context context, C14038b c14038b) throws C14387a, C13241a, C14389c {
        C1016d.m6181a("UCSSignHelper", "begin to sign");
        if (m85560a(context)) {
            return m85565g(c14038b);
        }
        C1016d.m6183c("UCSSignHelper", "Credential init fail,sign fail");
        throw new C13241a(C13243c.m79629a(10550));
    }
}
