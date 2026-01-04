package com.huawei.hms.ads.jsb.inner.data;

import android.location.Location;
import java.util.List;

/* renamed from: com.huawei.hms.ads.jsb.inner.data.a */
/* loaded from: classes8.dex */
public class C5092a {

    /* renamed from: a */
    private List<Integer> f23260a;

    /* renamed from: b */
    private Integer f23261b;

    /* renamed from: c */
    private Integer f23262c;

    /* renamed from: d */
    private Integer f23263d;

    /* renamed from: e */
    private Location f23264e;

    /* renamed from: f */
    private String f23265f;

    /* renamed from: com.huawei.hms.ads.jsb.inner.data.a$a */
    public static final class a {

        /* renamed from: a */
        private List<Integer> f23266a;

        /* renamed from: b */
        private Integer f23267b;

        /* renamed from: c */
        private Integer f23268c;

        /* renamed from: d */
        private Integer f23269d;

        /* renamed from: e */
        private Location f23270e;

        /* renamed from: f */
        private String f23271f;

        /* renamed from: a */
        public a m30381a(Location location) {
            this.f23270e = location;
            return this;
        }

        /* renamed from: b */
        public a m30386b(Integer num) {
            this.f23268c = num;
            return this;
        }

        /* renamed from: c */
        public a m30387c(Integer num) {
            this.f23269d = num;
            return this;
        }

        /* renamed from: a */
        public a m30382a(Integer num) {
            this.f23267b = num;
            return this;
        }

        /* renamed from: a */
        public a m30383a(String str) {
            this.f23271f = str;
            return this;
        }

        /* renamed from: a */
        public a m30384a(List<Integer> list) {
            this.f23266a = list;
            return this;
        }

        /* renamed from: a */
        public C5092a m30385a() {
            C5092a c5092a = new C5092a();
            c5092a.f23260a = this.f23266a;
            c5092a.f23261b = this.f23267b;
            c5092a.f23262c = this.f23268c;
            c5092a.f23263d = this.f23269d;
            c5092a.f23264e = this.f23270e;
            c5092a.f23265f = this.f23271f;
            return c5092a;
        }
    }

    /* renamed from: b */
    public Integer m30376b() {
        return this.f23261b;
    }

    /* renamed from: c */
    public Integer m30377c() {
        return this.f23262c;
    }

    /* renamed from: d */
    public Integer m30378d() {
        return this.f23263d;
    }

    /* renamed from: e */
    public Location m30379e() {
        return this.f23264e;
    }

    /* renamed from: f */
    public String m30380f() {
        return this.f23265f;
    }

    /* renamed from: a */
    public List<Integer> m30375a() {
        return this.f23260a;
    }
}
