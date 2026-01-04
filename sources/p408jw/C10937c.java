package p408jw;

import java.io.Serializable;

/* renamed from: jw.c */
/* loaded from: classes9.dex */
public final class C10937c<T> implements InterfaceC10939e<T>, Serializable {

    /* renamed from: a */
    public final T f51852a;

    public C10937c(T t10) {
        this.f51852a = t10;
    }

    @Override // p408jw.InterfaceC10939e
    public T getValue() {
        return this.f51852a;
    }

    public String toString() {
        return String.valueOf(getValue());
    }
}
