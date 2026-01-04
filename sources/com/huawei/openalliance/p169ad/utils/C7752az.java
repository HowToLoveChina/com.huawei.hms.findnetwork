package com.huawei.openalliance.p169ad.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C7118fb;
import com.huawei.openalliance.p169ad.C7653sb;
import com.huawei.openalliance.p169ad.C7654sc;
import com.huawei.openalliance.p169ad.analysis.C6922c;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.Scheme;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.views.gif.C8101b;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.huawei.openalliance.ad.utils.az */
/* loaded from: classes2.dex */
public class C7752az {

    /* renamed from: a */
    private static final String f35907a = "az";

    /* renamed from: b */
    private static String f35908b;

    /* renamed from: com.huawei.openalliance.ad.utils.az$a */
    public interface a {
        /* renamed from: a */
        void mo30231a();

        /* renamed from: a */
        void mo30232a(Drawable drawable);
    }

    /* renamed from: a */
    private static int m47683a(InputStream inputStream) {
        try {
            String strM47439a = AbstractC7731ae.m47439a(inputStream);
            if (Constants.GIF_HEADER_HEX.equals(strM47439a)) {
                return 4;
            }
            return strM47439a != null ? 2 : 100;
        } catch (Resources.NotFoundException unused) {
            AbstractC7185ho.m43826d(f35907a, "resId is not found");
            return 100;
        }
    }

