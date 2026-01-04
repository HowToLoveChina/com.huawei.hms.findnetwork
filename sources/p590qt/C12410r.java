package p590qt;

import lt.InterfaceC11341a;

/* renamed from: qt.r */
/* loaded from: classes5.dex */
public class C12410r implements InterfaceC11341a.a {

    /* renamed from: b */
    public static volatile C12410r f57233b;

    /* renamed from: a */
    public volatile InterfaceC11341a.a f57234a = null;

    /* renamed from: d */
    public static C12410r m74523d() {
        if (f57233b != null) {
            return f57233b;
        }
        synchronized (C12410r.class) {
            try {
                if (f57233b != null) {
                    return f57233b;
                }
                f57233b = new C12410r();
                return f57233b;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // lt.InterfaceC11341a.a
    /* renamed from: a */
    public void mo57439a(String str, String str2) {
        if (this.f57234a == null) {
            return;
        }
        this.f57234a.mo57439a(str, str2);
    }

    @Override // lt.InterfaceC11341a.a
    /* renamed from: b */
    public void mo57440b(String str, String str2) {
        if (this.f57234a == null) {
            return;
        }
        this.f57234a.mo57440b(str, str2);
    }

    @Override // lt.InterfaceC11341a.a
    /* renamed from: c */
    public void mo57441c(String str, String str2) {
        if (this.f57234a == null) {
            return;
        }
        this.f57234a.mo57441c(str, str2);
    }

    /* renamed from: e */
    public void m74524e(InterfaceC11341a.a aVar) {
        this.f57234a = aVar;
    }
}
