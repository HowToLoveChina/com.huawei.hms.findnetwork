package p022ay;

import ax.C1045o;
import com.google.flatbuffers.reflection.BaseType;
import com.huawei.openalliance.p169ad.constant.VideoPlayFlag;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import cy.C8963b;
import p022ay.C1054d;
import p692uw.C13267j;

/* renamed from: ay.b */
/* loaded from: classes9.dex */
public final class C1051b {

    /* renamed from: a */
    public static final C1054d.a f5119a = new C1054d.a();

    /* renamed from: b */
    public static final int f5120b = -1234567890;

    /* renamed from: a */
    public static final boolean m6293a(byte[] bArr, int i10, byte[] bArr2, int i11, int i12) {
        C13267j.m79677e(bArr, VideoPlayFlag.PLAY_IN_ALL);
        C13267j.m79677e(bArr2, "b");
        for (int i13 = 0; i13 < i12; i13++) {
            if (bArr[i13 + i10] != bArr2[i13 + i11]) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public static final void m6294b(long j10, long j11, long j12) {
        if ((j11 | j12) < 0 || j11 > j10 || j10 - j11 < j12) {
            throw new ArrayIndexOutOfBoundsException("size=" + j10 + " offset=" + j11 + " byteCount=" + j12);
        }
    }

    /* renamed from: c */
    public static final int m6295c(C1057g c1057g, int i10) {
        C13267j.m79677e(c1057g, "<this>");
        return i10 == f5120b ? c1057g.m6370E() : i10;
    }

    /* renamed from: d */
    public static final int m6296d(int i10) {
        return ((i10 & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA) << 24) | (((-16777216) & i10) >>> 24) | ((16711680 & i10) >>> 8) | ((65280 & i10) << 8);
    }

    /* renamed from: e */
    public static final short m6297e(short s10) {
        return (short) (((s10 & 255) << 8) | ((65280 & s10) >>> 8));
    }

    /* renamed from: f */
    public static final String m6298f(byte b10) {
        return C1045o.m6259d(new char[]{C8963b.m56724f()[(b10 >> 4) & 15], C8963b.m56724f()[b10 & BaseType.Obj]});
    }

    /* renamed from: g */
    public static final String m6299g(int i10) {
        int i11 = 0;
        if (i10 == 0) {
            return "0";
        }
        char[] cArr = {C8963b.m56724f()[(i10 >> 28) & 15], C8963b.m56724f()[(i10 >> 24) & 15], C8963b.m56724f()[(i10 >> 20) & 15], C8963b.m56724f()[(i10 >> 16) & 15], C8963b.m56724f()[(i10 >> 12) & 15], C8963b.m56724f()[(i10 >> 8) & 15], C8963b.m56724f()[(i10 >> 4) & 15], C8963b.m56724f()[i10 & 15]};
        while (i11 < 8 && cArr[i11] == '0') {
            i11++;
        }
        return C1045o.m6260e(cArr, i11, 8);
    }
}
