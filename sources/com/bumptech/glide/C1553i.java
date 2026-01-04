package com.bumptech.glide;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.C1547c;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.C1570k;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.model.C1584a;
import com.bumptech.glide.load.model.C1585b;
import com.bumptech.glide.load.model.C1586c;
import com.bumptech.glide.load.model.C1587d;
import com.bumptech.glide.load.model.C1588e;
import com.bumptech.glide.load.model.C1592i;
import com.bumptech.glide.load.model.C1593j;
import com.bumptech.glide.load.model.C1594k;
import com.bumptech.glide.load.model.C1595l;
import com.bumptech.glide.load.model.C1596m;
import com.bumptech.glide.load.model.MediaStoreFileLoader;
import com.bumptech.glide.load.model.stream.MediaStoreImageThumbLoader;
import com.bumptech.glide.load.model.stream.MediaStoreVideoThumbLoader;
import com.bumptech.glide.load.model.stream.QMediaStoreUriLoader;
import com.bumptech.glide.load.resource.bitmap.C1599a;
import com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder;
import com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder;
import com.bumptech.glide.load.resource.transcode.BitmapDrawableTranscoder;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.List;
import p003a2.InterfaceC0007b;
import p003a2.InterfaceC0009d;
import p214d2.C8987a;
import p214d2.C8988b;
import p214d2.C8996j;
import p245e2.C9391a;
import p245e2.C9392b;
import p306g2.C9847a;
import p306g2.C9849b;
import p306g2.C9850b0;
import p306g2.C9851c;
import p306g2.C9855g;
import p306g2.C9856h;
import p306g2.C9860l;
import p306g2.C9862n;
import p306g2.C9865q;
import p306g2.C9869u;
import p306g2.C9871w;
import p306g2.C9873y;
import p306g2.C9874z;
import p324h2.C10087a;
import p355i2.C10415a;
import p355i2.C10419e;
import p382j2.C10699a;
import p415k2.C10973b;
import p415k2.C10974c;
import p415k2.C10978g;
import p415k2.C10980i;
import p441l2.C11222a;
import p441l2.C11223b;
import p441l2.C11224c;
import p467m2.AbstractC11392a;
import p467m2.InterfaceC11393b;
import p630s2.C12671f;
import p725w1.InterfaceC13516a;
import p759x1.InterfaceC13686k;
import p828z0.C14060a;

/* renamed from: com.bumptech.glide.i */
/* loaded from: classes.dex */
public final class C1553i {

    /* renamed from: com.bumptech.glide.i$a */
    public class a implements C12671f.b<C1552h> {

        /* renamed from: a */
        public boolean f6886a;

        /* renamed from: b */
        public final /* synthetic */ ComponentCallbacks2C1546b f6887b;

        /* renamed from: c */
        public final /* synthetic */ List f6888c;

        /* renamed from: d */
        public final /* synthetic */ AbstractC11392a f6889d;

        public a(ComponentCallbacks2C1546b componentCallbacks2C1546b, List list, AbstractC11392a abstractC11392a) {
            this.f6887b = componentCallbacks2C1546b;
            this.f6888c = list;
            this.f6889d = abstractC11392a;
        }

