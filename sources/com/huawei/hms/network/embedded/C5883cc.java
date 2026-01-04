package com.huawei.hms.network.embedded;

import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import java.nio.charset.Charset;

/* renamed from: com.huawei.hms.network.embedded.cc */
/* loaded from: classes8.dex */
public final class C5883cc {

    /* renamed from: a */
    public static final Charset f26596a = Charset.forName(Constants.UTF_8);

    /* renamed from: a */
    public static int m34085a(int i10) {
        return ((i10 & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA) << 24) | (((-16777216) & i10) >>> 24) | ((16711680 & i10) >>> 8) | ((65280 & i10) << 8);
    }

    /* renamed from: b */
    public static <T extends Throwable> void m34091b(Throwable th2) throws Throwable {
        throw th2;
    }

    /* renamed from: a */
    public static long m34086a(long j10) {
        return ((j10 & 255) << 56) | (((-72057594037927936L) & j10) >>> 56) | ((71776119061217280L & j10) >>> 40) | ((280375465082880L & j10) >>> 24) | ((1095216660480L & j10) >>> 8) | ((4278190080L & j10) << 8) | ((16711680 & j10) << 24) | ((65280 & j10) << 40);
    }

    /* renamed from: a */
    public static short m34087a(short s10) {
        return (short) (((s10 & 255) << 8) | ((65280 & s10) >>> 8));
    }

    /* renamed from: a */
    public static void m34088a(long j10, long j11, long j12) {
        if ((j11 | j12) < 0 || j11 > j10 || j10 - j11 < j12) {
            throw new ArrayIndexOutOfBoundsException(String.format("size=%s offset=%s byteCount=%s", Long.valueOf(j10), Long.valueOf(j11), Long.valueOf(j12)));
        }
    }

    /* renamed from: a */
    public static void m34089a(Throwable th2) throws Throwable {
        m34091b(th2);
    }

    /* renamed from: a */
    public static boolean m34090a(byte[] bArr, int i10, byte[] bArr2, int i11, int i12) {
        for (int i13 = 0; i13 < i12; i13++) {
            if (bArr[i13 + i10] != bArr2[i13 + i11]) {
                return false;
            }
        }
        return true;
    }
}
