package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.AbstractC0780b0;
import androidx.lifecycle.C0782c0;
import androidx.lifecycle.C0786e0;
import com.huawei.hms.network.embedded.C5929g4;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: androidx.fragment.app.u */
/* loaded from: classes.dex */
public final class C0763u extends AbstractC0780b0 {

    /* renamed from: k */
    public static final C0782c0.b f4075k = new a();

    /* renamed from: g */
    public final boolean f4079g;

    /* renamed from: d */
    public final HashMap<String, Fragment> f4076d = new HashMap<>();

    /* renamed from: e */
    public final HashMap<String, C0763u> f4077e = new HashMap<>();

    /* renamed from: f */
    public final HashMap<String, C0786e0> f4078f = new HashMap<>();

    /* renamed from: h */
    public boolean f4080h = false;

    /* renamed from: i */
    public boolean f4081i = false;

    /* renamed from: j */
    public boolean f4082j = false;

    /* renamed from: androidx.fragment.app.u$a */
    public class a implements C0782c0.b {
        @Override // androidx.lifecycle.C0782c0.b
        /* renamed from: a */
        public <T extends AbstractC0780b0> T mo4828a(Class<T> cls) {
            return new C0763u(true);
        }
    }

    public C0763u(boolean z10) {
        this.f4079g = z10;
    }

    /* renamed from: l */
    public static C0763u m4814l(C0786e0 c0786e0) {
        return (C0763u) new C0782c0(c0786e0, f4075k).m4929a(C0763u.class);
    }

    @Override // androidx.lifecycle.AbstractC0780b0
    /* renamed from: d */
    public void mo4815d() {
        if (FragmentManager.m4492I0(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f4080h = true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0763u.class != obj.getClass()) {
            return false;
        }
        C0763u c0763u = (C0763u) obj;
        return this.f4076d.equals(c0763u.f4076d) && this.f4077e.equals(c0763u.f4077e) && this.f4078f.equals(c0763u.f4078f);
    }

    /* renamed from: f */
    public void m4816f(Fragment fragment) {
        if (this.f4082j) {
            if (FragmentManager.m4492I0(2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
            }
        } else {
            if (this.f4076d.containsKey(fragment.f3728f)) {
                return;
            }
            this.f4076d.put(fragment.f3728f, fragment);
            if (FragmentManager.m4492I0(2)) {
                Log.v("FragmentManager", "Updating retained Fragments: Added " + fragment);
            }
        }
    }

    /* renamed from: g */
    public void m4817g(Fragment fragment) {
        if (FragmentManager.m4492I0(3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + fragment);
        }
        m4819i(fragment.f3728f);
    }

    /* renamed from: h */
    public void m4818h(String str) {
        if (FragmentManager.m4492I0(3)) {
            Log.d("FragmentManager", "Clearing non-config state for saved state of Fragment " + str);
        }
        m4819i(str);
    }

    public int hashCode() {
        return (((this.f4076d.hashCode() * 31) + this.f4077e.hashCode()) * 31) + this.f4078f.hashCode();
    }

    /* renamed from: i */
    public final void m4819i(String str) {
        C0763u c0763u = this.f4077e.get(str);
        if (c0763u != null) {
            c0763u.mo4815d();
            this.f4077e.remove(str);
        }
        C0786e0 c0786e0 = this.f4078f.get(str);
        if (c0786e0 != null) {
            c0786e0.m4942a();
            this.f4078f.remove(str);
        }
    }

    /* renamed from: j */
    public Fragment m4820j(String str) {
        return this.f4076d.get(str);
    }

    /* renamed from: k */
    public C0763u m4821k(Fragment fragment) {
        C0763u c0763u = this.f4077e.get(fragment.f3728f);
        if (c0763u != null) {
            return c0763u;
        }
        C0763u c0763u2 = new C0763u(this.f4079g);
        this.f4077e.put(fragment.f3728f, c0763u2);
        return c0763u2;
    }

    /* renamed from: m */
    public Collection<Fragment> m4822m() {
        return new ArrayList(this.f4076d.values());
    }

    /* renamed from: n */
    public C0786e0 m4823n(Fragment fragment) {
        C0786e0 c0786e0 = this.f4078f.get(fragment.f3728f);
        if (c0786e0 != null) {
            return c0786e0;
        }
        C0786e0 c0786e02 = new C0786e0();
        this.f4078f.put(fragment.f3728f, c0786e02);
        return c0786e02;
    }

    /* renamed from: o */
    public boolean m4824o() {
        return this.f4080h;
    }

    /* renamed from: p */
    public void m4825p(Fragment fragment) {
        if (this.f4082j) {
            if (FragmentManager.m4492I0(2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else {
            if (this.f4076d.remove(fragment.f3728f) == null || !FragmentManager.m4492I0(2)) {
                return;
            }
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + fragment);
        }
    }

    /* renamed from: q */
    public void m4826q(boolean z10) {
        this.f4082j = z10;
    }

    /* renamed from: r */
    public boolean m4827r(Fragment fragment) {
        if (this.f4076d.containsKey(fragment.f3728f)) {
            return this.f4079g ? this.f4080h : !this.f4081i;
        }
        return true;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("FragmentManagerViewModel{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append("} Fragments (");
        Iterator<Fragment> it = this.f4076d.values().iterator();
        while (it.hasNext()) {
            sb2.append(it.next());
            if (it.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(") Child Non Config (");
        Iterator<String> it2 = this.f4077e.keySet().iterator();
        while (it2.hasNext()) {
            sb2.append(it2.next());
            if (it2.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(") ViewModelStores (");
        Iterator<String> it3 = this.f4078f.keySet().iterator();
        while (it3.hasNext()) {
            sb2.append(it3.next());
            if (it3.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(C5929g4.f26850l);
        return sb2.toString();
    }
}
