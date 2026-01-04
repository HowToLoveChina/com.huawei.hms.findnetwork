package p666u2;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

/* renamed from: u2.i */
/* loaded from: classes.dex */
public class C13118i {

    /* renamed from: a */
    public long f59612a;

    /* renamed from: b */
    public long f59613b;

    /* renamed from: c */
    public TimeInterpolator f59614c;

    /* renamed from: d */
    public int f59615d;

    /* renamed from: e */
    public int f59616e;

    public C13118i(long j10, long j11) {
        this.f59614c = null;
        this.f59615d = 0;
        this.f59616e = 1;
        this.f59612a = j10;
        this.f59613b = j11;
    }

    /* renamed from: b */
    public static C13118i m78909b(ValueAnimator valueAnimator) {
        C13118i c13118i = new C13118i(valueAnimator.getStartDelay(), valueAnimator.getDuration(), m78910f(valueAnimator));
        c13118i.f59615d = valueAnimator.getRepeatCount();
        c13118i.f59616e = valueAnimator.getRepeatMode();
        return c13118i;
    }

    /* renamed from: f */
    public static TimeInterpolator m78910f(ValueAnimator valueAnimator) {
        TimeInterpolator interpolator = valueAnimator.getInterpolator();
        return ((interpolator instanceof AccelerateDecelerateInterpolator) || interpolator == null) ? C13110a.f59598b : interpolator instanceof AccelerateInterpolator ? C13110a.f59599c : interpolator instanceof DecelerateInterpolator ? C13110a.f59600d : interpolator;
    }

    /* renamed from: a */
    public void m78911a(Animator animator) {
        animator.setStartDelay(m78912c());
        animator.setDuration(m78913d());
        animator.setInterpolator(m78914e());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(m78915g());
            valueAnimator.setRepeatMode(m78916h());
        }
    }

    /* renamed from: c */
    public long m78912c() {
        return this.f59612a;
    }

    /* renamed from: d */
    public long m78913d() {
        return this.f59613b;
    }

    /* renamed from: e */
    public TimeInterpolator m78914e() {
        TimeInterpolator timeInterpolator = this.f59614c;
        return timeInterpolator != null ? timeInterpolator : C13110a.f59598b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C13118i)) {
            return false;
        }
        C13118i c13118i = (C13118i) obj;
        if (m78912c() == c13118i.m78912c() && m78913d() == c13118i.m78913d() && m78915g() == c13118i.m78915g() && m78916h() == c13118i.m78916h()) {
            return m78914e().getClass().equals(c13118i.m78914e().getClass());
        }
        return false;
    }

    /* renamed from: g */
    public int m78915g() {
        return this.f59615d;
    }

    /* renamed from: h */
    public int m78916h() {
        return this.f59616e;
    }

    public int hashCode() {
        return (((((((((int) (m78912c() ^ (m78912c() >>> 32))) * 31) + ((int) (m78913d() ^ (m78913d() >>> 32)))) * 31) + m78914e().getClass().hashCode()) * 31) + m78915g()) * 31) + m78916h();
    }

    public String toString() {
        return '\n' + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + m78912c() + " duration: " + m78913d() + " interpolator: " + m78914e().getClass() + " repeatCount: " + m78915g() + " repeatMode: " + m78916h() + "}\n";
    }

    public C13118i(long j10, long j11, TimeInterpolator timeInterpolator) {
        this.f59615d = 0;
        this.f59616e = 1;
        this.f59612a = j10;
        this.f59613b = j11;
        this.f59614c = timeInterpolator;
    }
}
