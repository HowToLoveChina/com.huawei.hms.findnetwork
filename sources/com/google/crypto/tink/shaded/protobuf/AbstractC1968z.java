package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.AbstractC1896a;
import com.google.crypto.tink.shaded.protobuf.AbstractC1968z;
import com.google.crypto.tink.shaded.protobuf.AbstractC1968z.a;
import com.google.crypto.tink.shaded.protobuf.C1900b0;
import com.google.crypto.tink.shaded.protobuf.C1908e;
import com.google.crypto.tink.shaded.protobuf.C1958u1;
import com.google.crypto.tink.shaded.protobuf.C1959v;
import com.google.crypto.tink.shaded.protobuf.InterfaceC1951s0;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import p831z3.C14089a;

/* renamed from: com.google.crypto.tink.shaded.protobuf.z */
/* loaded from: classes.dex */
public abstract class AbstractC1968z<MessageType extends AbstractC1968z<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends AbstractC1896a<MessageType, BuilderType> {
    private static Map<Object, AbstractC1968z<?, ?>> defaultInstanceMap = new ConcurrentHashMap();
    protected C1943p1 unknownFields = C1943p1.m12088e();
    protected int memoizedSerializedSize = -1;

    /* renamed from: com.google.crypto.tink.shaded.protobuf.z$a */
    public static abstract class a<MessageType extends AbstractC1968z<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends AbstractC1896a.a<MessageType, BuilderType> {

        /* renamed from: a */
        public final MessageType f9422a;

        /* renamed from: b */
        public MessageType f9423b;

        /* renamed from: c */
        public boolean f9424c = false;

