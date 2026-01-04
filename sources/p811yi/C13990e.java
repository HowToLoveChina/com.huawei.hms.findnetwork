package p811yi;

import com.huawei.cloud.base.util.C4650r;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import vi.C13447b;

/* renamed from: yi.e */
/* loaded from: classes.dex */
public class C13990e {

    /* renamed from: a */
    public static final C4650r f62694a = C4650r.m28485f("HashFile");

    /* renamed from: a */
    public static String m84021a(InputStream inputStream) throws GeneralSecurityException, IOException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] bArr = new byte[8192];
        while (true) {
            int i10 = inputStream.read(bArr);
            if (i10 == -1) {
                return m84023c(messageDigest.digest());
            }
            messageDigest.update(bArr, 0, i10);
        }
    }

    /* renamed from: b */
    public static void m84022b(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e10) {
                f62694a.m28492j("close error: " + e10);
            }
        }
    }

    /* renamed from: c */
    public static String m84023c(byte[] bArr) {
        if (bArr == null) {
            f62694a.m28490g("toHex byteArray is null");
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        for (byte b10 : bArr) {
            int i10 = b10 & 255;
            if (Integer.toHexString(i10).length() == 1) {
                sb2.append("0");
                sb2.append(Integer.toHexString(i10));
            } else {
                sb2.append(Integer.toHexString(i10));
            }
        }
        return sb2.toString();
    }

    /* renamed from: d */
    public static String m84024d(File file) throws Throwable {
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    String strM84021a = m84021a(fileInputStream2);
                    m84022b(fileInputStream2);
                    return strM84021a;
                } catch (IOException | GeneralSecurityException e10) {
                    e = e10;
                    fileInputStream = fileInputStream2;
                    throw new C13447b(900150004, "compute file hash error: " + e.getMessage());
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    m84022b(fileInputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (IOException | GeneralSecurityException e11) {
            e = e11;
        }
    }

    /* renamed from: e */
    public static String m84025e(byte[] bArr) throws Throwable {
        ByteArrayInputStream byteArrayInputStream = null;
        try {
            try {
                ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArr);
                try {
                    String strM84021a = m84021a(byteArrayInputStream2);
                    m84022b(byteArrayInputStream2);
                    return strM84021a;
                } catch (IOException | GeneralSecurityException e10) {
                    e = e10;
                    byteArrayInputStream = byteArrayInputStream2;
                    throw new C13447b(900150004, "compute file hash error: " + e.getMessage());
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayInputStream = byteArrayInputStream2;
                    m84022b(byteArrayInputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (IOException | GeneralSecurityException e11) {
            e = e11;
        }
    }
}
