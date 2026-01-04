package p008a7;

import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;

/* renamed from: a7.c */
/* loaded from: classes2.dex */
public class C0056c {

    /* renamed from: d */
    public float f196d;

    /* renamed from: h */
    public View f200h;

    /* renamed from: a */
    public float f193a = 0.0f;

    /* renamed from: b */
    public float f194b = 0.0f;

    /* renamed from: c */
    public float f195c = 0.0f;

    /* renamed from: e */
    public boolean f197e = false;

    /* renamed from: f */
    public boolean f198f = false;

    /* renamed from: g */
    public boolean f199g = false;

    /* renamed from: a7.c$a */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            C0056c c0056c = C0056c.this;
            c0056c.f196d = Math.min(1.0f, c0056c.f200h.getTranslationY() / C0056c.this.f200h.getHeight());
            C0056c.m397c(C0056c.this);
        }
    }

    public C0056c(View view, InterfaceC0058e interfaceC0058e) {
        this.f200h = view;
    }

    /* renamed from: c */
    public static /* synthetic */ InterfaceC0058e m397c(C0056c c0056c) {
        c0056c.getClass();
        return null;
    }

    /* renamed from: d */
    public final void m398d(Float f10, Float f11) {
        this.f196d = Math.min(1.0f, f11.floatValue() / this.f200h.getHeight());
    }

    /* renamed from: e */
    public final void m399e(Float f10, Float f11) {
        this.f196d = Math.min(1.0f, f11.floatValue() / this.f200h.getHeight());
    }

    /* renamed from: f */
    public void m400f(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f198f = false;
        }
        if (!this.f198f) {
            this.f198f = motionEvent.getPointerCount() >= 2;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                if (this.f198f) {
                    return;
                }
                if (this.f194b == 0.0f) {
                    this.f194b = motionEvent.getRawX();
                }
                if (this.f195c == 0.0f) {
                    this.f195c = motionEvent.getRawY();
                }
                float rawX = motionEvent.getRawX() - this.f194b;
                float rawY = motionEvent.getRawY() - this.f195c;
                if (this.f199g || Float.compare(Math.abs(rawY) - Math.abs(rawX), 10.0f) >= 0) {
                    if (rawY > 0.0f) {
                        this.f197e = true;
                        this.f199g = true;
                        m398d(Float.valueOf(rawX), Float.valueOf(rawY));
                        return;
                    } else {
                        if (this.f197e) {
                            this.f199g = true;
                            m399e(Float.valueOf(rawX), Float.valueOf(rawY));
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            if (actionMasked != 3) {
                return;
            }
        }
        m404j();
    }

    /* renamed from: g */
    public boolean m401g() {
        return this.f199g;
    }

    /* renamed from: h */
    public void m402h(float f10) {
        this.f193a = f10;
    }

    /* renamed from: i */
    public void m403i(InterfaceC0058e interfaceC0058e) {
    }

    /* renamed from: j */
    public final void m404j() {
        this.f197e = false;
        this.f199g = false;
        this.f198f = true;
        this.f194b = 0.0f;
        this.f195c = 0.0f;
        if (this.f200h.getTranslationY() <= this.f193a) {
            this.f200h.animate().translationX(0.0f).translationY(0.0f).scaleX(1.0f).scaleY(1.0f).setDuration(200L).setUpdateListener(new a()).start();
        } else {
            this.f200h.animate().translationX(0.0f).translationY(0.0f).scaleX(1.0f).scaleY(1.0f).setDuration(200L).start();
            this.f196d = 0.0f;
        }
    }
}
