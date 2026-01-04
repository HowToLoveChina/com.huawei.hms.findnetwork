package p642t;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R$styleable;
import com.huawei.android.remotecontrol.p093ui.widget.TopAnimatorConfig;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: t.e */
/* loaded from: classes.dex */
public class C12900e extends AbstractC12899d {

    /* renamed from: g */
    public String f58694g;

    /* renamed from: h */
    public int f58695h = -1;

    /* renamed from: i */
    public boolean f58696i = false;

    /* renamed from: j */
    public float f58697j = Float.NaN;

    /* renamed from: k */
    public float f58698k = Float.NaN;

    /* renamed from: l */
    public float f58699l = Float.NaN;

    /* renamed from: m */
    public float f58700m = Float.NaN;

    /* renamed from: n */
    public float f58701n = Float.NaN;

    /* renamed from: o */
    public float f58702o = Float.NaN;

    /* renamed from: p */
    public float f58703p = Float.NaN;

    /* renamed from: q */
    public float f58704q = Float.NaN;

    /* renamed from: r */
    public float f58705r = Float.NaN;

    /* renamed from: s */
    public float f58706s = Float.NaN;

    /* renamed from: t */
    public float f58707t = Float.NaN;

    /* renamed from: u */
    public float f58708u = Float.NaN;

    /* renamed from: v */
    public float f58709v = Float.NaN;

    /* renamed from: w */
    public float f58710w = Float.NaN;

    /* renamed from: t.e$a */
    public static class a {

        /* renamed from: a */
        public static SparseIntArray f58711a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f58711a = sparseIntArray;
            sparseIntArray.append(R$styleable.KeyAttribute_android_alpha, 1);
            f58711a.append(R$styleable.KeyAttribute_android_elevation, 2);
            f58711a.append(R$styleable.KeyAttribute_android_rotation, 4);
            f58711a.append(R$styleable.KeyAttribute_android_rotationX, 5);
            f58711a.append(R$styleable.KeyAttribute_android_rotationY, 6);
            f58711a.append(R$styleable.KeyAttribute_android_transformPivotX, 19);
            f58711a.append(R$styleable.KeyAttribute_android_transformPivotY, 20);
            f58711a.append(R$styleable.KeyAttribute_android_scaleX, 7);
            f58711a.append(R$styleable.KeyAttribute_transitionPathRotate, 8);
            f58711a.append(R$styleable.KeyAttribute_transitionEasing, 9);
            f58711a.append(R$styleable.KeyAttribute_motionTarget, 10);
            f58711a.append(R$styleable.KeyAttribute_framePosition, 12);
            f58711a.append(R$styleable.KeyAttribute_curveFit, 13);
            f58711a.append(R$styleable.KeyAttribute_android_scaleY, 14);
            f58711a.append(R$styleable.KeyAttribute_android_translationX, 15);
            f58711a.append(R$styleable.KeyAttribute_android_translationY, 16);
            f58711a.append(R$styleable.KeyAttribute_android_translationZ, 17);
            f58711a.append(R$styleable.KeyAttribute_motionProgress, 18);
        }

