package p306g2;

import android.graphics.Bitmap;
import p003a2.InterfaceC0007b;
import p759x1.C13683h;
import p759x1.C13684i;
import p759x1.EnumC13678c;
import p759x1.InterfaceC13687l;

/* renamed from: g2.c */
/* loaded from: classes.dex */
public class C9851c implements InterfaceC13687l<Bitmap> {

    /* renamed from: b */
    public static final C13683h<Integer> f48414b = C13683h.m82279f("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);

    /* renamed from: c */
    public static final C13683h<Bitmap.CompressFormat> f48415c = C13683h.m82278e("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");

    /* renamed from: a */
    public final InterfaceC0007b f48416a;

    public C9851c(InterfaceC0007b interfaceC0007b) {
        this.f48416a = interfaceC0007b;
    }

    @Override // p759x1.InterfaceC13687l
    /* renamed from: a */
    public EnumC13678c mo61223a(C13684i c13684i) {
        return EnumC13678c.TRANSFORMED;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0076 A[Catch: all -> 0x0056, TRY_LEAVE, TryCatch #4 {all -> 0x0056, blocks: (B:3:0x0021, B:16:0x0052, B:32:0x0070, B:34:0x0076, B:38:0x00c2, B:39:0x00c5, B:29:0x006b), top: B:49:0x0021 }] */
    @Override // p759x1.InterfaceC13679d
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean mo56815b(p829z1.InterfaceC14083v<android.graphics.Bitmap> r8, java.io.File r9, p759x1.C13684i r10) {
        /*
            r7 = this;
            java.lang.String r0 = "BitmapEncoder"
            java.lang.Object r8 = r8.get()
            android.graphics.Bitmap r8 = (android.graphics.Bitmap) r8
            android.graphics.Bitmap$CompressFormat r1 = r7.m61229d(r8, r10)
            int r2 = r8.getWidth()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            int r3 = r8.getHeight()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.String r4 = "encode: [%dx%d] %s"
            p645t2.C12921b.m77578d(r4, r2, r3, r1)
            long r2 = p630s2.C12672g.m76263b()     // Catch: java.lang.Throwable -> L56
            x1.h<java.lang.Integer> r4 = p306g2.C9851c.f48414b     // Catch: java.lang.Throwable -> L56
            java.lang.Object r4 = r10.m82284c(r4)     // Catch: java.lang.Throwable -> L56
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch: java.lang.Throwable -> L56
            int r4 = r4.intValue()     // Catch: java.lang.Throwable -> L56
            r5 = 0
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L5a java.io.IOException -> L5c
            r6.<init>(r9)     // Catch: java.lang.Throwable -> L5a java.io.IOException -> L5c
            a2.b r9 = r7.f48416a     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L48
            if (r9 == 0) goto L4b
            com.bumptech.glide.load.data.c r9 = new com.bumptech.glide.load.data.c     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L48
            a2.b r7 = r7.f48416a     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L48
            r9.<init>(r6, r7)     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L48
            r5 = r9
            goto L4c
        L44:
            r7 = move-exception
            r5 = r6
            goto Lc0
        L48:
            r7 = move-exception
            r5 = r6
            goto L5d
        L4b:
            r5 = r6
        L4c:
            r8.compress(r1, r4, r5)     // Catch: java.lang.Throwable -> L5a java.io.IOException -> L5c
            r5.close()     // Catch: java.lang.Throwable -> L5a java.io.IOException -> L5c
            r5.close()     // Catch: java.lang.Throwable -> L56 java.io.IOException -> L58
            goto L58
        L56:
            r7 = move-exception
            goto Lc6
        L58:
            r7 = 1
            goto L6f
        L5a:
            r7 = move-exception
            goto Lc0
        L5c:
            r7 = move-exception
        L5d:
            r9 = 3
            boolean r9 = android.util.Log.isLoggable(r0, r9)     // Catch: java.lang.Throwable -> L5a
            if (r9 == 0) goto L69
            java.lang.String r9 = "Failed to encode Bitmap"
            android.util.Log.d(r0, r9, r7)     // Catch: java.lang.Throwable -> L5a
        L69:
            if (r5 == 0) goto L6e
            r5.close()     // Catch: java.lang.Throwable -> L56 java.io.IOException -> L6e
        L6e:
            r7 = 0
        L6f:
            r9 = 2
            boolean r9 = android.util.Log.isLoggable(r0, r9)     // Catch: java.lang.Throwable -> L56
            if (r9 == 0) goto Lbc
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L56
            r9.<init>()     // Catch: java.lang.Throwable -> L56
            java.lang.String r4 = "Compressed with type: "
            r9.append(r4)     // Catch: java.lang.Throwable -> L56
            r9.append(r1)     // Catch: java.lang.Throwable -> L56
            java.lang.String r1 = " of size "
            r9.append(r1)     // Catch: java.lang.Throwable -> L56
            int r1 = p630s2.C12677l.m76284g(r8)     // Catch: java.lang.Throwable -> L56
            r9.append(r1)     // Catch: java.lang.Throwable -> L56
            java.lang.String r1 = " in "
            r9.append(r1)     // Catch: java.lang.Throwable -> L56
            double r1 = p630s2.C12672g.m76262a(r2)     // Catch: java.lang.Throwable -> L56
            r9.append(r1)     // Catch: java.lang.Throwable -> L56
            java.lang.String r1 = ", options format: "
            r9.append(r1)     // Catch: java.lang.Throwable -> L56
            x1.h<android.graphics.Bitmap$CompressFormat> r1 = p306g2.C9851c.f48415c     // Catch: java.lang.Throwable -> L56
            java.lang.Object r10 = r10.m82284c(r1)     // Catch: java.lang.Throwable -> L56
            r9.append(r10)     // Catch: java.lang.Throwable -> L56
            java.lang.String r10 = ", hasAlpha: "
            r9.append(r10)     // Catch: java.lang.Throwable -> L56
            boolean r8 = r8.hasAlpha()     // Catch: java.lang.Throwable -> L56
            r9.append(r8)     // Catch: java.lang.Throwable -> L56
            java.lang.String r8 = r9.toString()     // Catch: java.lang.Throwable -> L56
            android.util.Log.v(r0, r8)     // Catch: java.lang.Throwable -> L56
        Lbc:
            p645t2.C12921b.m77579e()
            return r7
        Lc0:
            if (r5 == 0) goto Lc5
            r5.close()     // Catch: java.lang.Throwable -> L56 java.io.IOException -> Lc5
        Lc5:
            throw r7     // Catch: java.lang.Throwable -> L56
        Lc6:
            p645t2.C12921b.m77579e()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: p306g2.C9851c.mo56815b(z1.v, java.io.File, x1.i):boolean");
    }

    /* renamed from: d */
    public final Bitmap.CompressFormat m61229d(Bitmap bitmap, C13684i c13684i) {
        Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) c13684i.m82284c(f48415c);
        return compressFormat != null ? compressFormat : bitmap.hasAlpha() ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG;
    }
}
