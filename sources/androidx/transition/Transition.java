package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import androidx.core.content.res.TypedArrayUtils;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import p273f0.C9603h0;
import p438l.C11207a;
import p438l.C11210d;

/* loaded from: classes.dex */
public abstract class Transition implements Cloneable {

    /* renamed from: H */
    public static final int[] f4763H = {2, 1, 3, 4};

    /* renamed from: I */
    public static final PathMotion f4764I = new C0918a();

    /* renamed from: J */
    public static ThreadLocal<C11207a<Animator, C0921d>> f4765J = new ThreadLocal<>();

    /* renamed from: D */
    public AbstractC0957r f4769D;

    /* renamed from: E */
    public AbstractC0922e f4770E;

    /* renamed from: F */
    public C11207a<String, String> f4771F;

    /* renamed from: t */
    public ArrayList<C0959t> f4792t;

    /* renamed from: u */
    public ArrayList<C0959t> f4793u;

    /* renamed from: a */
    public String f4773a = getClass().getName();

    /* renamed from: b */
    public long f4774b = -1;

    /* renamed from: c */
    public long f4775c = -1;

    /* renamed from: d */
    public TimeInterpolator f4776d = null;

    /* renamed from: e */
    public ArrayList<Integer> f4777e = new ArrayList<>();

    /* renamed from: f */
    public ArrayList<View> f4778f = new ArrayList<>();

    /* renamed from: g */
    public ArrayList<String> f4779g = null;

    /* renamed from: h */
    public ArrayList<Class<?>> f4780h = null;

    /* renamed from: i */
    public ArrayList<Integer> f4781i = null;

    /* renamed from: j */
    public ArrayList<View> f4782j = null;

    /* renamed from: k */
    public ArrayList<Class<?>> f4783k = null;

    /* renamed from: l */
    public ArrayList<String> f4784l = null;

    /* renamed from: m */
    public ArrayList<Integer> f4785m = null;

    /* renamed from: n */
    public ArrayList<View> f4786n = null;

    /* renamed from: o */
    public ArrayList<Class<?>> f4787o = null;

    /* renamed from: p */
    public C0960u f4788p = new C0960u();

    /* renamed from: q */
    public C0960u f4789q = new C0960u();

    /* renamed from: r */
    public TransitionSet f4790r = null;

    /* renamed from: s */
    public int[] f4791s = f4763H;

    /* renamed from: v */
    public ViewGroup f4794v = null;

    /* renamed from: w */
    public boolean f4795w = false;

    /* renamed from: x */
    public ArrayList<Animator> f4796x = new ArrayList<>();

    /* renamed from: y */
    public int f4797y = 0;

    /* renamed from: z */
    public boolean f4798z = false;

    /* renamed from: A */
    public boolean f4766A = false;

    /* renamed from: B */
    public ArrayList<InterfaceC0923f> f4767B = null;

    /* renamed from: C */
    public ArrayList<Animator> f4768C = new ArrayList<>();

    /* renamed from: G */
    public PathMotion f4772G = f4764I;

    /* renamed from: androidx.transition.Transition$a */
    public static class C0918a extends PathMotion {
        @Override // androidx.transition.PathMotion
        /* renamed from: a */
        public Path mo5612a(float f10, float f11, float f12, float f13) {
            Path path = new Path();
            path.moveTo(f10, f11);
            path.lineTo(f12, f13);
            return path;
        }
    }

    /* renamed from: androidx.transition.Transition$b */
    public class C0919b extends AnimatorListenerAdapter {

        /* renamed from: a */
        public final /* synthetic */ C11207a f4799a;

        public C0919b(C11207a c11207a) {
            this.f4799a = c11207a;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f4799a.remove(animator);
            Transition.this.f4796x.remove(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Transition.this.f4796x.add(animator);
        }
    }

    /* renamed from: androidx.transition.Transition$c */
    public class C0920c extends AnimatorListenerAdapter {
        public C0920c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Transition.this.m5745r();
            animator.removeListener(this);
        }
    }

    /* renamed from: androidx.transition.Transition$d */
    public static class C0921d {

        /* renamed from: a */
        public View f4802a;

        /* renamed from: b */
        public String f4803b;

        /* renamed from: c */
        public C0959t f4804c;

        /* renamed from: d */
        public InterfaceC0950k0 f4805d;

        /* renamed from: e */
        public Transition f4806e;

        public C0921d(View view, String str, Transition transition, InterfaceC0950k0 interfaceC0950k0, C0959t c0959t) {
            this.f4802a = view;
            this.f4803b = str;
            this.f4804c = c0959t;
            this.f4805d = interfaceC0950k0;
            this.f4806e = transition;
        }
    }

    /* renamed from: androidx.transition.Transition$e */
    public static abstract class AbstractC0922e {
        /* renamed from: a */
        public abstract Rect mo5754a(Transition transition);
    }

    /* renamed from: androidx.transition.Transition$f */
    public interface InterfaceC0923f {
        /* renamed from: a */
        void mo5755a(Transition transition);