    /* renamed from: b */
    public static Bitmap m47693b(Drawable drawable) {
        Bitmap bitmapM47684a;
        if (drawable == null || (bitmapM47684a = m47684a(drawable)) == null) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(-1.0f, 1.0f);
        return Bitmap.createBitmap(bitmapM47684a, 0, 0, bitmapM47684a.getWidth(), bitmapM47684a.getHeight(), matrix, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static Drawable m47697c(String str) {
        return C7751ay.m47678a().m47680a(AbstractC7801cu.m48126a(str));
    }

    /* renamed from: a */
    public static Bitmap m47684a(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            AbstractC7185ho.m43820b(f35907a, "BitmapDrawable");
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicHeight <= 0) {
            intrinsicHeight = 1;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth > 0 ? intrinsicWidth : 1, intrinsicHeight, Bitmap.Config.ARGB_8888);
        m47692a(drawable, bitmapCreateBitmap);
        return bitmapCreateBitmap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r10v5, types: [java.io.Closeable] */
    /* renamed from: c */
    private static Pair<Drawable, String> m47698c(BitmapFactory.Options options, String str, Context context) {
        InputStream inputStream;
        InputStream inputStreamOpenInputStream;
        InputStream inputStream2;
        String str2;
        String str3;
        String str4;
        Uri uriFromFile;
        Pair<Drawable, String> pair;
        ContentResolver contentResolver;
        try {
            try {
                File fileM47453b = AbstractC7731ae.m47453b(context, str, Constants.NORMAL_CACHE);
                if (fileM47453b == null || !AbstractC7731ae.m47464d(fileM47453b)) {
                    fileM47453b = AbstractC7731ae.m47453b(context, str, Constants.TPLATE_CACHE);
                }
                Scheme scheme = Scheme.CONTENT;
                try {
                    if (str.startsWith(scheme.toString())) {
                        uriFromFile = Uri.parse(str);
                    } else {
                        if (fileM47453b == null) {
                            pair = new Pair<>(null, "File is null");
                            AbstractC7805cy.m48142a((Closeable) null);
                            AbstractC7805cy.m48142a((Closeable) null);
                            return pair;
                        }
                        uriFromFile = Uri.fromFile(fileM47453b);
                    }
                    if (m47683a(inputStreamOpenInputStream) == 4) {
                        pair = new Pair<>(str.startsWith(scheme.toString()) ? new C8101b(context, str) : fileM47453b != null ? new C8101b(context, fileM47453b.getCanonicalPath()) : null, null);
                        AbstractC7805cy.m48142a((Closeable) inputStreamOpenInputStream);
                        AbstractC7805cy.m48142a((Closeable) null);
                        return pair;
                    }
                    InputStream inputStreamOpenInputStream2 = contentResolver.openInputStream(uriFromFile);
                    try {
                        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream2, null, options);
                        if (bitmapDecodeStream == null) {
                            AbstractC7185ho.m43820b(f35907a, "Image decode fail");
                            C7787cg.m47900a(context).m47969b((Integer) 0);
                        }
                        return new Pair<>(new BitmapDrawable(context.getResources(), bitmapDecodeStream), null);
                    } catch (FileNotFoundException e10) {
                        e = e10;
                        inputStream2 = inputStreamOpenInputStream2;
                        str2 = "loadDiskImg FileNotFoundException";
                        str3 = f35907a;
                        str4 = "lfP " + e.getClass().getSimpleName();
                        str = inputStream2;
                        AbstractC7185ho.m43823c(str3, str4);
                        return new Pair<>(null, str2);
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = inputStreamOpenInputStream2;
                        str2 = "loadDiskImg " + th.getClass().getSimpleName();
                        str3 = f35907a;
                        str4 = "lfP " + th.getClass().getSimpleName();
                        str = inputStream;
                        AbstractC7185ho.m43823c(str3, str4);
                        return new Pair<>(null, str2);
                    }
                } catch (FileNotFoundException e11) {
                    e = e11;
                    inputStream2 = null;
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = null;
                }
                contentResolver = context.getContentResolver();
                inputStreamOpenInputStream = contentResolver.openInputStream(uriFromFile);
            } catch (FileNotFoundException e12) {
                e = e12;
                inputStream2 = null;
                inputStreamOpenInputStream = null;
            } catch (Throwable th4) {
                th = th4;
                inputStream = null;
                inputStreamOpenInputStream = null;
            }
        } finally {
            AbstractC7805cy.m48142a((Closeable) inputStreamOpenInputStream);
            AbstractC7805cy.m48142a((Closeable) str);
        }
    }

    /* renamed from: a */
    public static Rect m47685a(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        return new Rect(0, 0, options.outWidth, options.outHeight);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* renamed from: b */
    private static Pair<Drawable, String> m47695b(BitmapFactory.Options options, String str, Context context) throws Throwable {
        InputStream inputStreamOpenRawResource;
        String str2;
        String str3;
        String str4;
        int i10;
        Resources resources = context.getResources();
        ?? r22 = 0;
        try {
            try {
                i10 = Integer.parseInt(str.substring(Scheme.RES.toString().length()));
                inputStreamOpenRawResource = resources.openRawResource(i10);
            } catch (Resources.NotFoundException unused) {
                inputStreamOpenRawResource = null;
            } catch (NumberFormatException unused2) {
                inputStreamOpenRawResource = null;
            } catch (Throwable th2) {
                th = th2;
                AbstractC7805cy.m48142a((Closeable) r22);
                throw th;
            }
            try {
                if (m47683a(inputStreamOpenRawResource) == 4) {
                    Pair<Drawable, String> pair = new Pair<>(new C8101b(context, str), null);
                    AbstractC7805cy.m48142a((Closeable) inputStreamOpenRawResource);
                    return pair;
                }
                Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(context.getResources(), i10, options);
                if (bitmapDecodeResource == null) {
                    AbstractC7185ho.m43820b(f35907a, "Image decode fail");
                    C7787cg.m47900a(context).m47969b((Integer) 0);
                }
                Pair<Drawable, String> pair2 = new Pair<>(new BitmapDrawable(context.getResources(), bitmapDecodeResource), null);
                AbstractC7805cy.m48142a((Closeable) inputStreamOpenRawResource);
                return pair2;
            } catch (Resources.NotFoundException unused3) {
                str2 = "loadResImg Resources.NotFoundException";
                str3 = f35907a;
                str4 = "loadImage Resources.NotFoundException";
                AbstractC7185ho.m43823c(str3, str4);
                AbstractC7805cy.m48142a((Closeable) inputStreamOpenRawResource);
                return new Pair<>(null, str2);
            } catch (NumberFormatException unused4) {
                str2 = "loadResImg NumberFormatException";
                str3 = f35907a;
                str4 = "loadImage NumberFormatException";
                AbstractC7185ho.m43823c(str3, str4);
                AbstractC7805cy.m48142a((Closeable) inputStreamOpenRawResource);
                return new Pair<>(null, str2);
            }
        } catch (Throwable th3) {
            th = th3;
            r22 = resources;
            AbstractC7805cy.m48142a((Closeable) r22);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0088  */
    /* JADX WARN: Type inference failed for: r0v11, types: [android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r0v14, types: [android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5, types: [android.graphics.drawable.Drawable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v9, types: [android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r1v4, types: [com.huawei.openalliance.ad.utils.ay] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.util.Pair<android.graphics.drawable.Drawable, java.lang.String> m47686a(android.content.Context r4, java.lang.String r5) {
        /*
            android.graphics.BitmapFactory$Options r0 = new android.graphics.BitmapFactory$Options
            r0.<init>()
            r1 = 0
            r2 = 0
            r0.inJustDecodeBounds = r1     // Catch: java.lang.Throwable -> L27 java.lang.OutOfMemoryError -> L7c
            com.huawei.openalliance.ad.constant.Scheme r1 = com.huawei.openalliance.p169ad.constant.Scheme.RES     // Catch: java.lang.Throwable -> L27 java.lang.OutOfMemoryError -> L7c
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L27 java.lang.OutOfMemoryError -> L7c
            boolean r1 = r5.startsWith(r1)     // Catch: java.lang.Throwable -> L27 java.lang.OutOfMemoryError -> L7c
            if (r1 == 0) goto L29
            android.util.Pair r4 = m47695b(r0, r5, r4)     // Catch: java.lang.Throwable -> L27 java.lang.OutOfMemoryError -> L7c
            java.lang.Object r0 = r4.first     // Catch: java.lang.Throwable -> L27 java.lang.OutOfMemoryError -> L7c
            android.graphics.drawable.Drawable r0 = (android.graphics.drawable.Drawable) r0     // Catch: java.lang.Throwable -> L27 java.lang.OutOfMemoryError -> L7c
            java.lang.Object r4 = r4.second     // Catch: java.lang.Throwable -> L22 java.lang.OutOfMemoryError -> L25
        L1f:
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> L22 java.lang.OutOfMemoryError -> L25
            goto L86
        L22:
            r4 = move-exception
            r2 = r0
            goto L4b
        L25:
            r2 = r0
            goto L7c
        L27:
            r4 = move-exception
            goto L4b
        L29:
            com.huawei.openalliance.ad.constant.Scheme r1 = com.huawei.openalliance.p169ad.constant.Scheme.ASSET     // Catch: java.lang.Throwable -> L27 java.lang.OutOfMemoryError -> L7c
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L27 java.lang.OutOfMemoryError -> L7c
            boolean r1 = r5.startsWith(r1)     // Catch: java.lang.Throwable -> L27 java.lang.OutOfMemoryError -> L7c
            if (r1 == 0) goto L40
            android.util.Pair r4 = m47687a(r0, r5, r4)     // Catch: java.lang.Throwable -> L27 java.lang.OutOfMemoryError -> L7c
            java.lang.Object r0 = r4.first     // Catch: java.lang.Throwable -> L27 java.lang.OutOfMemoryError -> L7c
            android.graphics.drawable.Drawable r0 = (android.graphics.drawable.Drawable) r0     // Catch: java.lang.Throwable -> L27 java.lang.OutOfMemoryError -> L7c
            java.lang.Object r4 = r4.second     // Catch: java.lang.Throwable -> L22 java.lang.OutOfMemoryError -> L25
            goto L1f
        L40:
            android.util.Pair r4 = m47698c(r0, r5, r4)     // Catch: java.lang.Throwable -> L27 java.lang.OutOfMemoryError -> L7c
            java.lang.Object r0 = r4.first     // Catch: java.lang.Throwable -> L27 java.lang.OutOfMemoryError -> L7c
            android.graphics.drawable.Drawable r0 = (android.graphics.drawable.Drawable) r0     // Catch: java.lang.Throwable -> L27 java.lang.OutOfMemoryError -> L7c
            java.lang.Object r4 = r4.second     // Catch: java.lang.Throwable -> L22 java.lang.OutOfMemoryError -> L25
            goto L1f
        L4b:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "loadImageFromDisk "
            r0.append(r1)
            java.lang.Class r4 = r4.getClass()
            java.lang.String r4 = r4.getSimpleName()
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            java.lang.String r0 = com.huawei.openalliance.p169ad.utils.C7752az.f35907a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "loadImage err: "
            r1.append(r3)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43823c(r0, r1)
        L7a:
            r0 = r2
            goto L86
        L7c:
            java.lang.String r4 = com.huawei.openalliance.p169ad.utils.C7752az.f35907a
            java.lang.String r0 = "OutOfMemoryError when read image"
            com.huawei.openalliance.p169ad.AbstractC7185ho.m43823c(r4, r0)
            java.lang.String r4 = "OOM read image"
            goto L7a
        L86:
            if (r0 == 0) goto L93
            com.huawei.openalliance.ad.utils.ay r1 = com.huawei.openalliance.p169ad.utils.C7751ay.m47678a()
            java.lang.String r5 = com.huawei.openalliance.p169ad.utils.AbstractC7801cu.m48126a(r5)
            r1.m47681a(r5, r0)
        L93:
            android.util.Pair r5 = new android.util.Pair
            r5.<init>(r0, r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.utils.C7752az.m47686a(android.content.Context, java.lang.String):android.util.Pair");
    }

    /* renamed from: b */
    public static String m47696b(Context context, String str) {
        if (TextUtils.isEmpty(str) || !str.contains("__source__")) {
            AbstractC7185ho.m43820b(f35907a, "do not need dealUri");
            return str;
        }
        Integer numM47960ac = C7787cg.m47900a(context).m47960ac();
        f35908b = (numM47960ac != null ? numM47960ac.intValue() : 1) == 1 ? "heif" : "webp";
        if (TextUtils.isEmpty(f35908b)) {
            AbstractC7185ho.m43820b(f35907a, "replacedImageType is null, return original url");
            return str;
        }
        AbstractC7185ho.m43821b(f35907a, "dealUri replaceAll by replacedImageType %s", f35908b);
        return str.replaceAll("__source__", f35908b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* renamed from: a */
    private static Pair<Drawable, String> m47687a(BitmapFactory.Options options, String str, Context context) throws Throwable {
        InputStream inputStreamOpen;
        String strSubstring = str.substring(Scheme.ASSET.toString().length());
        ?? r22 = 0;
        try {
            try {
                inputStreamOpen = context.getAssets().open(strSubstring);
            } catch (IOException unused) {
                inputStreamOpen = null;
            } catch (Throwable th2) {
                th = th2;
                AbstractC7805cy.m48142a((Closeable) r22);
                throw th;
            }
            try {
                if (m47683a(inputStreamOpen) == 4) {
                    Pair<Drawable, String> pair = new Pair<>(new C8101b(context, str), null);
                    AbstractC7805cy.m48142a((Closeable) inputStreamOpen);
                    return pair;
                }
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpen, null, options);
                if (bitmapDecodeStream == null) {
                    AbstractC7185ho.m43820b(f35907a, "Image decode fail");
                    C7787cg.m47900a(context).m47969b((Integer) 0);
                }
                Pair<Drawable, String> pair2 = new Pair<>(new BitmapDrawable(context.getResources(), bitmapDecodeStream), null);
                AbstractC7805cy.m48142a((Closeable) inputStreamOpen);
                return pair2;
            } catch (IOException unused2) {
                AbstractC7185ho.m43823c(f35907a, "loadAssetImg IOException");
                AbstractC7805cy.m48142a((Closeable) inputStreamOpen);
                return new Pair<>(null, "loadAssetImg IOException");
            }
        } catch (Throwable th3) {
            th = th3;
            r22 = strSubstring;
            AbstractC7805cy.m48142a((Closeable) r22);
            throw th;
        }
    }

    /* renamed from: a */
    public static void m47689a(final Context context, final C7653sb c7653sb, final a aVar) {
        AbstractC7834m.m48481b(new Runnable() { // from class: com.huawei.openalliance.ad.utils.az.1
            @Override // java.lang.Runnable
            public void run() {
                C7654sc c7654scMo43274a = C7118fb.m43196a(context.getApplicationContext()).mo43274a(c7653sb);
                if (c7654scMo43274a != null && !AbstractC7806cz.m48165b(c7654scMo43274a.m47207a())) {
                    C7752az.m47690a(context, c7654scMo43274a.m47207a(), aVar);
                    return;
                }
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.mo30231a();
                }
            }
        });
    }

    /* renamed from: a */
    public static void m47690a(Context context, String str, a aVar) {
        m47691a(context, str, aVar, null);
    }

    /* renamed from: a */
    public static void m47691a(final Context context, final String str, final a aVar, final ContentRecord contentRecord) {
        if (context != null) {
            context = context.getApplicationContext();
        }
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.utils.az.2
            @Override // java.lang.Runnable
            public void run() {
                String str2;
                boolean z10;
                if (AbstractC7185ho.m43819a()) {
                    AbstractC7185ho.m43818a(C7752az.f35907a, "load image, filePath:%s", AbstractC7819dl.m48375a(str));
                }
                Drawable drawableM47697c = C7752az.m47697c(str);
                if (drawableM47697c == null) {
                    Pair<Drawable, String> pairM47686a = C7752az.m47686a(context, str);
                    Drawable drawable = (Drawable) pairM47686a.first;
                    str2 = (String) pairM47686a.second;
                    drawableM47697c = drawable;
                } else {
                    str2 = null;
                }
                a aVar2 = aVar;
                if (aVar2 != null) {
                    if (drawableM47697c != null) {
                        aVar2.mo30232a(drawableM47697c);
                        return;
                    }
                    boolean z11 = false;
                    boolean z12 = !AbstractC7806cz.m48165b(str) && AbstractC7731ae.m47462c(context, str, Constants.NORMAL_CACHE);
                    if (z12) {
                        z10 = z12;
                    } else {
                        if (!AbstractC7806cz.m48165b(str) && AbstractC7731ae.m47462c(context, str, Constants.TPLATE_CACHE)) {
                            z11 = true;
                        }
                        z10 = z11;
                    }
                    aVar.mo30231a();
                    if (contentRecord != null) {
                        new C6922c(context).m39091a(str, -1, str2, contentRecord, z10);
                    }
                }
            }
        });
    }

    /* renamed from: a */
    private static void m47692a(Drawable drawable, Bitmap bitmap) {
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
    }
}
