package gu;

import android.annotation.SuppressLint;
import java.io.UnsupportedEncodingException;
import p237du.AbstractC9309b;

/* renamed from: gu.a */
/* loaded from: classes5.dex */
public class C10047a {

    /* renamed from: a */
    public static final String f49014a = "BaseKeyUtil";

    /* renamed from: a */
    public static int m62459a(int i10, int i11, int i12) {
        if (i11 < i10) {
            i10 = i11;
        }
        return i12 < i10 ? i12 : i10;
    }

    /* renamed from: b */
    public static boolean m62460b(int i10) {
        return i10 >= 16;
    }

    /* renamed from: c */
    public static boolean m62461c(int i10, String str) {
        return str != null && str.length() >= i10;
    }

    /* renamed from: d */
    public static boolean m62462d(int i10, byte[] bArr) {
        return m62464f(i10) & m62463e(bArr);
    }

    /* renamed from: e */
    public static boolean m62463e(byte[] bArr) {
        return bArr.length >= 16;
    }

    /* renamed from: f */
    public static boolean m62464f(int i10) {
        return i10 >= 16;
    }

    /* renamed from: g */
    public static byte[] m62465g(String str, String str2, String str3, String str4, int i10, boolean z10) {
        return m62467i(str, str2, str3, C10049c.m62477b(str4), i10, z10);
    }

    /* renamed from: h */
    public static byte[] m62466h(String str, String str2, String str3, byte[] bArr, int i10, int i11, boolean z10) throws UnsupportedEncodingException {
        if (!m62460b(i11)) {
            C10053g.m62491c(f49014a, "exportLen length must be more than 128bit.");
            return new byte[0];
        }
        if (!m62461c(i11, str)) {
            C10053g.m62491c(f49014a, "material(first) length must be Greater than or equal to export length.");
            return new byte[0];
        }
        if (!m62461c(i11, str2)) {
            C10053g.m62491c(f49014a, "material(second) length must be Greater than or equal to export length.");
            return new byte[0];
        }
        if (!m62461c(i11, str3)) {
            C10053g.m62491c(f49014a, "material(third) length must be Greater than or equal to export length.");
            return new byte[0];
        }
        byte[] bArrM62477b = C10049c.m62477b(str);
        byte[] bArrM62477b2 = C10049c.m62477b(str2);
        byte[] bArrM62477b3 = C10049c.m62477b(str3);
        int iM62459a = m62459a(bArrM62477b.length, bArrM62477b2.length, bArrM62477b3.length);
        if (!m62462d(iM62459a, bArr)) {
            throw new IllegalArgumentException("key length must be more than 128bit.");
        }
        char[] cArr = new char[iM62459a];
        for (int i12 = 0; i12 < iM62459a; i12++) {
            cArr[i12] = (char) ((bArrM62477b[i12] ^ bArrM62477b2[i12]) ^ bArrM62477b3[i12]);
        }
        if (z10) {
            C10053g.m62492d(f49014a, "exportRootKey: sha256");
            return AbstractC9309b.m58616c(cArr, bArr, i10, i11 * 8, true);
        }
        C10053g.m62492d(f49014a, "exportRootKey: sha1");
        return AbstractC9309b.m58616c(cArr, bArr, i10, i11 * 8, false);
    }

    @SuppressLint({"NewApi"})
    /* renamed from: i */
    public static byte[] m62467i(String str, String str2, String str3, byte[] bArr, int i10, boolean z10) {
        return m62466h(str, str2, str3, bArr, 10000, i10, z10);
    }

    @SuppressLint({"NewApi"})
    /* renamed from: j */
    public static byte[] m62468j(String str, String str2, String str3, byte[] bArr, boolean z10) {
        return m62467i(str, str2, str3, bArr, 16, z10);
    }
}
