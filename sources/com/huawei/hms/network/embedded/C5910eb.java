package com.huawei.hms.network.embedded;

import com.google.flatbuffers.reflection.BaseType;
import com.huawei.openalliance.p169ad.constant.VideoPlayFlag;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.huawei.hms.network.embedded.eb */
/* loaded from: classes8.dex */
public class C5910eb implements Serializable, Comparable<C5910eb> {

    /* renamed from: e */
    public static final long f26710e = 1;

    /* renamed from: a */
    public final byte[] f26712a;

    /* renamed from: b */
    public transient int f26713b;

    /* renamed from: c */
    public transient String f26714c;

    /* renamed from: d */
    public static final char[] f26709d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: f */
    public static final C5910eb f26711f = m34158e(new byte[0]);

    public C5910eb(byte[] bArr) {
        this.f26712a = bArr;
    }

    /* renamed from: a */
    public byte mo34159a(int i10) {
        return this.f26712a[i10];
    }

    /* renamed from: b */
    public final int m34171b(C5910eb c5910eb, int i10) {
        return mo34173b(c5910eb.mo34184e(), i10);
    }

    /* renamed from: c */
    public final int m34177c(byte[] bArr) {
        return mo34173b(bArr, mo34192j());
    }

    /* renamed from: d */
    public C5910eb mo34180d(C5910eb c5910eb) {
        return m34149a("HmacSHA256", c5910eb);
    }

    /* renamed from: e */
    public C5910eb m34183e(C5910eb c5910eb) {
        return m34149a("HmacSHA512", c5910eb);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C5910eb) {
            C5910eb c5910eb = (C5910eb) obj;
            int iMo34192j = c5910eb.mo34192j();
            byte[] bArr = this.f26712a;
            if (iMo34192j == bArr.length && c5910eb.mo34169a(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: f */
    public final int m34185f(C5910eb c5910eb) {
        return mo34162a(c5910eb.mo34184e(), 0);
    }

    /* renamed from: g */
    public final int m34187g(C5910eb c5910eb) {
        return mo34173b(c5910eb.mo34184e(), mo34192j());
    }

    /* renamed from: h */
    public C5910eb mo34189h() {
        return m34156c("SHA-256");
    }

    public int hashCode() {
        int i10 = this.f26713b;
        if (i10 != 0) {
            return i10;
        }
        int iHashCode = Arrays.hashCode(this.f26712a);
        this.f26713b = iHashCode;
        return iHashCode;
    }

    /* renamed from: i */
    public C5910eb m34191i() {
        return m34156c("SHA-512");
    }

    /* renamed from: j */
    public int mo34192j() {
        return this.f26712a.length;
    }

    /* renamed from: k */
    public C5910eb mo34193k() {
        int i10 = 0;
        while (true) {
            byte[] bArr = this.f26712a;
            if (i10 >= bArr.length) {
                return this;
            }
            byte b10 = bArr[i10];
            if (b10 >= 65 && b10 <= 90) {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i10] = (byte) (b10 + 32);
                for (int i11 = i10 + 1; i11 < bArr2.length; i11++) {
                    byte b11 = bArr2[i11];
                    if (b11 >= 65 && b11 <= 90) {
                        bArr2[i11] = (byte) (b11 + 32);
                    }
                }
                return new C5910eb(bArr2);
            }
            i10++;
        }
    }

    /* renamed from: l */
    public C5910eb mo34194l() {
        int i10 = 0;
        while (true) {
            byte[] bArr = this.f26712a;
            if (i10 >= bArr.length) {
                return this;
            }
            byte b10 = bArr[i10];
            if (b10 >= 97 && b10 <= 122) {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i10] = (byte) (b10 - 32);
                for (int i11 = i10 + 1; i11 < bArr2.length; i11++) {
                    byte b11 = bArr2[i11];
                    if (b11 >= 97 && b11 <= 122) {
                        bArr2[i11] = (byte) (b11 - 32);
                    }
                }
                return new C5910eb(bArr2);
            }
            i10++;
        }
    }

    /* renamed from: m */
    public byte[] mo34195m() {
        return (byte[]) this.f26712a.clone();
    }

    /* renamed from: n */
    public String mo34196n() {
        String str = this.f26714c;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.f26712a, C5883cc.f26596a);
        this.f26714c = str2;
        return str2;
    }

    public String toString() {
        StringBuilder sb2;
        if (this.f26712a.length == 0) {
            return "[size=0]";
        }
        String strMo34196n = mo34196n();
        int iM34146a = m34146a(strMo34196n, 64);
        if (iM34146a == -1) {
            if (this.f26712a.length <= 64) {
                sb2 = new StringBuilder();
                sb2.append("[hex=");
                sb2.append(mo34181d());
                sb2.append("]");
            } else {
                sb2 = new StringBuilder();
                sb2.append("[size=");
                sb2.append(this.f26712a.length);
                sb2.append(" hex=");
                sb2.append(mo34163a(0, 64).mo34181d());
                sb2.append("…]");
            }
            return sb2.toString();
        }
        String strReplace = strMo34196n.substring(0, iM34146a).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        if (iM34146a >= strMo34196n.length()) {
            return "[text=" + strReplace + "]";
        }
        return "[size=" + this.f26712a.length + " text=" + strReplace + "…]";
    }

