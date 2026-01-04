package androidx.fragment.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.InterfaceC0337k;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.AbstractC0343c;
import androidx.activity.result.InterfaceC0344d;
import androidx.core.content.OnConfigurationChangedProvider;
import androidx.core.content.OnTrimMemoryProvider;
import androidx.lifecycle.AbstractC0791h;
import androidx.lifecycle.C0786e0;
import androidx.lifecycle.C0797m;
import androidx.lifecycle.InterfaceC0788f0;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import p023b.InterfaceC1084b;
import p243e0.InterfaceC9366a;
import p273f0.InterfaceC9622r;
import p273f0.InterfaceC9628u;
import p628s0.AbstractC12660a;
import p694v.C13299a;
import p694v.C13301c;
import p694v.C13309k;
import p694v.InterfaceC13307i;
import p694v.InterfaceC13308j;
import p724w0.C13512b;
import p724w0.InterfaceC13514d;

/* loaded from: classes.dex */
public class FragmentActivity extends ComponentActivity implements C13299a.c {

    /* renamed from: v */
    public boolean f3779v;

    /* renamed from: w */
    public boolean f3780w;

    /* renamed from: t */
    public final C0752j f3777t = C0752j.m4780b(new C0713a());

    /* renamed from: u */
    public final C0797m f3778u = new C0797m(this);

    /* renamed from: x */
    public boolean f3781x = true;

    /* renamed from: androidx.fragment.app.FragmentActivity$a */
    public class C0713a extends AbstractC0754l<FragmentActivity> implements OnConfigurationChangedProvider, OnTrimMemoryProvider, InterfaceC13307i, InterfaceC13308j, InterfaceC0788f0, InterfaceC0337k, InterfaceC0344d, InterfaceC13514d, InterfaceC0764v, InterfaceC9622r {
        public C0713a() {
            super(FragmentActivity.this);
        }

        @Override // p724w0.InterfaceC13514d
        /* renamed from: J */
        public C13512b mo1909J() {
            return FragmentActivity.this.mo1909J();
        }

        @Override // androidx.fragment.app.InterfaceC0764v
        /* renamed from: a */
        public void mo4482a(FragmentManager fragmentManager, Fragment fragment) {
            FragmentActivity.this.m4479c0(fragment);
        }

        @Override // androidx.core.content.OnConfigurationChangedProvider
        public void addOnConfigurationChangedListener(InterfaceC9366a<Configuration> interfaceC9366a) {
            FragmentActivity.this.addOnConfigurationChangedListener(interfaceC9366a);
        }

        @Override // androidx.core.content.OnTrimMemoryProvider
        public void addOnTrimMemoryListener(InterfaceC9366a<Integer> interfaceC9366a) {
            FragmentActivity.this.addOnTrimMemoryListener(interfaceC9366a);
        }

        @Override // p273f0.InterfaceC9622r
        /* renamed from: c */
        public void mo1914c(InterfaceC9628u interfaceC9628u) {
            FragmentActivity.this.mo1914c(interfaceC9628u);
        }

        @Override // androidx.fragment.app.AbstractC0754l, androidx.fragment.app.AbstractC0750i
        /* renamed from: d */
        public View mo4463d(int i10) {
            return FragmentActivity.this.findViewById(i10);
        }

