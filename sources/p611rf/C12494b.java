package p611rf;

import org.json.JSONException;
import org.json.JSONObject;
import p809yg.C13981a;

/* renamed from: rf.b */
/* loaded from: classes4.dex */
public final class C12494b {

    /* renamed from: a */
    public int f57525a;

    /* renamed from: b */
    public int f57526b;

    /* renamed from: c */
    public int f57527c;

    public C12494b(int i10, int i11, int i12) {
        this.f57525a = i10;
        this.f57526b = i11;
        this.f57527c = i12;
    }

    /* renamed from: a */
    public static C12494b m74991a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("info")) {
                C13981a.m83987d("ActiveResult", "createActiveResult->json has no info");
                return null;
            }
            JSONObject jSONObject2 = (JSONObject) jSONObject.get("info");
            if (jSONObject2 != null) {
                return new C12494b(jSONObject2.getInt("active"), jSONObject2.getInt("sim"), jSONObject2.getInt("push"));
            }
            C13981a.m83987d("ActiveResult", "createActiveResult->info is null");
            return null;
        } catch (JSONException unused) {
            C13981a.m83988e("ActiveResult", "createActiveResult JSONException");
            return null;
        }
    }

    /* renamed from: b */
    public int m74992b() {
        return this.f57525a;
    }

    /* renamed from: c */
    public int m74993c() {
        return this.f57527c;
    }

    /* renamed from: d */
    public int m74994d() {
        return this.f57526b;
    }

    public String toString() {
        return "ActiveResult [active=" + this.f57525a + ", sim=" + this.f57526b + ", push=" + this.f57527c + "]";
    }
}
