package com.huawei.location.lite.common.chain;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes8.dex */
public final class Data {

    /* renamed from: b */
    public static final Data f31347b = new C6776a().m38400a();

    /* renamed from: a */
    public Map<String, Object> f31348a;

    /* renamed from: com.huawei.location.lite.common.chain.Data$a */
    public static final class C6776a {

        /* renamed from: a */
        public Map<String, Object> f31349a = new HashMap();

        /* renamed from: a */
        public Data m38400a() {
            return new Data(this.f31349a);
        }

        /* renamed from: b */
        public C6776a m38401b(String str, Object obj) {
            if (obj == null) {
                this.f31349a.put(str, null);
            } else {
                Class<?> cls = obj.getClass();
                if (cls != Integer.class && cls != String.class && !(obj instanceof Serializable) && !(obj instanceof Parcelable)) {
                    Locale locale = Locale.ENGLISH;
                    throw new IllegalArgumentException("Key " + str + " has invalid type " + cls);
                }
                this.f31349a.put(str, obj);
            }
            return this;
        }

        /* renamed from: c */
        public C6776a m38402c(Data data) {
            m38403d(data.f31348a);
            return this;
        }

        /* renamed from: d */
        public C6776a m38403d(Map<String, Object> map) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                m38401b(entry.getKey(), entry.getValue());
            }
            return this;
        }

        /* renamed from: e */
        public C6776a m38404e(String str, int i10) {
            this.f31349a.put(str, Integer.valueOf(i10));
            return this;
        }

        /* renamed from: f */
        public C6776a m38405f(String str, Parcelable parcelable) {
            this.f31349a.put(str, parcelable);
            return this;
        }

        /* renamed from: g */
        public C6776a m38406g(String str, String str2) {
            this.f31349a.put(str, str2);
            return this;
        }
    }

    public Data(Map<String, ?> map) {
        this.f31348a = new HashMap(map);
    }

    /* renamed from: a */
    public int m38396a(String str, int i10) {
        Object obj = this.f31348a.get(str);
        return obj instanceof Integer ? ((Integer) obj).intValue() : i10;
    }

    /* renamed from: b */
    public Map<String, Object> m38397b() {
        return Collections.unmodifiableMap(this.f31348a);
    }

    /* renamed from: c */
    public Parcelable m38398c(String str) {
        Object obj = this.f31348a.get(str);
        return obj instanceof Parcelable ? (Parcelable) obj : new Parcelable() { // from class: com.huawei.location.lite.common.chain.Data.1
            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i10) {
            }
        };
    }

    /* renamed from: d */
    public String m38399d(String str) {
        Object obj = this.f31348a.get(str);
        return obj instanceof String ? (String) obj : "";
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("Data {");
        if (!this.f31348a.isEmpty()) {
            for (String str : this.f31348a.keySet()) {
                sb2.append(str);
                sb2.append(" : ");
                Object obj = this.f31348a.get(str);
                if (obj instanceof Object[]) {
                    sb2.append(Arrays.toString((Object[]) obj));
                } else {
                    sb2.append(obj);
                }
                sb2.append(", ");
            }
        }
        sb2.append("}");
        return sb2.toString();
    }
}
