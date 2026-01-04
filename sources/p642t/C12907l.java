package p642t;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.widget.C0583a;
import androidx.constraintlayout.widget.C0585c;
import com.huawei.android.remotecontrol.p093ui.widget.TopAnimatorConfig;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import p504o.C11770c;
import p627s.AbstractC12657d;

/* renamed from: t.l */
/* loaded from: classes.dex */
public class C12907l implements Comparable<C12907l> {

    /* renamed from: D */
    public static String[] f58790D = {"position", Constants.MULTIPLE_SIGN, "y", "width", "height", "pathRotate"};

    /* renamed from: c */
    public int f58796c;

    /* renamed from: t */
    public C11770c f58813t;

    /* renamed from: v */
    public float f58815v;

    /* renamed from: w */
    public float f58816w;

    /* renamed from: x */
    public float f58817x;

    /* renamed from: y */
    public float f58818y;

    /* renamed from: z */
    public float f58819z;

    /* renamed from: a */
    public float f58794a = 0.0f;

    /* renamed from: b */
    public int f58795b = 0;

    /* renamed from: d */
    public LinkedHashMap<String, C0583a> f58797d = new LinkedHashMap<>();

    /* renamed from: e */
    public int f58798e = 0;

    /* renamed from: f */
    public double[] f58799f = new double[18];

    /* renamed from: g */
    public double[] f58800g = new double[18];

    /* renamed from: h */
    public float f58801h = 1.0f;

    /* renamed from: i */
    public boolean f58802i = false;

    /* renamed from: j */
    public float f58803j = 0.0f;

    /* renamed from: k */
    public float f58804k = 0.0f;

    /* renamed from: l */
    public float f58805l = 0.0f;

    /* renamed from: m */
    public float f58806m = 1.0f;

    /* renamed from: n */
    public float f58807n = 1.0f;

    /* renamed from: o */
    public float f58808o = Float.NaN;

    /* renamed from: p */
    public float f58809p = Float.NaN;

    /* renamed from: q */
    public float f58810q = 0.0f;

    /* renamed from: r */
    public float f58811r = 0.0f;

    /* renamed from: s */
    public float f58812s = 0.0f;

    /* renamed from: u */
    public int f58814u = 0;

    /* renamed from: A */
    public float f58791A = Float.NaN;

    /* renamed from: B */
    public float f58792B = Float.NaN;

