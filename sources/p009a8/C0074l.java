package p009a8;

import android.text.TextUtils;
import android.util.LruCache;
import p031b7.C1120a;

/* renamed from: a8.l */
/* loaded from: classes2.dex */
public class C0074l {

    /* renamed from: a */
    public boolean f278a;

    /* renamed from: b */
    public String f279b;

    /* renamed from: c */
    public int f280c;

    /* renamed from: d */
    public LruCache<String, Integer> f281d;

    /* renamed from: a8.l$b */
    public static class b {

        /* renamed from: a */
        public static C0074l f282a = new C0074l();
    }

    /* renamed from: c */
    public static C0074l m603c() {
        return b.f282a;
    }

    /* renamed from: a */
    public synchronized void m604a() {
        this.f281d.evictAll();
        this.f278a = false;
        this.f279b = "";
    }

    /* renamed from: b */
    public Integer m605b(String str) {
        if (str != null) {
            return this.f281d.get(str);
        }
        C1120a.m6676e("ShareSessionManager", "getCacheUpCount key is null");
        return null;
    }

    /* renamed from: d */
    public String m606d() {
        return this.f279b;
    }

    /* renamed from: e */
    public boolean m607e() {
        return this.f278a;
    }

    /* renamed from: f */
    public boolean m608f() {
        return this.f280c == 45;
    }

    /* renamed from: g */
    public boolean m609g() {
        return !TextUtils.isEmpty(m606d());
    }

    /* renamed from: h */
    public void m610h(String str, Integer num) {
        if (str != null && num != null) {
            this.f281d.put(str, num);
            return;
        }
        C1120a.m6676e("ShareSessionManager", "setCacheUpCount upType invalid: " + str + ", value: " + num);
    }

    /* renamed from: i */
    public void m611i(boolean z10) {
        this.f278a = z10;
    }

    /* renamed from: j */
    public synchronized void m612j(String str) {
        this.f279b = str;
    }

    /* renamed from: k */
    public void m613k(int i10) {
        this.f280c = i10;
    }

    public C0074l() {
        this.f278a = false;
        this.f281d = new LruCache<>(500);
    }
}
