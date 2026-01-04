package p631s3;

import com.google.crypto.tink.shaded.protobuf.AbstractC1920i;
import com.google.crypto.tink.shaded.protobuf.C1903c0;
import com.google.crypto.tink.shaded.protobuf.InterfaceC1951s0;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import p831z3.C14125y;

/* renamed from: s3.h */
/* loaded from: classes.dex */
public abstract class AbstractC12685h<KeyProtoT extends InterfaceC1951s0> {

    /* renamed from: a */
    public final Class<KeyProtoT> f58205a;

    /* renamed from: b */
    public final Map<Class<?>, b<?, KeyProtoT>> f58206b;

    /* renamed from: c */
    public final Class<?> f58207c;

    /* renamed from: s3.h$a */
    public static abstract class a<KeyFormatProtoT extends InterfaceC1951s0, KeyT> {

        /* renamed from: a */
        public final Class<KeyFormatProtoT> f58208a;

        public a(Class<KeyFormatProtoT> cls) {
            this.f58208a = cls;
        }

        /* renamed from: a */
        public abstract KeyT mo76324a(KeyFormatProtoT keyformatprotot) throws GeneralSecurityException;

        /* renamed from: b */
        public final Class<KeyFormatProtoT> m76325b() {
            return this.f58208a;
        }

        /* renamed from: c */
        public abstract KeyFormatProtoT mo76326c(AbstractC1920i abstractC1920i) throws C1903c0;

        /* renamed from: d */
        public abstract void mo76327d(KeyFormatProtoT keyformatprotot) throws GeneralSecurityException;
    }

    /* renamed from: s3.h$b */
    public static abstract class b<PrimitiveT, KeyT> {

        /* renamed from: a */
        public final Class<PrimitiveT> f58209a;

        public b(Class<PrimitiveT> cls) {
            this.f58209a = cls;
        }

        /* renamed from: a */
        public abstract PrimitiveT mo76328a(KeyT keyt) throws GeneralSecurityException;

        /* renamed from: b */
        public final Class<PrimitiveT> m76329b() {
            return this.f58209a;
        }
    }

    @SafeVarargs
    public AbstractC12685h(Class<KeyProtoT> cls, b<?, KeyProtoT>... bVarArr) {
        this.f58205a = cls;
        HashMap map = new HashMap();
        for (b<?, KeyProtoT> bVar : bVarArr) {
            if (map.containsKey(bVar.m76329b())) {
                throw new IllegalArgumentException("KeyTypeManager constructed with duplicate factories for primitive " + bVar.m76329b().getCanonicalName());
            }
            map.put(bVar.m76329b(), bVar);
        }
        if (bVarArr.length > 0) {
            this.f58207c = bVarArr[0].m76329b();
        } else {
            this.f58207c = Void.class;
        }
        this.f58206b = Collections.unmodifiableMap(map);
    }

    /* renamed from: a */
    public final Class<?> m76315a() {
        return this.f58207c;
    }

    /* renamed from: b */
    public final Class<KeyProtoT> m76316b() {
        return this.f58205a;
    }

    /* renamed from: c */
    public abstract String mo76317c();

    /* renamed from: d */
    public final <P> P m76318d(KeyProtoT keyprotot, Class<P> cls) throws GeneralSecurityException {
        b<?, KeyProtoT> bVar = this.f58206b.get(cls);
        if (bVar != null) {
            return (P) bVar.mo76328a(keyprotot);
        }
        throw new IllegalArgumentException("Requested primitive class " + cls.getCanonicalName() + " not supported.");
    }

    /* renamed from: e */
    public abstract a<?, KeyProtoT> mo76319e();

    /* renamed from: f */
    public abstract C14125y.c mo76320f();

    /* renamed from: g */
    public abstract KeyProtoT mo76321g(AbstractC1920i abstractC1920i) throws C1903c0;

    /* renamed from: h */
    public final Set<Class<?>> m76322h() {
        return this.f58206b.keySet();
    }

    /* renamed from: i */
    public abstract void mo76323i(KeyProtoT keyprotot) throws GeneralSecurityException;
}
