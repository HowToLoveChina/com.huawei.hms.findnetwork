package com.huawei.hms.drive;

import com.google.flatbuffers.reflection.BaseType;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import com.huawei.uikit.hwrecyclerview.widget.HwItemTouchHelperEx;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import p022ay.C1057g;
import p022ay.InterfaceC1055e;

/* renamed from: com.huawei.hms.drive.df */
/* loaded from: classes8.dex */
class C5257df {

    /* renamed from: a */
    private static final int[] f24439a = {8184, 8388568, 268435426, 268435427, 268435428, 268435429, 268435430, 268435431, 268435432, 16777194, 1073741820, 268435433, 268435434, 1073741821, 268435435, 268435436, 268435437, 268435438, 268435439, 268435440, 268435441, 268435442, 1073741822, 268435443, 268435444, 268435445, 268435446, 268435447, 268435448, 268435449, 268435450, 268435451, 20, FamilyShareConstants.StatusCode.USER_ROLE_NOT_ALLOWED, 1017, 4090, 8185, 21, 248, 2042, 1018, FamilyShareConstants.StatusCode.USER_JOIN_IS_FROZEN, 249, 2043, HwItemTouchHelperEx.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 22, 23, 24, 0, 1, 2, 25, 26, 27, 28, 29, 30, 31, 92, 251, 32764, 32, 4091, 1020, 8186, 33, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 252, 115, 253, 8187, 524272, 8188, 16380, 34, 32765, 3, 35, 4, 36, 5, 37, 38, 39, 6, 116, 117, 40, 41, 42, 7, 43, 118, 44, 8, 9, 45, 119, 120, 121, 122, 123, 32766, 2044, 16381, 8189, 268435452, 1048550, 4194258, 1048551, 1048552, 4194259, 4194260, 4194261, 8388569, 4194262, 8388570, 8388571, 8388572, 8388573, 8388574, 16777195, 8388575, 16777196, 16777197, 4194263, 8388576, 16777198, 8388577, 8388578, 8388579, 8388580, 2097116, 4194264, 8388581, 4194265, 8388582, 8388583, 16777199, 4194266, 2097117, 1048553, 4194267, 4194268, 8388584, 8388585, 2097118, 8388586, 4194269, 4194270, 16777200, 2097119, 4194271, 8388587, 8388588, 2097120, 2097121, 4194272, 2097122, 8388589, 4194273, 8388590, 8388591, 1048554, 4194274, 4194275, 4194276, 8388592, 4194277, 4194278, 8388593, 67108832, 67108833, 1048555, 524273, 4194279, 8388594, 4194280, 33554412, 67108834, 67108835, 67108836, 134217694, 134217695, 67108837, 16777201, 33554413, 524274, 2097123, 67108838, 134217696, 134217697, 67108839, 134217698, 16777202, 2097124, 2097125, 67108840, 67108841, 268435453, 134217699, 134217700, 134217701, 1048556, 16777203, 1048557, 2097126, 4194281, 2097127, 2097128, 8388595, 4194282, 4194283, 33554414, 33554415, 16777204, 16777205, 67108842, 8388596, 67108843, 134217702, 67108844, 67108845, 134217703, 134217704, 134217705, 134217706, 134217707, 268435454, 134217708, 134217709, 134217710, 134217711, 134217712, 67108846};

    /* renamed from: b */
    private static final byte[] f24440b = {13, 23, 28, 28, 28, 28, 28, 28, 28, 24, 30, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 28, 6, 10, 10, BaseType.Double, 13, 6, 8, BaseType.Float, 10, 10, 8, BaseType.Float, 8, 6, 6, 6, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 8, BaseType.Obj, 6, BaseType.Double, 10, 13, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 7, 8, 13, BaseType.MaxBaseType, 13, BaseType.Vector, 6, BaseType.Obj, 5, 6, 5, 6, 5, 6, 6, 6, 5, 7, 7, 6, 6, 6, 5, 6, 7, 6, 5, 5, 6, 7, 7, 7, 7, 7, BaseType.Obj, BaseType.Float, BaseType.Vector, 13, 28, 20, 22, 20, 20, 22, 22, 22, 23, 22, 23, 23, 23, 23, 23, 24, 23, 24, 24, 22, 23, 24, 23, 23, 23, 23, 21, 22, 23, 22, 23, 23, 24, 22, 21, 20, 22, 22, 23, 23, 21, 23, 22, 22, 24, 21, 22, 23, 23, 21, 21, 22, 21, 23, 22, 23, 23, 20, 22, 22, 22, 23, 22, 22, 23, 26, 26, 20, BaseType.MaxBaseType, 22, 23, 22, 25, 26, 26, 26, 27, 27, 26, 24, 25, BaseType.MaxBaseType, 21, 26, 27, 27, 26, 27, 24, 21, 21, 26, 26, 28, 27, 27, 27, 20, 24, 20, 21, 22, 21, 21, 23, 22, 22, 25, 25, 24, 24, 26, 23, 26, 27, 26, 26, 27, 27, 27, 27, 27, 28, 27, 27, 27, 27, 27, 26};

