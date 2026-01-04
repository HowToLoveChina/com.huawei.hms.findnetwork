package p328h6;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.backup.filelogic.utils.C2111d;
import gy.C10065d;
import gy.C10067f;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import p699v4.C13339h;

/* renamed from: h6.e */
/* loaded from: classes.dex */
public class C10105e {
    /* renamed from: a */
    public static boolean m62939a(Context context, String str, String str2, int i10) throws Throwable {
        C10067f c10067f;
        Throwable th2;
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            C2111d.m12648d("TarAppDataFile", "archiveFiles param is null");
            return false;
        }
        File file = new File(m62943e(context, str2, i10));
        AbstractC10110j.m62976r(file);
        C10067f c10067f2 = null;
        try {
            try {
                c10067f = new C10067f(new FileOutputStream(file));
                try {
                    c10067f.m62642F(2);
                    File file2 = new File(str);
                    AbstractC10110j.m62961c(file2, c10067f, file2.getParent() + File.separator, str2);
                    C13339h.m80014a(c10067f);
                    return true;
                } catch (FileNotFoundException unused) {
                    c10067f2 = c10067f;
                    C2111d.m12648d("TarAppDataFile", "archiveFiles File not existed ");
                    C13339h.m80014a(c10067f2);
                    return false;
                } catch (IOException unused2) {
                    c10067f2 = c10067f;
                    C2111d.m12648d("TarAppDataFile", "archiveFiles IOException");
                    C13339h.m80014a(c10067f2);
                    return false;
                } catch (Throwable th3) {
                    th2 = th3;
                    C13339h.m80014a(c10067f);
                    throw th2;
                }
            } catch (FileNotFoundException unused3) {
            } catch (IOException unused4) {
            }
        } catch (Throwable th4) {
            c10067f = null;
            th2 = th4;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.io.Closeable] */
    /* renamed from: b */
    public static boolean m62940b(Context context, String str, String str2) throws Throwable {
        StringBuilder sb2;
        boolean z10 = false;
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            C2111d.m12648d("TarAppDataFile", "deArchiveFiles param is null");
            return false;
        }
        String strM62941c = m62941c(context, str2);
        if (strM62941c == null) {
            C2111d.m12648d("TarAppDataFile", "deArchiveFiles destRootPath is null");
            return false;
        }
        File file = new File(str);
        ?? r62 = 0;
        C10065d c10065d = null;
        C10065d c10065d2 = null;
        try {
            try {
                C10065d c10065d3 = new C10065d(new FileInputStream(file));
                r62 = 1;
                try {
                    AbstractC10110j.m62972n(strM62941c, c10065d3, true);
                    C13339h.m80014a(c10065d3);
                    boolean zExists = file.exists();
                    String str3 = file;
                    if (zExists) {
                        boolean zDelete = file.delete();
                        str3 = file;
                        if (!zDelete) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("delete fail: ");
                            String path = file.getPath();
                            sb3.append(path);
                            C2111d.m12648d("TarAppDataFile", sb3.toString());
                            str3 = path;
                        }
                    }
                    z10 = true;
                    file = str3;
                } catch (FileNotFoundException unused) {
                    c10065d = c10065d3;
                    C2111d.m12648d("TarAppDataFile", "dearchive srcFile File not existed ");
                    C13339h.m80014a(c10065d);
                    boolean zExists2 = file.exists();
                    r62 = c10065d;
                    file = file;
                    if (zExists2) {
                        boolean zDelete2 = file.delete();
                        r62 = c10065d;
                        file = file;
                        if (!zDelete2) {
                            sb2 = new StringBuilder();
                            sb2.append("delete fail: ");
                            String path2 = file.getPath();
                            sb2.append(path2);
                            C2111d.m12648d("TarAppDataFile", sb2.toString());
                            r62 = path2;
                            file = file;
                        }
                    }
                    return z10;
                } catch (IOException unused2) {
                    c10065d2 = c10065d3;
                    C2111d.m12648d("TarAppDataFile", "deArchive srcFile IOException");
                    C13339h.m80014a(c10065d2);
                    boolean zExists3 = file.exists();
                    r62 = c10065d2;
                    file = file;
                    if (zExists3) {
                        boolean zDelete3 = file.delete();
                        r62 = c10065d2;
                        file = file;
                        if (!zDelete3) {
                            sb2 = new StringBuilder();
                            sb2.append("delete fail: ");
                            String path22 = file.getPath();
                            sb2.append(path22);
                            C2111d.m12648d("TarAppDataFile", sb2.toString());
                            r62 = path22;
                            file = file;
                        }
                    }
                    return z10;
                } catch (Throwable th2) {
                    th = th2;
                    r62 = c10065d3;
                    C13339h.m80014a(r62);
                    if (file.exists() && !file.delete()) {
                        C2111d.m12648d("TarAppDataFile", "delete fail: " + file.getPath());
                    }
                    throw th;
                }
            } catch (FileNotFoundException unused3) {
            } catch (IOException unused4) {
            }
            return z10;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* renamed from: c */
    public static String m62941c(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(context.getApplicationContext().getFilesDir());
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append("clone");
        sb2.append(str2);
        sb2.append(str);
        return sb2.toString();
    }

    /* renamed from: d */
    public static String m62942d(String str, int i10) {
        String str2;
        if (i10 != 0) {
            str2 = str + "#TwinApp";
        } else {
            str2 = str;
        }
        StringBuilder sb2 = new StringBuilder();
        String str3 = File.separator;
        sb2.append(str3);
        sb2.append(str2);
        sb2.append(str3);
        sb2.append(str);
        sb2.append(".tar");
        return sb2.toString();
    }

    /* renamed from: e */
    public static String m62943e(Context context, String str, int i10) {
        if (context == null) {
            return "";
        }
        return context.getFilesDir() + File.separator + "tarappcache" + m62942d(str, i10);
    }
}
