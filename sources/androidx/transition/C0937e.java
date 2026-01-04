package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.AbstractC0741d0;
import androidx.transition.Transition;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"RestrictedApi"})
/* renamed from: androidx.transition.e */
/* loaded from: classes.dex */
public class C0937e extends AbstractC0741d0 {

    /* renamed from: androidx.transition.e$a */
    public class a extends Transition.AbstractC0922e {

        /* renamed from: a */
        public final /* synthetic */ Rect f4842a;

        public a(Rect rect) {
            this.f4842a = rect;
        }

        @Override // androidx.transition.Transition.AbstractC0922e
        /* renamed from: a */
        public Rect mo5754a(Transition transition) {
            return this.f4842a;
        }
    }

    /* renamed from: androidx.transition.e$b */
    public class b implements Transition.InterfaceC0923f {

        /* renamed from: a */
        public final /* synthetic */ View f4844a;

        /* renamed from: b */
        public final /* synthetic */ ArrayList f4845b;

        public b(View view, ArrayList arrayList) {
            this.f4844a = view;
            this.f4845b = arrayList;
        }

        @Override // androidx.transition.Transition.InterfaceC0923f
        /* renamed from: a */
        public void mo5755a(Transition transition) {
        }

        @Override // androidx.transition.Transition.InterfaceC0923f
        /* renamed from: b */
        public void mo5636b(Transition transition) {
        }

        @Override // androidx.transition.Transition.InterfaceC0923f
        /* renamed from: c */
        public void mo5637c(Transition transition) {
            transition.mo5721V(this);
            this.f4844a.setVisibility(8);
            int size = this.f4845b.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((View) this.f4845b.get(i10)).setVisibility(0);
            }
        }

        @Override // androidx.transition.Transition.InterfaceC0923f
        /* renamed from: d */
        public void mo5638d(Transition transition) {
        }

