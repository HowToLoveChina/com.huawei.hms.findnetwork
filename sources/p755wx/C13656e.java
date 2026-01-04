package p755wx;

import java.io.IOException;
import p022ay.C1057g;
import sx.C12875e;

/* renamed from: wx.e */
/* loaded from: classes9.dex */
public final class C13656e {

    /* renamed from: a */
    public static final C1057g f61406a = C1057g.m6364k("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* renamed from: b */
    public static final String[] f61407b = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    /* renamed from: c */
    public static final String[] f61408c = new String[64];

    /* renamed from: d */
    public static final String[] f61409d = new String[256];

    static {
        int i10 = 0;
        int i11 = 0;
        while (true) {
            String[] strArr = f61409d;
            if (i11 >= strArr.length) {
                break;
            }
            strArr[i11] = C12875e.m77260q("%8s", Integer.toBinaryString(i11)).replace(' ', '0');
            i11++;
        }
        String[] strArr2 = f61408c;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        int i12 = iArr[0];
        strArr2[i12 | 8] = strArr2[i12] + "|PADDED";
        strArr2[4] = "END_HEADERS";
        strArr2[32] = "PRIORITY";
        strArr2[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i13 = 0; i13 < 3; i13++) {
            int i14 = iArr2[i13];
            int i15 = iArr[0];
            String[] strArr3 = f61408c;
            int i16 = i15 | i14;
            strArr3[i16] = strArr3[i15] + '|' + strArr3[i14];
            strArr3[i16 | 8] = strArr3[i15] + '|' + strArr3[i14] + "|PADDED";
        }
        while (true) {
            String[] strArr4 = f61408c;
            if (i10 >= strArr4.length) {
                return;
            }
            if (strArr4[i10] == null) {
                strArr4[i10] = f61409d[i10];
            }
            i10++;
        }
    }

    /* renamed from: a */
    public static String m82068a(byte b10, byte b11) {
        if (b11 == 0) {
            return "";
        }
        if (b10 != 2 && b10 != 3) {
            if (b10 == 4 || b10 == 6) {
                return b11 == 1 ? "ACK" : f61409d[b11];
            }
            if (b10 != 7 && b10 != 8) {
                String[] strArr = f61408c;
                String str = b11 < strArr.length ? strArr[b11] : f61409d[b11];
                return (b10 != 5 || (b11 & 4) == 0) ? (b10 != 0 || (b11 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED") : str.replace("HEADERS", "PUSH_PROMISE");
            }
        }
        return f61409d[b11];
    }

    /* renamed from: b */
    public static String m82069b(boolean z10, int i10, int i11, byte b10, byte b11) {
        String[] strArr = f61407b;
        String strM77260q = b10 < strArr.length ? strArr[b10] : C12875e.m77260q("0x%02x", Byte.valueOf(b10));
        String strM82068a = m82068a(b10, b11);
        Object[] objArr = new Object[5];
        objArr[0] = z10 ? "<<" : ">>";
        objArr[1] = Integer.valueOf(i10);
        objArr[2] = Integer.valueOf(i11);
        objArr[3] = strM77260q;
        objArr[4] = strM82068a;
        return C12875e.m77260q("%s 0x%08x %5d %-13s %s", objArr);
    }

    /* renamed from: c */
    public static IllegalArgumentException m82070c(String str, Object... objArr) {
        throw new IllegalArgumentException(C12875e.m77260q(str, objArr));
    }

    /* renamed from: d */
    public static IOException m82071d(String str, Object... objArr) throws IOException {
        throw new IOException(C12875e.m77260q(str, objArr));
    }
}
