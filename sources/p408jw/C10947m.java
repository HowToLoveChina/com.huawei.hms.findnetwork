package p408jw;

import java.io.Serializable;
import p692uw.C13264g;
import p692uw.C13267j;
import tw.InterfaceC13075a;

/* renamed from: jw.m */
/* loaded from: classes9.dex */
public final class C10947m<T> implements InterfaceC10939e<T>, Serializable {

    /* renamed from: a */
    public InterfaceC13075a<? extends T> f51857a;

    /* renamed from: b */
    public volatile Object f51858b;

    /* renamed from: c */
    public final Object f51859c;

    public C10947m(InterfaceC13075a<? extends T> interfaceC13075a, Object obj) {
        C13267j.m79677e(interfaceC13075a, "initializer");
        this.f51857a = interfaceC13075a;
        this.f51858b = C10949o.f51860a;
        this.f51859c = obj == null ? this : obj;
    }

    private final Object writeReplace() {
        return new C10937c(getValue());
    }

    /* renamed from: b */
    public boolean m66074b() {
        return this.f51858b != C10949o.f51860a;
    }

    @Override // p408jw.InterfaceC10939e
    public T getValue() {
        T tMo5005b;
        T t10 = (T) this.f51858b;
        C10949o c10949o = C10949o.f51860a;
        if (t10 != c10949o) {
            return t10;
        }
        synchronized (this.f51859c) {
            tMo5005b = (T) this.f51858b;
            if (tMo5005b == c10949o) {
                InterfaceC13075a<? extends T> interfaceC13075a = this.f51857a;
                C13267j.m79674b(interfaceC13075a);
                tMo5005b = interfaceC13075a.mo5005b();
                this.f51858b = tMo5005b;
                this.f51857a = null;
            }
        }
        return tMo5005b;
    }

    public String toString() {
        return m66074b() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    public /* synthetic */ C10947m(InterfaceC13075a interfaceC13075a, Object obj, int i10, C13264g c13264g) {
        this(interfaceC13075a, (i10 & 2) != 0 ? null : obj);
    }
}
