package p405jt;

import android.util.Log;

/* renamed from: jt.i */
/* loaded from: classes2.dex */
public final class C10923i extends AbstractC10918d {
    /* renamed from: c */
    public static InterfaceC10925k m66023c() {
        return new C10923i();
    }

    @Override // p405jt.InterfaceC10925k
    /* renamed from: a */
    public InterfaceC10925k mo66001a(String str, String str2) {
        InterfaceC10925k interfaceC10925k = this.f51802a;
        if (interfaceC10925k != null) {
            interfaceC10925k.mo66001a(str, str2);
        }
        return this;
    }

    /* renamed from: d */
    public final void m66024d(String str, int i10, String str2) {
        if (str == null) {
            return;
        }
        if (i10 == 3) {
            Log.d(str2, str);
            return;
        }
        if (i10 == 5) {
            Log.w(str2, str);
        } else if (i10 != 6) {
            Log.i(str2, str);
        } else {
            Log.e(str2, str);
        }
    }

    @Override // p405jt.InterfaceC10925k
    /* renamed from: a */
    public void mo66002a(C10927m c10927m, int i10, String str) {
        if (c10927m == null) {
            return;
        }
        m66024d(c10927m.m66027a(), i10, str);
        InterfaceC10925k interfaceC10925k = this.f51802a;
        if (interfaceC10925k != null) {
            interfaceC10925k.mo66002a(c10927m, i10, str);
        }
    }
}
