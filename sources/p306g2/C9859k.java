package p306g2;

import android.graphics.Bitmap;
import java.security.MessageDigest;
import p003a2.InterfaceC0009d;
import p759x1.InterfaceC13681f;

/* renamed from: g2.k */
/* loaded from: classes.dex */
public class C9859k extends AbstractC9854f {

    /* renamed from: b */
    public static final byte[] f48424b = "com.bumptech.glide.load.resource.bitmap.CircleCrop.1".getBytes(InterfaceC13681f.f61610a);

    @Override // p759x1.InterfaceC13681f
    /* renamed from: a */
    public void mo56817a(MessageDigest messageDigest) {
        messageDigest.update(f48424b);
    }

    @Override // p306g2.AbstractC9854f
    /* renamed from: c */
    public Bitmap mo61235c(InterfaceC0009d interfaceC0009d, Bitmap bitmap, int i10, int i11) {
        return C9848a0.m61211d(interfaceC0009d, bitmap, i10, i11);
    }

    @Override // p759x1.InterfaceC13681f
    public boolean equals(Object obj) {
        return obj instanceof C9859k;
    }

    @Override // p759x1.InterfaceC13681f
    public int hashCode() {
        return 1101716364;
    }
}
