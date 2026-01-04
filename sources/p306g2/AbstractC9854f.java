package p306g2;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.ComponentCallbacks2C1546b;
import p003a2.InterfaceC0009d;
import p630s2.C12677l;
import p759x1.InterfaceC13688m;
import p829z1.InterfaceC14083v;

/* renamed from: g2.f */
/* loaded from: classes.dex */
public abstract class AbstractC9854f implements InterfaceC13688m<Bitmap> {
    @Override // p759x1.InterfaceC13688m
    /* renamed from: b */
    public final InterfaceC14083v<Bitmap> mo60257b(Context context, InterfaceC14083v<Bitmap> interfaceC14083v, int i10, int i11) {
        if (!C12677l.m76296s(i10, i11)) {
            throw new IllegalArgumentException("Cannot apply transformation on width: " + i10 + " or height: " + i11 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
        }
        InterfaceC0009d interfaceC0009dM8907f = ComponentCallbacks2C1546b.m8898c(context).m8907f();
        Bitmap bitmap = interfaceC14083v.get();
        if (i10 == Integer.MIN_VALUE) {
            i10 = bitmap.getWidth();
        }
        if (i11 == Integer.MIN_VALUE) {
            i11 = bitmap.getHeight();
        }
        Bitmap bitmapMo61235c = mo61235c(interfaceC0009dM8907f, bitmap, i10, i11);
        return bitmap.equals(bitmapMo61235c) ? interfaceC14083v : C9853e.m61232e(bitmapMo61235c, interfaceC0009dM8907f);
    }

    /* renamed from: c */
    public abstract Bitmap mo61235c(InterfaceC0009d interfaceC0009d, Bitmap bitmap, int i10, int i11);
}
