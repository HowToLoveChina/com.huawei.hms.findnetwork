package p514o9;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.ImageView;
import java.io.File;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import p015ak.C0213f;
import p015ak.C0227m;
import p491nd.C11665c;
import p616rk.C12515a;
import p757x.AbstractC13671c;
import p757x.C13672d;

/* renamed from: o9.b */
/* loaded from: classes3.dex */
public class C11828b {

    /* renamed from: a */
    public String f54743a;

    /* renamed from: b */
    public HashMap<String, SoftReference<Bitmap>> f54744b = new HashMap<>();

    /* renamed from: c */
    public HashMap<String, ArrayList<ImageView>> f54745c = new HashMap<>();

    /* renamed from: d */
    public boolean f54746d = true;

    /* renamed from: e */
    public int f54747e = 8;

    /* renamed from: f */
    public Handler f54748f = new a(Looper.getMainLooper());

    /* renamed from: o9.b$a */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null) {
                return;
            }
            int i10 = message.what;
            if (i10 != 5001) {
                if (i10 == 5002) {
                    C11839m.m70686d("CommonImageLoader", "download image failed.");
                    postDelayed(new c(C11828b.this, (b) message.obj), 1000L);
                    return;
                }
                return;
            }
            b bVar = (b) message.obj;
            if (bVar == null) {
                C11839m.m70688i("CommonImageLoader", "handle download success message, result is null");
                return;
            }
            String str = bVar.f54751b;
            Bitmap bitmap = bVar.f54752c;
            if (TextUtils.isEmpty(str) || bitmap == null) {
                C11839m.m70688i("CommonImageLoader", "handle download success message, result sub obj is null");
                return;
            }
            C11828b.this.m70490f(C11828b.this.m70494j(str), bitmap);
            ArrayList arrayList = (ArrayList) C11828b.this.f54745c.remove(str);
            if (arrayList == null || arrayList.isEmpty()) {
                C11839m.m70687e("CommonImageLoader", "imageViewList is null or empty");
                return;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ImageView imageView = (ImageView) it.next();
                if (imageView != null && ((String) imageView.getTag()).equals(str)) {
                    C11828b.this.m70497m(imageView, bitmap);
                }
            }
        }
    }

    /* renamed from: o9.b$c */
    public static class c implements Runnable {

        /* renamed from: a */
        public WeakReference<C11828b> f54753a;

        /* renamed from: b */
        public b f54754b;

        public c(C11828b c11828b, b bVar) {
            this.f54753a = new WeakReference<>(c11828b);
            this.f54754b = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            C11839m.m70686d("CommonImageLoader", "NotExitTask start");
            C11828b c11828b = this.f54753a.get();
            if (c11828b == null) {
                return;
            }
            b bVar = this.f54754b;
            if (bVar == null) {
                C11839m.m70688i("CommonImageLoader", "NotExitTask result is null");
                return;
            }
            ImageView imageView = bVar.f54750a;
            String str = bVar.f54751b;
            C11839m.m70686d("CommonImageLoader", "NotExitTask show = " + str);
            c11828b.m70497m(imageView, c11828b.m70493i(c11828b.m70494j(str)));
        }
    }

    public C11828b() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a != null) {
            this.f54743a = contextM1377a.getCacheDir().getPath() + "/defaultCacheFolder/";
        }
    }

    /* renamed from: f */
    public final void m70490f(String str, Bitmap bitmap) {
        if (m70493i(str) == null) {
            this.f54744b.put(str, new SoftReference<>(bitmap));
        }
    }

    /* renamed from: g */
    public void m70491g(String str, String str2, ImageView imageView) {
        if (imageView == null || TextUtils.isEmpty(str)) {
            C11839m.m70688i("CommonImageLoader", "imageView is null or uri is empty");
            return;
        }
        imageView.setTag(str);
        Bitmap bitmapM70495k = m70495k(str);
        if (bitmapM70495k != null) {
            m70497m(imageView, bitmapM70495k);
            return;
        }
        String strM70494j = m70494j(str);
        if (TextUtils.isEmpty(this.f54743a)) {
            Context contextM1377a = C0213f.m1377a();
            if (contextM1377a == null) {
                C11839m.m70687e("CommonImageLoader", "context is null, can't get image cache path");
                return;
            }
            this.f54743a = contextM1377a.getCacheDir().getPath() + "/defaultCacheFolder/";
        }
        String str3 = this.f54743a + strM70494j;
        if (this.f54745c.containsKey(str)) {
            ArrayList<ImageView> arrayList = this.f54745c.get(str);
            arrayList.add(imageView);
            this.f54745c.put(str, arrayList);
        } else {
            C12515a.m75110o().m75175e(new C11665c(str, str3, str2, this.f54748f, imageView), false);
            ArrayList<ImageView> arrayList2 = new ArrayList<>();
            arrayList2.add(imageView);
            this.f54745c.put(str, arrayList2);
        }
    }

    /* renamed from: h */
    public boolean m70492h(Context context, String str) {
        if (new File(context.getCacheDir().getPath() + "/defaultCacheFolder/" + C0227m.m1593f(str)).exists()) {
            return true;
        }
        C11839m.m70686d("CommonImageLoader", "tempFile exists false");
        return false;
    }

    /* renamed from: i */
    public final Bitmap m70493i(String str) {
        SoftReference<Bitmap> softReference = this.f54744b.get(str);
        if (softReference == null) {
            return null;
        }
        return softReference.get();
    }

    /* renamed from: j */
    public final String m70494j(String str) {
        return C0227m.m1593f(str);
    }

    /* renamed from: k */
    public final Bitmap m70495k(String str) {
        return m70493i(m70494j(str));
    }

    /* renamed from: l */
    public void m70496l(boolean z10) {
        this.f54746d = z10;
    }

    /* renamed from: m */
    public final void m70497m(ImageView imageView, Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            C11839m.m70686d("CommonImageLoader", "bitmap is null or recycled, return");
            return;
        }
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null || !this.f54746d) {
            C11839m.m70686d("CommonImageLoader", "load bitmap success, context is null");
            imageView.setImageBitmap(bitmap);
        } else {
            AbstractC13671c abstractC13671cM82255a = C13672d.m82255a(contextM1377a.getResources(), bitmap);
            abstractC13671cM82255a.m82252e(C11842p.m70844o(contextM1377a, this.f54747e));
            imageView.setImageDrawable(abstractC13671cM82255a);
        }
    }

    /* renamed from: o9.b$b */
    public static class b {

        /* renamed from: a */
        public ImageView f54750a;

        /* renamed from: b */
        public String f54751b;

        /* renamed from: c */
        public Bitmap f54752c;

        public b(ImageView imageView, String str) {
            this.f54750a = imageView;
            this.f54751b = str;
        }

        public b(ImageView imageView, String str, Bitmap bitmap) {
            this.f54750a = imageView;
            this.f54751b = str;
            this.f54752c = bitmap;
        }
    }

    public C11828b(String str) {
        Context contextM1377a = C0213f.m1377a();
        if (TextUtils.isEmpty(str) && contextM1377a != null) {
            this.f54743a = contextM1377a.getCacheDir().getPath() + "/defaultCacheFolder/";
            return;
        }
        this.f54743a = str;
    }
}
