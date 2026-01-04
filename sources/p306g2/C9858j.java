package p306g2;

import android.graphics.Bitmap;
import java.security.MessageDigest;
import p003a2.InterfaceC0009d;
import p759x1.InterfaceC13681f;

/* renamed from: g2.j */
/* loaded from: classes.dex */
public class C9858j extends AbstractC9854f {

    /* renamed from: b */
    public static final byte[] f48423b = "com.bumptech.glide.load.resource.bitmap.CenterInside".getBytes(InterfaceC13681f.f61610a);

    @Override // p759x1.InterfaceC13681f
    /* renamed from: a */
    public void mo56817a(MessageDigest messageDigest) {
        messageDigest.update(f48423b);
    }

    @Override // p306g2.AbstractC9854f
    /* renamed from: c */
    public Bitmap mo61235c(InterfaceC0009d interfaceC0009d, Bitmap bitmap, int i10, int i11) {
        return C9848a0.m61210c(interfaceC0009d, bitmap, i10, i11);
    }

    @Override // p759x1.InterfaceC13681f
    public boolean equals(Object obj) {
        return obj instanceof C9858j;
    }

    @Override // p759x1.InterfaceC13681f
    public int hashCode() {
        return -670243078;
    }
}
