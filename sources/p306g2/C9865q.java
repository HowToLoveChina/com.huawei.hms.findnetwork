package p306g2;

import com.bumptech.glide.load.ImageHeaderParser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import p003a2.InterfaceC0007b;
import p505o0.C11784a;
import p630s2.C12666a;

/* renamed from: g2.q */
/* loaded from: classes.dex */
public final class C9865q implements ImageHeaderParser {
    @Override // com.bumptech.glide.load.ImageHeaderParser
    /* renamed from: a */
    public ImageHeaderParser.ImageType mo8996a(ByteBuffer byteBuffer) {
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    /* renamed from: b */
    public ImageHeaderParser.ImageType mo8997b(InputStream inputStream) {
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    /* renamed from: c */
    public int mo8998c(InputStream inputStream, InterfaceC0007b interfaceC0007b) throws IOException {
        int iM70201c = new C11784a(inputStream).m70201c("Orientation", 1);
        if (iM70201c == 0) {
            return -1;
        }
        return iM70201c;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    /* renamed from: d */
    public int mo8999d(ByteBuffer byteBuffer, InterfaceC0007b interfaceC0007b) throws IOException {
        return mo8998c(C12666a.m76252g(byteBuffer), interfaceC0007b);
    }
}
