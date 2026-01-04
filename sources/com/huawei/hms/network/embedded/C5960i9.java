package com.huawei.hms.network.embedded;

import com.huawei.hms.network.embedded.C5971j7;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/* renamed from: com.huawei.hms.network.embedded.i9 */
/* loaded from: classes8.dex */
public final class C5960i9 {

    /* renamed from: a */
    public static final C5910eb f27036a = C5910eb.m34157d("\"\\");

    /* renamed from: b */
    public static final C5910eb f27037b = C5910eb.m34157d("\t ,=");

    /* renamed from: a */
    public static int m34399a(C5868bb c5868bb, byte b10) {
        int i10 = 0;
        while (!c5868bb.mo33971i() && c5868bb.m33972j(0L) == b10) {
            i10++;
            try {
                c5868bb.readByte();
            } catch (EOFException e10) {
                throw new AssertionError(e10);
            }
        }
        return i10;
    }

    /* renamed from: b */
    public static int m34412b(String str, int i10) {
        char cCharAt;
        while (i10 < str.length() && ((cCharAt = str.charAt(i10)) == ' ' || cCharAt == '\t')) {
            i10++;
        }
        return i10;
    }

    /* renamed from: c */
    public static Set<String> m34416c(C5971j7 c5971j7) {
        Set<String> setEmptySet = Collections.emptySet();
        int iM34527d = c5971j7.m34527d();
        for (int i10 = 0; i10 < iM34527d; i10++) {
            if ("Vary".equalsIgnoreCase(c5971j7.m34520a(i10))) {
                String strM34522b = c5971j7.m34522b(i10);
                if (setEmptySet.isEmpty()) {
                    setEmptySet = new TreeSet<>((Comparator<? super String>) String.CASE_INSENSITIVE_ORDER);
                }
                for (String str : strM34522b.split(",")) {
                    setEmptySet.add(str.trim());
                }
            }
        }
        return setEmptySet;
    }

    /* renamed from: d */
    public static Set<String> m34419d(C6127v7 c6127v7) {
        return m34416c(c6127v7.m35591y());
    }

    /* renamed from: e */
    public static C5971j7 m34420e(C6127v7 c6127v7) {
        return m34405a(c6127v7.m35573C().m35578H().m35417e(), c6127v7.m35591y());
    }

