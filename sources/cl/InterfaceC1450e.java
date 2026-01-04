package cl;

import java.util.function.Predicate;
import java.util.stream.Stream;
import nu.C11754g;

/* renamed from: cl.e */
/* loaded from: classes6.dex */
public interface InterfaceC1450e extends Comparable<InterfaceC1450e> {
    static Stream<InterfaceC1450e> get() {
        return C11754g.m70076k(InterfaceC1450e.class).filter(new Predicate() { // from class: cl.d
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((InterfaceC1450e) obj).isValid();
            }
        }).sorted();
    }

    void finalize();

    @Override // java.lang.Comparable
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    default int compareTo(InterfaceC1450e interfaceC1450e) {
        return identity().compareTo(interfaceC1450e.identity());
    }

    EnumC1448c identity();

    default boolean isValid() {
        return true;
    }
}
