package p618rm;

import com.huawei.secure.android.common.util.SafeBase64;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import p508o3.C11799d;
import p514o9.C11839m;

/* renamed from: rm.f */
/* loaded from: classes6.dex */
public class C12550f {
    /* renamed from: a */
    public static String m75504a(C11799d<String> c11799d) {
        return c11799d == null ? "" : m75506c(m75505b(c11799d));
    }

    /* renamed from: b */
    public static byte[] m75505b(C11799d<String> c11799d) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            c11799d.m70332m(byteArrayOutputStream);
        } catch (IOException unused) {
            C11839m.m70687e("BloomFilterUtil", "Write bloom filter to outputStream exception");
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: c */
    public static String m75506c(byte[] bArr) {
        return SafeBase64.encodeToString(bArr, 2);
    }
}