    /* renamed from: a */
    public static int m34145a(char c10) {
        if (c10 >= '0' && c10 <= '9') {
            return c10 - '0';
        }
        if (c10 >= 'a' && c10 <= 'f') {
            return c10 - 'W';
        }
        if (c10 >= 'A' && c10 <= 'F') {
            return c10 - '7';
        }
        throw new IllegalArgumentException("Unexpected hex digit: " + c10);
    }

    /* renamed from: d */
    public static C5910eb m34157d(String str) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        }
        C5910eb c5910eb = new C5910eb(str.getBytes(C5883cc.f26596a));
        c5910eb.f26714c = str;
        return c5910eb;
    }

    /* renamed from: e */
    public static C5910eb m34158e(byte... bArr) {
        if (bArr != null) {
            return new C5910eb((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    /* renamed from: b */
    public final int m34172b(byte[] bArr) {
        return mo34162a(bArr, 0);
    }

    /* renamed from: c */
    public C5910eb mo34178c(C5910eb c5910eb) {
        return m34149a("HmacSHA1", c5910eb);
    }

    /* renamed from: f */
    public C5910eb mo34186f() {
        return m34156c("MD5");
    }

    /* renamed from: g */
    public C5910eb mo34188g() {
        return m34156c("SHA-1");
    }

    /* renamed from: h */
    public final boolean m34190h(C5910eb c5910eb) {
        return mo34168a(0, c5910eb, 0, c5910eb.mo34192j());
    }

    /* renamed from: c */
    private C5910eb m34156c(String str) {
        try {
            return m34158e(MessageDigest.getInstance(str).digest(this.f26712a));
        } catch (NoSuchAlgorithmException e10) {
            throw new AssertionError(e10);
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C5910eb c5910eb) {
        int iMo34192j = mo34192j();
        int iMo34192j2 = c5910eb.mo34192j();
        int iMin = Math.min(iMo34192j, iMo34192j2);
        for (int i10 = 0; i10 < iMin; i10++) {
            int iMo34159a = mo34159a(i10) & 255;
            int iMo34159a2 = c5910eb.mo34159a(i10) & 255;
            if (iMo34159a != iMo34159a2) {
                return iMo34159a < iMo34159a2 ? -1 : 1;
            }
        }
        if (iMo34192j == iMo34192j2) {
            return 0;
        }
        return iMo34192j < iMo34192j2 ? -1 : 1;
    }

    /* renamed from: b */
    public int mo34173b(byte[] bArr, int i10) {
        for (int iMin = Math.min(i10, this.f26712a.length - bArr.length); iMin >= 0; iMin--) {
            if (C5883cc.m34090a(this.f26712a, iMin, bArr, 0, bArr.length)) {
                return iMin;
            }
        }
        return -1;
    }

    /* renamed from: d */
    public String mo34181d() {
        byte[] bArr = this.f26712a;
        char[] cArr = new char[bArr.length * 2];
        int i10 = 0;
        for (byte b10 : bArr) {
            int i11 = i10 + 1;
            char[] cArr2 = f26709d;
            cArr[i10] = cArr2[(b10 >> 4) & 15];
            i10 += 2;
            cArr[i11] = cArr2[b10 & BaseType.Obj];
        }
        return new String(cArr);
    }

    /* renamed from: e */
    public byte[] mo34184e() {
        return this.f26712a;
    }

    /* renamed from: a */
    public final int m34161a(C5910eb c5910eb, int i10) {
        return mo34162a(c5910eb.mo34184e(), i10);
    }

    /* renamed from: b */
    public C5910eb mo34174b(int i10) {
        return mo34163a(i10, this.f26712a.length);
    }

    /* renamed from: c */
    public String mo34179c() {
        return C5854ab.m33839b(this.f26712a);
    }

    /* renamed from: d */
    public final boolean m34182d(byte[] bArr) {
        return mo34169a(0, bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public static int m34146a(String str, int i10) {
        int length = str.length();
        int iCharCount = 0;
        int i11 = 0;
        while (iCharCount < length) {
            if (i11 == i10) {
                return iCharCount;
            }
            int iCodePointAt = str.codePointAt(iCharCount);
            if ((Character.isISOControl(iCodePointAt) && iCodePointAt != 10 && iCodePointAt != 13) || iCodePointAt == 65533) {
                return -1;
            }
            i11++;
            iCharCount += Character.charCount(iCodePointAt);
        }
        return str.length();
    }

    /* renamed from: b */
    public static C5910eb m34155b(String str) {
        if (str == null) {
            throw new IllegalArgumentException("hex == null");
        }
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Unexpected hex string: " + str);
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = i10 * 2;
            bArr[i10] = (byte) ((m34145a(str.charAt(i11)) << 4) + m34145a(str.charAt(i11 + 1)));
        }
        return m34158e(bArr);
    }

    /* renamed from: a */
    public int mo34162a(byte[] bArr, int i10) {
        int length = this.f26712a.length - bArr.length;
        for (int iMax = Math.max(i10, 0); iMax <= length; iMax++) {
            if (C5883cc.m34090a(this.f26712a, iMax, bArr, 0, bArr.length)) {
                return iMax;
            }
        }
        return -1;
    }

    /* renamed from: b */
    public String mo34175b() {
        return C5854ab.m33836a(this.f26712a);
    }

    /* renamed from: a */
    public C5910eb mo34163a(int i10, int i11) {
        if (i10 < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        byte[] bArr = this.f26712a;
        if (i11 > bArr.length) {
            throw new IllegalArgumentException("endIndex > length(" + this.f26712a.length + ")");
        }
        int i12 = i11 - i10;
        if (i12 < 0) {
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        if (i10 == 0 && i11 == bArr.length) {
            return this;
        }
        byte[] bArr2 = new byte[i12];
        System.arraycopy(bArr, i10, bArr2, 0, i12);
        return new C5910eb(bArr2);
    }

    /* renamed from: b */
    public final boolean m34176b(C5910eb c5910eb) {
        return mo34168a(mo34192j() - c5910eb.mo34192j(), c5910eb, 0, c5910eb.mo34192j());
    }

    /* renamed from: a */
    public static C5910eb m34147a(InputStream inputStream, int i10) throws IOException {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (i10 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + i10);
        }
        byte[] bArr = new byte[i10];
        int i11 = 0;
        while (i11 < i10) {
            int i12 = inputStream.read(bArr, i11, i10 - i11);
            if (i12 == -1) {
                throw new EOFException();
            }
            i11 += i12;
        }
        return new C5910eb(bArr);
    }

    /* renamed from: a */
    public static C5910eb m34148a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("base64 == null");
        }
        byte[] bArrM33838a = C5854ab.m33838a(str);
        if (bArrM33838a != null) {
            return new C5910eb(bArrM33838a);
        }
        return null;
    }

    /* renamed from: a */
    private C5910eb m34149a(String str, C5910eb c5910eb) throws NoSuchAlgorithmException, InvalidKeyException {
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(c5910eb.mo34195m(), str));
            return m34158e(mac.doFinal(this.f26712a));
        } catch (InvalidKeyException e10) {
            throw new IllegalArgumentException(e10);
        } catch (NoSuchAlgorithmException e11) {
            throw new AssertionError(e11);
        }
    }

    /* renamed from: a */
    public static C5910eb m34150a(String str, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        }
        if (charset != null) {
            return new C5910eb(str.getBytes(charset));
        }
        throw new IllegalArgumentException("charset == null");
    }

    /* renamed from: a */
    public static C5910eb m34151a(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("data == null");
        }
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        return new C5910eb(bArr);
    }

    /* renamed from: a */
    public static C5910eb m34152a(byte[] bArr, int i10, int i11) {
        if (bArr == null) {
            throw new IllegalArgumentException("data == null");
        }
        C5883cc.m34088a(bArr.length, i10, i11);
        byte[] bArr2 = new byte[i11];
        System.arraycopy(bArr, i10, bArr2, 0, i11);
        return new C5910eb(bArr2);
    }

    /* renamed from: a */
    public String mo34164a(Charset charset) {
        if (charset != null) {
            return new String(this.f26712a, charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    /* renamed from: a */
    public ByteBuffer mo34165a() {
        return ByteBuffer.wrap(this.f26712a).asReadOnlyBuffer();
    }

    /* renamed from: a */
    public void mo34166a(C5868bb c5868bb) {
        byte[] bArr = this.f26712a;
        c5868bb.write(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    private void m34153a(ObjectInputStream objectInputStream) throws IllegalAccessException, NoSuchFieldException, IOException, SecurityException, IllegalArgumentException {
        C5910eb c5910ebM34147a = m34147a(objectInputStream, objectInputStream.readInt());
        try {
            Field declaredField = C5910eb.class.getDeclaredField(VideoPlayFlag.PLAY_IN_ALL);
            declaredField.setAccessible(true);
            declaredField.set(this, c5910ebM34147a.f26712a);
        } catch (IllegalAccessException unused) {
            throw new AssertionError();
        } catch (NoSuchFieldException unused2) {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    private void m34154a(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.f26712a.length);
        objectOutputStream.write(this.f26712a);
    }

    /* renamed from: a */
    public void mo34167a(OutputStream outputStream) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        outputStream.write(this.f26712a);
    }

    /* renamed from: a */
    public boolean mo34168a(int i10, C5910eb c5910eb, int i11, int i12) {
        return c5910eb.mo34169a(i11, this.f26712a, i10, i12);
    }

    /* renamed from: a */
    public boolean mo34169a(int i10, byte[] bArr, int i11, int i12) {
        if (i10 >= 0) {
            byte[] bArr2 = this.f26712a;
            if (i10 <= bArr2.length - i12 && i11 >= 0 && i11 <= bArr.length - i12 && C5883cc.m34090a(bArr2, i10, bArr, i11, i12)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public final boolean m34170a(byte[] bArr) {
        return mo34169a(mo34192j() - bArr.length, bArr, 0, bArr.length);
    }
}
