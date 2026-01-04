package com.huawei.location.lite.common.chain;

/* renamed from: com.huawei.location.lite.common.chain.a */
/* loaded from: classes8.dex */
public abstract class AbstractC6777a {

    /* renamed from: a */
    public Data f31350a;

    /* renamed from: com.huawei.location.lite.common.chain.a$a */
    public static final class a extends AbstractC6777a {
        public a() {
            this(Data.f31347b);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && a.class == obj.getClass() && (obj instanceof a)) {
                return this.f31350a.equals(((a) obj).f31350a);
            }
            return false;
        }

        public int hashCode() {
            return this.f31350a.hashCode() - 1087636498;
        }

        public String toString() {
            return "Failure {outputData=" + this.f31350a + '}';
        }

        public a(Data data) {
            this.f31350a = data;
        }
    }

    /* renamed from: com.huawei.location.lite.common.chain.a$b */
    public static final class b extends AbstractC6777a {
        public b() {
            this(Data.f31347b);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && b.class == obj.getClass() && (obj instanceof b)) {
                return this.f31350a.equals(((b) obj).f31350a);
            }
            return false;
        }

        public int hashCode() {
            return this.f31350a.hashCode() + 483703957;
        }

        public String toString() {
            return "Success {outputData=" + this.f31350a + '}';
        }

        public b(Data data) {
            this.f31350a = data;
        }
    }

    /* renamed from: a */
    public static AbstractC6777a m38407a() {
        return new a();
    }

    /* renamed from: b */
    public static AbstractC6777a m38408b(Data data) {
        return new a(data);
    }

    /* renamed from: d */
    public static AbstractC6777a m38409d(Data data) {
        return new b(data);
    }

    /* renamed from: c */
    public Data m38410c() {
        return this.f31350a;
    }
}
