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
import p504o.AbstractC11777j;

/* renamed from: s.d */
/* loaded from: classes.dex */
public abstract class AbstractC12657d extends AbstractC11777j {

    /* renamed from: s.d$a */
    public static class a extends AbstractC12657d {
        @Override // p627s.AbstractC12657d
        /* renamed from: h */
        public void mo76193h(View view, float f10) {
            view.setAlpha(m70149a(f10));
        }
    }

    /* renamed from: s.d$b */
    public static class b extends AbstractC12657d {

        /* renamed from: f */
        public String f58130f;

        /* renamed from: g */
        public SparseArray<C0583a> f58131g;

        /* renamed from: h */
        public float[] f58132h;

        public b(String str, SparseArray<C0583a> sparseArray) {
            this.f58130f = str.split(",")[1];
            this.f58131g = sparseArray;
        }

        @Override // p504o.AbstractC11777j
        /* renamed from: c */
        public void mo70151c(int i10, float f10) {
            throw new RuntimeException("call of custom attribute setPoint");
        }

        @Override // p504o.AbstractC11777j
        /* renamed from: e */
        public void mo70153e(int i10) {
            int size = this.f58131g.size();
            int iM3592h = this.f58131g.valueAt(0).m3592h();
            double[] dArr = new double[size];
            this.f58132h = new float[iM3592h];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, iM3592h);
            for (int i11 = 0; i11 < size; i11++) {
                int iKeyAt = this.f58131g.keyAt(i11);
                C0583a c0583aValueAt = this.f58131g.valueAt(i11);
                dArr[i11] = iKeyAt * 0.01d;
                c0583aValueAt.m3590f(this.f58132h);
                int i12 = 0;
                while (true) {
                    if (i12 < this.f58132h.length) {
                        dArr2[i11][i12] = r6[i12];
                        i12++;
                    }
                }
            }
            this.f54450a = AbstractC11769b.m70114a(i10, dArr, dArr2);
        }

        @Override // p627s.AbstractC12657d
        /* renamed from: h */
        public void mo76193h(View view, float f10) {
            this.f54450a.mo70099e(f10, this.f58132h);
            C12654a.m76184b(this.f58131g.valueAt(0), view, this.f58132h);
        }

        /* renamed from: i */
        public void m76194i(int i10, C0583a c0583a) {
            this.f58131g.append(i10, c0583a);
        }
    }

    /* renamed from: s.d$c */
    public static class c extends AbstractC12657d {
        @Override // p627s.AbstractC12657d
        /* renamed from: h */
        public void mo76193h(View view, float f10) {
            view.setElevation(m70149a(f10));
        }
    }

    /* renamed from: s.d$d */
    public static class d extends AbstractC12657d {
        @Override // p627s.AbstractC12657d
        /* renamed from: h */
        public void mo76193h(View view, float f10) {
        }

        /* renamed from: i */
        public void m76195i(View view, float f10, double d10, double d11) {
            view.setRotation(m70149a(f10) + ((float) Math.toDegrees(Math.atan2(d11, d10))));
        }
    }

    /* renamed from: s.d$e */
    public static class e extends AbstractC12657d {
        @Override // p627s.AbstractC12657d
        /* renamed from: h */
        public void mo76193h(View view, float f10) {
            view.setPivotX(m70149a(f10));
        }
    }

    /* renamed from: s.d$f */
    public static class f extends AbstractC12657d {
        @Override // p627s.AbstractC12657d
        /* renamed from: h */
        public void mo76193h(View view, float f10) {
            view.setPivotY(m70149a(f10));
        }
    }

    /* renamed from: s.d$g */
    public static class g extends AbstractC12657d {

        /* renamed from: f */
        public boolean f58133f = false;

        @Override // p627s.AbstractC12657d
        /* renamed from: h */
        public void mo76193h(View view, float f10) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            Method method;
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(m70149a(f10));
                return;
            }
            if (this.f58133f) {
                return;
            }
            try {
                method = view.getClass().getMethod("setProgress", Float.TYPE);
            } catch (NoSuchMethodException unused) {
                this.f58133f = true;
                method = null;
            }
            if (method != null) {
                try {
                    method.invoke(view, Float.valueOf(m70149a(f10)));
                } catch (IllegalAccessException e10) {
                    Log.e("ViewSpline", "unable to setProgress", e10);
                } catch (InvocationTargetException e11) {
                    Log.e("ViewSpline", "unable to setProgress", e11);
                }
            }
        }
    }

    /* renamed from: s.d$h */
    public static class h extends AbstractC12657d {
        @Override // p627s.AbstractC12657d
        /* renamed from: h */
        public void mo76193h(View view, float f10) {
            view.setRotation(m70149a(f10));
        }
    }

    /* renamed from: s.d$i */
    public static class i extends AbstractC12657d {
        @Override // p627s.AbstractC12657d
        /* renamed from: h */
        public void mo76193h(View view, float f10) {
            view.setRotationX(m70149a(f10));
        }
    }

    /* renamed from: s.d$j */
    public static class j extends AbstractC12657d {
        @Override // p627s.AbstractC12657d
        /* renamed from: h */
        public void mo76193h(View view, float f10) {
            view.setRotationY(m70149a(f10));
        }
    }

    /* renamed from: s.d$k */
    public static class k extends AbstractC12657d {
        @Override // p627s.AbstractC12657d
        /* renamed from: h */
        public void mo76193h(View view, float f10) {
            view.setScaleX(m70149a(f10));
        }
    }

    /* renamed from: s.d$l */
    public static class l extends AbstractC12657d {
        @Override // p627s.AbstractC12657d
        /* renamed from: h */
        public void mo76193h(View view, float f10) {
            view.setScaleY(m70149a(f10));
        }
    }

    /* renamed from: s.d$m */
    public static class m extends AbstractC12657d {
        @Override // p627s.AbstractC12657d
        /* renamed from: h */
        public void mo76193h(View view, float f10) {
            view.setTranslationX(m70149a(f10));
        }
    }

    /* renamed from: s.d$n */
    public static class n extends AbstractC12657d {
        @Override // p627s.AbstractC12657d
        /* renamed from: h */
        public void mo76193h(View view, float f10) {
            view.setTranslationY(m70149a(f10));
        }
    }

    /* renamed from: s.d$o */
    public static class o extends AbstractC12657d {
        @Override // p627s.AbstractC12657d
        /* renamed from: h */
        public void mo76193h(View view, float f10) {
            view.setTranslationZ(m70149a(f10));
        }
    }

    /* renamed from: f */
    public static AbstractC12657d m76191f(String str, SparseArray<C0583a> sparseArray) {
        return new b(str, sparseArray);
    }

    /* renamed from: g */
    public static AbstractC12657d m76192g(String str) {
        str.hashCode();
        switch (str) {
        }
        return new a();
    }

    /* renamed from: h */
    public abstract void mo76193h(View view, float f10);
}
