package com.google.crypto.tink.shaded.protobuf;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* renamed from: com.google.crypto.tink.shaded.protobuf.r1 */
/* loaded from: classes.dex */
public class C1949r1 extends AbstractList<String> implements InterfaceC1918h0, RandomAccess {

    /* renamed from: a */
    public final InterfaceC1918h0 f9248a;

    /* renamed from: com.google.crypto.tink.shaded.protobuf.r1$a */
    public class a implements ListIterator<String> {

        /* renamed from: a */
        public ListIterator<String> f9249a;

        /* renamed from: b */
        public final /* synthetic */ int f9250b;

        public a(int i10) {
            this.f9250b = i10;
            this.f9249a = C1949r1.this.f9248a.listIterator(i10);
        }

        @Override // java.util.ListIterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void add(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public String next() {
            return this.f9249a.next();
        }

        @Override // java.util.ListIterator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public String previous() {
            return this.f9249a.previous();
        }

        @Override // java.util.ListIterator
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void set(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f9249a.hasNext();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f9249a.hasPrevious();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f9249a.nextIndex();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f9249a.previousIndex();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.r1$b */
    public class b implements Iterator<String> {

        /* renamed from: a */
        public Iterator<String> f9252a;

        public b() {
            this.f9252a = C1949r1.this.f9248a.iterator();
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public String next() {
            return this.f9252a.next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f9252a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public C1949r1(InterfaceC1918h0 interfaceC1918h0) {
        this.f9248a = interfaceC1918h0;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1918h0
    /* renamed from: A */
    public List<?> mo11657A() {
        return this.f9248a.mo11657A();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1918h0
    /* renamed from: V */
    public void mo11658V(AbstractC1920i abstractC1920i) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1918h0
    /* renamed from: Y */
    public InterfaceC1918h0 mo11659Y() {
        return this;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1918h0
    /* renamed from: a0 */
    public Object mo11660a0(int i10) {
        return this.f9248a.mo11660a0(i10);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String get(int i10) {
        return (String) this.f9248a.get(i10);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<String> iterator() {
        return new b();
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<String> listIterator(int i10) {
        return new a(i10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f9248a.size();
    }
}
