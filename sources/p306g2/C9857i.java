package p306g2;

import android.graphics.Bitmap;
import java.security.MessageDigest;
import p003a2.InterfaceC0009d;
import p759x1.InterfaceC13681f;

/* renamed from: g2.i */
/* loaded from: classes.dex */
public class C9857i extends AbstractC9854f {

    /* renamed from: b */
    public static final byte[] f48422b = "com.bumptech.glide.load.resource.bitmap.CenterCrop".getBytes(InterfaceC13681f.f61610a);

    @Override // p759x1.InterfaceC13681f
    /* renamed from: a */
    public void mo56817a(MessageDigest messageDigest) {
        messageDigest.update(f48422b);
    }

    @Override // p306g2.AbstractC9854f
    /* renamed from: c */
    public Bitmap mo61235c(InterfaceC0009d interfaceC0009d, Bitmap bitmap, int i10, int i11) {
        return C9848a0.m61209b(interfaceC0009d, bitmap, i10, i11);
    }

    @Override // p759x1.InterfaceC13681f
    public boolean equals(Object obj) {
        return obj instanceof C9857i;
    }

    @Override // p759x1.InterfaceC13681f
    public int hashCode() {
        return -599754482;
    }
}
