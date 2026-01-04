package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.R$id;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import p024b0.C1089e;
import p273f0.C9603h0;

/* renamed from: androidx.fragment.app.g0 */
/* loaded from: classes.dex */
public abstract class AbstractC0747g0 {

    /* renamed from: a */
    public final ViewGroup f4021a;

    /* renamed from: b */
    public final ArrayList<e> f4022b = new ArrayList<>();

    /* renamed from: c */
    public final ArrayList<e> f4023c = new ArrayList<>();

    /* renamed from: d */
    public boolean f4024d = false;

    /* renamed from: e */
    public boolean f4025e = false;

    /* renamed from: androidx.fragment.app.g0$a */
    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ d f4026a;

        public a(d dVar) {
            this.f4026a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AbstractC0747g0.this.f4022b.contains(this.f4026a)) {
                this.f4026a.m4765e().m4774b(this.f4026a.m4766f().f3704I);
            }
        }
    }

    /* renamed from: androidx.fragment.app.g0$b */
    public class b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ d f4028a;

        public b(d dVar) {
            this.f4028a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC0747g0.this.f4022b.remove(this.f4028a);
            AbstractC0747g0.this.f4023c.remove(this.f4028a);
        }
    }

    /* renamed from: androidx.fragment.app.g0$c */
    public static /* synthetic */ class c {

        /* renamed from: a */
        public static final /* synthetic */ int[] f4030a;

        /* renamed from: b */
        public static final /* synthetic */ int[] f4031b;

        static {
            int[] iArr = new int[e.b.values().length];
            f4031b = iArr;
            try {
                iArr[e.b.ADDING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4031b[e.b.REMOVING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4031b[e.b.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[e.c.values().length];
            f4030a = iArr2;
            try {
                iArr2[e.c.REMOVED.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4030a[e.c.VISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4030a[e.c.GONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f4030a[e.c.INVISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* renamed from: androidx.fragment.app.g0$d */
    public static class d extends e {

        /* renamed from: h */
        public final C0766x f4032h;

        public d(e.c cVar, e.b bVar, C0766x c0766x, C1089e c1089e) {
            super(cVar, bVar, c0766x.m4839k(), c1089e);
            this.f4032h = c0766x;
        }

        @Override // androidx.fragment.app.AbstractC0747g0.e
        /* renamed from: c */
        public void mo4760c() {
            super.mo4760c();
            this.f4032h.m4841m();
        }

        @Override // androidx.fragment.app.AbstractC0747g0.e
        /* renamed from: l */
        public void mo4761l() {
            if (m4767g() != e.b.ADDING) {
                if (m4767g() == e.b.REMOVING) {
                    Fragment fragmentM4839k = this.f4032h.m4839k();
                    View viewM4422n1 = fragmentM4839k.m4422n1();
                    if (FragmentManager.m4492I0(2)) {
                        Log.v("FragmentManager", "Clearing focus " + viewM4422n1.findFocus() + " on view " + viewM4422n1 + " for Fragment " + fragmentM4839k);
                    }
                    viewM4422n1.clearFocus();
                    return;
                }
                return;
            }
            Fragment fragmentM4839k2 = this.f4032h.m4839k();
            View viewFindFocus = fragmentM4839k2.f3704I.findFocus();
            if (viewFindFocus != null) {
                fragmentM4839k2.m4440t1(viewFindFocus);
                if (FragmentManager.m4492I0(2)) {
                    Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + fragmentM4839k2);
                }
            }
            View viewM4422n12 = m4766f().m4422n1();
            if (viewM4422n12.getParent() == null) {
                this.f4032h.m4830b();
                viewM4422n12.setAlpha(0.0f);
            }
            if (viewM4422n12.getAlpha() == 0.0f && viewM4422n12.getVisibility() == 0) {
                viewM4422n12.setVisibility(4);
            }
            viewM4422n12.setAlpha(fragmentM4839k2.m4349H());
        }
    }

    /* renamed from: androidx.fragment.app.g0$e */
    public static class e {

        /* renamed from: a */
        public c f4033a;

        /* renamed from: b */
        public b f4034b;

        /* renamed from: c */
        public final Fragment f4035c;

        /* renamed from: d */
        public final List<Runnable> f4036d = new ArrayList();

        /* renamed from: e */
        public final HashSet<C1089e> f4037e = new HashSet<>();

        /* renamed from: f */
        public boolean f4038f = false;

        /* renamed from: g */
        public boolean f4039g = false;

        /* renamed from: androidx.fragment.app.g0$e$a */
        public class a implements C1089e.b {
            public a() {
            }

            @Override // p024b0.C1089e.b
            public void onCancel() {
                e.this.m4763b();
            }
        }

        /* renamed from: androidx.fragment.app.g0$e$b */
        public enum b {
            NONE,
            ADDING,
            REMOVING
        }

        /* renamed from: androidx.fragment.app.g0$e$c */
        public enum c {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;

            /* renamed from: e */
            public static c m4772e(int i10) {
                if (i10 == 0) {
                    return VISIBLE;
                }
                if (i10 == 4) {
                    return INVISIBLE;
                }
                if (i10 == 8) {
                    return GONE;
                }
                throw new IllegalArgumentException("Unknown visibility " + i10);
            }

            /* renamed from: f */
            public static c m4773f(View view) {
                return (view.getAlpha() == 0.0f && view.getVisibility() == 0) ? INVISIBLE : m4772e(view.getVisibility());
            }

            /* renamed from: b */
            public void m4774b(View view) {
                int i10 = c.f4030a[ordinal()];
                if (i10 == 1) {
                    ViewGroup viewGroup = (ViewGroup) view.getParent();
                    if (viewGroup != null) {
                        if (FragmentManager.m4492I0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view + " from container " + viewGroup);
                        }
                        viewGroup.removeView(view);
                        return;
                    }
                    return;
                }
                if (i10 == 2) {
                    if (FragmentManager.m4492I0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
                    }
                    view.setVisibility(0);
                    return;
                }
                if (i10 == 3) {
                    if (FragmentManager.m4492I0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
                    }
                    view.setVisibility(8);
                    return;
                }
                if (i10 != 4) {
                    return;
                }
                if (FragmentManager.m4492I0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
                }
                view.setVisibility(4);
            }
        }

        public e(c cVar, b bVar, Fragment fragment, C1089e c1089e) {
            this.f4033a = cVar;
            this.f4034b = bVar;
            this.f4035c = fragment;
            c1089e.m6470c(new a());
        }

        /* renamed from: a */
        public final void m4762a(Runnable runnable) {
            this.f4036d.add(runnable);
        }

        /* renamed from: b */
        public final void m4763b() {
            if (m4768h()) {
                return;
            }
            this.f4038f = true;
            if (this.f4037e.isEmpty()) {
                mo4760c();
                return;
            }
            Iterator it = new ArrayList(this.f4037e).iterator();
            while (it.hasNext()) {
                ((C1089e) it.next()).m6468a();
            }
        }

        /* renamed from: c */
        public void mo4760c() {
            if (this.f4039g) {
                return;
            }
            if (FragmentManager.m4492I0(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
            }
            this.f4039g = true;
            Iterator<Runnable> it = this.f4036d.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
        }

        /* renamed from: d */
        public final void m4764d(C1089e c1089e) {
            if (this.f4037e.remove(c1089e) && this.f4037e.isEmpty()) {
                mo4760c();
            }
        }

        /* renamed from: e */
        public c m4765e() {
            return this.f4033a;
        }

        /* renamed from: f */
        public final Fragment m4766f() {
            return this.f4035c;
        }

        /* renamed from: g */
        public b m4767g() {
            return this.f4034b;
        }

        /* renamed from: h */
        public final boolean m4768h() {
            return this.f4038f;
        }

        /* renamed from: i */
        public final boolean m4769i() {
            return this.f4039g;
        }

        /* renamed from: j */
        public final void m4770j(C1089e c1089e) {
            mo4761l();
            this.f4037e.add(c1089e);
        }

        /* renamed from: k */
        public final void m4771k(c cVar, b bVar) {
            int i10 = c.f4031b[bVar.ordinal()];
            if (i10 == 1) {
                if (this.f4033a == c.REMOVED) {
                    if (FragmentManager.m4492I0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f4035c + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.f4034b + " to ADDING.");
                    }
                    this.f4033a = c.VISIBLE;
                    this.f4034b = b.ADDING;
                    return;
                }
                return;
            }
            if (i10 == 2) {
                if (FragmentManager.m4492I0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f4035c + " mFinalState = " + this.f4033a + " -> REMOVED. mLifecycleImpact  = " + this.f4034b + " to REMOVING.");
                }
                this.f4033a = c.REMOVED;
                this.f4034b = b.REMOVING;
                return;
            }
            if (i10 == 3 && this.f4033a != c.REMOVED) {
                if (FragmentManager.m4492I0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f4035c + " mFinalState = " + this.f4033a + " -> " + cVar + ". ");
                }
                this.f4033a = cVar;
            }
        }

        /* renamed from: l */
        public void mo4761l() {
        }

        public String toString() {
            return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {mFinalState = " + this.f4033a + "} {mLifecycleImpact = " + this.f4034b + "} {mFragment = " + this.f4035c + "}";
        }
    }

    public AbstractC0747g0(ViewGroup viewGroup) {
        this.f4021a = viewGroup;
    }

    /* renamed from: n */
    public static AbstractC0747g0 m4743n(ViewGroup viewGroup, FragmentManager fragmentManager) {
        return m4744o(viewGroup, fragmentManager.m4506A0());
    }

    /* renamed from: o */
    public static AbstractC0747g0 m4744o(ViewGroup viewGroup, InterfaceC0749h0 interfaceC0749h0) {
        int i10 = R$id.special_effects_controller_view_tag;
        Object tag = viewGroup.getTag(i10);
        if (tag instanceof AbstractC0747g0) {
            return (AbstractC0747g0) tag;
        }
        AbstractC0747g0 abstractC0747g0Mo4624a = interfaceC0749h0.mo4624a(viewGroup);
        viewGroup.setTag(i10, abstractC0747g0Mo4624a);
        return abstractC0747g0Mo4624a;
    }

    /* renamed from: a */
    public final void m4745a(e.c cVar, e.b bVar, C0766x c0766x) {
        synchronized (this.f4022b) {
            try {
                C1089e c1089e = new C1089e();
                e eVarM4751h = m4751h(c0766x.m4839k());
                if (eVarM4751h != null) {
                    eVarM4751h.m4771k(cVar, bVar);
                    return;
                }
                d dVar = new d(cVar, bVar, c0766x, c1089e);
                this.f4022b.add(dVar);
                dVar.m4762a(new a(dVar));
                dVar.m4762a(new b(dVar));
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: b */
    public void m4746b(e.c cVar, C0766x c0766x) {
        if (FragmentManager.m4492I0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + c0766x.m4839k());
        }
        m4745a(cVar, e.b.ADDING, c0766x);
    }

    /* renamed from: c */
    public void m4747c(C0766x c0766x) {
        if (FragmentManager.m4492I0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + c0766x.m4839k());
        }
        m4745a(e.c.GONE, e.b.NONE, c0766x);
    }

    /* renamed from: d */
    public void m4748d(C0766x c0766x) {
        if (FragmentManager.m4492I0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + c0766x.m4839k());
        }
        m4745a(e.c.REMOVED, e.b.REMOVING, c0766x);
    }

    /* renamed from: e */
    public void m4749e(C0766x c0766x) {
        if (FragmentManager.m4492I0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + c0766x.m4839k());
        }
        m4745a(e.c.VISIBLE, e.b.NONE, c0766x);
    }

    /* renamed from: f */
    public abstract void mo4672f(List<e> list, boolean z10);

    /* renamed from: g */
    public void m4750g() {
        if (this.f4025e) {
            return;
        }
        if (!C9603h0.m59863S(this.f4021a)) {
            m4753j();
            this.f4024d = false;
            return;
        }
        synchronized (this.f4022b) {
            try {
                if (!this.f4022b.isEmpty()) {
                    ArrayList arrayList = new ArrayList(this.f4023c);
                    this.f4023c.clear();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        e eVar = (e) it.next();
                        if (FragmentManager.m4492I0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + eVar);
                        }
                        eVar.m4763b();
                        if (!eVar.m4769i()) {
                            this.f4023c.add(eVar);
                        }
                    }
                    m4758q();
                    ArrayList arrayList2 = new ArrayList(this.f4022b);
                    this.f4022b.clear();
                    this.f4023c.addAll(arrayList2);
                    if (FragmentManager.m4492I0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Executing pending operations");
                    }
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        ((e) it2.next()).mo4761l();
                    }
                    mo4672f(arrayList2, this.f4024d);
                    this.f4024d = false;
                    if (FragmentManager.m4492I0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Finished executing pending operations");
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: h */
    public final e m4751h(Fragment fragment) {
        Iterator<e> it = this.f4022b.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next.m4766f().equals(fragment) && !next.m4768h()) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: i */
    public final e m4752i(Fragment fragment) {
        Iterator<e> it = this.f4023c.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next.m4766f().equals(fragment) && !next.m4768h()) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: j */
    public void m4753j() {
        String str;
        String str2;
        if (FragmentManager.m4492I0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Forcing all operations to complete");
        }
        boolean zM59863S = C9603h0.m59863S(this.f4021a);
        synchronized (this.f4022b) {
            try {
                m4758q();
                Iterator<e> it = this.f4022b.iterator();
                while (it.hasNext()) {
                    it.next().mo4761l();
                }
                Iterator it2 = new ArrayList(this.f4023c).iterator();
                while (it2.hasNext()) {
                    e eVar = (e) it2.next();
                    if (FragmentManager.m4492I0(2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("SpecialEffectsController: ");
                        if (zM59863S) {
                            str2 = "";
                        } else {
                            str2 = "Container " + this.f4021a + " is not attached to window. ";
                        }
                        sb2.append(str2);
                        sb2.append("Cancelling running operation ");
                        sb2.append(eVar);
                        Log.v("FragmentManager", sb2.toString());
                    }
                    eVar.m4763b();
                }
                Iterator it3 = new ArrayList(this.f4022b).iterator();
                while (it3.hasNext()) {
                    e eVar2 = (e) it3.next();
                    if (FragmentManager.m4492I0(2)) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("SpecialEffectsController: ");
                        if (zM59863S) {
                            str = "";
                        } else {
                            str = "Container " + this.f4021a + " is not attached to window. ";
                        }
                        sb3.append(str);
                        sb3.append("Cancelling pending operation ");
                        sb3.append(eVar2);
                        Log.v("FragmentManager", sb3.toString());
                    }
                    eVar2.m4763b();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: k */
    public void m4754k() {
        if (this.f4025e) {
            if (FragmentManager.m4492I0(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: Forcing postponed operations");
            }
            this.f4025e = false;
            m4750g();
        }
    }

    /* renamed from: l */
    public e.b m4755l(C0766x c0766x) {
        e eVarM4751h = m4751h(c0766x.m4839k());
        e.b bVarM4767g = eVarM4751h != null ? eVarM4751h.m4767g() : null;
        e eVarM4752i = m4752i(c0766x.m4839k());
        return (eVarM4752i == null || !(bVarM4767g == null || bVarM4767g == e.b.NONE)) ? bVarM4767g : eVarM4752i.m4767g();
    }

    /* renamed from: m */
    public ViewGroup m4756m() {
        return this.f4021a;
    }

    /* renamed from: p */
    public void m4757p() {
        synchronized (this.f4022b) {
            try {
                m4758q();
                this.f4025e = false;
                int size = this.f4022b.size() - 1;
                while (true) {
                    if (size < 0) {
                        break;
                    }
                    e eVar = this.f4022b.get(size);
                    e.c cVarM4773f = e.c.m4773f(eVar.m4766f().f3704I);
                    e.c cVarM4765e = eVar.m4765e();
                    e.c cVar = e.c.VISIBLE;
                    if (cVarM4765e == cVar && cVarM4773f != cVar) {
                        this.f4025e = eVar.m4766f().m4392c0();
                        break;
                    }
                    size--;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: q */
    public final void m4758q() {
        Iterator<e> it = this.f4022b.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next.m4767g() == e.b.ADDING) {
                next.m4771k(e.c.m4772e(next.m4766f().m4422n1().getVisibility()), e.b.NONE);
            }
        }
    }

    /* renamed from: r */
    public void m4759r(boolean z10) {
        this.f4024d = z10;
    }
}
