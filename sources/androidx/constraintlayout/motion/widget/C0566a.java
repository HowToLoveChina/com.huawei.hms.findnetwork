package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.C0585c;
import androidx.constraintlayout.widget.C0588f;
import androidx.constraintlayout.widget.R$id;
import androidx.constraintlayout.widget.R$styleable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p504o.C11770c;
import p642t.C12896a;
import p642t.C12902g;
import p642t.C12908m;

/* renamed from: androidx.constraintlayout.motion.widget.a */
/* loaded from: classes.dex */
public class C0566a {

    /* renamed from: a */
    public final MotionLayout f2692a;

    /* renamed from: m */
    public MotionEvent f2704m;

    /* renamed from: p */
    public MotionLayout.InterfaceC0561g f2707p;

    /* renamed from: q */
    public boolean f2708q;

    /* renamed from: r */
    public final C0569d f2709r;

    /* renamed from: s */
    public float f2710s;

    /* renamed from: t */
    public float f2711t;

    /* renamed from: b */
    public C0588f f2693b = null;

    /* renamed from: c */
    public b f2694c = null;

    /* renamed from: d */
    public boolean f2695d = false;

    /* renamed from: e */
    public ArrayList<b> f2696e = new ArrayList<>();

    /* renamed from: f */
    public b f2697f = null;

    /* renamed from: g */
    public ArrayList<b> f2698g = new ArrayList<>();

    /* renamed from: h */
    public SparseArray<C0585c> f2699h = new SparseArray<>();

    /* renamed from: i */
    public HashMap<String, Integer> f2700i = new HashMap<>();

    /* renamed from: j */
    public SparseIntArray f2701j = new SparseIntArray();

    /* renamed from: k */
    public int f2702k = 400;

    /* renamed from: l */
    public int f2703l = 0;

    /* renamed from: n */
    public boolean f2705n = false;

    /* renamed from: o */
    public boolean f2706o = false;

    /* renamed from: androidx.constraintlayout.motion.widget.a$a */
    public class a implements Interpolator {

        /* renamed from: a */
        public final /* synthetic */ C11770c f2712a;

        public a(C11770c c11770c) {
            this.f2712a = c11770c;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            return (float) this.f2712a.mo70117a(f10);
        }
    }

    public C0566a(Context context, MotionLayout motionLayout, int i10) throws XmlPullParserException, Resources.NotFoundException, IOException {
        this.f2692a = motionLayout;
        this.f2709r = new C0569d(motionLayout);
        m3393K(context, i10);
        SparseArray<C0585c> sparseArray = this.f2699h;
        int i11 = R$id.motion_base;
        sparseArray.put(i11, new C0585c());
        this.f2700i.put("motion_base", Integer.valueOf(i11));
    }

    /* renamed from: a0 */
    public static String m3378a0(String str) {
        if (str == null) {
            return "";
        }
        int iIndexOf = str.indexOf(47);
        return iIndexOf < 0 ? str : str.substring(iIndexOf + 1);
    }

    /* renamed from: A */
    public float m3383A() {
        b bVar = this.f2694c;
        if (bVar == null || bVar.f2725l == null) {
            return 0.0f;
        }
        return this.f2694c.f2725l.m3481l();
    }

    /* renamed from: B */
    public float m3384B() {
        b bVar = this.f2694c;
        if (bVar == null || bVar.f2725l == null) {
            return 0.0f;
        }
        return this.f2694c.f2725l.m3482m();
    }

    /* renamed from: C */
    public float m3385C() {
        b bVar = this.f2694c;
        if (bVar == null || bVar.f2725l == null) {
            return 0.0f;
        }
        return this.f2694c.f2725l.m3483n();
    }

    /* renamed from: D */
    public float m3386D() {
        b bVar = this.f2694c;
        if (bVar == null || bVar.f2725l == null) {
            return 0.0f;
        }
        return this.f2694c.f2725l.m3484o();
    }

    /* renamed from: E */
    public float m3387E() {
        b bVar = this.f2694c;
        if (bVar != null) {
            return bVar.f2722i;
        }
        return 0.0f;
    }

    /* renamed from: F */
    public int m3388F() {
        b bVar = this.f2694c;
        if (bVar == null) {
            return -1;
        }
        return bVar.f2717d;
    }

    /* renamed from: G */
    public b m3389G(int i10) {
        Iterator<b> it = this.f2696e.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.f2714a == i10) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: H */
    public List<b> m3390H(int i10) {
        int iM3430y = m3430y(i10);
        ArrayList arrayList = new ArrayList();
        Iterator<b> it = this.f2696e.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.f2717d == iM3430y || next.f2716c == iM3430y) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* renamed from: I */
    public final boolean m3391I(int i10) {
        int i11 = this.f2701j.get(i10);
        int size = this.f2701j.size();
        while (i11 > 0) {
            if (i11 == i10) {
                return true;
            }
            int i12 = size - 1;
            if (size < 0) {
                return true;
            }
            i11 = this.f2701j.get(i11);
            size = i12;
        }
        return false;
    }

