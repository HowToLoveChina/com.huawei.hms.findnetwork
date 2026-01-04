package p546p6;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.text.TextUtils;
import android.util.LruCache;
import com.huawei.android.p069cg.bean.MediaFileBean;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;
import p015ak.C0213f;
import p015ak.C0241z;
import p031b7.C1120a;
import p035bk.C1248a;

/* renamed from: p6.g */
/* loaded from: classes2.dex */
public class C12094g {

    /* renamed from: a */
    public static volatile C12094g f56090a;

    /* renamed from: b */
    public static LruCache<String, Bitmap> f56091b;

    /* renamed from: c */
    public static final ReentrantLock f56092c = new ReentrantLock();

    /* renamed from: d */
    public static C12094g m72412d() {
        m72413f();
        if (f56090a == null) {
            f56090a = new C12094g();
        }
        return f56090a;
    }

    /* renamed from: f */
    public static void m72413f() {
        if (f56091b == null) {
            ReentrantLock reentrantLock = f56092c;
            reentrantLock.lock();
            try {
                if (f56091b == null) {
                    f56091b = new LruCache<>(62914560);
                }
                reentrantLock.unlock();
            } catch (Throwable th2) {
                f56092c.unlock();
                throw th2;
            }
        }
    }

    /* renamed from: a */
    public int m72414a(int i10, int i11, int i12, int i13) {
        int i14;
        if (i11 > i13 || i10 > i12) {
            double d10 = i13 * 1.2d;
            double d11 = i12 * 1.2d;
            i14 = 1;
            while (true) {
                double d12 = i14;
                if (i11 / d12 < d10 || i10 / d12 < d11) {
                    break;
                }
                i14 *= 2;
            }
        } else {
            i14 = 1;
        }
        if (i14 == 1) {
            double d13 = i13 * 4;
            double d14 = i12 * 4;
            while (true) {
                double d15 = i14;
                if (i11 / d15 < d13 && i10 / d15 < d14) {
                    break;
                }
                i14 *= 2;
            }
        }
        return i14;
    }

    /* renamed from: b */
    public final int m72415b(BitmapFactory.Options options, int i10, int i11) {
        return m72414a(options.outWidth, options.outHeight, i10, i11);
    }

    /* renamed from: c */
    public Bitmap m72416c(String str, int i10, int i11) {
        Bitmap bitmap = f56091b.get(str);
        if (bitmap != null) {
            return bitmap;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        C1248a.m7473d(str, options);
        options.inSampleSize = m72415b(options, i10, i11);
        options.inJustDecodeBounds = false;
        Bitmap bitmapM7476g = null;
        try {
        } catch (IOException e10) {
            C1120a.m6676e("BitmapCompressManager", "decodeSampledBitmapFromResource: " + e10.toString());
        }
        if (TextUtils.isEmpty(str)) {
            C1120a.m6678w("BitmapCompressManager", "pathName is null");
            return null;
        }
        FileInputStream fileInputStream = new FileInputStream(str);
        int length = (int) new File(str).length();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream, length);
        bufferedInputStream.mark(length);
        bitmapM7476g = C1248a.m7476g(bufferedInputStream, null, options);
        if (bitmapM7476g != null) {
            f56091b.put(str, bitmapM7476g);
        } else {
            C1120a.m6677i("BitmapCompressManager", "bitmap is null");
        }
        return bitmapM7476g;
    }

    /* renamed from: e */
    public Bitmap m72417e(Uri uri, MediaFileBean mediaFileBean) throws IOException {
        Bitmap bitmap = f56091b.get(uri.toString());
        if (bitmap != null) {
            return bitmap;
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(C0213f.m1377a(), uri);
                if (mediaFileBean.m14325c() <= 0) {
                    mediaFileBean.m14315R(C0241z.m1688f(mediaMetadataRetriever.extractMetadata(9)));
                }
                f56091b.put(uri.toString(), mediaMetadataRetriever.getFrameAtTime());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime();
                try {
                    mediaMetadataRetriever.release();
                } catch (Exception unused) {
                    C1120a.m6676e("BitmapCompressManager", "media.release error");
                }
                return frameAtTime;
            } catch (Exception unused2) {
                C1120a.m6676e("BitmapCompressManager", uri + "getVideoThumb fail");
                try {
                    mediaMetadataRetriever.release();
                    return null;
                } catch (Exception unused3) {
                    C1120a.m6676e("BitmapCompressManager", "media.release error");
                    return null;
                }
            }
        } catch (Throwable th2) {
            try {
                mediaMetadataRetriever.release();
            } catch (Exception unused4) {
                C1120a.m6676e("BitmapCompressManager", "media.release error");
            }
            throw th2;
        }
    }
}
