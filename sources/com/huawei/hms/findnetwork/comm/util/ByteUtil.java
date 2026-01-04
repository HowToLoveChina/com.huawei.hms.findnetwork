package com.huawei.hms.findnetwork.comm.util;

import android.text.TextUtils;
import com.huawei.hms.findnetwork.comm.log.HmsFindLog;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

/* loaded from: classes8.dex */
public class ByteUtil {
    private static final int BRIEF_LIMIT = 6;
    private static final int BYTE_LEN = 8;
    private static final int HEX_CHAR_BYTES = 2;
    private static final int MAC_BYTES_LEN = 6;
    private static final int MAC_LEN = 12;
    private static final int RADIX_16 = 16;
    private static final String SHA256 = "SHA-256";
    private static final int SHIFT_4BITS = 4;
    private static final String TAG = "ByteUtil";

    public static String byte2hex(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            HmsFindLog.m31928e(TAG, "Illegal Argument in bytes to hex.");
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        for (byte b10 : bArr) {
            String hexString = Integer.toHexString(b10 & 255);
            if (hexString.length() == 1) {
                sb2.append('0');
            }
            sb2.append(hexString);
        }
        return sb2.toString().toUpperCase(Locale.ENGLISH);
    }

    public static int byteArrayToInt(byte[] bArr) {
        if (bArr == null) {
            return 0;
        }
        return ByteBuffer.wrap(bArr).asReadOnlyBuffer().getInt();
    }

    public static long byteArrayToLong(byte[] bArr) {
        if (bArr == null) {
            return 0L;
        }
        return ByteBuffer.wrap(bArr).asReadOnlyBuffer().getLong();
    }

    public static short byteArrayToShort(byte[] bArr) {
        if (bArr == null) {
            return (short) 0;
        }
        return ByteBuffer.wrap(bArr).asReadOnlyBuffer().getShort();
    }

