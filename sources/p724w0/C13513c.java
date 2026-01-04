package p724w0;

import android.os.Bundle;
import androidx.lifecycle.AbstractC0791h;
import androidx.savedstate.Recreator;
import com.huawei.android.hicloud.drive.cloudphoto.model.Role;
import p692uw.C13264g;
import p692uw.C13267j;

/* renamed from: w0.c */
/* loaded from: classes.dex */
public final class C13513c {

    /* renamed from: d */
    public static final a f60791d = new a(null);

    /* renamed from: a */
    public final InterfaceC13514d f60792a;

    /* renamed from: b */
    public final C13512b f60793b;

    /* renamed from: c */
    public boolean f60794c;

    /* renamed from: w0.c$a */
    public static final class a {
        public /* synthetic */ a(C13264g c13264g) {
            this();
        }

        /* renamed from: a */
        public final C13513c m81274a(InterfaceC13514d interfaceC13514d) {
            C13267j.m79677e(interfaceC13514d, Role.OWNER);
            return new C13513c(interfaceC13514d, null);
        }

        public a() {
        }
    }

    public /* synthetic */ C13513c(InterfaceC13514d interfaceC13514d, C13264g c13264g) {
        this(interfaceC13514d);
    }

    /* renamed from: a */
    public static final C13513c m81269a(InterfaceC13514d interfaceC13514d) {
        return f60791d.m81274a(interfaceC13514d);
    }

    /* renamed from: b */
    public final C13512b m81270b() {
        return this.f60793b;
    }

    /* renamed from: c */
    public final void m81271c() {
        AbstractC0791h abstractC0791hMo1915g = this.f60792a.mo1915g();
        C13267j.m79676d(abstractC0791hMo1915g, "owner.lifecycle");
        if (abstractC0791hMo1915g.mo4949b() != AbstractC0791h.c.INITIALIZED) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage".toString());
        }
        abstractC0791hMo1915g.mo4948a(new Recreator(this.f60792a));
        this.f60793b.m81264e(abstractC0791hMo1915g);
        this.f60794c = true;
    }

    /* renamed from: d */
    public final void m81272d(Bundle bundle) {
        if (!this.f60794c) {
            m81271c();
        }
        AbstractC0791h abstractC0791hMo1915g = this.f60792a.mo1915g();
        C13267j.m79676d(abstractC0791hMo1915g, "owner.lifecycle");
        if (!abstractC0791hMo1915g.mo4949b().m4954b(AbstractC0791h.c.STARTED)) {
            this.f60793b.m81265f(bundle);
            return;
        }
        throw new IllegalStateException(("performRestore cannot be called when owner is " + abstractC0791hMo1915g.mo4949b()).toString());
    }

    /* renamed from: e */
    public final void m81273e(Bundle bundle) {
        C13267j.m79677e(bundle, "outBundle");
        this.f60793b.m81266g(bundle);
    }

    public C13513c(InterfaceC13514d interfaceC13514d) {
        this.f60792a = interfaceC13514d;
        this.f60793b = new C13512b();
    }
}
