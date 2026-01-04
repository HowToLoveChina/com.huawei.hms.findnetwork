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
import p627s.AbstractC12657d;

/* renamed from: t.j */
/* loaded from: classes.dex */
public class C12905j extends AbstractC12899d {

    /* renamed from: g */
    public String f58749g;

    /* renamed from: h */
    public int f58750h = -1;

    /* renamed from: i */
    public float f58751i = Float.NaN;

    /* renamed from: j */
    public float f58752j = Float.NaN;

    /* renamed from: k */
    public float f58753k = Float.NaN;

    /* renamed from: l */
    public float f58754l = Float.NaN;

    /* renamed from: m */
    public float f58755m = Float.NaN;

    /* renamed from: n */
    public float f58756n = Float.NaN;

    /* renamed from: o */
    public float f58757o = Float.NaN;

    /* renamed from: p */
    public float f58758p = Float.NaN;

    /* renamed from: q */
    public float f58759q = Float.NaN;

    /* renamed from: r */
    public float f58760r = Float.NaN;

    /* renamed from: s */
    public float f58761s = Float.NaN;

    /* renamed from: t */
    public float f58762t = Float.NaN;

    /* renamed from: u */
    public int f58763u = 0;

    /* renamed from: v */
    public String f58764v = null;

    /* renamed from: w */
    public float f58765w = Float.NaN;

    /* renamed from: x */
    public float f58766x = 0.0f;

    /* renamed from: t.j$a */
    public static class a {

        /* renamed from: a */
        public static SparseIntArray f58767a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f58767a = sparseIntArray;
            sparseIntArray.append(R$styleable.KeyTimeCycle_android_alpha, 1);
            f58767a.append(R$styleable.KeyTimeCycle_android_elevation, 2);
            f58767a.append(R$styleable.KeyTimeCycle_android_rotation, 4);
            f58767a.append(R$styleable.KeyTimeCycle_android_rotationX, 5);
            f58767a.append(R$styleable.KeyTimeCycle_android_rotationY, 6);
            f58767a.append(R$styleable.KeyTimeCycle_android_scaleX, 7);
            f58767a.append(R$styleable.KeyTimeCycle_transitionPathRotate, 8);
            f58767a.append(R$styleable.KeyTimeCycle_transitionEasing, 9);
            f58767a.append(R$styleable.KeyTimeCycle_motionTarget, 10);
            f58767a.append(R$styleable.KeyTimeCycle_framePosition, 12);
            f58767a.append(R$styleable.KeyTimeCycle_curveFit, 13);
            f58767a.append(R$styleable.KeyTimeCycle_android_scaleY, 14);
            f58767a.append(R$styleable.KeyTimeCycle_android_translationX, 15);
            f58767a.append(R$styleable.KeyTimeCycle_android_translationY, 16);
            f58767a.append(R$styleable.KeyTimeCycle_android_translationZ, 17);
            f58767a.append(R$styleable.KeyTimeCycle_motionProgress, 18);
            f58767a.append(R$styleable.KeyTimeCycle_wavePeriod, 20);
            f58767a.append(R$styleable.KeyTimeCycle_waveOffset, 21);
            f58767a.append(R$styleable.KeyTimeCycle_waveShape, 19);
        }

