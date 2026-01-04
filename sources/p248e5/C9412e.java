package p248e5;

import com.huawei.android.backup.filelogic.utils.C2111d;

/* renamed from: e5.e */
/* loaded from: classes.dex */
public class C9412e {
    /* renamed from: a */
    public static boolean m59032a(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            C2111d.m12648d("SecurityUtil", "byte[] is null");
            return false;
        }
        int length = bArr.length ^ bArr2.length;
        for (int i10 = 0; i10 < bArr.length && i10 < bArr2.length; i10++) {
            length |= bArr[i10] ^ bArr2[i10];
        }
        return length == 0;
    }
}
