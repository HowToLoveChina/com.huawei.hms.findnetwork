package androidx.fragment.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import p024b0.C1089e;

/* renamed from: androidx.fragment.app.c0 */
/* loaded from: classes.dex */
public class C0739c0 extends AbstractC0741d0 {

    /* renamed from: androidx.fragment.app.c0$a */
    public class a extends Transition.EpicenterCallback {

        /* renamed from: a */
        public final /* synthetic */ Rect f3988a;

        public a(Rect rect) {
            this.f3988a = rect;
        }

        @Override // android.transition.Transition.EpicenterCallback
        public Rect onGetEpicenter(Transition transition) {
            return this.f3988a;
        }
    }

    /* renamed from: androidx.fragment.app.c0$b */
    public class b implements Transition.TransitionListener {

        /* renamed from: a */
        public final /* synthetic */ View f3990a;

        /* renamed from: b */
        public final /* synthetic */ ArrayList f3991b;

        public b(View view, ArrayList arrayList) {
            this.f3990a = view;
            this.f3991b = arrayList;
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            f.m4729b(transition, this);
            this.f3990a.setVisibility(8);
            int size = this.f3991b.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((View) this.f3991b.get(i10)).setVisibility(0);
            }
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionPause(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionResume(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
            f.m4729b(transition, this);
            f.m4728a(transition, this);
        }
    }

    /* renamed from: androidx.fragment.app.c0$c */
    public class c implements Transition.TransitionListener {

        /* renamed from: a */
        public final /* synthetic */ Object f3993a;

        /* renamed from: b */
        public final /* synthetic */ ArrayList f3994b;

        /* renamed from: c */
        public final /* synthetic */ Object f3995c;

        /* renamed from: d */
        public final /* synthetic */ ArrayList f3996d;

        /* renamed from: e */
        public final /* synthetic */ Object f3997e;

        /* renamed from: f */
        public final /* synthetic */ ArrayList f3998f;

        public c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.f3993a = obj;
            this.f3994b = arrayList;
            this.f3995c = obj2;
            this.f3996d = arrayList2;
            this.f3997e = obj3;
            this.f3998f = arrayList3;
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            f.m4729b(transition, this);
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionPause(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionResume(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
            Object obj = this.f3993a;
            if (obj != null) {
                C0739c0.this.m4727w(obj, this.f3994b, null);
            }
            Object obj2 = this.f3995c;
            if (obj2 != null) {
                C0739c0.this.m4727w(obj2, this.f3996d, null);
            }
            Object obj3 = this.f3997e;
            if (obj3 != null) {
                C0739c0.this.m4727w(obj3, this.f3998f, null);
            }
        }
    }

    /* renamed from: androidx.fragment.app.c0$d */
    public class d implements Transition.TransitionListener {

        /* renamed from: a */
        public final /* synthetic */ Runnable f4000a;

        public d(Runnable runnable) {
            this.f4000a = runnable;
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            this.f4000a.run();
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionPause(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionResume(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
        }
    }

    /* renamed from: androidx.fragment.app.c0$e */
    public class e extends Transition.EpicenterCallback {

        /* renamed from: a */
        public final /* synthetic */ Rect f4002a;

        public e(Rect rect) {
            this.f4002a = rect;
        }

        @Override // android.transition.Transition.EpicenterCallback
        public Rect onGetEpicenter(Transition transition) {
            Rect rect = this.f4002a;
            if (rect == null || rect.isEmpty()) {
                return null;
            }
            return this.f4002a;
        }
    }

    /* renamed from: androidx.fragment.app.c0$f */
    public static class f {
        /* renamed from: a */
        public static void m4728a(Transition transition, Transition.TransitionListener transitionListener) {
            transition.addListener(transitionListener);
        }

        /* renamed from: b */
        public static void m4729b(Transition transition, Transition.TransitionListener transitionListener) {
            transition.removeListener(transitionListener);
        }
    }

    /* renamed from: v */
    public static boolean m4711v(Transition transition) {
        return (AbstractC0741d0.m4732i(transition.getTargetIds()) && AbstractC0741d0.m4732i(transition.getTargetNames()) && AbstractC0741d0.m4732i(transition.getTargetTypes())) ? false : true;
    }

    @Override // androidx.fragment.app.AbstractC0741d0
    /* renamed from: a */
    public void mo4712a(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).addTarget(view);
        }
    }

    @Override // androidx.fragment.app.AbstractC0741d0
    /* renamed from: b */
    public void mo4713b(Object obj, ArrayList<View> arrayList) {
        Transition transition = (Transition) obj;
        if (transition == null) {
            return;
        }
        int i10 = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int transitionCount = transitionSet.getTransitionCount();
            while (i10 < transitionCount) {
                mo4713b(transitionSet.getTransitionAt(i10), arrayList);
                i10++;
            }
            return;
        }
        if (m4711v(transition) || !AbstractC0741d0.m4732i(transition.getTargets())) {
            return;
        }
        int size = arrayList.size();
        while (i10 < size) {
            transition.addTarget(arrayList.get(i10));
            i10++;
        }
    }

