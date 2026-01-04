package com.google.flatbuffers;

import com.google.flatbuffers.Utf8;
import com.huawei.riemann.location.common.utils.Constant;
import com.huawei.uikit.hwadvancednumberpicker.widget.PickerHelper;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class Utf8Safe extends Utf8 {

    public static class UnpairedSurrogateException extends IllegalArgumentException {
        public UnpairedSurrogateException(int i10, int i11) {
            super("Unpaired surrogate at index " + i10 + " of " + i11);
        }
    }

    private static int computeEncodedLength(CharSequence charSequence) {
        int length = charSequence.length();
        int i10 = 0;
        while (i10 < length && charSequence.charAt(i10) < 128) {
            i10++;
        }
        int iEncodedLengthGeneral = length;
        while (true) {
            if (i10 < length) {
                char cCharAt = charSequence.charAt(i10);
                if (cCharAt >= 2048) {
                    iEncodedLengthGeneral += encodedLengthGeneral(charSequence, i10);
                    break;
                }
                iEncodedLengthGeneral += (127 - cCharAt) >>> 31;
                i10++;
            } else {
                break;
            }
        }
        if (iEncodedLengthGeneral >= length) {
            return iEncodedLengthGeneral;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (iEncodedLengthGeneral + 4294967296L));
    }

    public static String decodeUtf8Array(byte[] bArr, int i10, int i11) throws IllegalArgumentException {
        if ((i10 | i11 | ((bArr.length - i10) - i11)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i10), Integer.valueOf(i11)));
        }
        int i12 = i10 + i11;
        char[] cArr = new char[i11];
        int i13 = 0;
        while (i10 < i12) {
            byte b10 = bArr[i10];
            if (!Utf8.DecodeUtil.isOneByte(b10)) {
                break;
            }
            i10++;
            Utf8.DecodeUtil.handleOneByte(b10, cArr, i13);
            i13++;
        }
        int i14 = i13;
        while (i10 < i12) {
            int i15 = i10 + 1;
            byte b11 = bArr[i10];
            if (Utf8.DecodeUtil.isOneByte(b11)) {
                int i16 = i14 + 1;
                Utf8.DecodeUtil.handleOneByte(b11, cArr, i14);
                while (i15 < i12) {
                    byte b12 = bArr[i15];
                    if (!Utf8.DecodeUtil.isOneByte(b12)) {
                        break;
                    }
                    i15++;
                    Utf8.DecodeUtil.handleOneByte(b12, cArr, i16);
                    i16++;
                }
                i14 = i16;
                i10 = i15;
            } else if (Utf8.DecodeUtil.isTwoBytes(b11)) {
                if (i15 >= i12) {
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
                i10 += 2;
                Utf8.DecodeUtil.handleTwoBytes(b11, bArr[i15], cArr, i14);
                i14++;
            } else if (Utf8.DecodeUtil.isThreeBytes(b11)) {
                if (i15 >= i12 - 1) {
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
                int i17 = i10 + 2;
                i10 += 3;
                Utf8.DecodeUtil.handleThreeBytes(b11, bArr[i15], bArr[i17], cArr, i14);
                i14++;
            } else {
                if (i15 >= i12 - 2) {
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
                byte b13 = bArr[i15];
                int i18 = i10 + 3;
                byte b14 = bArr[i10 + 2];
                i10 += 4;
                Utf8.DecodeUtil.handleFourBytes(b11, b13, b14, bArr[i18], cArr, i14);
                i14 += 2;
            }
        }
        return new String(cArr, 0, i14);
    }

    public static String decodeUtf8Buffer(ByteBuffer byteBuffer, int i10, int i11) throws IllegalArgumentException {
        if ((i10 | i11 | ((byteBuffer.limit() - i10) - i11)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i10), Integer.valueOf(i11)));
        }
        int i12 = i10 + i11;
        char[] cArr = new char[i11];
        int i13 = 0;
        while (i10 < i12) {
            byte b10 = byteBuffer.get(i10);
            if (!Utf8.DecodeUtil.isOneByte(b10)) {
                break;
            }
            i10++;
            Utf8.DecodeUtil.handleOneByte(b10, cArr, i13);
            i13++;
        }
        int i14 = i13;
        while (i10 < i12) {
            int i15 = i10 + 1;
            byte b11 = byteBuffer.get(i10);
            if (Utf8.DecodeUtil.isOneByte(b11)) {
                int i16 = i14 + 1;
                Utf8.DecodeUtil.handleOneByte(b11, cArr, i14);
                while (i15 < i12) {
                    byte b12 = byteBuffer.get(i15);
                    if (!Utf8.DecodeUtil.isOneByte(b12)) {
                        break;
                    }
                    i15++;
                    Utf8.DecodeUtil.handleOneByte(b12, cArr, i16);
                    i16++;
                }
                i14 = i16;
                i10 = i15;
            } else if (Utf8.DecodeUtil.isTwoBytes(b11)) {
                if (i15 >= i12) {
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
                i10 += 2;
                Utf8.DecodeUtil.handleTwoBytes(b11, byteBuffer.get(i15), cArr, i14);
                i14++;
            } else if (Utf8.DecodeUtil.isThreeBytes(b11)) {
                if (i15 >= i12 - 1) {
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
                int i17 = i10 + 2;
                i10 += 3;
                Utf8.DecodeUtil.handleThreeBytes(b11, byteBuffer.get(i15), byteBuffer.get(i17), cArr, i14);
                i14++;
            } else {
                if (i15 >= i12 - 2) {
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
                byte b13 = byteBuffer.get(i15);
                int i18 = i10 + 3;
                byte b14 = byteBuffer.get(i10 + 2);
                i10 += 4;
                Utf8.DecodeUtil.handleFourBytes(b11, b13, b14, byteBuffer.get(i18), cArr, i14);
                i14 += 2;
            }
        }
        return new String(cArr, 0, i14);
    }

    private static int encodeUtf8Array(CharSequence charSequence, byte[] bArr, int i10, int i11) {
        int i12;
        int i13;
        char cCharAt;
        int length = charSequence.length();
        int i14 = i11 + i10;
        int i15 = 0;
        while (i15 < length && (i13 = i15 + i10) < i14 && (cCharAt = charSequence.charAt(i15)) < 128) {
            bArr[i13] = (byte) cCharAt;
            i15++;
        }
        if (i15 == length) {
            return i10 + length;
        }
        int i16 = i10 + i15;
        while (i15 < length) {
            char cCharAt2 = charSequence.charAt(i15);
            if (cCharAt2 < 128 && i16 < i14) {
                bArr[i16] = (byte) cCharAt2;
                i16++;
            } else if (cCharAt2 < 2048 && i16 <= i14 - 2) {
                int i17 = i16 + 1;
                bArr[i16] = (byte) ((cCharAt2 >>> 6) | PickerHelper.PICKER_MOUSE_SCROLL_VECTORITY);
                i16 += 2;
                bArr[i17] = (byte) ((cCharAt2 & '?') | 128);
            } else {
                if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || i16 > i14 - 3) {
                    if (i16 > i14 - 4) {
                        if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i12 = i15 + 1) == charSequence.length() || !Character.isSurrogatePair(cCharAt2, charSequence.charAt(i12)))) {
                            throw new UnpairedSurrogateException(i15, length);
                        }
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + i16);
                    }
                    int i18 = i15 + 1;
                    if (i18 != charSequence.length()) {
                        char cCharAt3 = charSequence.charAt(i18);
                        if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                            int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                            bArr[i16] = (byte) ((codePoint >>> 18) | 240);
                            bArr[i16 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                            int i19 = i16 + 3;
                            bArr[i16 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                            i16 += 4;
                            bArr[i19] = (byte) ((codePoint & 63) | 128);
                            i15 = i18;
                        } else {
                            i15 = i18;
                        }
                    }
                    throw new UnpairedSurrogateException(i15 - 1, length);
                }
                bArr[i16] = (byte) ((cCharAt2 >>> '\f') | com.huawei.openalliance.p169ad.constant.Constants.INTERSTITIAL_LAND_WIDTH);
                int i20 = i16 + 2;
                bArr[i16 + 1] = (byte) (((cCharAt2 >>> 6) & 63) | 128);
                i16 += 3;
                bArr[i20] = (byte) ((cCharAt2 & '?') | 128);
            }
            i15++;
        }
        return i16;
    }

    private static void encodeUtf8Buffer(CharSequence charSequence, ByteBuffer byteBuffer) {
        int length = charSequence.length();
        int iPosition = byteBuffer.position();
        int i10 = 0;
        while (i10 < length) {
            try {
                char cCharAt = charSequence.charAt(i10);
                if (cCharAt >= 128) {
                    break;
                }
                byteBuffer.put(iPosition + i10, (byte) cCharAt);
                i10++;
            } catch (IndexOutOfBoundsException unused) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i10) + " at index " + (byteBuffer.position() + Math.max(i10, (iPosition - byteBuffer.position()) + 1)));
            }
        }
        if (i10 == length) {
            byteBuffer.position(iPosition + i10);
            return;
        }
        iPosition += i10;
        while (i10 < length) {
            char cCharAt2 = charSequence.charAt(i10);
            if (cCharAt2 < 128) {
                byteBuffer.put(iPosition, (byte) cCharAt2);
            } else if (cCharAt2 < 2048) {
                int i11 = iPosition + 1;
                try {
                    byteBuffer.put(iPosition, (byte) ((cCharAt2 >>> 6) | 192));
                    byteBuffer.put(i11, (byte) ((cCharAt2 & '?') | 128));
                    iPosition = i11;
                } catch (IndexOutOfBoundsException unused2) {
                    iPosition = i11;
                    throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i10) + " at index " + (byteBuffer.position() + Math.max(i10, (iPosition - byteBuffer.position()) + 1)));
                }
            } else {
                if (cCharAt2 >= 55296 && 57343 >= cCharAt2) {
                    int i12 = i10 + 1;
                    if (i12 != length) {
                        try {
                            char cCharAt3 = charSequence.charAt(i12);
                            if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                int i13 = iPosition + 1;
                                try {
                                    byteBuffer.put(iPosition, (byte) ((codePoint >>> 18) | 240));
                                    int i14 = iPosition + 2;
                                    try {
                                        byteBuffer.put(i13, (byte) (((codePoint >>> 12) & 63) | 128));
                                        iPosition += 3;
                                        byteBuffer.put(i14, (byte) (((codePoint >>> 6) & 63) | 128));
                                        byteBuffer.put(iPosition, (byte) ((codePoint & 63) | 128));
                                        i10 = i12;
                                    } catch (IndexOutOfBoundsException unused3) {
                                        i10 = i12;
                                        iPosition = i14;
                                        throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i10) + " at index " + (byteBuffer.position() + Math.max(i10, (iPosition - byteBuffer.position()) + 1)));
                                    }
                                } catch (IndexOutOfBoundsException unused4) {
                                    iPosition = i13;
                                    i10 = i12;
                                    throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i10) + " at index " + (byteBuffer.position() + Math.max(i10, (iPosition - byteBuffer.position()) + 1)));
                                }
                            } else {
                                i10 = i12;
                            }
                        } catch (IndexOutOfBoundsException unused5) {
                        }
                    }
                    throw new UnpairedSurrogateException(i10, length);
                }
                int i15 = iPosition + 1;
                byteBuffer.put(iPosition, (byte) ((cCharAt2 >>> '\f') | Constant.ERROR_WSS_INVALID));
                iPosition += 2;
                byteBuffer.put(i15, (byte) (((cCharAt2 >>> 6) & 63) | 128));
                byteBuffer.put(iPosition, (byte) ((cCharAt2 & '?') | 128));
            }
            i10++;
            iPosition++;
        }
        byteBuffer.position(iPosition);
    }

    private static int encodedLengthGeneral(CharSequence charSequence, int i10) {
        int length = charSequence.length();
        int i11 = 0;
        while (i10 < length) {
            char cCharAt = charSequence.charAt(i10);
            if (cCharAt < 2048) {
                i11 += (127 - cCharAt) >>> 31;
            } else {
                i11 += 2;
                if (55296 <= cCharAt && cCharAt <= 57343) {
                    if (Character.codePointAt(charSequence, i10) < 65536) {
                        throw new UnpairedSurrogateException(i10, length);
                    }
                    i10++;
                }
            }
            i10++;
        }
        return i11;
    }

    @Override // com.google.flatbuffers.Utf8
    public String decodeUtf8(ByteBuffer byteBuffer, int i10, int i11) throws IllegalArgumentException {
        return byteBuffer.hasArray() ? decodeUtf8Array(byteBuffer.array(), byteBuffer.arrayOffset() + i10, i11) : decodeUtf8Buffer(byteBuffer, i10, i11);
    }

    @Override // com.google.flatbuffers.Utf8
    public void encodeUtf8(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (!byteBuffer.hasArray()) {
            encodeUtf8Buffer(charSequence, byteBuffer);
        } else {
            int iArrayOffset = byteBuffer.arrayOffset();
            byteBuffer.position(encodeUtf8Array(charSequence, byteBuffer.array(), byteBuffer.position() + iArrayOffset, byteBuffer.remaining()) - iArrayOffset);
        }
    }

    @Override // com.google.flatbuffers.Utf8
    public int encodedLength(CharSequence charSequence) {
        return computeEncodedLength(charSequence);
    }
}
