package com.huawei.hms.drive;

import java.io.IOException;
import java.net.ProtocolException;

/* renamed from: com.huawei.hms.drive.ct */
/* loaded from: classes8.dex */
public final class C5243ct {

    /* renamed from: a */
    public final EnumC5199bd f24228a;

    /* renamed from: b */
    public final int f24229b;

    /* renamed from: c */
    public final String f24230c;

    public C5243ct(EnumC5199bd enumC5199bd, int i10, String str) {
        this.f24228a = enumC5199bd;
        this.f24229b = i10;
        this.f24230c = str;
    }

    /* renamed from: a */
    public static C5243ct m31432a(String str) throws NumberFormatException, IOException {
        EnumC5199bd enumC5199bd;
        int i10;
        String strSubstring;
        if (str.startsWith("HTTP/1.")) {
            i10 = 9;
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            int iCharAt = str.charAt(7) - '0';
            if (iCharAt == 0) {
                enumC5199bd = EnumC5199bd.HTTP_1_0;
            } else {
                if (iCharAt != 1) {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                enumC5199bd = EnumC5199bd.HTTP_1_1;
            }
        } else {
            if (!str.startsWith("ICY ")) {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            enumC5199bd = EnumC5199bd.HTTP_1_0;
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
            return new C5243ct(enumC5199bd, i12, strSubstring);
        } catch (NumberFormatException unused) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f24228a == EnumC5199bd.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb2.append(' ');
        sb2.append(this.f24229b);
        if (this.f24230c != null) {
            sb2.append(' ');
            sb2.append(this.f24230c);
        }
        return sb2.toString();
    }
}
