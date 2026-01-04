package p785xr;

import android.text.TextUtils;
import as.C1016d;
import org.json.JSONException;
import org.json.JSONObject;
import tr.AbstractC13064h;

/* renamed from: xr.c */
/* loaded from: classes8.dex */
public class C13853c extends AbstractC13064h {

    /* renamed from: a */
    public String f62135a;

    /* renamed from: xr.c$a */
    public static final class a {

        /* renamed from: a */
        public JSONObject f62136a = new JSONObject();

        /* renamed from: b */
        public StringBuilder f62137b;

        /* renamed from: c */
        public int f62138c;

        /* renamed from: d */
        public a m83159d(String str, String str2) throws JSONException {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                try {
                    if (this.f62138c == 1) {
                        StringBuilder sb2 = this.f62137b;
                        sb2.append(str);
                        sb2.append("=");
                        sb2.append(str2);
                        sb2.append("&");
                    } else {
                        this.f62136a.put(str, str2);
                    }
                } catch (JSONException unused) {
                    C1016d.m6183c("RequestJsonBody", "add: failed");
                }
            }
            return this;
        }

        /* renamed from: e */
        public C13853c m83160e() {
            return new C13853c(this);
        }

        /* renamed from: f */
        public C13853c m83161f(JSONObject jSONObject) {
            this.f62136a = jSONObject;
            return new C13853c(this);
        }
    }

    public C13853c(a aVar) {
        String string;
        if (aVar.f62138c != 1) {
            string = aVar.f62136a.toString();
        } else if (TextUtils.isEmpty(aVar.f62137b)) {
            return;
        } else {
            string = aVar.f62137b.substring(0, aVar.f62137b.length() - 1);
        }
        this.f62135a = string;
    }

    /* renamed from: a */
    public String m83154a() {
        return "application/json; charset=utf-8";
    }

    /* renamed from: b */
    public String m83155b() {
        return this.f62135a;
    }
}
