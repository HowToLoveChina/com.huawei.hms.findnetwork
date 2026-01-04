package com.huawei.updatesdk.p177a.p178a.p183d;

import com.google.flatbuffers.reflection.BaseType;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.UnsupportedEncodingException;

/* renamed from: com.huawei.updatesdk.a.a.d.b */
/* loaded from: classes9.dex */
public class C8780b {

    /* renamed from: b */
    private int f45073b = 1024;

    /* renamed from: c */
    private int f45074c = 0;

    /* renamed from: a */
    private byte[] f45072a = new byte[1024];

    /* renamed from: a */
    public String m56035a() {
        int i10 = this.f45074c;
        if (i10 <= 0) {
            return null;
        }
        try {
            return new String(this.f45072a, 0, i10, Constants.UTF_8);
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static String m56034a(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] cArr2 = new char[bArr.length * 2];
        int i10 = 0;
        for (byte b10 : bArr) {
            int i11 = i10 + 1;
            cArr2[i10] = cArr[(b10 >>> 4) & 15];
            i10 += 2;
            cArr2[i11] = cArr[b10 & BaseType.Obj];
        }
        return String.valueOf(cArr2);
    }

    /* renamed from: a */
    public void m56036a(byte[] bArr, int i10) {
        if (i10 <= 0) {
            return;
        }
        byte[] bArr2 = this.f45072a;
        int length = bArr2.length;
        int i11 = this.f45074c;
        if (length - i11 >= i10) {
            System.arraycopy(bArr, 0, bArr2, i11, i10);
        } else {
            byte[] bArr3 = new byte[(bArr2.length + i10) << 1];
            System.arraycopy(bArr2, 0, bArr3, 0, i11);
            System.arraycopy(bArr, 0, bArr3, this.f45074c, i10);
            this.f45072a = bArr3;
        }
        this.f45074c += i10;
    }
}
