package p355i2;

import android.graphics.drawable.Drawable;
import p829z1.InterfaceC14083v;

/* renamed from: i2.d */
/* loaded from: classes.dex */
public final class C10418d extends AbstractC10417c<Drawable> {
    public C10418d(Drawable drawable) {
        super(drawable);
    }

    /* renamed from: e */
    public static InterfaceC14083v<Drawable> m63963e(Drawable drawable) {
        if (drawable != null) {
            return new C10418d(drawable);
        }
        return null;
    }

    @Override // p829z1.InterfaceC14083v
    /* renamed from: a */
    public void mo60254a() {
    }

    @Override // p829z1.InterfaceC14083v
    /* renamed from: c */
    public Class<Drawable> mo60255c() {
        return this.f50252a.getClass();
    }

    @Override // p829z1.InterfaceC14083v
    public int getSize() {
        return Math.max(1, this.f50252a.getIntrinsicWidth() * this.f50252a.getIntrinsicHeight() * 4);
    }
}
