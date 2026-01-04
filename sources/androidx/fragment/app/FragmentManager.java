package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.AbstractC0333g;
import androidx.activity.InterfaceC0337k;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.AbstractC0342b;
import androidx.activity.result.AbstractC0343c;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.InterfaceC0341a;
import androidx.activity.result.InterfaceC0344d;
import androidx.core.content.OnConfigurationChangedProvider;
import androidx.core.content.OnTrimMemoryProvider;
import androidx.fragment.R$id;
import androidx.fragment.app.AbstractC0735a0;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.AbstractC0791h;
import androidx.lifecycle.C0786e0;
import androidx.lifecycle.InterfaceC0788f0;
import androidx.lifecycle.InterfaceC0794j;
import androidx.lifecycle.InterfaceC0796l;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import p041c.AbstractC1365a;
import p041c.C1366b;
import p041c.C1367c;
import p243e0.InterfaceC9366a;
import p273f0.InterfaceC9622r;
import p273f0.InterfaceC9628u;
import p540p0.C12062c;
import p694v.C13301c;
import p694v.C13309k;
import p694v.InterfaceC13307i;
import p694v.InterfaceC13308j;
import p724w0.C13512b;
import p724w0.InterfaceC13514d;

/* loaded from: classes.dex */
public abstract class FragmentManager {

    /* renamed from: S */
    public static boolean f3788S = false;

    /* renamed from: D */
    public AbstractC0342b<Intent> f3792D;

    /* renamed from: E */
    public AbstractC0342b<IntentSenderRequest> f3793E;

    /* renamed from: F */
    public AbstractC0342b<String[]> f3794F;

    /* renamed from: H */
    public boolean f3796H;

    /* renamed from: I */
    public boolean f3797I;

    /* renamed from: J */
    public boolean f3798J;

    /* renamed from: K */
    public boolean f3799K;

    /* renamed from: L */
    public boolean f3800L;

    /* renamed from: M */
    public ArrayList<C0734a> f3801M;

    /* renamed from: N */
    public ArrayList<Boolean> f3802N;

    /* renamed from: O */
    public ArrayList<Fragment> f3803O;

    /* renamed from: P */
    public C0763u f3804P;

    /* renamed from: Q */
    public C12062c.c f3805Q;

    /* renamed from: b */
    public boolean f3808b;

    /* renamed from: d */
    public ArrayList<C0734a> f3810d;

    /* renamed from: e */
    public ArrayList<Fragment> f3811e;

    /* renamed from: g */
    public OnBackPressedDispatcher f3813g;

    /* renamed from: m */
    public ArrayList<InterfaceC0727k> f3819m;

    /* renamed from: v */
    public AbstractC0754l<?> f3828v;

    /* renamed from: w */
    public AbstractC0750i f3829w;

    /* renamed from: x */
    public Fragment f3830x;

    /* renamed from: y */
    public Fragment f3831y;

    /* renamed from: a */
    public final ArrayList<InterfaceC0728l> f3807a = new ArrayList<>();

    /* renamed from: c */
    public final C0768z f3809c = new C0768z();

    /* renamed from: f */
    public final LayoutInflaterFactory2C0755m f3812f = new LayoutInflaterFactory2C0755m(this);

    /* renamed from: h */
    public final AbstractC0333g f3814h = new C0718b(false);

    /* renamed from: i */
    public final AtomicInteger f3815i = new AtomicInteger();

    /* renamed from: j */
    public final Map<String, BackStackState> f3816j = Collections.synchronizedMap(new HashMap());

    /* renamed from: k */
    public final Map<String, Bundle> f3817k = Collections.synchronizedMap(new HashMap());

    /* renamed from: l */
    public final Map<String, Object> f3818l = Collections.synchronizedMap(new HashMap());

    /* renamed from: n */
    public final C0756n f3820n = new C0756n(this);

    /* renamed from: o */
    public final CopyOnWriteArrayList<InterfaceC0764v> f3821o = new CopyOnWriteArrayList<>();

    /* renamed from: p */
    public final InterfaceC9366a<Configuration> f3822p = new InterfaceC9366a() { // from class: androidx.fragment.app.o
        @Override // p243e0.InterfaceC9366a
        public final void accept(Object obj) {
            this.f4070a.m4538R0((Configuration) obj);
        }
    };

    /* renamed from: q */
    public final InterfaceC9366a<Integer> f3823q = new InterfaceC9366a() { // from class: androidx.fragment.app.p
        @Override // p243e0.InterfaceC9366a
        public final void accept(Object obj) {
            this.f4071a.m4540S0((Integer) obj);
        }
    };

    /* renamed from: r */
    public final InterfaceC9366a<C13301c> f3824r = new InterfaceC9366a() { // from class: androidx.fragment.app.q
        @Override // p243e0.InterfaceC9366a
        public final void accept(Object obj) {
            this.f4072a.m4542T0((C13301c) obj);
        }
    };

    /* renamed from: s */
    public final InterfaceC9366a<C13309k> f3825s = new InterfaceC9366a() { // from class: androidx.fragment.app.r
        @Override // p243e0.InterfaceC9366a
        public final void accept(Object obj) {
            this.f4073a.m4544U0((C13309k) obj);
        }
    };

    /* renamed from: t */
    public final InterfaceC9628u f3826t = new C0719c();

    /* renamed from: u */
    public int f3827u = -1;

    /* renamed from: z */
    public C0753k f3832z = null;

    /* renamed from: A */
    public C0753k f3789A = new C0720d();

    /* renamed from: B */
    public InterfaceC0749h0 f3790B = null;

    /* renamed from: C */
    public InterfaceC0749h0 f3791C = new C0721e();

    /* renamed from: G */
    public ArrayDeque<LaunchedFragmentInfo> f3795G = new ArrayDeque<>();

    /* renamed from: R */
    public Runnable f3806R = new RunnableC0722f();

    /* renamed from: androidx.fragment.app.FragmentManager$6 */
    class C07156 implements InterfaceC0794j {

        /* renamed from: a */
        public final /* synthetic */ String f3833a;

        /* renamed from: b */
        public final /* synthetic */ AbstractC0791h f3834b;

        /* renamed from: c */
        public final /* synthetic */ FragmentManager f3835c;

        @Override // androidx.lifecycle.InterfaceC0794j
        /* renamed from: d */
        public void mo1925d(InterfaceC0796l interfaceC0796l, AbstractC0791h.b bVar) {
            if (bVar == AbstractC0791h.b.ON_START && ((Bundle) this.f3835c.f3817k.get(this.f3833a)) != null) {
                throw null;
            }
            if (bVar == AbstractC0791h.b.ON_DESTROY) {
                this.f3834b.mo4950c(this);
                this.f3835c.f3818l.remove(this.f3833a);
            }
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class LaunchedFragmentInfo implements Parcelable {
        public static final Parcelable.Creator<LaunchedFragmentInfo> CREATOR = new C0716a();

        /* renamed from: a */
        public String f3836a;

        /* renamed from: b */
        public int f3837b;

        /* renamed from: androidx.fragment.app.FragmentManager$LaunchedFragmentInfo$a */
        public class C0716a implements Parcelable.Creator<LaunchedFragmentInfo> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public LaunchedFragmentInfo createFromParcel(Parcel parcel) {
                return new LaunchedFragmentInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public LaunchedFragmentInfo[] newArray(int i10) {
                return new LaunchedFragmentInfo[i10];
            }
        }

        public LaunchedFragmentInfo(Parcel parcel) {
            this.f3836a = parcel.readString();
            this.f3837b = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeString(this.f3836a);
            parcel.writeInt(this.f3837b);
        }
    }

    /* renamed from: androidx.fragment.app.FragmentManager$a */
    public class C0717a implements InterfaceC0341a<Map<String, Boolean>> {
        public C0717a() {
        }

        @Override // androidx.activity.result.InterfaceC0341a
        @SuppressLint({"SyntheticAccessor"})
        /* renamed from: b */
        public void mo1962a(Map<String, Boolean> map) {
            String[] strArr = (String[]) map.keySet().toArray(new String[0]);
            ArrayList arrayList = new ArrayList(map.values());
            int[] iArr = new int[arrayList.size()];
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                iArr[i10] = ((Boolean) arrayList.get(i10)).booleanValue() ? 0 : -1;
            }
            LaunchedFragmentInfo launchedFragmentInfoPollFirst = FragmentManager.this.f3795G.pollFirst();
            if (launchedFragmentInfoPollFirst == null) {
                Log.w("FragmentManager", "No permissions were requested for " + this);
                return;
            }
            String str = launchedFragmentInfoPollFirst.f3836a;
            int i11 = launchedFragmentInfoPollFirst.f3837b;
            Fragment fragmentM4862i = FragmentManager.this.f3809c.m4862i(str);
            if (fragmentM4862i != null) {
                fragmentM4862i.m4346F0(i11, strArr, iArr);
                return;
            }
            Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + str);
        }
    }

