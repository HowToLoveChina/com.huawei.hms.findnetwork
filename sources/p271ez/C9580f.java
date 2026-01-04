package p271ez;

import java.security.AccessController;
import java.security.PrivilegedAction;

/* renamed from: ez.f */
/* loaded from: classes9.dex */
public final class C9580f {

    /* renamed from: a */
    public static String f47676a;

    /* renamed from: ez.f$a */
    public static class a implements PrivilegedAction<String> {
        @Override // java.security.PrivilegedAction
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String run() {
            return System.getProperty("line.separator");
        }
    }

    static {
        try {
            try {
                f47676a = (String) AccessController.doPrivileged(new a());
            } catch (Exception unused) {
                f47676a = "\n";
            }
        } catch (Exception unused2) {
            f47676a = String.format("%n", new Object[0]);
        }
    }

    /* renamed from: a */
    public static char[] m59777a(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length];
        for (int i10 = 0; i10 != length; i10++) {
            cArr[i10] = (char) (bArr[i10] & 255);
        }
        return cArr;
    }

    /* renamed from: b */
    public static String m59778b(byte[] bArr) {
        return new String(m59777a(bArr));
    }
}
