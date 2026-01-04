package p244e1;

import java.io.IOException;
import java.io.NotActiveException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import p244e1.C9381e;
import p323h1.C10085i;
import p481n1.C11603o;

/* renamed from: e1.b */
/* loaded from: classes.dex */
public class C9378b extends AbstractC9377a implements List<Object>, Cloneable, RandomAccess, Serializable {
    private static final long serialVersionUID = 1;

    /* renamed from: k */
    public final List<Object> f46788k;

    /* renamed from: l */
    public transient Object f46789l;

    /* renamed from: m */
    public transient Type f46790m;

    public C9378b() {
        this.f46788k = new ArrayList();
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        C9381e.a.m58797s();
        if (C9381e.a.f46792a != null && !C9381e.a.f46793b) {
            try {
                new C9381e.a(objectInputStream).defaultReadObject();
                return;
            } catch (NotActiveException unused) {
            }
        }
        objectInputStream.defaultReadObject();
        for (Object obj : this.f46788k) {
            if (obj != null) {
                String name = obj.getClass().getName();
                if (C11603o.m69272Q(name) == null) {
                    C10085i.f49239z.m62860i(name, null);
                }
            }
        }
    }

    /* renamed from: E */
    public Type m58780E() {
        return this.f46790m;
    }

    /* renamed from: F */
    public Integer m58781F(int i10) {
        return C11603o.m69320t(get(i10));
    }

    /* renamed from: G */
    public Long m58782G(int i10) {
        return C11603o.m69324v(get(i10));
    }

    /* renamed from: H */
    public Object m58783H() {
        return this.f46789l;
    }

    /* renamed from: J */
    public void m58784J(Type type) {
        this.f46790m = type;
    }

    /* renamed from: K */
    public void m58785K(Object obj) {
        this.f46789l = obj;
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(Object obj) {
        return this.f46788k.add(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<?> collection) {
        return this.f46788k.addAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        this.f46788k.clear();
    }

    public Object clone() {
        return new C9378b(new ArrayList(this.f46788k));
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return this.f46788k.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        return this.f46788k.containsAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj instanceof C9378b ? this.f46788k.equals(((C9378b) obj).f46788k) : this.f46788k.equals(obj);
    }

    @Override // java.util.List
    public Object get(int i10) {
        return this.f46788k.get(i10);
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return this.f46788k.hashCode();
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return this.f46788k.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.f46788k.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<Object> iterator() {
        return this.f46788k.iterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return this.f46788k.lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator<Object> listIterator() {
        return this.f46788k.listIterator();
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        return this.f46788k.remove(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        return this.f46788k.removeAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        return this.f46788k.retainAll(collection);
    }

    @Override // java.util.List
    public Object set(int i10, Object obj) {
        if (i10 == -1) {
            this.f46788k.add(obj);
            return null;
        }
        if (this.f46788k.size() > i10) {
            return this.f46788k.set(i10, obj);
        }
        for (int size = this.f46788k.size(); size < i10; size++) {
            this.f46788k.add(null);
        }
        this.f46788k.add(obj);
        return null;
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return this.f46788k.size();
    }

    @Override // java.util.List
    public List<Object> subList(int i10, int i11) {
        return this.f46788k.subList(i10, i11);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return this.f46788k.toArray();
    }

    @Override // java.util.List
    public void add(int i10, Object obj) {
        this.f46788k.add(i10, obj);
    }

    @Override // java.util.List
    public boolean addAll(int i10, Collection<? extends Object> collection) {
        return this.f46788k.addAll(i10, collection);
    }

    @Override // java.util.List
    public ListIterator<Object> listIterator(int i10) {
        return this.f46788k.listIterator(i10);
    }

    @Override // java.util.List
    public Object remove(int i10) {
        return this.f46788k.remove(i10);
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) this.f46788k.toArray(tArr);
    }

    public C9378b(List<Object> list) {
        if (list != null) {
            this.f46788k = list;
            return;
        }
        throw new IllegalArgumentException("list is null.");
    }

    public C9378b(int i10) {
        this.f46788k = new ArrayList(i10);
    }
}
