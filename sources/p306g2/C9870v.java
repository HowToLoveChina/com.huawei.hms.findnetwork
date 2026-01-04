package p306g2;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import p630s2.C12676k;
import p829z1.InterfaceC14079r;
import p829z1.InterfaceC14083v;

/* renamed from: g2.v */
/* loaded from: classes.dex */
public final class C9870v implements InterfaceC14083v<BitmapDrawable>, InterfaceC14079r {

    /* renamed from: a */
    public final Resources f48481a;

    /* renamed from: b */
    public final InterfaceC14083v<Bitmap> f48482b;

    public C9870v(Resources resources, InterfaceC14083v<Bitmap> interfaceC14083v) {
        this.f48481a = (Resources) C12676k.m76276d(resources);
        this.f48482b = (InterfaceC14083v) C12676k.m76276d(interfaceC14083v);
    }

    /* renamed from: e */
    public static InterfaceC14083v<BitmapDrawable> m61307e(Resources resources, InterfaceC14083v<Bitmap> interfaceC14083v) {
        if (interfaceC14083v == null) {
            return null;
        }
        return new C9870v(resources, interfaceC14083v);
    }

    @Override // p829z1.InterfaceC14083v
    /* renamed from: a */
    public void mo60254a() {
        this.f48482b.mo60254a();
    }

    @Override // p829z1.InterfaceC14079r
    /* renamed from: b */
    public void mo61233b() {
        InterfaceC14083v<Bitmap> interfaceC14083v = this.f48482b;
        if (interfaceC14083v instanceof InterfaceC14079r) {
            ((InterfaceC14079r) interfaceC14083v).mo61233b();
        }
    }

    @Override // p829z1.InterfaceC14083v
    /* renamed from: c */
    public Class<BitmapDrawable> mo60255c() {
        return BitmapDrawable.class;
    }

    @Override // p829z1.InterfaceC14083v
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public BitmapDrawable get() {
        return new BitmapDrawable(this.f48481a, this.f48482b.get());
    }

    @Override // p829z1.InterfaceC14083v
    public int getSize() {
        return this.f48482b.getSize();
    }
}
