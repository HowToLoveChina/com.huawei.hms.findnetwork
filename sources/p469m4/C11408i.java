package p469m4;

import android.content.Context;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;
import p443l4.InterfaceC11230b;
import p443l4.InterfaceC11232d;

/* renamed from: m4.i */
/* loaded from: classes.dex */
public class C11408i implements InterfaceC11230b {

    /* renamed from: a */
    public final Context f53182a;

    /* renamed from: b */
    public final String f53183b;

    /* renamed from: c */
    public InterfaceC11232d f53184c;

    public C11408i(Context context, String str) {
        Log.d("AGC_FlexibleDecrypt", "init");
        this.f53182a = context;
        this.f53183b = str;
    }

    @Override // p443l4.InterfaceC11230b
    /* renamed from: a */
    public String mo67438a(String str, String str2) {
        if (this.f53184c == null) {
            this.f53184c = m68347b();
        }
        if (this.f53184c == null) {
            Log.w("AGC_FlexibleDecrypt", "decrypt Flexible Decrypt error, use old instead");
            this.f53184c = new C11407h(this.f53182a, this.f53183b).m68346b();
        }
        return this.f53184c.mo67439a(C11412m.m68360b(this.f53182a, this.f53183b, "agc_plugin_", str), str2);
    }

    /* renamed from: b */
    public InterfaceC11232d m68347b() throws JSONException {
        String strM68360b = C11412m.m68360b(this.f53182a, this.f53183b, "agc_plugin_", "crypto_component");
        if (strM68360b == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(C11400a.m68316b(strM68360b), "utf-8"));
            return new C11406g(new C11404e(jSONObject.getString("rx"), jSONObject.getString("ry"), jSONObject.getString("rz"), jSONObject.getString("salt"), jSONObject.getString("algorithm"), jSONObject.getInt("iterationCount")));
        } catch (UnsupportedEncodingException | IllegalArgumentException | JSONException e10) {
            Log.e("AGC_FlexibleDecrypt", "FlexibleDecrypt exception: " + e10.getMessage());
            return null;
        }
    }
}
