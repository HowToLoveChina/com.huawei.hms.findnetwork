package com.baidu.location;

import com.baidu.location.p065a.C1534f;

/* renamed from: com.baidu.location.a */
/* loaded from: classes.dex */
public final class C1528a {
    public final String address;
    public final String city;
    public final String cityCode;
    public final String country;
    public final String countryCode;
    public final String district;
    public final String province;
    public final String street;
    public final String streetNumber;

    /* renamed from: com.baidu.location.a$a */
    public static class a {

        /* renamed from: j */
        private static final String f6562j = "北京";

        /* renamed from: k */
        private static final String f6563k = "天津";

        /* renamed from: l */
        private static final String f6564l = "重庆";

        /* renamed from: m */
        private static final String f6565m = "上海";

        /* renamed from: a */
        private String f6566a = null;

        /* renamed from: b */
        private String f6567b = null;

        /* renamed from: c */
        private String f6568c = null;

        /* renamed from: d */
        private String f6569d = null;

        /* renamed from: e */
        private String f6570e = null;

        /* renamed from: f */
        private String f6571f = null;

        /* renamed from: g */
        private String f6572g = null;

        /* renamed from: h */
        private String f6573h = null;

        /* renamed from: i */
        private String f6574i = null;

        public C1528a build() {
            StringBuffer stringBuffer = new StringBuffer();
            String str = this.f6566a;
            if (str != null) {
                stringBuffer.append(str);
            }
            String str2 = this.f6568c;
            if (str2 != null) {
                stringBuffer.append(str2);
            }
            String str3 = this.f6568c;
            if (str3 != null && this.f6569d != null && ((!str3.contains(f6562j) || !this.f6569d.contains(f6562j)) && ((!this.f6568c.contains(f6565m) || !this.f6569d.contains(f6565m)) && ((!this.f6568c.contains(f6563k) || !this.f6569d.contains(f6563k)) && (!this.f6568c.contains(f6564l) || !this.f6569d.contains(f6564l)))))) {
                stringBuffer.append(this.f6569d);
            }
            String str4 = this.f6571f;
            if (str4 != null) {
                stringBuffer.append(str4);
            }
            String str5 = this.f6572g;
            if (str5 != null) {
                stringBuffer.append(str5);
            }
            String str6 = this.f6573h;
            if (str6 != null) {
                stringBuffer.append(str6);
            }
            if (stringBuffer.length() > 0) {
                this.f6574i = stringBuffer.toString();
                C1534f.m8725c("Address = " + this.f6574i);
            }
            return new C1528a(this);
        }

        public a city(String str) {
            this.f6569d = str;
            return this;
        }

        public a cityCode(String str) {
            this.f6570e = str;
            return this;
        }

        public a country(String str) {
            this.f6566a = str;
            return this;
        }

        public a countryCode(String str) {
            this.f6567b = str;
            return this;
        }

        public a district(String str) {
            this.f6571f = str;
            return this;
        }

        public a province(String str) {
            this.f6568c = str;
            return this;
        }

        public a street(String str) {
            this.f6572g = str;
            return this;
        }

        public a streetNumber(String str) {
            this.f6573h = str;
            return this;
        }
    }

    private C1528a(a aVar) {
        this.country = aVar.f6566a;
        this.countryCode = aVar.f6567b;
        this.province = aVar.f6568c;
        this.city = aVar.f6569d;
        this.cityCode = aVar.f6570e;
        this.district = aVar.f6571f;
        this.street = aVar.f6572g;
        this.streetNumber = aVar.f6573h;
        this.address = aVar.f6574i;
    }
}
