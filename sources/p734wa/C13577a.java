package p734wa;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.LruCache;

/* renamed from: wa.a */
/* loaded from: classes3.dex */
public class C13577a extends LruCache<String, BitmapDrawable> {
    public C13577a(int i10) {
        super(i10);
    }

    @Override // android.util.LruCache
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void entryRemoved(boolean z10, String str, BitmapDrawable bitmapDrawable, BitmapDrawable bitmapDrawable2) {
        if (bitmapDrawable instanceof C13579c) {
            ((C13579c) bitmapDrawable).m81581b(false);
        }
    }

    /* renamed from: b */
    public BitmapDrawable m81572b(String str) {
        return get(str);
    }

    @Override // android.util.LruCache
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public int sizeOf(String str, BitmapDrawable bitmapDrawable) {
        Bitmap bitmap;
        if (bitmapDrawable == null || (bitmap = bitmapDrawable.getBitmap()) == null) {
            return -1;
        }
        return bitmap.getByteCount();
    }
}
