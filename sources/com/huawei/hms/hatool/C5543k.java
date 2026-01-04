package com.huawei.hms.hatool;

import android.util.Pair;
import java.util.List;
import java.util.Map;
import p237du.C9310c;

/* renamed from: com.huawei.hms.hatool.k */
/* loaded from: classes8.dex */
public class C5543k extends C5570u0 {

    /* renamed from: com.huawei.hms.hatool.k$a */
    public static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f25231a;

        static {
            int[] iArr = new int[EnumC5523d0.values().length];
            f25231a = iArr;
            try {
                iArr[EnumC5523d0.SN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25231a[EnumC5523d0.IMEI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25231a[EnumC5523d0.UDID.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* renamed from: a */
    public static C5529f0 m32596a(String str, String str2, String str3, String str4) {
        C5529f0 c5529f0M32780a = C5570u0.m32780a(str, str2, str3, str4);
        String strM32578a = C5540j.m32576a().m32578a(AbstractC5515a1.m32428c(str2, str3));
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strM58618b = C9310c.m58618b(AbstractC5562q0.m32712f() + strM32578a + jCurrentTimeMillis);
        c5529f0M32780a.m32606f(String.valueOf(jCurrentTimeMillis));
        c5529f0M32780a.m32511g(strM58618b);
        return c5529f0M32780a;
    }

    /* renamed from: b */
    public static Map<String, String> m32600b(String str, String str2, String str3) {
        Map<String, String> mapM32784c = C5570u0.m32784c(str, str3);
        Map<String, String> mapM32434i = AbstractC5515a1.m32434i(str, str2);
        if (mapM32434i == null) {
            return mapM32784c;
        }
        mapM32784c.putAll(mapM32434i);
        return mapM32784c;
    }

    /* renamed from: a */
    public static C5536h1 m32597a(List<C5518b1> list, String str, String str2, String str3, String str4) {
        C5536h1 c5536h1M32783b = C5570u0.m32783b(str, str2);
        if (c5536h1M32783b == null) {
            return null;
        }
        c5536h1M32783b.m32564a(m32596a(C5551m1.m32643d().m32644a(), str, str2, str3));
        c5536h1M32783b.m32565a(m32598a(str, str2));
        c5536h1M32783b.m32566a(m32599a(str2, str, str4));
        c5536h1M32783b.m32567a(AbstractC5515a1.m32432g(str, str2));
        c5536h1M32783b.m32568a(list);
        return c5536h1M32783b;
    }

    /* renamed from: a */
    public static C5546l m32598a(String str, String str2) {
        C5546l c5546lM32781a = C5570u0.m32781a(str, str2);
        C5537i c5537iM32581c = C5540j.m32576a().m32581c(str, str2);
        c5546lM32781a.m32619g(C5540j.m32576a().m32578a(AbstractC5515a1.m32428c(str, str2)));
        c5546lM32781a.m32618f(AbstractC5515a1.m32440o(str, str2));
        c5546lM32781a.m32615c(C5540j.m32576a().m32584f(str, str2));
        int i10 = a.f25231a[c5537iM32581c.m32569a().ordinal()];
        if (i10 == 1) {
            c5546lM32781a.m32616d(c5537iM32581c.m32570b());
        } else if (i10 == 2) {
            c5546lM32781a.m32614b(c5537iM32581c.m32570b());
        } else if (i10 == 3) {
            c5546lM32781a.m32617e(c5537iM32581c.m32570b());
        }
        return c5546lM32781a;
    }

    /* renamed from: a */
    public static C5578y0 m32599a(String str, String str2, String str3) {
        C5578y0 c5578y0M32782a = C5570u0.m32782a(str, str2, str3);
        Pair<String, String> pairM32583e = C5540j.m32576a().m32583e(str2, str);
        c5578y0M32782a.m32825f((String) pairM32583e.first);
        c5578y0M32782a.m32826g((String) pairM32583e.second);
        c5578y0M32782a.m32827h(AbstractC5555o.m32669b());
        c5578y0M32782a.m32776d(C5540j.m32576a().m32582d(str2, str));
        return c5578y0M32782a;
    }
}
