package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.C1900b0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.crypto.tink.shaded.protobuf.i0 */
/* loaded from: classes.dex */
public abstract class AbstractC1921i0 {

    /* renamed from: a */
    public static final AbstractC1921i0 f9159a;

    /* renamed from: b */
    public static final AbstractC1921i0 f9160b;

    /* renamed from: com.google.crypto.tink.shaded.protobuf.i0$b */
    public static final class b extends AbstractC1921i0 {

        /* renamed from: c */
        public static final Class<?> f9161c = Collections.unmodifiableList(Collections.emptyList()).getClass();

        public b() {
            super();
        }

        /* renamed from: f */
        public static <E> List<E> m11715f(Object obj, long j10) {
            return (List) C1952s1.m12144A(obj, j10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: g */
        public static <L> List<L> m11716g(Object obj, long j10, int i10) {
            C1915g0 c1915g0;
            List<L> listM11715f = m11715f(obj, j10);
            if (listM11715f.isEmpty()) {
                List<L> c1915g02 = listM11715f instanceof InterfaceC1918h0 ? new C1915g0(i10) : ((listM11715f instanceof InterfaceC1901b1) && (listM11715f instanceof C1900b0.i)) ? ((C1900b0.i) listM11715f).mo11479v(i10) : new ArrayList<>(i10);
                C1952s1.m12158O(obj, j10, c1915g02);
                return c1915g02;
            }
            if (f9161c.isAssignableFrom(listM11715f.getClass())) {
                ArrayList arrayList = new ArrayList(listM11715f.size() + i10);
                arrayList.addAll(listM11715f);
                C1952s1.m12158O(obj, j10, arrayList);
                c1915g0 = arrayList;
            } else {
                if (!(listM11715f instanceof C1949r1)) {
                    if (!(listM11715f instanceof InterfaceC1901b1) || !(listM11715f instanceof C1900b0.i)) {
                        return listM11715f;
                    }
                    C1900b0.i iVar = (C1900b0.i) listM11715f;
                    if (iVar.mo11499b0()) {
                        return listM11715f;
                    }
                    C1900b0.i iVarMo11479v = iVar.mo11479v(listM11715f.size() + i10);
                    C1952s1.m12158O(obj, j10, iVarMo11479v);
                    return iVarMo11479v;
                }
                C1915g0 c1915g03 = new C1915g0(listM11715f.size() + i10);
                c1915g03.addAll((C1949r1) listM11715f);
                C1952s1.m12158O(obj, j10, c1915g03);
                c1915g0 = c1915g03;
            }
            return c1915g0;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1921i0
        /* renamed from: c */
        public void mo11712c(Object obj, long j10) {
            Object objUnmodifiableList;
            List list = (List) C1952s1.m12144A(obj, j10);
            if (list instanceof InterfaceC1918h0) {
                objUnmodifiableList = ((InterfaceC1918h0) list).mo11659Y();
            } else {
                if (f9161c.isAssignableFrom(list.getClass())) {
                    return;
                }
                if ((list instanceof InterfaceC1901b1) && (list instanceof C1900b0.i)) {
                    C1900b0.i iVar = (C1900b0.i) list;
                    if (iVar.mo11499b0()) {
                        iVar.mo11500s();
                        return;
                    }
                    return;
                }
                objUnmodifiableList = Collections.unmodifiableList(list);
            }
            C1952s1.m12158O(obj, j10, objUnmodifiableList);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1921i0
        /* renamed from: d */
        public <E> void mo11713d(Object obj, Object obj2, long j10) {
            List listM11715f = m11715f(obj2, j10);
            List listM11716g = m11716g(obj, j10, listM11715f.size());
            int size = listM11716g.size();
            int size2 = listM11715f.size();
            if (size > 0 && size2 > 0) {
                listM11716g.addAll(listM11715f);
            }
            if (size > 0) {
                listM11715f = listM11716g;
            }
            C1952s1.m12158O(obj, j10, listM11715f);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1921i0
        /* renamed from: e */
        public <L> List<L> mo11714e(Object obj, long j10) {
            return m11716g(obj, j10, 10);
        }
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.i0$c */
    public static final class c extends AbstractC1921i0 {
        public c() {
            super();
        }

        /* renamed from: f */
        public static <E> C1900b0.i<E> m11717f(Object obj, long j10) {
            return (C1900b0.i) C1952s1.m12144A(obj, j10);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1921i0
        /* renamed from: c */
        public void mo11712c(Object obj, long j10) {
            m11717f(obj, j10).mo11500s();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1921i0
        /* renamed from: d */
        public <E> void mo11713d(Object obj, Object obj2, long j10) {
            C1900b0.i iVarM11717f = m11717f(obj, j10);
            C1900b0.i iVarM11717f2 = m11717f(obj2, j10);
            int size = iVarM11717f.size();
            int size2 = iVarM11717f2.size();
            if (size > 0 && size2 > 0) {
                if (!iVarM11717f.mo11499b0()) {
                    iVarM11717f = iVarM11717f.mo11479v(size2 + size);
                }
                iVarM11717f.addAll(iVarM11717f2);
            }
            if (size > 0) {
                iVarM11717f2 = iVarM11717f;
            }
            C1952s1.m12158O(obj, j10, iVarM11717f2);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1921i0
        /* renamed from: e */
        public <L> List<L> mo11714e(Object obj, long j10) {
            C1900b0.i iVarM11717f = m11717f(obj, j10);
            if (iVarM11717f.mo11499b0()) {
                return iVarM11717f;
            }
            int size = iVarM11717f.size();
            C1900b0.i iVarMo11479v = iVarM11717f.mo11479v(size == 0 ? 10 : size * 2);
            C1952s1.m12158O(obj, j10, iVarMo11479v);
            return iVarMo11479v;
        }
    }

    static {
        f9159a = new b();
        f9160b = new c();
    }

    /* renamed from: a */
    public static AbstractC1921i0 m11710a() {
        return f9159a;
    }

    /* renamed from: b */
    public static AbstractC1921i0 m11711b() {
        return f9160b;
    }

    /* renamed from: c */
    public abstract void mo11712c(Object obj, long j10);

    /* renamed from: d */
    public abstract <L> void mo11713d(Object obj, Object obj2, long j10);

    /* renamed from: e */
    public abstract <L> List<L> mo11714e(Object obj, long j10);

    public AbstractC1921i0() {
    }
}
