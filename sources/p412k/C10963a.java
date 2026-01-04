package p412k;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

/* renamed from: k.a */
/* loaded from: classes.dex */
public class C10963a implements InterfaceC10965c {
    @Override // p412k.InterfaceC10965c
    /* renamed from: a */
    public void mo66171a(InterfaceC10964b interfaceC10964b) {
        mo66179i(interfaceC10964b, mo66178h(interfaceC10964b));
    }

    @Override // p412k.InterfaceC10965c
    /* renamed from: b */
    public void mo66172b(InterfaceC10964b interfaceC10964b, Context context, ColorStateList colorStateList, float f10, float f11, float f12) {
        interfaceC10964b.mo3215b(new C10966d(colorStateList, f10));
        View viewMo3219f = interfaceC10964b.mo3219f();
        viewMo3219f.setClipToOutline(true);
        viewMo3219f.setElevation(f11);
        mo66179i(interfaceC10964b, f12);
    }

    @Override // p412k.InterfaceC10965c
    /* renamed from: c */
    public void mo66173c(InterfaceC10964b interfaceC10964b, float f10) {
        interfaceC10964b.mo3219f().setElevation(f10);
    }

    @Override // p412k.InterfaceC10965c
    /* renamed from: d */
    public float mo66174d(InterfaceC10964b interfaceC10964b) {
        return interfaceC10964b.mo3219f().getElevation();
    }

    @Override // p412k.InterfaceC10965c
    /* renamed from: e */
    public void mo66175e(InterfaceC10964b interfaceC10964b) {
        mo66179i(interfaceC10964b, mo66178h(interfaceC10964b));
    }

    @Override // p412k.InterfaceC10965c
    /* renamed from: f */
    public float mo66176f(InterfaceC10964b interfaceC10964b) {
        return m66186p(interfaceC10964b).m66190d();
    }

    @Override // p412k.InterfaceC10965c
    /* renamed from: g */
    public void mo66177g(InterfaceC10964b interfaceC10964b, ColorStateList colorStateList) {
        m66186p(interfaceC10964b).m66192f(colorStateList);
    }

    @Override // p412k.InterfaceC10965c
    /* renamed from: h */
    public float mo66178h(InterfaceC10964b interfaceC10964b) {
        return m66186p(interfaceC10964b).m66189c();
    }

    @Override // p412k.InterfaceC10965c
    /* renamed from: i */
    public void mo66179i(InterfaceC10964b interfaceC10964b, float f10) {
        m66186p(interfaceC10964b).m66193g(f10, interfaceC10964b.mo3217d(), interfaceC10964b.mo3216c());
        mo66180j(interfaceC10964b);
    }

    @Override // p412k.InterfaceC10965c
    /* renamed from: j */
    public void mo66180j(InterfaceC10964b interfaceC10964b) {
        if (!interfaceC10964b.mo3217d()) {
            interfaceC10964b.mo3214a(0, 0, 0, 0);
            return;
        }
        float fMo66178h = mo66178h(interfaceC10964b);
        float fMo66176f = mo66176f(interfaceC10964b);
        int iCeil = (int) Math.ceil(C10967e.m66196a(fMo66178h, fMo66176f, interfaceC10964b.mo3216c()));
        int iCeil2 = (int) Math.ceil(C10967e.m66197b(fMo66178h, fMo66176f, interfaceC10964b.mo3216c()));
        interfaceC10964b.mo3214a(iCeil, iCeil2, iCeil, iCeil2);
    }

    @Override // p412k.InterfaceC10965c
    /* renamed from: k */
    public void mo66181k(InterfaceC10964b interfaceC10964b, float f10) {
        m66186p(interfaceC10964b).m66194h(f10);
    }

    @Override // p412k.InterfaceC10965c
    /* renamed from: l */
    public ColorStateList mo66182l(InterfaceC10964b interfaceC10964b) {
        return m66186p(interfaceC10964b).m66188b();
    }

    @Override // p412k.InterfaceC10965c
    /* renamed from: m */
    public void mo66183m() {
    }

    @Override // p412k.InterfaceC10965c
    /* renamed from: n */
    public float mo66184n(InterfaceC10964b interfaceC10964b) {
        return mo66176f(interfaceC10964b) * 2.0f;
    }

    @Override // p412k.InterfaceC10965c
    /* renamed from: o */
    public float mo66185o(InterfaceC10964b interfaceC10964b) {
        return mo66176f(interfaceC10964b) * 2.0f;
    }

    /* renamed from: p */
    public final C10966d m66186p(InterfaceC10964b interfaceC10964b) {
        return (C10966d) interfaceC10964b.mo3218e();
    }
}
