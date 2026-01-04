package com.huawei.cloud.base.util;

import com.huawei.cloud.base.util.C4643k;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* renamed from: com.huawei.cloud.base.util.n */
/* loaded from: classes.dex */
public class C4646n extends AbstractMap<String, Object> implements Cloneable {
    final C4638g classInfo;
    Map<String, Object> unknownFields;

    /* renamed from: com.huawei.cloud.base.util.n$a */
    public final class a implements Iterator<Map.Entry<String, Object>> {

        /* renamed from: a */
        public final Iterator<Map.Entry<String, Object>> f21324a;

        /* renamed from: b */
        public final Iterator<Map.Entry<String, Object>> f21325b;

        /* renamed from: c */
        public boolean f21326c;

        public a(C4643k.c cVar) {
            this.f21324a = cVar.iterator();
            this.f21325b = C4646n.this.unknownFields.entrySet().iterator();
        }

        @Override // java.util.Iterator
        /* renamed from: b */
        public Map.Entry<String, Object> next() {
            if (!this.f21326c) {
                if (this.f21324a.hasNext()) {
                    return this.f21324a.next();
                }
                this.f21326c = true;
            }
            return this.f21325b.next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f21324a.hasNext() || this.f21325b.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.f21326c) {
                this.f21325b.remove();
            }
            this.f21324a.remove();
        }
    }

    /* renamed from: com.huawei.cloud.base.util.n$b */
    public final class b extends AbstractSet<Map.Entry<String, Object>> {

        /* renamed from: a */
        public final C4643k.c f21328a;

        public b() {
            this.f21328a = new C4643k(C4646n.this, C4646n.this.classInfo.m28432d()).entrySet();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            C4646n.this.unknownFields.clear();
            this.f21328a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<String, Object>> iterator() {
            return C4646n.this.new a(this.f21328a);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return C4646n.this.unknownFields.size() + this.f21328a.size();
        }
    }

    /* renamed from: com.huawei.cloud.base.util.n$c */
    public enum c {
        IGNORE_CASE
    }

    public C4646n() {
        this(EnumSet.noneOf(c.class));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<String, Object>> entrySet() {
        return new b();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        String lowerCase = (String) obj;
        C4645m c4645mM28430b = this.classInfo.m28430b(lowerCase);
        if (c4645mM28430b != null) {
            return c4645mM28430b.m28469g(this);
        }
        if (this.classInfo.m28432d()) {
            lowerCase = lowerCase.toLowerCase(Locale.US);
        }
        return this.unknownFields.get(lowerCase);
    }

    public final C4638g getClassInfo() {
        return this.classInfo;
    }

    public final Map<String, Object> getUnknownKeys() {
        return this.unknownFields;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void putAll(Map<? extends String, ?> map) {
        for (Map.Entry<? extends String, ?> entry : map.entrySet()) {
            set(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        String lowerCase = (String) obj;
        if (this.classInfo.m28430b(lowerCase) != null) {
            throw new UnsupportedOperationException();
        }
        if (this.classInfo.m28432d()) {
            lowerCase = lowerCase.toLowerCase(Locale.US);
        }
        return this.unknownFields.remove(lowerCase);
    }

    public C4646n set(String str, Object obj) {
        C4645m c4645mM28430b = this.classInfo.m28430b(str);
        if (c4645mM28430b != null) {
            c4645mM28430b.m28472m(this, obj);
        } else {
            if (this.classInfo.m28432d()) {
                str = str.toLowerCase(Locale.US);
            }
            this.unknownFields.put(str, obj);
        }
        return this;
    }

    public final void setUnknownKeys(Map<String, Object> map) {
        this.unknownFields = map;
    }

    public C4646n(EnumSet<c> enumSet) {
        this.unknownFields = C4626a.m28373d();
        this.classInfo = C4638g.m28428g(getClass(), enumSet.contains(c.IGNORE_CASE));
    }

    @Override // java.util.AbstractMap
    public C4646n clone() {
        try {
            C4646n c4646n = (C4646n) super.clone();
            C4642j.m28439b(this, c4646n);
            c4646n.unknownFields = (Map) C4642j.m28438a(this.unknownFields);
            return c4646n;
        } catch (CloneNotSupportedException e10) {
            throw new IllegalStateException(e10);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(String str, Object obj) {
        C4645m c4645mM28430b = this.classInfo.m28430b(str);
        if (c4645mM28430b != null) {
            Object objM28469g = c4645mM28430b.m28469g(this);
            c4645mM28430b.m28472m(this, obj);
            return objM28469g;
        }
        if (this.classInfo.m28432d()) {
            str = str.toLowerCase(Locale.US);
        }
        return this.unknownFields.put(str, obj);
    }
}