        /* renamed from: b */
        void mo5636b(Transition transition);

        /* renamed from: c */
        void mo5637c(Transition transition);

        /* renamed from: d */
        void mo5638d(Transition transition);

        /* renamed from: e */
        void mo5639e(Transition transition);
    }

    public Transition() {
    }

    /* renamed from: A */
    public static C11207a<Animator, C0921d> m5700A() {
        C11207a<Animator, C0921d> c11207a = f4765J.get();
        if (c11207a != null) {
            return c11207a;
        }
        C11207a<Animator, C0921d> c11207a2 = new C11207a<>();
        f4765J.set(c11207a2);
        return c11207a2;
    }

    /* renamed from: K */
    public static boolean m5701K(int i10) {
        return i10 >= 1 && i10 <= 4;
    }

    /* renamed from: M */
    public static boolean m5702M(C0959t c0959t, C0959t c0959t2, String str) {
        Object obj = c0959t.f4888a.get(str);
        Object obj2 = c0959t2.f4888a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return !obj.equals(obj2);
    }

    /* renamed from: S */
    public static int[] m5703S(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        int[] iArr = new int[stringTokenizer.countTokens()];
        int i10 = 0;
        while (stringTokenizer.hasMoreTokens()) {
            String strTrim = stringTokenizer.nextToken().trim();
            if ("id".equalsIgnoreCase(strTrim)) {
                iArr[i10] = 3;
            } else if ("instance".equalsIgnoreCase(strTrim)) {
                iArr[i10] = 1;
            } else if ("name".equalsIgnoreCase(strTrim)) {
                iArr[i10] = 2;
            } else if ("itemId".equalsIgnoreCase(strTrim)) {
                iArr[i10] = 4;
            } else {
                if (!strTrim.isEmpty()) {
                    throw new InflateException("Unknown match type in matchOrder: '" + strTrim + "'");
                }
                int[] iArr2 = new int[iArr.length - 1];
                System.arraycopy(iArr, 0, iArr2, 0, i10);
                i10--;
                iArr = iArr2;
            }
            i10++;
        }
        return iArr;
    }

