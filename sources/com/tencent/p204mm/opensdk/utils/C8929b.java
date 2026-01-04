package com.tencent.p204mm.opensdk.utils;

import com.google.flatbuffers.reflection.BaseType;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.tencent.mm.opensdk.utils.b */
/* loaded from: classes9.dex */
public final class C8929b {
    /* renamed from: c */
    public static final String m56645c(byte[] bArr) throws NoSuchAlgorithmException {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            byte[] bArrDigest = messageDigest.digest();
            char[] cArr2 = new char[bArrDigest.length * 2];
            int i10 = 0;
            for (byte b10 : bArrDigest) {
                int i11 = i10 + 1;
                cArr2[i10] = cArr[(b10 >>> 4) & 15];
                i10 += 2;
                cArr2[i11] = cArr[b10 & BaseType.Obj];
            }
            return new String(cArr2);
        } catch (Exception unused) {
            return null;
        }
    }
}
