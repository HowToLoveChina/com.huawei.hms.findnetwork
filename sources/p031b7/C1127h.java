package p031b7;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import java.io.FileInputStream;
import java.io.IOException;
import p035bk.C1248a;

/* renamed from: b7.h */
/* loaded from: classes2.dex */
public final class C1127h {

    /* renamed from: b7.h$b */
    public static class b {

        /* renamed from: a */
        public Bitmap f5385a;

        public b() {
        }
    }

    /* renamed from: a */
    public static void m6902a(FileInputStream fileInputStream) throws IOException {
        if (fileInputStream != null) {
            try {
                fileInputStream.close();
            } catch (IOException e10) {
                C1120a.m6676e("ImageLocalThumbnailUtil", "closefis error: " + e10.toString());
            }
        }
    }

    /* renamed from: b */
    public static int m6903b(BitmapFactory.Options options, int i10, int i11) {
        int iMin;
        double d10 = options.outWidth;
        double d11 = options.outHeight;
        int iCeil = i11 == -1 ? 1 : (int) Math.ceil(Math.sqrt((d10 * d11) / i11));
        if (i10 == -1) {
            iMin = 128;
        } else {
            double d12 = i10;
            iMin = (int) Math.min(Math.floor(d10 / d12), Math.floor(d11 / d12));
        }
        if (iMin < iCeil) {
            return iCeil;
        }
        if (i11 == -1 && i10 == -1) {
            return 1;
        }
        return i10 == -1 ? iCeil : iMin;
    }

