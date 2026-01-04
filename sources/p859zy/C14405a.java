package p859zy;

/* renamed from: zy.a */
/* loaded from: classes9.dex */
public class C14405a {
    /* renamed from: a */
    public int m85638a(byte[] bArr, int i10) {
        int length = bArr.length - i10;
        bArr[i10] = -128;
        while (true) {
            i10++;
            if (i10 >= bArr.length) {
                return length;
            }
            bArr[i10] = 0;
        }
    }
}
