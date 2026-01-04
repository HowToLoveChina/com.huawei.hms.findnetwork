package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p273f0.C9603h0;

/* renamed from: androidx.recyclerview.widget.e */
/* loaded from: classes.dex */
public class C0866e extends AbstractC0879r {

    /* renamed from: Q */
    public static TimeInterpolator f4486Q;

    /* renamed from: F */
    public ArrayList<RecyclerView.AbstractC0833c0> f4487F = new ArrayList<>();

    /* renamed from: G */
    public ArrayList<RecyclerView.AbstractC0833c0> f4488G = new ArrayList<>();

    /* renamed from: H */
    public ArrayList<j> f4489H = new ArrayList<>();

    /* renamed from: I */
    public ArrayList<i> f4490I = new ArrayList<>();

    /* renamed from: J */
    public ArrayList<ArrayList<RecyclerView.AbstractC0833c0>> f4491J = new ArrayList<>();

    /* renamed from: K */
    public ArrayList<ArrayList<j>> f4492K = new ArrayList<>();

    /* renamed from: L */
    public ArrayList<ArrayList<i>> f4493L = new ArrayList<>();

    /* renamed from: M */
    public ArrayList<RecyclerView.AbstractC0833c0> f4494M = new ArrayList<>();

    /* renamed from: N */
    public ArrayList<RecyclerView.AbstractC0833c0> f4495N = new ArrayList<>();

    /* renamed from: O */
    public ArrayList<RecyclerView.AbstractC0833c0> f4496O = new ArrayList<>();

    /* renamed from: P */
    public ArrayList<RecyclerView.AbstractC0833c0> f4497P = new ArrayList<>();

    /* renamed from: androidx.recyclerview.widget.e$a */
    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ ArrayList f4498a;

