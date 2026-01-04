package com.google.crypto.tink.shaded.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: com.google.crypto.tink.shaded.protobuf.g0 */
/* loaded from: classes.dex */
public class C1915g0 extends AbstractC1902c<String> implements InterfaceC1918h0, RandomAccess {

    /* renamed from: c */
    public static final C1915g0 f9144c;

    /* renamed from: d */
    public static final InterfaceC1918h0 f9145d;

    /* renamed from: b */
    public final List<Object> f9146b;

    static {
        C1915g0 c1915g0 = new C1915g0();
        f9144c = c1915g0;
        c1915g0.mo11500s();
        f9145d = c1915g0;
    }

    public C1915g0() {
        this(10);
    }

    /* renamed from: c */
    public static String m11656c(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof AbstractC1920i ? ((AbstractC1920i) obj).m11701z() : C1900b0.m11495j((byte[]) obj);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1918h0
    /* renamed from: A */
    public List<?> mo11657A() {
        return Collections.unmodifiableList(this.f9146b);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1918h0
    /* renamed from: V */
    public void mo11658V(AbstractC1920i abstractC1920i) {
        m11501a();
        this.f9146b.add(abstractC1920i);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1918h0
    /* renamed from: Y */
    public InterfaceC1918h0 mo11659Y() {
        return mo11499b0() ? new C1949r1(this) : this;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1918h0
    /* renamed from: a0 */
    public Object mo11660a0(int i10) {
        return this.f9146b.get(i10);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1902c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void add(int i10, String str) {
        m11501a();
        this.f9146b.add(i10, str);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1902c, com.google.crypto.tink.shaded.protobuf.C1900b0.i
    /* renamed from: b0 */
    public /* bridge */ /* synthetic */ boolean mo11499b0() {
        return super.mo11499b0();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1902c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        m11501a();
        this.f9146b.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public String get(int i10) {
        Object obj = this.f9146b.get(i10);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof AbstractC1920i) {
            AbstractC1920i abstractC1920i = (AbstractC1920i) obj;
            String strM11701z = abstractC1920i.m11701z();
            if (abstractC1920i.mo11692l()) {
                this.f9146b.set(i10, strM11701z);
            }
            return strM11701z;
        }
        byte[] bArr = (byte[]) obj;
        String strM11495j = C1900b0.m11495j(bArr);
        if (C1900b0.m11492g(bArr)) {
            this.f9146b.set(i10, strM11495j);
        }
        return strM11495j;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.C1900b0.i
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C1915g0 mo11479v(int i10) {
        if (i10 < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i10);
        arrayList.addAll(this.f9146b);
        return new C1915g0((ArrayList<Object>) arrayList);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1902c, java.util.AbstractList, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public String remove(int i10) {
        m11501a();
        Object objRemove = this.f9146b.remove(i10);
        ((AbstractList) this).modCount++;
        return m11656c(objRemove);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public String set(int i10, String str) {
        m11501a();
        return m11656c(this.f9146b.set(i10, str));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1902c, java.util.AbstractList, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1902c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1902c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f9146b.size();
    }

    public C1915g0(int i10) {
        this((ArrayList<Object>) new ArrayList(i10));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1902c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        return super.add(obj);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1902c, java.util.AbstractList, java.util.List
    public boolean addAll(int i10, Collection<? extends String> collection) {
        m11501a();
        if (collection instanceof InterfaceC1918h0) {
            collection = ((InterfaceC1918h0) collection).mo11657A();
        }
        boolean zAddAll = this.f9146b.addAll(i10, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1902c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    public C1915g0(ArrayList<Object> arrayList) {
        this.f9146b = arrayList;
    }
}