        /* renamed from: a */
        public static void m77366a(C12900e c12900e, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArray.getIndex(i10);
                switch (f58711a.get(index)) {
                    case 1:
                        c12900e.f58697j = typedArray.getFloat(index, c12900e.f58697j);
                        break;
                    case 2:
                        c12900e.f58698k = typedArray.getDimension(index, c12900e.f58698k);
                        break;
                    case 3:
                    case 11:
                    default:
                        Log.e("KeyAttribute", "unused attribute 0x" + Integer.toHexString(index) + "   " + f58711a.get(index));
                        break;
                    case 4:
                        c12900e.f58699l = typedArray.getFloat(index, c12900e.f58699l);
                        break;
                    case 5:
                        c12900e.f58700m = typedArray.getFloat(index, c12900e.f58700m);
                        break;
                    case 6:
                        c12900e.f58701n = typedArray.getFloat(index, c12900e.f58701n);
                        break;
                    case 7:
                        c12900e.f58705r = typedArray.getFloat(index, c12900e.f58705r);
                        break;
                    case 8:
                        c12900e.f58704q = typedArray.getFloat(index, c12900e.f58704q);
                        break;
                    case 9:
                        c12900e.f58694g = typedArray.getString(index);
                        break;
                    case 10:
                        if (MotionLayout.f2560E0) {
                            int resourceId = typedArray.getResourceId(index, c12900e.f58690b);
                            c12900e.f58690b = resourceId;
                            if (resourceId == -1) {
                                c12900e.f58691c = typedArray.getString(index);
                                break;
                            } else {
                                break;
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            c12900e.f58691c = typedArray.getString(index);
                            break;
                        } else {
                            c12900e.f58690b = typedArray.getResourceId(index, c12900e.f58690b);
                            break;
                        }
                    case 12:
                        c12900e.f58689a = typedArray.getInt(index, c12900e.f58689a);
                        break;
                    case 13:
                        c12900e.f58695h = typedArray.getInteger(index, c12900e.f58695h);
                        break;
                    case 14:
                        c12900e.f58706s = typedArray.getFloat(index, c12900e.f58706s);
                        break;
                    case 15:
                        c12900e.f58707t = typedArray.getDimension(index, c12900e.f58707t);
                        break;
                    case 16:
                        c12900e.f58708u = typedArray.getDimension(index, c12900e.f58708u);
                        break;
                    case 17:
                        c12900e.f58709v = typedArray.getDimension(index, c12900e.f58709v);
                        break;
                    case 18:
                        c12900e.f58710w = typedArray.getFloat(index, c12900e.f58710w);
                        break;
                    case 19:
                        c12900e.f58702o = typedArray.getDimension(index, c12900e.f58702o);
                        break;
                    case 20:
                        c12900e.f58703p = typedArray.getDimension(index, c12900e.f58703p);
                        break;
                }
            }
        }
    }

    public C12900e() {
        this.f58692d = 1;
        this.f58693e = new HashMap<>();
    }

    /* renamed from: R */
    public void m77365R(String str, Object obj) {
        str.hashCode();
        switch (str) {
            case "motionProgress":
                this.f58710w = m77332k(obj);
                break;
            case "transitionEasing":
                this.f58694g = obj.toString();
                break;
            case "rotationX":
                this.f58700m = m77332k(obj);
                break;
            case "rotationY":
                this.f58701n = m77332k(obj);
                break;
            case "translationX":
                this.f58707t = m77332k(obj);
                break;
            case "translationY":
                this.f58708u = m77332k(obj);
                break;
            case "translationZ":
                this.f58709v = m77332k(obj);
                break;
            case "scaleX":
                this.f58705r = m77332k(obj);
                break;
            case "scaleY":
                this.f58706s = m77332k(obj);
                break;
            case "transformPivotX":
                this.f58702o = m77332k(obj);
                break;
            case "transformPivotY":
                this.f58703p = m77332k(obj);
                break;
            case "rotation":
                this.f58699l = m77332k(obj);
                break;
            case "elevation":
                this.f58698k = m77332k(obj);
                break;
            case "transitionPathRotate":
                this.f58704q = m77332k(obj);
                break;
            case "alpha":
                this.f58697j = m77332k(obj);
                break;
            case "curveFit":
                this.f58695h = m77333l(obj);
                break;
            case "visibility":
                this.f58696i = m77331j(obj);
                break;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0044  */
    @Override // p642t.AbstractC12899d
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo77322a(java.util.HashMap<java.lang.String, p627s.AbstractC12657d> r7) {
        /*
            Method dump skipped, instructions count: 572
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p642t.C12900e.mo77322a(java.util.HashMap):void");
    }

    @Override // p642t.AbstractC12899d
    /* renamed from: b */
    public AbstractC12899d clone() {
        return new C12900e().mo77324c(this);
    }

    @Override // p642t.AbstractC12899d
    /* renamed from: c */
    public AbstractC12899d mo77324c(AbstractC12899d abstractC12899d) {
        super.mo77324c(abstractC12899d);
        C12900e c12900e = (C12900e) abstractC12899d;
        this.f58695h = c12900e.f58695h;
        this.f58696i = c12900e.f58696i;
        this.f58697j = c12900e.f58697j;
        this.f58698k = c12900e.f58698k;
        this.f58699l = c12900e.f58699l;
        this.f58700m = c12900e.f58700m;
        this.f58701n = c12900e.f58701n;
        this.f58702o = c12900e.f58702o;
        this.f58703p = c12900e.f58703p;
        this.f58704q = c12900e.f58704q;
        this.f58705r = c12900e.f58705r;
        this.f58706s = c12900e.f58706s;
        this.f58707t = c12900e.f58707t;
        this.f58708u = c12900e.f58708u;
        this.f58709v = c12900e.f58709v;
        this.f58710w = c12900e.f58710w;
        this.f58694g = c12900e.f58694g;
        return this;
    }

    @Override // p642t.AbstractC12899d
    /* renamed from: d */
    public void mo77325d(HashSet<String> hashSet) {
        if (!Float.isNaN(this.f58697j)) {
            hashSet.add(TopAnimatorConfig.AnimatorType.ALPHA);
        }
        if (!Float.isNaN(this.f58698k)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.f58699l)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.f58700m)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.f58701n)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.f58702o)) {
            hashSet.add("transformPivotX");
        }
        if (!Float.isNaN(this.f58703p)) {
            hashSet.add("transformPivotY");
        }
        if (!Float.isNaN(this.f58707t)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.f58708u)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.f58709v)) {
            hashSet.add("translationZ");
        }
        if (!Float.isNaN(this.f58704q)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.f58705r)) {
            hashSet.add(TopAnimatorConfig.AnimatorType.SCALE_X);
        }
        if (!Float.isNaN(this.f58706s)) {
            hashSet.add(TopAnimatorConfig.AnimatorType.SCALE_Y);
        }
        if (!Float.isNaN(this.f58710w)) {
            hashSet.add(VastAttribute.PROGRESS);
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
        a.m77366a(this, context.obtainStyledAttributes(attributeSet, R$styleable.KeyAttribute));
    }

    @Override // p642t.AbstractC12899d
    /* renamed from: h */
    public void mo77329h(HashMap<String, Integer> map) {
        if (this.f58695h == -1) {
            return;
        }
        if (!Float.isNaN(this.f58697j)) {
            map.put(TopAnimatorConfig.AnimatorType.ALPHA, Integer.valueOf(this.f58695h));
        }
        if (!Float.isNaN(this.f58698k)) {
            map.put("elevation", Integer.valueOf(this.f58695h));
        }
        if (!Float.isNaN(this.f58699l)) {
            map.put("rotation", Integer.valueOf(this.f58695h));
        }
        if (!Float.isNaN(this.f58700m)) {
            map.put("rotationX", Integer.valueOf(this.f58695h));
        }
        if (!Float.isNaN(this.f58701n)) {
            map.put("rotationY", Integer.valueOf(this.f58695h));
        }
        if (!Float.isNaN(this.f58702o)) {
            map.put("transformPivotX", Integer.valueOf(this.f58695h));
        }
        if (!Float.isNaN(this.f58703p)) {
            map.put("transformPivotY", Integer.valueOf(this.f58695h));
        }
        if (!Float.isNaN(this.f58707t)) {
            map.put("translationX", Integer.valueOf(this.f58695h));
        }
        if (!Float.isNaN(this.f58708u)) {
            map.put("translationY", Integer.valueOf(this.f58695h));
        }
        if (!Float.isNaN(this.f58709v)) {
            map.put("translationZ", Integer.valueOf(this.f58695h));
        }
        if (!Float.isNaN(this.f58704q)) {
            map.put("transitionPathRotate", Integer.valueOf(this.f58695h));
        }
        if (!Float.isNaN(this.f58705r)) {
            map.put(TopAnimatorConfig.AnimatorType.SCALE_X, Integer.valueOf(this.f58695h));
        }
        if (!Float.isNaN(this.f58706s)) {
            map.put(TopAnimatorConfig.AnimatorType.SCALE_Y, Integer.valueOf(this.f58695h));
        }
        if (!Float.isNaN(this.f58710w)) {
            map.put(VastAttribute.PROGRESS, Integer.valueOf(this.f58695h));
        }
        if (this.f58693e.size() > 0) {
            Iterator<String> it = this.f58693e.keySet().iterator();
            while (it.hasNext()) {
                map.put("CUSTOM," + it.next(), Integer.valueOf(this.f58695h));
            }
        }
    }
}
