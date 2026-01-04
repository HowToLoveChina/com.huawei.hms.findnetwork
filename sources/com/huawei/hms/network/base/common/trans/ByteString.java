package com.huawei.hms.network.base.common.trans;

import com.google.flatbuffers.reflection.BaseType;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.openalliance.p169ad.constant.Constants;
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

/* loaded from: classes8.dex */
public class ByteString implements Serializable, Comparable<ByteString> {
    public static final int REPLACEMENT_CHARACTER = 65533;

    /* renamed from: d */
    private static final String f26221d = "ByteString";

    /* renamed from: f */
    private static final long f26223f = 1;

    /* renamed from: a */
    final byte[] f26224a;

    /* renamed from: b */
    transient int f26225b;

    /* renamed from: c */
    transient String f26226c;

    /* renamed from: e */
    static final char[] f26222e = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final ByteString EMPTY = m33654of(new byte[0]);

    public ByteString(byte[] bArr) {
        this.f26224a = bArr;
    }

    /* renamed from: a */
    private static int m33645a(char c10) {
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

    public static ByteString decodeBase64(String str) {
        byte[] bArrDecode;
        if (str == null) {
            throw new IllegalArgumentException("base64 == null");
        }
        try {
            bArrDecode = Base64.decode(str);
        } catch (IllegalArgumentException unused) {
            Logger.m32138e(f26221d, "An exception occurred while decoding string with Base64");
            bArrDecode = null;
        }
        if (bArrDecode != null) {
            return new ByteString(bArrDecode);
        }
        return null;
    }

    public static ByteString decodeHex(String str) {
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
            bArr[i10] = (byte) ((m33645a(str.charAt(i11)) << 4) + m33645a(str.charAt(i11 + 1)));
        }
        return m33654of(bArr);
    }