    /* renamed from: C */
    public int f58793C = -1;

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* renamed from: a */
    public void m77470a(HashMap<String, AbstractC12657d> map, int i10) {
        for (String str : map.keySet()) {
            AbstractC12657d abstractC12657d = map.get(str);
            if (abstractC12657d != null) {
                str.hashCode();
                char c10 = 65535;
                switch (str.hashCode()) {
                    case -1249320806:
                        if (str.equals("rotationX")) {
                            c10 = 0;
                            break;
                        }
                        break;
                    case -1249320805:
                        if (str.equals("rotationY")) {
                            c10 = 1;
                            break;
                        }
                        break;
                    case -1225497657:
                        if (str.equals("translationX")) {
                            c10 = 2;
                            break;
                        }
                        break;
                    case -1225497656:
                        if (str.equals("translationY")) {
                            c10 = 3;
                            break;
                        }
                        break;
                    case -1225497655:
                        if (str.equals("translationZ")) {
                            c10 = 4;
                            break;
                        }
                        break;
                    case -1001078227:
                        if (str.equals(VastAttribute.PROGRESS)) {
                            c10 = 5;
                            break;
                        }
                        break;
                    case -908189618:
                        if (str.equals(TopAnimatorConfig.AnimatorType.SCALE_X)) {
                            c10 = 6;
                            break;
                        }
                        break;
                    case -908189617:
                        if (str.equals(TopAnimatorConfig.AnimatorType.SCALE_Y)) {
                            c10 = 7;
                            break;
                        }
                        break;
                    case -760884510:
                        if (str.equals("transformPivotX")) {
                            c10 = '\b';
                            break;
                        }
                        break;
                    case -760884509:
                        if (str.equals("transformPivotY")) {
                            c10 = '\t';
                            break;
                        }
                        break;
                    case -40300674:
                        if (str.equals("rotation")) {
                            c10 = '\n';
                            break;
                        }
                        break;
                    case -4379043:
                        if (str.equals("elevation")) {
                            c10 = 11;
                            break;
                        }
                        break;
                    case 37232917:
                        if (str.equals("transitionPathRotate")) {
                            c10 = '\f';
                            break;
                        }
                        break;
                    case 92909918:
                        if (str.equals(TopAnimatorConfig.AnimatorType.ALPHA)) {
                            c10 = '\r';
                            break;
                        }
                        break;
                }
                switch (c10) {
                    case 0:
                        abstractC12657d.mo70151c(i10, Float.isNaN(this.f58805l) ? 0.0f : this.f58805l);
                        break;
                    case 1:
                        abstractC12657d.mo70151c(i10, Float.isNaN(this.f58794a) ? 0.0f : this.f58794a);
                        break;
                    case 2:
                        abstractC12657d.mo70151c(i10, Float.isNaN(this.f58810q) ? 0.0f : this.f58810q);
                        break;
                    case 3:
                        abstractC12657d.mo70151c(i10, Float.isNaN(this.f58811r) ? 0.0f : this.f58811r);
                        break;
                    case 4:
                        abstractC12657d.mo70151c(i10, Float.isNaN(this.f58812s) ? 0.0f : this.f58812s);
                        break;
                    case 5:
                        abstractC12657d.mo70151c(i10, Float.isNaN(this.f58792B) ? 0.0f : this.f58792B);
                        break;
                    case 6:
                        abstractC12657d.mo70151c(i10, Float.isNaN(this.f58806m) ? 1.0f : this.f58806m);
                        break;
                    case 7:
                        abstractC12657d.mo70151c(i10, Float.isNaN(this.f58807n) ? 1.0f : this.f58807n);
                        break;
                    case '\b':
                        abstractC12657d.mo70151c(i10, Float.isNaN(this.f58808o) ? 0.0f : this.f58808o);
                        break;
                    case '\t':
                        abstractC12657d.mo70151c(i10, Float.isNaN(this.f58809p) ? 0.0f : this.f58809p);
                        break;
                    case '\n':
                        abstractC12657d.mo70151c(i10, Float.isNaN(this.f58804k) ? 0.0f : this.f58804k);
                        break;
                    case 11:
                        abstractC12657d.mo70151c(i10, Float.isNaN(this.f58803j) ? 0.0f : this.f58803j);
                        break;
                    case '\f':
                        abstractC12657d.mo70151c(i10, Float.isNaN(this.f58791A) ? 0.0f : this.f58791A);
                        break;
                    case '\r':
                        abstractC12657d.mo70151c(i10, Float.isNaN(this.f58801h) ? 1.0f : this.f58801h);
                        break;
                    default:
                        if (str.startsWith("CUSTOM")) {
                            String str2 = str.split(",")[1];
                            if (this.f58797d.containsKey(str2)) {
                                C0583a c0583a = this.f58797d.get(str2);
                                if (abstractC12657d instanceof AbstractC12657d.b) {
                                    ((AbstractC12657d.b) abstractC12657d).m76194i(i10, c0583a);
                                    break;
                                } else {
                                    Log.e("MotionPaths", str + " ViewSpline not a CustomSet frame = " + i10 + ", value" + c0583a.m3589e() + abstractC12657d);
                                    break;
                                }
                            } else {
                                break;
                            }
                        } else {
                            Log.e("MotionPaths", "UNKNOWN spline " + str);
                            break;
                        }
                }
            }
        }
    }

    /* renamed from: b */
    public void m77471b(View view) {
        this.f58796c = view.getVisibility();
        this.f58801h = view.getVisibility() != 0 ? 0.0f : view.getAlpha();
        this.f58802i = false;
        this.f58803j = view.getElevation();
        this.f58804k = view.getRotation();
        this.f58805l = view.getRotationX();
        this.f58794a = view.getRotationY();
        this.f58806m = view.getScaleX();
        this.f58807n = view.getScaleY();
        this.f58808o = view.getPivotX();
        this.f58809p = view.getPivotY();
        this.f58810q = view.getTranslationX();
        this.f58811r = view.getTranslationY();
        this.f58812s = view.getTranslationZ();
    }

