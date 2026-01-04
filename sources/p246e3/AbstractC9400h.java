package p246e3;

import android.animation.Animator;
import p002a1.AbstractC0002a;

/* renamed from: e3.h */
/* loaded from: classes.dex */
public abstract class AbstractC9400h<T extends Animator> {

    /* renamed from: a */
    public C9401i f46968a;

    /* renamed from: b */
    public final float[] f46969b;

    /* renamed from: c */
    public final int[] f46970c;

    public AbstractC9400h(int i10) {
        this.f46969b = new float[i10 * 2];
        this.f46970c = new int[i10];
    }

    /* renamed from: a */
    public abstract void mo58873a();

    /* renamed from: b */
    public float m58926b(int i10, int i11, int i12) {
        return (i10 - i11) / i12;
    }

    /* renamed from: c */
    public abstract void mo58874c();

    /* renamed from: d */
    public abstract void mo58875d(AbstractC0002a abstractC0002a);

    /* renamed from: e */
    public void m58927e(C9401i c9401i) {
        this.f46968a = c9401i;
    }

    /* renamed from: f */
    public abstract void mo58876f();

    /* renamed from: g */
    public abstract void mo58877g();

    /* renamed from: h */
    public abstract void mo58878h();
}
