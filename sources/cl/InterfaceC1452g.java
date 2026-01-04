package cl;

import java.util.function.Predicate;
import java.util.stream.Stream;
import nu.C11754g;

/* renamed from: cl.g */
/* loaded from: classes6.dex */
public interface InterfaceC1452g extends Comparable<InterfaceC1452g> {
    static Stream<InterfaceC1452g> get() {
        return C11754g.m70076k(InterfaceC1452g.class).filter(new Predicate() { // from class: cl.f
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((InterfaceC1452g) obj).isValid();
            }
        }).sorted();
    }

    EnumC1453h identity();

    default boolean isValid() {
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    default int compareTo(InterfaceC1452g interfaceC1452g) {
        return identity().compareTo(interfaceC1452g.identity());
    }

    /* renamed from: l */
    void mo7504l(String str, boolean z10, boolean z11, int i10);
}