    /* renamed from: a */
    public static int m34400a(String str, int i10) throws NumberFormatException {
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

    /* renamed from: b */
    public static String m34413b(C5868bb c5868bb) {
        try {
            long jMo33951c = c5868bb.mo33951c(f27037b);
            if (jMo33951c == -1) {
                jMo33951c = c5868bb.m33913B();
            }
            if (jMo33951c != 0) {
                return c5868bb.mo33965f(jMo33951c);
            }
            return null;
        } catch (EOFException e10) {
            throw new AssertionError(e10);
        }
    }

    /* renamed from: c */
    public static boolean m34417c(C5868bb c5868bb) {
        boolean z10 = false;
        while (!c5868bb.mo33971i()) {
            byte bM33972j = c5868bb.m33972j(0L);
            if (bM33972j != 44) {
                if (bM33972j != 32 && bM33972j != 9) {
                    break;
                }
                c5868bb.readByte();
            } else {
                try {
                    c5868bb.readByte();
                    z10 = true;
                } catch (EOFException e10) {
                    throw new AssertionError(e10);
                }
            }
        }
        return z10;
    }

    /* renamed from: a */
    public static int m34401a(String str, int i10, String str2) {
        while (i10 < str.length() && str2.indexOf(str.charAt(i10)) == -1) {
            i10++;
        }
        return i10;
    }

    /* renamed from: b */
    public static boolean m34414b(C5971j7 c5971j7) {
        return m34416c(c5971j7).contains("*");
    }

    /* renamed from: c */
    public static boolean m34418c(C6127v7 c6127v7) {
        return m34414b(c6127v7.m35591y());
    }

    /* renamed from: a */
    public static long m34402a(C5971j7 c5971j7) {
        return m34404a(c5971j7.m34521a("Content-Length"));
    }

    /* renamed from: b */
    public static boolean m34415b(C6127v7 c6127v7) {
        if (c6127v7.m35578H().m35420h().equals("HEAD")) {
            return false;
        }
        int iM35589w = c6127v7.m35589w();
        return (((iM35589w >= 100 && iM35589w < 200) || iM35589w == 204 || iM35589w == 304) && m34403a(c6127v7) == -1 && !"chunked".equalsIgnoreCase(c6127v7.m35582b("Transfer-Encoding"))) ? false : true;
    }

    /* renamed from: a */
    public static long m34403a(C6127v7 c6127v7) {
        return m34402a(c6127v7.m35591y());
    }

    /* renamed from: a */
    public static long m34404a(String str) {
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
    public static C5971j7 m34405a(C5971j7 c5971j7, C5971j7 c5971j72) {
        Set<String> setM34416c = m34416c(c5971j72);
        if (setM34416c.isEmpty()) {
            return C5920f8.f26771c;
        }
        C5971j7.a aVar = new C5971j7.a();
        int iM34527d = c5971j7.m34527d();
        for (int i10 = 0; i10 < iM34527d; i10++) {
            String strM34520a = c5971j7.m34520a(i10);
            if (setM34416c.contains(strM34520a)) {
                aVar.m34532a(strM34520a, c5971j7.m34522b(i10));
            }
        }
        return aVar.m34535a();
    }

    /* renamed from: a */
    public static String m34406a(char c10, int i10) {
        char[] cArr = new char[i10];
        Arrays.fill(cArr, c10);
        return new String(cArr);
    }

    /* renamed from: a */
    public static String m34407a(C5868bb c5868bb) throws EOFException {
        if (c5868bb.readByte() != 34) {
            throw new IllegalArgumentException();
        }
        C5868bb c5868bb2 = new C5868bb();
        while (true) {
            long jMo33951c = c5868bb.mo33951c(f27036a);
            if (jMo33951c == -1) {
                return null;
            }
            if (c5868bb.m33972j(jMo33951c) == 34) {
                c5868bb2.write(c5868bb, jMo33951c);
                c5868bb.readByte();
                return c5868bb2.mo33979o();
            }
            if (c5868bb.m33913B() == jMo33951c + 1) {
                return null;
            }
            c5868bb2.write(c5868bb, jMo33951c);
            c5868bb.readByte();
            c5868bb2.write(c5868bb, 1L);
        }
    }

    /* renamed from: a */
    public static List<C6139w6> m34408a(C5971j7 c5971j7, String str) {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < c5971j7.m34527d(); i10++) {
            if (str.equalsIgnoreCase(c5971j7.m34520a(i10))) {
                m34410a(arrayList, new C5868bb().mo33934a(c5971j7.m34522b(i10)));
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static void m34409a(InterfaceC5878c7 interfaceC5878c7, C6010m7 c6010m7, C5971j7 c5971j7) {
        if (interfaceC5878c7 == InterfaceC5878c7.f26566a) {
            return;
        }
        List<C5864b7> listM33866a = C5864b7.m33866a(c6010m7, c5971j7);
        if (listM33866a.isEmpty()) {
            return;
        }
        interfaceC5878c7.mo34040a(c6010m7, listM33866a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x007d, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x007d, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0088  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m34410a(java.util.List<com.huawei.hms.network.embedded.C6139w6> r8, com.huawei.hms.network.embedded.C5868bb r9) {
        /*
            r0 = 0
        L1:
            r1 = r0
        L2:
            if (r1 != 0) goto Le
            m34417c(r9)
            java.lang.String r1 = m34413b(r9)
            if (r1 != 0) goto Le
            return
        Le:
            boolean r2 = m34417c(r9)
            java.lang.String r3 = m34413b(r9)
            if (r3 != 0) goto L2c
            boolean r9 = r9.mo33971i()
            if (r9 != 0) goto L1f
            return
        L1f:
            com.huawei.hms.network.embedded.w6 r9 = new com.huawei.hms.network.embedded.w6
            java.util.Map r0 = java.util.Collections.emptyMap()
            r9.<init>(r1, r0)
            r8.add(r9)
            return
        L2c:
            r4 = 61
            int r5 = m34399a(r9, r4)
            boolean r6 = m34417c(r9)
            if (r2 != 0) goto L60
            if (r6 != 0) goto L40
            boolean r2 = r9.mo33971i()
            if (r2 == 0) goto L60
        L40:
            com.huawei.hms.network.embedded.w6 r2 = new com.huawei.hms.network.embedded.w6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r3)
            java.lang.String r3 = m34406a(r4, r5)
            r6.append(r3)
            java.lang.String r3 = r6.toString()
            java.util.Map r3 = java.util.Collections.singletonMap(r0, r3)
            r2.<init>(r1, r3)
            r8.add(r2)
            goto L1
        L60:
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            r2.<init>()
            int r6 = m34399a(r9, r4)
            int r5 = r5 + r6
        L6a:
            if (r3 != 0) goto L7b
            java.lang.String r3 = m34413b(r9)
            boolean r5 = m34417c(r9)
            if (r5 == 0) goto L77
            goto L7d
        L77:
            int r5 = m34399a(r9, r4)
        L7b:
            if (r5 != 0) goto L88
        L7d:
            com.huawei.hms.network.embedded.w6 r4 = new com.huawei.hms.network.embedded.w6
            r4.<init>(r1, r2)
            r8.add(r4)
            r1 = r3
            goto L2
        L88:
            r6 = 1
            if (r5 <= r6) goto L8c
            return
        L8c:
            boolean r6 = m34417c(r9)
            if (r6 == 0) goto L93
            return
        L93:
            boolean r6 = r9.mo33971i()     // Catch: java.io.EOFException -> La8
            if (r6 != 0) goto Laa
            r6 = 0
            byte r6 = r9.m33972j(r6)     // Catch: java.io.EOFException -> La8
            r7 = 34
            if (r6 != r7) goto Laa
            java.lang.String r6 = m34407a(r9)     // Catch: java.io.EOFException -> La8
            goto Lae
        La8:
            r8 = move-exception
            goto Lc9
        Laa:
            java.lang.String r6 = m34413b(r9)     // Catch: java.io.EOFException -> La8
        Lae:
            if (r6 != 0) goto Lb1
            return
        Lb1:
            java.lang.Object r3 = r2.put(r3, r6)
            java.lang.String r3 = (java.lang.String) r3
            if (r3 == 0) goto Lba
            return
        Lba:
            boolean r3 = m34417c(r9)
            if (r3 != 0) goto Lc7
            boolean r3 = r9.mo33971i()
            if (r3 != 0) goto Lc7
            return
        Lc7:
            r3 = r0
            goto L6a
        Lc9:
            java.lang.AssertionError r9 = new java.lang.AssertionError
            r9.<init>(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.network.embedded.C5960i9.m34410a(java.util.List, com.huawei.hms.network.embedded.bb):void");
    }

    /* renamed from: a */
    public static boolean m34411a(C6127v7 c6127v7, C5971j7 c5971j7, C6101t7 c6101t7) {
        for (String str : m34419d(c6127v7)) {
            if (!Objects.equals(c5971j7.m34528d(str), c6101t7.m35414b(str))) {
                return false;
            }
        }
        return true;
    }
}
