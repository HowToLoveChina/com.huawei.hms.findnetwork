package p239dw;

import android.text.TextUtils;
import cw.C8958c;
import java.nio.charset.StandardCharsets;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p857zv.Exception_C14389c;

/* renamed from: dw.j0 */
/* loaded from: classes9.dex */
public class C9337j0 {

    /* renamed from: a */
    public a f46738a;

    /* renamed from: b */
    public b f46739b;

    /* renamed from: c */
    public byte[] f46740c;

    /* renamed from: d */
    public String f46741d;

    /* renamed from: dw.j0$a */
    public static class a {

        /* renamed from: a */
        public String f46742a;

        /* renamed from: b */
        public String[] f46743b;
    }

    /* renamed from: dw.j0$b */
    public static class b {

        /* renamed from: a */
        public int f46744a;

        /* renamed from: b */
        public String f46745b;
    }

    public C9337j0(String str) throws Exception_C14389c {
        m58685a(str);
        String[] strArrSplit = str.split("\\.");
        m58687c(strArrSplit);
        m58688d(strArrSplit);
        m58686b(str, strArrSplit);
    }

    /* renamed from: a */
    public final void m58685a(String str) throws Exception_C14389c {
        if (TextUtils.isEmpty(str)) {
            throw new Exception_C14389c(1012L, "ComponentJws is empty.");
        }
    }

    /* renamed from: b */
    public void m58686b(String str, String[] strArr) throws Exception_C14389c {
        try {
            this.f46740c = C8958c.m56709a(strArr[2], 8);
            this.f46741d = str.substring(0, str.lastIndexOf("."));
        } catch (Exception_C14389c e10) {
            StringBuilder sbM58651a = C9320b.m58651a("Fail to convert jws string to Content, ");
            sbM58651a.append(e10.getMessage());
            throw new Exception_C14389c(1012L, sbM58651a.toString());
        }
    }

    /* renamed from: c */
    public void m58687c(String[] strArr) throws Exception_C14389c {
        try {
            JSONObject jSONObject = new JSONObject(new String(C8958c.m56709a(strArr[0], 8), StandardCharsets.UTF_8));
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("x5c");
            String[] strArr2 = {jSONArrayOptJSONArray.optString(0), jSONArrayOptJSONArray.optString(1)};
            a aVar = new a();
            this.f46738a = aVar;
            aVar.f46742a = jSONObject.getString("alg");
            this.f46738a.f46743b = strArr2;
        } catch (RuntimeException | JSONException e10) {
            StringBuilder sbM58651a = C9320b.m58651a("Fail to convert jws string to header, ");
            sbM58651a.append(e10.getMessage());
            throw new Exception_C14389c(1012L, sbM58651a.toString());
        }
    }

    /* renamed from: d */
    public void m58688d(String[] strArr) throws Exception_C14389c {
        try {
            JSONObject jSONObject = new JSONObject(new String(C8958c.m56709a(strArr[1], 8), StandardCharsets.UTF_8));
            b bVar = new b();
            this.f46739b = bVar;
            bVar.f46745b = jSONObject.getString("component");
            this.f46739b.f46744a = jSONObject.getInt("version");
        } catch (RuntimeException | JSONException e10) {
            StringBuilder sbM58651a = C9320b.m58651a("Fail to convert jws string to payload, ");
            sbM58651a.append(e10.getMessage());
            throw new Exception_C14389c(1012L, sbM58651a.toString());
        }
    }
}
