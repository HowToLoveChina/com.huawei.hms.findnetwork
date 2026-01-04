package com.huawei.hms.framework.network.restclient.hwhttp.dns;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes8.dex */
public class DnsResult {
    public static final int INVALID = 2;
    public static final String KEY_ADDRESSLIST = "addressList";
    public static final String KEY_ATN_CODE = "atnCode";
    public static final String KEY_CREATE_TIME = "createTime";
    public static final String KEY_TTL = "ttl";
    public static final String KEY_TYPE = "type";
    public static final String KEY_VALUE = "value";
    public static final int NEED_UPDATE = 1;
    public static final long TIME_TO_LIVE = 600000;
    public static final long TIME_TO_UPDATE = 86400000;
    public static final String TYPE_A = "A";
    public static final String TYPE_AAAA = "AAAA";
    public static final String TYPE_ALL = "ALL";
    public static final String TYPE_CNAME = "CNAME";
    public static final int VALID = 0;

    /* renamed from: d */
    private int f25127d;

    /* renamed from: a */
    private String f25124a = "A";

    /* renamed from: b */
    private List<Address> f25125b = new ArrayList();

    /* renamed from: c */
    private long f25126c = System.currentTimeMillis();

    /* renamed from: e */
    private int f25128e = -1;

    public static class Address {

        /* renamed from: a */
        private String f25129a;

        /* renamed from: b */
        private String f25130b;

        /* renamed from: c */
        private long f25131c;

        public static final class Builder {

            /* renamed from: a */
            private String f25132a;

            /* renamed from: b */
            private String f25133b;

            /* renamed from: c */
            private long f25134c = 2147483647L;

            public Address build() {
                return new Address(this);
            }

            public Builder ttl(long j10) {
                this.f25134c = j10;
                return this;
            }

            public Builder type(String str) {
                this.f25132a = str;
                return this;
            }

            public Builder value(String str) {
                this.f25133b = str;
                return this;
            }
        }

        private Address(Builder builder) {
            this.f25129a = builder.f25132a;
            this.f25130b = builder.f25133b;
            this.f25131c = builder.f25134c;
        }

        public long getTtl() {
            return this.f25131c;
        }

        public String getType() {
            return this.f25129a;
        }

        public String getValue() {
            return this.f25130b;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Address{type='");
            sb2.append(this.f25129a);
            sb2.append('\'');
            sb2.append(", value is null='");
            sb2.append(this.f25130b == null);
            sb2.append('\'');
            sb2.append(", ttl=");
            sb2.append(this.f25131c);
            sb2.append('}');
            return sb2.toString();
        }
    }

    public void addAddress(Address address) {
        this.f25125b.add(address);
    }

    public List<Address> getAddressList() {
        return this.f25125b;
    }

    public int getCache() {
        return this.f25128e;
    }

    public long getCreateTime() {
        return this.f25126c;
    }

    public List<String> getIpList() {
        ArrayList arrayList = new ArrayList(this.f25125b.size());
        Iterator<Address> it = this.f25125b.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getValue());
        }
        return arrayList;
    }

    public int getSource() {
        return this.f25127d;
    }

    public int getStatus() {
        long jAbs = Math.abs(System.currentTimeMillis() - this.f25126c);
        if (jAbs < 600000) {
            return 0;
        }
        return jAbs < 86400000 ? 1 : 2;
    }

    public String getType() {
        return this.f25124a;
    }

    public boolean isEmpty() {
        return this.f25125b.isEmpty();
    }

    public void setAddressList(List<Address> list) {
        if (list == null) {
            this.f25125b = new ArrayList();
        } else {
            this.f25125b = list;
        }
    }

    public void setCache(int i10) {
        this.f25128e = i10;
    }

    public void setCreateTime(long j10) {
        this.f25126c = j10;
    }

    public void setSource(int i10) {
        this.f25127d = i10;
    }

    public void setType(String str) {
        this.f25124a = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("DnsResult{type='");
        sb2.append(this.f25124a);
        sb2.append('\'');
        sb2.append(isEmpty() ? ", addressList isEmpty" : ", addressList is not Empty");
        sb2.append(", createTime=");
        sb2.append(this.f25126c);
        sb2.append(", source=");
        sb2.append(this.f25127d);
        sb2.append(", cache=");
        sb2.append(this.f25128e);
        sb2.append('}');
        return sb2.toString();
    }

    public void addAddress(List<Address> list) {
        this.f25125b.addAll(list);
    }
}
