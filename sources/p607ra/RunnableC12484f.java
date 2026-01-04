package p607ra;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.android.hicloud.drive.clouddisk.model.FileModel;
import hk.C10278a;
import java.io.File;
import p015ak.C0224k0;
import p514o9.C11829c;
import p514o9.C11839m;
import p734wa.C13578b;
import p734wa.C13579c;
import pa.C12123a;
import sk.C12809f;

/* renamed from: ra.f */
/* loaded from: classes3.dex */
public class RunnableC12484f implements Runnable {

    /* renamed from: a */
    public String f57485a;

    /* renamed from: b */
    public String f57486b;

    /* renamed from: c */
    public String f57487c;

    /* renamed from: d */
    public Handler f57488d;

    /* renamed from: e */
    public FileModel f57489e;

    /* renamed from: f */
    public C12123a f57490f = new C12123a();

    /* renamed from: g */
    public int f57491g;

    public RunnableC12484f(FileModel fileModel, Handler handler, int i10) {
        this.f57489e = fileModel;
        this.f57485a = fileModel.getFileId();
        this.f57486b = fileModel.getFileName();
        this.f57487c = fileModel.getThumbnailPath();
        this.f57488d = handler;
        this.f57491g = i10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.io.FileInputStream] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.graphics.Bitmap m74962a(java.io.File r8) throws java.lang.Throwable {
        /*
            r7 = this;
            java.lang.String r7 = "IOException"
            java.lang.String r0 = "ThumbnailThreadForNetdisk"
            r1 = 0
            android.graphics.BitmapFactory$Options r2 = new android.graphics.BitmapFactory$Options     // Catch: java.lang.Throwable -> L4d java.lang.OutOfMemoryError -> L52 java.io.FileNotFoundException -> L54
            r2.<init>()     // Catch: java.lang.Throwable -> L4d java.lang.OutOfMemoryError -> L52 java.io.FileNotFoundException -> L54
            r3 = 1
            r2.inSampleSize = r3     // Catch: java.lang.Throwable -> L4d java.lang.OutOfMemoryError -> L52 java.io.FileNotFoundException -> L54
            java.io.FileInputStream r8 = hk.C10278a.m63444j(r8)     // Catch: java.lang.Throwable -> L4d java.lang.OutOfMemoryError -> L52 java.io.FileNotFoundException -> L54
            android.graphics.Bitmap r2 = p035bk.C1248a.m7476g(r8, r1, r2)     // Catch: java.lang.Throwable -> L4b java.lang.OutOfMemoryError -> L56 java.io.FileNotFoundException -> L79
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4b java.lang.OutOfMemoryError -> L56 java.io.FileNotFoundException -> L79
            r4.<init>()     // Catch: java.lang.Throwable -> L4b java.lang.OutOfMemoryError -> L56 java.io.FileNotFoundException -> L79
            java.lang.String r5 = "decodeFile bitmap is null: "
            r4.append(r5)     // Catch: java.lang.Throwable -> L4b java.lang.OutOfMemoryError -> L56 java.io.FileNotFoundException -> L79
            if (r2 != 0) goto L22
            goto L23
        L22:
            r3 = 0
        L23:
            r4.append(r3)     // Catch: java.lang.Throwable -> L4b java.lang.OutOfMemoryError -> L56 java.io.FileNotFoundException -> L79
            java.lang.String r3 = r4.toString()     // Catch: java.lang.Throwable -> L4b java.lang.OutOfMemoryError -> L56 java.io.FileNotFoundException -> L79
            p514o9.C11839m.m70688i(r0, r3)     // Catch: java.lang.Throwable -> L4b java.lang.OutOfMemoryError -> L56 java.io.FileNotFoundException -> L79
            if (r8 == 0) goto L4a
            r8.close()     // Catch: java.io.IOException -> L33
            goto L4a
        L33:
            r8 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r7)
            java.lang.String r7 = r8.toString()
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            p514o9.C11839m.m70687e(r0, r7)
        L4a:
            return r2
        L4b:
            r1 = move-exception
            goto L8c
        L4d:
            r8 = move-exception
            r6 = r1
            r1 = r8
            r8 = r6
            goto L8c
        L52:
            r8 = r1
            goto L56
        L54:
            r8 = r1
            goto L79
        L56:
            java.lang.String r2 = "OutOfMemoryError"
            p514o9.C11839m.m70687e(r0, r2)     // Catch: java.lang.Throwable -> L4b
            if (r8 == 0) goto L8b
            r8.close()     // Catch: java.io.IOException -> L61
            goto L8b
        L61:
            r8 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
        L67:
            r2.append(r7)
            java.lang.String r7 = r8.toString()
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            p514o9.C11839m.m70687e(r0, r7)
            goto L8b
        L79:
            java.lang.String r2 = "FileNotFoundException"
            p514o9.C11839m.m70687e(r0, r2)     // Catch: java.lang.Throwable -> L4b
            if (r8 == 0) goto L8b
            r8.close()     // Catch: java.io.IOException -> L84
            goto L8b
        L84:
            r8 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            goto L67
        L8b:
            return r1
        L8c:
            if (r8 == 0) goto La9
            r8.close()     // Catch: java.io.IOException -> L92
            goto La9
        L92:
            r8 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r7)
            java.lang.String r7 = r8.toString()
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            p514o9.C11839m.m70687e(r0, r7)
        La9:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p607ra.RunnableC12484f.m74962a(java.io.File):android.graphics.Bitmap");
    }

    /* renamed from: c */
    public final boolean m74963c(String str) {
        if (TextUtils.isEmpty(str)) {
            if (str == null && (str = this.f57490f.m72698n(this.f57491g, this.f57485a)) == null) {
                return true;
            }
        } else if (C11829c.m70540Q0(str).booleanValue()) {
            C11839m.m70688i("ThumbnailThreadForNetdisk", "displayImageViewImpl isThumbnailNotExist");
            return !C11829c.m70542R0(str);
        }
        BitmapDrawable bitmapDrawableM81578d = C13578b.m81574f().m81578d(this.f57485a);
        File fileM63442h = C10278a.m63442h(str);
        if (!fileM63442h.exists()) {
            return true;
        }
        Bitmap bitmap = bitmapDrawableM81578d != null ? bitmapDrawableM81578d.getBitmap() : null;
        if (bitmapDrawableM81578d != null && bitmap != null && !bitmap.isRecycled()) {
            Message messageObtainMessage = this.f57488d.obtainMessage();
            messageObtainMessage.obj = bitmapDrawableM81578d;
            this.f57488d.sendMessage(messageObtainMessage);
            C11839m.m70686d("ThumbnailThreadForNetdisk", "displayImageViewImpl hasBitmap");
            return false;
        }
        Bitmap bitmapM74964d = m74964d(str);
        if (bitmapM74964d == null) {
            C11839m.m70688i("ThumbnailThreadForNetdisk", "displayImageViewImpl bitmap == null delete: " + fileM63442h.delete());
            return true;
        }
        if (bitmapM74964d.isRecycled()) {
            return true;
        }
        C13579c c13579c = new C13579c(C12809f.m76837j(bitmapM74964d, str));
        Message messageObtainMessage2 = this.f57488d.obtainMessage();
        messageObtainMessage2.obj = c13579c;
        this.f57488d.sendMessage(messageObtainMessage2);
        C13578b.m81574f().m81575a(c13579c, this.f57485a);
        C11839m.m70686d("ThumbnailThreadForNetdisk", "displayImageViewImpl bitmap is not Recycled");
        return false;
    }

    /* renamed from: d */
    public final Bitmap m74964d(String str) {
        File fileM63442h = C10278a.m63442h(str);
        if (!fileM63442h.exists() || (fileM63442h.length() <= 1048576 && fileM63442h.length() != 0)) {
            return m74962a(fileM63442h);
        }
        Bitmap bitmapM1548c = C0224k0.m1548c(str, 3);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("getBitmap4NetThumnail mBitmap is null: ");
        sb2.append(bitmapM1548c == null);
        C11839m.m70688i("ThumbnailThreadForNetdisk", sb2.toString());
        return bitmapM1548c;
    }

    @Override // java.lang.Runnable
    public void run() {
        C11839m.m70686d("ThumbnailThreadForNetdisk", "run: " + this.f57486b);
        try {
            boolean zM74963c = m74963c(this.f57487c);
            C11839m.m70686d("ThumbnailThreadForNetdisk", "needDownload: " + zM74963c);
            if (!zM74963c || TextUtils.isEmpty(this.f57485a)) {
                return;
            }
            if (C11829c.m70542R0(this.f57490f.m72698n(this.f57491g, this.f57485a))) {
                C11839m.m70686d("ThumbnailThreadForNetdisk", "no small thumbnail: " + this.f57486b);
                return;
            }
            C11839m.m70686d("ThumbnailThreadForNetdisk", "run getThumbnail: " + this.f57486b);
            new C12479a(this.f57489e, this.f57488d, this.f57491g).m74929a();
        } catch (Exception e10) {
            C11839m.m70687e("ThumbnailThreadForNetdisk", "run error: " + e10.getMessage());
        } catch (OutOfMemoryError unused) {
            C11839m.m70687e("ThumbnailThreadForNetdisk", "out of memory error");
        } catch (Throwable th2) {
            C11839m.m70687e("ThumbnailThreadForNetdisk", "run throwable: " + th2.toString());
        }
    }
}
