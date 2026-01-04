package p239dw;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import aw.C1029b;
import com.huawei.wisesecurity.ucs.credential.Credential;
import com.huawei.wisesecurity.ucs.credential.CredentialClient;
import com.huawei.wisesecurity.ucs.credential.entity.ErrorBody;
import com.huawei.wisesecurity.ucs.credential.nativelib.UcsLib;
import com.huawei.wisesecurity.ucs.credential.outer.NetworkCapability;
import com.huawei.wisesecurity.ucs.credential.outer.NetworkResponse;
import com.tencent.p204mm.opensdk.constants.ConstantsAPI;
import cw.C8957b;
import cw.C8958c;
import java.nio.charset.StandardCharsets;
import java.security.cert.Certificate;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import p857zv.C14389c;

/* renamed from: dw.o0 */
/* loaded from: classes9.dex */
public class C9347o0 extends AbstractC9328f {
    public C9347o0(CredentialClient credentialClient, Context context, NetworkCapability networkCapability) throws C14389c {
        super(credentialClient, context, networkCapability);
    }

    @Override // p239dw.AbstractC9328f
    /* renamed from: a */
    public Credential mo58666a(String str) throws C14389c {
        try {
            if (Integer.parseInt(new JSONObject(str).getString("expire")) == 0) {
                return this.f46708g.genCredentialFromString(str);
            }
            throw new C14389c(1017L, "unenable expire.");
        } catch (NumberFormatException e10) {
            StringBuilder sbM58651a = C9320b.m58651a("parse TSMS resp expire error : ");
            sbM58651a.append(e10.getMessage());
            throw new C14389c(2001L, sbM58651a.toString());
        } catch (JSONException e11) {
            StringBuilder sbM58651a2 = C9320b.m58651a("parse TSMS resp get json error : ");
            sbM58651a2.append(e11.getMessage());
            throw new C14389c(1002L, sbM58651a2.toString());
        }
    }

    @Override // p239dw.AbstractC9328f
    /* renamed from: c */
    public Credential mo58667c(String str, String str2, String str3, String str4, C9334i c9334i) throws C14389c {
        try {
            C1029b.m6234e("KeyStoreHandler", "applyCredential use KeyStoreHandler.", new Object[0]);
            return m58672b(str, str2, str3, str4);
        } catch (Throwable th2) {
            StringBuilder sbM58651a = C9320b.m58651a("applyCredential use KeyStoreHandler get exception: ");
            sbM58651a.append(th2.getMessage());
            C1029b.m6231b("KeyStoreHandler", sbM58651a.toString(), new Object[0]);
            return c9334i.m58678a(0, str, str2, str3, str4, c9334i);
        }
    }

    @Override // p239dw.AbstractC9328f
    /* renamed from: d */
    public String mo58668d(NetworkResponse networkResponse) throws C14389c {
        if (networkResponse.isSuccessful()) {
            return networkResponse.getBody();
        }
        ErrorBody errorBodyFromString = ErrorBody.fromString(networkResponse.getBody());
        StringBuilder sbM58651a = C9320b.m58651a("tsms service error, ");
        sbM58651a.append(errorBodyFromString.getErrorMessage());
        String string = sbM58651a.toString();
        C1029b.m6231b("KeyStoreHandler", string, new Object[0]);
        if (AbstractC9328f.m58671g(errorBodyFromString.getErrorCode())) {
            C9326e.m58665c(this.f46703b);
            C1029b.m6234e("KeyStoreHandler", "turn off android keystore CertificateChain", new Object[0]);
        }
        throw new C14389c(ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS, string);
    }

    @Override // p239dw.AbstractC9328f
    /* renamed from: e */
    public void mo58669e() throws C14389c {
        Context context = this.f46703b;
        if (!C9326e.m58664b() || C8957b.m56703b("ucs_keystore_sp_key_t", -1, context) == 0) {
            throw C9344n.m58700a("KeyStoreHandler", "keyStoreCertificateChain is off. not support keyStore RSA.", new Object[0], 1022L, "keyStoreCertificateChain is off. not support keyStore RSA.");
        }
    }

    @Override // p239dw.AbstractC9328f
    @SuppressLint({"NewApi"})
    /* renamed from: f */
    public String mo58670f() throws JSONException, C14389c {
        String strM56711c;
        if (C9321b0.f46695a == null) {
            C9321b0.f46696b.m58652a(null);
        }
        C9321b0 c9321b0 = C9321b0.f46696b;
        c9321b0.m58654b("ucs_alias_rootKey");
        Certificate[] certificateArrM58656d = c9321b0.m58656d("ucs_alias_rootKey");
        if (C9322c.m58657a(certificateArrM58656d)) {
            C9326e.m58665c(this.f46703b);
            throw new C14389c(2001L, "android keystore RSA no support software attestation root.");
        }
        String string = new C9349q("PS256", certificateArrM58656d, "AndroidKS").toString();
        List<String> pkgNameCertFP = UcsLib.getPkgNameCertFP(this.f46703b);
        String str = this.f46706e;
        String str2 = this.f46705d;
        String str3 = pkgNameCertFP.get(0);
        String str4 = pkgNameCertFP.get(1);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("alg", 2);
            jSONObject.put("kekAlg", 1);
            jSONObject.put("packageName", str);
            jSONObject.put("appId", str2);
            jSONObject.put("akskVersion", 1);
            jSONObject.put("appPkgName", str3);
            jSONObject.put("appCertFP", str4);
            strM56711c = C8958c.m56711c(jSONObject.toString().getBytes(StandardCharsets.UTF_8), 10);
        } catch (JSONException | C14389c e10) {
            C1029b.m6231b("CredentialJws", "generate payload exception: {0}", e10.getMessage());
            strM56711c = "";
        }
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(strM56711c)) {
            throw new C14389c(1006L, "Get signStr error");
        }
        String strM56711c2 = C8958c.m56711c(c9321b0.mo58653a("ucs_alias_rootKey", string + "." + strM56711c), 10);
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(strM56711c) || TextUtils.isEmpty(strM56711c2)) {
            throw new C14389c(1006L, "get credential JWS is empty...");
        }
        StringBuilder sb2 = new StringBuilder();
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(strM56711c)) {
            throw new C14389c(1006L, "Get signStr error");
        }
        sb2.append(string + "." + strM56711c);
        sb2.append(".");
        sb2.append(strM56711c2);
        return sb2.toString();
    }
}
