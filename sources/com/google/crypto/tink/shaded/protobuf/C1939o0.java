package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.C1930l0;
import java.util.Map;

/* renamed from: com.google.crypto.tink.shaded.protobuf.o0 */
/* loaded from: classes.dex */
public class C1939o0 implements InterfaceC1936n0 {
    /* renamed from: i */
    public static <K, V> int m12058i(int i10, Object obj, Object obj2) {
        C1933m0 c1933m0 = (C1933m0) obj;
        C1930l0 c1930l0 = (C1930l0) obj2;
        int iM11974a = 0;
        if (c1933m0.isEmpty()) {
            return 0;
        }
        for (Map.Entry<K, V> entry : c1933m0.entrySet()) {
            iM11974a += c1930l0.m11974a(i10, entry.getKey(), entry.getValue());
        }
        return iM11974a;
    }

    /* renamed from: j */
    public static <K, V> C1933m0<K, V> m12059j(Object obj, Object obj2) {
        C1933m0<K, V> c1933m0M12032o = (C1933m0) obj;
        C1933m0<K, V> c1933m0 = (C1933m0) obj2;
        if (!c1933m0.isEmpty()) {
            if (!c1933m0M12032o.m12029l()) {
                c1933m0M12032o = c1933m0M12032o.m12032o();
            }
            c1933m0M12032o.m12031n(c1933m0);
        }
        return c1933m0M12032o;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1936n0
    /* renamed from: a */
    public Object mo12049a(Object obj, Object obj2) {
        return m12059j(obj, obj2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1936n0
    /* renamed from: b */
    public Object mo12050b(Object obj) {
        ((C1933m0) obj).m12030m();
        return obj;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1936n0
    /* renamed from: c */
    public C1930l0.a<?, ?> mo12051c(Object obj) {
        ((C1930l0) obj).m11975c();
        return null;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1936n0
    /* renamed from: d */
    public Map<?, ?> mo12052d(Object obj) {
        return (C1933m0) obj;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1936n0
    /* renamed from: e */
    public Object mo12053e(Object obj) {
        return C1933m0.m12025f().m12032o();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1936n0
    /* renamed from: f */
    public int mo12054f(int i10, Object obj, Object obj2) {
        return m12058i(i10, obj, obj2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1936n0
    /* renamed from: g */
    public boolean mo12055g(Object obj) {
        return !((C1933m0) obj).m12029l();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1936n0
    /* renamed from: h */
    public Map<?, ?> mo12056h(Object obj) {
        return (C1933m0) obj;
    }
}
