package com.bumptech.glide.manager;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.AbstractC0791h;
import com.bumptech.glide.ComponentCallbacks2C1546b;
import com.bumptech.glide.ComponentCallbacks2C1555k;
import com.bumptech.glide.manager.C1618p;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p630s2.C12677l;

/* renamed from: com.bumptech.glide.manager.n */
/* loaded from: classes.dex */
public final class C1616n {

    /* renamed from: a */
    public final Map<AbstractC0791h, ComponentCallbacks2C1555k> f7116a = new HashMap();

    /* renamed from: b */
    public final C1618p.b f7117b;

    /* renamed from: com.bumptech.glide.manager.n$a */
    public class a implements InterfaceC1615m {

        /* renamed from: a */
        public final /* synthetic */ AbstractC0791h f7118a;

        public a(AbstractC0791h abstractC0791h) {
            this.f7118a = abstractC0791h;
        }

        @Override // com.bumptech.glide.manager.InterfaceC1615m
        public void onDestroy() {
            C1616n.this.f7116a.remove(this.f7118a);
        }

        @Override // com.bumptech.glide.manager.InterfaceC1615m
        public void onStart() {
        }

        @Override // com.bumptech.glide.manager.InterfaceC1615m
        public void onStop() {
        }
    }

    /* renamed from: com.bumptech.glide.manager.n$b */
    public final class b implements InterfaceC1619q {

        /* renamed from: a */
        public final FragmentManager f7120a;

        public b(FragmentManager fragmentManager) {
            this.f7120a = fragmentManager;
        }

        @Override // com.bumptech.glide.manager.InterfaceC1619q
        /* renamed from: a */
        public Set<ComponentCallbacks2C1555k> mo9184a() {
            HashSet hashSet = new HashSet();
            m9194b(this.f7120a, hashSet);
            return hashSet;
        }

        /* renamed from: b */
        public final void m9194b(FragmentManager fragmentManager, Set<ComponentCallbacks2C1555k> set) {
            List<Fragment> listM4604u0 = fragmentManager.m4604u0();
            int size = listM4604u0.size();
            for (int i10 = 0; i10 < size; i10++) {
                Fragment fragment = listM4604u0.get(i10);
                m9194b(fragment.m4423o(), set);
                ComponentCallbacks2C1555k componentCallbacks2C1555kM9192a = C1616n.this.m9192a(fragment.mo1915g());
                if (componentCallbacks2C1555kM9192a != null) {
                    set.add(componentCallbacks2C1555kM9192a);
                }
            }
        }
    }

    public C1616n(C1618p.b bVar) {
        this.f7117b = bVar;
    }

    /* renamed from: a */
    public ComponentCallbacks2C1555k m9192a(AbstractC0791h abstractC0791h) {
        C12677l.m76278a();
        return this.f7116a.get(abstractC0791h);
    }

    /* renamed from: b */
    public ComponentCallbacks2C1555k m9193b(Context context, ComponentCallbacks2C1546b componentCallbacks2C1546b, AbstractC0791h abstractC0791h, FragmentManager fragmentManager, boolean z10) {
        C12677l.m76278a();
        ComponentCallbacks2C1555k componentCallbacks2C1555kM9192a = m9192a(abstractC0791h);
        if (componentCallbacks2C1555kM9192a != null) {
            return componentCallbacks2C1555kM9192a;
        }
        LifecycleLifecycle lifecycleLifecycle = new LifecycleLifecycle(abstractC0791h);
        ComponentCallbacks2C1555k componentCallbacks2C1555kMo9212a = this.f7117b.mo9212a(componentCallbacks2C1546b, lifecycleLifecycle, new b(fragmentManager), context);
        this.f7116a.put(abstractC0791h, componentCallbacks2C1555kMo9212a);
        lifecycleLifecycle.mo9170e(new a(abstractC0791h));
        if (z10) {
            componentCallbacks2C1555kMo9212a.onStart();
        }
        return componentCallbacks2C1555kMo9212a;
    }
}
