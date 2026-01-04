package p409jx;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import mx.C11549i;
import mx.C11556p;
import p376ix.C10631a;
import p594qx.C12425d;
import p594qx.C12427f;

/* renamed from: jx.d */
/* loaded from: classes9.dex */
public class C10955d {
    /* renamed from: a */
    public static String m66103a(byte[] bArr, boolean z10, Charset charset) {
        if (charset != null) {
            return new String(bArr, charset);
        }
        if (z10) {
            return new String(bArr, C12425d.f57265b);
        }
        try {
            return new String(bArr, "Cp437");
        } catch (UnsupportedEncodingException unused) {
            return new String(bArr);
        }
    }

    /* renamed from: b */
    public static byte[] m66104b(String str, Charset charset) {
        return charset == null ? str.getBytes(C12425d.f57266c) : str.getBytes(charset);
    }

    /* renamed from: c */
    public static C11549i m66105c(C11556p c11556p, String str) throws C10631a {
        C11549i c11549iM66106d = m66106d(c11556p, str);
        if (c11549iM66106d != null) {
            return c11549iM66106d;
        }
        String strReplaceAll = str.replaceAll("\\\\", "/");
        C11549i c11549iM66106d2 = m66106d(c11556p, strReplaceAll);
        return c11549iM66106d2 == null ? m66106d(c11556p, strReplaceAll.replaceAll("/", "\\\\")) : c11549iM66106d2;
    }

    /* renamed from: d */
    public static C11549i m66106d(C11556p c11556p, String str) throws C10631a {
        if (c11556p == null) {
            throw new C10631a("zip model is null, cannot determine file header with exact match for fileName: " + str);
        }
        if (!C12427f.m74616f(str)) {
            throw new C10631a("file name is null, cannot determine file header with exact match for fileName: " + str);
        }
        if (c11556p.m68967c() == null) {
            throw new C10631a("central directory is null, cannot determine file header with exact match for fileName: " + str);
        }
        if (c11556p.m68967c().m68888a() == null) {
            throw new C10631a("file Headers are null, cannot determine file header with exact match for fileName: " + str);
        }
        if (c11556p.m68967c().m68888a().size() == 0) {
            return null;
        }
        for (C11549i c11549i : c11556p.m68967c().m68888a()) {
            String strM68871j = c11549i.m68871j();
            if (C12427f.m74616f(strM68871j) && str.equals(strM68871j)) {
                return c11549i;
            }
        }
        return null;
    }

    /* renamed from: e */
    public static long m66107e(C11556p c11556p) {
        return c11556p.m68975m() ? c11556p.m68972j().m68940e() : c11556p.m68968d().m68897g();
    }
}
