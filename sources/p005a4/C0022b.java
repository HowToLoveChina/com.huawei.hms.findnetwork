package p005a4;

import com.huawei.android.hicloud.sync.service.aidl.SyncType;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.AEADBadTagException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import p631s3.InterfaceC12678a;

/* renamed from: a4.b */
/* loaded from: classes.dex */
public final class C0022b implements InterfaceC12678a {

    /* renamed from: e */
    public static final ThreadLocal<Cipher> f46e = new a();

    /* renamed from: f */
    public static final ThreadLocal<Cipher> f47f = new b();

    /* renamed from: a */
    public final byte[] f48a;

    /* renamed from: b */
    public final byte[] f49b;

    /* renamed from: c */
    public final SecretKeySpec f50c;

    /* renamed from: d */
    public final int f51d;

    /* renamed from: a4.b$a */
    public class a extends ThreadLocal<Cipher> {
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Cipher initialValue() {
            try {
                return C0033m.f86f.m134a("AES/ECB/NOPADDING");
            } catch (GeneralSecurityException e10) {
                throw new IllegalStateException(e10);
            }
        }
    }

    /* renamed from: a4.b$b */
    public class b extends ThreadLocal<Cipher> {
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Cipher initialValue() {
            try {
                return C0033m.f86f.m134a("AES/CTR/NOPADDING");
            } catch (GeneralSecurityException e10) {
                throw new IllegalStateException(e10);
            }
        }
    }

    public C0022b(byte[] bArr, int i10) throws GeneralSecurityException {
        if (i10 != 12 && i10 != 16) {
            throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
        }
        this.f51d = i10;
        C0043w.m165a(bArr.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        this.f50c = secretKeySpec;
        Cipher cipher = f46e.get();
        cipher.init(1, secretKeySpec);
        byte[] bArrM86c = m86c(cipher.doFinal(new byte[16]));
        this.f48a = bArrM86c;
        this.f49b = m86c(bArrM86c);
    }

    /* renamed from: c */
    public static byte[] m86c(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        int i10 = 0;
        while (i10 < 15) {
            int i11 = i10 + 1;
            bArr2[i10] = (byte) (((bArr[i10] << 1) ^ ((bArr[i11] & 255) >>> 7)) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
            i10 = i11;
        }
        bArr2[15] = (byte) ((bArr[15] << 1) ^ ((bArr[0] & 128) != 0 ? SyncType.RISK_MANAGEMENT_MANUALLY : 0));
        return bArr2;
    }

    /* renamed from: f */
    public static byte[] m87f(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        byte[] bArr3 = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            bArr3[i10] = (byte) (bArr[i10] ^ bArr2[i10]);
        }
        return bArr3;
    }

    @Override // p631s3.InterfaceC12678a
    /* renamed from: a */
    public byte[] mo88a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i10 = this.f51d;
        if (length > 2147483631 - i10) {
            throw new GeneralSecurityException("plaintext too long");
        }
        byte[] bArr3 = new byte[bArr.length + i10 + 16];
        byte[] bArrM161c = C0041u.m161c(i10);
        System.arraycopy(bArrM161c, 0, bArr3, 0, this.f51d);
        Cipher cipher = f46e.get();
        cipher.init(1, this.f50c);
        byte[] bArrM90d = m90d(cipher, 0, bArrM161c, 0, bArrM161c.length);
        byte[] bArr4 = bArr2 == null ? new byte[0] : bArr2;
        byte[] bArrM90d2 = m90d(cipher, 1, bArr4, 0, bArr4.length);
        Cipher cipher2 = f47f.get();
        cipher2.init(1, this.f50c, new IvParameterSpec(bArrM90d));
        cipher2.doFinal(bArr, 0, bArr.length, bArr3, this.f51d);
        byte[] bArrM90d3 = m90d(cipher, 2, bArr3, this.f51d, bArr.length);
        int length2 = bArr.length + this.f51d;
        for (int i11 = 0; i11 < 16; i11++) {
            bArr3[length2 + i11] = (byte) ((bArrM90d2[i11] ^ bArrM90d[i11]) ^ bArrM90d3[i11]);
        }
        return bArr3;
    }

    @Override // p631s3.InterfaceC12678a
    /* renamed from: b */
    public byte[] mo89b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = (bArr.length - this.f51d) - 16;
        if (length < 0) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        Cipher cipher = f46e.get();
        cipher.init(1, this.f50c);
        byte[] bArrM90d = m90d(cipher, 0, bArr, 0, this.f51d);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        byte[] bArr3 = bArr2;
        byte[] bArrM90d2 = m90d(cipher, 1, bArr3, 0, bArr3.length);
        byte[] bArrM90d3 = m90d(cipher, 2, bArr, this.f51d, length);
        int length2 = bArr.length - 16;
        byte b10 = 0;
        for (int i10 = 0; i10 < 16; i10++) {
            b10 = (byte) (b10 | (((bArr[length2 + i10] ^ bArrM90d2[i10]) ^ bArrM90d[i10]) ^ bArrM90d3[i10]));
        }
        if (b10 != 0) {
            throw new AEADBadTagException("tag mismatch");
        }
        Cipher cipher2 = f47f.get();
        cipher2.init(1, this.f50c, new IvParameterSpec(bArrM90d));
        return cipher2.doFinal(bArr, this.f51d, length);
    }

    /* renamed from: d */
    public final byte[] m90d(Cipher cipher, int i10, byte[] bArr, int i11, int i12) throws BadPaddingException, IllegalBlockSizeException {
        byte[] bArr2 = new byte[16];
        bArr2[15] = (byte) i10;
        if (i12 == 0) {
            return cipher.doFinal(m87f(bArr2, this.f48a));
        }
        byte[] bArrDoFinal = cipher.doFinal(bArr2);
        int i13 = 0;
        while (i12 - i13 > 16) {
            for (int i14 = 0; i14 < 16; i14++) {
                bArrDoFinal[i14] = (byte) (bArrDoFinal[i14] ^ bArr[(i11 + i13) + i14]);
            }
            bArrDoFinal = cipher.doFinal(bArrDoFinal);
            i13 += 16;
        }
        return cipher.doFinal(m87f(bArrDoFinal, m91e(Arrays.copyOfRange(bArr, i13 + i11, i11 + i12))));
    }

    /* renamed from: e */
    public final byte[] m91e(byte[] bArr) {
        if (bArr.length == 16) {
            return m87f(bArr, this.f48a);
        }
        byte[] bArrCopyOf = Arrays.copyOf(this.f49b, 16);
        for (int i10 = 0; i10 < bArr.length; i10++) {
            bArrCopyOf[i10] = (byte) (bArrCopyOf[i10] ^ bArr[i10]);
        }
        bArrCopyOf[bArr.length] = (byte) (bArrCopyOf[bArr.length] ^ 128);
        return bArrCopyOf;
    }
}
