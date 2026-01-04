package p306g2;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.os.ParcelFileDescriptor;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import p003a2.InterfaceC0007b;
import p003a2.InterfaceC0009d;
import p306g2.AbstractC9861m;
import p306g2.InterfaceC9868t;
import p630s2.C12672g;
import p630s2.C12676k;
import p630s2.C12677l;
import p759x1.C13683h;
import p759x1.C13684i;
import p759x1.EnumC13677b;
import p759x1.EnumC13685j;
import p829z1.InterfaceC14083v;

/* renamed from: g2.n */
/* loaded from: classes.dex */
public final class C9862n {

    /* renamed from: f */
    public static final C13683h<EnumC13677b> f48442f = C13683h.m82279f("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", EnumC13677b.f61603c);

    /* renamed from: g */
    public static final C13683h<EnumC13685j> f48443g = C13683h.m82278e("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace");

    /* renamed from: h */
    @Deprecated
    public static final C13683h<AbstractC9861m> f48444h = AbstractC9861m.f48437h;

    /* renamed from: i */
    public static final C13683h<Boolean> f48445i;

    /* renamed from: j */
    public static final C13683h<Boolean> f48446j;

    /* renamed from: k */
    public static final Set<String> f48447k;

    /* renamed from: l */
    public static final b f48448l;

    /* renamed from: m */
    public static final Set<ImageHeaderParser.ImageType> f48449m;

    /* renamed from: n */
    public static final Queue<BitmapFactory.Options> f48450n;

    /* renamed from: a */
    public final InterfaceC0009d f48451a;

    /* renamed from: b */
    public final DisplayMetrics f48452b;

    /* renamed from: c */
    public final InterfaceC0007b f48453c;

    /* renamed from: d */
    public final List<ImageHeaderParser> f48454d;

    /* renamed from: e */
    public final C9867s f48455e = C9867s.m61291b();

    /* renamed from: g2.n$a */
    public class a implements b {
        @Override // p306g2.C9862n.b
        /* renamed from: a */
        public void mo61285a(InterfaceC0009d interfaceC0009d, Bitmap bitmap) {
        }

        @Override // p306g2.C9862n.b
        /* renamed from: b */
        public void mo61286b() {
        }
    }

    /* renamed from: g2.n$b */
    public interface b {
        /* renamed from: a */
        void mo61285a(InterfaceC0009d interfaceC0009d, Bitmap bitmap) throws IOException;

        /* renamed from: b */
        void mo61286b();
    }

    static {
        Boolean bool = Boolean.FALSE;
        f48445i = C13683h.m82279f("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", bool);
        f48446j = C13683h.m82279f("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", bool);
        f48447k = Collections.unmodifiableSet(new HashSet(Arrays.asList("image/vnd.wap.wbmp", "image/x-ico")));
        f48448l = new a();
        f48449m = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
        f48450n = C12677l.m76282e(0);
    }

    public C9862n(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, InterfaceC0009d interfaceC0009d, InterfaceC0007b interfaceC0007b) {
        this.f48454d = list;
        this.f48452b = (DisplayMetrics) C12676k.m76276d(displayMetrics);
        this.f48451a = (InterfaceC0009d) C12676k.m76276d(interfaceC0009d);
        this.f48453c = (InterfaceC0007b) C12676k.m76276d(interfaceC0007b);
    }

    /* renamed from: a */
    public static int m61259a(double d10) {
        return m61273x((d10 / (r1 / r0)) * m61273x(m61264l(d10) * d10));
    }

