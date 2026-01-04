package p306g2;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.Log;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import p003a2.InterfaceC0009d;

/* renamed from: g2.a0 */
/* loaded from: classes.dex */
public final class C9848a0 {

    /* renamed from: a */
    public static final Paint f48406a = new Paint(6);

    /* renamed from: b */
    public static final Paint f48407b = new Paint(7);

    /* renamed from: c */
    public static final Paint f48408c;

    /* renamed from: d */
    public static final Set<String> f48409d;

    /* renamed from: e */
    public static final Lock f48410e;

    /* renamed from: g2.a0$a */
    public static final class a implements Lock {
        @Override // java.util.concurrent.locks.Lock
        public void lock() {
        }

        @Override // java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
        }

        @Override // java.util.concurrent.locks.Lock
        public Condition newCondition() {
            throw new UnsupportedOperationException("Should not be called");
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock() {
            return true;
        }

        @Override // java.util.concurrent.locks.Lock
        public void unlock() {
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock(long j10, TimeUnit timeUnit) throws InterruptedException {
            return true;
        }
    }

    static {
        HashSet hashSet = new HashSet(Arrays.asList("XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098", "XT1031", "XT1028", "XT937C", "XT1032", "XT1008", "XT1033", "XT1035", "XT1034", "XT939G", "XT1039", "XT1040", "XT1042", "XT1045", "XT1063", "XT1064", "XT1068", "XT1069", "XT1072", "XT1077", "XT1078", "XT1079"));
        f48409d = hashSet;
        f48410e = hashSet.contains(Build.MODEL) ? new ReentrantLock() : new a();
        Paint paint = new Paint(7);
        f48408c = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    /* renamed from: a */
    public static void m61208a(Bitmap bitmap, Bitmap bitmap2, Matrix matrix) {
        Lock lock = f48410e;
        lock.lock();
        try {
            Canvas canvas = new Canvas(bitmap2);
            canvas.drawBitmap(bitmap, matrix, f48406a);
            m61212e(canvas);
            lock.unlock();
        } catch (Throwable th2) {
            f48410e.unlock();
            throw th2;
        }
    }

    /* renamed from: b */
    public static Bitmap m61209b(InterfaceC0009d interfaceC0009d, Bitmap bitmap, int i10, int i11) {
        float width;
        float height;
        if (bitmap.getWidth() == i10 && bitmap.getHeight() == i11) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        float width2 = 0.0f;
        if (bitmap.getWidth() * i11 > bitmap.getHeight() * i10) {
            width = i11 / bitmap.getHeight();
            width2 = (i10 - (bitmap.getWidth() * width)) * 0.5f;
            height = 0.0f;
        } else {
            width = i10 / bitmap.getWidth();
            height = (i11 - (bitmap.getHeight() * width)) * 0.5f;
        }
        matrix.setScale(width, width);
        matrix.postTranslate((int) (width2 + 0.5f), (int) (height + 0.5f));
        Bitmap bitmapMo16c = interfaceC0009d.mo16c(i10, i11, m61218k(bitmap));
        m61222o(bitmap, bitmapMo16c);
        m61208a(bitmap, bitmapMo16c, matrix);
        return bitmapMo16c;
    }

    /* renamed from: c */
    public static Bitmap m61210c(InterfaceC0009d interfaceC0009d, Bitmap bitmap, int i10, int i11) {
        if (bitmap.getWidth() > i10 || bitmap.getHeight() > i11) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "requested target size too big for input, fit centering instead");
            }
            return m61213f(interfaceC0009d, bitmap, i10, i11);
        }
        if (Log.isLoggable("TransformationUtils", 2)) {
            Log.v("TransformationUtils", "requested target size larger or equal to input, returning input");
        }
        return bitmap;
    }

    /* renamed from: d */
    public static Bitmap m61211d(InterfaceC0009d interfaceC0009d, Bitmap bitmap, int i10, int i11) {
        int iMin = Math.min(i10, i11);
        float f10 = iMin;
        float f11 = f10 / 2.0f;
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        float fMax = Math.max(f10 / width, f10 / height);
        float f12 = width * fMax;
        float f13 = fMax * height;
        float f14 = (f10 - f12) / 2.0f;
        float f15 = (f10 - f13) / 2.0f;
        RectF rectF = new RectF(f14, f15, f12 + f14, f13 + f15);
        Bitmap bitmapM61214g = m61214g(interfaceC0009d, bitmap);
        Bitmap bitmapMo16c = interfaceC0009d.mo16c(iMin, iMin, m61215h(bitmap));
        bitmapMo16c.setHasAlpha(true);
        Lock lock = f48410e;
        lock.lock();
        try {
            Canvas canvas = new Canvas(bitmapMo16c);
            canvas.drawCircle(f11, f11, f11, f48407b);
            canvas.drawBitmap(bitmapM61214g, (Rect) null, rectF, f48408c);
            m61212e(canvas);
            lock.unlock();
            if (!bitmapM61214g.equals(bitmap)) {
                interfaceC0009d.mo15b(bitmapM61214g);
            }
            return bitmapMo16c;
        } catch (Throwable th2) {
            f48410e.unlock();
            throw th2;
        }
    }

    /* renamed from: e */
    public static void m61212e(Canvas canvas) {
        canvas.setBitmap(null);
    }

    /* renamed from: f */
    public static Bitmap m61213f(InterfaceC0009d interfaceC0009d, Bitmap bitmap, int i10, int i11) {
        if (bitmap.getWidth() == i10 && bitmap.getHeight() == i11) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "requested target size matches input, returning input");
            }
            return bitmap;
        }
        float fMin = Math.min(i10 / bitmap.getWidth(), i11 / bitmap.getHeight());
        int iRound = Math.round(bitmap.getWidth() * fMin);
        int iRound2 = Math.round(bitmap.getHeight() * fMin);
        if (bitmap.getWidth() == iRound && bitmap.getHeight() == iRound2) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "adjusted target size matches input, returning input");
            }
            return bitmap;
        }
        Bitmap bitmapMo16c = interfaceC0009d.mo16c((int) (bitmap.getWidth() * fMin), (int) (bitmap.getHeight() * fMin), m61218k(bitmap));
        m61222o(bitmap, bitmapMo16c);
        if (Log.isLoggable("TransformationUtils", 2)) {
            Log.v("TransformationUtils", "request: " + i10 + Constants.MULTIPLE_SIGN + i11);
            Log.v("TransformationUtils", "toFit:   " + bitmap.getWidth() + Constants.MULTIPLE_SIGN + bitmap.getHeight());
            Log.v("TransformationUtils", "toReuse: " + bitmapMo16c.getWidth() + Constants.MULTIPLE_SIGN + bitmapMo16c.getHeight());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("minPct:   ");
            sb2.append(fMin);
            Log.v("TransformationUtils", sb2.toString());
        }
        Matrix matrix = new Matrix();
        matrix.setScale(fMin, fMin);
        m61208a(bitmap, bitmapMo16c, matrix);
        return bitmapMo16c;
    }

    /* renamed from: g */
    public static Bitmap m61214g(InterfaceC0009d interfaceC0009d, Bitmap bitmap) {
        Bitmap.Config configM61215h = m61215h(bitmap);
        if (configM61215h.equals(bitmap.getConfig())) {
            return bitmap;
        }
        Bitmap bitmapMo16c = interfaceC0009d.mo16c(bitmap.getWidth(), bitmap.getHeight(), configM61215h);
        new Canvas(bitmapMo16c).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        return bitmapMo16c;
    }

    /* renamed from: h */
    public static Bitmap.Config m61215h(Bitmap bitmap) {
        Bitmap.Config config = Bitmap.Config.RGBA_F16;
        return config.equals(bitmap.getConfig()) ? config : Bitmap.Config.ARGB_8888;
    }

    /* renamed from: i */
    public static Lock m61216i() {
        return f48410e;
    }

    /* renamed from: j */
    public static int m61217j(int i10) {
        switch (i10) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return Constants.INTERSTITIAL_WIDTH;
            default:
                return 0;
        }
    }

    /* renamed from: k */
    public static Bitmap.Config m61218k(Bitmap bitmap) {
        return bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888;
    }

    /* renamed from: l */
    public static void m61219l(int i10, Matrix matrix) {
        switch (i10) {
            case 2:
                matrix.setScale(-1.0f, 1.0f);
                break;
            case 3:
                matrix.setRotate(180.0f);
                break;
            case 4:
                matrix.setRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 5:
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 6:
                matrix.setRotate(90.0f);
                break;
            case 7:
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 8:
                matrix.setRotate(-90.0f);
                break;
        }
    }

    /* renamed from: m */
    public static boolean m61220m(int i10) {
        switch (i10) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }

    /* renamed from: n */
    public static Bitmap m61221n(InterfaceC0009d interfaceC0009d, Bitmap bitmap, int i10) {
        if (!m61220m(i10)) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        m61219l(i10, matrix);
        RectF rectF = new RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
        matrix.mapRect(rectF);
        Bitmap bitmapMo16c = interfaceC0009d.mo16c(Math.round(rectF.width()), Math.round(rectF.height()), m61218k(bitmap));
        matrix.postTranslate(-rectF.left, -rectF.top);
        bitmapMo16c.setHasAlpha(bitmap.hasAlpha());
        m61208a(bitmap, bitmapMo16c, matrix);
        return bitmapMo16c;
    }

    /* renamed from: o */
    public static void m61222o(Bitmap bitmap, Bitmap bitmap2) {
        bitmap2.setHasAlpha(bitmap.hasAlpha());
    }
}
