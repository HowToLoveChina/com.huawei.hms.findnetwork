package com.bumptech.glide.load;

import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.huawei.feedback.constant.FeedbackConst;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import p003a2.InterfaceC0007b;
import p306g2.C9872x;
import p630s2.C12666a;

/* renamed from: com.bumptech.glide.load.a */
/* loaded from: classes.dex */
public final class C1558a {

    /* renamed from: com.bumptech.glide.load.a$a */
    public class a implements h {

        /* renamed from: a */
        public final /* synthetic */ InputStream f6927a;

        public a(InputStream inputStream) {
            this.f6927a = inputStream;
        }

        @Override // com.bumptech.glide.load.C1558a.h
        /* renamed from: a */
        public ImageHeaderParser.ImageType mo9008a(ImageHeaderParser imageHeaderParser) throws IOException {
            try {
                return imageHeaderParser.mo8997b(this.f6927a);
            } finally {
                this.f6927a.reset();
            }
        }
    }

    /* renamed from: com.bumptech.glide.load.a$b */
    public class b implements h {

        /* renamed from: a */
        public final /* synthetic */ ByteBuffer f6928a;

        public b(ByteBuffer byteBuffer) {
            this.f6928a = byteBuffer;
        }

        @Override // com.bumptech.glide.load.C1558a.h
        /* renamed from: a */
        public ImageHeaderParser.ImageType mo9008a(ImageHeaderParser imageHeaderParser) throws IOException {
            try {
                return imageHeaderParser.mo8996a(this.f6928a);
            } finally {
                C12666a.m76249d(this.f6928a);
            }
        }
    }

    /* renamed from: com.bumptech.glide.load.a$c */
    public class c implements h {

        /* renamed from: a */
        public final /* synthetic */ ParcelFileDescriptorRewinder f6929a;

        /* renamed from: b */
        public final /* synthetic */ InterfaceC0007b f6930b;

        public c(ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, InterfaceC0007b interfaceC0007b) {
            this.f6929a = parcelFileDescriptorRewinder;
            this.f6930b = interfaceC0007b;
        }

        @Override // com.bumptech.glide.load.C1558a.h
        /* renamed from: a */
        public ImageHeaderParser.ImageType mo9008a(ImageHeaderParser imageHeaderParser) throws Throwable {
            C9872x c9872x;
            C9872x c9872x2 = null;
            try {
                c9872x = new C9872x(new FileInputStream(this.f6929a.mo9011a().getFileDescriptor()), this.f6930b);
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                ImageHeaderParser.ImageType imageTypeMo8997b = imageHeaderParser.mo8997b(c9872x);
                c9872x.m61315t();
                this.f6929a.mo9011a();
                return imageTypeMo8997b;
            } catch (Throwable th3) {
                th = th3;
                c9872x2 = c9872x;
                if (c9872x2 != null) {
                    c9872x2.m61315t();
                }
                this.f6929a.mo9011a();
                throw th;
            }
        }
    }

    /* renamed from: com.bumptech.glide.load.a$d */
    public class d implements g {

        /* renamed from: a */
        public final /* synthetic */ ByteBuffer f6931a;

        /* renamed from: b */
        public final /* synthetic */ InterfaceC0007b f6932b;

        public d(ByteBuffer byteBuffer, InterfaceC0007b interfaceC0007b) {
            this.f6931a = byteBuffer;
            this.f6932b = interfaceC0007b;
        }

        @Override // com.bumptech.glide.load.C1558a.g
        /* renamed from: a */
        public int mo9009a(ImageHeaderParser imageHeaderParser) throws IOException {
            try {
                return imageHeaderParser.mo8999d(this.f6931a, this.f6932b);
            } finally {
                C12666a.m76249d(this.f6931a);
            }
        }
    }

    /* renamed from: com.bumptech.glide.load.a$e */
    public class e implements g {

        /* renamed from: a */
        public final /* synthetic */ InputStream f6933a;

        /* renamed from: b */
        public final /* synthetic */ InterfaceC0007b f6934b;

        public e(InputStream inputStream, InterfaceC0007b interfaceC0007b) {
            this.f6933a = inputStream;
            this.f6934b = interfaceC0007b;
        }

        @Override // com.bumptech.glide.load.C1558a.g
        /* renamed from: a */
        public int mo9009a(ImageHeaderParser imageHeaderParser) throws IOException {
            try {
                return imageHeaderParser.mo8998c(this.f6933a, this.f6934b);
            } finally {
                this.f6933a.reset();
            }
        }
    }

