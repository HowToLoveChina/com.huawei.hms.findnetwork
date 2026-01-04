package androidx.fragment.app;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.R$id;
import androidx.fragment.app.AbstractC0747g0;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.AbstractC0791h;
import androidx.lifecycle.InterfaceC0788f0;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import p273f0.C9603h0;
import p540p0.C12062c;

/* renamed from: androidx.fragment.app.x */
/* loaded from: classes.dex */
public class C0766x {

    /* renamed from: a */
    public final C0756n f4083a;

    /* renamed from: b */
    public final C0768z f4084b;

    /* renamed from: c */
    public final Fragment f4085c;

    /* renamed from: d */
    public boolean f4086d = false;

    /* renamed from: e */
    public int f4087e = -1;

    /* renamed from: androidx.fragment.app.x$a */
    public class a implements View.OnAttachStateChangeListener {

        /* renamed from: a */
        public final /* synthetic */ View f4088a;

        public a(View view) {
            this.f4088a = view;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            this.f4088a.removeOnAttachStateChangeListener(this);
            C9603h0.m59896m0(this.f4088a);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* renamed from: androidx.fragment.app.x$b */
    public static /* synthetic */ class b {

        /* renamed from: a */
        public static final /* synthetic */ int[] f4090a;

        static {
            int[] iArr = new int[AbstractC0791h.c.values().length];
            f4090a = iArr;
            try {
                iArr[AbstractC0791h.c.RESUMED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4090a[AbstractC0791h.c.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4090a[AbstractC0791h.c.CREATED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4090a[AbstractC0791h.c.INITIALIZED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public C0766x(C0756n c0756n, C0768z c0768z, Fragment fragment) {
        this.f4083a = c0756n;
        this.f4084b = c0768z;
        this.f4085c = fragment;
    }

    /* renamed from: a */
    public void m4829a() {
        if (FragmentManager.m4492I0(3)) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + this.f4085c);
        }
        Fragment fragment = this.f4085c;
        fragment.m4359M0(fragment.f3724b);
        C0756n c0756n = this.f4083a;
        Fragment fragment2 = this.f4085c;
        c0756n.m4800a(fragment2, fragment2.f3724b, false);
    }

    /* renamed from: b */
    public void m4830b() {
        int iM4863j = this.f4084b.m4863j(this.f4085c);
        Fragment fragment = this.f4085c;
        fragment.f3703H.addView(fragment.f3704I, iM4863j);
    }

    /* renamed from: c */
    public void m4831c() {
        if (FragmentManager.m4492I0(3)) {
            Log.d("FragmentManager", "moveto ATTACHED: " + this.f4085c);
        }
        Fragment fragment = this.f4085c;
        Fragment fragment2 = fragment.f3730h;
        C0766x c0766xM4867n = null;
        if (fragment2 != null) {
            C0766x c0766xM4867n2 = this.f4084b.m4867n(fragment2.f3728f);
            if (c0766xM4867n2 == null) {
                throw new IllegalStateException("Fragment " + this.f4085c + " declared target fragment " + this.f4085c.f3730h + " that does not belong to this FragmentManager!");
            }
            Fragment fragment3 = this.f4085c;
            fragment3.f3731i = fragment3.f3730h.f3728f;
            fragment3.f3730h = null;
            c0766xM4867n = c0766xM4867n2;
        } else {
            String str = fragment.f3731i;
            if (str != null && (c0766xM4867n = this.f4084b.m4867n(str)) == null) {
                throw new IllegalStateException("Fragment " + this.f4085c + " declared target fragment " + this.f4085c.f3731i + " that does not belong to this FragmentManager!");
            }
        }
        if (c0766xM4867n != null) {
            c0766xM4867n.m4841m();
        }
        Fragment fragment4 = this.f4085c;
        fragment4.f3743u = fragment4.f3742t.m4607v0();
        Fragment fragment5 = this.f4085c;
        fragment5.f3745w = fragment5.f3742t.m4613y0();
        this.f4083a.m4806g(this.f4085c, false);
        this.f4085c.m4361N0();
        this.f4083a.m4801b(this.f4085c, false);
    }

    /* renamed from: d */
    public int m4832d() {
        Fragment fragment = this.f4085c;
        if (fragment.f3742t == null) {
            return fragment.f3722a;
        }
        int iMin = this.f4087e;
        int i10 = b.f4090a[fragment.f3713R.ordinal()];
        if (i10 != 1) {
            iMin = i10 != 2 ? i10 != 3 ? i10 != 4 ? Math.min(iMin, -1) : Math.min(iMin, 0) : Math.min(iMin, 1) : Math.min(iMin, 5);
        }
        Fragment fragment2 = this.f4085c;
        if (fragment2.f3737o) {
            if (fragment2.f3738p) {
                iMin = Math.max(this.f4087e, 2);
                View view = this.f4085c.f3704I;
                if (view != null && view.getParent() == null) {
                    iMin = Math.min(iMin, 2);
                }
            } else {
                iMin = this.f4087e < 4 ? Math.min(iMin, fragment2.f3722a) : Math.min(iMin, 1);
            }
        }
        if (!this.f4085c.f3734l) {
            iMin = Math.min(iMin, 1);
        }
        Fragment fragment3 = this.f4085c;
        ViewGroup viewGroup = fragment3.f3703H;
        AbstractC0747g0.e.b bVarM4755l = viewGroup != null ? AbstractC0747g0.m4743n(viewGroup, fragment3.m4341D()).m4755l(this) : null;
        if (bVarM4755l == AbstractC0747g0.e.b.ADDING) {
            iMin = Math.min(iMin, 6);
        } else if (bVarM4755l == AbstractC0747g0.e.b.REMOVING) {
            iMin = Math.max(iMin, 3);
        } else {
            Fragment fragment4 = this.f4085c;
            if (fragment4.f3735m) {
                iMin = fragment4.m4386a0() ? Math.min(iMin, 1) : Math.min(iMin, -1);
            }
        }
        Fragment fragment5 = this.f4085c;
        if (fragment5.f3705J && fragment5.f3722a < 5) {
            iMin = Math.min(iMin, 4);
        }
        if (FragmentManager.m4492I0(2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + iMin + " for " + this.f4085c);
        }
        return iMin;
    }

    /* renamed from: e */
    public void m4833e() {
        if (FragmentManager.m4492I0(3)) {
            Log.d("FragmentManager", "moveto CREATED: " + this.f4085c);
        }
        Fragment fragment = this.f4085c;
        if (fragment.f3711P) {
            fragment.m4425o1(fragment.f3724b);
            this.f4085c.f3722a = 1;
            return;
        }
        this.f4083a.m4807h(fragment, fragment.f3724b, false);
        Fragment fragment2 = this.f4085c;
        fragment2.m4367Q0(fragment2.f3724b);
        C0756n c0756n = this.f4083a;
        Fragment fragment3 = this.f4085c;
        c0756n.m4802c(fragment3, fragment3.f3724b, false);
    }

    /* renamed from: f */
    public void m4834f() throws Resources.NotFoundException {
        String resourceName;
        if (this.f4085c.f3737o) {
            return;
        }
        if (FragmentManager.m4492I0(3)) {
            Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f4085c);
        }
        Fragment fragment = this.f4085c;
        LayoutInflater layoutInflaterM4378W0 = fragment.m4378W0(fragment.f3724b);
        Fragment fragment2 = this.f4085c;
        ViewGroup viewGroup = fragment2.f3703H;
        if (viewGroup == null) {
            int i10 = fragment2.f3747y;
            if (i10 == 0) {
                viewGroup = null;
            } else {
                if (i10 == -1) {
                    throw new IllegalArgumentException("Cannot create fragment " + this.f4085c + " for a container view with no id");
                }
                viewGroup = (ViewGroup) fragment2.f3742t.m4592q0().mo4463d(this.f4085c.f3747y);
                if (viewGroup == null) {
                    Fragment fragment3 = this.f4085c;
                    if (!fragment3.f3739q) {
                        try {
                            resourceName = fragment3.m4354K().getResourceName(this.f4085c.f3747y);
                        } catch (Resources.NotFoundException unused) {
                            resourceName = "unknown";
                        }
                        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.f4085c.f3747y) + " (" + resourceName + ") for fragment " + this.f4085c);
                    }
                } else if (!(viewGroup instanceof FragmentContainerView)) {
                    C12062c.m72211j(this.f4085c, viewGroup);
                }
            }
        }
        Fragment fragment4 = this.f4085c;
        fragment4.f3703H = viewGroup;
        fragment4.mo4371S0(layoutInflaterM4378W0, viewGroup, fragment4.f3724b);
        View view = this.f4085c.f3704I;
        if (view != null) {
            view.setSaveFromParentEnabled(false);
            Fragment fragment5 = this.f4085c;
            fragment5.f3704I.setTag(R$id.fragment_container_view_tag, fragment5);
            if (viewGroup != null) {
                m4830b();
            }
            Fragment fragment6 = this.f4085c;
            if (fragment6.f3696A) {
                fragment6.f3704I.setVisibility(8);
            }
            if (C9603h0.m59863S(this.f4085c.f3704I)) {
                C9603h0.m59896m0(this.f4085c.f3704I);
            } else {
                View view2 = this.f4085c.f3704I;
                view2.addOnAttachStateChangeListener(new a(view2));
            }
            this.f4085c.m4410j1();
            C0756n c0756n = this.f4083a;
            Fragment fragment7 = this.f4085c;
            c0756n.m4812m(fragment7, fragment7.f3704I, fragment7.f3724b, false);
            int visibility = this.f4085c.f3704I.getVisibility();
            this.f4085c.m4455y1(this.f4085c.f3704I.getAlpha());
            Fragment fragment8 = this.f4085c;
            if (fragment8.f3703H != null && visibility == 0) {
                View viewFindFocus = fragment8.f3704I.findFocus();
                if (viewFindFocus != null) {
                    this.f4085c.m4440t1(viewFindFocus);
                    if (FragmentManager.m4492I0(2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + this.f4085c);
                    }
                }
                this.f4085c.f3704I.setAlpha(0.0f);
            }
        }
        this.f4085c.f3722a = 2;
    }

    /* renamed from: g */
    public void m4835g() {
        Fragment fragmentM4859f;
        if (FragmentManager.m4492I0(3)) {
            Log.d("FragmentManager", "movefrom CREATED: " + this.f4085c);
        }
        Fragment fragment = this.f4085c;
        boolean zIsChangingConfigurations = true;
        boolean z10 = fragment.f3735m && !fragment.m4386a0();
        if (z10) {
            Fragment fragment2 = this.f4085c;
            if (!fragment2.f3736n) {
                this.f4084b.m4853B(fragment2.f3728f, null);
            }
        }
        if (!z10 && !this.f4084b.m4869p().m4827r(this.f4085c)) {
            String str = this.f4085c.f3731i;
            if (str != null && (fragmentM4859f = this.f4084b.m4859f(str)) != null && fragmentM4859f.f3698C) {
                this.f4085c.f3730h = fragmentM4859f;
            }
            this.f4085c.f3722a = 0;
            return;
        }
        AbstractC0754l<?> abstractC0754l = this.f4085c.f3743u;
        if (abstractC0754l instanceof InterfaceC0788f0) {
            zIsChangingConfigurations = this.f4084b.m4869p().m4824o();
        } else if (abstractC0754l.m4798i() instanceof Activity) {
            zIsChangingConfigurations = true ^ ((Activity) abstractC0754l.m4798i()).isChangingConfigurations();
        }
        if ((z10 && !this.f4085c.f3736n) || zIsChangingConfigurations) {
            this.f4084b.m4869p().m4817g(this.f4085c);
        }
        this.f4085c.m4373T0();
        this.f4083a.m4803d(this.f4085c, false);
        for (C0766x c0766x : this.f4084b.m4864k()) {
            if (c0766x != null) {
                Fragment fragmentM4839k = c0766x.m4839k();
                if (this.f4085c.f3728f.equals(fragmentM4839k.f3731i)) {
                    fragmentM4839k.f3730h = this.f4085c;
                    fragmentM4839k.f3731i = null;
                }
            }
        }
        Fragment fragment3 = this.f4085c;
        String str2 = fragment3.f3731i;
        if (str2 != null) {
            fragment3.f3730h = this.f4084b.m4859f(str2);
        }
        this.f4084b.m4872s(this);
    }

    /* renamed from: h */
    public void m4836h() {
        View view;
        if (FragmentManager.m4492I0(3)) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + this.f4085c);
        }
        Fragment fragment = this.f4085c;
        ViewGroup viewGroup = fragment.f3703H;
        if (viewGroup != null && (view = fragment.f3704I) != null) {
            viewGroup.removeView(view);
        }
        this.f4085c.m4375U0();
        this.f4083a.m4813n(this.f4085c, false);
        Fragment fragment2 = this.f4085c;
        fragment2.f3703H = null;
        fragment2.f3704I = null;
        fragment2.f3715T = null;
        fragment2.f3716U.mo4896n(null);
        this.f4085c.f3738p = false;
    }

    /* renamed from: i */
    public void m4837i() {
        if (FragmentManager.m4492I0(3)) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + this.f4085c);
        }
        this.f4085c.m4377V0();
        this.f4083a.m4804e(this.f4085c, false);
        Fragment fragment = this.f4085c;
        fragment.f3722a = -1;
        fragment.f3743u = null;
        fragment.f3745w = null;
        fragment.f3742t = null;
        if ((!fragment.f3735m || fragment.m4386a0()) && !this.f4084b.m4869p().m4827r(this.f4085c)) {
            return;
        }
        if (FragmentManager.m4492I0(3)) {
            Log.d("FragmentManager", "initState called for fragment: " + this.f4085c);
        }
        this.f4085c.m4376V();
    }

