package com.huawei.updatesdk.p191b.p199f;

import com.huawei.updatesdk.p177a.p178a.p180c.p181a.p182a.C8777a;
import com.huawei.updatesdk.p177a.p186b.p188b.C8795b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.huawei.updatesdk.b.f.c */
/* loaded from: classes9.dex */
public final class C8829c {

    /* renamed from: a */
    private static C8829c f45167a = new C8829c();

    /* renamed from: b */
    private static InterfaceC8827a f45168b = new a();

    /* renamed from: com.huawei.updatesdk.b.f.c$a */
    public static class a implements InterfaceC8827a {

        /* renamed from: a */
        private final List<InterfaceC8828b> f45169a = new ArrayList();

        @Override // com.huawei.updatesdk.p191b.p199f.InterfaceC8827a
        /* renamed from: a */
        public void mo56287a(int i10, C8795b c8795b) {
            synchronized (this.f45169a) {
                try {
                    Iterator<InterfaceC8828b> it = this.f45169a.iterator();
                    while (it.hasNext()) {
                        it.next().mo56290a(i10, c8795b);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // com.huawei.updatesdk.p191b.p199f.InterfaceC8827a
        /* renamed from: b */
        public void mo56289b(InterfaceC8828b interfaceC8828b) {
            synchronized (this.f45169a) {
                try {
                    this.f45169a.remove(interfaceC8828b);
                } catch (UnsupportedOperationException unused) {
                    C8777a.m56028b("InstallObserverManager", "unRegisterObserver UnsupportedOperationException");
                }
            }
        }

        @Override // com.huawei.updatesdk.p191b.p199f.InterfaceC8827a
        /* renamed from: a */
        public void mo56288a(InterfaceC8828b interfaceC8828b) {
            String str;
            String str2;
            synchronized (this.f45169a) {
                try {
                    if (interfaceC8828b == null) {
                        return;
                    }
                    if (!this.f45169a.contains(interfaceC8828b)) {
                        try {
                            this.f45169a.add(interfaceC8828b);
                        } catch (ClassCastException unused) {
                            str = "InstallObserverManager";
                            str2 = "registerObserver ClassCastException";
                            C8777a.m56028b(str, str2);
                        } catch (IllegalArgumentException unused2) {
                            str = "InstallObserverManager";
                            str2 = "registerObserver IllegalArgumentException";
                            C8777a.m56028b(str, str2);
                        } catch (UnsupportedOperationException unused3) {
                            str = "InstallObserverManager";
                            str2 = "registerObserver UnsupportedOperationException";
                            C8777a.m56028b(str, str2);
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    private C8829c() {
    }

    /* renamed from: a */
    public static InterfaceC8827a m56291a() {
        return f45168b;
    }

    /* renamed from: b */
    public static C8829c m56292b() {
        return f45167a;
    }

    /* renamed from: c */
    public void m56295c(C8795b c8795b) {
        f45168b.mo56287a(2, c8795b);
    }

    /* renamed from: a */
    public void m56293a(C8795b c8795b) {
        f45168b.mo56287a(1, c8795b);
    }

    /* renamed from: b */
    public void m56294b(C8795b c8795b) {
        f45168b.mo56287a(0, c8795b);
    }
}
