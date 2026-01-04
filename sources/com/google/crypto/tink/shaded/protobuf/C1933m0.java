package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.C1900b0;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.crypto.tink.shaded.protobuf.m0 */
/* loaded from: classes.dex */
public final class C1933m0<K, V> extends LinkedHashMap<K, V> {

    /* renamed from: b */
    public static final C1933m0 f9226b;

    /* renamed from: a */
    public boolean f9227a;

    static {
        C1933m0 c1933m0 = new C1933m0();
        f9226b = c1933m0;
        c1933m0.m12030m();
    }

    public C1933m0() {
        this.f9227a = true;
    }

    /* renamed from: b */
    public static <K, V> int m12022b(Map<K, V> map) {
        int iM12023c = 0;
        for (Map.Entry<K, V> entry : map.entrySet()) {
            iM12023c += m12023c(entry.getValue()) ^ m12023c(entry.getKey());
        }
        return iM12023c;
    }

    /* renamed from: c */
    public static int m12023c(Object obj) {
        if (obj instanceof byte[]) {
            return C1900b0.m11489d((byte[]) obj);
        }
        if (obj instanceof C1900b0.c) {
            throw new UnsupportedOperationException();
        }
        return obj.hashCode();
    }

    /* renamed from: d */
    public static void m12024d(Map<?, ?> map) {
        for (Object obj : map.keySet()) {
            C1900b0.m11486a(obj);
            C1900b0.m11486a(map.get(obj));
        }
    }

    /* renamed from: f */
    public static <K, V> C1933m0<K, V> m12025f() {
        return f9226b;
    }

    /* renamed from: j */
    public static boolean m12026j(Object obj, Object obj2) {
        return ((obj instanceof byte[]) && (obj2 instanceof byte[])) ? Arrays.equals((byte[]) obj, (byte[]) obj2) : obj.equals(obj2);
    }

    /* renamed from: k */
    public static <K, V> boolean m12027k(Map<K, V> map, Map<K, V> map2) {
        if (map == map2) {
            return true;
        }
        if (map.size() != map2.size()) {
            return false;
        }
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (!map2.containsKey(entry.getKey()) || !m12026j(entry.getValue(), map2.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        m12028g();
        super.clear();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        return (obj instanceof Map) && m12027k(this, (Map) obj);
    }

    /* renamed from: g */
    public final void m12028g() {
        if (!m12029l()) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        return m12022b(this);
    }

    /* renamed from: l */
    public boolean m12029l() {
        return this.f9227a;
    }

    /* renamed from: m */
    public void m12030m() {
        this.f9227a = false;
    }

    /* renamed from: n */
    public void m12031n(C1933m0<K, V> c1933m0) {
        m12028g();
        if (c1933m0.isEmpty()) {
            return;
        }
        putAll(c1933m0);
    }

    /* renamed from: o */
    public C1933m0<K, V> m12032o() {
        return isEmpty() ? new C1933m0<>() : new C1933m0<>(this);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public V put(K k10, V v10) {
        m12028g();
        C1900b0.m11486a(k10);
        C1900b0.m11486a(v10);
        return (V) super.put(k10, v10);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        m12028g();
        m12024d(map);
        super.putAll(map);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        m12028g();
        return (V) super.remove(obj);
    }

    public C1933m0(Map<K, V> map) {
        super(map);
        this.f9227a = true;
    }
}
