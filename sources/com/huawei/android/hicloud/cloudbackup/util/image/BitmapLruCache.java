package com.huawei.android.hicloud.cloudbackup.util.image;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;
import androidx.core.content.ContextCompat;
import com.huawei.hiar.ARImageMetadata;
import p015ak.C0213f;
import p514o9.C11839m;
import p723w.C13502a;

/* loaded from: classes2.dex */
public class BitmapLruCache extends LruCache<String, Bitmap> {
    private static final int DEFAULT_SIZE = 15728640;
    private static final BitmapLruCache LRU_CACHE = new BitmapLruCache();
    private static final String TAG = "BitmapLruCache";

    private BitmapLruCache() {
        this(calculateMemoryCacheSize());
    }

    public static int calculateMemoryCacheSize() {
        Context context = getContext();
        if (((ActivityManager) ContextCompat.getSystemService(context, ActivityManager.class)) == null) {
            return DEFAULT_SIZE;
        }
        int largeMemoryClass = (int) ((((context.getApplicationInfo().flags & ARImageMetadata.SHADING_MODE) != 0 ? r1.getLargeMemoryClass() : r1.getMemoryClass()) * 1048576) / 20);
        C11839m.m70686d(TAG, "calculateMemoryCacheSize size = " + largeMemoryClass);
        return largeMemoryClass;
    }

    private static Context getContext() {
        return C0213f.m1377a();
    }

    public static BitmapLruCache getInstance() {
        return LRU_CACHE;
    }

    private BitmapLruCache(int i10) {
        super(i10);
    }

    @Override // android.util.LruCache
    public int sizeOf(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            throw new NullPointerException("key == null || bitmap == null");
        }
        int iM81215a = C13502a.m81215a(bitmap);
        C11839m.m70686d(TAG, "sizeOf key = " + str + " count " + iM81215a);
        return iM81215a;
    }
}
