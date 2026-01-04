package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p024b0.C1089e;
import p273f0.C9603h0;
import p273f0.ViewTreeObserverOnPreDrawListenerC9595e0;

@SuppressLint({"UnknownNullness"})
/* renamed from: androidx.fragment.app.d0 */
/* loaded from: classes.dex */
public abstract class AbstractC0741d0 {

    /* renamed from: androidx.fragment.app.d0$a */
    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ int f4005a;

        /* renamed from: b */
        public final /* synthetic */ ArrayList f4006b;

        /* renamed from: c */
        public final /* synthetic */ ArrayList f4007c;

        /* renamed from: d */
        public final /* synthetic */ ArrayList f4008d;

        /* renamed from: e */
        public final /* synthetic */ ArrayList f4009e;

        public a(int i10, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
            this.f4005a = i10;
            this.f4006b = arrayList;
            this.f4007c = arrayList2;
            this.f4008d = arrayList3;
            this.f4009e = arrayList4;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (int i10 = 0; i10 < this.f4005a; i10++) {
                C9603h0.m59847H0((View) this.f4006b.get(i10), (String) this.f4007c.get(i10));
                C9603h0.m59847H0((View) this.f4008d.get(i10), (String) this.f4009e.get(i10));
            }
        }
    }

    /* renamed from: d */
    public static void m4730d(List<View> list, View view) {
        int size = list.size();
        if (m4731g(list, view, size)) {
            return;
        }
        if (C9603h0.m59850J(view) != null) {
            list.add(view);
        }
        for (int i10 = size; i10 < list.size(); i10++) {
            View view2 = list.get(i10);
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int i11 = 0; i11 < childCount; i11++) {
                    View childAt = viewGroup.getChildAt(i11);
                    if (!m4731g(list, childAt, size) && C9603h0.m59850J(childAt) != null) {
                        list.add(childAt);
                    }
                }
            }
        }
    }

    /* renamed from: g */
    public static boolean m4731g(List<View> list, View view, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            if (list.get(i11) == view) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: i */
    public static boolean m4732i(List list) {
        return list == null || list.isEmpty();
    }

    /* renamed from: a */
    public abstract void mo4712a(Object obj, View view);

    /* renamed from: b */
    public abstract void mo4713b(Object obj, ArrayList<View> arrayList);

    /* renamed from: c */
    public abstract void mo4714c(ViewGroup viewGroup, Object obj);

    /* renamed from: e */
    public abstract boolean mo4715e(Object obj);

    /* renamed from: f */
    public abstract Object mo4716f(Object obj);

    /* renamed from: h */
    public void m4733h(View view, Rect rect) {
        if (C9603h0.m59863S(view)) {
            RectF rectF = new RectF();
            rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
            view.getMatrix().mapRect(rectF);
            rectF.offset(view.getLeft(), view.getTop());
            Object parent = view.getParent();
            while (parent instanceof View) {
                View view2 = (View) parent;
                rectF.offset(-view2.getScrollX(), -view2.getScrollY());
                view2.getMatrix().mapRect(rectF);
                rectF.offset(view2.getLeft(), view2.getTop());
                parent = view2.getParent();
            }
            view.getRootView().getLocationOnScreen(new int[2]);
            rectF.offset(r0[0], r0[1]);
            rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
        }
    }

    /* renamed from: j */
    public abstract Object mo4717j(Object obj, Object obj2, Object obj3);

    /* renamed from: k */
    public abstract Object mo4718k(Object obj, Object obj2, Object obj3);

    /* renamed from: l */
    public ArrayList<String> m4734l(ArrayList<View> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            View view = arrayList.get(i10);
            arrayList2.add(C9603h0.m59850J(view));
            C9603h0.m59847H0(view, null);
        }
        return arrayList2;
    }

    /* renamed from: m */
    public abstract void mo4719m(Object obj, View view, ArrayList<View> arrayList);

    /* renamed from: n */
    public abstract void mo4720n(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3);

    /* renamed from: o */
    public abstract void mo4721o(Object obj, Rect rect);

    /* renamed from: p */
    public abstract void mo4722p(Object obj, View view);

    /* renamed from: q */
    public void mo4723q(Fragment fragment, Object obj, C1089e c1089e, Runnable runnable) {
        runnable.run();
    }

    /* renamed from: r */
    public void m4735r(View view, ArrayList<View> arrayList, ArrayList<View> arrayList2, ArrayList<String> arrayList3, Map<String, String> map) {
        int size = arrayList2.size();
        ArrayList arrayList4 = new ArrayList();
        for (int i10 = 0; i10 < size; i10++) {
            View view2 = arrayList.get(i10);
            String strM59850J = C9603h0.m59850J(view2);
            arrayList4.add(strM59850J);
            if (strM59850J != null) {
                C9603h0.m59847H0(view2, null);
                String str = map.get(strM59850J);
                int i11 = 0;
                while (true) {
                    if (i11 >= size) {
                        break;
                    }
                    if (str.equals(arrayList3.get(i11))) {
                        C9603h0.m59847H0(arrayList2.get(i11), strM59850J);
                        break;
                    }
                    i11++;
                }
            }
        }
        ViewTreeObserverOnPreDrawListenerC9595e0.m59820a(view, new a(size, arrayList2, arrayList3, arrayList, arrayList4));
    }

    /* renamed from: s */
    public abstract void mo4724s(Object obj, View view, ArrayList<View> arrayList);

    /* renamed from: t */
    public abstract void mo4725t(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    /* renamed from: u */
    public abstract Object mo4726u(Object obj);
}
