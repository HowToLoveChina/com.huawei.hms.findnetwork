package com.google.crypto.tink.shaded.protobuf;

import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.crypto.tink.shaded.protobuf.e0 */
/* loaded from: classes.dex */
public class C1909e0 extends C1912f0 {

    /* renamed from: f */
    public final InterfaceC1951s0 f9119f;

    /* renamed from: com.google.crypto.tink.shaded.protobuf.e0$b */
    public static class b<K> implements Map.Entry<K, Object> {

        /* renamed from: a */
        public Map.Entry<K, C1909e0> f9120a;

        public /* synthetic */ b(Map.Entry entry, a aVar) {
            this(entry);
        }

        /* renamed from: a */
        public C1909e0 m11562a() {
            return this.f9120a.getValue();
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f9120a.getKey();
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            C1909e0 value = this.f9120a.getValue();
            if (value == null) {
                return null;
            }
            return value.m11561f();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            if (obj instanceof InterfaceC1951s0) {
                return this.f9120a.getValue().m11637d((InterfaceC1951s0) obj);
            }
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }

        public b(Map.Entry<K, C1909e0> entry) {
            this.f9120a = entry;
        }
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.e0$c */
    public static class c<K> implements Iterator<Map.Entry<K, Object>> {

        /* renamed from: a */
        public Iterator<Map.Entry<K, Object>> f9121a;

        public c(Iterator<Map.Entry<K, Object>> it) {
            this.f9121a = it;
        }

        @Override // java.util.Iterator
        /* renamed from: b */
        public Map.Entry<K, Object> next() {
            Map.Entry<K, Object> next = this.f9121a.next();
            return next.getValue() instanceof C1909e0 ? new b(next) : next;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f9121a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f9121a.remove();
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.C1912f0
    public boolean equals(Object obj) {
        return m11561f().equals(obj);
    }

    /* renamed from: f */
    public InterfaceC1951s0 m11561f() {
        return m11636c(this.f9119f);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.C1912f0
    public int hashCode() {
        return m11561f().hashCode();
    }

    public String toString() {
        return m11561f().toString();
    }
}
