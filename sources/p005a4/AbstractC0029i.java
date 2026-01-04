package p005a4;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* renamed from: a4.i */
/* loaded from: classes.dex */
public abstract class AbstractC0029i implements InterfaceC0036p {

    /* renamed from: c */
    public static final int[] f76c = m123m(new byte[]{101, 120, 112, 97, 110, 100, 32, 51, 50, 45, 98, 121, 116, 101, 32, 107});

    /* renamed from: a */
    public int[] f77a;

    /* renamed from: b */
    public final int f78b;

    public AbstractC0029i(byte[] bArr, int i10) throws InvalidKeyException {
        if (bArr.length != 32) {
            throw new InvalidKeyException("The key length in bytes must be 32.");
        }
        this.f77a = m123m(bArr);
        this.f78b = i10;
    }

    /* renamed from: i */
    public static void m119i(int[] iArr, int i10, int i11, int i12, int i13) {
        int i14 = iArr[i10] + iArr[i11];
        iArr[i10] = i14;
        int iM120j = m120j(i14 ^ iArr[i13], 16);
        iArr[i13] = iM120j;
        int i15 = iArr[i12] + iM120j;
        iArr[i12] = i15;
        int iM120j2 = m120j(iArr[i11] ^ i15, 12);
        iArr[i11] = iM120j2;
        int i16 = iArr[i10] + iM120j2;
        iArr[i10] = i16;
        int iM120j3 = m120j(iArr[i13] ^ i16, 8);
        iArr[i13] = iM120j3;
        int i17 = iArr[i12] + iM120j3;
        iArr[i12] = i17;
        iArr[i11] = m120j(iArr[i11] ^ i17, 7);
    }

    /* renamed from: j */
    public static int m120j(int i10, int i11) {
        return (i10 >>> (-i11)) | (i10 << i11);
    }

    /* renamed from: k */
    public static void m121k(int[] iArr, int[] iArr2) {
        int[] iArr3 = f76c;
        System.arraycopy(iArr3, 0, iArr, 0, iArr3.length);
        System.arraycopy(iArr2, 0, iArr, iArr3.length, 8);
    }

    /* renamed from: l */
    public static void m122l(int[] iArr) {
        for (int i10 = 0; i10 < 10; i10++) {
            m119i(iArr, 0, 4, 8, 12);
            m119i(iArr, 1, 5, 9, 13);
            m119i(iArr, 2, 6, 10, 14);
            m119i(iArr, 3, 7, 11, 15);
            m119i(iArr, 0, 5, 10, 15);
            m119i(iArr, 1, 6, 11, 12);
            m119i(iArr, 2, 7, 8, 13);
            m119i(iArr, 3, 4, 9, 14);
        }
    }

    /* renamed from: m */
    public static int[] m123m(byte[] bArr) {
        IntBuffer intBufferAsIntBuffer = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
        int[] iArr = new int[intBufferAsIntBuffer.remaining()];
        intBufferAsIntBuffer.get(iArr);
        return iArr;
    }

    @Override // p005a4.InterfaceC0036p
    /* renamed from: a */
    public byte[] mo82a(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length > Integer.MAX_VALUE - mo118g()) {
            throw new GeneralSecurityException("plaintext too long");
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(mo118g() + bArr.length);
        m126f(byteBufferAllocate, bArr);
        return byteBufferAllocate.array();
    }

    @Override // p005a4.InterfaceC0036p
    /* renamed from: b */
    public byte[] mo83b(byte[] bArr) throws GeneralSecurityException {
        return m125e(ByteBuffer.wrap(bArr));
    }

    /* renamed from: c */
    public ByteBuffer m124c(byte[] bArr, int i10) {
        int[] iArrMo117d = mo117d(m123m(bArr), i10);
        int[] iArr = (int[]) iArrMo117d.clone();
        m122l(iArr);
        for (int i11 = 0; i11 < iArrMo117d.length; i11++) {
            iArrMo117d[i11] = iArrMo117d[i11] + iArr[i11];
        }
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.asIntBuffer().put(iArrMo117d, 0, 16);
        return byteBufferOrder;
    }

    /* renamed from: d */
    public abstract int[] mo117d(int[] iArr, int i10);

    /* renamed from: e */
    public byte[] m125e(ByteBuffer byteBuffer) throws GeneralSecurityException {
        if (byteBuffer.remaining() < mo118g()) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        byte[] bArr = new byte[mo118g()];
        byteBuffer.get(bArr);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBuffer.remaining());
        m127h(bArr, byteBufferAllocate, byteBuffer);
        return byteBufferAllocate.array();
    }

    /* renamed from: f */
    public void m126f(ByteBuffer byteBuffer, byte[] bArr) throws GeneralSecurityException {
        if (byteBuffer.remaining() - mo118g() < bArr.length) {
            throw new IllegalArgumentException("Given ByteBuffer output is too small");
        }
        byte[] bArrM161c = C0041u.m161c(mo118g());
        byteBuffer.put(bArrM161c);
        m127h(bArrM161c, byteBuffer, ByteBuffer.wrap(bArr));
    }

    /* renamed from: g */
    public abstract int mo118g();

    /* renamed from: h */
    public final void m127h(byte[] bArr, ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws GeneralSecurityException {
        int iRemaining = byteBuffer2.remaining();
        int i10 = iRemaining / 64;
        int i11 = i10 + 1;
        for (int i12 = 0; i12 < i11; i12++) {
            ByteBuffer byteBufferM124c = m124c(bArr, this.f78b + i12);
            if (i12 == i10) {
                C0027g.m113c(byteBuffer, byteBuffer2, byteBufferM124c, iRemaining % 64);
            } else {
                C0027g.m113c(byteBuffer, byteBuffer2, byteBufferM124c, 64);
            }
        }
    }
}
