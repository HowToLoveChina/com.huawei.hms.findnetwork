package com.huawei.hms.network.file.p130a.p133k.p134b.p135j;

import com.huawei.hms.network.embedded.C6160y1;
import com.huawei.hms.network.file.core.util.FLogger;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.secure.android.common.encrypt.aes.AesGcm;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.huawei.hms.network.file.a.k.b.j.b */
/* loaded from: classes8.dex */
public class C6209b {

    /* renamed from: com.huawei.hms.network.file.a.k.b.j.b$a */
    public static class a extends IOException {
        public a(String str) {
            super(str);
        }
    }

    /* renamed from: com.huawei.hms.network.file.a.k.b.j.b$b */
    public static class b extends IOException {
        public b(String str) {
            super(str);
        }
    }

    /* renamed from: a */
    public static void m36132a() {
        try {
            m36133a(m36134b("encodeString".getBytes(Constants.UTF_8)));
        } catch (IOException e10) {
            FLogger.m36355w(C6160y1.f29130a, "initAesGcm fail", e10);
        }
    }

    /* renamed from: b */
    public static byte[] m36134b(byte[] bArr) throws NoSuchAlgorithmException, a {
        byte[] bArrEncrypt = AesGcm.encrypt(bArr, C6208a.m36131a(true));
        if (bArrEncrypt == null || bArrEncrypt.length == 0) {
            throw new a("Encrypt body failed");
        }
        return bArrEncrypt;
    }

    /* renamed from: a */
    public static byte[] m36133a(byte[] bArr) throws a {
        if (bArr == null || bArr.length == 0) {
            throw new a("Decrypt body is empty");
        }
        try {
            byte[] bArrDecrypt = AesGcm.decrypt(bArr, C6208a.m36131a(false));
            if (bArrDecrypt == null || bArrDecrypt.length == 0) {
                throw new a("Decrypt body failed");
            }
            return bArrDecrypt;
        } catch (IndexOutOfBoundsException unused) {
            throw new a("The cached file is tampered, throw a indexOutOfBoundsException");
        }
    }
}
