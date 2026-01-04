package androidx.fragment.app;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.lifecycle.AbstractC0791h;
import androidx.lifecycle.C0782c0;
import androidx.lifecycle.C0786e0;
import androidx.lifecycle.C0790g0;
import androidx.lifecycle.C0792h0;
import androidx.lifecycle.C0797m;
import androidx.lifecycle.C0801q;
import androidx.lifecycle.C0807w;
import androidx.lifecycle.C0810z;
import androidx.lifecycle.InterfaceC0788f0;
import androidx.lifecycle.InterfaceC0789g;
import androidx.lifecycle.InterfaceC0794j;
import androidx.lifecycle.InterfaceC0796l;
import androidx.lifecycle.LiveData;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import p273f0.C9618p;
import p540p0.C12062c;
import p597r0.AbstractC12450a;
import p597r0.C12453d;
import p628s0.AbstractC12660a;
import p694v.AbstractC13311m;
import p724w0.C13512b;
import p724w0.C13513c;
import p724w0.C13515e;
import p724w0.InterfaceC13514d;

/* loaded from: classes.dex */
public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, InterfaceC0796l, InterfaceC0788f0, InterfaceC0789g, InterfaceC13514d {

    /* renamed from: b0 */
    public static final Object f3695b0 = new Object();

    /* renamed from: A */
    public boolean f3696A;

    /* renamed from: B */
    public boolean f3697B;

    /* renamed from: C */
    public boolean f3698C;

    /* renamed from: D */
    public boolean f3699D;

    /* renamed from: E */
    public boolean f3700E;

    /* renamed from: G */
    public boolean f3702G;

    /* renamed from: H */
    public ViewGroup f3703H;

    /* renamed from: I */
    public View f3704I;

    /* renamed from: J */
    public boolean f3705J;

    /* renamed from: L */
    public C0709f f3707L;

    /* renamed from: N */
    public boolean f3709N;

    /* renamed from: O */
    public LayoutInflater f3710O;

    /* renamed from: P */
    public boolean f3711P;

    /* renamed from: Q */
    public String f3712Q;

    /* renamed from: S */
    public C0797m f3714S;

    /* renamed from: T */
    public C0743e0 f3715T;

    /* renamed from: V */
    public C0782c0.b f3717V;

    /* renamed from: W */
    public C13513c f3718W;

    /* renamed from: X */
    public int f3719X;

    /* renamed from: b */
    public Bundle f3724b;

    /* renamed from: c */
    public SparseArray<Parcelable> f3725c;

    /* renamed from: d */
    public Bundle f3726d;

    /* renamed from: e */
    public Boolean f3727e;

    /* renamed from: g */
    public Bundle f3729g;

    /* renamed from: h */
    public Fragment f3730h;

    /* renamed from: j */
    public int f3732j;

    /* renamed from: l */
    public boolean f3734l;

    /* renamed from: m */
    public boolean f3735m;

    /* renamed from: n */
    public boolean f3736n;

    /* renamed from: o */
    public boolean f3737o;

    /* renamed from: p */
    public boolean f3738p;

    /* renamed from: q */
    public boolean f3739q;

    /* renamed from: r */
    public boolean f3740r;

    /* renamed from: s */
    public int f3741s;

    /* renamed from: t */
    public FragmentManager f3742t;

    /* renamed from: u */
    public AbstractC0754l<?> f3743u;

    /* renamed from: w */
    public Fragment f3745w;

    /* renamed from: x */
    public int f3746x;

    /* renamed from: y */
    public int f3747y;

    /* renamed from: z */
    public String f3748z;

    /* renamed from: a */
    public int f3722a = -1;

    /* renamed from: f */
    public String f3728f = UUID.randomUUID().toString();

    /* renamed from: i */
    public String f3731i = null;

    /* renamed from: k */
    public Boolean f3733k = null;

    /* renamed from: v */
    public FragmentManager f3744v = new C0762t();

    /* renamed from: F */
    public boolean f3701F = true;

    /* renamed from: K */
    public boolean f3706K = true;

    /* renamed from: M */
    public Runnable f3708M = new RunnableC0704a();

    /* renamed from: R */
    public AbstractC0791h.c f3713R = AbstractC0791h.c.RESUMED;

    /* renamed from: U */
    public C0801q<InterfaceC0796l> f3716U = new C0801q<>();

    /* renamed from: Y */
    public final AtomicInteger f3720Y = new AtomicInteger();

    /* renamed from: Z */
    public final ArrayList<AbstractC0712i> f3721Z = new ArrayList<>();

    /* renamed from: a0 */
    public final AbstractC0712i f3723a0 = new C0705b();

    /* renamed from: androidx.fragment.app.Fragment$6 */
    public class C07026 implements InterfaceC0794j {
        public C07026() {
        }

        @Override // androidx.lifecycle.InterfaceC0794j
        /* renamed from: d */
        public void mo1925d(InterfaceC0796l interfaceC0796l, AbstractC0791h.b bVar) {
            View view;
            if (bVar != AbstractC0791h.b.ON_STOP || (view = Fragment.this.f3704I) == null) {
                return;
            }
            C0710g.m4465a(view);
        }
    }

    /* renamed from: androidx.fragment.app.Fragment$a */
    public class RunnableC0704a implements Runnable {
        public RunnableC0704a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Fragment.this.m4338B1();
        }
    }

    /* renamed from: androidx.fragment.app.Fragment$b */
    public class C0705b extends AbstractC0712i {
        public C0705b() {
            super(null);
        }

        @Override // androidx.fragment.app.Fragment.AbstractC0712i
        /* renamed from: a */
        public void mo4462a() {
            Fragment.this.f3718W.m81271c();
            C0807w.m4997c(Fragment.this);
        }
    }

    /* renamed from: androidx.fragment.app.Fragment$c */
    public class RunnableC0706c implements Runnable {
        public RunnableC0706c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Fragment.this.m4385a(false);
        }
    }

    /* renamed from: androidx.fragment.app.Fragment$d */
    public class RunnableC0707d implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ AbstractC0747g0 f3754a;

        public RunnableC0707d(AbstractC0747g0 abstractC0747g0) {
            this.f3754a = abstractC0747g0;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f3754a.m4750g();
        }
    }

    /* renamed from: androidx.fragment.app.Fragment$e */
    public class C0708e extends AbstractC0750i {
        public C0708e() {
        }

        @Override // androidx.fragment.app.AbstractC0750i
        /* renamed from: d */
        public View mo4463d(int i10) {
            View view = Fragment.this.f3704I;
            if (view != null) {
                return view.findViewById(i10);
            }
            throw new IllegalStateException("Fragment " + Fragment.this + " does not have a view");
        }

        @Override // androidx.fragment.app.AbstractC0750i
        /* renamed from: e */
        public boolean mo4464e() {
            return Fragment.this.f3704I != null;
        }
    }

    /* renamed from: androidx.fragment.app.Fragment$f */
    public static class C0709f {

        /* renamed from: a */
        public View f3757a;

        /* renamed from: b */
        public boolean f3758b;

        /* renamed from: c */
        public int f3759c;

        /* renamed from: d */
        public int f3760d;

        /* renamed from: e */
        public int f3761e;

        /* renamed from: f */
        public int f3762f;

        /* renamed from: g */
        public int f3763g;

        /* renamed from: h */
        public ArrayList<String> f3764h;

        /* renamed from: i */
        public ArrayList<String> f3765i;

        /* renamed from: j */
        public Object f3766j = null;

        /* renamed from: k */
        public Object f3767k;

        /* renamed from: l */
        public Object f3768l;

        /* renamed from: m */
        public Object f3769m;

        /* renamed from: n */
        public Object f3770n;

        /* renamed from: o */
        public Object f3771o;

        /* renamed from: p */
        public Boolean f3772p;

        /* renamed from: q */
        public Boolean f3773q;

        /* renamed from: r */
        public float f3774r;

        /* renamed from: s */
        public View f3775s;

        /* renamed from: t */
        public boolean f3776t;

        public C0709f() {
            Object obj = Fragment.f3695b0;
            this.f3767k = obj;
            this.f3768l = null;
            this.f3769m = obj;
            this.f3770n = null;
            this.f3771o = obj;
            this.f3774r = 1.0f;
            this.f3775s = null;
        }
    }

    /* renamed from: androidx.fragment.app.Fragment$g */
    public static class C0710g {
        /* renamed from: a */
        public static void m4465a(View view) {
            view.cancelPendingInputEvents();
        }
    }

    /* renamed from: androidx.fragment.app.Fragment$h */
    public static class C0711h extends RuntimeException {
        public C0711h(String str, Exception exc) {
            super(str, exc);
        }
    }

    /* renamed from: androidx.fragment.app.Fragment$i */
    public static abstract class AbstractC0712i {
        public AbstractC0712i() {
        }

        /* renamed from: a */
        public abstract void mo4462a();

        public /* synthetic */ AbstractC0712i(RunnableC0704a runnableC0704a) {
            this();
        }
    }

    public Fragment() {
        m4374U();
    }

    @Deprecated
    /* renamed from: W */
    public static Fragment m4332W(Context context, String str, Bundle bundle) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        try {
            Fragment fragmentNewInstance = C0753k.m4796d(context.getClassLoader(), str).getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle != null) {
                bundle.setClassLoader(fragmentNewInstance.getClass().getClassLoader());
                fragmentNewInstance.m4437s1(bundle);
            }
            return fragmentNewInstance;
        } catch (IllegalAccessException e10) {
            throw new C0711h("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e10);
        } catch (InstantiationException e11) {
            throw new C0711h("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e11);
        } catch (NoSuchMethodException e12) {
            throw new C0711h("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e12);
        } catch (InvocationTargetException e13) {
            throw new C0711h("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e13);
        }
    }

    /* renamed from: A */
    public final int m4333A() {
        AbstractC0791h.c cVar = this.f3713R;
        return (cVar == AbstractC0791h.c.INITIALIZED || this.f3745w == null) ? cVar.ordinal() : Math.min(cVar.ordinal(), this.f3745w.m4333A());
    }

    @Deprecated
    /* renamed from: A0 */
    public void m4334A0(Menu menu) {
    }

    @Deprecated
    /* renamed from: A1 */
    public void m4335A1(boolean z10) {
        C12062c.m72210i(this, z10);
        if (!this.f3706K && z10 && this.f3722a < 5 && this.f3742t != null && m4379X() && this.f3711P) {
            FragmentManager fragmentManager = this.f3742t;
            fragmentManager.m4552Y0(fragmentManager.m4606v(this));
        }
        this.f3706K = z10;
        this.f3705J = this.f3722a < 5 && !z10;
        if (this.f3724b != null) {
            this.f3727e = Boolean.valueOf(z10);
        }
    }

    /* renamed from: B */
    public int m4336B() {
        C0709f c0709f = this.f3707L;
        if (c0709f == null) {
            return 0;
        }
        return c0709f.f3763g;
    }

    /* renamed from: B0 */
    public void m4337B0() {
        this.f3702G = true;
    }

    /* renamed from: B1 */
    public void m4338B1() {
        if (this.f3707L == null || !m4394d().f3776t) {
            return;
        }
        if (this.f3743u == null) {
            m4394d().f3776t = false;
        } else if (Looper.myLooper() != this.f3743u.m4799j().getLooper()) {
            this.f3743u.m4799j().postAtFrontOfQueue(new RunnableC0706c());
        } else {
            m4385a(true);
        }
    }

    /* renamed from: C */
    public final Fragment m4339C() {
        return this.f3745w;
    }

    /* renamed from: C0 */
    public void m4340C0(boolean z10) {
    }

    /* renamed from: D */
    public final FragmentManager m4341D() {
        FragmentManager fragmentManager = this.f3742t;
        if (fragmentManager != null) {
            return fragmentManager;
        }
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    @Deprecated
    /* renamed from: D0 */
    public void m4342D0(Menu menu) {
    }

    /* renamed from: E */
    public boolean m4343E() {
        C0709f c0709f = this.f3707L;
        if (c0709f == null) {
            return false;
        }
        return c0709f.f3758b;
    }

    /* renamed from: E0 */
    public void m4344E0(boolean z10) {
    }

    /* renamed from: F */
    public int m4345F() {
        C0709f c0709f = this.f3707L;
        if (c0709f == null) {
            return 0;
        }
        return c0709f.f3761e;
    }

    @Deprecated
    /* renamed from: F0 */
    public void m4346F0(int i10, String[] strArr, int[] iArr) {
    }

    /* renamed from: G */
    public int m4347G() {
        C0709f c0709f = this.f3707L;
        if (c0709f == null) {
            return 0;
        }
        return c0709f.f3762f;
    }

    /* renamed from: G0 */
    public void mo4348G0() {
        this.f3702G = true;
    }

    /* renamed from: H */
    public float m4349H() {
        C0709f c0709f = this.f3707L;
        if (c0709f == null) {
            return 1.0f;
        }
        return c0709f.f3774r;
    }

    /* renamed from: H0 */
    public void mo4350H0(Bundle bundle) {
    }

    /* renamed from: I */
    public Object m4351I() {
        C0709f c0709f = this.f3707L;
        if (c0709f == null) {
            return null;
        }
        Object obj = c0709f.f3769m;
        return obj == f3695b0 ? m4441u() : obj;
    }

    /* renamed from: I0 */
    public void mo4352I0() {
        this.f3702G = true;
    }

    @Override // p724w0.InterfaceC13514d
    /* renamed from: J */
    public final C13512b mo1909J() {
        return this.f3718W.m81270b();
    }

    /* renamed from: J0 */
    public void mo4353J0() {
        this.f3702G = true;
    }

    /* renamed from: K */
    public final Resources m4354K() {
        return m4419m1().getResources();
    }

    /* renamed from: K0 */
    public void m4355K0(View view, Bundle bundle) {
    }

    /* renamed from: L */
    public Object m4356L() {
        C0709f c0709f = this.f3707L;
        if (c0709f == null) {
            return null;
        }
        Object obj = c0709f.f3767k;
        return obj == f3695b0 ? m4432r() : obj;
    }

    /* renamed from: L0 */
    public void mo4357L0(Bundle bundle) {
        this.f3702G = true;
    }

    /* renamed from: M */
    public Object m4358M() {
        C0709f c0709f = this.f3707L;
        if (c0709f == null) {
            return null;
        }
        return c0709f.f3770n;
    }

    /* renamed from: M0 */
    public void m4359M0(Bundle bundle) {
        this.f3744v.m4548W0();
        this.f3722a = 3;
        this.f3702G = false;
        mo4401f0(bundle);
        if (this.f3702G) {
            m4428p1();
            this.f3744v.m4610x();
        } else {
            throw new C0751i0("Fragment " + this + " did not call through to super.onActivityCreated()");
        }
    }

    /* renamed from: N */
    public Object m4360N() {
        C0709f c0709f = this.f3707L;
        if (c0709f == null) {
            return null;
        }
        Object obj = c0709f.f3771o;
        return obj == f3695b0 ? m4358M() : obj;
    }

    /* renamed from: N0 */
    public void m4361N0() {
        Iterator<AbstractC0712i> it = this.f3721Z.iterator();
        while (it.hasNext()) {
            it.next().mo4462a();
        }
        this.f3721Z.clear();
        this.f3744v.m4579m(this.f3743u, mo4388b(), this);
        this.f3722a = 0;
        this.f3702G = false;
        mo4407i0(this.f3743u.m4798i());
        if (this.f3702G) {
            this.f3742t.m4518H(this);
            this.f3744v.m4612y();
        } else {
            throw new C0751i0("Fragment " + this + " did not call through to super.onAttach()");
        }
    }

    /* renamed from: O */
    public ArrayList<String> m4362O() {
        ArrayList<String> arrayList;
        C0709f c0709f = this.f3707L;
        return (c0709f == null || (arrayList = c0709f.f3764h) == null) ? new ArrayList<>() : arrayList;
    }

    /* renamed from: O0 */
    public void m4363O0(Configuration configuration) {
        onConfigurationChanged(configuration);
    }

    /* renamed from: P */
    public ArrayList<String> m4364P() {
        ArrayList<String> arrayList;
        C0709f c0709f = this.f3707L;
        return (c0709f == null || (arrayList = c0709f.f3765i) == null) ? new ArrayList<>() : arrayList;
    }

    /* renamed from: P0 */
    public boolean m4365P0(MenuItem menuItem) {
        if (this.f3696A) {
            return false;
        }
        if (m4412k0(menuItem)) {
            return true;
        }
        return this.f3744v.m4505A(menuItem);
    }

    /* renamed from: Q */
    public final String m4366Q(int i10) {
        return m4354K().getString(i10);
    }

    /* renamed from: Q0 */
    public void m4367Q0(Bundle bundle) {
        this.f3744v.m4548W0();
        this.f3722a = 1;
        this.f3702G = false;
        this.f3714S.mo4948a(new InterfaceC0794j() { // from class: androidx.fragment.app.Fragment.6
            public C07026() {
            }

            @Override // androidx.lifecycle.InterfaceC0794j
            /* renamed from: d */
            public void mo1925d(InterfaceC0796l interfaceC0796l, AbstractC0791h.b bVar) {
                View view;
                if (bVar != AbstractC0791h.b.ON_STOP || (view = Fragment.this.f3704I) == null) {
                    return;
                }
                C0710g.m4465a(view);
            }
        });
        this.f3718W.m81272d(bundle);
        mo4415l0(bundle);
        this.f3711P = true;
        if (this.f3702G) {
            this.f3714S.m4962h(AbstractC0791h.b.ON_CREATE);
            return;
        }
        throw new C0751i0("Fragment " + this + " did not call through to super.onCreate()");
    }

    /* renamed from: R */
    public final Fragment m4368R(boolean z10) {
        String str;
        if (z10) {
            C12062c.m72209h(this);
        }
        Fragment fragment = this.f3730h;
        if (fragment != null) {
            return fragment;
        }
        FragmentManager fragmentManager = this.f3742t;
        if (fragmentManager == null || (str = this.f3731i) == null) {
            return null;
        }
        return fragmentManager.m4564f0(str);
    }

    /* renamed from: R0 */
    public boolean m4369R0(Menu menu, MenuInflater menuInflater) {
        boolean z10 = false;
        if (this.f3696A) {
            return false;
        }
        if (this.f3700E && this.f3701F) {
            m4424o0(menu, menuInflater);
            z10 = true;
        }
        return z10 | this.f3744v.m4509C(menu, menuInflater);
    }

    /* renamed from: S */
    public View m4370S() {
        return this.f3704I;
    }

    /* renamed from: S0 */
    public void mo4371S0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f3744v.m4548W0();
        this.f3740r = true;
        this.f3715T = new C0743e0(this, getViewModelStore());
        View viewMo4427p0 = mo4427p0(layoutInflater, viewGroup, bundle);
        this.f3704I = viewMo4427p0;
        if (viewMo4427p0 == null) {
            if (this.f3715T.m4738c()) {
                throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
            }
            this.f3715T = null;
        } else {
            this.f3715T.m4737b();
            C0790g0.m4947a(this.f3704I, this.f3715T);
            C0792h0.m4955a(this.f3704I, this.f3715T);
            C13515e.m81275a(this.f3704I, this.f3715T);
            this.f3716U.mo4896n(this.f3715T);
        }
    }

    /* renamed from: T */
    public LiveData<InterfaceC0796l> m4372T() {
        return this.f3716U;
    }

    /* renamed from: T0 */
    public void m4373T0() {
        this.f3744v.m4510D();
        this.f3714S.m4962h(AbstractC0791h.b.ON_DESTROY);
        this.f3722a = 0;
        this.f3702G = false;
        this.f3711P = false;
        mo4430q0();
        if (this.f3702G) {
            return;
        }
        throw new C0751i0("Fragment " + this + " did not call through to super.onDestroy()");
    }

    /* renamed from: U */
    public final void m4374U() {
        this.f3714S = new C0797m(this);
        this.f3718W = C13513c.m81269a(this);
        this.f3717V = null;
        if (this.f3721Z.contains(this.f3723a0)) {
            return;
        }
        m4413k1(this.f3723a0);
    }

    /* renamed from: U0 */
    public void m4375U0() {
        this.f3744v.m4512E();
        if (this.f3704I != null && this.f3715T.mo1915g().mo4949b().m4954b(AbstractC0791h.c.CREATED)) {
            this.f3715T.m4736a(AbstractC0791h.b.ON_DESTROY);
        }
        this.f3722a = 1;
        this.f3702G = false;
        mo4436s0();
        if (this.f3702G) {
            AbstractC12660a.m76204b(this).mo76206c();
            this.f3740r = false;
        } else {
            throw new C0751i0("Fragment " + this + " did not call through to super.onDestroyView()");
        }
    }

    /* renamed from: V */
    public void m4376V() {
        m4374U();
        this.f3712Q = this.f3728f;
        this.f3728f = UUID.randomUUID().toString();
        this.f3734l = false;
        this.f3735m = false;
        this.f3737o = false;
        this.f3738p = false;
        this.f3739q = false;
        this.f3741s = 0;
        this.f3742t = null;
        this.f3744v = new C0762t();
        this.f3743u = null;
        this.f3746x = 0;
        this.f3747y = 0;
        this.f3748z = null;
        this.f3696A = false;
        this.f3697B = false;
    }

    /* renamed from: V0 */
    public void m4377V0() {
        this.f3722a = -1;
        this.f3702G = false;
        mo4439t0();
        this.f3710O = null;
        if (this.f3702G) {
            if (this.f3744v.m4519H0()) {
                return;
            }
            this.f3744v.m4510D();
            this.f3744v = new C0762t();
            return;
        }
        throw new C0751i0("Fragment " + this + " did not call through to super.onDetach()");
    }

    /* renamed from: W0 */
    public LayoutInflater m4378W0(Bundle bundle) {
        LayoutInflater layoutInflaterMo4442u0 = mo4442u0(bundle);
        this.f3710O = layoutInflaterMo4442u0;
        return layoutInflaterMo4442u0;
    }

    /* renamed from: X */
    public final boolean m4379X() {
        return this.f3743u != null && this.f3734l;
    }

    /* renamed from: X0 */
    public void m4380X0() {
        onLowMemory();
    }

    /* renamed from: Y */
    public final boolean m4381Y() {
        return this.f3697B;
    }

    /* renamed from: Y0 */
    public void m4382Y0(boolean z10) {
        m4454y0(z10);
    }

    /* renamed from: Z */
    public final boolean m4383Z() {
        FragmentManager fragmentManager;
        return this.f3696A || ((fragmentManager = this.f3742t) != null && fragmentManager.m4526L0(this.f3745w));
    }

    /* renamed from: Z0 */
    public boolean m4384Z0(MenuItem menuItem) {
        if (this.f3696A) {
            return false;
        }
        if (this.f3700E && this.f3701F && m4457z0(menuItem)) {
            return true;
        }
        return this.f3744v.m4521J(menuItem);
    }

    /* renamed from: a */
    public void m4385a(boolean z10) {
        ViewGroup viewGroup;
        FragmentManager fragmentManager;
        C0709f c0709f = this.f3707L;
        if (c0709f != null) {
            c0709f.f3776t = false;
        }
        if (this.f3704I == null || (viewGroup = this.f3703H) == null || (fragmentManager = this.f3742t) == null) {
            return;
        }
        AbstractC0747g0 abstractC0747g0M4743n = AbstractC0747g0.m4743n(viewGroup, fragmentManager);
        abstractC0747g0M4743n.m4757p();
        if (z10) {
            this.f3743u.m4799j().post(new RunnableC0707d(abstractC0747g0M4743n));
        } else {
            abstractC0747g0M4743n.m4750g();
        }
    }

    /* renamed from: a0 */
    public final boolean m4386a0() {
        return this.f3741s > 0;
    }

    /* renamed from: a1 */
    public void m4387a1(Menu menu) {
        if (this.f3696A) {
            return;
        }
        if (this.f3700E && this.f3701F) {
            m4334A0(menu);
        }
        this.f3744v.m4523K(menu);
    }

    /* renamed from: b */
    public AbstractC0750i mo4388b() {
        return new C0708e();
    }

    /* renamed from: b0 */
    public final boolean m4389b0() {
        FragmentManager fragmentManager;
        return this.f3701F && ((fragmentManager = this.f3742t) == null || fragmentManager.m4528M0(this.f3745w));
    }

    /* renamed from: b1 */
    public void m4390b1() {
        this.f3744v.m4527M();
        if (this.f3704I != null) {
            this.f3715T.m4736a(AbstractC0791h.b.ON_PAUSE);
        }
        this.f3714S.m4962h(AbstractC0791h.b.ON_PAUSE);
        this.f3722a = 6;
        this.f3702G = false;
        m4337B0();
        if (this.f3702G) {
            return;
        }
        throw new C0751i0("Fragment " + this + " did not call through to super.onPause()");
    }

    /* renamed from: c */
    public void m4391c(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.f3746x));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.f3747y));
        printWriter.print(" mTag=");
        printWriter.println(this.f3748z);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.f3722a);
        printWriter.print(" mWho=");
        printWriter.print(this.f3728f);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.f3741s);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.f3734l);
        printWriter.print(" mRemoving=");
        printWriter.print(this.f3735m);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.f3737o);
        printWriter.print(" mInLayout=");
        printWriter.println(this.f3738p);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.f3696A);
        printWriter.print(" mDetached=");
        printWriter.print(this.f3697B);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.f3701F);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.f3700E);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.f3698C);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.f3706K);
        if (this.f3742t != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.f3742t);
        }
        if (this.f3743u != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.f3743u);
        }
        if (this.f3745w != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.f3745w);
        }
        if (this.f3729g != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.f3729g);
        }
        if (this.f3724b != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.f3724b);
        }
        if (this.f3725c != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.f3725c);
        }
        if (this.f3726d != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewRegistryState=");
            printWriter.println(this.f3726d);
        }
        Fragment fragmentM4368R = m4368R(false);
        if (fragmentM4368R != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(fragmentM4368R);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.f3732j);
        }
        printWriter.print(str);
        printWriter.print("mPopDirection=");
        printWriter.println(m4343E());
        if (m4429q() != 0) {
            printWriter.print(str);
            printWriter.print("getEnterAnim=");
            printWriter.println(m4429q());
        }
        if (m4438t() != 0) {
            printWriter.print(str);
            printWriter.print("getExitAnim=");
            printWriter.println(m4438t());
        }
        if (m4345F() != 0) {
            printWriter.print(str);
            printWriter.print("getPopEnterAnim=");
            printWriter.println(m4345F());
        }
        if (m4347G() != 0) {
            printWriter.print(str);
            printWriter.print("getPopExitAnim=");
            printWriter.println(m4347G());
        }
        if (this.f3703H != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.f3703H);
        }
        if (this.f3704I != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.f3704I);
        }
        if (m4417m() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(m4417m());
        }
        if (m4426p() != null) {
            AbstractC12660a.m76204b(this).mo76205a(str, fileDescriptor, printWriter, strArr);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.f3744v + ":");
        this.f3744v.m4547W(str + "  ", fileDescriptor, printWriter, strArr);
    }

    /* renamed from: c0 */
    public boolean m4392c0() {
        C0709f c0709f = this.f3707L;
        if (c0709f == null) {
            return false;
        }
        return c0709f.f3776t;
    }

    /* renamed from: c1 */
    public void m4393c1(boolean z10) {
        m4340C0(z10);
    }

    /* renamed from: d */
    public final C0709f m4394d() {
        if (this.f3707L == null) {
            this.f3707L = new C0709f();
        }
        return this.f3707L;
    }

    /* renamed from: d0 */
    public final boolean m4395d0() {
        FragmentManager fragmentManager = this.f3742t;
        if (fragmentManager == null) {
            return false;
        }
        return fragmentManager.m4534P0();
    }

    /* renamed from: d1 */
    public boolean m4396d1(Menu menu) {
        boolean z10 = false;
        if (this.f3696A) {
            return false;
        }
        if (this.f3700E && this.f3701F) {
            m4342D0(menu);
            z10 = true;
        }
        return z10 | this.f3744v.m4531O(menu);
    }

    /* renamed from: e */
    public Fragment m4397e(String str) {
        return str.equals(this.f3728f) ? this : this.f3744v.m4574j0(str);
    }

    /* renamed from: e0 */
    public void m4398e0() {
        this.f3744v.m4548W0();
    }

    /* renamed from: e1 */
    public void m4399e1() {
        boolean zM4530N0 = this.f3742t.m4530N0(this);
        Boolean bool = this.f3733k;
        if (bool == null || bool.booleanValue() != zM4530N0) {
            this.f3733k = Boolean.valueOf(zM4530N0);
            m4344E0(zM4530N0);
            this.f3744v.m4533P();
        }
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* renamed from: f */
    public final FragmentActivity m4400f() {
        AbstractC0754l<?> abstractC0754l = this.f3743u;
        if (abstractC0754l == null) {
            return null;
        }
        return (FragmentActivity) abstractC0754l.m4797f();
    }

    @Deprecated
    /* renamed from: f0 */
    public void mo4401f0(Bundle bundle) {
        this.f3702G = true;
    }

    /* renamed from: f1 */
    public void m4402f1() {
        this.f3744v.m4548W0();
        this.f3744v.m4555a0(true);
        this.f3722a = 7;
        this.f3702G = false;
        mo4348G0();
        if (!this.f3702G) {
            throw new C0751i0("Fragment " + this + " did not call through to super.onResume()");
        }
        C0797m c0797m = this.f3714S;
        AbstractC0791h.b bVar = AbstractC0791h.b.ON_RESUME;
        c0797m.m4962h(bVar);
        if (this.f3704I != null) {
            this.f3715T.m4736a(bVar);
        }
        this.f3744v.m4535Q();
    }

    @Override // androidx.lifecycle.InterfaceC0796l
    /* renamed from: g */
    public AbstractC0791h mo1915g() {
        return this.f3714S;
    }

    @Deprecated
    /* renamed from: g0 */
    public void m4403g0(int i10, int i11, Intent intent) {
        if (FragmentManager.m4492I0(2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in onActivityResult(): requestCode: " + i10 + " resultCode: " + i11 + " data: " + intent);
        }
    }

    /* renamed from: g1 */
    public void m4404g1(Bundle bundle) {
        mo4350H0(bundle);
        this.f3718W.m81273e(bundle);
        Bundle bundleM4536Q0 = this.f3744v.m4536Q0();
        if (bundleM4536Q0 != null) {
            bundle.putParcelable("android:support:fragments", bundleM4536Q0);
        }
    }

    @Override // androidx.lifecycle.InterfaceC0788f0
    public C0786e0 getViewModelStore() {
        if (this.f3742t == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (m4333A() != AbstractC0791h.c.INITIALIZED.ordinal()) {
            return this.f3742t.m4511D0(this);
        }
        throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
    }

    @Deprecated
    /* renamed from: h0 */
    public void mo4405h0(Activity activity) {
        this.f3702G = true;
    }

    /* renamed from: h1 */
    public void m4406h1() {
        this.f3744v.m4548W0();
        this.f3744v.m4555a0(true);
        this.f3722a = 5;
        this.f3702G = false;
        mo4352I0();
        if (!this.f3702G) {
            throw new C0751i0("Fragment " + this + " did not call through to super.onStart()");
        }
        C0797m c0797m = this.f3714S;
        AbstractC0791h.b bVar = AbstractC0791h.b.ON_START;
        c0797m.m4962h(bVar);
        if (this.f3704I != null) {
            this.f3715T.m4736a(bVar);
        }
        this.f3744v.m4537R();
    }

    public final int hashCode() {
        return super.hashCode();
    }

    @Override // androidx.lifecycle.InterfaceC0789g
    /* renamed from: i */
    public C0782c0.b mo1917i() {
        Application application;
        if (this.f3742t == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (this.f3717V == null) {
            Context applicationContext = m4419m1().getApplicationContext();
            while (true) {
                if (!(applicationContext instanceof ContextWrapper)) {
                    application = null;
                    break;
                }
                if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                }
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            }
            if (application == null && FragmentManager.m4492I0(3)) {
                Log.d("FragmentManager", "Could not find Application instance from Context " + m4419m1().getApplicationContext() + ", you will need CreationExtras to use AndroidViewModel with the default ViewModelProvider.Factory");
            }
            this.f3717V = new C0810z(application, this, m4420n());
        }
        return this.f3717V;
    }

    /* renamed from: i0 */
    public void mo4407i0(Context context) {
        this.f3702G = true;
        AbstractC0754l<?> abstractC0754l = this.f3743u;
        Activity activityM4797f = abstractC0754l == null ? null : abstractC0754l.m4797f();
        if (activityM4797f != null) {
            this.f3702G = false;
            mo4405h0(activityM4797f);
        }
    }

    /* renamed from: i1 */
    public void m4408i1() {
        this.f3744v.m4541T();
        if (this.f3704I != null) {
            this.f3715T.m4736a(AbstractC0791h.b.ON_STOP);
        }
        this.f3714S.m4962h(AbstractC0791h.b.ON_STOP);
        this.f3722a = 4;
        this.f3702G = false;
        mo4353J0();
        if (this.f3702G) {
            return;
        }
        throw new C0751i0("Fragment " + this + " did not call through to super.onStop()");
    }

    @Override // androidx.lifecycle.InterfaceC0789g
    /* renamed from: j */
    public AbstractC12450a mo1918j() {
        Application application;
        Context applicationContext = m4419m1().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                application = null;
                break;
            }
            if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            }
            applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
        }
        if (application == null && FragmentManager.m4492I0(3)) {
            Log.d("FragmentManager", "Could not find Application instance from Context " + m4419m1().getApplicationContext() + ", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
        }
        C12453d c12453d = new C12453d();
        if (application != null) {
            c12453d.m74708c(C0782c0.a.f4155h, application);
        }
        c12453d.m74708c(C0807w.f4207a, this);
        c12453d.m74708c(C0807w.f4208b, this);
        if (m4420n() != null) {
            c12453d.m74708c(C0807w.f4209c, m4420n());
        }
        return c12453d;
    }

    @Deprecated
    /* renamed from: j0 */
    public void m4409j0(Fragment fragment) {
    }

    /* renamed from: j1 */
    public void m4410j1() {
        m4355K0(this.f3704I, this.f3724b);
        this.f3744v.m4543U();
    }

    /* renamed from: k */
    public boolean m4411k() {
        Boolean bool;
        C0709f c0709f = this.f3707L;
        if (c0709f == null || (bool = c0709f.f3773q) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    /* renamed from: k0 */
    public boolean m4412k0(MenuItem menuItem) {
        return false;
    }

    /* renamed from: k1 */
    public final void m4413k1(AbstractC0712i abstractC0712i) {
        if (this.f3722a >= 0) {
            abstractC0712i.mo4462a();
        } else {
            this.f3721Z.add(abstractC0712i);
        }
    }

    /* renamed from: l */
    public boolean m4414l() {
        Boolean bool;
        C0709f c0709f = this.f3707L;
        if (c0709f == null || (bool = c0709f.f3772p) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    /* renamed from: l0 */
    public void mo4415l0(Bundle bundle) {
        this.f3702G = true;
        m4425o1(bundle);
        if (this.f3744v.m4532O0(1)) {
            return;
        }
        this.f3744v.m4507B();
    }

    /* renamed from: l1 */
    public final FragmentActivity m4416l1() {
        FragmentActivity fragmentActivityM4400f = m4400f();
        if (fragmentActivityM4400f != null) {
            return fragmentActivityM4400f;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    /* renamed from: m */
    public View m4417m() {
        C0709f c0709f = this.f3707L;
        if (c0709f == null) {
            return null;
        }
        return c0709f.f3757a;
    }

    /* renamed from: m0 */
    public Animation m4418m0(int i10, boolean z10, int i11) {
        return null;
    }

    /* renamed from: m1 */
    public final Context m4419m1() {
        Context contextM4426p = m4426p();
        if (contextM4426p != null) {
            return contextM4426p;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    /* renamed from: n */
    public final Bundle m4420n() {
        return this.f3729g;
    }

    /* renamed from: n0 */
    public Animator m4421n0(int i10, boolean z10, int i11) {
        return null;
    }

    /* renamed from: n1 */
    public final View m4422n1() {
        View viewM4370S = m4370S();
        if (viewM4370S != null) {
            return viewM4370S;
        }
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    /* renamed from: o */
    public final FragmentManager m4423o() {
        if (this.f3743u != null) {
            return this.f3744v;
        }
        throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    @Deprecated
    /* renamed from: o0 */
    public void m4424o0(Menu menu, MenuInflater menuInflater) {
    }

    /* renamed from: o1 */
    public void m4425o1(Bundle bundle) {
        Parcelable parcelable;
        if (bundle == null || (parcelable = bundle.getParcelable("android:support:fragments")) == null) {
            return;
        }
        this.f3744v.m4572i1(parcelable);
        this.f3744v.m4507B();
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.f3702G = true;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        m4416l1().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.f3702G = true;
    }

    /* renamed from: p */
    public Context m4426p() {
        AbstractC0754l<?> abstractC0754l = this.f3743u;
        if (abstractC0754l == null) {
            return null;
        }
        return abstractC0754l.m4798i();
    }

    /* renamed from: p0 */
    public View mo4427p0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i10 = this.f3719X;
        if (i10 != 0) {
            return layoutInflater.inflate(i10, viewGroup, false);
        }
        return null;
    }

    /* renamed from: p1 */
    public final void m4428p1() {
        if (FragmentManager.m4492I0(3)) {
            Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + this);
        }
        if (this.f3704I != null) {
            m4431q1(this.f3724b);
        }
        this.f3724b = null;
    }

    /* renamed from: q */
    public int m4429q() {
        C0709f c0709f = this.f3707L;
        if (c0709f == null) {
            return 0;
        }
        return c0709f.f3759c;
    }

    /* renamed from: q0 */
    public void mo4430q0() {
        this.f3702G = true;
    }

    /* renamed from: q1 */
    public final void m4431q1(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.f3725c;
        if (sparseArray != null) {
            this.f3704I.restoreHierarchyState(sparseArray);
            this.f3725c = null;
        }
        if (this.f3704I != null) {
            this.f3715T.m4739d(this.f3726d);
            this.f3726d = null;
        }
        this.f3702G = false;
        mo4357L0(bundle);
        if (this.f3702G) {
            if (this.f3704I != null) {
                this.f3715T.m4736a(AbstractC0791h.b.ON_CREATE);
            }
        } else {
            throw new C0751i0("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    /* renamed from: r */
    public Object m4432r() {
        C0709f c0709f = this.f3707L;
        if (c0709f == null) {
            return null;
        }
        return c0709f.f3766j;
    }

    @Deprecated
    /* renamed from: r0 */
    public void m4433r0() {
    }

    /* renamed from: r1 */
    public void m4434r1(int i10, int i11, int i12, int i13) {
        if (this.f3707L == null && i10 == 0 && i11 == 0 && i12 == 0 && i13 == 0) {
            return;
        }
        m4394d().f3759c = i10;
        m4394d().f3760d = i11;
        m4394d().f3761e = i12;
        m4394d().f3762f = i13;
    }

    /* renamed from: s */
    public AbstractC13311m m4435s() {
        C0709f c0709f = this.f3707L;
        if (c0709f == null) {
            return null;
        }
        c0709f.getClass();
        return null;
    }

    /* renamed from: s0 */
    public void mo4436s0() {
        this.f3702G = true;
    }

    /* renamed from: s1 */
    public void m4437s1(Bundle bundle) {
        if (this.f3742t != null && m4395d0()) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.f3729g = bundle;
    }

    /* renamed from: t */
    public int m4438t() {
        C0709f c0709f = this.f3707L;
        if (c0709f == null) {
            return 0;
        }
        return c0709f.f3760d;
    }

    /* renamed from: t0 */
    public void mo4439t0() {
        this.f3702G = true;
    }

    /* renamed from: t1 */
    public void m4440t1(View view) {
        m4394d().f3775s = view;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append(getClass().getSimpleName());
        sb2.append("{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append("}");
        sb2.append(" (");
        sb2.append(this.f3728f);
        if (this.f3746x != 0) {
            sb2.append(" id=0x");
            sb2.append(Integer.toHexString(this.f3746x));
        }
        if (this.f3748z != null) {
            sb2.append(" tag=");
            sb2.append(this.f3748z);
        }
        sb2.append(")");
        return sb2.toString();
    }

    /* renamed from: u */
    public Object m4441u() {
        C0709f c0709f = this.f3707L;
        if (c0709f == null) {
            return null;
        }
        return c0709f.f3768l;
    }

    /* renamed from: u0 */
    public LayoutInflater mo4442u0(Bundle bundle) {
        return m4456z(bundle);
    }

    /* renamed from: u1 */
    public void m4443u1(SavedState savedState) {
        Bundle bundle;
        if (this.f3742t != null) {
            throw new IllegalStateException("Fragment already added");
        }
        if (savedState == null || (bundle = savedState.f3750a) == null) {
            bundle = null;
        }
        this.f3724b = bundle;
    }

    /* renamed from: v */
    public AbstractC13311m m4444v() {
        C0709f c0709f = this.f3707L;
        if (c0709f == null) {
            return null;
        }
        c0709f.getClass();
        return null;
    }

    /* renamed from: v0 */
    public void m4445v0(boolean z10) {
    }

    /* renamed from: v1 */
    public void m4446v1(boolean z10) {
        if (this.f3701F != z10) {
            this.f3701F = z10;
            if (this.f3700E && m4379X() && !m4383Z()) {
                this.f3743u.mo4486q();
            }
        }
    }

    /* renamed from: w */
    public View m4447w() {
        C0709f c0709f = this.f3707L;
        if (c0709f == null) {
            return null;
        }
        return c0709f.f3775s;
    }

    @Deprecated
    /* renamed from: w0 */
    public void m4448w0(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.f3702G = true;
    }

    /* renamed from: w1 */
    public void m4449w1(int i10) {
        if (this.f3707L == null && i10 == 0) {
            return;
        }
        m4394d();
        this.f3707L.f3763g = i10;
    }

    @Deprecated
    /* renamed from: x */
    public final FragmentManager m4450x() {
        return this.f3742t;
    }

    /* renamed from: x0 */
    public void m4451x0(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.f3702G = true;
        AbstractC0754l<?> abstractC0754l = this.f3743u;
        Activity activityM4797f = abstractC0754l == null ? null : abstractC0754l.m4797f();
        if (activityM4797f != null) {
            this.f3702G = false;
            m4448w0(activityM4797f, attributeSet, bundle);
        }
    }

    /* renamed from: x1 */
    public void m4452x1(boolean z10) {
        if (this.f3707L == null) {
            return;
        }
        m4394d().f3758b = z10;
    }

    /* renamed from: y */
    public final Object m4453y() {
        AbstractC0754l<?> abstractC0754l = this.f3743u;
        if (abstractC0754l == null) {
            return null;
        }
        return abstractC0754l.mo4484n();
    }

    /* renamed from: y0 */
    public void m4454y0(boolean z10) {
    }

    /* renamed from: y1 */
    public void m4455y1(float f10) {
        m4394d().f3774r = f10;
    }

    @Deprecated
    /* renamed from: z */
    public LayoutInflater m4456z(Bundle bundle) {
        AbstractC0754l<?> abstractC0754l = this.f3743u;
        if (abstractC0754l == null) {
            throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
        }
        LayoutInflater layoutInflaterMo4485p = abstractC0754l.mo4485p();
        C9618p.m60122a(layoutInflaterMo4485p, this.f3744v.m4609w0());
        return layoutInflaterMo4485p;
    }

    @Deprecated
    /* renamed from: z0 */
    public boolean m4457z0(MenuItem menuItem) {
        return false;
    }

    /* renamed from: z1 */
    public void m4458z1(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        m4394d();
        C0709f c0709f = this.f3707L;
        c0709f.f3764h = arrayList;
        c0709f.f3765i = arrayList2;
    }

    @SuppressLint({"BanParcelableUsage, ParcelClassLoader"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0703a();

        /* renamed from: a */
        public final Bundle f3750a;

        /* renamed from: androidx.fragment.app.Fragment$SavedState$a */
        public class C0703a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Bundle bundle) {
            this.f3750a = bundle;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeBundle(this.f3750a);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            Bundle bundle = parcel.readBundle();
            this.f3750a = bundle;
            if (classLoader == null || bundle == null) {
                return;
            }
            bundle.setClassLoader(classLoader);
        }
    }
}