    /* renamed from: e */
    public void m77472e(C0585c.a aVar) {
        C0585c.d dVar = aVar.f3107c;
        int i10 = dVar.f3212c;
        this.f58795b = i10;
        int i11 = dVar.f3211b;
        this.f58796c = i11;
        this.f58801h = (i11 == 0 || i10 != 0) ? dVar.f3213d : 0.0f;
        C0585c.e eVar = aVar.f3110f;
        this.f58802i = eVar.f3228m;
        this.f58803j = eVar.f3229n;
        this.f58804k = eVar.f3217b;
        this.f58805l = eVar.f3218c;
        this.f58794a = eVar.f3219d;
        this.f58806m = eVar.f3220e;
        this.f58807n = eVar.f3221f;
        this.f58808o = eVar.f3222g;
        this.f58809p = eVar.f3223h;
        this.f58810q = eVar.f3225j;
        this.f58811r = eVar.f3226k;
        this.f58812s = eVar.f3227l;
        this.f58813t = C11770c.m70116c(aVar.f3108d.f3199d);
        C0585c.c cVar = aVar.f3108d;
        this.f58791A = cVar.f3204i;
        this.f58814u = cVar.f3201f;
        this.f58793C = cVar.f3197b;
        this.f58792B = aVar.f3107c.f3214e;
        for (String str : aVar.f3111g.keySet()) {
            C0583a c0583a = aVar.f3111g.get(str);
            if (c0583a.m3591g()) {
                this.f58797d.put(str, c0583a);
            }
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public int compareTo(C12907l c12907l) {
        return Float.compare(this.f58815v, c12907l.f58815v);
    }

    /* renamed from: h */
    public final boolean m77474h(float f10, float f11) {
        return (Float.isNaN(f10) || Float.isNaN(f11)) ? Float.isNaN(f10) != Float.isNaN(f11) : Math.abs(f10 - f11) > 1.0E-6f;
    }

    /* renamed from: i */
    public void m77475i(C12907l c12907l, HashSet<String> hashSet) {
        if (m77474h(this.f58801h, c12907l.f58801h)) {
            hashSet.add(TopAnimatorConfig.AnimatorType.ALPHA);
        }
        if (m77474h(this.f58803j, c12907l.f58803j)) {
            hashSet.add("elevation");
        }
        int i10 = this.f58796c;
        int i11 = c12907l.f58796c;
        if (i10 != i11 && this.f58795b == 0 && (i10 == 0 || i11 == 0)) {
            hashSet.add(TopAnimatorConfig.AnimatorType.ALPHA);
        }
        if (m77474h(this.f58804k, c12907l.f58804k)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.f58791A) || !Float.isNaN(c12907l.f58791A)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.f58792B) || !Float.isNaN(c12907l.f58792B)) {
            hashSet.add(VastAttribute.PROGRESS);
        }
        if (m77474h(this.f58805l, c12907l.f58805l)) {
            hashSet.add("rotationX");
        }
        if (m77474h(this.f58794a, c12907l.f58794a)) {
            hashSet.add("rotationY");
        }
        if (m77474h(this.f58808o, c12907l.f58808o)) {
            hashSet.add("transformPivotX");
        }
        if (m77474h(this.f58809p, c12907l.f58809p)) {
            hashSet.add("transformPivotY");
        }
        if (m77474h(this.f58806m, c12907l.f58806m)) {
            hashSet.add(TopAnimatorConfig.AnimatorType.SCALE_X);
        }
        if (m77474h(this.f58807n, c12907l.f58807n)) {
            hashSet.add(TopAnimatorConfig.AnimatorType.SCALE_Y);
        }
        if (m77474h(this.f58810q, c12907l.f58810q)) {
            hashSet.add("translationX");
        }
        if (m77474h(this.f58811r, c12907l.f58811r)) {
            hashSet.add("translationY");
        }
        if (m77474h(this.f58812s, c12907l.f58812s)) {
            hashSet.add("translationZ");
        }
    }

    /* renamed from: k */
    public void m77476k(float f10, float f11, float f12, float f13) {
        this.f58816w = f10;
        this.f58817x = f11;
        this.f58818y = f12;
        this.f58819z = f13;
    }

    /* renamed from: p */
    public void m77477p(Rect rect, View view, int i10, float f10) {
        m77476k(rect.left, rect.top, rect.width(), rect.height());
        m77471b(view);
        this.f58808o = Float.NaN;
        this.f58809p = Float.NaN;
        if (i10 == 1) {
            this.f58804k = f10 - 90.0f;
        } else {
            if (i10 != 2) {
                return;
            }
            this.f58804k = f10 + 90.0f;
        }
    }

    /* renamed from: q */
    public void m77478q(Rect rect, C0585c c0585c, int i10, int i11) {
        m77476k(rect.left, rect.top, rect.width(), rect.height());
        m77472e(c0585c.m3647z(i11));
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    if (i10 != 4) {
                        return;
                    }
                }
            }
            float f10 = this.f58804k + 90.0f;
            this.f58804k = f10;
            if (f10 > 180.0f) {
                this.f58804k = f10 - 360.0f;
                return;
            }
            return;
        }
        this.f58804k -= 90.0f;
    }

    /* renamed from: r */
    public void m77479r(View view) {
        m77476k(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        m77471b(view);
    }
}
