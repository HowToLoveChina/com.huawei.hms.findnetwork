package p642t;

import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.widget.C0583a;
import androidx.constraintlayout.widget.C0585c;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.huawei.android.remotecontrol.p093ui.widget.TopAnimatorConfig;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import p504o.AbstractC11769b;
import p504o.C11770c;
import p504o.C11771d;
import p504o.C11783p;
import p627s.AbstractC12656c;
import p627s.AbstractC12657d;
import p627s.AbstractC12659f;
import p627s.C12654a;
import p627s.C12658e;

/* renamed from: t.m */
/* loaded from: classes.dex */
public class C12908m {

    /* renamed from: B */
    public HashMap<String, AbstractC12659f> f58821B;

    /* renamed from: C */
    public HashMap<String, AbstractC12657d> f58822C;

    /* renamed from: D */
    public HashMap<String, AbstractC12656c> f58823D;

    /* renamed from: E */
    public C12906k[] f58824E;

    /* renamed from: F */
    public int f58825F;

    /* renamed from: G */
    public int f58826G;

    /* renamed from: H */
    public View f58827H;

    /* renamed from: I */
    public int f58828I;

    /* renamed from: J */
    public float f58829J;

    /* renamed from: K */
    public Interpolator f58830K;

    /* renamed from: L */
    public boolean f58831L;

    /* renamed from: b */
    public View f58833b;

    /* renamed from: c */
    public int f58834c;

    /* renamed from: e */
    public String f58836e;

    /* renamed from: k */
    public AbstractC11769b[] f58842k;

    /* renamed from: l */
    public AbstractC11769b f58843l;

    /* renamed from: p */
    public float f58847p;

    /* renamed from: q */
    public float f58848q;

    /* renamed from: r */
    public int[] f58849r;

    /* renamed from: s */
    public double[] f58850s;

    /* renamed from: t */
    public double[] f58851t;

    /* renamed from: u */
    public String[] f58852u;

    /* renamed from: v */
    public int[] f58853v;

    /* renamed from: a */
    public Rect f58832a = new Rect();

    /* renamed from: d */
    public boolean f58835d = false;

    /* renamed from: f */
    public int f58837f = -1;

    /* renamed from: g */
    public C12910o f58838g = new C12910o();

    /* renamed from: h */
    public C12910o f58839h = new C12910o();

    /* renamed from: i */
    public C12907l f58840i = new C12907l();

    /* renamed from: j */
    public C12907l f58841j = new C12907l();

    /* renamed from: m */
    public float f58844m = Float.NaN;

    /* renamed from: n */
    public float f58845n = 0.0f;

    /* renamed from: o */
    public float f58846o = 1.0f;

    /* renamed from: w */
    public int f58854w = 4;

    /* renamed from: x */
    public float[] f58855x = new float[4];

    /* renamed from: y */
    public ArrayList<C12910o> f58856y = new ArrayList<>();

    /* renamed from: z */
    public float[] f58857z = new float[1];

    /* renamed from: A */
    public ArrayList<AbstractC12899d> f58820A = new ArrayList<>();

    /* renamed from: t.m$a */
    public class a implements Interpolator {

        /* renamed from: a */
        public final /* synthetic */ C11770c f58858a;

        public a(C11770c c11770c) {
            this.f58858a = c11770c;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            return (float) this.f58858a.mo70117a(f10);
        }
    }

    public C12908m(View view) {
        int i10 = AbstractC12899d.f58688f;
        this.f58825F = i10;
        this.f58826G = i10;
        this.f58827H = null;
        this.f58828I = i10;
        this.f58829J = Float.NaN;
        this.f58830K = null;
        this.f58831L = false;
        m77488H(view);
    }

