package p306g2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.C1558a;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.C1570k;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import p003a2.InterfaceC0007b;
import p630s2.C12666a;
import p630s2.C12676k;

/* renamed from: g2.t */
/* loaded from: classes.dex */
public interface InterfaceC9868t {

    /* renamed from: g2.t$a */
    public static final class a implements InterfaceC9868t {

        /* renamed from: a */
        public final ByteBuffer f48471a;

        /* renamed from: b */
        public final List<ImageHeaderParser> f48472b;

        /* renamed from: c */
        public final InterfaceC0007b f48473c;

        public a(ByteBuffer byteBuffer, List<ImageHeaderParser> list, InterfaceC0007b interfaceC0007b) {
            this.f48471a = byteBuffer;
            this.f48472b = list;
            this.f48473c = interfaceC0007b;
        }

        @Override // p306g2.InterfaceC9868t
        /* renamed from: a */
        public int mo61300a() throws IOException {
            return C1558a.m9002c(this.f48472b, C12666a.m76249d(this.f48471a), this.f48473c);
        }

        @Override // p306g2.InterfaceC9868t
        /* renamed from: b */
        public Bitmap mo61301b(BitmapFactory.Options options) {
            return BitmapFactory.decodeStream(m61304e(), null, options);
        }

        @Override // p306g2.InterfaceC9868t
        /* renamed from: c */
        public void mo61302c() {
        }

        @Override // p306g2.InterfaceC9868t
        /* renamed from: d */
        public ImageHeaderParser.ImageType mo61303d() throws IOException {
            return C1558a.m9006g(this.f48472b, C12666a.m76249d(this.f48471a));
        }

        /* renamed from: e */
        public final InputStream m61304e() {
            return C12666a.m76252g(C12666a.m76249d(this.f48471a));
        }
    }

    /* renamed from: g2.t$b */
    public static final class b implements InterfaceC9868t {

        /* renamed from: a */
        public final C1570k f48474a;

        /* renamed from: b */
        public final InterfaceC0007b f48475b;

        /* renamed from: c */
        public final List<ImageHeaderParser> f48476c;

        public b(InputStream inputStream, List<ImageHeaderParser> list, InterfaceC0007b interfaceC0007b) {
            this.f48475b = (InterfaceC0007b) C12676k.m76276d(interfaceC0007b);
            this.f48476c = (List) C12676k.m76276d(list);
            this.f48474a = new C1570k(inputStream, interfaceC0007b);
        }

        @Override // p306g2.InterfaceC9868t
        /* renamed from: a */
        public int mo61300a() throws IOException {
            return C1558a.m9001b(this.f48476c, this.f48474a.mo9011a(), this.f48475b);
        }

        @Override // p306g2.InterfaceC9868t
        /* renamed from: b */
        public Bitmap mo61301b(BitmapFactory.Options options) throws IOException {
            return BitmapFactory.decodeStream(this.f48474a.mo9011a(), null, options);
        }

        @Override // p306g2.InterfaceC9868t
        /* renamed from: c */
        public void mo61302c() {
            this.f48474a.m9045c();
        }

        @Override // p306g2.InterfaceC9868t
        /* renamed from: d */
        public ImageHeaderParser.ImageType mo61303d() throws IOException {
            return C1558a.m9005f(this.f48476c, this.f48474a.mo9011a(), this.f48475b);
        }
    }

    /* renamed from: g2.t$c */
    public static final class c implements InterfaceC9868t {

        /* renamed from: a */
        public final InterfaceC0007b f48477a;

        /* renamed from: b */
        public final List<ImageHeaderParser> f48478b;

        /* renamed from: c */
        public final ParcelFileDescriptorRewinder f48479c;

        public c(ParcelFileDescriptor parcelFileDescriptor, List<ImageHeaderParser> list, InterfaceC0007b interfaceC0007b) {
            this.f48477a = (InterfaceC0007b) C12676k.m76276d(interfaceC0007b);
            this.f48478b = (List) C12676k.m76276d(list);
            this.f48479c = new ParcelFileDescriptorRewinder(parcelFileDescriptor);
        }

        @Override // p306g2.InterfaceC9868t
        /* renamed from: a */
        public int mo61300a() throws IOException {
            return C1558a.m9000a(this.f48478b, this.f48479c, this.f48477a);
        }

        @Override // p306g2.InterfaceC9868t
        /* renamed from: b */
        public Bitmap mo61301b(BitmapFactory.Options options) throws IOException {
            return BitmapFactory.decodeFileDescriptor(this.f48479c.mo9011a().getFileDescriptor(), null, options);
        }

        @Override // p306g2.InterfaceC9868t
        /* renamed from: c */
        public void mo61302c() {
        }

        @Override // p306g2.InterfaceC9868t
        /* renamed from: d */
        public ImageHeaderParser.ImageType mo61303d() throws IOException {
            return C1558a.m9004e(this.f48478b, this.f48479c, this.f48477a);
        }
    }

    /* renamed from: a */
    int mo61300a() throws IOException;

    /* renamed from: b */
    Bitmap mo61301b(BitmapFactory.Options options) throws IOException;

    /* renamed from: c */
    void mo61302c();

    /* renamed from: d */
    ImageHeaderParser.ImageType mo61303d() throws IOException;
}