    /* renamed from: androidx.fragment.app.FragmentManager$b */
    public class C0718b extends AbstractC0333g {
        public C0718b(boolean z10) {
            super(z10);
        }

        @Override // androidx.activity.AbstractC0333g
        /* renamed from: b */
        public void mo1948b() {
            FragmentManager.this.m4513E0();
        }
    }

    /* renamed from: androidx.fragment.app.FragmentManager$c */
    public class C0719c implements InterfaceC9628u {
        public C0719c() {
        }

        @Override // p273f0.InterfaceC9628u
        /* renamed from: a */
        public boolean mo4619a(MenuItem menuItem) {
            return FragmentManager.this.m4521J(menuItem);
        }

        @Override // p273f0.InterfaceC9628u
        /* renamed from: b */
        public void mo4620b(Menu menu) {
            FragmentManager.this.m4523K(menu);
        }

        @Override // p273f0.InterfaceC9628u
        /* renamed from: c */
        public void mo4621c(Menu menu, MenuInflater menuInflater) {
            FragmentManager.this.m4509C(menu, menuInflater);
        }

        @Override // p273f0.InterfaceC9628u
        /* renamed from: d */
        public void mo4622d(Menu menu) {
            FragmentManager.this.m4531O(menu);
        }
    }

    /* renamed from: androidx.fragment.app.FragmentManager$d */
    public class C0720d extends C0753k {
        public C0720d() {
        }

        @Override // androidx.fragment.app.C0753k
        /* renamed from: a */
        public Fragment mo4623a(ClassLoader classLoader, String str) {
            return FragmentManager.this.m4607v0().m4779b(FragmentManager.this.m4607v0().m4798i(), str, null);
        }
    }

    /* renamed from: androidx.fragment.app.FragmentManager$e */
    public class C0721e implements InterfaceC0749h0 {
        public C0721e() {
        }

        @Override // androidx.fragment.app.InterfaceC0749h0
        /* renamed from: a */
        public AbstractC0747g0 mo4624a(ViewGroup viewGroup) {
            return new C0736b(viewGroup);
        }
    }

