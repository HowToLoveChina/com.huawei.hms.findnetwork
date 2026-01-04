package com.huawei.hms.network.p129ai;

import java.util.Map;

/* renamed from: com.huawei.hms.network.ai.b0 */
/* loaded from: classes8.dex */
public class C5789b0 {

    /* renamed from: a */
    public boolean f25757a;

    /* renamed from: b */
    public C5826z f25758b;

    /* renamed from: c */
    public C5787a0 f25759c;

    /* renamed from: com.huawei.hms.network.ai.b0$b */
    public static class b {

        /* renamed from: a */
        public static final C5789b0 f25760a = new C5789b0();
    }

    public C5789b0() {
        this.f25757a = false;
    }

    /* renamed from: c */
    public static C5789b0 m33249c() {
        return b.f25760a;
    }

    /* renamed from: a */
    public Map<String, Integer> m33250a(int i10, Map<String, String> map) {
        if (this.f25757a) {
            return this.f25758b.m33625a(i10, map);
        }
        return null;
    }

    /* renamed from: b */
    public void m33252b() {
        if (this.f25757a) {
            C5792d.m33287c().m33292a(C5788b.f25736f, this.f25759c);
            C5800h.m33340d().m33344a(C5788b.f25736f, this.f25758b);
        }
    }

    /* renamed from: a */
    public boolean m33251a() {
        if (this.f25757a) {
            return this.f25758b.m33629d();
        }
        return false;
    }
}
