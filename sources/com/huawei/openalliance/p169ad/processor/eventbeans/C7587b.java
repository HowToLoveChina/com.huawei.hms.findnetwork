package com.huawei.openalliance.p169ad.processor.eventbeans;

import com.huawei.openalliance.p169ad.constant.EventType;
import com.huawei.openalliance.p169ad.inter.data.MaterialClickInfo;

/* renamed from: com.huawei.openalliance.ad.processor.eventbeans.b */
/* loaded from: classes2.dex */
public class C7587b {

    /* renamed from: a */
    private int f35415a;

    /* renamed from: b */
    private int f35416b;

    /* renamed from: c */
    private String f35417c;

    /* renamed from: d */
    private Integer f35418d;

    /* renamed from: e */
    private MaterialClickInfo f35419e;

    /* renamed from: f */
    private String f35420f;

    /* renamed from: g */
    private String f35421g;

    /* renamed from: h */
    private boolean f35422h;

    /* renamed from: i */
    private String f35423i;

    /* renamed from: j */
    private boolean f35424j;

    /* renamed from: k */
    private EventType f35425k;

    /* renamed from: l */
    private String f35426l;

    /* renamed from: m */
    private String f35427m;

    /* renamed from: com.huawei.openalliance.ad.processor.eventbeans.b$a */
    public static final class a {

        /* renamed from: c */
        private String f35430c;

        /* renamed from: d */
        private Integer f35431d;

        /* renamed from: i */
        private String f35436i;

        /* renamed from: l */
        private String f35439l;

        /* renamed from: a */
        private int f35428a = 0;

        /* renamed from: b */
        private int f35429b = 0;

        /* renamed from: e */
        private MaterialClickInfo f35432e = null;

        /* renamed from: f */
        private String f35433f = null;

        /* renamed from: g */
        private String f35434g = null;

        /* renamed from: h */
        private boolean f35435h = true;

        /* renamed from: j */
        private boolean f35437j = true;

        /* renamed from: k */
        private EventType f35438k = EventType.CLICK;

        /* renamed from: c */
        public a m46922c(String str) {
            this.f35433f = str;
            return this;
        }

        /* renamed from: d */
        public a m46923d(String str) {
            this.f35434g = str;
            return this;
        }

        /* renamed from: a */
        public a m46912a(int i10) {
            this.f35428a = i10;
            return this;
        }

        /* renamed from: b */
        public a m46919b(int i10) {
            this.f35429b = i10;
            return this;
        }

        /* renamed from: e */
        public a m46924e(String str) {
            this.f35436i = str;
            return this;
        }

        /* renamed from: a */
        public a m46913a(EventType eventType) {
            this.f35438k = eventType;
            return this;
        }

        /* renamed from: b */
        public a m46920b(String str) {
            this.f35430c = str;
            return this;
        }

        /* renamed from: a */
        public a m46914a(MaterialClickInfo materialClickInfo) {
            this.f35432e = materialClickInfo;
            return this;
        }

        /* renamed from: b */
        public a m46921b(boolean z10) {
            this.f35435h = z10;
            return this;
        }

        /* renamed from: a */
        public a m46915a(Integer num) {
            this.f35431d = num;
            return this;
        }

        /* renamed from: a */
        public a m46916a(String str) {
            this.f35439l = str;
            return this;
        }

        /* renamed from: a */
        public a m46917a(boolean z10) {
            this.f35437j = z10;
            return this;
        }

        /* renamed from: a */
        public C7587b m46918a() {
            return new C7587b(this);
        }
    }

    private C7587b(a aVar) {
        this.f35424j = true;
        this.f35425k = EventType.CLICK;
        this.f35415a = aVar.f35428a;
        this.f35416b = aVar.f35429b;
        this.f35417c = aVar.f35430c;
        this.f35418d = aVar.f35431d;
        this.f35419e = aVar.f35432e;
        this.f35420f = aVar.f35433f;
        this.f35421g = aVar.f35434g;
        this.f35422h = aVar.f35435h;
        this.f35423i = aVar.f35436i;
        this.f35424j = aVar.f35437j;
        this.f35425k = aVar.f35438k;
        this.f35427m = aVar.f35439l;
    }

    /* renamed from: a */
    public String m46886a() {
        return this.f35427m;
    }

    /* renamed from: b */
    public String m46888b() {
        return this.f35426l;
    }

    /* renamed from: c */
    public boolean m46889c() {
        return this.f35424j;
    }

    /* renamed from: d */
    public int m46890d() {
        return this.f35415a;
    }

    /* renamed from: e */
    public int m46891e() {
        return this.f35416b;
    }

    /* renamed from: f */
    public String m46892f() {
        return this.f35417c;
    }

    /* renamed from: g */
    public Integer m46893g() {
        return this.f35418d;
    }

    /* renamed from: h */
    public MaterialClickInfo m46894h() {
        return this.f35419e;
    }

    /* renamed from: i */
    public String m46895i() {
        return this.f35420f;
    }

    /* renamed from: j */
    public String m46896j() {
        return this.f35421g;
    }

    /* renamed from: k */
    public boolean m46897k() {
        return this.f35422h;
    }

    /* renamed from: l */
    public String m46898l() {
        return this.f35423i;
    }

    /* renamed from: m */
    public EventType m46899m() {
        return this.f35425k;
    }

    /* renamed from: a */
    public void m46887a(String str) {
        this.f35426l = str;
    }
}
