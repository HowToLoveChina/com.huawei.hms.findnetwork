package com.huawei.android.brotli.dec;

import com.huawei.android.hicloud.sync.service.aidl.SyncType;
import com.huawei.hiar.ARImageMetadata;
import com.huawei.hms.network.embedded.C5914f2;
import com.huawei.hms.videokit.player.common.PlayerConstants;
import com.huawei.openalliance.p169ad.constant.ErrorCode;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import com.tencent.p204mm.opensdk.modelmsg.WXMediaMessage;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.huawei.android.brotli.dec.e */
/* loaded from: classes.dex */
public class C2165e {

    /* renamed from: a */
    public static final int[] f9787a = {1, 2, 3, 4, 0, 5, 17, 6, 16, 7, 8, 9, 10, 11, 12, 13, 14, 15};

    /* renamed from: b */
    public static final int[] f9788b = {3, 2, 1, 0, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2};

    /* renamed from: c */
    public static final int[] f9789c = {0, 0, 0, 0, -1, 1, -2, 2, -3, 3, -1, 1, -2, 2, -3, 3};

    /* renamed from: d */
    public static final int[] f9790d = {WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, 131076, 131075, 196610, WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, 131076, 131075, 262145, WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, 131076, 131075, 196610, WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, 131076, 131075, ARImageMetadata.FLASH_STATE};

    /* renamed from: e */
    public static final int[] f9791e = {0, 0, 0, 0, 0, 4096, 9216, 21504, 35840, 44032, 53248, 63488, 74752, 87040, 93696, 100864, 104704, 106752, 108928, 113536, 115968, 118528, 119872, 121280, 122016};

    /* renamed from: f */
    public static final int[] f9792f = {0, 0, 0, 0, 10, 10, 11, 11, 10, 10, 10, 10, 10, 9, 9, 8, 7, 7, 8, 7, 7, 6, 6, 5, 5};

    /* renamed from: g */
    public static final int[] f9793g = {1, 5, 9, 13, 17, 25, 33, 41, 49, 65, 81, 97, 113, 145, 177, PlayerConstants.EventCode.MEDIA_INFO_METADATA_UPDATE, 241, 305, 369, ErrorCode.ERROR_CODE_NULL_AD_VIEW, 753, 1265, 2289, 4337, 8433, 16625};

    /* renamed from: h */
    public static final int[] f9794h = {2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 7, 8, 9, 10, 11, 12, 13, 24};

    /* renamed from: i */
    public static final int[] f9795i = {0, 1, 2, 3, 4, 5, 6, 8, 10, 14, 18, 26, 34, 50, 66, 98, 130, 194, 322, 578, 1090, 2114, 6210, 22594};

    /* renamed from: j */
    public static final int[] f9796j = {0, 0, 0, 0, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 7, 8, 9, 10, 12, 14, 24};

    /* renamed from: k */
    public static final int[] f9797k = {2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14, 18, 22, 30, 38, 54, 70, 102, SyncType.OPEN_SWITCH_FROM_GUIDE, 198, 326, 582, 1094, 2118};

