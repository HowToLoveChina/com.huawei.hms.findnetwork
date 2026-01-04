package com.huawei.hms.ads.identifier;

import android.util.Log;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.huawei.hms.ads.identifier.i */
/* loaded from: classes8.dex */
public class C5075i {
    /* renamed from: a */
    public static byte[] m30315a(byte[] bArr) {
        try {
            return MessageDigest.getInstance("SHA-256").digest(bArr);
        } catch (NoSuchAlgorithmException unused) {
            Log.e("Sha256Util", "sha256 NoSuchAlgorithmException");
            return new byte[0];
        }
    }
}