        @Override // androidx.transition.Transition.InterfaceC0923f
        /* renamed from: e */
        public void mo5639e(Transition transition) {
        }
    }

    /* renamed from: androidx.transition.e$c */
    public class c extends C0955p {

        /* renamed from: a */
        public final /* synthetic */ Object f4847a;

        /* renamed from: b */
        public final /* synthetic */ ArrayList f4848b;

        /* renamed from: c */
        public final /* synthetic */ Object f4849c;

        /* renamed from: d */
        public final /* synthetic */ ArrayList f4850d;

        /* renamed from: e */
        public final /* synthetic */ Object f4851e;

        /* renamed from: f */
        public final /* synthetic */ ArrayList f4852f;

        public c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.f4847a = obj;
            this.f4848b = arrayList;
            this.f4849c = obj2;
            this.f4850d = arrayList2;
            this.f4851e = obj3;
            this.f4852f = arrayList3;
        }

        @Override // androidx.transition.C0955p, androidx.transition.Transition.InterfaceC0923f
        /* renamed from: a */
        public void mo5755a(Transition transition) {
            Object obj = this.f4847a;
            if (obj != null) {
                C0937e.this.m5805w(obj, this.f4848b, null);
            }
            Object obj2 = this.f4849c;
            if (obj2 != null) {
                C0937e.this.m5805w(obj2, this.f4850d, null);
            }
            Object obj3 = this.f4851e;
            if (obj3 != null) {
                C0937e.this.m5805w(obj3, this.f4852f, null);
            }
        }

        @Override // androidx.transition.Transition.InterfaceC0923f
        /* renamed from: c */
        public void mo5637c(Transition transition) {
            transition.mo5721V(this);
        }
    }

    /* renamed from: androidx.transition.e$d */
    public class d extends Transition.AbstractC0922e {

        /* renamed from: a */
        public final /* synthetic */ Rect f4854a;

        public d(Rect rect) {
            this.f4854a = rect;
        }

        @Override // androidx.transition.Transition.AbstractC0922e
        /* renamed from: a */
        public Rect mo5754a(Transition transition) {
            Rect rect = this.f4854a;
            if (rect == null || rect.isEmpty()) {
                return null;
            }
            return this.f4854a;
        }
    }

    /* renamed from: v */
    public static boolean m5804v(Transition transition) {
        return (AbstractC0741d0.m4732i(transition.m5707C()) && AbstractC0741d0.m4732i(transition.m5708D()) && AbstractC0741d0.m4732i(transition.m5709E())) ? false : true;
    }

    @Override // androidx.fragment.app.AbstractC0741d0
    /* renamed from: a */
    public void mo4712a(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).mo5728b(view);
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
            int iM5761o0 = transitionSet.m5761o0();
            while (i10 < iM5761o0) {
                mo4713b(transitionSet.m5760n0(i10), arrayList);
                i10++;
            }
            return;
        }
        if (m5804v(transition) || !AbstractC0741d0.m4732i(transition.m5710F())) {
            return;
        }
        int size = arrayList.size();
        while (i10 < size) {
            transition.mo5728b(arrayList.get(i10));
            i10++;
        }
    }

    @Override // androidx.fragment.app.AbstractC0741d0
    /* renamed from: c */
    public void mo4714c(ViewGroup viewGroup, Object obj) {
        C0956q.m5832a(viewGroup, (Transition) obj);
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
        Transition transitionM5766t0 = (Transition) obj;
        Transition transition = (Transition) obj2;
        Transition transition2 = (Transition) obj3;
        if (transitionM5766t0 != null && transition != null) {
            transitionM5766t0 = new TransitionSet().m5758l0(transitionM5766t0).m5758l0(transition).m5766t0(1);
        } else if (transitionM5766t0 == null) {
            transitionM5766t0 = transition != null ? transition : null;
        }
        if (transition2 == null) {
            return transitionM5766t0;
        }
        TransitionSet transitionSet = new TransitionSet();
        if (transitionM5766t0 != null) {
            transitionSet.m5758l0(transitionM5766t0);
        }
        transitionSet.m5758l0(transition2);
        return transitionSet;
    }

    @Override // androidx.fragment.app.AbstractC0741d0
    /* renamed from: k */
    public Object mo4718k(Object obj, Object obj2, Object obj3) {
        TransitionSet transitionSet = new TransitionSet();
        if (obj != null) {
            transitionSet.m5758l0((Transition) obj);
        }
        if (obj2 != null) {
            transitionSet.m5758l0((Transition) obj2);
        }
        if (obj3 != null) {
            transitionSet.m5758l0((Transition) obj3);
        }
        return transitionSet;
    }

    @Override // androidx.fragment.app.AbstractC0741d0
    /* renamed from: m */
    public void mo4719m(Object obj, View view, ArrayList<View> arrayList) {
        ((Transition) obj).mo5726a(new b(view, arrayList));
    }

    @Override // androidx.fragment.app.AbstractC0741d0
    /* renamed from: n */
    public void mo4720n(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        ((Transition) obj).mo5726a(new c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // androidx.fragment.app.AbstractC0741d0
    /* renamed from: o */
    public void mo4721o(Object obj, Rect rect) {
        if (obj != null) {
            ((Transition) obj).mo5729b0(new d(rect));
        }
    }

    @Override // androidx.fragment.app.AbstractC0741d0
    /* renamed from: p */
    public void mo4722p(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            m4733h(view, rect);
            ((Transition) obj).mo5729b0(new a(rect));
        }
    }

    @Override // androidx.fragment.app.AbstractC0741d0
    /* renamed from: s */
    public void mo4724s(Object obj, View view, ArrayList<View> arrayList) {
        TransitionSet transitionSet = (TransitionSet) obj;
        List<View> listM5710F = transitionSet.m5710F();
        listM5710F.clear();
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            AbstractC0741d0.m4730d(listM5710F, arrayList.get(i10));
        }
        listM5710F.add(view);
        arrayList.add(view);
        mo4713b(transitionSet, arrayList);
    }

    @Override // androidx.fragment.app.AbstractC0741d0
    /* renamed from: t */
    public void mo4725t(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        TransitionSet transitionSet = (TransitionSet) obj;
        if (transitionSet != null) {
            transitionSet.m5710F().clear();
            transitionSet.m5710F().addAll(arrayList2);
            m5805w(transitionSet, arrayList, arrayList2);
        }
    }

    @Override // androidx.fragment.app.AbstractC0741d0
    /* renamed from: u */
    public Object mo4726u(Object obj) {
        if (obj == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.m5758l0((Transition) obj);
        return transitionSet;
    }

    /* renamed from: w */
    public void m5805w(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        Transition transition = (Transition) obj;
        int i10 = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int iM5761o0 = transitionSet.m5761o0();
            while (i10 < iM5761o0) {
                m5805w(transitionSet.m5760n0(i10), arrayList, arrayList2);
                i10++;
            }
            return;
        }
        if (m5804v(transition)) {
            return;
        }
        List<View> listM5710F = transition.m5710F();
        if (listM5710F.size() == arrayList.size() && listM5710F.containsAll(arrayList)) {
            int size = arrayList2 == null ? 0 : arrayList2.size();
            while (i10 < size) {
                transition.mo5728b(arrayList2.get(i10));
                i10++;
            }
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                transition.mo5722W(arrayList.get(size2));
            }
        }
    }
}
