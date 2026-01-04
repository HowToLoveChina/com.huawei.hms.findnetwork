package p642t;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.C0583a;
import androidx.constraintlayout.widget.R$styleable;
import com.huawei.android.remotecontrol.p093ui.widget.TopAnimatorConfig;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import p627s.AbstractC12656c;
import p627s.AbstractC12657d;

/* renamed from: t.f */
/* loaded from: classes.dex */
public class C12901f extends AbstractC12899d {

    /* renamed from: g */
    public String f58712g = null;

    /* renamed from: h */
    public int f58713h = 0;

    /* renamed from: i */
    public int f58714i = -1;

    /* renamed from: j */
    public String f58715j = null;

    /* renamed from: k */
    public float f58716k = Float.NaN;

    /* renamed from: l */
    public float f58717l = 0.0f;

    /* renamed from: m */
    public float f58718m = 0.0f;

    /* renamed from: n */
    public float f58719n = Float.NaN;

    /* renamed from: o */
    public int f58720o = -1;

    /* renamed from: p */
    public float f58721p = Float.NaN;

    /* renamed from: q */
    public float f58722q = Float.NaN;

    /* renamed from: r */
    public float f58723r = Float.NaN;

    /* renamed from: s */
    public float f58724s = Float.NaN;

    /* renamed from: t */
    public float f58725t = Float.NaN;

    /* renamed from: u */
    public float f58726u = Float.NaN;

    /* renamed from: v */
    public float f58727v = Float.NaN;

    /* renamed from: w */
    public float f58728w = Float.NaN;

    /* renamed from: x */
    public float f58729x = Float.NaN;

    /* renamed from: y */
    public float f58730y = Float.NaN;

    /* renamed from: z */
    public float f58731z = Float.NaN;

    /* renamed from: t.f$a */
    public static class a {

        /* renamed from: a */
        public static SparseIntArray f58732a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f58732a = sparseIntArray;
            sparseIntArray.append(R$styleable.KeyCycle_motionTarget, 1);
            f58732a.append(R$styleable.KeyCycle_framePosition, 2);
            f58732a.append(R$styleable.KeyCycle_transitionEasing, 3);
            f58732a.append(R$styleable.KeyCycle_curveFit, 4);
            f58732a.append(R$styleable.KeyCycle_waveShape, 5);
            f58732a.append(R$styleable.KeyCycle_wavePeriod, 6);
            f58732a.append(R$styleable.KeyCycle_waveOffset, 7);
            f58732a.append(R$styleable.KeyCycle_waveVariesBy, 8);
            f58732a.append(R$styleable.KeyCycle_android_alpha, 9);
            f58732a.append(R$styleable.KeyCycle_android_elevation, 10);
            f58732a.append(R$styleable.KeyCycle_android_rotation, 11);
            f58732a.append(R$styleable.KeyCycle_android_rotationX, 12);
            f58732a.append(R$styleable.KeyCycle_android_rotationY, 13);
            f58732a.append(R$styleable.KeyCycle_transitionPathRotate, 14);
            f58732a.append(R$styleable.KeyCycle_android_scaleX, 15);
            f58732a.append(R$styleable.KeyCycle_android_scaleY, 16);
            f58732a.append(R$styleable.KeyCycle_android_translationX, 17);
            f58732a.append(R$styleable.KeyCycle_android_translationY, 18);
            f58732a.append(R$styleable.KeyCycle_android_translationZ, 19);
            f58732a.append(R$styleable.KeyCycle_motionProgress, 20);
            f58732a.append(R$styleable.KeyCycle_wavePhase, 21);
        }

