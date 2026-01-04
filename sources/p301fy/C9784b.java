package p301fy;

import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import p241dy.C9361b;

/* renamed from: fy.b */
/* loaded from: classes9.dex */
public final class C9784b extends AbstractC9786d {

    /* renamed from: fy.b$b */
    public static final class b extends InputStream {

        /* renamed from: a */
        public final InputStream f48115a;

        /* renamed from: b */
        public final C9790h f48116b;

        /* renamed from: c */
        public final String f48117c;

        /* renamed from: d */
        public final byte[] f48118d;

        /* renamed from: e */
        public boolean f48119e;

        /* renamed from: f */
        public CipherInputStream f48120f;

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            CipherInputStream cipherInputStream = this.f48120f;
            if (cipherInputStream != null) {
                cipherInputStream.close();
            }
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            return m60859s().read();
        }

        /* renamed from: s */
        public final CipherInputStream m60859s() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IOException, InvalidAlgorithmParameterException {
            byte[] bArrM60856f;
            if (this.f48119e) {
                return this.f48120f;
            }
            byte[] bArr = this.f48116b.f48139d;
            if (bArr == null) {
                throw new IOException("Missing AES256 properties in " + this.f48117c);
            }
            if (bArr.length < 2) {
                throw new IOException("AES256 properties too short in " + this.f48117c);
            }
            int i10 = bArr[0];
            int i11 = i10 & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA;
            int i12 = i10 & 63;
            int i13 = bArr[1];
            int i14 = ((i11 >> 6) & 1) + (i13 & 15);
            int i15 = ((i11 >> 7) & 1) + ((i13 & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA) >> 4);
            int i16 = i15 + 2;
            if (i16 + i14 > bArr.length) {
                throw new IOException("Salt size + IV size too long in " + this.f48117c);
            }
            byte[] bArr2 = new byte[i15];
            System.arraycopy(bArr, 2, bArr2, 0, i15);
            byte[] bArr3 = new byte[16];
            System.arraycopy(this.f48116b.f48139d, i16, bArr3, 0, i14);
            byte[] bArr4 = this.f48118d;
            if (bArr4 == null) {
                throw new C9361b(this.f48117c);
            }
            if (i12 == 63) {
                bArrM60856f = new byte[32];
                System.arraycopy(bArr2, 0, bArrM60856f, 0, i15);
                byte[] bArr5 = this.f48118d;
                System.arraycopy(bArr5, 0, bArrM60856f, i15, Math.min(bArr5.length, 32 - i15));
            } else {
                bArrM60856f = C9784b.m60856f(bArr4, i12, bArr2);
            }
            SecretKeySpec secretKeySpecM60855a = C9783a.m60855a(bArrM60856f);
            try {
                Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
                cipher.init(2, secretKeySpecM60855a, new IvParameterSpec(bArr3));
                CipherInputStream cipherInputStream = new CipherInputStream(this.f48115a, cipher);
                this.f48120f = cipherInputStream;
                this.f48119e = true;
                return cipherInputStream;
            } catch (GeneralSecurityException e10) {
                throw new IllegalStateException("Decryption error (do you have the JCE Unlimited Strength Jurisdiction Policy Files installed?)", e10);
            }
        }

        public b(InputStream inputStream, C9790h c9790h, String str, byte[] bArr) {
            this.f48115a = inputStream;
            this.f48116b = c9790h;
            this.f48117c = str;
            this.f48118d = bArr;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i10, int i11) throws IOException {
            return m60859s().read(bArr, i10, i11);
        }
    }

    public C9784b() {
        super(C9783a.class);
    }

    /* renamed from: f */
    public static byte[] m60856f(byte[] bArr, int i10, byte[] bArr2) throws NoSuchAlgorithmException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] bArr3 = new byte[8];
            for (long j10 = 0; j10 < (1 << i10); j10++) {
                messageDigest.update(bArr2);
                messageDigest.update(bArr);
                messageDigest.update(bArr3);
                for (int i11 = 0; i11 < 8; i11++) {
                    byte b10 = (byte) (bArr3[i11] + 1);
                    bArr3[i11] = b10;
                    if (b10 != 0) {
                        break;
                    }
                }
            }
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException e10) {
            throw new IllegalStateException("SHA-256 is unsupported by your Java implementation", e10);
        }
    }

    /* renamed from: g */
    public static byte[] m60857g(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        ByteBuffer byteBufferEncode = StandardCharsets.UTF_16LE.encode(CharBuffer.wrap(cArr));
        if (byteBufferEncode.hasArray()) {
            return byteBufferEncode.array();
        }
        byte[] bArr = new byte[byteBufferEncode.remaining()];
        byteBufferEncode.get(bArr);
        return bArr;
    }

    @Override // p301fy.AbstractC9786d
    /* renamed from: b */
    public InputStream mo60858b(String str, InputStream inputStream, long j10, C9790h c9790h, byte[] bArr, int i10) {
        return new b(inputStream, c9790h, str, bArr);
    }
}
