package p239dw;

import android.content.Context;
import aw.C1029b;
import com.huawei.wisesecurity.ucs.credential.Credential;
import com.huawei.wisesecurity.ucs.credential.CredentialClient;
import com.huawei.wisesecurity.ucs.credential.entity.EcKeyPair;
import com.huawei.wisesecurity.ucs.credential.entity.ErrorBody;
import com.huawei.wisesecurity.ucs.credential.entity.UcsKeyStoreProvider;
import com.huawei.wisesecurity.ucs.credential.nativelib.UcsLib;
import com.huawei.wisesecurity.ucs.credential.outer.NetworkCapability;
import com.huawei.wisesecurity.ucs.credential.outer.NetworkResponse;
import com.tencent.p204mm.opensdk.constants.ConstantsAPI;
import cw.C8957b;
import cw.C8958c;
import java.security.KeyStoreException;
import java.security.cert.Certificate;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import p857zv.Exception_C14389c;

/* renamed from: dw.n0 */
/* loaded from: classes9.dex */
public class UcsECKeyStoreHandler extends AbstractC9328f {
    public UcsECKeyStoreHandler(CredentialClient credentialClient, Context context, NetworkCapability networkCapability) throws Exception_C14389c {
        super(credentialClient, context, networkCapability);
    }

    @Override // p239dw.AbstractC9328f
    /* renamed from: a */
    public Credential mo58666a(String str) throws Exception_C14389c {
        try {
            if (Integer.parseInt(new JSONObject(str).getString("expire")) == 0) {
                return this.m_credential.genCredentialFromString(str);
            }
            throw new Exception_C14389c(1017L, "unenable expire.");
        } catch (NumberFormatException e10) {
            StringBuilder sbM58651a = C9320b.m58651a("parse TSMS resp expire error : ");
            sbM58651a.append(e10.getMessage());
            throw new Exception_C14389c(2001L, sbM58651a.toString());
        } catch (JSONException e11) {
            StringBuilder sbM58651a2 = C9320b.m58651a("parse TSMS resp get json error : ");
            sbM58651a2.append(e11.getMessage());
            throw new Exception_C14389c(1002L, sbM58651a2.toString());
        }
    }

    @Override // p239dw.AbstractC9328f
    /* renamed from: c */
    public Credential mo58667c(String str, String str2, String str3, String str4, C9334i c9334i) throws Exception_C14389c {
        try {
            C1029b.m6234e("UcsECKeyStoreHandler", "applyCredential use KeyStoreEcHandler.", new Object[0]);
            return m58672b(str, str2, str3, str4);
        } catch (Throwable th2) {
            StringBuilder sbM58651a = C9320b.m58651a("applyCredential use KeyStoreEcHandler get exception: ");
            sbM58651a.append(th2.getMessage());
            C1029b.m6231b("UcsECKeyStoreHandler", sbM58651a.toString(), new Object[0]);
            return c9334i.m58678a(3, str, str2, str3, str4, c9334i);
        }
    }

    @Override // p239dw.AbstractC9328f
    /* renamed from: d */
    public String mo58668d(NetworkResponse networkResponse) throws Exception_C14389c {
        if (networkResponse.isSuccessful()) {
            return networkResponse.getBody();
        }
        ErrorBody errorBodyFromString = ErrorBody.fromString(networkResponse.getBody());
        StringBuilder sbM58651a = C9320b.m58651a("tsms service error, ");
        sbM58651a.append(errorBodyFromString.getErrorMessage());
        sbM58651a.append("; error code : ");
        sbM58651a.append(errorBodyFromString.getErrorCode());
        String string = sbM58651a.toString();
        C1029b.m6231b("UcsECKeyStoreHandler", string, new Object[0]);
        if (AbstractC9328f.m58671g(errorBodyFromString.getErrorCode())) {
            C9326e.m58663a(this.m_context);
            C1029b.m6234e("UcsECKeyStoreHandler", "turn off android keystore EC CertificateChain", new Object[0]);
        }
        throw new Exception_C14389c(ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS, string);
    }

    @Override // p239dw.AbstractC9328f
    /* renamed from: e */
    public void mo58669e() throws Exception_C14389c {
        Context context = this.m_context;
        if (!C9326e.m58664b() || C8957b.m56703b("ucs_ec_keystore_sp_key_t", -1, context) == 0) {
            throw C9344n.m58700a("UcsECKeyStoreHandler", "keyStoreCertificateChain is off. not support android keyStore EC.", new Object[0], 1022L, "keyStoreCertificateChain is off. not support android keyStore EC.");
        }
    }

    @Override // p239dw.AbstractC9328f
    /* renamed from: f */
    public String mo58670f() throws Exception_C14389c, KeyStoreException {
        C9356x.m58717a(UcsKeyStoreProvider.ANDROID_KEYSTORE);
        InterfaceC9358z interfaceC9358z = C9356x.f46764b;
        C9356x c9356x = (C9356x) interfaceC9358z;
        c9356x.m58718b("ucs_ec_alias_rootKey");
        Certificate[] certificateArrM58720d = c9356x.m58720d("ucs_ec_alias_rootKey");
        if (C9322c.m58657a(certificateArrM58720d)) {
            C9326e.m58663a(this.m_context);
            throw new Exception_C14389c(2001L, "android keystore EC no support software attestation root.");
        }
        C9333h0 c9333h0 = new C9333h0();
        c9333h0.f46720i = "ucs_ec_alias_rootKey";
        c9333h0.f46722k = "ED256";
        c9333h0.f46721j = interfaceC9358z;
        c9333h0.f46724m = certificateArrM58720d;
        c9333h0.f46723l = "AndroidKS";
        List<String> pkgNameCertFP = UcsLib.getPkgNameCertFP(this.m_context);
        c9333h0.f46714c = 1;
        c9333h0.f46715d = this.f46706e;
        c9333h0.f46716e = this.f46705d;
        c9333h0.f46717f = 1;
        c9333h0.f46718g = pkgNameCertFP.get(0);
        c9333h0.f46719h = pkgNameCertFP.get(1);
        EcKeyPair ecKeyPairM58721a = C9357y.m58721a(this.m_context);
        c9333h0.f46726o = C8958c.m56711c(ecKeyPairM58721a.getPublicKey(), 2);
        C9357y.m58722b(ecKeyPairM58721a);
        return c9333h0.m58677a();
    }
}
