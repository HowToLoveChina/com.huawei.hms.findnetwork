package p040bx;

import com.huawei.hms.network.embedded.C5929g4;
import p408jw.C10951q;
import p692uw.C13264g;
import p692uw.C13267j;
import tw.InterfaceC13086l;

/* renamed from: bx.m */
/* loaded from: classes9.dex */
public final class C1329m {

    /* renamed from: a */
    public final Object f5822a;

    /* renamed from: b */
    public final AbstractC1305e f5823b;

    /* renamed from: c */
    public final InterfaceC13086l<Throwable, C10951q> f5824c;

    /* renamed from: d */
    public final Object f5825d;

    /* renamed from: e */
    public final Throwable f5826e;

    public /* synthetic */ C1329m(Object obj, AbstractC1305e abstractC1305e, InterfaceC13086l interfaceC13086l, Object obj2, Throwable th2, int i10, C13264g c13264g) {
        this(obj, (i10 & 2) != 0 ? null : abstractC1305e, (i10 & 4) != 0 ? null : interfaceC13086l, (i10 & 8) != 0 ? null : obj2, (i10 & 16) != 0 ? null : th2);
    }

    /* renamed from: b */
    public static /* synthetic */ C1329m m7814b(C1329m c1329m, Object obj, AbstractC1305e abstractC1305e, InterfaceC13086l interfaceC13086l, Object obj2, Throwable th2, int i10, Object obj3) {
        if ((i10 & 1) != 0) {
            obj = c1329m.f5822a;
        }
        if ((i10 & 2) != 0) {
            abstractC1305e = c1329m.f5823b;
        }
        AbstractC1305e abstractC1305e2 = abstractC1305e;
        if ((i10 & 4) != 0) {
            interfaceC13086l = c1329m.f5824c;
        }
        InterfaceC13086l interfaceC13086l2 = interfaceC13086l;
        if ((i10 & 8) != 0) {
            obj2 = c1329m.f5825d;
        }
        Object obj4 = obj2;
        if ((i10 & 16) != 0) {
            th2 = c1329m.f5826e;
        }
        return c1329m.m7815a(obj, abstractC1305e2, interfaceC13086l2, obj4, th2);
    }

    /* renamed from: a */
    public final C1329m m7815a(Object obj, AbstractC1305e abstractC1305e, InterfaceC13086l<? super Throwable, C10951q> interfaceC13086l, Object obj2, Throwable th2) {
        return new C1329m(obj, abstractC1305e, interfaceC13086l, obj2, th2);
    }

    /* renamed from: c */
    public final boolean m7816c() {
        return this.f5826e != null;
    }

    /* renamed from: d */
    public final void m7817d(C1314h<?> c1314h, Throwable th2) {
        AbstractC1305e abstractC1305e = this.f5823b;
        if (abstractC1305e != null) {
            c1314h.m7761k(abstractC1305e, th2);
        }
        InterfaceC13086l<Throwable, C10951q> interfaceC13086l = this.f5824c;
        if (interfaceC13086l == null) {
            return;
        }
        c1314h.m7762l(interfaceC13086l, th2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1329m)) {
            return false;
        }
        C1329m c1329m = (C1329m) obj;
        return C13267j.m79673a(this.f5822a, c1329m.f5822a) && C13267j.m79673a(this.f5823b, c1329m.f5823b) && C13267j.m79673a(this.f5824c, c1329m.f5824c) && C13267j.m79673a(this.f5825d, c1329m.f5825d) && C13267j.m79673a(this.f5826e, c1329m.f5826e);
    }

    public int hashCode() {
        Object obj = this.f5822a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        AbstractC1305e abstractC1305e = this.f5823b;
        int iHashCode2 = (iHashCode + (abstractC1305e == null ? 0 : abstractC1305e.hashCode())) * 31;
        InterfaceC13086l<Throwable, C10951q> interfaceC13086l = this.f5824c;
        int iHashCode3 = (iHashCode2 + (interfaceC13086l == null ? 0 : interfaceC13086l.hashCode())) * 31;
        Object obj2 = this.f5825d;
        int iHashCode4 = (iHashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th2 = this.f5826e;
        return iHashCode4 + (th2 != null ? th2.hashCode() : 0);
    }

    public String toString() {
        return "CompletedContinuation(result=" + this.f5822a + ", cancelHandler=" + this.f5823b + ", onCancellation=" + this.f5824c + ", idempotentResume=" + this.f5825d + ", cancelCause=" + this.f5826e + C5929g4.f26850l;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C1329m(Object obj, AbstractC1305e abstractC1305e, InterfaceC13086l<? super Throwable, C10951q> interfaceC13086l, Object obj2, Throwable th2) {
        this.f5822a = obj;
        this.f5823b = abstractC1305e;
        this.f5824c = interfaceC13086l;
        this.f5825d = obj2;
        this.f5826e = th2;
    }
}