    /* renamed from: j */
    public void m4838j() {
        Fragment fragment = this.f4085c;
        if (fragment.f3737o && fragment.f3738p && !fragment.f3740r) {
            if (FragmentManager.m4492I0(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f4085c);
            }
            Fragment fragment2 = this.f4085c;
            fragment2.mo4371S0(fragment2.m4378W0(fragment2.f3724b), null, this.f4085c.f3724b);
            View view = this.f4085c.f3704I;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                Fragment fragment3 = this.f4085c;
                fragment3.f3704I.setTag(R$id.fragment_container_view_tag, fragment3);
                Fragment fragment4 = this.f4085c;
                if (fragment4.f3696A) {
                    fragment4.f3704I.setVisibility(8);
                }
                this.f4085c.m4410j1();
                C0756n c0756n = this.f4083a;
                Fragment fragment5 = this.f4085c;
                c0756n.m4812m(fragment5, fragment5.f3704I, fragment5.f3724b, false);
                this.f4085c.f3722a = 2;
            }
        }
    }

    /* renamed from: k */
    public Fragment m4839k() {
        return this.f4085c;
    }

    /* renamed from: l */
    public final boolean m4840l(View view) {
        if (view == this.f4085c.f3704I) {
            return true;
        }
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == this.f4085c.f3704I) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: m */
    public void m4841m() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        if (this.f4086d) {
            if (FragmentManager.m4492I0(2)) {
                Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + m4839k());
                return;
            }
            return;
        }
        try {
            this.f4086d = true;
            boolean z10 = false;
            while (true) {
                int iM4832d = m4832d();
                Fragment fragment = this.f4085c;
                int i10 = fragment.f3722a;
                if (iM4832d == i10) {
                    if (!z10 && i10 == -1 && fragment.f3735m && !fragment.m4386a0() && !this.f4085c.f3736n) {
                        if (FragmentManager.m4492I0(3)) {
                            Log.d("FragmentManager", "Cleaning up state of never attached fragment: " + this.f4085c);
                        }
                        this.f4084b.m4869p().m4817g(this.f4085c);
                        this.f4084b.m4872s(this);
                        if (FragmentManager.m4492I0(3)) {
                            Log.d("FragmentManager", "initState called for fragment: " + this.f4085c);
                        }
                        this.f4085c.m4376V();
                    }
                    Fragment fragment2 = this.f4085c;
                    if (fragment2.f3709N) {
                        if (fragment2.f3704I != null && (viewGroup = fragment2.f3703H) != null) {
                            AbstractC0747g0 abstractC0747g0M4743n = AbstractC0747g0.m4743n(viewGroup, fragment2.m4341D());
                            if (this.f4085c.f3696A) {
                                abstractC0747g0M4743n.m4747c(this);
                            } else {
                                abstractC0747g0M4743n.m4749e(this);
                            }
                        }
                        Fragment fragment3 = this.f4085c;
                        FragmentManager fragmentManager = fragment3.f3742t;
                        if (fragmentManager != null) {
                            fragmentManager.m4517G0(fragment3);
                        }
                        Fragment fragment4 = this.f4085c;
                        fragment4.f3709N = false;
                        fragment4.m4445v0(fragment4.f3696A);
                        this.f4085c.f3744v.m4520I();
                    }
                    this.f4086d = false;
                    return;
                }
                if (iM4832d <= i10) {
                    switch (i10 - 1) {
                        case -1:
                            m4837i();
                            break;
                        case 0:
                            if (fragment.f3736n && this.f4084b.m4870q(fragment.f3728f) == null) {
                                m4847s();
                            }
                            m4835g();
                            break;
                        case 1:
                            m4836h();
                            this.f4085c.f3722a = 1;
                            break;
                        case 2:
                            fragment.f3738p = false;
                            fragment.f3722a = 2;
                            break;
                        case 3:
                            if (FragmentManager.m4492I0(3)) {
                                Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + this.f4085c);
                            }
                            Fragment fragment5 = this.f4085c;
                            if (fragment5.f3736n) {
                                m4847s();
                            } else if (fragment5.f3704I != null && fragment5.f3725c == null) {
                                m4848t();
                            }
                            Fragment fragment6 = this.f4085c;
                            if (fragment6.f3704I != null && (viewGroup2 = fragment6.f3703H) != null) {
                                AbstractC0747g0.m4743n(viewGroup2, fragment6.m4341D()).m4748d(this);
                            }
                            this.f4085c.f3722a = 3;
                            break;
                        case 4:
                            m4851w();
                            break;
                        case 5:
                            fragment.f3722a = 5;
                            break;
                        case 6:
                            m4842n();
                            break;
                    }
                } else {
                    switch (i10 + 1) {
                        case 0:
                            m4831c();
                            break;
                        case 1:
                            m4833e();
                            break;
                        case 2:
                            m4838j();
                            m4834f();
                            break;
                        case 3:
                            m4829a();
                            break;
                        case 4:
                            if (fragment.f3704I != null && (viewGroup3 = fragment.f3703H) != null) {
                                AbstractC0747g0.m4743n(viewGroup3, fragment.m4341D()).m4746b(AbstractC0747g0.e.c.m4772e(this.f4085c.f3704I.getVisibility()), this);
                            }
                            this.f4085c.f3722a = 4;
                            break;
                        case 5:
                            m4850v();
                            break;
                        case 6:
                            fragment.f3722a = 6;
                            break;
                        case 7:
                            m4844p();
                            break;
                    }
                }
                z10 = true;
            }
        } catch (Throwable th2) {
            this.f4086d = false;
            throw th2;
        }
    }

    /* renamed from: n */
    public void m4842n() {
        if (FragmentManager.m4492I0(3)) {
            Log.d("FragmentManager", "movefrom RESUMED: " + this.f4085c);
        }
        this.f4085c.m4390b1();
        this.f4083a.m4805f(this.f4085c, false);
    }

    /* renamed from: o */
    public void m4843o(ClassLoader classLoader) {
        Bundle bundle = this.f4085c.f3724b;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        Fragment fragment = this.f4085c;
        fragment.f3725c = fragment.f3724b.getSparseParcelableArray("android:view_state");
        Fragment fragment2 = this.f4085c;
        fragment2.f3726d = fragment2.f3724b.getBundle("android:view_registry_state");
        Fragment fragment3 = this.f4085c;
        fragment3.f3731i = fragment3.f3724b.getString("android:target_state");
        Fragment fragment4 = this.f4085c;
        if (fragment4.f3731i != null) {
            fragment4.f3732j = fragment4.f3724b.getInt("android:target_req_state", 0);
        }
        Fragment fragment5 = this.f4085c;
        Boolean bool = fragment5.f3727e;
        if (bool != null) {
            fragment5.f3706K = bool.booleanValue();
            this.f4085c.f3727e = null;
        } else {
            fragment5.f3706K = fragment5.f3724b.getBoolean("android:user_visible_hint", true);
        }
        Fragment fragment6 = this.f4085c;
        if (fragment6.f3706K) {
            return;
        }
        fragment6.f3705J = true;
    }

    /* renamed from: p */
    public void m4844p() {
        if (FragmentManager.m4492I0(3)) {
            Log.d("FragmentManager", "moveto RESUMED: " + this.f4085c);
        }
        View viewM4447w = this.f4085c.m4447w();
        if (viewM4447w != null && m4840l(viewM4447w)) {
            boolean zRequestFocus = viewM4447w.requestFocus();
            if (FragmentManager.m4492I0(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("requestFocus: Restoring focused view ");
                sb2.append(viewM4447w);
                sb2.append(" ");
                sb2.append(zRequestFocus ? "succeeded" : NotifyConstants.CommonReportConstants.FAILED);
                sb2.append(" on Fragment ");
                sb2.append(this.f4085c);
                sb2.append(" resulting in focused view ");
                sb2.append(this.f4085c.f3704I.findFocus());
                Log.v("FragmentManager", sb2.toString());
            }
        }
        this.f4085c.m4440t1(null);
        this.f4085c.m4402f1();
        this.f4083a.m4808i(this.f4085c, false);
        Fragment fragment = this.f4085c;
        fragment.f3724b = null;
        fragment.f3725c = null;
        fragment.f3726d = null;
    }

    /* renamed from: q */
    public final Bundle m4845q() {
        Bundle bundle = new Bundle();
        this.f4085c.m4404g1(bundle);
        this.f4083a.m4809j(this.f4085c, bundle, false);
        if (bundle.isEmpty()) {
            bundle = null;
        }
        if (this.f4085c.f3704I != null) {
            m4848t();
        }
        if (this.f4085c.f3725c != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", this.f4085c.f3725c);
        }
        if (this.f4085c.f3726d != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBundle("android:view_registry_state", this.f4085c.f3726d);
        }
        if (!this.f4085c.f3706K) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", this.f4085c.f3706K);
        }
        return bundle;
    }

    /* renamed from: r */
    public Fragment.SavedState m4846r() {
        Bundle bundleM4845q;
        if (this.f4085c.f3722a <= -1 || (bundleM4845q = m4845q()) == null) {
            return null;
        }
        return new Fragment.SavedState(bundleM4845q);
    }

    /* renamed from: s */
    public void m4847s() {
        FragmentState fragmentState = new FragmentState(this.f4085c);
        Fragment fragment = this.f4085c;
        if (fragment.f3722a <= -1 || fragmentState.f3872m != null) {
            fragmentState.f3872m = fragment.f3724b;
        } else {
            Bundle bundleM4845q = m4845q();
            fragmentState.f3872m = bundleM4845q;
            if (this.f4085c.f3731i != null) {
                if (bundleM4845q == null) {
                    fragmentState.f3872m = new Bundle();
                }
                fragmentState.f3872m.putString("android:target_state", this.f4085c.f3731i);
                int i10 = this.f4085c.f3732j;
                if (i10 != 0) {
                    fragmentState.f3872m.putInt("android:target_req_state", i10);
                }
            }
        }
        this.f4084b.m4853B(this.f4085c.f3728f, fragmentState);
    }

    /* renamed from: t */
    public void m4848t() {
        if (this.f4085c.f3704I == null) {
            return;
        }
        if (FragmentManager.m4492I0(2)) {
            Log.v("FragmentManager", "Saving view state for fragment " + this.f4085c + " with view " + this.f4085c.f3704I);
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        this.f4085c.f3704I.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            this.f4085c.f3725c = sparseArray;
        }
        Bundle bundle = new Bundle();
        this.f4085c.f3715T.m4740e(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        this.f4085c.f3726d = bundle;
    }

    /* renamed from: u */
    public void m4849u(int i10) {
        this.f4087e = i10;
    }

    /* renamed from: v */
    public void m4850v() {
        if (FragmentManager.m4492I0(3)) {
            Log.d("FragmentManager", "moveto STARTED: " + this.f4085c);
        }
        this.f4085c.m4406h1();
        this.f4083a.m4810k(this.f4085c, false);
    }

    /* renamed from: w */
    public void m4851w() {
        if (FragmentManager.m4492I0(3)) {
            Log.d("FragmentManager", "movefrom STARTED: " + this.f4085c);
        }
        this.f4085c.m4408i1();
        this.f4083a.m4811l(this.f4085c, false);
    }

    public C0766x(C0756n c0756n, C0768z c0768z, ClassLoader classLoader, C0753k c0753k, FragmentState fragmentState) {
        this.f4083a = c0756n;
        this.f4084b = c0768z;
        Fragment fragmentM4633a = fragmentState.m4633a(c0753k, classLoader);
        this.f4085c = fragmentM4633a;
        if (FragmentManager.m4492I0(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + fragmentM4633a);
        }
    }

    public C0766x(C0756n c0756n, C0768z c0768z, Fragment fragment, FragmentState fragmentState) {
        this.f4083a = c0756n;
        this.f4084b = c0768z;
        this.f4085c = fragment;
        fragment.f3725c = null;
        fragment.f3726d = null;
        fragment.f3741s = 0;
        fragment.f3738p = false;
        fragment.f3734l = false;
        Fragment fragment2 = fragment.f3730h;
        fragment.f3731i = fragment2 != null ? fragment2.f3728f : null;
        fragment.f3730h = null;
        Bundle bundle = fragmentState.f3872m;
        if (bundle != null) {
            fragment.f3724b = bundle;
        } else {
            fragment.f3724b = new Bundle();
        }
    }
}
