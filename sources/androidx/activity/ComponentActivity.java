package androidx.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.result.AbstractC0343c;
import androidx.activity.result.InterfaceC0344d;
import androidx.core.content.OnConfigurationChangedProvider;
import androidx.core.content.OnTrimMemoryProvider;
import androidx.lifecycle.AbstractC0791h;
import androidx.lifecycle.C0782c0;
import androidx.lifecycle.C0786e0;
import androidx.lifecycle.C0790g0;
import androidx.lifecycle.C0792h0;
import androidx.lifecycle.C0797m;
import androidx.lifecycle.C0807w;
import androidx.lifecycle.C0810z;
import androidx.lifecycle.InterfaceC0788f0;
import androidx.lifecycle.InterfaceC0789g;
import androidx.lifecycle.InterfaceC0794j;
import androidx.lifecycle.InterfaceC0796l;
import androidx.lifecycle.ReportFragment;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import p023b.C1083a;
import p023b.InterfaceC1084b;
import p024b0.C1085a;
import p243e0.InterfaceC9366a;
import p273f0.C9624s;
import p273f0.InterfaceC9622r;
import p273f0.InterfaceC9628u;
import p597r0.AbstractC12450a;
import p597r0.C12453d;
import p694v.C13301c;
import p694v.C13309k;
import p694v.InterfaceC13307i;
import p694v.InterfaceC13308j;
import p724w0.C13512b;
import p724w0.C13513c;
import p724w0.C13515e;
import p724w0.InterfaceC13514d;
import p828z0.C14060a;

/* loaded from: classes.dex */
public class ComponentActivity extends androidx.core.app.ComponentActivity implements InterfaceC0796l, InterfaceC0788f0, InterfaceC0789g, InterfaceC13514d, InterfaceC0337k, InterfaceC0344d, OnConfigurationChangedProvider, OnTrimMemoryProvider, InterfaceC13307i, InterfaceC13308j, InterfaceC9622r {

    /* renamed from: c */
    public final C1083a f1065c = new C1083a();

    /* renamed from: d */
    public final C9624s f1066d = new C9624s(new Runnable() { // from class: androidx.activity.b
        @Override // java.lang.Runnable
        public final void run() {
            this.f1108a.m1910L();
        }
    });

    /* renamed from: e */
    public final C0797m f1067e = new C0797m(this);

    /* renamed from: f */
    public final C13513c f1068f;

    /* renamed from: g */
    public C0786e0 f1069g;

    /* renamed from: h */
    public C0782c0.b f1070h;

    /* renamed from: i */
    public final OnBackPressedDispatcher f1071i;

    /* renamed from: j */
    public int f1072j;

    /* renamed from: k */
    public final AtomicInteger f1073k;

    /* renamed from: l */
    public final AbstractC0343c f1074l;

    /* renamed from: m */
    public final CopyOnWriteArrayList<InterfaceC9366a<Configuration>> f1075m;

    /* renamed from: n */
    public final CopyOnWriteArrayList<InterfaceC9366a<Integer>> f1076n;

    /* renamed from: o */
    public final CopyOnWriteArrayList<InterfaceC9366a<Intent>> f1077o;

    /* renamed from: p */
    public final CopyOnWriteArrayList<InterfaceC9366a<C13301c>> f1078p;

    /* renamed from: q */
    public final CopyOnWriteArrayList<InterfaceC9366a<C13309k>> f1079q;

    /* renamed from: r */
    public boolean f1080r;

    /* renamed from: s */
    public boolean f1081s;

    /* renamed from: androidx.activity.ComponentActivity$3 */
    public class C03173 implements InterfaceC0794j {
        public C03173() {
        }

        @Override // androidx.lifecycle.InterfaceC0794j
        /* renamed from: d */
        public void mo1925d(InterfaceC0796l interfaceC0796l, AbstractC0791h.b bVar) {
            if (bVar == AbstractC0791h.b.ON_STOP) {
                Window window = ComponentActivity.this.getWindow();
                View viewPeekDecorView = window != null ? window.peekDecorView() : null;
                if (viewPeekDecorView != null) {
                    C0322c.m1926a(viewPeekDecorView);
                }
            }
        }
    }