    /* renamed from: c */
    public static int m6904c(BitmapFactory.Options options, int i10, int i11) {
        return m6903b(options, i10, i11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:45:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r6v0, types: [b7.h$a] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap m6905d(java.lang.String r10, int r11) throws java.lang.Throwable {
        /*
            r0 = 0
            r1 = 1
            if (r11 != r1) goto L6
            r2 = r1
            goto L7
        L6:
            r2 = r0
        L7:
            r3 = 96
            if (r2 == 0) goto Le
            r4 = 320(0x140, float:4.48E-43)
            goto Lf
        Le:
            r4 = r3
        Lf:
            if (r2 == 0) goto L14
            r2 = 196608(0x30000, float:2.75506E-40)
            goto L16
        L14:
            r2 = 16384(0x4000, float:2.2959E-41)
        L16:
            b7.h$b r5 = new b7.h$b
            r6 = 0
            r5.<init>()
            pp.a r7 = p818yp.C14034a.m84166c(r10, r0)
            if (r7 == 0) goto L30
            int r7 = r7.m73355a()
            r8 = 100
            if (r7 != r8) goto L30
            m6906e(r10, r4, r2, r5)
            android.graphics.Bitmap r5 = r5.f5385a
            goto L31
        L30:
            r5 = r6
        L31:
            if (r5 != 0) goto L9b
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L76 java.io.IOException -> L78
            r7.<init>(r10)     // Catch: java.lang.Throwable -> L76 java.io.IOException -> L78
            java.io.FileDescriptor r10 = r7.getFD()     // Catch: java.lang.Throwable -> L6c java.io.IOException -> L6f
            android.graphics.BitmapFactory$Options r8 = new android.graphics.BitmapFactory$Options     // Catch: java.lang.Throwable -> L6c java.io.IOException -> L6f
            r8.<init>()     // Catch: java.lang.Throwable -> L6c java.io.IOException -> L6f
            r8.inJustDecodeBounds = r1     // Catch: java.lang.Throwable -> L6c java.io.IOException -> L6f
            r8.inSampleSize = r1     // Catch: java.lang.Throwable -> L6c java.io.IOException -> L6f
            p035bk.C1248a.m7474e(r10, r6, r8)     // Catch: java.lang.Throwable -> L6c java.io.IOException -> L6f
            boolean r1 = r8.mCancel     // Catch: java.lang.Throwable -> L6c java.io.IOException -> L6f
            if (r1 != 0) goto L72
            int r1 = r8.outWidth     // Catch: java.lang.Throwable -> L6c java.io.IOException -> L6f
            r9 = -1
            if (r1 == r9) goto L72
            int r1 = r8.outHeight     // Catch: java.lang.Throwable -> L6c java.io.IOException -> L6f
            if (r1 != r9) goto L56
            goto L72
        L56:
            int r1 = m6904c(r8, r4, r2)     // Catch: java.lang.Throwable -> L6c java.io.IOException -> L6f
            r8.inSampleSize = r1     // Catch: java.lang.Throwable -> L6c java.io.IOException -> L6f
            r8.inDither = r0     // Catch: java.lang.Throwable -> L6c java.io.IOException -> L6f
            android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_8888     // Catch: java.lang.Throwable -> L6c java.io.IOException -> L6f
            r8.inPreferredConfig = r1     // Catch: java.lang.Throwable -> L6c java.io.IOException -> L6f
            r8.inJustDecodeBounds = r0     // Catch: java.lang.Throwable -> L6c java.io.IOException -> L6f
            android.graphics.Bitmap r5 = p035bk.C1248a.m7474e(r10, r6, r8)     // Catch: java.lang.Throwable -> L6c java.io.IOException -> L6f
            m6902a(r7)
            goto L9b
        L6c:
            r10 = move-exception
            r6 = r7
            goto L97
        L6f:
            r10 = move-exception
            r6 = r7
            goto L79
        L72:
            m6902a(r7)
            return r6
        L76:
            r10 = move-exception
            goto L97
        L78:
            r10 = move-exception
        L79:
            java.lang.String r0 = "ImageLocalThumbnailUtil"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L76
            r1.<init>()     // Catch: java.lang.Throwable -> L76
            java.lang.String r2 = "createImageThumbnail error: "
            r1.append(r2)     // Catch: java.lang.Throwable -> L76
            java.lang.String r10 = r10.toString()     // Catch: java.lang.Throwable -> L76
            r1.append(r10)     // Catch: java.lang.Throwable -> L76
            java.lang.String r10 = r1.toString()     // Catch: java.lang.Throwable -> L76
            p031b7.C1120a.m6676e(r0, r10)     // Catch: java.lang.Throwable -> L76
            m6902a(r6)
            goto L9b
        L97:
            m6902a(r6)
            throw r10
        L9b:
            r10 = 3
            if (r11 != r10) goto La3
            r10 = 2
            android.graphics.Bitmap r5 = android.media.ThumbnailUtils.extractThumbnail(r5, r3, r3, r10)
        La3:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p031b7.C1127h.m6905d(java.lang.String, int):android.graphics.Bitmap");
    }

    /* renamed from: e */
    public static void m6906e(String str, int i10, int i11, b bVar) {
        byte[] thumbnail;
        int i12;
        if (str == null) {
            return;
        }
        try {
            thumbnail = new ExifInterface(str).getThumbnail();
        } catch (IOException e10) {
            C1120a.m6676e("ImageLocalThumbnailUtil", "createThumbnailFromEXIF error:" + e10.toString());
            thumbnail = null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        if (thumbnail != null) {
            options2.inJustDecodeBounds = true;
            C1248a.m7471b(thumbnail, 0, thumbnail.length, options2);
            int iM6904c = m6904c(options2, i10, i11);
            options2.inSampleSize = iM6904c;
            i12 = options2.outWidth / iM6904c;
        } else {
            i12 = 0;
        }
        options.inJustDecodeBounds = true;
        C1248a.m7473d(str, options);
        int iM6904c2 = m6904c(options, i10, i11);
        options.inSampleSize = iM6904c2;
        int i13 = options.outWidth / iM6904c2;
        if (thumbnail == null || i12 < i13) {
            options.inJustDecodeBounds = false;
            bVar.f5385a = C1248a.m7473d(str, options);
        } else {
            options2.inJustDecodeBounds = false;
            bVar.f5385a = C1248a.m7471b(thumbnail, 0, thumbnail.length, options2);
        }
    }
}
