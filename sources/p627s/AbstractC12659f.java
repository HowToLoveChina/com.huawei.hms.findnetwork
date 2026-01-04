package p627s;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.C0583a;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import p504o.AbstractC11769b;
import p504o.AbstractC11782o;
import p504o.C11771d;

/* renamed from: s.f */
/* loaded from: classes.dex */
public abstract class AbstractC12659f extends AbstractC11782o {

    /* renamed from: s.f$a */
    public static class a extends AbstractC12659f {
        @Override // p627s.AbstractC12659f
        /* renamed from: i */
        public boolean mo76201i(View view, float f10, long j10, C11771d c11771d) {
            view.setAlpha(m76200f(f10, j10, view, c11771d));
            return this.f54491h;
        }
    }

    /* renamed from: s.f$b */
    public static class b extends AbstractC12659f {

        /* renamed from: l */
        public String f58139l;

        /* renamed from: m */
        public SparseArray<C0583a> f58140m;

        /* renamed from: n */
        public SparseArray<float[]> f58141n = new SparseArray<>();

        /* renamed from: o */
        public float[] f58142o;

        public b(String str, SparseArray<C0583a> sparseArray) {
            this.f58139l = str.split(",")[1];
            this.f58140m = sparseArray;
        }

        @Override // p504o.AbstractC11782o
        /* renamed from: b */
        public void mo70167b(int i10, float f10, float f11, int i11, float f12) {
            throw new RuntimeException("Wrong call for custom attribute");
        }

        @Override // p504o.AbstractC11782o
        /* renamed from: e */
        public void mo70170e(int i10) {
            int size = this.f58140m.size();
            int iM3592h = this.f58140m.valueAt(0).m3592h();
            double[] dArr = new double[size];
            int i11 = iM3592h + 2;
            this.f58142o = new float[i11];
            this.f54490g = new float[iM3592h];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, i11);
            for (int i12 = 0; i12 < size; i12++) {
                int iKeyAt = this.f58140m.keyAt(i12);
                C0583a c0583aValueAt = this.f58140m.valueAt(i12);
                float[] fArrValueAt = this.f58141n.valueAt(i12);
                dArr[i12] = iKeyAt * 0.01d;
                c0583aValueAt.m3590f(this.f58142o);
                int i13 = 0;
                while (true) {
                    if (i13 < this.f58142o.length) {
                        dArr2[i12][i13] = r7[i13];
                        i13++;
                    }
                }
                double[] dArr3 = dArr2[i12];
                dArr3[iM3592h] = fArrValueAt[0];
                dArr3[iM3592h + 1] = fArrValueAt[1];
            }
            this.f54484a = AbstractC11769b.m70114a(i10, dArr, dArr2);
        }

        @Override // p627s.AbstractC12659f
        /* renamed from: i */
        public boolean mo76201i(View view, float f10, long j10, C11771d c11771d) {
            this.f54484a.mo70099e(f10, this.f58142o);
            float[] fArr = this.f58142o;
            float f11 = fArr[fArr.length - 2];
            float f12 = fArr[fArr.length - 1];
            long j11 = j10 - this.f54492i;
            if (Float.isNaN(this.f54493j)) {
                float fM70121a = c11771d.m70121a(view, this.f58139l, 0);
                this.f54493j = fM70121a;
                if (Float.isNaN(fM70121a)) {
                    this.f54493j = 0.0f;
                }
            }
            float f13 = (float) ((this.f54493j + ((j11 * 1.0E-9d) * f11)) % 1.0d);
            this.f54493j = f13;
            this.f54492i = j10;
            float fM70166a = m70166a(f13);
            this.f54491h = false;
            int i10 = 0;
            while (true) {
                float[] fArr2 = this.f54490g;
                if (i10 >= fArr2.length) {
                    break;
                }
                boolean z10 = this.f54491h;
                float f14 = this.f58142o[i10];
                this.f54491h = z10 | (((double) f14) != 0.0d);
                fArr2[i10] = (f14 * fM70166a) + f12;
                i10++;
            }
            C12654a.m76184b(this.f58140m.valueAt(0), view, this.f54490g);
            if (f11 != 0.0f) {
                this.f54491h = true;
            }
            return this.f54491h;
        }

