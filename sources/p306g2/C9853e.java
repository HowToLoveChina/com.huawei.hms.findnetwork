package p306g2;

import android.graphics.Bitmap;
import p003a2.InterfaceC0009d;
import p630s2.C12676k;
import p630s2.C12677l;
import p829z1.InterfaceC14079r;
import p829z1.InterfaceC14083v;

/* renamed from: g2.e */
/* loaded from: classes.dex */
public class C9853e implements InterfaceC14083v<Bitmap>, InterfaceC14079r {

    /* renamed from: a */
    public final Bitmap f48418a;

    /* renamed from: b */
    public final InterfaceC0009d f48419b;

    public C9853e(Bitmap bitmap, InterfaceC0009d interfaceC0009d) {
        this.f48418a = (Bitmap) C12676k.m76277e(bitmap, "Bitmap must not be null");
        this.f48419b = (InterfaceC0009d) C12676k.m76277e(interfaceC0009d, "BitmapPool must not be null");
    }

    /* renamed from: e */
    public static C9853e m61232e(Bitmap bitmap, InterfaceC0009d interfaceC0009d) {
        if (bitmap == null) {
            return null;
        }
        return new C9853e(bitmap, interfaceC0009d);
    }

    @Override // p829z1.InterfaceC14083v
    /* renamed from: a */
    public void mo60254a() {
        this.f48419b.mo15b(this.f48418a);
    }

    @Override // p829z1.InterfaceC14079r
    /* renamed from: b */
    public void mo61233b() {
        this.f48418a.prepareToDraw();
    }

    @Override // p829z1.InterfaceC14083v
    /* renamed from: c */
    public Class<Bitmap> mo60255c() {
        return Bitmap.class;
    }

    @Override // p829z1.InterfaceC14083v
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Bitmap get() {
        return this.f48418a;
    }

    @Override // p829z1.InterfaceC14083v
    public int getSize() {
        return C12677l.m76284g(this.f48418a);
    }
}
