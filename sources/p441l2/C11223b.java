package p441l2;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import p003a2.InterfaceC0009d;
import p306g2.C9853e;
import p415k2.C10973b;
import p759x1.C13684i;
import p829z1.InterfaceC14083v;

/* renamed from: l2.b */
/* loaded from: classes.dex */
public final class C11223b implements InterfaceC11225d<Drawable, byte[]> {

    /* renamed from: a */
    public final InterfaceC0009d f52711a;

    /* renamed from: b */
    public final InterfaceC11225d<Bitmap, byte[]> f52712b;

    /* renamed from: c */
    public final InterfaceC11225d<C10973b, byte[]> f52713c;

    public C11223b(InterfaceC0009d interfaceC0009d, InterfaceC11225d<Bitmap, byte[]> interfaceC11225d, InterfaceC11225d<C10973b, byte[]> interfaceC11225d2) {
        this.f52711a = interfaceC0009d;
        this.f52712b = interfaceC11225d;
        this.f52713c = interfaceC11225d2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    public static InterfaceC14083v<C10973b> m67415b(InterfaceC14083v<Drawable> interfaceC14083v) {
        return interfaceC14083v;
    }

    @Override // p441l2.InterfaceC11225d
    /* renamed from: a */
    public InterfaceC14083v<byte[]> mo9169a(InterfaceC14083v<Drawable> interfaceC14083v, C13684i c13684i) {
        Drawable drawable = interfaceC14083v.get();
        if (drawable instanceof BitmapDrawable) {
            return this.f52712b.mo9169a(C9853e.m61232e(((BitmapDrawable) drawable).getBitmap(), this.f52711a), c13684i);
        }
        if (drawable instanceof C10973b) {
            return this.f52713c.mo9169a(m67415b(interfaceC14083v), c13684i);
        }
        return null;
    }
}
