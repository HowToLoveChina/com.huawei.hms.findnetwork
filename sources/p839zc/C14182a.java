package p839zc;

import com.huawei.hms.feature.dynamic.p119f.AbstractC5331a;
import fk.C9722c;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import p514o9.C11839m;

/* renamed from: zc.a */
/* loaded from: classes3.dex */
public class C14182a {
    /* renamed from: a */
    public static void m85046a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
        while (true) {
            int i10 = inputStream.read(bArr);
            if (i10 == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, i10);
            }
        }
    }

    /* renamed from: b */
    public static void m85047b(InputStream inputStream, OutputStream outputStream) throws IOException {
        m85046a(new C14183b(inputStream), outputStream);
    }

    /* renamed from: c */
    public static byte[] m85048c(String str) throws C9722c {
        try {
            return m85049d(m85050e(str).getBytes("ASCII"));
        } catch (UnsupportedEncodingException unused) {
            C11839m.m70689w(AbstractC5331a.f24713a, "ASCII is not supported");
            throw new C9722c(2008, "Base64 decode UnsupportedEncodingException", "", "local_pre_sync");
        }
    }

    /* renamed from: d */
    public static byte[] m85049d(byte[] bArr) throws C9722c {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                m85047b(byteArrayInputStream, byteArrayOutputStream);
                try {
                    byteArrayInputStream.close();
                } catch (Throwable unused) {
                    C11839m.m70689w(AbstractC5331a.f24713a, "localByteArrayInputStream close error");
                }
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable unused2) {
                    C11839m.m70689w(AbstractC5331a.f24713a, "localByteArrayOutputStream close error");
                }
                return byteArrayOutputStream.toByteArray();
            } catch (IOException e10) {
                C11839m.m70687e(AbstractC5331a.f24713a, "Unexpected IO error: " + e10.toString());
                throw new C9722c(2008, "Base64 decode IOException", "", "local_pre_sync");
            }
        } finally {
        }
    }

    /* renamed from: e */
    public static String m85050e(String str) {
        int length = str.length();
        char[] cArr = new char[length];
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            char cCharAt = str.charAt(i11);
            if (m85053h(cCharAt)) {
                cArr[i10] = cCharAt;
                i10++;
            }
        }
        return i10 == length ? str : new String(cArr, 0, i10);
    }

    /* renamed from: f */
    public static void m85051f(InputStream inputStream, OutputStream outputStream) throws Throwable {
        C14184c c14184c = null;
        try {
            try {
                C14184c c14184c2 = new C14184c(outputStream, 0);
                try {
                    m85046a(inputStream, c14184c2);
                    c14184c2.close();
                } catch (Exception unused) {
                    c14184c = c14184c2;
                    C11839m.m70686d(AbstractC5331a.f24713a, "encode exception");
                    if (c14184c != null) {
                        c14184c.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    c14184c = c14184c2;
                    if (c14184c != null) {
                        c14184c.close();
                    }
                    throw th;
                }
            } catch (Exception unused2) {
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* renamed from: g */
    public static byte[] m85052g(byte[] bArr) throws C9722c {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                m85051f(byteArrayInputStream, byteArrayOutputStream);
                try {
                    byteArrayInputStream.close();
                } catch (Throwable unused) {
                    C11839m.m70687e(AbstractC5331a.f24713a, "localByteArrayInputStream close fail ");
                }
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable unused2) {
                    C11839m.m70687e(AbstractC5331a.f24713a, "localByteArrayOutputStream close fail ");
                }
                return byteArrayOutputStream.toByteArray();
            } catch (IOException e10) {
                C11839m.m70687e(AbstractC5331a.f24713a, "Unexpected IO error: " + e10.toString());
                throw new C9722c(2008, "Base64 encode IOException", "", "local_pre_sync");
            }
        } finally {
        }
    }

    /* renamed from: h */
    public static boolean m85053h(char c10) {
        return c10 == '=' || (c10 >= 'a' && c10 <= 'z') || ((c10 >= 'A' && c10 <= 'Z') || ((c10 >= '0' && c10 <= '9') || c10 == '+' || c10 == '/'));
    }
}
