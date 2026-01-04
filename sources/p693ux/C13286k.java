package p693ux;

import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.EnumC11914c0;

/* renamed from: ux.k */
/* loaded from: classes9.dex */
public final class C13286k {

    /* renamed from: a */
    public final EnumC11914c0 f60002a;

    /* renamed from: b */
    public final int f60003b;

    /* renamed from: c */
    public final String f60004c;

    public C13286k(EnumC11914c0 enumC11914c0, int i10, String str) {
        this.f60002a = enumC11914c0;
        this.f60003b = i10;
        this.f60004c = str;
    }

    /* renamed from: a */
    public static C13286k m79735a(String str) throws NumberFormatException, IOException {
        EnumC11914c0 enumC11914c0;
        int i10;
        String strSubstring;
        if (str.startsWith("HTTP/1.")) {
            i10 = 9;
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            int iCharAt = str.charAt(7) - '0';
            if (iCharAt == 0) {
                enumC11914c0 = EnumC11914c0.HTTP_1_0;
            } else {
                if (iCharAt != 1) {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                enumC11914c0 = EnumC11914c0.HTTP_1_1;
            }
        } else {
            if (!str.startsWith("ICY ")) {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            enumC11914c0 = EnumC11914c0.HTTP_1_0;
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
            return new C13286k(enumC11914c0, i12, strSubstring);
        } catch (NumberFormatException unused) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f60002a == EnumC11914c0.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb2.append(' ');
        sb2.append(this.f60003b);
        if (this.f60004c != null) {
            sb2.append(' ');
            sb2.append(this.f60004c);
        }
        return sb2.toString();
    }
}
