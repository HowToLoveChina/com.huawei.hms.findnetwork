package p247e4;

import com.huawei.ads.adsrec.p066db.table.AdEventRecord;

/* renamed from: e4.a */
/* loaded from: classes.dex */
public class C9405a {

    /* renamed from: a */
    public AdEventRecord f46997a;

    /* renamed from: e4.a$a */
    public static class a {

        /* renamed from: a */
        public String f46998a;

        /* renamed from: b */
        public String f46999b;

        /* renamed from: c */
        public String f47000c;

        /* renamed from: d */
        public String f47001d;

        /* renamed from: e */
        public Long f47002e;

        /* renamed from: f */
        public Integer f47003f;

        /* renamed from: g */
        public String f47004g;

        /* renamed from: h */
        public Long f47005h;

        /* renamed from: i */
        public String f47006i;

        /* renamed from: a */
        public C9405a m58961a() {
            AdEventRecord adEventRecord = new AdEventRecord();
            adEventRecord.m12466D(this.f46998a);
            adEventRecord.m12470H(this.f46999b);
            adEventRecord.m12479z(this.f47000c);
            adEventRecord.m12468F(this.f47001d);
            Long l10 = this.f47002e;
            if (l10 != null) {
                adEventRecord.m12478y(l10.longValue());
            }
            Integer num = this.f47003f;
            if (num != null) {
                adEventRecord.m12474u(num.intValue());
            }
            adEventRecord.m12464B(this.f47004g);
            Long l11 = this.f47005h;
            if (l11 != null) {
                adEventRecord.m12475v(l11.longValue());
            }
            String str = this.f47006i;
            if (str != null) {
                adEventRecord.m12476w(str);
            }
            return new C9405a(adEventRecord);
        }

        /* renamed from: b */
        public a m58962b(String str) {
            this.f47006i = str;
            return this;
        }

        /* renamed from: c */
        public a m58963c(String str) {
            this.f47000c = str;
            return this;
        }

        /* renamed from: d */
        public a m58964d(Long l10) {
            this.f47005h = l10;
            return this;
        }

        /* renamed from: e */
        public a m58965e(String str) {
            this.f47004g = str;
            return this;
        }

        /* renamed from: f */
        public a m58966f(Integer num) {
            this.f47003f = num;
            return this;
        }

        /* renamed from: g */
        public a m58967g(String str) {
            this.f46998a = str;
            return this;
        }

        /* renamed from: h */
        public a m58968h(Long l10) {
            this.f47002e = l10;
            return this;
        }

        /* renamed from: i */
        public a m58969i(String str) {
            this.f47001d = str;
            return this;
        }

        /* renamed from: j */
        public a m58970j(String str) {
            this.f46999b = str;
            return this;
        }
    }

    public C9405a(AdEventRecord adEventRecord) {
        this.f46997a = adEventRecord;
    }

    /* renamed from: a */
    public AdEventRecord m58960a() {
        return this.f46997a;
    }

    public String toString() {
        return "AdAffair{" + this.f46997a + '}';
    }
}
