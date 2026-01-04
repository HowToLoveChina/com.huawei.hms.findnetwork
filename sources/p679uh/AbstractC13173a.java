package p679uh;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;
import th.C13012a;

/* renamed from: uh.a */
/* loaded from: classes4.dex */
public abstract class AbstractC13173a {
    /* renamed from: a */
    public static byte[] m79214a(byte[] bArr) throws Throwable {
        if (bArr == null) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = null;
        try {
            try {
                try {
                    DataOutputStream dataOutputStream2 = new DataOutputStream(new GZIPOutputStream(byteArrayOutputStream, bArr.length));
                    try {
                        dataOutputStream2.write(bArr, 0, bArr.length);
                        dataOutputStream2.flush();
                        dataOutputStream2.close();
                    } catch (IOException e10) {
                        e = e10;
                        dataOutputStream = dataOutputStream2;
                        C13012a.m78316b("GZIPUtil", "gzip error!", e);
                        if (dataOutputStream != null) {
                            dataOutputStream.close();
                        }
                        return byteArrayOutputStream.toByteArray();
                    } catch (Throwable th2) {
                        th = th2;
                        dataOutputStream = dataOutputStream2;
                        if (dataOutputStream != null) {
                            try {
                                dataOutputStream.close();
                            } catch (IOException e11) {
                                C13012a.m78316b("GZIPUtil", "", e11);
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (IOException e12) {
                e = e12;
            }
        } catch (IOException e13) {
            C13012a.m78316b("GZIPUtil", "", e13);
        }
        return byteArrayOutputStream.toByteArray();
    }
}
