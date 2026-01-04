package p386j6;

import com.huawei.android.backup.filelogic.utils.C2111d;
import gy.C10064c;
import gy.C10065d;
import gy.C10067f;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import p699v4.C13339h;

/* renamed from: j6.g */
/* loaded from: classes.dex */
public class C10717g {

    /* renamed from: a */
    public static final String f51362a = File.separator;

    /* renamed from: a */
    public static void m65407a(File file, C10067f c10067f, String str) throws Throwable {
        if (file == null || c10067f == null) {
            return;
        }
        if (file.isDirectory()) {
            m65408b(file, c10067f, str);
        } else {
            m65409c(file, c10067f, str);
        }
    }

    /* renamed from: b */
    public static void m65408b(File file, C10067f c10067f, String str) throws IOException {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        if (fileArrListFiles.length < 1) {
            c10067f.m62640D(new C10064c(str + file.getName() + f51362a));
            c10067f.m62654s();
        }
        for (File file2 : fileArrListFiles) {
            m65407a(file2, c10067f, str + file.getName() + f51362a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: c */
    public static void m65409c(File file, C10067f c10067f, String str) throws Throwable {
        if (c10067f == null) {
            return;
        }
        byte[] bArr = null;
        BufferedInputStream bufferedInputStream = 0;
        BufferedInputStream bufferedInputStream2 = 0;
        try {
        } catch (IOException unused) {
            C2111d.m12648d("ZipUtils", "archiveFile error");
            bufferedInputStream2 = bArr;
        }
        try {
            try {
                C10064c c10064c = new C10064c(str + file.getName());
                c10064c.m62592l0(file.length());
                c10067f.m62640D(c10064c);
                BufferedInputStream bufferedInputStream3 = new BufferedInputStream(new FileInputStream(file));
                try {
                    byte[] bArr2 = new byte[1024];
                    while (true) {
                        int i10 = bufferedInputStream3.read(bArr2, 0, 1024);
                        if (i10 == -1) {
                            break;
                        } else {
                            c10067f.write(bArr2, 0, i10);
                        }
                    }
                    bufferedInputStream3.close();
                    bArr = bArr2;
                } catch (IOException unused2) {
                    bufferedInputStream = bufferedInputStream3;
                    C2111d.m12648d("ZipUtils", "archive file fail");
                    bArr = bufferedInputStream;
                    if (bufferedInputStream != 0) {
                        bufferedInputStream.close();
                        bArr = bufferedInputStream;
                    }
                    c10067f.m62654s();
                    bufferedInputStream2 = bArr;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream2 = bufferedInputStream3;
                    if (bufferedInputStream2 != 0) {
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException unused3) {
                            C2111d.m12648d("ZipUtils", "archiveFile error");
                            throw th;
                        }
                    }
                    c10067f.m62654s();
                    throw th;
                }
            } catch (IOException unused4) {
            }
            c10067f.m62654s();
            bufferedInputStream2 = bArr;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* renamed from: d */
    public static void m65410d(File file, C10065d c10065d) throws Throwable {
        if (file == null || c10065d == null) {
            return;
        }
        while (true) {
            C10064c c10064cM62615A = c10065d.m62615A();
            if (c10064cM62615A == null) {
                return;
            }
            File file2 = new File(file.getPath() + File.separator + c10064cM62615A.m62607t());
            if (file2.getCanonicalPath().startsWith(file.getCanonicalPath())) {
                m65412f(file2);
                if (!c10064cM62615A.m62614z()) {
                    m65411e(file2, c10065d);
                } else if (!file2.mkdirs()) {
                    C2111d.m12648d("ZipUtils", "dirFile: mkdir failure");
                    return;
                }
            } else {
                C2111d.m12648d("ZipUtils", "path is invalid, continue");
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* renamed from: e */
    public static void m65411e(File file, C10065d c10065d) throws Throwable {
        ?? r02 = 0;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i10 = c10065d.read(bArr, 0, 1024);
                        if (i10 == -1) {
                            break;
                        } else {
                            bufferedOutputStream2.write(bArr, 0, i10);
                        }
                    }
                    C13339h.m80014a(bufferedOutputStream2);
                    r02 = bArr;
                } catch (IOException unused) {
                    bufferedOutputStream = bufferedOutputStream2;
                    C2111d.m12648d("ZipUtils", "deArchiveFile fail");
                    C13339h.m80014a(bufferedOutputStream);
                    r02 = bufferedOutputStream;
                } catch (Throwable th2) {
                    th = th2;
                    r02 = bufferedOutputStream2;
                    C13339h.m80014a(r02);
                    throw th;
                }
            } catch (IOException unused2) {
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* renamed from: f */
    public static void m65412f(File file) {
        File parentFile = file.getParentFile();
        if (parentFile.exists()) {
            return;
        }
        m65412f(parentFile);
        if (parentFile.mkdir()) {
            return;
        }
        C2111d.m12648d("ZipUtils", "parentFile: mkdir failure");
    }
}
