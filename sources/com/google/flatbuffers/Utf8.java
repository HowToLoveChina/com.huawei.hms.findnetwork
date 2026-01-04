package com.google.flatbuffers;

import com.google.flatbuffers.reflection.BaseType;
import com.huawei.hms.videokit.player.common.PlayerConstants;
import com.huawei.riemann.location.common.utils.Constant;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public abstract class Utf8 {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static Utf8 DEFAULT;

    public static class DecodeUtil {
        public static void handleFourBytes(byte b10, byte b11, byte b12, byte b13, char[] cArr, int i10) throws IllegalArgumentException {
            if (isNotTrailingByte(b11) || (((b10 << 28) + (b11 + 112)) >> 30) != 0 || isNotTrailingByte(b12) || isNotTrailingByte(b13)) {
                throw new IllegalArgumentException("Invalid UTF-8");
            }
            int iTrailingByteValue = ((b10 & 7) << 18) | (trailingByteValue(b11) << 12) | (trailingByteValue(b12) << 6) | trailingByteValue(b13);
            cArr[i10] = highSurrogate(iTrailingByteValue);
            cArr[i10 + 1] = lowSurrogate(iTrailingByteValue);
        }

        public static void handleOneByte(byte b10, char[] cArr, int i10) {
            cArr[i10] = (char) b10;
        }

        public static void handleThreeBytes(byte b10, byte b11, byte b12, char[] cArr, int i10) throws IllegalArgumentException {
            if (isNotTrailingByte(b11) || ((b10 == -32 && b11 < -96) || ((b10 == -19 && b11 >= -96) || isNotTrailingByte(b12)))) {
                throw new IllegalArgumentException("Invalid UTF-8");
            }
            cArr[i10] = (char) (((b10 & BaseType.Obj) << 12) | (trailingByteValue(b11) << 6) | trailingByteValue(b12));
        }

        public static void handleTwoBytes(byte b10, byte b11, char[] cArr, int i10) throws IllegalArgumentException {
            if (b10 < -62) {
                throw new IllegalArgumentException("Invalid UTF-8: Illegal leading byte in 2 bytes utf");
            }
            if (isNotTrailingByte(b11)) {
                throw new IllegalArgumentException("Invalid UTF-8: Illegal trailing byte in 2 bytes utf");
            }
            cArr[i10] = (char) (((b10 & 31) << 6) | trailingByteValue(b11));
        }

        private static char highSurrogate(int i10) {
            return (char) ((i10 >>> 10) + 55232);
        }

        private static boolean isNotTrailingByte(byte b10) {
            return b10 > -65;
        }

        public static boolean isOneByte(byte b10) {
            return b10 >= 0;
        }

        public static boolean isThreeBytes(byte b10) {
            return b10 < -16;
        }

        public static boolean isTwoBytes(byte b10) {
            return b10 < -32;
        }

        private static char lowSurrogate(int i10) {
            return (char) ((i10 & PlayerConstants.ErrorCode.SWITCH_PLAYMODE_NORMAL_FAILED) + 56320);
        }

        private static int trailingByteValue(byte b10) {
            return b10 & 63;
        }
    }

    public static class UnpairedSurrogateException extends IllegalArgumentException {
        public UnpairedSurrogateException(int i10, int i11) {
            super("Unpaired surrogate at index " + i10 + " of " + i11);
        }
    }

    public static int encodeUtf8CodePoint(CharSequence charSequence, int i10, byte[] bArr) {
        int length = charSequence.length();
        if (i10 >= length) {
            return 0;
        }
        char cCharAt = charSequence.charAt(i10);
        if (cCharAt < 128) {
            bArr[0] = (byte) cCharAt;
            return 1;
        }
        if (cCharAt < 2048) {
            bArr[0] = (byte) ((cCharAt >>> 6) | 192);
            bArr[1] = (byte) ((cCharAt & '?') | 128);
            return 2;
        }
        if (cCharAt < 55296 || 57343 < cCharAt) {
            bArr[0] = (byte) ((cCharAt >>> '\f') | Constant.ERROR_WSS_INVALID);
            bArr[1] = (byte) (((cCharAt >>> 6) & 63) | 128);
            bArr[2] = (byte) ((cCharAt & '?') | 128);
            return 3;
        }
        int i11 = i10 + 1;
        if (i11 != length) {
            char cCharAt2 = charSequence.charAt(i11);
            if (Character.isSurrogatePair(cCharAt, cCharAt2)) {
                int codePoint = Character.toCodePoint(cCharAt, cCharAt2);
                bArr[0] = (byte) ((codePoint >>> 18) | 240);
                bArr[1] = (byte) (((codePoint >>> 12) & 63) | 128);
                bArr[2] = (byte) (((codePoint >>> 6) & 63) | 128);
                bArr[3] = (byte) ((codePoint & 63) | 128);
                return 4;
            }
        }
        throw new UnpairedSurrogateException(i10, length);
    }

    public static Utf8 getDefault() {
        if (DEFAULT == null) {
            DEFAULT = new Utf8Safe();
        }
        return DEFAULT;
    }

    public static void setDefault(Utf8 utf8) {
        DEFAULT = utf8;
    }

    public abstract String decodeUtf8(ByteBuffer byteBuffer, int i10, int i11);

    public abstract void encodeUtf8(CharSequence charSequence, ByteBuffer byteBuffer);

    public abstract int encodedLength(CharSequence charSequence);
}
