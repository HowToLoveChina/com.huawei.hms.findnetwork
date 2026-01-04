package com.huawei.android.brotli.dec;

import com.huawei.hms.videokit.player.common.PlayerConstants;
import java.nio.ByteBuffer;

/* renamed from: com.huawei.android.brotli.dec.h */
/* loaded from: classes.dex */
public class C2168h {

    /* renamed from: a */
    public static final int[] f9860a;

    /* renamed from: b */
    public static final byte[] f9861b;

    /* renamed from: c */
    public static final int[] f9862c;

    static {
        int[] iArr = new int[363];
        f9860a = iArr;
        byte[] bArr = new byte[PlayerConstants.EventCode.CAN_NOT_SUPPORT_PROXY];
        f9861b = bArr;
        int[] iArr2 = new int[51];
        f9862c = iArr2;
        m13271b(bArr, iArr2, iArr, "# #s #, #e #.# the #.com/#Â # of # and # in # to #\"#\">#\n#]# for # a # that #. # with #'# from # by #. The # on # as # is #ing #\n\t#:#ed #(# at #ly #=\"# of the #. This #,# not #er #al #='#ful #ive #less #est #ize #ous #", "     !! ! ,  *!  &!  \" !  ) *   * -  ! # !  #!*!  +  ,$ !  -  %  .  / #   0  1 .  \"   2  3!*   4%  ! # /   5  6  7  8 0  1 &   $   9 +   :  ;  < '  !=  >  ?! 4  @ 4  2  &   A *# (   B  C& ) %  ) !*# *-% A +! *.  D! %'  & E *6  F  G% ! *A *%  H! D  I!+!  J!+   K +- *4! A  L!*4  M  N +6  O!*% +.! K *G  P +%(  ! G *D +D  Q +# *K!*G!+D!+# +G +A +4!+% +K!+4!*D!+K!*K");
    }

    /* renamed from: a */
    public static int m13270a(byte[] bArr, int i10, ByteBuffer byteBuffer, int i11, int i12, int i13) {
        int i14 = i13 * 3;
        int[] iArr = f9862c;
        int[] iArr2 = f9860a;
        int i15 = iArr[iArr2[i14]];
        int i16 = iArr2[i14 + 1];
        int i17 = iArr[iArr2[i14 + 2]];
        int i18 = i10;
        while (true) {
            byte b10 = f9861b[i15];
            if (b10 == 0) {
                break;
            }
            i15++;
            bArr[i18] = b10;
            i18++;
        }
        int i19 = i16 >= 12 ? i16 - 11 : 0;
        if (i19 > i12) {
            i19 = i12;
        }
        int i20 = i11 + i19;
        int i21 = (i12 - i19) - (i16 <= 9 ? i16 : 0);
        int i22 = i21;
        while (i22 > 0) {
            bArr[i18] = byteBuffer.get(i20);
            i22--;
            i18++;
            i20++;
        }
        if (i16 == 11 || i16 == 10) {
            int i23 = i18 - i21;
            if (i16 == 10) {
                i21 = 1;
            }
            while (i21 > 0) {
                byte b11 = bArr[i23];
                int i24 = b11 & 255;
                if (i24 < 192) {
                    if (i24 >= 97 && i24 <= 122) {
                        bArr[i23] = (byte) (b11 ^ 32);
                    }
                    i23++;
                    i21--;
                } else if (i24 < 224) {
                    int i25 = i23 + 1;
                    bArr[i25] = (byte) (bArr[i25] ^ 32);
                    i23 += 2;
                    i21 -= 2;
                } else {
                    int i26 = i23 + 2;
                    bArr[i26] = (byte) (bArr[i26] ^ 5);
                    i23 += 3;
                    i21 -= 3;
                }
            }
        }
        while (true) {
            byte b12 = f9861b[i17];
            if (b12 == 0) {
                return i18 - i10;
            }
            i17++;
            bArr[i18] = b12;
            i18++;
        }
    }

    /* renamed from: b */
    public static void m13271b(byte[] bArr, int[] iArr, int[] iArr2, String str, String str2) {
        int length = str.length();
        int i10 = 1;
        for (int i11 = 0; i11 < length; i11++) {
            char cCharAt = str.charAt(i11);
            bArr[i11] = (byte) cCharAt;
            if (cCharAt == '#') {
                iArr[i10] = i11 + 1;
                bArr[i11] = 0;
                i10++;
            }
        }
        for (int i12 = 0; i12 < 363; i12++) {
            iArr2[i12] = str2.charAt(i12) - ' ';
        }
    }
}
