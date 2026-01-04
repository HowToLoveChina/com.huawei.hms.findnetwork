package p613rh;

import com.google.flatbuffers.reflection.BaseType;

/* renamed from: rh.a */
/* loaded from: classes4.dex */
public class C12510a {

    /* renamed from: b */
    public int f57617b = 1024;

    /* renamed from: c */
    public int f57618c = 0;

    /* renamed from: a */
    public byte[] f57616a = new byte[1024];

    /* renamed from: a */
    public static String m75103a(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] cArr2 = new char[bArr.length * 2];
        int i10 = 0;
        for (byte b10 : bArr) {
            int i11 = i10 + 1;
            cArr2[i10] = cArr[(b10 >>> 4) & 15];
            i10 += 2;
            cArr2[i11] = cArr[b10 & BaseType.Obj];
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(cArr2);
        return sb2.toString();
    }

    /* renamed from: b */
    public void m75104b() {
        this.f57616a = new byte[this.f57617b];
        this.f57618c = 0;
    }

    /* renamed from: c */
    public void m75105c(byte[] bArr, int i10) {
        if (i10 <= 0) {
            return;
        }
        byte[] bArr2 = this.f57616a;
        int length = bArr2.length;
        int i11 = this.f57618c;
        if (length - i11 >= i10) {
            System.arraycopy(bArr, 0, bArr2, i11, i10);
        } else {
            byte[] bArr3 = new byte[(bArr2.length + i10) << 1];
            System.arraycopy(bArr2, 0, bArr3, 0, i11);
            System.arraycopy(bArr, 0, bArr3, this.f57618c, i10);
            this.f57616a = bArr3;
        }
        this.f57618c += i10;
    }

    /* renamed from: d */
    public byte[] m75106d() {
        int i10 = this.f57618c;
        if (i10 <= 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i10];
        System.arraycopy(this.f57616a, 0, bArr, 0, i10);
        return bArr;
    }

    /* renamed from: e */
    public int m75107e() {
        return this.f57618c;
    }
}