    /* renamed from: J */
    public final boolean m3392J() {
        return this.f2707p != null;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0091  */
    /* renamed from: K */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m3393K(android.content.Context r10, int r11) throws org.xmlpull.v1.XmlPullParserException, android.content.res.Resources.NotFoundException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 452
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.C0566a.m3393K(android.content.Context, int):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0028  */
    /* renamed from: L */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int m3394L(android.content.Context r14, org.xmlpull.v1.XmlPullParser r15) {
        /*
            Method dump skipped, instructions count: 316
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.C0566a.m3394L(android.content.Context, org.xmlpull.v1.XmlPullParser):int");
    }

    /* renamed from: M */
    public final int m3395M(Context context, int i10) throws XmlPullParserException, Resources.NotFoundException, IOException {
        XmlResourceParser xml = context.getResources().getXml(i10);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                String name = xml.getName();
                if (2 == eventType && "ConstraintSet".equals(name)) {
                    return m3394L(context, xml);
                }
            }
            return -1;
        } catch (IOException e10) {
            Log.e("MotionScene", "Error parsing resource: " + i10, e10);
            return -1;
        } catch (XmlPullParserException e11) {
            Log.e("MotionScene", "Error parsing resource: " + i10, e11);
            return -1;
        }
    }

    /* renamed from: N */
    public final void m3396N(Context context, XmlPullParser xmlPullParser) throws XmlPullParserException, Resources.NotFoundException, IOException {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.include);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i10);
            if (index == R$styleable.include_constraintSet) {
                m3395M(context, typedArrayObtainStyledAttributes.getResourceId(index, -1));
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    /* renamed from: O */
    public final void m3397O(Context context, XmlPullParser xmlPullParser) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.MotionScene);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i10);
            if (index == R$styleable.MotionScene_defaultDuration) {
                int i11 = typedArrayObtainStyledAttributes.getInt(index, this.f2702k);
                this.f2702k = i11;
                if (i11 < 8) {
                    this.f2702k = 8;
                }
            } else if (index == R$styleable.MotionScene_layoutDuringTransition) {
                this.f2703l = typedArrayObtainStyledAttributes.getInteger(index, 0);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    /* renamed from: P */
    public void m3398P(float f10, float f11) {
        b bVar = this.f2694c;
        if (bVar == null || bVar.f2725l == null) {
            return;
        }
        this.f2694c.f2725l.m3490u(f10, f11);
    }

    /* renamed from: Q */
    public void m3399Q(float f10, float f11) {
        b bVar = this.f2694c;
        if (bVar == null || bVar.f2725l == null) {
            return;
        }
        this.f2694c.f2725l.m3491v(f10, f11);
    }

    /* renamed from: R */
    public void m3400R(MotionEvent motionEvent, int i10, MotionLayout motionLayout) {
        MotionLayout.InterfaceC0561g interfaceC0561g;
        MotionEvent motionEvent2;
        RectF rectF = new RectF();
        if (this.f2707p == null) {
            this.f2707p = this.f2692a.m3320a0();
        }
        this.f2707p.mo3363b(motionEvent);
        if (i10 != -1) {
            int action = motionEvent.getAction();
            boolean z10 = false;
            if (action == 0) {
                this.f2710s = motionEvent.getRawX();
                this.f2711t = motionEvent.getRawY();
                this.f2704m = motionEvent;
                this.f2705n = false;
                if (this.f2694c.f2725l != null) {
                    RectF rectFM3475f = this.f2694c.f2725l.m3475f(this.f2692a, rectF);
                    if (rectFM3475f != null && !rectFM3475f.contains(this.f2704m.getX(), this.f2704m.getY())) {
                        this.f2704m = null;
                        this.f2705n = true;
                        return;
                    }
                    RectF rectFM3485p = this.f2694c.f2725l.m3485p(this.f2692a, rectF);
                    if (rectFM3485p == null || rectFM3485p.contains(this.f2704m.getX(), this.f2704m.getY())) {
                        this.f2706o = false;
                    } else {
                        this.f2706o = true;
                    }
                    this.f2694c.f2725l.m3492w(this.f2710s, this.f2711t);
                    return;
                }
                return;
            }
            if (action == 2 && !this.f2705n) {
                float rawY = motionEvent.getRawY() - this.f2711t;
                float rawX = motionEvent.getRawX() - this.f2710s;
                if ((rawX == 0.0d && rawY == 0.0d) || (motionEvent2 = this.f2704m) == null) {
                    return;
                }
                b bVarM3414i = m3414i(i10, rawX, rawY, motionEvent2);
                if (bVarM3414i != null) {
                    motionLayout.setTransition(bVarM3414i);
                    RectF rectFM3485p2 = this.f2694c.f2725l.m3485p(this.f2692a, rectF);
                    if (rectFM3485p2 != null && !rectFM3485p2.contains(this.f2704m.getX(), this.f2704m.getY())) {
                        z10 = true;
                    }
                    this.f2706o = z10;
                    this.f2694c.f2725l.m3495z(this.f2710s, this.f2711t);
                }
            }
        }
        if (this.f2705n) {
            return;
        }
        b bVar = this.f2694c;
        if (bVar != null && bVar.f2725l != null && !this.f2706o) {
            this.f2694c.f2725l.m3488s(motionEvent, this.f2707p, i10, this);
        }
        this.f2710s = motionEvent.getRawX();
        this.f2711t = motionEvent.getRawY();
        if (motionEvent.getAction() != 1 || (interfaceC0561g = this.f2707p) == null) {
            return;
        }
        interfaceC0561g.mo3362a();
        this.f2707p = null;
        int i11 = motionLayout.f2598f;
        if (i11 != -1) {
            m3413h(motionLayout, i11);
        }
    }

    /* renamed from: S */
    public final void m3401S(int i10, MotionLayout motionLayout) {
        C0585c c0585c = this.f2699h.get(i10);
        c0585c.f3099c = c0585c.f3098b;
        int i11 = this.f2701j.get(i10);
        if (i11 > 0) {
            m3401S(i11, motionLayout);
            C0585c c0585c2 = this.f2699h.get(i11);
            if (c0585c2 == null) {
                Log.e("MotionScene", "ERROR! invalid deriveConstraintsFrom: @id/" + C12896a.m77317c(this.f2692a.getContext(), i11));
                return;
            }
            c0585c.f3099c += "/" + c0585c2.f3099c;
            c0585c.m3625M(c0585c2);
        } else {
            c0585c.f3099c += "  layout";
            c0585c.m3624L(motionLayout);
        }
        c0585c.m3630h(c0585c);
    }

    /* renamed from: T */
    public void m3402T(MotionLayout motionLayout) {
        for (int i10 = 0; i10 < this.f2699h.size(); i10++) {
            int iKeyAt = this.f2699h.keyAt(i10);
            if (m3391I(iKeyAt)) {
                Log.e("MotionScene", "Cannot be derived from yourself");
                return;
            }
            m3401S(iKeyAt, motionLayout);
        }
    }

    /* renamed from: U */
    public void m3403U(int i10, C0585c c0585c) {
        this.f2699h.put(i10, c0585c);
    }

    /* renamed from: V */
    public void m3404V(int i10) {
        b bVar = this.f2694c;
        if (bVar != null) {
            bVar.m3455E(i10);
        } else {
            this.f2702k = i10;
        }
    }

    /* renamed from: W */
    public void m3405W(boolean z10) {
        this.f2708q = z10;
        b bVar = this.f2694c;
        if (bVar == null || bVar.f2725l == null) {
            return;
        }
        this.f2694c.f2725l.m3493x(this.f2708q);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0096  */
    /* renamed from: X */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m3406X(int r7, int r8) {
        /*
            r6 = this;
            androidx.constraintlayout.widget.f r0 = r6.f2693b
            r1 = -1
            if (r0 == 0) goto L18
            int r0 = r0.m3674c(r7, r1, r1)
            if (r0 == r1) goto Lc
            goto Ld
        Lc:
            r0 = r7
        Ld:
            androidx.constraintlayout.widget.f r2 = r6.f2693b
            int r2 = r2.m3674c(r8, r1, r1)
            if (r2 == r1) goto L16
            goto L1a
        L16:
            r2 = r8
            goto L1a
        L18:
            r0 = r7
            goto L16
        L1a:
            androidx.constraintlayout.motion.widget.a$b r3 = r6.f2694c
            if (r3 == 0) goto L2d
            int r3 = androidx.constraintlayout.motion.widget.C0566a.b.m3432a(r3)
            if (r3 != r8) goto L2d
            androidx.constraintlayout.motion.widget.a$b r3 = r6.f2694c
            int r3 = androidx.constraintlayout.motion.widget.C0566a.b.m3434c(r3)
            if (r3 != r7) goto L2d
            return
        L2d:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.a$b> r3 = r6.f2696e
            java.util.Iterator r3 = r3.iterator()
        L33:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L6d
            java.lang.Object r4 = r3.next()
            androidx.constraintlayout.motion.widget.a$b r4 = (androidx.constraintlayout.motion.widget.C0566a.b) r4
            int r5 = androidx.constraintlayout.motion.widget.C0566a.b.m3432a(r4)
            if (r5 != r2) goto L4b
            int r5 = androidx.constraintlayout.motion.widget.C0566a.b.m3434c(r4)
            if (r5 == r0) goto L57
        L4b:
            int r5 = androidx.constraintlayout.motion.widget.C0566a.b.m3432a(r4)
            if (r5 != r8) goto L33
            int r5 = androidx.constraintlayout.motion.widget.C0566a.b.m3434c(r4)
            if (r5 != r7) goto L33
        L57:
            r6.f2694c = r4
            if (r4 == 0) goto L6c
            androidx.constraintlayout.motion.widget.b r7 = androidx.constraintlayout.motion.widget.C0566a.b.m3443l(r4)
            if (r7 == 0) goto L6c
            androidx.constraintlayout.motion.widget.a$b r7 = r6.f2694c
            androidx.constraintlayout.motion.widget.b r7 = androidx.constraintlayout.motion.widget.C0566a.b.m3443l(r7)
            boolean r6 = r6.f2708q
            r7.m3493x(r6)
        L6c:
            return
        L6d:
            androidx.constraintlayout.motion.widget.a$b r7 = r6.f2697f
            java.util.ArrayList<androidx.constraintlayout.motion.widget.a$b> r3 = r6.f2698g
            java.util.Iterator r3 = r3.iterator()
        L75:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L89
            java.lang.Object r4 = r3.next()
            androidx.constraintlayout.motion.widget.a$b r4 = (androidx.constraintlayout.motion.widget.C0566a.b) r4
            int r5 = androidx.constraintlayout.motion.widget.C0566a.b.m3432a(r4)
            if (r5 != r8) goto L75
            r7 = r4
            goto L75
        L89:
            androidx.constraintlayout.motion.widget.a$b r8 = new androidx.constraintlayout.motion.widget.a$b
            r8.<init>(r6, r7)
            androidx.constraintlayout.motion.widget.C0566a.b.m3435d(r8, r0)
            androidx.constraintlayout.motion.widget.C0566a.b.m3433b(r8, r2)
            if (r0 == r1) goto L9b
            java.util.ArrayList<androidx.constraintlayout.motion.widget.a$b> r7 = r6.f2696e
            r7.add(r8)
        L9b:
            r6.f2694c = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.C0566a.m3406X(int, int):void");
    }

    /* renamed from: Y */
    public void m3407Y(b bVar) {
        this.f2694c = bVar;
        if (bVar == null || bVar.f2725l == null) {
            return;
        }
        this.f2694c.f2725l.m3493x(this.f2708q);
    }

    /* renamed from: Z */
    public void m3408Z() {
        b bVar = this.f2694c;
        if (bVar == null || bVar.f2725l == null) {
            return;
        }
        this.f2694c.f2725l.m3469A();
    }

    /* renamed from: b0 */
    public boolean m3409b0() {
        Iterator<b> it = this.f2696e.iterator();
        while (it.hasNext()) {
            if (it.next().f2725l != null) {
                return true;
            }
        }
        b bVar = this.f2694c;
        return (bVar == null || bVar.f2725l == null) ? false : true;
    }

    /* renamed from: c0 */
    public void m3410c0(int i10, View... viewArr) {
        this.f2709r.m3524i(i10, viewArr);
    }

    /* renamed from: f */
    public void m3411f(MotionLayout motionLayout, int i10) {
        Iterator<b> it = this.f2696e.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.f2726m.size() > 0) {
                Iterator it2 = next.f2726m.iterator();
                while (it2.hasNext()) {
                    ((b.a) it2.next()).m3468c(motionLayout);
                }
            }
        }
        Iterator<b> it3 = this.f2698g.iterator();
        while (it3.hasNext()) {
            b next2 = it3.next();
            if (next2.f2726m.size() > 0) {
                Iterator it4 = next2.f2726m.iterator();
                while (it4.hasNext()) {
                    ((b.a) it4.next()).m3468c(motionLayout);
                }
            }
        }
        Iterator<b> it5 = this.f2696e.iterator();
        while (it5.hasNext()) {
            b next3 = it5.next();
            if (next3.f2726m.size() > 0) {
                Iterator it6 = next3.f2726m.iterator();
                while (it6.hasNext()) {
                    ((b.a) it6.next()).m3466a(motionLayout, i10, next3);
                }
            }
        }
        Iterator<b> it7 = this.f2698g.iterator();
        while (it7.hasNext()) {
            b next4 = it7.next();
            if (next4.f2726m.size() > 0) {
                Iterator it8 = next4.f2726m.iterator();
                while (it8.hasNext()) {
                    ((b.a) it8.next()).m3466a(motionLayout, i10, next4);
                }
            }
        }
    }

    /* renamed from: g */
    public boolean m3412g(int i10, C12908m c12908m) {
        return this.f2709r.m3519d(i10, c12908m);
    }

    /* renamed from: h */
    public boolean m3413h(MotionLayout motionLayout, int i10) {
        b bVar;
        if (m3392J() || this.f2695d) {
            return false;
        }
        Iterator<b> it = this.f2696e.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.f2727n != 0 && ((bVar = this.f2694c) != next || !bVar.m3454D(2))) {
                if (i10 == next.f2717d && (next.f2727n == 4 || next.f2727n == 2)) {
                    MotionLayout.EnumC0565k enumC0565k = MotionLayout.EnumC0565k.FINISHED;
                    motionLayout.setState(enumC0565k);
                    motionLayout.setTransition(next);
                    if (next.f2727n == 4) {
                        motionLayout.m3329j0();
                        motionLayout.setState(MotionLayout.EnumC0565k.SETUP);
                        motionLayout.setState(MotionLayout.EnumC0565k.MOVING);
                    } else {
                        motionLayout.setProgress(1.0f);
                        motionLayout.m3306M(true);
                        motionLayout.setState(MotionLayout.EnumC0565k.SETUP);
                        motionLayout.setState(MotionLayout.EnumC0565k.MOVING);
                        motionLayout.setState(enumC0565k);
                        motionLayout.m3321b0();
                    }
                    return true;
                }
                if (i10 == next.f2716c && (next.f2727n == 3 || next.f2727n == 1)) {
                    MotionLayout.EnumC0565k enumC0565k2 = MotionLayout.EnumC0565k.FINISHED;
                    motionLayout.setState(enumC0565k2);
                    motionLayout.setTransition(next);
                    if (next.f2727n == 3) {
                        motionLayout.m3331l0();
                        motionLayout.setState(MotionLayout.EnumC0565k.SETUP);
                        motionLayout.setState(MotionLayout.EnumC0565k.MOVING);
                    } else {
                        motionLayout.setProgress(0.0f);
                        motionLayout.m3306M(true);
                        motionLayout.setState(MotionLayout.EnumC0565k.SETUP);
                        motionLayout.setState(MotionLayout.EnumC0565k.MOVING);
                        motionLayout.setState(enumC0565k2);
                        motionLayout.m3321b0();
                    }
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: i */
    public b m3414i(int i10, float f10, float f11, MotionEvent motionEvent) {
        if (i10 == -1) {
            return this.f2694c;
        }
        List<b> listM3390H = m3390H(i10);
        RectF rectF = new RectF();
        float f12 = 0.0f;
        b bVar = null;
        for (b bVar2 : listM3390H) {
            if (!bVar2.f2728o && bVar2.f2725l != null) {
                bVar2.f2725l.m3493x(this.f2708q);
                RectF rectFM3485p = bVar2.f2725l.m3485p(this.f2692a, rectF);
                if (rectFM3485p == null || motionEvent == null || rectFM3485p.contains(motionEvent.getX(), motionEvent.getY())) {
                    RectF rectFM3475f = bVar2.f2725l.m3475f(this.f2692a, rectF);
                    if (rectFM3475f == null || motionEvent == null || rectFM3475f.contains(motionEvent.getX(), motionEvent.getY())) {
                        float fM3470a = bVar2.f2725l.m3470a(f10, f11);
                        if (bVar2.f2725l.f2754l && motionEvent != null) {
                            fM3470a = ((float) (Math.atan2(f11 + r10, f10 + r9) - Math.atan2(motionEvent.getX() - bVar2.f2725l.f2751i, motionEvent.getY() - bVar2.f2725l.f2752j))) * 10.0f;
                        }
                        float f13 = fM3470a * (bVar2.f2716c == i10 ? -1.0f : 1.1f);
                        if (f13 > f12) {
                            bVar = bVar2;
                            f12 = f13;
                        }
                    }
                }
            }
        }
        return bVar;
    }

    /* renamed from: j */
    public int m3415j() {
        b bVar = this.f2694c;
        if (bVar != null) {
            return bVar.f2729p;
        }
        return -1;
    }

    /* renamed from: k */
    public int m3416k() {
        b bVar = this.f2694c;
        if (bVar == null || bVar.f2725l == null) {
            return 0;
        }
        return this.f2694c.f2725l.m3473d();
    }

    /* renamed from: l */
    public C0585c m3417l(int i10) {
        return m3418m(i10, -1, -1);
    }

    /* renamed from: m */
    public C0585c m3418m(int i10, int i11, int i12) {
        int iM3674c;
        C0588f c0588f = this.f2693b;
        if (c0588f != null && (iM3674c = c0588f.m3674c(i10, i11, i12)) != -1) {
            i10 = iM3674c;
        }
        if (this.f2699h.get(i10) != null) {
            return this.f2699h.get(i10);
        }
        Log.e("MotionScene", "Warning could not find ConstraintSet id/" + C12896a.m77317c(this.f2692a.getContext(), i10) + " In MotionScene");
        SparseArray<C0585c> sparseArray = this.f2699h;
        return sparseArray.get(sparseArray.keyAt(0));
    }

    /* renamed from: n */
    public int[] m3419n() {
        int size = this.f2699h.size();
        int[] iArr = new int[size];
        for (int i10 = 0; i10 < size; i10++) {
            iArr[i10] = this.f2699h.keyAt(i10);
        }
        return iArr;
    }

    /* renamed from: o */
    public ArrayList<b> m3420o() {
        return this.f2696e;
    }

    /* renamed from: p */
    public int m3421p() {
        b bVar = this.f2694c;
        return bVar != null ? bVar.f2721h : this.f2702k;
    }

    /* renamed from: q */
    public int m3422q() {
        b bVar = this.f2694c;
        if (bVar == null) {
            return -1;
        }
        return bVar.f2716c;
    }

    /* renamed from: r */
    public final int m3423r(Context context, String str) {
        int identifier;
        if (str.contains("/")) {
            identifier = context.getResources().getIdentifier(str.substring(str.indexOf(47) + 1), "id", context.getPackageName());
        } else {
            identifier = -1;
        }
        if (identifier != -1) {
            return identifier;
        }
        if (str.length() > 1) {
            return Integer.parseInt(str.substring(1));
        }
        Log.e("MotionScene", "error in parsing id");
        return identifier;
    }

    /* renamed from: s */
    public Interpolator m3424s() {
        int i10 = this.f2694c.f2718e;
        if (i10 == -2) {
            return AnimationUtils.loadInterpolator(this.f2692a.getContext(), this.f2694c.f2720g);
        }
        if (i10 == -1) {
            return new a(C11770c.m70116c(this.f2694c.f2719f));
        }
        if (i10 == 0) {
            return new AccelerateDecelerateInterpolator();
        }
        if (i10 == 1) {
            return new AccelerateInterpolator();
        }
        if (i10 == 2) {
            return new DecelerateInterpolator();
        }
        if (i10 == 4) {
            return new BounceInterpolator();
        }
        if (i10 == 5) {
            return new OvershootInterpolator();
        }
        if (i10 != 6) {
            return null;
        }
        return new AnticipateInterpolator();
    }

    /* renamed from: t */
    public void m3425t(C12908m c12908m) {
        b bVar = this.f2694c;
        if (bVar != null) {
            Iterator it = bVar.f2724k.iterator();
            while (it.hasNext()) {
                ((C12902g) it.next()).m77410b(c12908m);
            }
        } else {
            b bVar2 = this.f2697f;
            if (bVar2 != null) {
                Iterator it2 = bVar2.f2724k.iterator();
                while (it2.hasNext()) {
                    ((C12902g) it2.next()).m77410b(c12908m);
                }
            }
        }
    }

    /* renamed from: u */
    public float m3426u() {
        b bVar = this.f2694c;
        if (bVar == null || bVar.f2725l == null) {
            return 0.0f;
        }
        return this.f2694c.f2725l.m3476g();
    }

    /* renamed from: v */
    public float m3427v() {
        b bVar = this.f2694c;
        if (bVar == null || bVar.f2725l == null) {
            return 0.0f;
        }
        return this.f2694c.f2725l.m3477h();
    }

    /* renamed from: w */
    public boolean m3428w() {
        b bVar = this.f2694c;
        if (bVar == null || bVar.f2725l == null) {
            return false;
        }
        return this.f2694c.f2725l.m3478i();
    }

    /* renamed from: x */
    public float m3429x(float f10, float f11) {
        b bVar = this.f2694c;
        if (bVar == null || bVar.f2725l == null) {
            return 0.0f;
        }
        return this.f2694c.f2725l.m3479j(f10, f11);
    }

    /* renamed from: y */
    public final int m3430y(int i10) {
        int iM3674c;
        C0588f c0588f = this.f2693b;
        return (c0588f == null || (iM3674c = c0588f.m3674c(i10, -1, -1)) == -1) ? i10 : iM3674c;
    }

    /* renamed from: z */
    public int m3431z() {
        b bVar = this.f2694c;
        if (bVar == null || bVar.f2725l == null) {
            return 0;
        }
        return this.f2694c.f2725l.m3480k();
    }

    /* renamed from: androidx.constraintlayout.motion.widget.a$b */
    public static class b {

        /* renamed from: a */
        public int f2714a;

        /* renamed from: b */
        public boolean f2715b;

        /* renamed from: c */
        public int f2716c;

        /* renamed from: d */
        public int f2717d;

        /* renamed from: e */
        public int f2718e;

        /* renamed from: f */
        public String f2719f;

        /* renamed from: g */
        public int f2720g;

        /* renamed from: h */
        public int f2721h;

        /* renamed from: i */
        public float f2722i;

        /* renamed from: j */
        public final C0566a f2723j;

        /* renamed from: k */
        public ArrayList<C12902g> f2724k;

        /* renamed from: l */
        public C0567b f2725l;

        /* renamed from: m */
        public ArrayList<a> f2726m;

        /* renamed from: n */
        public int f2727n;

        /* renamed from: o */
        public boolean f2728o;

        /* renamed from: p */
        public int f2729p;

        /* renamed from: q */
        public int f2730q;

        /* renamed from: r */
        public int f2731r;

        /* renamed from: androidx.constraintlayout.motion.widget.a$b$a */
        public static class a implements View.OnClickListener {

            /* renamed from: a */
            public final b f2732a;

            /* renamed from: b */
            public int f2733b;

            /* renamed from: c */
            public int f2734c;

            public a(Context context, b bVar, XmlPullParser xmlPullParser) {
                this.f2733b = -1;
                this.f2734c = 17;
                this.f2732a = bVar;
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.OnClick);
                int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
                for (int i10 = 0; i10 < indexCount; i10++) {
                    int index = typedArrayObtainStyledAttributes.getIndex(i10);
                    if (index == R$styleable.OnClick_targetId) {
                        this.f2733b = typedArrayObtainStyledAttributes.getResourceId(index, this.f2733b);
                    } else if (index == R$styleable.OnClick_clickAction) {
                        this.f2734c = typedArrayObtainStyledAttributes.getInt(index, this.f2734c);
                    }
                }
                typedArrayObtainStyledAttributes.recycle();
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r7v4, types: [android.view.View] */
            /* renamed from: a */
            public void m3466a(MotionLayout motionLayout, int i10, b bVar) {
                int i11 = this.f2733b;
                MotionLayout motionLayoutFindViewById = motionLayout;
                if (i11 != -1) {
                    motionLayoutFindViewById = motionLayout.findViewById(i11);
                }
                if (motionLayoutFindViewById == null) {
                    Log.e("MotionScene", "OnClick could not find id " + this.f2733b);
                    return;
                }
                int i12 = bVar.f2717d;
                int i13 = bVar.f2716c;
                if (i12 == -1) {
                    motionLayoutFindViewById.setOnClickListener(this);
                    return;
                }
                int i14 = this.f2734c;
                boolean z10 = false;
                boolean z11 = ((i14 & 1) != 0 && i10 == i12) | ((i14 & 1) != 0 && i10 == i12) | ((i14 & 256) != 0 && i10 == i12) | ((i14 & 16) != 0 && i10 == i13);
                if ((i14 & 4096) != 0 && i10 == i13) {
                    z10 = true;
                }
                if (z11 || z10) {
                    motionLayoutFindViewById.setOnClickListener(this);
                }
            }

            /* renamed from: b */
            public boolean m3467b(b bVar, MotionLayout motionLayout) {
                b bVar2 = this.f2732a;
                if (bVar2 == bVar) {
                    return true;
                }
                int i10 = bVar2.f2716c;
                int i11 = this.f2732a.f2717d;
                if (i11 == -1) {
                    return motionLayout.f2598f != i10;
                }
                int i12 = motionLayout.f2598f;
                return i12 == i11 || i12 == i10;
            }

            /* renamed from: c */
            public void m3468c(MotionLayout motionLayout) {
                int i10 = this.f2733b;
                if (i10 == -1) {
                    return;
                }
                View viewFindViewById = motionLayout.findViewById(i10);
                if (viewFindViewById != null) {
                    viewFindViewById.setOnClickListener(null);
                    return;
                }
                Log.e("MotionScene", " (*)  could not find id " + this.f2733b);
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MotionLayout motionLayout = this.f2732a.f2723j.f2692a;
                if (motionLayout.m3319Z()) {
                    if (this.f2732a.f2717d == -1) {
                        int currentState = motionLayout.getCurrentState();
                        if (currentState == -1) {
                            motionLayout.m3332m0(this.f2732a.f2716c);
                            return;
                        }
                        b bVar = new b(this.f2732a.f2723j, this.f2732a);
                        bVar.f2717d = currentState;
                        bVar.f2716c = this.f2732a.f2716c;
                        motionLayout.setTransition(bVar);
                        motionLayout.m3329j0();
                        return;
                    }
                    b bVar2 = this.f2732a.f2723j.f2694c;
                    int i10 = this.f2734c;
                    boolean z10 = false;
                    boolean z11 = ((i10 & 1) == 0 && (i10 & 256) == 0) ? false : true;
                    boolean z12 = ((i10 & 16) == 0 && (i10 & 4096) == 0) ? false : true;
                    if (z11 && z12) {
                        b bVar3 = this.f2732a.f2723j.f2694c;
                        b bVar4 = this.f2732a;
                        if (bVar3 != bVar4) {
                            motionLayout.setTransition(bVar4);
                        }
                        if (motionLayout.getCurrentState() != motionLayout.getEndState() && motionLayout.getProgress() <= 0.5f) {
                            z12 = false;
                            z10 = z11;
                        }
                    } else {
                        z10 = z11;
                    }
                    if (m3467b(bVar2, motionLayout)) {
                        if (z10 && (this.f2734c & 1) != 0) {
                            motionLayout.setTransition(this.f2732a);
                            motionLayout.m3329j0();
                            return;
                        }
                        if (z12 && (this.f2734c & 16) != 0) {
                            motionLayout.setTransition(this.f2732a);
                            motionLayout.m3331l0();
                        } else if (z10 && (this.f2734c & 256) != 0) {
                            motionLayout.setTransition(this.f2732a);
                            motionLayout.setProgress(1.0f);
                        } else {
                            if (!z12 || (this.f2734c & 4096) == 0) {
                                return;
                            }
                            motionLayout.setTransition(this.f2732a);
                            motionLayout.setProgress(0.0f);
                        }
                    }
                }
            }
        }

        public b(C0566a c0566a, b bVar) {
            this.f2714a = -1;
            this.f2715b = false;
            this.f2716c = -1;
            this.f2717d = -1;
            this.f2718e = 0;
            this.f2719f = null;
            this.f2720g = -1;
            this.f2721h = 400;
            this.f2722i = 0.0f;
            this.f2724k = new ArrayList<>();
            this.f2725l = null;
            this.f2726m = new ArrayList<>();
            this.f2727n = 0;
            this.f2728o = false;
            this.f2729p = -1;
            this.f2730q = 0;
            this.f2731r = 0;
            this.f2723j = c0566a;
            this.f2721h = c0566a.f2702k;
            if (bVar != null) {
                this.f2729p = bVar.f2729p;
                this.f2718e = bVar.f2718e;
                this.f2719f = bVar.f2719f;
                this.f2720g = bVar.f2720g;
                this.f2721h = bVar.f2721h;
                this.f2724k = bVar.f2724k;
                this.f2722i = bVar.f2722i;
                this.f2730q = bVar.f2730q;
            }
        }

        /* renamed from: A */
        public int m3451A() {
            return this.f2717d;
        }

        /* renamed from: B */
        public C0567b m3452B() {
            return this.f2725l;
        }

        /* renamed from: C */
        public boolean m3453C() {
            return !this.f2728o;
        }

        /* renamed from: D */
        public boolean m3454D(int i10) {
            return (this.f2731r & i10) != 0;
        }

        /* renamed from: E */
        public void m3455E(int i10) {
            this.f2721h = Math.max(i10, 8);
        }

        /* renamed from: F */
        public void m3456F(int i10, String str, int i11) {
            this.f2718e = i10;
            this.f2719f = str;
            this.f2720g = i11;
        }

        /* renamed from: G */
        public void m3457G(int i10) {
            C0567b c0567bM3452B = m3452B();
            if (c0567bM3452B != null) {
                c0567bM3452B.m3494y(i10);
            }
        }

        /* renamed from: H */
        public void m3458H(int i10) {
            this.f2729p = i10;
        }

        /* renamed from: t */
        public void m3459t(C12902g c12902g) {
            this.f2724k.add(c12902g);
        }

        /* renamed from: u */
        public void m3460u(Context context, XmlPullParser xmlPullParser) {
            this.f2726m.add(new a(context, this, xmlPullParser));
        }

        /* renamed from: v */
        public final void m3461v(C0566a c0566a, Context context, TypedArray typedArray) throws XmlPullParserException, Resources.NotFoundException, IOException, NumberFormatException {
            int indexCount = typedArray.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArray.getIndex(i10);
                if (index == R$styleable.Transition_constraintSetEnd) {
                    this.f2716c = typedArray.getResourceId(index, -1);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f2716c);
                    if ("layout".equals(resourceTypeName)) {
                        C0585c c0585c = new C0585c();
                        c0585c.m3621D(context, this.f2716c);
                        c0566a.f2699h.append(this.f2716c, c0585c);
                    } else if ("xml".equals(resourceTypeName)) {
                        this.f2716c = c0566a.m3395M(context, this.f2716c);
                    }
                } else if (index == R$styleable.Transition_constraintSetStart) {
                    this.f2717d = typedArray.getResourceId(index, this.f2717d);
                    String resourceTypeName2 = context.getResources().getResourceTypeName(this.f2717d);
                    if ("layout".equals(resourceTypeName2)) {
                        C0585c c0585c2 = new C0585c();
                        c0585c2.m3621D(context, this.f2717d);
                        c0566a.f2699h.append(this.f2717d, c0585c2);
                    } else if ("xml".equals(resourceTypeName2)) {
                        this.f2717d = c0566a.m3395M(context, this.f2717d);
                    }
                } else if (index == R$styleable.Transition_motionInterpolator) {
                    int i11 = typedArray.peekValue(index).type;
                    if (i11 == 1) {
                        int resourceId = typedArray.getResourceId(index, -1);
                        this.f2720g = resourceId;
                        if (resourceId != -1) {
                            this.f2718e = -2;
                        }
                    } else if (i11 == 3) {
                        String string = typedArray.getString(index);
                        this.f2719f = string;
                        if (string != null) {
                            if (string.indexOf("/") > 0) {
                                this.f2720g = typedArray.getResourceId(index, -1);
                                this.f2718e = -2;
                            } else {
                                this.f2718e = -1;
                            }
                        }
                    } else {
                        this.f2718e = typedArray.getInteger(index, this.f2718e);
                    }
                } else if (index == R$styleable.Transition_duration) {
                    int i12 = typedArray.getInt(index, this.f2721h);
                    this.f2721h = i12;
                    if (i12 < 8) {
                        this.f2721h = 8;
                    }
                } else if (index == R$styleable.Transition_staggered) {
                    this.f2722i = typedArray.getFloat(index, this.f2722i);
                } else if (index == R$styleable.Transition_autoTransition) {
                    this.f2727n = typedArray.getInteger(index, this.f2727n);
                } else if (index == R$styleable.Transition_android_id) {
                    this.f2714a = typedArray.getResourceId(index, this.f2714a);
                } else if (index == R$styleable.Transition_transitionDisable) {
                    this.f2728o = typedArray.getBoolean(index, this.f2728o);
                } else if (index == R$styleable.Transition_pathMotionArc) {
                    this.f2729p = typedArray.getInteger(index, -1);
                } else if (index == R$styleable.Transition_layoutDuringTransition) {
                    this.f2730q = typedArray.getInteger(index, 0);
                } else if (index == R$styleable.Transition_transitionFlags) {
                    this.f2731r = typedArray.getInteger(index, 0);
                }
            }
            if (this.f2717d == -1) {
                this.f2715b = true;
            }
        }

        /* renamed from: w */
        public final void m3462w(C0566a c0566a, Context context, AttributeSet attributeSet) throws XmlPullParserException, Resources.NotFoundException, IOException, NumberFormatException {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Transition);
            m3461v(c0566a, context, typedArrayObtainStyledAttributes);
            typedArrayObtainStyledAttributes.recycle();
        }

        /* renamed from: x */
        public int m3463x() {
            return this.f2727n;
        }

        /* renamed from: y */
        public int m3464y() {
            return this.f2716c;
        }

        /* renamed from: z */
        public int m3465z() {
            return this.f2730q;
        }

        public b(int i10, C0566a c0566a, int i11, int i12) {
            this.f2714a = -1;
            this.f2715b = false;
            this.f2716c = -1;
            this.f2717d = -1;
            this.f2718e = 0;
            this.f2719f = null;
            this.f2720g = -1;
            this.f2721h = 400;
            this.f2722i = 0.0f;
            this.f2724k = new ArrayList<>();
            this.f2725l = null;
            this.f2726m = new ArrayList<>();
            this.f2727n = 0;
            this.f2728o = false;
            this.f2729p = -1;
            this.f2730q = 0;
            this.f2731r = 0;
            this.f2714a = i10;
            this.f2723j = c0566a;
            this.f2717d = i11;
            this.f2716c = i12;
            this.f2721h = c0566a.f2702k;
            this.f2730q = c0566a.f2703l;
        }

        public b(C0566a c0566a, Context context, XmlPullParser xmlPullParser) throws XmlPullParserException, Resources.NotFoundException, IOException, NumberFormatException {
            this.f2714a = -1;
            this.f2715b = false;
            this.f2716c = -1;
            this.f2717d = -1;
            this.f2718e = 0;
            this.f2719f = null;
            this.f2720g = -1;
            this.f2721h = 400;
            this.f2722i = 0.0f;
            this.f2724k = new ArrayList<>();
            this.f2725l = null;
            this.f2726m = new ArrayList<>();
            this.f2727n = 0;
            this.f2728o = false;
            this.f2729p = -1;
            this.f2730q = 0;
            this.f2731r = 0;
            this.f2721h = c0566a.f2702k;
            this.f2730q = c0566a.f2703l;
            this.f2723j = c0566a;
            m3462w(c0566a, context, Xml.asAttributeSet(xmlPullParser));
        }
    }
}
