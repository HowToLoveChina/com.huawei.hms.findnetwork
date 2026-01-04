package p627s;

import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.C0583a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import p504o.AbstractC11772e;

/* renamed from: s.c */
/* loaded from: classes.dex */
public abstract class AbstractC12656c extends AbstractC11772e {

    /* renamed from: s.c$a */
    public static class a extends AbstractC12656c {
        @Override // p627s.AbstractC12656c
        /* renamed from: j */
        public void mo76189j(View view, float f10) {
            view.setAlpha(m70123a(f10));
        }
    }

    /* renamed from: s.c$b */
    public static class b extends AbstractC12656c {

        /* renamed from: h */
        public float[] f58127h = new float[1];

        /* renamed from: i */
        public C0583a f58128i;

        @Override // p504o.AbstractC11772e
        /* renamed from: c */
        public void mo70125c(Object obj) {
            this.f58128i = (C0583a) obj;
        }

        @Override // p627s.AbstractC12656c
        /* renamed from: j */
        public void mo76189j(View view, float f10) {
            this.f58127h[0] = m70123a(f10);
            C12654a.m76184b(this.f58128i, view, this.f58127h);
        }
    }

    /* renamed from: s.c$c */
    public static class c extends AbstractC12656c {
        @Override // p627s.AbstractC12656c
        /* renamed from: j */
        public void mo76189j(View view, float f10) {
            view.setElevation(m70123a(f10));
        }
    }

    /* renamed from: s.c$d */
    public static class d extends AbstractC12656c {
        @Override // p627s.AbstractC12656c
        /* renamed from: j */
        public void mo76189j(View view, float f10) {
        }

        /* renamed from: k */
        public void m76190k(View view, float f10, double d10, double d11) {
            view.setRotation(m70123a(f10) + ((float) Math.toDegrees(Math.atan2(d11, d10))));
        }
    }

    /* renamed from: s.c$e */
    public static class e extends AbstractC12656c {

        /* renamed from: h */
        public boolean f58129h = false;

        @Override // p627s.AbstractC12656c
        /* renamed from: j */
        public void mo76189j(View view, float f10) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            Method method;
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(m70123a(f10));
                return;
            }
            if (this.f58129h) {
                return;
            }
            try {
                method = view.getClass().getMethod("setProgress", Float.TYPE);
            } catch (NoSuchMethodException unused) {
                this.f58129h = true;
                method = null;
            }
            if (method != null) {
                try {
                    method.invoke(view, Float.valueOf(m70123a(f10)));
                } catch (IllegalAccessException e10) {
                    Log.e("ViewOscillator", "unable to setProgress", e10);
                } catch (InvocationTargetException e11) {
                    Log.e("ViewOscillator", "unable to setProgress", e11);
                }
            }
        }
    }

    /* renamed from: s.c$f */
    public static class f extends AbstractC12656c {
        @Override // p627s.AbstractC12656c
        /* renamed from: j */
        public void mo76189j(View view, float f10) {
            view.setRotation(m70123a(f10));
        }
    }

    /* renamed from: s.c$g */
    public static class g extends AbstractC12656c {
        @Override // p627s.AbstractC12656c
        /* renamed from: j */
        public void mo76189j(View view, float f10) {
            view.setRotationX(m70123a(f10));
        }
    }

    /* renamed from: s.c$h */
    public static class h extends AbstractC12656c {
        @Override // p627s.AbstractC12656c
        /* renamed from: j */
        public void mo76189j(View view, float f10) {
            view.setRotationY(m70123a(f10));
        }
    }

    /* renamed from: s.c$i */
    public static class i extends AbstractC12656c {
        @Override // p627s.AbstractC12656c
        /* renamed from: j */
        public void mo76189j(View view, float f10) {
            view.setScaleX(m70123a(f10));
        }
    }

    /* renamed from: s.c$j */
    public static class j extends AbstractC12656c {
        @Override // p627s.AbstractC12656c
        /* renamed from: j */
        public void mo76189j(View view, float f10) {
            view.setScaleY(m70123a(f10));
        }
    }

    /* renamed from: s.c$k */
    public static class k extends AbstractC12656c {
        @Override // p627s.AbstractC12656c
        /* renamed from: j */
        public void mo76189j(View view, float f10) {
            view.setTranslationX(m70123a(f10));
        }
    }

    /* renamed from: s.c$l */
    public static class l extends AbstractC12656c {
        @Override // p627s.AbstractC12656c
        /* renamed from: j */
        public void mo76189j(View view, float f10) {
            view.setTranslationY(m70123a(f10));
        }
    }

    /* renamed from: s.c$m */
    public static class m extends AbstractC12656c {
        @Override // p627s.AbstractC12656c
        /* renamed from: j */
        public void mo76189j(View view, float f10) {
            view.setTranslationZ(m70123a(f10));
        }
    }

    /* renamed from: i */
    public static AbstractC12656c m76188i(String str) {
        if (str.startsWith("CUSTOM")) {
            return new b();
        }
        switch (str) {
            case "rotationX":
                return new g();
            case "rotationY":
                return new h();
            case "translationX":
                return new k();
            case "translationY":
                return new l();
            case "translationZ":
                return new m();
            case "progress":
                return new e();
            case "scaleX":
                return new i();
            case "scaleY":
                return new j();
            case "waveVariesBy":
                return new a();
            case "rotation":
                return new f();
            case "elevation":
                return new c();
            case "transitionPathRotate":
                return new d();
            case "alpha":
                return new a();
            case "waveOffset":
                return new a();
            default:
                return null;
        }
    }

    /* renamed from: j */
    public abstract void mo76189j(View view, float f10);
}
