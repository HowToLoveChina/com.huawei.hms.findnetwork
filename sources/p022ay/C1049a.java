package p022ay;

import com.google.flatbuffers.reflection.BaseType;
import p022ay.C1057g;
import p692uw.C13267j;

/* renamed from: ay.a */
/* loaded from: classes9.dex */
public final class C1049a {

    /* renamed from: a */
    public static final byte[] f5117a;

    /* renamed from: b */
    public static final byte[] f5118b;

    static {
        C1057g.a aVar = C1057g.f5135d;
        f5117a = aVar.m6390b("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").m6380q();
        f5118b = aVar.m6390b("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").m6380q();
    }

    /* renamed from: a */
    public static final String m6290a(byte[] bArr, byte[] bArr2) {
        C13267j.m79677e(bArr, "<this>");
        C13267j.m79677e(bArr2, "map");
        byte[] bArr3 = new byte[((bArr.length + 2) / 3) * 4];
        int length = bArr.length - (bArr.length % 3);
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            byte b10 = bArr[i10];
            int i12 = i10 + 2;
            byte b11 = bArr[i10 + 1];
            i10 += 3;
            byte b12 = bArr[i12];
            bArr3[i11] = bArr2[(b10 & 255) >> 2];
            bArr3[i11 + 1] = bArr2[((b10 & 3) << 4) | ((b11 & 255) >> 4)];
            int i13 = i11 + 3;
            bArr3[i11 + 2] = bArr2[((b11 & BaseType.Obj) << 2) | ((b12 & 255) >> 6)];
            i11 += 4;
            bArr3[i13] = bArr2[b12 & 63];
        }
        int length2 = bArr.length - length;
        if (length2 == 1) {
            byte b13 = bArr[i10];
            bArr3[i11] = bArr2[(b13 & 255) >> 2];
            bArr3[i11 + 1] = bArr2[(b13 & 3) << 4];
            bArr3[i11 + 2] = 61;
            bArr3[i11 + 3] = 61;
        } else if (length2 == 2) {
            int i14 = i10 + 1;
            byte b14 = bArr[i10];
            byte b15 = bArr[i14];
            bArr3[i11] = bArr2[(b14 & 255) >> 2];
            bArr3[i11 + 1] = bArr2[((b14 & 3) << 4) | ((b15 & 255) >> 4)];
            bArr3[i11 + 2] = bArr2[(b15 & BaseType.Obj) << 2];
            bArr3[i11 + 3] = 61;
        }
        return C1052b0.m6301b(bArr3);
    }

    /* renamed from: b */
    public static /* synthetic */ String m6291b(byte[] bArr, byte[] bArr2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            bArr2 = f5117a;
        }
        return m6290a(bArr, bArr2);
    }
}
