package com.huawei.openalliance.p169ad.inter.data;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6929a;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import java.io.Serializable;

@DataKeep
@OuterVisible
/* loaded from: classes2.dex */
public class BiddingInfo implements Serializable {
    private static final long serialVersionUID = 30721000906L;
    private String cur;
    private String lurl;
    private String nurl;

    @InterfaceC6929a
    private Float price;

    /* renamed from: com.huawei.openalliance.ad.inter.data.BiddingInfo$a */
    public static final class C7295a {

        /* renamed from: a */
        private String f33614a;

        /* renamed from: b */
        @InterfaceC6929a
        private Float f33615b;

        /* renamed from: c */
        private String f33616c;

        /* renamed from: d */
        private String f33617d;

        /* renamed from: a */
        public C7295a m44454a(Float f10) {
            this.f33615b = f10;
            return this;
        }

        /* renamed from: b */
        public C7295a m44457b(String str) {
            this.f33616c = str;
            return this;
        }

        @OuterVisible
        public C7295a setLurl(String str) {
            this.f33617d = str;
            return this;
        }

        public String toString() {
            return "BiddingInfo{cur = " + this.f33614a + ", nurl = " + this.f33616c + ", lurl = " + this.f33617d + '}';
        }

        /* renamed from: a */
        public C7295a m44455a(String str) {
            this.f33614a = str;
            return this;
        }

        /* renamed from: a */
        public BiddingInfo m44456a() {
            return new BiddingInfo(this);
        }
    }

    @OuterVisible
    public BiddingInfo() {
    }

    @OuterVisible
    public BiddingInfo(C7295a c7295a) {
        if (c7295a != null) {
            this.cur = c7295a.f33614a;
            this.price = c7295a.f33615b;
            this.nurl = c7295a.f33616c;
            this.lurl = c7295a.f33617d;
        }
    }

    /* renamed from: a */
    public boolean m44449a() {
        return getPrice() == null && getCur() == null && getNurl() == null && getLurl() == null;
    }

    @OuterVisible
    public String getCur() {
        return this.cur;
    }

    @OuterVisible
    public String getLurl() {
        return this.lurl;
    }

    @OuterVisible
    public String getNurl() {
        return this.nurl;
    }

    @OuterVisible
    public Float getPrice() {
        return this.price;
    }

    public String toString() {
        return "BiddingInfo{cur = " + this.cur + ", nurl = " + this.nurl + ", lurl = " + this.lurl + '}';
    }
}
