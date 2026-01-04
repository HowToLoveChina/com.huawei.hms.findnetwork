package p548p8;

import java.util.HashMap;
import java.util.Map;

/* renamed from: p8.b */
/* loaded from: classes2.dex */
public final class C12121b {

    /* renamed from: a */
    public String f56226a;

    /* renamed from: b */
    public String f56227b = "/media";

    /* renamed from: c */
    public Map<String, String> f56228c;

    /* renamed from: d */
    public Map<String, String> f56229d;

    /* renamed from: e */
    public Map<String, String[]> f56230e;

    public C12121b() {
        HashMap map = new HashMap();
        this.f56228c = map;
        map.put("recording", m72679d());
        HashMap map2 = new HashMap();
        this.f56229d = map2;
        map2.put("recording", this.f56227b + "/recording");
        HashMap map3 = new HashMap();
        this.f56230e = map3;
        map3.put("recording", new String[]{".amr", ".m4a", ".wav"});
    }

    /* renamed from: d */
    public static String m72679d() {
        return "/Sounds";
    }

    /* renamed from: a */
    public Map<String, String> m72680a() {
        return this.f56228c;
    }

    /* renamed from: b */
    public Map<String, String> m72681b() {
        return this.f56229d;
    }

    /* renamed from: c */
    public Map<String, String[]> m72682c() {
        return this.f56230e;
    }

    /* renamed from: e */
    public String m72683e() {
        return this.f56226a;
    }

    /* renamed from: f */
    public void m72684f(String str) {
        this.f56226a = str;
    }
}
