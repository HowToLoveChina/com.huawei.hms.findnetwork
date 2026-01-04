package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.fragment.app.AbstractC0747g0;
import androidx.fragment.app.C0748h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p024b0.C1089e;
import p243e0.C9373h;
import p273f0.C9603h0;
import p273f0.C9609k0;
import p273f0.ViewTreeObserverOnPreDrawListenerC9595e0;
import p438l.C11207a;

/* renamed from: androidx.fragment.app.b */
/* loaded from: classes.dex */
public class C0736b extends AbstractC0747g0 {

    /* renamed from: androidx.fragment.app.b$a */
    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f3918a;

        static {
            int[] iArr = new int[AbstractC0747g0.e.c.values().length];
            f3918a = iArr;
            try {
                iArr[AbstractC0747g0.e.c.GONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3918a[AbstractC0747g0.e.c.INVISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3918a[AbstractC0747g0.e.c.REMOVED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3918a[AbstractC0747g0.e.c.VISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* renamed from: androidx.fragment.app.b$b */
    public class b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ List f3919a;

        /* renamed from: b */
        public final /* synthetic */ AbstractC0747g0.e f3920b;

        public b(List list, AbstractC0747g0.e eVar) {
            this.f3919a = list;
            this.f3920b = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f3919a.contains(this.f3920b)) {
                this.f3919a.remove(this.f3920b);
                C0736b.this.m4673s(this.f3920b);
            }
        }
    }

    /* renamed from: androidx.fragment.app.b$c */
    public class c extends AnimatorListenerAdapter {

        /* renamed from: a */
        public final /* synthetic */ ViewGroup f3922a;

        /* renamed from: b */
        public final /* synthetic */ View f3923b;

        /* renamed from: c */
        public final /* synthetic */ boolean f3924c;

        /* renamed from: d */
        public final /* synthetic */ AbstractC0747g0.e f3925d;

        /* renamed from: e */
        public final /* synthetic */ k f3926e;

        public c(ViewGroup viewGroup, View view, boolean z10, AbstractC0747g0.e eVar, k kVar) {
            this.f3922a = viewGroup;
            this.f3923b = view;
            this.f3924c = z10;
            this.f3925d = eVar;
            this.f3926e = kVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f3922a.endViewTransition(this.f3923b);
            if (this.f3924c) {
                this.f3925d.m4765e().m4774b(this.f3923b);
            }
            this.f3926e.m4681a();
            if (FragmentManager.m4492I0(2)) {
                Log.v("FragmentManager", "Animator from operation " + this.f3925d + " has ended.");
            }
        }
    }

    /* renamed from: androidx.fragment.app.b$d */
    public class d implements C1089e.b {

        /* renamed from: a */
        public final /* synthetic */ Animator f3928a;

        /* renamed from: b */
        public final /* synthetic */ AbstractC0747g0.e f3929b;

        public d(Animator animator, AbstractC0747g0.e eVar) {
            this.f3928a = animator;
            this.f3929b = eVar;
        }

        @Override // p024b0.C1089e.b
        public void onCancel() {
            this.f3928a.end();
            if (FragmentManager.m4492I0(2)) {
                Log.v("FragmentManager", "Animator from operation " + this.f3929b + " has been canceled.");
            }
        }
    }

    /* renamed from: androidx.fragment.app.b$e */
    public class e implements Animation.AnimationListener {

        /* renamed from: a */
        public final /* synthetic */ AbstractC0747g0.e f3931a;

        /* renamed from: b */
        public final /* synthetic */ ViewGroup f3932b;

        /* renamed from: c */
        public final /* synthetic */ View f3933c;

        /* renamed from: d */
        public final /* synthetic */ k f3934d;

        /* renamed from: androidx.fragment.app.b$e$a */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e eVar = e.this;
                eVar.f3932b.endViewTransition(eVar.f3933c);
                e.this.f3934d.m4681a();
            }
        }

        public e(AbstractC0747g0.e eVar, ViewGroup viewGroup, View view, k kVar) {
            this.f3931a = eVar;
            this.f3932b = viewGroup;
            this.f3933c = view;
            this.f3934d = kVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f3932b.post(new a());
            if (FragmentManager.m4492I0(2)) {
                Log.v("FragmentManager", "Animation from operation " + this.f3931a + " has ended.");
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            if (FragmentManager.m4492I0(2)) {
                Log.v("FragmentManager", "Animation from operation " + this.f3931a + " has reached onAnimationStart.");
            }
        }
    }

    /* renamed from: androidx.fragment.app.b$f */
    public class f implements C1089e.b {

        /* renamed from: a */
        public final /* synthetic */ View f3937a;

        /* renamed from: b */
        public final /* synthetic */ ViewGroup f3938b;

        /* renamed from: c */
        public final /* synthetic */ k f3939c;

        /* renamed from: d */
        public final /* synthetic */ AbstractC0747g0.e f3940d;

        public f(View view, ViewGroup viewGroup, k kVar, AbstractC0747g0.e eVar) {
            this.f3937a = view;
            this.f3938b = viewGroup;
            this.f3939c = kVar;
            this.f3940d = eVar;
        }

        @Override // p024b0.C1089e.b
        public void onCancel() {
            this.f3937a.clearAnimation();
            this.f3938b.endViewTransition(this.f3937a);
            this.f3939c.m4681a();
            if (FragmentManager.m4492I0(2)) {
                Log.v("FragmentManager", "Animation from operation " + this.f3940d + " has been cancelled.");
            }
        }
    }

    /* renamed from: androidx.fragment.app.b$g */
    public class g implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ AbstractC0747g0.e f3942a;

        /* renamed from: b */
        public final /* synthetic */ AbstractC0747g0.e f3943b;

        /* renamed from: c */
        public final /* synthetic */ boolean f3944c;

        /* renamed from: d */
        public final /* synthetic */ C11207a f3945d;

        public g(AbstractC0747g0.e eVar, AbstractC0747g0.e eVar2, boolean z10, C11207a c11207a) {
            this.f3942a = eVar;
            this.f3943b = eVar2;
            this.f3944c = z10;
            this.f3945d = c11207a;
        }

        @Override // java.lang.Runnable
        public void run() {
            C0737b0.m4691a(this.f3942a.m4766f(), this.f3943b.m4766f(), this.f3944c, this.f3945d, false);
        }
    }

    /* renamed from: androidx.fragment.app.b$h */
    public class h implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ AbstractC0741d0 f3947a;

        /* renamed from: b */
        public final /* synthetic */ View f3948b;

        /* renamed from: c */
        public final /* synthetic */ Rect f3949c;

        public h(AbstractC0741d0 abstractC0741d0, View view, Rect rect) {
            this.f3947a = abstractC0741d0;
            this.f3948b = view;
            this.f3949c = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f3947a.m4733h(this.f3948b, this.f3949c);
        }
    }

    /* renamed from: androidx.fragment.app.b$i */
    public class i implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ ArrayList f3951a;

        public i(ArrayList arrayList) {
            this.f3951a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            C0737b0.m4694d(this.f3951a, 4);
        }
    }

