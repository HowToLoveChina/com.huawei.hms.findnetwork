package com.bumptech.glide.load;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import p003a2.InterfaceC0007b;

/* loaded from: classes.dex */
public interface ImageHeaderParser {

    public enum ImageType {
        GIF(true),
        JPEG(false),
        RAW(false),
        PNG_A(true),
        PNG(false),
        WEBP_A(true),
        WEBP(false),
        ANIMATED_WEBP(true),
        AVIF(true),
        UNKNOWN(false);


        /* renamed from: a */
        public final boolean f6925a;

        ImageType(boolean z10) {
            this.f6925a = z10;
        }

        public boolean hasAlpha() {
            return this.f6925a;
        }

        public boolean isWebp() {
            int i10 = C1557a.f6926a[ordinal()];
            return i10 == 1 || i10 == 2 || i10 == 3;
        }
    }

    /* renamed from: com.bumptech.glide.load.ImageHeaderParser$a */
    public static /* synthetic */ class C1557a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f6926a;

        static {
            int[] iArr = new int[ImageType.values().length];
            f6926a = iArr;
            try {
                iArr[ImageType.WEBP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6926a[ImageType.WEBP_A.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6926a[ImageType.ANIMATED_WEBP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* renamed from: a */
    ImageType mo8996a(ByteBuffer byteBuffer) throws IOException;

    /* renamed from: b */
    ImageType mo8997b(InputStream inputStream) throws IOException;

    /* renamed from: c */
    int mo8998c(InputStream inputStream, InterfaceC0007b interfaceC0007b) throws IOException;

    /* renamed from: d */
    int mo8999d(ByteBuffer byteBuffer, InterfaceC0007b interfaceC0007b) throws IOException;
}
