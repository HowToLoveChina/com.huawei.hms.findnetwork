package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.ComponentCallbacks2C1546b;
import com.bumptech.glide.ComponentCallbacks2C1555k;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.bumptech.glide.manager.t */
/* loaded from: classes.dex */
public class C1622t extends Fragment {

    /* renamed from: c0 */
    public final C1603a f7151c0;

    /* renamed from: d0 */
    public final InterfaceC1619q f7152d0;

    /* renamed from: e0 */
    public final Set<C1622t> f7153e0;

    /* renamed from: f0 */
    public C1622t f7154f0;

    /* renamed from: g0 */
    public ComponentCallbacks2C1555k f7155g0;

    /* renamed from: h0 */
    public Fragment f7156h0;

    /* renamed from: com.bumptech.glide.manager.t$a */
    public class a implements InterfaceC1619q {
        public a() {
        }

        @Override // com.bumptech.glide.manager.InterfaceC1619q
        /* renamed from: a */
        public Set<ComponentCallbacks2C1555k> mo9184a() {
            Set<C1622t> setM9232D1 = C1622t.this.m9232D1();
            HashSet hashSet = new HashSet(setM9232D1.size());
            for (C1622t c1622t : setM9232D1) {
                if (c1622t.m9235G1() != null) {
                    hashSet.add(c1622t.m9235G1());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + C1622t.this + "}";
        }
    }

    public C1622t() {
        this(new C1603a());
    }

    /* renamed from: I1 */
    public static FragmentManager m9230I1(Fragment fragment) {
        while (fragment.m4339C() != null) {
            fragment = fragment.m4339C();
        }
        return fragment.m4450x();
    }

    /* renamed from: C1 */
    public final void m9231C1(C1622t c1622t) {
        this.f7153e0.add(c1622t);
    }

    /* renamed from: D1 */
    public Set<C1622t> m9232D1() {
        C1622t c1622t = this.f7154f0;
        if (c1622t == null) {
            return Collections.emptySet();
        }
        if (equals(c1622t)) {
            return Collections.unmodifiableSet(this.f7153e0);
        }
        HashSet hashSet = new HashSet();
        for (C1622t c1622t2 : this.f7154f0.m9232D1()) {
            if (m9237J1(c1622t2.m9234F1())) {
                hashSet.add(c1622t2);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    /* renamed from: E1 */
    public C1603a m9233E1() {
        return this.f7151c0;
    }

    /* renamed from: F1 */
    public final Fragment m9234F1() {
        Fragment fragmentM4339C = m4339C();
        return fragmentM4339C != null ? fragmentM4339C : this.f7156h0;
    }

    /* renamed from: G1 */
    public ComponentCallbacks2C1555k m9235G1() {
        return this.f7155g0;
    }

    /* renamed from: H1 */
    public InterfaceC1619q m9236H1() {
        return this.f7152d0;
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: I0 */
    public void mo4352I0() {
        super.mo4352I0();
        this.f7151c0.m9186b();
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: J0 */
    public void mo4353J0() {
        super.mo4353J0();
        this.f7151c0.m9187c();
    }

    /* renamed from: J1 */
    public final boolean m9237J1(Fragment fragment) {
        Fragment fragmentM9234F1 = m9234F1();
        while (true) {
            Fragment fragmentM4339C = fragment.m4339C();
            if (fragmentM4339C == null) {
                return false;
            }
            if (fragmentM4339C.equals(fragmentM9234F1)) {
                return true;
            }
            fragment = fragment.m4339C();
        }
    }

    /* renamed from: K1 */
    public final void m9238K1(Context context, FragmentManager fragmentManager) {
        m9242O1();
        C1622t c1622tM9206k = ComponentCallbacks2C1546b.m8898c(context).m8912k().m9206k(fragmentManager);
        this.f7154f0 = c1622tM9206k;
        if (equals(c1622tM9206k)) {
            return;
        }
        this.f7154f0.m9231C1(this);
    }

    /* renamed from: L1 */
    public final void m9239L1(C1622t c1622t) {
        this.f7153e0.remove(c1622t);
    }

    /* renamed from: M1 */
    public void m9240M1(Fragment fragment) {
        FragmentManager fragmentManagerM9230I1;
        this.f7156h0 = fragment;
        if (fragment == null || fragment.m4426p() == null || (fragmentManagerM9230I1 = m9230I1(fragment)) == null) {
            return;
        }
        m9238K1(fragment.m4426p(), fragmentManagerM9230I1);
    }

    /* renamed from: N1 */
    public void m9241N1(ComponentCallbacks2C1555k componentCallbacks2C1555k) {
        this.f7155g0 = componentCallbacks2C1555k;
    }

    /* renamed from: O1 */
    public final void m9242O1() {
        C1622t c1622t = this.f7154f0;
        if (c1622t != null) {
            c1622t.m9239L1(this);
            this.f7154f0 = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: i0 */
    public void mo4407i0(Context context) {
        super.mo4407i0(context);
        FragmentManager fragmentManagerM9230I1 = m9230I1(this);
        if (fragmentManagerM9230I1 == null) {
            if (Log.isLoggable("SupportRMFragment", 5)) {
                Log.w("SupportRMFragment", "Unable to register fragment with root, ancestor detached");
            }
        } else {
            try {
                m9238K1(m4426p(), fragmentManagerM9230I1);
            } catch (IllegalStateException e10) {
                if (Log.isLoggable("SupportRMFragment", 5)) {
                    Log.w("SupportRMFragment", "Unable to register fragment with root", e10);
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: q0 */
    public void mo4430q0() {
        super.mo4430q0();
        this.f7151c0.m9185a();
        m9242O1();
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: t0 */
    public void mo4439t0() {
        super.mo4439t0();
        this.f7156h0 = null;
        m9242O1();
    }

    @Override // androidx.fragment.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + m9234F1() + "}";
    }

    @SuppressLint({"ValidFragment"})
    public C1622t(C1603a c1603a) {
        this.f7152d0 = new a();
        this.f7153e0 = new HashSet();
        this.f7151c0 = c1603a;
    }
}