        public a(MessageType messagetype) {
            this.f9422a = messagetype;
            this.f9423b = (MessageType) messagetype.m12395s(f.NEW_MUTABLE_INSTANCE);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1951s0.a
        /* renamed from: o */
        public final MessageType build() {
            MessageType messagetype = (MessageType) mo12143I();
            if (messagetype.mo12209m()) {
                return messagetype;
            }
            throw AbstractC1896a.a.m11463n(messagetype);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1951s0.a
        /* renamed from: p */
        public MessageType mo12143I() {
            if (this.f9424c) {
                return this.f9423b;
            }
            this.f9423b.m12390A();
            this.f9424c = true;
            return this.f9423b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: q */
        public BuilderType clone() {
            C14089a.b bVar = (BuilderType) mo12208c().mo12141k();
            bVar.m12406v(mo12143I());
            return bVar;
        }

        /* renamed from: r */
        public final void m12402r() {
            if (this.f9424c) {
                m12403s();
                this.f9424c = false;
            }
        }

        /* renamed from: s */
        public void m12403s() {
            MessageType messagetype = (MessageType) this.f9423b.m12395s(f.NEW_MUTABLE_INSTANCE);
            m12407w(messagetype, this.f9423b);
            this.f9423b = messagetype;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1954t0
        /* renamed from: t */
        public MessageType mo12208c() {
            return this.f9422a;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1896a.a
        /* renamed from: u */
        public BuilderType mo11464a(MessageType messagetype) {
            return (BuilderType) m12406v(messagetype);
        }

        /* renamed from: v */
        public BuilderType m12406v(MessageType messagetype) {
            m12402r();
            m12407w(this.f9423b, messagetype);
            return this;
        }

        /* renamed from: w */
        public final void m12407w(MessageType messagetype, MessageType messagetype2) {
            C1907d1.m11516a().m11520e(messagetype).mo11667a(messagetype, messagetype2);
        }
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.z$b */
    public static class b<T extends AbstractC1968z<T, ?>> extends AbstractC1899b<T> {

        /* renamed from: b */
        public final T f9425b;

        public b(T t10) {
            this.f9425b = t10;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1898a1
        /* renamed from: g */
        public T mo11481b(AbstractC1923j abstractC1923j, C1944q c1944q) throws C1903c0 {
            return (T) AbstractC1968z.m12382H(this.f9425b, abstractC1923j, c1944q);
        }
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.z$c */
    public static abstract class c<MessageType extends c<MessageType, BuilderType>, BuilderType> extends AbstractC1968z<MessageType, BuilderType> implements InterfaceC1954t0 {
        protected C1959v<d> extensions = C1959v.m12265h();

        /* renamed from: M */
        public C1959v<d> m12409M() {
            if (this.extensions.m12277n()) {
                this.extensions = this.extensions.clone();
            }
            return this.extensions;
        }
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.z$d */
    public static final class d implements C1959v.b<d> {

        /* renamed from: a */
        public final C1900b0.d<?> f9426a;

        /* renamed from: b */
        public final int f9427b;

        /* renamed from: c */
        public final C1958u1.b f9428c;

        /* renamed from: d */
        public final boolean f9429d;

        /* renamed from: e */
        public final boolean f9430e;

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(d dVar) {
            return this.f9427b - dVar.f9427b;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.C1959v.b
        /* renamed from: a0 */
        public int mo12285a0() {
            return this.f9427b;
        }

        /* renamed from: b */
        public C1900b0.d<?> m12411b() {
            return this.f9426a;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.C1959v.b
        /* renamed from: b0 */
        public boolean mo12286b0() {
            return this.f9429d;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.C1959v.b
        /* renamed from: c0 */
        public C1958u1.b mo12287c0() {
            return this.f9428c;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.crypto.tink.shaded.protobuf.C1959v.b
        /* renamed from: d0 */
        public InterfaceC1951s0.a mo12288d0(InterfaceC1951s0.a aVar, InterfaceC1951s0 interfaceC1951s0) {
            return ((a) aVar).m12406v((AbstractC1968z) interfaceC1951s0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.C1959v.b
        /* renamed from: l0 */
        public C1958u1.c mo12289l0() {
            return this.f9428c.m12260b();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.C1959v.b
        /* renamed from: o0 */
        public boolean mo12290o0() {
            return this.f9430e;
        }
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.z$e */
    public static class e<ContainingType extends InterfaceC1951s0, Type> extends AbstractC1938o<ContainingType, Type> {

        /* renamed from: a */
        public final InterfaceC1951s0 f9431a;

        /* renamed from: b */
        public final d f9432b;

        /* renamed from: a */
        public C1958u1.b m12412a() {
            return this.f9432b.mo12287c0();
        }

        /* renamed from: b */
        public InterfaceC1951s0 m12413b() {
            return this.f9431a;
        }

        /* renamed from: c */
        public int m12414c() {
            return this.f9432b.mo12285a0();
        }

        /* renamed from: d */
        public boolean m12415d() {
            return this.f9432b.f9429d;
        }
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.z$f */
    public enum f {
        GET_MEMOIZED_IS_INITIALIZED,
        SET_MEMOIZED_IS_INITIALIZED,
        BUILD_MESSAGE_INFO,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE,
        GET_PARSER
    }

    /* renamed from: B */
    public static <E> C1900b0.i<E> m12377B(C1900b0.i<E> iVar) {
        int size = iVar.size();
        return iVar.mo11479v(size == 0 ? 10 : size * 2);
    }

    /* renamed from: D */
    public static Object m12378D(InterfaceC1951s0 interfaceC1951s0, String str, Object[] objArr) {
        return new C1913f1(interfaceC1951s0, str, objArr);
    }

    /* renamed from: E */
    public static <T extends AbstractC1968z<T, ?>> T m12379E(T t10, AbstractC1920i abstractC1920i, C1944q c1944q) throws C1903c0 {
        return (T) m12385q(m12381G(t10, abstractC1920i, c1944q));
    }

    /* renamed from: F */
    public static <T extends AbstractC1968z<T, ?>> T m12380F(T t10, byte[] bArr, C1944q c1944q) throws C1903c0 {
        return (T) m12385q(m12383J(t10, bArr, 0, bArr.length, c1944q));
    }

    /* renamed from: G */
    public static <T extends AbstractC1968z<T, ?>> T m12381G(T t10, AbstractC1920i abstractC1920i, C1944q c1944q) throws C1903c0 {
        AbstractC1923j abstractC1923jMo11694o = abstractC1920i.mo11694o();
        T t11 = (T) m12382H(t10, abstractC1923jMo11694o, c1944q);
        try {
            abstractC1923jMo11694o.mo11727a(0);
            return t11;
        } catch (C1903c0 e10) {
            throw e10.m11511k(t11);
        }
    }

    /* renamed from: H */
    public static <T extends AbstractC1968z<T, ?>> T m12382H(T t10, AbstractC1923j abstractC1923j, C1944q c1944q) throws C1903c0 {
        T t11 = (T) t10.m12395s(f.NEW_MUTABLE_INSTANCE);
        try {
            InterfaceC1919h1 interfaceC1919h1M11520e = C1907d1.m11516a().m11520e(t11);
            interfaceC1919h1M11520e.mo11672f(t11, C1926k.m11830Q(abstractC1923j), c1944q);
            interfaceC1919h1M11520e.mo11668b(t11);
            return t11;
        } catch (IOException e10) {
            if (e10.getCause() instanceof C1903c0) {
                throw ((C1903c0) e10.getCause());
            }
            throw new C1903c0(e10.getMessage()).m11511k(t11);
        } catch (RuntimeException e11) {
            if (e11.getCause() instanceof C1903c0) {
                throw ((C1903c0) e11.getCause());
            }
            throw e11;
        }
    }

    /* renamed from: J */
    public static <T extends AbstractC1968z<T, ?>> T m12383J(T t10, byte[] bArr, int i10, int i11, C1944q c1944q) throws C1903c0 {
        T t11 = (T) t10.m12395s(f.NEW_MUTABLE_INSTANCE);
        try {
            InterfaceC1919h1 interfaceC1919h1M11520e = C1907d1.m11516a().m11520e(t11);
            interfaceC1919h1M11520e.mo11670d(t11, bArr, i10, i10 + i11, new C1908e.b(c1944q));
            interfaceC1919h1M11520e.mo11668b(t11);
            if (t11.memoizedHashCode == 0) {
                return t11;
            }
            throw new RuntimeException();
        } catch (IOException e10) {
            if (e10.getCause() instanceof C1903c0) {
                throw ((C1903c0) e10.getCause());
            }
            throw new C1903c0(e10.getMessage()).m11511k(t11);
        } catch (IndexOutOfBoundsException unused) {
            throw C1903c0.m11510l().m11511k(t11);
        }
    }

    /* renamed from: K */
    public static <T extends AbstractC1968z<?, ?>> void m12384K(Class<T> cls, T t10) {
        defaultInstanceMap.put(cls, t10);
    }

    /* renamed from: q */
    public static <T extends AbstractC1968z<T, ?>> T m12385q(T t10) throws C1903c0 {
        if (t10 == null || t10.mo12209m()) {
            return t10;
        }
        throw t10.m11461n().m12057b().m11511k(t10);
    }

    /* renamed from: v */
    public static <E> C1900b0.i<E> m12386v() {
        return C1910e1.m11565c();
    }

    /* renamed from: w */
    public static <T extends AbstractC1968z<?, ?>> T m12387w(Class<T> cls) throws ClassNotFoundException {
        AbstractC1968z<?, ?> abstractC1968z = defaultInstanceMap.get(cls);
        if (abstractC1968z == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                abstractC1968z = defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e10) {
                throw new IllegalStateException("Class initialization cannot fail.", e10);
            }
        }
        if (abstractC1968z == null) {
            abstractC1968z = (T) ((AbstractC1968z) C1952s1.m12169i(cls)).mo12208c();
            if (abstractC1968z == null) {
                throw new IllegalStateException();
            }
            defaultInstanceMap.put(cls, abstractC1968z);
        }
        return (T) abstractC1968z;
    }

    /* renamed from: y */
    public static Object m12388y(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e10) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e10);
        } catch (InvocationTargetException e11) {
            Throwable cause = e11.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    /* renamed from: z */
    public static final <T extends AbstractC1968z<T, ?>> boolean m12389z(T t10, boolean z10) {
        byte bByteValue = ((Byte) t10.m12395s(f.GET_MEMOIZED_IS_INITIALIZED)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zMo11669c = C1907d1.m11516a().m11520e(t10).mo11669c(t10);
        if (z10) {
            t10.m12396t(f.SET_MEMOIZED_IS_INITIALIZED, zMo11669c ? t10 : null);
        }
        return zMo11669c;
    }

    /* renamed from: A */
    public void m12390A() {
        C1907d1.m11516a().m11520e(this).mo11668b(this);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1951s0
    /* renamed from: C */
    public final BuilderType mo12141k() {
        return (BuilderType) m12395s(f.NEW_BUILDER);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1951s0
    /* renamed from: L */
    public final BuilderType mo12138d() {
        BuilderType buildertype = (BuilderType) m12395s(f.NEW_BUILDER);
        buildertype.m12406v(this);
        return buildertype;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1896a
    /* renamed from: a */
    public int mo11456a() {
        return this.memoizedSerializedSize;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (mo12208c().getClass().isInstance(obj)) {
            return C1907d1.m11516a().m11520e(this).mo11673g(this, (AbstractC1968z) obj);
        }
        return false;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1951s0
    /* renamed from: f */
    public void mo12139f(AbstractC1929l abstractC1929l) throws IOException {
        C1907d1.m11516a().m11520e(this).mo11671e(this, C1932m.m11978P(abstractC1929l));
    }

    public int hashCode() {
        int i10 = this.memoizedHashCode;
        if (i10 != 0) {
            return i10;
        }
        int iMo11676j = C1907d1.m11516a().m11520e(this).mo11676j(this);
        this.memoizedHashCode = iMo11676j;
        return iMo11676j;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1951s0
    /* renamed from: i */
    public int mo12140i() {
        if (this.memoizedSerializedSize == -1) {
            this.memoizedSerializedSize = C1907d1.m11516a().m11520e(this).mo11674h(this);
        }
        return this.memoizedSerializedSize;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1951s0
    /* renamed from: l */
    public final InterfaceC1898a1<MessageType> mo12142l() {
        return (InterfaceC1898a1) m12395s(f.GET_PARSER);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1954t0
    /* renamed from: m */
    public final boolean mo12209m() {
        return m12389z(this, true);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1896a
    /* renamed from: o */
    public void mo11462o(int i10) {
        this.memoizedSerializedSize = i10;
    }

    /* renamed from: p */
    public Object m12393p() throws Exception {
        return m12395s(f.BUILD_MESSAGE_INFO);
    }

    /* renamed from: r */
    public final <MessageType extends AbstractC1968z<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> BuilderType m12394r() {
        return (BuilderType) m12395s(f.NEW_BUILDER);
    }

    /* renamed from: s */
    public Object m12395s(f fVar) {
        return mo12397u(fVar, null, null);
    }

    /* renamed from: t */
    public Object m12396t(f fVar, Object obj) {
        return mo12397u(fVar, obj, null);
    }

    public String toString() {
        return C1957u0.m12256e(this, super.toString());
    }

    /* renamed from: u */
    public abstract Object mo12397u(f fVar, Object obj, Object obj2);

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1954t0
    /* renamed from: x */
    public final MessageType mo12208c() {
        return (MessageType) m12395s(f.GET_DEFAULT_INSTANCE);
    }
}