    /* renamed from: c */
    private static final C5257df f24441c = new C5257df();

    /* renamed from: d */
    private final a f24442d = new a();

    private C5257df() {
        m31622b();
    }

    /* renamed from: b */
    private void m31622b() {
        int i10 = 0;
        while (true) {
            byte[] bArr = f24440b;
            if (i10 >= bArr.length) {
                return;
            }
            m31621a(i10, f24439a[i10], bArr[i10]);
            i10++;
        }
    }

    /* renamed from: a */
    public int m31623a(C1057g c1057g) {
        long j10 = 0;
        for (int i10 = 0; i10 < c1057g.m6370E(); i10++) {
            j10 += f24440b[c1057g.m6379p(i10) & 255];
        }
        return (int) ((j10 + 7) >> 3);
    }

    /* renamed from: com.huawei.hms.drive.df$a */
    public static final class a {

        /* renamed from: a */
        final a[] f24443a;

        /* renamed from: b */
        final int f24444b;

        /* renamed from: c */
        final int f24445c;

        public a() {
            this.f24443a = new a[256];
            this.f24444b = 0;
            this.f24445c = 0;
        }

        public a(int i10, int i11) {
            this.f24443a = null;
            this.f24444b = i10;
            int i12 = i11 & 7;
            this.f24445c = i12 == 0 ? 8 : i12;
        }
    }

    /* renamed from: a */
    public void m31624a(C1057g c1057g, InterfaceC1055e interfaceC1055e) throws IOException {
        long j10 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < c1057g.m6370E(); i11++) {
            int iM6379p = c1057g.m6379p(i11) & 255;
            int i12 = f24439a[iM6379p];
            byte b10 = f24440b[iM6379p];
            j10 = (j10 << b10) | i12;
            i10 += b10;
            while (i10 >= 8) {
                i10 -= 8;
                interfaceC1055e.writeByte((int) (j10 >> i10));
            }
        }
        if (i10 > 0) {
            interfaceC1055e.writeByte((int) ((j10 << (8 - i10)) | (HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA >>> i10)));
        }
    }

    /* renamed from: a */
    public static C5257df m31620a() {
        return f24441c;
    }

    /* renamed from: a */
    public byte[] m31625a(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        a aVar = this.f24442d;
        int i10 = 0;
        int i11 = 0;
        for (byte b10 : bArr) {
            i10 = (i10 << 8) | (b10 & 255);
            i11 += 8;
            while (i11 >= 8) {
                aVar = aVar.f24443a[(i10 >>> (i11 - 8)) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA];
                if (aVar.f24443a == null) {
                    byteArrayOutputStream.write(aVar.f24444b);
                    i11 -= aVar.f24445c;
                    aVar = this.f24442d;
                } else {
                    i11 -= 8;
                }
            }
        }
        while (i11 > 0) {
            a aVar2 = aVar.f24443a[(i10 << (8 - i11)) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA];
            if (aVar2.f24443a != null || aVar2.f24445c > i11) {
                break;
            }
            byteArrayOutputStream.write(aVar2.f24444b);
            i11 -= aVar2.f24445c;
            aVar = this.f24442d;
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: a */
    private void m31621a(int i10, int i11, byte b10) {
        a aVar = new a(i10, b10);
        a aVar2 = this.f24442d;
        while (b10 > 8) {
            b10 = (byte) (b10 - 8);
            int i12 = (i11 >>> b10) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA;
            a[] aVarArr = aVar2.f24443a;
            if (aVarArr != null) {
                if (aVarArr[i12] == null) {
                    aVarArr[i12] = new a();
                }
                aVar2 = aVar2.f24443a[i12];
            } else {
                throw new IllegalStateException("invalid dictionary: prefix not unique");
            }
        }
        int i13 = 8 - b10;
        int i14 = (i11 << i13) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA;
        int i15 = 1 << i13;
        for (int i16 = i14; i16 < i14 + i15; i16++) {
            aVar2.f24443a[i16] = aVar;
        }
    }
}