    /* renamed from: d */
    public static void m5704d(C0960u c0960u, View view, C0959t c0959t) {
        c0960u.f4891a.put(view, c0959t);
        int id2 = view.getId();
        if (id2 >= 0) {
            if (c0960u.f4892b.indexOfKey(id2) >= 0) {
                c0960u.f4892b.put(id2, null);
            } else {
                c0960u.f4892b.put(id2, view);
            }
        }
        String strM59850J = C9603h0.m59850J(view);
        if (strM59850J != null) {
            if (c0960u.f4894d.containsKey(strM59850J)) {
                c0960u.f4894d.put(strM59850J, null);
            } else {
                c0960u.f4894d.put(strM59850J, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (c0960u.f4893c.m67298j(itemIdAtPosition) < 0) {
                    C9603h0.m59922z0(view, true);
                    c0960u.f4893c.m67300l(itemIdAtPosition, view);
                    return;
                }
                View viewM67296g = c0960u.f4893c.m67296g(itemIdAtPosition);
                if (viewM67296g != null) {
                    C9603h0.m59922z0(viewM67296g, false);
                    c0960u.f4893c.m67300l(itemIdAtPosition, null);
                }
            }
        }
    }

    /* renamed from: f */
    public static boolean m5705f(int[] iArr, int i10) {
        int i11 = iArr[i10];
        for (int i12 = 0; i12 < i10; i12++) {
            if (iArr[i12] == i11) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: B */
    public long m5706B() {
        return this.f4774b;
    }

    /* renamed from: C */
    public List<Integer> m5707C() {
        return this.f4777e;
    }

    /* renamed from: D */
    public List<String> m5708D() {
        return this.f4779g;
    }

    /* renamed from: E */
    public List<Class<?>> m5709E() {
        return this.f4780h;
    }

    /* renamed from: F */
    public List<View> m5710F() {
        return this.f4778f;
    }

    /* renamed from: G */
    public String[] mo5617G() {
        return null;
    }

    /* renamed from: H */
    public C0959t m5711H(View view, boolean z10) {
        TransitionSet transitionSet = this.f4790r;
        if (transitionSet != null) {
            return transitionSet.m5711H(view, z10);
        }
        return (z10 ? this.f4788p : this.f4789q).f4891a.get(view);
    }

    /* renamed from: J */
    public boolean mo5712J(C0959t c0959t, C0959t c0959t2) {
        if (c0959t == null || c0959t2 == null) {
            return false;
        }
        String[] strArrMo5617G = mo5617G();
        if (strArrMo5617G == null) {
            Iterator<String> it = c0959t.f4888a.keySet().iterator();
            while (it.hasNext()) {
                if (m5702M(c0959t, c0959t2, it.next())) {
                }
            }
            return false;
        }
        for (String str : strArrMo5617G) {
            if (!m5702M(c0959t, c0959t2, str)) {
            }
        }
        return false;
        return true;
    }

    /* renamed from: L */
    public boolean m5713L(View view) {
        ArrayList<Class<?>> arrayList;
        ArrayList<String> arrayList2;
        int id2 = view.getId();
        ArrayList<Integer> arrayList3 = this.f4781i;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id2))) {
            return false;
        }
        ArrayList<View> arrayList4 = this.f4782j;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList<Class<?>> arrayList5 = this.f4783k;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (this.f4783k.get(i10).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.f4784l != null && C9603h0.m59850J(view) != null && this.f4784l.contains(C9603h0.m59850J(view))) {
            return false;
        }
        if ((this.f4777e.size() == 0 && this.f4778f.size() == 0 && (((arrayList = this.f4780h) == null || arrayList.isEmpty()) && ((arrayList2 = this.f4779g) == null || arrayList2.isEmpty()))) || this.f4777e.contains(Integer.valueOf(id2)) || this.f4778f.contains(view)) {
            return true;
        }
        ArrayList<String> arrayList6 = this.f4779g;
        if (arrayList6 != null && arrayList6.contains(C9603h0.m59850J(view))) {
            return true;
        }
        if (this.f4780h != null) {
            for (int i11 = 0; i11 < this.f4780h.size(); i11++) {
                if (this.f4780h.get(i11).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: N */
    public final void m5714N(C11207a<View, C0959t> c11207a, C11207a<View, C0959t> c11207a2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i10 = 0; i10 < size; i10++) {
            View viewValueAt = sparseArray.valueAt(i10);
            if (viewValueAt != null && m5713L(viewValueAt) && (view = sparseArray2.get(sparseArray.keyAt(i10))) != null && m5713L(view)) {
                C0959t c0959t = c11207a.get(viewValueAt);
                C0959t c0959t2 = c11207a2.get(view);
                if (c0959t != null && c0959t2 != null) {
                    this.f4792t.add(c0959t);
                    this.f4793u.add(c0959t2);
                    c11207a.remove(viewValueAt);
                    c11207a2.remove(view);
                }
            }
        }
    }

    /* renamed from: O */
    public final void m5715O(C11207a<View, C0959t> c11207a, C11207a<View, C0959t> c11207a2) {
        C0959t c0959tRemove;
        for (int size = c11207a.size() - 1; size >= 0; size--) {
            View viewM67331i = c11207a.m67331i(size);
            if (viewM67331i != null && m5713L(viewM67331i) && (c0959tRemove = c11207a2.remove(viewM67331i)) != null && m5713L(c0959tRemove.f4889b)) {
                this.f4792t.add(c11207a.mo67333k(size));
                this.f4793u.add(c0959tRemove);
            }
        }
    }

    /* renamed from: P */
    public final void m5716P(C11207a<View, C0959t> c11207a, C11207a<View, C0959t> c11207a2, C11210d<View> c11210d, C11210d<View> c11210d2) {
        View viewM67296g;
        int iM67303o = c11210d.m67303o();
        for (int i10 = 0; i10 < iM67303o; i10++) {
            View viewM67304p = c11210d.m67304p(i10);
            if (viewM67304p != null && m5713L(viewM67304p) && (viewM67296g = c11210d2.m67296g(c11210d.m67299k(i10))) != null && m5713L(viewM67296g)) {
                C0959t c0959t = c11207a.get(viewM67304p);
                C0959t c0959t2 = c11207a2.get(viewM67296g);
                if (c0959t != null && c0959t2 != null) {
                    this.f4792t.add(c0959t);
                    this.f4793u.add(c0959t2);
                    c11207a.remove(viewM67304p);
                    c11207a2.remove(viewM67296g);
                }
            }
        }
    }

    /* renamed from: Q */
    public final void m5717Q(C11207a<View, C0959t> c11207a, C11207a<View, C0959t> c11207a2, C11207a<String, View> c11207a3, C11207a<String, View> c11207a4) {
        View view;
        int size = c11207a3.size();
        for (int i10 = 0; i10 < size; i10++) {
            View viewM67335m = c11207a3.m67335m(i10);
            if (viewM67335m != null && m5713L(viewM67335m) && (view = c11207a4.get(c11207a3.m67331i(i10))) != null && m5713L(view)) {
                C0959t c0959t = c11207a.get(viewM67335m);
                C0959t c0959t2 = c11207a2.get(view);
                if (c0959t != null && c0959t2 != null) {
                    this.f4792t.add(c0959t);
                    this.f4793u.add(c0959t2);
                    c11207a.remove(viewM67335m);
                    c11207a2.remove(view);
                }
            }
        }
    }

    /* renamed from: R */
    public final void m5718R(C0960u c0960u, C0960u c0960u2) {
        C11207a<View, C0959t> c11207a = new C11207a<>(c0960u.f4891a);
        C11207a<View, C0959t> c11207a2 = new C11207a<>(c0960u2.f4891a);
        int i10 = 0;
        while (true) {
            int[] iArr = this.f4791s;
            if (i10 >= iArr.length) {
                m5730c(c11207a, c11207a2);
                return;
            }
            int i11 = iArr[i10];
            if (i11 == 1) {
                m5715O(c11207a, c11207a2);
            } else if (i11 == 2) {
                m5717Q(c11207a, c11207a2, c0960u.f4894d, c0960u2.f4894d);
            } else if (i11 == 3) {
                m5714N(c11207a, c11207a2, c0960u.f4892b, c0960u2.f4892b);
            } else if (i11 == 4) {
                m5716P(c11207a, c11207a2, c0960u.f4893c, c0960u2.f4893c);
            }
            i10++;
        }
    }

    /* renamed from: T */
    public void mo5719T(View view) {
        if (this.f4766A) {
            return;
        }
        C11207a<Animator, C0921d> c11207aM5700A = m5700A();
        int size = c11207aM5700A.size();
        InterfaceC0950k0 interfaceC0950k0M5787d = C0932b0.m5787d(view);
        for (int i10 = size - 1; i10 >= 0; i10--) {
            C0921d c0921dM67335m = c11207aM5700A.m67335m(i10);
            if (c0921dM67335m.f4802a != null && interfaceC0950k0M5787d.equals(c0921dM67335m.f4805d)) {
                C0929a.m5779b(c11207aM5700A.m67331i(i10));
            }
        }
        ArrayList<InterfaceC0923f> arrayList = this.f4767B;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.f4767B.clone();
            int size2 = arrayList2.size();
            for (int i11 = 0; i11 < size2; i11++) {
                ((InterfaceC0923f) arrayList2.get(i11)).mo5636b(this);
            }
        }
        this.f4798z = true;
    }

    /* renamed from: U */
    public void m5720U(ViewGroup viewGroup) {
        C0921d c0921d;
        this.f4792t = new ArrayList<>();
        this.f4793u = new ArrayList<>();
        m5718R(this.f4788p, this.f4789q);
        C11207a<Animator, C0921d> c11207aM5700A = m5700A();
        int size = c11207aM5700A.size();
        InterfaceC0950k0 interfaceC0950k0M5787d = C0932b0.m5787d(viewGroup);
        for (int i10 = size - 1; i10 >= 0; i10--) {
            Animator animatorM67331i = c11207aM5700A.m67331i(i10);
            if (animatorM67331i != null && (c0921d = c11207aM5700A.get(animatorM67331i)) != null && c0921d.f4802a != null && interfaceC0950k0M5787d.equals(c0921d.f4805d)) {
                C0959t c0959t = c0921d.f4804c;
                View view = c0921d.f4802a;
                C0959t c0959tM5711H = m5711H(view, true);
                C0959t c0959tM5750w = m5750w(view, true);
                if (c0959tM5711H == null && c0959tM5750w == null) {
                    c0959tM5750w = this.f4789q.f4891a.get(view);
                }
                if ((c0959tM5711H != null || c0959tM5750w != null) && c0921d.f4806e.mo5712J(c0959t, c0959tM5750w)) {
                    if (animatorM67331i.isRunning() || animatorM67331i.isStarted()) {
                        animatorM67331i.cancel();
                    } else {
                        c11207aM5700A.remove(animatorM67331i);
                    }
                }
            }
        }
        mo5744q(viewGroup, this.f4788p, this.f4789q, this.f4792t, this.f4793u);
        mo5725Z();
    }

    /* renamed from: V */
    public Transition mo5721V(InterfaceC0923f interfaceC0923f) {
        ArrayList<InterfaceC0923f> arrayList = this.f4767B;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(interfaceC0923f);
        if (this.f4767B.size() == 0) {
            this.f4767B = null;
        }
        return this;
    }

    /* renamed from: W */
    public Transition mo5722W(View view) {
        this.f4778f.remove(view);
        return this;
    }

    /* renamed from: X */
    public void mo5723X(View view) {
        if (this.f4798z) {
            if (!this.f4766A) {
                C11207a<Animator, C0921d> c11207aM5700A = m5700A();
                int size = c11207aM5700A.size();
                InterfaceC0950k0 interfaceC0950k0M5787d = C0932b0.m5787d(view);
                for (int i10 = size - 1; i10 >= 0; i10--) {
                    C0921d c0921dM67335m = c11207aM5700A.m67335m(i10);
                    if (c0921dM67335m.f4802a != null && interfaceC0950k0M5787d.equals(c0921dM67335m.f4805d)) {
                        C0929a.m5780c(c11207aM5700A.m67331i(i10));
                    }
                }
                ArrayList<InterfaceC0923f> arrayList = this.f4767B;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.f4767B.clone();
                    int size2 = arrayList2.size();
                    for (int i11 = 0; i11 < size2; i11++) {
                        ((InterfaceC0923f) arrayList2.get(i11)).mo5639e(this);
                    }
                }
            }
            this.f4798z = false;
        }
    }

    /* renamed from: Y */
    public final void m5724Y(Animator animator, C11207a<Animator, C0921d> c11207a) {
        if (animator != null) {
            animator.addListener(new C0919b(c11207a));
            m5735g(animator);
        }
    }

    /* renamed from: Z */
    public void mo5725Z() {
        m5737h0();
        C11207a<Animator, C0921d> c11207aM5700A = m5700A();
        Iterator<Animator> it = this.f4768C.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (c11207aM5700A.containsKey(next)) {
                m5737h0();
                m5724Y(next, c11207aM5700A);
            }
        }
        this.f4768C.clear();
        m5745r();
    }

