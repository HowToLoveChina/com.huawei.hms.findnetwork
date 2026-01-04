package androidx.lifecycle;

import android.os.Bundle;
import java.util.Map;
import p408jw.C10941g;
import p408jw.InterfaceC10939e;
import p692uw.AbstractC13268k;
import p692uw.C13267j;
import p724w0.C13512b;
import tw.InterfaceC13075a;

/* renamed from: androidx.lifecycle.x */
/* loaded from: classes.dex */
public final class C0808x implements C13512b.c {

    /* renamed from: a */
    public final C13512b f4211a;

    /* renamed from: b */
    public boolean f4212b;

    /* renamed from: c */
    public Bundle f4213c;

    /* renamed from: d */
    public final InterfaceC10939e f4214d;

    /* renamed from: androidx.lifecycle.x$a */
    public static final class a extends AbstractC13268k implements InterfaceC13075a<C0809y> {

        /* renamed from: b */
        public final /* synthetic */ InterfaceC0788f0 f4215b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(InterfaceC0788f0 interfaceC0788f0) {
            super(0);
            this.f4215b = interfaceC0788f0;
        }

        @Override // tw.InterfaceC13075a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public final C0809y mo5005b() {
            return C0807w.m4999e(this.f4215b);
        }
    }

    public C0808x(C13512b c13512b, InterfaceC0788f0 interfaceC0788f0) {
        C13267j.m79677e(c13512b, "savedStateRegistry");
        C13267j.m79677e(interfaceC0788f0, "viewModelStoreOwner");
        this.f4211a = c13512b;
        this.f4214d = C10941g.m66065a(new a(interfaceC0788f0));
    }

    @Override // p724w0.C13512b.c
    /* renamed from: a */
    public Bundle mo1944a() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f4213c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        for (Map.Entry<String, C0806v> entry : m5003c().m5007f().entrySet()) {
            String key = entry.getKey();
            Bundle bundleMo1944a = entry.getValue().m4991d().mo1944a();
            if (!C13267j.m79673a(bundleMo1944a, Bundle.EMPTY)) {
                bundle.putBundle(key, bundleMo1944a);
            }
        }
        this.f4212b = false;
        return bundle;
    }

    /* renamed from: b */
    public final Bundle m5002b(String str) {
        C13267j.m79677e(str, "key");
        m5004d();
        Bundle bundle = this.f4213c;
        Bundle bundle2 = bundle != null ? bundle.getBundle(str) : null;
        Bundle bundle3 = this.f4213c;
        if (bundle3 != null) {
            bundle3.remove(str);
        }
        Bundle bundle4 = this.f4213c;
        if (bundle4 != null && bundle4.isEmpty()) {
            this.f4213c = null;
        }
        return bundle2;
    }

    /* renamed from: c */
    public final C0809y m5003c() {
        return (C0809y) this.f4214d.getValue();
    }

    /* renamed from: d */
    public final void m5004d() {
        if (this.f4212b) {
            return;
        }
        this.f4213c = this.f4211a.m81262b("androidx.lifecycle.internal.SavedStateHandlesProvider");
        this.f4212b = true;
        m5003c();
    }
}
