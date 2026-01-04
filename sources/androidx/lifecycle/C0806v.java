package androidx.lifecycle;

import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import com.huawei.hms.network.embedded.C6055q0;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kw.C11172e0;
import p024b0.C1088d;
import p240dx.InterfaceC9359a;
import p408jw.C10948n;
import p692uw.C13264g;
import p692uw.C13267j;
import p724w0.C13512b;

/* renamed from: androidx.lifecycle.v */
/* loaded from: classes.dex */
public final class C0806v {

    /* renamed from: f */
    public static final a f4200f = new a(null);

    /* renamed from: g */
    public static final Class<? extends Object>[] f4201g = {Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class};

    /* renamed from: a */
    public final Map<String, Object> f4202a;

    /* renamed from: b */
    public final Map<String, C13512b.c> f4203b;

    /* renamed from: c */
    public final Map<String, Object> f4204c;

    /* renamed from: d */
    public final Map<String, InterfaceC9359a<Object>> f4205d;

    /* renamed from: e */
    public final C13512b.c f4206e;

    /* renamed from: androidx.lifecycle.v$a */
    public static final class a {
        public /* synthetic */ a(C13264g c13264g) {
            this();
        }

        /* renamed from: a */
        public final C0806v m4993a(Bundle bundle, Bundle bundle2) {
            if (bundle == null) {
                if (bundle2 == null) {
                    return new C0806v();
                }
                HashMap map = new HashMap();
                for (String str : bundle2.keySet()) {
                    C13267j.m79676d(str, "key");
                    map.put(str, bundle2.get(str));
                }
                return new C0806v(map);
            }
            ArrayList parcelableArrayList = bundle.getParcelableArrayList("keys");
            ArrayList parcelableArrayList2 = bundle.getParcelableArrayList(C6055q0.f27803j);
            if (parcelableArrayList == null || parcelableArrayList2 == null || parcelableArrayList.size() != parcelableArrayList2.size()) {
                throw new IllegalStateException("Invalid bundle passed as restored state".toString());
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int size = parcelableArrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                Object obj = parcelableArrayList.get(i10);
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                linkedHashMap.put((String) obj, parcelableArrayList2.get(i10));
            }
            return new C0806v(linkedHashMap);
        }

        /* renamed from: b */
        public final boolean m4994b(Object obj) {
            if (obj == null) {
                return true;
            }
            for (Class cls : C0806v.f4201g) {
                C13267j.m79674b(cls);
                if (cls.isInstance(obj)) {
                    return true;
                }
            }
            return false;
        }

        public a() {
        }
    }

    public C0806v(Map<String, ? extends Object> map) {
        C13267j.m79677e(map, "initialState");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.f4202a = linkedHashMap;
        this.f4203b = new LinkedHashMap();
        this.f4204c = new LinkedHashMap();
        this.f4205d = new LinkedHashMap();
        this.f4206e = new C13512b.c() { // from class: androidx.lifecycle.u
            @Override // p724w0.C13512b.c
            /* renamed from: a */
            public final Bundle mo1944a() {
                return C0806v.m4990e(this.f4199a);
            }
        };
        linkedHashMap.putAll(map);
    }

    /* renamed from: c */
    public static final C0806v m4989c(Bundle bundle, Bundle bundle2) {
        return f4200f.m4993a(bundle, bundle2);
    }

    /* renamed from: e */
    public static final Bundle m4990e(C0806v c0806v) {
        C13267j.m79677e(c0806v, "this$0");
        for (Map.Entry entry : C11172e0.m67140i(c0806v.f4203b).entrySet()) {
            c0806v.m4992f((String) entry.getKey(), ((C13512b.c) entry.getValue()).mo1944a());
        }
        Set<String> setKeySet = c0806v.f4202a.keySet();
        ArrayList arrayList = new ArrayList(setKeySet.size());
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (String str : setKeySet) {
            arrayList.add(str);
            arrayList2.add(c0806v.f4202a.get(str));
        }
        return C1088d.m6467a(C10948n.m66075a("keys", arrayList), C10948n.m66075a(C6055q0.f27803j, arrayList2));
    }

    /* renamed from: d */
    public final C13512b.c m4991d() {
        return this.f4206e;
    }

    /* renamed from: f */
    public final <T> void m4992f(String str, T t10) {
        C13267j.m79677e(str, "key");
        if (!f4200f.m4994b(t10)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Can't put value with type ");
            C13267j.m79674b(t10);
            sb2.append(t10.getClass());
            sb2.append(" into saved state");
            throw new IllegalArgumentException(sb2.toString());
        }
        Object obj = this.f4204c.get(str);
        C0801q c0801q = obj instanceof C0801q ? (C0801q) obj : null;
        if (c0801q != null) {
            c0801q.mo4896n(t10);
        } else {
            this.f4202a.put(str, t10);
        }
        InterfaceC9359a<Object> interfaceC9359a = this.f4205d.get(str);
        if (interfaceC9359a == null) {
            return;
        }
        interfaceC9359a.setValue(t10);
    }

    public C0806v() {
        this.f4202a = new LinkedHashMap();
        this.f4203b = new LinkedHashMap();
        this.f4204c = new LinkedHashMap();
        this.f4205d = new LinkedHashMap();
        this.f4206e = new C13512b.c() { // from class: androidx.lifecycle.u
            @Override // p724w0.C13512b.c
            /* renamed from: a */
            public final Bundle mo1944a() {
                return C0806v.m4990e(this.f4199a);
            }
        };
    }
}
