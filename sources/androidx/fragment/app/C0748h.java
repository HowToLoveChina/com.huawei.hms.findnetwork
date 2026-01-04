package androidx.fragment.app;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import androidx.fragment.R$animator;
import androidx.fragment.R$id;
import p273f0.ViewTreeObserverOnPreDrawListenerC9595e0;

/* renamed from: androidx.fragment.app.h */
/* loaded from: classes.dex */
public class C0748h {
    /* renamed from: a */
    public static int m4775a(Fragment fragment, boolean z10, boolean z11) {
        return z11 ? z10 ? fragment.m4345F() : fragment.m4347G() : z10 ? fragment.m4429q() : fragment.m4438t();
    }

    /* renamed from: b */
    public static a m4776b(Context context, Fragment fragment, boolean z10, boolean z11) throws Resources.NotFoundException {
        int iM4336B = fragment.m4336B();
        int iM4775a = m4775a(fragment, z10, z11);
        fragment.m4434r1(0, 0, 0, 0);
        ViewGroup viewGroup = fragment.f3703H;
        if (viewGroup != null) {
            int i10 = R$id.visible_removing_fragment_view_tag;
            if (viewGroup.getTag(i10) != null) {
                fragment.f3703H.setTag(i10, null);
            }
        }
        ViewGroup viewGroup2 = fragment.f3703H;
        if (viewGroup2 != null && viewGroup2.getLayoutTransition() != null) {
            return null;
        }
        Animation animationM4418m0 = fragment.m4418m0(iM4336B, z10, iM4775a);
        if (animationM4418m0 != null) {
            return new a(animationM4418m0);
        }
        Animator animatorM4421n0 = fragment.m4421n0(iM4336B, z10, iM4775a);
        if (animatorM4421n0 != null) {
            return new a(animatorM4421n0);
        }
        if (iM4775a == 0 && iM4336B != 0) {
            iM4775a = m4778d(context, iM4336B, z10);
        }
        if (iM4775a != 0) {
            boolean zEquals = "anim".equals(context.getResources().getResourceTypeName(iM4775a));
            if (zEquals) {
                try {
                    Animation animationLoadAnimation = AnimationUtils.loadAnimation(context, iM4775a);
                    if (animationLoadAnimation != null) {
                        return new a(animationLoadAnimation);
                    }
                } catch (Resources.NotFoundException e10) {
                    throw e10;
                } catch (RuntimeException unused) {
                }
            } else {
                try {
                    Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(context, iM4775a);
                    if (animatorLoadAnimator != null) {
                        return new a(animatorLoadAnimator);
                    }
                } catch (RuntimeException e11) {
                    if (zEquals) {
                        throw e11;
                    }
                    Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(context, iM4775a);
                    if (animationLoadAnimation2 != null) {
                        return new a(animationLoadAnimation2);
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: c */
    public static int m4777c(Context context, int i10) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(R.style.Animation.Activity, new int[]{i10});
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    /* renamed from: d */
    public static int m4778d(Context context, int i10, boolean z10) {
        if (i10 == 4097) {
            return z10 ? R$animator.fragment_open_enter : R$animator.fragment_open_exit;
        }
        if (i10 == 8194) {
            return z10 ? R$animator.fragment_close_enter : R$animator.fragment_close_exit;
        }
        if (i10 == 8197) {
            return z10 ? m4777c(context, R.attr.activityCloseEnterAnimation) : m4777c(context, R.attr.activityCloseExitAnimation);
        }
        if (i10 == 4099) {
            return z10 ? R$animator.fragment_fade_enter : R$animator.fragment_fade_exit;
        }
        if (i10 != 4100) {
            return -1;
        }
        return z10 ? m4777c(context, R.attr.activityOpenEnterAnimation) : m4777c(context, R.attr.activityOpenExitAnimation);
    }

    /* renamed from: androidx.fragment.app.h$a */
    public static class a {

        /* renamed from: a */
        public final Animation f4050a;

        /* renamed from: b */
        public final Animator f4051b;

        public a(Animation animation) {
            this.f4050a = animation;
            this.f4051b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        public a(Animator animator) {
            this.f4050a = null;
            this.f4051b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    /* renamed from: androidx.fragment.app.h$b */
    public static class b extends AnimationSet implements Runnable {

        /* renamed from: a */
        public final ViewGroup f4052a;

        /* renamed from: b */
        public final View f4053b;

        /* renamed from: c */
        public boolean f4054c;

        /* renamed from: d */
        public boolean f4055d;

        /* renamed from: e */
        public boolean f4056e;

        public b(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f4056e = true;
            this.f4052a = viewGroup;
            this.f4053b = view;
            addAnimation(animation);
            viewGroup.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j10, Transformation transformation) {
            this.f4056e = true;
            if (this.f4054c) {
                return !this.f4055d;
            }
            if (!super.getTransformation(j10, transformation)) {
                this.f4054c = true;
                ViewTreeObserverOnPreDrawListenerC9595e0.m59820a(this.f4052a, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f4054c || !this.f4056e) {
                this.f4052a.endViewTransition(this.f4053b);
                this.f4055d = true;
            } else {
                this.f4056e = false;
                this.f4052a.post(this);
            }
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j10, Transformation transformation, float f10) {
            this.f4056e = true;
            if (this.f4054c) {
                return !this.f4055d;
            }
            if (!super.getTransformation(j10, transformation, f10)) {
                this.f4054c = true;
                ViewTreeObserverOnPreDrawListenerC9595e0.m59820a(this.f4052a, this);
            }
            return true;
        }
    }
}
