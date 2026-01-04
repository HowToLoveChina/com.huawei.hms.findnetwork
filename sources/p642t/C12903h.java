package p642t;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R$styleable;
import java.util.HashMap;
import p504o.C11770c;
import p627s.AbstractC12657d;

/* renamed from: t.h */
/* loaded from: classes.dex */
public class C12903h extends AbstractC12904i {

    /* renamed from: h */
    public String f58735h = null;

    /* renamed from: i */
    public int f58736i = AbstractC12899d.f58688f;

    /* renamed from: j */
    public int f58737j = 0;

    /* renamed from: k */
    public float f58738k = Float.NaN;

    /* renamed from: l */
    public float f58739l = Float.NaN;

    /* renamed from: m */
    public float f58740m = Float.NaN;

    /* renamed from: n */
    public float f58741n = Float.NaN;

    /* renamed from: o */
    public float f58742o = Float.NaN;

    /* renamed from: p */
    public float f58743p = Float.NaN;

    /* renamed from: q */
    public int f58744q = 0;

    /* renamed from: r */
    public float f58745r = Float.NaN;

    /* renamed from: s */
    public float f58746s = Float.NaN;

    /* renamed from: t.h$a */
    public static class a {

        /* renamed from: a */
        public static SparseIntArray f58747a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f58747a = sparseIntArray;
            sparseIntArray.append(R$styleable.KeyPosition_motionTarget, 1);
            f58747a.append(R$styleable.KeyPosition_framePosition, 2);
            f58747a.append(R$styleable.KeyPosition_transitionEasing, 3);
            f58747a.append(R$styleable.KeyPosition_curveFit, 4);
            f58747a.append(R$styleable.KeyPosition_drawPath, 5);
            f58747a.append(R$styleable.KeyPosition_percentX, 6);
            f58747a.append(R$styleable.KeyPosition_percentY, 7);
            f58747a.append(R$styleable.KeyPosition_keyPositionType, 9);
            f58747a.append(R$styleable.KeyPosition_sizePercent, 8);
            f58747a.append(R$styleable.KeyPosition_percentWidth, 11);
            f58747a.append(R$styleable.KeyPosition_percentHeight, 12);
            f58747a.append(R$styleable.KeyPosition_pathMotionArc, 10);
        }

        /* renamed from: b */
        public static void m77416b(C12903h c12903h, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArray.getIndex(i10);
                switch (f58747a.get(index)) {
                    case 1:
                        if (MotionLayout.f2560E0) {
                            int resourceId = typedArray.getResourceId(index, c12903h.f58690b);
                            c12903h.f58690b = resourceId;
                            if (resourceId == -1) {
                                c12903h.f58691c = typedArray.getString(index);
                                break;
                            } else {
                                break;
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            c12903h.f58691c = typedArray.getString(index);
                            break;
                        } else {
                            c12903h.f58690b = typedArray.getResourceId(index, c12903h.f58690b);
                            break;
                        }
                    case 2:
                        c12903h.f58689a = typedArray.getInt(index, c12903h.f58689a);
                        break;
                    case 3:
                        if (typedArray.peekValue(index).type == 3) {
                            c12903h.f58735h = typedArray.getString(index);
                            break;
                        } else {
                            c12903h.f58735h = C11770c.f54392c[typedArray.getInteger(index, 0)];
                            break;
                        }
                    case 4:
                        c12903h.f58748g = typedArray.getInteger(index, c12903h.f58748g);
                        break;
                    case 5:
                        c12903h.f58737j = typedArray.getInt(index, c12903h.f58737j);
                        break;
                    case 6:
                        c12903h.f58740m = typedArray.getFloat(index, c12903h.f58740m);
                        break;
                    case 7:
                        c12903h.f58741n = typedArray.getFloat(index, c12903h.f58741n);
                        break;
                    case 8:
                        float f10 = typedArray.getFloat(index, c12903h.f58739l);
                        c12903h.f58738k = f10;
                        c12903h.f58739l = f10;
                        break;
                    case 9:
                        c12903h.f58744q = typedArray.getInt(index, c12903h.f58744q);
                        break;
                    case 10:
                        c12903h.f58736i = typedArray.getInt(index, c12903h.f58736i);
                        break;
                    case 11:
                        c12903h.f58738k = typedArray.getFloat(index, c12903h.f58738k);
                        break;
                    case 12:
                        c12903h.f58739l = typedArray.getFloat(index, c12903h.f58739l);
                        break;
                    default:
                        Log.e("KeyPosition", "unused attribute 0x" + Integer.toHexString(index) + "   " + f58747a.get(index));
                        break;
                }
            }
            if (c12903h.f58689a == -1) {
                Log.e("KeyPosition", "no frame position");
            }
        }
    }

    public C12903h() {
        this.f58692d = 2;
    }

    @Override // p642t.AbstractC12899d
    /* renamed from: a */
    public void mo77322a(HashMap<String, AbstractC12657d> map) {
    }

    @Override // p642t.AbstractC12899d
    /* renamed from: b */
    public AbstractC12899d clone() {
        return new C12903h().mo77324c(this);
    }

    @Override // p642t.AbstractC12899d
    /* renamed from: c */
    public AbstractC12899d mo77324c(AbstractC12899d abstractC12899d) {
        super.mo77324c(abstractC12899d);
        C12903h c12903h = (C12903h) abstractC12899d;
        this.f58735h = c12903h.f58735h;
        this.f58736i = c12903h.f58736i;
        this.f58737j = c12903h.f58737j;
        this.f58738k = c12903h.f58738k;
        this.f58739l = Float.NaN;
        this.f58740m = c12903h.f58740m;
        this.f58741n = c12903h.f58741n;
        this.f58742o = c12903h.f58742o;
        this.f58743p = c12903h.f58743p;
        this.f58745r = c12903h.f58745r;
        this.f58746s = c12903h.f58746s;
        return this;
    }

    @Override // p642t.AbstractC12899d
    /* renamed from: e */
    public void mo77326e(Context context, AttributeSet attributeSet) {
        a.m77416b(this, context.obtainStyledAttributes(attributeSet, R$styleable.KeyPosition));
    }

    /* renamed from: m */
    public void m77413m(int i10) {
        this.f58744q = i10;
    }

    /* renamed from: n */
    public void m77414n(String str, Object obj) {
        str.hashCode();
        switch (str) {
            case "transitionEasing":
                this.f58735h = obj.toString();
                break;
            case "percentWidth":
                this.f58738k = m77332k(obj);
                break;
            case "percentHeight":
                this.f58739l = m77332k(obj);
                break;
            case "drawPath":
                this.f58737j = m77333l(obj);
                break;
            case "sizePercent":
                float fM77332k = m77332k(obj);
                this.f58738k = fM77332k;
                this.f58739l = fM77332k;
                break;
            case "percentX":
                this.f58740m = m77332k(obj);
                break;
            case "percentY":
                this.f58741n = m77332k(obj);
                break;
        }
    }
}
