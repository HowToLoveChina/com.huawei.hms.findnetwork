package p469m4;

import android.util.Log;
import com.huawei.hicloud.notification.manager.HiCloudParamMetaManager;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p443l4.InterfaceC11231c;

/* renamed from: m4.j */
/* loaded from: classes.dex */
public class C11409j implements InterfaceC11231c {

    /* renamed from: a */
    public final JSONObject f53185a;

    public C11409j(InputStream inputStream, String str) throws JSONException {
        this.f53185a = m68348a(inputStream);
        m68349b(str);
    }

    /* renamed from: a */
    public final JSONObject m68348a(InputStream inputStream) {
        String str;
        if (inputStream != null) {
            try {
                return new JSONObject(C11401b.m68324g(inputStream, Constants.UTF_8));
            } catch (IOException unused) {
                str = "IOException when reading the 'Config' from InputStream.";
                Log.e("InputStreamReader", str);
                return new JSONObject();
            } catch (JSONException unused2) {
                str = "JSONException when reading the 'Config' from InputStream.";
                Log.e("InputStreamReader", str);
                return new JSONObject();
            }
        }
        return new JSONObject();
    }

    /* renamed from: b */
    public final void m68349b(String str) throws JSONException {
        try {
            JSONObject jSONObjectM68351d = m68351d(str);
            if (jSONObjectM68351d == null) {
                return;
            }
            String string = getString("/configuration_version", "");
            BigDecimal bigDecimal = new BigDecimal("0.0");
            try {
                bigDecimal = BigDecimal.valueOf(Double.parseDouble(string));
            } catch (NumberFormatException unused) {
                Log.d("InputStreamReader", "configuration_version to double error");
            }
            if (bigDecimal.compareTo(new BigDecimal("2.0")) == 0) {
                this.f53185a.getJSONObject(HiCloudParamMetaManager.LOACL_CLIENT).put("app_id", jSONObjectM68351d.getString("app_id"));
                return;
            }
            if (bigDecimal.compareTo(new BigDecimal("3.0")) >= 0) {
                Iterator<String> itKeys = jSONObjectM68351d.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (!MapKeyNames.PACKAGE_NAME.equals(next)) {
                        m68350c(next, jSONObjectM68351d.get(next), this.f53185a);
                    }
                }
            }
        } catch (JSONException unused2) {
            Log.d("InputStreamReader", "JSONException when reading the 'appInfos' from InputStream.");
        }
    }

    /* renamed from: c */
    public final void m68350c(String str, Object obj, JSONObject jSONObject) throws JSONException {
        if (str == null || obj == null || jSONObject == null) {
            return;
        }
        if (!(obj instanceof JSONObject)) {
            jSONObject.put(str, obj);
            return;
        }
        JSONObject jSONObject2 = (JSONObject) obj;
        Iterator<String> itKeys = jSONObject2.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            m68350c(next, jSONObject2.get(next), jSONObject.getJSONObject(str));
        }
    }

    /* renamed from: d */
    public final JSONObject m68351d(String str) throws JSONException {
        JSONArray jSONArray = this.f53185a.getJSONArray("appInfos");
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i10);
            if (jSONObject.getString(MapKeyNames.PACKAGE_NAME).equals(str)) {
                return jSONObject;
            }
        }
        return null;
    }

    @Override // p443l4.InterfaceC11231c
    public String getString(String str, String str2) throws JSONException {
        if (str.endsWith("/")) {
            return str2;
        }
        String[] strArrSplit = str.split("/");
        try {
            JSONObject jSONObject = this.f53185a;
            for (int i10 = 1; i10 < strArrSplit.length; i10++) {
                if (i10 == strArrSplit.length - 1) {
                    return jSONObject.get(strArrSplit[i10]).toString();
                }
                jSONObject = jSONObject.getJSONObject(strArrSplit[i10]);
            }
        } catch (JSONException unused) {
            Log.w("InputStreamReader", "JSONException when reading 'path': " + str);
        }
        return str2;
    }

    public String toString() {
        return "InputStreamReader{config=" + this.f53185a.toString().hashCode() + '}';
    }
}