        /* renamed from: j */
        public void m76202j(int i10, C0583a c0583a, float f10, int i11, float f11) {
            this.f58140m.append(i10, c0583a);
            this.f58141n.append(i10, new float[]{f10, f11});
            this.f54485b = Math.max(this.f54485b, i11);
        }
    }

    /* renamed from: s.f$c */
    public static class c extends AbstractC12659f {
        @Override // p627s.AbstractC12659f
        /* renamed from: i */
        public boolean mo76201i(View view, float f10, long j10, C11771d c11771d) {
            view.setElevation(m76200f(f10, j10, view, c11771d));
            return this.f54491h;
        }
    }

    /* renamed from: s.f$d */
    public static class d extends AbstractC12659f {
        @Override // p627s.AbstractC12659f
        /* renamed from: i */
        public boolean mo76201i(View view, float f10, long j10, C11771d c11771d) {
            return this.f54491h;
        }

        /* renamed from: j */
        public boolean m76203j(View view, C11771d c11771d, float f10, long j10, double d10, double d11) {
            view.setRotation(m76200f(f10, j10, view, c11771d) + ((float) Math.toDegrees(Math.atan2(d11, d10))));
            return this.f54491h;
        }
    }

    /* renamed from: s.f$e */
    public static class e extends AbstractC12659f {

        /* renamed from: l */
        public boolean f58143l = false;

        @Override // p627s.AbstractC12659f
        /* renamed from: i */
        public boolean mo76201i(View view, float f10, long j10, C11771d c11771d) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            Method method;
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(m76200f(f10, j10, view, c11771d));
            } else {
                if (this.f58143l) {
                    return false;
                }
                try {
                    method = view.getClass().getMethod("setProgress", Float.TYPE);
                } catch (NoSuchMethodException unused) {
                    this.f58143l = true;
                    method = null;
                }
                Method method2 = method;
                if (method2 != null) {
                    try {
                        method2.invoke(view, Float.valueOf(m76200f(f10, j10, view, c11771d)));
                    } catch (IllegalAccessException e10) {
                        Log.e("ViewTimeCycle", "unable to setProgress", e10);
                    } catch (InvocationTargetException e11) {
                        Log.e("ViewTimeCycle", "unable to setProgress", e11);
                    }
                }
            }
            return this.f54491h;
        }
    }

    /* renamed from: s.f$f */
    public static class f extends AbstractC12659f {
        @Override // p627s.AbstractC12659f
        /* renamed from: i */
        public boolean mo76201i(View view, float f10, long j10, C11771d c11771d) {
            view.setRotation(m76200f(f10, j10, view, c11771d));
            return this.f54491h;
        }
    }

    /* renamed from: s.f$g */
    public static class g extends AbstractC12659f {
        @Override // p627s.AbstractC12659f
        /* renamed from: i */
        public boolean mo76201i(View view, float f10, long j10, C11771d c11771d) {
            view.setRotationX(m76200f(f10, j10, view, c11771d));
            return this.f54491h;
        }
    }

    /* renamed from: s.f$h */
    public static class h extends AbstractC12659f {
        @Override // p627s.AbstractC12659f
        /* renamed from: i */
        public boolean mo76201i(View view, float f10, long j10, C11771d c11771d) {
            view.setRotationY(m76200f(f10, j10, view, c11771d));
            return this.f54491h;
        }
    }

    /* renamed from: s.f$i */
    public static class i extends AbstractC12659f {
        @Override // p627s.AbstractC12659f
        /* renamed from: i */
        public boolean mo76201i(View view, float f10, long j10, C11771d c11771d) {
            view.setScaleX(m76200f(f10, j10, view, c11771d));
            return this.f54491h;
        }
    }

    /* renamed from: s.f$j */
    public static class j extends AbstractC12659f {
        @Override // p627s.AbstractC12659f
        /* renamed from: i */
        public boolean mo76201i(View view, float f10, long j10, C11771d c11771d) {
            view.setScaleY(m76200f(f10, j10, view, c11771d));
            return this.f54491h;
        }
    }

    /* renamed from: s.f$k */
    public static class k extends AbstractC12659f {
        @Override // p627s.AbstractC12659f
        /* renamed from: i */
        public boolean mo76201i(View view, float f10, long j10, C11771d c11771d) {
            view.setTranslationX(m76200f(f10, j10, view, c11771d));
            return this.f54491h;
        }
    }

    /* renamed from: s.f$l */
    public static class l extends AbstractC12659f {
        @Override // p627s.AbstractC12659f
        /* renamed from: i */
        public boolean mo76201i(View view, float f10, long j10, C11771d c11771d) {
            view.setTranslationY(m76200f(f10, j10, view, c11771d));
            return this.f54491h;
        }
    }

    /* renamed from: s.f$m */
    public static class m extends AbstractC12659f {
        @Override // p627s.AbstractC12659f
        /* renamed from: i */
        public boolean mo76201i(View view, float f10, long j10, C11771d c11771d) {
            view.setTranslationZ(m76200f(f10, j10, view, c11771d));
            return this.f54491h;
        }
    }

    /* renamed from: g */
    public static AbstractC12659f m76198g(String str, SparseArray<C0583a> sparseArray) {
        return new b(str, sparseArray);
    }

    /* renamed from: h */
    public static AbstractC12659f m76199h(String str, long j10) {
        AbstractC12659f gVar;
        str.hashCode();
        switch (str) {
            case "rotationX":
                gVar = new g();
                break;
            case "rotationY":
                gVar = new h();
                break;
            case "translationX":
                gVar = new k();
                break;
            case "translationY":
                gVar = new l();
                break;
            case "translationZ":
                gVar = new m();
                break;
            case "progress":
                gVar = new e();
                break;
            case "scaleX":
                gVar = new i();
                break;
            case "scaleY":
                gVar = new j();
                break;
            case "rotation":
                gVar = new f();
                break;
            case "elevation":
                gVar = new c();
                break;
            case "transitionPathRotate":
                gVar = new d();
                break;
            case "alpha":
                gVar = new a();
                break;
            default:
                return null;
        }
        gVar.m70168c(j10);
        return gVar;
    }

    /* renamed from: f */
    public float m76200f(float f10, long j10, View view, C11771d c11771d) {
        this.f54484a.mo70099e(f10, this.f54490g);
        float[] fArr = this.f54490g;
        float f11 = fArr[1];
        if (f11 == 0.0f) {
            this.f54491h = false;
            return fArr[2];
        }
        if (Float.isNaN(this.f54493j)) {
            float fM70121a = c11771d.m70121a(view, this.f54489f, 0);
            this.f54493j = fM70121a;
            if (Float.isNaN(fM70121a)) {
                this.f54493j = 0.0f;
            }
        }
        float f12 = (float) ((this.f54493j + (((j10 - this.f54492i) * 1.0E-9d) * f11)) % 1.0d);
        this.f54493j = f12;
        c11771d.m70122b(view, this.f54489f, 0, f12);
        this.f54492i = j10;
        float f13 = this.f54490g[0];
        float fM70166a = (m70166a(this.f54493j) * f13) + this.f54490g[2];
        this.f54491h = (f13 == 0.0f && f11 == 0.0f) ? false : true;
        return fM70166a;
    }

    /* renamed from: i */
    public abstract boolean mo76201i(View view, float f10, long j10, C11771d c11771d);
}
