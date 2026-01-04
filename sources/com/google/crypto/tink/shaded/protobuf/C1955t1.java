package com.google.crypto.tink.shaded.protobuf;

import com.google.flatbuffers.reflection.BaseType;
import com.huawei.hms.videokit.player.common.PlayerConstants;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.uikit.hwadvancednumberpicker.widget.PickerHelper;

/* renamed from: com.google.crypto.tink.shaded.protobuf.t1 */
/* loaded from: classes.dex */
public final class C1955t1 {

    /* renamed from: a */
    public static final b f9282a;

    /* renamed from: com.google.crypto.tink.shaded.protobuf.t1$a */
    public static class a {
        /* renamed from: h */
        public static void m12231h(byte b10, byte b11, byte b12, byte b13, char[] cArr, int i10) throws C1903c0 {
            if (m12236m(b11) || (((b10 << 28) + (b11 + 112)) >> 30) != 0 || m12236m(b12) || m12236m(b13)) {
                throw C1903c0.m11504d();
            }
            int iM12241r = ((b10 & 7) << 18) | (m12241r(b11) << 12) | (m12241r(b12) << 6) | m12241r(b13);
            cArr[i10] = m12235l(iM12241r);
            cArr[i10 + 1] = m12240q(iM12241r);
        }

        /* renamed from: i */
        public static void m12232i(byte b10, char[] cArr, int i10) {
            cArr[i10] = (char) b10;
        }

        /* renamed from: j */
        public static void m12233j(byte b10, byte b11, byte b12, char[] cArr, int i10) throws C1903c0 {
            if (m12236m(b11) || ((b10 == -32 && b11 < -96) || ((b10 == -19 && b11 >= -96) || m12236m(b12)))) {
                throw C1903c0.m11504d();
            }
            cArr[i10] = (char) (((b10 & BaseType.Obj) << 12) | (m12241r(b11) << 6) | m12241r(b12));
        }

        /* renamed from: k */
        public static void m12234k(byte b10, byte b11, char[] cArr, int i10) throws C1903c0 {
            if (b10 < -62 || m12236m(b11)) {
                throw C1903c0.m11504d();
            }
            cArr[i10] = (char) (((b10 & 31) << 6) | m12241r(b11));
        }

        /* renamed from: l */
        public static char m12235l(int i10) {
            return (char) ((i10 >>> 10) + 55232);
        }

        /* renamed from: m */
        public static boolean m12236m(byte b10) {
            return b10 > -65;
        }

        /* renamed from: n */
        public static boolean m12237n(byte b10) {
            return b10 >= 0;
        }

        /* renamed from: o */
        public static boolean m12238o(byte b10) {
            return b10 < -16;
        }

        /* renamed from: p */
        public static boolean m12239p(byte b10) {
            return b10 < -32;
        }

        /* renamed from: q */
        public static char m12240q(int i10) {
            return (char) ((i10 & PlayerConstants.ErrorCode.SWITCH_PLAYMODE_NORMAL_FAILED) + 56320);
        }

        /* renamed from: r */
        public static int m12241r(byte b10) {
            return b10 & 63;
        }
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.t1$b */
    public static abstract class b {
        /* renamed from: a */
        public abstract String mo12242a(byte[] bArr, int i10, int i11) throws C1903c0;

        /* renamed from: b */
        public abstract int mo12243b(CharSequence charSequence, byte[] bArr, int i10, int i11);

        /* renamed from: c */
        public final boolean m12244c(byte[] bArr, int i10, int i11) {
            return mo12245d(0, bArr, i10, i11) == 0;
        }

        /* renamed from: d */
        public abstract int mo12245d(int i10, byte[] bArr, int i11, int i12);
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.t1$c */
    public static final class c extends b {
        /* renamed from: e */
        public static int m12246e(byte[] bArr, int i10, int i11) {
            while (i10 < i11 && bArr[i10] >= 0) {
                i10++;
            }
            if (i10 >= i11) {
                return 0;
            }
            return m12247f(bArr, i10, i11);
        }

