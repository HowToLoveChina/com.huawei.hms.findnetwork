package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import p003a2.InterfaceC0009d;
import p306g2.AbstractC9861m;
import p306g2.C9853e;
import p759x1.C13683h;
import p759x1.C13684i;
import p759x1.InterfaceC13686k;
import p829z1.InterfaceC14083v;

/* renamed from: com.bumptech.glide.load.resource.bitmap.a */
/* loaded from: classes.dex */
public class C1599a<T> implements InterfaceC13686k<T, Bitmap> {

    /* renamed from: d */
    public static final C13683h<Long> f7080d = C13683h.m82276a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new a());

    /* renamed from: e */
    public static final C13683h<Integer> f7081e = C13683h.m82276a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new b());

    /* renamed from: f */
    public static final e f7082f = new e();

    /* renamed from: g */
    public static final List<String> f7083g = Collections.unmodifiableList(Arrays.asList("TP1A", "TD1A.220804.031"));

    /* renamed from: a */
    public final f<T> f7084a;

    /* renamed from: b */
    public final InterfaceC0009d f7085b;

    /* renamed from: c */
    public final e f7086c;

    /* renamed from: com.bumptech.glide.load.resource.bitmap.a$a */
    public class a implements C13683h.b<Long> {

        /* renamed from: a */
        public final ByteBuffer f7087a = ByteBuffer.allocate(8);

        @Override // p759x1.C13683h.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void mo9148a(byte[] bArr, Long l10, MessageDigest messageDigest) {
            messageDigest.update(bArr);
            synchronized (this.f7087a) {
                this.f7087a.position(0);
                messageDigest.update(this.f7087a.putLong(l10.longValue()).array());
            }
        }
    }

    /* renamed from: com.bumptech.glide.load.resource.bitmap.a$b */
    public class b implements C13683h.b<Integer> {

        /* renamed from: a */
        public final ByteBuffer f7088a = ByteBuffer.allocate(4);

        @Override // p759x1.C13683h.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void mo9148a(byte[] bArr, Integer num, MessageDigest messageDigest) {
            if (num == null) {
                return;
            }
            messageDigest.update(bArr);
            synchronized (this.f7088a) {
                this.f7088a.position(0);
                messageDigest.update(this.f7088a.putInt(num.intValue()).array());
            }
        }
    }

    /* renamed from: com.bumptech.glide.load.resource.bitmap.a$c */
    public static final class c implements f<AssetFileDescriptor> {
        public c() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.C1599a.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void mo9151a(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) throws IllegalArgumentException {
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    /* renamed from: com.bumptech.glide.load.resource.bitmap.a$d */
    public static final class d implements f<ByteBuffer> {

        /* renamed from: com.bumptech.glide.load.resource.bitmap.a$d$a */
        public class a extends MediaDataSource {

            /* renamed from: a */
            public final /* synthetic */ ByteBuffer f7089a;

            public a(ByteBuffer byteBuffer) {
                this.f7089a = byteBuffer;
            }

            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // android.media.MediaDataSource
            public long getSize() {
                return this.f7089a.limit();
            }

            @Override // android.media.MediaDataSource
            public int readAt(long j10, byte[] bArr, int i10, int i11) {
                if (j10 >= this.f7089a.limit()) {
                    return -1;
                }
                this.f7089a.position((int) j10);
                int iMin = Math.min(i11, this.f7089a.remaining());
                this.f7089a.get(bArr, i10, iMin);
                return iMin;
            }
        }

        @Override // com.bumptech.glide.load.resource.bitmap.C1599a.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void mo9151a(MediaMetadataRetriever mediaMetadataRetriever, ByteBuffer byteBuffer) throws IllegalArgumentException {
            mediaMetadataRetriever.setDataSource(new a(byteBuffer));
        }
    }

    /* renamed from: com.bumptech.glide.load.resource.bitmap.a$e */
    public static class e {
        /* renamed from: a */
        public MediaMetadataRetriever m9154a() {
            return new MediaMetadataRetriever();
        }
    }

    /* renamed from: com.bumptech.glide.load.resource.bitmap.a$f */
    public interface f<T> {
        /* renamed from: a */
        void mo9151a(MediaMetadataRetriever mediaMetadataRetriever, T t10);
    }

    /* renamed from: com.bumptech.glide.load.resource.bitmap.a$g */
    public static final class g implements f<ParcelFileDescriptor> {
        @Override // com.bumptech.glide.load.resource.bitmap.C1599a.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void mo9151a(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) throws IllegalArgumentException {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }

    /* renamed from: com.bumptech.glide.load.resource.bitmap.a$h */
    public static final class h extends RuntimeException {
        private static final long serialVersionUID = -2556382523004027815L;

        public h() {
            super("MediaMetadataRetriever failed to retrieve a frame without throwing, check the adb logs for .*MetadataRetriever.* prior to this exception for details");
        }
    }

    public C1599a(InterfaceC0009d interfaceC0009d, f<T> fVar) {
        this(interfaceC0009d, fVar, f7082f);
    }

    /* renamed from: c */
    public static InterfaceC13686k<AssetFileDescriptor, Bitmap> m9136c(InterfaceC0009d interfaceC0009d) {
        return new C1599a(interfaceC0009d, new c(null));
    }

    /* renamed from: d */
    public static InterfaceC13686k<ByteBuffer, Bitmap> m9137d(InterfaceC0009d interfaceC0009d) {
        return new C1599a(interfaceC0009d, new d());
    }

    /* renamed from: e */
    public static Bitmap m9138e(MediaMetadataRetriever mediaMetadataRetriever, Bitmap bitmap) {
        if (!m9143j()) {
            return bitmap;
        }
        try {
            if (m9142i(mediaMetadataRetriever)) {
                if (Math.abs(Integer.parseInt(mediaMetadataRetriever.extractMetadata(24))) == 180) {
                    if (Log.isLoggable("VideoDecoder", 3)) {
                        Log.d("VideoDecoder", "Applying HDR 180 deg thumbnail correction");
                    }
                    Matrix matrix = new Matrix();
                    matrix.postRotate(180.0f, bitmap.getWidth() / 2.0f, bitmap.getHeight() / 2.0f);
                    return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                }
            }
        } catch (NumberFormatException unused) {
            if (Log.isLoggable("VideoDecoder", 3)) {
                Log.d("VideoDecoder", "Exception trying to extract HDR transfer function or rotation");
            }
        }
        return bitmap;
    }

    /* renamed from: f */
    public static Bitmap m9139f(MediaMetadataRetriever mediaMetadataRetriever, long j10, int i10, int i11, int i12, AbstractC9861m abstractC9861m) {
        Bitmap bitmapM9141h = (i11 == Integer.MIN_VALUE || i12 == Integer.MIN_VALUE || abstractC9861m == AbstractC9861m.f48435f) ? null : m9141h(mediaMetadataRetriever, j10, i10, i11, i12, abstractC9861m);
        if (bitmapM9141h == null) {
            bitmapM9141h = m9140g(mediaMetadataRetriever, j10, i10);
        }
        Bitmap bitmapM9138e = m9138e(mediaMetadataRetriever, bitmapM9141h);
        if (bitmapM9138e != null) {
            return bitmapM9138e;
        }
        throw new h();
    }

    /* renamed from: g */
    public static Bitmap m9140g(MediaMetadataRetriever mediaMetadataRetriever, long j10, int i10) {
        return mediaMetadataRetriever.getFrameAtTime(j10, i10);
    }

    @TargetApi(27)
    /* renamed from: h */
    public static Bitmap m9141h(MediaMetadataRetriever mediaMetadataRetriever, long j10, int i10, int i11, int i12, AbstractC9861m abstractC9861m) {
        try {
            int i13 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int i14 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            int i15 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            if (i15 == 90 || i15 == 270) {
                i14 = i13;
                i13 = i14;
            }
            float fMo61258b = abstractC9861m.mo61258b(i13, i14, i11, i12);
            return mediaMetadataRetriever.getScaledFrameAtTime(j10, i10, Math.round(i13 * fMo61258b), Math.round(fMo61258b * i14));
        } catch (Throwable th2) {
            if (!Log.isLoggable("VideoDecoder", 3)) {
                return null;
            }
            Log.d("VideoDecoder", "Exception trying to decode a scaled frame on oreo+, falling back to a fullsize frame", th2);
            return null;
        }
    }

    /* renamed from: i */
    public static boolean m9142i(MediaMetadataRetriever mediaMetadataRetriever) throws NumberFormatException {
        String strExtractMetadata = mediaMetadataRetriever.extractMetadata(36);
        String strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(35);
        int i10 = Integer.parseInt(strExtractMetadata);
        return (i10 == 7 || i10 == 6) && Integer.parseInt(strExtractMetadata2) == 6;
    }

    /* renamed from: j */
    public static boolean m9143j() {
        if (Build.MODEL.startsWith("Pixel") && Build.VERSION.SDK_INT == 33) {
            return m9144k();
        }
        int i10 = Build.VERSION.SDK_INT;
        return i10 >= 30 && i10 < 33;
    }

    /* renamed from: k */
    public static boolean m9144k() {
        Iterator<String> it = f7083g.iterator();
        while (it.hasNext()) {
            if (Build.ID.startsWith(it.next())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: l */
    public static InterfaceC13686k<ParcelFileDescriptor, Bitmap> m9145l(InterfaceC0009d interfaceC0009d) {
        return new C1599a(interfaceC0009d, new g());
    }

    @Override // p759x1.InterfaceC13686k
    /* renamed from: a */
    public boolean mo9146a(T t10, C13684i c13684i) {
        return true;
    }

    @Override // p759x1.InterfaceC13686k
    /* renamed from: b */
    public InterfaceC14083v<Bitmap> mo9147b(T t10, int i10, int i11, C13684i c13684i) throws IOException {
        long jLongValue = ((Long) c13684i.m82284c(f7080d)).longValue();
        if (jLongValue < 0 && jLongValue != -1) {
            throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + jLongValue);
        }
        Integer num = (Integer) c13684i.m82284c(f7081e);
        if (num == null) {
            num = 2;
        }
        AbstractC9861m abstractC9861m = (AbstractC9861m) c13684i.m82284c(AbstractC9861m.f48437h);
        if (abstractC9861m == null) {
            abstractC9861m = AbstractC9861m.f48436g;
        }
        AbstractC9861m abstractC9861m2 = abstractC9861m;
        MediaMetadataRetriever mediaMetadataRetrieverM9154a = this.f7086c.m9154a();
        try {
            this.f7084a.mo9151a(mediaMetadataRetrieverM9154a, t10);
            Bitmap bitmapM9139f = m9139f(mediaMetadataRetrieverM9154a, jLongValue, num.intValue(), i10, i11, abstractC9861m2);
            mediaMetadataRetrieverM9154a.close();
            return C9853e.m61232e(bitmapM9139f, this.f7085b);
        } catch (Throwable th2) {
            mediaMetadataRetrieverM9154a.close();
            throw th2;
        }
    }

    public C1599a(InterfaceC0009d interfaceC0009d, f<T> fVar, e eVar) {
        this.f7085b = interfaceC0009d;
        this.f7084a = fVar;
        this.f7086c = eVar;
    }
}
