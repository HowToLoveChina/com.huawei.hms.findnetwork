package com.huawei.hms.network.embedded;

import com.huawei.secure.android.common.encrypt.aes.AesGcm;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.huawei.hms.network.embedded.y1 */
/* loaded from: classes8.dex */
public class C6160y1 {

    /* renamed from: a */
    public static final String f29130a = "Secure";

    /* renamed from: com.huawei.hms.network.embedded.y1$a */
    public static class a extends IOException {
        public a(String str) {
            super(str);
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.y1$b */
    public static class b extends IOException {
        public b(String str) {
            super(str);
        }
    }

    public static byte[] decryptBody(byte[] bArr) throws IOException {
        if (bArr == null || bArr.length == 0) {
            throw new a("Decrypt body is empty");
        }
        try {
            byte[] bArrDecrypt = AesGcm.decrypt(bArr, C6134w1.m35715a(false));
            if (bArrDecrypt == null || bArrDecrypt.length == 0) {
                throw new a("Decrypt body failed");
            }
            return bArrDecrypt;
        } catch (IndexOutOfBoundsException unused) {
            throw new a("The cached file is tampered, throw a indexOutOfBoundsException");
        }
    }

    public static byte[] encryptBody(byte[] bArr) throws NoSuchAlgorithmException, IOException {
        byte[] bArrEncrypt = AesGcm.encrypt(bArr, C6134w1.m35715a(true));
        if (bArrEncrypt == null || bArrEncrypt.length == 0) {
            throw new a("Encrypt body failed");
        }
        return bArrEncrypt;
    }
}
