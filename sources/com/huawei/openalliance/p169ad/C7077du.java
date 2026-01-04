package com.huawei.openalliance.p169ad;

import com.huawei.openalliance.p169ad.constant.Scheme;
import com.huawei.openalliance.p169ad.download.DownloadTask;
import com.huawei.openalliance.p169ad.utils.AbstractC7801cu;

/* renamed from: com.huawei.openalliance.ad.du */
/* loaded from: classes8.dex */
public class C7077du extends DownloadTask {

    /* renamed from: c */
    private String f32606c;

    /* renamed from: d */
    private String f32607d;

    /* renamed from: e */
    private String f32608e;

    /* renamed from: f */
    private Long f32609f;

    /* renamed from: g */
    private Long f32610g;

    /* renamed from: i */
    private String f32612i;

    /* renamed from: b */
    private int f32605b = -1;

    /* renamed from: h */
    private boolean f32611h = false;

    /* renamed from: a */
    int f32604a = 0;

    /* renamed from: com.huawei.openalliance.ad.du$a */
    public static class a {

        /* renamed from: a */
        private boolean f32613a = false;

        /* renamed from: b */
        private String f32614b;

        /* renamed from: c */
        private int f32615c;

        /* renamed from: d */
        private String f32616d;

        /* renamed from: e */
        private String f32617e;

        /* renamed from: f */
        private String f32618f;

        /* renamed from: a */
        public a m42708a(int i10) {
            this.f32615c = i10;
            return this;
        }

        /* renamed from: b */
        public a m42712b(String str) {
            this.f32616d = str;
            return this;
        }

        /* renamed from: c */
        public a m42713c(String str) {
            this.f32617e = str;
            return this;
        }

        /* renamed from: d */
        public a m42714d(String str) {
            this.f32618f = str;
            return this;
        }

        /* renamed from: a */
        public a m42709a(String str) {
            this.f32614b = str;
            return this;
        }

        /* renamed from: a */
        public a m42710a(boolean z10) {
            this.f32613a = z10;
            return this;
        }

        /* renamed from: a */
        public C7077du m42711a() {
            C7077du c7077du = new C7077du();
            c7077du.m42057a(this.f32613a);
            String strM48126a = AbstractC7801cu.m48126a(this.f32614b);
            c7077du.m42704g(strM48126a);
            c7077du.m42072e(C7076dt.m42678h().m42684b(strM48126a));
            c7077du.m42069d(Scheme.DISKCACHE.toString() + strM48126a);
            c7077du.m42056a(this.f32614b);
            c7077du.m42066c(this.f32616d);
            c7077du.m42047a((long) this.f32615c);
            c7077du.m42046a(0);
            c7077du.m42706i(this.f32618f);
            c7077du.m42705h(this.f32617e);
            return c7077du;
        }
    }

    /* renamed from: B */
    public String m42691B() {
        return this.f32607d;
    }

    /* renamed from: C */
    public String m42692C() {
        return this.f32608e;
    }

    /* renamed from: D */
    public boolean m42693D() {
        return this.f32611h;
    }

    /* renamed from: E */
    public Long m42694E() {
        return this.f32609f;
    }

    /* renamed from: F */
    public Long m42695F() {
        return this.f32610g;
    }

    /* renamed from: G */
    public int m42696G() {
        return this.f32605b;
    }

    /* renamed from: H */
    public String m42697H() {
        return this.f32612i;
    }

    /* renamed from: I */
    public int m42698I() {
        return this.f32604a;
    }

    /* renamed from: a */
    public void m42699a(Long l10) {
        this.f32609f = l10;
    }

    /* renamed from: b */
    public void m42700b(Long l10) {
        this.f32610g = l10;
    }

    /* renamed from: d */
    public void m42701d(int i10) {
        this.f32605b = i10;
    }

    /* renamed from: e */
    public void m42702e(int i10) {
        this.f32604a = i10;
    }

    @Override // com.huawei.openalliance.p169ad.download.DownloadTask
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* renamed from: g */
    public void m42704g(String str) {
        this.f32606c = str;
    }

    /* renamed from: h */
    public void m42705h(String str) {
        this.f32607d = str;
    }

    @Override // com.huawei.openalliance.p169ad.download.DownloadTask
    public int hashCode() {
        return super.hashCode();
    }

    /* renamed from: i */
    public void m42706i(String str) {
        this.f32608e = str;
    }

    /* renamed from: j */
    public void m42707j(String str) {
        this.f32612i = str;
    }

    @Override // com.huawei.openalliance.p169ad.download.DownloadTask
    /* renamed from: n */
    public String mo42082n() {
        return this.f32606c;
    }

    /* renamed from: e */
    public void m42703e(boolean z10) {
        this.f32611h = z10;
    }
}
