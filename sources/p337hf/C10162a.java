package p337hf;

import android.graphics.Bitmap;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import java.lang.reflect.Array;

/* renamed from: hf.a */
/* loaded from: classes4.dex */
public class C10162a {
    /* renamed from: a */
    public static Bitmap m63346a(Bitmap bitmap, int i10, boolean z10) {
        int[] iArr;
        int i11 = i10;
        Bitmap bitmapCreateBitmap = z10 ? bitmap : Bitmap.createBitmap(bitmap);
        if (i11 < 1) {
            return null;
        }
        int width = bitmapCreateBitmap.getWidth();
        int height = bitmapCreateBitmap.getHeight();
        int i12 = width * height;
        int[] iArr2 = new int[i12];
        bitmapCreateBitmap.getPixels(iArr2, 0, width, 0, 0, width, height);
        int i13 = width - 1;
        int i14 = height - 1;
        int i15 = i11 + i11;
        int i16 = i15 + 1;
        int[] iArr3 = new int[i12];
        int[] iArr4 = new int[i12];
        int[] iArr5 = new int[i12];
        int[] iArr6 = new int[Math.max(width, height)];
        int i17 = (i15 + 2) >> 1;
        int i18 = i17 * i17;
        int i19 = i18 * 256;
        int[] iArr7 = new int[i19];
        for (int i20 = 0; i20 < i19; i20++) {
            iArr7[i20] = i20 / i18;
        }
        int[][] iArr8 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i16, 3);
        int i21 = i11 + 1;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        while (i22 < height) {
            int i25 = -i11;
            int i26 = 0;
            int i27 = 0;
            int i28 = 0;
            int i29 = 0;
            int i30 = 0;
            int i31 = 0;
            int i32 = 0;
            int i33 = 0;
            int i34 = 0;
            while (i25 <= i11) {
                int i35 = i14;
                int i36 = height;
                int i37 = iArr2[i23 + Math.min(i13, Math.max(i25, 0))];
                int[] iArr9 = iArr8[i25 + i11];
                iArr9[0] = (i37 & 16711680) >> 16;
                iArr9[1] = (i37 & 65280) >> 8;
                iArr9[2] = i37 & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA;
                int iAbs = i21 - Math.abs(i25);
                int i38 = iArr9[0];
                i26 += i38 * iAbs;
                int i39 = iArr9[1];
                i27 += i39 * iAbs;
                int i40 = iArr9[2];
                i28 += iAbs * i40;
                if (i25 > 0) {
                    i32 += i38;
                    i33 += i39;
                    i34 += i40;
                } else {
                    i29 += i38;
                    i30 += i39;
                    i31 += i40;
                }
                i25++;
                height = i36;
                i14 = i35;
            }
            int i41 = i14;
            int i42 = height;
            int i43 = i11;
            int i44 = 0;
            while (i44 < width) {
                iArr3[i23] = iArr7[i26];
                iArr4[i23] = iArr7[i27];
                iArr5[i23] = iArr7[i28];
                int i45 = i26 - i29;
                int i46 = i27 - i30;
                int i47 = i28 - i31;
                int[] iArr10 = iArr8[((i43 - i11) + i16) % i16];
                int i48 = i29 - iArr10[0];
                int i49 = i30 - iArr10[1];
                int i50 = i31 - iArr10[2];
                if (i22 == 0) {
                    iArr = iArr7;
                    iArr6[i44] = Math.min(i44 + i11 + 1, i13);
                } else {
                    iArr = iArr7;
                }
                int i51 = iArr2[i24 + iArr6[i44]];
                int i52 = (i51 & 16711680) >> 16;
                iArr10[0] = i52;
                int i53 = (i51 & 65280) >> 8;
                iArr10[1] = i53;
                int i54 = i51 & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA;
                iArr10[2] = i54;
                int i55 = i32 + i52;
                int i56 = i33 + i53;
                int i57 = i34 + i54;
                i26 = i45 + i55;
                i27 = i46 + i56;
                i28 = i47 + i57;
                i43 = (i43 + 1) % i16;
                int[] iArr11 = iArr8[i43 % i16];
                int i58 = iArr11[0];
                i29 = i48 + i58;
                int i59 = iArr11[1];
                i30 = i49 + i59;
                int i60 = iArr11[2];
                i31 = i50 + i60;
                i32 = i55 - i58;
                i33 = i56 - i59;
                i34 = i57 - i60;
                i23++;
                i44++;
                iArr7 = iArr;
            }
            i24 += width;
            i22++;
            height = i42;
            i14 = i41;
        }
        int i61 = i14;
        int i62 = height;
        int[] iArr12 = iArr7;
        int i63 = 0;
        while (i63 < width) {
            int i64 = -i11;
            int i65 = i64 * width;
            int i66 = 0;
            int i67 = 0;
            int i68 = 0;
            int i69 = 0;
            int i70 = 0;
            int i71 = 0;
            int i72 = 0;
            int i73 = 0;
            int i74 = 0;
            while (i64 <= i11) {
                int[] iArr13 = iArr6;
                int iMax = Math.max(0, i65) + i63;
                int[] iArr14 = iArr8[i64 + i11];
                iArr14[0] = iArr3[iMax];
                iArr14[1] = iArr4[iMax];
                iArr14[2] = iArr5[iMax];
                int iAbs2 = i21 - Math.abs(i64);
                i66 += iArr3[iMax] * iAbs2;
                i67 += iArr4[iMax] * iAbs2;
                i68 += iArr5[iMax] * iAbs2;
                if (i64 > 0) {
                    i72 += iArr14[0];
                    i73 += iArr14[1];
                    i74 += iArr14[2];
                } else {
                    i69 += iArr14[0];
                    i70 += iArr14[1];
                    i71 += iArr14[2];
                }
                int i75 = i61;
                if (i64 < i75) {
                    i65 += width;
                }
                i64++;
                i61 = i75;
                iArr6 = iArr13;
            }
            int[] iArr15 = iArr6;
            int i76 = i61;
            int i77 = i11;
            int i78 = i63;
            int i79 = i62;
            int i80 = 0;
            while (i80 < i79) {
                iArr2[i78] = (iArr2[i78] & (-16777216)) | (iArr12[i66] << 16) | (iArr12[i67] << 8) | iArr12[i68];
                int i81 = i66 - i69;
                int i82 = i67 - i70;
                int i83 = i68 - i71;
                int[] iArr16 = iArr8[((i77 - i11) + i16) % i16];
                int i84 = i69 - iArr16[0];
                int i85 = i70 - iArr16[1];
                int i86 = i71 - iArr16[2];
                if (i63 == 0) {
                    iArr15[i80] = Math.min(i80 + i21, i76) * width;
                }
                int i87 = iArr15[i80] + i63;
                int i88 = iArr3[i87];
                iArr16[0] = i88;
                int i89 = iArr4[i87];
                iArr16[1] = i89;
                int i90 = iArr5[i87];
                iArr16[2] = i90;
                int i91 = i72 + i88;
                int i92 = i73 + i89;
                int i93 = i74 + i90;
                i66 = i81 + i91;
                i67 = i82 + i92;
                i68 = i83 + i93;
                i77 = (i77 + 1) % i16;
                int[] iArr17 = iArr8[i77];
                int i94 = iArr17[0];
                i69 = i84 + i94;
                int i95 = iArr17[1];
                i70 = i85 + i95;
                int i96 = iArr17[2];
                i71 = i86 + i96;
                i72 = i91 - i94;
                i73 = i92 - i95;
                i74 = i93 - i96;
                i78 += width;
                i80++;
                i11 = i10;
            }
            i63++;
            i11 = i10;
            i62 = i79;
            i61 = i76;
            iArr6 = iArr15;
        }
        int i97 = i62;
        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(width, i97, Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap2.setPixels(iArr2, 0, width, 0, 0, width, i97);
        return bitmapCreateBitmap2;
    }
}
