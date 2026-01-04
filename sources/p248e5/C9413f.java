package p248e5;

import com.google.flatbuffers.reflection.BaseType;
import com.huawei.android.backup.filelogic.utils.C2111d;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import p699v4.C13339h;

/* renamed from: e5.f */
/* loaded from: classes.dex */
public class C9413f {

    /* renamed from: b */
    public static volatile C9413f f47044b;

    /* renamed from: a */
    public MessageDigest f47045a;

    public C9413f() {
        this.f47045a = null;
        try {
            this.f47045a = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException unused) {
            C2111d.m12648d("Sha256Calculator", "Sha256Calculator get algorithm fail");
        }
    }

    /* renamed from: a */
    public static String m59033a(byte[] bArr, int i10, int i11) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        StringBuilder sb2 = new StringBuilder();
        int i12 = i11 + i10;
        while (i10 < i12) {
            byte b10 = bArr[i10];
            sb2.append(cArr[(b10 >>> 4) & 15]);
            sb2.append(cArr[b10 & BaseType.Obj]);
            i10++;
        }
        return sb2.toString();
    }

    /* renamed from: b */
    public static String m59034b(String str) throws Throwable {
        C9413f c9413fM59035d = m59035d();
        if (str == null) {
            return null;
        }
        c9413fM59035d.m59036c(str);
        byte[] bArrDigest = c9413fM59035d.f47045a.digest();
        c9413fM59035d.f47045a.reset();
        return m59033a(bArrDigest, 0, bArrDigest.length);
    }

    /* renamed from: d */
    public static C9413f m59035d() {
        if (f47044b == null) {
            synchronized (C9413f.class) {
                try {
                    if (f47044b == null) {
                        f47044b = new C9413f();
                    }
                } finally {
                }
            }
        }
        return f47044b;
    }

    /* renamed from: c */
    public final void m59036c(String str) throws Throwable {
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int i10 = fileInputStream2.read(bArr);
                        if (i10 <= 0) {
                            C13339h.m80014a(fileInputStream2);
                            return;
                        }
                        this.f47045a.update(bArr, 0, i10);
                    }
                } catch (FileNotFoundException unused) {
                    fileInputStream = fileInputStream2;
                    C2111d.m12648d("Sha256Calculator", "File path error.");
                    C13339h.m80014a(fileInputStream);
                } catch (IOException unused2) {
                    fileInputStream = fileInputStream2;
                    C2111d.m12648d("Sha256Calculator", "File input stream error.");
                    C13339h.m80014a(fileInputStream);
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    C13339h.m80014a(fileInputStream);
                    throw th;
                }
            } catch (FileNotFoundException unused3) {
            } catch (IOException unused4) {
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