    @Override // androidx.fragment.app.AbstractC0741d0
    /* renamed from: c */
    public void mo4714c(ViewGroup viewGroup, Object obj) {
        TransitionManager.beginDelayedTransition(viewGroup, (Transition) obj);
    }

    @Override // androidx.fragment.app.AbstractC0741d0
    /* renamed from: e */
    public boolean mo4715e(Object obj) {
        return obj instanceof Transition;
    }

    @Override // androidx.fragment.app.AbstractC0741d0
    /* renamed from: f */
    public Object mo4716f(Object obj) {
        if (obj != null) {
            return ((Transition) obj).clone();
        }
        return null;
    }

    @Override // androidx.fragment.app.AbstractC0741d0
    /* renamed from: j */
    public Object mo4717j(Object obj, Object obj2, Object obj3) {
        Transition ordering = (Transition) obj;
        Transition transition = (Transition) obj2;
        Transition transition2 = (Transition) obj3;
        if (ordering != null && transition != null) {
            ordering = new TransitionSet().addTransition(ordering).addTransition(transition).setOrdering(1);
        } else if (ordering == null) {
            ordering = transition != null ? transition : null;
        }
        if (transition2 == null) {
            return ordering;
        }
        TransitionSet transitionSet = new TransitionSet();
        if (ordering != null) {
            transitionSet.addTransition(ordering);
        }
        transitionSet.addTransition(transition2);
        return transitionSet;
    }

    @Override // androidx.fragment.app.AbstractC0741d0
    /* renamed from: k */
    public Object mo4718k(Object obj, Object obj2, Object obj3) {
        TransitionSet transitionSet = new TransitionSet();
        if (obj != null) {
            transitionSet.addTransition((Transition) obj);
        }
        if (obj2 != null) {
            transitionSet.addTransition((Transition) obj2);
        }
        if (obj3 != null) {
            transitionSet.addTransition((Transition) obj3);
        }
        return transitionSet;
    }

    @Override // androidx.fragment.app.AbstractC0741d0
    /* renamed from: m */
    public void mo4719m(Object obj, View view, ArrayList<View> arrayList) {
        ((Transition) obj).addListener(new b(view, arrayList));
    }

    @Override // androidx.fragment.app.AbstractC0741d0
    /* renamed from: n */
    public void mo4720n(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        ((Transition) obj).addListener(new c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // androidx.fragment.app.AbstractC0741d0
    /* renamed from: o */
    public void mo4721o(Object obj, Rect rect) {
        if (obj != null) {
            ((Transition) obj).setEpicenterCallback(new e(rect));
        }
    }

    @Override // androidx.fragment.app.AbstractC0741d0
    /* renamed from: p */
    public void mo4722p(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            m4733h(view, rect);
            ((Transition) obj).setEpicenterCallback(new a(rect));
        }
    }

    @Override // androidx.fragment.app.AbstractC0741d0
    /* renamed from: q */
    public void mo4723q(Fragment fragment, Object obj, C1089e c1089e, Runnable runnable) {
        ((Transition) obj).addListener(new d(runnable));
    }

    @Override // androidx.fragment.app.AbstractC0741d0
    /* renamed from: s */
    public void mo4724s(Object obj, View view, ArrayList<View> arrayList) {
        TransitionSet transitionSet = (TransitionSet) obj;
        List<View> targets = transitionSet.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            AbstractC0741d0.m4730d(targets, arrayList.get(i10));
        }
        targets.add(view);
        arrayList.add(view);
        mo4713b(transitionSet, arrayList);
    }

    @Override // androidx.fragment.app.AbstractC0741d0
    /* renamed from: t */
    public void mo4725t(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        TransitionSet transitionSet = (TransitionSet) obj;
        if (transitionSet != null) {
            transitionSet.getTargets().clear();
            transitionSet.getTargets().addAll(arrayList2);
            m4727w(transitionSet, arrayList, arrayList2);
        }
    }

    @Override // androidx.fragment.app.AbstractC0741d0
    /* renamed from: u */
    public Object mo4726u(Object obj) {
        if (obj == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition((Transition) obj);
        return transitionSet;
    }

    /* renamed from: w */
    public void m4727w(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        List<View> targets;
        Transition transition = (Transition) obj;
        int i10 = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int transitionCount = transitionSet.getTransitionCount();
            while (i10 < transitionCount) {
                m4727w(transitionSet.getTransitionAt(i10), arrayList, arrayList2);
                i10++;
            }
            return;
        }
        if (m4711v(transition) || (targets = transition.getTargets()) == null || targets.size() != arrayList.size() || !targets.containsAll(arrayList)) {
            return;
        }
        int size = arrayList2 == null ? 0 : arrayList2.size();
        while (i10 < size) {
            transition.addTarget(arrayList2.get(i10));
            i10++;
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            transition.removeTarget(arrayList.get(size2));
        }
    }
}
