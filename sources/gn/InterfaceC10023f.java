package gn;

import com.huawei.hicloud.notificationv2.bean.C4972b;
import com.huawei.hicloud.notificationv2.bean.NotificationTask;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;
import nu.C11754g;

/* renamed from: gn.f */
/* loaded from: classes6.dex */
public interface InterfaceC10023f extends Comparable<InterfaceC10023f> {
    static Stream<InterfaceC10023f> get() {
        return C11754g.m70076k(InterfaceC10023f.class).filter(new Predicate() { // from class: gn.e
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((InterfaceC10023f) obj).isValid();
            }
        }).sorted();
    }

    EnumC10018a identity();

    default boolean isValid() {
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: m */
    default int compareTo(InterfaceC10023f interfaceC10023f) {
        return identity().compareTo(interfaceC10023f.identity());
    }

    /* renamed from: o */
    void mo62168o(C4972b c4972b, List<NotificationTask> list);
}
