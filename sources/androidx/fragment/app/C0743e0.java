package androidx.fragment.app;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import androidx.lifecycle.AbstractC0791h;
import androidx.lifecycle.C0782c0;
import androidx.lifecycle.C0786e0;
import androidx.lifecycle.C0797m;
import androidx.lifecycle.C0807w;
import androidx.lifecycle.C0810z;
import androidx.lifecycle.InterfaceC0788f0;
import androidx.lifecycle.InterfaceC0789g;
import p597r0.AbstractC12450a;
import p597r0.C12453d;
import p724w0.C13512b;
import p724w0.C13513c;
import p724w0.InterfaceC13514d;

/* renamed from: androidx.fragment.app.e0 */
/* loaded from: classes.dex */
public class C0743e0 implements InterfaceC0789g, InterfaceC13514d, InterfaceC0788f0 {

    /* renamed from: a */
    public final Fragment f4012a;

    /* renamed from: b */
    public final C0786e0 f4013b;

    /* renamed from: c */
    public C0782c0.b f4014c;

    /* renamed from: d */
    public C0797m f4015d = null;

    /* renamed from: e */
    public C13513c f4016e = null;

    public C0743e0(Fragment fragment, C0786e0 c0786e0) {
        this.f4012a = fragment;
        this.f4013b = c0786e0;
    }

    @Override // p724w0.InterfaceC13514d
    /* renamed from: J */
    public C13512b mo1909J() {
        m4737b();
        return this.f4016e.m81270b();
    }

    /* renamed from: a */
    public void m4736a(AbstractC0791h.b bVar) {
        this.f4015d.m4962h(bVar);
    }

    /* renamed from: b */
    public void m4737b() {
        if (this.f4015d == null) {
            this.f4015d = new C0797m(this);
            C13513c c13513cM81269a = C13513c.m81269a(this);
            this.f4016e = c13513cM81269a;
            c13513cM81269a.m81271c();
        }
    }

    /* renamed from: c */
    public boolean m4738c() {
        return this.f4015d != null;
    }

    /* renamed from: d */
    public void m4739d(Bundle bundle) {
        this.f4016e.m81272d(bundle);
    }

    /* renamed from: e */
    public void m4740e(Bundle bundle) {
        this.f4016e.m81273e(bundle);
    }

    /* renamed from: f */
    public void m4741f(AbstractC0791h.c cVar) {
        this.f4015d.m4968o(cVar);
    }

    @Override // androidx.lifecycle.InterfaceC0796l
    /* renamed from: g */
    public AbstractC0791h mo1915g() {
        m4737b();
        return this.f4015d;
    }

    @Override // androidx.lifecycle.InterfaceC0788f0
    public C0786e0 getViewModelStore() {
        m4737b();
        return this.f4013b;
    }

    @Override // androidx.lifecycle.InterfaceC0789g
    /* renamed from: i */
    public C0782c0.b mo1917i() {
        Application application;
        C0782c0.b bVarMo1917i = this.f4012a.mo1917i();
        if (!bVarMo1917i.equals(this.f4012a.f3717V)) {
            this.f4014c = bVarMo1917i;
            return bVarMo1917i;
        }
        if (this.f4014c == null) {
            Context applicationContext = this.f4012a.m4419m1().getApplicationContext();
            while (true) {
                if (!(applicationContext instanceof ContextWrapper)) {
                    application = null;
                    break;
                }
                if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                }
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            }
            Fragment fragment = this.f4012a;
            this.f4014c = new C0810z(application, fragment, fragment.m4420n());
        }
        return this.f4014c;
    }

    @Override // androidx.lifecycle.InterfaceC0789g
    /* renamed from: j */
    public AbstractC12450a mo1918j() {
        Application application;
        Context applicationContext = this.f4012a.m4419m1().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                application = null;
                break;
            }
            if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            }
            applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
        }
        C12453d c12453d = new C12453d();
        if (application != null) {
            c12453d.m74708c(C0782c0.a.f4155h, application);
        }
        c12453d.m74708c(C0807w.f4207a, this.f4012a);
        c12453d.m74708c(C0807w.f4208b, this);
        if (this.f4012a.m4420n() != null) {
            c12453d.m74708c(C0807w.f4209c, this.f4012a.m4420n());
        }
        return c12453d;
    }
}
