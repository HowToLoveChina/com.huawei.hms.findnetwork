package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.ComponentCallbacks2C1546b;
import com.bumptech.glide.load.C1558a;
import com.bumptech.glide.load.ImageHeaderParser;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;
import p003a2.InterfaceC0007b;
import p003a2.InterfaceC0009d;
import p275f2.C9646c;
import p415k2.C10972a;
import p415k2.C10973b;
import p415k2.C10975d;
import p415k2.C10979h;
import p630s2.C12672g;
import p630s2.C12677l;
import p725w1.C13518c;
import p725w1.C13519d;
import p725w1.C13520e;
import p725w1.InterfaceC13516a;
import p759x1.C13684i;
import p759x1.EnumC13677b;
import p759x1.InterfaceC13686k;

/* loaded from: classes.dex */
public class ByteBufferGifDecoder implements InterfaceC13686k<ByteBuffer, C10973b> {

    /* renamed from: f */
    public static final C1600a f7093f = new C1600a();

    /* renamed from: g */
    public static final C1601b f7094g = new C1601b();

    /* renamed from: a */
    public final Context f7095a;

    /* renamed from: b */
    public final List<ImageHeaderParser> f7096b;

    /* renamed from: c */
    public final C1601b f7097c;

    /* renamed from: d */
    public final C1600a f7098d;

    /* renamed from: e */
    public final C10972a f7099e;

    /* renamed from: com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder$a */
    public static class C1600a {
        /* renamed from: a */
        public InterfaceC13516a m9166a(InterfaceC13516a.a aVar, C13518c c13518c, ByteBuffer byteBuffer, int i10) {
            return new C13520e(aVar, c13518c, byteBuffer, i10);
        }
    }

    /* renamed from: com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder$b */
    public static class C1601b {

        /* renamed from: a */
        public final Queue<C13519d> f7100a = C12677l.m76282e(0);

        /* renamed from: a */
        public synchronized C13519d m9167a(ByteBuffer byteBuffer) {
            C13519d c13519dPoll;
            try {
                c13519dPoll = this.f7100a.poll();
                if (c13519dPoll == null) {
                    c13519dPoll = new C13519d();
                }
            } catch (Throwable th2) {
                throw th2;
            }
            return c13519dPoll.m81303p(byteBuffer);
        }

        /* renamed from: b */
        public synchronized void m9168b(C13519d c13519d) {
            c13519d.m81288a();
            this.f7100a.offer(c13519d);
        }
    }

    public ByteBufferGifDecoder(Context context) {
        this(context, ComponentCallbacks2C1546b.m8898c(context).m8911j().m8937g(), ComponentCallbacks2C1546b.m8898c(context).m8907f(), ComponentCallbacks2C1546b.m8898c(context).m8906e());
    }

    /* renamed from: e */
    public static int m9162e(C13518c c13518c, int i10, int i11) {
        int iMin = Math.min(c13518c.m81284a() / i11, c13518c.m81287d() / i10);
        int iMax = Math.max(1, iMin == 0 ? 0 : Integer.highestOneBit(iMin));
        if (Log.isLoggable("BufferGifDecoder", 2) && iMax > 1) {
            Log.v("BufferGifDecoder", "Downsampling GIF, sampleSize: " + iMax + ", target dimens: [" + i10 + Constants.MULTIPLE_SIGN + i11 + "], actual dimens: [" + c13518c.m81287d() + Constants.MULTIPLE_SIGN + c13518c.m81284a() + "]");
        }
        return iMax;
    }

    /* renamed from: c */
    public final C10975d m9163c(ByteBuffer byteBuffer, int i10, int i11, C13519d c13519d, C13684i c13684i) {
        long jM76263b = C12672g.m76263b();
        try {
            C13518c c13518cM81290c = c13519d.m81290c();
            if (c13518cM81290c.m81285b() > 0 && c13518cM81290c.m81286c() == 0) {
                Bitmap.Config config = c13684i.m82284c(C10979h.f52035a) == EnumC13677b.PREFER_RGB_565 ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888;
                InterfaceC13516a interfaceC13516aM9166a = this.f7098d.m9166a(this.f7099e, c13518cM81290c, byteBuffer, m9162e(c13518cM81290c, i10, i11));
                interfaceC13516aM9166a.mo81280e(config);
                interfaceC13516aM9166a.mo81277b();
                Bitmap bitmapMo81276a = interfaceC13516aM9166a.mo81276a();
                if (bitmapMo81276a == null) {
                    if (Log.isLoggable("BufferGifDecoder", 2)) {
                        Log.v("BufferGifDecoder", "Decoded GIF from stream in " + C12672g.m76262a(jM76263b));
                    }
                    return null;
                }
                C10975d c10975d = new C10975d(new C10973b(this.f7095a, interfaceC13516aM9166a, C9646c.m60256c(), i10, i11, bitmapMo81276a));
                if (Log.isLoggable("BufferGifDecoder", 2)) {
                    Log.v("BufferGifDecoder", "Decoded GIF from stream in " + C12672g.m76262a(jM76263b));
                }
                return c10975d;
            }
            return null;
        } finally {
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                Log.v("BufferGifDecoder", "Decoded GIF from stream in " + C12672g.m76262a(jM76263b));
            }
        }
    }

    @Override // p759x1.InterfaceC13686k
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C10975d mo9147b(ByteBuffer byteBuffer, int i10, int i11, C13684i c13684i) {
        C13519d c13519dM9167a = this.f7097c.m9167a(byteBuffer);
        try {
            return m9163c(byteBuffer, i10, i11, c13519dM9167a, c13684i);
        } finally {
            this.f7097c.m9168b(c13519dM9167a);
        }
    }

    @Override // p759x1.InterfaceC13686k
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public boolean mo9146a(ByteBuffer byteBuffer, C13684i c13684i) throws IOException {
        return !((Boolean) c13684i.m82284c(C10979h.f52036b)).booleanValue() && C1558a.m9006g(this.f7096b, byteBuffer) == ImageHeaderParser.ImageType.GIF;
    }

    public ByteBufferGifDecoder(Context context, List<ImageHeaderParser> list, InterfaceC0009d interfaceC0009d, InterfaceC0007b interfaceC0007b) {
        this(context, list, interfaceC0009d, interfaceC0007b, f7094g, f7093f);
    }

    public ByteBufferGifDecoder(Context context, List<ImageHeaderParser> list, InterfaceC0009d interfaceC0009d, InterfaceC0007b interfaceC0007b, C1601b c1601b, C1600a c1600a) {
        this.f7095a = context.getApplicationContext();
        this.f7096b = list;
        this.f7098d = c1600a;
        this.f7099e = new C10972a(interfaceC0009d, interfaceC0007b);
        this.f7097c = c1601b;
    }
}
