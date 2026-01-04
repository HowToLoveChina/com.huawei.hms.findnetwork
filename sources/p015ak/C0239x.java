package p015ak;

import java.util.Map;
import java.util.Random;

/* renamed from: ak.x */
/* loaded from: classes6.dex */
public class C0239x {

    /* renamed from: f */
    public static final C0239x f864f = new C0239x();

    /* renamed from: a */
    public Random f865a = new Random();

    /* renamed from: b */
    public String f866b;

    /* renamed from: c */
    public String f867c;

    /* renamed from: d */
    public String f868d;

    /* renamed from: e */
    public String f869e;

    /* renamed from: c */
    public static C0239x m1671c() {
        return f864f;
    }

    /* renamed from: a */
    public void m1672a(Map<String, String> map) {
        if (map == null) {
            return;
        }
        map.put("enterFrom", this.f866b);
        map.put("traceId", this.f867c);
        map.put("currentComponent", this.f868d);
        map.put("processId", this.f869e);
    }

    /* renamed from: b */
    public final String m1673b() {
        return String.valueOf(this.f865a.nextInt(10000));
    }

    /* renamed from: d */
    public String m1674d() {
        return this.f869e;
    }

    /* renamed from: e */
    public void m1675e() {
        this.f867c = m1673b();
    }

    /* renamed from: f */
    public void m1676f(String str) {
        this.f868d = str;
    }

    /* renamed from: g */
    public void m1677g(String str) {
        this.f866b = str;
    }

    /* renamed from: h */
    public void m1678h(String str) {
        this.f869e = str;
    }
}