    /* renamed from: a */
    public Transition mo5726a(InterfaceC0923f interfaceC0923f) {
        if (this.f4767B == null) {
            this.f4767B = new ArrayList<>();
        }
        this.f4767B.add(interfaceC0923f);
        return this;
    }

    /* renamed from: a0 */
    public Transition mo5727a0(long j10) {
        this.f4775c = j10;
        return this;
    }

    /* renamed from: b */
    public Transition mo5728b(View view) {
        this.f4778f.add(view);
        return this;
    }

    /* renamed from: b0 */
    public void mo5729b0(AbstractC0922e abstractC0922e) {
        this.f4770E = abstractC0922e;
    }

    /* renamed from: c */
    public final void m5730c(C11207a<View, C0959t> c11207a, C11207a<View, C0959t> c11207a2) {
        for (int i10 = 0; i10 < c11207a.size(); i10++) {
            C0959t c0959tM67335m = c11207a.m67335m(i10);
            if (m5713L(c0959tM67335m.f4889b)) {
                this.f4792t.add(c0959tM67335m);
                this.f4793u.add(null);
            }
        }
        for (int i11 = 0; i11 < c11207a2.size(); i11++) {
            C0959t c0959tM67335m2 = c11207a2.m67335m(i11);
            if (m5713L(c0959tM67335m2.f4889b)) {
                this.f4793u.add(c0959tM67335m2);
                this.f4792t.add(null);
            }
        }
    }

