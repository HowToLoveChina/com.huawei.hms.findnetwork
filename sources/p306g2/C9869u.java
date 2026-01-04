package p306g2;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import java.io.IOException;
import java.io.InputStream;
import p630s2.C12666a;
import p759x1.C13684i;
import p759x1.InterfaceC13686k;
import p829z1.InterfaceC14083v;

/* renamed from: g2.u */
/* loaded from: classes.dex */
public final class C9869u implements InterfaceC13686k<InputStream, Bitmap> {

    /* renamed from: a */
    public final C9852d f48480a = new C9852d();

    @Override // p759x1.InterfaceC13686k
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public InterfaceC14083v<Bitmap> mo9147b(InputStream inputStream, int i10, int i11, C13684i c13684i) throws IOException {
        return this.f48480a.mo9147b(ImageDecoder.createSource(C12666a.m76247b(inputStream)), i10, i11, c13684i);
    }

    @Override // p759x1.InterfaceC13686k
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean mo9146a(InputStream inputStream, C13684i c13684i) throws IOException {
        return true;
    }
}
