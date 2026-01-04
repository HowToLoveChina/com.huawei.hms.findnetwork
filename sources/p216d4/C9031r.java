package p216d4;

import android.text.TextUtils;
import com.huawei.ads.adsrec.p066db.table.SlotRecord;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p247e4.C9406b;
import p384j4.AbstractC10706e;
import p405jt.AbstractC10915a;

/* renamed from: d4.r */
/* loaded from: classes.dex */
public class C9031r implements Cloneable {

    /* renamed from: a */
    public String f45684a;

    /* renamed from: b */
    public String f45685b;

    /* renamed from: c */
    public SlotRecord f45686c;

    /* renamed from: d */
    public int f45687d;

    /* renamed from: e */
    public List<C9406b> f45688e;

    /* renamed from: f */
    public JSONObject f45689f;

    /* renamed from: g */
    public String f45690g;

    public C9031r(SlotRecord slotRecord) {
        if (slotRecord != null) {
            this.f45684a = slotRecord.m12519v();
            this.f45685b = slotRecord.m12518u();
        }
        this.f45686c = slotRecord;
    }

    /* renamed from: c */
    public C9031r m56964c() {
        try {
            C9031r c9031r = (C9031r) super.clone();
            if (this.f45688e != null) {
                ArrayList arrayList = new ArrayList(this.f45688e.size());
                Iterator<C9406b> it = this.f45688e.iterator();
                while (it.hasNext()) {
                    C9406b c9406bM58974f = it.next().m58974f();
                    if (c9406bM58974f != null) {
                        arrayList.add(c9406bM58974f);
                    }
                }
                c9031r.f45688e = arrayList;
            }
            SlotRecord slotRecord = this.f45686c;
            if (slotRecord != null) {
                c9031r.f45686c = (SlotRecord) slotRecord.m64212n();
            }
            return c9031r;
        } catch (CloneNotSupportedException unused) {
            AbstractC10915a.m65978j("AdSlot", "copy failed");
            return null;
        }
    }

    /* renamed from: d */
    public Set<String> m56965d(Integer num, Integer num2, Integer num3) {
        return this.f45688e == null ? new HashSet() : (C9034u.m56984a(num3) && C9034u.m56984a(num) && C9034u.m56984a(num2)) ? m56979t() : !C9034u.m56984a(num3) ? m56973n(num3.intValue()) : !C9034u.m56984a(num) ? m56973n(num.intValue()) : m56971l(num2.intValue());
    }

    /* renamed from: f */
    public final JSONObject m56966f(SlotRecord slotRecord) {
        if (slotRecord == null || TextUtils.isEmpty(slotRecord.m12517t())) {
            return new JSONObject();
        }
        try {
            return new JSONObject(slotRecord.m12517t());
        } catch (JSONException unused) {
            AbstractC10915a.m65978j("AdSlot", "create valued json obj err");
            return new JSONObject();
        }
    }

    /* renamed from: g */
    public void m56967g(int i10) {
        this.f45687d = i10;
    }

    /* renamed from: i */
    public void m56968i(C9031r c9031r) {
        this.f45684a = c9031r.f45684a;
        this.f45686c = c9031r.f45686c;
        this.f45688e = c9031r.f45688e;
        this.f45689f = c9031r.f45689f;
        this.f45687d = c9031r.f45687d;
    }

    /* renamed from: j */
    public void m56969j(List<C9406b> list) {
        this.f45688e = list;
    }

    /* renamed from: k */
    public final void m56970k(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f45690g = jSONObject.optString("adtype");
        this.f45684a = jSONObject.optString("slotid");
        this.f45687d = jSONObject.optInt("retcode30");
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("content");
        if (jSONArrayOptJSONArray != null) {
            int length = jSONArrayOptJSONArray.length();
            this.f45688e = new ArrayList(length);
            for (int i10 = 0; i10 < length; i10++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i10);
                if (jSONObjectOptJSONObject != null) {
                    this.f45688e.add(new C9406b(this.f45685b, this.f45690g, this.f45684a, jSONObjectOptJSONObject));
                }
            }
        }
        jSONObject.remove("content");
        this.f45686c = new SlotRecord(this.f45685b, jSONObject);
    }

    /* renamed from: l */
    public final Set<String> m56971l(int i10) {
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        int i11 = 0;
        for (C9406b c9406b : this.f45688e) {
            if (c9406b != null) {
                c9406b.m58977j();
                c9406b.m58981n();
                if (c9406b.m58981n() == 0) {
                    arrayList.add(c9406b);
                } else if (i11 < i10) {
                    arrayList.add(c9406b);
                    i11++;
                } else {
                    hashSet.add(c9406b.m58977j());
                }
            }
        }
        this.f45688e = arrayList;
        return hashSet;
    }

    /* renamed from: m */
    public JSONObject m56972m() throws JSONException {
        if (this.f45689f == null) {
            JSONObject jSONObjectM56966f = m56966f(this.f45686c);
            this.f45689f = jSONObjectM56966f;
            C9036w.m56988b(jSONObjectM56966f, "retcode30", this.f45687d);
        }
        if (!AbstractC10706e.m65374a(this.f45688e)) {
            JSONArray jSONArray = new JSONArray();
            Iterator<C9406b> it = this.f45688e.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().m58978k());
            }
            C9036w.m56989c(this.f45689f, "content", jSONArray);
        }
        return this.f45689f;
    }

    /* renamed from: n */
    public final Set<String> m56973n(int i10) {
        ArrayList arrayList = new ArrayList(i10);
        HashSet hashSet = new HashSet();
        int i11 = 0;
        for (C9406b c9406b : this.f45688e) {
            if (c9406b != null) {
                c9406b.m58977j();
                c9406b.m58981n();
                if (i11 < i10) {
                    arrayList.add(c9406b);
                    i11++;
                } else {
                    hashSet.add(c9406b.m58977j());
                }
            }
        }
        this.f45688e = arrayList;
        return hashSet;
    }

    /* renamed from: o */
    public List<C9406b> m56974o() {
        return this.f45688e;
    }

    /* renamed from: p */
    public String m56975p() {
        return this.f45685b;
    }

    /* renamed from: q */
    public String m56976q() {
        return this.f45684a;
    }

    /* renamed from: r */
    public SlotRecord m56977r() {
        return this.f45686c;
    }

    /* renamed from: s */
    public boolean m56978s() {
        List<C9406b> list = this.f45688e;
        return list == null || list.isEmpty();
    }

    /* renamed from: t */
    public final Set<String> m56979t() {
        return new HashSet();
    }

    public String toString() {
        return "AdSlot{slotId='" + this.f45684a + "', pkgName=" + this.f45685b + ", retcode30=" + this.f45687d + ", contents=" + this.f45688e + '}';
    }

    public C9031r(String str, String str2) {
        this.f45685b = str;
        this.f45684a = str2;
    }

    public C9031r(String str, JSONObject jSONObject) {
        this.f45685b = str;
        this.f45689f = jSONObject;
        m56970k(jSONObject);
    }
}
