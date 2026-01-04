package com.huawei.openalliance.p169ad.inter.data;

import com.huawei.openalliance.p169ad.annotations.DataKeep;

@DataKeep
/* loaded from: classes2.dex */
public class MaterialClickInfo {
    private Long clickDTime;
    private Long clickUTime;
    private Integer clickX;
    private Integer clickY;
    private String creativeSize;
    private Float density;
    private Integer mark;
    private String shakeAngle;
    private Integer sld;
    private Integer upX;
    private Integer upY;

    /* renamed from: com.huawei.openalliance.ad.inter.data.MaterialClickInfo$a */
    public static final class C7296a {

        /* renamed from: a */
        private Integer f33639a;

        /* renamed from: b */
        private Integer f33640b;

        /* renamed from: c */
        private String f33641c;

        /* renamed from: d */
        private Integer f33642d;

        /* renamed from: e */
        private Integer f33643e;

        /* renamed from: f */
        private Integer f33644f;

        /* renamed from: g */
        private Float f33645g;

        /* renamed from: h */
        private Long f33646h;

        /* renamed from: i */
        private Long f33647i;

        /* renamed from: j */
        private String f33648j;

        /* renamed from: a */
        public C7296a m44531a(Float f10) {
            this.f33645g = f10;
            return this;
        }

        /* renamed from: b */
        public C7296a m44536b(Integer num) {
            this.f33640b = num;
            return this;
        }

        /* renamed from: c */
        public C7296a m44539c(Integer num) {
            this.f33642d = num;
            return this;
        }

        /* renamed from: d */
        public C7296a m44540d(Integer num) {
            this.f33643e = num;
            return this;
        }

        /* renamed from: e */
        public C7296a m44541e(Integer num) {
            this.f33644f = num;
            return this;
        }

        /* renamed from: a */
        public C7296a m44532a(Integer num) {
            this.f33639a = num;
            return this;
        }

        /* renamed from: b */
        public C7296a m44537b(Long l10) {
            this.f33647i = l10;
            return this;
        }

        /* renamed from: a */
        public C7296a m44533a(Long l10) {
            this.f33646h = l10;
            return this;
        }

        /* renamed from: b */
        public C7296a m44538b(String str) {
            this.f33641c = str;
            return this;
        }

        /* renamed from: a */
        public C7296a m44534a(String str) {
            this.f33648j = str;
            return this;
        }

        /* renamed from: a */
        public MaterialClickInfo m44535a() {
            return new MaterialClickInfo(this);
        }
    }

    public MaterialClickInfo() {
    }

    public MaterialClickInfo(C7296a c7296a) {
        this.clickX = c7296a.f33639a;
        this.clickY = c7296a.f33640b;
        this.creativeSize = c7296a.f33641c;
        this.sld = c7296a.f33642d;
        this.density = c7296a.f33645g;
        this.upX = c7296a.f33643e;
        this.upY = c7296a.f33644f;
        this.clickDTime = c7296a.f33647i;
        this.clickUTime = c7296a.f33646h;
        this.shakeAngle = c7296a.f33648j;
    }

    /* renamed from: a */
    public Integer m44501a() {
        return this.clickX;
    }

    /* renamed from: b */
    public Integer m44506b() {
        return this.clickY;
    }

    /* renamed from: c */
    public String m44508c() {
        return this.creativeSize;
    }

    /* renamed from: d */
    public Integer m44510d() {
        return this.sld;
    }

    /* renamed from: e */
    public Integer m44512e() {
        return this.upX;
    }

    /* renamed from: f */
    public Integer m44514f() {
        return this.upY;
    }

    /* renamed from: g */
    public Float m44516g() {
        return this.density;
    }

    /* renamed from: h */
    public Long m44517h() {
        return this.clickUTime;
    }

    /* renamed from: i */
    public Long m44518i() {
        return this.clickDTime;
    }

    /* renamed from: j */
    public Integer m44519j() {
        return this.mark;
    }

    /* renamed from: k */
    public String m44520k() {
        return this.shakeAngle;
    }

    public String toString() {
        return "MaterialClickInfo{clickX=" + this.clickX + ", clickY=" + this.clickY + ", creativeSize='" + this.creativeSize + "', sld=" + this.sld + ", density=" + this.density + ", upX=" + this.upX + ", upY=" + this.upY + '}';
    }

    /* renamed from: a */
    public void m44502a(Float f10) {
        this.density = f10;
    }

    /* renamed from: b */
    public void m44507b(Integer num) {
        this.clickY = num;
    }

    /* renamed from: c */
    public void m44509c(Integer num) {
        this.sld = num;
    }

    /* renamed from: d */
    public void m44511d(Integer num) {
        this.upX = num;
    }

    /* renamed from: e */
    public void m44513e(Integer num) {
        this.upY = num;
    }

    /* renamed from: f */
    public void m44515f(Integer num) {
        this.mark = num;
    }

    /* renamed from: a */
    public void m44503a(Integer num) {
        this.clickX = num;
    }

    /* renamed from: a */
    public void m44504a(Long l10) {
        this.clickUTime = l10;
    }

    /* renamed from: a */
    public void m44505a(String str) {
        this.creativeSize = str;
    }
}