    public static float byteToFloat(byte[] bArr) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.put(bArr, 0, bArr.length);
        byteBufferAllocate.flip();
        return byteBufferAllocate.getFloat();
    }

    public static long byteToLong(byte[] bArr) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.put(bArr, 0, bArr.length);
        byteBufferAllocate.flip();
        return byteBufferAllocate.getLong();
    }

    public static String bytesToHexMac(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < bArr.length; i10++) {
            String hexString = Integer.toHexString(bArr[i10] & 255);
            if (hexString.length() < 2) {
                sb2.append(0);
            }
            sb2.append(hexString.toUpperCase(Locale.getDefault()));
            if (i10 < bArr.length - 1) {
                sb2.append(":");
            }
        }
        return sb2.toString();
    }

    public static String bytesToHexString(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        for (byte b10 : bArr) {
            String hexString = Integer.toHexString(b10 & 255);
            if (hexString.length() < 2) {
                sb2.append(0);
            }
            sb2.append(hexString.toUpperCase(Locale.getDefault()));
        }
        return sb2.toString();
    }

    public static int bytesToIntBig(byte[] bArr) {
        if (bArr.length != 4) {
            return 0;
        }
        int i10 = (bArr[0] & 255) << 24;
        int i11 = (bArr[1] & 255) << 16;
        return i10 | i11 | ((bArr[2] & 255) << 8) | (bArr[3] & 255);
    }

    public static int bytesToIntLittle(byte[] bArr) {
        if (bArr.length != 4) {
            return 0;
        }
        int i10 = (bArr[3] & 255) << 24;
        int i11 = (bArr[2] & 255) << 16;
        return i10 | i11 | ((bArr[1] & 255) << 8) | (bArr[0] & 255);
    }

    public static long bytesToLong(byte[] bArr, int i10, boolean z10) {
        long j10 = 0;
        for (int i11 = 0; i11 < 8; i11++) {
            int i12 = (z10 ? i11 : 7 - i11) << 3;
            j10 |= (255 << i12) & (bArr[i10 + i11] << i12);
        }
        return j10;
    }

    public static short bytesToShortBig(byte[] bArr) {
        if (bArr.length != 2) {
            return (short) 0;
        }
        return (short) ((bArr[1] & 255) | ((bArr[0] & 255) << 8));
    }

    public static short bytesToShortLittle(byte[] bArr) {
        if (bArr.length != 2) {
            return (short) 0;
        }
        return (short) ((bArr[0] & 255) | ((bArr[1] & 255) << 8));
    }

    public static byte[] combineBytes(byte[]... bArr) {
        int length = 0;
        for (byte[] bArr2 : bArr) {
            if (bArr2 != null) {
                length += bArr2.length;
            }
        }
        byte[] bArr3 = new byte[length];
        int length2 = 0;
        for (byte[] bArr4 : bArr) {
            if (bArr4 != null) {
                System.arraycopy(bArr4, 0, bArr3, length2, bArr4.length);
                length2 += bArr4.length;
            }
        }
        return bArr3;
    }

    public static int getBit(byte b10, int i10) {
        return (b10 >> i10) & 1;
    }

    public static byte[] getBytes(String str) {
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        char[] charArray = str.toCharArray();
        byte[] bArr = new byte[str.length()];
        for (int i10 = 0; i10 < charArray.length; i10++) {
            bArr[i10] = Byte.valueOf(String.valueOf(charArray[i10]), 16).byteValue();
        }
        return bArr;
    }

    public static String getHashUid(String str) {
        return TextUtils.isEmpty(str) ? "" : getSHA256Str(str.getBytes(StandardCharsets.UTF_8));
    }

    public static String getMacByFirst6Byte(String str) {
        if (str == null || str.length() != 12) {
            return "";
        }
        byte[] bArrHexStringToBytes = hexStringToBytes(str);
        bArrHexStringToBytes[0] = (byte) (bArrHexStringToBytes[0] | 192);
        return bytesToHexMac(bArrHexStringToBytes);
    }

    public static String getMacByPublicKey(byte[] bArr) {
        if (CollectionUtil.isEmpty(bArr) || bArr.length < 6) {
            return "";
        }
        byte[] bArr2 = new byte[6];
        System.arraycopy(bArr, 0, bArr2, 0, 6);
        return bytesToHexMac(bArr2);
    }

    public static String getSHA256Str(byte[] bArr) {
        try {
            return byte2hex(MessageDigest.getInstance("SHA-256").digest(bArr));
        } catch (NoSuchAlgorithmException unused) {
            HmsFindLog.m31928e(TAG, "sha256 error.");
            return null;
        }
    }

    public static String hexBrief(byte[] bArr) {
        boolean z10 = bArr.length > 6;
        int length = z10 ? 6 : bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        String strByte2hex = byte2hex(bArr2);
        if (!z10) {
            return strByte2hex;
        }
        return strByte2hex + "****";
    }

    public static byte[] hexStringToBytes(String str) {
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = i10 * 2;
            bArr[i10] = (byte) ((Character.digit(str.charAt(i11), 16) << 4) + Character.digit(str.charAt(i11 + 1), 16));
        }
        return bArr;
    }

    public static byte[] intToBytesBig(int i10) {
        return new byte[]{(byte) ((i10 >> 24) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA), (byte) ((i10 >> 16) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA), (byte) ((i10 >> 8) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA), (byte) (i10 & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA)};
    }

    public static byte[] intToBytesLittle(int i10) {
        byte b10 = (byte) ((i10 >> 24) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
        return new byte[]{(byte) (i10 & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA), (byte) ((i10 >> 8) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA), (byte) ((i10 >> 16) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA), b10};
    }

    public static byte[] intTobyteArray(int i10) {
        return ByteBuffer.allocate(4).putInt(i10).array();
    }

    public static byte[] intTobyteSubArray(int i10) {
        byte[] bArr = new byte[2];
        System.arraycopy(ByteBuffer.allocate(4).putInt(i10).array(), 2, bArr, 0, 2);
        return bArr;
    }

    public static byte[] longToBytesLittleEndian(long j10) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        byteBufferAllocate.putLong(j10);
        return byteBufferAllocate.array();
    }

    public static byte[] longTobyteArray(long j10) {
        return ByteBuffer.allocate(8).putLong(j10).array();
    }

    public static void reverseBytes(byte[] bArr) {
        int length = bArr.length - 1;
        for (int i10 = 0; length > i10; i10++) {
            byte b10 = bArr[length];
            bArr[length] = bArr[i10];
            bArr[i10] = b10;
            length--;
        }
    }

    public static byte[] shortToBytesBig(short s10) {
        return new byte[]{(byte) ((s10 >> 8) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA), (byte) (s10 & 255)};
    }

    public static byte[] shortToBytesLittle(short s10) {
        return new byte[]{(byte) (s10 & 255), (byte) ((s10 >> 8) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA)};
    }

    public static byte[] shortTobyteArray(short s10) {
        return ByteBuffer.allocate(2).putShort(s10).array();
    }

    public static byte toSignedByte(byte b10) {
        if (b10 > 0) {
            return b10;
        }
        String binaryString = Integer.toBinaryString(Math.abs((int) b10));
        StringBuilder sb2 = new StringBuilder("1");
        for (int i10 = 0; i10 < 7 - binaryString.length(); i10++) {
            sb2.append(0);
        }
        sb2.append(binaryString);
        return new BigInteger(sb2.toString(), 2).byteValue();
    }

    public static int getBit(int i10, int i11) {
        return (i10 >> i11) & 1;
    }
}