        /* renamed from: f */
        public static int m12247f(byte[] bArr, int i10, int i11) {
            while (i10 < i11) {
                int i12 = i10 + 1;
                byte b10 = bArr[i10];
                if (b10 < 0) {
                    if (b10 < -32) {
                        if (i12 >= i11) {
                            return b10;
                        }
                        if (b10 >= -62) {
                            i10 += 2;
                            if (bArr[i12] > -65) {
                            }
                        }
                        return -1;
                    }
                    if (b10 >= -16) {
                        if (i12 >= i11 - 2) {
                            return C1955t1.m12221l(bArr, i12, i11);
                        }
                        int i13 = i10 + 2;
                        byte b11 = bArr[i12];
                        if (b11 <= -65 && (((b10 << 28) + (b11 + 112)) >> 30) == 0) {
                            int i14 = i10 + 3;
                            if (bArr[i13] <= -65) {
                                i10 += 4;
                                if (bArr[i14] > -65) {
                                }
                            }
                        }
                        return -1;
                    }
                    if (i12 >= i11 - 1) {
                        return C1955t1.m12221l(bArr, i12, i11);
                    }
                    int i15 = i10 + 2;
                    byte b12 = bArr[i12];
                    if (b12 <= -65 && ((b10 != -32 || b12 >= -96) && (b10 != -19 || b12 < -96))) {
                        i10 += 3;
                        if (bArr[i15] > -65) {
                        }
                    }
                    return -1;
                }
                i10 = i12;
            }
            return 0;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.C1955t1.b
        /* renamed from: a */
        public String mo12242a(byte[] bArr, int i10, int i11) throws C1903c0 {
            if ((i10 | i11 | ((bArr.length - i10) - i11)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i10), Integer.valueOf(i11)));
            }
            int i12 = i10 + i11;
            char[] cArr = new char[i11];
            int i13 = 0;
            while (i10 < i12) {
                byte b10 = bArr[i10];
                if (!a.m12237n(b10)) {
                    break;
                }
                i10++;
                a.m12232i(b10, cArr, i13);
                i13++;
            }
            int i14 = i13;
            while (i10 < i12) {
                int i15 = i10 + 1;
                byte b11 = bArr[i10];
                if (a.m12237n(b11)) {
                    int i16 = i14 + 1;
                    a.m12232i(b11, cArr, i14);
                    while (i15 < i12) {
                        byte b12 = bArr[i15];
                        if (!a.m12237n(b12)) {
                            break;
                        }
                        i15++;
                        a.m12232i(b12, cArr, i16);
                        i16++;
                    }
                    i14 = i16;
                    i10 = i15;
                } else if (a.m12239p(b11)) {
                    if (i15 >= i12) {
                        throw C1903c0.m11504d();
                    }
                    i10 += 2;
                    a.m12234k(b11, bArr[i15], cArr, i14);
                    i14++;
                } else if (a.m12238o(b11)) {
                    if (i15 >= i12 - 1) {
                        throw C1903c0.m11504d();
                    }
                    int i17 = i10 + 2;
                    i10 += 3;
                    a.m12233j(b11, bArr[i15], bArr[i17], cArr, i14);
                    i14++;
                } else {
                    if (i15 >= i12 - 2) {
                        throw C1903c0.m11504d();
                    }
                    byte b13 = bArr[i15];
                    int i18 = i10 + 3;
                    byte b14 = bArr[i10 + 2];
                    i10 += 4;
                    a.m12231h(b11, b13, b14, bArr[i18], cArr, i14);
                    i14 += 2;
                }
            }
            return new String(cArr, 0, i14);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.C1955t1.b
        /* renamed from: b */
        public int mo12243b(CharSequence charSequence, byte[] bArr, int i10, int i11) {
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
                                throw new d(i15, length);
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
                        throw new d(i15 - 1, length);
                    }
                    bArr[i16] = (byte) ((cCharAt2 >>> '\f') | Constants.INTERSTITIAL_LAND_WIDTH);
                    int i20 = i16 + 2;
                    bArr[i16 + 1] = (byte) (((cCharAt2 >>> 6) & 63) | 128);
                    i16 += 3;
                    bArr[i20] = (byte) ((cCharAt2 & '?') | 128);
                }
                i15++;
            }
            return i16;
        }

