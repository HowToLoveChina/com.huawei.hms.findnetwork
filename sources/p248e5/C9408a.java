package p248e5;

import com.huawei.android.backup.filelogic.utils.C2111d;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: e5.a */
/* loaded from: classes.dex */
public class C9408a {

    /* renamed from: i */
    public static C9408a f47033i;

    /* renamed from: a */
    public String f47034a = null;

    /* renamed from: b */
    public String f47035b = null;

    /* renamed from: c */
    public String f47036c = null;

    /* renamed from: d */
    public String f47037d = null;

    /* renamed from: e */
    public String f47038e = null;

    /* renamed from: f */
    public String f47039f = null;

    /* renamed from: g */
    public String f47040g = null;

    /* renamed from: h */
    public String f47041h = null;

    /* renamed from: b */
    public static void m59011b() {
        C2111d.m12653i("CloneSecurity", "closeCloneSecurity");
        if (f47033i != null) {
            f47033i = null;
        }
    }

    /* renamed from: f */
    public static synchronized C9408a m59012f() {
        try {
            if (f47033i == null) {
                synchronized (C9408a.class) {
                    f47033i = new C9408a();
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f47033i;
    }

    /* renamed from: a */
    public String m59013a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("CLONE_SECURITY_VERSION", 1);
            jSONObject.put("FEK_SALT_ENC", this.f47035b);
            jSONObject.put("FEK_SALT_HMAC", this.f47037d);
            jSONObject.put("FEK_IV", this.f47036c);
            jSONObject.put("FEK_CIPHERTEXT", this.f47038e);
            jSONObject.put("FEK_CHECKCODE", this.f47039f);
            jSONObject.put("FILE_IV", this.f47040g);
            jSONObject.put("FILE_CHECKCODE", this.f47041h);
            return jSONObject.toString();
        } catch (JSONException unused) {
            C2111d.m12648d("CloneSecurity", "buildSecurityMsg JSONException.");
            return null;
        }
    }

    /* renamed from: c */
    public String m59014c(String str, String str2) {
        return C9410c.m59029a(str, str2);
    }

    /* renamed from: d */
    public String m59015d() {
        return this.f47034a;
    }

    /* renamed from: e */
    public String m59016e() {
        return this.f47041h;
    }

    /* renamed from: g */
    public boolean m59017g(String str) {
        if (str == null) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("FEK_SALT_ENC")) {
                this.f47035b = jSONObject.getString("FEK_SALT_ENC");
            }
            if (jSONObject.has("FEK_SALT_HMAC")) {
                this.f47037d = jSONObject.getString("FEK_SALT_HMAC");
            }
            if (jSONObject.has("FEK_IV")) {
                this.f47036c = jSONObject.getString("FEK_IV");
            }
            if (jSONObject.has("FEK_CIPHERTEXT")) {
                this.f47038e = jSONObject.getString("FEK_CIPHERTEXT");
            }
            if (jSONObject.has("FEK_CHECKCODE")) {
                this.f47039f = jSONObject.getString("FEK_CHECKCODE");
            }
            if (jSONObject.has("FILE_IV")) {
                this.f47040g = jSONObject.getString("FILE_IV");
            }
            if (jSONObject.has("FILE_CHECKCODE")) {
                this.f47041h = jSONObject.getString("FILE_CHECKCODE");
            }
            boolean z10 = this.f47035b == null || this.f47037d == null;
            boolean z11 = this.f47036c == null || this.f47038e == null || this.f47039f == null;
            boolean z12 = this.f47040g == null || this.f47041h == null;
            if (!z10 && !z11 && !z12) {
                return true;
            }
            Object[] objArr = new Object[4];
            objArr[0] = "parseSecurityMsg isNull EncryptInfo:";
            objArr[1] = Boolean.valueOf(this.f47038e == null);
            objArr[2] = " FileCheckInfo ";
            objArr[3] = Boolean.valueOf(this.f47041h == null);
            C2111d.m12649e("CloneSecurity", objArr);
            return false;
        } catch (JSONException unused) {
            C2111d.m12648d("CloneSecurity", "parseSecurityMsg JSONException.");
            return false;
        }
    }

    /* renamed from: h */
    public void m59018h(String str) {
        this.f47041h = str;
    }

    /* renamed from: i */
    public boolean m59019i(String str, String str2, String str3) {
        return C9412e.m59032a(C9411d.m59030a(m59014c(str, str2)), C9411d.m59030a(str3));
    }
}