    /* renamed from: c0 */
    public Transition mo5731c0(TimeInterpolator timeInterpolator) {
        this.f4776d = timeInterpolator;
        return this;
    }

    public void cancel() {
        for (int size = this.f4796x.size() - 1; size >= 0; size--) {
            this.f4796x.get(size).cancel();
        }
        ArrayList<InterfaceC0923f> arrayList = this.f4767B;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        ArrayList arrayList2 = (ArrayList) this.f4767B.clone();
        int size2 = arrayList2.size();
        for (int i10 = 0; i10 < size2; i10++) {
            ((InterfaceC0923f) arrayList2.get(i10)).mo5638d(this);
        }
    }

    /* renamed from: d0 */
    public void m5732d0(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            this.f4791s = f4763H;
            return;
        }
        for (int i10 = 0; i10 < iArr.length; i10++) {
            if (!m5701K(iArr[i10])) {
                throw new IllegalArgumentException("matches contains invalid value");
            }
            if (m5705f(iArr, i10)) {
                throw new IllegalArgumentException("matches contains a duplicate value");
            }
        }
        this.f4791s = (int[]) iArr.clone();
    }

    /* renamed from: e0 */
    public void mo5733e0(PathMotion pathMotion) {
        if (pathMotion == null) {
            this.f4772G = f4764I;
        } else {
            this.f4772G = pathMotion;
        }
    }

    /* renamed from: f0 */
    public void mo5734f0(AbstractC0957r abstractC0957r) {
        this.f4769D = abstractC0957r;
    }

    /* renamed from: g */
    public void m5735g(Animator animator) {
        if (animator == null) {
            m5745r();
            return;
        }
        if (m5746s() >= 0) {
            animator.setDuration(m5746s());
        }
        if (m5706B() >= 0) {
            animator.setStartDelay(m5706B() + animator.getStartDelay());
        }
        if (m5749v() != null) {
            animator.setInterpolator(m5749v());
        }
        animator.addListener(new C0920c());
        animator.start();
    }

    /* renamed from: g0 */
    public Transition mo5736g0(long j10) {
        this.f4774b = j10;
        return this;
    }

    /* renamed from: h0 */
    public void m5737h0() {
        if (this.f4797y == 0) {
            ArrayList<InterfaceC0923f> arrayList = this.f4767B;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.f4767B.clone();
                int size = arrayList2.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((InterfaceC0923f) arrayList2.get(i10)).mo5755a(this);
                }
            }
            this.f4766A = false;
        }
        this.f4797y++;
    }

    /* renamed from: i */
    public abstract void mo5618i(C0959t c0959t);

    /* renamed from: i0 */
    public String mo5738i0(String str) {
        String str2 = str + getClass().getSimpleName() + SplitAppUtil.SPLIT_APP_SUFFIX + Integer.toHexString(hashCode()) + ": ";
        if (this.f4775c != -1) {
            str2 = str2 + "dur(" + this.f4775c + ") ";
        }
        if (this.f4774b != -1) {
            str2 = str2 + "dly(" + this.f4774b + ") ";
        }
        if (this.f4776d != null) {
            str2 = str2 + "interp(" + this.f4776d + ") ";
        }
        if (this.f4777e.size() <= 0 && this.f4778f.size() <= 0) {
            return str2;
        }
        String str3 = str2 + "tgts(";
        if (this.f4777e.size() > 0) {
            for (int i10 = 0; i10 < this.f4777e.size(); i10++) {
                if (i10 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.f4777e.get(i10);
            }
        }
        if (this.f4778f.size() > 0) {
            for (int i11 = 0; i11 < this.f4778f.size(); i11++) {
                if (i11 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.f4778f.get(i11);
            }
        }
        return str3 + ")";
    }

    /* renamed from: j */
    public final void m5739j(View view, boolean z10) {
        if (view == null) {
            return;
        }
        int id2 = view.getId();
        ArrayList<Integer> arrayList = this.f4781i;
        if (arrayList == null || !arrayList.contains(Integer.valueOf(id2))) {
            ArrayList<View> arrayList2 = this.f4782j;
            if (arrayList2 == null || !arrayList2.contains(view)) {
                ArrayList<Class<?>> arrayList3 = this.f4783k;
                if (arrayList3 != null) {
                    int size = arrayList3.size();
                    for (int i10 = 0; i10 < size; i10++) {
                        if (this.f4783k.get(i10).isInstance(view)) {
                            return;
                        }
                    }
                }
                if (view.getParent() instanceof ViewGroup) {
                    C0959t c0959t = new C0959t(view);
                    if (z10) {
                        mo5621l(c0959t);
                    } else {
                        mo5618i(c0959t);
                    }
                    c0959t.f4890c.add(this);
                    mo5740k(c0959t);
                    if (z10) {
                        m5704d(this.f4788p, view, c0959t);
                    } else {
                        m5704d(this.f4789q, view, c0959t);
                    }
                }
                if (view instanceof ViewGroup) {
                    ArrayList<Integer> arrayList4 = this.f4785m;
                    if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id2))) {
                        ArrayList<View> arrayList5 = this.f4786n;
                        if (arrayList5 == null || !arrayList5.contains(view)) {
                            ArrayList<Class<?>> arrayList6 = this.f4787o;
                            if (arrayList6 != null) {
                                int size2 = arrayList6.size();
                                for (int i11 = 0; i11 < size2; i11++) {
                                    if (this.f4787o.get(i11).isInstance(view)) {
                                        return;
                                    }
                                }
                            }
                            ViewGroup viewGroup = (ViewGroup) view;
                            for (int i12 = 0; i12 < viewGroup.getChildCount(); i12++) {
                                m5739j(viewGroup.getChildAt(i12), z10);
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: k */
    public void mo5740k(C0959t c0959t) {
        String[] strArrMo5819b;
        if (this.f4769D == null || c0959t.f4888a.isEmpty() || (strArrMo5819b = this.f4769D.mo5819b()) == null) {
            return;
        }
        for (String str : strArrMo5819b) {
            if (!c0959t.f4888a.containsKey(str)) {
                this.f4769D.mo5818a(c0959t);
                return;
            }
        }
    }

    /* renamed from: l */
    public abstract void mo5621l(C0959t c0959t);

    /* renamed from: m */
    public void m5741m(ViewGroup viewGroup, boolean z10) {
        ArrayList<String> arrayList;
        ArrayList<Class<?>> arrayList2;
        C11207a<String, String> c11207a;
        m5742n(z10);
        if ((this.f4777e.size() > 0 || this.f4778f.size() > 0) && (((arrayList = this.f4779g) == null || arrayList.isEmpty()) && ((arrayList2 = this.f4780h) == null || arrayList2.isEmpty()))) {
            for (int i10 = 0; i10 < this.f4777e.size(); i10++) {
                View viewFindViewById = viewGroup.findViewById(this.f4777e.get(i10).intValue());
                if (viewFindViewById != null) {
                    C0959t c0959t = new C0959t(viewFindViewById);
                    if (z10) {
                        mo5621l(c0959t);
                    } else {
                        mo5618i(c0959t);
                    }
                    c0959t.f4890c.add(this);
                    mo5740k(c0959t);
                    if (z10) {
                        m5704d(this.f4788p, viewFindViewById, c0959t);
                    } else {
                        m5704d(this.f4789q, viewFindViewById, c0959t);
                    }
                }
            }
            for (int i11 = 0; i11 < this.f4778f.size(); i11++) {
                View view = this.f4778f.get(i11);
                C0959t c0959t2 = new C0959t(view);
                if (z10) {
                    mo5621l(c0959t2);
                } else {
                    mo5618i(c0959t2);
                }
                c0959t2.f4890c.add(this);
                mo5740k(c0959t2);
                if (z10) {
                    m5704d(this.f4788p, view, c0959t2);
                } else {
                    m5704d(this.f4789q, view, c0959t2);
                }
            }
        } else {
            m5739j(viewGroup, z10);
        }
        if (z10 || (c11207a = this.f4771F) == null) {
            return;
        }
        int size = c11207a.size();
        ArrayList arrayList3 = new ArrayList(size);
        for (int i12 = 0; i12 < size; i12++) {
            arrayList3.add(this.f4788p.f4894d.remove(this.f4771F.m67331i(i12)));
        }
        for (int i13 = 0; i13 < size; i13++) {
            View view2 = (View) arrayList3.get(i13);
            if (view2 != null) {
                this.f4788p.f4894d.put(this.f4771F.m67335m(i13), view2);
            }
        }
    }

    /* renamed from: n */
    public void m5742n(boolean z10) {
        if (z10) {
            this.f4788p.f4891a.clear();
            this.f4788p.f4892b.clear();
            this.f4788p.f4893c.m67293c();
        } else {
            this.f4789q.f4891a.clear();
            this.f4789q.f4892b.clear();
            this.f4789q.f4893c.m67293c();
        }
    }

    @Override // 
    /* renamed from: o */
    public Transition clone() {
        try {
            Transition transition = (Transition) super.clone();
            transition.f4768C = new ArrayList<>();
            transition.f4788p = new C0960u();
            transition.f4789q = new C0960u();
            transition.f4792t = null;
            transition.f4793u = null;
            return transition;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    /* renamed from: p */
    public Animator mo5623p(ViewGroup viewGroup, C0959t c0959t, C0959t c0959t2) {
        return null;
    }

    /* renamed from: q */
    public void mo5744q(ViewGroup viewGroup, C0960u c0960u, C0960u c0960u2, ArrayList<C0959t> arrayList, ArrayList<C0959t> arrayList2) {
        Animator animatorMo5623p;
        int i10;
        View view;
        Animator animator;
        C0959t c0959t;
        Animator animator2;
        C0959t c0959t2;
        C11207a<Animator, C0921d> c11207aM5700A = m5700A();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        long jMin = Long.MAX_VALUE;
        int i11 = 0;
        while (i11 < size) {
            C0959t c0959t3 = arrayList.get(i11);
            C0959t c0959t4 = arrayList2.get(i11);
            if (c0959t3 != null && !c0959t3.f4890c.contains(this)) {
                c0959t3 = null;
            }
            if (c0959t4 != null && !c0959t4.f4890c.contains(this)) {
                c0959t4 = null;
            }
            if (!(c0959t3 == null && c0959t4 == null) && ((c0959t3 == null || c0959t4 == null || mo5712J(c0959t3, c0959t4)) && (animatorMo5623p = mo5623p(viewGroup, c0959t3, c0959t4)) != null)) {
                if (c0959t4 != null) {
                    view = c0959t4.f4889b;
                    String[] strArrMo5617G = mo5617G();
                    if (strArrMo5617G != null && strArrMo5617G.length > 0) {
                        c0959t2 = new C0959t(view);
                        i10 = size;
                        C0959t c0959t5 = c0960u2.f4891a.get(view);
                        if (c0959t5 != null) {
                            int i12 = 0;
                            while (i12 < strArrMo5617G.length) {
                                Map<String, Object> map = c0959t2.f4888a;
                                String str = strArrMo5617G[i12];
                                map.put(str, c0959t5.f4888a.get(str));
                                i12++;
                                strArrMo5617G = strArrMo5617G;
                            }
                        }
                        int size2 = c11207aM5700A.size();
                        int i13 = 0;
                        while (true) {
                            if (i13 >= size2) {
                                animator2 = animatorMo5623p;
                                break;
                            }
                            C0921d c0921d = c11207aM5700A.get(c11207aM5700A.m67331i(i13));
                            if (c0921d.f4804c != null && c0921d.f4802a == view && c0921d.f4803b.equals(m5751x()) && c0921d.f4804c.equals(c0959t2)) {
                                animator2 = null;
                                break;
                            }
                            i13++;
                        }
                    } else {
                        i10 = size;
                        animator2 = animatorMo5623p;
                        c0959t2 = null;
                    }
                    animator = animator2;
                    c0959t = c0959t2;
                } else {
                    i10 = size;
                    view = c0959t3.f4889b;
                    animator = animatorMo5623p;
                    c0959t = null;
                }
                if (animator != null) {
                    AbstractC0957r abstractC0957r = this.f4769D;
                    if (abstractC0957r != null) {
                        long jMo5800c = abstractC0957r.mo5800c(viewGroup, this, c0959t3, c0959t4);
                        sparseIntArray.put(this.f4768C.size(), (int) jMo5800c);
                        jMin = Math.min(jMo5800c, jMin);
                    }
                    c11207aM5700A.put(animator, new C0921d(view, m5751x(), this, C0932b0.m5787d(viewGroup), c0959t));
                    this.f4768C.add(animator);
                    jMin = jMin;
                }
            } else {
                i10 = size;
            }
            i11++;
            size = i10;
        }
        if (sparseIntArray.size() != 0) {
            for (int i14 = 0; i14 < sparseIntArray.size(); i14++) {
                Animator animator3 = this.f4768C.get(sparseIntArray.keyAt(i14));
                animator3.setStartDelay((sparseIntArray.valueAt(i14) - jMin) + animator3.getStartDelay());
            }
        }
    }

    /* renamed from: r */
    public void m5745r() {
        int i10 = this.f4797y - 1;
        this.f4797y = i10;
        if (i10 == 0) {
            ArrayList<InterfaceC0923f> arrayList = this.f4767B;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.f4767B.clone();
                int size = arrayList2.size();
                for (int i11 = 0; i11 < size; i11++) {
                    ((InterfaceC0923f) arrayList2.get(i11)).mo5637c(this);
                }
            }
            for (int i12 = 0; i12 < this.f4788p.f4893c.m67303o(); i12++) {
                View viewM67304p = this.f4788p.f4893c.m67304p(i12);
                if (viewM67304p != null) {
                    C9603h0.m59922z0(viewM67304p, false);
                }
            }
            for (int i13 = 0; i13 < this.f4789q.f4893c.m67303o(); i13++) {
                View viewM67304p2 = this.f4789q.f4893c.m67304p(i13);
                if (viewM67304p2 != null) {
                    C9603h0.m59922z0(viewM67304p2, false);
                }
            }
            this.f4766A = true;
        }
    }

    /* renamed from: s */
    public long m5746s() {
        return this.f4775c;
    }

    /* renamed from: t */
    public Rect m5747t() {
        AbstractC0922e abstractC0922e = this.f4770E;
        if (abstractC0922e == null) {
            return null;
        }
        return abstractC0922e.mo5754a(this);
    }

    public String toString() {
        return mo5738i0("");
    }

    /* renamed from: u */
    public AbstractC0922e m5748u() {
        return this.f4770E;
    }

    /* renamed from: v */
    public TimeInterpolator m5749v() {
        return this.f4776d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x002d, code lost:
    
        if (r3 < 0) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x002f, code lost:
    
        if (r7 == false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0031, code lost:
    
        r5 = r5.f4793u;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0034, code lost:
    
        r5 = r5.f4792t;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x003d, code lost:
    
        return r5.get(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:?, code lost:
    
        return null;
     */
    /* renamed from: w */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public androidx.transition.C0959t m5750w(android.view.View r6, boolean r7) {
        /*
            r5 = this;
            androidx.transition.TransitionSet r0 = r5.f4790r
            if (r0 == 0) goto L9
            androidx.transition.t r5 = r0.m5750w(r6, r7)
            return r5
        L9:
            if (r7 == 0) goto Le
            java.util.ArrayList<androidx.transition.t> r0 = r5.f4792t
            goto L10
        Le:
            java.util.ArrayList<androidx.transition.t> r0 = r5.f4793u
        L10:
            r1 = 0
            if (r0 != 0) goto L14
            return r1
        L14:
            int r2 = r0.size()
            r3 = 0
        L19:
            if (r3 >= r2) goto L2c
            java.lang.Object r4 = r0.get(r3)
            androidx.transition.t r4 = (androidx.transition.C0959t) r4
            if (r4 != 0) goto L24
            return r1
        L24:
            android.view.View r4 = r4.f4889b
            if (r4 != r6) goto L29
            goto L2d
        L29:
            int r3 = r3 + 1
            goto L19
        L2c:
            r3 = -1
        L2d:
            if (r3 < 0) goto L3d
            if (r7 == 0) goto L34
            java.util.ArrayList<androidx.transition.t> r5 = r5.f4793u
            goto L36
        L34:
            java.util.ArrayList<androidx.transition.t> r5 = r5.f4792t
        L36:
            java.lang.Object r5 = r5.get(r3)
            r1 = r5
            androidx.transition.t r1 = (androidx.transition.C0959t) r1
        L3d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.Transition.m5750w(android.view.View, boolean):androidx.transition.t");
    }

    /* renamed from: x */
    public String m5751x() {
        return this.f4773a;
    }

    /* renamed from: y */
    public PathMotion m5752y() {
        return this.f4772G;
    }

    /* renamed from: z */
    public AbstractC0957r m5753z() {
        return this.f4769D;
    }

    @SuppressLint({"RestrictedApi"})
    public Transition(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0954o.f4866c);
        XmlResourceParser xmlResourceParser = (XmlResourceParser) attributeSet;
        long namedInt = TypedArrayUtils.getNamedInt(typedArrayObtainStyledAttributes, xmlResourceParser, "duration", 1, -1);
        if (namedInt >= 0) {
            mo5727a0(namedInt);
        }
        long namedInt2 = TypedArrayUtils.getNamedInt(typedArrayObtainStyledAttributes, xmlResourceParser, "startDelay", 2, -1);
        if (namedInt2 > 0) {
            mo5736g0(namedInt2);
        }
        int namedResourceId = TypedArrayUtils.getNamedResourceId(typedArrayObtainStyledAttributes, xmlResourceParser, "interpolator", 0, 0);
        if (namedResourceId > 0) {
            mo5731c0(AnimationUtils.loadInterpolator(context, namedResourceId));
        }
        String namedString = TypedArrayUtils.getNamedString(typedArrayObtainStyledAttributes, xmlResourceParser, "matchOrder", 3);
        if (namedString != null) {
            m5732d0(m5703S(namedString));
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