        @Override // androidx.fragment.app.AbstractC0754l, androidx.fragment.app.AbstractC0750i
        /* renamed from: e */
        public boolean mo4464e() {
            Window window = FragmentActivity.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        @Override // androidx.lifecycle.InterfaceC0796l
        /* renamed from: g */
        public AbstractC0791h mo1915g() {
            return FragmentActivity.this.f3778u;
        }

        @Override // androidx.lifecycle.InterfaceC0788f0
        public C0786e0 getViewModelStore() {
            return FragmentActivity.this.getViewModelStore();
        }

        @Override // androidx.activity.InterfaceC0337k
        /* renamed from: h */
        public OnBackPressedDispatcher mo1916h() {
            return FragmentActivity.this.mo1916h();
        }

        @Override // androidx.activity.result.InterfaceC0344d
        /* renamed from: k */
        public AbstractC0343c mo1919k() {
            return FragmentActivity.this.mo1919k();
        }

        @Override // androidx.fragment.app.AbstractC0754l
        /* renamed from: l */
        public void mo4483l(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            FragmentActivity.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        @Override // p694v.InterfaceC13307i
        /* renamed from: m */
        public void mo1920m(InterfaceC9366a<C13301c> interfaceC9366a) {
            FragmentActivity.this.mo1920m(interfaceC9366a);
        }

        @Override // p694v.InterfaceC13308j
        /* renamed from: o */
        public void mo1921o(InterfaceC9366a<C13309k> interfaceC9366a) {
            FragmentActivity.this.mo1921o(interfaceC9366a);
        }

        @Override // androidx.fragment.app.AbstractC0754l
        /* renamed from: p */
        public LayoutInflater mo4485p() {
            return FragmentActivity.this.getLayoutInflater().cloneInContext(FragmentActivity.this);
        }

        @Override // androidx.fragment.app.AbstractC0754l
        /* renamed from: q */
        public void mo4486q() {
            m4487s();
        }

        @Override // p694v.InterfaceC13308j
        /* renamed from: r */
        public void mo1922r(InterfaceC9366a<C13309k> interfaceC9366a) {
            FragmentActivity.this.mo1922r(interfaceC9366a);
        }

        @Override // androidx.core.content.OnConfigurationChangedProvider
        public void removeOnConfigurationChangedListener(InterfaceC9366a<Configuration> interfaceC9366a) {
            FragmentActivity.this.removeOnConfigurationChangedListener(interfaceC9366a);
        }

        @Override // androidx.core.content.OnTrimMemoryProvider
        public void removeOnTrimMemoryListener(InterfaceC9366a<Integer> interfaceC9366a) {
            FragmentActivity.this.removeOnTrimMemoryListener(interfaceC9366a);
        }

        /* renamed from: s */
        public void m4487s() {
            FragmentActivity.this.invalidateOptionsMenu();
        }

        @Override // p273f0.InterfaceC9622r
        /* renamed from: t */
        public void mo1923t(InterfaceC9628u interfaceC9628u) {
            FragmentActivity.this.mo1923t(interfaceC9628u);
        }

        @Override // androidx.fragment.app.AbstractC0754l
        /* renamed from: u */
        public FragmentActivity mo4484n() {
            return FragmentActivity.this;
        }

        @Override // p694v.InterfaceC13307i
        /* renamed from: w */
        public void mo1924w(InterfaceC9366a<C13301c> interfaceC9366a) {
            FragmentActivity.this.mo1924w(interfaceC9366a);
        }
    }

    public FragmentActivity() {
        m4470V();
    }

    /* renamed from: V */
    private void m4470V() {
        mo1909J().m81267h("android:support:lifecycle", new C13512b.c() { // from class: androidx.fragment.app.d
            @Override // p724w0.C13512b.c
            /* renamed from: a */
            public final Bundle mo1944a() {
                return this.f4004a.m4474W();
            }
        });
        addOnConfigurationChangedListener(new InterfaceC9366a() { // from class: androidx.fragment.app.e
            @Override // p243e0.InterfaceC9366a
            public final void accept(Object obj) {
                this.f4011a.m4475X((Configuration) obj);
            }
        });
        m1907H(new InterfaceC9366a() { // from class: androidx.fragment.app.f
            @Override // p243e0.InterfaceC9366a
            public final void accept(Object obj) {
                this.f4017a.m4476Y((Intent) obj);
            }
        });
        m1906G(new InterfaceC1084b() { // from class: androidx.fragment.app.g
            @Override // p023b.InterfaceC1084b
            /* renamed from: a */
            public final void mo1945a(Context context) {
                this.f4020a.m4477Z(context);
            }
        });
    }

    /* renamed from: b0 */
    public static boolean m4471b0(FragmentManager fragmentManager, AbstractC0791h.c cVar) {
        boolean zM4471b0 = false;
        for (Fragment fragment : fragmentManager.m4604u0()) {
            if (fragment != null) {
                if (fragment.m4453y() != null) {
                    zM4471b0 |= m4471b0(fragment.m4423o(), cVar);
                }
                C0743e0 c0743e0 = fragment.f3715T;
                if (c0743e0 != null && c0743e0.mo1915g().mo4949b().m4954b(AbstractC0791h.c.STARTED)) {
                    fragment.f3715T.m4741f(cVar);
                    zM4471b0 = true;
                }
                if (fragment.f3714S.mo4949b().m4954b(AbstractC0791h.c.STARTED)) {
                    fragment.f3714S.m4968o(cVar);
                    zM4471b0 = true;
                }
            }
        }
        return zM4471b0;
    }

    /* renamed from: T */
    public final View m4472T(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f3777t.m4793n(view, str, context, attributeSet);
    }

    /* renamed from: U */
    public FragmentManager m4473U() {
        return this.f3777t.m4791l();
    }

    /* renamed from: W */
    public final /* synthetic */ Bundle m4474W() {
        m4478a0();
        this.f3778u.m4962h(AbstractC0791h.b.ON_STOP);
        return new Bundle();
    }

    /* renamed from: X */
    public final /* synthetic */ void m4475X(Configuration configuration) {
        this.f3777t.m4792m();
    }

    /* renamed from: Y */
    public final /* synthetic */ void m4476Y(Intent intent) {
        this.f3777t.m4792m();
    }

    /* renamed from: Z */
    public final /* synthetic */ void m4477Z(Context context) {
        this.f3777t.m4781a(null);
    }

    /* renamed from: a0 */
    public void m4478a0() {
        while (m4471b0(m4473U(), AbstractC0791h.c.CREATED)) {
        }
    }

    @Deprecated
    /* renamed from: c0 */
    public void m4479c0(Fragment fragment) {
    }

    @Override // p694v.C13299a.c
    @Deprecated
    /* renamed from: d */
    public final void mo4480d(int i10) {
    }

    /* renamed from: d0 */
    public void m4481d0() {
        this.f3778u.m4962h(AbstractC0791h.b.ON_RESUME);
        this.f3777t.m4787h();
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        if (m3778B(strArr)) {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            String str2 = str + "  ";
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.f3779v);
            printWriter.print(" mResumed=");
            printWriter.print(this.f3780w);
            printWriter.print(" mStopped=");
            printWriter.print(this.f3781x);
            if (getApplication() != null) {
                AbstractC12660a.m76204b(this).mo76205a(str2, fileDescriptor, printWriter, strArr);
            }
            this.f3777t.m4791l().m4547W(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        this.f3777t.m4792m();
        super.onActivityResult(i10, i11, intent);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3778u.m4962h(AbstractC0791h.b.ON_CREATE);
        this.f3777t.m4784e();
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View viewM4472T = m4472T(view, str, context, attributeSet);
        return viewM4472T == null ? super.onCreateView(view, str, context, attributeSet) : viewM4472T;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f3777t.m4785f();
        this.f3778u.m4962h(AbstractC0791h.b.ON_DESTROY);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i10, MenuItem menuItem) {
        if (super.onMenuItemSelected(i10, menuItem)) {
            return true;
        }
        if (i10 == 6) {
            return this.f3777t.m4783d(menuItem);
        }
        return false;
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.f3780w = false;
        this.f3777t.m4786g();
        this.f3778u.m4962h(AbstractC0791h.b.ON_PAUSE);
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        m4481d0();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        this.f3777t.m4792m();
        super.onRequestPermissionsResult(i10, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onResume() {
        this.f3777t.m4792m();
        super.onResume();
        this.f3780w = true;
        this.f3777t.m4790k();
    }

    @Override // android.app.Activity
    public void onStart() {
        this.f3777t.m4792m();
        super.onStart();
        this.f3781x = false;
        if (!this.f3779v) {
            this.f3779v = true;
            this.f3777t.m4782c();
        }
        this.f3777t.m4790k();
        this.f3778u.m4962h(AbstractC0791h.b.ON_START);
        this.f3777t.m4788i();
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.f3777t.m4792m();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.f3781x = true;
        m4478a0();
        this.f3777t.m4789j();
        this.f3778u.m4962h(AbstractC0791h.b.ON_STOP);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View viewM4472T = m4472T(null, str, context, attributeSet);
        return viewM4472T == null ? super.onCreateView(str, context, attributeSet) : viewM4472T;
    }
}
