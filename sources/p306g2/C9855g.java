package p306g2;

import android.graphics.Bitmap;
import java.io.IOException;
import java.nio.ByteBuffer;
import p759x1.C13684i;
import p759x1.InterfaceC13686k;
import p829z1.InterfaceC14083v;

/* renamed from: g2.g */
/* loaded from: classes.dex */
public class C9855g implements InterfaceC13686k<ByteBuffer, Bitmap> {

    /* renamed from: a */
    public final C9862n f48420a;

    public C9855g(C9862n c9862n) {
        this.f48420a = c9862n;
    }

    @Override // p759x1.InterfaceC13686k
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public InterfaceC14083v<Bitmap> mo9147b(ByteBuffer byteBuffer, int i10, int i11, C13684i c13684i) throws IOException {
        return this.f48420a.m61279g(byteBuffer, i10, i11, c13684i);
    }

    @Override // p759x1.InterfaceC13686k
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean mo9146a(ByteBuffer byteBuffer, C13684i c13684i) {
        return this.f48420a.m61283q(byteBuffer);
    }
}