    /* renamed from: androidx.activity.ComponentActivity$4 */
    public class C03184 implements InterfaceC0794j {
        public C03184() {
        }

        @Override // androidx.lifecycle.InterfaceC0794j
        /* renamed from: d */
        public void mo1925d(InterfaceC0796l interfaceC0796l, AbstractC0791h.b bVar) {
            if (bVar == AbstractC0791h.b.ON_DESTROY) {
                ComponentActivity.this.f1065c.m6459b();
                if (ComponentActivity.this.isChangingConfigurations()) {
                    return;
                }
                ComponentActivity.this.getViewModelStore().m4942a();
            }
        }
    }

    /* renamed from: androidx.activity.ComponentActivity$5 */
    public class C03195 implements InterfaceC0794j {
        public C03195() {
        }

        @Override // androidx.lifecycle.InterfaceC0794j
        /* renamed from: d */
        public void mo1925d(InterfaceC0796l interfaceC0796l, AbstractC0791h.b bVar) {
            ComponentActivity.this.m1908I();
            ComponentActivity.this.mo1915g().mo4950c(this);
        }
    }

    /* renamed from: androidx.activity.ComponentActivity$a */
    public class RunnableC0320a implements Runnable {
        public RunnableC0320a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ComponentActivity.super.onBackPressed();
            } catch (IllegalStateException e10) {
                if (!TextUtils.equals(e10.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                    throw e10;
                }
            }
        }
    }

    /* renamed from: androidx.activity.ComponentActivity$b */
    public class C0321b extends AbstractC0343c {
        public C0321b() {
        }
    }

    /* renamed from: androidx.activity.ComponentActivity$c */
    public static class C0322c {
        /* renamed from: a */
        public static void m1926a(View view) {
            view.cancelPendingInputEvents();
        }
    }

    /* renamed from: androidx.activity.ComponentActivity$d */
    public static class C0323d {
        /* renamed from: a */
        public static OnBackInvokedDispatcher m1927a(Activity activity) {
            return activity.getOnBackInvokedDispatcher();
        }
    }

    /* renamed from: androidx.activity.ComponentActivity$e */
    public static final class C0324e {

        /* renamed from: a */
        public Object f1087a;

        /* renamed from: b */
        public C0786e0 f1088b;
    }

    public ComponentActivity() {
        C13513c c13513cM81269a = C13513c.m81269a(this);
        this.f1068f = c13513cM81269a;
        this.f1071i = new OnBackPressedDispatcher(new RunnableC0320a());
        this.f1073k = new AtomicInteger();
        this.f1074l = new C0321b();
        this.f1075m = new CopyOnWriteArrayList<>();
        this.f1076n = new CopyOnWriteArrayList<>();
        this.f1077o = new CopyOnWriteArrayList<>();
        this.f1078p = new CopyOnWriteArrayList<>();
        this.f1079q = new CopyOnWriteArrayList<>();
        this.f1080r = false;
        this.f1081s = false;
        if (mo1915g() == null) {
            throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        }
        mo1915g().mo4948a(new InterfaceC0794j() { // from class: androidx.activity.ComponentActivity.3
            public C03173() {
            }

            @Override // androidx.lifecycle.InterfaceC0794j
            /* renamed from: d */
            public void mo1925d(InterfaceC0796l interfaceC0796l, AbstractC0791h.b bVar) {
                if (bVar == AbstractC0791h.b.ON_STOP) {
                    Window window = ComponentActivity.this.getWindow();
                    View viewPeekDecorView = window != null ? window.peekDecorView() : null;
                    if (viewPeekDecorView != null) {
                        C0322c.m1926a(viewPeekDecorView);
                    }
                }
            }
        });
        mo1915g().mo4948a(new InterfaceC0794j() { // from class: androidx.activity.ComponentActivity.4
            public C03184() {
            }

            @Override // androidx.lifecycle.InterfaceC0794j
            /* renamed from: d */
            public void mo1925d(InterfaceC0796l interfaceC0796l, AbstractC0791h.b bVar) {
                if (bVar == AbstractC0791h.b.ON_DESTROY) {
                    ComponentActivity.this.f1065c.m6459b();
                    if (ComponentActivity.this.isChangingConfigurations()) {
                        return;
                    }
                    ComponentActivity.this.getViewModelStore().m4942a();
                }
            }
        });
        mo1915g().mo4948a(new InterfaceC0794j() { // from class: androidx.activity.ComponentActivity.5
            public C03195() {
            }

            @Override // androidx.lifecycle.InterfaceC0794j
            /* renamed from: d */
            public void mo1925d(InterfaceC0796l interfaceC0796l, AbstractC0791h.b bVar) {
                ComponentActivity.this.m1908I();
                ComponentActivity.this.mo1915g().mo4950c(this);
            }
        });
        c13513cM81269a.m81271c();
        C0807w.m4997c(this);
        mo1909J().m81267h("android:support:activity-result", new C13512b.c() { // from class: androidx.activity.c
            @Override // p724w0.C13512b.c
            /* renamed from: a */
            public final Bundle mo1944a() {
                return this.f1109a.m1911M();
            }
        });
        m1906G(new InterfaceC1084b() { // from class: androidx.activity.d
            @Override // p023b.InterfaceC1084b
            /* renamed from: a */
            public final void mo1945a(Context context) {
                this.f1110a.m1912N(context);
            }
        });
    }

    /* renamed from: K */
    private void m1905K() {
        C0790g0.m4947a(getWindow().getDecorView(), this);
        C0792h0.m4955a(getWindow().getDecorView(), this);
        C13515e.m81275a(getWindow().getDecorView(), this);
        C0338l.m1954a(getWindow().getDecorView(), this);
    }

    /* renamed from: G */
    public final void m1906G(InterfaceC1084b interfaceC1084b) {
        this.f1065c.m6458a(interfaceC1084b);
    }

    /* renamed from: H */
    public final void m1907H(InterfaceC9366a<Intent> interfaceC9366a) {
        this.f1077o.add(interfaceC9366a);
    }

    /* renamed from: I */
    public void m1908I() {
        if (this.f1069g == null) {
            C0324e c0324e = (C0324e) getLastNonConfigurationInstance();
            if (c0324e != null) {
                this.f1069g = c0324e.f1088b;
            }
            if (this.f1069g == null) {
                this.f1069g = new C0786e0();
            }
        }
    }

    @Override // p724w0.InterfaceC13514d
    /* renamed from: J */
    public final C13512b mo1909J() {
        return this.f1068f.m81270b();
    }

    /* renamed from: L */
    public void m1910L() {
        invalidateOptionsMenu();
    }

    /* renamed from: M */
    public final /* synthetic */ Bundle m1911M() {
        Bundle bundle = new Bundle();
        this.f1074l.m1969f(bundle);
        return bundle;
    }

    /* renamed from: N */
    public final /* synthetic */ void m1912N(Context context) {
        Bundle bundleM81262b = mo1909J().m81262b("android:support:activity-result");
        if (bundleM81262b != null) {
            this.f1074l.m1968e(bundleM81262b);
        }
    }

    @Deprecated
    /* renamed from: O */
    public Object m1913O() {
        return null;
    }

    @Override // android.app.Activity
    public void addContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams layoutParams) {
        m1905K();
        super.addContentView(view, layoutParams);
    }

    @Override // androidx.core.content.OnConfigurationChangedProvider
    public final void addOnConfigurationChangedListener(InterfaceC9366a<Configuration> interfaceC9366a) {
        this.f1075m.add(interfaceC9366a);
    }

    @Override // androidx.core.content.OnTrimMemoryProvider
    public final void addOnTrimMemoryListener(InterfaceC9366a<Integer> interfaceC9366a) {
        this.f1076n.add(interfaceC9366a);
    }

    @Override // p273f0.InterfaceC9622r
    /* renamed from: c */
    public void mo1914c(InterfaceC9628u interfaceC9628u) {
        this.f1066d.m60139a(interfaceC9628u);
    }

    @Override // androidx.core.app.ComponentActivity, androidx.lifecycle.InterfaceC0796l
    /* renamed from: g */
    public AbstractC0791h mo1915g() {
        return this.f1067e;
    }

    @Override // androidx.lifecycle.InterfaceC0788f0
    public C0786e0 getViewModelStore() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        m1908I();
        return this.f1069g;
    }

    @Override // androidx.activity.InterfaceC0337k
    /* renamed from: h */
    public final OnBackPressedDispatcher mo1916h() {
        return this.f1071i;
    }

    @Override // androidx.lifecycle.InterfaceC0789g
    /* renamed from: i */
    public C0782c0.b mo1917i() {
        if (this.f1070h == null) {
            this.f1070h = new C0810z(getApplication(), this, getIntent() != null ? getIntent().getExtras() : null);
        }
        return this.f1070h;
    }

    @Override // androidx.lifecycle.InterfaceC0789g
    /* renamed from: j */
    public AbstractC12450a mo1918j() {
        C12453d c12453d = new C12453d();
        if (getApplication() != null) {
            c12453d.m74708c(C0782c0.a.f4155h, getApplication());
        }
        c12453d.m74708c(C0807w.f4207a, this);
        c12453d.m74708c(C0807w.f4208b, this);
        if (getIntent() != null && getIntent().getExtras() != null) {
            c12453d.m74708c(C0807w.f4209c, getIntent().getExtras());
        }
        return c12453d;
    }

    @Override // androidx.activity.result.InterfaceC0344d
    /* renamed from: k */
    public final AbstractC0343c mo1919k() {
        return this.f1074l;
    }

    @Override // p694v.InterfaceC13307i
    /* renamed from: m */
    public final void mo1920m(InterfaceC9366a<C13301c> interfaceC9366a) {
        this.f1078p.add(interfaceC9366a);
    }

    @Override // p694v.InterfaceC13308j
    /* renamed from: o */
    public final void mo1921o(InterfaceC9366a<C13309k> interfaceC9366a) {
        this.f1079q.add(interfaceC9366a);
    }

    @Override // android.app.Activity
    @Deprecated
    public void onActivityResult(int i10, int i11, Intent intent) {
        if (this.f1074l.m1965b(i10, i11, intent)) {
            return;
        }
        super.onActivityResult(i10, i11, intent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.f1071i.m1938f();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Iterator<InterfaceC9366a<Configuration>> it = this.f1075m.iterator();
        while (it.hasNext()) {
            it.next().accept(configuration);
        }
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.f1068f.m81272d(bundle);
        this.f1065c.m6460c(this);
        super.onCreate(bundle);
        ReportFragment.m4903f(this);
        if (C1085a.m6463c()) {
            this.f1071i.m1939g(C0323d.m1927a(this));
        }
        int i10 = this.f1072j;
        if (i10 != 0) {
            setContentView(i10);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i10, Menu menu) {
        if (i10 != 0) {
            return true;
        }
        super.onCreatePanelMenu(i10, menu);
        this.f1066d.m60140b(menu, getMenuInflater());
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i10, MenuItem menuItem) {
        if (super.onMenuItemSelected(i10, menuItem)) {
            return true;
        }
        if (i10 == 0) {
            return this.f1066d.m60142d(menuItem);
        }
        return false;
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z10) {
        if (this.f1080r) {
            return;
        }
        Iterator<InterfaceC9366a<C13301c>> it = this.f1078p.iterator();
        while (it.hasNext()) {
            it.next().accept(new C13301c(z10));
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(@SuppressLint({"UnknownNullness", "MissingNullability"}) Intent intent) {
        super.onNewIntent(intent);
        Iterator<InterfaceC9366a<Intent>> it = this.f1077o.iterator();
        while (it.hasNext()) {
            it.next().accept(intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i10, Menu menu) {
        this.f1066d.m60141c(menu);
        super.onPanelClosed(i10, menu);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z10) {
        if (this.f1081s) {
            return;
        }
        Iterator<InterfaceC9366a<C13309k>> it = this.f1079q.iterator();
        while (it.hasNext()) {
            it.next().accept(new C13309k(z10));
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i10, View view, Menu menu) {
        if (i10 != 0) {
            return true;
        }
        super.onPreparePanel(i10, view, menu);
        this.f1066d.m60143e(menu);
        return true;
    }

    @Override // android.app.Activity
    @Deprecated
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        if (this.f1074l.m1965b(i10, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr))) {
            return;
        }
        super.onRequestPermissionsResult(i10, strArr, iArr);
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        C0324e c0324e;
        Object objM1913O = m1913O();
        C0786e0 c0786e0 = this.f1069g;
        if (c0786e0 == null && (c0324e = (C0324e) getLastNonConfigurationInstance()) != null) {
            c0786e0 = c0324e.f1088b;
        }
        if (c0786e0 == null && objM1913O == null) {
            return null;
        }
        C0324e c0324e2 = new C0324e();
        c0324e2.f1087a = objM1913O;
        c0324e2.f1088b = c0786e0;
        return c0324e2;
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        AbstractC0791h abstractC0791hMo1915g = mo1915g();
        if (abstractC0791hMo1915g instanceof C0797m) {
            ((C0797m) abstractC0791hMo1915g).m4968o(AbstractC0791h.c.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.f1068f.m81273e(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i10) {
        super.onTrimMemory(i10);
        Iterator<InterfaceC9366a<Integer>> it = this.f1076n.iterator();
        while (it.hasNext()) {
            it.next().accept(Integer.valueOf(i10));
        }
    }

    @Override // p694v.InterfaceC13308j
    /* renamed from: r */
    public final void mo1922r(InterfaceC9366a<C13309k> interfaceC9366a) {
        this.f1079q.remove(interfaceC9366a);
    }

    @Override // androidx.core.content.OnConfigurationChangedProvider
    public final void removeOnConfigurationChangedListener(InterfaceC9366a<Configuration> interfaceC9366a) {
        this.f1075m.remove(interfaceC9366a);
    }

    @Override // androidx.core.content.OnTrimMemoryProvider
    public final void removeOnTrimMemoryListener(InterfaceC9366a<Integer> interfaceC9366a) {
        this.f1076n.remove(interfaceC9366a);
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        try {
            if (C14060a.m84268d()) {
                C14060a.m84265a("reportFullyDrawn() for ComponentActivity");
            }
            super.reportFullyDrawn();
            C14060a.m84266b();
        } catch (Throwable th2) {
            C14060a.m84266b();
            throw th2;
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i10) {
        m1905K();
        super.setContentView(i10);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(Intent intent, int i10) {
        super.startActivityForResult(intent, i10);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i10, Intent intent, int i11, int i12, int i13) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i10, intent, i11, i12, i13);
    }

    @Override // p273f0.InterfaceC9622r
    /* renamed from: t */
    public void mo1923t(InterfaceC9628u interfaceC9628u) {
        this.f1066d.m60144f(interfaceC9628u);
    }

    @Override // p694v.InterfaceC13307i
    /* renamed from: w */
    public final void mo1924w(InterfaceC9366a<C13301c> interfaceC9366a) {
        this.f1078p.remove(interfaceC9366a);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(Intent intent, int i10, Bundle bundle) {
        super.startActivityForResult(intent, i10, bundle);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i10, Intent intent, int i11, int i12, int i13, Bundle bundle) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i10, intent, i11, i12, i13, bundle);
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view) {
        m1905K();
        super.setContentView(view);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z10, Configuration configuration) {
        this.f1080r = true;
        try {
            super.onMultiWindowModeChanged(z10, configuration);
            this.f1080r = false;
            Iterator<InterfaceC9366a<C13301c>> it = this.f1078p.iterator();
            while (it.hasNext()) {
                it.next().accept(new C13301c(z10, configuration));
            }
        } catch (Throwable th2) {
            this.f1080r = false;
            throw th2;
        }
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z10, Configuration configuration) {
        this.f1081s = true;
        try {
            super.onPictureInPictureModeChanged(z10, configuration);
            this.f1081s = false;
            Iterator<InterfaceC9366a<C13309k>> it = this.f1079q.iterator();
            while (it.hasNext()) {
                it.next().accept(new C13309k(z10, configuration));
            }
        } catch (Throwable th2) {
            this.f1081s = false;
            throw th2;
        }
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams layoutParams) {
        m1905K();
        super.setContentView(view, layoutParams);
    }
}
