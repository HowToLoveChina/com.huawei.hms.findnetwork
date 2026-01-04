package p209cs;

import java.util.Iterator;
import java.util.List;

/* renamed from: cs.c */
/* loaded from: classes8.dex */
public class C8947c {

    /* renamed from: a */
    public C8949e<InterfaceC8945a> f45446a;

    /* renamed from: cs.c$b */
    public static final class b {

        /* renamed from: a */
        public static final C8947c f45447a = new C8947c();
    }

    public C8947c() {
        this.f45446a = C8949e.m56673a(InterfaceC8945a.class);
    }

    /* renamed from: a */
    public static C8947c m56668a() {
        return b.f45447a;
    }

    /* renamed from: b */
    public <T> void m56669b(int i10, String str, C8948d c8948d, InterfaceC8946b<T> interfaceC8946b) {
        List<InterfaceC8945a> listM56674b = this.f45446a.m56674b(i10);
        if (listM56674b.isEmpty()) {
            return;
        }
        Iterator<InterfaceC8945a> it = listM56674b.iterator();
        while (it.hasNext()) {
            it.next().m56667a(str, c8948d, interfaceC8946b);
        }
    }
}
