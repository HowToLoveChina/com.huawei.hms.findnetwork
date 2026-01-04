package p306g2;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import java.io.IOException;
import java.nio.ByteBuffer;
import p759x1.C13684i;
import p759x1.InterfaceC13686k;
import p829z1.InterfaceC14083v;

/* renamed from: g2.h */
/* loaded from: classes.dex */
public final class C9856h implements InterfaceC13686k<ByteBuffer, Bitmap> {

    /* renamed from: a */
    public final C9852d f48421a = new C9852d();

    @Override // p759x1.InterfaceC13686k
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public InterfaceC14083v<Bitmap> mo9147b(ByteBuffer byteBuffer, int i10, int i11, C13684i c13684i) throws IOException {
        return this.f48421a.mo9147b(ImageDecoder.createSource(byteBuffer), i10, i11, c13684i);
    }

    @Override // p759x1.InterfaceC13686k
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean mo9146a(ByteBuffer byteBuffer, C13684i c13684i) throws IOException {
        return true;
    }
}
