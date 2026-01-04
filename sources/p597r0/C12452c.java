package p597r0;

import androidx.lifecycle.AbstractC0780b0;
import androidx.lifecycle.C0782c0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import p641sw.C12870a;
import p692uw.C13267j;
import p824yw.InterfaceC14050b;
import tw.InterfaceC13086l;

/* renamed from: r0.c */
/* loaded from: classes.dex */
public final class C12452c {

    /* renamed from: a */
    public final List<C12454e<?>> f57376a = new ArrayList();

    /* renamed from: a */
    public final <T extends AbstractC0780b0> void m74706a(InterfaceC14050b<T> interfaceC14050b, InterfaceC13086l<? super AbstractC12450a, ? extends T> interfaceC13086l) {
        C13267j.m79677e(interfaceC14050b, "clazz");
        C13267j.m79677e(interfaceC13086l, "initializer");
        this.f57376a.add(new C12454e<>(C12870a.m77224a(interfaceC14050b), interfaceC13086l));
    }

    /* renamed from: b */
    public final C0782c0.b m74707b() {
        Object[] array = this.f57376a.toArray(new C12454e[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        C12454e[] c12454eArr = (C12454e[]) array;
        return new C12451b((C12454e[]) Arrays.copyOf(c12454eArr, c12454eArr.length));
    }
}