    /* renamed from: p */
    public static Interpolator m77480p(Context context, int i10, String str, int i11) {
        if (i10 == -2) {
            return AnimationUtils.loadInterpolator(context, i11);
        }
        if (i10 == -1) {
            return new a(C11770c.m70116c(str));
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
        if (i10 != 5) {
            return null;
        }
        return new OvershootInterpolator();
    }

    /* renamed from: A */
    public void m77481A(Rect rect, Rect rect2, int i10, int i11, int i12) {
        if (i10 == 1) {
            int i13 = rect.left + rect.right;
            rect2.left = ((rect.top + rect.bottom) - rect.width()) / 2;
            rect2.top = i12 - ((i13 + rect.height()) / 2);
            rect2.right = rect2.left + rect.width();
            rect2.bottom = rect2.top + rect.height();
            return;
        }
        if (i10 == 2) {
            int i14 = rect.left + rect.right;
            rect2.left = i11 - (((rect.top + rect.bottom) + rect.width()) / 2);
            rect2.top = (i14 - rect.height()) / 2;
            rect2.right = rect2.left + rect.width();
            rect2.bottom = rect2.top + rect.height();
            return;
        }
        if (i10 == 3) {
            int i15 = rect.left + rect.right;
            rect2.left = ((rect.height() / 2) + rect.top) - (i15 / 2);
            rect2.top = i12 - ((i15 + rect.height()) / 2);
            rect2.right = rect2.left + rect.width();
            rect2.bottom = rect2.top + rect.height();
            return;
        }
        if (i10 != 4) {
            return;
        }
        int i16 = rect.left + rect.right;
        rect2.left = i11 - (((rect.bottom + rect.top) + rect.width()) / 2);
        rect2.top = (i16 - rect.height()) / 2;
        rect2.right = rect2.left + rect.width();
        rect2.bottom = rect2.top + rect.height();
    }

    /* renamed from: B */
    public void m77482B(View view) {
        C12910o c12910o = this.f58838g;
        c12910o.f58862c = 0.0f;
        c12910o.f58863d = 0.0f;
        this.f58831L = true;
        c12910o.m77534y(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        this.f58839h.m77534y(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        this.f58840i.m77479r(view);
        this.f58841j.m77479r(view);
    }

    /* renamed from: C */
    public void m77483C(Rect rect, C0585c c0585c, int i10, int i11) {
        int i12 = c0585c.f3101e;
        if (i12 != 0) {
            m77481A(rect, this.f58832a, i12, i10, i11);
            rect = this.f58832a;
        }
        C12910o c12910o = this.f58839h;
        c12910o.f58862c = 1.0f;
        c12910o.f58863d = 1.0f;
        m77514y(c12910o);
        this.f58839h.m77534y(rect.left, rect.top, rect.width(), rect.height());
        this.f58839h.m77518a(c0585c.m3647z(this.f58834c));
        this.f58841j.m77478q(rect, c0585c, i12, this.f58834c);
    }

    /* renamed from: D */
    public void m77484D(int i10) {
        this.f58825F = i10;
    }

    /* renamed from: E */
    public void m77485E(View view) {
        C12910o c12910o = this.f58838g;
        c12910o.f58862c = 0.0f;
        c12910o.f58863d = 0.0f;
        c12910o.m77534y(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        this.f58840i.m77479r(view);
    }

    /* renamed from: F */
    public void m77486F(Rect rect, C0585c c0585c, int i10, int i11) {
        int i12 = c0585c.f3101e;
        if (i12 != 0) {
            m77481A(rect, this.f58832a, i12, i10, i11);
        }
        C12910o c12910o = this.f58838g;
        c12910o.f58862c = 0.0f;
        c12910o.f58863d = 0.0f;
        m77514y(c12910o);
        this.f58838g.m77534y(rect.left, rect.top, rect.width(), rect.height());
        C0585c.a aVarM3647z = c0585c.m3647z(this.f58834c);
        this.f58838g.m77518a(aVarM3647z);
        this.f58844m = aVarM3647z.f3108d.f3202g;
        this.f58840i.m77478q(rect, c0585c, i12, this.f58834c);
        this.f58826G = aVarM3647z.f3110f.f3224i;
        C0585c.c cVar = aVarM3647z.f3108d;
        this.f58828I = cVar.f3206k;
        this.f58829J = cVar.f3205j;
        Context context = this.f58833b.getContext();
        C0585c.c cVar2 = aVarM3647z.f3108d;
        this.f58830K = m77480p(context, cVar2.f3208m, cVar2.f3207l, cVar2.f3209n);
    }

    /* renamed from: G */
    public void m77487G(C12658e c12658e, View view, int i10, int i11, int i12) {
        C12910o c12910o = this.f58838g;
        c12910o.f58862c = 0.0f;
        c12910o.f58863d = 0.0f;
        Rect rect = new Rect();
        if (i10 == 1) {
            int i13 = c12658e.f58135b + c12658e.f58137d;
            rect.left = ((c12658e.f58136c + c12658e.f58138e) - c12658e.m76197b()) / 2;
            rect.top = i11 - ((i13 + c12658e.m76196a()) / 2);
            rect.right = rect.left + c12658e.m76197b();
            rect.bottom = rect.top + c12658e.m76196a();
        } else if (i10 == 2) {
            int i14 = c12658e.f58135b + c12658e.f58137d;
            rect.left = i12 - (((c12658e.f58136c + c12658e.f58138e) + c12658e.m76197b()) / 2);
            rect.top = (i14 - c12658e.m76196a()) / 2;
            rect.right = rect.left + c12658e.m76197b();
            rect.bottom = rect.top + c12658e.m76196a();
        }
        this.f58838g.m77534y(rect.left, rect.top, rect.width(), rect.height());
        this.f58840i.m77477p(rect, view, i10, c12658e.f58134a);
    }

    /* renamed from: H */
    public void m77488H(View view) {
        this.f58833b = view;
        this.f58834c = view.getId();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            this.f58836e = ((ConstraintLayout.LayoutParams) layoutParams).m3568a();
        }
    }

    /* renamed from: I */
    public void m77489I(int i10, int i11, float f10, long j10) {
        ArrayList arrayList;
        String[] strArr;
        double[][] dArr;
        C0583a c0583a;
        AbstractC12659f abstractC12659fM76199h;
        C0583a c0583a2;
        Integer num;
        AbstractC12657d abstractC12657dM76192g;
        C0583a c0583a3;
        new HashSet();
        HashSet<String> hashSet = new HashSet<>();
        HashSet<String> hashSet2 = new HashSet<>();
        HashSet<String> hashSet3 = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        int i12 = this.f58825F;
        if (i12 != AbstractC12899d.f58688f) {
            this.f58838g.f58870k = i12;
        }
        this.f58840i.m77475i(this.f58841j, hashSet2);
        ArrayList<AbstractC12899d> arrayList2 = this.f58820A;
        if (arrayList2 != null) {
            Iterator<AbstractC12899d> it = arrayList2.iterator();
            arrayList = null;
            while (it.hasNext()) {
                AbstractC12899d next = it.next();
                if (next instanceof C12903h) {
                    C12903h c12903h = (C12903h) next;
                    m77512w(new C12910o(i10, i11, c12903h, this.f58838g, this.f58839h));
                    int i13 = c12903h.f58748g;
                    if (i13 != AbstractC12899d.f58688f) {
                        this.f58837f = i13;
                    }
                } else if (next instanceof C12901f) {
                    next.mo77325d(hashSet3);
                } else if (next instanceof C12905j) {
                    next.mo77325d(hashSet);
                } else if (next instanceof C12906k) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add((C12906k) next);
                } else {
                    next.mo77329h(map);
                    next.mo77325d(hashSet2);
                }
            }
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            this.f58824E = (C12906k[]) arrayList.toArray(new C12906k[0]);
        }
        if (!hashSet2.isEmpty()) {
            this.f58822C = new HashMap<>();
            Iterator<String> it2 = hashSet2.iterator();
            while (it2.hasNext()) {
                String next2 = it2.next();
                if (next2.startsWith("CUSTOM,")) {
                    SparseArray sparseArray = new SparseArray();
                    String str = next2.split(",")[1];
                    Iterator<AbstractC12899d> it3 = this.f58820A.iterator();
                    while (it3.hasNext()) {
                        AbstractC12899d next3 = it3.next();
                        HashMap<String, C0583a> map2 = next3.f58693e;
                        if (map2 != null && (c0583a3 = map2.get(str)) != null) {
                            sparseArray.append(next3.f58689a, c0583a3);
                        }
                    }
                    abstractC12657dM76192g = AbstractC12657d.m76191f(next2, sparseArray);
                } else {
                    abstractC12657dM76192g = AbstractC12657d.m76192g(next2);
                }
                if (abstractC12657dM76192g != null) {
                    abstractC12657dM76192g.m70152d(next2);
                    this.f58822C.put(next2, abstractC12657dM76192g);
                }
            }
            ArrayList<AbstractC12899d> arrayList3 = this.f58820A;
            if (arrayList3 != null) {
                Iterator<AbstractC12899d> it4 = arrayList3.iterator();
                while (it4.hasNext()) {
                    AbstractC12899d next4 = it4.next();
                    if (next4 instanceof C12900e) {
                        next4.mo77322a(this.f58822C);
                    }
                }
            }
            this.f58840i.m77470a(this.f58822C, 0);
            this.f58841j.m77470a(this.f58822C, 100);
            for (String str2 : this.f58822C.keySet()) {
                int iIntValue = (!map.containsKey(str2) || (num = map.get(str2)) == null) ? 0 : num.intValue();
                AbstractC12657d abstractC12657d = this.f58822C.get(str2);
                if (abstractC12657d != null) {
                    abstractC12657d.mo70153e(iIntValue);
                }
            }
        }
        if (!hashSet.isEmpty()) {
            if (this.f58821B == null) {
                this.f58821B = new HashMap<>();
            }
            Iterator<String> it5 = hashSet.iterator();
            while (it5.hasNext()) {
                String next5 = it5.next();
                if (!this.f58821B.containsKey(next5)) {
                    if (next5.startsWith("CUSTOM,")) {
                        SparseArray sparseArray2 = new SparseArray();
                        String str3 = next5.split(",")[1];
                        Iterator<AbstractC12899d> it6 = this.f58820A.iterator();
                        while (it6.hasNext()) {
                            AbstractC12899d next6 = it6.next();
                            HashMap<String, C0583a> map3 = next6.f58693e;
                            if (map3 != null && (c0583a2 = map3.get(str3)) != null) {
                                sparseArray2.append(next6.f58689a, c0583a2);
                            }
                        }
                        abstractC12659fM76199h = AbstractC12659f.m76198g(next5, sparseArray2);
                    } else {
                        abstractC12659fM76199h = AbstractC12659f.m76199h(next5, j10);
                    }
                    if (abstractC12659fM76199h != null) {
                        abstractC12659fM76199h.m70169d(next5);
                        this.f58821B.put(next5, abstractC12659fM76199h);
                    }
                }
            }
            ArrayList<AbstractC12899d> arrayList4 = this.f58820A;
            if (arrayList4 != null) {
                Iterator<AbstractC12899d> it7 = arrayList4.iterator();
                while (it7.hasNext()) {
                    AbstractC12899d next7 = it7.next();
                    if (next7 instanceof C12905j) {
                        ((C12905j) next7).m77451U(this.f58821B);
                    }
                }
            }
            for (String str4 : this.f58821B.keySet()) {
                this.f58821B.get(str4).mo70170e(map.containsKey(str4) ? map.get(str4).intValue() : 0);
            }
        }
        int size = this.f58856y.size();
        int i14 = size + 2;
        C12910o[] c12910oArr = new C12910o[i14];
        c12910oArr[0] = this.f58838g;
        c12910oArr[size + 1] = this.f58839h;
        if (this.f58856y.size() > 0 && this.f58837f == -1) {
            this.f58837f = 0;
        }
        Iterator<C12910o> it8 = this.f58856y.iterator();
        int i15 = 1;
        while (it8.hasNext()) {
            c12910oArr[i15] = it8.next();
            i15++;
        }
        HashSet hashSet4 = new HashSet();
        for (String str5 : this.f58839h.f58874o.keySet()) {
            if (this.f58838g.f58874o.containsKey(str5)) {
                if (!hashSet2.contains("CUSTOM," + str5)) {
                    hashSet4.add(str5);
                }
            }
        }
        String[] strArr2 = (String[]) hashSet4.toArray(new String[0]);
        this.f58852u = strArr2;
        this.f58853v = new int[strArr2.length];
        int i16 = 0;
        while (true) {
            strArr = this.f58852u;
            if (i16 >= strArr.length) {
                break;
            }
            String str6 = strArr[i16];
            this.f58853v[i16] = 0;
            int i17 = 0;
            while (true) {
                if (i17 >= i14) {
                    break;
                }
                if (c12910oArr[i17].f58874o.containsKey(str6) && (c0583a = c12910oArr[i17].f58874o.get(str6)) != null) {
                    int[] iArr = this.f58853v;
                    iArr[i16] = iArr[i16] + c0583a.m3592h();
                    break;
                }
                i17++;
            }
            i16++;
        }
        boolean z10 = c12910oArr[0].f58870k != AbstractC12899d.f58688f;
        int length = 18 + strArr.length;
        boolean[] zArr = new boolean[length];
        for (int i18 = 1; i18 < i14; i18++) {
            c12910oArr[i18].m77521f(c12910oArr[i18 - 1], zArr, this.f58852u, z10);
        }
        int i19 = 0;
        for (int i20 = 1; i20 < length; i20++) {
            if (zArr[i20]) {
                i19++;
            }
        }
        this.f58849r = new int[i19];
        int iMax = Math.max(2, i19);
        this.f58850s = new double[iMax];
        this.f58851t = new double[iMax];
        int i21 = 0;
        for (int i22 = 1; i22 < length; i22++) {
            if (zArr[i22]) {
                this.f58849r[i21] = i22;
                i21++;
            }
        }
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i14, this.f58849r.length);
        double[] dArr3 = new double[i14];
        for (int i23 = 0; i23 < i14; i23++) {
            c12910oArr[i23].m77522h(dArr2[i23], this.f58849r);
            dArr3[i23] = c12910oArr[i23].f58862c;
        }
        int i24 = 0;
        while (true) {
            int[] iArr2 = this.f58849r;
            if (i24 >= iArr2.length) {
                break;
            }
            if (iArr2[i24] < C12910o.f58859t.length) {
                String str7 = C12910o.f58859t[this.f58849r[i24]] + " [";
                for (int i25 = 0; i25 < i14; i25++) {
                    str7 = str7 + dArr2[i25][i24];
                }
            }
            i24++;
        }
        this.f58842k = new AbstractC11769b[this.f58852u.length + 1];
        int i26 = 0;
        while (true) {
            String[] strArr3 = this.f58852u;
            if (i26 >= strArr3.length) {
                break;
            }
            String str8 = strArr3[i26];
            int i27 = 0;
            int i28 = 0;
            double[] dArr4 = null;
            double[][] dArr5 = null;
            while (i27 < i14) {
                if (c12910oArr[i27].m77528s(str8)) {
                    if (dArr5 == null) {
                        dArr4 = new double[i14];
                        dArr5 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i14, c12910oArr[i27].m77526q(str8));
                    }
                    C12910o c12910o = c12910oArr[i27];
                    dArr = dArr2;
                    dArr4[i28] = c12910o.f58862c;
                    c12910o.m77525p(str8, dArr5[i28], 0);
                    i28++;
                } else {
                    dArr = dArr2;
                }
                i27++;
                dArr2 = dArr;
            }
            i26++;
            this.f58842k[i26] = AbstractC11769b.m70114a(this.f58837f, Arrays.copyOf(dArr4, i28), (double[][]) Arrays.copyOf(dArr5, i28));
            dArr2 = dArr2;
        }
        this.f58842k[0] = AbstractC11769b.m70114a(this.f58837f, dArr3, dArr2);
        if (c12910oArr[0].f58870k != AbstractC12899d.f58688f) {
            int[] iArr3 = new int[i14];
            double[] dArr6 = new double[i14];
            double[][] dArr7 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i14, 2);
            for (int i29 = 0; i29 < i14; i29++) {
                iArr3[i29] = c12910oArr[i29].f58870k;
                dArr6[i29] = r9.f58862c;
                double[] dArr8 = dArr7[i29];
                dArr8[0] = r9.f58864e;
                dArr8[1] = r9.f58865f;
            }
            this.f58843l = AbstractC11769b.m70115b(iArr3, dArr6, dArr7);
        }
        this.f58823D = new HashMap<>();
        if (this.f58820A != null) {
            Iterator<String> it9 = hashSet3.iterator();
            float fM77508s = Float.NaN;
            while (it9.hasNext()) {
                String next8 = it9.next();
                AbstractC12656c abstractC12656cM76188i = AbstractC12656c.m76188i(next8);
                if (abstractC12656cM76188i != null) {
                    if (abstractC12656cM76188i.m70130h() && Float.isNaN(fM77508s)) {
                        fM77508s = m77508s();
                    }
                    abstractC12656cM76188i.m70128f(next8);
                    this.f58823D.put(next8, abstractC12656cM76188i);
                }
            }
            Iterator<AbstractC12899d> it10 = this.f58820A.iterator();
            while (it10.hasNext()) {
                AbstractC12899d next9 = it10.next();
                if (next9 instanceof C12901f) {
                    ((C12901f) next9).m77405Y(this.f58823D);
                }
            }
            Iterator<AbstractC12656c> it11 = this.f58823D.values().iterator();
            while (it11.hasNext()) {
                it11.next().m70129g(fM77508s);
            }
        }
    }

    /* renamed from: J */
    public void m77490J(C12908m c12908m) {
        this.f58838g.m77517B(c12908m, c12908m.f58838g);
        this.f58839h.m77517B(c12908m, c12908m.f58839h);
    }

    /* renamed from: a */
    public void m77491a(AbstractC12899d abstractC12899d) {
        this.f58820A.add(abstractC12899d);
    }

    /* renamed from: b */
    public void m77492b(ArrayList<AbstractC12899d> arrayList) {
        this.f58820A.addAll(arrayList);
    }

    /* renamed from: c */
    public int m77493c(float[] fArr, int[] iArr) {
        if (fArr == null) {
            return 0;
        }
        double[] dArrMo70102h = this.f58842k[0].mo70102h();
        if (iArr != null) {
            Iterator<C12910o> it = this.f58856y.iterator();
            int i10 = 0;
            while (it.hasNext()) {
                iArr[i10] = it.next().f58875p;
                i10++;
            }
        }
        int i11 = 0;
        for (int i12 = 0; i12 < dArrMo70102h.length; i12++) {
            this.f58842k[0].mo70098d(dArrMo70102h[i12], this.f58850s);
            this.f58838g.m77523i(dArrMo70102h[i12], this.f58849r, this.f58850s, fArr, i11);
            i11 += 2;
        }
        return i11 / 2;
    }

    /* renamed from: d */
    public void m77494d(float[] fArr, int i10) {
        double dMo70117a;
        float f10 = 1.0f;
        float f11 = 1.0f / (i10 - 1);
        HashMap<String, AbstractC12657d> map = this.f58822C;
        AbstractC12657d abstractC12657d = map == null ? null : map.get("translationX");
        HashMap<String, AbstractC12657d> map2 = this.f58822C;
        AbstractC12657d abstractC12657d2 = map2 == null ? null : map2.get("translationY");
        HashMap<String, AbstractC12656c> map3 = this.f58823D;
        AbstractC12656c abstractC12656c = map3 == null ? null : map3.get("translationX");
        HashMap<String, AbstractC12656c> map4 = this.f58823D;
        AbstractC12656c abstractC12656c2 = map4 != null ? map4.get("translationY") : null;
        int i11 = 0;
        while (i11 < i10) {
            float fMin = i11 * f11;
            float f12 = this.f58846o;
            float f13 = 0.0f;
            if (f12 != f10) {
                float f14 = this.f58845n;
                if (fMin < f14) {
                    fMin = 0.0f;
                }
                if (fMin > f14 && fMin < 1.0d) {
                    fMin = Math.min((fMin - f14) * f12, f10);
                }
            }
            float f15 = fMin;
            double d10 = f15;
            C11770c c11770c = this.f58838g.f58860a;
            Iterator<C12910o> it = this.f58856y.iterator();
            float f16 = Float.NaN;
            while (it.hasNext()) {
                C12910o next = it.next();
                C11770c c11770c2 = next.f58860a;
                double d11 = d10;
                if (c11770c2 != null) {
                    float f17 = next.f58862c;
                    if (f17 < f15) {
                        f13 = f17;
                        c11770c = c11770c2;
                    } else if (Float.isNaN(f16)) {
                        f16 = next.f58862c;
                    }
                }
                d10 = d11;
            }
            double d12 = d10;
            if (c11770c != null) {
                if (Float.isNaN(f16)) {
                    f16 = 1.0f;
                }
                dMo70117a = (((float) c11770c.mo70117a((f15 - f13) / r16)) * (f16 - f13)) + f13;
            } else {
                dMo70117a = d12;
            }
            this.f58842k[0].mo70098d(dMo70117a, this.f58850s);
            AbstractC11769b abstractC11769b = this.f58843l;
            if (abstractC11769b != null) {
                double[] dArr = this.f58850s;
                if (dArr.length > 0) {
                    abstractC11769b.mo70098d(dMo70117a, dArr);
                }
            }
            int i12 = i11 * 2;
            int i13 = i11;
            this.f58838g.m77523i(dMo70117a, this.f58849r, this.f58850s, fArr, i12);
            if (abstractC12656c != null) {
                fArr[i12] = fArr[i12] + abstractC12656c.m70123a(f15);
            } else if (abstractC12657d != null) {
                fArr[i12] = fArr[i12] + abstractC12657d.m70149a(f15);
            }
            if (abstractC12656c2 != null) {
                int i14 = i12 + 1;
                fArr[i14] = fArr[i14] + abstractC12656c2.m70123a(f15);
            } else if (abstractC12657d2 != null) {
                int i15 = i12 + 1;
                fArr[i15] = fArr[i15] + abstractC12657d2.m70149a(f15);
            }
            i11 = i13 + 1;
            f10 = 1.0f;
        }
    }

    /* renamed from: e */
    public void m77495e(float f10, float[] fArr, int i10) {
        this.f58842k[0].mo70098d(m77497g(f10, null), this.f58850s);
        this.f58838g.m77527r(this.f58849r, this.f58850s, fArr, i10);
    }

    /* renamed from: f */
    public void m77496f(boolean z10) {
        if (!"button".equals(C12896a.m77318d(this.f58833b)) || this.f58824E == null) {
            return;
        }
        int i10 = 0;
        while (true) {
            C12906k[] c12906kArr = this.f58824E;
            if (i10 >= c12906kArr.length) {
                return;
            }
            c12906kArr[i10].m77467y(z10 ? -100.0f : 100.0f, this.f58833b);
            i10++;
        }
    }

    /* renamed from: g */
    public final float m77497g(float f10, float[] fArr) {
        float f11 = 0.0f;
        if (fArr != null) {
            fArr[0] = 1.0f;
        } else {
            float f12 = this.f58846o;
            if (f12 != 1.0d) {
                float f13 = this.f58845n;
                if (f10 < f13) {
                    f10 = 0.0f;
                }
                if (f10 > f13 && f10 < 1.0d) {
                    f10 = Math.min((f10 - f13) * f12, 1.0f);
                }
            }
        }
        C11770c c11770c = this.f58838g.f58860a;
        Iterator<C12910o> it = this.f58856y.iterator();
        float f14 = Float.NaN;
        while (it.hasNext()) {
            C12910o next = it.next();
            C11770c c11770c2 = next.f58860a;
            if (c11770c2 != null) {
                float f15 = next.f58862c;
                if (f15 < f10) {
                    c11770c = c11770c2;
                    f11 = f15;
                } else if (Float.isNaN(f14)) {
                    f14 = next.f58862c;
                }
            }
        }
        if (c11770c == null) {
            return f10;
        }
        float f16 = (Float.isNaN(f14) ? 1.0f : f14) - f11;
        double d10 = (f10 - f11) / f16;
        float fMo70117a = f11 + (((float) c11770c.mo70117a(d10)) * f16);
        if (fArr != null) {
            fArr[0] = (float) c11770c.mo70118b(d10);
        }
        return fMo70117a;
    }

    /* renamed from: h */
    public int m77498h() {
        return this.f58838g.f58871l;
    }

    /* renamed from: i */
    public void m77499i(double d10, float[] fArr, float[] fArr2) {
        double[] dArr = new double[4];
        double[] dArr2 = new double[4];
        this.f58842k[0].mo70098d(d10, dArr);
        this.f58842k[0].mo70101g(d10, dArr2);
        Arrays.fill(fArr2, 0.0f);
        this.f58838g.m77524k(d10, this.f58849r, dArr, fArr, dArr2, fArr2);
    }

    /* renamed from: j */
    public float m77500j() {
        return this.f58847p;
    }

    /* renamed from: k */
    public float m77501k() {
        return this.f58848q;
    }

    /* renamed from: l */
    public void m77502l(float f10, float f11, float f12, float[] fArr) {
        double[] dArr;
        float fM77497g = m77497g(f10, this.f58857z);
        AbstractC11769b[] abstractC11769bArr = this.f58842k;
        int i10 = 0;
        if (abstractC11769bArr == null) {
            C12910o c12910o = this.f58839h;
            float f13 = c12910o.f58864e;
            C12910o c12910o2 = this.f58838g;
            float f14 = f13 - c12910o2.f58864e;
            float f15 = c12910o.f58865f - c12910o2.f58865f;
            float f16 = (c12910o.f58866g - c12910o2.f58866g) + f14;
            float f17 = (c12910o.f58867h - c12910o2.f58867h) + f15;
            fArr[0] = (f14 * (1.0f - f11)) + (f16 * f11);
            fArr[1] = (f15 * (1.0f - f12)) + (f17 * f12);
            return;
        }
        double d10 = fM77497g;
        abstractC11769bArr[0].mo70101g(d10, this.f58851t);
        this.f58842k[0].mo70098d(d10, this.f58850s);
        float f18 = this.f58857z[0];
        while (true) {
            dArr = this.f58851t;
            if (i10 >= dArr.length) {
                break;
            }
            dArr[i10] = dArr[i10] * f18;
            i10++;
        }
        AbstractC11769b abstractC11769b = this.f58843l;
        if (abstractC11769b == null) {
            this.f58838g.m77535z(f11, f12, fArr, this.f58849r, dArr, this.f58850s);
            return;
        }
        double[] dArr2 = this.f58850s;
        if (dArr2.length > 0) {
            abstractC11769b.mo70098d(d10, dArr2);
            this.f58843l.mo70101g(d10, this.f58851t);
            this.f58838g.m77535z(f11, f12, fArr, this.f58849r, this.f58851t, this.f58850s);
        }
    }

    /* renamed from: m */
    public int m77503m() {
        int iMax = this.f58838g.f58861b;
        Iterator<C12910o> it = this.f58856y.iterator();
        while (it.hasNext()) {
            iMax = Math.max(iMax, it.next().f58861b);
        }
        return Math.max(iMax, this.f58839h.f58861b);
    }

    /* renamed from: n */
    public float m77504n() {
        return this.f58839h.f58864e;
    }

    /* renamed from: o */
    public float m77505o() {
        return this.f58839h.f58865f;
    }

    /* renamed from: q */
    public C12910o m77506q(int i10) {
        return this.f58856y.get(i10);
    }

    /* renamed from: r */
    public void m77507r(float f10, int i10, int i11, float f11, float f12, float[] fArr) {
        float fM77497g = m77497g(f10, this.f58857z);
        HashMap<String, AbstractC12657d> map = this.f58822C;
        AbstractC12657d abstractC12657d = map == null ? null : map.get("translationX");
        HashMap<String, AbstractC12657d> map2 = this.f58822C;
        AbstractC12657d abstractC12657d2 = map2 == null ? null : map2.get("translationY");
        HashMap<String, AbstractC12657d> map3 = this.f58822C;
        AbstractC12657d abstractC12657d3 = map3 == null ? null : map3.get("rotation");
        HashMap<String, AbstractC12657d> map4 = this.f58822C;
        AbstractC12657d abstractC12657d4 = map4 == null ? null : map4.get(TopAnimatorConfig.AnimatorType.SCALE_X);
        HashMap<String, AbstractC12657d> map5 = this.f58822C;
        AbstractC12657d abstractC12657d5 = map5 == null ? null : map5.get(TopAnimatorConfig.AnimatorType.SCALE_Y);
        HashMap<String, AbstractC12656c> map6 = this.f58823D;
        AbstractC12656c abstractC12656c = map6 == null ? null : map6.get("translationX");
        HashMap<String, AbstractC12656c> map7 = this.f58823D;
        AbstractC12656c abstractC12656c2 = map7 == null ? null : map7.get("translationY");
        HashMap<String, AbstractC12656c> map8 = this.f58823D;
        AbstractC12656c abstractC12656c3 = map8 == null ? null : map8.get("rotation");
        HashMap<String, AbstractC12656c> map9 = this.f58823D;
        AbstractC12656c abstractC12656c4 = map9 == null ? null : map9.get(TopAnimatorConfig.AnimatorType.SCALE_X);
        HashMap<String, AbstractC12656c> map10 = this.f58823D;
        AbstractC12656c abstractC12656c5 = map10 != null ? map10.get(TopAnimatorConfig.AnimatorType.SCALE_Y) : null;
        C11783p c11783p = new C11783p();
        c11783p.m70175b();
        c11783p.m70177d(abstractC12657d3, fM77497g);
        c11783p.m70181h(abstractC12657d, abstractC12657d2, fM77497g);
        c11783p.m70179f(abstractC12657d4, abstractC12657d5, fM77497g);
        c11783p.m70176c(abstractC12656c3, fM77497g);
        c11783p.m70180g(abstractC12656c, abstractC12656c2, fM77497g);
        c11783p.m70178e(abstractC12656c4, abstractC12656c5, fM77497g);
        AbstractC11769b abstractC11769b = this.f58843l;
        if (abstractC11769b != null) {
            double[] dArr = this.f58850s;
            if (dArr.length > 0) {
                double d10 = fM77497g;
                abstractC11769b.mo70098d(d10, dArr);
                this.f58843l.mo70101g(d10, this.f58851t);
                this.f58838g.m77535z(f11, f12, fArr, this.f58849r, this.f58851t, this.f58850s);
            }
            c11783p.m70174a(f11, f12, i10, i11, fArr);
            return;
        }
        int i12 = 0;
        if (this.f58842k == null) {
            C12910o c12910o = this.f58839h;
            float f13 = c12910o.f58864e;
            C12910o c12910o2 = this.f58838g;
            float f14 = f13 - c12910o2.f58864e;
            AbstractC12656c abstractC12656c6 = abstractC12656c5;
            float f15 = c12910o.f58865f - c12910o2.f58865f;
            AbstractC12656c abstractC12656c7 = abstractC12656c4;
            float f16 = (c12910o.f58866g - c12910o2.f58866g) + f14;
            float f17 = (c12910o.f58867h - c12910o2.f58867h) + f15;
            fArr[0] = (f14 * (1.0f - f11)) + (f16 * f11);
            fArr[1] = (f15 * (1.0f - f12)) + (f17 * f12);
            c11783p.m70175b();
            c11783p.m70177d(abstractC12657d3, fM77497g);
            c11783p.m70181h(abstractC12657d, abstractC12657d2, fM77497g);
            c11783p.m70179f(abstractC12657d4, abstractC12657d5, fM77497g);
            c11783p.m70176c(abstractC12656c3, fM77497g);
            c11783p.m70180g(abstractC12656c, abstractC12656c2, fM77497g);
            c11783p.m70178e(abstractC12656c7, abstractC12656c6, fM77497g);
            c11783p.m70174a(f11, f12, i10, i11, fArr);
            return;
        }
        double dM77497g = m77497g(fM77497g, this.f58857z);
        this.f58842k[0].mo70101g(dM77497g, this.f58851t);
        this.f58842k[0].mo70098d(dM77497g, this.f58850s);
        float f18 = this.f58857z[0];
        while (true) {
            double[] dArr2 = this.f58851t;
            if (i12 >= dArr2.length) {
                this.f58838g.m77535z(f11, f12, fArr, this.f58849r, dArr2, this.f58850s);
                c11783p.m70174a(f11, f12, i10, i11, fArr);
                return;
            } else {
                dArr2[i12] = dArr2[i12] * f18;
                i12++;
            }
        }
    }

    /* renamed from: s */
    public final float m77508s() {
        char c10;
        float[] fArr = new float[2];
        float f10 = 1.0f / 99;
        double d10 = 0.0d;
        double d11 = 0.0d;
        int i10 = 0;
        float fHypot = 0.0f;
        while (i10 < 100) {
            float f11 = i10 * f10;
            double dMo70117a = f11;
            C11770c c11770c = this.f58838g.f58860a;
            Iterator<C12910o> it = this.f58856y.iterator();
            float f12 = Float.NaN;
            float f13 = 0.0f;
            while (it.hasNext()) {
                C12910o next = it.next();
                C11770c c11770c2 = next.f58860a;
                if (c11770c2 != null) {
                    float f14 = next.f58862c;
                    if (f14 < f11) {
                        c11770c = c11770c2;
                        f13 = f14;
                    } else if (Float.isNaN(f12)) {
                        f12 = next.f58862c;
                    }
                }
            }
            if (c11770c != null) {
                if (Float.isNaN(f12)) {
                    f12 = 1.0f;
                }
                dMo70117a = (((float) c11770c.mo70117a((f11 - f13) / r7)) * (f12 - f13)) + f13;
            }
            this.f58842k[0].mo70098d(dMo70117a, this.f58850s);
            int i11 = i10;
            this.f58838g.m77523i(dMo70117a, this.f58849r, this.f58850s, fArr, 0);
            if (i11 > 0) {
                c10 = 0;
                fHypot += (float) Math.hypot(d11 - fArr[1], d10 - fArr[0]);
            } else {
                c10 = 0;
            }
            d10 = fArr[c10];
            i10 = i11 + 1;
            d11 = fArr[1];
        }
        return fHypot;
    }

    /* renamed from: t */
    public float m77509t() {
        return this.f58838g.f58864e;
    }

    public String toString() {
        return " start: x: " + this.f58838g.f58864e + " y: " + this.f58838g.f58865f + " end: x: " + this.f58839h.f58864e + " y: " + this.f58839h.f58865f;
    }

    /* renamed from: u */
    public float m77510u() {
        return this.f58838g.f58865f;
    }

    /* renamed from: v */
    public View m77511v() {
        return this.f58833b;
    }

    /* renamed from: w */
    public final void m77512w(C12910o c12910o) {
        if (Collections.binarySearch(this.f58856y, c12910o) == 0) {
            Log.e("MotionController", " KeyPath position \"" + c12910o.f58863d + "\" outside of range");
        }
        this.f58856y.add((-r0) - 1, c12910o);
    }

    /* renamed from: x */
    public boolean m77513x(View view, float f10, long j10, C11771d c11771d) {
        AbstractC12659f.d dVar;
        boolean zM76203j;
        int i10;
        double d10;
        float fM77497g = m77497g(f10, null);
        int i11 = this.f58828I;
        if (i11 != AbstractC12899d.f58688f) {
            float f11 = 1.0f / i11;
            float fFloor = ((float) Math.floor(fM77497g / f11)) * f11;
            float f12 = (fM77497g % f11) / f11;
            if (!Float.isNaN(this.f58829J)) {
                f12 = (f12 + this.f58829J) % 1.0f;
            }
            Interpolator interpolator = this.f58830K;
            fM77497g = ((interpolator != null ? interpolator.getInterpolation(f12) : ((double) f12) > 0.5d ? 1.0f : 0.0f) * f11) + fFloor;
        }
        float f13 = fM77497g;
        HashMap<String, AbstractC12657d> map = this.f58822C;
        if (map != null) {
            Iterator<AbstractC12657d> it = map.values().iterator();
            while (it.hasNext()) {
                it.next().mo76193h(view, f13);
            }
        }
        HashMap<String, AbstractC12659f> map2 = this.f58821B;
        if (map2 != null) {
            AbstractC12659f.d dVar2 = null;
            boolean zMo76201i = false;
            for (AbstractC12659f abstractC12659f : map2.values()) {
                if (abstractC12659f instanceof AbstractC12659f.d) {
                    dVar2 = (AbstractC12659f.d) abstractC12659f;
                } else {
                    zMo76201i |= abstractC12659f.mo76201i(view, f13, j10, c11771d);
                }
            }
            zM76203j = zMo76201i;
            dVar = dVar2;
        } else {
            dVar = null;
            zM76203j = false;
        }
        AbstractC11769b[] abstractC11769bArr = this.f58842k;
        if (abstractC11769bArr != null) {
            double d11 = f13;
            abstractC11769bArr[0].mo70098d(d11, this.f58850s);
            this.f58842k[0].mo70101g(d11, this.f58851t);
            AbstractC11769b abstractC11769b = this.f58843l;
            if (abstractC11769b != null) {
                double[] dArr = this.f58850s;
                if (dArr.length > 0) {
                    abstractC11769b.mo70098d(d11, dArr);
                    this.f58843l.mo70101g(d11, this.f58851t);
                }
            }
            if (this.f58831L) {
                d10 = d11;
            } else {
                d10 = d11;
                this.f58838g.m77516A(f13, view, this.f58849r, this.f58850s, this.f58851t, null, this.f58835d);
                this.f58835d = false;
            }
            if (this.f58826G != AbstractC12899d.f58688f) {
                if (this.f58827H == null) {
                    this.f58827H = ((View) view.getParent()).findViewById(this.f58826G);
                }
                if (this.f58827H != null) {
                    float top = (r1.getTop() + this.f58827H.getBottom()) / 2.0f;
                    float left = (this.f58827H.getLeft() + this.f58827H.getRight()) / 2.0f;
                    if (view.getRight() - view.getLeft() > 0 && view.getBottom() - view.getTop() > 0) {
                        view.setPivotX(left - view.getLeft());
                        view.setPivotY(top - view.getTop());
                    }
                }
            }
            HashMap<String, AbstractC12657d> map3 = this.f58822C;
            if (map3 != null) {
                for (AbstractC12657d abstractC12657d : map3.values()) {
                    if (abstractC12657d instanceof AbstractC12657d.d) {
                        double[] dArr2 = this.f58851t;
                        if (dArr2.length > 1) {
                            ((AbstractC12657d.d) abstractC12657d).m76195i(view, f13, dArr2[0], dArr2[1]);
                        }
                    }
                }
            }
            if (dVar != null) {
                double[] dArr3 = this.f58851t;
                i10 = 1;
                zM76203j |= dVar.m76203j(view, c11771d, f13, j10, dArr3[0], dArr3[1]);
            } else {
                i10 = 1;
            }
            int i12 = i10;
            while (true) {
                AbstractC11769b[] abstractC11769bArr2 = this.f58842k;
                if (i12 >= abstractC11769bArr2.length) {
                    break;
                }
                abstractC11769bArr2[i12].mo70099e(d10, this.f58855x);
                C12654a.m76184b(this.f58838g.f58874o.get(this.f58852u[i12 - 1]), view, this.f58855x);
                i12++;
            }
            C12907l c12907l = this.f58840i;
            if (c12907l.f58795b == 0) {
                if (f13 <= 0.0f) {
                    view.setVisibility(c12907l.f58796c);
                } else if (f13 >= 1.0f) {
                    view.setVisibility(this.f58841j.f58796c);
                } else if (this.f58841j.f58796c != c12907l.f58796c) {
                    view.setVisibility(0);
                }
            }
            if (this.f58824E != null) {
                int i13 = 0;
                while (true) {
                    C12906k[] c12906kArr = this.f58824E;
                    if (i13 >= c12906kArr.length) {
                        break;
                    }
                    c12906kArr[i13].m77467y(f13, view);
                    i13++;
                }
            }
        } else {
            i10 = 1;
            C12910o c12910o = this.f58838g;
            float f14 = c12910o.f58864e;
            C12910o c12910o2 = this.f58839h;
            float f15 = f14 + ((c12910o2.f58864e - f14) * f13);
            float f16 = c12910o.f58865f;
            float f17 = f16 + ((c12910o2.f58865f - f16) * f13);
            float f18 = c12910o.f58866g;
            float f19 = c12910o2.f58866g;
            float f20 = c12910o.f58867h;
            float f21 = c12910o2.f58867h;
            float f22 = f15 + 0.5f;
            int i14 = (int) f22;
            float f23 = f17 + 0.5f;
            int i15 = (int) f23;
            int i16 = (int) (f22 + ((f19 - f18) * f13) + f18);
            int i17 = (int) (f23 + ((f21 - f20) * f13) + f20);
            int i18 = i16 - i14;
            int i19 = i17 - i15;
            if (f19 != f18 || f21 != f20 || this.f58835d) {
                view.measure(View.MeasureSpec.makeMeasureSpec(i18, 1073741824), View.MeasureSpec.makeMeasureSpec(i19, 1073741824));
                this.f58835d = false;
            }
            view.layout(i14, i15, i16, i17);
        }
        HashMap<String, AbstractC12656c> map4 = this.f58823D;
        if (map4 != null) {
            for (AbstractC12656c abstractC12656c : map4.values()) {
                if (abstractC12656c instanceof AbstractC12656c.d) {
                    double[] dArr4 = this.f58851t;
                    ((AbstractC12656c.d) abstractC12656c).m76190k(view, f13, dArr4[0], dArr4[i10]);
                } else {
                    abstractC12656c.mo76189j(view, f13);
                }
            }
        }
        return zM76203j;
    }

    /* renamed from: y */
    public final void m77514y(C12910o c12910o) {
        c12910o.m77534y((int) this.f58833b.getX(), (int) this.f58833b.getY(), this.f58833b.getWidth(), this.f58833b.getHeight());
    }

    /* renamed from: z */
    public void m77515z() {
        this.f58835d = true;
    }
}
