package es;

import as.C1016d;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLDecoder;

/* renamed from: es.h */
/* loaded from: classes8.dex */
public class C9543h {
    /* renamed from: a */
    public static void m59589a(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (inputStream == null || outputStream == null) {
            return;
        }
        byte[] bArr = new byte[4096];
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
    public static byte[] m59590b(InputStream inputStream) throws IOException {
        try {
            if (inputStream == null) {
                return new byte[0];
            }
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    m59589a(inputStream, byteArrayOutputStream);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    return byteArray;
                } catch (Throwable th2) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                    throw th2;
                }
            } catch (IOException unused) {
                C1016d.m6181a("HttpUtils", "toByteArray error");
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                    C1016d.m6183c("HttpUtils", "toByteArray close error");
                }
                return new byte[0];
            }
        } finally {
            try {
                inputStream.close();
            } catch (IOException unused3) {
                C1016d.m6183c("HttpUtils", "toByteArray close error");
            }
        }
    }

    /* renamed from: c */
    public static String m59591c(String str) {
        try {
            return URLDecoder.decode(str, Constants.UTF_8);
        } catch (Exception unused) {
            return str;
        }
    }
}