    /* renamed from: l */
    public static final int[] f9798l = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 7, 8, 9, 10, 24};

    /* renamed from: m */
    public static final int[] f9799m = {0, 0, 8, 8, 0, 16, 8, 16, 16};

    /* renamed from: n */
    public static final int[] f9800n = {0, 8, 0, 8, 16, 0, 16, 8, 16};

    /* renamed from: A */
    public static int m13239A(C2167g c2167g) {
        int iMin = Math.min(c2167g.f9830b0 - c2167g.f9832c0, c2167g.f9836e0 - c2167g.f9834d0);
        if (iMin != 0) {
            System.arraycopy(c2167g.f9827a, c2167g.f9834d0, c2167g.f9835e, c2167g.f9828a0 + c2167g.f9832c0, iMin);
            c2167g.f9832c0 += iMin;
            c2167g.f9834d0 += iMin;
        }
        return c2167g.f9832c0 < c2167g.f9830b0 ? 1 : 0;
    }

    /* renamed from: a */
    public static int m13240a(C2167g c2167g) {
        int i10 = c2167g.f9825Y;
        return c2167g.f9838f0 != 0 ? Math.min(i10, (c2167g.f9834d0 + c2167g.f9830b0) - c2167g.f9832c0) : i10;
    }

    /* renamed from: b */
    public static int m13241b(int[] iArr, int i10) {
        int i11 = 0;
        while (i11 < i10 - 1) {
            int i12 = i11 + 1;
            for (int i13 = i12; i13 < i10; i13++) {
                if (iArr[i11] == iArr[i13]) {
                    return 0;
                }
            }
            i11 = i12;
        }
        return 1;
    }

    /* renamed from: c */
    public static void m13242c(C2167g c2167g) throws IOException {
        int i10 = c2167g.f9847n;
        if (i10 == 0) {
            throw new IllegalStateException("State MUST be initialized");
        }
        if (i10 == 10) {
            return;
        }
        c2167g.f9847n = 10;
        InputStream inputStream = c2167g.f9840g0;
        if (inputStream != null) {
            C2169i.m13272a(inputStream);
            c2167g.f9840g0 = null;
        }
    }

    /* renamed from: d */
    public static void m13243d(C2167g c2167g) {
        byte[] bArr = c2167g.f9827a;
        int i10 = c2167g.f9853t;
        if (i10 <= 0) {
            C2161a.m13237o(c2167g);
            c2167g.f9847n = 1;
            return;
        }
        int iMin = Math.min(c2167g.f9825Y - c2167g.f9804D, i10);
        C2161a.m13225c(c2167g, bArr, c2167g.f9804D, iMin);
        c2167g.f9853t -= iMin;
        int i11 = c2167g.f9804D + iMin;
        c2167g.f9804D = i11;
        if (i11 == c2167g.f9825Y) {
            c2167g.f9848o = 5;
            c2167g.f9847n = 11;
        } else {
            C2161a.m13237o(c2167g);
            c2167g.f9847n = 1;
        }
    }

    /* renamed from: e */
    public static int m13244e(C2167g c2167g, int i10, int i11) {
        int[] iArr = c2167g.f9841h;
        int i12 = i10 * 2;
        int i13 = i12 + 4;
        C2161a.m13228f(c2167g);
        int iM13264y = m13264y(c2167g.f9842i, i10 * 1080, c2167g);
        int iM13258s = m13258s(c2167g.f9842i, (i10 + 3) * 1080, c2167g);
        int i14 = iM13264y == 1 ? iArr[i12 + 5] + 1 : iM13264y == 0 ? iArr[i13] : iM13264y - 2;
        if (i14 >= i11) {
            i14 -= i11;
        }
        int i15 = i12 + 5;
        iArr[i13] = iArr[i15];
        iArr[i15] = i14;
        return iM13258s;
    }

    /* renamed from: f */
    public static void m13245f(C2167g c2167g) {
        c2167g.f9859z = m13244e(c2167g, 1, c2167g.f9801A);
        c2167g.f9816P = c2167g.f9844k[c2167g.f9841h[7]];
    }

    /* renamed from: g */
    public static int m13246g(int i10, byte[] bArr, C2167g c2167g) {
        C2161a.m13236n(c2167g);
        int iM13251l = m13251l(c2167g) + 1;
        if (iM13251l == 1) {
            C2169i.m13274c(bArr, 0, i10);
            return iM13251l;
        }
        C2161a.m13228f(c2167g);
        int iM13235m = C2161a.m13235m(c2167g, 1) != 0 ? C2161a.m13235m(c2167g, 4) + 1 : 0;
        int[] iArr = new int[1080];
        m13259t(iM13251l + iM13235m, iArr, 0, c2167g);
        int i11 = 0;
        while (i11 < i10) {
            C2161a.m13236n(c2167g);
            C2161a.m13228f(c2167g);
            int iM13264y = m13264y(iArr, 0, c2167g);
            if (iM13264y == 0) {
                bArr[i11] = 0;
            } else if (iM13264y <= iM13235m) {
                C2161a.m13228f(c2167g);
                for (int iM13235m2 = (1 << iM13264y) + C2161a.m13235m(c2167g, iM13264y); iM13235m2 != 0; iM13235m2--) {
                    if (i11 >= i10) {
                        throw new C2163c("Corrupted context map");
                    }
                    bArr[i11] = 0;
                    i11++;
                }
            } else {
                bArr[i11] = (byte) (iM13264y - iM13235m);
            }
            i11++;
        }
        C2161a.m13228f(c2167g);
        if (C2161a.m13235m(c2167g, 1) == 1) {
            m13255p(bArr, i10);
        }
        return iM13251l;
    }

    /* renamed from: h */
    public static void m13247h(C2167g c2167g) {
        c2167g.f9802B = m13244e(c2167g, 2, c2167g.f9803C);
        c2167g.f9813M = c2167g.f9841h[9] << 2;
    }

    /* renamed from: i */
    public static int[] m13248i(int i10, int i11, C2167g c2167g) {
        int[] iArr = new int[(i11 * 1080) + i11];
        int i12 = i11;
        for (int i13 = 0; i13 < i11; i13++) {
            iArr[i13] = i12;
            m13259t(i10, iArr, i12, c2167g);
            i12 += 1080;
        }
        return iArr;
    }

    /* renamed from: j */
    public static void m13249j(C2167g c2167g) {
        c2167g.f9857x = m13244e(c2167g, 0, c2167g.f9858y);
        int i10 = c2167g.f9841h[5];
        int i11 = i10 << 6;
        c2167g.f9812L = i11;
        int i12 = c2167g.f9831c[i11] & 255;
        c2167g.f9808H = i12;
        c2167g.f9809I = c2167g.f9843j[i12];
        int i13 = c2167g.f9829b[i10] << 9;
        c2167g.f9814N = i13;
        c2167g.f9815O = i13 + 256;
    }

    /* renamed from: k */
    public static void m13250k(C2167g c2167g) {
        C2161a.m13228f(c2167g);
        int iM13235m = C2161a.m13235m(c2167g, 1);
        c2167g.f9854u = iM13235m;
        int i10 = 0;
        c2167g.f9853t = 0;
        c2167g.f9855v = 0;
        c2167g.f9856w = 0;
        if (iM13235m == 0 || C2161a.m13235m(c2167g, 1) == 0) {
            int iM13235m2 = C2161a.m13235m(c2167g, 2) + 4;
            if (iM13235m2 == 7) {
                c2167g.f9856w = 1;
                if (C2161a.m13235m(c2167g, 1) != 0) {
                    throw new C2163c("Corrupted reserved bit");
                }
                int iM13235m3 = C2161a.m13235m(c2167g, 2);
                if (iM13235m3 == 0) {
                    return;
                }
                while (i10 < iM13235m3) {
                    C2161a.m13228f(c2167g);
                    int iM13235m4 = C2161a.m13235m(c2167g, 8);
                    if (iM13235m4 == 0 && i10 + 1 == iM13235m3 && iM13235m3 > 1) {
                        throw new C2163c("Exuberant nibble");
                    }
                    c2167g.f9853t = (iM13235m4 << (i10 * 8)) | c2167g.f9853t;
                    i10++;
                }
            } else {
                while (i10 < iM13235m2) {
                    C2161a.m13228f(c2167g);
                    int iM13235m5 = C2161a.m13235m(c2167g, 4);
                    if (iM13235m5 == 0 && i10 + 1 == iM13235m2 && iM13235m2 > 4) {
                        throw new C2163c("Exuberant nibble");
                    }
                    c2167g.f9853t = (iM13235m5 << (i10 * 4)) | c2167g.f9853t;
                    i10++;
                }
            }
            c2167g.f9853t++;
            if (c2167g.f9854u == 0) {
                c2167g.f9855v = C2161a.m13235m(c2167g, 1);
            }
        }
    }

    /* renamed from: l */
    public static int m13251l(C2167g c2167g) {
        C2161a.m13228f(c2167g);
        if (C2161a.m13235m(c2167g, 1) == 0) {
            return 0;
        }
        int iM13235m = C2161a.m13235m(c2167g, 3);
        if (iM13235m == 0) {
            return 1;
        }
        return C2161a.m13235m(c2167g, iM13235m) + (1 << iM13235m);
    }

    /* renamed from: m */
    public static int m13252m(C2167g c2167g) {
        C2161a.m13228f(c2167g);
        if (C2161a.m13235m(c2167g, 1) == 0) {
            return 16;
        }
        int iM13235m = C2161a.m13235m(c2167g, 3);
        if (iM13235m != 0) {
            return iM13235m + 17;
        }
        int iM13235m2 = C2161a.m13235m(c2167g, 3);
        if (iM13235m2 != 0) {
            return iM13235m2 + 8;
        }
        return 17;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00c8, code lost:
    
        throw new com.huawei.android.brotli.dec.C2163c("Invalid backward reference");
     */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0058 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0308 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x00f1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x01f9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x00f5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0015 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0015 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:198:0x02de A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:200:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0158 A[LOOP:4: B:59:0x0158->B:205:?, LOOP_START] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0190  */
    /* renamed from: n */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m13253n(com.huawei.android.brotli.dec.C2167g r18) {
        /*
            Method dump skipped, instructions count: 882
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.brotli.dec.C2165e.m13253n(com.huawei.android.brotli.dec.g):void");
    }

    /* renamed from: o */
    public static void m13254o(C2167g c2167g, InputStream inputStream) {
        if (c2167g.f9847n != 0) {
            throw new IllegalStateException("State MUST be uninitialized");
        }
        c2167g.f9842i = new int[6480];
        c2167g.f9840g0 = inputStream;
        C2161a.m13230h(c2167g);
        int iM13252m = m13252m(c2167g);
        if (iM13252m == 9) {
            throw new C2163c("Invalid 'windowBits' code");
        }
        int i10 = 1 << iM13252m;
        c2167g.f9824X = i10;
        c2167g.f9823W = i10 - 16;
        c2167g.f9847n = 1;
    }

    /* renamed from: p */
    public static void m13255p(byte[] bArr, int i10) {
        int[] iArr = new int[256];
        for (int i11 = 0; i11 < 256; i11++) {
            iArr[i11] = i11;
        }
        for (int i12 = 0; i12 < i10; i12++) {
            int i13 = bArr[i12] & 255;
            bArr[i12] = (byte) iArr[i13];
            if (i13 != 0) {
                m13257r(iArr, i13);
            }
        }
    }

    /* renamed from: q */
    public static void m13256q(C2167g c2167g) {
        int i10 = c2167g.f9824X;
        int i11 = c2167g.f9826Z;
        if (i10 > i11) {
            while (true) {
                int i12 = i10 >> 1;
                if (i12 <= i11) {
                    break;
                } else {
                    i10 = i12;
                }
            }
            if (c2167g.f9854u == 0 && i10 < 16384 && c2167g.f9824X >= 16384) {
                i10 = 16384;
            }
        }
        int i13 = c2167g.f9825Y;
        if (i10 <= i13) {
            return;
        }
        byte[] bArr = new byte[i10 + 37];
        byte[] bArr2 = c2167g.f9827a;
        if (bArr2.length != 0) {
            System.arraycopy(bArr2, 0, bArr, 0, i13);
        }
        c2167g.f9827a = bArr;
        c2167g.f9825Y = i10;
    }

    /* renamed from: r */
    public static void m13257r(int[] iArr, int i10) {
        int i11 = iArr[i10];
        while (i10 > 0) {
            iArr[i10] = iArr[i10 - 1];
            i10--;
        }
        iArr[0] = i11;
    }

    /* renamed from: s */
    public static int m13258s(int[] iArr, int i10, C2167g c2167g) {
        C2161a.m13228f(c2167g);
        int iM13264y = m13264y(iArr, i10, c2167g);
        int i11 = f9794h[iM13264y];
        C2161a.m13228f(c2167g);
        return f9793g[iM13264y] + C2161a.m13234l(c2167g, i11);
    }

    /* renamed from: t */
    public static void m13259t(int i10, int[] iArr, int i11, C2167g c2167g) {
        int iM13241b;
        C2161a.m13236n(c2167g);
        int[] iArr2 = new int[i10];
        C2161a.m13228f(c2167g);
        int iM13235m = C2161a.m13235m(c2167g, 2);
        if (iM13235m == 1) {
            int i12 = i10 - 1;
            int[] iArr3 = new int[4];
            int iM13235m2 = C2161a.m13235m(c2167g, 2) + 1;
            int i13 = 0;
            while (i12 != 0) {
                i12 >>= 1;
                i13++;
            }
            for (int i14 = 0; i14 < iM13235m2; i14++) {
                C2161a.m13228f(c2167g);
                int iM13235m3 = C2161a.m13235m(c2167g, i13) % i10;
                iArr3[i14] = iM13235m3;
                iArr2[iM13235m3] = 2;
            }
            iArr2[iArr3[0]] = 1;
            if (iM13235m2 == 2) {
                iArr2[iArr3[1]] = 1;
            } else if (iM13235m2 == 4) {
                if (C2161a.m13235m(c2167g, 1) == 1) {
                    iArr2[iArr3[2]] = 3;
                    iArr2[iArr3[3]] = 3;
                } else {
                    iArr2[iArr3[0]] = 2;
                }
            }
            iM13241b = m13241b(iArr3, iM13235m2);
        } else {
            int[] iArr4 = new int[18];
            int i15 = 0;
            int i16 = 32;
            while (iM13235m < 18 && i16 > 0) {
                int i17 = f9787a[iM13235m];
                C2161a.m13228f(c2167g);
                int iM13232j = C2161a.m13232j(c2167g) & 15;
                int i18 = c2167g.f9849p;
                int i19 = f9790d[iM13232j];
                c2167g.f9849p = i18 + (i19 >> 16);
                int i20 = i19 & 65535;
                iArr4[i17] = i20;
                if (i20 != 0) {
                    i16 -= 32 >> i20;
                    i15++;
                }
                iM13235m++;
            }
            int i21 = (i16 == 0 || i15 == 1) ? 1 : 0;
            m13260u(iArr4, i10, iArr2, c2167g);
            iM13241b = i21;
        }
        if (iM13241b == 0) {
            throw new C2163c("Can't readHuffmanCode");
        }
        C2166f.m13266a(iArr, i11, 8, iArr2, i10);
    }

    /* renamed from: u */
    public static void m13260u(int[] iArr, int i10, int[] iArr2, C2167g c2167g) {
        int[] iArr3 = new int[32];
        C2166f.m13266a(iArr3, 0, 5, iArr, 18);
        int i11 = 8;
        int i12 = 32768;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (i13 < i10 && i12 > 0) {
            C2161a.m13236n(c2167g);
            C2161a.m13228f(c2167g);
            int iM13232j = C2161a.m13232j(c2167g) & 31;
            int i16 = c2167g.f9849p;
            int i17 = iArr3[iM13232j];
            c2167g.f9849p = i16 + (i17 >> 16);
            int i18 = i17 & 65535;
            if (i18 < 16) {
                int i19 = i13 + 1;
                iArr2[i13] = i18;
                if (i18 != 0) {
                    i12 -= C5914f2.f26733f >> i18;
                    i13 = i19;
                    i11 = i18;
                } else {
                    i13 = i19;
                }
                i15 = 0;
            } else {
                int i20 = i18 - 14;
                int i21 = i18 == 16 ? i11 : 0;
                if (i14 != i21) {
                    i15 = 0;
                    i14 = i21;
                }
                int i22 = i15 > 0 ? (i15 - 2) << i20 : i15;
                C2161a.m13228f(c2167g);
                int iM13235m = i22 + C2161a.m13235m(c2167g, i20) + 3;
                int i23 = iM13235m - i15;
                if (i13 + i23 > i10) {
                    throw new C2163c("symbol + repeatDelta > numSymbols");
                }
                int i24 = 0;
                while (i24 < i23) {
                    iArr2[i13] = i14;
                    i24++;
                    i13++;
                }
                if (i14 != 0) {
                    i12 -= i23 << (15 - i14);
                }
                i15 = iM13235m;
            }
        }
        if (i12 != 0) {
            throw new C2163c("Unused space");
        }
        C2169i.m13275d(iArr2, i13, i10);
    }

    /* renamed from: v */
    public static void m13261v(C2167g c2167g) {
        int i10;
        int iM13251l = m13251l(c2167g) + 1;
        c2167g.f9858y = iM13251l;
        c2167g.f9857x = m13262w(c2167g, 0, iM13251l);
        int iM13251l2 = m13251l(c2167g) + 1;
        c2167g.f9801A = iM13251l2;
        c2167g.f9859z = m13262w(c2167g, 1, iM13251l2);
        int iM13251l3 = m13251l(c2167g) + 1;
        c2167g.f9803C = iM13251l3;
        c2167g.f9802B = m13262w(c2167g, 2, iM13251l3);
        C2161a.m13236n(c2167g);
        C2161a.m13228f(c2167g);
        c2167g.f9820T = C2161a.m13235m(c2167g, 2);
        int iM13235m = C2161a.m13235m(c2167g, 4);
        int i11 = c2167g.f9820T;
        int i12 = (iM13235m << i11) + 16;
        c2167g.f9818R = i12;
        c2167g.f9819S = (1 << i11) - 1;
        int i13 = i12 + (48 << i11);
        c2167g.f9829b = new byte[c2167g.f9858y];
        int i14 = 0;
        while (true) {
            i10 = c2167g.f9858y;
            if (i14 >= i10) {
                break;
            }
            int iMin = Math.min(i14 + 96, i10);
            while (i14 < iMin) {
                C2161a.m13228f(c2167g);
                c2167g.f9829b[i14] = (byte) C2161a.m13235m(c2167g, 2);
                i14++;
            }
            C2161a.m13236n(c2167g);
        }
        byte[] bArr = new byte[i10 << 6];
        c2167g.f9831c = bArr;
        int iM13246g = m13246g(i10 << 6, bArr, c2167g);
        c2167g.f9807G = 1;
        int i15 = 0;
        while (true) {
            if (i15 >= (c2167g.f9858y << 6)) {
                break;
            }
            if (c2167g.f9831c[i15] != (i15 >> 6)) {
                c2167g.f9807G = 0;
                break;
            }
            i15++;
        }
        int i16 = c2167g.f9803C;
        byte[] bArr2 = new byte[i16 << 2];
        c2167g.f9833d = bArr2;
        int iM13246g2 = m13246g(i16 << 2, bArr2, c2167g);
        c2167g.f9843j = m13248i(256, iM13246g, c2167g);
        c2167g.f9844k = m13248i(ErrorCode.ERROR_BANNER_AD_EXPIRE, c2167g.f9801A, c2167g);
        c2167g.f9845l = m13248i(i13, iM13246g2, c2167g);
        c2167g.f9812L = 0;
        c2167g.f9813M = 0;
        int i17 = c2167g.f9829b[0] << 9;
        c2167g.f9814N = i17;
        c2167g.f9815O = i17 + 256;
        c2167g.f9808H = 0;
        c2167g.f9809I = c2167g.f9843j[0];
        c2167g.f9816P = c2167g.f9844k[0];
        int[] iArr = c2167g.f9841h;
        iArr[4] = 1;
        iArr[5] = 0;
        iArr[6] = 1;
        iArr[7] = 0;
        iArr[8] = 1;
        iArr[9] = 0;
    }

    /* renamed from: w */
    public static int m13262w(C2167g c2167g, int i10, int i11) {
        if (i11 <= 1) {
            return HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK;
        }
        m13259t(i11 + 2, c2167g.f9842i, i10 * 1080, c2167g);
        int i12 = (i10 + 3) * 1080;
        m13259t(26, c2167g.f9842i, i12, c2167g);
        return m13258s(c2167g.f9842i, i12, c2167g);
    }

    /* renamed from: x */
    public static void m13263x(C2167g c2167g) {
        if (c2167g.f9854u != 0) {
            c2167g.f9848o = 9;
            c2167g.f9847n = 11;
            return;
        }
        c2167g.f9843j = new int[0];
        c2167g.f9844k = new int[0];
        c2167g.f9845l = new int[0];
        C2161a.m13236n(c2167g);
        m13250k(c2167g);
        if (c2167g.f9853t == 0 && c2167g.f9856w == 0) {
            return;
        }
        if (c2167g.f9855v == 0 && c2167g.f9856w == 0) {
            c2167g.f9847n = 2;
        } else {
            C2161a.m13231i(c2167g);
            c2167g.f9847n = c2167g.f9856w != 0 ? 4 : 5;
        }
        if (c2167g.f9856w != 0) {
            return;
        }
        int i10 = c2167g.f9826Z + c2167g.f9853t;
        c2167g.f9826Z = i10;
        if (i10 > 1073741824) {
            c2167g.f9826Z = 1073741824;
        }
        if (c2167g.f9825Y < c2167g.f9824X) {
            m13256q(c2167g);
        }
    }

    /* renamed from: y */
    public static int m13264y(int[] iArr, int i10, C2167g c2167g) {
        int iM13232j = C2161a.m13232j(c2167g);
        int i11 = i10 + (iM13232j & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
        int i12 = iArr[i11];
        int i13 = i12 >> 16;
        int i14 = i12 & 65535;
        if (i13 <= 8) {
            c2167g.f9849p += i13;
            return i14;
        }
        int i15 = i11 + i14 + ((iM13232j & ((1 << i13) - 1)) >>> 8);
        int i16 = c2167g.f9849p;
        int i17 = iArr[i15];
        c2167g.f9849p = i16 + (i17 >> 16) + 8;
        return i17 & 65535;
    }

    /* renamed from: z */
    public static int m13265z(int i10, int[] iArr, int i11) {
        return i10 < 16 ? iArr[(i11 + f9788b[i10]) & 3] + f9789c[i10] : i10 - 15;
    }
}
