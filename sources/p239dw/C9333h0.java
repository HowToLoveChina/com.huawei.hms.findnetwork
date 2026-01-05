package p239dw;

import aw.C1029b;
import cw.C8958c;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p857zv.Exception_C14389c;

/* renamed from: dw.h0 */
/* loaded from: classes9.dex */
public class C9333h0 extends AbstractC9331g0 {

    /* renamed from: i */
    public String f46720i;

    /* renamed from: j */
    public InterfaceC9358z f46721j;

    /* renamed from: k */
    public String f46722k;

    /* renamed from: l */
    public String f46723l;

    /* renamed from: m */
    public Certificate[] f46724m;

    /* renamed from: n */
    public int f46725n = 5;

    /* renamed from: o */
    public String f46726o;

    /* renamed from: a */
    public String m58677a() throws JSONException, Exception_C14389c {
        try {
            this.f46713b.put("alg", this.f46725n);
            this.f46713b.put("pbk", this.f46726o);
            this.f46712a.put("alg", this.f46722k);
            this.f46712a.put("cty", this.f46723l);
            int iMin = Math.min(this.f46724m.length, 3);
            JSONArray jSONArray = new JSONArray();
            for (int i10 = 0; i10 < iMin; i10++) {
                jSONArray.put(C8958c.m56711c(this.f46724m[i10].getEncoded(), 2));
            }
            this.f46712a.put("x5c", jSONArray);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("len", 32);
            JSONObject jSONObject2 = this.f46712a;
            String string = jSONObject.toString();
            Charset charset = StandardCharsets.UTF_8;
            jSONObject2.put("kid", C8958c.m56711c(string.getBytes(charset), 10));
            try {
                this.f46713b.put("kekAlg", this.f46714c);
                this.f46713b.put("packageName", this.f46715d);
                this.f46713b.put("appId", this.f46716e);
                this.f46713b.put("akskVersion", this.f46717f);
                this.f46713b.put("appPkgName", this.f46718g);
                this.f46713b.put("appCertFP", this.f46719h);
                String str = C8958c.m56711c(this.f46712a.toString().getBytes(charset), 10) + "." + C8958c.m56711c(this.f46713b.toString().getBytes(charset), 10);
                InterfaceC9358z interfaceC9358z = this.f46721j;
                if (interfaceC9358z == null) {
                    throw new Exception_C14389c(1022L, "UcsKeyStore must no null");
                }
                return str + "." + C8958c.m56711c(interfaceC9358z.mo58653a(this.f46720i, str), 10);
            } catch (JSONException e10) {
                C1029b.m6231b("JwsKeystoreCredentialReqGenerator", "generate payload exception: {0}", e10.getMessage());
                StringBuilder sbM58651a = C9320b.m58651a("build payload json error: ");
                sbM58651a.append(e10.getMessage());
                throw new Exception_C14389c(1002L, sbM58651a.toString());
            }
        } catch (CertificateEncodingException | JSONException e11) {
            StringBuilder sbM58651a2 = C9320b.m58651a("put json error: ");
            sbM58651a2.append(e11.getMessage());
            C1029b.m6231b("JwsKeystoreECCredentialReqGenerator", sbM58651a2.toString(), new Object[0]);
            StringBuilder sbM58651a3 = C9320b.m58651a("put json error: ");
            sbM58651a3.append(e11.getMessage());
            throw new Exception_C14389c(1002L, sbM58651a3.toString());
        }
    }
}
