package p015ak;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import p851zp.InterfaceC14356c;
import p851zp.InterfaceC14358e;

/* renamed from: ak.l */
/* loaded from: classes6.dex */
public class C0225l {
    /* renamed from: a */
    public static <T> void m1577a(InterfaceC14356c<T> interfaceC14356c, Consumer<Exception> consumer) {
        try {
            interfaceC14356c.execute();
        } catch (Exception e10) {
            consumer.accept(e10);
        }
    }

    /* renamed from: b */
    public static <T> void m1578b(InterfaceC14356c<T> interfaceC14356c, Consumer<Exception> consumer, InterfaceC14358e interfaceC14358e) {
        try {
            try {
                interfaceC14356c.execute();
            } catch (Exception e10) {
                consumer.accept(e10);
            }
        } finally {
            interfaceC14358e.execute();
        }
    }

    /* renamed from: c */
    public static <T, U> List<U> m1579c(List<T> list, Function<T, U> function) {
        return m1580d(list, function, true);
    }

    /* renamed from: d */
    public static <T, U> List<U> m1580d(List<T> list, Function<T, U> function, boolean z10) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            U uApply = function.apply(it.next());
            if (uApply != null || !z10) {
                arrayList.add(uApply);
            }
        }
        return arrayList;
    }
}