        public a(ArrayList arrayList) {
            this.f4498a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f4498a.iterator();
            while (it.hasNext()) {
                j jVar = (j) it.next();
                C0866e.this.m5469g(jVar.f4532a, jVar.f4533b, jVar.f4534c, jVar.f4535d, jVar.f4536e);
            }
            this.f4498a.clear();
            C0866e.this.f4492K.remove(this.f4498a);
        }
    }

    /* renamed from: androidx.recyclerview.widget.e$b */
    public class b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ ArrayList f4500a;

        public b(ArrayList arrayList) {
            this.f4500a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f4500a.iterator();
            while (it.hasNext()) {
                C0866e.this.m5468f((i) it.next());
            }
            this.f4500a.clear();
            C0866e.this.f4493L.remove(this.f4500a);
        }
    }

    /* renamed from: androidx.recyclerview.widget.e$c */
    public class c implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ ArrayList f4502a;

        public c(ArrayList arrayList) {
            this.f4502a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f4502a.iterator();
            while (it.hasNext()) {
                C0866e.this.m5467e((RecyclerView.AbstractC0833c0) it.next());
            }
            this.f4502a.clear();
            C0866e.this.f4491J.remove(this.f4502a);
        }
    }

    /* renamed from: androidx.recyclerview.widget.e$d */
    public class d extends AnimatorListenerAdapter {

        /* renamed from: a */
        public final /* synthetic */ RecyclerView.AbstractC0833c0 f4504a;

        /* renamed from: b */
        public final /* synthetic */ ViewPropertyAnimator f4505b;

        /* renamed from: c */
        public final /* synthetic */ View f4506c;

        public d(RecyclerView.AbstractC0833c0 abstractC0833c0, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f4504a = abstractC0833c0;
            this.f4505b = viewPropertyAnimator;
            this.f4506c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f4505b.setListener(null);
            this.f4506c.setAlpha(1.0f);
            C0866e.this.dispatchRemoveFinished(this.f4504a);
            C0866e.this.f4496O.remove(this.f4504a);
            C0866e.this.m5472j();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            C0866e.this.dispatchRemoveStarting(this.f4504a);
        }
    }

    /* renamed from: androidx.recyclerview.widget.e$e */
    public class e extends AnimatorListenerAdapter {

        /* renamed from: a */
        public final /* synthetic */ RecyclerView.AbstractC0833c0 f4508a;

        /* renamed from: b */
        public final /* synthetic */ View f4509b;

        /* renamed from: c */
        public final /* synthetic */ ViewPropertyAnimator f4510c;

        public e(RecyclerView.AbstractC0833c0 abstractC0833c0, View view, ViewPropertyAnimator viewPropertyAnimator) {
            this.f4508a = abstractC0833c0;
            this.f4509b = view;
            this.f4510c = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f4509b.setAlpha(1.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f4510c.setListener(null);
            C0866e.this.dispatchAddFinished(this.f4508a);
            C0866e.this.f4494M.remove(this.f4508a);
            C0866e.this.m5472j();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            C0866e.this.dispatchAddStarting(this.f4508a);
        }
    }

    /* renamed from: androidx.recyclerview.widget.e$f */
    public class f extends AnimatorListenerAdapter {

        /* renamed from: a */
        public final /* synthetic */ RecyclerView.AbstractC0833c0 f4512a;

        /* renamed from: b */
        public final /* synthetic */ int f4513b;

        /* renamed from: c */
        public final /* synthetic */ View f4514c;

        /* renamed from: d */
        public final /* synthetic */ int f4515d;

        /* renamed from: e */
        public final /* synthetic */ ViewPropertyAnimator f4516e;

        public f(RecyclerView.AbstractC0833c0 abstractC0833c0, int i10, View view, int i11, ViewPropertyAnimator viewPropertyAnimator) {
            this.f4512a = abstractC0833c0;
            this.f4513b = i10;
            this.f4514c = view;
            this.f4515d = i11;
            this.f4516e = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.f4513b != 0) {
                this.f4514c.setTranslationX(0.0f);
            }
            if (this.f4515d != 0) {
                this.f4514c.setTranslationY(0.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f4516e.setListener(null);
            C0866e.this.dispatchMoveFinished(this.f4512a);
            C0866e.this.f4495N.remove(this.f4512a);
            C0866e.this.m5472j();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            C0866e.this.dispatchMoveStarting(this.f4512a);
        }
    }

    /* renamed from: androidx.recyclerview.widget.e$g */
    public class g extends AnimatorListenerAdapter {

        /* renamed from: a */
        public final /* synthetic */ i f4518a;

        /* renamed from: b */
        public final /* synthetic */ ViewPropertyAnimator f4519b;

        /* renamed from: c */
        public final /* synthetic */ View f4520c;

        public g(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f4518a = iVar;
            this.f4519b = viewPropertyAnimator;
            this.f4520c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f4519b.setListener(null);
            this.f4520c.setAlpha(1.0f);
            this.f4520c.setTranslationX(0.0f);
            this.f4520c.setTranslationY(0.0f);
            C0866e.this.dispatchChangeFinished(this.f4518a.f4526a, true);
            C0866e.this.f4497P.remove(this.f4518a.f4526a);
            C0866e.this.m5472j();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            C0866e.this.dispatchChangeStarting(this.f4518a.f4526a, true);
        }
    }

    /* renamed from: androidx.recyclerview.widget.e$h */
    public class h extends AnimatorListenerAdapter {

        /* renamed from: a */
        public final /* synthetic */ i f4522a;

        /* renamed from: b */
        public final /* synthetic */ ViewPropertyAnimator f4523b;

        /* renamed from: c */
        public final /* synthetic */ View f4524c;

        public h(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f4522a = iVar;
            this.f4523b = viewPropertyAnimator;
            this.f4524c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f4523b.setListener(null);
            this.f4524c.setAlpha(1.0f);
            this.f4524c.setTranslationX(0.0f);
            this.f4524c.setTranslationY(0.0f);
            C0866e.this.dispatchChangeFinished(this.f4522a.f4527b, false);
            C0866e.this.f4497P.remove(this.f4522a.f4527b);
            C0866e.this.m5472j();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            C0866e.this.dispatchChangeStarting(this.f4522a.f4527b, false);
        }
    }

    /* renamed from: androidx.recyclerview.widget.e$j */
    public static class j {

        /* renamed from: a */
        public RecyclerView.AbstractC0833c0 f4532a;

        /* renamed from: b */
        public int f4533b;

        /* renamed from: c */
        public int f4534c;

        /* renamed from: d */
        public int f4535d;

        /* renamed from: e */
        public int f4536e;

        public j(RecyclerView.AbstractC0833c0 abstractC0833c0, int i10, int i11, int i12, int i13) {
            this.f4532a = abstractC0833c0;
            this.f4533b = i10;
            this.f4534c = i11;
            this.f4535d = i12;
            this.f4536e = i13;
        }
    }

    @Override // androidx.recyclerview.widget.AbstractC0879r
    public boolean animateAdd(RecyclerView.AbstractC0833c0 abstractC0833c0) {
        m5476n(abstractC0833c0);
        abstractC0833c0.f4327a.setAlpha(0.0f);
        this.f4488G.add(abstractC0833c0);
        return true;
    }

    @Override // androidx.recyclerview.widget.AbstractC0879r
    public boolean animateChange(RecyclerView.AbstractC0833c0 abstractC0833c0, RecyclerView.AbstractC0833c0 abstractC0833c02, int i10, int i11, int i12, int i13) {
        if (abstractC0833c0 == abstractC0833c02) {
            return animateMove(abstractC0833c0, i10, i11, i12, i13);
        }
        float translationX = abstractC0833c0.f4327a.getTranslationX();
        float translationY = abstractC0833c0.f4327a.getTranslationY();
        float alpha = abstractC0833c0.f4327a.getAlpha();
        m5476n(abstractC0833c0);
        int i14 = (int) ((i12 - i10) - translationX);
        int i15 = (int) ((i13 - i11) - translationY);
        abstractC0833c0.f4327a.setTranslationX(translationX);
        abstractC0833c0.f4327a.setTranslationY(translationY);
        abstractC0833c0.f4327a.setAlpha(alpha);
        if (abstractC0833c02 != null) {
            m5476n(abstractC0833c02);
            abstractC0833c02.f4327a.setTranslationX(-i14);
            abstractC0833c02.f4327a.setTranslationY(-i15);
            abstractC0833c02.f4327a.setAlpha(0.0f);
        }
        this.f4490I.add(new i(abstractC0833c0, abstractC0833c02, i10, i11, i12, i13));
        return true;
    }

    @Override // androidx.recyclerview.widget.AbstractC0879r
    public boolean animateMove(RecyclerView.AbstractC0833c0 abstractC0833c0, int i10, int i11, int i12, int i13) {
        View view = abstractC0833c0.f4327a;
        int translationX = i10 + ((int) view.getTranslationX());
        int translationY = i11 + ((int) abstractC0833c0.f4327a.getTranslationY());
        m5476n(abstractC0833c0);
        int i14 = i12 - translationX;
        int i15 = i13 - translationY;
        if (i14 == 0 && i15 == 0) {
            dispatchMoveFinished(abstractC0833c0);
            return false;
        }
        if (i14 != 0) {
            view.setTranslationX(-i14);
        }
        if (i15 != 0) {
            view.setTranslationY(-i15);
        }
        this.f4489H.add(new j(abstractC0833c0, translationX, translationY, i12, i13));
        return true;
    }

    @Override // androidx.recyclerview.widget.AbstractC0879r
    public boolean animateRemove(RecyclerView.AbstractC0833c0 abstractC0833c0) {
        m5476n(abstractC0833c0);
        this.f4487F.add(abstractC0833c0);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843m
    public boolean canReuseUpdatedViewHolder(RecyclerView.AbstractC0833c0 abstractC0833c0, List<Object> list) {
        return !list.isEmpty() || super.canReuseUpdatedViewHolder(abstractC0833c0, list);
    }

    /* renamed from: e */
    public void m5467e(RecyclerView.AbstractC0833c0 abstractC0833c0) {
        View view = abstractC0833c0.f4327a;
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.f4494M.add(abstractC0833c0);
        viewPropertyAnimatorAnimate.alpha(1.0f).setDuration(getAddDuration()).setListener(new e(abstractC0833c0, view, viewPropertyAnimatorAnimate)).start();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843m
    public void endAnimation(RecyclerView.AbstractC0833c0 abstractC0833c0) {
        View view = abstractC0833c0.f4327a;
        view.animate().cancel();
        int size = this.f4489H.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (this.f4489H.get(size).f4532a == abstractC0833c0) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                dispatchMoveFinished(abstractC0833c0);
                this.f4489H.remove(size);
            }
        }
        m5473k(this.f4490I, abstractC0833c0);
        if (this.f4487F.remove(abstractC0833c0)) {
            view.setAlpha(1.0f);
            dispatchRemoveFinished(abstractC0833c0);
        }
        if (this.f4488G.remove(abstractC0833c0)) {
            view.setAlpha(1.0f);
            dispatchAddFinished(abstractC0833c0);
        }
        for (int size2 = this.f4493L.size() - 1; size2 >= 0; size2--) {
            ArrayList<i> arrayList = this.f4493L.get(size2);
            m5473k(arrayList, abstractC0833c0);
            if (arrayList.isEmpty()) {
                this.f4493L.remove(size2);
            }
        }
        for (int size3 = this.f4492K.size() - 1; size3 >= 0; size3--) {
            ArrayList<j> arrayList2 = this.f4492K.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                }
                if (arrayList2.get(size4).f4532a == abstractC0833c0) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    dispatchMoveFinished(abstractC0833c0);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.f4492K.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.f4491J.size() - 1; size5 >= 0; size5--) {
            ArrayList<RecyclerView.AbstractC0833c0> arrayList3 = this.f4491J.get(size5);
            if (arrayList3.remove(abstractC0833c0)) {
                view.setAlpha(1.0f);
                dispatchAddFinished(abstractC0833c0);
                if (arrayList3.isEmpty()) {
                    this.f4491J.remove(size5);
                }
            }
        }
        this.f4496O.remove(abstractC0833c0);
        this.f4494M.remove(abstractC0833c0);
        this.f4497P.remove(abstractC0833c0);
        this.f4495N.remove(abstractC0833c0);
        m5472j();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843m
    public void endAnimations() {
        int size = this.f4489H.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            j jVar = this.f4489H.get(size);
            View view = jVar.f4532a.f4327a;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            dispatchMoveFinished(jVar.f4532a);
            this.f4489H.remove(size);
        }
        for (int size2 = this.f4487F.size() - 1; size2 >= 0; size2--) {
            dispatchRemoveFinished(this.f4487F.get(size2));
            this.f4487F.remove(size2);
        }
        int size3 = this.f4488G.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.AbstractC0833c0 abstractC0833c0 = this.f4488G.get(size3);
            abstractC0833c0.f4327a.setAlpha(1.0f);
            dispatchAddFinished(abstractC0833c0);
            this.f4488G.remove(size3);
        }
        for (int size4 = this.f4490I.size() - 1; size4 >= 0; size4--) {
            m5474l(this.f4490I.get(size4));
        }
        this.f4490I.clear();
        if (isRunning()) {
            for (int size5 = this.f4492K.size() - 1; size5 >= 0; size5--) {
                ArrayList<j> arrayList = this.f4492K.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    j jVar2 = arrayList.get(size6);
                    View view2 = jVar2.f4532a.f4327a;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    dispatchMoveFinished(jVar2.f4532a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.f4492K.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.f4491J.size() - 1; size7 >= 0; size7--) {
                ArrayList<RecyclerView.AbstractC0833c0> arrayList2 = this.f4491J.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.AbstractC0833c0 abstractC0833c02 = arrayList2.get(size8);
                    abstractC0833c02.f4327a.setAlpha(1.0f);
                    dispatchAddFinished(abstractC0833c02);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.f4491J.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.f4493L.size() - 1; size9 >= 0; size9--) {
                ArrayList<i> arrayList3 = this.f4493L.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    m5474l(arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.f4493L.remove(arrayList3);
                    }
                }
            }
            m5471i(this.f4496O);
            m5471i(this.f4495N);
            m5471i(this.f4494M);
            m5471i(this.f4497P);
            dispatchAnimationsFinished();
        }
    }

    /* renamed from: f */
    public void m5468f(i iVar) {
        RecyclerView.AbstractC0833c0 abstractC0833c0 = iVar.f4526a;
        View view = abstractC0833c0 == null ? null : abstractC0833c0.f4327a;
        RecyclerView.AbstractC0833c0 abstractC0833c02 = iVar.f4527b;
        View view2 = abstractC0833c02 != null ? abstractC0833c02.f4327a : null;
        if (view != null) {
            ViewPropertyAnimator duration = view.animate().setDuration(getChangeDuration());
            this.f4497P.add(iVar.f4526a);
            duration.translationX(iVar.f4530e - iVar.f4528c);
            duration.translationY(iVar.f4531f - iVar.f4529d);
            duration.alpha(0.0f).setListener(new g(iVar, duration, view)).start();
        }
        if (view2 != null) {
            ViewPropertyAnimator viewPropertyAnimatorAnimate = view2.animate();
            this.f4497P.add(iVar.f4527b);
            viewPropertyAnimatorAnimate.translationX(0.0f).translationY(0.0f).setDuration(getChangeDuration()).alpha(1.0f).setListener(new h(iVar, viewPropertyAnimatorAnimate, view2)).start();
        }
    }

    /* renamed from: g */
    public void m5469g(RecyclerView.AbstractC0833c0 abstractC0833c0, int i10, int i11, int i12, int i13) {
        View view = abstractC0833c0.f4327a;
        int i14 = i12 - i10;
        int i15 = i13 - i11;
        if (i14 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i15 != 0) {
            view.animate().translationY(0.0f);
        }
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.f4495N.add(abstractC0833c0);
        viewPropertyAnimatorAnimate.setDuration(getMoveDuration()).setListener(new f(abstractC0833c0, i14, view, i15, viewPropertyAnimatorAnimate)).start();
    }

    /* renamed from: h */
    public final void m5470h(RecyclerView.AbstractC0833c0 abstractC0833c0) {
        View view = abstractC0833c0.f4327a;
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.f4496O.add(abstractC0833c0);
        viewPropertyAnimatorAnimate.setDuration(getRemoveDuration()).alpha(0.0f).setListener(new d(abstractC0833c0, viewPropertyAnimatorAnimate, view)).start();
    }

    /* renamed from: i */
    public void m5471i(List<RecyclerView.AbstractC0833c0> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).f4327a.animate().cancel();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843m
    public boolean isRunning() {
        return (this.f4488G.isEmpty() && this.f4490I.isEmpty() && this.f4489H.isEmpty() && this.f4487F.isEmpty() && this.f4495N.isEmpty() && this.f4496O.isEmpty() && this.f4494M.isEmpty() && this.f4497P.isEmpty() && this.f4492K.isEmpty() && this.f4491J.isEmpty() && this.f4493L.isEmpty()) ? false : true;
    }

    /* renamed from: j */
    public void m5472j() {
        if (isRunning()) {
            return;
        }
        dispatchAnimationsFinished();
    }

    /* renamed from: k */
    public final void m5473k(List<i> list, RecyclerView.AbstractC0833c0 abstractC0833c0) {
        for (int size = list.size() - 1; size >= 0; size--) {
            i iVar = list.get(size);
            if (m5475m(iVar, abstractC0833c0) && iVar.f4526a == null && iVar.f4527b == null) {
                list.remove(iVar);
            }
        }
    }

    /* renamed from: l */
    public final void m5474l(i iVar) {
        RecyclerView.AbstractC0833c0 abstractC0833c0 = iVar.f4526a;
        if (abstractC0833c0 != null) {
            m5475m(iVar, abstractC0833c0);
        }
        RecyclerView.AbstractC0833c0 abstractC0833c02 = iVar.f4527b;
        if (abstractC0833c02 != null) {
            m5475m(iVar, abstractC0833c02);
        }
    }

    /* renamed from: m */
    public final boolean m5475m(i iVar, RecyclerView.AbstractC0833c0 abstractC0833c0) {
        boolean z10 = false;
        if (iVar.f4527b == abstractC0833c0) {
            iVar.f4527b = null;
        } else {
            if (iVar.f4526a != abstractC0833c0) {
                return false;
            }
            iVar.f4526a = null;
            z10 = true;
        }
        abstractC0833c0.f4327a.setAlpha(1.0f);
        abstractC0833c0.f4327a.setTranslationX(0.0f);
        abstractC0833c0.f4327a.setTranslationY(0.0f);
        dispatchChangeFinished(abstractC0833c0, z10);
        return true;
    }

    /* renamed from: n */
    public final void m5476n(RecyclerView.AbstractC0833c0 abstractC0833c0) {
        if (f4486Q == null) {
            f4486Q = new ValueAnimator().getInterpolator();
        }
        abstractC0833c0.f4327a.animate().setInterpolator(f4486Q);
        endAnimation(abstractC0833c0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843m
    public void runPendingAnimations() {
        boolean z10 = !this.f4487F.isEmpty();
        boolean z11 = !this.f4489H.isEmpty();
        boolean z12 = !this.f4490I.isEmpty();
        boolean z13 = !this.f4488G.isEmpty();
        if (z10 || z11 || z13 || z12) {
            Iterator<RecyclerView.AbstractC0833c0> it = this.f4487F.iterator();
            while (it.hasNext()) {
                m5470h(it.next());
            }
            this.f4487F.clear();
            if (z11) {
                ArrayList<j> arrayList = new ArrayList<>();
                arrayList.addAll(this.f4489H);
                this.f4492K.add(arrayList);
                this.f4489H.clear();
                a aVar = new a(arrayList);
                if (z10) {
                    C9603h0.m59888i0(arrayList.get(0).f4532a.f4327a, aVar, getRemoveDuration());
                } else {
                    aVar.run();
                }
            }
            if (z12) {
                ArrayList<i> arrayList2 = new ArrayList<>();
                arrayList2.addAll(this.f4490I);
                this.f4493L.add(arrayList2);
                this.f4490I.clear();
                b bVar = new b(arrayList2);
                if (z10) {
                    C9603h0.m59888i0(arrayList2.get(0).f4526a.f4327a, bVar, getRemoveDuration());
                } else {
                    bVar.run();
                }
            }
            if (z13) {
                ArrayList<RecyclerView.AbstractC0833c0> arrayList3 = new ArrayList<>();
                arrayList3.addAll(this.f4488G);
                this.f4491J.add(arrayList3);
                this.f4488G.clear();
                c cVar = new c(arrayList3);
                if (z10 || z11 || z12) {
                    C9603h0.m59888i0(arrayList3.get(0).f4327a, cVar, (z10 ? getRemoveDuration() : 0L) + Math.max(z11 ? getMoveDuration() : 0L, z12 ? getChangeDuration() : 0L));
                } else {
                    cVar.run();
                }
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.e$i */
    public static class i {

        /* renamed from: a */
        public RecyclerView.AbstractC0833c0 f4526a;

        /* renamed from: b */
        public RecyclerView.AbstractC0833c0 f4527b;

        /* renamed from: c */
        public int f4528c;

        /* renamed from: d */
        public int f4529d;

        /* renamed from: e */
        public int f4530e;

        /* renamed from: f */
        public int f4531f;

        public i(RecyclerView.AbstractC0833c0 abstractC0833c0, RecyclerView.AbstractC0833c0 abstractC0833c02) {
            this.f4526a = abstractC0833c0;
            this.f4527b = abstractC0833c02;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f4526a + ", newHolder=" + this.f4527b + ", fromX=" + this.f4528c + ", fromY=" + this.f4529d + ", toX=" + this.f4530e + ", toY=" + this.f4531f + '}';
        }

        public i(RecyclerView.AbstractC0833c0 abstractC0833c0, RecyclerView.AbstractC0833c0 abstractC0833c02, int i10, int i11, int i12, int i13) {
            this(abstractC0833c0, abstractC0833c02);
            this.f4528c = i10;
            this.f4529d = i11;
            this.f4530e = i12;
            this.f4531f = i13;
        }
    }
}
