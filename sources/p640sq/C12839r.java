package p640sq;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Point;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.huawei.android.hicloud.album.service.logic.callable.CloudAlbumDownloadBabyHeadPicCallable;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* renamed from: sq.r */
/* loaded from: classes8.dex */
public class C12839r {
    /* renamed from: a */
    public static int m77103a(int i10) {
        if (i10 > 1000) {
            return 60;
        }
        if (i10 > 750) {
            return 40;
        }
        return i10 > 500 ? 20 : 10;
    }

    /* renamed from: b */
    public static int m77104b(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt == 6) {
                return 90;
            }
            if (attributeInt != 8) {
                return 0;
            }
            return Constants.INTERSTITIAL_WIDTH;
        } catch (IOException e10) {
            C12836o.m77099d("PicUtil", "readImageDegree IOException" + e10.getClass().getSimpleName(), true);
            return 0;
        }
    }

    /* renamed from: c */
    public static Bitmap m77105c(int i10, Bitmap bitmap) {
        if (i10 == 0 || bitmap == null) {
            return bitmap;
        }
        C12836o.m77097b("PicUtil", "rotaingImageView", true);
        Matrix matrix = new Matrix();
        matrix.postRotate(i10);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    /* renamed from: d */
    public static Bitmap m77106d(String str, int i10, int i11) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        try {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            int i12 = options.outWidth / i10;
            int i13 = options.outHeight / i11;
            if (i12 >= i13) {
                i12 = i13;
            }
            if (i12 < 1) {
                i12 = 1;
            }
            C12836o.m77097b("PicUtil", "Picture resolution compression scale：" + i12, true);
            options.inSampleSize = i12;
            options.inJustDecodeBounds = false;
            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str, options);
            int iM77104b = m77104b(str);
            C12836o.m77097b("PicUtil", "Picture resolution degree：" + iM77104b, true);
            return iM77104b != 0 ? m77105c(iM77104b, bitmapDecodeFile) : bitmapDecodeFile;
        } catch (OutOfMemoryError unused) {
            C12836o.m77099d("PicUtil", "compressByResolution OutOfMemoryError", true);
            return null;
        } catch (RuntimeException unused2) {
            C12836o.m77099d("PicUtil", "compressByResolution RuntimeException", true);
            return null;
        } catch (Exception unused3) {
            C12836o.m77099d("PicUtil", "compressByResolution Exception", true);
            return null;
        }
    }

    /* renamed from: e */
    public static Uri m77107e(Context context) {
        String strM77114l = m77114l(context);
        if (TextUtils.isEmpty(strM77114l)) {
            return null;
        }
        return Uri.fromFile(new File(strM77114l));
    }

    /* renamed from: f */
    public static String m77108f() {
        Date date = new Date(System.currentTimeMillis());
        return "HwID_card_" + new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(date) + CloudAlbumDownloadBabyHeadPicCallable.DEFAULT_HEAD_EXT;
    }

    /* renamed from: g */
    public static void m77109g(File file) {
        if (file == null) {
            return;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            C12836o.m77097b("PicUtil", "deleteDirInnerPicFile files == null", true);
            return;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.getName().startsWith("HwID_card_") && !file2.delete()) {
                C12836o.m77097b("PicUtil", "delete file fail", true);
            }
        }
    }

    /* renamed from: h */
    public static boolean m77110h(Context context, Uri uri, Uri uri2, boolean z10) throws Throwable {
        FileOutputStream fileOutputStreamCreateOutputStream;
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor;
        InputStream inputStreamOpenInputStream = null;
        try {
            assetFileDescriptorOpenAssetFileDescriptor = context.getContentResolver().openAssetFileDescriptor(uri2, "rw");
            if (assetFileDescriptorOpenAssetFileDescriptor == null || uri2 == null || uri == null) {
                fileOutputStreamCreateOutputStream = null;
            } else {
                try {
                    fileOutputStreamCreateOutputStream = assetFileDescriptorOpenAssetFileDescriptor.createOutputStream();
                    try {
                        inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
                        byte[] bArr = new byte[16384];
                        if (inputStreamOpenInputStream != null) {
                            while (true) {
                                int i10 = inputStreamOpenInputStream.read(bArr);
                                if (i10 <= 0) {
                                    break;
                                }
                                fileOutputStreamCreateOutputStream.write(bArr, 0, i10);
                            }
                        }
                    } catch (IOException unused) {
                        if (inputStreamOpenInputStream != null) {
                            try {
                                inputStreamOpenInputStream.close();
                            } catch (IOException e10) {
                                C12836o.m77097b("PicUtil", "error e = " + e10.getClass().getSimpleName(), true);
                                return false;
                            }
                        }
                        if (fileOutputStreamCreateOutputStream != null) {
                            fileOutputStreamCreateOutputStream.close();
                        }
                        if (z10 && uri != null) {
                            context.getContentResolver().delete(uri, "", new String[0]);
                        }
                        if (assetFileDescriptorOpenAssetFileDescriptor != null) {
                            assetFileDescriptorOpenAssetFileDescriptor.close();
                        }
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        if (inputStreamOpenInputStream != null) {
                            try {
                                inputStreamOpenInputStream.close();
                            } catch (IOException e11) {
                                C12836o.m77097b("PicUtil", "error e = " + e11.getClass().getSimpleName(), true);
                                throw th;
                            }
                        }
                        if (fileOutputStreamCreateOutputStream != null) {
                            fileOutputStreamCreateOutputStream.close();
                        }
                        if (z10 && uri != null) {
                            context.getContentResolver().delete(uri, "", new String[0]);
                        }
                        if (assetFileDescriptorOpenAssetFileDescriptor != null) {
                            assetFileDescriptorOpenAssetFileDescriptor.close();
                        }
                        throw th;
                    }
                } catch (IOException unused2) {
                    fileOutputStreamCreateOutputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStreamCreateOutputStream = null;
                }
            }
            if (inputStreamOpenInputStream != null) {
                try {
                    inputStreamOpenInputStream.close();
                } catch (IOException e12) {
                    C12836o.m77097b("PicUtil", "error e = " + e12.getClass().getSimpleName(), true);
                }
            }
            if (fileOutputStreamCreateOutputStream != null) {
                fileOutputStreamCreateOutputStream.close();
            }
            if (z10 && uri != null) {
                context.getContentResolver().delete(uri, "", new String[0]);
            }
            if (assetFileDescriptorOpenAssetFileDescriptor != null) {
                assetFileDescriptorOpenAssetFileDescriptor.close();
            }
            return true;
        } catch (IOException unused3) {
            fileOutputStreamCreateOutputStream = null;
            assetFileDescriptorOpenAssetFileDescriptor = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStreamCreateOutputStream = null;
            assetFileDescriptorOpenAssetFileDescriptor = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0128 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r11v0, types: [int] */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m77111i(android.content.Context r9, java.lang.String r10, int r11, java.lang.String r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 328
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p640sq.C12839r.m77111i(android.content.Context, java.lang.String, int, java.lang.String):boolean");
    }

    /* renamed from: j */
    public static Point m77112j(Context context) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C12836o.m77097b("PicUtil", "getRealScreenSize start.", true);
        Display defaultDisplay = ((WindowManager) context.getApplicationContext().getSystemService(Constants.NATIVE_WINDOW_SUB_DIR)).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        int i10 = displayMetrics.heightPixels;
        int i11 = displayMetrics.widthPixels;
        try {
            Point point = new Point();
            Display.class.getMethod("getRealSize", Point.class).invoke(defaultDisplay, point);
            i10 = point.y;
            i11 = point.x;
            C12836o.m77097b("PicUtil", "heightPixels is " + i10, false);
            C12836o.m77097b("PicUtil", "widthPixels is " + i11, false);
        } catch (IllegalAccessException e10) {
            C12836o.m77097b("PicUtil", "IllegalAccessException " + e10.getClass().getSimpleName(), true);
        } catch (IllegalArgumentException e11) {
            C12836o.m77097b("PicUtil", "IllegalArgumentException " + e11.getClass().getSimpleName(), true);
        } catch (NoSuchMethodException e12) {
            C12836o.m77097b("PicUtil", "getRealScreenSize NoSuchMethodException " + e12.getClass().getSimpleName(), true);
        } catch (InvocationTargetException e13) {
            C12836o.m77097b("PicUtil", "InvocationTargetException " + e13.getClass().getSimpleName(), true);
        } catch (Exception e14) {
            C12836o.m77097b("PicUtil", "getRealScreenSize Exception " + e14.getClass().getSimpleName(), true);
        }
        return new Point(i11, i10);
    }

    /* renamed from: k */
    public static void m77113k(Context context) {
        C12836o.m77097b("PicUtil", "deleteCachedFiles", true);
        try {
            String strM77115m = m77115m(context);
            if (TextUtils.isEmpty(strM77115m)) {
                return;
            }
            File file = new File(strM77115m);
            if (file.exists() && file.isDirectory()) {
                m77109g(file);
            }
        } catch (RuntimeException unused) {
            C12836o.m77099d("PicUtil", "deleteCachedFiles RuntimeException", true);
        } catch (Exception unused2) {
            C12836o.m77099d("PicUtil", "deleteCachedFiles Exception", true);
        }
    }

    /* renamed from: l */
    public static String m77114l(Context context) {
        String strM77115m = m77115m(context);
        if (TextUtils.isEmpty(strM77115m)) {
            return "";
        }
        return strM77115m + "/" + m77108f();
    }

    /* renamed from: m */
    public static String m77115m(Context context) {
        if (context == null) {
            C12836o.m77099d("PicUtil", "context is null.", true);
            return "";
        }
        try {
            String externalStorageState = Environment.getExternalStorageState();
            if ("mounted_ro".equals(externalStorageState)) {
                C12836o.m77097b("PicUtil", "read only.", true);
                return "";
            }
            if ("mounted".equals(externalStorageState)) {
                return m77116n(context);
            }
            C12836o.m77097b("PicUtil", "media mounted.", true);
            return "";
        } catch (RuntimeException unused) {
            C12836o.m77099d("PicUtil", "getExternalStorageState failed", true);
            return "";
        }
    }

    /* renamed from: n */
    public static String m77116n(Context context) {
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir == null) {
            C12836o.m77099d("PicUtil", "External cache dir not existence.", true);
            return "";
        }
        try {
            String str = externalCacheDir.getCanonicalPath() + "/tmpFiles";
            File file = new File(str);
            if (file.exists() || file.mkdir()) {
                return str;
            }
            C12836o.m77099d("PicUtil", "External cache tmp dir not existence.", true);
            return "";
        } catch (IOException e10) {
            C12836o.m77097b("PicUtil", "IOException " + e10.getClass().getSimpleName(), true);
            return "";
        }
    }
}