        /* renamed from: a */
        public static void m77452a(C12905j c12905j, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArray.getIndex(i10);
                switch (f58767a.get(index)) {
                    case 1:
                        c12905j.f58751i = typedArray.getFloat(index, c12905j.f58751i);
                        break;
                    case 2:
                        c12905j.f58752j = typedArray.getDimension(index, c12905j.f58752j);
                        break;
                    case 3:
                    case 11:
                    default:
                        Log.e("KeyTimeCycle", "unused attribute 0x" + Integer.toHexString(index) + "   " + f58767a.get(index));
                        break;
                    case 4:
                        c12905j.f58753k = typedArray.getFloat(index, c12905j.f58753k);
                        break;
                    case 5:
                        c12905j.f58754l = typedArray.getFloat(index, c12905j.f58754l);
                        break;
                    case 6:
                        c12905j.f58755m = typedArray.getFloat(index, c12905j.f58755m);
                        break;
                    case 7:
                        c12905j.f58757o = typedArray.getFloat(index, c12905j.f58757o);
                        break;
                    case 8:
                        c12905j.f58756n = typedArray.getFloat(index, c12905j.f58756n);
                        break;
                    case 9:
                        c12905j.f58749g = typedArray.getString(index);
                        break;
                    case 10:
                        if (MotionLayout.f2560E0) {
                            int resourceId = typedArray.getResourceId(index, c12905j.f58690b);
                            c12905j.f58690b = resourceId;
                            if (resourceId == -1) {
                                c12905j.f58691c = typedArray.getString(index);
                                break;
                            } else {
                                break;
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            c12905j.f58691c = typedArray.getString(index);
                            break;
                        } else {
                            c12905j.f58690b = typedArray.getResourceId(index, c12905j.f58690b);
                            break;
                        }
                    case 12:
                        c12905j.f58689a = typedArray.getInt(index, c12905j.f58689a);
                        break;
                    case 13:
                        c12905j.f58750h = typedArray.getInteger(index, c12905j.f58750h);
                        break;
                    case 14:
                        c12905j.f58758p = typedArray.getFloat(index, c12905j.f58758p);
                        break;
                    case 15:
                        c12905j.f58759q = typedArray.getDimension(index, c12905j.f58759q);
                        break;
                    case 16:
                        c12905j.f58760r = typedArray.getDimension(index, c12905j.f58760r);
                        break;
                    case 17:
                        c12905j.f58761s = typedArray.getDimension(index, c12905j.f58761s);
                        break;
                    case 18:
                        c12905j.f58762t = typedArray.getFloat(index, c12905j.f58762t);
                        break;
                    case 19:
                        if (typedArray.peekValue(index).type == 3) {
                            c12905j.f58764v = typedArray.getString(index);
                            c12905j.f58763u = 7;
                            break;
                        } else {
                            c12905j.f58763u = typedArray.getInt(index, c12905j.f58763u);
                            break;
                        }
                    case 20:
                        c12905j.f58765w = typedArray.getFloat(index, c12905j.f58765w);
                        break;
                    case 21:
                        if (typedArray.peekValue(index).type == 5) {
                            c12905j.f58766x = typedArray.getDimension(index, c12905j.f58766x);
                            break;
                        } else {
                            c12905j.f58766x = typedArray.getFloat(index, c12905j.f58766x);
                            break;
                        }
                }
            }
        }
    }

    public C12905j() {
        this.f58692d = 3;
        this.f58693e = new HashMap<>();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004d  */
    /* renamed from: U */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m77451U(java.util.HashMap<java.lang.String, p627s.AbstractC12659f> r11) {
        /*
            Method dump skipped, instructions count: 604
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p642t.C12905j.m77451U(java.util.HashMap):void");
    }

    @Override // p642t.AbstractC12899d
    /* renamed from: a */
    public void mo77322a(HashMap<String, AbstractC12657d> map) {
        throw new IllegalArgumentException(" KeyTimeCycles do not support SplineSet");
    }

    @Override // p642t.AbstractC12899d
    /* renamed from: b */
    public AbstractC12899d clone() {
        return new C12905j().mo77324c(this);
    }

    @Override // p642t.AbstractC12899d
    /* renamed from: c */
    public AbstractC12899d mo77324c(AbstractC12899d abstractC12899d) {
        super.mo77324c(abstractC12899d);
        C12905j c12905j = (C12905j) abstractC12899d;
        this.f58749g = c12905j.f58749g;
        this.f58750h = c12905j.f58750h;
        this.f58763u = c12905j.f58763u;
        this.f58765w = c12905j.f58765w;
        this.f58766x = c12905j.f58766x;
        this.f58762t = c12905j.f58762t;
        this.f58751i = c12905j.f58751i;
        this.f58752j = c12905j.f58752j;
        this.f58753k = c12905j.f58753k;
        this.f58756n = c12905j.f58756n;
        this.f58754l = c12905j.f58754l;
        this.f58755m = c12905j.f58755m;
        this.f58757o = c12905j.f58757o;
        this.f58758p = c12905j.f58758p;
        this.f58759q = c12905j.f58759q;
        this.f58760r = c12905j.f58760r;
        this.f58761s = c12905j.f58761s;
        this.f58764v = c12905j.f58764v;
        return this;
    }

    @Override // p642t.AbstractC12899d
    /* renamed from: d */
    public void mo77325d(HashSet<String> hashSet) {
        if (!Float.isNaN(this.f58751i)) {
            hashSet.add(TopAnimatorConfig.AnimatorType.ALPHA);
        }
        if (!Float.isNaN(this.f58752j)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.f58753k)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.f58754l)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.f58755m)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.f58759q)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.f58760r)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.f58761s)) {
            hashSet.add("translationZ");
        }
        if (!Float.isNaN(this.f58756n)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.f58757o)) {
            hashSet.add(TopAnimatorConfig.AnimatorType.SCALE_X);
        }
        if (!Float.isNaN(this.f58758p)) {
            hashSet.add(TopAnimatorConfig.AnimatorType.SCALE_Y);
        }
        if (!Float.isNaN(this.f58762t)) {
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
        a.m77452a(this, context.obtainStyledAttributes(attributeSet, R$styleable.KeyTimeCycle));
    }

    @Override // p642t.AbstractC12899d
    /* renamed from: h */
    public void mo77329h(HashMap<String, Integer> map) {
        if (this.f58750h == -1) {
            return;
        }
        if (!Float.isNaN(this.f58751i)) {
            map.put(TopAnimatorConfig.AnimatorType.ALPHA, Integer.valueOf(this.f58750h));
        }
        if (!Float.isNaN(this.f58752j)) {
            map.put("elevation", Integer.valueOf(this.f58750h));
        }
        if (!Float.isNaN(this.f58753k)) {
            map.put("rotation", Integer.valueOf(this.f58750h));
        }
        if (!Float.isNaN(this.f58754l)) {
            map.put("rotationX", Integer.valueOf(this.f58750h));
        }
        if (!Float.isNaN(this.f58755m)) {
            map.put("rotationY", Integer.valueOf(this.f58750h));
        }
        if (!Float.isNaN(this.f58759q)) {
            map.put("translationX", Integer.valueOf(this.f58750h));
        }
        if (!Float.isNaN(this.f58760r)) {
            map.put("translationY", Integer.valueOf(this.f58750h));
        }
        if (!Float.isNaN(this.f58761s)) {
            map.put("translationZ", Integer.valueOf(this.f58750h));
        }
        if (!Float.isNaN(this.f58756n)) {
            map.put("transitionPathRotate", Integer.valueOf(this.f58750h));
        }
        if (!Float.isNaN(this.f58757o)) {
            map.put(TopAnimatorConfig.AnimatorType.SCALE_X, Integer.valueOf(this.f58750h));
        }
        if (!Float.isNaN(this.f58757o)) {
            map.put(TopAnimatorConfig.AnimatorType.SCALE_Y, Integer.valueOf(this.f58750h));
        }
        if (!Float.isNaN(this.f58762t)) {
            map.put(VastAttribute.PROGRESS, Integer.valueOf(this.f58750h));
        }
        if (this.f58693e.size() > 0) {
            Iterator<String> it = this.f58693e.keySet().iterator();
            while (it.hasNext()) {
                map.put("CUSTOM," + it.next(), Integer.valueOf(this.f58750h));
            }
        }
    }
}
