package tr;

import com.huawei.location.activity.C6738e;
import p785xr.C13852b;

/* renamed from: tr.i */
/* loaded from: classes8.dex */
public class C13065i {

    /* renamed from: a */
    public C13066j f59436a;

    /* renamed from: b */
    public C13852b f59437b;

    /* renamed from: c */
    public int f59438c;

    /* renamed from: d */
    public String f59439d;

    /* renamed from: e */
    public long f59440e;

    /* renamed from: f */
    public long f59441f;

    /* renamed from: g */
    public String f59442g;

    /* renamed from: tr.i$b */
    public static final class b {

        /* renamed from: a */
        public C13066j f59443a;

        /* renamed from: b */
        public C13852b f59444b;

        /* renamed from: c */
        public int f59445c;

        /* renamed from: d */
        public String f59446d;

        /* renamed from: e */
        public long f59447e;

        /* renamed from: f */
        public long f59448f;

        /* renamed from: g */
        public String f59449g;

        public b() {
        }

        public b(C13065i c13065i) {
            this.f59443a = c13065i.f59436a;
            this.f59444b = c13065i.f59437b;
            this.f59445c = c13065i.f59438c;
            this.f59446d = c13065i.f59439d;
            this.f59447e = c13065i.f59440e;
            this.f59448f = c13065i.f59441f;
            this.f59449g = c13065i.f59442g;
        }

        /* renamed from: h */
        public b m78810h(C13066j c13066j) {
            this.f59443a = c13066j;
            return this;
        }

        /* renamed from: i */
        public C13065i m78811i() {
            return new C13065i(this);
        }

        /* renamed from: j */
        public b m78812j(int i10) {
            this.f59445c = i10;
            return this;
        }

        /* renamed from: k */
        public b m78813k(C13852b c13852b) {
            this.f59444b = c13852b;
            return this;
        }

        /* renamed from: l */
        public b m78814l(String str) {
            this.f59446d = str;
            return this;
        }

        /* renamed from: m */
        public b m78815m(long j10) {
            this.f59448f = j10;
            return this;
        }

        /* renamed from: n */
        public b m78816n(long j10) {
            this.f59447e = j10;
            return this;
        }

        /* renamed from: o */
        public b m78817o(String str) {
            this.f59449g = str;
            return this;
        }

        public /* synthetic */ b(C13065i c13065i, a aVar) {
            this(c13065i);
        }
    }

    public C13065i(b bVar) {
        this.f59436a = bVar.f59443a;
        this.f59437b = bVar.f59444b;
        this.f59438c = bVar.f59445c;
        this.f59439d = bVar.f59446d;
        this.f59440e = bVar.f59447e;
        this.f59441f = bVar.f59448f;
        this.f59442g = bVar.f59449g;
    }

    /* renamed from: h */
    public C13066j m78798h() {
        return this.f59436a;
    }

    /* renamed from: i */
    public int m78799i() {
        return this.f59438c;
    }

    /* renamed from: j */
    public long m78800j() {
        return this.f59441f - this.f59440e;
    }

    /* renamed from: k */
    public boolean m78801k() {
        int i10 = this.f59438c;
        return i10 >= 200 && i10 < 300;
    }

    /* renamed from: l */
    public b m78802l() {
        return new b();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("ResponseAdapter{body=");
        sb2.append(this.f59436a.toString());
        sb2.append(", headers=");
        sb2.append(this.f59437b.toString());
        sb2.append(", code=");
        sb2.append(this.f59438c);
        sb2.append(", message='");
        sb2.append(this.f59439d);
        sb2.append("', sentRequestAtMillis=");
        sb2.append(this.f59440e);
        sb2.append(", receivedResponseAtMillis=");
        sb2.append(this.f59441f);
        sb2.append(", url='");
        return C6738e.m38291a(sb2, this.f59442g, "'}");
    }

    public /* synthetic */ C13065i(b bVar, a aVar) {
        this(bVar);
    }
}
