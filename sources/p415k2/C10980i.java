package p415k2;

import android.util.Log;
import com.bumptech.glide.load.C1558a;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import p003a2.InterfaceC0007b;
import p759x1.C13684i;
import p759x1.InterfaceC13686k;
import p829z1.InterfaceC14083v;

/* renamed from: k2.i */
/* loaded from: classes.dex */
public class C10980i implements InterfaceC13686k<InputStream, C10973b> {

    /* renamed from: a */
    public final List<ImageHeaderParser> f52037a;

    /* renamed from: b */
    public final InterfaceC13686k<ByteBuffer, C10973b> f52038b;

    /* renamed from: c */
    public final InterfaceC0007b f52039c;

    public C10980i(List<ImageHeaderParser> list, InterfaceC13686k<ByteBuffer, C10973b> interfaceC13686k, InterfaceC0007b interfaceC0007b) {
        this.f52037a = list;
        this.f52038b = interfaceC13686k;
        this.f52039c = interfaceC0007b;
    }

    /* renamed from: e */
    public static byte[] m66343e(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int i10 = inputStream.read(bArr);
                if (i10 == -1) {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, i10);
            }
        } catch (IOException e10) {
            if (!Log.isLoggable("StreamGifDecoder", 5)) {
                return null;
            }
            Log.w("StreamGifDecoder", "Error reading data from stream", e10);
            return null;
        }
    }

    @Override // p759x1.InterfaceC13686k
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public InterfaceC14083v<C10973b> mo9147b(InputStream inputStream, int i10, int i11, C13684i c13684i) throws IOException {
        byte[] bArrM66343e = m66343e(inputStream);
        if (bArrM66343e == null) {
            return null;
        }
        return this.f52038b.mo9147b(ByteBuffer.wrap(bArrM66343e), i10, i11, c13684i);
    }

    @Override // p759x1.InterfaceC13686k
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean mo9146a(InputStream inputStream, C13684i c13684i) throws IOException {
        return !((Boolean) c13684i.m82284c(C10979h.f52036b)).booleanValue() && C1558a.m9005f(this.f52037a, inputStream, this.f52039c) == ImageHeaderParser.ImageType.GIF;
    }
}