        /* renamed from: b */
        public static void m77408b(C12901f c12901f, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArray.getIndex(i10);
                switch (f58732a.get(index)) {
                    case 1:
                        if (MotionLayout.f2560E0) {
                            int resourceId = typedArray.getResourceId(index, c12901f.f58690b);
                            c12901f.f58690b = resourceId;
                            if (resourceId == -1) {
                                c12901f.f58691c = typedArray.getString(index);
                                break;
                            } else {
                                break;
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            c12901f.f58691c = typedArray.getString(index);
                            break;
                        } else {
                            c12901f.f58690b = typedArray.getResourceId(index, c12901f.f58690b);
                            break;
                        }
                    case 2:
                        c12901f.f58689a = typedArray.getInt(index, c12901f.f58689a);
                        break;
                    case 3:
                        c12901f.f58712g = typedArray.getString(index);
                        break;
                    case 4:
                        c12901f.f58713h = typedArray.getInteger(index, c12901f.f58713h);
                        break;
                    case 5:
                        if (typedArray.peekValue(index).type == 3) {
                            c12901f.f58715j = typedArray.getString(index);
                            c12901f.f58714i = 7;
                            break;
                        } else {
                            c12901f.f58714i = typedArray.getInt(index, c12901f.f58714i);
                            break;
                        }
                    case 6:
                        c12901f.f58716k = typedArray.getFloat(index, c12901f.f58716k);
                        break;
                    case 7:
                        if (typedArray.peekValue(index).type == 5) {
                            c12901f.f58717l = typedArray.getDimension(index, c12901f.f58717l);
                            break;
                        } else {
                            c12901f.f58717l = typedArray.getFloat(index, c12901f.f58717l);
                            break;
                        }
                    case 8:
                        c12901f.f58720o = typedArray.getInt(index, c12901f.f58720o);
                        break;
                    case 9:
                        c12901f.f58721p = typedArray.getFloat(index, c12901f.f58721p);
                        break;
                    case 10:
                        c12901f.f58722q = typedArray.getDimension(index, c12901f.f58722q);
                        break;
                    case 11:
                        c12901f.f58723r = typedArray.getFloat(index, c12901f.f58723r);
                        break;
                    case 12:
                        c12901f.f58725t = typedArray.getFloat(index, c12901f.f58725t);
                        break;
                    case 13:
                        c12901f.f58726u = typedArray.getFloat(index, c12901f.f58726u);
                        break;
                    case 14:
                        c12901f.f58724s = typedArray.getFloat(index, c12901f.f58724s);
                        break;
                    case 15:
                        c12901f.f58727v = typedArray.getFloat(index, c12901f.f58727v);
                        break;
                    case 16:
                        c12901f.f58728w = typedArray.getFloat(index, c12901f.f58728w);
                        break;
                    case 17:
                        c12901f.f58729x = typedArray.getDimension(index, c12901f.f58729x);
                        break;
                    case 18:
                        c12901f.f58730y = typedArray.getDimension(index, c12901f.f58730y);
                        break;
                    case 19:
                        c12901f.f58731z = typedArray.getDimension(index, c12901f.f58731z);
                        break;
                    case 20:
                        c12901f.f58719n = typedArray.getFloat(index, c12901f.f58719n);
                        break;
                    case 21:
                        c12901f.f58718m = typedArray.getFloat(index, c12901f.f58718m) / 360.0f;
                        break;
                    default:
                        Log.e("KeyCycle", "unused attribute 0x" + Integer.toHexString(index) + "   " + f58732a.get(index));
                        break;
                }
            }
        }
    }

    public C12901f() {
        this.f58692d = 4;
        this.f58693e = new HashMap<>();
    }

    /* renamed from: Y */
    public void m77405Y(HashMap<String, AbstractC12656c> map) {
        AbstractC12656c abstractC12656c;
        AbstractC12656c abstractC12656c2;
        for (String str : map.keySet()) {
            if (str.startsWith("CUSTOM")) {
                C0583a c0583a = this.f58693e.get(str.substring(7));
                if (c0583a != null && c0583a.m3588d() == C0583a.a.FLOAT_TYPE && (abstractC12656c = map.get(str)) != null) {
                    abstractC12656c.m70127e(this.f58689a, this.f58714i, this.f58715j, this.f58720o, this.f58716k, this.f58717l, this.f58718m, c0583a.m3589e(), c0583a);
                }
            } else {
                float fM77406Z = m77406Z(str);
                if (!Float.isNaN(fM77406Z) && (abstractC12656c2 = map.get(str)) != null) {
                    abstractC12656c2.m70126d(this.f58689a, this.f58714i, this.f58715j, this.f58720o, this.f58716k, this.f58717l, this.f58718m, fM77406Z);
                }
            }
        }
    }

    /* renamed from: Z */
    public float m77406Z(String str) {
        str.hashCode();
        switch (str) {
            case "rotationX":
                return this.f58725t;
            case "rotationY":
                return this.f58726u;
            case "translationX":
                return this.f58729x;
            case "translationY":
                return this.f58730y;
            case "translationZ":
                return this.f58731z;
            case "progress":
                return this.f58719n;
            case "scaleX":
                return this.f58727v;
            case "scaleY":
                return this.f58728w;
            case "rotation":
                return this.f58723r;
            case "elevation":
                return this.f58722q;
            case "transitionPathRotate":
                return this.f58724s;
            case "alpha":
                return this.f58721p;
            case "waveOffset":
                return this.f58717l;
            case "wavePhase":
                return this.f58718m;
            default:
                if (str.startsWith("CUSTOM")) {
                    return Float.NaN;
                }
                Log.v("WARNING! KeyCycle", "  UNKNOWN  " + str);
                return Float.NaN;
        }
    }

    @Override // p642t.AbstractC12899d
    /* renamed from: a */
    public void mo77322a(HashMap<String, AbstractC12657d> map) {
        C12896a.m77321g("KeyCycle", "add " + map.size() + " values", 2);
        for (String str : map.keySet()) {
            AbstractC12657d abstractC12657d = map.get(str);
            if (abstractC12657d != null) {
                str.hashCode();
                switch (str) {
                    case "rotationX":
                        abstractC12657d.mo70151c(this.f58689a, this.f58725t);
                        break;
                    case "rotationY":
                        abstractC12657d.mo70151c(this.f58689a, this.f58726u);
                        break;
                    case "translationX":
                        abstractC12657d.mo70151c(this.f58689a, this.f58729x);
                        break;
                    case "translationY":
                        abstractC12657d.mo70151c(this.f58689a, this.f58730y);
                        break;
                    case "translationZ":
                        abstractC12657d.mo70151c(this.f58689a, this.f58731z);
                        break;
                    case "progress":
                        abstractC12657d.mo70151c(this.f58689a, this.f58719n);
                        break;
                    case "scaleX":
                        abstractC12657d.mo70151c(this.f58689a, this.f58727v);
                        break;
                    case "scaleY":
                        abstractC12657d.mo70151c(this.f58689a, this.f58728w);
                        break;
                    case "rotation":
                        abstractC12657d.mo70151c(this.f58689a, this.f58723r);
                        break;
                    case "elevation":
                        abstractC12657d.mo70151c(this.f58689a, this.f58722q);
                        break;
                    case "transitionPathRotate":
                        abstractC12657d.mo70151c(this.f58689a, this.f58724s);
                        break;
                    case "alpha":
                        abstractC12657d.mo70151c(this.f58689a, this.f58721p);
                        break;
                    case "waveOffset":
                        abstractC12657d.mo70151c(this.f58689a, this.f58717l);
                        break;
                    case "wavePhase":
                        abstractC12657d.mo70151c(this.f58689a, this.f58718m);
                        break;
                    default:
                        if (str.startsWith("CUSTOM")) {
                            break;
                        } else {
                            Log.v("WARNING KeyCycle", "  UNKNOWN  " + str);
                            break;
                        }
                }
            }
        }
    }

    @Override // p642t.AbstractC12899d
    /* renamed from: b */
    public AbstractC12899d clone() {
        return new C12901f().mo77324c(this);
    }

    @Override // p642t.AbstractC12899d
    /* renamed from: c */
    public AbstractC12899d mo77324c(AbstractC12899d abstractC12899d) {
        super.mo77324c(abstractC12899d);
        C12901f c12901f = (C12901f) abstractC12899d;
        this.f58712g = c12901f.f58712g;
        this.f58713h = c12901f.f58713h;
        this.f58714i = c12901f.f58714i;
        this.f58715j = c12901f.f58715j;
        this.f58716k = c12901f.f58716k;
        this.f58717l = c12901f.f58717l;
        this.f58718m = c12901f.f58718m;
        this.f58719n = c12901f.f58719n;
        this.f58720o = c12901f.f58720o;
        this.f58721p = c12901f.f58721p;
        this.f58722q = c12901f.f58722q;
        this.f58723r = c12901f.f58723r;
        this.f58724s = c12901f.f58724s;
        this.f58725t = c12901f.f58725t;
        this.f58726u = c12901f.f58726u;
        this.f58727v = c12901f.f58727v;
        this.f58728w = c12901f.f58728w;
        this.f58729x = c12901f.f58729x;
        this.f58730y = c12901f.f58730y;
        this.f58731z = c12901f.f58731z;
        return this;
    }

    @Override // p642t.AbstractC12899d
    /* renamed from: d */
    public void mo77325d(HashSet<String> hashSet) {
        if (!Float.isNaN(this.f58721p)) {
            hashSet.add(TopAnimatorConfig.AnimatorType.ALPHA);
        }
        if (!Float.isNaN(this.f58722q)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.f58723r)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.f58725t)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.f58726u)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.f58727v)) {
            hashSet.add(TopAnimatorConfig.AnimatorType.SCALE_X);
        }
        if (!Float.isNaN(this.f58728w)) {
            hashSet.add(TopAnimatorConfig.AnimatorType.SCALE_Y);
        }
        if (!Float.isNaN(this.f58724s)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.f58729x)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.f58730y)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.f58731z)) {
            hashSet.add("translationZ");
        }
        if (this.f58693e.size() > 0) {
            Iterator<String> it = this.f58693e.keySet().iterator();
            while (it.hasNext()) {
                hashSet.add("CUSTOM," + it.next());
            }
        }
    }

    @Override // p642t.AbstractC12899d
    /* renamed from: e */
    public void mo77326e(Context context, AttributeSet attributeSet) {
        a.m77408b(this, context.obtainStyledAttributes(attributeSet, R$styleable.KeyCycle));
    }
}