        /* JADX WARN: Code restructure failed: missing block: B:108:0x0083, code lost:
        
            if (r7[r6] > (-65)) goto L109;
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x0015, code lost:
        
            if (r7[r8] > (-65)) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:87:0x0046, code lost:
        
            if (r7[r8] > (-65)) goto L88;
         */
        @Override // com.google.crypto.tink.shaded.protobuf.C1955t1.b
        /* renamed from: d */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int mo12245d(int r6, byte[] r7, int r8, int r9) {
            /*
                r5 = this;
                if (r6 == 0) goto L86
                if (r8 < r9) goto L5
                return r6
            L5:
                byte r5 = (byte) r6
                r0 = -32
                r1 = -1
                r2 = -65
                if (r5 >= r0) goto L1c
                r6 = -62
                if (r5 < r6) goto L1b
                int r5 = r8 + 1
                r6 = r7[r8]
                if (r6 <= r2) goto L18
                goto L1b
            L18:
                r8 = r5
                goto L86
            L1b:
                return r1
            L1c:
                r3 = -16
                if (r5 >= r3) goto L49
                int r6 = r6 >> 8
                int r6 = ~r6
                byte r6 = (byte) r6
                if (r6 != 0) goto L34
                int r6 = r8 + 1
                r8 = r7[r8]
                if (r6 < r9) goto L31
                int r5 = com.google.crypto.tink.shaded.protobuf.C1955t1.m12210a(r5, r8)
                return r5
            L31:
                r4 = r8
                r8 = r6
                r6 = r4
            L34:
                if (r6 > r2) goto L48
                r3 = -96
                if (r5 != r0) goto L3c
                if (r6 < r3) goto L48
            L3c:
                r0 = -19
                if (r5 != r0) goto L42
                if (r6 >= r3) goto L48
            L42:
                int r5 = r8 + 1
                r6 = r7[r8]
                if (r6 <= r2) goto L18
            L48:
                return r1
            L49:
                int r0 = r6 >> 8
                int r0 = ~r0
                byte r0 = (byte) r0
                if (r0 != 0) goto L5c
                int r6 = r8 + 1
                r0 = r7[r8]
                if (r6 < r9) goto L5a
                int r5 = com.google.crypto.tink.shaded.protobuf.C1955t1.m12210a(r5, r0)
                return r5
            L5a:
                r8 = 0
                goto L62
            L5c:
                int r6 = r6 >> 16
                byte r6 = (byte) r6
                r4 = r8
                r8 = r6
                r6 = r4
            L62:
                if (r8 != 0) goto L72
                int r8 = r6 + 1
                r6 = r7[r6]
                if (r8 < r9) goto L6f
                int r5 = com.google.crypto.tink.shaded.protobuf.C1955t1.m12211b(r5, r0, r6)
                return r5
            L6f:
                r4 = r8
                r8 = r6
                r6 = r4
            L72:
                if (r0 > r2) goto L85
                int r5 = r5 << 28
                int r0 = r0 + 112
                int r5 = r5 + r0
                int r5 = r5 >> 30
                if (r5 != 0) goto L85
                if (r8 > r2) goto L85
                int r8 = r6 + 1
                r5 = r7[r6]
                if (r5 <= r2) goto L86
            L85:
                return r1
            L86:
                int r5 = m12246e(r7, r8, r9)
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.C1955t1.c.mo12245d(int, byte[], int, int):int");
        }
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.t1$d */
    public static class d extends IllegalArgumentException {
        public d(int i10, int i11) {
            super("Unpaired surrogate at index " + i10 + " of " + i11);
        }
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.t1$e */
    public static final class e extends b {
        /* renamed from: e */
        public static boolean m12248e() {
            return C1952s1.m12146C() && C1952s1.m12147D();
        }

        /* JADX WARN: Code restructure failed: missing block: B:116:0x0064, code lost:
        
            return -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:99:0x0039, code lost:
        
            return -1;
         */
        /* renamed from: f */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static int m12249f(byte[] r10, long r11, int r13) {
            /*
                int r0 = m12250g(r10, r11, r13)
                int r13 = r13 - r0
                long r0 = (long) r0
                long r11 = r11 + r0
            L7:
                r0 = 0
                r1 = r0
            L9:
                r2 = 1
                if (r13 <= 0) goto L1a
                long r4 = r11 + r2
                byte r1 = com.google.crypto.tink.shaded.protobuf.C1952s1.m12179s(r10, r11)
                if (r1 < 0) goto L19
                int r13 = r13 + (-1)
                r11 = r4
                goto L9
            L19:
                r11 = r4
            L1a:
                if (r13 != 0) goto L1d
                return r0
            L1d:
                int r0 = r13 + (-1)
                r4 = -32
                r5 = -1
                r6 = -65
                if (r1 >= r4) goto L3a
                if (r0 != 0) goto L29
                return r1
            L29:
                int r13 = r13 + (-2)
                r0 = -62
                if (r1 < r0) goto L39
                long r2 = r2 + r11
                byte r11 = com.google.crypto.tink.shaded.protobuf.C1952s1.m12179s(r10, r11)
                if (r11 <= r6) goto L37
                goto L39
            L37:
                r11 = r2
                goto L7
            L39:
                return r5
            L3a:
                r7 = -16
                r8 = 2
                if (r1 >= r7) goto L65
                r7 = 2
                if (r0 >= r7) goto L48
                int r10 = m12251h(r10, r1, r11, r0)
                return r10
            L48:
                int r13 = r13 + (-3)
                long r2 = r2 + r11
                byte r0 = com.google.crypto.tink.shaded.protobuf.C1952s1.m12179s(r10, r11)
                if (r0 > r6) goto L64
                r7 = -96
                if (r1 != r4) goto L57
                if (r0 < r7) goto L64
            L57:
                r4 = -19
                if (r1 != r4) goto L5d
                if (r0 >= r7) goto L64
            L5d:
                long r11 = r11 + r8
                byte r0 = com.google.crypto.tink.shaded.protobuf.C1952s1.m12179s(r10, r2)
                if (r0 <= r6) goto L7
            L64:
                return r5
            L65:
                r4 = 3
                if (r0 >= r4) goto L6d
                int r10 = m12251h(r10, r1, r11, r0)
                return r10
            L6d:
                int r13 = r13 + (-4)
                long r2 = r2 + r11
                byte r0 = com.google.crypto.tink.shaded.protobuf.C1952s1.m12179s(r10, r11)
                if (r0 > r6) goto L8f
                int r1 = r1 << 28
                int r0 = r0 + 112
                int r1 = r1 + r0
                int r0 = r1 >> 30
                if (r0 != 0) goto L8f
                long r8 = r8 + r11
                byte r0 = com.google.crypto.tink.shaded.protobuf.C1952s1.m12179s(r10, r2)
                if (r0 > r6) goto L8f
                r0 = 3
                long r11 = r11 + r0
                byte r0 = com.google.crypto.tink.shaded.protobuf.C1952s1.m12179s(r10, r8)
                if (r0 <= r6) goto L7
            L8f:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.C1955t1.e.m12249f(byte[], long, int):int");
        }

        /* renamed from: g */
        public static int m12250g(byte[] bArr, long j10, int i10) {
            int i11 = 0;
            if (i10 < 16) {
                return 0;
            }
            while (i11 < i10) {
                long j11 = 1 + j10;
                if (C1952s1.m12179s(bArr, j10) < 0) {
                    return i11;
                }
                i11++;
                j10 = j11;
            }
            return i10;
        }

        /* renamed from: h */
        public static int m12251h(byte[] bArr, int i10, long j10, int i11) {
            if (i11 == 0) {
                return C1955t1.m12218i(i10);
            }
            if (i11 == 1) {
                return C1955t1.m12219j(i10, C1952s1.m12179s(bArr, j10));
            }
            if (i11 == 2) {
                return C1955t1.m12220k(i10, C1952s1.m12179s(bArr, j10), C1952s1.m12179s(bArr, j10 + 1));
            }
            throw new AssertionError();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.C1955t1.b
        /* renamed from: a */
        public String mo12242a(byte[] bArr, int i10, int i11) throws C1903c0 {
            if ((i10 | i11 | ((bArr.length - i10) - i11)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i10), Integer.valueOf(i11)));
            }
            int i12 = i10 + i11;
            char[] cArr = new char[i11];
            int i13 = 0;
            while (i10 < i12) {
                byte bM12179s = C1952s1.m12179s(bArr, i10);
                if (!a.m12237n(bM12179s)) {
                    break;
                }
                i10++;
                a.m12232i(bM12179s, cArr, i13);
                i13++;
            }
            int i14 = i13;
            while (i10 < i12) {
                int i15 = i10 + 1;
                byte bM12179s2 = C1952s1.m12179s(bArr, i10);
                if (a.m12237n(bM12179s2)) {
                    int i16 = i14 + 1;
                    a.m12232i(bM12179s2, cArr, i14);
                    while (i15 < i12) {
                        byte bM12179s3 = C1952s1.m12179s(bArr, i15);
                        if (!a.m12237n(bM12179s3)) {
                            break;
                        }
                        i15++;
                        a.m12232i(bM12179s3, cArr, i16);
                        i16++;
                    }
                    i14 = i16;
                    i10 = i15;
                } else if (a.m12239p(bM12179s2)) {
                    if (i15 >= i12) {
                        throw C1903c0.m11504d();
                    }
                    i10 += 2;
                    a.m12234k(bM12179s2, C1952s1.m12179s(bArr, i15), cArr, i14);
                    i14++;
                } else if (a.m12238o(bM12179s2)) {
                    if (i15 >= i12 - 1) {
                        throw C1903c0.m11504d();
                    }
                    int i17 = i10 + 2;
                    i10 += 3;
                    a.m12233j(bM12179s2, C1952s1.m12179s(bArr, i15), C1952s1.m12179s(bArr, i17), cArr, i14);
                    i14++;
                } else {
                    if (i15 >= i12 - 2) {
                        throw C1903c0.m11504d();
                    }
                    byte bM12179s4 = C1952s1.m12179s(bArr, i15);
                    int i18 = i10 + 3;
                    byte bM12179s5 = C1952s1.m12179s(bArr, i10 + 2);
                    i10 += 4;
                    a.m12231h(bM12179s2, bM12179s4, bM12179s5, C1952s1.m12179s(bArr, i18), cArr, i14);
                    i14 += 2;
                }
            }
            return new String(cArr, 0, i14);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.C1955t1.b
        /* renamed from: b */
        public int mo12243b(CharSequence charSequence, byte[] bArr, int i10, int i11) {
            long j10;
            String str;
            String str2;
            int i12;
            long j11;
            long j12;
            char cCharAt;
            long j13 = i10;
            long j14 = i11 + j13;
            int length = charSequence.length();
            String str3 = " at index ";
            String str4 = "Failed writing ";
            if (length > i11 || bArr.length - i11 < i10) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(length - 1) + " at index " + (i10 + i11));
            }
            int i13 = 0;
            while (true) {
                j10 = 1;
                if (i13 >= length || (cCharAt = charSequence.charAt(i13)) >= 128) {
                    break;
                }
                C1952s1.m12151H(bArr, j13, (byte) cCharAt);
                i13++;
                j13 = 1 + j13;
            }
            if (i13 == length) {
                return (int) j13;
            }
            while (i13 < length) {
                char cCharAt2 = charSequence.charAt(i13);
                if (cCharAt2 >= 128 || j13 >= j14) {
                    if (cCharAt2 >= 2048 || j13 > j14 - 2) {
                        str = str3;
                        str2 = str4;
                        if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || j13 > j14 - 3) {
                            if (j13 > j14 - 4) {
                                if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i12 = i13 + 1) == length || !Character.isSurrogatePair(cCharAt2, charSequence.charAt(i12)))) {
                                    throw new d(i13, length);
                                }
                                throw new ArrayIndexOutOfBoundsException(str2 + cCharAt2 + str + j13);
                            }
                            int i14 = i13 + 1;
                            if (i14 != length) {
                                char cCharAt3 = charSequence.charAt(i14);
                                if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                    int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                    j11 = 1;
                                    C1952s1.m12151H(bArr, j13, (byte) ((codePoint >>> 18) | 240));
                                    j12 = j14;
                                    C1952s1.m12151H(bArr, j13 + 1, (byte) (((codePoint >>> 12) & 63) | 128));
                                    long j15 = j13 + 3;
                                    C1952s1.m12151H(bArr, j13 + 2, (byte) (((codePoint >>> 6) & 63) | 128));
                                    j13 += 4;
                                    C1952s1.m12151H(bArr, j15, (byte) ((codePoint & 63) | 128));
                                    i13 = i14;
                                } else {
                                    i13 = i14;
                                }
                            }
                            throw new d(i13 - 1, length);
                        }
                        C1952s1.m12151H(bArr, j13, (byte) ((cCharAt2 >>> '\f') | Constants.INTERSTITIAL_LAND_WIDTH));
                        long j16 = j13 + 2;
                        C1952s1.m12151H(bArr, j13 + 1, (byte) (((cCharAt2 >>> 6) & 63) | 128));
                        j13 += 3;
                        C1952s1.m12151H(bArr, j16, (byte) ((cCharAt2 & '?') | 128));
                    } else {
                        str = str3;
                        str2 = str4;
                        long j17 = j13 + j10;
                        C1952s1.m12151H(bArr, j13, (byte) ((cCharAt2 >>> 6) | PickerHelper.PICKER_MOUSE_SCROLL_VECTORITY));
                        j13 += 2;
                        C1952s1.m12151H(bArr, j17, (byte) ((cCharAt2 & '?') | 128));
                    }
                    j12 = j14;
                    j11 = 1;
                } else {
                    C1952s1.m12151H(bArr, j13, (byte) cCharAt2);
                    j12 = j14;
                    str = str3;
                    j11 = j10;
                    j13 += j10;
                    str2 = str4;
                }
                i13++;
                str3 = str;
                str4 = str2;
                j10 = j11;
                j14 = j12;
            }
            return (int) j13;
        }

        /* JADX WARN: Code restructure failed: missing block: B:122:0x009e, code lost:
        
            if (com.google.crypto.tink.shaded.protobuf.C1952s1.m12179s(r11, r0) > (-65)) goto L123;
         */
        /* JADX WARN: Code restructure failed: missing block: B:99:0x0058, code lost:
        
            if (com.google.crypto.tink.shaded.protobuf.C1952s1.m12179s(r11, r0) > (-65)) goto L102;
         */
        @Override // com.google.crypto.tink.shaded.protobuf.C1955t1.b
        /* renamed from: d */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int mo12245d(int r10, byte[] r11, int r12, int r13) {
            /*
                Method dump skipped, instructions count: 197
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.C1955t1.e.mo12245d(int, byte[], int, int):int");
        }
    }

    static {
        f9282a = (!e.m12248e() || C1905d.m11514c()) ? new c() : new e();
    }

    /* renamed from: e */
    public static String m12214e(byte[] bArr, int i10, int i11) throws C1903c0 {
        return f9282a.mo12242a(bArr, i10, i11);
    }

    /* renamed from: f */
    public static int m12215f(CharSequence charSequence, byte[] bArr, int i10, int i11) {
        return f9282a.mo12243b(charSequence, bArr, i10, i11);
    }

    /* renamed from: g */
    public static int m12216g(CharSequence charSequence) {
        int length = charSequence.length();
        int i10 = 0;
        while (i10 < length && charSequence.charAt(i10) < 128) {
            i10++;
        }
        int iM12217h = length;
        while (true) {
            if (i10 < length) {
                char cCharAt = charSequence.charAt(i10);
                if (cCharAt >= 2048) {
                    iM12217h += m12217h(charSequence, i10);
                    break;
                }
                iM12217h += (127 - cCharAt) >>> 31;
                i10++;
            } else {
                break;
            }
        }
        if (iM12217h >= length) {
            return iM12217h;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (iM12217h + 4294967296L));
    }

    /* renamed from: h */
    public static int m12217h(CharSequence charSequence, int i10) {
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
                        throw new d(i10, length);
                    }
                    i10++;
                }
            }
            i10++;
        }
        return i11;
    }

    /* renamed from: i */
    public static int m12218i(int i10) {
        if (i10 > -12) {
            return -1;
        }
        return i10;
    }

    /* renamed from: j */
    public static int m12219j(int i10, int i11) {
        if (i10 > -12 || i11 > -65) {
            return -1;
        }
        return i10 ^ (i11 << 8);
    }

    /* renamed from: k */
    public static int m12220k(int i10, int i11, int i12) {
        if (i10 > -12 || i11 > -65 || i12 > -65) {
            return -1;
        }
        return (i10 ^ (i11 << 8)) ^ (i12 << 16);
    }

    /* renamed from: l */
    public static int m12221l(byte[] bArr, int i10, int i11) {
        byte b10 = bArr[i10 - 1];
        int i12 = i11 - i10;
        if (i12 == 0) {
            return m12218i(b10);
        }
        if (i12 == 1) {
            return m12219j(b10, bArr[i10]);
        }
        if (i12 == 2) {
            return m12220k(b10, bArr[i10], bArr[i10 + 1]);
        }
        throw new AssertionError();
    }

    /* renamed from: m */
    public static boolean m12222m(byte[] bArr) {
        return f9282a.m12244c(bArr, 0, bArr.length);
    }

    /* renamed from: n */
    public static boolean m12223n(byte[] bArr, int i10, int i11) {
        return f9282a.m12244c(bArr, i10, i11);
    }
}
