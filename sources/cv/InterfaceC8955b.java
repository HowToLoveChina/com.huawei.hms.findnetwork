package cv;

import android.util.Base64;
import java.nio.charset.StandardCharsets;
import mv.C11529b;
import p374iv.C10622a;

/* renamed from: cv.b */
/* loaded from: classes9.dex */
public interface InterfaceC8955b {

    /* renamed from: a */
    public static final InterfaceC8955b f45458a = new a();

    /* renamed from: b */
    public static final InterfaceC8955b f45459b = new b();

    /* renamed from: c */
    public static final InterfaceC8955b f45460c = new c();

    /* renamed from: d */
    public static final InterfaceC8955b f45461d = new d();

    /* renamed from: cv.b$a */
    public static class a implements InterfaceC8955b {
        @Override // cv.InterfaceC8955b
        /* renamed from: a */
        public String mo56698a(byte[] bArr) throws C10622a {
            return Base64.encodeToString(bArr, 2);
        }
    }

    /* renamed from: cv.b$b */
    public static class b implements InterfaceC8955b {
        @Override // cv.InterfaceC8955b
        /* renamed from: a */
        public String mo56698a(byte[] bArr) throws C10622a {
            return Base64.encodeToString(bArr, 10);
        }
    }

    /* renamed from: cv.b$c */
    public static class c implements InterfaceC8955b {
        @Override // cv.InterfaceC8955b
        /* renamed from: a */
        public String mo56698a(byte[] bArr) throws C10622a {
            if (bArr == null) {
                return null;
            }
            return C11529b.m68817e(bArr, false);
        }
    }

    /* renamed from: cv.b$d */
    public static class d implements InterfaceC8955b {
        @Override // cv.InterfaceC8955b
        /* renamed from: a */
        public String mo56698a(byte[] bArr) throws C10622a {
            return new String(bArr, StandardCharsets.UTF_8);
        }
    }

    /* renamed from: a */
    String mo56698a(byte[] bArr) throws C10622a;
}
