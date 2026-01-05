package p239dw;

import android.content.Context;
import aw.C1029b;
import com.huawei.wisesecurity.ucs.credential.Credential;
import com.huawei.wisesecurity.ucs.credential.CredentialClient;
import com.huawei.wisesecurity.ucs.credential.entity.ErrorBody;
import com.huawei.wisesecurity.ucs.credential.outer.NetworkCapability;
import com.huawei.wisesecurity.ucs.credential.outer.NetworkResponse;
import com.tencent.p204mm.opensdk.constants.ConstantsAPI;
import cw.C8957b;
import org.json.JSONException;
import org.json.JSONObject;
import p857zv.Exception_C14389c;

/* renamed from: dw.e0 */
/* loaded from: classes9.dex */
public class C9327e0 extends AbstractC9328f {
    public C9327e0(CredentialClient credentialClient, Context context, NetworkCapability networkCapability) throws Exception_C14389c {
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
            C1029b.m6234e("HuksHandler", "applyCredential use HuksHandler.", new Object[0]);
            return m58672b(str, str2, str3, str4);
        } catch (Throwable th2) {
            StringBuilder sbM58651a = C9320b.m58651a("applyCredential use HuksHandler get exception: ");
            sbM58651a.append(th2.getMessage());
            C1029b.m6231b("HuksHandler", sbM58651a.toString(), new Object[0]);
            return c9334i.m58678a(0, str, str2, str3, str4, c9334i);
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
        C1029b.m6231b("HuksHandler", string, new Object[0]);
        if (AbstractC9328f.m58671g(errorBodyFromString.getErrorCode())) {
            C8957b.m56706e("ucs_ec_huks_sp_key_t", 0, this.m_context);
            C1029b.m6234e("HuksHandler", "turn off huks EC CertificateChain", new Object[0]);
        }
        throw new Exception_C14389c(ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS, string);
    }

    @Override // p239dw.AbstractC9328f
    /* renamed from: e */
    public void mo58669e() throws Exception_C14389c {
        Context context = this.m_context;
        if (!C9326e.m58664b() || C8957b.m56703b("ucs_ec_huks_sp_key_t", -1, context) == 0) {
            throw C9344n.m58700a("HuksHandler", "keyStoreCertificateChain is off. not support huks EC.", new Object[0], 1026L, "keyStoreCertificateChain is off. not support huks EC.");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x004b  */
    @Override // p239dw.AbstractC9328f
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String mo58670f() throws p857zv.Exception_C14389c, java.security.KeyStoreException {
        /*
            r8 = this;
            com.huawei.wisesecurity.ucs.credential.entity.UcsKeyStoreProvider r0 = com.huawei.wisesecurity.ucs.credential.entity.UcsKeyStoreProvider.HUAWEI_KEYSTORE
            p239dw.C9356x.m58717a(r0)
            dw.z r0 = p239dw.C9356x.f46764b
            r1 = r0
            dw.x r1 = (p239dw.C9356x) r1
            java.lang.String r2 = "ucs_ec_alias_rootKey"
            r1.m58718b(r2)
            java.security.cert.Certificate[] r1 = r1.m58720d(r2)
            int r3 = r1.length
            r4 = 0
            r5 = 1
            r6 = 2
            if (r3 <= r6) goto L21
            r3 = r1[r4]
            r1 = r1[r5]
            java.security.cert.Certificate[] r1 = new java.security.cert.Certificate[]{r3, r1}
        L21:
            dw.h0 r3 = new dw.h0
            r3.<init>()
            r3.f46720i = r2
            java.lang.String r2 = android.os.Build.MANUFACTURER
            java.lang.String r7 = "HONOR"
            boolean r2 = r2.equals(r7)
            if (r2 != 0) goto L33
            goto L4b
        L33:
            java.lang.String r2 = "com.huawei.android.os.BuildEx$VERSION"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch: java.lang.Throwable -> L4b
            java.lang.String r7 = "EMUI_SDK_INT"
            java.lang.reflect.Field r2 = r2.getField(r7)     // Catch: java.lang.Throwable -> L4b
            r7 = 0
            int r2 = r2.getInt(r7)     // Catch: java.lang.Throwable -> L4b
            r7 = 31
            if (r2 < r7) goto L4b
            java.lang.String r2 = "ED256"
            goto L4d
        L4b:
            java.lang.String r2 = "ED256HUKS"
        L4d:
            r3.f46722k = r2
            r3.f46721j = r0
            r3.f46724m = r1
            android.content.Context r0 = r8.m_context
            java.util.List r0 = com.huawei.wisesecurity.ucs.credential.nativelib.UcsLib.getPkgNameCertFP(r0)
            java.lang.String r1 = "huks"
            r3.f46723l = r1
            r3.f46714c = r5
            java.lang.String r1 = r8.f46706e
            r3.f46715d = r1
            java.lang.String r1 = r8.f46705d
            r3.f46716e = r1
            r3.f46717f = r5
            java.lang.Object r1 = r0.get(r4)
            java.lang.String r1 = (java.lang.String) r1
            r3.f46718g = r1
            java.lang.Object r0 = r0.get(r5)
            java.lang.String r0 = (java.lang.String) r0
            r3.f46719h = r0
            android.content.Context r8 = r8.m_context
            com.huawei.wisesecurity.ucs.credential.entity.EcKeyPair r8 = p239dw.C9357y.m58721a(r8)
            byte[] r0 = r8.getPublicKey()
            java.lang.String r0 = cw.C8958c.m56711c(r0, r6)
            r3.f46726o = r0
            p239dw.C9357y.m58722b(r8)
            java.lang.String r8 = r3.m58677a()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p239dw.C9327e0.mo58670f():java.lang.String");
    }
}