    /* renamed from: com.bumptech.glide.load.a$f */
    public class f implements g {

        /* renamed from: a */
        public final /* synthetic */ ParcelFileDescriptorRewinder f6935a;

        /* renamed from: b */
        public final /* synthetic */ InterfaceC0007b f6936b;

        public f(ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, InterfaceC0007b interfaceC0007b) {
            this.f6935a = parcelFileDescriptorRewinder;
            this.f6936b = interfaceC0007b;
        }

        @Override // com.bumptech.glide.load.C1558a.g
        /* renamed from: a */
        public int mo9009a(ImageHeaderParser imageHeaderParser) throws Throwable {
            C9872x c9872x;
            C9872x c9872x2 = null;
            try {
                c9872x = new C9872x(new FileInputStream(this.f6935a.mo9011a().getFileDescriptor()), this.f6936b);
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                int iMo8998c = imageHeaderParser.mo8998c(c9872x, this.f6936b);
                c9872x.m61315t();
                this.f6935a.mo9011a();
                return iMo8998c;
            } catch (Throwable th3) {
                th = th3;
                c9872x2 = c9872x;
                if (c9872x2 != null) {
                    c9872x2.m61315t();
                }
                this.f6935a.mo9011a();
                throw th;
            }
        }
    }

    /* renamed from: com.bumptech.glide.load.a$g */
    public interface g {
        /* renamed from: a */
        int mo9009a(ImageHeaderParser imageHeaderParser) throws IOException;
    }

    /* renamed from: com.bumptech.glide.load.a$h */
    public interface h {
        /* renamed from: a */
        ImageHeaderParser.ImageType mo9008a(ImageHeaderParser imageHeaderParser) throws IOException;
    }

    /* renamed from: a */
    public static int m9000a(List<ImageHeaderParser> list, ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, InterfaceC0007b interfaceC0007b) throws IOException {
        return m9003d(list, new f(parcelFileDescriptorRewinder, interfaceC0007b));
    }

    /* renamed from: b */
    public static int m9001b(List<ImageHeaderParser> list, InputStream inputStream, InterfaceC0007b interfaceC0007b) throws IOException {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new C9872x(inputStream, interfaceC0007b);
        }
        inputStream.mark(FeedbackConst.Mail.LOG_MAX_LENGTH);
        return m9003d(list, new e(inputStream, interfaceC0007b));
    }

    /* renamed from: c */
    public static int m9002c(List<ImageHeaderParser> list, ByteBuffer byteBuffer, InterfaceC0007b interfaceC0007b) throws IOException {
        if (byteBuffer == null) {
            return -1;
        }
        return m9003d(list, new d(byteBuffer, interfaceC0007b));
    }

    /* renamed from: d */
    public static int m9003d(List<ImageHeaderParser> list, g gVar) throws IOException {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            int iMo9009a = gVar.mo9009a(list.get(i10));
            if (iMo9009a != -1) {
                return iMo9009a;
            }
        }
        return -1;
    }

    /* renamed from: e */
    public static ImageHeaderParser.ImageType m9004e(List<ImageHeaderParser> list, ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, InterfaceC0007b interfaceC0007b) throws IOException {
        return m9007h(list, new c(parcelFileDescriptorRewinder, interfaceC0007b));
    }

    /* renamed from: f */
    public static ImageHeaderParser.ImageType m9005f(List<ImageHeaderParser> list, InputStream inputStream, InterfaceC0007b interfaceC0007b) throws IOException {
        if (inputStream == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new C9872x(inputStream, interfaceC0007b);
        }
        inputStream.mark(FeedbackConst.Mail.LOG_MAX_LENGTH);
        return m9007h(list, new a(inputStream));
    }

    /* renamed from: g */
    public static ImageHeaderParser.ImageType m9006g(List<ImageHeaderParser> list, ByteBuffer byteBuffer) throws IOException {
        return byteBuffer == null ? ImageHeaderParser.ImageType.UNKNOWN : m9007h(list, new b(byteBuffer));
    }

    /* renamed from: h */
    public static ImageHeaderParser.ImageType m9007h(List<ImageHeaderParser> list, h hVar) throws IOException {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            ImageHeaderParser.ImageType imageTypeMo9008a = hVar.mo9008a(list.get(i10));
            if (imageTypeMo9008a != ImageHeaderParser.ImageType.UNKNOWN) {
                return imageTypeMo9008a;
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }
}
