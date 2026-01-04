package p355i2;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import p415k2.C10973b;
import p630s2.C12676k;
import p829z1.InterfaceC14079r;
import p829z1.InterfaceC14083v;

/* renamed from: i2.c */
/* loaded from: classes.dex */
public abstract class AbstractC10417c<T extends Drawable> implements InterfaceC14083v<T>, InterfaceC14079r {

    /* renamed from: a */
    public final T f50252a;

    public AbstractC10417c(T t10) {
        this.f50252a = (T) C12676k.m76276d(t10);
    }

    @Override // p829z1.InterfaceC14079r
    /* renamed from: b */
    public void mo61233b() {
        T t10 = this.f50252a;
        if (t10 instanceof BitmapDrawable) {
            ((BitmapDrawable) t10).getBitmap().prepareToDraw();
        } else if (t10 instanceof C10973b) {
            ((C10973b) t10).m66307e().prepareToDraw();
        }
    }

    @Override // p829z1.InterfaceC14083v
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public final T get() {
        Drawable.ConstantState constantState = this.f50252a.getConstantState();
        return constantState == null ? this.f50252a : (T) constantState.newDrawable();
    }
}