    /* renamed from: androidx.fragment.app.FragmentManager$f */
    public class RunnableC0722f implements Runnable {
        public RunnableC0722f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FragmentManager.this.m4555a0(true);
        }
    }

    /* renamed from: androidx.fragment.app.FragmentManager$g */
    public class C0723g implements InterfaceC0764v {

        /* renamed from: a */
        public final /* synthetic */ Fragment f3844a;

        public C0723g(Fragment fragment) {
            this.f3844a = fragment;
        }

        @Override // androidx.fragment.app.InterfaceC0764v
        /* renamed from: a */
        public void mo4482a(FragmentManager fragmentManager, Fragment fragment) {
            this.f3844a.m4409j0(fragment);
        }
    }

    /* renamed from: androidx.fragment.app.FragmentManager$h */
    public class C0724h implements InterfaceC0341a<ActivityResult> {
        public C0724h() {
        }

        @Override // androidx.activity.result.InterfaceC0341a
        /* renamed from: b */
        public void mo1962a(ActivityResult activityResult) {
            LaunchedFragmentInfo launchedFragmentInfoPollFirst = FragmentManager.this.f3795G.pollFirst();
            if (launchedFragmentInfoPollFirst == null) {
                Log.w("FragmentManager", "No Activities were started for result for " + this);
                return;
            }
            String str = launchedFragmentInfoPollFirst.f3836a;
            int i10 = launchedFragmentInfoPollFirst.f3837b;
            Fragment fragmentM4862i = FragmentManager.this.f3809c.m4862i(str);
            if (fragmentM4862i != null) {
                fragmentM4862i.m4403g0(i10, activityResult.m1957c(), activityResult.m1956a());
                return;
            }
            Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str);
        }
    }

    /* renamed from: androidx.fragment.app.FragmentManager$i */
    public class C0725i implements InterfaceC0341a<ActivityResult> {
        public C0725i() {
        }

        @Override // androidx.activity.result.InterfaceC0341a
        /* renamed from: b */
        public void mo1962a(ActivityResult activityResult) {
            LaunchedFragmentInfo launchedFragmentInfoPollFirst = FragmentManager.this.f3795G.pollFirst();
            if (launchedFragmentInfoPollFirst == null) {
                Log.w("FragmentManager", "No IntentSenders were started for " + this);
                return;
            }
            String str = launchedFragmentInfoPollFirst.f3836a;
            int i10 = launchedFragmentInfoPollFirst.f3837b;
            Fragment fragmentM4862i = FragmentManager.this.f3809c.m4862i(str);
            if (fragmentM4862i != null) {
                fragmentM4862i.m4403g0(i10, activityResult.m1957c(), activityResult.m1956a());
                return;
            }
            Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str);
        }
    }

    /* renamed from: androidx.fragment.app.FragmentManager$j */
    public static class C0726j extends AbstractC1365a<IntentSenderRequest, ActivityResult> {
        @Override // p041c.AbstractC1365a
        /* renamed from: b */
        public ActivityResult mo4627a(int i10, Intent intent) {
            return new ActivityResult(i10, intent);
        }
    }

    /* renamed from: androidx.fragment.app.FragmentManager$k */
    public interface InterfaceC0727k {
        /* renamed from: a */
        void m4629a();
    }

    /* renamed from: androidx.fragment.app.FragmentManager$l */
    public interface InterfaceC0728l {
        /* renamed from: a */
        boolean mo4630a(ArrayList<C0734a> arrayList, ArrayList<Boolean> arrayList2);
    }

    /* renamed from: androidx.fragment.app.FragmentManager$m */
    public class C0729m implements InterfaceC0728l {

        /* renamed from: a */
        public final String f3848a;

        /* renamed from: b */
        public final int f3849b;

        /* renamed from: c */
        public final int f3850c;

        public C0729m(String str, int i10, int i11) {
            this.f3848a = str;
            this.f3849b = i10;
            this.f3850c = i11;
        }

        @Override // androidx.fragment.app.FragmentManager.InterfaceC0728l
        /* renamed from: a */
        public boolean mo4630a(ArrayList<C0734a> arrayList, ArrayList<Boolean> arrayList2) {
            Fragment fragment = FragmentManager.this.f3831y;
            if (fragment == null || this.f3849b >= 0 || this.f3848a != null || !fragment.m4423o().m4556a1()) {
                return FragmentManager.this.m4561d1(arrayList, arrayList2, this.f3848a, this.f3849b, this.f3850c);
            }
            return false;
        }
    }

    /* renamed from: C0 */
    public static Fragment m4491C0(View view) {
        Object tag = view.getTag(R$id.fragment_container_view_tag);
        if (tag instanceof Fragment) {
            return (Fragment) tag;
        }
        return null;
    }

    /* renamed from: I0 */
    public static boolean m4492I0(int i10) {
        return f3788S || Log.isLoggable("FragmentManager", i10);
    }

    /* renamed from: c0 */
    public static void m4496c0(ArrayList<C0734a> arrayList, ArrayList<Boolean> arrayList2, int i10, int i11) {
        while (i10 < i11) {
            C0734a c0734a = arrayList.get(i10);
            if (arrayList2.get(i10).booleanValue()) {
                c0734a.m4658w(-1);
                c0734a.m4642B();
            } else {
                c0734a.m4658w(1);
                c0734a.m4641A();
            }
            i10++;
        }
    }

    /* renamed from: j1 */
    public static int m4502j1(int i10) {
        int i11 = 4097;
        if (i10 == 4097) {
            return 8194;
        }
        if (i10 != 8194) {
            i11 = 8197;
            if (i10 == 8197) {
                return 4100;
            }
            if (i10 == 4099) {
                return 4099;
            }
            if (i10 != 4100) {
                return 0;
            }
        }
        return i11;
    }

    /* renamed from: k0 */
    public static FragmentManager m4503k0(View view) {
        FragmentActivity fragmentActivity;
        Fragment fragmentM4504l0 = m4504l0(view);
        if (fragmentM4504l0 != null) {
            if (fragmentM4504l0.m4379X()) {
                return fragmentM4504l0.m4423o();
            }
            throw new IllegalStateException("The Fragment " + fragmentM4504l0 + " that owns View " + view + " has already been destroyed. Nested fragments should always use the child FragmentManager.");
        }
        Context context = view.getContext();
        while (true) {
            if (!(context instanceof ContextWrapper)) {
                fragmentActivity = null;
                break;
            }
            if (context instanceof FragmentActivity) {
                fragmentActivity = (FragmentActivity) context;
                break;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (fragmentActivity != null) {
            return fragmentActivity.m4473U();
        }
        throw new IllegalStateException("View " + view + " is not within a subclass of FragmentActivity.");
    }

    /* renamed from: l0 */
    public static Fragment m4504l0(View view) {
        while (view != null) {
            Fragment fragmentM4491C0 = m4491C0(view);
            if (fragmentM4491C0 != null) {
                return fragmentM4491C0;
            }
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return null;
    }

    /* renamed from: A */
    public boolean m4505A(MenuItem menuItem) {
        if (this.f3827u < 1) {
            return false;
        }
        for (Fragment fragment : this.f3809c.m4868o()) {
            if (fragment != null && fragment.m4365P0(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: A0 */
    public InterfaceC0749h0 m4506A0() {
        InterfaceC0749h0 interfaceC0749h0 = this.f3790B;
        if (interfaceC0749h0 != null) {
            return interfaceC0749h0;
        }
        Fragment fragment = this.f3830x;
        return fragment != null ? fragment.f3742t.m4506A0() : this.f3791C;
    }

    /* renamed from: B */
    public void m4507B() {
        this.f3797I = false;
        this.f3798J = false;
        this.f3804P.m4826q(false);
        m4539S(1);
    }

    /* renamed from: B0 */
    public C12062c.c m4508B0() {
        return this.f3805Q;
    }

    /* renamed from: C */
    public boolean m4509C(Menu menu, MenuInflater menuInflater) {
        if (this.f3827u < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z10 = false;
        for (Fragment fragment : this.f3809c.m4868o()) {
            if (fragment != null && m4528M0(fragment) && fragment.m4369R0(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(fragment);
                z10 = true;
            }
        }
        if (this.f3811e != null) {
            for (int i10 = 0; i10 < this.f3811e.size(); i10++) {
                Fragment fragment2 = this.f3811e.get(i10);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.m4433r0();
                }
            }
        }
        this.f3811e = arrayList;
        return z10;
    }

    /* renamed from: D */
    public void m4510D() {
        this.f3799K = true;
        m4555a0(true);
        m4549X();
        m4597s();
        m4539S(-1);
        Object obj = this.f3828v;
        if (obj instanceof OnTrimMemoryProvider) {
            ((OnTrimMemoryProvider) obj).removeOnTrimMemoryListener(this.f3823q);
        }
        Object obj2 = this.f3828v;
        if (obj2 instanceof OnConfigurationChangedProvider) {
            ((OnConfigurationChangedProvider) obj2).removeOnConfigurationChangedListener(this.f3822p);
        }
        Object obj3 = this.f3828v;
        if (obj3 instanceof InterfaceC13307i) {
            ((InterfaceC13307i) obj3).mo1924w(this.f3824r);
        }
        Object obj4 = this.f3828v;
        if (obj4 instanceof InterfaceC13308j) {
            ((InterfaceC13308j) obj4).mo1922r(this.f3825s);
        }
        Object obj5 = this.f3828v;
        if (obj5 instanceof InterfaceC9622r) {
            ((InterfaceC9622r) obj5).mo1923t(this.f3826t);
        }
        this.f3828v = null;
        this.f3829w = null;
        this.f3830x = null;
        if (this.f3813g != null) {
            this.f3814h.m1950d();
            this.f3813g = null;
        }
        AbstractC0342b<Intent> abstractC0342b = this.f3792D;
        if (abstractC0342b != null) {
            abstractC0342b.mo1963a();
            this.f3793E.mo1963a();
            this.f3794F.mo1963a();
        }
    }

    /* renamed from: D0 */
    public C0786e0 m4511D0(Fragment fragment) {
        return this.f3804P.m4823n(fragment);
    }

    /* renamed from: E */
    public void m4512E() {
        m4539S(1);
    }

    /* renamed from: E0 */
    public void m4513E0() {
        m4555a0(true);
        if (this.f3814h.m1949c()) {
            m4556a1();
        } else {
            this.f3813g.m1938f();
        }
    }

    /* renamed from: F */
    public void m4514F(boolean z10) {
        if (z10 && (this.f3828v instanceof OnTrimMemoryProvider)) {
            m4602t1(new IllegalStateException("Do not call dispatchLowMemory() on host. Host implements OnTrimMemoryProvider and automatically dispatches low memory callbacks to fragments."));
        }
        for (Fragment fragment : this.f3809c.m4868o()) {
            if (fragment != null) {
                fragment.m4380X0();
                if (z10) {
                    fragment.f3744v.m4514F(true);
                }
            }
        }
    }

    /* renamed from: F0 */
    public void m4515F0(Fragment fragment) {
        if (m4492I0(2)) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (fragment.f3696A) {
            return;
        }
        fragment.f3696A = true;
        fragment.f3709N = true ^ fragment.f3709N;
        m4593q1(fragment);
    }

    /* renamed from: G */
    public void m4516G(boolean z10, boolean z11) {
        if (z11 && (this.f3828v instanceof InterfaceC13307i)) {
            m4602t1(new IllegalStateException("Do not call dispatchMultiWindowModeChanged() on host. Host implements OnMultiWindowModeChangedProvider and automatically dispatches multi-window mode changes to fragments."));
        }
        for (Fragment fragment : this.f3809c.m4868o()) {
            if (fragment != null) {
                fragment.m4382Y0(z10);
                if (z11) {
                    fragment.f3744v.m4516G(z10, true);
                }
            }
        }
    }

    /* renamed from: G0 */
    public void m4517G0(Fragment fragment) {
        if (fragment.f3734l && m4522J0(fragment)) {
            this.f3796H = true;
        }
    }

    /* renamed from: H */
    public void m4518H(Fragment fragment) {
        Iterator<InterfaceC0764v> it = this.f3821o.iterator();
        while (it.hasNext()) {
            it.next().mo4482a(this, fragment);
        }
    }

    /* renamed from: H0 */
    public boolean m4519H0() {
        return this.f3799K;
    }

    /* renamed from: I */
    public void m4520I() {
        for (Fragment fragment : this.f3809c.m4865l()) {
            if (fragment != null) {
                fragment.m4445v0(fragment.m4383Z());
                fragment.f3744v.m4520I();
            }
        }
    }

    /* renamed from: J */
    public boolean m4521J(MenuItem menuItem) {
        if (this.f3827u < 1) {
            return false;
        }
        for (Fragment fragment : this.f3809c.m4868o()) {
            if (fragment != null && fragment.m4384Z0(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: J0 */
    public final boolean m4522J0(Fragment fragment) {
        return (fragment.f3700E && fragment.f3701F) || fragment.f3744v.m4588p();
    }

    /* renamed from: K */
    public void m4523K(Menu menu) {
        if (this.f3827u < 1) {
            return;
        }
        for (Fragment fragment : this.f3809c.m4868o()) {
            if (fragment != null) {
                fragment.m4387a1(menu);
            }
        }
    }

    /* renamed from: K0 */
    public final boolean m4524K0() {
        Fragment fragment = this.f3830x;
        if (fragment == null) {
            return true;
        }
        return fragment.m4379X() && this.f3830x.m4341D().m4524K0();
    }

    /* renamed from: L */
    public final void m4525L(Fragment fragment) {
        if (fragment == null || !fragment.equals(m4564f0(fragment.f3728f))) {
            return;
        }
        fragment.m4399e1();
    }

    /* renamed from: L0 */
    public boolean m4526L0(Fragment fragment) {
        if (fragment == null) {
            return false;
        }
        return fragment.m4383Z();
    }

    /* renamed from: M */
    public void m4527M() {
        m4539S(5);
    }

    /* renamed from: M0 */
    public boolean m4528M0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        return fragment.m4389b0();
    }

    /* renamed from: N */
    public void m4529N(boolean z10, boolean z11) {
        if (z11 && (this.f3828v instanceof InterfaceC13308j)) {
            m4602t1(new IllegalStateException("Do not call dispatchPictureInPictureModeChanged() on host. Host implements OnPictureInPictureModeChangedProvider and automatically dispatches picture-in-picture mode changes to fragments."));
        }
        for (Fragment fragment : this.f3809c.m4868o()) {
            if (fragment != null) {
                fragment.m4393c1(z10);
                if (z11) {
                    fragment.f3744v.m4529N(z10, true);
                }
            }
        }
    }

    /* renamed from: N0 */
    public boolean m4530N0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        FragmentManager fragmentManager = fragment.f3742t;
        return fragment.equals(fragmentManager.m4615z0()) && m4530N0(fragmentManager.f3830x);
    }

    /* renamed from: O */
    public boolean m4531O(Menu menu) {
        boolean z10 = false;
        if (this.f3827u < 1) {
            return false;
        }
        for (Fragment fragment : this.f3809c.m4868o()) {
            if (fragment != null && m4528M0(fragment) && fragment.m4396d1(menu)) {
                z10 = true;
            }
        }
        return z10;
    }

    /* renamed from: O0 */
    public boolean m4532O0(int i10) {
        return this.f3827u >= i10;
    }

    /* renamed from: P */
    public void m4533P() {
        m4605u1();
        m4525L(this.f3831y);
    }

    /* renamed from: P0 */
    public boolean m4534P0() {
        return this.f3797I || this.f3798J;
    }

    /* renamed from: Q */
    public void m4535Q() {
        this.f3797I = false;
        this.f3798J = false;
        this.f3804P.m4826q(false);
        m4539S(7);
    }

    /* renamed from: R */
    public void m4537R() {
        this.f3797I = false;
        this.f3798J = false;
        this.f3804P.m4826q(false);
        m4539S(5);
    }

    /* renamed from: R0 */
    public final /* synthetic */ void m4538R0(Configuration configuration) {
        if (m4524K0()) {
            m4614z(configuration, false);
        }
    }

    /* renamed from: S */
    public final void m4539S(int i10) {
        try {
            this.f3808b = true;
            this.f3809c.m4857d(i10);
            m4546V0(i10, false);
            Iterator<AbstractC0747g0> it = m4600t().iterator();
            while (it.hasNext()) {
                it.next().m4753j();
            }
            this.f3808b = false;
            m4555a0(true);
        } catch (Throwable th2) {
            this.f3808b = false;
            throw th2;
        }
    }

    /* renamed from: S0 */
    public final /* synthetic */ void m4540S0(Integer num) {
        if (m4524K0() && num.intValue() == 80) {
            m4514F(false);
        }
    }

    /* renamed from: T */
    public void m4541T() {
        this.f3798J = true;
        this.f3804P.m4826q(true);
        m4539S(4);
    }

    /* renamed from: T0 */
    public final /* synthetic */ void m4542T0(C13301c c13301c) {
        if (m4524K0()) {
            m4516G(c13301c.m79769a(), false);
        }
    }

    /* renamed from: U */
    public void m4543U() {
        m4539S(2);
    }

    /* renamed from: U0 */
    public final /* synthetic */ void m4544U0(C13309k c13309k) {
        if (m4524K0()) {
            m4529N(c13309k.m79801a(), false);
        }
    }

    /* renamed from: V */
    public final void m4545V() {
        if (this.f3800L) {
            this.f3800L = false;
            m4599s1();
        }
    }

    /* renamed from: V0 */
    public void m4546V0(int i10, boolean z10) {
        AbstractC0754l<?> abstractC0754l;
        if (this.f3828v == null && i10 != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z10 || i10 != this.f3827u) {
            this.f3827u = i10;
            this.f3809c.m4873t();
            m4599s1();
            if (this.f3796H && (abstractC0754l = this.f3828v) != null && this.f3827u == 7) {
                abstractC0754l.mo4486q();
                this.f3796H = false;
            }
        }
    }

    /* renamed from: W */
    public void m4547W(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String str2 = str + "    ";
        this.f3809c.m4858e(str, fileDescriptor, printWriter, strArr);
        ArrayList<Fragment> arrayList = this.f3811e;
        if (arrayList != null && (size2 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i10 = 0; i10 < size2; i10++) {
                Fragment fragment = this.f3811e.get(i10);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i10);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
        ArrayList<C0734a> arrayList2 = this.f3810d;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i11 = 0; i11 < size; i11++) {
                C0734a c0734a = this.f3810d.get(i11);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i11);
                printWriter.print(": ");
                printWriter.println(c0734a.toString());
                c0734a.m4660y(str2, printWriter);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f3815i.get());
        synchronized (this.f3807a) {
            try {
                int size3 = this.f3807a.size();
                if (size3 > 0) {
                    printWriter.print(str);
                    printWriter.println("Pending Actions:");
                    for (int i12 = 0; i12 < size3; i12++) {
                        InterfaceC0728l interfaceC0728l = this.f3807a.get(i12);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i12);
                        printWriter.print(": ");
                        printWriter.println(interfaceC0728l);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f3828v);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f3829w);
        if (this.f3830x != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f3830x);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f3827u);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f3797I);
        printWriter.print(" mStopped=");
        printWriter.print(this.f3798J);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f3799K);
        if (this.f3796H) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f3796H);
        }
    }

    /* renamed from: W0 */
    public void m4548W0() {
        if (this.f3828v == null) {
            return;
        }
        this.f3797I = false;
        this.f3798J = false;
        this.f3804P.m4826q(false);
        for (Fragment fragment : this.f3809c.m4868o()) {
            if (fragment != null) {
                fragment.m4398e0();
            }
        }
    }

    /* renamed from: X */
    public final void m4549X() {
        Iterator<AbstractC0747g0> it = m4600t().iterator();
        while (it.hasNext()) {
            it.next().m4753j();
        }
    }

    /* renamed from: X0 */
    public void m4550X0(FragmentContainerView fragmentContainerView) {
        View view;
        for (C0766x c0766x : this.f3809c.m4864k()) {
            Fragment fragmentM4839k = c0766x.m4839k();
            if (fragmentM4839k.f3747y == fragmentContainerView.getId() && (view = fragmentM4839k.f3704I) != null && view.getParent() == null) {
                fragmentM4839k.f3703H = fragmentContainerView;
                c0766x.m4830b();
            }
        }
    }

    /* renamed from: Y */
    public void m4551Y(InterfaceC0728l interfaceC0728l, boolean z10) {
        if (!z10) {
            if (this.f3828v == null) {
                if (!this.f3799K) {
                    throw new IllegalStateException("FragmentManager has not been attached to a host.");
                }
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            m4591q();
        }
        synchronized (this.f3807a) {
            try {
                if (this.f3828v == null) {
                    if (!z10) {
                        throw new IllegalStateException("Activity has been destroyed");
                    }
                } else {
                    this.f3807a.add(interfaceC0728l);
                    m4581m1();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: Y0 */
    public void m4552Y0(C0766x c0766x) {
        Fragment fragmentM4839k = c0766x.m4839k();
        if (fragmentM4839k.f3705J) {
            if (this.f3808b) {
                this.f3800L = true;
            } else {
                fragmentM4839k.f3705J = false;
                c0766x.m4841m();
            }
        }
    }

    /* renamed from: Z */
    public final void m4553Z(boolean z10) {
        if (this.f3808b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.f3828v == null) {
            if (!this.f3799K) {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            throw new IllegalStateException("FragmentManager has been destroyed");
        }
        if (Looper.myLooper() != this.f3828v.m4799j().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z10) {
            m4591q();
        }
        if (this.f3801M == null) {
            this.f3801M = new ArrayList<>();
            this.f3802N = new ArrayList<>();
        }
    }

    /* renamed from: Z0 */
    public void m4554Z0(int i10, int i11, boolean z10) {
        if (i10 >= 0) {
            m4551Y(new C0729m(null, i10, i11), z10);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i10);
    }

    /* renamed from: a0 */
    public boolean m4555a0(boolean z10) {
        m4553Z(z10);
        boolean z11 = false;
        while (m4583n0(this.f3801M, this.f3802N)) {
            z11 = true;
            this.f3808b = true;
            try {
                m4567g1(this.f3801M, this.f3802N);
            } finally {
                m4594r();
            }
        }
        m4605u1();
        m4545V();
        this.f3809c.m4855b();
        return z11;
    }

    /* renamed from: a1 */
    public boolean m4556a1() {
        return m4559c1(null, -1, 0);
    }

    /* renamed from: b0 */
    public void m4557b0(InterfaceC0728l interfaceC0728l, boolean z10) {
        if (z10 && (this.f3828v == null || this.f3799K)) {
            return;
        }
        m4553Z(z10);
        if (interfaceC0728l.mo4630a(this.f3801M, this.f3802N)) {
            this.f3808b = true;
            try {
                m4567g1(this.f3801M, this.f3802N);
            } finally {
                m4594r();
            }
        }
        m4605u1();
        m4545V();
        this.f3809c.m4855b();
    }

    /* renamed from: b1 */
    public boolean m4558b1(int i10, int i11) {
        if (i10 >= 0) {
            return m4559c1(null, i10, i11);
        }
        throw new IllegalArgumentException("Bad id: " + i10);
    }

    /* renamed from: c1 */
    public final boolean m4559c1(String str, int i10, int i11) {
        m4555a0(false);
        m4553Z(true);
        Fragment fragment = this.f3831y;
        if (fragment != null && i10 < 0 && str == null && fragment.m4423o().m4556a1()) {
            return true;
        }
        boolean zM4561d1 = m4561d1(this.f3801M, this.f3802N, str, i10, i11);
        if (zM4561d1) {
            this.f3808b = true;
            try {
                m4567g1(this.f3801M, this.f3802N);
            } finally {
                m4594r();
            }
        }
        m4605u1();
        m4545V();
        this.f3809c.m4855b();
        return zM4561d1;
    }

    /* renamed from: d0 */
    public final void m4560d0(ArrayList<C0734a> arrayList, ArrayList<Boolean> arrayList2, int i10, int i11) {
        boolean z10 = arrayList.get(i10).f3907r;
        ArrayList<Fragment> arrayList3 = this.f3803O;
        if (arrayList3 == null) {
            this.f3803O = new ArrayList<>();
        } else {
            arrayList3.clear();
        }
        this.f3803O.addAll(this.f3809c.m4868o());
        Fragment fragmentM4615z0 = m4615z0();
        boolean z11 = false;
        for (int i12 = i10; i12 < i11; i12++) {
            C0734a c0734a = arrayList.get(i12);
            fragmentM4615z0 = !arrayList2.get(i12).booleanValue() ? c0734a.m4643C(this.f3803O, fragmentM4615z0) : c0734a.m4646F(this.f3803O, fragmentM4615z0);
            z11 = z11 || c0734a.f3898i;
        }
        this.f3803O.clear();
        if (!z10 && this.f3827u >= 1) {
            for (int i13 = i10; i13 < i11; i13++) {
                Iterator<AbstractC0735a0.a> it = arrayList.get(i13).f3892c.iterator();
                while (it.hasNext()) {
                    Fragment fragment = it.next().f3910b;
                    if (fragment != null && fragment.f3742t != null) {
                        this.f3809c.m4871r(m4606v(fragment));
                    }
                }
            }
        }
        m4496c0(arrayList, arrayList2, i10, i11);
        boolean zBooleanValue = arrayList2.get(i11 - 1).booleanValue();
        for (int i14 = i10; i14 < i11; i14++) {
            C0734a c0734a2 = arrayList.get(i14);
            if (zBooleanValue) {
                for (int size = c0734a2.f3892c.size() - 1; size >= 0; size--) {
                    Fragment fragment2 = c0734a2.f3892c.get(size).f3910b;
                    if (fragment2 != null) {
                        m4606v(fragment2).m4841m();
                    }
                }
            } else {
                Iterator<AbstractC0735a0.a> it2 = c0734a2.f3892c.iterator();
                while (it2.hasNext()) {
                    Fragment fragment3 = it2.next().f3910b;
                    if (fragment3 != null) {
                        m4606v(fragment3).m4841m();
                    }
                }
            }
        }
        m4546V0(this.f3827u, true);
        for (AbstractC0747g0 abstractC0747g0 : m4603u(arrayList, i10, i11)) {
            abstractC0747g0.m4759r(zBooleanValue);
            abstractC0747g0.m4757p();
            abstractC0747g0.m4750g();
        }
        while (i10 < i11) {
            C0734a c0734a3 = arrayList.get(i10);
            if (arrayList2.get(i10).booleanValue() && c0734a3.f3888v >= 0) {
                c0734a3.f3888v = -1;
            }
            c0734a3.m4645E();
            i10++;
        }
        if (z11) {
            m4569h1();
        }
    }

    /* renamed from: d1 */
    public boolean m4561d1(ArrayList<C0734a> arrayList, ArrayList<Boolean> arrayList2, String str, int i10, int i11) {
        int iM4566g0 = m4566g0(str, i10, (i11 & 1) != 0);
        if (iM4566g0 < 0) {
            return false;
        }
        for (int size = this.f3810d.size() - 1; size >= iM4566g0; size--) {
            arrayList.add(this.f3810d.remove(size));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }

    /* renamed from: e0 */
    public boolean m4562e0() {
        boolean zM4555a0 = m4555a0(true);
        m4580m0();
        return zM4555a0;
    }

    /* renamed from: e1 */
    public void m4563e1(Bundle bundle, String str, Fragment fragment) {
        if (fragment.f3742t != this) {
            m4602t1(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putString(str, fragment.f3728f);
    }

    /* renamed from: f0 */
    public Fragment m4564f0(String str) {
        return this.f3809c.m4859f(str);
    }

    /* renamed from: f1 */
    public void m4565f1(Fragment fragment) {
        if (m4492I0(2)) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.f3741s);
        }
        boolean z10 = !fragment.m4386a0();
        if (!fragment.f3697B || z10) {
            this.f3809c.m4874u(fragment);
            if (m4522J0(fragment)) {
                this.f3796H = true;
            }
            fragment.f3735m = true;
            m4593q1(fragment);
        }
    }

    /* renamed from: g0 */
    public final int m4566g0(String str, int i10, boolean z10) {
        ArrayList<C0734a> arrayList = this.f3810d;
        if (arrayList == null || arrayList.isEmpty()) {
            return -1;
        }
        if (str == null && i10 < 0) {
            if (z10) {
                return 0;
            }
            return this.f3810d.size() - 1;
        }
        int size = this.f3810d.size() - 1;
        while (size >= 0) {
            C0734a c0734a = this.f3810d.get(size);
            if ((str != null && str.equals(c0734a.m4644D())) || (i10 >= 0 && i10 == c0734a.f3888v)) {
                break;
            }
            size--;
        }
        if (size < 0) {
            return size;
        }
        if (!z10) {
            if (size == this.f3810d.size() - 1) {
                return -1;
            }
            return size + 1;
        }
        while (size > 0) {
            C0734a c0734a2 = this.f3810d.get(size - 1);
            if ((str == null || !str.equals(c0734a2.m4644D())) && (i10 < 0 || i10 != c0734a2.f3888v)) {
                return size;
            }
            size--;
        }
        return size;
    }

    /* renamed from: g1 */
    public final void m4567g1(ArrayList<C0734a> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        int size = arrayList.size();
        int i10 = 0;
        int i11 = 0;
        while (i10 < size) {
            if (!arrayList.get(i10).f3907r) {
                if (i11 != i10) {
                    m4560d0(arrayList, arrayList2, i11, i10);
                }
                i11 = i10 + 1;
                if (arrayList2.get(i10).booleanValue()) {
                    while (i11 < size && arrayList2.get(i11).booleanValue() && !arrayList.get(i11).f3907r) {
                        i11++;
                    }
                }
                m4560d0(arrayList, arrayList2, i10, i11);
                i10 = i11 - 1;
            }
            i10++;
        }
        if (i11 != size) {
            m4560d0(arrayList, arrayList2, i11, size);
        }
    }

    /* renamed from: h0 */
    public Fragment m4568h0(int i10) {
        return this.f3809c.m4860g(i10);
    }

    /* renamed from: h1 */
    public final void m4569h1() {
        if (this.f3819m != null) {
            for (int i10 = 0; i10 < this.f3819m.size(); i10++) {
                this.f3819m.get(i10).m4629a();
            }
        }
    }

    /* renamed from: i */
    public void m4570i(C0734a c0734a) {
        if (this.f3810d == null) {
            this.f3810d = new ArrayList<>();
        }
        this.f3810d.add(c0734a);
    }

    /* renamed from: i0 */
    public Fragment m4571i0(String str) {
        return this.f3809c.m4861h(str);
    }

    /* renamed from: i1 */
    public void m4572i1(Parcelable parcelable) {
        C0766x c0766x;
        Bundle bundle;
        Bundle bundle2;
        if (parcelable == null) {
            return;
        }
        Bundle bundle3 = (Bundle) parcelable;
        for (String str : bundle3.keySet()) {
            if (str.startsWith("result_") && (bundle2 = bundle3.getBundle(str)) != null) {
                bundle2.setClassLoader(this.f3828v.m4798i().getClassLoader());
                this.f3817k.put(str.substring(7), bundle2);
            }
        }
        ArrayList<FragmentState> arrayList = new ArrayList<>();
        for (String str2 : bundle3.keySet()) {
            if (str2.startsWith("fragment_") && (bundle = bundle3.getBundle(str2)) != null) {
                bundle.setClassLoader(this.f3828v.m4798i().getClassLoader());
                arrayList.add((FragmentState) bundle.getParcelable(CommonConstant.ReqAccessTokenParam.STATE_LABEL));
            }
        }
        this.f3809c.m4877x(arrayList);
        FragmentManagerState fragmentManagerState = (FragmentManagerState) bundle3.getParcelable(CommonConstant.ReqAccessTokenParam.STATE_LABEL);
        if (fragmentManagerState == null) {
            return;
        }
        this.f3809c.m4875v();
        Iterator<String> it = fragmentManagerState.f3852a.iterator();
        while (it.hasNext()) {
            FragmentState fragmentStateM4853B = this.f3809c.m4853B(it.next(), null);
            if (fragmentStateM4853B != null) {
                Fragment fragmentM4820j = this.f3804P.m4820j(fragmentStateM4853B.f3861b);
                if (fragmentM4820j != null) {
                    if (m4492I0(2)) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + fragmentM4820j);
                    }
                    c0766x = new C0766x(this.f3820n, this.f3809c, fragmentM4820j, fragmentStateM4853B);
                } else {
                    c0766x = new C0766x(this.f3820n, this.f3809c, this.f3828v.m4798i().getClassLoader(), m4601t0(), fragmentStateM4853B);
                }
                Fragment fragmentM4839k = c0766x.m4839k();
                fragmentM4839k.f3742t = this;
                if (m4492I0(2)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + fragmentM4839k.f3728f + "): " + fragmentM4839k);
                }
                c0766x.m4843o(this.f3828v.m4798i().getClassLoader());
                this.f3809c.m4871r(c0766x);
                c0766x.m4849u(this.f3827u);
            }
        }
        for (Fragment fragment : this.f3804P.m4822m()) {
            if (!this.f3809c.m4856c(fragment.f3728f)) {
                if (m4492I0(2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + fragment + " that was not found in the set of active Fragments " + fragmentManagerState.f3852a);
                }
                this.f3804P.m4825p(fragment);
                fragment.f3742t = this;
                C0766x c0766x2 = new C0766x(this.f3820n, this.f3809c, fragment);
                c0766x2.m4849u(1);
                c0766x2.m4841m();
                fragment.f3735m = true;
                c0766x2.m4841m();
            }
        }
        this.f3809c.m4876w(fragmentManagerState.f3853b);
        if (fragmentManagerState.f3854c != null) {
            this.f3810d = new ArrayList<>(fragmentManagerState.f3854c.length);
            int i10 = 0;
            while (true) {
                BackStackRecordState[] backStackRecordStateArr = fragmentManagerState.f3854c;
                if (i10 >= backStackRecordStateArr.length) {
                    break;
                }
                C0734a c0734aM4327c = backStackRecordStateArr[i10].m4327c(this);
                if (m4492I0(2)) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i10 + " (index " + c0734aM4327c.f3888v + "): " + c0734aM4327c);
                    PrintWriter printWriter = new PrintWriter(new C0745f0("FragmentManager"));
                    c0734aM4327c.m4661z("  ", printWriter, false);
                    printWriter.close();
                }
                this.f3810d.add(c0734aM4327c);
                i10++;
            }
        } else {
            this.f3810d = null;
        }
        this.f3815i.set(fragmentManagerState.f3855d);
        String str3 = fragmentManagerState.f3856e;
        if (str3 != null) {
            Fragment fragmentM4564f0 = m4564f0(str3);
            this.f3831y = fragmentM4564f0;
            m4525L(fragmentM4564f0);
        }
        ArrayList<String> arrayList2 = fragmentManagerState.f3857f;
        if (arrayList2 != null) {
            for (int i11 = 0; i11 < arrayList2.size(); i11++) {
                this.f3816j.put(arrayList2.get(i11), fragmentManagerState.f3858g.get(i11));
            }
        }
        this.f3795G = new ArrayDeque<>(fragmentManagerState.f3859h);
    }

    /* renamed from: j */
    public C0766x m4573j(Fragment fragment) {
        String str = fragment.f3712Q;
        if (str != null) {
            C12062c.m72207f(fragment, str);
        }
        if (m4492I0(2)) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        C0766x c0766xM4606v = m4606v(fragment);
        fragment.f3742t = this;
        this.f3809c.m4871r(c0766xM4606v);
        if (!fragment.f3697B) {
            this.f3809c.m4854a(fragment);
            fragment.f3735m = false;
            if (fragment.f3704I == null) {
                fragment.f3709N = false;
            }
            if (m4522J0(fragment)) {
                this.f3796H = true;
            }
        }
        return c0766xM4606v;
    }

    /* renamed from: j0 */
    public Fragment m4574j0(String str) {
        return this.f3809c.m4862i(str);
    }

    /* renamed from: k */
    public void m4575k(InterfaceC0764v interfaceC0764v) {
        this.f3821o.add(interfaceC0764v);
    }

    /* renamed from: k1 */
    public Bundle m4536Q0() {
        BackStackRecordState[] backStackRecordStateArr;
        int size;
        Bundle bundle = new Bundle();
        m4580m0();
        m4549X();
        m4555a0(true);
        this.f3797I = true;
        this.f3804P.m4826q(true);
        ArrayList<String> arrayListM4878y = this.f3809c.m4878y();
        ArrayList<FragmentState> arrayListM4866m = this.f3809c.m4866m();
        if (!arrayListM4866m.isEmpty()) {
            ArrayList<String> arrayListM4879z = this.f3809c.m4879z();
            ArrayList<C0734a> arrayList = this.f3810d;
            if (arrayList == null || (size = arrayList.size()) <= 0) {
                backStackRecordStateArr = null;
            } else {
                backStackRecordStateArr = new BackStackRecordState[size];
                for (int i10 = 0; i10 < size; i10++) {
                    backStackRecordStateArr[i10] = new BackStackRecordState(this.f3810d.get(i10));
                    if (m4492I0(2)) {
                        Log.v("FragmentManager", "saveAllState: adding back stack #" + i10 + ": " + this.f3810d.get(i10));
                    }
                }
            }
            FragmentManagerState fragmentManagerState = new FragmentManagerState();
            fragmentManagerState.f3852a = arrayListM4878y;
            fragmentManagerState.f3853b = arrayListM4879z;
            fragmentManagerState.f3854c = backStackRecordStateArr;
            fragmentManagerState.f3855d = this.f3815i.get();
            Fragment fragment = this.f3831y;
            if (fragment != null) {
                fragmentManagerState.f3856e = fragment.f3728f;
            }
            fragmentManagerState.f3857f.addAll(this.f3816j.keySet());
            fragmentManagerState.f3858g.addAll(this.f3816j.values());
            fragmentManagerState.f3859h = new ArrayList<>(this.f3795G);
            bundle.putParcelable(CommonConstant.ReqAccessTokenParam.STATE_LABEL, fragmentManagerState);
            for (String str : this.f3817k.keySet()) {
                bundle.putBundle("result_" + str, this.f3817k.get(str));
            }
            Iterator<FragmentState> it = arrayListM4866m.iterator();
            while (it.hasNext()) {
                FragmentState next = it.next();
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable(CommonConstant.ReqAccessTokenParam.STATE_LABEL, next);
                bundle.putBundle("fragment_" + next.f3861b, bundle2);
            }
        } else if (m4492I0(2)) {
            Log.v("FragmentManager", "saveAllState: no fragments!");
        }
        return bundle;
    }

    /* renamed from: l */
    public int m4577l() {
        return this.f3815i.getAndIncrement();
    }

    /* renamed from: l1 */
    public Fragment.SavedState m4578l1(Fragment fragment) {
        C0766x c0766xM4867n = this.f3809c.m4867n(fragment.f3728f);
        if (c0766xM4867n == null || !c0766xM4867n.m4839k().equals(fragment)) {
            m4602t1(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        return c0766xM4867n.m4846r();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"SyntheticAccessor"})
    /* renamed from: m */
    public void m4579m(AbstractC0754l<?> abstractC0754l, AbstractC0750i abstractC0750i, Fragment fragment) {
        String str;
        if (this.f3828v != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f3828v = abstractC0754l;
        this.f3829w = abstractC0750i;
        this.f3830x = fragment;
        if (fragment != null) {
            m4575k(new C0723g(fragment));
        } else if (abstractC0754l instanceof InterfaceC0764v) {
            m4575k((InterfaceC0764v) abstractC0754l);
        }
        if (this.f3830x != null) {
            m4605u1();
        }
        if (abstractC0754l instanceof InterfaceC0337k) {
            InterfaceC0337k interfaceC0337k = (InterfaceC0337k) abstractC0754l;
            OnBackPressedDispatcher onBackPressedDispatcherMo1916h = interfaceC0337k.mo1916h();
            this.f3813g = onBackPressedDispatcherMo1916h;
            InterfaceC0796l interfaceC0796l = interfaceC0337k;
            if (fragment != null) {
                interfaceC0796l = fragment;
            }
            onBackPressedDispatcherMo1916h.m1934b(interfaceC0796l, this.f3814h);
        }
        if (fragment != null) {
            this.f3804P = fragment.f3742t.m4589p0(fragment);
        } else if (abstractC0754l instanceof InterfaceC0788f0) {
            this.f3804P = C0763u.m4814l(((InterfaceC0788f0) abstractC0754l).getViewModelStore());
        } else {
            this.f3804P = new C0763u(false);
        }
        this.f3804P.m4826q(m4534P0());
        this.f3809c.m4852A(this.f3804P);
        Object obj = this.f3828v;
        if ((obj instanceof InterfaceC13514d) && fragment == null) {
            C13512b c13512bMo1909J = ((InterfaceC13514d) obj).mo1909J();
            c13512bMo1909J.m81267h("android:support:fragments", new C13512b.c() { // from class: androidx.fragment.app.s
                @Override // p724w0.C13512b.c
                /* renamed from: a */
                public final Bundle mo1944a() {
                    return this.f4074a.m4536Q0();
                }
            });
            Bundle bundleM81262b = c13512bMo1909J.m81262b("android:support:fragments");
            if (bundleM81262b != null) {
                m4572i1(bundleM81262b);
            }
        }
        Object obj2 = this.f3828v;
        if (obj2 instanceof InterfaceC0344d) {
            AbstractC0343c abstractC0343cMo1919k = ((InterfaceC0344d) obj2).mo1919k();
            if (fragment != null) {
                str = fragment.f3728f + ":";
            } else {
                str = "";
            }
            String str2 = "FragmentManager:" + str;
            this.f3792D = abstractC0343cMo1919k.m1970g(str2 + "StartActivityForResult", new C1367c(), new C0724h());
            this.f3793E = abstractC0343cMo1919k.m1970g(str2 + "StartIntentSenderForResult", new C0726j(), new C0725i());
            this.f3794F = abstractC0343cMo1919k.m1970g(str2 + "RequestPermissions", new C1366b(), new C0717a());
        }
        Object obj3 = this.f3828v;
        if (obj3 instanceof OnConfigurationChangedProvider) {
            ((OnConfigurationChangedProvider) obj3).addOnConfigurationChangedListener(this.f3822p);
        }
        Object obj4 = this.f3828v;
        if (obj4 instanceof OnTrimMemoryProvider) {
            ((OnTrimMemoryProvider) obj4).addOnTrimMemoryListener(this.f3823q);
        }
        Object obj5 = this.f3828v;
        if (obj5 instanceof InterfaceC13307i) {
            ((InterfaceC13307i) obj5).mo1920m(this.f3824r);
        }
        Object obj6 = this.f3828v;
        if (obj6 instanceof InterfaceC13308j) {
            ((InterfaceC13308j) obj6).mo1921o(this.f3825s);
        }
        Object obj7 = this.f3828v;
        if ((obj7 instanceof InterfaceC9622r) && fragment == null) {
            ((InterfaceC9622r) obj7).mo1914c(this.f3826t);
        }
    }

    /* renamed from: m0 */
    public final void m4580m0() {
        Iterator<AbstractC0747g0> it = m4600t().iterator();
        while (it.hasNext()) {
            it.next().m4754k();
        }
    }

    /* renamed from: m1 */
    public void m4581m1() {
        synchronized (this.f3807a) {
            try {
                if (this.f3807a.size() == 1) {
                    this.f3828v.m4799j().removeCallbacks(this.f3806R);
                    this.f3828v.m4799j().post(this.f3806R);
                    m4605u1();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: n */
    public void m4582n(Fragment fragment) {
        if (m4492I0(2)) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.f3697B) {
            fragment.f3697B = false;
            if (fragment.f3734l) {
                return;
            }
            this.f3809c.m4854a(fragment);
            if (m4492I0(2)) {
                Log.v("FragmentManager", "add from attach: " + fragment);
            }
            if (m4522J0(fragment)) {
                this.f3796H = true;
            }
        }
    }

    /* renamed from: n0 */
    public final boolean m4583n0(ArrayList<C0734a> arrayList, ArrayList<Boolean> arrayList2) {
        synchronized (this.f3807a) {
            if (this.f3807a.isEmpty()) {
                return false;
            }
            try {
                int size = this.f3807a.size();
                boolean zMo4630a = false;
                for (int i10 = 0; i10 < size; i10++) {
                    zMo4630a |= this.f3807a.get(i10).mo4630a(arrayList, arrayList2);
                }
                return zMo4630a;
            } finally {
                this.f3807a.clear();
                this.f3828v.m4799j().removeCallbacks(this.f3806R);
            }
        }
    }

    /* renamed from: n1 */
    public void m4584n1(Fragment fragment, boolean z10) {
        ViewGroup viewGroupM4598s0 = m4598s0(fragment);
        if (viewGroupM4598s0 == null || !(viewGroupM4598s0 instanceof FragmentContainerView)) {
            return;
        }
        ((FragmentContainerView) viewGroupM4598s0).setDrawDisappearingViewsLast(!z10);
    }

    /* renamed from: o */
    public AbstractC0735a0 m4585o() {
        return new C0734a(this);
    }

    /* renamed from: o0 */
    public int m4586o0() {
        ArrayList<C0734a> arrayList = this.f3810d;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    /* renamed from: o1 */
    public void m4587o1(Fragment fragment, AbstractC0791h.c cVar) {
        if (fragment.equals(m4564f0(fragment.f3728f)) && (fragment.f3743u == null || fragment.f3742t == this)) {
            fragment.f3713R = cVar;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    /* renamed from: p */
    public boolean m4588p() {
        boolean zM4522J0 = false;
        for (Fragment fragment : this.f3809c.m4865l()) {
            if (fragment != null) {
                zM4522J0 = m4522J0(fragment);
            }
            if (zM4522J0) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: p0 */
    public final C0763u m4589p0(Fragment fragment) {
        return this.f3804P.m4821k(fragment);
    }

    /* renamed from: p1 */
    public void m4590p1(Fragment fragment) {
        if (fragment == null || (fragment.equals(m4564f0(fragment.f3728f)) && (fragment.f3743u == null || fragment.f3742t == this))) {
            Fragment fragment2 = this.f3831y;
            this.f3831y = fragment;
            m4525L(fragment2);
            m4525L(this.f3831y);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    /* renamed from: q */
    public final void m4591q() {
        if (m4534P0()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    /* renamed from: q0 */
    public AbstractC0750i m4592q0() {
        return this.f3829w;
    }

    /* renamed from: q1 */
    public final void m4593q1(Fragment fragment) {
        ViewGroup viewGroupM4598s0 = m4598s0(fragment);
        if (viewGroupM4598s0 == null || fragment.m4429q() + fragment.m4438t() + fragment.m4345F() + fragment.m4347G() <= 0) {
            return;
        }
        int i10 = R$id.visible_removing_fragment_view_tag;
        if (viewGroupM4598s0.getTag(i10) == null) {
            viewGroupM4598s0.setTag(i10, fragment);
        }
        ((Fragment) viewGroupM4598s0.getTag(i10)).m4452x1(fragment.m4343E());
    }

    /* renamed from: r */
    public final void m4594r() {
        this.f3808b = false;
        this.f3802N.clear();
        this.f3801M.clear();
    }

    /* renamed from: r0 */
    public Fragment m4595r0(Bundle bundle, String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        Fragment fragmentM4564f0 = m4564f0(string);
        if (fragmentM4564f0 == null) {
            m4602t1(new IllegalStateException("Fragment no longer exists for key " + str + ": unique id " + string));
        }
        return fragmentM4564f0;
    }

    /* renamed from: r1 */
    public void m4596r1(Fragment fragment) {
        if (m4492I0(2)) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.f3696A) {
            fragment.f3696A = false;
            fragment.f3709N = !fragment.f3709N;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0039  */
    /* renamed from: s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m4597s() {
        /*
            r4 = this;
            androidx.fragment.app.l<?> r0 = r4.f3828v
            boolean r1 = r0 instanceof androidx.lifecycle.InterfaceC0788f0
            if (r1 == 0) goto L11
            androidx.fragment.app.z r0 = r4.f3809c
            androidx.fragment.app.u r0 = r0.m4869p()
            boolean r0 = r0.m4824o()
            goto L27
        L11:
            android.content.Context r0 = r0.m4798i()
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L29
            androidx.fragment.app.l<?> r0 = r4.f3828v
            android.content.Context r0 = r0.m4798i()
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            r0 = r0 ^ 1
        L27:
            if (r0 == 0) goto L5b
        L29:
            java.util.Map<java.lang.String, androidx.fragment.app.BackStackState> r0 = r4.f3816j
            java.util.Collection r0 = r0.values()
            java.util.Iterator r0 = r0.iterator()
        L33:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L5b
            java.lang.Object r1 = r0.next()
            androidx.fragment.app.BackStackState r1 = (androidx.fragment.app.BackStackState) r1
            java.util.List<java.lang.String> r1 = r1.f3693a
            java.util.Iterator r1 = r1.iterator()
        L45:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L33
            java.lang.Object r2 = r1.next()
            java.lang.String r2 = (java.lang.String) r2
            androidx.fragment.app.z r3 = r4.f3809c
            androidx.fragment.app.u r3 = r3.m4869p()
            r3.m4818h(r2)
            goto L45
        L5b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManager.m4597s():void");
    }

    /* renamed from: s0 */
    public final ViewGroup m4598s0(Fragment fragment) {
        ViewGroup viewGroup = fragment.f3703H;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (fragment.f3747y > 0 && this.f3829w.mo4464e()) {
            View viewMo4463d = this.f3829w.mo4463d(fragment.f3747y);
            if (viewMo4463d instanceof ViewGroup) {
                return (ViewGroup) viewMo4463d;
            }
        }
        return null;
    }

    /* renamed from: s1 */
    public final void m4599s1() {
        Iterator<C0766x> it = this.f3809c.m4864k().iterator();
        while (it.hasNext()) {
            m4552Y0(it.next());
        }
    }

    /* renamed from: t */
    public final Set<AbstractC0747g0> m4600t() {
        HashSet hashSet = new HashSet();
        Iterator<C0766x> it = this.f3809c.m4864k().iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = it.next().m4839k().f3703H;
            if (viewGroup != null) {
                hashSet.add(AbstractC0747g0.m4744o(viewGroup, m4506A0()));
            }
        }
        return hashSet;
    }

    /* renamed from: t0 */
    public C0753k m4601t0() {
        C0753k c0753k = this.f3832z;
        if (c0753k != null) {
            return c0753k;
        }
        Fragment fragment = this.f3830x;
        return fragment != null ? fragment.f3742t.m4601t0() : this.f3789A;
    }

    /* renamed from: t1 */
    public final void m4602t1(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new C0745f0("FragmentManager"));
        AbstractC0754l<?> abstractC0754l = this.f3828v;
        if (abstractC0754l != null) {
            try {
                abstractC0754l.mo4483l("  ", null, printWriter, new String[0]);
                throw runtimeException;
            } catch (Exception e10) {
                Log.e("FragmentManager", "Failed dumping state", e10);
                throw runtimeException;
            }
        }
        try {
            m4547W("  ", null, printWriter, new String[0]);
            throw runtimeException;
        } catch (Exception e11) {
            Log.e("FragmentManager", "Failed dumping state", e11);
            throw runtimeException;
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("FragmentManager{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append(" in ");
        Fragment fragment = this.f3830x;
        if (fragment != null) {
            sb2.append(fragment.getClass().getSimpleName());
            sb2.append("{");
            sb2.append(Integer.toHexString(System.identityHashCode(this.f3830x)));
            sb2.append("}");
        } else {
            AbstractC0754l<?> abstractC0754l = this.f3828v;
            if (abstractC0754l != null) {
                sb2.append(abstractC0754l.getClass().getSimpleName());
                sb2.append("{");
                sb2.append(Integer.toHexString(System.identityHashCode(this.f3828v)));
                sb2.append("}");
            } else {
                sb2.append("null");
            }
        }
        sb2.append("}}");
        return sb2.toString();
    }

    /* renamed from: u */
    public final Set<AbstractC0747g0> m4603u(ArrayList<C0734a> arrayList, int i10, int i11) {
        ViewGroup viewGroup;
        HashSet hashSet = new HashSet();
        while (i10 < i11) {
            Iterator<AbstractC0735a0.a> it = arrayList.get(i10).f3892c.iterator();
            while (it.hasNext()) {
                Fragment fragment = it.next().f3910b;
                if (fragment != null && (viewGroup = fragment.f3703H) != null) {
                    hashSet.add(AbstractC0747g0.m4743n(viewGroup, this));
                }
            }
            i10++;
        }
        return hashSet;
    }

    /* renamed from: u0 */
    public List<Fragment> m4604u0() {
        return this.f3809c.m4868o();
    }

    /* renamed from: u1 */
    public final void m4605u1() {
        synchronized (this.f3807a) {
            try {
                if (this.f3807a.isEmpty()) {
                    this.f3814h.m1952f(m4586o0() > 0 && m4530N0(this.f3830x));
                } else {
                    this.f3814h.m1952f(true);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: v */
    public C0766x m4606v(Fragment fragment) {
        C0766x c0766xM4867n = this.f3809c.m4867n(fragment.f3728f);
        if (c0766xM4867n != null) {
            return c0766xM4867n;
        }
        C0766x c0766x = new C0766x(this.f3820n, this.f3809c, fragment);
        c0766x.m4843o(this.f3828v.m4798i().getClassLoader());
        c0766x.m4849u(this.f3827u);
        return c0766x;
    }

    /* renamed from: v0 */
    public AbstractC0754l<?> m4607v0() {
        return this.f3828v;
    }

    /* renamed from: w */
    public void m4608w(Fragment fragment) {
        if (m4492I0(2)) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (fragment.f3697B) {
            return;
        }
        fragment.f3697B = true;
        if (fragment.f3734l) {
            if (m4492I0(2)) {
                Log.v("FragmentManager", "remove from detach: " + fragment);
            }
            this.f3809c.m4874u(fragment);
            if (m4522J0(fragment)) {
                this.f3796H = true;
            }
            m4593q1(fragment);
        }
    }

    /* renamed from: w0 */
    public LayoutInflater.Factory2 m4609w0() {
        return this.f3812f;
    }

    /* renamed from: x */
    public void m4610x() {
        this.f3797I = false;
        this.f3798J = false;
        this.f3804P.m4826q(false);
        m4539S(4);
    }

    /* renamed from: x0 */
    public C0756n m4611x0() {
        return this.f3820n;
    }

    /* renamed from: y */
    public void m4612y() {
        this.f3797I = false;
        this.f3798J = false;
        this.f3804P.m4826q(false);
        m4539S(0);
    }

    /* renamed from: y0 */
    public Fragment m4613y0() {
        return this.f3830x;
    }

    /* renamed from: z */
    public void m4614z(Configuration configuration, boolean z10) {
        if (z10 && (this.f3828v instanceof OnConfigurationChangedProvider)) {
            m4602t1(new IllegalStateException("Do not call dispatchConfigurationChanged() on host. Host implements OnConfigurationChangedProvider and automatically dispatches configuration changes to fragments."));
        }
        for (Fragment fragment : this.f3809c.m4868o()) {
            if (fragment != null) {
                fragment.m4363O0(configuration);
                if (z10) {
                    fragment.f3744v.m4614z(configuration, true);
                }
            }
        }
    }

    /* renamed from: z0 */
    public Fragment m4615z0() {
        return this.f3831y;
    }
}
