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

/* renamed from: dw.q */
/* loaded from: classes9.dex */
public class C9349q {

    /* renamed from: a */
    public Certificate[] f46751a;

    public C9349q(String str, Certificate[] certificateArr, String str2) {
        this.f46751a = certificateArr;
    }

    public String toString() throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            jSONObject.put("alg", "PS256");
            jSONObject.put("cty", "AndroidKS");
            Certificate[] certificateArr = this.f46751a;
            int length = 3;
            if (certificateArr.length <= 3) {
                length = certificateArr.length;
            }
            for (int i10 = 0; i10 < length; i10++) {
                jSONArray.put(C8958c.m56711c(this.f46751a[i10].getEncoded(), 2));
            }
            jSONObject.put("x5c", jSONArray);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("len", 32);
            String string = jSONObject2.toString();
            Charset charset = StandardCharsets.UTF_8;
            jSONObject.put("kid", C8958c.m56711c(string.getBytes(charset), 10));
            return C8958c.m56711c(jSONObject.toString().getBytes(charset), 10);
        } catch (CertificateEncodingException | JSONException | Exception_C14389c e10) {
            C1029b.m6231b("CredentialJws", "generate TAHeader exception: {0}", e10.getMessage());
            return "";
        }
    }
}
