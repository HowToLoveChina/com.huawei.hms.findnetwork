package p724w0;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.lifecycle.AbstractC0791h;
import androidx.lifecycle.InterfaceC0794j;
import androidx.lifecycle.InterfaceC0796l;
import androidx.savedstate.Recreator;
import java.util.Iterator;
import java.util.Map;
import p352i.C10381b;
import p692uw.C13264g;
import p692uw.C13267j;

@SuppressLint({"RestrictedApi"})
/* renamed from: w0.b */
/* loaded from: classes.dex */
public final class C13512b {

    /* renamed from: g */
    public static final b f60784g = new b(null);

    /* renamed from: b */
    public boolean f60786b;

    /* renamed from: c */
    public Bundle f60787c;

    /* renamed from: d */
    public boolean f60788d;

    /* renamed from: e */
    public Recreator.C0884b f60789e;

    /* renamed from: a */
    public final C10381b<String, c> f60785a = new C10381b<>();

    /* renamed from: f */
    public boolean f60790f = true;

    /* renamed from: w0.b$a */
    public interface a {
        /* renamed from: a */
        void mo4883a(InterfaceC13514d interfaceC13514d);
    }

    /* renamed from: w0.b$b */
    public static final class b {
        public /* synthetic */ b(C13264g c13264g) {
            this();
        }

        public b() {
        }
    }

    /* renamed from: w0.b$c */
    public interface c {
        /* renamed from: a */
        Bundle mo1944a();
    }

    /* renamed from: d */
    public static final void m81261d(C13512b c13512b, InterfaceC0796l interfaceC0796l, AbstractC0791h.b bVar) {
        C13267j.m79677e(c13512b, "this$0");
        C13267j.m79677e(interfaceC0796l, "<anonymous parameter 0>");
        C13267j.m79677e(bVar, "event");
        if (bVar == AbstractC0791h.b.ON_START) {
            c13512b.f60790f = true;
        } else if (bVar == AbstractC0791h.b.ON_STOP) {
            c13512b.f60790f = false;
        }
    }

    /* renamed from: b */
    public final Bundle m81262b(String str) {
        C13267j.m79677e(str, "key");
        if (!this.f60788d) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component".toString());
        }
        Bundle bundle = this.f60787c;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle != null ? bundle.getBundle(str) : null;
        Bundle bundle3 = this.f60787c;
        if (bundle3 != null) {
            bundle3.remove(str);
        }
        Bundle bundle4 = this.f60787c;
        if (bundle4 == null || bundle4.isEmpty()) {
            this.f60787c = null;
        }
        return bundle2;
    }

    /* renamed from: c */
    public final c m81263c(String str) {
        C13267j.m79677e(str, "key");
        Iterator<Map.Entry<String, c>> it = this.f60785a.iterator();
        while (it.hasNext()) {
            Map.Entry<String, c> next = it.next();
            C13267j.m79676d(next, "components");
            String key = next.getKey();
            c value = next.getValue();
            if (C13267j.m79673a(key, str)) {
                return value;
            }
        }
        return null;
    }

    /* renamed from: e */
    public final void m81264e(AbstractC0791h abstractC0791h) {
        C13267j.m79677e(abstractC0791h, "lifecycle");
        if (!(!this.f60786b)) {
            throw new IllegalStateException("SavedStateRegistry was already attached.".toString());
        }
        abstractC0791h.mo4948a(new InterfaceC0794j() { // from class: w0.a
            @Override // androidx.lifecycle.InterfaceC0794j
            /* renamed from: d */
            public final void mo1925d(InterfaceC0796l interfaceC0796l, AbstractC0791h.b bVar) {
                C13512b.m81261d(this.f60783a, interfaceC0796l, bVar);
            }
        });
        this.f60786b = true;
    }

    /* renamed from: f */
    public final void m81265f(Bundle bundle) {
        if (!this.f60786b) {
            throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).".toString());
        }
        if (!(!this.f60788d)) {
            throw new IllegalStateException("SavedStateRegistry was already restored.".toString());
        }
        this.f60787c = bundle != null ? bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key") : null;
        this.f60788d = true;
    }

    /* renamed from: g */
    public final void m81266g(Bundle bundle) {
        C13267j.m79677e(bundle, "outBundle");
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = this.f60787c;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        C10381b<String, c>.d dVarM63821d = this.f60785a.m63821d();
        C13267j.m79676d(dVarM63821d, "this.components.iteratorWithAdditions()");
        while (dVarM63821d.hasNext()) {
            Map.Entry next = dVarM63821d.next();
            bundle2.putBundle((String) next.getKey(), ((c) next.getValue()).mo1944a());
        }
        if (bundle2.isEmpty()) {
            return;
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }

    /* renamed from: h */
    public final void m81267h(String str, c cVar) {
        C13267j.m79677e(str, "key");
        C13267j.m79677e(cVar, "provider");
        if (this.f60785a.mo63816g(str, cVar) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered".toString());
        }
    }

    /* renamed from: i */
    public final void m81268i(Class<? extends a> cls) throws NoSuchMethodException, SecurityException {
        C13267j.m79677e(cls, "clazz");
        if (!this.f60790f) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState".toString());
        }
        Recreator.C0884b c0884b = this.f60789e;
        if (c0884b == null) {
            c0884b = new Recreator.C0884b(this);
        }
        this.f60789e = c0884b;
        try {
            cls.getDeclaredConstructor(new Class[0]);
            Recreator.C0884b c0884b2 = this.f60789e;
            if (c0884b2 != null) {
                String name = cls.getName();
                C13267j.m79676d(name, "clazz.name");
                c0884b2.m5610b(name);
            }
        } catch (NoSuchMethodException e10) {
            throw new IllegalArgumentException("Class " + cls.getSimpleName() + " must have default constructor in order to be automatically recreated", e10);
        }
    }
}
