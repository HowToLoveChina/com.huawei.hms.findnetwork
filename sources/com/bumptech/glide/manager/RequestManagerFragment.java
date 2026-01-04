package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.util.Log;
import com.bumptech.glide.ComponentCallbacks2C1546b;
import com.bumptech.glide.ComponentCallbacks2C1555k;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Deprecated
/* loaded from: classes.dex */
public class RequestManagerFragment extends Fragment {

    /* renamed from: a */
    public final C1603a f7104a;

    /* renamed from: b */
    public final InterfaceC1619q f7105b;

    /* renamed from: c */
    public final Set<RequestManagerFragment> f7106c;

    /* renamed from: d */
    public ComponentCallbacks2C1555k f7107d;

    /* renamed from: e */
    public RequestManagerFragment f7108e;

    /* renamed from: f */
    public Fragment f7109f;

    /* renamed from: com.bumptech.glide.manager.RequestManagerFragment$a */
    public class C1602a implements InterfaceC1619q {
        public C1602a() {
        }

        @Override // com.bumptech.glide.manager.InterfaceC1619q
        /* renamed from: a */
        public Set<ComponentCallbacks2C1555k> mo9184a() {
            Set<RequestManagerFragment> setM9173b = RequestManagerFragment.this.m9173b();
            HashSet hashSet = new HashSet(setM9173b.size());
            for (RequestManagerFragment requestManagerFragment : setM9173b) {
                if (requestManagerFragment.m9176e() != null) {
                    hashSet.add(requestManagerFragment.m9176e());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + RequestManagerFragment.this + "}";
        }
    }

    public RequestManagerFragment() {
        this(new C1603a());
    }

    /* renamed from: a */
    public final void m9172a(RequestManagerFragment requestManagerFragment) {
        this.f7106c.add(requestManagerFragment);
    }

    @TargetApi(17)
    /* renamed from: b */
    public Set<RequestManagerFragment> m9173b() {
        if (equals(this.f7108e)) {
            return Collections.unmodifiableSet(this.f7106c);
        }
        if (this.f7108e == null) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet();
        for (RequestManagerFragment requestManagerFragment : this.f7108e.m9173b()) {
            if (m9178g(requestManagerFragment.getParentFragment())) {
                hashSet.add(requestManagerFragment);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    /* renamed from: c */
    public C1603a m9174c() {
        return this.f7104a;
    }

    @TargetApi(17)
    /* renamed from: d */
    public final Fragment m9175d() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null ? parentFragment : this.f7109f;
    }

    /* renamed from: e */
    public ComponentCallbacks2C1555k m9176e() {
        return this.f7107d;
    }

    /* renamed from: f */
    public InterfaceC1619q m9177f() {
        return this.f7105b;
    }

    @TargetApi(17)
    /* renamed from: g */
    public final boolean m9178g(Fragment fragment) {
        Fragment parentFragment = getParentFragment();
        while (true) {
            Fragment parentFragment2 = fragment.getParentFragment();
            if (parentFragment2 == null) {
                return false;
            }
            if (parentFragment2.equals(parentFragment)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
    }

    /* renamed from: h */
    public final void m9179h(Activity activity) {
        m9183l();
        RequestManagerFragment requestManagerFragmentM9204i = ComponentCallbacks2C1546b.m8898c(activity).m8912k().m9204i(activity);
        this.f7108e = requestManagerFragmentM9204i;
        if (equals(requestManagerFragmentM9204i)) {
            return;
        }
        this.f7108e.m9172a(this);
    }

    /* renamed from: i */
    public final void m9180i(RequestManagerFragment requestManagerFragment) {
        this.f7106c.remove(requestManagerFragment);
    }

    /* renamed from: j */
    public void m9181j(Fragment fragment) {
        this.f7109f = fragment;
        if (fragment == null || fragment.getActivity() == null) {
            return;
        }
        m9179h(fragment.getActivity());
    }

    /* renamed from: k */
    public void m9182k(ComponentCallbacks2C1555k componentCallbacks2C1555k) {
        this.f7107d = componentCallbacks2C1555k;
    }

    /* renamed from: l */
    public final void m9183l() {
        RequestManagerFragment requestManagerFragment = this.f7108e;
        if (requestManagerFragment != null) {
            requestManagerFragment.m9180i(this);
            this.f7108e = null;
        }
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            m9179h(activity);
        } catch (IllegalStateException e10) {
            if (Log.isLoggable("RMFragment", 5)) {
                Log.w("RMFragment", "Unable to register fragment with root", e10);
            }
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f7104a.m9185a();
        m9183l();
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        m9183l();
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.f7104a.m9186b();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.f7104a.m9187c();
    }

    @Override // android.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + m9175d() + "}";
    }

    @SuppressLint({"ValidFragment"})
    public RequestManagerFragment(C1603a c1603a) {
        this.f7105b = new C1602a();
        this.f7106c = new HashSet();
        this.f7104a = c1603a;
    }
}