        @Override // p630s2.C12671f.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C1552h get() {
            if (this.f6886a) {
                throw new IllegalStateException("Recursive Registry initialization! In your AppGlideModule and LibraryGlideModules, Make sure you're using the provided Registry rather calling glide.getRegistry()!");
            }
            this.f6886a = true;
            C14060a.m84265a("Glide registry");
            try {
                return C1553i.m8949a(this.f6887b, this.f6888c, this.f6889d);
            } finally {
                C14060a.m84266b();
            }
        }
    }

    /* renamed from: a */
    public static C1552h m8949a(ComponentCallbacks2C1546b componentCallbacks2C1546b, List<InterfaceC11393b> list, AbstractC11392a abstractC11392a) {
        InterfaceC0009d interfaceC0009dM8907f = componentCallbacks2C1546b.m8907f();
        InterfaceC0007b interfaceC0007bM8906e = componentCallbacks2C1546b.m8906e();
        Context applicationContext = componentCallbacks2C1546b.m8910i().getApplicationContext();
        C1549e c1549eM8925g = componentCallbacks2C1546b.m8910i().m8925g();
        C1552h c1552h = new C1552h();
        m8950b(applicationContext, c1552h, interfaceC0009dM8907f, interfaceC0007bM8906e, c1549eM8925g);
        m8951c(applicationContext, componentCallbacks2C1546b, c1552h, list, abstractC11392a);
        return c1552h;
    }

    /* renamed from: b */
    public static void m8950b(Context context, C1552h c1552h, InterfaceC0009d interfaceC0009d, InterfaceC0007b interfaceC0007b, C1549e c1549e) {
        InterfaceC13686k c9855g;
        InterfaceC13686k c9874z;
        C1552h c1552h2;
        Object obj;
        c1552h.m8945o(new C9860l());
        c1552h.m8945o(new C9865q());
        Resources resources = context.getResources();
        List<ImageHeaderParser> listM8937g = c1552h.m8937g();
        ByteBufferGifDecoder byteBufferGifDecoder = new ByteBufferGifDecoder(context, listM8937g, interfaceC0009d, interfaceC0007b);
        InterfaceC13686k<ParcelFileDescriptor, Bitmap> interfaceC13686kM9145l = C1599a.m9145l(interfaceC0009d);
        C9862n c9862n = new C9862n(c1552h.m8937g(), resources.getDisplayMetrics(), interfaceC0009d, interfaceC0007b);
        if (c1549e.m8928a(C1547c.b.class)) {
            c9874z = new C9869u();
            c9855g = new C9856h();
        } else {
            c9855g = new C9855g(c9862n);
            c9874z = new C9874z(c9862n, interfaceC0007b);
        }
        c1552h.m8935e("Animation", InputStream.class, Drawable.class, C10415a.m63947f(listM8937g, interfaceC0007b));
        c1552h.m8935e("Animation", ByteBuffer.class, Drawable.class, C10415a.m63946a(listM8937g, interfaceC0007b));
        ResourceDrawableDecoder resourceDrawableDecoder = new ResourceDrawableDecoder(context);
        C1592i.c cVar = new C1592i.c(resources);
        C1592i.d dVar = new C1592i.d(resources);
        C1592i.b bVar = new C1592i.b(resources);
        C1592i.a aVar = new C1592i.a(resources);
        C9851c c9851c = new C9851c(interfaceC0007b);
        C11222a c11222a = new C11222a();
        C11224c c11224c = new C11224c();
        ContentResolver contentResolver = context.getContentResolver();
        c1552h.m8933c(ByteBuffer.class, new C8987a()).m8933c(InputStream.class, new C8996j(interfaceC0007b)).m8935e("Bitmap", ByteBuffer.class, Bitmap.class, c9855g).m8935e("Bitmap", InputStream.class, Bitmap.class, c9874z);
        if (ParcelFileDescriptorRewinder.m9010c()) {
            c1552h.m8935e("Bitmap", ParcelFileDescriptor.class, Bitmap.class, new C9871w(c9862n));
        }
        c1552h.m8935e("Bitmap", ParcelFileDescriptor.class, Bitmap.class, interfaceC13686kM9145l).m8935e("Bitmap", AssetFileDescriptor.class, Bitmap.class, C1599a.m9136c(interfaceC0009d)).m8931a(Bitmap.class, Bitmap.class, C1594k.a.m9119a()).m8935e("Bitmap", Bitmap.class, Bitmap.class, new C9850b0()).m8934d(Bitmap.class, c9851c).m8935e("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new C9847a(resources, c9855g)).m8935e("BitmapDrawable", InputStream.class, BitmapDrawable.class, new C9847a(resources, c9874z)).m8935e("BitmapDrawable", ParcelFileDescriptor.class, BitmapDrawable.class, new C9847a(resources, interfaceC13686kM9145l)).m8934d(BitmapDrawable.class, new C9849b(interfaceC0009d, c9851c)).m8935e("Animation", InputStream.class, C10973b.class, new C10980i(listM8937g, byteBufferGifDecoder, interfaceC0007b)).m8935e("Animation", ByteBuffer.class, C10973b.class, byteBufferGifDecoder).m8934d(C10973b.class, new C10974c()).m8931a(InterfaceC13516a.class, InterfaceC13516a.class, C1594k.a.m9119a()).m8935e("Bitmap", InterfaceC13516a.class, Bitmap.class, new C10978g(interfaceC0009d)).m8932b(Uri.class, Drawable.class, resourceDrawableDecoder).m8932b(Uri.class, Bitmap.class, new C9873y(resourceDrawableDecoder, interfaceC0009d)).m8946p(new C10087a.a()).m8931a(File.class, ByteBuffer.class, new C1586c.b()).m8931a(File.class, InputStream.class, new C1588e.e()).m8932b(File.class, File.class, new C10699a()).m8931a(File.class, ParcelFileDescriptor.class, new C1588e.b()).m8931a(File.class, File.class, C1594k.a.m9119a()).m8946p(new C1570k.a(interfaceC0007b));
        if (ParcelFileDescriptorRewinder.m9010c()) {
            c1552h2 = c1552h;
            obj = AssetFileDescriptor.class;
            c1552h2.m8946p(new ParcelFileDescriptorRewinder.C1559a());
        } else {
            c1552h2 = c1552h;
            obj = AssetFileDescriptor.class;
        }
        Class cls = Integer.TYPE;
        c1552h2.m8931a(cls, InputStream.class, cVar).m8931a(cls, ParcelFileDescriptor.class, bVar).m8931a(Integer.class, InputStream.class, cVar).m8931a(Integer.class, ParcelFileDescriptor.class, bVar).m8931a(Integer.class, Uri.class, dVar).m8931a(cls, obj, aVar).m8931a(Integer.class, obj, aVar).m8931a(cls, Uri.class, dVar).m8931a(String.class, InputStream.class, new C1587d.c()).m8931a(Uri.class, InputStream.class, new C1587d.c()).m8931a(String.class, InputStream.class, new C1593j.c()).m8931a(String.class, ParcelFileDescriptor.class, new C1593j.b()).m8931a(String.class, obj, new C1593j.a()).m8931a(Uri.class, InputStream.class, new C1584a.c(context.getAssets())).m8931a(Uri.class, obj, new C1584a.b(context.getAssets())).m8931a(Uri.class, InputStream.class, new MediaStoreImageThumbLoader.Factory(context)).m8931a(Uri.class, InputStream.class, new MediaStoreVideoThumbLoader.Factory(context));
        c1552h2.m8931a(Uri.class, InputStream.class, new QMediaStoreUriLoader.InputStreamFactory(context));
        c1552h2.m8931a(Uri.class, ParcelFileDescriptor.class, new QMediaStoreUriLoader.FileDescriptorFactory(context));
        c1552h2.m8931a(Uri.class, InputStream.class, new C1595l.d(contentResolver)).m8931a(Uri.class, ParcelFileDescriptor.class, new C1595l.b(contentResolver)).m8931a(Uri.class, obj, new C1595l.a(contentResolver)).m8931a(Uri.class, InputStream.class, new C1596m.a()).m8931a(URL.class, InputStream.class, new C9392b.a()).m8931a(Uri.class, File.class, new MediaStoreFileLoader.Factory(context)).m8931a(C8988b.class, InputStream.class, new C9391a.a()).m8931a(byte[].class, ByteBuffer.class, new C1585b.a()).m8931a(byte[].class, InputStream.class, new C1585b.d()).m8931a(Uri.class, Uri.class, C1594k.a.m9119a()).m8931a(Drawable.class, Drawable.class, C1594k.a.m9119a()).m8932b(Drawable.class, Drawable.class, new C10419e()).m8947q(Bitmap.class, BitmapDrawable.class, new BitmapDrawableTranscoder(resources)).m8947q(Bitmap.class, byte[].class, c11222a).m8947q(Drawable.class, byte[].class, new C11223b(interfaceC0009d, c11222a, c11224c)).m8947q(C10973b.class, byte[].class, c11224c);
        InterfaceC13686k<ByteBuffer, Bitmap> interfaceC13686kM9137d = C1599a.m9137d(interfaceC0009d);
        c1552h2.m8932b(ByteBuffer.class, Bitmap.class, interfaceC13686kM9137d);
        c1552h2.m8932b(ByteBuffer.class, BitmapDrawable.class, new C9847a(resources, interfaceC13686kM9137d));
    }

    /* renamed from: c */
    public static void m8951c(Context context, ComponentCallbacks2C1546b componentCallbacks2C1546b, C1552h c1552h, List<InterfaceC11393b> list, AbstractC11392a abstractC11392a) {
        for (InterfaceC11393b interfaceC11393b : list) {
            try {
                interfaceC11393b.m68300b(context, componentCallbacks2C1546b, c1552h);
            } catch (AbstractMethodError e10) {
                throw new IllegalStateException("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: " + interfaceC11393b.getClass().getName(), e10);
            }
        }
        if (abstractC11392a != null) {
            abstractC11392a.m68301a(context, componentCallbacks2C1546b, c1552h);
        }
    }

    /* renamed from: d */
    public static C12671f.b<C1552h> m8952d(ComponentCallbacks2C1546b componentCallbacks2C1546b, List<InterfaceC11393b> list, AbstractC11392a abstractC11392a) {
        return new a(componentCallbacks2C1546b, list, abstractC11392a);
    }
}
