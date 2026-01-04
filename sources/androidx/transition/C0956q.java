package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import p273f0.C9603h0;
import p438l.C11207a;

/* renamed from: androidx.transition.q */
/* loaded from: classes.dex */
public class C0956q {

    /* renamed from: a */
    public static Transition f4875a = new AutoTransition();

    /* renamed from: b */
    public static ThreadLocal<WeakReference<C11207a<ViewGroup, ArrayList<Transition>>>> f4876b = new ThreadLocal<>();

    /* renamed from: c */
    public static ArrayList<ViewGroup> f4877c = new ArrayList<>();

    /* renamed from: androidx.transition.q$a */
    public static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

        /* renamed from: a */
        public Transition f4878a;

        /* renamed from: b */
        public ViewGroup f4879b;

        /* renamed from: androidx.transition.q$a$a, reason: collision with other inner class name */
        public class C14411a extends C0955p {

            /* renamed from: a */
            public final /* synthetic */ C11207a f4880a;

            public C14411a(C11207a c11207a) {
                this.f4880a = c11207a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.transition.Transition.InterfaceC0923f
            /* renamed from: c */
            public void mo5637c(Transition transition) {
                ((ArrayList) this.f4880a.get(a.this.f4879b)).remove(transition);
                transition.mo5721V(this);
            }
        }

        public a(Transition transition, ViewGroup viewGroup) {
            this.f4878a = transition;
            this.f4879b = viewGroup;
        }

        /* renamed from: a */
        public final void m5836a() {
            this.f4879b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f4879b.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            m5836a();
            if (!C0956q.f4877c.remove(this.f4879b)) {
                return true;
            }
            C11207a<ViewGroup, ArrayList<Transition>> c11207aM5833b = C0956q.m5833b();
            ArrayList<Transition> arrayList = c11207aM5833b.get(this.f4879b);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                c11207aM5833b.put(this.f4879b, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.f4878a);
            this.f4878a.mo5726a(new C14411a(c11207aM5833b));
            this.f4878a.m5741m(this.f4879b, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((Transition) it.next()).mo5723X(this.f4879b);
                }
            }
            this.f4878a.m5720U(this.f4879b);
            return true;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            m5836a();
            C0956q.f4877c.remove(this.f4879b);
            ArrayList<Transition> arrayList = C0956q.m5833b().get(this.f4879b);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<Transition> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().mo5723X(this.f4879b);
                }
            }
            this.f4878a.m5742n(true);
        }
    }

    /* renamed from: a */
    public static void m5832a(ViewGroup viewGroup, Transition transition) {
        if (f4877c.contains(viewGroup) || !C9603h0.m59864T(viewGroup)) {
            return;
        }
        f4877c.add(viewGroup);
        if (transition == null) {
            transition = f4875a;
        }
        Transition transitionClone = transition.clone();
        m5835d(viewGroup, transitionClone);
        C0952m.m5827c(viewGroup, null);
        m5834c(viewGroup, transitionClone);
    }

    /* renamed from: b */
    public static C11207a<ViewGroup, ArrayList<Transition>> m5833b() {
        C11207a<ViewGroup, ArrayList<Transition>> c11207a;
        WeakReference<C11207a<ViewGroup, ArrayList<Transition>>> weakReference = f4876b.get();
        if (weakReference != null && (c11207a = weakReference.get()) != null) {
            return c11207a;
        }
        C11207a<ViewGroup, ArrayList<Transition>> c11207a2 = new C11207a<>();
        f4876b.set(new WeakReference<>(c11207a2));
        return c11207a2;
    }

    /* renamed from: c */
    public static void m5834c(ViewGroup viewGroup, Transition transition) {
        if (transition == null || viewGroup == null) {
            return;
        }
        a aVar = new a(transition, viewGroup);
        viewGroup.addOnAttachStateChangeListener(aVar);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
    }

    /* renamed from: d */
    public static void m5835d(ViewGroup viewGroup, Transition transition) {
        ArrayList<Transition> arrayList = m5833b().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<Transition> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().mo5719T(viewGroup);
            }
        }
        if (transition != null) {
            transition.m5741m(viewGroup, true);
        }
        C0952m c0952mM5826b = C0952m.m5826b(viewGroup);
        if (c0952mM5826b != null) {
            c0952mM5826b.m5828a();
        }
    }
}
