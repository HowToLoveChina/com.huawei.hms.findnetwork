package p441l2;

import android.graphics.Bitmap;
import java.io.ByteArrayOutputStream;
import p324h2.C10088b;
import p759x1.C13684i;
import p829z1.InterfaceC14083v;

/* renamed from: l2.a */
/* loaded from: classes.dex */
public class C11222a implements InterfaceC11225d<Bitmap, byte[]> {

    /* renamed from: a */
    public final Bitmap.CompressFormat f52709a;

    /* renamed from: b */
    public final int f52710b;

    public C11222a() {
        this(Bitmap.CompressFormat.JPEG, 100);
    }

    @Override // p441l2.InterfaceC11225d
    /* renamed from: a */
    public InterfaceC14083v<byte[]> mo9169a(InterfaceC14083v<Bitmap> interfaceC14083v, C13684i c13684i) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        interfaceC14083v.get().compress(this.f52709a, this.f52710b, byteArrayOutputStream);
        interfaceC14083v.mo60254a();
        return new C10088b(byteArrayOutputStream.toByteArray());
    }

    public C11222a(Bitmap.CompressFormat compressFormat, int i10) {
        this.f52709a = compressFormat;
        this.f52710b = i10;
    }
}
