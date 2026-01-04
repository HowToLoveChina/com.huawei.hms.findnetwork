package p216d4;

import android.text.TextUtils;
import com.huawei.ads.adsrec.p066db.table.AdContentRspRecord;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p277f4.C9655a;
import p384j4.AbstractC10706e;
import p405jt.AbstractC10915a;

/* renamed from: d4.l */
/* loaded from: classes.dex */
public class C9020l implements Cloneable {

    /* renamed from: a */
    public int f45655a;

    /* renamed from: b */
    public String f45656b;

    /* renamed from: c */
    public String f45657c;

    /* renamed from: d */
    public JSONArray f45658d;

    /* renamed from: e */
    public List<C9031r> f45659e;

    /* renamed from: f */
    public AdContentRspRecord f45660f;

    /* renamed from: g */
    public JSONObject f45661g;

    /* renamed from: h */
    public int f45662h;

    public C9020l(String str, AdContentRspRecord adContentRspRecord) {
        this.f45656b = str;
        this.f45655a = 200;
        this.f45660f = adContentRspRecord;
    }

    /* renamed from: f */
    public static JSONObject m56934f(AdContentRspRecord adContentRspRecord) {
        if (adContentRspRecord == null || TextUtils.isEmpty(adContentRspRecord.m12456t())) {
            return new JSONObject();
        }
        try {
            return new JSONObject(adContentRspRecord.m12456t());
        } catch (JSONException unused) {
            AbstractC10915a.m65978j("AdContentRsp", "create valued json obj err");
            return new JSONObject();
        }
    }

    /* renamed from: c */
    public C9020l m56935c() {
        try {
            C9020l c9020l = (C9020l) super.clone();
            if (this.f45659e != null) {
                ArrayList arrayList = new ArrayList(this.f45659e.size());
                Iterator<C9031r> it = this.f45659e.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().m56964c());
                }
                c9020l.f45659e = arrayList;
            }
            c9020l.f45660f = (AdContentRspRecord) this.f45660f.m64212n();
            return c9020l;
        } catch (CloneNotSupportedException unused) {
            AbstractC10915a.m65970b("AdContentRsp", "copy failed");
            return null;
        }
    }

    /* renamed from: d */
    public Set<String> m56936d(Integer num, Integer num2, C9655a c9655a) {
        HashSet hashSet = new HashSet();
        List<C9031r> list = this.f45659e;
        if (list != null) {
            Iterator<C9031r> it = list.iterator();
            while (it.hasNext()) {
                C9031r next = it.next();
                hashSet.addAll(next.m56965d(num, num2, (next == null || c9655a == null) ? null : c9655a.m60299e(next.m56976q())));
            }
        }
        return hashSet;
    }

    /* renamed from: g */
    public void m56937g(int i10) {
        this.f45655a = i10;
    }

    /* renamed from: i */
    public void m56938i(String str) {
        this.f45657c = str;
    }

    /* renamed from: j */
    public void m56939j(List<C9031r> list) {
        this.f45659e = list;
    }

    /* renamed from: k */
    public final void m56940k(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f45655a = jSONObject.optInt("retcode", -1);
            this.f45658d = jSONObject.optJSONArray("invalidcontentid");
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("multiad");
            if (jSONArrayOptJSONArray != null) {
                int length = jSONArrayOptJSONArray.length();
                this.f45659e = new ArrayList(length);
                for (int i10 = 0; i10 < length; i10++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i10);
                    if (jSONObjectOptJSONObject != null) {
                        this.f45659e.add(new C9031r(this.f45656b, jSONObjectOptJSONObject));
                    }
                }
            }
            jSONObject.remove("multiad");
            this.f45660f = new AdContentRspRecord(this.f45656b, jSONObject);
        }
    }

    /* renamed from: l */
    public AdContentRspRecord m56941l() {
        return this.f45660f;
    }

    /* renamed from: m */
    public void m56942m(int i10) {
        this.f45662h = i10;
    }

    /* renamed from: n */
    public JSONObject m56943n() throws JSONException {
        if (this.f45661g == null) {
            try {
                JSONObject jSONObjectM56934f = m56934f(this.f45660f);
                this.f45661g = jSONObjectM56934f;
                jSONObjectM56934f.put("retcode", this.f45655a);
                this.f45661g.put("clientAdRequestId", this.f45657c);
                this.f45661g.remove("cost");
                this.f45661g.remove("ppsStore");
            } catch (Throwable th2) {
                AbstractC10915a.m65978j("AdContentRsp", "gen json fail " + th2.getClass().getSimpleName());
            }
        }
        if (!AbstractC10706e.m65374a(this.f45659e)) {
            JSONArray jSONArray = new JSONArray();
            Iterator<C9031r> it = this.f45659e.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().m56972m());
            }
            C9036w.m56989c(this.f45661g, "multiad", jSONArray);
        }
        return this.f45661g;
    }

    /* renamed from: o */
    public JSONArray m56944o() {
        return this.f45658d;
    }

    /* renamed from: p */
    public String m56945p() {
        return this.f45656b;
    }

    /* renamed from: q */
    public List<C9031r> m56946q() {
        return this.f45659e;
    }

    /* renamed from: r */
    public boolean m56947r() {
        List<C9031r> list = this.f45659e;
        if (list == null) {
            return true;
        }
        Iterator<C9031r> it = list.iterator();
        while (it.hasNext()) {
            if (!it.next().m56978s()) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        return "AdContentRsp{retCode='" + this.f45655a + "', pkgName=" + this.f45656b + ", adContentRspRecord=" + this.f45660f + ", slots=" + this.f45659e + '}';
    }

    public C9020l(String str, JSONObject jSONObject) {
        this.f45656b = str;
        this.f45661g = jSONObject;
        m56940k(jSONObject);
    }
}
