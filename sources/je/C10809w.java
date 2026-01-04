package je;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import hk.C10278a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import p015ak.C0213f;
import p514o9.C11839m;

/* renamed from: je.w */
/* loaded from: classes3.dex */
public class C10809w {
    /* renamed from: a */
    public static void m65797a() {
        try {
            m65798b(new File(C0213f.m1377a().getFilesDir().getPath() + "/headpic/headpic.png"));
        } catch (NullPointerException unused) {
            C11839m.m70687e("ShowUserPhoto", "deleteHeadPicFile null access.");
        }
    }

    /* renamed from: b */
    public static void m65798b(File file) {
        if (file == null || !file.exists() || file.delete()) {
            return;
        }
        C11839m.m70687e("ShowUserPhoto", "delete file failed");
    }

    /* renamed from: c */
    public static void m65799c() {
        try {
            m65798b(new File(C0213f.m1377a().getFilesDir().getPath() + "/headpic/tmp.png"));
        } catch (NullPointerException unused) {
            C11839m.m70687e("ShowUserPhoto", "deleteTmpHeadPhoto null access.");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0135 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0126 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap m65800d(java.lang.String r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 317
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: je.C10809w.m65800d(java.lang.String):android.graphics.Bitmap");
    }

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x0061: MOVE (r3 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:20:0x0061 */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap m65801e() throws java.lang.Throwable {
        /*
            java.lang.String r0 = "headpic.png"
            java.lang.String r1 = "close error"
            java.lang.String r2 = "ShowUserPhoto"
            r3 = 0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L65 java.lang.OutOfMemoryError -> L67 java.lang.Exception -> L69
            r4.<init>()     // Catch: java.lang.Throwable -> L65 java.lang.OutOfMemoryError -> L67 java.lang.Exception -> L69
            android.content.Context r5 = p015ak.C0213f.m1377a()     // Catch: java.lang.Throwable -> L65 java.lang.OutOfMemoryError -> L67 java.lang.Exception -> L69
            java.io.File r5 = r5.getFilesDir()     // Catch: java.lang.Throwable -> L65 java.lang.OutOfMemoryError -> L67 java.lang.Exception -> L69
            java.lang.String r5 = r5.getPath()     // Catch: java.lang.Throwable -> L65 java.lang.OutOfMemoryError -> L67 java.lang.Exception -> L69
            r4.append(r5)     // Catch: java.lang.Throwable -> L65 java.lang.OutOfMemoryError -> L67 java.lang.Exception -> L69
            java.lang.String r5 = "/headpic/"
            r4.append(r5)     // Catch: java.lang.Throwable -> L65 java.lang.OutOfMemoryError -> L67 java.lang.Exception -> L69
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L65 java.lang.OutOfMemoryError -> L67 java.lang.Exception -> L69
            java.io.File r5 = new java.io.File     // Catch: java.lang.Throwable -> L65 java.lang.OutOfMemoryError -> L67 java.lang.Exception -> L69
            r5.<init>(r4, r0)     // Catch: java.lang.Throwable -> L65 java.lang.OutOfMemoryError -> L67 java.lang.Exception -> L69
            boolean r5 = r5.exists()     // Catch: java.lang.Throwable -> L65 java.lang.OutOfMemoryError -> L67 java.lang.Exception -> L69
            if (r5 != 0) goto L30
            return r3
        L30:
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L65 java.lang.OutOfMemoryError -> L67 java.lang.Exception -> L69
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L65 java.lang.OutOfMemoryError -> L67 java.lang.Exception -> L69
            r6.<init>()     // Catch: java.lang.Throwable -> L65 java.lang.OutOfMemoryError -> L67 java.lang.Exception -> L69
            r6.append(r4)     // Catch: java.lang.Throwable -> L65 java.lang.OutOfMemoryError -> L67 java.lang.Exception -> L69
            r6.append(r0)     // Catch: java.lang.Throwable -> L65 java.lang.OutOfMemoryError -> L67 java.lang.Exception -> L69
            java.lang.String r0 = r6.toString()     // Catch: java.lang.Throwable -> L65 java.lang.OutOfMemoryError -> L67 java.lang.Exception -> L69
            r5.<init>(r0)     // Catch: java.lang.Throwable -> L65 java.lang.OutOfMemoryError -> L67 java.lang.Exception -> L69
            android.graphics.Bitmap r0 = p035bk.C1248a.m7475f(r5)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63 java.lang.OutOfMemoryError -> L6c
            if (r0 != 0) goto L52
            r5.close()     // Catch: java.lang.Throwable -> L4e
            goto L51
        L4e:
            p514o9.C11839m.m70687e(r2, r1)
        L51:
            return r3
        L52:
            r4 = 1073741824(0x40000000, float:2.0)
            android.graphics.Bitmap r0 = m65804h(r0, r4)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63 java.lang.OutOfMemoryError -> L6c
            r5.close()     // Catch: java.lang.Throwable -> L5c
            goto L5f
        L5c:
            p514o9.C11839m.m70687e(r2, r1)
        L5f:
            return r0
        L60:
            r0 = move-exception
            r3 = r5
            goto L8c
        L63:
            r0 = move-exception
            goto L7b
        L65:
            r0 = move-exception
            goto L8c
        L67:
            r5 = r3
            goto L6c
        L69:
            r0 = move-exception
            r5 = r3
            goto L7b
        L6c:
            java.lang.String r0 = "OutOfMemoryError error"
            p514o9.C11839m.m70687e(r2, r0)     // Catch: java.lang.Throwable -> L60
            if (r5 == 0) goto L7a
            r5.close()     // Catch: java.lang.Throwable -> L77
            goto L7a
        L77:
            p514o9.C11839m.m70687e(r2, r1)
        L7a:
            return r3
        L7b:
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L60
            p514o9.C11839m.m70687e(r2, r0)     // Catch: java.lang.Throwable -> L60
            if (r5 == 0) goto L8b
            r5.close()     // Catch: java.lang.Throwable -> L88
            goto L8b
        L88:
            p514o9.C11839m.m70687e(r2, r1)
        L8b:
            return r3
        L8c:
            if (r3 == 0) goto L95
            r3.close()     // Catch: java.lang.Throwable -> L92
            goto L95
        L92:
            p514o9.C11839m.m70687e(r2, r1)
        L95:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: je.C10809w.m65801e():android.graphics.Bitmap");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:30:0x0074
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1178)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /* renamed from: f */
    public static void m65802f(android.graphics.Bitmap r6) {
        /*
            java.lang.String r0 = "close error"
            java.lang.String r1 = "ShowUserPhoto"
            if (r6 == 0) goto Lbb
            r2 = 0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3e java.lang.RuntimeException -> L40
            r3.<init>()     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3e java.lang.RuntimeException -> L40
            android.content.Context r4 = p015ak.C0213f.m1377a()     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3e java.lang.RuntimeException -> L40
            java.io.File r4 = r4.getFilesDir()     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3e java.lang.RuntimeException -> L40
            java.lang.String r4 = r4.getPath()     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3e java.lang.RuntimeException -> L40
            r3.append(r4)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3e java.lang.RuntimeException -> L40
            java.lang.String r4 = "/headpic/"
            r3.append(r4)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3e java.lang.RuntimeException -> L40
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3e java.lang.RuntimeException -> L40
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3e java.lang.RuntimeException -> L40
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3e java.lang.RuntimeException -> L40
            boolean r5 = r4.isDirectory()     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3e java.lang.RuntimeException -> L40
            if (r5 != 0) goto L42
            boolean r4 = r4.mkdir()     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3e java.lang.RuntimeException -> L40
            if (r4 != 0) goto L42
            java.lang.String r6 = "saveBitmapToFile fail"
            p514o9.C11839m.m70687e(r1, r6)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3e java.lang.RuntimeException -> L40
            return
        L3b:
            r6 = move-exception
            goto Lb1
        L3e:
            r6 = move-exception
            goto L78
        L40:
            r6 = move-exception
            goto L96
        L42:
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3e java.lang.RuntimeException -> L40
            java.lang.String r5 = "headpic.png"
            r4.<init>(r3, r5)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3e java.lang.RuntimeException -> L40
            m65798b(r4)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3e java.lang.RuntimeException -> L40
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3e java.lang.RuntimeException -> L40
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3e java.lang.RuntimeException -> L40
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L65 java.lang.RuntimeException -> L68
            r4 = 80
            boolean r6 = r6.compress(r2, r4, r3)     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L65 java.lang.RuntimeException -> L68
            if (r6 == 0) goto L6b
            r3.flush()     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L65 java.lang.RuntimeException -> L68
            r3.close()     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L65 java.lang.RuntimeException -> L68
            goto L70
        L62:
            r6 = move-exception
            r2 = r3
            goto Lb1
        L65:
            r6 = move-exception
            r2 = r3
            goto L78
        L68:
            r6 = move-exception
            r2 = r3
            goto L96
        L6b:
            java.lang.String r6 = "write Bitmap to OutputStream failed"
            p514o9.C11839m.m70687e(r1, r6)     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L65 java.lang.RuntimeException -> L68
        L70:
            r3.close()     // Catch: java.lang.Throwable -> L74
            goto Lbb
        L74:
            p514o9.C11839m.m70687e(r1, r0)
            goto Lbb
        L78:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3b
            r3.<init>()     // Catch: java.lang.Throwable -> L3b
            java.lang.String r4 = "saveBitmap error: "
            r3.append(r4)     // Catch: java.lang.Throwable -> L3b
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L3b
            r3.append(r6)     // Catch: java.lang.Throwable -> L3b
            java.lang.String r6 = r3.toString()     // Catch: java.lang.Throwable -> L3b
            p514o9.C11839m.m70687e(r1, r6)     // Catch: java.lang.Throwable -> L3b
            if (r2 == 0) goto Lbb
        L92:
            r2.close()     // Catch: java.lang.Throwable -> L74
            goto Lbb
        L96:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3b
            r3.<init>()     // Catch: java.lang.Throwable -> L3b
            java.lang.String r4 = "save error: "
            r3.append(r4)     // Catch: java.lang.Throwable -> L3b
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L3b
            r3.append(r6)     // Catch: java.lang.Throwable -> L3b
            java.lang.String r6 = r3.toString()     // Catch: java.lang.Throwable -> L3b
            p514o9.C11839m.m70687e(r1, r6)     // Catch: java.lang.Throwable -> L3b
            if (r2 == 0) goto Lbb
            goto L92
        Lb1:
            if (r2 == 0) goto Lba
            r2.close()     // Catch: java.lang.Throwable -> Lb7
            goto Lba
        Lb7:
            p514o9.C11839m.m70687e(r1, r0)
        Lba:
            throw r6
        Lbb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: je.C10809w.m65802f(android.graphics.Bitmap):void");
    }

    /* renamed from: g */
    public static long m65803g(InputStream inputStream) throws Throwable {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File file = new File(C0213f.m1377a().getFilesDir().getPath() + "/headpic/tmp.png");
                File fileM63437c = C10278a.m63437c(file);
                if (fileM63437c != null && !fileM63437c.exists() && !fileM63437c.mkdirs()) {
                    C11839m.m70688i("ShowUserPhoto", "mkdirs faile");
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e10) {
                            C11839m.m70687e("ShowUserPhoto", "error e = " + e10.getMessage());
                        }
                    }
                    return 0L;
                }
                if (!file.exists() && !file.createNewFile()) {
                    C11839m.m70688i("ShowUserPhoto", "createNewFile faile");
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e11) {
                            C11839m.m70687e("ShowUserPhoto", "error e = " + e11.getMessage());
                        }
                    }
                    return 0L;
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[16384];
                    if (inputStream != null) {
                        while (true) {
                            int i10 = inputStream.read(bArr);
                            if (i10 <= 0) {
                                break;
                            }
                            fileOutputStream2.write(bArr, 0, i10);
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e12) {
                            C11839m.m70687e("ShowUserPhoto", "error e = " + e12.getMessage());
                        }
                    }
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e13) {
                        C11839m.m70687e("ShowUserPhoto", "error e = " + e13.getMessage());
                    }
                    return file.length();
                } catch (IOException unused) {
                    fileOutputStream = fileOutputStream2;
                    C11839m.m70687e("ShowUserPhoto", "saveHeadPhoto IOException");
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e14) {
                            C11839m.m70687e("ShowUserPhoto", "error e = " + e14.getMessage());
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e15) {
                            C11839m.m70687e("ShowUserPhoto", "error e = " + e15.getMessage());
                        }
                    }
                    return 0L;
                } catch (NullPointerException unused2) {
                    fileOutputStream = fileOutputStream2;
                    C11839m.m70687e("ShowUserPhoto", "saveTmpHeadPhoto null access.");
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e16) {
                            C11839m.m70687e("ShowUserPhoto", "error e = " + e16.getMessage());
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e17) {
                            C11839m.m70687e("ShowUserPhoto", "error e = " + e17.getMessage());
                        }
                    }
                    return 0L;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e18) {
                            C11839m.m70687e("ShowUserPhoto", "error e = " + e18.getMessage());
                        }
                    }
                    if (fileOutputStream == null) {
                        throw th;
                    }
                    try {
                        fileOutputStream.close();
                        throw th;
                    } catch (IOException e19) {
                        C11839m.m70687e("ShowUserPhoto", "error e = " + e19.getMessage());
                        throw th;
                    }
                }
            } catch (IOException unused3) {
            } catch (NullPointerException unused4) {
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* renamed from: h */
    public static Bitmap m65804h(Bitmap bitmap, float f10) {
        if (bitmap == null || f10 == 0.0f) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawRoundRect(rectF, bitmap.getWidth() / f10, bitmap.getHeight() / f10, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return bitmapCreateBitmap;
    }
}
