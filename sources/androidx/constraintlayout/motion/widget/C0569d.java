package androidx.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.motion.widget.C0568c;
import androidx.constraintlayout.widget.C0585c;
import androidx.constraintlayout.widget.C0587e;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import p642t.C12908m;

/* renamed from: androidx.constraintlayout.motion.widget.d */
/* loaded from: classes.dex */
public class C0569d {

    /* renamed from: a */
    public final MotionLayout f2810a;

    /* renamed from: c */
    public HashSet<View> f2812c;

    /* renamed from: e */
    public ArrayList<C0568c.b> f2814e;

    /* renamed from: b */
    public ArrayList<C0568c> f2811b = new ArrayList<>();

    /* renamed from: d */
    public String f2813d = "ViewTransitionController";

    /* renamed from: f */
    public ArrayList<C0568c.b> f2815f = new ArrayList<>();

    /* renamed from: androidx.constraintlayout.motion.widget.d$a */
    public class a implements C0587e.a {

        /* renamed from: a */
        public final /* synthetic */ C0568c f2816a;

        /* renamed from: b */
        public final /* synthetic */ int f2817b;

        /* renamed from: c */
        public final /* synthetic */ boolean f2818c;

        /* renamed from: d */
        public final /* synthetic */ int f2819d;

        public a(C0568c c0568c, int i10, boolean z10, int i11) {
            this.f2816a = c0568c;
            this.f2817b = i10;
            this.f2818c = z10;
            this.f2819d = i11;
        }
    }

    public C0569d(MotionLayout motionLayout) {
        this.f2810a = motionLayout;
    }

    /* renamed from: a */
    public void m3516a(C0568c c0568c) {
        this.f2811b.add(c0568c);
        this.f2812c = null;
        if (c0568c.m3505i() == 4) {
            m3521f(c0568c, true);
        } else if (c0568c.m3505i() == 5) {
            m3521f(c0568c, false);
        }
    }

    /* renamed from: b */
    public void m3517b(C0568c.b bVar) {
        if (this.f2814e == null) {
            this.f2814e = new ArrayList<>();
        }
        this.f2814e.add(bVar);
    }

    /* renamed from: c */
    public void m3518c() {
        ArrayList<C0568c.b> arrayList = this.f2814e;
        if (arrayList == null) {
            return;
        }
        Iterator<C0568c.b> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().m3511a();
        }
        this.f2814e.removeAll(this.f2815f);
        this.f2815f.clear();
        if (this.f2814e.isEmpty()) {
            this.f2814e = null;
        }
    }

    /* renamed from: d */
    public boolean m3519d(int i10, C12908m c12908m) {
        Iterator<C0568c> it = this.f2811b.iterator();
        while (it.hasNext()) {
            C0568c next = it.next();
            if (next.m3501e() == i10) {
                next.f2776f.m77409a(c12908m);
                return true;
            }
        }
        return false;
    }

    /* renamed from: e */
    public void m3520e() {
        this.f2810a.invalidate();
    }

    /* renamed from: f */
    public final void m3521f(C0568c c0568c, boolean z10) {
        ConstraintLayout.getSharedValues().m3670a(c0568c.m3504h(), new a(c0568c, c0568c.m3504h(), z10, c0568c.m3503g()));
    }

    /* renamed from: g */
    public void m3522g(C0568c.b bVar) {
        this.f2815f.add(bVar);
    }

    /* renamed from: h */
    public void m3523h(MotionEvent motionEvent) {
        int currentState = this.f2810a.getCurrentState();
        if (currentState == -1) {
            return;
        }
        if (this.f2812c == null) {
            this.f2812c = new HashSet<>();
            Iterator<C0568c> it = this.f2811b.iterator();
            while (it.hasNext()) {
                C0568c next = it.next();
                int childCount = this.f2810a.getChildCount();
                for (int i10 = 0; i10 < childCount; i10++) {
                    View childAt = this.f2810a.getChildAt(i10);
                    if (next.m3507k(childAt)) {
                        childAt.getId();
                        this.f2812c.add(childAt);
                    }
                }
            }
        }
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        Rect rect = new Rect();
        int action = motionEvent.getAction();
        ArrayList<C0568c.b> arrayList = this.f2814e;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<C0568c.b> it2 = this.f2814e.iterator();
            while (it2.hasNext()) {
                it2.next().m3514d(action, x10, y10);
            }
        }
        if (action == 0 || action == 1) {
            C0585c c0585cM3313T = this.f2810a.m3313T(currentState);
            Iterator<C0568c> it3 = this.f2811b.iterator();
            while (it3.hasNext()) {
                C0568c next2 = it3.next();
                if (next2.m3509m(action)) {
                    Iterator<View> it4 = this.f2812c.iterator();
                    while (it4.hasNext()) {
                        View next3 = it4.next();
                        if (next2.m3507k(next3)) {
                            next3.getHitRect(rect);
                            if (rect.contains((int) x10, (int) y10)) {
                                next2.m3499c(this, this.f2810a, currentState, c0585cM3313T, next3);
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: i */
    public void m3524i(int i10, View... viewArr) {
        ArrayList arrayList = new ArrayList();
        Iterator<C0568c> it = this.f2811b.iterator();
        C0568c c0568c = null;
        while (it.hasNext()) {
            C0568c next = it.next();
            if (next.m3501e() == i10) {
                for (View view : viewArr) {
                    if (next.m3500d(view)) {
                        arrayList.add(view);
                    }
                }
                if (!arrayList.isEmpty()) {
                    m3525j(next, (View[]) arrayList.toArray(new View[0]));
                    arrayList.clear();
                }
                c0568c = next;
            }
        }
        if (c0568c == null) {
            Log.e(this.f2813d, " Could not find ViewTransition");
        }
    }

    /* renamed from: j */
    public final void m3525j(C0568c c0568c, View... viewArr) {
        int currentState = this.f2810a.getCurrentState();
        if (c0568c.f2775e == 2) {
            c0568c.m3499c(this, this.f2810a, currentState, null, viewArr);
            return;
        }
        if (currentState != -1) {
            C0585c c0585cM3313T = this.f2810a.m3313T(currentState);
            if (c0585cM3313T == null) {
                return;
            }
            c0568c.m3499c(this, this.f2810a, currentState, c0585cM3313T, viewArr);
            return;
        }
        Log.w(this.f2813d, "No support for ViewTransition within transition yet. Currently: " + this.f2810a.toString());
    }
}