    public static ByteString encodeString(String str, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        }
        if (charset != null) {
            return new ByteString(str.getBytes(charset));
        }
        throw new IllegalArgumentException("charset == null");
    }

    public static ByteString encodeUtf8(String str) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        }
        ByteString byteString = new ByteString(str.getBytes(Charset.forName(Constants.UTF_8)));
        byteString.f26226c = str;
        return byteString;
    }

    /* renamed from: of */
    public static ByteString m33653of(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("data == null");
        }
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        return new ByteString(bArr);
    }

    public static ByteString read(InputStream inputStream, int i10) throws IOException {
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
        return new ByteString(bArr);
    }

    public ByteBuffer asByteBuffer() {
        return ByteBuffer.wrap(this.f26224a).asReadOnlyBuffer();
    }

    public String base64() {
        return Base64.encode(this.f26224a);
    }

    public String base64Url() {
        return Base64.encodeUrl(this.f26224a);
    }

    @Override // java.lang.Comparable
    public int compareTo(ByteString byteString) {
        int size = size();
        int size2 = byteString.size();
        int iMin = Math.min(size, size2);
        for (int i10 = 0; i10 < iMin; i10++) {
            int i11 = getByte(i10) & 255;
            int i12 = byteString.getByte(i10) & 255;
            if (i11 != i12) {
                return i11 < i12 ? -1 : 1;
            }
        }
        if (size == size2) {
            return 0;
        }
        return size < size2 ? -1 : 1;
    }

    public final boolean endsWith(ByteString byteString) {
        return rangeEquals(size() - byteString.size(), byteString, 0, byteString.size());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            int size = byteString.size();
            byte[] bArr = this.f26224a;
            if (size == bArr.length && byteString.rangeEquals(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public byte getByte(int i10) {
        return this.f26224a[i10];
    }

    public int hashCode() {
        int i10 = this.f26225b;
        if (i10 != 0) {
            return i10;
        }
        int iHashCode = Arrays.hashCode(this.f26224a);
        this.f26225b = iHashCode;
        return iHashCode;
    }

    public String hex() {
        byte[] bArr = this.f26224a;
        char[] cArr = new char[bArr.length * 2];
        int i10 = 0;
        for (byte b10 : bArr) {
            int i11 = i10 + 1;
            char[] cArr2 = f26222e;
            cArr[i10] = cArr2[(b10 >> 4) & 15];
            i10 += 2;
            cArr[i11] = cArr2[b10 & BaseType.Obj];
        }
        return String.valueOf(cArr);
    }

    public ByteString hmacSha1(ByteString byteString) {
        return m33648a("HmacSHA1", byteString);
    }

    public ByteString hmacSha256(ByteString byteString) {
        return m33648a("HmacSHA256", byteString);
    }

    public ByteString hmacSha512(ByteString byteString) {
        return m33648a("HmacSHA512", byteString);
    }

    public final int indexOf(ByteString byteString) {
        return indexOf(byteString.m33656a(), 0);
    }

    public final int lastIndexOf(ByteString byteString) {
        return lastIndexOf(byteString.m33656a(), size());
    }

    public ByteString md5() {
        return m33647a("MD5");
    }

    public boolean rangeEquals(int i10, ByteString byteString, int i11, int i12) {
        return byteString.rangeEquals(i11, this.f26224a, i10, i12);
    }

    public ByteString sha1() {
        return m33647a("SHA-1");
    }

    public ByteString sha256() {
        return m33647a("SHA-256");
    }

    public ByteString sha512() {
        return m33647a("SHA-512");
    }

    public int size() {
        return this.f26224a.length;
    }

    public final boolean startsWith(ByteString byteString) {
        return rangeEquals(0, byteString, 0, byteString.size());
    }

    public String string(Charset charset) {
        if (charset != null) {
            return new String(this.f26224a, charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    public ByteString substring(int i10) {
        return substring(i10, this.f26224a.length);
    }

    public ByteString toAsciiLowercase() {
        int i10 = 0;
        while (true) {
            byte[] bArr = this.f26224a;
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
                return new ByteString(bArr2);
            }
            i10++;
        }
    }

    public ByteString toAsciiUppercase() {
        int i10 = 0;
        while (true) {
            byte[] bArr = this.f26224a;
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
                return new ByteString(bArr2);
            }
            i10++;
        }
    }

    public byte[] toByteArray() {
        return (byte[]) this.f26224a.clone();
    }

    public String toString() {
        StringBuilder sb2;
        if (this.f26224a.length == 0) {
            return "[size=0]";
        }
        String strUtf8 = utf8();
        int iM33646a = m33646a(strUtf8, 64);
        if (iM33646a == -1) {
            if (this.f26224a.length <= 64) {
                sb2 = new StringBuilder();
                sb2.append("[hex=");
                sb2.append(hex());
                sb2.append("]");
            } else {
                sb2 = new StringBuilder();
                sb2.append("[size=");
                sb2.append(this.f26224a.length);
                sb2.append(" hex=");
                sb2.append(substring(0, 64).hex());
                sb2.append("…]");
            }
            return sb2.toString();
        }
        String strReplace = StringUtils.replace(StringUtils.replace(StringUtils.replace(StringUtils.substring(strUtf8, 0, iM33646a), "\\", "\\\\"), "\n", "\\n"), "\r", "\\r");
        if (iM33646a >= strUtf8.length()) {
            return "[text=" + strReplace + "]";
        }
        return "[size=" + this.f26224a.length + " text=" + strReplace + "…]";
    }

    public String utf8() {
        String str = this.f26226c;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.f26224a, Charset.forName(Constants.UTF_8));
        this.f26226c = str2;
        return str2;
    }

    public void write(OutputStream outputStream) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        outputStream.write(this.f26224a);
    }

    /* renamed from: a */
    public static int m33646a(String str, int i10) {
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

    /* renamed from: of */
    public static ByteString m33654of(byte... bArr) {
        if (bArr != null) {
            return new ByteString((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public final boolean endsWith(byte[] bArr) {
        return rangeEquals(size() - bArr.length, bArr, 0, bArr.length);
    }

    public final int indexOf(ByteString byteString, int i10) {
        return indexOf(byteString.m33656a(), i10);
    }

    public final int lastIndexOf(ByteString byteString, int i10) {
        return lastIndexOf(byteString.m33656a(), i10);
    }

    public boolean rangeEquals(int i10, byte[] bArr, int i11, int i12) {
        if (i10 >= 0) {
            byte[] bArr2 = this.f26224a;
            if (i10 <= bArr2.length - i12 && i11 >= 0 && i11 <= bArr.length - i12 && m33652a(bArr2, i10, bArr, i11, i12)) {
                return true;
            }
        }
        return false;
    }

    public final boolean startsWith(byte[] bArr) {
        return rangeEquals(0, bArr, 0, bArr.length);
    }

    public ByteString substring(int i10, int i11) {
        if (i10 < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        byte[] bArr = this.f26224a;
        if (i11 > bArr.length) {
            throw new IllegalArgumentException("endIndex > length(" + this.f26224a.length + ")");
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
        return new ByteString(bArr2);
    }

    /* renamed from: a */
    private ByteString m33647a(String str) {
        try {
            return m33654of(MessageDigest.getInstance(str).digest(this.f26224a));
        } catch (NoSuchAlgorithmException e10) {
            throw new AssertionError(e10);
        }
    }

    /* renamed from: of */
    public static ByteString m33655of(byte[] bArr, int i10, int i11) {
        if (bArr == null) {
            throw new IllegalArgumentException("data == null");
        }
        m33649a(bArr.length, i10, i11);
        byte[] bArr2 = new byte[i11];
        System.arraycopy(bArr, i10, bArr2, 0, i11);
        return new ByteString(bArr2);
    }

    public final int indexOf(byte[] bArr) {
        return indexOf(bArr, 0);
    }

    public final int lastIndexOf(byte[] bArr) {
        return lastIndexOf(bArr, size());
    }

    /* renamed from: a */
    private ByteString m33648a(String str, ByteString byteString) throws NoSuchAlgorithmException, InvalidKeyException {
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(byteString.toByteArray(), str));
            return m33654of(mac.doFinal(this.f26224a));
        } catch (InvalidKeyException e10) {
            throw new IllegalArgumentException(e10);
        } catch (NoSuchAlgorithmException e11) {
            throw new AssertionError(e11);
        }
    }

    public int indexOf(byte[] bArr, int i10) {
        int length = this.f26224a.length - bArr.length;
        for (int iMax = Math.max(i10, 0); iMax <= length; iMax++) {
            if (m33652a(this.f26224a, iMax, bArr, 0, bArr.length)) {
                return iMax;
            }
        }
        return -1;
    }

    public int lastIndexOf(byte[] bArr, int i10) {
        for (int iMin = Math.min(i10, this.f26224a.length - bArr.length); iMin >= 0; iMin--) {
            if (m33652a(this.f26224a, iMin, bArr, 0, bArr.length)) {
                return iMin;
            }
        }
        return -1;
    }

    /* renamed from: a */
    private static void m33649a(long j10, long j11, long j12) {
        if ((j11 | j12) < 0 || j11 > j10 || j10 - j11 < j12) {
            throw new ArrayIndexOutOfBoundsException(StringUtils.format("size=%s offset=%s byteCount=%s", Long.valueOf(j10), Long.valueOf(j11), Long.valueOf(j12)));
        }
    }

    /* renamed from: a */
    private void m33650a(ObjectInputStream objectInputStream) throws IllegalAccessException, NoSuchFieldException, IOException, SecurityException, IllegalArgumentException {
        ByteString byteString = read(objectInputStream, objectInputStream.readInt());
        try {
            Field declaredField = ByteString.class.getDeclaredField(VideoPlayFlag.PLAY_IN_ALL);
            declaredField.setAccessible(true);
            declaredField.set(this, byteString.f26224a);
        } catch (IllegalAccessException unused) {
            throw new AssertionError();
        } catch (NoSuchFieldException unused2) {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    private void m33651a(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.f26224a.length);
        objectOutputStream.write(this.f26224a);
    }

    /* renamed from: a */
    private static boolean m33652a(byte[] bArr, int i10, byte[] bArr2, int i11, int i12) {
        for (int i13 = 0; i13 < i12; i13++) {
            if (bArr[i13 + i10] != bArr2[i13 + i11]) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public byte[] m33656a() {
        return this.f26224a;
    }
}
