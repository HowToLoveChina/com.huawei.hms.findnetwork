package p795y1;

import android.content.ContentResolver;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.load.C1558a;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import p003a2.InterfaceC0007b;

/* renamed from: y1.e */
/* loaded from: classes.dex */
public class C13905e {

    /* renamed from: f */
    public static final C13901a f62253f = new C13901a();

    /* renamed from: a */
    public final C13901a f62254a;

    /* renamed from: b */
    public final InterfaceC13904d f62255b;

    /* renamed from: c */
    public final InterfaceC0007b f62256c;

    /* renamed from: d */
    public final ContentResolver f62257d;

    /* renamed from: e */
    public final List<ImageHeaderParser> f62258e;

    public C13905e(List<ImageHeaderParser> list, InterfaceC13904d interfaceC13904d, InterfaceC0007b interfaceC0007b, ContentResolver contentResolver) {
        this(list, f62253f, interfaceC13904d, interfaceC0007b, contentResolver);
    }

    /* renamed from: a */
    public int m83323a(Uri uri) throws IOException {
        InputStream inputStreamOpenInputStream = null;
        try {
            try {
                inputStreamOpenInputStream = this.f62257d.openInputStream(uri);
                int iM9001b = C1558a.m9001b(this.f62258e, inputStreamOpenInputStream, this.f62256c);
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (IOException unused) {
                    }
                }
                return iM9001b;
            } catch (IOException | NullPointerException e10) {
                if (Log.isLoggable("ThumbStreamOpener", 3)) {
                    Log.d("ThumbStreamOpener", "Failed to open uri: " + uri, e10);
                }
                if (inputStreamOpenInputStream == null) {
                    return -1;
                }
                try {
                    inputStreamOpenInputStream.close();
                    return -1;
                } catch (IOException unused2) {
                    return -1;
                }
            }
        } catch (Throwable th2) {
            if (inputStreamOpenInputStream != null) {
                try {
                    inputStreamOpenInputStream.close();
                } catch (IOException unused3) {
                }
            }
            throw th2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004c  */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String m83324b(android.net.Uri r6) throws java.lang.Throwable {
        /*
            r5 = this;
            java.lang.String r0 = "ThumbStreamOpener"
            r1 = 0
            y1.d r5 = r5.f62255b     // Catch: java.lang.Throwable -> L25 java.lang.SecurityException -> L27
            android.database.Cursor r5 = r5.mo83322a(r6)     // Catch: java.lang.Throwable -> L25 java.lang.SecurityException -> L27
            if (r5 == 0) goto L1f
            boolean r2 = r5.moveToFirst()     // Catch: java.lang.Throwable -> L1a java.lang.SecurityException -> L1d
            if (r2 == 0) goto L1f
            r2 = 0
            java.lang.String r6 = r5.getString(r2)     // Catch: java.lang.Throwable -> L1a java.lang.SecurityException -> L1d
            r5.close()
            return r6
        L1a:
            r6 = move-exception
            r1 = r5
            goto L4a
        L1d:
            r2 = move-exception
            goto L29
        L1f:
            if (r5 == 0) goto L24
            r5.close()
        L24:
            return r1
        L25:
            r6 = move-exception
            goto L4a
        L27:
            r2 = move-exception
            r5 = r1
        L29:
            r3 = 3
            boolean r3 = android.util.Log.isLoggable(r0, r3)     // Catch: java.lang.Throwable -> L1a
            if (r3 == 0) goto L44
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1a
            r3.<init>()     // Catch: java.lang.Throwable -> L1a
            java.lang.String r4 = "Failed to query for thumbnail for Uri: "
            r3.append(r4)     // Catch: java.lang.Throwable -> L1a
            r3.append(r6)     // Catch: java.lang.Throwable -> L1a
            java.lang.String r6 = r3.toString()     // Catch: java.lang.Throwable -> L1a
            android.util.Log.d(r0, r6, r2)     // Catch: java.lang.Throwable -> L1a
        L44:
            if (r5 == 0) goto L49
            r5.close()
        L49:
            return r1
        L4a:
            if (r1 == 0) goto L4f
            r1.close()
        L4f:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p795y1.C13905e.m83324b(android.net.Uri):java.lang.String");
    }

    /* renamed from: c */
    public final boolean m83325c(File file) {
        return this.f62254a.m83310a(file) && 0 < this.f62254a.m83312c(file);
    }

    /* renamed from: d */
    public InputStream m83326d(Uri uri) throws Throwable {
        String strM83324b = m83324b(uri);
        if (TextUtils.isEmpty(strM83324b)) {
            return null;
        }
        File fileM83311b = this.f62254a.m83311b(strM83324b);
        if (!m83325c(fileM83311b)) {
            return null;
        }
        Uri uriFromFile = Uri.fromFile(fileM83311b);
        try {
            return this.f62257d.openInputStream(uriFromFile);
        } catch (NullPointerException e10) {
            throw ((FileNotFoundException) new FileNotFoundException("NPE opening uri: " + uri + " -> " + uriFromFile).initCause(e10));
        }
    }

    public C13905e(List<ImageHeaderParser> list, C13901a c13901a, InterfaceC13904d interfaceC13904d, InterfaceC0007b interfaceC0007b, ContentResolver contentResolver) {
        this.f62254a = c13901a;
        this.f62255b = interfaceC13904d;
        this.f62256c = interfaceC0007b;
        this.f62257d = contentResolver;
        this.f62258e = list;
    }
}
