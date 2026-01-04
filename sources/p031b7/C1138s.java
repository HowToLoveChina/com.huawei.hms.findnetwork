package p031b7;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.LruCache;
import p723w.C13502a;

/* renamed from: b7.s */
/* loaded from: classes2.dex */
public class C1138s {

    /* renamed from: a */
    public b f5402a;

    /* renamed from: b7.s$b */
    public static class b extends LruCache<String, Bitmap> {
        public b(int i10) {
            super(i10);
        }

        @Override // android.util.LruCache
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int sizeOf(String str, Bitmap bitmap) {
            if (str == null || bitmap == null) {
                return 0;
            }
            return C13502a.m81215a(bitmap);
        }
    }

    /* renamed from: b7.s$c */
    public static class c {

        /* renamed from: a */
        public static C1138s f5403a = new C1138s();
    }

    /* renamed from: d */
    public static C1138s m7181d() {
        return c.f5403a;
    }

    /* renamed from: a */
    public void m7182a(String str, Bitmap bitmap) {
        if (TextUtils.isEmpty(str) || bitmap == null) {
            return;
        }
        Bitmap bitmapM7184c = m7184c(str);
        if (bitmapM7184c == null || bitmapM7184c.getAllocationByteCount() <= bitmap.getAllocationByteCount()) {
            this.f5402a.put(str, bitmap);
        } else {
            C1120a.m6675d("ThumbnailBitmapCache", "cache bigger than bitmap, already saved LCD pic.");
        }
    }

    /* renamed from: b */
    public void m7183b() {
        this.f5402a.evictAll();
    }

    /* renamed from: c */
    public Bitmap m7184c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f5402a.get(str);
    }

    public C1138s() {
        this.f5402a = new b(52428800);
    }
}
