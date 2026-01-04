package com.huawei.hms.drive;

import java.util.List;
import p022ay.C1057g;

/* renamed from: com.huawei.hms.drive.cn */
/* loaded from: classes8.dex */
public final class C5237cn {

    /* renamed from: a */
    private static final C1057g f24212a = C1057g.m6364k("\"\\");

    /* renamed from: b */
    private static final C1057g f24213b = C1057g.m6364k("\t ,=");

    /* renamed from: a */
    public static long m31411a(C5203bh c5203bh) {
        return m31410a(c5203bh.m31132e());
    }

    /* renamed from: b */
    public static boolean m31415b(C5203bh c5203bh) {
        if (c5203bh.m31126a().m31109b().equals("HEAD")) {
            return false;
        }
        int iM31129b = c5203bh.m31129b();
        return (((iM31129b >= 100 && iM31129b < 200) || iM31129b == 204 || iM31129b == 304) && m31411a(c5203bh) == -1 && !"chunked".equalsIgnoreCase(c5203bh.m31127a("Transfer-Encoding"))) ? false : true;
    }

    /* renamed from: a */
    public static long m31410a(C5190aw c5190aw) {
        return m31412a(c5190aw.m30923a("Content-Length"));
    }

    /* renamed from: a */
    private static long m31412a(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    /* renamed from: a */
    public static void m31413a(InterfaceC5185ar interfaceC5185ar, C5193az c5193az, C5190aw c5190aw) {
        if (interfaceC5185ar == InterfaceC5185ar.f23765a) {
            return;
        }
        List<C5184aq> listM30873a = C5184aq.m30873a(c5193az, c5190aw);
        if (listM30873a.isEmpty()) {
            return;
        }
        interfaceC5185ar.mo30880a(c5193az, listM30873a);
    }

    /* renamed from: b */
    public static int m31414b(String str, int i10) {
        try {
            long j10 = Long.parseLong(str);
            if (j10 > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (j10 < 0) {
                return 0;
            }
            return (int) j10;
        } catch (NumberFormatException unused) {
            return i10;
        }
    }

    /* renamed from: a */
    public static int m31409a(String str, int i10, String str2) {
        while (i10 < str.length() && str2.indexOf(str.charAt(i10)) == -1) {
            i10++;
        }
        return i10;
    }

    /* renamed from: a */
    public static int m31408a(String str, int i10) {
        char cCharAt;
        while (i10 < str.length() && ((cCharAt = str.charAt(i10)) == ' ' || cCharAt == '\t')) {
            i10++;
        }
        return i10;
    }
}
