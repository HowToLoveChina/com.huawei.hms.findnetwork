package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.AbstractC0791h;
import androidx.lifecycle.InterfaceC0794j;
import androidx.lifecycle.InterfaceC0796l;
import com.huawei.android.hicloud.drive.cloudphoto.model.Role;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import p692uw.C13264g;
import p692uw.C13267j;
import p724w0.C13512b;
import p724w0.InterfaceC13514d;

/* loaded from: classes.dex */
public final class Recreator implements InterfaceC0794j {

    /* renamed from: b */
    public static final C0883a f4649b = new C0883a(null);

    /* renamed from: a */
    public final InterfaceC13514d f4650a;

    /* renamed from: androidx.savedstate.Recreator$a */
    public static final class C0883a {
        public /* synthetic */ C0883a(C13264g c13264g) {
            this();
        }

        public C0883a() {
        }
    }

    /* renamed from: androidx.savedstate.Recreator$b */
    public static final class C0884b implements C13512b.c {

        /* renamed from: a */
        public final Set<String> f4651a;

        public C0884b(C13512b c13512b) {
            C13267j.m79677e(c13512b, "registry");
            this.f4651a = new LinkedHashSet();
            c13512b.m81267h("androidx.savedstate.Restarter", this);
        }

        @Override // p724w0.C13512b.c
        /* renamed from: a */
        public Bundle mo1944a() {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("classes_to_restore", new ArrayList<>(this.f4651a));
            return bundle;
        }

        /* renamed from: b */
        public final void m5610b(String str) {
            C13267j.m79677e(str, "className");
            this.f4651a.add(str);
        }
    }

    public Recreator(InterfaceC13514d interfaceC13514d) {
        C13267j.m79677e(interfaceC13514d, Role.OWNER);
        this.f4650a = interfaceC13514d;
    }

    @Override // androidx.lifecycle.InterfaceC0794j
    /* renamed from: d */
    public void mo1925d(InterfaceC0796l interfaceC0796l, AbstractC0791h.b bVar) throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        C13267j.m79677e(interfaceC0796l, "source");
        C13267j.m79677e(bVar, "event");
        if (bVar != AbstractC0791h.b.ON_CREATE) {
            throw new AssertionError("Next event must be ON_CREATE");
        }
        interfaceC0796l.mo1915g().mo4950c(this);
        Bundle bundleM81262b = this.f4650a.mo1909J().m81262b("androidx.savedstate.Restarter");
        if (bundleM81262b == null) {
            return;
        }
        ArrayList<String> stringArrayList = bundleM81262b.getStringArrayList("classes_to_restore");
        if (stringArrayList == null) {
            throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
        }
        Iterator<String> it = stringArrayList.iterator();
        while (it.hasNext()) {
            m5609e(it.next());
        }
    }

    /* renamed from: e */
    public final void m5609e(String str) throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            Class<? extends U> clsAsSubclass = Class.forName(str, false, Recreator.class.getClassLoader()).asSubclass(C13512b.a.class);
            C13267j.m79676d(clsAsSubclass, "{\n                Class.…class.java)\n            }");
            try {
                Constructor declaredConstructor = clsAsSubclass.getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                try {
                    Object objNewInstance = declaredConstructor.newInstance(new Object[0]);
                    C13267j.m79676d(objNewInstance, "{\n                constr…wInstance()\n            }");
                    ((C13512b.a) objNewInstance).mo4883a(this.f4650a);
                } catch (Exception e10) {
                    throw new RuntimeException("Failed to instantiate " + str, e10);
                }
            } catch (NoSuchMethodException e11) {
                throw new IllegalStateException("Class " + clsAsSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e11);
            }
        } catch (ClassNotFoundException e12) {
            throw new RuntimeException("Class " + str + " wasn't found", e12);
        }
    }
}
