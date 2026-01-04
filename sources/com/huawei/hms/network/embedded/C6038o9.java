package com.huawei.hms.network.embedded;

import java.io.IOException;
import java.net.ProtocolException;

/* renamed from: com.huawei.hms.network.embedded.o9 */
/* loaded from: classes8.dex */
public final class C6038o9 {

    /* renamed from: d */
    public static final int f27625d = 307;

    /* renamed from: e */
    public static final int f27626e = 308;

    /* renamed from: f */
    public static final int f27627f = 100;

    /* renamed from: a */
    public final EnumC6075r7 f27628a;

    /* renamed from: b */
    public final int f27629b;

    /* renamed from: c */
    public final String f27630c;

    public C6038o9(EnumC6075r7 enumC6075r7, int i10, String str) {
        this.f27628a = enumC6075r7;
        this.f27629b = i10;
        this.f27630c = str;
    }

    /* renamed from: a */
    public static C6038o9 m34930a(C6127v7 c6127v7) {
        return new C6038o9(c6127v7.m35576F(), c6127v7.m35589w(), c6127v7.m35572B());
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f27628a == EnumC6075r7.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb2.append(' ');
        sb2.append(this.f27629b);
        if (this.f27630c != null) {
            sb2.append(' ');
            sb2.append(this.f27630c);
        }
        return sb2.toString();
    }

    /* renamed from: a */
    public static C6038o9 m34931a(String str) throws NumberFormatException, IOException {
        EnumC6075r7 enumC6075r7;
        int i10;
        String strSubstring;
        if (str.startsWith("HTTP/1.")) {
            i10 = 9;
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            int iCharAt = str.charAt(7) - '0';
            if (iCharAt == 0) {
                enumC6075r7 = EnumC6075r7.HTTP_1_0;
            } else {
                if (iCharAt != 1) {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                enumC6075r7 = EnumC6075r7.HTTP_1_1;
            }
        } else {
            if (!str.startsWith("ICY ")) {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            enumC6075r7 = EnumC6075r7.HTTP_1_0;
            i10 = 4;
        }
        int i11 = i10 + 3;
        if (str.length() < i11) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        try {
            int i12 = Integer.parseInt(str.substring(i10, i11));
            if (str.length() <= i11) {
                strSubstring = "";
            } else {
                if (str.charAt(i11) != ' ') {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                strSubstring = str.substring(i10 + 4);
            }
            return new C6038o9(enumC6075r7, i12, strSubstring);
        } catch (NumberFormatException unused) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
    }
}
