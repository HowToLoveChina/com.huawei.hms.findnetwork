package p306g2;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import java.io.File;
import p003a2.InterfaceC0009d;
import p759x1.C13684i;
import p759x1.EnumC13678c;
import p759x1.InterfaceC13687l;
import p829z1.InterfaceC14083v;

/* renamed from: g2.b */
/* loaded from: classes.dex */
public class C9849b implements InterfaceC13687l<BitmapDrawable> {

    /* renamed from: a */
    public final InterfaceC0009d f48411a;

    /* renamed from: b */
    public final InterfaceC13687l<Bitmap> f48412b;

    public C9849b(InterfaceC0009d interfaceC0009d, InterfaceC13687l<Bitmap> interfaceC13687l) {
        this.f48411a = interfaceC0009d;
        this.f48412b = interfaceC13687l;
    }

    @Override // p759x1.InterfaceC13687l
    /* renamed from: a */
    public EnumC13678c mo61223a(C13684i c13684i) {
        return this.f48412b.mo61223a(c13684i);
    }

    @Override // p759x1.InterfaceC13679d
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean mo56815b(InterfaceC14083v<BitmapDrawable> interfaceC14083v, File file, C13684i c13684i) {
        return this.f48412b.mo56815b(new C9853e(interfaceC14083v.get().getBitmap(), this.f48411a), file, c13684i);
    }
}
