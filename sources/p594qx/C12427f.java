package p594qx;

import com.huawei.android.remotecontrol.tag.p092ui.view.RippleView;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.Calendar;

/* renamed from: qx.f */
/* loaded from: classes9.dex */
public class C12427f {
    /* renamed from: a */
    public static byte[] m74611a(char[] cArr, boolean z10) {
        return z10 ? m74613c(cArr) : m74612b(cArr);
    }

    /* renamed from: b */
    public static byte[] m74612b(char[] cArr) {
        byte[] bArr = new byte[cArr.length];
        for (int i10 = 0; i10 < cArr.length; i10++) {
            bArr[i10] = (byte) cArr[i10];
        }
        return bArr;
    }

    /* renamed from: c */
    public static byte[] m74613c(char[] cArr) {
        try {
            ByteBuffer byteBufferEncode = C12425d.f57265b.encode(CharBuffer.wrap(cArr));
            byte[] bArr = new byte[byteBufferEncode.limit()];
            byteBufferEncode.get(bArr);
            return bArr;
        } catch (Exception unused) {
            return m74612b(cArr);
        }
    }

    /* renamed from: d */
    public static long m74614d(long j10) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j10);
        if (calendar.get(1) < 1980) {
            return 2162688L;
        }
        return (calendar.get(13) >> 1) | ((r5 - 1980) << 25) | ((calendar.get(2) + 1) << 21) | (calendar.get(5) << 16) | (calendar.get(11) << 11) | (calendar.get(12) << 5);
    }

    /* renamed from: e */
    public static long m74615e(long j10) {
        if (j10 < 0) {
            return 2162688L;
        }
        long jM74614d = m74614d(j10);
        if (jM74614d != 2162688) {
            return jM74614d + ((j10 % RippleView.SINGLE_RIPPLE_TIME) << 32);
        }
        return 2162688L;
    }

    /* renamed from: f */
    public static boolean m74616f(String str) {
        return str != null && str.trim().length() > 0;
    }

    /* renamed from: g */
    public static boolean m74617g(String str) {
        return str == null || str.trim().length() == 0;
    }
}