    /* renamed from: c */
    public static void m61260c(ImageHeaderParser.ImageType imageType, InterfaceC9868t interfaceC9868t, b bVar, InterfaceC0009d interfaceC0009d, AbstractC9861m abstractC9861m, int i10, int i11, int i12, int i13, int i14, BitmapFactory.Options options) throws IOException {
        int i15;
        int i16;
        int iFloor;
        int iFloor2;
        if (i11 <= 0 || i12 <= 0) {
            if (Log.isLoggable("Downsampler", 3)) {
                Log.d("Downsampler", "Unable to determine dimensions for: " + imageType + " with target [" + i13 + Constants.MULTIPLE_SIGN + i14 + "]");
                return;
            }
            return;
        }
        if (m61267r(i10)) {
            i16 = i11;
            i15 = i12;
        } else {
            i15 = i11;
            i16 = i12;
        }
        float fMo61258b = abstractC9861m.mo61258b(i15, i16, i13, i14);
        if (fMo61258b <= 0.0f) {
            throw new IllegalArgumentException("Cannot scale with factor: " + fMo61258b + " from: " + abstractC9861m + ", source: [" + i11 + Constants.MULTIPLE_SIGN + i12 + "], target: [" + i13 + Constants.MULTIPLE_SIGN + i14 + "]");
        }
        AbstractC9861m.g gVarMo61257a = abstractC9861m.mo61257a(i15, i16, i13, i14);
        if (gVarMo61257a == null) {
            throw new IllegalArgumentException("Cannot round with null rounding");
        }
        float f10 = i15;
        float f11 = i16;
        int iM61273x = i15 / m61273x(fMo61258b * f10);
        int iM61273x2 = i16 / m61273x(fMo61258b * f11);
        AbstractC9861m.g gVar = AbstractC9861m.g.MEMORY;
        int iMax = Math.max(1, Integer.highestOneBit(gVarMo61257a == gVar ? Math.max(iM61273x, iM61273x2) : Math.min(iM61273x, iM61273x2)));
        if (gVarMo61257a == gVar && iMax < 1.0f / fMo61258b) {
            iMax <<= 1;
        }
        options.inSampleSize = iMax;
        if (imageType == ImageHeaderParser.ImageType.JPEG) {
            float fMin = Math.min(iMax, 8);
            iFloor = (int) Math.ceil(f10 / fMin);
            iFloor2 = (int) Math.ceil(f11 / fMin);
            int i17 = iMax / 8;
            if (i17 > 0) {
                iFloor /= i17;
                iFloor2 /= i17;
            }
        } else if (imageType == ImageHeaderParser.ImageType.PNG || imageType == ImageHeaderParser.ImageType.PNG_A) {
            float f12 = iMax;
            iFloor = (int) Math.floor(f10 / f12);
            iFloor2 = (int) Math.floor(f11 / f12);
        } else if (imageType.isWebp()) {
            float f13 = iMax;
            iFloor = Math.round(f10 / f13);
            iFloor2 = Math.round(f11 / f13);
        } else if (i15 % iMax == 0 && i16 % iMax == 0) {
            iFloor = i15 / iMax;
            iFloor2 = i16 / iMax;
        } else {
            int[] iArrM61265m = m61265m(interfaceC9868t, options, bVar, interfaceC0009d);
            iFloor = iArrM61265m[0];
            iFloor2 = iArrM61265m[1];
        }
        double dMo61258b = abstractC9861m.mo61258b(iFloor, iFloor2, i13, i14);
        options.inTargetDensity = m61259a(dMo61258b);
        options.inDensity = m61264l(dMo61258b);
        if (m61268s(options)) {
            options.inScaled = true;
        } else {
            options.inTargetDensity = 0;
            options.inDensity = 0;
        }
        if (Log.isLoggable("Downsampler", 2)) {
            Log.v("Downsampler", "Calculate scaling, source: [" + i11 + Constants.MULTIPLE_SIGN + i12 + "], degreesToRotate: " + i10 + ", target: [" + i13 + Constants.MULTIPLE_SIGN + i14 + "], power of two scaled: [" + iFloor + Constants.MULTIPLE_SIGN + iFloor2 + "], exact scale factor: " + fMo61258b + ", power of 2 sample size: " + iMax + ", adjusted scale factor: " + dMo61258b + ", target density: " + options.inTargetDensity + ", density: " + options.inDensity);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:?, code lost:
    
        throw r1;
     */
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap m61261i(p306g2.InterfaceC9868t r5, android.graphics.BitmapFactory.Options r6, p306g2.C9862n.b r7, p003a2.InterfaceC0009d r8) throws java.io.IOException {
        /*
            java.lang.String r0 = "Downsampler"
            boolean r1 = r6.inJustDecodeBounds
            if (r1 != 0) goto Lc
            r7.mo61286b()
            r5.mo61302c()
        Lc:
            int r1 = r6.outWidth
            int r2 = r6.outHeight
            java.lang.String r3 = r6.outMimeType
            java.util.concurrent.locks.Lock r4 = p306g2.C9848a0.m61216i()
            r4.lock()
            android.graphics.Bitmap r5 = r5.mo61301b(r6)     // Catch: java.lang.Throwable -> L25 java.lang.IllegalArgumentException -> L27
            java.util.concurrent.locks.Lock r6 = p306g2.C9848a0.m61216i()
            r6.unlock()
            return r5
        L25:
            r5 = move-exception
            goto L50
        L27:
            r4 = move-exception
            java.io.IOException r1 = m61270u(r4, r1, r2, r3, r6)     // Catch: java.lang.Throwable -> L25
            r2 = 3
            boolean r2 = android.util.Log.isLoggable(r0, r2)     // Catch: java.lang.Throwable -> L25
            if (r2 == 0) goto L38
            java.lang.String r2 = "Failed to decode with inBitmap, trying again without Bitmap re-use"
            android.util.Log.d(r0, r2, r1)     // Catch: java.lang.Throwable -> L25
        L38:
            android.graphics.Bitmap r0 = r6.inBitmap     // Catch: java.lang.Throwable -> L25
            if (r0 == 0) goto L4f
            r8.mo15b(r0)     // Catch: java.lang.Throwable -> L25 java.io.IOException -> L4e
            r0 = 0
            r6.inBitmap = r0     // Catch: java.lang.Throwable -> L25 java.io.IOException -> L4e
            android.graphics.Bitmap r5 = m61261i(r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L25 java.io.IOException -> L4e
            java.util.concurrent.locks.Lock r6 = p306g2.C9848a0.m61216i()
            r6.unlock()
            return r5
        L4e:
            throw r1     // Catch: java.lang.Throwable -> L25
        L4f:
            throw r1     // Catch: java.lang.Throwable -> L25
        L50:
            java.util.concurrent.locks.Lock r6 = p306g2.C9848a0.m61216i()
            r6.unlock()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p306g2.C9862n.m61261i(g2.t, android.graphics.BitmapFactory$Options, g2.n$b, a2.d):android.graphics.Bitmap");
    }

    @TargetApi(19)
    /* renamed from: j */
    public static String m61262j(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return "[" + bitmap.getWidth() + Constants.MULTIPLE_SIGN + bitmap.getHeight() + "] " + bitmap.getConfig() + (" (" + bitmap.getAllocationByteCount() + ")");
    }

    /* renamed from: k */
    public static synchronized BitmapFactory.Options m61263k() {
        BitmapFactory.Options optionsPoll;
        Queue<BitmapFactory.Options> queue = f48450n;
        synchronized (queue) {
            optionsPoll = queue.poll();
        }
        if (optionsPoll == null) {
            optionsPoll = new BitmapFactory.Options();
            m61272w(optionsPoll);
        }
        return optionsPoll;
    }

    /* renamed from: l */
    public static int m61264l(double d10) {
        if (d10 > 1.0d) {
            d10 = 1.0d / d10;
        }
        return (int) Math.round(d10 * 2.147483647E9d);
    }

    /* renamed from: m */
    public static int[] m61265m(InterfaceC9868t interfaceC9868t, BitmapFactory.Options options, b bVar, InterfaceC0009d interfaceC0009d) throws IOException {
        options.inJustDecodeBounds = true;
        m61261i(interfaceC9868t, options, bVar, interfaceC0009d);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    /* renamed from: n */
    public static String m61266n(BitmapFactory.Options options) {
        return m61262j(options.inBitmap);
    }

    /* renamed from: r */
    public static boolean m61267r(int i10) {
        return i10 == 90 || i10 == 270;
    }

    /* renamed from: s */
    public static boolean m61268s(BitmapFactory.Options options) {
        int i10;
        int i11 = options.inTargetDensity;
        return i11 > 0 && (i10 = options.inDensity) > 0 && i11 != i10;
    }

    /* renamed from: t */
    public static void m61269t(int i10, int i11, String str, BitmapFactory.Options options, Bitmap bitmap, int i12, int i13, long j10) {
        Log.v("Downsampler", "Decoded " + m61262j(bitmap) + " from [" + i10 + Constants.MULTIPLE_SIGN + i11 + "] " + str + " with inBitmap " + m61266n(options) + " for [" + i12 + Constants.MULTIPLE_SIGN + i13 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + C12672g.m76262a(j10));
    }

    /* renamed from: u */
    public static IOException m61270u(IllegalArgumentException illegalArgumentException, int i10, int i11, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i10 + ", outHeight: " + i11 + ", outMimeType: " + str + ", inBitmap: " + m61266n(options), illegalArgumentException);
    }

    /* renamed from: v */
    public static void m61271v(BitmapFactory.Options options) {
        m61272w(options);
        Queue<BitmapFactory.Options> queue = f48450n;
        synchronized (queue) {
            queue.offer(options);
        }
    }

    /* renamed from: w */
    public static void m61272w(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        options.inPreferredColorSpace = null;
        options.outColorSpace = null;
        options.outConfig = null;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    /* renamed from: x */
    public static int m61273x(double d10) {
        return (int) (d10 + 0.5d);
    }

    @TargetApi(26)
    /* renamed from: y */
    public static void m61274y(BitmapFactory.Options options, InterfaceC0009d interfaceC0009d, int i10, int i11) {
        Bitmap.Config config = options.inPreferredConfig;
        if (config == Bitmap.Config.HARDWARE) {
            return;
        }
        Bitmap.Config config2 = options.outConfig;
        if (config2 != null) {
            config = config2;
        }
        options.inBitmap = interfaceC0009d.mo17d(i10, i11, config);
    }

    /* renamed from: b */
    public final void m61275b(InterfaceC9868t interfaceC9868t, EnumC13677b enumC13677b, boolean z10, boolean z11, BitmapFactory.Options options, int i10, int i11) {
        if (this.f48455e.m61299i(i10, i11, options, z10, z11)) {
            return;
        }
        if (enumC13677b == EnumC13677b.PREFER_ARGB_8888) {
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            return;
        }
        try {
        } catch (IOException e10) {
            if (Log.isLoggable("Downsampler", 3)) {
                Log.d("Downsampler", "Cannot determine whether the image has alpha or not from header, format " + enumC13677b, e10);
            }
        }
        Bitmap.Config config = interfaceC9868t.mo61303d().hasAlpha() ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
        options.inPreferredConfig = config;
        if (config == Bitmap.Config.RGB_565) {
            options.inDither = true;
        }
    }

    /* renamed from: d */
    public InterfaceC14083v<Bitmap> m61276d(ParcelFileDescriptor parcelFileDescriptor, int i10, int i11, C13684i c13684i) throws IOException {
        return m61277e(new InterfaceC9868t.c(parcelFileDescriptor, this.f48454d, this.f48453c), i10, i11, c13684i, f48448l);
    }

    /* renamed from: e */
    public final InterfaceC14083v<Bitmap> m61277e(InterfaceC9868t interfaceC9868t, int i10, int i11, C13684i c13684i, b bVar) throws IOException {
        byte[] bArr = (byte[]) this.f48453c.mo10c(65536, byte[].class);
        BitmapFactory.Options optionsM61263k = m61263k();
        optionsM61263k.inTempStorage = bArr;
        EnumC13677b enumC13677b = (EnumC13677b) c13684i.m82284c(f48442f);
        EnumC13685j enumC13685j = (EnumC13685j) c13684i.m82284c(f48443g);
        AbstractC9861m abstractC9861m = (AbstractC9861m) c13684i.m82284c(AbstractC9861m.f48437h);
        boolean zBooleanValue = ((Boolean) c13684i.m82284c(f48445i)).booleanValue();
        C13683h<Boolean> c13683h = f48446j;
        try {
            return C9853e.m61232e(m61280h(interfaceC9868t, optionsM61263k, abstractC9861m, enumC13677b, enumC13685j, c13684i.m82284c(c13683h) != null && ((Boolean) c13684i.m82284c(c13683h)).booleanValue(), i10, i11, zBooleanValue, bVar), this.f48451a);
        } finally {
            m61271v(optionsM61263k);
            this.f48453c.put(bArr);
        }
    }

    /* renamed from: f */
    public InterfaceC14083v<Bitmap> m61278f(InputStream inputStream, int i10, int i11, C13684i c13684i, b bVar) throws IOException {
        return m61277e(new InterfaceC9868t.b(inputStream, this.f48454d, this.f48453c), i10, i11, c13684i, bVar);
    }

    /* renamed from: g */
    public InterfaceC14083v<Bitmap> m61279g(ByteBuffer byteBuffer, int i10, int i11, C13684i c13684i) throws IOException {
        return m61277e(new InterfaceC9868t.a(byteBuffer, this.f48454d, this.f48453c), i10, i11, c13684i, f48448l);
    }

    /* renamed from: h */
    public final Bitmap m61280h(InterfaceC9868t interfaceC9868t, BitmapFactory.Options options, AbstractC9861m abstractC9861m, EnumC13677b enumC13677b, EnumC13685j enumC13685j, boolean z10, int i10, int i11, boolean z11, b bVar) throws IOException {
        int i12;
        int i13;
        int i14;
        ColorSpace colorSpace;
        int iRound;
        int iRound2;
        long jM76263b = C12672g.m76263b();
        int[] iArrM61265m = m61265m(interfaceC9868t, options, bVar, this.f48451a);
        int i15 = iArrM61265m[0];
        int i16 = iArrM61265m[1];
        String str = options.outMimeType;
        boolean z12 = (i15 == -1 || i16 == -1) ? false : z10;
        int iMo61300a = interfaceC9868t.mo61300a();
        int iM61217j = C9848a0.m61217j(iMo61300a);
        boolean zM61220m = C9848a0.m61220m(iMo61300a);
        if (i10 == Integer.MIN_VALUE) {
            i12 = i11;
            i13 = m61267r(iM61217j) ? i16 : i15;
        } else {
            i12 = i11;
            i13 = i10;
        }
        int i17 = i12 == Integer.MIN_VALUE ? m61267r(iM61217j) ? i15 : i16 : i12;
        ImageHeaderParser.ImageType imageTypeMo61303d = interfaceC9868t.mo61303d();
        m61260c(imageTypeMo61303d, interfaceC9868t, bVar, this.f48451a, abstractC9861m, iM61217j, i15, i16, i13, i17, options);
        m61275b(interfaceC9868t, enumC13677b, z12, zM61220m, options, i13, i17);
        if (m61284z(imageTypeMo61303d)) {
            if (i15 < 0 || i16 < 0 || !z11) {
                float f10 = m61268s(options) ? options.inTargetDensity / options.inDensity : 1.0f;
                int i18 = options.inSampleSize;
                float f11 = i18;
                int iCeil = (int) Math.ceil(i15 / f11);
                int iCeil2 = (int) Math.ceil(i16 / f11);
                iRound = Math.round(iCeil * f10);
                iRound2 = Math.round(iCeil2 * f10);
                if (Log.isLoggable("Downsampler", 2)) {
                    Log.v("Downsampler", "Calculated target [" + iRound + Constants.MULTIPLE_SIGN + iRound2 + "] for source [" + i15 + Constants.MULTIPLE_SIGN + i16 + "], sampleSize: " + i18 + ", targetDensity: " + options.inTargetDensity + ", density: " + options.inDensity + ", density multiplier: " + f10);
                }
            } else {
                iRound = i13;
                iRound2 = i17;
            }
            if (iRound > 0 && iRound2 > 0) {
                m61274y(options, this.f48451a, iRound, iRound2);
            }
        }
        if (enumC13685j != null) {
            options.inPreferredColorSpace = ColorSpace.get((enumC13685j == EnumC13685j.DISPLAY_P3 && (colorSpace = options.outColorSpace) != null && colorSpace.isWideGamut()) ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB);
        }
        Bitmap bitmapM61261i = m61261i(interfaceC9868t, options, bVar, this.f48451a);
        bVar.mo61285a(this.f48451a, bitmapM61261i);
        if (Log.isLoggable("Downsampler", 2)) {
            i14 = iMo61300a;
            m61269t(i15, i16, str, options, bitmapM61261i, i10, i11, jM76263b);
        } else {
            i14 = iMo61300a;
        }
        if (bitmapM61261i == null) {
            return null;
        }
        bitmapM61261i.setDensity(this.f48452b.densityDpi);
        Bitmap bitmapM61221n = C9848a0.m61221n(this.f48451a, bitmapM61261i, i14);
        if (bitmapM61261i.equals(bitmapM61221n)) {
            return bitmapM61221n;
        }
        this.f48451a.mo15b(bitmapM61261i);
        return bitmapM61221n;
    }

    /* renamed from: o */
    public boolean m61281o(ParcelFileDescriptor parcelFileDescriptor) {
        return ParcelFileDescriptorRewinder.m9010c();
    }

    /* renamed from: p */
    public boolean m61282p(InputStream inputStream) {
        return true;
    }

    /* renamed from: q */
    public boolean m61283q(ByteBuffer byteBuffer) {
        return true;
    }

    /* renamed from: z */
    public final boolean m61284z(ImageHeaderParser.ImageType imageType) {
        return true;
    }
}
