package com.bumptech.glide.manager;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.AbstractC0735a0;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.C1547c;
import com.bumptech.glide.C1549e;
import com.bumptech.glide.ComponentCallbacks2C1546b;
import com.bumptech.glide.ComponentCallbacks2C1555k;
import java.util.HashMap;
import java.util.Map;
import p306g2.C9867s;
import p438l.C11207a;
import p630s2.C12677l;

/* renamed from: com.bumptech.glide.manager.p */
/* loaded from: classes.dex */
public class C1618p implements Handler.Callback {

    /* renamed from: l */
    public static final b f7122l = new a();

    /* renamed from: a */
    public volatile ComponentCallbacks2C1555k f7123a;

    /* renamed from: d */
    public final Handler f7126d;

    /* renamed from: e */
    public final b f7127e;

    /* renamed from: f */
    public final C1549e f7128f;

    /* renamed from: j */
    public final InterfaceC1613k f7132j;

    /* renamed from: k */
    public final C1616n f7133k;

    /* renamed from: b */
    public final Map<FragmentManager, RequestManagerFragment> f7124b = new HashMap();

    /* renamed from: c */
    public final Map<androidx.fragment.app.FragmentManager, C1622t> f7125c = new HashMap();

    /* renamed from: g */
    public final C11207a<View, Fragment> f7129g = new C11207a<>();

    /* renamed from: h */
    public final C11207a<View, android.app.Fragment> f7130h = new C11207a<>();

    /* renamed from: i */
    public final Bundle f7131i = new Bundle();

    /* renamed from: com.bumptech.glide.manager.p$a */
    public class a implements b {
        @Override // com.bumptech.glide.manager.C1618p.b
        /* renamed from: a */
        public ComponentCallbacks2C1555k mo9212a(ComponentCallbacks2C1546b componentCallbacks2C1546b, InterfaceC1614l interfaceC1614l, InterfaceC1619q interfaceC1619q, Context context) {
            return new ComponentCallbacks2C1555k(componentCallbacks2C1546b, interfaceC1614l, interfaceC1619q, context);
        }
    }

    /* renamed from: com.bumptech.glide.manager.p$b */
    public interface b {
        /* renamed from: a */
        ComponentCallbacks2C1555k mo9212a(ComponentCallbacks2C1546b componentCallbacks2C1546b, InterfaceC1614l interfaceC1614l, InterfaceC1619q interfaceC1619q, Context context);
    }

    public C1618p(b bVar, C1549e c1549e) {
        bVar = bVar == null ? f7122l : bVar;
        this.f7127e = bVar;
        this.f7128f = c1549e;
        this.f7126d = new Handler(Looper.getMainLooper(), this);
        this.f7133k = new C1616n(bVar);
        this.f7132j = m9196b(c1549e);
    }