    /* renamed from: androidx.fragment.app.b$j */
    public class j implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ m f3953a;

        /* renamed from: b */
        public final /* synthetic */ AbstractC0747g0.e f3954b;

        public j(m mVar, AbstractC0747g0.e eVar) {
            this.f3953a = mVar;
            this.f3954b = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f3953a.m4681a();
            if (FragmentManager.m4492I0(2)) {
                Log.v("FragmentManager", "Transition for operation " + this.f3954b + "has completed");
            }
        }
    }

    /* renamed from: androidx.fragment.app.b$k */
    public static class k extends l {

        /* renamed from: c */
        public boolean f3956c;

        /* renamed from: d */
        public boolean f3957d;

        /* renamed from: e */
        public C0748h.a f3958e;

        public k(AbstractC0747g0.e eVar, C1089e c1089e, boolean z10) {
            super(eVar, c1089e);
            this.f3957d = false;
            this.f3956c = z10;
        }

        /* renamed from: e */
        public C0748h.a m4680e(Context context) throws Resources.NotFoundException {
            if (this.f3957d) {
                return this.f3958e;
            }
            C0748h.a aVarM4776b = C0748h.m4776b(context, m4682b().m4766f(), m4682b().m4765e() == AbstractC0747g0.e.c.VISIBLE, this.f3956c);
            this.f3958e = aVarM4776b;
            this.f3957d = true;
            return aVarM4776b;
        }
    }

    /* renamed from: androidx.fragment.app.b$l */
    public static class l {

        /* renamed from: a */
        public final AbstractC0747g0.e f3959a;

        /* renamed from: b */
        public final C1089e f3960b;

        public l(AbstractC0747g0.e eVar, C1089e c1089e) {
            this.f3959a = eVar;
            this.f3960b = c1089e;
        }

        /* renamed from: a */
        public void m4681a() {
            this.f3959a.m4764d(this.f3960b);
        }

        /* renamed from: b */
        public AbstractC0747g0.e m4682b() {
            return this.f3959a;
        }

        /* renamed from: c */
        public C1089e m4683c() {
            return this.f3960b;
        }

        /* renamed from: d */
        public boolean m4684d() {
            AbstractC0747g0.e.c cVar;
            AbstractC0747g0.e.c cVarM4773f = AbstractC0747g0.e.c.m4773f(this.f3959a.m4766f().f3704I);
            AbstractC0747g0.e.c cVarM4765e = this.f3959a.m4765e();
            return cVarM4773f == cVarM4765e || !(cVarM4773f == (cVar = AbstractC0747g0.e.c.VISIBLE) || cVarM4765e == cVar);
        }
    }

    /* renamed from: androidx.fragment.app.b$m */
    public static class m extends l {

        /* renamed from: c */
        public final Object f3961c;

        /* renamed from: d */
        public final boolean f3962d;

        /* renamed from: e */
        public final Object f3963e;

        public m(AbstractC0747g0.e eVar, C1089e c1089e, boolean z10, boolean z11) {
            super(eVar, c1089e);
            if (eVar.m4765e() == AbstractC0747g0.e.c.VISIBLE) {
                this.f3961c = z10 ? eVar.m4766f().m4351I() : eVar.m4766f().m4432r();
                this.f3962d = z10 ? eVar.m4766f().m4414l() : eVar.m4766f().m4411k();
            } else {
                this.f3961c = z10 ? eVar.m4766f().m4356L() : eVar.m4766f().m4441u();
                this.f3962d = true;
            }
            if (!z11) {
                this.f3963e = null;
            } else if (z10) {
                this.f3963e = eVar.m4766f().m4360N();
            } else {
                this.f3963e = eVar.m4766f().m4358M();
            }
        }

        /* renamed from: e */
        public AbstractC0741d0 m4685e() {
            AbstractC0741d0 abstractC0741d0M4686f = m4686f(this.f3961c);
            AbstractC0741d0 abstractC0741d0M4686f2 = m4686f(this.f3963e);
            if (abstractC0741d0M4686f == null || abstractC0741d0M4686f2 == null || abstractC0741d0M4686f == abstractC0741d0M4686f2) {
                return abstractC0741d0M4686f != null ? abstractC0741d0M4686f : abstractC0741d0M4686f2;
            }
            throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + m4682b().m4766f() + " returned Transition " + this.f3961c + " which uses a different Transition  type than its shared element transition " + this.f3963e);
        }

        /* renamed from: f */
        public final AbstractC0741d0 m4686f(Object obj) {
            if (obj == null) {
                return null;
            }
            AbstractC0741d0 abstractC0741d0 = C0737b0.f3964a;
            if (abstractC0741d0 != null && abstractC0741d0.mo4715e(obj)) {
                return abstractC0741d0;
            }
            AbstractC0741d0 abstractC0741d02 = C0737b0.f3965b;
            if (abstractC0741d02 != null && abstractC0741d02.mo4715e(obj)) {
                return abstractC0741d02;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + m4682b().m4766f() + " is not a valid framework Transition or AndroidX Transition");
        }

        /* renamed from: g */
        public Object m4687g() {
            return this.f3963e;
        }

        /* renamed from: h */
        public Object m4688h() {
            return this.f3961c;
        }

        /* renamed from: i */
        public boolean m4689i() {
            return this.f3963e != null;
        }

        /* renamed from: j */
        public boolean m4690j() {
            return this.f3962d;
        }
    }

    public C0736b(ViewGroup viewGroup) {
        super(viewGroup);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00a8  */
    @Override // androidx.fragment.app.AbstractC0747g0
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo4672f(java.util.List<androidx.fragment.app.AbstractC0747g0.e> r14, boolean r15) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 263
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.C0736b.mo4672f(java.util.List, boolean):void");
    }

    /* renamed from: s */
    public void m4673s(AbstractC0747g0.e eVar) {
        eVar.m4765e().m4774b(eVar.m4766f().f3704I);
    }

    /* renamed from: t */
    public void m4674t(ArrayList<View> arrayList, View view) {
        if (!(view instanceof ViewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(view);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (C9609k0.m60070a(viewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(viewGroup);
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if (childAt.getVisibility() == 0) {
                m4674t(arrayList, childAt);
            }
        }
    }

    /* renamed from: u */
    public void m4675u(Map<String, View> map, View view) {
        String strM59850J = C9603h0.m59850J(view);
        if (strM59850J != null) {
            map.put(strM59850J, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = viewGroup.getChildAt(i10);
                if (childAt.getVisibility() == 0) {
                    m4675u(map, childAt);
                }
            }
        }
    }

    /* renamed from: v */
    public void m4676v(C11207a<String, View> c11207a, Collection<String> collection) {
        Iterator<Map.Entry<String, View>> it = c11207a.entrySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(C9603h0.m59850J(it.next().getValue()))) {
                it.remove();
            }
        }
    }

    /* renamed from: w */
    public final void m4677w(List<k> list, List<AbstractC0747g0.e> list2, boolean z10, Map<AbstractC0747g0.e, Boolean> map) throws Resources.NotFoundException {
        int i10;
        boolean z11;
        Context context;
        View view;
        int i11;
        AbstractC0747g0.e eVar;
        ViewGroup viewGroupM4756m = m4756m();
        Context context2 = viewGroupM4756m.getContext();
        ArrayList arrayList = new ArrayList();
        Iterator<k> it = list.iterator();
        boolean z12 = false;
        while (true) {
            i10 = 2;
            if (!it.hasNext()) {
                break;
            }
            k next = it.next();
            if (next.m4684d()) {
                next.m4681a();
            } else {
                C0748h.a aVarM4680e = next.m4680e(context2);
                if (aVarM4680e == null) {
                    next.m4681a();
                } else {
                    Animator animator = aVarM4680e.f4051b;
                    if (animator == null) {
                        arrayList.add(next);
                    } else {
                        AbstractC0747g0.e eVarM4682b = next.m4682b();
                        Fragment fragmentM4766f = eVarM4682b.m4766f();
                        if (Boolean.TRUE.equals(map.get(eVarM4682b))) {
                            if (FragmentManager.m4492I0(2)) {
                                Log.v("FragmentManager", "Ignoring Animator set on " + fragmentM4766f + " as this Fragment was involved in a Transition.");
                            }
                            next.m4681a();
                        } else {
                            boolean z13 = eVarM4682b.m4765e() == AbstractC0747g0.e.c.GONE;
                            if (z13) {
                                list2.remove(eVarM4682b);
                            }
                            View view2 = fragmentM4766f.f3704I;
                            viewGroupM4756m.startViewTransition(view2);
                            animator.addListener(new c(viewGroupM4756m, view2, z13, eVarM4682b, next));
                            animator.setTarget(view2);
                            animator.start();
                            if (FragmentManager.m4492I0(2)) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("Animator from operation ");
                                eVar = eVarM4682b;
                                sb2.append(eVar);
                                sb2.append(" has started.");
                                Log.v("FragmentManager", sb2.toString());
                            } else {
                                eVar = eVarM4682b;
                            }
                            next.m4683c().m6470c(new d(animator, eVar));
                            z12 = true;
                        }
                    }
                }
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            k kVar = (k) it2.next();
            AbstractC0747g0.e eVarM4682b2 = kVar.m4682b();
            Fragment fragmentM4766f2 = eVarM4682b2.m4766f();
            if (z10) {
                if (FragmentManager.m4492I0(i10)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + fragmentM4766f2 + " as Animations cannot run alongside Transitions.");
                }
                kVar.m4681a();
            } else if (z12) {
                if (FragmentManager.m4492I0(i10)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + fragmentM4766f2 + " as Animations cannot run alongside Animators.");
                }
                kVar.m4681a();
            } else {
                View view3 = fragmentM4766f2.f3704I;
                Animation animation = (Animation) C9373h.m58745f(((C0748h.a) C9373h.m58745f(kVar.m4680e(context2))).f4050a);
                if (eVarM4682b2.m4765e() != AbstractC0747g0.e.c.REMOVED) {
                    view3.startAnimation(animation);
                    kVar.m4681a();
                    z11 = z12;
                    context = context2;
                    i11 = i10;
                    view = view3;
                } else {
                    viewGroupM4756m.startViewTransition(view3);
                    C0748h.b bVar = new C0748h.b(animation, viewGroupM4756m, view3);
                    z11 = z12;
                    context = context2;
                    view = view3;
                    bVar.setAnimationListener(new e(eVarM4682b2, viewGroupM4756m, view3, kVar));
                    view.startAnimation(bVar);
                    i11 = 2;
                    if (FragmentManager.m4492I0(2)) {
                        Log.v("FragmentManager", "Animation from operation " + eVarM4682b2 + " has started.");
                    }
                }
                kVar.m4683c().m6470c(new f(view, viewGroupM4756m, kVar, eVarM4682b2));
                i10 = i11;
                z12 = z11;
                context2 = context;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: x */
    public final Map<AbstractC0747g0.e, Boolean> m4678x(List<m> list, List<AbstractC0747g0.e> list2, boolean z10, AbstractC0747g0.e eVar, AbstractC0747g0.e eVar2) {
        String str;
        String str2;
        String str3;
        View view;
        Object obj;
        ArrayList<View> arrayList;
        Object obj2;
        ArrayList<View> arrayList2;
        HashMap map;
        View view2;
        Object objMo4718k;
        C11207a c11207a;
        ArrayList<View> arrayList3;
        AbstractC0747g0.e eVar3;
        ArrayList<View> arrayList4;
        Rect rect;
        AbstractC0741d0 abstractC0741d0;
        HashMap map2;
        AbstractC0747g0.e eVar4;
        View view3;
        View view4;
        View view5;
        boolean z11 = z10;
        AbstractC0747g0.e eVar5 = eVar;
        AbstractC0747g0.e eVar6 = eVar2;
        HashMap map3 = new HashMap();
        AbstractC0741d0 abstractC0741d02 = null;
        for (m mVar : list) {
            if (!mVar.m4684d()) {
                AbstractC0741d0 abstractC0741d0M4685e = mVar.m4685e();
                if (abstractC0741d02 == null) {
                    abstractC0741d02 = abstractC0741d0M4685e;
                } else if (abstractC0741d0M4685e != null && abstractC0741d02 != abstractC0741d0M4685e) {
                    throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + mVar.m4682b().m4766f() + " returned Transition " + mVar.m4688h() + " which uses a different Transition  type than other Fragments.");
                }
            }
        }
        if (abstractC0741d02 == null) {
            for (m mVar2 : list) {
                map3.put(mVar2.m4682b(), Boolean.FALSE);
                mVar2.m4681a();
            }
            return map3;
        }
        View view6 = new View(m4756m().getContext());
        Rect rect2 = new Rect();
        ArrayList<View> arrayList5 = new ArrayList<>();
        ArrayList<View> arrayList6 = new ArrayList<>();
        C11207a c11207a2 = new C11207a();
        Iterator<m> it = list.iterator();
        Object obj3 = null;
        View view7 = null;
        boolean z12 = false;
        while (true) {
            str = "FragmentManager";
            if (!it.hasNext()) {
                break;
            }
            m next = it.next();
            if (!next.m4689i() || eVar5 == null || eVar6 == null) {
                c11207a = c11207a2;
                arrayList3 = arrayList6;
                eVar3 = eVar5;
                arrayList4 = arrayList5;
                rect = rect2;
                abstractC0741d0 = abstractC0741d02;
                map2 = map3;
                View view8 = view6;
                eVar4 = eVar6;
                view3 = view8;
                view7 = view7;
            } else {
                Object objMo4726u = abstractC0741d02.mo4726u(abstractC0741d02.mo4716f(next.m4687g()));
                ArrayList<String> arrayListM4362O = eVar2.m4766f().m4362O();
                ArrayList<String> arrayListM4362O2 = eVar.m4766f().m4362O();
                ArrayList<String> arrayListM4364P = eVar.m4766f().m4364P();
                View view9 = view7;
                int i10 = 0;
                while (i10 < arrayListM4364P.size()) {
                    int iIndexOf = arrayListM4362O.indexOf(arrayListM4364P.get(i10));
                    ArrayList<String> arrayList7 = arrayListM4364P;
                    if (iIndexOf != -1) {
                        arrayListM4362O.set(iIndexOf, arrayListM4362O2.get(i10));
                    }
                    i10++;
                    arrayListM4364P = arrayList7;
                }
                ArrayList<String> arrayListM4364P2 = eVar2.m4766f().m4364P();
                if (z11) {
                    eVar.m4766f().m4435s();
                    eVar2.m4766f().m4444v();
                } else {
                    eVar.m4766f().m4444v();
                    eVar2.m4766f().m4435s();
                }
                int i11 = 0;
                for (int size = arrayListM4362O.size(); i11 < size; size = size) {
                    c11207a2.put(arrayListM4362O.get(i11), arrayListM4364P2.get(i11));
                    i11++;
                }
                if (FragmentManager.m4492I0(2)) {
                    Log.v("FragmentManager", ">>> entering view names <<<");
                    for (Iterator<String> it2 = arrayListM4364P2.iterator(); it2.hasNext(); it2 = it2) {
                        Log.v("FragmentManager", "Name: " + it2.next());
                    }
                    Log.v("FragmentManager", ">>> exiting view names <<<");
                    for (Iterator<String> it3 = arrayListM4362O.iterator(); it3.hasNext(); it3 = it3) {
                        Log.v("FragmentManager", "Name: " + it3.next());
                    }
                }
                C11207a<String, View> c11207a3 = new C11207a<>();
                m4675u(c11207a3, eVar.m4766f().f3704I);
                c11207a3.m67269o(arrayListM4362O);
                c11207a2.m67269o(c11207a3.keySet());
                C11207a<String, View> c11207a4 = new C11207a<>();
                m4675u(c11207a4, eVar2.m4766f().f3704I);
                c11207a4.m67269o(arrayListM4364P2);
                c11207a4.m67269o(c11207a2.values());
                C0737b0.m4693c(c11207a2, c11207a4);
                m4676v(c11207a3, c11207a2.keySet());
                m4676v(c11207a4, c11207a2.values());
                if (c11207a2.isEmpty()) {
                    arrayList5.clear();
                    arrayList6.clear();
                    c11207a = c11207a2;
                    arrayList3 = arrayList6;
                    eVar3 = eVar5;
                    arrayList4 = arrayList5;
                    rect = rect2;
                    view3 = view6;
                    abstractC0741d0 = abstractC0741d02;
                    view7 = view9;
                    obj3 = null;
                    eVar4 = eVar2;
                    map2 = map3;
                } else {
                    C0737b0.m4691a(eVar2.m4766f(), eVar.m4766f(), z11, c11207a3, true);
                    HashMap map4 = map3;
                    View view10 = view6;
                    c11207a = c11207a2;
                    ArrayList<View> arrayList8 = arrayList6;
                    ViewTreeObserverOnPreDrawListenerC9595e0.m59820a(m4756m(), new g(eVar2, eVar, z10, c11207a4));
                    arrayList5.addAll(c11207a3.values());
                    if (arrayListM4362O.isEmpty()) {
                        view7 = view9;
                    } else {
                        view7 = (View) c11207a3.get(arrayListM4362O.get(0));
                        abstractC0741d02.mo4722p(objMo4726u, view7);
                    }
                    arrayList3 = arrayList8;
                    arrayList3.addAll(c11207a4.values());
                    if (arrayListM4364P2.isEmpty() || (view5 = (View) c11207a4.get(arrayListM4364P2.get(0))) == null) {
                        view4 = view10;
                    } else {
                        ViewTreeObserverOnPreDrawListenerC9595e0.m59820a(m4756m(), new h(abstractC0741d02, view5, rect2));
                        view4 = view10;
                        z12 = true;
                    }
                    abstractC0741d02.mo4724s(objMo4726u, view4, arrayList5);
                    arrayList4 = arrayList5;
                    rect = rect2;
                    view3 = view4;
                    abstractC0741d0 = abstractC0741d02;
                    abstractC0741d02.mo4720n(objMo4726u, null, null, null, null, objMo4726u, arrayList3);
                    Boolean bool = Boolean.TRUE;
                    eVar3 = eVar;
                    map2 = map4;
                    map2.put(eVar3, bool);
                    eVar4 = eVar2;
                    map2.put(eVar4, bool);
                    obj3 = objMo4726u;
                }
            }
            eVar5 = eVar3;
            arrayList5 = arrayList4;
            rect2 = rect;
            map3 = map2;
            c11207a2 = c11207a;
            z11 = z10;
            arrayList6 = arrayList3;
            abstractC0741d02 = abstractC0741d0;
            AbstractC0747g0.e eVar7 = eVar4;
            view6 = view3;
            eVar6 = eVar7;
        }
        View view11 = view7;
        C11207a c11207a5 = c11207a2;
        ArrayList<View> arrayList9 = arrayList6;
        AbstractC0747g0.e eVar8 = eVar5;
        ArrayList<View> arrayList10 = arrayList5;
        Rect rect3 = rect2;
        AbstractC0741d0 abstractC0741d03 = abstractC0741d02;
        HashMap map5 = map3;
        View view12 = view6;
        AbstractC0747g0.e eVar9 = eVar6;
        View view13 = view12;
        ArrayList arrayList11 = new ArrayList();
        Object obj4 = null;
        Object objMo4718k2 = null;
        for (m mVar3 : list) {
            if (mVar3.m4684d()) {
                map5.put(mVar3.m4682b(), Boolean.FALSE);
                mVar3.m4681a();
            } else {
                Object objMo4716f = abstractC0741d03.mo4716f(mVar3.m4688h());
                AbstractC0747g0.e eVarM4682b = mVar3.m4682b();
                boolean z13 = obj3 != null && (eVarM4682b == eVar8 || eVarM4682b == eVar9);
                if (objMo4716f == null) {
                    if (!z13) {
                        map5.put(eVarM4682b, Boolean.FALSE);
                        mVar3.m4681a();
                    }
                    arrayList2 = arrayList9;
                    str3 = str;
                    arrayList = arrayList10;
                    view = view13;
                    objMo4718k = obj4;
                    map = map5;
                    view2 = view11;
                } else {
                    str3 = str;
                    ArrayList<View> arrayList12 = new ArrayList<>();
                    Object obj5 = obj4;
                    m4674t(arrayList12, eVarM4682b.m4766f().f3704I);
                    if (z13) {
                        if (eVarM4682b == eVar8) {
                            arrayList12.removeAll(arrayList10);
                        } else {
                            arrayList12.removeAll(arrayList9);
                        }
                    }
                    if (arrayList12.isEmpty()) {
                        abstractC0741d03.mo4712a(objMo4716f, view13);
                        arrayList2 = arrayList9;
                        arrayList = arrayList10;
                        view = view13;
                        obj2 = objMo4718k2;
                        map = map5;
                        obj = obj5;
                    } else {
                        abstractC0741d03.mo4713b(objMo4716f, arrayList12);
                        view = view13;
                        obj = obj5;
                        arrayList = arrayList10;
                        obj2 = objMo4718k2;
                        arrayList2 = arrayList9;
                        map = map5;
                        abstractC0741d03.mo4720n(objMo4716f, objMo4716f, arrayList12, null, null, null, null);
                        if (eVarM4682b.m4765e() == AbstractC0747g0.e.c.GONE) {
                            list2.remove(eVarM4682b);
                            ArrayList<View> arrayList13 = new ArrayList<>(arrayList12);
                            arrayList13.remove(eVarM4682b.m4766f().f3704I);
                            abstractC0741d03.mo4719m(objMo4716f, eVarM4682b.m4766f().f3704I, arrayList13);
                            ViewTreeObserverOnPreDrawListenerC9595e0.m59820a(m4756m(), new i(arrayList12));
                        }
                    }
                    if (eVarM4682b.m4765e() == AbstractC0747g0.e.c.VISIBLE) {
                        arrayList11.addAll(arrayList12);
                        if (z12) {
                            abstractC0741d03.mo4721o(objMo4716f, rect3);
                        }
                        view2 = view11;
                    } else {
                        view2 = view11;
                        abstractC0741d03.mo4722p(objMo4716f, view2);
                    }
                    map.put(eVarM4682b, Boolean.TRUE);
                    if (mVar3.m4690j()) {
                        objMo4718k2 = abstractC0741d03.mo4718k(obj2, objMo4716f, null);
                        objMo4718k = obj;
                    } else {
                        objMo4718k = abstractC0741d03.mo4718k(obj, objMo4716f, null);
                        objMo4718k2 = obj2;
                    }
                }
                eVar9 = eVar2;
                map5 = map;
                obj4 = objMo4718k;
                view11 = view2;
                str = str3;
                view13 = view;
                arrayList10 = arrayList;
                arrayList9 = arrayList2;
            }
        }
        ArrayList<View> arrayList14 = arrayList9;
        String str4 = str;
        ArrayList<View> arrayList15 = arrayList10;
        HashMap map6 = map5;
        Object objMo4717j = abstractC0741d03.mo4717j(objMo4718k2, obj4, obj3);
        if (objMo4717j == null) {
            return map6;
        }
        for (m mVar4 : list) {
            if (!mVar4.m4684d()) {
                Object objM4688h = mVar4.m4688h();
                AbstractC0747g0.e eVarM4682b2 = mVar4.m4682b();
                HashMap map7 = map6;
                boolean z14 = obj3 != null && (eVarM4682b2 == eVar8 || eVarM4682b2 == eVar2);
                if (objM4688h == null && !z14) {
                    str2 = str4;
                } else if (C9603h0.m59864T(m4756m())) {
                    str2 = str4;
                    abstractC0741d03.mo4723q(mVar4.m4682b().m4766f(), objMo4717j, mVar4.m4683c(), new j(mVar4, eVarM4682b2));
                } else {
                    if (FragmentManager.m4492I0(2)) {
                        str2 = str4;
                        Log.v(str2, "SpecialEffectsController: Container " + m4756m() + " has not been laid out. Completing operation " + eVarM4682b2);
                    } else {
                        str2 = str4;
                    }
                    mVar4.m4681a();
                }
                map6 = map7;
                str4 = str2;
            }
        }
        HashMap map8 = map6;
        String str5 = str4;
        if (!C9603h0.m59864T(m4756m())) {
            return map8;
        }
        C0737b0.m4694d(arrayList11, 4);
        ArrayList<String> arrayListM4734l = abstractC0741d03.m4734l(arrayList14);
        if (FragmentManager.m4492I0(2)) {
            Log.v(str5, ">>>>> Beginning transition <<<<<");
            Log.v(str5, ">>>>> SharedElementFirstOutViews <<<<<");
            Iterator<View> it4 = arrayList15.iterator();
            while (it4.hasNext()) {
                View next2 = it4.next();
                Log.v(str5, "View: " + next2 + " Name: " + C9603h0.m59850J(next2));
            }
            Log.v(str5, ">>>>> SharedElementLastInViews <<<<<");
            Iterator<View> it5 = arrayList14.iterator();
            while (it5.hasNext()) {
                View next3 = it5.next();
                Log.v(str5, "View: " + next3 + " Name: " + C9603h0.m59850J(next3));
            }
        }
        abstractC0741d03.mo4714c(m4756m(), objMo4717j);
        abstractC0741d03.m4735r(m4756m(), arrayList15, arrayList14, arrayListM4734l, c11207a5);
        C0737b0.m4694d(arrayList11, 0);
        abstractC0741d03.mo4725t(obj3, arrayList15, arrayList14);
        return map8;
    }

    /* renamed from: y */
    public final void m4679y(List<AbstractC0747g0.e> list) {
        Fragment fragmentM4766f = list.get(list.size() - 1).m4766f();
        for (AbstractC0747g0.e eVar : list) {
            eVar.m4766f().f3707L.f3759c = fragmentM4766f.f3707L.f3759c;
            eVar.m4766f().f3707L.f3760d = fragmentM4766f.f3707L.f3760d;
            eVar.m4766f().f3707L.f3761e = fragmentM4766f.f3707L.f3761e;
            eVar.m4766f().f3707L.f3762f = fragmentM4766f.f3707L.f3762f;
        }
    }
}
