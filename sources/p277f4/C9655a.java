package p277f4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p216d4.C8999a0;
import p216d4.C9023m0;
import p384j4.AbstractC10706e;
import p384j4.AbstractC10707f;

/* renamed from: f4.a */
/* loaded from: classes.dex */
public class C9655a {

    /* renamed from: a */
    public final String f47807a;

    /* renamed from: b */
    public final List<String> f47808b;

    /* renamed from: c */
    public List<String> f47809c;

    /* renamed from: d */
    public Integer f47810d;

    /* renamed from: e */
    public Integer f47811e;

    /* renamed from: f */
    public final int f47812f;

    /* renamed from: g */
    public Integer f47813g;

    /* renamed from: h */
    public String f47814h;

    /* renamed from: i */
    public String f47815i;

    /* renamed from: j */
    public String f47816j;

    /* renamed from: k */
    public String f47817k;

    /* renamed from: l */
    public Integer f47818l;

    /* renamed from: m */
    public Map<String, C9023m0> f47819m;

    /* renamed from: n */
    public int f47820n = 0;

    public C9655a(String str, String str2, List<String> list, Integer num, int i10) {
        this.f47807a = str;
        this.f47814h = str2;
        this.f47808b = list;
        this.f47810d = num;
        this.f47812f = i10;
        m60312r();
    }

    /* renamed from: a */
    public final C9023m0 m60295a(String str) {
        if (this.f47819m == null) {
            this.f47819m = new HashMap();
        }
        C9023m0 c9023m0 = this.f47819m.get(str);
        if (c9023m0 != null) {
            return c9023m0;
        }
        C9023m0 c9023m02 = new C9023m0();
        this.f47819m.put(str, c9023m02);
        return c9023m02;
    }

    /* renamed from: b */
    public List<String> m60296b() {
        return this.f47808b;
    }

    /* renamed from: c */
    public void m60297c(int i10) {
        if (this.f47818l == null) {
            this.f47818l = Integer.valueOf(i10);
        }
    }

    /* renamed from: d */
    public void m60298d(String str, Integer num) {
        if (AbstractC10707f.m65379d(str)) {
            return;
        }
        m60295a(str).m56951b(num);
    }

    /* renamed from: e */
    public Integer m60299e(String str) {
        C9023m0 c9023m0M60303i = m60303i(str);
        if (c9023m0M60303i == null) {
            return null;
        }
        return c9023m0M60303i.m56952c();
    }

    /* renamed from: f */
    public List<String> m60300f() {
        return this.f47809c;
    }

    /* renamed from: g */
    public void m60301g(int i10) {
        this.f47820n = i10;
    }

    /* renamed from: h */
    public void m60302h(String str, Integer num) {
        if (AbstractC10707f.m65379d(str)) {
            return;
        }
        m60295a(str).m56953d(num);
    }

    /* renamed from: i */
    public final C9023m0 m60303i(String str) {
        if (C8999a0.m56863a(this.f47819m) || AbstractC10707f.m65379d(str)) {
            return null;
        }
        return this.f47819m.get(str);
    }

    /* renamed from: j */
    public String m60304j() {
        String str = this.f47807a;
        return str == null ? this.f47817k : str;
    }

    /* renamed from: k */
    public String m60305k() {
        return this.f47814h;
    }

    /* renamed from: l */
    public int m60306l() {
        return this.f47820n;
    }

    /* renamed from: m */
    public int m60307m() {
        return this.f47812f;
    }

    /* renamed from: n */
    public Integer m60308n() {
        return this.f47811e;
    }

    /* renamed from: o */
    public Integer m60309o() {
        return this.f47810d;
    }

    /* renamed from: p */
    public Integer m60310p() {
        return this.f47818l;
    }

    /* renamed from: q */
    public Integer m60311q() {
        return this.f47813g;
    }

    /* renamed from: r */
    public final void m60312r() {
        if (AbstractC10706e.m65374a(this.f47808b)) {
            return;
        }
        this.f47819m = new HashMap(((int) (this.f47808b.size() / 0.75f)) + 1);
        for (String str : this.f47808b) {
            if (!AbstractC10707f.m65379d(str)) {
                this.f47819m.put(str, new C9023m0());
            }
        }
    }

    /* renamed from: s */
    public String m60313s() {
        if (C8999a0.m56863a(this.f47819m)) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        int i10 = 0;
        for (Map.Entry<String, C9023m0> entry : this.f47819m.entrySet()) {
            String key = entry.getKey();
            C9023m0 value = entry.getValue();
            if (value != null) {
                if (i10 > 0) {
                    sb2.append(";");
                }
                Integer numM56952c = value.m56952c();
                Integer numM56950a = value.m56950a();
                sb2.append(key);
                sb2.append(",");
                sb2.append(numM56952c == null ? 0 : numM56952c.intValue());
                sb2.append(",");
                sb2.append(numM56950a == null ? 0 : numM56950a.intValue());
                i10++;
            }
        }
        return sb2.toString();
    }

    /* renamed from: t */
    public void m60314t(List<String> list) {
        this.f47809c = list;
    }

    public String toString() {
        return "AdRecallParam{appPkgName='" + this.f47807a + "', adSlotIds=" + this.f47808b + ", maxCount=" + this.f47810d + ", adType=" + this.f47812f + ", clientRequestId='" + this.f47814h + "'}";
    }

    /* renamed from: u */
    public void m60315u(String str) {
        this.f47817k = str;
    }

    /* renamed from: v */
    public void m60316v(Integer num) {
        this.f47811e = num;
    }

    /* renamed from: w */
    public void m60317w(String str) {
        this.f47816j = str;
    }

    /* renamed from: x */
    public void m60318x(String str) {
        this.f47815i = str;
    }

    /* renamed from: y */
    public void m60319y(Integer num) {
        this.f47818l = num;
    }

    /* renamed from: z */
    public void m60320z(Integer num) {
        this.f47813g = num;
    }
}
