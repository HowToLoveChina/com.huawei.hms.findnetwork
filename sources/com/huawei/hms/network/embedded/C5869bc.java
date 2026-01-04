package com.huawei.hms.network.embedded;

/* renamed from: com.huawei.hms.network.embedded.bc */
/* loaded from: classes8.dex */
public final class C5869bc {
    /* renamed from: a */
    public static long m33995a(String str) {
        return m33996a(str, 0, str.length());
    }

    /* renamed from: a */
    public static long m33996a(String str, int i10, int i11) {
        long j10;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i10 < 0) {
            throw new IllegalArgumentException("beginIndex < 0: " + i10);
        }
        if (i11 < i10) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i11 + " < " + i10);
        }
        if (i11 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i11 + " > " + str.length());
        }
        long j11 = 0;
        while (i10 < i11) {
            char cCharAt = str.charAt(i10);
            if (cCharAt < 128) {
                j11++;
            } else {
                if (cCharAt < 2048) {
                    j10 = 2;
                } else if (cCharAt < 55296 || cCharAt > 57343) {
                    j10 = 3;
                } else {
                    int i12 = i10 + 1;
                    char cCharAt2 = i12 < i11 ? str.charAt(i12) : (char) 0;
                    if (cCharAt > 56319 || cCharAt2 < 56320 || cCharAt2 > 57343) {
                        j11++;
                        i10 = i12;
                    } else {
                        j11 += 4;
                        i10 += 2;
                    }
                }
                j11 += j10;
            }
            i10++;
        }
        return j11;
    }
}
