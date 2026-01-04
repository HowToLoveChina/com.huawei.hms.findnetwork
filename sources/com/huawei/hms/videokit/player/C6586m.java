package com.huawei.hms.videokit.player;

import com.google.flatbuffers.reflection.BaseType;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.UnsupportedEncodingException;

/* renamed from: com.huawei.hms.videokit.player.m */
/* loaded from: classes8.dex */
public final class C6586m {

    /* renamed from: a */
    private static final char[] f30642a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b */
    private static char[] m37560b(byte[] bArr) {
        char[] cArr = new char[bArr.length << 1];
        int i10 = 0;
        for (byte b10 : bArr) {
            int i11 = i10 + 1;
            char[] cArr2 = f30642a;
            cArr[i10] = cArr2[(b10 & 240) >>> 4];
            i10 += 2;
            cArr[i11] = cArr2[b10 & BaseType.Obj];
        }
        return cArr;
    }

    /* renamed from: a */
    public byte[] m37561a(byte[] bArr) {
        if (bArr == null) {
            return new byte[0];
        }
        try {
            return new String(m37560b(bArr)).getBytes(Constants.UTF_8);
        } catch (UnsupportedEncodingException unused) {
            C6550c1.m37262b("HexEncoder", "Error in generate Hex UnsupportedEncodingException");
            return null;
        }
    }
}