    @TargetApi(17)
    /* renamed from: a */
    public static void m9195a(Activity activity) {
        if (activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    /* renamed from: b */
    public static InterfaceC1613k m9196b(C1549e c1549e) {
        return (C9867s.f48461h && C9867s.f48460g) ? c1549e.m8928a(C1547c.e.class) ? new ComponentCallbacks2C1611i() : new C1612j() : new C1609g();
    }

    /* renamed from: c */
    public static Activity m9197c(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return m9197c(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    /* renamed from: m */
    public static boolean m9198m(Context context) {
        Activity activityM9197c = m9197c(context);
        return activityM9197c == null || !activityM9197c.isFinishing();
    }

    @Deprecated
    /* renamed from: d */
    public final ComponentCallbacks2C1555k m9199d(Context context, FragmentManager fragmentManager, android.app.Fragment fragment, boolean z10) {
        RequestManagerFragment requestManagerFragmentM9205j = m9205j(fragmentManager, fragment);
        ComponentCallbacks2C1555k componentCallbacks2C1555kM9176e = requestManagerFragmentM9205j.m9176e();
        if (componentCallbacks2C1555kM9176e == null) {
            componentCallbacks2C1555kM9176e = this.f7127e.mo9212a(ComponentCallbacks2C1546b.m8898c(context), requestManagerFragmentM9205j.m9174c(), requestManagerFragmentM9205j.m9177f(), context);
            if (z10) {
                componentCallbacks2C1555kM9176e.onStart();
            }
            requestManagerFragmentM9205j.m9182k(componentCallbacks2C1555kM9176e);
        }
        return componentCallbacks2C1555kM9176e;
    }

    @Deprecated
    /* renamed from: e */
    public ComponentCallbacks2C1555k m9200e(Activity activity) {
        if (C12677l.m76293p()) {
            return m9201f(activity.getApplicationContext());
        }
        if (activity instanceof FragmentActivity) {
            return m9202g((FragmentActivity) activity);
        }
        m9195a(activity);
        this.f7132j.mo9191a(activity);
        return m9199d(activity, activity.getFragmentManager(), null, m9198m(activity));
    }

    /* renamed from: f */
    public ComponentCallbacks2C1555k m9201f(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        }
        if (C12677l.m76294q() && !(context instanceof Application)) {
            if (context instanceof FragmentActivity) {
                return m9202g((FragmentActivity) context);
            }
            if (context instanceof Activity) {
                return m9200e((Activity) context);
            }
            if (context instanceof ContextWrapper) {
                ContextWrapper contextWrapper = (ContextWrapper) context;
                if (contextWrapper.getBaseContext().getApplicationContext() != null) {
                    return m9201f(contextWrapper.getBaseContext());
                }
            }
        }
        return m9203h(context);
    }

    /* renamed from: g */
    public ComponentCallbacks2C1555k m9202g(FragmentActivity fragmentActivity) {
        if (C12677l.m76293p()) {
            return m9201f(fragmentActivity.getApplicationContext());
        }
        m9195a(fragmentActivity);
        this.f7132j.mo9191a(fragmentActivity);
        androidx.fragment.app.FragmentManager fragmentManagerM4473U = fragmentActivity.m4473U();
        boolean zM9198m = m9198m(fragmentActivity);
        if (!m9209o()) {
            return m9208n(fragmentActivity, fragmentManagerM4473U, null, zM9198m);
        }
        Context applicationContext = fragmentActivity.getApplicationContext();
        return this.f7133k.m9193b(applicationContext, ComponentCallbacks2C1546b.m8898c(applicationContext), fragmentActivity.mo1915g(), fragmentActivity.m4473U(), zM9198m);
    }

    /* renamed from: h */
    public final ComponentCallbacks2C1555k m9203h(Context context) {
        if (this.f7123a == null) {
            synchronized (this) {
                try {
                    if (this.f7123a == null) {
                        this.f7123a = this.f7127e.mo9212a(ComponentCallbacks2C1546b.m8898c(context.getApplicationContext()), new C1604b(), new C1610h(), context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
        return this.f7123a;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        FragmentManager fragmentManager;
        FragmentManager fragmentManager2;
        boolean z10 = true;
        boolean z11 = false;
        boolean z12 = message.arg1 == 1;
        int i10 = message.what;
        Object objRemove = null;
        if (i10 == 1) {
            FragmentManager fragmentManager3 = (FragmentManager) message.obj;
            if (m9210p(fragmentManager3, z12)) {
                objRemove = this.f7124b.remove(fragmentManager3);
                fragmentManager2 = fragmentManager3;
                z11 = true;
                fragmentManager = fragmentManager2;
            }
            fragmentManager = null;
            z11 = true;
            z10 = false;
        } else if (i10 != 2) {
            z10 = false;
            fragmentManager = null;
        } else {
            androidx.fragment.app.FragmentManager fragmentManager4 = (androidx.fragment.app.FragmentManager) message.obj;
            if (m9211q(fragmentManager4, z12)) {
                objRemove = this.f7125c.remove(fragmentManager4);
                fragmentManager2 = fragmentManager4;
                z11 = true;
                fragmentManager = fragmentManager2;
            }
            fragmentManager = null;
            z11 = true;
            z10 = false;
        }
        if (Log.isLoggable("RMRetriever", 5) && z10 && objRemove == null) {
            Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + fragmentManager);
        }
        return z11;
    }

    @Deprecated
    /* renamed from: i */
    public RequestManagerFragment m9204i(Activity activity) {
        return m9205j(activity.getFragmentManager(), null);
    }

    /* renamed from: j */
    public final RequestManagerFragment m9205j(FragmentManager fragmentManager, android.app.Fragment fragment) {
        RequestManagerFragment requestManagerFragment = this.f7124b.get(fragmentManager);
        if (requestManagerFragment != null) {
            return requestManagerFragment;
        }
        RequestManagerFragment requestManagerFragment2 = (RequestManagerFragment) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (requestManagerFragment2 == null) {
            requestManagerFragment2 = new RequestManagerFragment();
            requestManagerFragment2.m9181j(fragment);
            this.f7124b.put(fragmentManager, requestManagerFragment2);
            fragmentManager.beginTransaction().add(requestManagerFragment2, "com.bumptech.glide.manager").commitAllowingStateLoss();
            this.f7126d.obtainMessage(1, fragmentManager).sendToTarget();
        }
        return requestManagerFragment2;
    }

    /* renamed from: k */
    public C1622t m9206k(androidx.fragment.app.FragmentManager fragmentManager) {
        return m9207l(fragmentManager, null);
    }

    /* renamed from: l */
    public final C1622t m9207l(androidx.fragment.app.FragmentManager fragmentManager, Fragment fragment) {
        C1622t c1622t = this.f7125c.get(fragmentManager);
        if (c1622t != null) {
            return c1622t;
        }
        C1622t c1622t2 = (C1622t) fragmentManager.m4571i0("com.bumptech.glide.manager");
        if (c1622t2 == null) {
            c1622t2 = new C1622t();
            c1622t2.m9240M1(fragment);
            this.f7125c.put(fragmentManager, c1622t2);
            fragmentManager.m4585o().m4665e(c1622t2, "com.bumptech.glide.manager").mo4648i();
            this.f7126d.obtainMessage(2, fragmentManager).sendToTarget();
        }
        return c1622t2;
    }

    /* renamed from: n */
    public final ComponentCallbacks2C1555k m9208n(Context context, androidx.fragment.app.FragmentManager fragmentManager, Fragment fragment, boolean z10) {
        C1622t c1622tM9207l = m9207l(fragmentManager, fragment);
        ComponentCallbacks2C1555k componentCallbacks2C1555kM9235G1 = c1622tM9207l.m9235G1();
        if (componentCallbacks2C1555kM9235G1 == null) {
            componentCallbacks2C1555kM9235G1 = this.f7127e.mo9212a(ComponentCallbacks2C1546b.m8898c(context), c1622tM9207l.m9233E1(), c1622tM9207l.m9236H1(), context);
            if (z10) {
                componentCallbacks2C1555kM9235G1.onStart();
            }
            c1622tM9207l.m9241N1(componentCallbacks2C1555kM9235G1);
        }
        return componentCallbacks2C1555kM9235G1;
    }

    /* renamed from: o */
    public final boolean m9209o() {
        return this.f7128f.m8928a(C1547c.d.class);
    }

    /* renamed from: p */
    public final boolean m9210p(FragmentManager fragmentManager, boolean z10) {
        RequestManagerFragment requestManagerFragment = this.f7124b.get(fragmentManager);
        RequestManagerFragment requestManagerFragment2 = (RequestManagerFragment) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (requestManagerFragment2 == requestManagerFragment) {
            return true;
        }
        if (requestManagerFragment2 != null && requestManagerFragment2.m9176e() != null) {
            throw new IllegalStateException("We've added two fragments with requests! Old: " + requestManagerFragment2 + " New: " + requestManagerFragment);
        }
        if (z10 || fragmentManager.isDestroyed()) {
            if (Log.isLoggable("RMRetriever", 5)) {
                if (fragmentManager.isDestroyed()) {
                    Log.w("RMRetriever", "Parent was destroyed before our Fragment could be added");
                } else {
                    Log.w("RMRetriever", "Tried adding Fragment twice and failed twice, giving up!");
                }
            }
            requestManagerFragment.m9174c().m9185a();
            return true;
        }
        FragmentTransaction fragmentTransactionAdd = fragmentManager.beginTransaction().add(requestManagerFragment, "com.bumptech.glide.manager");
        if (requestManagerFragment2 != null) {
            fragmentTransactionAdd.remove(requestManagerFragment2);
        }
        fragmentTransactionAdd.commitAllowingStateLoss();
        this.f7126d.obtainMessage(1, 1, 0, fragmentManager).sendToTarget();
        if (Log.isLoggable("RMRetriever", 3)) {
            Log.d("RMRetriever", "We failed to add our Fragment the first time around, trying again...");
        }
        return false;
    }

    /* renamed from: q */
    public final boolean m9211q(androidx.fragment.app.FragmentManager fragmentManager, boolean z10) {
        C1622t c1622t = this.f7125c.get(fragmentManager);
        C1622t c1622t2 = (C1622t) fragmentManager.m4571i0("com.bumptech.glide.manager");
        if (c1622t2 == c1622t) {
            return true;
        }
        if (c1622t2 != null && c1622t2.m9235G1() != null) {
            throw new IllegalStateException("We've added two fragments with requests! Old: " + c1622t2 + " New: " + c1622t);
        }
        if (z10 || fragmentManager.m4519H0()) {
            if (fragmentManager.m4519H0()) {
                if (Log.isLoggable("RMRetriever", 5)) {
                    Log.w("RMRetriever", "Parent was destroyed before our Fragment could be added, all requests for the destroyed parent are cancelled");
                }
            } else if (Log.isLoggable("RMRetriever", 6)) {
                Log.e("RMRetriever", "ERROR: Tried adding Fragment twice and failed twice, giving up and cancelling all associated requests! This probably means you're starting loads in a unit test with an Activity that you haven't created and never create. If you're using Robolectric, create the Activity as part of your test setup");
            }
            c1622t.m9233E1().m9185a();
            return true;
        }
        AbstractC0735a0 abstractC0735a0M4665e = fragmentManager.m4585o().m4665e(c1622t, "com.bumptech.glide.manager");
        if (c1622t2 != null) {
            abstractC0735a0M4665e.mo4655q(c1622t2);
        }
        abstractC0735a0M4665e.mo4650k();
        this.f7126d.obtainMessage(2, 1, 0, fragmentManager).sendToTarget();
        if (Log.isLoggable("RMRetriever", 3)) {
            Log.d("RMRetriever", "We failed to add our Fragment the first time around, trying again...");
        }
        return false;
    }
}
