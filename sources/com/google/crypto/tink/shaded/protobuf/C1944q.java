package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.AbstractC1968z;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.crypto.tink.shaded.protobuf.q */
/* loaded from: classes.dex */
public class C1944q {

    /* renamed from: b */
    public static boolean f9242b = true;

    /* renamed from: c */
    public static volatile C1944q f9243c;

    /* renamed from: d */
    public static final C1944q f9244d = new C1944q(true);

    /* renamed from: a */
    public final Map<a, AbstractC1968z.e<?, ?>> f9245a;

    /* renamed from: com.google.crypto.tink.shaded.protobuf.q$a */
    public static final class a {

        /* renamed from: a */
        public final Object f9246a;

        /* renamed from: b */
        public final int f9247b;

        public a(Object obj, int i10) {
            this.f9246a = obj;
            this.f9247b = i10;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f9246a == aVar.f9246a && this.f9247b == aVar.f9247b;
        }

        public int hashCode() {
            return (System.identityHashCode(this.f9246a) * 65535) + this.f9247b;
        }
    }

    public C1944q() {
        this.f9245a = new HashMap();
    }

    /* renamed from: b */
    public static C1944q m12103b() {
        C1944q c1944qM12080a = f9243c;
        if (c1944qM12080a == null) {
            synchronized (C1944q.class) {
                try {
                    c1944qM12080a = f9243c;
                    if (c1944qM12080a == null) {
                        c1944qM12080a = f9242b ? C1941p.m12080a() : f9244d;
                        f9243c = c1944qM12080a;
                    }
                } finally {
                }
            }
        }
        return c1944qM12080a;
    }

    /* renamed from: a */
    public <ContainingType extends InterfaceC1951s0> AbstractC1968z.e<ContainingType, ?> m12104a(ContainingType containingtype, int i10) {
        return (AbstractC1968z.e) this.f9245a.get(new a(containingtype, i10));
    }

    public C1944q(boolean z10) {
        this.f9245a = Collections.emptyMap();
    }
}
