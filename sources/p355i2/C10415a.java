package p355i2;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.C1558a;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import p003a2.InterfaceC0007b;
import p275f2.C9644a;
import p630s2.C12666a;
import p630s2.C12677l;
import p759x1.C13684i;
import p759x1.InterfaceC13686k;
import p829z1.InterfaceC14083v;

/* renamed from: i2.a */
/* loaded from: classes.dex */
public final class C10415a {

    /* renamed from: a */
    public final List<ImageHeaderParser> f50246a;

    /* renamed from: b */
    public final InterfaceC0007b f50247b;

    /* renamed from: i2.a$a */
    public static final class a implements InterfaceC14083v<Drawable> {

        /* renamed from: a */
        public final AnimatedImageDrawable f50248a;

        public a(AnimatedImageDrawable animatedImageDrawable) {
            this.f50248a = animatedImageDrawable;
        }

        @Override // p829z1.InterfaceC14083v
        /* renamed from: a */
        public void mo60254a() {
            this.f50248a.stop();
            this.f50248a.clearAnimationCallbacks();
        }

        @Override // p829z1.InterfaceC14083v
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AnimatedImageDrawable get() {
            return this.f50248a;
        }

        @Override // p829z1.InterfaceC14083v
        /* renamed from: c */
        public Class<Drawable> mo60255c() {
            return Drawable.class;
        }

        @Override // p829z1.InterfaceC14083v
        public int getSize() {
            return this.f50248a.getIntrinsicWidth() * this.f50248a.getIntrinsicHeight() * C12677l.m76285h(Bitmap.Config.ARGB_8888) * 2;
        }
    }

    /* renamed from: i2.a$b */
    public static final class b implements InterfaceC13686k<ByteBuffer, Drawable> {

        /* renamed from: a */
        public final C10415a f50249a;

        public b(C10415a c10415a) {
            this.f50249a = c10415a;
        }

        @Override // p759x1.InterfaceC13686k
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public InterfaceC14083v<Drawable> mo9147b(ByteBuffer byteBuffer, int i10, int i11, C13684i c13684i) throws IOException {
            return this.f50249a.m63948b(ImageDecoder.createSource(byteBuffer), i10, i11, c13684i);
        }

        @Override // p759x1.InterfaceC13686k
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean mo9146a(ByteBuffer byteBuffer, C13684i c13684i) throws IOException {
            return this.f50249a.m63950d(byteBuffer);
        }
    }

    /* renamed from: i2.a$c */
    public static final class c implements InterfaceC13686k<InputStream, Drawable> {

        /* renamed from: a */
        public final C10415a f50250a;

        public c(C10415a c10415a) {
            this.f50250a = c10415a;
        }

        @Override // p759x1.InterfaceC13686k
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public InterfaceC14083v<Drawable> mo9147b(InputStream inputStream, int i10, int i11, C13684i c13684i) throws IOException {
            return this.f50250a.m63948b(ImageDecoder.createSource(C12666a.m76247b(inputStream)), i10, i11, c13684i);
        }

        @Override // p759x1.InterfaceC13686k
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean mo9146a(InputStream inputStream, C13684i c13684i) throws IOException {
            return this.f50250a.m63949c(inputStream);
        }
    }

    public C10415a(List<ImageHeaderParser> list, InterfaceC0007b interfaceC0007b) {
        this.f50246a = list;
        this.f50247b = interfaceC0007b;
    }

    /* renamed from: a */
    public static InterfaceC13686k<ByteBuffer, Drawable> m63946a(List<ImageHeaderParser> list, InterfaceC0007b interfaceC0007b) {
        return new b(new C10415a(list, interfaceC0007b));
    }

    /* renamed from: f */
    public static InterfaceC13686k<InputStream, Drawable> m63947f(List<ImageHeaderParser> list, InterfaceC0007b interfaceC0007b) {
        return new c(new C10415a(list, interfaceC0007b));
    }

    /* renamed from: b */
    public InterfaceC14083v<Drawable> m63948b(ImageDecoder.Source source, int i10, int i11, C13684i c13684i) throws IOException {
        Drawable drawableDecodeDrawable = ImageDecoder.decodeDrawable(source, new C9644a(i10, i11, c13684i));
        if (drawableDecodeDrawable instanceof AnimatedImageDrawable) {
            return new a((AnimatedImageDrawable) drawableDecodeDrawable);
        }
        throw new IOException("Received unexpected drawable type for animated webp, failing: " + drawableDecodeDrawable);
    }

    /* renamed from: c */
    public boolean m63949c(InputStream inputStream) throws IOException {
        return m63951e(C1558a.m9005f(this.f50246a, inputStream, this.f50247b));
    }

    /* renamed from: d */
    public boolean m63950d(ByteBuffer byteBuffer) throws IOException {
        return m63951e(C1558a.m9006g(this.f50246a, byteBuffer));
    }

    /* renamed from: e */
    public final boolean m63951e(ImageHeaderParser.ImageType imageType) {
        return imageType == ImageHeaderParser.ImageType.ANIMATED_WEBP;
    }
}
